package controllers.partner;

import com.fasterxml.jackson.databind.JsonNode;
import com.google.inject.Inject;
import com.wordnik.swagger.annotations.*;
import configs.Constants;
import controllers.BaseController;
import controllers.admin.BaseMerchantApiAction;
import dto.Authentication;
import dto.BaseAPIResponse;
import dto.partner.*;
import model.Card;
import model.Currency;
import model.Customer;
import model.enums.KYC;
import org.apache.commons.lang3.StringUtils;
import play.Logger;
import play.libs.F;
import play.libs.Json;
import play.mvc.Result;
import play.mvc.With;
import provider.GlobalProcessingCardProvider;
import provider.dto.CardCreationResponse;
import repository.CardRepository;
import repository.CurrencyRepository;
import util.DateUtil;
import util.SecurityUtil;

import java.util.Date;
import java.util.Optional;

import static configs.ReturnCodes.*;

/**
 * Partner card provider API controller
 *
 * @author corbandalas created 11.09.2017.
 * @since 0.6.0
 */
@Api(value = Constants.PARTNER_API_PATH + "/card", description = "Card processing functions")
public class CardPartnerController extends BaseController {

    @Inject
    private GlobalProcessingCardProvider globalProcessingCardProvider;

    @Inject
    CurrencyRepository currencyRepository;

    @Inject
    CardRepository cardRepository;

    @With(BaseMerchantApiAction.class)
    @ApiOperation(
            nickname = "createCard",
            value = "Create card",
            notes = "Method allows to create payment card",
            produces = "application/json",
            consumes = "application/json",
            httpMethod = "POST",
            response = CreateCardResponse.class
    )

    @ApiResponses(value = {
            @ApiResponse(code = SUCCESS_CODE, message = SUCCESS_TEXT, response = CreateCardResponse.class),
            @ApiResponse(code = INCORRECT_AUTHORIZATION_DATA_CODE, message = INCORRECT_AUTHORIZATION_DATA_TEXT, response = BaseAPIResponse.class),
            @ApiResponse(code = INACTIVE_ACCOUNT_CODE, message = INACTIVE_ACCOUNT_TEXT, response = BaseAPIResponse.class),
            @ApiResponse(code = WRONG_REQUEST_FORMAT_CODE, message = WRONG_REQUEST_FORMAT_TEXT, response = BaseAPIResponse.class),
            @ApiResponse(code = WRONG_REQUEST_ENCKEY_CODE, message = WRONG_REQUEST_ENCKEY_TEXT, response = BaseAPIResponse.class),
            @ApiResponse(code = GENERAL_ERROR_CODE, message = GENERAL_ERROR_TEXT, response = BaseAPIResponse.class),
    })
    @ApiImplicitParams(value = {
            @ApiImplicitParam(value = "Create card request", required = true, dataType = "dto.partner.CreateCardRequest", paramType = "body"),
            @ApiImplicitParam(value = "Account id header", required = true, dataType = "String", paramType = "header", name = "accountId"),
            @ApiImplicitParam(value = "Enckey header. SHA256(accountId+orderId+phone+firstName+lastName+amount+currency+email+secret)",
                    required = true, dataType = "String", paramType = "header", name = "enckey"),
            @ApiImplicitParam(value = "orderId header", required = true, dataType = "String", paramType = "header", name = "orderId")})
    public F.Promise<Result> create() {

        final Authentication authData = (Authentication) ctx().args.get("authData");

        final JsonNode jsonNode = request().body().asJson();
        final CreateCardRequest createCard;
        try {
            createCard = Json.fromJson(jsonNode, CreateCardRequest.class);
        } catch (Exception ex) {
            Logger.error("Wrong request format: ", ex);
            return F.Promise.pure(createWrongRequestFormatResponse());
        }

        if (StringUtils.isBlank(createCard.getPhone()) ||
                StringUtils.isBlank(createCard.getFirstName()) ||
                StringUtils.isBlank(createCard.getLastName()) ||
                StringUtils.isBlank(createCard.getAddress1()) ||
                StringUtils.isBlank(createCard.getAddress2()) ||
                StringUtils.isBlank(createCard.getCity()) ||
                StringUtils.isBlank(createCard.getCountry()) ||
                StringUtils.isBlank(createCard.getTitle()) ||
                StringUtils.isBlank(createCard.getPostcode()) ||
                StringUtils.isBlank(createCard.getDob()) ||
                StringUtils.isBlank(createCard.getKyc()) ||
                StringUtils.isBlank(createCard.getCurrency()) ||
                StringUtils.isBlank(createCard.getEmail()) ||
                StringUtils.isBlank(createCard.getCardName()) ||
                StringUtils.isBlank(createCard.getPlastic()) ||
                StringUtils.isBlank(createCard.getActivateNow()) ||
                StringUtils.isBlank(createCard.getAmount())
                ) {
            Logger.error("Missing params");
            return F.Promise.pure(createWrongRequestFormatResponse());
        }


        if (!authData.getEnckey().equalsIgnoreCase(SecurityUtil.generateKeyFromArray(authData.getAccount().getId().toString(), authData.getOrderId(),
                createCard.getPhone(), createCard.getFirstName(), createCard.getLastName(), createCard.getAmount(), createCard.getCurrency(), createCard.getEmail(), authData.getAccount().getSecret()))) {
            Logger.error("Provided and calculated enckeys do not match");
            return F.Promise.pure(createWrongEncKeyResponse());
        }


        Customer customer = new Customer();

        customer.setFirstName(createCard.getFirstName());
        customer.setLastName(createCard.getLastName());
        customer.setAddress1(createCard.getAddress1());
        customer.setAddress2(createCard.getAddress2());
        customer.setId(createCard.getPhone());
        customer.setCity(createCard.getCity());
        customer.setEmail(createCard.getEmail());
        customer.setCountry_id(createCard.getCountry());
        customer.setPostcode(createCard.getPostcode());
        customer.setTitle(createCard.getTitle());


        long amount = 0;

        boolean plastic = false;
        boolean activateNow = false;

        try {
            KYC kyc = KYC.valueOf(createCard.getKyc().toUpperCase());

            customer.setKyc(kyc);

            Date dob = DateUtil.parse(createCard.getDob(), "yyyy-MM-dd");

            customer.setDateBirth(dob);

            amount = Long.parseLong(createCard.getAmount());

            plastic = Boolean.parseBoolean(createCard.getPlastic());

            activateNow = Boolean.parseBoolean(createCard.getActivateNow());

        } catch (Exception ex) {
            Logger.error("Wrong request format: ", ex);
            return F.Promise.pure(createWrongRequestFormatResponse());
        }


        final F.Promise<Optional<Currency>> currencyPromise = F.Promise.wrap(currencyRepository.retrieveById(createCard.getCurrency()));

        final long finalAmount = amount;
        final boolean finalPlastic = plastic;

        final boolean finalActivateNow = activateNow;
        F.Promise<Result> result = currencyPromise.flatMap(currency -> {

            F.Promise<CardCreationResponse> cardCreationResponsePromise;

            if (!finalPlastic) {
                if (finalAmount > 0) {
                    cardCreationResponsePromise = globalProcessingCardProvider.issuePrepaidVirtualCardForPartner(authData.getAccount().getId().toString(), customer, createCard.getCardName(), finalAmount, currency.get(), finalActivateNow, createCard.getCardDesign(), createCard.getDeliveryAddress1(), createCard.getDeliveryCity(), createCard.getDeliveryPostCode(), createCard.getDeliveryCountry(), createCard.getDeliveryMethod());
                } else {
                    cardCreationResponsePromise = globalProcessingCardProvider.issueEmptyVirtualCardForPartner(authData.getAccount().getId().toString(), customer, createCard.getCardName(), currency.get(), finalActivateNow, createCard.getCardDesign(), createCard.getDeliveryAddress1(), createCard.getDeliveryCity(), createCard.getDeliveryPostCode(), createCard.getDeliveryCountry(), createCard.getDeliveryMethod());
                }
            } else {
                if (finalAmount > 0) {
                    cardCreationResponsePromise = globalProcessingCardProvider.issuePrepaidPlasticCardForPartner(authData.getAccount().getId().toString(), customer, createCard.getCardName(), finalAmount, currency.get(), finalActivateNow, createCard.getCardDesign(), createCard.getDeliveryAddress1(), createCard.getDeliveryCity(), createCard.getDeliveryPostCode(), createCard.getDeliveryCountry(), createCard.getDeliveryMethod());
                } else {
                    cardCreationResponsePromise = globalProcessingCardProvider.issueEmptyPlasticCardForPartner(authData.getAccount().getId().toString(), customer, createCard.getCardName(), currency.get(), finalActivateNow, createCard.getCardDesign(), createCard.getDeliveryAddress1(), createCard.getDeliveryCity(), createCard.getDeliveryPostCode(), createCard.getDeliveryCountry(), createCard.getDeliveryMethod());
                }
            }


            return cardCreationResponsePromise.map(res -> ok(Json.toJson(new CreateCardResponse(SUCCESS_TEXT, String.valueOf(SUCCESS_CODE), res))));

        });


        return returnRecover(result);
    }


