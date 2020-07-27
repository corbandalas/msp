package controllers.partner;

import accomplish.dto.account.GetAccountResponse;
import accomplish.dto.user.CreateUserResponse;
import accomplish.dto.user.update.address.response.AddressRequestBean;
import com.fasterxml.jackson.databind.JsonNode;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.inject.Inject;
import com.wordnik.swagger.annotations.*;
import configs.Constants;
import controllers.BaseAccomplishController;
import controllers.admin.BaseMerchantApiV2Action;
import dto.Authentication;
import dto.partnerV2.*;
import dto.partnerV2.entity.Document;
import exception.CustomerAlreadyRegisteredException;
import exception.WrongCountryException;
import exception.WrongPhoneNumberException;
import model.Card;
import model.Country;
import model.Currency;
import model.Customer;
import model.enums.CardBrand;
import model.enums.CardType;
import model.enums.KYC;
import org.apache.commons.lang3.StringUtils;
import play.Logger;
import play.libs.F;
import play.libs.Json;
import play.mvc.Result;
import play.mvc.With;
import provider.CardProvider;
import repository.CardRepository;
import repository.CountryRepository;
import repository.CurrencyRepository;
import repository.CustomerRepository;
import services.AccomplishService;
import services.OperationService;
import util.DateUtil;
import util.SecurityUtil;
import util.Utils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static configs.ReturnCodes.*;

import dto.partnerV2.LoadResponse;


/**
 * Partner card provider API controller
 *
 * @author corbandalas created 02.07.2020.
 * @since 0.6.0
 */
@Api(value = Constants.PARTNERV2_API_PATH, description = "Partner API v2")
public class CardPartnerAccomplishController extends BaseAccomplishController {

    @Inject
    CurrencyRepository currencyRepository;

    @Inject
    CardRepository cardRepository;

    @Inject
    CustomerRepository customerRepository;

    @Inject
    CountryRepository countryRepository;

    @Inject
    AccomplishService accomplishService;

    @Inject
    CardProvider cardProvider;

    @Inject
    OperationService operationService;

    @With(BaseMerchantApiV2Action.class)
    @ApiOperation(
            nickname = "createCustomer",
            value = "Create new customer",
            notes = "Method allows to create new customer",
            produces = "application/json",
            consumes = "application/json",
            httpMethod = "POST",
            response = CreateCustomerResponse.class
    )

    @ApiResponses(value = {
            @ApiResponse(code = SUCCESS_CODE, message = SUCCESS_TEXT, response = CreateCustomerResponse.class),
            @ApiResponse(code = INCORRECT_AUTHORIZATION_DATA_CODE, message = INCORRECT_AUTHORIZATION_DATA_TEXT, response = BaseAPIV2ErrorResponse.class),
            @ApiResponse(code = INACTIVE_ACCOUNT_CODE, message = INACTIVE_ACCOUNT_TEXT, response = BaseAPIV2ErrorResponse.class),
            @ApiResponse(code = WRONG_REQUEST_FORMAT_CODE, message = WRONG_REQUEST_FORMAT_TEXT, response = BaseAPIV2ErrorResponse.class),
            @ApiResponse(code = WRONG_REQUEST_ENCKEY_CODE, message = WRONG_REQUEST_ENCKEY_TEXT, response = BaseAPIV2ErrorResponse.class),
            @ApiResponse(code = GENERAL_ERROR_CODE, message = GENERAL_ERROR_TEXT, response = BaseAPIV2ErrorResponse.class),
    })
    @ApiImplicitParams(value = {
            @ApiImplicitParam(value = "Create card request", required = true, dataType = "dto.partnerV2.CreateCustomerRequest", paramType = "body"),
            @ApiImplicitParam(value = "X-Api-Key account ID header", required = true, dataType = "String", paramType = "header", name = "X-Api-Key"),
            @ApiImplicitParam(value = "X-Request-Hash message digest header. Base64(sha1(RequestNonce+Api Secret))",
                    required = true, dataType = "String", paramType = "header", name = "X-Request-Hash"),
            @ApiImplicitParam(value = "X-Request-Nonce orderID header", required = true, dataType = "String", paramType = "header", name = "X-Request-Nonce")})
    public F.Promise<Result> createCustomer() {

        final Authentication authData = (Authentication) ctx().args.get("authData");

        final JsonNode jsonNode = request().body().asJson();
        final CreateCustomerRequest createCard;
        try {
            createCard = Json.fromJson(jsonNode, CreateCustomerRequest.class);
        } catch (Exception ex) {
            Logger.error("Wrong request format: ", ex);
            return F.Promise.pure(createWrongRequestFormatResponse("Wrong request format. Check your json"));
        }

        if (StringUtils.isBlank(createCard.getMobilePhone()) ||
                StringUtils.isBlank(createCard.getFirstName()) ||
                StringUtils.isBlank(createCard.getLastName()) ||
                StringUtils.isBlank(createCard.getAddress1()) ||
                StringUtils.isBlank(createCard.getCity()) ||
                StringUtils.isBlank(createCard.getCountry()) ||
                StringUtils.isBlank(createCard.getTitle()) ||
                StringUtils.isBlank(createCard.getZip()) ||
                StringUtils.isBlank(createCard.getBirthdayDate()) ||
                StringUtils.isBlank(createCard.getLang()) ||
                StringUtils.isBlank(createCard.getEmail())
        ) {
            Logger.error("Missing params");
            return F.Promise.pure(createWrongRequestFormatResponse("Missing params. Check API docs"));
        }

        Customer customer = new Customer();

        customer.setFirstName(createCard.getFirstName());
        customer.setLastName(createCard.getLastName());
        customer.setAddress1(createCard.getAddress1());
        customer.setAddress2(createCard.getAddress2());
        customer.setId(createCard.getMobilePhone());
        customer.setCity(createCard.getCity());
        customer.setEmail(createCard.getEmail());
        customer.setCountry_id(createCard.getCountry());
        customer.setPostcode(createCard.getZip());
        customer.setTitle(createCard.getTitle());
        customer.setActive(true);
        customer.setId(createCard.getMobilePhone());
        customer.setFlat("");

        if (StringUtils.isNoneBlank(createCard.getPassword())) {
            customer.setPassword(SecurityUtil.generateKeyFromArray(createCard.getPassword()));
        }

        try {

            customer.setKyc(KYC.NONE);

            Date dob = DateUtil.parse(createCard.getBirthdayDate(), "DD/MM/YYYY");

            customer.setDateBirth(dob);
            customer.setRegistrationDate(new Date());

        } catch (Exception ex) {
            Logger.error("Wrong request format: ", ex);
            return F.Promise.pure(createWrongRequestFormatResponse("Wrong date format"));
        }

        F.Promise<F.Tuple<F.Tuple<Optional<Country>, List<Customer>>, Boolean>> promise = F.Promise.wrap(countryRepository.retrieveById(createCard.getCountry()))
                .zip(F.Promise.wrap(customerRepository.retrieveByEmail(createCard.getEmail()))).zip(F.Promise.wrap(customerRepository.isRegistered(createCard.getMobilePhone())));

        F.Promise<Result> result = promise.flatMap(res -> {

            boolean isRegisteredByPhone = res._2.booleanValue();

            List<Customer> customersByEMail = res._1._2;

            Optional<Country> country = res._1._1;

            if (!country.isPresent()) {
                Logger.error("Country is not exist");
                throw new WrongCountryException("Country is not exist or inactive");
            }

            if (isRegisteredByPhone) {
                Logger.error("Customer is already registered");

                throw new CustomerAlreadyRegisteredException("Customer is already registered");
            }

            if (customersByEMail != null && customersByEMail.size() > 0) {
                Logger.error("Customer is already registered");

                throw new CustomerAlreadyRegisteredException("Customer is already registered");
            }

//            if (!Utils.isValidPhoneNumber(createCard.getMobilePhone(), country.get().getCode())) {
//                throw new WrongPhoneNumberException();
//            }

            F.Promise<CreateUserResponse> userResponsePromise = accomplishService.createUser(createCard.getEmail(), createCard.getTitle(), createCard.getFirstName(),
                    createCard.getLastName(), createCard.getBirthdayDate(), createCard.getMobilePhone(),
                    createCard.getNationality(), createCard.getKycLevel(), createCard.getAddress1(),
                    createCard.getAddress2(), createCard.getCity(), createCard.getZip(), country.get().getCode(),
                    createCard.getLang(), createCard.getPassword(), "" + authData.getAccount().getId());


            return userResponsePromise.map(rez -> {

                if (rez.getResult().getCode().equalsIgnoreCase("0000")) {
                    customer.setReferral("" + rez.getInfo().getId());

                    customerRepository.create(customer);

                    return ok(Json.toJson(new CreateCustomerResponse(new dto.partnerV2.entity.Customer(createCard.getEmail(), createCard.getTitle(), createCard.getFirstName(),
                            createCard.getLastName(), createCard.getBirthdayDate(), createCard.getMobilePhone(),
                            createCard.getNationality(), createCard.getKycLevel(), createCard.getAddress1(),
                            createCard.getAddress2(), createCard.getCity(), createCard.getZip(), country.get().getCode()))));
                } else {
                    return createCardProviderException("" + rez.getResult().getCode());
                }

            });

        });


        return returnRecover(result);
    }


