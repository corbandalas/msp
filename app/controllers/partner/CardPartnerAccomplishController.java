package controllers.partner;

import accomplish.dto.user.CreateUserResponse;
import com.fasterxml.jackson.databind.JsonNode;
import com.google.inject.Inject;
import com.wordnik.swagger.annotations.*;
import configs.Constants;
import controllers.BaseAccomplishController;
import controllers.admin.BaseMerchantApiAction;
import controllers.admin.BaseMerchantApiV2Action;
import dto.Authentication;
import dto.BaseAPIResponse;
import dto.partnerV2.CreateCustomerIdentificationRequest;
import dto.partnerV2.CreateCustomerIdentificationResponse;
import dto.partnerV2.CreateCustomerRequest;
import dto.partnerV2.CreateCustomerResponse;
import exception.CustomerAlreadyRegisteredException;
import exception.WrongCountryException;
import exception.WrongPhoneNumberException;
import model.Country;
import model.Customer;
import model.enums.KYC;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;
import play.Logger;
import play.libs.F;
import play.libs.Json;
import play.mvc.Result;
import play.mvc.With;
import repository.CountryRepository;
import repository.CurrencyRepository;
import repository.CustomerRepository;
import services.AccomplishService;
import util.DateUtil;
import util.SecurityUtil;
import util.Utils;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import static configs.ReturnCodes.*;


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
    CustomerRepository customerRepository;

    @Inject
    CountryRepository countryRepository;

    @Inject
    AccomplishService accomplishService;

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
            @ApiResponse(code = INCORRECT_AUTHORIZATION_DATA_CODE, message = INCORRECT_AUTHORIZATION_DATA_TEXT, response = BaseAPIResponse.class),
            @ApiResponse(code = INACTIVE_ACCOUNT_CODE, message = INACTIVE_ACCOUNT_TEXT, response = BaseAPIResponse.class),
            @ApiResponse(code = WRONG_REQUEST_FORMAT_CODE, message = WRONG_REQUEST_FORMAT_TEXT, response = BaseAPIResponse.class),
            @ApiResponse(code = WRONG_REQUEST_ENCKEY_CODE, message = WRONG_REQUEST_ENCKEY_TEXT, response = BaseAPIResponse.class),
            @ApiResponse(code = GENERAL_ERROR_CODE, message = GENERAL_ERROR_TEXT, response = BaseAPIResponse.class),
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

        if (StringUtils.isNoneBlank(createCard.getPassword())) {
            customer.setPassword(SecurityUtil.generateKeyFromArray(createCard.getPassword()));
        }

        try {

            customer.setKyc(KYC.NONE);

            Date dob = DateUtil.parse(createCard.getBirthdayDate(), "DD/MM/YYYY");

            customer.setDateBirth(dob);

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

            if (!Utils.isValidPhoneNumber(createCard.getMobilePhone(), country.get().getCode())) {
                throw new WrongPhoneNumberException();
            }

            F.Promise<CreateUserResponse> userResponsePromise = accomplishService.createUser(createCard.getEmail(), createCard.getTitle(), createCard.getFirstName(),
                    createCard.getLastName(), createCard.getBirthdayDate(), createCard.getMobilePhone(),
                    createCard.getNationality(), createCard.getKycLevel(), createCard.getAddress1(),
                    createCard.getAddress2(), createCard.getCity(), createCard.getZip(), country.get().getCode(),
                    createCard.getLang(), createCard.getPassword(), "" + authData.getAccount().getId());


            return userResponsePromise.map(rez -> {

                customer.setReferral("" + rez.getInfo().getId());

                customerRepository.create(customer);

                return ok(Json.toJson(new CreateCustomerResponse(new dto.partnerV2.entity.Customer(createCard.getEmail(), createCard.getTitle(), createCard.getFirstName(),
                        createCard.getLastName(), createCard.getBirthdayDate(), createCard.getMobilePhone(),
                        createCard.getNationality(), createCard.getKycLevel(), createCard.getAddress1(),
                        createCard.getAddress2(), createCard.getCity(), createCard.getZip(), country.get().getCode()))));
            });

        });


        return returnRecover(result);
    }


    @With(BaseMerchantApiAction.class)
    @ApiOperation(
            nickname = "createIdentification",
            value = "Create identification",
            notes = "Method allows to create identification",
            produces = "application/json",
            consumes = "application/json",
            httpMethod = "POST",
            response = CreateCustomerResponse.class
    )

    @ApiResponses(value = {
            @ApiResponse(code = SUCCESS_CODE, message = SUCCESS_TEXT, response = CreateCustomerIdentificationResponse.class),
            @ApiResponse(code = INCORRECT_AUTHORIZATION_DATA_CODE, message = INCORRECT_AUTHORIZATION_DATA_TEXT, response = BaseAPIResponse.class),
            @ApiResponse(code = INACTIVE_ACCOUNT_CODE, message = INACTIVE_ACCOUNT_TEXT, response = BaseAPIResponse.class),
            @ApiResponse(code = WRONG_REQUEST_FORMAT_CODE, message = WRONG_REQUEST_FORMAT_TEXT, response = BaseAPIResponse.class),
            @ApiResponse(code = WRONG_REQUEST_ENCKEY_CODE, message = WRONG_REQUEST_ENCKEY_TEXT, response = BaseAPIResponse.class),
            @ApiResponse(code = GENERAL_ERROR_CODE, message = GENERAL_ERROR_TEXT, response = BaseAPIResponse.class),
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
                StringUtils.isBlank(createCard.getEmail())
        ) {
            Logger.error("Missing params");
            return F.Promise.pure(createWrongRequestFormatResponse("Missing request params"));
        }


        F.Promise<Result> result = accomplishService.createIdentification(createCard.getUserID(), createCard.getIssuanceCountry(),
                createCard.getResidenceCountry(), createCard.getIssueDate(), createCard.getExpiryDate(),
                createCard.getType(), createCard.getNumber(), "" + authData.getAccount().getId())
                .map(res -> ok(Json.toJson(new CreateCustomerIdentificationResponse(SUCCESS_TEXT, String.valueOf(SUCCESS_CODE), res))));


        return returnRecover(result);
    }


}