    @With(BaseMerchantApiAction.class)
    @ApiOperation(
            nickname = "loadCard",
            value = "Load card",
            notes = "Method allows to load payment card",
            produces = "application/json",
            consumes = "application/json",
            httpMethod = "POST",
            response = LoadCardResponse.class
    )

    @ApiResponses(value = {
            @ApiResponse(code = SUCCESS_CODE, message = SUCCESS_TEXT, response = LoadCardResponse.class),
            @ApiResponse(code = INCORRECT_AUTHORIZATION_DATA_CODE, message = INCORRECT_AUTHORIZATION_DATA_TEXT, response = BaseAPIResponse.class),
            @ApiResponse(code = INACTIVE_ACCOUNT_CODE, message = INACTIVE_ACCOUNT_TEXT, response = BaseAPIResponse.class),
            @ApiResponse(code = WRONG_REQUEST_FORMAT_CODE, message = WRONG_REQUEST_FORMAT_TEXT, response = BaseAPIResponse.class),
            @ApiResponse(code = WRONG_REQUEST_ENCKEY_CODE, message = WRONG_REQUEST_ENCKEY_TEXT, response = BaseAPIResponse.class),
            @ApiResponse(code = GENERAL_ERROR_CODE, message = GENERAL_ERROR_TEXT, response = LoadCardResponse.class),
    })
    @ApiImplicitParams(value = {
            @ApiImplicitParam(value = "Load card request", required = true, dataType = "dto.partner.LoadCardRequest", paramType = "body"),
            @ApiImplicitParam(value = "Account id header", required = true, dataType = "String", paramType = "header", name = "accountId"),
            @ApiImplicitParam(value = "Enckey header. SHA256(accountId+orderId+token+amount+currency+source+secret)",
                    required = true, dataType = "String", paramType = "header", name = "enckey"),
            @ApiImplicitParam(value = "orderId header", required = true, dataType = "String", paramType = "header", name = "orderId")})
    public F.Promise<Result> load() {

        final Authentication authData = (Authentication) ctx().args.get("authData");

        final JsonNode jsonNode = request().body().asJson();
        final LoadCardRequest loadCard;
        try {
            loadCard = Json.fromJson(jsonNode, LoadCardRequest.class);
        } catch (Exception ex) {
            Logger.error("Wrong request format: ", ex);
            return F.Promise.pure(createWrongRequestFormatResponse());
        }

        if (StringUtils.isBlank(loadCard.getAmount()) ||
                StringUtils.isBlank(loadCard.getCurrency()) ||
                StringUtils.isBlank(loadCard.getToken()) ||
                StringUtils.isBlank(loadCard.getDescription()) ||
                StringUtils.isBlank(loadCard.getSource())
                ) {
            Logger.error("Missing params");
            return F.Promise.pure(createWrongRequestFormatResponse());
        }

        if (!authData.getEnckey().equalsIgnoreCase(SecurityUtil.generateKeyFromArray(authData.getAccount().getId().toString(), authData.getOrderId(), loadCard.getToken(),
                loadCard.getAmount(), loadCard.getCurrency(), loadCard.getSource(), authData.getAccount().getSecret()))) {
            Logger.error("Provided and calculated enckeys do not match");
            return F.Promise.pure(createWrongEncKeyResponse());
        }


        long amount;

        try {
            amount = Long.parseLong(loadCard.getAmount());

            if (amount <= 0) {
                Logger.error("Negative amount error: ");
                throw new Exception();
            }

        } catch (Exception ex) {
            Logger.error("Wrong request format: ", ex);
            return F.Promise.pure(createWrongRequestFormatResponse());
        }


        final F.Promise<Optional<Currency>> currencyPromise = F.Promise.wrap(currencyRepository.retrieveById(loadCard.getCurrency()));

        final long finalAmount = amount;

        F.Promise<Result> result = currencyPromise.flatMap(currency -> globalProcessingCardProvider.loadVirtualCardForPartner(loadCard.getToken(), finalAmount, currency.get(), loadCard.getDescription(), loadCard.getSource(), authData.getAccount().getId().toString()).map(res -> ok(Json.toJson(new LoadCardResponse(SUCCESS_TEXT, String.valueOf(SUCCESS_CODE), res.getLoadCard())))));

        return returnRecover(result);
    }

    @With(BaseMerchantApiAction.class)
    @ApiOperation(
            nickname = "unloadCard",
            value = "Unload card",
            notes = "Method allows to unload payment card",
            produces = "application/json",
            consumes = "application/json",
            httpMethod = "POST",
            response = UnloadCardResponse.class
    )