    @With(BaseMerchantApiV2Action.class)
    @ApiOperation(
            nickname = "createIdentification",
            value = "Create identification",
            notes = "Method allows to create identification",
            produces = "application/json",
            consumes = "application/json",
            httpMethod = "POST",
            response = CreateCustomerIdentificationResponse.class
    )

    @ApiResponses(value = {
            @ApiResponse(code = SUCCESS_CODE, message = SUCCESS_TEXT, response = CreateCustomerIdentificationResponse.class),
            @ApiResponse(code = INCORRECT_AUTHORIZATION_DATA_CODE, message = INCORRECT_AUTHORIZATION_DATA_TEXT, response = BaseAPIV2ErrorResponse.class),
            @ApiResponse(code = INACTIVE_ACCOUNT_CODE, message = INACTIVE_ACCOUNT_TEXT, response = BaseAPIV2ErrorResponse.class),
            @ApiResponse(code = WRONG_REQUEST_FORMAT_CODE, message = WRONG_REQUEST_FORMAT_TEXT, response = BaseAPIV2ErrorResponse.class),
            @ApiResponse(code = WRONG_REQUEST_ENCKEY_CODE, message = WRONG_REQUEST_ENCKEY_TEXT, response = BaseAPIV2ErrorResponse.class),
            @ApiResponse(code = GENERAL_ERROR_CODE, message = GENERAL_ERROR_TEXT, response = BaseAPIV2ErrorResponse.class),
    })
    @ApiImplicitParams(value = {
            @ApiImplicitParam(value = "Create identification request", required = true, dataType = "dto.partnerV2.CreateCustomerIdentificationRequest", paramType = "body"),
            @ApiImplicitParam(value = "X-Api-Key account ID header", required = true, dataType = "String", paramType = "header", name = "X-Api-Key"),
            @ApiImplicitParam(value = "X-Request-Hash message digest header. Base64(sha1(RequestNonce+Api Secret))",
                    required = true, dataType = "String", paramType = "header", name = "X-Request-Hash"),
            @ApiImplicitParam(value = "X-Request-Nonce orderID header", required = true, dataType = "String", paramType = "header", name = "X-Request-Nonce")})
    public F.Promise<Result> createIdentification() {

        final Authentication authData = (Authentication) ctx().args.get("authData");

        final JsonNode jsonNode = request().body().asJson();
        final CreateCustomerIdentificationRequest createCard;
        try {
            createCard = Json.fromJson(jsonNode, CreateCustomerIdentificationRequest.class);
        } catch (Exception ex) {
            Logger.error("Wrong request format: ", ex);
            return F.Promise.pure(createWrongRequestFormatResponse("Wrong request format"));
        }

        if (StringUtils.isBlank(createCard.getNumber()) ||
                StringUtils.isBlank(createCard.getType()) ||
                StringUtils.isBlank(createCard.getExpiryDate()) ||
                StringUtils.isBlank(createCard.getIssuanceCountry()) ||
                StringUtils.isBlank(createCard.getResidenceCountry()) ||
                StringUtils.isBlank(createCard.getMobilePhone())
        ) {
            Logger.error("Missing params");
            return F.Promise.pure(createWrongRequestFormatResponse("Missing request params"));
        }

        F.Promise<Optional<Customer>> customerPromise = F.Promise.wrap(customerRepository.retrieveById(createCard.getMobilePhone()));


        F.Promise<Result> result = customerPromise.flatMap(customers -> accomplishService.createIdentification(customers.get().getReferral(), createCard.getIssuanceCountry(),
                createCard.getResidenceCountry(), createCard.getIssueDate(), createCard.getExpiryDate(),
                createCard.getType(), createCard.getNumber(), "" + authData.getAccount().getId())
                .map(res -> {

                    if (res.getResult().getCode().equalsIgnoreCase("0000")) {
                        return ok(Json.toJson(new CreateCustomerIdentificationResponse("" + res.getIdentification().get(0).getId())));
                    } else {
                        return createCardProviderException(res.getResult().getCode());
                    }
                }));

        return returnRecover(result);
    }


    @With(BaseMerchantApiV2Action.class)
    @ApiOperation(
            nickname = "sendDocument",
            value = "Send document",
            notes = "Method allows to send document",
            produces = "application/json",
            consumes = "application/json",
            httpMethod = "POST",
            response = CreateCustomerDocumentResponse.class
    )

    @ApiResponses(value = {
            @ApiResponse(code = SUCCESS_CODE, message = SUCCESS_TEXT, response = CreateCustomerDocumentResponse.class),
            @ApiResponse(code = INCORRECT_AUTHORIZATION_DATA_CODE, message = INCORRECT_AUTHORIZATION_DATA_TEXT, response = BaseAPIV2ErrorResponse.class),
            @ApiResponse(code = INACTIVE_ACCOUNT_CODE, message = INACTIVE_ACCOUNT_TEXT, response = BaseAPIV2ErrorResponse.class),
            @ApiResponse(code = WRONG_REQUEST_FORMAT_CODE, message = WRONG_REQUEST_FORMAT_TEXT, response = BaseAPIV2ErrorResponse.class),
            @ApiResponse(code = WRONG_REQUEST_ENCKEY_CODE, message = WRONG_REQUEST_ENCKEY_TEXT, response = BaseAPIV2ErrorResponse.class),
            @ApiResponse(code = GENERAL_ERROR_CODE, message = GENERAL_ERROR_TEXT, response = BaseAPIV2ErrorResponse.class),
    })
    @ApiImplicitParams(value = {
            @ApiImplicitParam(value = "Create identification request", required = true, dataType = "dto.partnerV2.CreateDocumentRequest", paramType = "body"),
            @ApiImplicitParam(value = "X-Api-Key account ID header", required = true, dataType = "String", paramType = "header", name = "X-Api-Key"),
            @ApiImplicitParam(value = "X-Request-Hash message digest header. Base64(sha1(RequestNonce+Api Secret))",
                    required = true, dataType = "String", paramType = "header", name = "X-Request-Hash"),
            @ApiImplicitParam(value = "X-Request-Nonce orderID header", required = true, dataType = "String", paramType = "header", name = "X-Request-Nonce")})
    public F.Promise<Result> sendDocument() {

        final Authentication authData = (Authentication) ctx().args.get("authData");

        final JsonNode jsonNode = request().body().asJson();
        final CreateDocumentRequest createCard;
        try {
            createCard = Json.fromJson(jsonNode, CreateDocumentRequest.class);
        } catch (Exception ex) {
            Logger.error("Wrong request format: ", ex);
            return F.Promise.pure(createWrongRequestFormatResponse("Wrong request format"));
        }

        if (StringUtils.isBlank(createCard.getDocument()) ||
                StringUtils.isBlank(createCard.getDocumentType()) ||
                StringUtils.isBlank(createCard.getDocumentName()) ||
                StringUtils.isBlank(createCard.getMobilePhone())
        ) {
            Logger.error("Missing params");
            return F.Promise.pure(createWrongRequestFormatResponse("Missing request params"));
        }

        F.Promise<Optional<Customer>> customerPromise = F.Promise.wrap(customerRepository.retrieveById(createCard.getMobilePhone()));


        F.Promise<Result> result = customerPromise.flatMap(customers -> accomplishService.sendDocument(customers.get().getReferral(), createCard.getDocumentName(), createCard.getDocument(),
                createCard.getDocumentType(), "" + authData.getAccount().getId())
                .map(res -> {
                    if (res.getResult().getCode().equalsIgnoreCase("0000")) {
                        return ok(Json.toJson(new CreateCustomerDocumentResponse(new Document("" + res.getInfo().getDocumentId(), "" + res.getInfo().getStatus()))));
                    } else {
                        return createCardProviderException(res.getResult().getCode());
                    }
                }));

        return returnRecover(result);
    }

