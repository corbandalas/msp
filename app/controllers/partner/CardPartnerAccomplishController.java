package controllers.partner;

import accomplish.dto.account.GetAccountResponse;
import accomplish.dto.account.info.GetAccountInfoResponse;
import accomplish.dto.account.update.response.UpdateAccountResponse;
import accomplish.dto.customerget.*;
import accomplish.dto.customerget.GetCustomerResponse;
import accomplish.dto.user.CreateUserResponse;
import accomplish.dto.user.update.address.response.AddressRequestBean;
import com.fasterxml.jackson.databind.JsonNode;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.inject.Inject;
import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;
import com.wordnik.swagger.annotations.*;
import configs.Constants;
import controllers.BaseAccomplishController;
import controllers.admin.BaseMerchantApiV2Action;
import dto.Authentication;
import dto.partnerV2.*;
import dto.partnerV2.Transaction;
import dto.partnerV2.entity.CustomerV2;
import dto.partnerV2.entity.CustomerV3;
import dto.partnerV2.entity.Document;
import exception.CustomerAlreadyRegisteredException;
import exception.WrongCountryException;
import model.*;
import model.Currency;
import model.enums.CardBrand;
import model.enums.CardType;
import model.enums.KYC;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.text.StringEscapeUtils;
import play.Logger;
import play.libs.F;
import play.libs.Json;
import play.mvc.Result;
import play.mvc.With;
import provider.CardProvider;
import repository.*;
import services.AccomplishService;
import services.CacheProvider;
import services.OperationService;
import util.DateUtil;
import util.SecurityUtil;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

import static configs.ReturnCodes.*;


/**
 * Partner card provider API controller
 *
 * @author corbandalas created 02.07.2020.
 * @since 0.6.0
 */