    @ApiResponses(value = {
            @ApiResponse(code = SUCCESS_CODE, message = SUCCESS_TEXT, response = UnloadCardResponse.class),
            @ApiResponse(code = INCORRECT_AUTHORIZATION_DATA_CODE, message = INCORRECT_AUTHORIZATION_DATA_TEXT, response = BaseAPIResponse.class),
            @ApiResponse(code = INACTIVE_ACCOUNT_CODE, message = INACTIVE_ACCOUNT_TEXT, response = BaseAPIResponse.class),
            @ApiResponse(code = WRONG_REQUEST_FORMAT_CODE, message = WRONG_REQUEST_FORMAT_TEXT, response = BaseAPIResponse.class),
            @ApiResponse(code = WRONG_REQUEST_ENCKEY_CODE, message = WRONG_REQUEST_ENCKEY_TEXT, response = BaseAPIResponse.class),
            @ApiResponse(code = GENERAL_ERROR_CODE, message = GENERAL_ERROR_TEXT, response = BaseAPIResponse.class),
    })
    @ApiImplicitParams(value = {
            @ApiImplicitParam(value = "Unload card request", required = true, dataType = "dto.partner.UnloadCardRequest", paramType = "body"),
            @ApiImplicitParam(value = "Account id header", required = true, dataType = "String", paramType = "header", name = "accountId"),
            @ApiImplicitParam(value = "Enckey header. SHA256(accountId+orderId+token+amount+currency+secret)",
                    required = true, dataType = "String", paramType = "header", name = "enckey"),
            @ApiImplicitParam(value = "orderId header", required = true, dataType = "String", paramType = "header", name = "orderId")})
    public F.Promise<Result> unload() {

        final Authentication authData = (Authentication) ctx().args.get("authData");

        final JsonNode jsonNode = request().body().asJson();
        final UnloadCardRequest unloadCard;
        try {
            unloadCard = Json.fromJson(jsonNode, UnloadCardRequest.class);
        } catch (Exception ex) {
            Logger.error("Wrong request format: ", ex);
            return F.Promise.pure(createWrongRequestFormatResponse());
        }

        if (StringUtils.isBlank(unloadCard.getAmount()) ||
                StringUtils.isBlank(unloadCard.getCurrency()) ||
                StringUtils.isBlank(unloadCard.getToken()) ||
                StringUtils.isBlank(unloadCard.getDescription()) ||
                StringUtils.isBlank(unloadCard.getLoadType())
                ) {
            Logger.error("Missing params");
            return F.Promise.pure(createWrongRequestFormatResponse());
        }


        if (!authData.getEnckey().equalsIgnoreCase(SecurityUtil.generateKeyFromArray(authData.getAccount().getId().toString(), authData.getOrderId(), unloadCard.getToken(),
                unloadCard.getAmount(), unloadCard.getCurrency(), authData.getAccount().getSecret()))) {
            Logger.error("Provided and calculated enckeys do not match");
            return F.Promise.pure(createWrongEncKeyResponse());
        }


        long amount;

        try {
            amount = Long.parseLong(unloadCard.getAmount());

            if (amount <= 0) {
                Logger.error("Negative amount error: ");
                throw new Exception();
            }

        } catch (Exception ex) {
            Logger.error("Wrong request format: ", ex);
            return F.Promise.pure(createWrongRequestFormatResponse());
        }


        final F.Promise<Optional<Currency>> currencyPromise = F.Promise.wrap(currencyRepository.retrieveById(unloadCard.getCurrency()));

        final long finalAmount = amount;

        F.Promise<Result> result = currencyPromise.flatMap(currency -> globalProcessingCardProvider.unloadVirtualCardForPartner(unloadCard.getToken(), finalAmount, currency.get(), unloadCard.getDescription(), unloadCard.getLoadType(), authData.getAccount().getId().toString()).map(res -> ok(Json.toJson(new UnloadCardResponse(SUCCESS_TEXT, String.valueOf(SUCCESS_CODE), res)))));

        return returnRecover(result);
    }

    @With(BaseMerchantApiAction.class)
    @ApiOperation(
            nickname = "balanceCard",
            value = "Card balance",
            notes = "Method allows to obtain balance of a card",
            produces = "application/json",
            consumes = "application/json",
            httpMethod = "POST",
            response = BalanceResponse.class
    )

    @ApiResponses(value = {
            @ApiResponse(code = SUCCESS_CODE, message = SUCCESS_TEXT, response = BalanceResponse.class),
            @ApiResponse(code = INCORRECT_AUTHORIZATION_DATA_CODE, message = INCORRECT_AUTHORIZATION_DATA_TEXT, response = BaseAPIResponse.class),
            @ApiResponse(code = INACTIVE_ACCOUNT_CODE, message = INACTIVE_ACCOUNT_TEXT, response = BaseAPIResponse.class),
            @ApiResponse(code = WRONG_REQUEST_FORMAT_CODE, message = WRONG_REQUEST_FORMAT_TEXT, response = BaseAPIResponse.class),
            @ApiResponse(code = WRONG_REQUEST_ENCKEY_CODE, message = WRONG_REQUEST_ENCKEY_TEXT, response = BaseAPIResponse.class),
            @ApiResponse(code = GENERAL_ERROR_CODE, message = GENERAL_ERROR_TEXT, response = BaseAPIResponse.class),
    })
    @ApiImplicitParams(value = {
            @ApiImplicitParam(value = "Сard balance request", required = true, dataType = "dto.partner.BalanceRequest", paramType = "body"),
            @ApiImplicitParam(value = "Account id header", required = true, dataType = "String", paramType = "header", name = "accountId"),
            @ApiImplicitParam(value = "Enckey header. SHA256(accountId+orderId+token+secret)",
                    required = true, dataType = "String", paramType = "header", name = "enckey"),
            @ApiImplicitParam(value = "orderId header", required = true, dataType = "String", paramType = "header", name = "orderId")})
    public F.Promise<Result> balance() {

        final Authentication authData = (Authentication) ctx().args.get("authData");

        final JsonNode jsonNode = request().body().asJson();
        final BalanceRequest balance;
        try {
            balance = Json.fromJson(jsonNode, BalanceRequest.class);
        } catch (Exception ex) {
            Logger.error("Wrong request format: ", ex);
            return F.Promise.pure(createWrongRequestFormatResponse());
        }

        if (StringUtils.isBlank(balance.getToken())) {
            Logger.error("Missing params");
            return F.Promise.pure(createWrongRequestFormatResponse());
        }


        if (!authData.getEnckey().equalsIgnoreCase(SecurityUtil.generateKeyFromArray(authData.getAccount().getId().toString(), authData.getOrderId(), balance.getToken(), authData.getAccount().getSecret()))) {
            Logger.error("Provided and calculated enckeys do not match");
            return F.Promise.pure(createWrongEncKeyResponse());
        }

        F.Promise<Result> result = globalProcessingCardProvider.getVirtualCardBalanceForPartner(balance.getToken(), authData.getAccount().getId().toString()).map(res -> ok(Json.toJson(new BalanceResponse(SUCCESS_TEXT, String.valueOf(SUCCESS_CODE), res))));

        return returnRecover(result);
    }

    @With(BaseMerchantApiAction.class)
    @ApiOperation(
            nickname = "transactionsCard",
            value = "Card transactions",
            notes = "Method allows to retrieve card transactions",
            produces = "application/json",
            consumes = "application/json",
            httpMethod = "POST",
            response = MiniStatementResponse.class
    )