    @With(BaseMerchantApiV2Action.class)
    @ApiOperation(
            nickname = "getCustomer",
            value = "Get customer",
            notes = "Method allows to get customer",
            produces = "application/json",
            consumes = "application/json",
            httpMethod = "POST",
            response = CreateCustomerResponse.class
    )

    @ApiResponses(value = {
            @ApiResponse(code = SUCCESS_CODE, message = SUCCESS_TEXT, response = CreateCustomerIdentificationResponse.class),
            @ApiResponse(code = INCORRECT_AUTHORIZATION_DATA_CODE, message = INCORRECT_AUTHORIZATION_DATA_TEXT, response = BaseAPIV2ErrorResponse.class),
            @ApiResponse(code = INACTIVE_ACCOUNT_CODE, message = INACTIVE_ACCOUNT_TEXT, response = BaseAPIV2ErrorResponse.class),
            @ApiResponse(code = WRONG_REQUEST_FORMAT_CODE, message = WRONG_REQUEST_FORMAT_TEXT, response = BaseAPIV2ErrorResponse.class),
            @ApiResponse(code = WRONG_REQUEST_ENCKEY_CODE, message = WRONG_REQUEST_ENCKEY_TEXT, response = BaseAPIV2ErrorResponse.class),
            @ApiResponse(code = GENERAL_ERROR_CODE, message = GENERAL_ERROR_TEXT, response = BaseAPIV2ErrorResponse.class),
    })
    @ApiImplicitParams(value = {
            @ApiImplicitParam(value = "Create identification request", required = true, dataType = "dto.partnerV2.CreateDocumentRequest", paramType = "body"),
            @ApiImplicitParam(value = "X-Api-Key account ID header", required = true, dataType = "String", paramType = "header", name = "X-Api-Key"),
            @ApiImplicitParam(value = "X-Request-Hash message digest header. Base64(sha1(RequestNonce+Api Secret))",
                    required = true, dataType = "String", paramType = "header", name = "X-Request-Hash"),
            @ApiImplicitParam(value = "X-Request-Nonce orderID header", required = true, dataType = "String", paramType = "header", name = "X-Request-Nonce")})
    public F.Promise<Result> getCustomer() {

        final Authentication authData = (Authentication) ctx().args.get("authData");

        final JsonNode jsonNode = request().body().asJson();
        final GetCustomerRequest createCard;
        try {
            createCard = Json.fromJson(jsonNode, GetCustomerRequest.class);
        } catch (Exception ex) {
            Logger.error("Wrong request format: ", ex);
            return F.Promise.pure(createWrongRequestFormatResponse("Wrong request format"));
        }

        if (StringUtils.isBlank(createCard.getMobilePhone())
        ) {
            Logger.error("Missing params");
            return F.Promise.pure(createWrongRequestFormatResponse("Missing request params: mobilePhone"));
        }

        F.Promise<Optional<Customer>> customerPromise = F.Promise.wrap(customerRepository.retrieveById(createCard.getMobilePhone()));


        F.Promise<Result> result = customerPromise.flatMap(customers -> accomplishService.getCustomer(customers.get().getReferral(), "" + authData.getAccount().getId())
                .map(res -> {

                    if (res.getResult().getCode().equalsIgnoreCase("0000")) {
                        return ok(Json.toJson(new CreateCustomerResponse(new dto.partnerV2.entity.Customer(res.getEmail().get(0).getAddress(),
                                res.getPersonalInfo().getTitle(), res.getPersonalInfo().getFirstName(),
                                res.getPersonalInfo().getLastName(), res.getPersonalInfo().getDateOfBirth(),
                                res.getPhone().get(0).getNumber(), res.getAddress().getCountryCode(), customers.get().getKyc().name(),
                                res.getAddress().getCountryCode(), res.getAddress().getAddressLine1(), res.getAddress().getAddressLine2(),
                                res.getAddress().getCityTown(), res.getAddress().getPostalZipCode()))));
                    } else {
                        return createCardProviderException(res.getResult().getCode());
                    }

                }));

        return returnRecover(result);
    }


    @With(BaseMerchantApiV2Action.class)
    @ApiOperation(
            nickname = "createCard",
            value = "Create card",
            notes = "Method allows to create new card",
            produces = "application/json",
            consumes = "application/json",
            httpMethod = "POST",
            response = CreateCardResponse.class
    )