@Api(value = Constants.PARTNERV2_API_PATH, description = "Partner API Accomplish Integration")
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

    @Inject
    WalletTransactionRepository walletTransactionRepository;

    @Inject
    TransactionRepository transactionRepository;

    @With(BaseMerchantApiV2Action.class)
    @ApiOperation(
            nickname = "newCustomer",
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
    public F.Promise<Result> newCustomer() {

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
        customer.setCity(createCard.getCity());
        customer.setEmail(createCard.getEmail());
        customer.setCountry_id(createCard.getCountry());
        customer.setPostcode(createCard.getZip());
        customer.setTitle(createCard.getTitle());
        customer.setActive(true);
        customer.setId(StringUtils.removeStart(createCard.getMobilePhone(), "+"));
        customer.setPhone2(StringUtils.removeStart(createCard.getMobilePhone(), "+"));
        customer.setFlat("");
        customer.setHouseNameNumber("");
        customer.setAccountID(authData.getAccount().getId().toString());
        customer.setTemppassword(false);
        if (StringUtils.isNotBlank(createCard.getCdata1())) {
            customer.setCdata(createCard.getCdata1());
        }

//        if (StringUtils.isNotBlank(createCard.getCdata2())) {
//            customer.setCdata2(createCard.getCdata2());
//        }

        String cdata = "";

        if (createCard.getCdata2() instanceof String) {

            cdata = (String) createCard.getCdata2();

        } else {
            java.util.LinkedHashMap data = (java.util.LinkedHashMap) createCard.getCdata2();
            cdata = data.toString();

        }

        Logger.info("CDATA2 = " + cdata);

        if (StringUtils.isNotBlank(cdata)) {

            cdata = StringEscapeUtils.unescapeJson(cdata);

            cdata = StringUtils.remove(cdata, "{");
            cdata = StringUtils.remove(cdata, "}");
            cdata = StringUtils.remove(cdata, "\"");

            customer.setCdata2(cdata);
        }

        Logger.info("CDATA2 = " + cdata);


        if (StringUtils.isNotBlank(createCard.getCdata3())) {
            customer.setCdata3(createCard.getCdata3());
        }

        if (StringUtils.isNoneBlank(createCard.getPassword())) {
            customer.setPassword(SecurityUtil.generateKeyFromArray(createCard.getPassword()));
        } else {
            customer.setPassword(SecurityUtil.generateKeyFromArray(RandomStringUtils.random(8)).substring(0, 8));
        }


        String formatDate = "";
        try {

            KYC kyc = KYC.SIMPLIFIED_DUE_DILIGENCE;

            if (createCard.getKycLevel().equalsIgnoreCase("fdd")) {
                kyc = KYC.FULL_DUE_DILIGENCE;
            }

            customer.setKyc(kyc);

            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");

            Date dob = simpleDateFormat.parse(createCard.getBirthdayDate());

            Logger.info("DOB date = " + dob.toString());

            customer.setDateBirth(dob);
            customer.setRegistrationDate(new Date());

            simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd");

            formatDate = simpleDateFormat.format(dob);


        } catch (Exception ex) {
            Logger.error("Wrong request format: ", ex);
            return F.Promise.pure(createWrongRequestFormatResponse("Wrong date format"));
        }

        F.Promise<F.Tuple<F.Tuple<Optional<Country>, List<Customer>>, Boolean>> promise = F.Promise.wrap(countryRepository.retrieveById(createCard.getCountry()))
                .zip(F.Promise.wrap(customerRepository.retrieveByEmail(createCard.getEmail()))).zip(F.Promise.wrap(customerRepository.isRegistered(StringUtils.removeStart(createCard.getMobilePhone(), "+"))));

        final String finalFormatDate = formatDate;
        String finalCdata = cdata;
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


            F.Promise<CreateUserResponse> userResponsePromise = accomplishService.createUser(createCard.getCurrency(), createCard.getEmail(), createCard.getTitle(), createCard.getFirstName(),
                    createCard.getLastName(), /*createCard.getBirthdayDate()*/ finalFormatDate, createCard.getMobilePhone(),
                    createCard.getNationality(), createCard.getKycLevel(), createCard.getAddress1(),
                    createCard.getAddress2(), createCard.getCity(), createCard.getZip(), country.get().getCode(),
                    createCard.getLang(), customer.getPassword(), createCard.getCdata1(), finalCdata, createCard.getCdata3(), "" + authData.getAccount().getId());


            return userResponsePromise.map(rez -> {

                if (rez.getResult().getCode().equalsIgnoreCase("0000")) {
                    customer.setReferral("" + rez.getInfo().getId());

                    F.Promise.wrap(customerRepository.create(customer)).get(10000);

                    return ok(Json.toJson(new CreateCustomerResponse(new CustomerV2(createCard.getEmail(), createCard.getTitle(), createCard.getFirstName(),
                            createCard.getLastName(), createCard.getBirthdayDate(), createCard.getMobilePhone(),
                            createCard.getNationality(), createCard.getKycLevel(), country.get().getId(), createCard.getAddress1(),
                            createCard.getAddress2(), createCard.getCity(), createCard.getZip()))));
                } else {
                    return createCardProviderException("" + rez.getResult().getCode(), rez.getResult().getMessage());
                }

            });

        });


        return returnRecover(result);
    }


    @With(BaseMerchantApiV2Action.class)
    @ApiOperation(
            nickname = "newCustomerSimple",
            value = "Create new customer(only card provider invocation)",
            notes = "Method allows to create new customer(only card provider API create user invocation)",
            produces = "application/json",
            consumes = "application/json",
            httpMethod = "POST",
            response = CreateCustomerSimpleResponse.class
    )

    @ApiResponses(value = {
            @ApiResponse(code = SUCCESS_CODE, message = SUCCESS_TEXT, response = CreateCustomerSimpleResponse.class),
            @ApiResponse(code = INCORRECT_AUTHORIZATION_DATA_CODE, message = INCORRECT_AUTHORIZATION_DATA_TEXT, response = BaseAPIV2ErrorResponse.class),
            @ApiResponse(code = INACTIVE_ACCOUNT_CODE, message = INACTIVE_ACCOUNT_TEXT, response = BaseAPIV2ErrorResponse.class),
            @ApiResponse(code = WRONG_REQUEST_FORMAT_CODE, message = WRONG_REQUEST_FORMAT_TEXT, response = BaseAPIV2ErrorResponse.class),
            @ApiResponse(code = WRONG_REQUEST_ENCKEY_CODE, message = WRONG_REQUEST_ENCKEY_TEXT, response = BaseAPIV2ErrorResponse.class),
            @ApiResponse(code = GENERAL_ERROR_CODE, message = GENERAL_ERROR_TEXT, response = BaseAPIV2ErrorResponse.class),
    })
    @ApiImplicitParams(value = {
            @ApiImplicitParam(value = "Create customer simplified request", required = true, dataType = "dto.partnerV2.CreateCustomerSimpleRequest", paramType = "body"),
            @ApiImplicitParam(value = "X-Api-Key account ID header", required = true, dataType = "String", paramType = "header", name = "X-Api-Key"),
            @ApiImplicitParam(value = "X-Request-Hash message digest header. Base64(sha1(RequestNonce+Api Secret))",
                    required = true, dataType = "String", paramType = "header", name = "X-Request-Hash"),
            @ApiImplicitParam(value = "X-Request-Nonce orderID header", required = true, dataType = "String", paramType = "header", name = "X-Request-Nonce")})
    public F.Promise<Result> newCustomerSimple() {

        final Authentication authData = (Authentication) ctx().args.get("authData");

        final JsonNode jsonNode = request().body().asJson();
        final CreateCustomerSimpleRequest createCard;
        try {
            createCard = Json.fromJson(jsonNode, CreateCustomerSimpleRequest.class);
        } catch (Exception ex) {
            Logger.error("Wrong request format: ", ex);
            return F.Promise.pure(createWrongRequestFormatResponse("Wrong request format. Check your json"));
        }

        if (
                StringUtils.isBlank(createCard.getEmail()) || StringUtils.isBlank(createCard.getPassword())
        ) {
            Logger.error("Missing params");
            return F.Promise.pure(createWrongRequestFormatResponse("Missing params. Check API docs"));
        }

        F.Promise<F.Tuple<F.Tuple<Optional<Country>, List<Customer>>, Boolean>> promise = F.Promise.wrap(countryRepository.retrieveById(createCard.getCountry()))
                .zip(F.Promise.wrap(customerRepository.retrieveByEmail(createCard.getEmail()))).zip(F.Promise.wrap(customerRepository.isRegistered(StringUtils.removeStart(createCard.getPhone(), "+"))));
        F.Promise<Result> result = promise.flatMap(res -> {

            if (res != null && res._1._2.size() > 0) {
                Logger.error("Customer is already registered");

                throw new CustomerAlreadyRegisteredException("Customer is already registered");
            }

            if (res._2) {
                Logger.error("Customer is already registered");

                throw new CustomerAlreadyRegisteredException("Customer is already registered");
            }


            F.Promise<CreateUserResponse> userResponsePromise = accomplishService.createUserSimplified(createCard.getEmail(), createCard.getPhone(),  res._1._1.get().getCode(), createCard.getCurrency(),
                    createCard.getPassword(), "" + authData.getAccount().getId());

            return userResponsePromise.map(rez -> {

                if (rez.getResult().getCode().equalsIgnoreCase("0000")) {
//

                    return ok(Json.toJson(new CreateCustomerSimpleResponse("" + rez.getInfo().getId())));
                } else {
                    return createCardProviderException("" + rez.getResult().getCode(), rez.getResult().getMessage());
                }

            });

        });

        return returnRecover(result);
    }


    @With(BaseMerchantApiV2Action.class)
    @ApiOperation(
            nickname = "connectCustomer",
            value = "Connect existed card provider customer",
            notes = "Method allows to connect existed card provider customer",
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
            @ApiImplicitParam(value = "Connect customer request", required = true, dataType = "dto.partnerV2.ConnectCustomerRequest", paramType = "body"),
            @ApiImplicitParam(value = "X-Api-Key account ID header", required = true, dataType = "String", paramType = "header", name = "X-Api-Key"),
            @ApiImplicitParam(value = "X-Request-Hash message digest header. Base64(sha1(RequestNonce+Api Secret))",
                    required = true, dataType = "String", paramType = "header", name = "X-Request-Hash"),
            @ApiImplicitParam(value = "X-Request-Nonce orderID header", required = true, dataType = "String", paramType = "header", name = "X-Request-Nonce")})
    public F.Promise<Result> connectCustomer() {

        final Authentication authData = (Authentication) ctx().args.get("authData");

        final JsonNode jsonNode = request().body().asJson();
        final ConnectCustomerRequest createCard;
        try {
            createCard = Json.fromJson(jsonNode, ConnectCustomerRequest.class);
        } catch (Exception ex) {
            Logger.error("Wrong request format: ", ex);
            return F.Promise.pure(createWrongRequestFormatResponse("Wrong request format. Check your json"));
        }

        if (StringUtils.isBlank(createCard.getUserID())
        ) {
            Logger.error("Missing params");
            return F.Promise.pure(createWrongRequestFormatResponse("Missing params. Check API docs"));
        }


        F.Promise<Result> result = accomplishService.getCustomer(createCard.getUserID(), "" + authData.getAccount().getId())
                .flatMap(res -> {

                    F.Promise<Result> returnPromise = null;

                    if (res.getResult().getCode().equalsIgnoreCase("0000")) {

                        F.Promise<Optional<Country>> countryPromise = F.Promise.wrap(countryRepository.retrieveByCode(res.getAddress().getCountryCode()));

                        returnPromise = countryPromise.map(rezz -> {

                            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

                            Date date = simpleDateFormat.parse(
                                    res.getPersonalInfo().getDateOfBirth());


                            Logger.info("DOB date = " + date);

                            String titleValue = "Mr";

                            if (res.getPersonalInfo().getTitle().equalsIgnoreCase("1")) {
                                titleValue = "Mr";
                            } else if (res.getPersonalInfo().getTitle().equalsIgnoreCase("10")) {
                                titleValue = "Mrs";
                            } else if (res.getPersonalInfo().getTitle().equalsIgnoreCase("11")) {
                                titleValue = "Ms";
                            }

                            String kycStatus = "";

                            switch (res.getSecurity().getTrustLevel()) {
                                case "1":
                                    kycStatus = "none";
                                    break;
                                case "3":
                                    kycStatus = "sdd";
                                    break;
                                case "5":
                                    kycStatus = "fdd";
                                    break;
                                default:
                                    kycStatus = "none";
                                    break;

                            }

                            KYC kyc = KYC.SIMPLIFIED_DUE_DILIGENCE;

                            if (kycStatus.equalsIgnoreCase("fdd")) {
                                kyc = KYC.FULL_DUE_DILIGENCE;
                            }


                            Customer customer = new Customer();

                            customer.setFirstName(res.getPersonalInfo().getFirstName());
                            customer.setLastName(res.getPersonalInfo().getLastName());
                            customer.setAddress1(res.getAddress().getAddressLine1());
                            customer.setAddress2(res.getAddress().getAddressLine2());
                            customer.setCity(res.getAddress().getCityTown());
                            customer.setEmail(res.getEmail().get(0).getAddress());
                            customer.setCountry_id(rezz.get().getId());
                            customer.setPostcode(res.getAddress().getPostalZipCode());
                            customer.setTitle(titleValue);
                            customer.setActive(true);
                            customer.setId(StringUtils.removeStart(res.getPhone().get(0).getNumber(), "+"));
                            customer.setPhone2(StringUtils.removeStart(res.getPhone().get(0).getNumber(), "+"));
                            customer.setFlat("");
                            customer.setHouseNameNumber("");
                            customer.setAccountID(authData.getAccount().getId().toString());
                            customer.setTemppassword(false);
                            customer.setCdata(res.getEmail().get(0).getAddress());
                            customer.setKyc(kyc);
                            customer.setPassword(SecurityUtil.generateKeyFromArray(RandomStringUtils.random(8)).substring(0, 8));

                            customer.setDateBirth(date);
                            customer.setRegistrationDate(new Date());

                            simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd");

                            customer.setReferral("" + res.getInfo().getId());

                            F.Promise.wrap(customerRepository.create(customer)).get(10000);


                            return ok(Json.toJson(new GetCustomerAPIResponse(new CustomerV3(res.getEmail().get(0).getAddress(),
                                    titleValue, res.getPersonalInfo().getFirstName(),
                                    res.getPersonalInfo().getLastName(), simpleDateFormat.format(date),
                                    res.getPhone().get(0).getNumber(), rezz.get().getId(), kycStatus,
                                    rezz.get().getId(), res.getAddress().getAddressLine1(), res.getAddress().getAddressLine2(),
                                    res.getAddress().getCityTown(), res.getAddress().getPostalZipCode()))));
                        });
                    } else {
                        returnPromise = F.Promise.pure(createCardProviderException("" + res.getResult().getCode(), res.getResult().getMessage()));
                    }

                    return returnPromise;


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
                StringUtils.isBlank(createCard.getMobilePhone()) ||
                StringUtils.isBlank(createCard.getCdata1())
        ) {
            Logger.error("Missing params");
            return F.Promise.pure(createWrongRequestFormatResponse("Missing request params"));
        }

        F.Promise<Optional<Customer>> customerPromise = F.Promise.wrap(customerRepository.retrieveById(StringUtils.removeStart(createCard.getMobilePhone(), "+"), createCard.getCdata1()));

        F.Promise<Optional<Country>> issuanceCountry = F.Promise.wrap(countryRepository.retrieveById(createCard.getIssuanceCountry()));

        F.Promise<Optional<Country>> residanceCuntry = F.Promise.wrap(countryRepository.retrieveById(createCard.getResidenceCountry()));

        F.Promise<Result> result = issuanceCountry.zip(customerPromise).zip(residanceCuntry).flatMap(customers -> accomplishService.createIdentification(customers._1._2.get().getReferral(), customers._1._1.get().getCode(),
                customers._2.get().getCode(), createCard.getIssueDate(), createCard.getExpiryDate(),
                createCard.getType(), createCard.getNumber(), "" + authData.getAccount().getId())
                .map(res -> {

                    if (res.getResult().getCode().equalsIgnoreCase("0000")) {
                        return ok(Json.toJson(new CreateCustomerIdentificationResponse("" + res.getIdentification().get(0).getId())));
                    } else {
                        return createCardProviderException("" + res.getResult().getCode(), res.getResult().getMessage());
                    }
                }));

        return returnRecover(result);
    }


    @With(BaseMerchantApiV2Action.class)
    @ApiOperation(
            nickname = "checkPassword",
            value = "Check card provider user password ",
            notes = "Method allows to check card provider user password",
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
            @ApiImplicitParam(value = "Check password  request", required = true, dataType = "dto.partnerV2.CheckCardProviderPasswordRequest", paramType = "body"),
            @ApiImplicitParam(value = "X-Api-Key account ID header", required = true, dataType = "String", paramType = "header", name = "X-Api-Key"),
            @ApiImplicitParam(value = "X-Request-Hash message digest header. Base64(sha1(RequestNonce+Api Secret))",
                    required = true, dataType = "String", paramType = "header", name = "X-Request-Hash"),
            @ApiImplicitParam(value = "X-Request-Nonce orderID header", required = true, dataType = "String", paramType = "header", name = "X-Request-Nonce")})
    public F.Promise<Result> checkPassword() {

        final Authentication authData = (Authentication) ctx().args.get("authData");

        final JsonNode jsonNode = request().body().asJson();
        final CheckCardProviderPasswordRequest createCard;
        try {
            createCard = Json.fromJson(jsonNode, CheckCardProviderPasswordRequest.class);
        } catch (Exception ex) {
            Logger.error("Wrong request format: ", ex);
            return F.Promise.pure(createWrongRequestFormatResponse("Wrong request format"));
        }

        if (StringUtils.isBlank(createCard.getPassword()) ||
                StringUtils.isBlank(createCard.getEmail()))
        {
            Logger.error("Missing params");
            return F.Promise.pure(createWrongRequestFormatResponse("Missing request params"));
        }

        F.Promise<List<Customer>> customerPromise = F.Promise.wrap(customerRepository.retrieveByEmail(createCard.getEmail(), "" + authData.getAccount().getId()));

        F.Promise<Result> result = customerPromise.flatMap(customers -> accomplishService.validatePassword(customers.get(0).getReferral(), createCard.getPassword(), "" + authData.getAccount().getId())
                .map(res -> {

                    if (res.getResult().getCode().equalsIgnoreCase("0000")) {
                        return ok(Json.toJson(new CheckCardProviderCustomerPasswordResponse(customers.get(0).getFirstName(), customers.get(0).getLastName())));
                    } else {
                        return createCardProviderException("" + res.getResult().getCode(), res.getResult().getMessage());
                    }
                }));

        return returnRecover(result);
    }

    @With(BaseMerchantApiV2Action.class)
    @ApiOperation(
            nickname = "getLimits",
            value = "Get card provider card limits",
            notes = "Method allows to get card provider card limits",
            produces = "application/json",
            consumes = "application/json",
            httpMethod = "POST",
            response = LimitsResponse.class
    )
    @ApiResponses(value = {
            @ApiResponse(code = SUCCESS_CODE, message = SUCCESS_TEXT, response = LimitsResponse.class),
            @ApiResponse(code = INCORRECT_AUTHORIZATION_DATA_CODE, message = INCORRECT_AUTHORIZATION_DATA_TEXT, response = BaseAPIV2ErrorResponse.class),
            @ApiResponse(code = INACTIVE_ACCOUNT_CODE, message = INACTIVE_ACCOUNT_TEXT, response = BaseAPIV2ErrorResponse.class),
            @ApiResponse(code = WRONG_REQUEST_FORMAT_CODE, message = WRONG_REQUEST_FORMAT_TEXT, response = BaseAPIV2ErrorResponse.class),
            @ApiResponse(code = WRONG_REQUEST_ENCKEY_CODE, message = WRONG_REQUEST_ENCKEY_TEXT, response = BaseAPIV2ErrorResponse.class),
            @ApiResponse(code = GENERAL_ERROR_CODE, message = GENERAL_ERROR_TEXT, response = BaseAPIV2ErrorResponse.class),
    })
    @ApiImplicitParams(value = {
            @ApiImplicitParam(value = "Get limits request", required = true, dataType = "dto.partnerV2.LimitsRequest", paramType = "body"),
            @ApiImplicitParam(value = "X-Api-Key account ID header", required = true, dataType = "String", paramType = "header", name = "X-Api-Key"),
            @ApiImplicitParam(value = "X-Request-Hash message digest header. Base64(sha1(RequestNonce+Api Secret))",
                    required = true, dataType = "String", paramType = "header", name = "X-Request-Hash"),
            @ApiImplicitParam(value = "X-Request-Nonce orderID header", required = true, dataType = "String", paramType = "header", name = "X-Request-Nonce")})
    public F.Promise<Result> getLimits() {

        final Authentication authData = (Authentication) ctx().args.get("authData");

        final JsonNode jsonNode = request().body().asJson();
        final LimitsRequest createCard;
        try {
            createCard = Json.fromJson(jsonNode, LimitsRequest.class);
        } catch (Exception ex) {
            Logger.error("Wrong request format: ", ex);
            return F.Promise.pure(createWrongRequestFormatResponse("Wrong request format"));
        }

        if (StringUtils.isBlank(createCard.getToken()))
        {
            Logger.error("Missing params");
            return F.Promise.pure(createWrongRequestFormatResponse("Missing request params"));
        }

        F.Promise<Result> result =  accomplishService.getLimits(createCard.getToken(), "" + authData.getAccount().getId())
                .map(res -> {

                    if (res.getResult().getCode().equalsIgnoreCase("0000")) {
                        return ok(Json.toJson(new LimitsResponse(res)));
                    } else {
                        return createCardProviderException("" + res.getResult().getCode(), res.getResult().getMessage());
                    }
                });

        return returnRecover(result);
    }

    @With(BaseMerchantApiV2Action.class)
    @ApiOperation(
            nickname = "resetPassword",
            value = "Reset card provider user password ",
            notes = "Method allows to reset card provider user password",
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
            @ApiImplicitParam(value = "Reset password  request", required = true, dataType = "dto.partnerV2.ResetCardProviderPasswordRequest", paramType = "body"),
            @ApiImplicitParam(value = "X-Api-Key account ID header", required = true, dataType = "String", paramType = "header", name = "X-Api-Key"),
            @ApiImplicitParam(value = "X-Request-Hash message digest header. Base64(sha1(RequestNonce+Api Secret))",
                    required = true, dataType = "String", paramType = "header", name = "X-Request-Hash"),
            @ApiImplicitParam(value = "X-Request-Nonce orderID header", required = true, dataType = "String", paramType = "header", name = "X-Request-Nonce")})
    public F.Promise<Result> resetPassword() {

        final Authentication authData = (Authentication) ctx().args.get("authData");

        final JsonNode jsonNode = request().body().asJson();
        final ResetCardProviderPasswordRequest createCard;
        try {
            createCard = Json.fromJson(jsonNode, ResetCardProviderPasswordRequest.class);
        } catch (Exception ex) {
            Logger.error("Wrong request format: ", ex);
            return F.Promise.pure(createWrongRequestFormatResponse("Wrong request format"));
        }

        if (
                StringUtils.isBlank(createCard.getEmail()))
        {
            Logger.error("Missing params");
            return F.Promise.pure(createWrongRequestFormatResponse("Missing request params"));
        }

        F.Promise<List<Customer>> customerPromise = F.Promise.wrap(customerRepository.retrieveByEmail(createCard.getEmail(), "" + authData.getAccount().getId()));

        F.Promise<Result> result = customerPromise.flatMap(customers -> accomplishService.resetPassword(customers.get(0).getReferral(), customers.get(0).getEmail(), "" + authData.getAccount().getId())
                .map(res -> {

                    if (res.getResult().getCode().equalsIgnoreCase("0000")) {
                        return ok(Json.toJson(new SuccessAPIV2Response(true)));
                    } else {
                        return createCardProviderException("" + res.getResult().getCode(), res.getResult().getMessage());
                    }
                }));

        return returnRecover(result);
    }


    @With(BaseMerchantApiV2Action.class)
    @ApiOperation(
            nickname = "resetPassword2",
            value = "Reset card provider user password ",
            notes = "Method allows to reset card provider user password",
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
            @ApiImplicitParam(value = "Reset password  request", required = true, dataType = "dto.partnerV2.ResetCardProviderPasswordRequest2", paramType = "body"),
            @ApiImplicitParam(value = "X-Api-Key account ID header", required = true, dataType = "String", paramType = "header", name = "X-Api-Key"),
            @ApiImplicitParam(value = "X-Request-Hash message digest header. Base64(sha1(RequestNonce+Api Secret))",
                    required = true, dataType = "String", paramType = "header", name = "X-Request-Hash"),
            @ApiImplicitParam(value = "X-Request-Nonce orderID header", required = true, dataType = "String", paramType = "header", name = "X-Request-Nonce")})
    public F.Promise<Result> resetPassword2() {

        final Authentication authData = (Authentication) ctx().args.get("authData");

        final JsonNode jsonNode = request().body().asJson();
        final ResetCardProviderPasswordRequest2 createCard;
        try {
            createCard = Json.fromJson(jsonNode, ResetCardProviderPasswordRequest2.class);
        } catch (Exception ex) {
            Logger.error("Wrong request format: ", ex);
            return F.Promise.pure(createWrongRequestFormatResponse("Wrong request format"));
        }

        if (
                StringUtils.isBlank(createCard.getEmail()) || StringUtils.isBlank(createCard.getCurrentPassword()) || StringUtils.isBlank(createCard.getNewPassword()))
        {
            Logger.error("Missing params");
            return F.Promise.pure(createWrongRequestFormatResponse("Missing request params"));
        }

        F.Promise<List<Customer>> customerPromise = F.Promise.wrap(customerRepository.retrieveByEmail(createCard.getEmail(), "" + authData.getAccount().getId()));

        F.Promise<Result> result = customerPromise.flatMap(customers -> accomplishService.resetPassword(customers.get(0).getReferral(), createCard.getCurrentPassword(), createCard.getNewPassword()    , "" + authData.getAccount().getId())
                .map(res -> {

                    if (res.getResult().getCode().equalsIgnoreCase("0000")) {
                        return ok(Json.toJson(new SuccessAPIV2Response(true)));
                    } else {
                        return createCardProviderException("" + res.getResult().getCode(), res.getResult().getMessage());
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
                StringUtils.isBlank(createCard.getMobilePhone()) ||
                StringUtils.isBlank(createCard.getCdata1())
        ) {
            Logger.error("Missing params");
            return F.Promise.pure(createWrongRequestFormatResponse("Missing request params"));
        }

        F.Promise<Optional<Customer>> customerPromise = F.Promise.wrap(customerRepository.retrieveById(StringUtils.removeStart(createCard.getMobilePhone(), "+"), createCard.getCdata1()));


        F.Promise<Result> result = customerPromise.flatMap(customers -> accomplishService.sendDocument(customers.get().getReferral(), createCard.getDocumentName(), createCard.getDocument(),
                createCard.getDocumentType(), createCard.getDocumentExtension(), "" + authData.getAccount().getId())
                .map(res -> {
                    if (res.getResult().getCode().equalsIgnoreCase("0000")) {
                        return ok(Json.toJson(new CreateCustomerDocumentResponse(new Document("" + res.getInfo().getDocumentId(), "" + res.getInfo().getStatus()))));
                    } else {
                        return createCardProviderException("" + res.getResult().getCode(), res.getResult().getMessage());
                    }
                }));

        return returnRecover(result);
    }


    @With(BaseMerchantApiV2Action.class)
    @ApiOperation(
            nickname = "getDocuments",
            value = "Get documents",
            notes = "Method allows to get documents",
            produces = "application/json",
            consumes = "application/json",
            httpMethod = "POST",
            response = GetCustomerDocumentResponse.class
    )

    @ApiResponses(value = {
            @ApiResponse(code = SUCCESS_CODE, message = SUCCESS_TEXT, response = GetCustomerDocumentResponse.class),
            @ApiResponse(code = INCORRECT_AUTHORIZATION_DATA_CODE, message = INCORRECT_AUTHORIZATION_DATA_TEXT, response = BaseAPIV2ErrorResponse.class),
            @ApiResponse(code = INACTIVE_ACCOUNT_CODE, message = INACTIVE_ACCOUNT_TEXT, response = BaseAPIV2ErrorResponse.class),
            @ApiResponse(code = WRONG_REQUEST_FORMAT_CODE, message = WRONG_REQUEST_FORMAT_TEXT, response = BaseAPIV2ErrorResponse.class),
            @ApiResponse(code = WRONG_REQUEST_ENCKEY_CODE, message = WRONG_REQUEST_ENCKEY_TEXT, response = BaseAPIV2ErrorResponse.class),
            @ApiResponse(code = GENERAL_ERROR_CODE, message = GENERAL_ERROR_TEXT, response = BaseAPIV2ErrorResponse.class),
    })
    @ApiImplicitParams(value = {
            @ApiImplicitParam(value = "Create identification request", required = true, dataType = "dto.partnerV2.GetDocumentRequest", paramType = "body"),
            @ApiImplicitParam(value = "X-Api-Key account ID header", required = true, dataType = "String", paramType = "header", name = "X-Api-Key"),
            @ApiImplicitParam(value = "X-Request-Hash message digest header. Base64(sha1(RequestNonce+Api Secret))",
                    required = true, dataType = "String", paramType = "header", name = "X-Request-Hash"),
            @ApiImplicitParam(value = "X-Request-Nonce orderID header", required = true, dataType = "String", paramType = "header", name = "X-Request-Nonce")})
    public F.Promise<Result> getDocument() {

        final Authentication authData = (Authentication) ctx().args.get("authData");

        final JsonNode jsonNode = request().body().asJson();
        final GetDocumentRequest createCard;
        try {
            createCard = Json.fromJson(jsonNode, GetDocumentRequest.class);
        } catch (Exception ex) {
            Logger.error("Wrong request format: ", ex);
            return F.Promise.pure(createWrongRequestFormatResponse("Wrong request format"));
        }

        if (
                StringUtils.isBlank(createCard.getMobilePhone()) ||
                        StringUtils.isBlank(createCard.getCdata1())
        ) {
            Logger.error("Missing params");
            return F.Promise.pure(createWrongRequestFormatResponse("Missing request params"));
        }

        F.Promise<Optional<Customer>> customerPromise = F.Promise.wrap(customerRepository.retrieveById(StringUtils.removeStart(createCard.getMobilePhone(), "+"), createCard.getCdata1()));


        F.Promise<Result> result = customerPromise.flatMap(customers -> accomplishService.getDocument(customers.get().getReferral(), "" + authData.getAccount().getId())
                .map(res -> {
                    if (res.getResult().getCode().equalsIgnoreCase("0000")) {
                        return ok(Json.toJson(new GetCustomerDocumentResponse(res)));
                    } else {
                        return createCardProviderException("" + res.getResult().getCode(), res.getResult().getMessage());
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
            response = GetCustomerAPIResponse.class
    )

    @ApiResponses(value = {
            @ApiResponse(code = SUCCESS_CODE, message = SUCCESS_TEXT, response = GetCustomerAPIResponse.class),
            @ApiResponse(code = INCORRECT_AUTHORIZATION_DATA_CODE, message = INCORRECT_AUTHORIZATION_DATA_TEXT, response = BaseAPIV2ErrorResponse.class),
            @ApiResponse(code = INACTIVE_ACCOUNT_CODE, message = INACTIVE_ACCOUNT_TEXT, response = BaseAPIV2ErrorResponse.class),
            @ApiResponse(code = WRONG_REQUEST_FORMAT_CODE, message = WRONG_REQUEST_FORMAT_TEXT, response = BaseAPIV2ErrorResponse.class),
            @ApiResponse(code = WRONG_REQUEST_ENCKEY_CODE, message = WRONG_REQUEST_ENCKEY_TEXT, response = BaseAPIV2ErrorResponse.class),
            @ApiResponse(code = GENERAL_ERROR_CODE, message = GENERAL_ERROR_TEXT, response = BaseAPIV2ErrorResponse.class),
    })
    @ApiImplicitParams(value = {
            @ApiImplicitParam(value = "Get customer request", required = true, dataType = "dto.partnerV2.GetCustomerRequest", paramType = "body"),
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

        if (StringUtils.isBlank(createCard.getCdata1())
        ) {
            Logger.error("Missing params");
            return F.Promise.pure(createWrongRequestFormatResponse("Missing request params: cdata1"));
        }

        F.Promise<Optional<Customer>> customerPromise = F.Promise.wrap(customerRepository.retrieveById(StringUtils.removeStart(createCard.getMobilePhone(), "+"), createCard.getCdata1()));


        F.Promise<Result> result = customerPromise.flatMap(customers -> accomplishService.getCustomer(customers.get().getReferral(), "" + authData.getAccount().getId())
                .map(res -> {

                    if (res.getResult().getCode().equalsIgnoreCase("0000")) {

//                        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");

                        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

//                        String format = simpleDateFormat.format(customers.get().getDateBirth());

                        Date date = simpleDateFormat.parse(
                                res.getPersonalInfo().getDateOfBirth());

//                        String kyc = "sdd";
//
//                        if (customers.get().getKyc().equals(KYC.FULL_DUE_DILIGENCE)) {
//                            kyc = "fdd";
//                        }


                        Logger.info("DOB date = " + date);

                        simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");

//                        String kycStatus = "";
//
//                        switch(res.getSecurity().getTrustLevel()) {
//                            case "0": kycStatus = "ko"; break;
//                            case "1":
//                            case "2":
//                                kycStatus = "light"; break;
//                            case "3":
//                            case "4":
//                                kycStatus = "full"; break;
//                            case "5":
//                            case "6":
//                            case "7":
//                            case "8":
//                            case "9":
//                            case "10":
//                                kycStatus = "extended"; break;
//                            default:
//                                kycStatus = "pending"; break;
//
//                        }

                        String kycStatus = "";

                        switch (res.getSecurity().getTrustLevel()) {
                            case "1":
                                kycStatus = "none";
                                break;
                            case "3":
                                kycStatus = "sdd";
                                break;
                            case "5":
                                kycStatus = "fdd";
                                break;
                            default:
                                kycStatus = "none";
                                break;

                        }


                        return ok(Json.toJson(new GetCustomerAPIResponse(new CustomerV3(res.getEmail().get(0).getAddress(),
                                customers.get().getTitle(), res.getPersonalInfo().getFirstName(),
                                res.getPersonalInfo().getLastName(), simpleDateFormat.format(date),
                                res.getPhone().get(0).getNumber(), customers.get().getCountry_id(), kycStatus,
                                customers.get().getCountry_id(), res.getAddress().getAddressLine1(), res.getAddress().getAddressLine2(),
                                res.getAddress().getCityTown(), res.getAddress().getPostalZipCode()))));
                    } else {
                        return createCardProviderException("" + res.getResult().getCode(), res.getResult().getMessage());
                    }

                }));

        return returnRecover(result);
    }


    @With(BaseMerchantApiV2Action.class)
    @ApiOperation(
            nickname = "getCustomerCardProvider",
            value = "Get customer at card provider side",
            notes = "Method allows to get card provider customer",
            produces = "application/json",
            consumes = "application/json",
            httpMethod = "POST",
            response = GetCustomerAPIResponse.class
    )

    @ApiResponses(value = {
            @ApiResponse(code = SUCCESS_CODE, message = SUCCESS_TEXT, response = GetCustomerAPIResponse.class),
            @ApiResponse(code = INCORRECT_AUTHORIZATION_DATA_CODE, message = INCORRECT_AUTHORIZATION_DATA_TEXT, response = BaseAPIV2ErrorResponse.class),
            @ApiResponse(code = INACTIVE_ACCOUNT_CODE, message = INACTIVE_ACCOUNT_TEXT, response = BaseAPIV2ErrorResponse.class),
            @ApiResponse(code = WRONG_REQUEST_FORMAT_CODE, message = WRONG_REQUEST_FORMAT_TEXT, response = BaseAPIV2ErrorResponse.class),
            @ApiResponse(code = WRONG_REQUEST_ENCKEY_CODE, message = WRONG_REQUEST_ENCKEY_TEXT, response = BaseAPIV2ErrorResponse.class),
            @ApiResponse(code = GENERAL_ERROR_CODE, message = GENERAL_ERROR_TEXT, response = BaseAPIV2ErrorResponse.class),
    })
    @ApiImplicitParams(value = {
            @ApiImplicitParam(value = "Get customer request", required = true, dataType = "dto.partnerV2.GetCustomerCardProviderRequest", paramType = "body"),
            @ApiImplicitParam(value = "X-Api-Key account ID header", required = true, dataType = "String", paramType = "header", name = "X-Api-Key"),
            @ApiImplicitParam(value = "X-Request-Hash message digest header. Base64(sha1(RequestNonce+Api Secret))",
                    required = true, dataType = "String", paramType = "header", name = "X-Request-Hash"),
            @ApiImplicitParam(value = "X-Request-Nonce orderID header", required = true, dataType = "String", paramType = "header", name = "X-Request-Nonce")})
    public F.Promise<Result> getCustomerCardProvider() {

        final Authentication authData = (Authentication) ctx().args.get("authData");

        final JsonNode jsonNode = request().body().asJson();
        final GetCustomerCardProviderRequest createCard;
        try {
            createCard = Json.fromJson(jsonNode, GetCustomerCardProviderRequest.class);
        } catch (Exception ex) {
            Logger.error("Wrong request format: ", ex);
            return F.Promise.pure(createWrongRequestFormatResponse("Wrong request format"));
        }

        if (StringUtils.isBlank(createCard.getUserID())
        ) {
            Logger.error("Missing params");
            return F.Promise.pure(createWrongRequestFormatResponse("Missing request params: userID"));
        }


        F.Promise<Result> result = accomplishService.getCustomer(createCard.getUserID(), "" + authData.getAccount().getId())
                .map(res -> {

                    if (res.getResult().getCode().equalsIgnoreCase("0000")) {

                        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

                        Date date = simpleDateFormat.parse(
                                res.getPersonalInfo().getDateOfBirth());

                        Logger.info("DOB date = " + date);

                        simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");

                        String kycStatus = "";

                        switch (res.getSecurity().getTrustLevel()) {
                            case "1":
                                kycStatus = "none";
                                break;
                            case "3":
                                kycStatus = "sdd";
                                break;
                            case "5":
                                kycStatus = "fdd";
                                break;
                            default:
                                kycStatus = "none";
                                break;

                        }


                        return ok(Json.toJson(new GetCustomerAPIResponse(new CustomerV3(res.getEmail().get(0).getAddress(),
                                "Dr", res.getPersonalInfo().getFirstName(),
                                res.getPersonalInfo().getLastName(), simpleDateFormat.format(date),
                                res.getPhone().get(0).getNumber(), "", kycStatus,
                                "", res.getAddress().getAddressLine1(), res.getAddress().getAddressLine2(),
                                res.getAddress().getCityTown(), res.getAddress().getPostalZipCode()))));
                    } else {
                        return createCardProviderException("" + res.getResult().getCode(), res.getResult().getMessage());
                    }

                });

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
            @ApiImplicitParam(value = "Create card request", required = true, dataType = "dto.partnerV2.CreateCardV2Request", paramType = "body"),
            @ApiImplicitParam(value = "X-Api-Key account ID header", required = true, dataType = "String", paramType = "header", name = "X-Api-Key"),
            @ApiImplicitParam(value = "X-Request-Hash message digest header. Base64(sha1(RequestNonce+Api Secret))",
                    required = true, dataType = "String", paramType = "header", name = "X-Request-Hash"),
            @ApiImplicitParam(value = "X-Request-Nonce orderID header", required = true, dataType = "String", paramType = "header", name = "X-Request-Nonce")})
    public F.Promise<Result> createCard() {

        final Authentication authData = (Authentication) ctx().args.get("authData");

        final JsonNode jsonNode = request().body().asJson();
        final CreateCardV2Request createCard;
        try {
            createCard = Json.fromJson(jsonNode, CreateCardV2Request.class);
        } catch (Exception ex) {
            Logger.error("Wrong request format: ", ex);
            return F.Promise.pure(createWrongRequestFormatResponse("Wrong request format"));
        }

        if (StringUtils.isBlank(createCard.getMobilePhone())
        ) {
            Logger.error("Missing params");
            return F.Promise.pure(createWrongRequestFormatResponse("Missing request params: mobilePhone"));
        }

        if (StringUtils.isBlank(createCard.getCdata1())
        ) {
            Logger.error("Missing params");
            return F.Promise.pure(createWrongRequestFormatResponse("Missing request params: cdata1"));
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

        F.Promise<Optional<Customer>> customerPromise = F.Promise.wrap(customerRepository.retrieveById(StringUtils.removeStart(createCard.getMobilePhone(), "+"), createCard.getCdata1()));


        F.Promise<Result> result = customerPromise.flatMap(customers -> accomplishService.createCard(customers.get().getReferral(),
                createCard.getCardModel(), createCard.getDesignID(), "" + authData.getAccount().getId())
                .flatMap(res -> {

                            F.Promise<Result> returnPromise = null;

                            if (res.getResult().getCode().equalsIgnoreCase("0000")) {
                                Card card = new Card();

                                Config conf = ConfigFactory.load();

                                String accomplishProd = conf.getString("accomplish.environment.prod");

                                String currency = "EUR";
                                CardBrand cardBrand = CardBrand.WALLET;
                                CardType cardType = CardType.VIRTUAL;
                                String type = "";

                                if (accomplishProd.equalsIgnoreCase("false")) {

                                    if (createCard.getCardModel().equalsIgnoreCase("mm_parent_wallet_dkk")) {
                                        cardBrand = CardBrand.PARENT_WALLET;
                                        currency = "DKK";
                                        cardType = CardType.VIRTUAL;
                                        type = "mvc";
                                    } else if (createCard.getCardModel().equalsIgnoreCase("mm_child_card_dkk")) {
                                        cardBrand = CardBrand.CHILDCARD;
                                        currency = "DKK";
                                        cardType = CardType.PLASTIC;
                                        type = "physical";
                                    } else if (createCard.getCardModel().equalsIgnoreCase("tgr_eur")) {
                                        cardBrand = CardBrand.VISA;
                                        currency = "EUR";
                                        cardType = CardType.PLASTIC;
                                        type = "physical";
                                    } else if (createCard.getCardModel().equalsIgnoreCase("tgr_gbp")) {
                                        cardBrand = CardBrand.VISA;
                                        currency = "GBP";
                                        cardType = CardType.PLASTIC;
                                        type = "physical";
                                    } else if (createCard.getCardModel().equalsIgnoreCase("Fortu_GBP")) {
                                        cardBrand = CardBrand.VISA;
                                        currency = "GBP";
                                        cardType = CardType.PLASTIC;
                                        type = "physical";
                                    } else if (createCard.getCardModel().equalsIgnoreCase("wari_eur")) {
                                        cardBrand = CardBrand.VISA;
                                        currency = "EUR";
                                        cardType = CardType.PLASTIC;
                                        type = "physical";
                                    } else if (createCard.getCardModel().equalsIgnoreCase("coinify_eur")) {
                                        cardBrand = CardBrand.VISA;
                                        currency = "EUR";
                                        cardType = CardType.PLASTIC;
                                        type = "physical";
                                    } else if (createCard.getCardModel().equalsIgnoreCase("coinify_gbp")) {
                                        cardBrand = CardBrand.VISA;
                                        currency = "GBP";
                                        cardType = CardType.PLASTIC;
                                        type = "physical";
                                    }


                                } else {
                                    if (createCard.getCardModel().equalsIgnoreCase("mm_parent_wallet_dkk")) {
                                        cardBrand = CardBrand.PARENT_WALLET;
                                        currency = "DKK";
                                        cardType = CardType.VIRTUAL;
                                        type = "mvc";
                                    } else if (createCard.getCardModel().equalsIgnoreCase("mm_child_card_dkk")) {
                                        cardBrand = CardBrand.CHILDCARD;
                                        currency = "DKK";
                                        cardType = CardType.PLASTIC;
                                        type = "physical";
                                    } else if (createCard.getCardModel().equalsIgnoreCase("accomplish_eur")) {
                                        cardBrand = CardBrand.VISA;
                                        currency = "EUR";
                                        cardType = CardType.PLASTIC;
                                        type = "physical";
                                    } else if (createCard.getCardModel().equalsIgnoreCase("accomplish_gbp")) {
                                        cardBrand = CardBrand.VISA;
                                        currency = "GBP";
                                        cardType = CardType.PLASTIC;
                                        type = "physical";
                                    } else if (createCard.getCardModel().equalsIgnoreCase("accomplish_eur_wallet")) {
                                        cardBrand = CardBrand.PARENT_WALLET;
                                        currency = "EUR";
                                        cardType = CardType.PLASTIC;
                                        type = "physical";
                                    } else if (createCard.getCardModel().equalsIgnoreCase("tgr_gbp")) {
                                        cardBrand = CardBrand.MASTERCARD;
                                        currency = "GBP";
                                        cardType = CardType.PLASTIC;
                                        type = "physical";
                                    } else if (createCard.getCardModel().equalsIgnoreCase("tgr_eur")) {
                                        cardBrand = CardBrand.MASTERCARD;
                                        currency = "EUR";
                                        cardType = CardType.PLASTIC;
                                        type = "physical";
                                    } else if (createCard.getCardModel().equalsIgnoreCase("Fortu_GBP")) {
                                        cardBrand = CardBrand.VISA;
                                        currency = "GBP";
                                        cardType = CardType.PLASTIC;
                                        type = "physical";
                                    } else if (createCard.getCardModel().equalsIgnoreCase("wari_eur")) {
                                        cardBrand = CardBrand.VISA;
                                        currency = "EUR";
                                        cardType = CardType.PLASTIC;
                                        type = "physical";
                                    }
                                    else if (createCard.getCardModel().equalsIgnoreCase("coinify_eur")) {
                                        cardBrand = CardBrand.VISA;
                                        currency = "EUR";
                                        cardType = CardType.PLASTIC;
                                        type = "physical";
                                    } else if (createCard.getCardModel().equalsIgnoreCase("coinify_gbp")) {
                                        cardBrand = CardBrand.VISA;
                                        currency = "GBP";
                                        cardType = CardType.PLASTIC;
                                        type = "physical";
                                    }
                                }


                                card.setToken("" + res.getInfo().getId());

                                card.setActive(true);
                                card.setAlias(createCard.getCardModel());
                                card.setBrand(cardBrand);
                                card.setType(cardType);
                                card.setCardDefault(true);
                                card.setCreateDate(new Date());
                                card.setCurrencyId(currency);
                                card.setCustomerId(customers.get().getId());
                                card.setDeliveryAddress1("address 1");
                                card.setDeliveryAddress2("address 2");
                                card.setDeliveryAddress3(createCard.getCardData());
                                card.setDeliveryCountry("DK");
                                card.setInfo(res.getInfo().getBinId());
                                card.setAccountID(authData.getAccount().getId().toString());
                                card.setFulfilment(createCard.getDesignID());

                                String finalCurrency = currency;
                                String finalType = type;
                                returnPromise = F.Promise.wrap(cardRepository.create(card)).map(rez -> ok(Json.toJson(new CreateCardResponse(null, 0.0, createCard.getCardData(), finalCurrency,
                                        "mymonii_feegroup_dkk", res.getInfo().getNumber(), "ready", "" + res.getInfo().getId(), finalType, "MYMONII"))));
                            } else {
                                returnPromise = F.Promise.pure(createCardProviderException(res.getResult().getCode(), res.getResult().getMessage()));
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

                    returnPromise = operationService.createAccomplishTransferOperation(data._1._1.get(),
                            data._1._2.get(), (long) createCard.getAmount() * 100, data._2.get(), "" + System.currentTimeMillis(), "Transfer funds", authData.getAccount())
                            .map(res -> ok(Json.toJson(new TransferResponse(true, "ready")
                            )));
                } else {
                    returnPromise = F.Promise.pure(createCardProviderException(providerResponse.getResult().getCode(), providerResponse.getResult().getMessage()));
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
        F.Promise<Optional<Customer>> customerPromise = F.Promise.wrap(customerRepository.retrieveById(StringUtils.removeStart(createCard.getMobilePhone(), "+"), createCard.getCdata1()));


        final F.Promise<Result> result = customerPromise.zip(senderCardPromise).flatMap(data -> {


            F.Promise<GetAccountResponse> account = accomplishService.getAccount(createCard.getToken(), "" + authData.getAccount().getId(), true);

            return account.flatMap(acc -> {

                F.Promise<Result> returnPromise = null;

                if (!data._1.isPresent()) {
                    Logger.error("Specified customer doesn't exist");
                    returnPromise = F.Promise.pure(createWrongCustomerAccountResponse());
                    return returnPromise;
                }

                if (acc.getResult().getCode().equalsIgnoreCase("0000")) {

                    String type = "1";

                    if (data._2.get().getType().equals(CardType.PLASTIC)) {
                        type = "0";
                    } else {
                        return F.Promise.pure(ok(Json.toJson(new SuccessAPIV2Response(true))));
                    }


                    return accomplishService.activateAccount(createCard.getToken(), data._2.get().getInfo(),
                            data._1.get().getReferral(), data._2.get().getCurrencyId(), acc.getInfo().getNumber(), type,
                            acc.getInfo().getSecurity().getActivationCode(), "" + authData.getAccount().getId()).map(rez -> {
                                if (rez.getResult().getCode().equalsIgnoreCase("0000")) {
                                    return ok(Json.toJson(new SuccessAPIV2Response(true)));
                                } else {
                                    return createCardProviderException(rez.getResult().getCode(), rez.getResult().getMessage());
                                }

                            }

                    );
                } else {
                    returnPromise = F.Promise.pure(createCardProviderException(acc.getResult().getCode(), acc.getResult().getMessage()));
                }

                return returnPromise;
            });
        });

        return returnRecover(result);

    }


    @With(BaseMerchantApiV2Action.class)
    @ApiOperation(
            nickname = "setCardStatus\n",
            value = "Set card status",
            notes = "Method allows to set card status",
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
            @ApiImplicitParam(value = "Set card status request", required = true, dataType = "dto.partnerV2.SetCardStatusRequest", paramType = "body"),
            @ApiImplicitParam(value = "X-Api-Key account ID header", required = true, dataType = "String", paramType = "header", name = "X-Api-Key"),
            @ApiImplicitParam(value = "X-Request-Hash message digest header. Base64(sha1(RequestNonce+Api Secret))",
                    required = true, dataType = "String", paramType = "header", name = "X-Request-Hash"),
            @ApiImplicitParam(value = "X-Request-Nonce orderID header", required = true, dataType = "String", paramType = "header", name = "X-Request-Nonce")})
    public F.Promise<Result> setCardStatus
            () {

        final Authentication authData = (Authentication) ctx().args.get("authData");

        final JsonNode jsonNode = request().body().asJson();
        final SetCardStatusRequest createCard;
        try {
            createCard = Json.fromJson(jsonNode, SetCardStatusRequest.class);
        } catch (Exception ex) {
            Logger.error("Wrong request format: ", ex);
            return F.Promise.pure(createWrongRequestFormatResponse("Wrong request format"));
        }

        if (StringUtils.isBlank(createCard.getToken())) {
            Logger.error("Missing params");
            return F.Promise.pure(createWrongRequestFormatResponse("Missing request params: token"));
        }

        if (StringUtils.isBlank(createCard.getNewStatus())) {
            Logger.error("Missing params");
            return F.Promise.pure(createWrongRequestFormatResponse("Missing request params: status"));
        }

        F.Promise<Optional<Card>> senderCardPromise = F.Promise.wrap(cardRepository.retrieveByToken(createCard.getToken()));

        final F.Promise<Result> result = senderCardPromise.flatMap(data -> {

            String newStatus = "1";

            switch (createCard.getNewStatus()) {
                case "active":
                    newStatus = "1";
                    break;
                case "blocked":
                    newStatus = "4";
                    break;
                case "lost":
                    newStatus = "2";
                    break;
                case "stolen":
                    newStatus = "3";
                    break;
                default:
                    newStatus = "1";
            }

            F.Promise<UpdateAccountResponse> account = accomplishService.updateCard(createCard.getToken(), newStatus, "" + authData.getAccount().getId());

            return account.map(acc -> {

                if (acc.getResult().getCode().equalsIgnoreCase("0000")) {
                    return ok(Json.toJson(new SuccessAPIV2Response(true)));
                } else {
                    return createCardProviderException(acc.getResult().getCode(), acc.getResult().getMessage());
                }
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

        final F.Promise<Result> result = senderCardPromise.flatMap(data -> F.Promise.wrap(currencyRepository.retrieveById(data.get().getCurrencyId())).flatMap(currency -> accomplishService.load(createCard.getAmount(), data.get().getCurrencyId(), createCard.getToken(), ref, "" + authData.getAccount().getId()).flatMap(acc -> {

            F.Promise<Result> returnPromise = null;

            if (acc.getResult().getCode().equalsIgnoreCase("0000")) {

                long amount = (long) (Float.parseFloat(createCard.getAmount()) * 100);

                if (amount > 0) {
                    return operationService.createAccomplishDepositOperation(data.get(),
                            amount, currency.get(), ref, StringUtils.isBlank(createCard.getLabel()) ? "Debit card deposit" : createCard.getLabel(), authData.getAccount()).map(rez ->
                            ok(Json.toJson(new LoadResponse(createCard.getToken(), "done", "" + amount, Double.parseDouble(acc.getInfo().getAvailableBalance()), ref)
                            )));
                } else {
                    return operationService.createAccomplishWithdrawOperation(data.get(),
                            -amount, currency.get(), ref, StringUtils.isBlank(createCard.getLabel()) ? "Debit card deposit" : createCard.getLabel(), authData.getAccount()).map(rez ->
                            ok(Json.toJson(new LoadResponse(createCard.getToken(), "done", "" + (-amount), Double.parseDouble(acc.getInfo().getAvailableBalance()), ref)
                            )));
                }


            } else {
                returnPromise = F.Promise.pure(createCardProviderException(acc.getResult().getCode(), acc.getResult().getMessage()));
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
        F.Promise<GetAccountInfoResponse> accountPromise = accomplishService.getAccountInfo(createCard.getToken(), "" + authData.getAccount().getId(), false);

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
                    status = "lostOrStolen";
                } else if (accStatus.equalsIgnoreCase("3")) {
                    status = "lostOrStolen";
                } else if (accStatus.equalsIgnoreCase("4")) {
                    status = "blocked";
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
                    status = "ready";
                }

                Card card = acc._1.get();

                String type = "mvc";

                if (card.getType().equals(CardType.PLASTIC)) {
                    type = "physical";
                }


                returnPromise =
                        F.Promise.pure(ok(Json.toJson(new dto.partnerV2.CheckCardResponse(createCard.getToken(), status, acc._2.getInfo().getActivationDateTime(),  Double.parseDouble(acc._2.getInfo().getBalance()), Double.parseDouble(acc._2.getInfo().getAvailableBalance()), acc._1.get().getDeliveryAddress3(), acc._1.get().getCurrencyId(), "mymonii_feegroup_dkk", acc._2.getInfo().getNumber(),
                                type, "MYMONII"))));
            } else {
                returnPromise = F.Promise.pure(createCardProviderException(acc._2.getResult().getCode(), acc._2.getResult().getMessage()));
            }

            return returnPromise;
        });

        return returnRecover(result);

    }


    @With(BaseMerchantApiV2Action.class)
    @ApiOperation(
            nickname = "getCardDetails",
            value = "Get card details",
            notes = "Method allows to get card details",
            produces = "application/json",
            consumes = "application/json",
            httpMethod = "POST",
            response = GetCardDetailsResponse.class
    )

    @ApiResponses(value = {
            @ApiResponse(code = SUCCESS_CODE, message = SUCCESS_TEXT, response = GetCardDetailsResponse.class),
            @ApiResponse(code = INCORRECT_AUTHORIZATION_DATA_CODE, message = INCORRECT_AUTHORIZATION_DATA_TEXT, response = BaseAPIV2ErrorResponse.class),
            @ApiResponse(code = INACTIVE_ACCOUNT_CODE, message = INACTIVE_ACCOUNT_TEXT, response = BaseAPIV2ErrorResponse.class),
            @ApiResponse(code = WRONG_REQUEST_FORMAT_CODE, message = WRONG_REQUEST_FORMAT_TEXT, response = BaseAPIV2ErrorResponse.class),
            @ApiResponse(code = WRONG_REQUEST_ENCKEY_CODE, message = WRONG_REQUEST_ENCKEY_TEXT, response = BaseAPIV2ErrorResponse.class),
            @ApiResponse(code = GENERAL_ERROR_CODE, message = GENERAL_ERROR_TEXT, response = BaseAPIV2ErrorResponse.class),
    })
    @ApiImplicitParams(value = {
            @ApiImplicitParam(value = "Get card details request", required = true, dataType = "dto.partnerV2.CheckCardRequest", paramType = "body"),
            @ApiImplicitParam(value = "X-Api-Key account ID header", required = true, dataType = "String", paramType = "header", name = "X-Api-Key"),
            @ApiImplicitParam(value = "X-Request-Hash message digest header. Base64(sha1(RequestNonce+Api Secret))",
                    required = true, dataType = "String", paramType = "header", name = "X-Request-Hash"),
            @ApiImplicitParam(value = "X-Request-Nonce orderID header", required = true, dataType = "String", paramType = "header", name = "X-Request-Nonce")})
    public F.Promise<Result> getCardDetails() {

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
        F.Promise<GetAccountResponse> accountPromise = accomplishService.getAccount(createCard.getToken(), "" + authData.getAccount().getId(), true);

        final F.Promise<Result> result = senderCardPromise.zip(accountPromise).flatMap(acc -> {

            F.Promise<Result> returnPromise = null;


            if (acc._2.getResult().getCode().equalsIgnoreCase("0000")) {


                returnPromise =
                        F.Promise.pure(ok(Json.toJson(new dto.partnerV2.GetCardDetailsResponse(createCard.getToken(), acc._2.getInfo().getNumber(), acc._2.getInfo().getSecurity().getSecurity_code(), acc._2.getInfo().getSecurity().getExpiry_date(), acc._1.get().getFulfilment()
                        ))));
            } else {
                returnPromise = F.Promise.pure(createCardProviderException(acc._2.getResult().getCode(), acc._2.getResult().getMessage()));
            }

            return returnPromise;
        });

        return returnRecover(result);

    }



    @With(BaseMerchantApiV2Action.class)
    @ApiOperation(
            nickname = "changeCardFulfilment",
            value = "Change card fulfilment",
            notes = "Method allows to change card fulfilment",
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
            @ApiImplicitParam(value = "Change card fulfilment request", required = true, dataType = "dto.partnerV2.ChangeCardFulfilmentRequest", paramType = "body"),
            @ApiImplicitParam(value = "X-Api-Key account ID header", required = true, dataType = "String", paramType = "header", name = "X-Api-Key"),
            @ApiImplicitParam(value = "X-Request-Hash message digest header. Base64(sha1(RequestNonce+Api Secret))",
                    required = true, dataType = "String", paramType = "header", name = "X-Request-Hash"),
            @ApiImplicitParam(value = "X-Request-Nonce orderID header", required = true, dataType = "String", paramType = "header", name = "X-Request-Nonce")})
    public F.Promise<Result> changeCardFulfilment() {

        final Authentication authData = (Authentication) ctx().args.get("authData");

        final JsonNode jsonNode = request().body().asJson();
        final ChangeCardFulfilmentRequest createCard;
        try {
            createCard = Json.fromJson(jsonNode, ChangeCardFulfilmentRequest.class);
        } catch (Exception ex) {
            Logger.error("Wrong request format: ", ex);
            return F.Promise.pure(createWrongRequestFormatResponse("Wrong request format"));
        }

        if (StringUtils.isBlank(createCard.getToken())) {
            Logger.error("Missing params");
            return F.Promise.pure(createWrongRequestFormatResponse("Missing request params: token"));
        }

        if (StringUtils.isBlank(createCard.getFulfilment())) {
            Logger.error("Missing params");
            return F.Promise.pure(createWrongRequestFormatResponse("Missing request params: fulfilment"));
        }


        F.Promise<Optional<Card>> senderCardPromise = F.Promise.wrap(cardRepository.retrieveByToken(createCard.getToken()));

        final F.Promise<Result> result = senderCardPromise.flatMap(acc -> {

            F.Promise<Result> returnPromise = null;


            if (acc.get() != null) {

                Card card = acc.get();

                card.setFulfilment(createCard.getFulfilment());

                cardRepository.update(card);

                return F.Promise.pure(ok(Json.toJson(new dto.partnerV2.SuccessAPIV2Response(true))));
            } else {


                returnPromise = F.Promise.pure(createWrongCardResponse());
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

        if (StringUtils.isBlank(createCard.getCdata1())) {
            Logger.error("Missing params");
            return F.Promise.pure(createWrongRequestFormatResponse("Missing request params: cdata1"));
        }

//        if (StringUtils.isBlank(createCard.getData())) {
//            Logger.error("Missing params");
//            return F.Promise.pure(createWrongRequestFormatResponse("Missing request params: data"));
//        }

        F.Promise<Optional<Customer>> customerPromise = F.Promise.wrap(customerRepository.retrieveById(StringUtils.removeStart(createCard.getMobilePhone(), "+"), createCard.getCdata1()));

        final F.Promise<Result> result = customerPromise.flatMap(acc -> {

            F.Promise<Result> returnPromise = null;

            if (createCard.getType().equalsIgnoreCase("address")) {

                final GsonBuilder gsonBuilder = new GsonBuilder();
                gsonBuilder.disableHtmlEscaping();

                final Gson gson = gsonBuilder.create();

                java.util.LinkedHashMap data = (java.util.LinkedHashMap) createCard.getData();


                AddressRequestBean addressRequestBean = new AddressRequestBean();

                addressRequestBean.setAddress1((String) data.get("address1"));
                addressRequestBean.setAddress2((String) data.get("address2"));
                addressRequestBean.setCity((String) data.get("city"));
                addressRequestBean.setCountry((String) data.get("country"));
                addressRequestBean.setZip("" + ((java.math.BigInteger) data.get("zip")).intValue());


                return F.Promise.wrap(countryRepository.retrieveById((String) data.get("country"))).flatMap(country -> {

                    addressRequestBean.setCountry(country.get().getCode());

                    return accomplishService.updateUserAddress(acc.get().getReferral(), addressRequestBean, "" + authData.getAccount().getId()).flatMap(res -> {
                        if (res.getResult().getCode().equalsIgnoreCase("0000")) {

                            Customer customer = acc.get();

                            customer.setAddress1(addressRequestBean.getAddress1());
                            customer.setAddress2(addressRequestBean.getAddress2());
                            customer.setCity(addressRequestBean.getCity());
                            customer.setCountry_id((String) data.get("country"));
                            customer.setPostcode(addressRequestBean.getZip());

                            customerRepository.update(customer);

                            return F.Promise.pure(ok(Json.toJson(new dto.partnerV2.SuccessAPIV2Response(true))));
                        } else {
                            return F.Promise.pure(createCardProviderException(res.getResult().getCode(), res.getResult().getMessage()));
                        }
                    });
                });
            } else if (createCard.getType().equalsIgnoreCase("email")) {
                return accomplishService.updateUserEmail(acc.get().getReferral(), (String) createCard.getData(), "" + authData.getAccount().getId()).flatMap(res -> {
                    if (res.getResult().getCode().equalsIgnoreCase("0000")) {

                        Customer customer = acc.get();

                        customer.setEmail((String) createCard.getData());

                        customerRepository.update(customer);

                        return F.Promise.pure(ok(Json.toJson(new dto.partnerV2.SuccessAPIV2Response(true))));
                    } else {
                        return F.Promise.pure(createCardProviderException(res.getResult().getCode(), res.getResult().getMessage()));
                    }
                });
            } else if (createCard.getType().equalsIgnoreCase("birthdate")) {
                return accomplishService.updateUserBirthdate(acc.get().getReferral(), (String) createCard.getData(), "" + authData.getAccount().getId()).flatMap(res -> {
                    if (res.getResult().getCode().equalsIgnoreCase("0000")) {

                        Customer customer = acc.get();

                        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

                        Date dob = simpleDateFormat.parse((String) createCard.getData());

                        customer.setDateBirth(dob);

                        customerRepository.update(customer);

                        return F.Promise.pure(ok(Json.toJson(new dto.partnerV2.SuccessAPIV2Response(true))));
                    } else {
                        return F.Promise.pure(createCardProviderException(res.getResult().getCode(), res.getResult().getMessage()));
                    }
                });
            }else if (createCard.getType().equalsIgnoreCase("name")) {

                String data = (String) createCard.getData();


                String firstNameData = "";
                String lastNameData = "";

                try {
                    firstNameData = StringUtils.substringBefore(data, "|");
                    lastNameData =  StringUtils.substringAfterLast(data, "|");

                    Logger.info("# Parsed name: firstNameData = " + firstNameData + " lastNameData = " + lastNameData);

                } catch (Exception e) {

                }




                if (StringUtils.isBlank(firstNameData)) {
                    firstNameData = acc.get().getFirstName();

                }

                if (StringUtils.isBlank(lastNameData)) {
                    lastNameData = acc.get().getLastName();

                }

                Logger.info("# Actual name: firstNameData = " + firstNameData + " lastNameData = " + lastNameData);



                final String finalFirstNameData = firstNameData;
                final String finalLastNameData = lastNameData;
                return accomplishService.updateUserName(acc.get().getReferral(), firstNameData, lastNameData, "" + authData.getAccount().getId()).flatMap(res -> {
                    if (res.getResult().getCode().equalsIgnoreCase("0000")) {

                        Customer customer = acc.get();

                        customer.setFirstName(finalFirstNameData);
                        customer.setLastName(finalLastNameData);

                        customerRepository.update(customer);

                        return F.Promise.pure(ok(Json.toJson(new dto.partnerV2.SuccessAPIV2Response(true))));
                    } else {
                        return F.Promise.pure(createCardProviderException(res.getResult().getCode(), res.getResult().getMessage()));
                    }
                });
            }
            else if (createCard.getType().equalsIgnoreCase("phone")) {
                return accomplishService.updateUserPhone(acc.get().getReferral(), (String) createCard.getData(), "" + authData.getAccount().getId()).flatMap(res -> {
                    if (res.getResult().getCode().equalsIgnoreCase("0000")) {

                        Customer customer = acc.get();
//
                        customer.setPhone2(StringUtils.removeStart((String) createCard.getData(), "+"));
//
                        customerRepository.update(customer);

                        return F.Promise.pure(ok(Json.toJson(new dto.partnerV2.SuccessAPIV2Response(true))));
                    } else {
                        return F.Promise.pure(createCardProviderException(res.getResult().getCode(), res.getResult().getMessage()));
                    }
                });
            } else if (createCard.getType().equalsIgnoreCase("kycLevel")) {

                Customer customer = acc.get();

                KYC kyc = KYC.SIMPLIFIED_DUE_DILIGENCE;

                String data = (String) createCard.getData();

                if (data.equalsIgnoreCase("sdd")) {
                    kyc = KYC.SIMPLIFIED_DUE_DILIGENCE;
                } else {
                    kyc = KYC.FULL_DUE_DILIGENCE;
                }


                customer.setKyc(kyc);

                customerRepository.update(customer);

                return F.Promise.pure(ok(Json.toJson(new dto.partnerV2.SuccessAPIV2Response(true))));

            } else if (createCard.getType().equalsIgnoreCase("cdata1")) {

                Customer customer = acc.get();

                customer.setCdata((String) createCard.getData());

                customerRepository.update(customer);

                return F.Promise.pure(ok(Json.toJson(new dto.partnerV2.SuccessAPIV2Response(true))));

            } else if (createCard.getType().equalsIgnoreCase("cdata2")) {

                Customer customer = acc.get();

                customer.setCdata2((String) createCard.getData());

                customerRepository.update(customer);

                return F.Promise.pure(ok(Json.toJson(new dto.partnerV2.SuccessAPIV2Response(true))));

            } else if (createCard.getType().equalsIgnoreCase("cdata3")) {

                Customer customer = acc.get();

                customer.setCdata3((String) createCard.getData());

                customerRepository.update(customer);

                return F.Promise.pure(ok(Json.toJson(new dto.partnerV2.SuccessAPIV2Response(true))));
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
        F.Promise<GetAccountResponse> accountPromise = accomplishService.getAccount(createCard.getToken(), "" + authData.getAccount().getId(), true);

        final F.Promise<Result> result = senderCardPromise.zip(accountPromise).flatMap(acc -> {

            F.Promise<Result> returnPromise = null;


            if (acc._2.getResult().getCode().equalsIgnoreCase("0000")) {


                returnPromise =
                        F.Promise.pure(ok(Json.toJson(new dto.partnerV2.GetPINImageCardResponse(acc._2.getInfo().getSecurity().getPin_code()))));
            } else {
                returnPromise = F.Promise.pure(createCardProviderException(acc._2.getResult().getCode(), acc._2.getResult().getMessage()));
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
        String status = "0";
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

        if (StringUtils.isNotBlank(createCard.getStatus())) {
            status = createCard.getStatus();
        }


        F.Promise<Optional<Card>> senderCardPromise = F.Promise.wrap(cardRepository.retrieveByToken(createCard.getToken()));
        F.Promise<GetAccountInfoResponse> accountPromise = accomplishService.getAccountInfo(createCard.getToken(), "" + authData.getAccount().getId(), false);

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

        int finalLimit = limit;
        int finalOffset = offset;
        String finalDateFrom = simpleDateFormat.format(new Date(Long.parseLong(dateFrom)));

        Logger.info("new Date(Long.parseLong(dateFrom) = " + (new Date(Long.parseLong(dateFrom)).toString()));

        String finalDateTo = simpleDateFormat.format(new Date(Long.parseLong(dateTo)));

        Logger.info("new Date(Long.parseLong(dateFrom) = " + (new Date(Long.parseLong(dateTo)).toString()));
        int finalOffset1 = offset;
        String finalStatus = status;
        final F.Promise<Result> result = senderCardPromise.zip(accountPromise).flatMap(acc -> {

            F.Promise<Result> returnPromise = null;


            if (acc._2.getResult().getCode().equalsIgnoreCase("0000")) {


                returnPromise = accomplishService.getTransaction("" + acc._2.getInfo().getUserId(), createCard.getToken(), finalLimit,
                        finalOffset, finalDateFrom, finalDateTo, finalStatus, "" + authData.getAccount().getId()).flatMap(res -> {

                    F.Promise<Result> promise = null;


                    if (res.getResult().getCode().equalsIgnoreCase("0000")) {

                        TransactionResponse transactionResponse = new TransactionResponse();

                        List<Transaction> transactions = new ArrayList<>();

                        for (accomplish.dto.transaction.Transaction transaction : res.getTransactions()) {

                            Transaction resTransaction = new Transaction();

                            resTransaction.setAmount(Double.parseDouble(transaction.getInfo().getAmount()));
                            resTransaction.setBalance(Double.parseDouble(transaction.getInfo().getBalance()));
                            resTransaction.setCurrency(transaction.getInfo().getCurrency());
                            resTransaction.setDesc(transaction.getInfo().getNotes());
                            resTransaction.setDirection(transaction.getInfo().getOperation());
                            resTransaction.setLocalDate(DateUtil.parse(transaction.getInfo().getServerDate(), "yyyy-MM-dd'T'HH:mm:ss").getTime());
                            resTransaction.setSettlementDate(DateUtil.parse(transaction.getInfo().getServerDate(), "yyyy-MM-dd'T'HH:mm:ss").getTime());

                            resTransaction.setOriginalAmount(Double.parseDouble(transaction.getConversion().getOriginalAmount()));
                            resTransaction.setOriginalCurrency(acc._1.get().getCurrencyId());
                            resTransaction.setType(transaction.getInfo().getOperation());
                            resTransaction.setOriginalSourceId(transaction.getInfo().getOriginalSourceId());
                            if (transaction.getAccount() != null)
                              resTransaction.setStatus(transaction.getAccount().getInfo().getStatus());

                            transactions.add(resTransaction);
                        }

                        transactionResponse.setFrom(finalOffset1);
                        transactionResponse.setTo(res.getTransactions().size());
                        transactionResponse.setCount(res.getTransactions().size());

                        transactionResponse.setTransactions(transactions);

                        promise =
                                F.Promise.pure(ok(Json.toJson(transactionResponse)));
                    } else {
                        promise = F.Promise.pure(createCardProviderException(res.getResult().getCode(), res.getResult().getMessage()));
                    }

                    return promise;

                });

            } else {
                returnPromise = F.Promise.pure(createCardProviderException(acc._2.getResult().getCode(), acc._2.getResult().getMessage()));
            }

            return returnPromise;
        });

        return returnRecover(result);
    }

    @With(BaseMerchantApiV2Action.class)
    @ApiOperation(
            nickname = "pushMwTransaction",
            value = "Push mini wallet transaction",
            notes = "Method allows to push mini wallet transaction",
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
            @ApiImplicitParam(value = "Push mini wallet transaction request", required = true, dataType = "dto.partnerV2.PushMiniWalletRequest", paramType = "body"),
            @ApiImplicitParam(value = "X-Api-Key account ID header", required = true, dataType = "String", paramType = "header", name = "X-Api-Key"),
            @ApiImplicitParam(value = "X-Request-Hash message digest header. Base64(sha1(RequestNonce+Api Secret))",
                    required = true, dataType = "String", paramType = "header", name = "X-Request-Hash"),
            @ApiImplicitParam(value = "X-Request-Nonce orderID header", required = true, dataType = "String", paramType = "header", name = "X-Request-Nonce")})
    public F.Promise<Result> pushMwTransaction() {

        final Authentication authData = (Authentication) ctx().args.get("authData");

        final JsonNode jsonNode = request().body().asJson();
        final PushMiniWalletRequest createCard;
        try {
            createCard = Json.fromJson(jsonNode, PushMiniWalletRequest.class);
        } catch (Exception ex) {
            Logger.error("Wrong request format: ", ex);
            return F.Promise.pure(createWrongRequestFormatResponse("Wrong request format"));
        }

        if (StringUtils.isBlank(createCard.getToken())
        ) {
            Logger.error("Missing params");
            return F.Promise.pure(createWrongRequestFormatResponse("Missing request params: token"));
        }

        if (StringUtils.isBlank(createCard.getReceiver())
        ) {
            Logger.error("Missing params");
            return F.Promise.pure(createWrongRequestFormatResponse("Missing request params: receiver"));
        }

        if (StringUtils.isBlank(createCard.getDescription())
        ) {
            Logger.error("Missing params");
            return F.Promise.pure(createWrongRequestFormatResponse("Missing request params: description"));
        }


        if (StringUtils.isBlank(createCard.getUuid())
        ) {
            Logger.error("Missing params");
            return F.Promise.pure(createWrongRequestFormatResponse("Missing request params: uuid"));
        }


        F.Promise<Optional<Card>> senderCardPromise = F.Promise.wrap(cardRepository.retrieveByToken(createCard.getToken()));
        F.Promise<Optional<Card>> receiverCardPromise = F.Promise.wrap(cardRepository.retrieveByToken(createCard.getReceiver()));
        F.Promise<Double> sum = F.Promise.wrap(walletTransactionRepository.retrieveSumByUUID(createCard.getUuid()));

        final F.Promise<Result> result = senderCardPromise.zip(sum).zip(receiverCardPromise).flatMap(card -> {

            Logger.info("Wallet sum for " + createCard.getUuid() + " = " + (card._1._2.floatValue() / 100));

            float sumAfter = createCard.getAmount() + (card._1._2.floatValue() / 100);

            Logger.info("Sum after = " + sumAfter);


            BigDecimal value = new BigDecimal(sumAfter);
            value = value.setScale(2, BigDecimal.ROUND_HALF_EVEN);

            Logger.info("Sum after rounded = " + value.floatValue());


            F.Promise<GetAccountInfoResponse> source = accomplishService.getAccountInfo(card._1._1.get().getToken(), "" + authData.getAccount().getId(), false);
            F.Promise<GetAccountInfoResponse> dest = accomplishService.getAccountInfo(card._2.get().getToken(), "" + authData.getAccount().getId(), false);

            BigDecimal finalValue = value;
            return source.zip(dest).flatMap(cards -> {

                F.Promise<Result> returnPromise = null;

                if (sumAfter > 0.0) {

                    if (Float.parseFloat(cards._1.getInfo().getAvailableBalance()) < finalValue.floatValue()) {
                        returnPromise = F.Promise.pure(createNotEnoughFundsResponse());
                    }

                } else {
                    if (Float.parseFloat(cards._2.getInfo().getAvailableBalance()) < Math.abs(finalValue.floatValue())) {
                        returnPromise = F.Promise.pure(createNotEnoughFundsResponse());
                    }
                }

                if (returnPromise == null) {


                    WalletTransaction walletTransaction = new WalletTransaction();


                    walletTransaction.setAmount_cts((long) (createCard.getAmount() * 100));
                    walletTransaction.setCurrency(card._1._1.get().getCurrencyId());
                    walletTransaction.setDate_added(new Date().getTime() / 1000);
                    walletTransaction.setDescription(createCard.getDescription());
                    walletTransaction.setSrc_token(createCard.getToken());
                    walletTransaction.setDest_token(createCard.getReceiver());
                    walletTransaction.setType("load");
                    walletTransaction.setUuid(createCard.getUuid());

                    Logger.info("Trying to save wallet transaction " + walletTransaction);


                    returnPromise =

                            F.Promise.wrap(walletTransactionRepository.create(walletTransaction)).map(tr -> ok(Json.toJson(new SuccessAPIV2Response(true))));

                }

                return returnPromise;
            });
        });

        return returnRecover(result);
    }

    @With(BaseMerchantApiV2Action.class)
    @ApiOperation(
            nickname = "getMwTransactions",
            value = "Get mini wallet transactions",
            notes = "Method allows to get mini wallet transaction",
            produces = "application/json",
            consumes = "application/json",
            httpMethod = "POST",
            response = MiniWalletTransactionResponse.class
    )

    @ApiResponses(value = {
            @ApiResponse(code = SUCCESS_CODE, message = SUCCESS_TEXT, response = MiniWalletTransactionResponse.class),
            @ApiResponse(code = INCORRECT_AUTHORIZATION_DATA_CODE, message = INCORRECT_AUTHORIZATION_DATA_TEXT, response = BaseAPIV2ErrorResponse.class),
            @ApiResponse(code = INACTIVE_ACCOUNT_CODE, message = INACTIVE_ACCOUNT_TEXT, response = BaseAPIV2ErrorResponse.class),
            @ApiResponse(code = WRONG_REQUEST_FORMAT_CODE, message = WRONG_REQUEST_FORMAT_TEXT, response = BaseAPIV2ErrorResponse.class),
            @ApiResponse(code = WRONG_REQUEST_ENCKEY_CODE, message = WRONG_REQUEST_ENCKEY_TEXT, response = BaseAPIV2ErrorResponse.class),
            @ApiResponse(code = GENERAL_ERROR_CODE, message = GENERAL_ERROR_TEXT, response = BaseAPIV2ErrorResponse.class),
    })
    @ApiImplicitParams(value = {
            @ApiImplicitParam(value = "Get mini wallet transaction request", required = true, dataType = "dto.partnerV2.GetMiniWalletTransactionRequest", paramType = "body"),
            @ApiImplicitParam(value = "X-Api-Key account ID header", required = true, dataType = "String", paramType = "header", name = "X-Api-Key"),
            @ApiImplicitParam(value = "X-Request-Hash message digest header. Base64(sha1(RequestNonce+Api Secret))",
                    required = true, dataType = "String", paramType = "header", name = "X-Request-Hash"),
            @ApiImplicitParam(value = "X-Request-Nonce orderID header", required = true, dataType = "String", paramType = "header", name = "X-Request-Nonce")})
    public F.Promise<Result> getMwTransactions() {

        final Authentication authData = (Authentication) ctx().args.get("authData");

        final JsonNode jsonNode = request().body().asJson();
        final GetMiniWalletTransactionRequest createCard;
        try {
            createCard = Json.fromJson(jsonNode, GetMiniWalletTransactionRequest.class);
        } catch (Exception ex) {
            Logger.error("Wrong request format: ", ex);
            return F.Promise.pure(createWrongRequestFormatResponse("Wrong request format"));
        }

        if (StringUtils.isBlank(createCard.getUuid())
        ) {
            Logger.error("Missing params");
            return F.Promise.pure(createWrongRequestFormatResponse("Missing request params: token"));
        }

        F.Promise<List<WalletTransaction>> wrap = (StringUtils.isNotBlank(createCard.getDateStart()) &&
                StringUtils.isNotBlank(createCard.getDateEnd())) ?
                F.Promise.wrap(walletTransactionRepository.retrieveByUuidAndDate(createCard.getUuid(), Long.parseLong(createCard.getDateEnd()) / 1000, Long.parseLong(createCard.getDateStart()) / 1000)) : F.Promise.wrap(walletTransactionRepository.retrieveByUuid(createCard.getUuid()));

        final F.Promise<Result> result = wrap.map(card -> {

            MiniWalletTransactionResponse response = new MiniWalletTransactionResponse();

            response.setUuid(createCard.getUuid());

            ArrayList<Transaction2> transaction2s = new ArrayList<>();

            for (WalletTransaction walletTransaction : card) {
                Transaction2 transaction2 = new Transaction2();
                transaction2.setAmount((double) walletTransaction.getAmount_cts() / 100);
                transaction2.setCurrency(walletTransaction.getCurrency());
                transaction2.setDate(walletTransaction.getDate_added() * 1000);
                transaction2.setDescription(walletTransaction.getDescription());
                transaction2.setReceiver(walletTransaction.getDest_token());
                transaction2.setToken(walletTransaction.getSrc_token());
                transaction2.setType(walletTransaction.getType());

                transaction2s.add(transaction2);
            }

            response.setTransactions(transaction2s);


            return ok(Json.toJson(response));
        });

        return returnRecover(result);
    }


    @With(BaseMerchantApiV2Action.class)
    @ApiOperation(
            nickname = "doMwTransfer",
            value = "Do mini wallet transaction",
            notes = "Method allows to do mini wallet transaction",
            produces = "application/json",
            consumes = "application/json",
            httpMethod = "POST",
            response = TransferResponse.class
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
            @ApiImplicitParam(value = "Do mini wallet transaction request", required = true, dataType = "dto.partnerV2.DoMiniWalletRequest", paramType = "body"),
            @ApiImplicitParam(value = "X-Api-Key account ID header", required = true, dataType = "String", paramType = "header", name = "X-Api-Key"),
            @ApiImplicitParam(value = "X-Request-Hash message digest header. Base64(sha1(RequestNonce+Api Secret))",
                    required = true, dataType = "String", paramType = "header", name = "X-Request-Hash"),
            @ApiImplicitParam(value = "X-Request-Nonce orderID header", required = true, dataType = "String", paramType = "header", name = "X-Request-Nonce")})
    public F.Promise<Result> doMwTransfer() {

        final Authentication authData = (Authentication) ctx().args.get("authData");

        final JsonNode jsonNode = request().body().asJson();
        final DoMiniWalletRequest createCard;
        try {
            createCard = Json.fromJson(jsonNode, DoMiniWalletRequest.class);
        } catch (Exception ex) {
            Logger.error("Wrong request format: ", ex);
            return F.Promise.pure(createWrongRequestFormatResponse("Wrong request format"));
        }

        if (StringUtils.isBlank(createCard.getToken())
        ) {
            Logger.error("Missing params");
            return F.Promise.pure(createWrongRequestFormatResponse("Missing request params: token"));
        }

        if (StringUtils.isBlank(createCard.getReceiver())
        ) {
            Logger.error("Missing params");
            return F.Promise.pure(createWrongRequestFormatResponse("Missing request params: receiver"));
        }

        if (StringUtils.isBlank(createCard.getUuid())
        ) {
            Logger.error("Missing params");
            return F.Promise.pure(createWrongRequestFormatResponse("Missing request params: uuid"));
        }

        F.Promise<Optional<Card>> senderCardPromise = F.Promise.wrap(cardRepository.retrieveByToken(createCard.getToken()));
        F.Promise<Optional<Card>> receiverCardPromise = F.Promise.wrap(cardRepository.retrieveByToken(createCard.getReceiver()));
        F.Promise<Double> sum = F.Promise.wrap(walletTransactionRepository.retrieveSumByUUID(createCard.getUuid()));
        F.Promise<GetAccountInfoResponse> source = accomplishService.getAccountInfo(createCard.getToken(), "" + authData.getAccount().getId(), false);
        F.Promise<GetAccountInfoResponse> dest = accomplishService.getAccountInfo(createCard.getReceiver(), "" + authData.getAccount().getId(), false);


        final F.Promise<Result> result = senderCardPromise.zip(sum).zip(receiverCardPromise).zip(source).zip(dest).flatMap(card -> {

            Long walletBalance = card._1._1._1._2.longValue();

            Long amount = (long) (createCard.getAmount() * 100);

            if ((walletBalance > 0 && walletBalance < amount) ||
                    (walletBalance < 0 && amount < walletBalance)) {
                return F.Promise.pure(createNotEnoughFundsResponse());
            }

            boolean reverse = false;

            if (amount > 0) {
                if (Float.parseFloat(card._1._2.getInfo().getAvailableBalance()) < createCard.getAmount()) {
                    return F.Promise.pure(createNotEnoughFundsResponse());
                }

            } else {
                if (Float.parseFloat(card._2.getInfo().getAvailableBalance()) < Math.abs(createCard.getAmount())) {
                    return F.Promise.pure(createNotEnoughFundsResponse());
                }

                reverse = true;
            }

            return F.Promise.wrap(currencyRepository.retrieveById(card._1._1._2.get().getCurrencyId())).zip(accomplishService.transfer((!reverse) ? createCard.getToken() : createCard.getReceiver(), (!reverse) ? createCard.getReceiver() : createCard.getToken(), "" + createCard.getAmount(), card._1._1._2.get().getCurrencyId(), "" + authData.getAccount().getId()))
                    .flatMap(providerResponse -> {

                        F.Promise<Result> returnPromise = null;

                        if (providerResponse._2.getResult().getCode().equalsIgnoreCase("0000")) {

                            returnPromise = operationService.createAccomplishTransferOperation(card._1._1._1._1.get(),
                                    card._1._1._2.get(), (long) createCard.getAmount() * 100, providerResponse._1.get(), "" + System.currentTimeMillis(), "Transfer funds", authData.getAccount())
                                    .flatMap(res -> {

                                        WalletTransaction walletTransaction = new WalletTransaction();


                                        walletTransaction.setAmount_cts(((long) (createCard.getAmount() * 100) > 0) ? -(long) (createCard.getAmount() * 100) : (long) createCard.getAmount() * 100);
                                        walletTransaction.setCurrency(card._1._1._2.get().getCurrencyId());
                                        walletTransaction.setDate_added(new Date().getTime() / 1000);
                                        walletTransaction.setDescription("Transfer between from " + createCard.getToken() + " to " + createCard.getReceiver());
                                        walletTransaction.setDest_token(createCard.getReceiver());
                                        walletTransaction.setType("transfer");
                                        walletTransaction.setSrc_token(createCard.getToken());
                                        walletTransaction.setUuid(createCard.getUuid());

//                                        walletTransactionRepository.create(walletTransaction);


                                        return F.Promise.wrap(walletTransactionRepository.create(walletTransaction)).map(tr -> ok(Json.toJson(new TransferResponse(true, "done"))));


//                                        return (ok(Json.toJson(new TransferResponse(true, "done"))));

                                    });
                        } else {
                            returnPromise = F.Promise.pure(createCardProviderException(providerResponse._2.getResult().getCode(), providerResponse._2.getResult().getMessage()));
                        }

                        return returnPromise;

                    });

        });

        return returnRecover(result);
    }


    @With(BaseMerchantApiV2Action.class)
    @ApiOperation(
            nickname = "getMwBalance",
            value = "Get mini wallet balance transaction",
            notes = "Method allows to get mini wallet balance",
            produces = "application/json",
            consumes = "application/json",
            httpMethod = "POST",
            response = GetWalletBalanceResponse.class
    )

    @ApiResponses(value = {
            @ApiResponse(code = SUCCESS_CODE, message = SUCCESS_TEXT, response = GetWalletBalanceResponse.class),
            @ApiResponse(code = INCORRECT_AUTHORIZATION_DATA_CODE, message = INCORRECT_AUTHORIZATION_DATA_TEXT, response = BaseAPIV2ErrorResponse.class),
            @ApiResponse(code = INACTIVE_ACCOUNT_CODE, message = INACTIVE_ACCOUNT_TEXT, response = BaseAPIV2ErrorResponse.class),
            @ApiResponse(code = WRONG_REQUEST_FORMAT_CODE, message = WRONG_REQUEST_FORMAT_TEXT, response = BaseAPIV2ErrorResponse.class),
            @ApiResponse(code = WRONG_REQUEST_ENCKEY_CODE, message = WRONG_REQUEST_ENCKEY_TEXT, response = BaseAPIV2ErrorResponse.class),
            @ApiResponse(code = GENERAL_ERROR_CODE, message = GENERAL_ERROR_TEXT, response = BaseAPIV2ErrorResponse.class),
    })
    @ApiImplicitParams(value = {
            @ApiImplicitParam(value = "Get mini wallet balance request", required = true, dataType = "dto.partnerV2.GetWalletBalanceRequest", paramType = "body"),
            @ApiImplicitParam(value = "X-Api-Key account ID header", required = true, dataType = "String", paramType = "header", name = "X-Api-Key"),
            @ApiImplicitParam(value = "X-Request-Hash message digest header. Base64(sha1(RequestNonce+Api Secret))",
                    required = true, dataType = "String", paramType = "header", name = "X-Request-Hash"),
            @ApiImplicitParam(value = "X-Request-Nonce orderID header", required = true, dataType = "String", paramType = "header", name = "X-Request-Nonce")})
    public F.Promise<Result> getMwBalance() {

        final Authentication authData = (Authentication) ctx().args.get("authData");

        final JsonNode jsonNode = request().body().asJson();
        final GetWalletBalanceRequest createCard;
        try {
            createCard = Json.fromJson(jsonNode, GetWalletBalanceRequest.class);
        } catch (Exception ex) {
            Logger.error("Wrong request format: ", ex);
            return F.Promise.pure(createWrongRequestFormatResponse("Wrong request format"));
        }

        if (StringUtils.isBlank(createCard.getUuid())
        ) {
            Logger.error("Missing params");
            return F.Promise.pure(createWrongRequestFormatResponse("Missing request params: uuid"));
        }


        F.Promise<F.Tuple<Double, List<WalletTransaction>>> zip = F.Promise.wrap(walletTransactionRepository.retrieveSumByUUID(createCard.getUuid())).
                zip(F.Promise.wrap(walletTransactionRepository.retrieveByUuid(createCard.getUuid())));

        final F.Promise<Result> result = zip.map(card -> ok(Json.toJson(new GetWalletBalanceResponse(createCard.getUuid(), card._1.floatValue() / 100, card._2.get(0).getCurrency()))));

        return returnRecover(result);
    }


    @With(BaseMerchantApiV2Action.class)
    @ApiOperation(
            nickname = "clearMw",
            value = "Clear mini wallet balance",
            notes = "Method allows to clear mini wallet transactions",
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
            @ApiImplicitParam(value = "Clear mini wallet transaction request", required = true, dataType = "dto.partnerV2.ClearWalletRequest", paramType = "body"),
            @ApiImplicitParam(value = "X-Api-Key account ID header", required = true, dataType = "String", paramType = "header", name = "X-Api-Key"),
            @ApiImplicitParam(value = "X-Request-Hash message digest header. Base64(sha1(RequestNonce+Api Secret))",
                    required = true, dataType = "String", paramType = "header", name = "X-Request-Hash"),
            @ApiImplicitParam(value = "X-Request-Nonce orderID header", required = true, dataType = "String", paramType = "header", name = "X-Request-Nonce")})
    public F.Promise<Result> clearMw() {

        final Authentication authData = (Authentication) ctx().args.get("authData");

        final JsonNode jsonNode = request().body().asJson();
        final ClearWalletRequest createCard;
        try {
            createCard = Json.fromJson(jsonNode, ClearWalletRequest.class);
        } catch (Exception ex) {
            Logger.error("Wrong request format: ", ex);
            return F.Promise.pure(createWrongRequestFormatResponse("Wrong request format"));
        }

        if (StringUtils.isBlank(createCard.getUuid())
        ) {
            Logger.error("Missing params");
            return F.Promise.pure(createWrongRequestFormatResponse("Missing request params: uuid"));
        }

        if (StringUtils.isBlank(createCard.getAction())
        ) {
            Logger.error("Missing params");
            return F.Promise.pure(createWrongRequestFormatResponse("Missing request params: action"));
        }
        F.Promise<Boolean> action = F.Promise.pure(true);

        if (createCard.getAction().equalsIgnoreCase("delete")) {
            action = F.Promise.wrap(walletTransactionRepository.deleteAll(createCard.getUuid()));
        } else {

            action = F.Promise.wrap(walletTransactionRepository.retrieveSumByUUID(createCard.getUuid())).
                    zip(F.Promise.wrap(walletTransactionRepository.retrieveByUuid(createCard.getUuid()))).map(balance -> {
                WalletTransaction walletTransaction = new WalletTransaction();


                walletTransaction.setAmount_cts((balance._1 > 0) ? (long) -balance._1 : (long) Math.abs(balance._1));
                walletTransaction.setCurrency(balance._2.get(0).getCurrency());
                walletTransaction.setDate_added(new Date().getTime() / 1000);
                walletTransaction.setDescription("Clear wallet " + createCard.getUuid());
                walletTransaction.setDest_token(balance._2.get(0).getDest_token());
                walletTransaction.setSrc_token(balance._2.get(0).getSrc_token());
                walletTransaction.setType("load");
                walletTransaction.setUuid(createCard.getUuid());

                F.Promise.wrap(walletTransactionRepository.create(walletTransaction));

                return true;
            });
        }

        final F.Promise<Result> result = action.map(card -> ok(Json.toJson(new SuccessAPIV2Response(true))));

        return returnRecover(result);
    }


    @With(BaseMerchantApiV2Action.class)
    @ApiOperation(
            nickname = "deleteCustomer",
            value = "Delete customer",
            notes = "Method allows to remove customer",
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
            @ApiImplicitParam(value = "Remove customer request", required = true, dataType = "dto.partnerV2.RemoveCustomerRequest", paramType = "body"),
            @ApiImplicitParam(value = "X-Api-Key account ID header", required = true, dataType = "String", paramType = "header", name = "X-Api-Key"),
            @ApiImplicitParam(value = "X-Request-Hash message digest header. Base64(sha1(RequestNonce+Api Secret))",
                    required = true, dataType = "String", paramType = "header", name = "X-Request-Hash"),
            @ApiImplicitParam(value = "X-Request-Nonce orderID header", required = true, dataType = "String", paramType = "header", name = "X-Request-Nonce")})
    public F.Promise<Result> deleteCustomer() {

        final Authentication authData = (Authentication) ctx().args.get("authData");

        final JsonNode jsonNode = request().body().asJson();
        final RemoveCustomerRequest createCard;
        try {
            createCard = Json.fromJson(jsonNode, RemoveCustomerRequest.class);
        } catch (Exception ex) {
            Logger.error("Wrong request format: ", ex);
            return F.Promise.pure(createWrongRequestFormatResponse("Wrong request format"));
        }

        if (StringUtils.isBlank(createCard.getMobilePhone())
        ) {
            Logger.error("Missing params");
            return F.Promise.pure(createWrongRequestFormatResponse("Missing request params: mobile phone"));
        }

        if (StringUtils.isBlank(createCard.getCdata1())
        ) {
            Logger.error("Missing params");
            return F.Promise.pure(createWrongRequestFormatResponse("Missing request params: cdata1"));
        }

//
        final F.Promise<Result> result = F.Promise.wrap(customerRepository.retrieveById(StringUtils.removeStart(createCard.getMobilePhone(), "+"), createCard.getCdata1())).
                flatMap(res -> F.Promise.wrap(cardRepository.retrieveListByCustomerId(res.get().getId())).map(cards -> {

                    Logger.info("Customer " + res.get());
                    Logger.info("Cards " + cards.size());

                    for (Card card : cards) {

                        Boolean aBoolean = F.Promise.wrap(transactionRepository.deleteAllTransaction(card.getId())).get(10000);
                    }

                    accomplishService.updateUserEmail(res.get().getReferral(), res.get().getPhone2() + System.currentTimeMillis() + "@me.com", "" + authData.getAccount().getId()).get(10000);
                    accomplishService.updateUserPhone(res.get().getReferral(), "+" + res.get().getPhone2() + RandomStringUtils.randomNumeric(4), "" + authData.getAccount().getId()).get(10000);


                    Boolean aBoolean1 = F.Promise.wrap(cardRepository.deleteAllCards(res.get().getId())).get(10000);
                    Boolean aBoolean = F.Promise.wrap(customerRepository.deleteCustomer(res.get().getId())).get(10000);


//                    accomplishService.updateUserPhone(res.get().getReferral(), "+" + res.get().getPhone2() + "0", "" + authData.getAccount().getId()).get(10000);


                    return ok(Json.toJson(new SuccessAPIV2Response(true)));
                }));

        return returnRecover(result);
    }

    @With(BaseMerchantApiV2Action.class)
    @ApiOperation(
            nickname = "getRef",
            value = "Get transaction reference by sourceID",
            notes = "Method allows to transaction reference",
            produces = "application/json",
            consumes = "application/json",
            httpMethod = "POST",
            response = GetReferenceResponse.class
    )

    @ApiResponses(value = {
            @ApiResponse(code = SUCCESS_CODE, message = SUCCESS_TEXT, response = GetReferenceResponse.class),
            @ApiResponse(code = INCORRECT_AUTHORIZATION_DATA_CODE, message = INCORRECT_AUTHORIZATION_DATA_TEXT, response = BaseAPIV2ErrorResponse.class),
            @ApiResponse(code = INACTIVE_ACCOUNT_CODE, message = INACTIVE_ACCOUNT_TEXT, response = BaseAPIV2ErrorResponse.class),
            @ApiResponse(code = WRONG_REQUEST_FORMAT_CODE, message = WRONG_REQUEST_FORMAT_TEXT, response = BaseAPIV2ErrorResponse.class),
            @ApiResponse(code = WRONG_REQUEST_ENCKEY_CODE, message = WRONG_REQUEST_ENCKEY_TEXT, response = BaseAPIV2ErrorResponse.class),
            @ApiResponse(code = GENERAL_ERROR_CODE, message = GENERAL_ERROR_TEXT, response = BaseAPIV2ErrorResponse.class),
    })
    @ApiImplicitParams(value = {
            @ApiImplicitParam(value = "Get reference request", required = true, dataType = "dto.partnerV2.GetReferenceRequest", paramType = "body"),
            @ApiImplicitParam(value = "X-Api-Key account ID header", required = true, dataType = "String", paramType = "header", name = "X-Api-Key"),
            @ApiImplicitParam(value = "X-Request-Hash message digest header. Base64(sha1(RequestNonce+Api Secret))",
                    required = true, dataType = "String", paramType = "header", name = "X-Request-Hash"),
            @ApiImplicitParam(value = "X-Request-Nonce orderID header", required = true, dataType = "String", paramType = "header", name = "X-Request-Nonce")})
    public F.Promise<Result> getRef() {

        final Authentication authData = (Authentication) ctx().args.get("authData");

        final JsonNode jsonNode = request().body().asJson();
        final GetReferenceRequest createCard;
        try {
            createCard = Json.fromJson(jsonNode, GetReferenceRequest.class);
        } catch (Exception ex) {
            Logger.error("Wrong request format: ", ex);
            return F.Promise.pure(createWrongRequestFormatResponse("Wrong request format"));
        }

        if (StringUtils.isBlank(createCard.getSourceID())
        ) {
            Logger.error("Missing params");
            return F.Promise.pure(createWrongRequestFormatResponse("Missing request params: token"));
        }

        String reference = (String) CacheProvider.getInstance().getObject(createCard.getSourceID());

        final F.Promise<Result> result = F.Promise.pure(ok(Json.toJson(new dto.partnerV2.GetReferenceResponse(reference))));

        return returnRecover(result);
    }


}