    @ApiResponses(value = {
            @ApiResponse(code = SUCCESS_CODE, message = SUCCESS_TEXT, response = MiniStatementResponse.class),
            @ApiResponse(code = INCORRECT_AUTHORIZATION_DATA_CODE, message = INCORRECT_AUTHORIZATION_DATA_TEXT, response = BaseAPIResponse.class),
            @ApiResponse(code = INACTIVE_ACCOUNT_CODE, message = INACTIVE_ACCOUNT_TEXT, response = BaseAPIResponse.class),
            @ApiResponse(code = WRONG_REQUEST_FORMAT_CODE, message = WRONG_REQUEST_FORMAT_TEXT, response = BaseAPIResponse.class),
            @ApiResponse(code = WRONG_REQUEST_ENCKEY_CODE, message = WRONG_REQUEST_ENCKEY_TEXT, response = BaseAPIResponse.class),
            @ApiResponse(code = GENERAL_ERROR_CODE, message = GENERAL_ERROR_TEXT, response = BaseAPIResponse.class),
    })
    @ApiImplicitParams(value = {
            @ApiImplicitParam(value = "Mini statement request", required = true, dataType = "dto.partner.MiniStatementRequest", paramType = "body"),
            @ApiImplicitParam(value = "Account id header", required = true, dataType = "String", paramType = "header", name = "accountId"),
            @ApiImplicitParam(value = "Enckey header. SHA256(accountId+orderId+token+secret)",
                    required = true, dataType = "String", paramType = "header", name = "enckey"),
            @ApiImplicitParam(value = "orderId header", required = true, dataType = "String", paramType = "header", name = "orderId")})
    public F.Promise<Result> transactions() {

        final Authentication authData = (Authentication) ctx().args.get("authData");

        final JsonNode jsonNode = request().body().asJson();
        final MiniStatementRequest miniStatementRequest;
        try {
            miniStatementRequest = Json.fromJson(jsonNode, MiniStatementRequest.class);
        } catch (Exception ex) {
            Logger.error("Wrong request format: ", ex);
            return F.Promise.pure(createWrongRequestFormatResponse());
        }

        if (StringUtils.isBlank(miniStatementRequest.getToken()) || StringUtils.isBlank(miniStatementRequest.getStartDate()) ||
                StringUtils.isBlank(miniStatementRequest.getEndDate())) {
            Logger.error("Missing params");
            return F.Promise.pure(createWrongRequestFormatResponse());
        }


        if (!authData.getEnckey().equalsIgnoreCase(SecurityUtil.generateKeyFromArray(authData.getAccount().getId().toString(), authData.getOrderId(), miniStatementRequest.getToken(), authData.getAccount().getSecret()))) {
            Logger.error("Provided and calculated enckeys do not match");
            return F.Promise.pure(createWrongEncKeyResponse());
        }

        Date startDate;

        Date endDate;

        try {

            startDate = DateUtil.parse(miniStatementRequest.getStartDate(), "yyyy-MM-dd");

            endDate = DateUtil.parse(miniStatementRequest.getEndDate(), "yyyy-MM-dd");

        } catch (Exception ex) {
            Logger.error("Wrong request format: ", ex);
            return F.Promise.pure(createWrongRequestFormatResponse());
        }

        F.Promise<Result> result = globalProcessingCardProvider.getCardTransactions(miniStatementRequest.getToken(), startDate, endDate, authData.getAccount().getId().toString()).map(res -> ok(Json.toJson(new MiniStatementResponse(SUCCESS_TEXT, String.valueOf(SUCCESS_CODE), res))));

        return returnRecover(result);
    }

    @With(BaseMerchantApiAction.class)
    @ApiOperation(
            nickname = "cardPinControl",
            value = "Obtain Card PIN",
            notes = "Method allows to retrieve PIN of a card",
            produces = "application/json",
            consumes = "application/json",
            httpMethod = "POST",
            response = ObtainPINResponse.class
    )

    @ApiResponses(value = {
            @ApiResponse(code = SUCCESS_CODE, message = SUCCESS_TEXT, response = ObtainPINResponse.class),
            @ApiResponse(code = INCORRECT_AUTHORIZATION_DATA_CODE, message = INCORRECT_AUTHORIZATION_DATA_TEXT, response = BaseAPIResponse.class),
            @ApiResponse(code = INACTIVE_ACCOUNT_CODE, message = INACTIVE_ACCOUNT_TEXT, response = BaseAPIResponse.class),
            @ApiResponse(code = WRONG_REQUEST_FORMAT_CODE, message = WRONG_REQUEST_FORMAT_TEXT, response = BaseAPIResponse.class),
            @ApiResponse(code = WRONG_REQUEST_ENCKEY_CODE, message = WRONG_REQUEST_ENCKEY_TEXT, response = BaseAPIResponse.class),
            @ApiResponse(code = GENERAL_ERROR_CODE, message = GENERAL_ERROR_TEXT, response = BaseAPIResponse.class),
    })
    @ApiImplicitParams(value = {
            @ApiImplicitParam(value = "PIN obtain request", required = true, dataType = "dto.partner.ObtainPINRequest", paramType = "body"),
            @ApiImplicitParam(value = "Account id header", required = true, dataType = "String", paramType = "header", name = "accountId"),
            @ApiImplicitParam(value = "Enckey header. SHA256(accountId+orderId+token+secret)",
                    required = true, dataType = "String", paramType = "header", name = "enckey"),
            @ApiImplicitParam(value = "orderId header", required = true, dataType = "String", paramType = "header", name = "orderId")})
    public F.Promise<Result> obtainPIN() {

        final Authentication authData = (Authentication) ctx().args.get("authData");

        final JsonNode jsonNode = request().body().asJson();
        final ObtainPINRequest obtainPINRequest;
        try {
            obtainPINRequest = Json.fromJson(jsonNode, ObtainPINRequest.class);
        } catch (Exception ex) {
            Logger.error("Wrong request format: ", ex);
            return F.Promise.pure(createWrongRequestFormatResponse());
        }

        if (StringUtils.isBlank(obtainPINRequest.getToken())) {
            Logger.error("Missing params");
            return F.Promise.pure(createWrongRequestFormatResponse());
        }


        if (!authData.getEnckey().equalsIgnoreCase(SecurityUtil.generateKeyFromArray(authData.getAccount().getId().toString(), authData.getOrderId(), obtainPINRequest.getToken(), authData.getAccount().getSecret()))) {
            Logger.error("Provided and calculated enckeys do not match");
            return F.Promise.pure(createWrongEncKeyResponse());
        }

        String needSMS = (StringUtils.isBlank(obtainPINRequest.getSms()))? "1": obtainPINRequest.getSms();

        F.Promise<Result> result = globalProcessingCardProvider.obtainPINForPartner(obtainPINRequest.getToken(), authData.getAccount().getId().toString(), obtainPINRequest.getFunc(), obtainPINRequest.getFeeWaiver(), needSMS).map(res -> ok(Json.toJson(new ObtainPINResponse(SUCCESS_TEXT, String.valueOf(SUCCESS_CODE), res))));

        return returnRecover(result);
    }