    @ApiResponses(value = {
            @ApiResponse(code = SUCCESS_CODE, message = SUCCESS_TEXT, response = CreateCardResponse.class),
            @ApiResponse(code = INCORRECT_AUTHORIZATION_DATA_CODE, message = INCORRECT_AUTHORIZATION_DATA_TEXT, response = BaseAPIV2ErrorResponse.class),
            @ApiResponse(code = INACTIVE_ACCOUNT_CODE, message = INACTIVE_ACCOUNT_TEXT, response = BaseAPIV2ErrorResponse.class),
            @ApiResponse(code = WRONG_REQUEST_FORMAT_CODE, message = WRONG_REQUEST_FORMAT_TEXT, response = BaseAPIV2ErrorResponse.class),
            @ApiResponse(code = WRONG_REQUEST_ENCKEY_CODE, message = WRONG_REQUEST_ENCKEY_TEXT, response = BaseAPIV2ErrorResponse.class),
            @ApiResponse(code = GENERAL_ERROR_CODE, message = GENERAL_ERROR_TEXT, response = BaseAPIV2ErrorResponse.class),
    })
    @ApiImplicitParams(value = {
            @ApiImplicitParam(value = "Create card request", required = true, dataType = "dto.partnerV2.CreateCardRequest", paramType = "body"),
            @ApiImplicitParam(value = "X-Api-Key account ID header", required = true, dataType = "String", paramType = "header", name = "X-Api-Key"),
            @ApiImplicitParam(value = "X-Request-Hash message digest header. Base64(sha1(RequestNonce+Api Secret))",
                    required = true, dataType = "String", paramType = "header", name = "X-Request-Hash"),
            @ApiImplicitParam(value = "X-Request-Nonce orderID header", required = true, dataType = "String", paramType = "header", name = "X-Request-Nonce")})
    public F.Promise<Result> createCard() {

        final Authentication authData = (Authentication) ctx().args.get("authData");

        final JsonNode jsonNode = request().body().asJson();
        final CreateCardRequest createCard;
        try {
            createCard = Json.fromJson(jsonNode, CreateCardRequest.class);
        } catch (Exception ex) {
            Logger.error("Wrong request format: ", ex);
            return F.Promise.pure(createWrongRequestFormatResponse("Wrong request format"));
        }

        if (StringUtils.isBlank(createCard.getMobilePhone())
        ) {
            Logger.error("Missing params");
            return F.Promise.pure(createWrongRequestFormatResponse("Missing request params: mobilePhone"));
        }

        if (StringUtils.isBlank(createCard.getCardData())
        ) {
            Logger.error("Missing params");
            return F.Promise.pure(createWrongRequestFormatResponse("Missing request params: cardData"));
        }

        if (StringUtils.isBlank(createCard.getCardModel())
        ) {
            Logger.error("Missing params");
            return F.Promise.pure(createWrongRequestFormatResponse("Missing request params: cardModel"));
        }

        F.Promise<Optional<Customer>> customerPromise = F.Promise.wrap(customerRepository.retrieveById(createCard.getMobilePhone()));


        F.Promise<Result> result = customerPromise.flatMap(customers -> accomplishService.createCard(customers.get().getReferral(),
                createCard.getCardModel(), "" + authData.getAccount().getId())
                .flatMap(res -> {

                            F.Promise<Result> returnPromise = null;

                            if (res.getResult().getCode().equalsIgnoreCase("0000")) {
                                Card card = new Card();

                                String currency = "DKK";
                                CardBrand cardBrand = CardBrand.WALLET;
                                CardType cardType = CardType.VIRTUAL;
                                String type = "";

                                if (createCard.getCardModel().equalsIgnoreCase("mymonii_parentwallet")) {
                                    cardBrand = CardBrand.WALLET;
                                    currency = "DKK";
                                    cardType = CardType.VIRTUAL;
                                    type = "mvc";
                                } else if (createCard.getCardModel().equalsIgnoreCase("mymonii_childcard")) {
                                    cardBrand = CardBrand.WALLET;
                                    currency = "DKK";
                                    cardType = CardType.PLASTIC;
                                    type = "physical";
                                }

                                card.setToken("" + res.getInfo().getId());

                                card.setActive(true);
                                card.setAlias(createCard.getCardModel());
                                card.setBrand(cardBrand);
                                card.setType(cardType);
                                card.setCardDefault(true);
                                card.setCreateDate(new Date());
                                card.setCurrencyId(currency);
                                card.setCustomerId(createCard.getMobilePhone());
                                card.setDeliveryAddress1("address 1");
                                card.setDeliveryAddress2("address 2");
                                card.setDeliveryAddress3("address 3");
                                card.setDeliveryCountry("DK");
                                card.setInfo(res.getInfo().getBinId());


                                String finalCurrency = currency;
                                String finalType = type;
                                returnPromise = F.Promise.wrap(cardRepository.create(card)).map(rez -> ok(Json.toJson(new CreateCardResponse(null, "0", createCard.getCardData(), finalCurrency, res.getInfo().getNumber(),
                                        "mymonii_feegroup_dkk", "ready", "" + res.getInfo().getId(), finalType, "MYMONII"))));
                            } else {
                                returnPromise = F.Promise.pure(createCardProviderException(res.getResult().getCode()));
                            }
                            return returnPromise;
                        }
                ));

        return returnRecover(result);
    }

    @With(BaseMerchantApiV2Action.class)
    @ApiOperation(
            nickname = "cardTransfer",
            value = "Card transfer",
            notes = "Method allows to transfer funds between cards",
            produces = "application/json",
            consumes = "application/json",
            httpMethod = "POST",
            response = TransferResponse.class
    )

    @ApiResponses(value = {
            @ApiResponse(code = SUCCESS_CODE, message = SUCCESS_TEXT, response = TransferResponse.class),
            @ApiResponse(code = INCORRECT_AUTHORIZATION_DATA_CODE, message = INCORRECT_AUTHORIZATION_DATA_TEXT, response = BaseAPIV2ErrorResponse.class),
            @ApiResponse(code = INACTIVE_ACCOUNT_CODE, message = INACTIVE_ACCOUNT_TEXT, response = BaseAPIV2ErrorResponse.class),
            @ApiResponse(code = WRONG_REQUEST_FORMAT_CODE, message = WRONG_REQUEST_FORMAT_TEXT, response = BaseAPIV2ErrorResponse.class),
            @ApiResponse(code = WRONG_REQUEST_ENCKEY_CODE, message = WRONG_REQUEST_ENCKEY_TEXT, response = BaseAPIV2ErrorResponse.class),
            @ApiResponse(code = GENERAL_ERROR_CODE, message = GENERAL_ERROR_TEXT, response = BaseAPIV2ErrorResponse.class),
    })
    @ApiImplicitParams(value = {
            @ApiImplicitParam(value = "Transfer request", required = true, dataType = "dto.partnerV2.TransferRequest", paramType = "body"),
            @ApiImplicitParam(value = "X-Api-Key account ID header", required = true, dataType = "String", paramType = "header", name = "X-Api-Key"),
            @ApiImplicitParam(value = "X-Request-Hash message digest header. Base64(sha1(RequestNonce+Api Secret))",
                    required = true, dataType = "String", paramType = "header", name = "X-Request-Hash"),
            @ApiImplicitParam(value = "X-Request-Nonce orderID header", required = true, dataType = "String", paramType = "header", name = "X-Request-Nonce")})
    public F.Promise<Result> transfer() {

        final Authentication authData = (Authentication) ctx().args.get("authData");

        final JsonNode jsonNode = request().body().asJson();
        final TransferRequest createCard;
        try {
            createCard = Json.fromJson(jsonNode, TransferRequest.class);
        } catch (Exception ex) {
            Logger.error("Wrong request format: ", ex);
            return F.Promise.pure(createWrongRequestFormatResponse("Wrong request format"));
        }

        if (StringUtils.isBlank(createCard.getCurrency())) {
            Logger.error("Missing params");
            return F.Promise.pure(createWrongRequestFormatResponse("Missing request params: currency"));
        }

        if (StringUtils.isBlank(createCard.getReceiver())) {
            Logger.error("Missing params");
            return F.Promise.pure(createWrongRequestFormatResponse("Missing request params: receiver"));
        }

        if (StringUtils.isBlank(createCard.getToken())) {
            Logger.error("Missing params");
            return F.Promise.pure(createWrongRequestFormatResponse("Missing request params: token"));
        }

        if (createCard.getAmount() <= 0) {
            Logger.error("Missing params");
            return F.Promise.pure(createWrongRequestFormatResponse("Missing request params: amount"));
        }

        F.Promise<Optional<Card>> senderCardPromise = F.Promise.wrap(cardRepository.retrieveByToken(createCard.getToken()));
        F.Promise<Optional<Card>> receiverCardPromise = F.Promise.wrap(cardRepository.retrieveByToken(createCard.getReceiver()));

        final F.Promise<F.Tuple<F.Tuple<Optional<Card>, Optional<Card>>, Optional<Currency>>> zip = senderCardPromise.zip(receiverCardPromise).zip(F.Promise.wrap(currencyRepository.retrieveById(createCard.getCurrency())));

        final F.Promise<Result> result = zip.flatMap(data -> {
            if (!data._2.isPresent()) {
                Logger.error("Specified currency doesn't exist");
                return F.Promise.pure(createIncorrectCurrencyResponse());
            }

            if (!data._1._1.isPresent()) {
                Logger.error("Specified card doesn't exist");
                return F.Promise.pure(createWrongCardResponse());
            }

            return accomplishService.transfer(createCard.getToken(), createCard.getReceiver(), "" + createCard.getAmount(),
                    createCard.getCurrency(), "" + authData.getAccount().getId()).flatMap(providerResponse -> {

                F.Promise<Result> returnPromise = null;

                if (providerResponse.getResult().getCode().equalsIgnoreCase("0000")) {

                    returnPromise = operationService.createTransferOperation(data._1._1.get(),
                            data._1._2.get(), (long) createCard.getAmount() * 100, data._2.get(), "" + System.currentTimeMillis(), "Transfer funds")
                            .map(res -> ok(Json.toJson(new TransferResponse(true, "ready")
                            )));
                } else {
                    returnPromise = F.Promise.pure(createCardProviderException(providerResponse.getResult().getCode()));
                }

                return returnPromise;

            });
        });
        return returnRecover(result);

    }

