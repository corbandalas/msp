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
            @ApiImplicitParam(value = "Create card request", required = true, dataType = "dto.partner.CreateCard", paramType = "body"),
            @ApiImplicitParam(value = "Account id header", required = true, dataType = "String", paramType = "header", name = "accountId"),
            @ApiImplicitParam(value = "Enckey header. SHA256(accountId+orderId+phone+firstName+lastName+amount+currency+email+secret)",
                    required = true, dataType = "String", paramType = "header", name = "enckey"),
            @ApiImplicitParam(value = "orderId header", required = true, dataType = "String", paramType = "header", name = "orderId")})
    public F.Promise<Result> create() {

        final Authentication authData = (Authentication) ctx().args.get("authData");

        final JsonNode jsonNode = request().body().asJson();
        final CreateCard createCard;
        try {
            createCard = Json.fromJson(jsonNode, CreateCard.class);
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

        ;

        final F.Promise<Optional<Currency>> currencyPromise = F.Promise.wrap(currencyRepository.retrieveById(createCard.getCurrency()));

        final long finalAmount = amount;
        final boolean finalPlastic = plastic;

        final boolean finalActivateNow = activateNow;
        F.Promise<Result> result = currencyPromise.flatMap(currency -> {

            F.Promise<CardCreationResponse> cardCreationResponsePromise;

            if (!finalPlastic) {
                if (finalAmount > 0) {
                    cardCreationResponsePromise = globalProcessingCardProvider.issuePrepaidVirtualCardForPartner(authData.getAccount().getId().toString(), customer, createCard.getCardName(), finalAmount, currency.get(), finalActivateNow);
                } else {
                    cardCreationResponsePromise = globalProcessingCardProvider.issueEmptyVirtualCardForPartner(authData.getAccount().getId().toString(), customer, createCard.getCardName(), currency.get(), finalActivateNow);
                }
            } else {
                if (finalAmount > 0) {
                    cardCreationResponsePromise = globalProcessingCardProvider.issuePrepaidPlasticCardForPartner(authData.getAccount().getId().toString(), customer, createCard.getCardName(), finalAmount, currency.get(), finalActivateNow);
                } else {
                    cardCreationResponsePromise = globalProcessingCardProvider.issueEmptyPlasticCardForPartner(authData.getAccount().getId().toString(), customer, createCard.getCardName(), currency.get(), finalActivateNow);
                }
            }



            return cardCreationResponsePromise.map(res -> ok(Json.toJson(new CreateCardResponse(String.valueOf(SUCCESS_CODE), SUCCESS_TEXT, res))));

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
            @ApiImplicitParam(value = "Load card request", required = true, dataType = "dto.partner.LoadCard", paramType = "body"),
            @ApiImplicitParam(value = "Account id header", required = true, dataType = "String", paramType = "header", name = "accountId"),
            @ApiImplicitParam(value = "Enckey header. SHA256(accountId+orderId+token+amount+currency+source+secret)",
                    required = true, dataType = "String", paramType = "header", name = "enckey"),
            @ApiImplicitParam(value = "orderId header", required = true, dataType = "String", paramType = "header", name = "orderId")})
    public F.Promise<Result> load() {

        final Authentication authData = (Authentication) ctx().args.get("authData");

        final JsonNode jsonNode = request().body().asJson();
        final LoadCard loadCard;
        try {
            loadCard = Json.fromJson(jsonNode, LoadCard.class);
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

        F.Promise<Result> result = currencyPromise.flatMap(currency -> globalProcessingCardProvider.loadVirtualCardForPartner(loadCard.getToken(), finalAmount, currency.get(), loadCard.getDescription(), loadCard.getSource(), authData.getAccount().getId().toString()).map(res -> ok(Json.toJson(new LoadCardResponse(String.valueOf(SUCCESS_CODE), SUCCESS_TEXT, res)))));

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
            @ApiResponse(code = GENERAL_ERROR_CODE, message = GENERAL_ERROR_TEXT, response = LoadCardResponse.class),
    })
    @ApiImplicitParams(value = {
            @ApiImplicitParam(value = "Load card request", required = true, dataType = "dto.partner.UnloadCard", paramType = "body"),
            @ApiImplicitParam(value = "Account id header", required = true, dataType = "String", paramType = "header", name = "accountId"),
            @ApiImplicitParam(value = "Enckey header. SHA256(accountId+orderId+token+amount+currency+secret)",
                    required = true, dataType = "String", paramType = "header", name = "enckey"),
            @ApiImplicitParam(value = "orderId header", required = true, dataType = "String", paramType = "header", name = "orderId")})
    public F.Promise<Result> unload() {

        final Authentication authData = (Authentication) ctx().args.get("authData");

        final JsonNode jsonNode = request().body().asJson();
        final UnloadCard unloadCard;
        try {
            unloadCard = Json.fromJson(jsonNode, UnloadCard.class);
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


        if (!authData.getEnckey().equalsIgnoreCase(SecurityUtil.generateKeyFromArray(authData.getAccount().getId().toString(), authData.getOrderId(),
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

        F.Promise<Result> result = currencyPromise.flatMap(currency -> globalProcessingCardProvider.unloadVirtualCardForPartner(unloadCard.getToken(), finalAmount, currency.get(), unloadCard.getDescription(), unloadCard.getLoadType(), authData.getAccount().getId().toString()).map(res -> ok(Json.toJson(new UnloadCardResponse(String.valueOf(SUCCESS_CODE), SUCCESS_TEXT, res)))));

        return returnRecover(result);
    }


}