    @With(BaseMerchantApiAction.class)
    @ApiOperation(
            nickname = "cardChangeStatus",
            value = "Change card status",
            notes = "Method allows to change card status",
            produces = "application/json",
            consumes = "application/json",
            httpMethod = "POST",
            response = ChangeStatusResponse.class
    )

    @ApiResponses(value = {
            @ApiResponse(code = SUCCESS_CODE, message = SUCCESS_TEXT, response = ChangeStatusResponse.class),
            @ApiResponse(code = INCORRECT_AUTHORIZATION_DATA_CODE, message = INCORRECT_AUTHORIZATION_DATA_TEXT, response = BaseAPIResponse.class),
            @ApiResponse(code = INACTIVE_ACCOUNT_CODE, message = INACTIVE_ACCOUNT_TEXT, response = BaseAPIResponse.class),
            @ApiResponse(code = WRONG_REQUEST_FORMAT_CODE, message = WRONG_REQUEST_FORMAT_TEXT, response = BaseAPIResponse.class),
            @ApiResponse(code = WRONG_REQUEST_ENCKEY_CODE, message = WRONG_REQUEST_ENCKEY_TEXT, response = BaseAPIResponse.class),
            @ApiResponse(code = GENERAL_ERROR_CODE, message = GENERAL_ERROR_TEXT, response = BaseAPIResponse.class),
    })
    @ApiImplicitParams(value = {
            @ApiImplicitParam(value = "Change card status request", required = true, dataType = "dto.partner.ChangeStatusRequest", paramType = "body"),
            @ApiImplicitParam(value = "Account id header", required = true, dataType = "String", paramType = "header", name = "accountId"),
            @ApiImplicitParam(value = "Enckey header. SHA256(accountId+orderId+token+status+reason+secret)",
                    required = true, dataType = "String", paramType = "header", name = "enckey"),
            @ApiImplicitParam(value = "orderId header", required = true, dataType = "String", paramType = "header", name = "orderId")})
    public F.Promise<Result> changeStatus() {

        final Authentication authData = (Authentication) ctx().args.get("authData");

        final JsonNode jsonNode = request().body().asJson();
        final ChangeStatusRequest changeStatusRequest;
        try {
            changeStatusRequest = Json.fromJson(jsonNode, ChangeStatusRequest.class);
        } catch (Exception ex) {
            Logger.error("Wrong request format: ", ex);
            return F.Promise.pure(createWrongRequestFormatResponse());
        }

        if (StringUtils.isBlank(changeStatusRequest.getToken()) || StringUtils.isBlank(changeStatusRequest.getStatus()) || StringUtils.isBlank(changeStatusRequest.getReason())) {
            Logger.error("Missing params");
            return F.Promise.pure(createWrongRequestFormatResponse());
        }


        if (!authData.getEnckey().equalsIgnoreCase(SecurityUtil.generateKeyFromArray(authData.getAccount().getId().toString(), authData.getOrderId(), changeStatusRequest.getToken(), changeStatusRequest.getStatus(), changeStatusRequest.getReason(), authData.getAccount().getSecret()))) {
            Logger.error("Provided and calculated enckeys do not match");
            return F.Promise.pure(createWrongEncKeyResponse());
        }


        ChangeCardStatus changeCardStatus;


        try {

            changeCardStatus = ChangeCardStatus.valueOf(changeStatusRequest.getStatus());

        } catch (Exception ex) {
            Logger.error("Wrong request format: ", ex);
            return F.Promise.pure(createWrongRequestFormatResponse());
        }

        F.Promise<Result> result = globalProcessingCardProvider.changeCardStatusForPartner(changeStatusRequest.getToken(), authData.getAccount().getId().toString(), changeCardStatus.getValue(), changeStatusRequest.getReason()).map(res -> ok(Json.toJson(new ChangeStatusResponse(SUCCESS_TEXT, String.valueOf(SUCCESS_CODE), res))));

        return returnRecover(result);
    }

    @With(BaseMerchantApiAction.class)
    @ApiOperation(
            nickname = "activateCard",
            value = "Activate plastic card",
            notes = "Method allows to activate plastic card",
            produces = "application/json",
            consumes = "application/json",
            httpMethod = "POST",
            response = ActivateCardResponse.class
    )

    @ApiResponses(value = {
            @ApiResponse(code = SUCCESS_CODE, message = SUCCESS_TEXT, response = ActivateCardResponse.class),
            @ApiResponse(code = INCORRECT_AUTHORIZATION_DATA_CODE, message = INCORRECT_AUTHORIZATION_DATA_TEXT, response = BaseAPIResponse.class),
            @ApiResponse(code = INACTIVE_ACCOUNT_CODE, message = INACTIVE_ACCOUNT_TEXT, response = BaseAPIResponse.class),
            @ApiResponse(code = WRONG_REQUEST_FORMAT_CODE, message = WRONG_REQUEST_FORMAT_TEXT, response = BaseAPIResponse.class),
            @ApiResponse(code = WRONG_REQUEST_ENCKEY_CODE, message = WRONG_REQUEST_ENCKEY_TEXT, response = BaseAPIResponse.class),
            @ApiResponse(code = GENERAL_ERROR_CODE, message = GENERAL_ERROR_TEXT, response = BaseAPIResponse.class),
    })
    @ApiImplicitParams(value = {
            @ApiImplicitParam(value = "Activate card request", required = true, dataType = "dto.partner.ActivateCardRequest", paramType = "body"),
            @ApiImplicitParam(value = "Account id header", required = true, dataType = "String", paramType = "header", name = "accountId"),
            @ApiImplicitParam(value = "Enckey header. SHA256(accountId+orderId+token+secret)",
                    required = true, dataType = "String", paramType = "header", name = "enckey"),
            @ApiImplicitParam(value = "orderId header", required = true, dataType = "String", paramType = "header", name = "orderId")})
    public F.Promise<Result> activate() {

        final Authentication authData = (Authentication) ctx().args.get("authData");

        final JsonNode jsonNode = request().body().asJson();
        final ActivateCardRequest activateCardRequest;
        try {
            activateCardRequest = Json.fromJson(jsonNode, ActivateCardRequest.class);
        } catch (Exception ex) {
            Logger.error("Wrong request format: ", ex);
            return F.Promise.pure(createWrongRequestFormatResponse());
        }

        if (StringUtils.isBlank(activateCardRequest.getToken())) {
            Logger.error("Missing params");
            return F.Promise.pure(createWrongRequestFormatResponse());
        }


        if (!authData.getEnckey().equalsIgnoreCase(SecurityUtil.generateKeyFromArray(authData.getAccount().getId().toString(), authData.getOrderId(), activateCardRequest.getToken(), authData.getAccount().getSecret()))) {
            Logger.error("Provided and calculated enckeys do not match");
            return F.Promise.pure(createWrongEncKeyResponse());
        }


        F.Promise<Result> result = globalProcessingCardProvider.activatePlasticCardForPartner(activateCardRequest.getToken(), activateCardRequest.getCardNumber(), activateCardRequest.getCvv(), authData.getAccount().getId().toString(), activateCardRequest.getLastName(), activateCardRequest.getFirstName(), activateCardRequest.getAddrl1(), activateCardRequest.getAddrl2(), activateCardRequest.getCity(), activateCardRequest.getPostCode(), activateCardRequest.getCountry(), activateCardRequest.getDob()).map(res -> ok(Json.toJson(new ActivateCardResponse(SUCCESS_TEXT, String.valueOf(SUCCESS_CODE), res))));

        return returnRecover(result);
    }