    @With(BaseMerchantApiV2Action.class)
    @ApiOperation(
            nickname = "cardActivation",
            value = "Card activation",
            notes = "Method allows to activate card",
            produces = "application/json",
            consumes = "application/json",
            httpMethod = "POST",
            response = SuccessAPIV2Response.class
    )

    @ApiResponses(value = {
            @ApiResponse(code = SUCCESS_CODE, message = SUCCESS_TEXT, response = SuccessAPIV2Response.class),
            @ApiResponse(code = INCORRECT_AUTHORIZATION_DATA_CODE, message = INCORRECT_AUTHORIZATION_DATA_TEXT, response = BaseAPIV2ErrorResponse.class),
            @ApiResponse(code = INACTIVE_ACCOUNT_CODE, message = INACTIVE_ACCOUNT_TEXT, response = BaseAPIV2ErrorResponse.class),
            @ApiResponse(code = WRONG_REQUEST_FORMAT_CODE, message = WRONG_REQUEST_FORMAT_TEXT, response = BaseAPIV2ErrorResponse.class),
            @ApiResponse(code = WRONG_REQUEST_ENCKEY_CODE, message = WRONG_REQUEST_ENCKEY_TEXT, response = BaseAPIV2ErrorResponse.class),
            @ApiResponse(code = GENERAL_ERROR_CODE, message = GENERAL_ERROR_TEXT, response = BaseAPIV2ErrorResponse.class),
    })
    @ApiImplicitParams(value = {
            @ApiImplicitParam(value = "Card activation request", required = true, dataType = "dto.partnerV2.ActivateRequest", paramType = "body"),
            @ApiImplicitParam(value = "X-Api-Key account ID header", required = true, dataType = "String", paramType = "header", name = "X-Api-Key"),
            @ApiImplicitParam(value = "X-Request-Hash message digest header. Base64(sha1(RequestNonce+Api Secret))",
                    required = true, dataType = "String", paramType = "header", name = "X-Request-Hash"),
            @ApiImplicitParam(value = "X-Request-Nonce orderID header", required = true, dataType = "String", paramType = "header", name = "X-Request-Nonce")})
    public F.Promise<Result> activation() {

        final Authentication authData = (Authentication) ctx().args.get("authData");

        final JsonNode jsonNode = request().body().asJson();
        final ActivateRequest createCard;
        try {
            createCard = Json.fromJson(jsonNode, ActivateRequest.class);
        } catch (Exception ex) {
            Logger.error("Wrong request format: ", ex);
            return F.Promise.pure(createWrongRequestFormatResponse("Wrong request format"));
        }

        if (StringUtils.isBlank(createCard.getToken())) {
            Logger.error("Missing params");
            return F.Promise.pure(createWrongRequestFormatResponse("Missing request params: token"));
        }

        if (StringUtils.isBlank(createCard.getLastDigits())) {
            Logger.error("Missing params");
            return F.Promise.pure(createWrongRequestFormatResponse("Missing request params: last4digit"));
        }

        if (StringUtils.isBlank(createCard.getMobilePhone())) {
            Logger.error("Missing params");
            return F.Promise.pure(createWrongRequestFormatResponse("Missing request params: mobilePhone"));
        }

        F.Promise<Optional<Card>> senderCardPromise = F.Promise.wrap(cardRepository.retrieveByToken(createCard.getToken()));
        F.Promise<Optional<Customer>> customerPromise = F.Promise.wrap(customerRepository.retrieveById(createCard.getMobilePhone()));


        final F.Promise<Result> result = customerPromise.zip(senderCardPromise).flatMap(data -> {


            F.Promise<GetAccountResponse> account = accomplishService.getAccount(createCard.getToken(), "" + authData.getAccount().getId());

            return account.flatMap(acc -> {

                F.Promise<Result> returnPromise = null;

                if (!data._1.isPresent()) {
                    Logger.error("Specified customer doesn't exist");
                    returnPromise = F.Promise.pure(createWrongCustomerAccountResponse());
                    return returnPromise;
                }

                if (acc.getResult().getCode().equalsIgnoreCase("0000")) {
                    return accomplishService.activateAccount(createCard.getToken(), data._2.get().getInfo(),
                            data._1.get().getReferral(), data._2.get().getCurrencyId(), acc.getInfo().getNumber(), "0",
                            acc.getInfo().getSecurity().getActivationCode(), "" + authData.getAccount().getId()).map(rez ->
                            ok(Json.toJson(new SuccessAPIV2Response(true)
                            )));
                } else {
                    returnPromise = F.Promise.pure(createCardProviderException(acc.getResult().getCode()));
                }

                return returnPromise;
            });
        });

        return returnRecover(result);

    }

    @With(BaseMerchantApiV2Action.class)
    @ApiOperation(
            nickname = "cardLoad",
            value = "Card load",
            notes = "Method allows to load card",
            produces = "application/json",
            consumes = "application/json",
            httpMethod = "POST",
            response = LoadResponse.class
    )

    @ApiResponses(value = {
            @ApiResponse(code = SUCCESS_CODE, message = SUCCESS_TEXT, response = LoadResponse.class),
            @ApiResponse(code = INCORRECT_AUTHORIZATION_DATA_CODE, message = INCORRECT_AUTHORIZATION_DATA_TEXT, response = BaseAPIV2ErrorResponse.class),
            @ApiResponse(code = INACTIVE_ACCOUNT_CODE, message = INACTIVE_ACCOUNT_TEXT, response = BaseAPIV2ErrorResponse.class),
            @ApiResponse(code = WRONG_REQUEST_FORMAT_CODE, message = WRONG_REQUEST_FORMAT_TEXT, response = BaseAPIV2ErrorResponse.class),
            @ApiResponse(code = WRONG_REQUEST_ENCKEY_CODE, message = WRONG_REQUEST_ENCKEY_TEXT, response = BaseAPIV2ErrorResponse.class),
            @ApiResponse(code = GENERAL_ERROR_CODE, message = GENERAL_ERROR_TEXT, response = BaseAPIV2ErrorResponse.class),
    })
    @ApiImplicitParams(value = {
            @ApiImplicitParam(value = "Card load request", required = true, dataType = "dto.partnerV2.LoadRequest", paramType = "body"),
            @ApiImplicitParam(value = "X-Api-Key account ID header", required = true, dataType = "String", paramType = "header", name = "X-Api-Key"),
            @ApiImplicitParam(value = "X-Request-Hash message digest header. Base64(sha1(RequestNonce+Api Secret))",
                    required = true, dataType = "String", paramType = "header", name = "X-Request-Hash"),
            @ApiImplicitParam(value = "X-Request-Nonce orderID header", required = true, dataType = "String", paramType = "header", name = "X-Request-Nonce")})
    public F.Promise<Result> load() {

        final Authentication authData = (Authentication) ctx().args.get("authData");

        final JsonNode jsonNode = request().body().asJson();
        final LoadRequest createCard;
        try {
            createCard = Json.fromJson(jsonNode, LoadRequest.class);
        } catch (Exception ex) {
            Logger.error("Wrong request format: ", ex);
            return F.Promise.pure(createWrongRequestFormatResponse("Wrong request format"));
        }

        if (StringUtils.isBlank(createCard.getToken())) {
            Logger.error("Missing params");
            return F.Promise.pure(createWrongRequestFormatResponse("Missing request params: token"));
        }

        if (StringUtils.isBlank(createCard.getAmount())) {
            Logger.error("Missing params");
            return F.Promise.pure(createWrongRequestFormatResponse("Missing request params: amount"));
        }

        String ref = StringUtils.isBlank(createCard.getReference()) ? "" + System.currentTimeMillis() : createCard.getReference();


        F.Promise<Optional<Card>> senderCardPromise = F.Promise.wrap(cardRepository.retrieveByToken(createCard.getToken()));

        final F.Promise<Result> result = senderCardPromise.flatMap(data -> F.Promise.wrap(currencyRepository.retrieveById(data.get().getCurrencyId())).flatMap(currency -> accomplishService.load(createCard.getAmount(), data.get().getCurrencyId(), createCard.getToken(), "" + authData.getAccount().getId()).flatMap(acc -> {

            F.Promise<Result> returnPromise = null;


            if (acc.getResult().getCode().equalsIgnoreCase("0000")) {
                return operationService.createDepositOperation(data.get(),
                        (long) (Float.parseFloat(createCard.getAmount()) * 100), currency.get(), ref, StringUtils.isBlank(createCard.getLabel()) ? "Debit card deposit" : createCard.getLabel()).map(rez ->
                        ok(Json.toJson(new LoadResponse(createCard.getToken(), "done", createCard.getAmount(), acc.getInfo().getAvailableBalance(), ref)
                        )));
            } else {
                returnPromise = F.Promise.pure(createCardProviderException(acc.getResult().getCode()));
            }

            return returnPromise;
        })));

        return returnRecover(result);

    }


