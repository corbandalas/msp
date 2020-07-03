package controllers.partner;

import accomplish.dto.user.CreateUserResponse;
import com.fasterxml.jackson.databind.JsonNode;
import com.google.inject.Inject;
import com.wordnik.swagger.annotations.*;
import configs.Constants;
import controllers.BaseController;
import controllers.admin.BaseMerchantApiAction;
import dto.Authentication;
import dto.BaseAPIResponse;
import dto.partner.*;
import dto.partnerV2.CreateCustomerIdentificationRequest;
import dto.partnerV2.CreateCustomerIdentificationResponse;
import dto.partnerV2.CreateCustomerRequest;
import dto.partnerV2.CreateCustomerResponse;
import model.Card;
import model.Country;
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
import repository.CountryRepository;
import repository.CurrencyRepository;
import services.AccomplishService;
import services.W2GlobaldataService;
import util.DateUtil;
import util.SecurityUtil;

import java.util.Date;
import java.util.Optional;

import static configs.ReturnCodes.*;


/**
 * Partner card provider API controller
 *
 * @author corbandalas created 02.07.2020.
 * @since 0.6.0
 */
@Api(value = Constants.PARTNERV2_API_PATH, description = "Partner API v2")
public class CardPartnerAccomplishController extends BaseController {

    @Inject
    CurrencyRepository currencyRepository;

    @Inject
    CountryRepository countryRepository;

    @Inject
    AccomplishService accomplishService;

    @With(BaseMerchantApiAction.class)
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
            @ApiImplicitParam(value = "Create card request", required = true, dataType = "dto.partnerv2.CreateCustomerRequest", paramType = "body"),
            @ApiImplicitParam(value = "Account id header", required = true, dataType = "String", paramType = "header", name = "accountId"),
            @ApiImplicitParam(value = "Enckey header. SHA256(accountId+orderId+mobilePhone+firstName+lastName+email+secret)",
                    required = true, dataType = "String", paramType = "header", name = "enckey"),
            @ApiImplicitParam(value = "orderId header", required = true, dataType = "String", paramType = "header", name = "orderId")})
    public F.Promise<Result> createCustomer() {

        final Authentication authData = (Authentication) ctx().args.get("authData");

        final JsonNode jsonNode = request().body().asJson();
        final CreateCustomerRequest createCard;
        try {
            createCard = Json.fromJson(jsonNode, CreateCustomerRequest.class);
        } catch (Exception ex) {
            Logger.error("Wrong request format: ", ex);
            return F.Promise.pure(createWrongRequestFormatResponse());
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
            return F.Promise.pure(createWrongRequestFormatResponse());
        }


        if (!authData.getEnckey().equalsIgnoreCase(SecurityUtil.generateKeyFromArray(authData.getAccount().getId().toString(), authData.getOrderId(),
                createCard.getMobilePhone(), createCard.getFirstName(), createCard.getLastName(), createCard.getEmail(), authData.getAccount().getSecret()))) {
            Logger.error("Provided and calculated enckeys do not match");
            return F.Promise.pure(createWrongEncKeyResponse());
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


        try {

//            KYC kyc = KYC.valueOf(createCard.getKyc().toUpperCase());

            customer.setKyc(KYC.SIMPLIFIED_DUE_DILIGENCE);

            Date dob = DateUtil.parse(createCard.getBirthdayDate(), "DD/MM/YYYY");

            customer.setDateBirth(dob);

        } catch (Exception ex) {
            Logger.error("Wrong request format: ", ex);
            return F.Promise.pure(createWrongRequestFormatResponse());
        }


        final F.Promise<Optional<Country>> countryPromise = F.Promise.wrap(countryRepository.retrieveById(createCard.getCountry()));

        F.Promise<Result> result = countryPromise.flatMap(country -> {

            F.Promise<CreateUserResponse> userResponsePromise = accomplishService.createUser(createCard.getEmail(), createCard.getTitle(), createCard.getFirstName(),
                    createCard.getLastName(), createCard.getBirthdayDate(), createCard.getMobilePhone(),
                    createCard.getNationality(), createCard.getKycLevel(), createCard.getAddress1(),
                    createCard.getAddress2(), createCard.getCity(), createCard.getZip(), country.get().getCode(),
                    createCard.getLang(), createCard.getPassword(), "" + authData.getAccount().getId());


            return userResponsePromise.map(res -> ok(Json.toJson(new CreateCustomerResponse(SUCCESS_TEXT, String.valueOf(SUCCESS_CODE), res))));

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
            @ApiImplicitParam(value = "Account id header", required = true, dataType = "String", paramType = "header", name = "accountId"),
            @ApiImplicitParam(value = "Enckey header. SHA256(accountId+orderId+number+type+userID+secret)",
                    required = true, dataType = "String", paramType = "header", name = "enckey"),
            @ApiImplicitParam(value = "orderId header", required = true, dataType = "String", paramType = "header", name = "orderId")})
    public F.Promise<Result> createIdentification() {

        final Authentication authData = (Authentication) ctx().args.get("authData");

        final JsonNode jsonNode = request().body().asJson();
        final CreateCustomerIdentificationRequest createCard;
        try {
            createCard = Json.fromJson(jsonNode, CreateCustomerIdentificationRequest.class);
        } catch (Exception ex) {
            Logger.error("Wrong request format: ", ex);
            return F.Promise.pure(createWrongRequestFormatResponse());
        }

        if (StringUtils.isBlank(createCard.getNumber()) ||
                StringUtils.isBlank(createCard.getType()) ||
                StringUtils.isBlank(createCard.getExpiryDate()) ||
                StringUtils.isBlank(createCard.getIssuanceCountry()) ||
                StringUtils.isBlank(createCard.getResidenceCountry()) ||
                StringUtils.isBlank(createCard.getUserID())
                ) {
            Logger.error("Missing params");
            return F.Promise.pure(createWrongRequestFormatResponse());
        }


        if (!authData.getEnckey().equalsIgnoreCase(SecurityUtil.generateKeyFromArray(authData.getAccount().getId().toString(), authData.getOrderId(),
                createCard.getNumber(), createCard.getType(), createCard.getUserID(), authData.getAccount().getSecret()))) {
            Logger.error("Provided and calculated enckeys do not match");
            return F.Promise.pure(createWrongEncKeyResponse());
        }


        F.Promise<Result> result = accomplishService.createIdentification(createCard.getUserID(), createCard.getIssuanceCountry(),
                createCard.getResidenceCountry(), createCard.getIssueDate(), createCard.getExpiryDate(),
                createCard.getType(), createCard.getNumber(), "" + authData.getAccount().getId())
                .map(res -> ok(Json.toJson(new CreateCustomerIdentificationResponse(SUCCESS_TEXT, String.valueOf(SUCCESS_CODE), res))));


        return returnRecover(result);
    }



}