    @With(BaseMerchantApiAction.class)
    @ApiOperation(
            nickname = "webServiceResult",
            value = "Get card provider web service result",
            notes = "Method allows to retrieve card provider web service result",
            produces = "application/json",
            consumes = "application/json",
            httpMethod = "POST",
            response = WebServiceResultResponse.class
    )

    @ApiResponses(value = {
            @ApiResponse(code = SUCCESS_CODE, message = SUCCESS_TEXT, response = WebServiceResultResponse.class),
            @ApiResponse(code = INCORRECT_AUTHORIZATION_DATA_CODE, message = INCORRECT_AUTHORIZATION_DATA_TEXT, response = BaseAPIResponse.class),
            @ApiResponse(code = INACTIVE_ACCOUNT_CODE, message = INACTIVE_ACCOUNT_TEXT, response = BaseAPIResponse.class),
            @ApiResponse(code = WRONG_REQUEST_FORMAT_CODE, message = WRONG_REQUEST_FORMAT_TEXT, response = BaseAPIResponse.class),
            @ApiResponse(code = WRONG_REQUEST_ENCKEY_CODE, message = WRONG_REQUEST_ENCKEY_TEXT, response = BaseAPIResponse.class),
            @ApiResponse(code = GENERAL_ERROR_CODE, message = GENERAL_ERROR_TEXT, response = BaseAPIResponse.class),
    })
    @ApiImplicitParams(value = {
            @ApiImplicitParam(value = "Card provider web service result request", required = true, dataType = "dto.partner.WebServiceResultRequest", paramType = "body"),
            @ApiImplicitParam(value = "Account id header", required = true, dataType = "String", paramType = "header", name = "accountId"),
            @ApiImplicitParam(value = "Enckey header. SHA256(accountId+orderId+token+wsid+secret)",
                    required = true, dataType = "String", paramType = "header", name = "enckey"),
            @ApiImplicitParam(value = "orderId header", required = true, dataType = "String", paramType = "header", name = "orderId")})
    public F.Promise<Result> wsResult() {

        final Authentication authData = (Authentication) ctx().args.get("authData");

        final JsonNode jsonNode = request().body().asJson();
        final WebServiceResultRequest webServiceResultRequest;
        try {
            webServiceResultRequest = Json.fromJson(jsonNode, WebServiceResultRequest.class);
        } catch (Exception ex) {
            Logger.error("Wrong request format: ", ex);
            return F.Promise.pure(createWrongRequestFormatResponse());
        }

        if (StringUtils.isBlank(webServiceResultRequest.getToken()) || StringUtils.isBlank(webServiceResultRequest.getWsid())) {
            Logger.error("Missing params");
            return F.Promise.pure(createWrongRequestFormatResponse());
        }


        if (!authData.getEnckey().equalsIgnoreCase(SecurityUtil.generateKeyFromArray(authData.getAccount().getId().toString(), authData.getOrderId(), webServiceResultRequest.getToken(), webServiceResultRequest.getWsid(), authData.getAccount().getSecret()))) {
            Logger.error("Provided and calculated enckeys do not match");
            return F.Promise.pure(createWrongEncKeyResponse());
        }

        F.Promise<Result> result = globalProcessingCardProvider.getServiceResultForPartner(webServiceResultRequest.getToken(), webServiceResultRequest.getWsid(), authData.getAccount().getId().toString()).map(res -> ok(Json.toJson(new WebServiceResultResponse(SUCCESS_TEXT, String.valueOf(SUCCESS_CODE), res))));

        return returnRecover(result);
    }

    @With(BaseMerchantApiAction.class)
    @ApiOperation(
            nickname = "changeCardGroup",
            value = "Change card group",
            notes = "Method allows to change card group",
            produces = "application/json",
            consumes = "application/json",
            httpMethod = "POST",
            response = ChangeCardGroupResponse.class
    )


    @ApiResponses(value = {
            @ApiResponse(code = SUCCESS_CODE, message = SUCCESS_TEXT, response = ChangeStatusResponse.class),
            @ApiResponse(code = INCORRECT_AUTHORIZATION_DATA_CODE, message = INCORRECT_AUTHORIZATION_DATA_TEXT, response = BaseAPIResponse.class),
            @ApiResponse(code = INACTIVE_ACCOUNT_CODE, message = INACTIVE_ACCOUNT_TEXT, response = BaseAPIResponse.class),
            @ApiResponse(code = WRONG_REQUEST_FORMAT_CODE, message = WRONG_REQUEST_FORMAT_TEXT, response = BaseAPIResponse.class),
            @ApiResponse(code = WRONG_REQUEST_ENCKEY_CODE, message = WRONG_REQUEST_ENCKEY_TEXT, response = BaseAPIResponse.class),
            @ApiResponse(code = GENERAL_ERROR_CODE, message = GENERAL_ERROR_TEXT, response = BaseAPIResponse.class),
    })
    @ApiImplicitParams(value = {
            @ApiImplicitParam(value = "Change card group request", required = true, dataType = "dto.partner.ChangeCardGroupRequest", paramType = "body"),
            @ApiImplicitParam(value = "Account id header", required = true, dataType = "String", paramType = "header", name = "accountId"),
            @ApiImplicitParam(value = "Enckey header. SHA256(accountId+orderId+token+secret)",
                    required = true, dataType = "String", paramType = "header", name = "enckey"),
            @ApiImplicitParam(value = "orderId header", required = true, dataType = "String", paramType = "header", name = "orderId")})
    public F.Promise<Result> changeCardGroup() {

        final Authentication authData = (Authentication) ctx().args.get("authData");

        final JsonNode jsonNode = request().body().asJson();
        final ChangeCardGroupRequest changeCardGroupRequest;
        try {
            changeCardGroupRequest = Json.fromJson(jsonNode, ChangeCardGroupRequest.class);
        } catch (Exception ex) {
            Logger.error("Wrong request format: ", ex);
            return F.Promise.pure(createWrongRequestFormatResponse());
        }

        if (StringUtils.isBlank(changeCardGroupRequest.getToken()) /*|| StringUtils.isBlank(changeCardGroupRequest.getLimitGroup()) || StringUtils.isBlank(changeCardGroupRequest.getPermGroup()) || StringUtils.isBlank(changeCardGroupRequest.getFeeGroup()) || StringUtils.isBlank(changeCardGroupRequest.getMccGroup()) || StringUtils.isBlank(changeCardGroupRequest.getSchedFeeGroup()) || StringUtils.isBlank(changeCardGroupRequest.getWsFeeGroup())*/) {
            Logger.error("Missing params");
            return F.Promise.pure(createWrongRequestFormatResponse());
        }


        if (!authData.getEnckey().equalsIgnoreCase(SecurityUtil.generateKeyFromArray(authData.getAccount().getId().toString(), authData.getOrderId(), changeCardGroupRequest.getToken(), authData.getAccount().getSecret()))) {
            Logger.error("Provided and calculated enckeys do not match");
            return F.Promise.pure(createWrongEncKeyResponse());
        }

//        F.Promise<Optional<Card>> cardPromise = F.Promise.wrap(cardRepository.retrieveByToken(changeCardGroupRequest.getToken()));

        Card card = new Card();

        card.setToken(changeCardGroupRequest.getToken());


        F.Promise<Result> result  = globalProcessingCardProvider.changeCardGroupForPartner(card, authData.getAccount().getId().toString(), changeCardGroupRequest.getLimitGroup(), changeCardGroupRequest.getPermGroup(), changeCardGroupRequest.getMccGroup(), changeCardGroupRequest.getFeeGroup(), changeCardGroupRequest.getSchedFeeGroup(), changeCardGroupRequest.getWsFeeGroup()).map(res -> ok(Json.toJson(new ChangeCardGroupResponse(SUCCESS_TEXT, String.valueOf(SUCCESS_CODE), res))));

        return returnRecover(result);
    }