    @With(BaseMerchantApiV2Action.class)
    @ApiOperation(
            nickname = "checkCard",
            value = "Card check",
            notes = "Method allows to check card",
            produces = "application/json",
            consumes = "application/json",
            httpMethod = "POST",
            response = CheckCardResponse.class
    )

    @ApiResponses(value = {
            @ApiResponse(code = SUCCESS_CODE, message = SUCCESS_TEXT, response = CheckCardResponse.class),
            @ApiResponse(code = INCORRECT_AUTHORIZATION_DATA_CODE, message = INCORRECT_AUTHORIZATION_DATA_TEXT, response = BaseAPIV2ErrorResponse.class),
            @ApiResponse(code = INACTIVE_ACCOUNT_CODE, message = INACTIVE_ACCOUNT_TEXT, response = BaseAPIV2ErrorResponse.class),
            @ApiResponse(code = WRONG_REQUEST_FORMAT_CODE, message = WRONG_REQUEST_FORMAT_TEXT, response = BaseAPIV2ErrorResponse.class),
            @ApiResponse(code = WRONG_REQUEST_ENCKEY_CODE, message = WRONG_REQUEST_ENCKEY_TEXT, response = BaseAPIV2ErrorResponse.class),
            @ApiResponse(code = GENERAL_ERROR_CODE, message = GENERAL_ERROR_TEXT, response = BaseAPIV2ErrorResponse.class),
    })
    @ApiImplicitParams(value = {
            @ApiImplicitParam(value = "Card check request", required = true, dataType = "dto.partnerV2.CheckCardRequest", paramType = "body"),
            @ApiImplicitParam(value = "X-Api-Key account ID header", required = true, dataType = "String", paramType = "header", name = "X-Api-Key"),
            @ApiImplicitParam(value = "X-Request-Hash message digest header. Base64(sha1(RequestNonce+Api Secret))",
                    required = true, dataType = "String", paramType = "header", name = "X-Request-Hash"),
            @ApiImplicitParam(value = "X-Request-Nonce orderID header", required = true, dataType = "String", paramType = "header", name = "X-Request-Nonce")})
    public F.Promise<Result> checkCard() {

        final Authentication authData = (Authentication) ctx().args.get("authData");

        final JsonNode jsonNode = request().body().asJson();
        final CheckCardRequest createCard;
        try {
            createCard = Json.fromJson(jsonNode, CheckCardRequest.class);
        } catch (Exception ex) {
            Logger.error("Wrong request format: ", ex);
            return F.Promise.pure(createWrongRequestFormatResponse("Wrong request format"));
        }

        if (StringUtils.isBlank(createCard.getToken())) {
            Logger.error("Missing params");
            return F.Promise.pure(createWrongRequestFormatResponse("Missing request params: token"));
        }


        F.Promise<Optional<Card>> senderCardPromise = F.Promise.wrap(cardRepository.retrieveByToken(createCard.getToken()));
        F.Promise<GetAccountResponse> accountPromise = accomplishService.getAccount(createCard.getToken(), "" + authData.getAccount().getId());

        final F.Promise<Result> result = senderCardPromise.zip(accountPromise).flatMap(acc -> {

            F.Promise<Result> returnPromise = null;


            if (acc._2.getResult().getCode().equalsIgnoreCase("0000")) {


                String accStatus = acc._2.getInfo().getStatus();

                String status = "active";

                if (accStatus.equalsIgnoreCase("0")) {
                    status = "closed";
                } else if (accStatus.equalsIgnoreCase("1")) {
                    status = "active";
                } else if (accStatus.equalsIgnoreCase("2")) {
                    status = "lost_or_stolen";
                } else if (accStatus.equalsIgnoreCase("3")) {
                    status = "lost_or_stolen";
                } else if (accStatus.equalsIgnoreCase("4")) {
                    status = "closed";
                } else if (accStatus.equalsIgnoreCase("5")) {
                    status = "blocked";
                } else if (accStatus.equalsIgnoreCase("6")) {
                    status = "blocked";
                } else if (accStatus.equalsIgnoreCase("7")) {
                    status = "expired";
                } else if (accStatus.equalsIgnoreCase("8")) {
                    status = "expired";
                } else if (accStatus.equalsIgnoreCase("9")) {
                    status = "blocked";
                } else if (accStatus.equalsIgnoreCase("12")) {
                    status = "active";
                }


                returnPromise =
                        F.Promise.pure(ok(Json.toJson(new dto.partnerV2.CheckCardResponse(createCard.getToken(), status, acc._2.getInfo().getActivationDateTime(), acc._2.getInfo().getAvailableBalance(), "", acc._1.get().getCurrencyId(), "", acc._2.getInfo().getNumber(),
                                "", ""))));
            } else {
                returnPromise = F.Promise.pure(createCardProviderException(acc._2.getResult().getCode()));
            }

            return returnPromise;
        });

        return returnRecover(result);

    }


    @With(BaseMerchantApiV2Action.class)
    @ApiOperation(
            nickname = "updateCustomer",
            value = "Update customer",
            notes = "Method allows to update customer",
            produces = "application/json",
            consumes = "application/json",
            httpMethod = "POST",
            response = SuccessAPIV2Response.class
    )