    @With(BaseMerchantApiAction.class)
    @ApiOperation(
            nickname = "applyFee",
            value = "Apply card fees",
            notes = "Method allows to apply card fees",
            produces = "application/json",
            consumes = "application/json",
            httpMethod = "POST",
            response = ApplyCardFeeResponse.class
    )


    @ApiResponses(value = {
            @ApiResponse(code = SUCCESS_CODE, message = SUCCESS_TEXT, response = ApplyCardFeeResponse.class),
            @ApiResponse(code = INCORRECT_AUTHORIZATION_DATA_CODE, message = INCORRECT_AUTHORIZATION_DATA_TEXT, response = BaseAPIResponse.class),
            @ApiResponse(code = INACTIVE_ACCOUNT_CODE, message = INACTIVE_ACCOUNT_TEXT, response = BaseAPIResponse.class),
            @ApiResponse(code = WRONG_REQUEST_FORMAT_CODE, message = WRONG_REQUEST_FORMAT_TEXT, response = BaseAPIResponse.class),
            @ApiResponse(code = WRONG_REQUEST_ENCKEY_CODE, message = WRONG_REQUEST_ENCKEY_TEXT, response = BaseAPIResponse.class),
            @ApiResponse(code = GENERAL_ERROR_CODE, message = GENERAL_ERROR_TEXT, response = BaseAPIResponse.class),
    })
    @ApiImplicitParams(value = {
            @ApiImplicitParam(value = "Apply card fee request", required = true, dataType = "dto.partner.ApplyCardFeeRequest", paramType = "body"),
            @ApiImplicitParam(value = "Account id header", required = true, dataType = "String", paramType = "header", name = "accountId"),
            @ApiImplicitParam(value = "Enckey header. SHA256(accountId+orderId+token+procCode+fee+secret)",
                    required = true, dataType = "String", paramType = "header", name = "enckey"),
            @ApiImplicitParam(value = "orderId header", required = true, dataType = "String", paramType = "header", name = "orderId")})
    public F.Promise<Result> applyFee() {

        final Authentication authData = (Authentication) ctx().args.get("authData");

        final JsonNode jsonNode = request().body().asJson();
        final ApplyCardFeeRequest applyCardFeeRequest;
        try {
            applyCardFeeRequest = Json.fromJson(jsonNode, ApplyCardFeeRequest.class);
        } catch (Exception ex) {
            Logger.error("Wrong request format: ", ex);
            return F.Promise.pure(createWrongRequestFormatResponse());
        }

        if (StringUtils.isBlank(applyCardFeeRequest.getToken()) || StringUtils.isBlank(applyCardFeeRequest.getProcCode())) {
            Logger.error("Missing params");
            return F.Promise.pure(createWrongRequestFormatResponse());
        }

        Logger.info("Request enckey = " + authData.getEnckey());

        String calculatedEnckey = SecurityUtil.generateKeyFromArray(authData.getAccount().getId().toString(), authData.getOrderId(), applyCardFeeRequest.getToken(), applyCardFeeRequest.getProcCode(), "" + applyCardFeeRequest.getFee(), authData.getAccount().getSecret());

        Logger.info("Calculated enckey = " + calculatedEnckey);

        if (!authData.getEnckey().equalsIgnoreCase(calculatedEnckey)) {
            Logger.error("Provided and calculated enckeys do not match");
            return F.Promise.pure(createWrongEncKeyResponse());
        }

//        F.Promise<Optional<Card>> cardPromise = F.Promise.wrap(cardRepository.retrieveByToken(applyCardFeeRequest.getToken()));

        Card card = new Card();

        card.setToken(applyCardFeeRequest.getToken());

        F.Promise<Result> result = globalProcessingCardProvider.applyFeeForPartner(authData.getAccount().getId().toString(), applyCardFeeRequest.getProcCode(), card, applyCardFeeRequest.getFee()).map(res -> ok(Json.toJson(new ApplyCardFeeResponse(SUCCESS_TEXT, String.valueOf(SUCCESS_CODE), res))));

        return returnRecover(result);
    }


    @With(BaseMerchantApiAction.class)
    @ApiOperation(
            nickname = "transferBalance",
            value = "Card balance transfer",
            notes = "Method allows to transfer balance between cards",
            produces = "application/json",
            consumes = "application/json",
            httpMethod = "POST",
            response = CardBalanceTransferResponse.class
    )


    @ApiResponses(value = {
            @ApiResponse(code = SUCCESS_CODE, message = SUCCESS_TEXT, response = CardBalanceTransferResponse.class),
            @ApiResponse(code = INCORRECT_AUTHORIZATION_DATA_CODE, message = INCORRECT_AUTHORIZATION_DATA_TEXT, response = BaseAPIResponse.class),
            @ApiResponse(code = INACTIVE_ACCOUNT_CODE, message = INACTIVE_ACCOUNT_TEXT, response = BaseAPIResponse.class),
            @ApiResponse(code = WRONG_REQUEST_FORMAT_CODE, message = WRONG_REQUEST_FORMAT_TEXT, response = BaseAPIResponse.class),
            @ApiResponse(code = WRONG_REQUEST_ENCKEY_CODE, message = WRONG_REQUEST_ENCKEY_TEXT, response = BaseAPIResponse.class),
            @ApiResponse(code = GENERAL_ERROR_CODE, message = GENERAL_ERROR_TEXT, response = BaseAPIResponse.class),
    })
    @ApiImplicitParams(value = {
            @ApiImplicitParam(value = "Card balance request", required = true, dataType = "dto.partner.CardBalanceTransferRequest", paramType = "body"),
            @ApiImplicitParam(value = "Account id header", required = true, dataType = "String", paramType = "header", name = "accountId"),
            @ApiImplicitParam(value = "Enckey header. SHA256(accountId+orderId+token+newToken+amount+currency+secret)",
                    required = true, dataType = "String", paramType = "header", name = "enckey"),
            @ApiImplicitParam(value = "orderId header", required = true, dataType = "String", paramType = "header", name = "orderId")})
    public F.Promise<Result> cardTransfer() {

        final Authentication authData = (Authentication) ctx().args.get("authData");

        final JsonNode jsonNode = request().body().asJson();
        final CardBalanceTransferRequest cardBalanceTransferRequest;
        try {
            cardBalanceTransferRequest = Json.fromJson(jsonNode, CardBalanceTransferRequest.class);
        } catch (Exception ex) {
            Logger.error("Wrong request format: ", ex);
            return F.Promise.pure(createWrongRequestFormatResponse());
        }

        if (StringUtils.isBlank(cardBalanceTransferRequest.getToken()) || StringUtils.isBlank(cardBalanceTransferRequest.getNewToken()) || StringUtils.isBlank(cardBalanceTransferRequest.getCurrency())) {
            Logger.error("Missing params");
            return F.Promise.pure(createWrongRequestFormatResponse());
        }


        if (!authData.getEnckey().equalsIgnoreCase(SecurityUtil.generateKeyFromArray(authData.getAccount().getId().toString(), authData.getOrderId(), cardBalanceTransferRequest.getToken(), cardBalanceTransferRequest.getNewToken(),  "" + cardBalanceTransferRequest.getAmount(), cardBalanceTransferRequest.getCurrency(), authData.getAccount().getSecret()))) {
            Logger.error("Provided and calculated enckeys do not match");
            return F.Promise.pure(createWrongEncKeyResponse());
        }


        F.Promise<Result> result = globalProcessingCardProvider.balanceTransfer(authData.getAccount().getId().toString(), cardBalanceTransferRequest.getToken(), cardBalanceTransferRequest.getNewToken(), cardBalanceTransferRequest.getAmount(), cardBalanceTransferRequest.getCurrency(), cardBalanceTransferRequest.getDescription(), cardBalanceTransferRequest.getLoadedBy(), cardBalanceTransferRequest.getFeeWaiver()).map(res -> ok(Json.toJson(new CardBalanceTransferResponse(SUCCESS_TEXT, String.valueOf(SUCCESS_CODE), res))));

        return returnRecover(result);
    }


    @With(BaseMerchantApiAction.class)
    @ApiOperation(
            nickname = "updateCardHolder",
            value = "Update card holder",
            notes = "Method allows to update card holder data",
            produces = "application/json",
            consumes = "application/json",
            httpMethod = "POST",
            response = UpdateCardHolderResponse.class
    )


    @ApiResponses(value = {
            @ApiResponse(code = SUCCESS_CODE, message = SUCCESS_TEXT, response = UpdateCardHolderResponse.class),
            @ApiResponse(code = INCORRECT_AUTHORIZATION_DATA_CODE, message = INCORRECT_AUTHORIZATION_DATA_TEXT, response = BaseAPIResponse.class),
            @ApiResponse(code = INACTIVE_ACCOUNT_CODE, message = INACTIVE_ACCOUNT_TEXT, response = BaseAPIResponse.class),
            @ApiResponse(code = WRONG_REQUEST_FORMAT_CODE, message = WRONG_REQUEST_FORMAT_TEXT, response = BaseAPIResponse.class),
            @ApiResponse(code = WRONG_REQUEST_ENCKEY_CODE, message = WRONG_REQUEST_ENCKEY_TEXT, response = BaseAPIResponse.class),
            @ApiResponse(code = GENERAL_ERROR_CODE, message = GENERAL_ERROR_TEXT, response = BaseAPIResponse.class),
    })
    @ApiImplicitParams(value = {
            @ApiImplicitParam(value = "Update card holder request", required = true, dataType = "dto.partner.UpdateCardHolderRequest", paramType = "body"),
            @ApiImplicitParam(value = "Account id header", required = true, dataType = "String", paramType = "header", name = "accountId"),
            @ApiImplicitParam(value = "Enckey header. SHA256(accountId+orderId+token+firstName+lastName+secret)",
                    required = true, dataType = "String", paramType = "header", name = "enckey"),
            @ApiImplicitParam(value = "orderId header", required = true, dataType = "String", paramType = "header", name = "orderId")})
    public F.Promise<Result> updateCardHolder() {

        final Authentication authData = (Authentication) ctx().args.get("authData");

        final JsonNode jsonNode = request().body().asJson();
        final UpdateCardHolderRequest updateCardHolderRequest;
        try {
            updateCardHolderRequest = Json.fromJson(jsonNode, UpdateCardHolderRequest.class);
        } catch (Exception ex) {
            Logger.error("Wrong request format: ", ex);
            return F.Promise.pure(createWrongRequestFormatResponse());
        }

        if (StringUtils.isBlank(updateCardHolderRequest.getToken()) || StringUtils.isBlank(updateCardHolderRequest.getFirstName()) || StringUtils.isBlank(updateCardHolderRequest.getLastName())) {
            Logger.error("Missing params");
            return F.Promise.pure(createWrongRequestFormatResponse());
        }


        if (!authData.getEnckey().equalsIgnoreCase(SecurityUtil.generateKeyFromArray(authData.getAccount().getId().toString(), authData.getOrderId(), updateCardHolderRequest.getToken(), updateCardHolderRequest.getFirstName(),  updateCardHolderRequest.getLastName(), authData.getAccount().getSecret()))) {
            Logger.error("Provided and calculated enckeys do not match");
            return F.Promise.pure(createWrongEncKeyResponse());
        }

        Customer customer = new Customer();

        customer.setId(updateCardHolderRequest.getPhone());
        customer.setAddress1(updateCardHolderRequest.getAddressl1());
        customer.setAddress2(updateCardHolderRequest.getAddressl2());
        customer.setFirstName(updateCardHolderRequest.getFirstName());
        customer.setLastName(updateCardHolderRequest.getLastName());
        customer.setCity(updateCardHolderRequest.getCity());
        customer.setEmail(updateCardHolderRequest.getEmail());
        customer.setPostcode(updateCardHolderRequest.getPostCode());
        customer.setTitle(updateCardHolderRequest.getTitle());
        customer.setCountry_id(updateCardHolderRequest.getCountry());

        F.Promise<Result> result = globalProcessingCardProvider.updateCardHolderForPartner(authData.getAccount().getId().toString(), updateCardHolderRequest.getToken(), customer).map(res -> ok(Json.toJson(new UpdateCardHolderResponse(SUCCESS_TEXT, String.valueOf(SUCCESS_CODE), res))));

        return returnRecover(result);
    }


}