    @ApiResponses(value = {
            @ApiResponse(code = SUCCESS_CODE, message = SUCCESS_TEXT, response = SuccessAPIV2Response.class),
            @ApiResponse(code = INCORRECT_AUTHORIZATION_DATA_CODE, message = INCORRECT_AUTHORIZATION_DATA_TEXT, response = BaseAPIV2ErrorResponse.class),
            @ApiResponse(code = INACTIVE_ACCOUNT_CODE, message = INACTIVE_ACCOUNT_TEXT, response = BaseAPIV2ErrorResponse.class),
            @ApiResponse(code = WRONG_REQUEST_FORMAT_CODE, message = WRONG_REQUEST_FORMAT_TEXT, response = BaseAPIV2ErrorResponse.class),
            @ApiResponse(code = WRONG_REQUEST_ENCKEY_CODE, message = WRONG_REQUEST_ENCKEY_TEXT, response = BaseAPIV2ErrorResponse.class),
            @ApiResponse(code = GENERAL_ERROR_CODE, message = GENERAL_ERROR_TEXT, response = BaseAPIV2ErrorResponse.class),
    })
    @ApiImplicitParams(value = {
            @ApiImplicitParam(value = "Update customer request", required = true, dataType = "dto.partnerV2.UpdateCustomerRequest", paramType = "body"),
            @ApiImplicitParam(value = "X-Api-Key account ID header", required = true, dataType = "String", paramType = "header", name = "X-Api-Key"),
            @ApiImplicitParam(value = "X-Request-Hash message digest header. Base64(sha1(RequestNonce+Api Secret))",
                    required = true, dataType = "String", paramType = "header", name = "X-Request-Hash"),
            @ApiImplicitParam(value = "X-Request-Nonce orderID header", required = true, dataType = "String", paramType = "header", name = "X-Request-Nonce")})
    public F.Promise<Result> updateCustomer() {

        final Authentication authData = (Authentication) ctx().args.get("authData");

        final JsonNode jsonNode = request().body().asJson();
        final UpdateCustomerRequest createCard;
        try {
            createCard = Json.fromJson(jsonNode, UpdateCustomerRequest.class);
        } catch (Exception ex) {
            Logger.error("Wrong request format: ", ex);
            return F.Promise.pure(createWrongRequestFormatResponse("Wrong request format"));
        }

        if (StringUtils.isBlank(createCard.getMobilePhone())) {
            Logger.error("Missing params");
            return F.Promise.pure(createWrongRequestFormatResponse("Missing request params: mobile phone"));
        }

        if (StringUtils.isBlank(createCard.getType())) {
            Logger.error("Missing params");
            return F.Promise.pure(createWrongRequestFormatResponse("Missing request params: type"));
        }

        if (StringUtils.isBlank(createCard.getData())) {
            Logger.error("Missing params");
            return F.Promise.pure(createWrongRequestFormatResponse("Missing request params: data"));
        }

        F.Promise<Optional<Customer>> customerPromise = F.Promise.wrap(customerRepository.retrieveById(createCard.getMobilePhone()));


        final F.Promise<Result> result = customerPromise.flatMap(acc -> {

            F.Promise<Result> returnPromise = null;

            if (createCard.getType().equalsIgnoreCase("address")) {

                final GsonBuilder gsonBuilder = new GsonBuilder();
                gsonBuilder.disableHtmlEscaping();

                final Gson gson = gsonBuilder.create();

                AddressRequestBean addressRequestBean = gson.fromJson(createCard.getData(), AddressRequestBean.class);

                return accomplishService.updateUserAddress(acc.get().getReferral(), addressRequestBean, "" + authData.getAccount().getId()).flatMap(res -> {
                    if (res.getResult().getCode().equalsIgnoreCase("0000")) {

                        Customer customer = acc.get();

                        customer.setAddress1(addressRequestBean.getAddress1());
                        customer.setAddress2(addressRequestBean.getAddress2());
                        customer.setCity(addressRequestBean.getCity());
                        customer.setCountry_id(addressRequestBean.getCountry());
                        customer.setPostcode(addressRequestBean.getZip());

                        customerRepository.update(customer);

                        return F.Promise.pure(ok(Json.toJson(new dto.partnerV2.SuccessAPIV2Response(true))));
                    } else {
                        return F.Promise.pure(createCardProviderException(res.getResult().getCode()));
                    }
                });
            } else if (createCard.getType().equalsIgnoreCase("email")) {
                return accomplishService.updateUserEmail(acc.get().getReferral(), createCard.getData(), "" + authData.getAccount().getId()).flatMap(res -> {
                    if (res.getResult().getCode().equalsIgnoreCase("0000")) {

                        Customer customer = acc.get();

                        customer.setEmail(createCard.getData());

                        customerRepository.update(customer);

                        return F.Promise.pure(ok(Json.toJson(new dto.partnerV2.SuccessAPIV2Response(true))));
                    } else {
                        return F.Promise.pure(createCardProviderException(res.getResult().getCode()));
                    }
                });
            } else if (createCard.getType().equalsIgnoreCase("phone")) {
                return accomplishService.updateUserPhone(acc.get().getReferral(), createCard.getData(), "" + authData.getAccount().getId()).flatMap(res -> {
                    if (res.getResult().getCode().equalsIgnoreCase("0000")) {

//                        Customer customer = acc.get();
//
//                        customer.setEmail(createCard.getData());
//
//                        customerRepository.update(customer);

                        return F.Promise.pure(ok(Json.toJson(new dto.partnerV2.SuccessAPIV2Response(true))));
                    } else {
                        return F.Promise.pure(createCardProviderException(res.getResult().getCode()));
                    }
                });
            }

            return returnPromise;
        });

        return returnRecover(result);

    }


    @With(BaseMerchantApiV2Action.class)
    @ApiOperation(
            nickname = "getPinImage",
            value = "Get PIN image",
            notes = "Method allows to obtain PIN image",
            produces = "application/json",
            consumes = "application/json",
            httpMethod = "POST",
            response = GetPINImageCardResponse.class
    )

    @ApiResponses(value = {
            @ApiResponse(code = SUCCESS_CODE, message = SUCCESS_TEXT, response = GetPINImageCardResponse.class),
            @ApiResponse(code = INCORRECT_AUTHORIZATION_DATA_CODE, message = INCORRECT_AUTHORIZATION_DATA_TEXT, response = BaseAPIV2ErrorResponse.class),
            @ApiResponse(code = INACTIVE_ACCOUNT_CODE, message = INACTIVE_ACCOUNT_TEXT, response = BaseAPIV2ErrorResponse.class),
            @ApiResponse(code = WRONG_REQUEST_FORMAT_CODE, message = WRONG_REQUEST_FORMAT_TEXT, response = BaseAPIV2ErrorResponse.class),
            @ApiResponse(code = WRONG_REQUEST_ENCKEY_CODE, message = WRONG_REQUEST_ENCKEY_TEXT, response = BaseAPIV2ErrorResponse.class),
            @ApiResponse(code = GENERAL_ERROR_CODE, message = GENERAL_ERROR_TEXT, response = BaseAPIV2ErrorResponse.class),
    })
    @ApiImplicitParams(value = {
            @ApiImplicitParam(value = "Get PIN image request", required = true, dataType = "dto.partnerV2.GetPINImageCardRequest", paramType = "body"),
            @ApiImplicitParam(value = "X-Api-Key account ID header", required = true, dataType = "String", paramType = "header", name = "X-Api-Key"),
            @ApiImplicitParam(value = "X-Request-Hash message digest header. Base64(sha1(RequestNonce+Api Secret))",
                    required = true, dataType = "String", paramType = "header", name = "X-Request-Hash"),
            @ApiImplicitParam(value = "X-Request-Nonce orderID header", required = true, dataType = "String", paramType = "header", name = "X-Request-Nonce")})
    public F.Promise<Result> getPinImage() {

        final Authentication authData = (Authentication) ctx().args.get("authData");

        final JsonNode jsonNode = request().body().asJson();
        final GetPINImageCardRequest createCard;
        try {
            createCard = Json.fromJson(jsonNode, GetPINImageCardRequest.class);
        } catch (Exception ex) {
            Logger.error("Wrong request format: ", ex);
            return F.Promise.pure(createWrongRequestFormatResponse("Wrong request format"));
        }

        if (StringUtils.isBlank(createCard.getToken())
        ) {
            Logger.error("Missing params");
            return F.Promise.pure(createWrongRequestFormatResponse("Missing request params: token"));
        }

        F.Promise<Optional<Card>> senderCardPromise = F.Promise.wrap(cardRepository.retrieveByToken(createCard.getToken()));
        F.Promise<GetAccountResponse> accountPromise = accomplishService.getAccount(createCard.getToken(), "" + authData.getAccount().getId());

        final F.Promise<Result> result = senderCardPromise.zip(accountPromise).flatMap(acc -> {

            F.Promise<Result> returnPromise = null;


            if (acc._2.getResult().getCode().equalsIgnoreCase("0000")) {


                returnPromise =
                        F.Promise.pure(ok(Json.toJson(new dto.partnerV2.GetPINImageCardResponse(acc._2.getInfo().getSecurity().getPin_code()))));
            } else {
                returnPromise = F.Promise.pure(createCardProviderException(acc._2.getResult().getCode()));
            }

            return returnPromise;
        });

        return returnRecover(result);
    }

    @With(BaseMerchantApiV2Action.class)
    @ApiOperation(
            nickname = "getTransactions",
            value = "Get transactions",
            notes = "Method allows to obtain card transactions",
            produces = "application/json",
            consumes = "application/json",
            httpMethod = "POST",
            response = TransactionResponse.class
    )

    @ApiResponses(value = {
            @ApiResponse(code = SUCCESS_CODE, message = SUCCESS_TEXT, response = TransactionResponse.class),
            @ApiResponse(code = INCORRECT_AUTHORIZATION_DATA_CODE, message = INCORRECT_AUTHORIZATION_DATA_TEXT, response = BaseAPIV2ErrorResponse.class),
            @ApiResponse(code = INACTIVE_ACCOUNT_CODE, message = INACTIVE_ACCOUNT_TEXT, response = BaseAPIV2ErrorResponse.class),
            @ApiResponse(code = WRONG_REQUEST_FORMAT_CODE, message = WRONG_REQUEST_FORMAT_TEXT, response = BaseAPIV2ErrorResponse.class),
            @ApiResponse(code = WRONG_REQUEST_ENCKEY_CODE, message = WRONG_REQUEST_ENCKEY_TEXT, response = BaseAPIV2ErrorResponse.class),
            @ApiResponse(code = GENERAL_ERROR_CODE, message = GENERAL_ERROR_TEXT, response = BaseAPIV2ErrorResponse.class),
    })
    @ApiImplicitParams(value = {
            @ApiImplicitParam(value = "Get transaction request", required = true, dataType = "dto.partnerV2.TransactionRequest", paramType = "body"),
            @ApiImplicitParam(value = "X-Api-Key account ID header", required = true, dataType = "String", paramType = "header", name = "X-Api-Key"),
            @ApiImplicitParam(value = "X-Request-Hash message digest header. Base64(sha1(RequestNonce+Api Secret))",
                    required = true, dataType = "String", paramType = "header", name = "X-Request-Hash"),
            @ApiImplicitParam(value = "X-Request-Nonce orderID header", required = true, dataType = "String", paramType = "header", name = "X-Request-Nonce")})
    public F.Promise<Result> getTransactions() {

        final Authentication authData = (Authentication) ctx().args.get("authData");

        final JsonNode jsonNode = request().body().asJson();
        final TransactionRequest createCard;
        try {
            createCard = Json.fromJson(jsonNode, TransactionRequest.class);
        } catch (Exception ex) {
            Logger.error("Wrong request format: ", ex);
            return F.Promise.pure(createWrongRequestFormatResponse("Wrong request format"));
        }

        if (StringUtils.isBlank(createCard.getToken())
        ) {
            Logger.error("Missing params");
            return F.Promise.pure(createWrongRequestFormatResponse("Missing request params: token"));
        }

        int offset = 0;
        int limit = 0;
        String dateFrom = null;
        String dateTo = null;


        if (StringUtils.isNotBlank(createCard.getOffset())) {
            try {
                offset = Integer.parseInt(createCard.getOffset());
            } catch (Exception e) {
                Logger.error("Parse error", e);
            }
        }

        if (StringUtils.isNotBlank(createCard.getLimit())) {
            try {
                limit = Integer.parseInt(createCard.getLimit());
            } catch (Exception e) {
                Logger.error("Parse error", e);
            }
        }

        if (StringUtils.isNotBlank(createCard.getDateStart())) {
            try {
                dateFrom = createCard.getDateStart();
            } catch (Exception e) {
                Logger.error("Parse error", e);
            }
        }

        if (StringUtils.isNotBlank(createCard.getDateEnd())) {
            try {
                dateTo = createCard.getDateEnd();
            } catch (Exception e) {
                Logger.error("Parse error", e);
            }
        }


        F.Promise<Optional<Card>> senderCardPromise = F.Promise.wrap(cardRepository.retrieveByToken(createCard.getToken()));
        F.Promise<GetAccountResponse> accountPromise = accomplishService.getAccount(createCard.getToken(), "" + authData.getAccount().getId());

        int finalLimit = limit;
        int finalOffset = offset;
        String finalDateFrom = dateFrom;
        String finalDateTo = dateTo;
        final F.Promise<Result> result = senderCardPromise.zip(accountPromise).flatMap(acc -> {

            F.Promise<Result> returnPromise = null;


            if (acc._2.getResult().getCode().equalsIgnoreCase("0000")) {

                returnPromise = accomplishService.getTransaction("" + acc._2.getInfo().getUserId(), createCard.getToken(), finalLimit,
                        finalOffset, finalDateFrom, finalDateTo, "" + authData.getAccount().getId()).flatMap(res -> {

                    F.Promise<Result> promise = null;


                    if (acc._2.getResult().getCode().equalsIgnoreCase("0000")) {

                        TransactionResponse transactionResponse = new TransactionResponse();

                        List<Transaction> transactions = new ArrayList<>();

                        for (accomplish.dto.transaction.Transaction transaction: res.getTransactions()) {

                            Transaction resTransaction = new Transaction();

                            resTransaction.setAmount(Double.parseDouble(transaction.getInfo().getAmount()));
                            resTransaction.setBalance(Double.parseDouble(transaction.getInfo().getBalance()));
                            resTransaction.setCurrency(transaction.getInfo().getCurrency());
                            resTransaction.setDesc(transaction.getInfo().getNotes());
                            resTransaction.setDirection(transaction.getInfo().getOperation());
                            resTransaction.setLocalDate((int)DateUtil.parse(transaction.getInfo().getServerDate(), "yyyy-MM-dd'T'HH:mm:ss").getTime());
                            resTransaction.setSettlementDate((int)DateUtil.parse(transaction.getInfo().getServerDate(), "yyyy-MM-dd'T'HH:mm:ss").getTime());

                            resTransaction.setOriginalAmount(Double.parseDouble(transaction.getConversion().getOriginalAmount()));
                            resTransaction.setOriginalCurrency(transaction.getConversion().getTransactionCurrency());
                            resTransaction.setType(transaction.getInfo().getOperation());
                            resTransaction.setOriginalSourceId(transaction.getInfo().getOriginalSourceId());

                            transactions.add(resTransaction);
                        }

                        transactionResponse.setFrom(res.getResultSet().getFromDate());
                        transactionResponse.setTo(res.getResultSet().getToDate());
                        transactionResponse.setCount("" + res.getResultSet().getTotalRecords());

                        transactionResponse.setTransactions(transactions);

                        promise =
                                F.Promise.pure(ok(Json.toJson(transactionResponse)));
                    } else {
                        promise = F.Promise.pure(createCardProviderException(acc._2.getResult().getCode()));
                    }

                    return promise;

                });

            } else {
                returnPromise = F.Promise.pure(createCardProviderException(acc._2.getResult().getCode()));
            }

            return returnPromise;
        });

        return returnRecover(result);
    }


}
