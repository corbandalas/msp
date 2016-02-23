package controllers.admin;

import com.fasterxml.jackson.databind.JsonNode;
import com.google.inject.Inject;
import com.wordnik.swagger.annotations.*;
import configs.Constants;
import controllers.BaseController;
import dto.*;
import model.Customer;
import model.enums.KYC;
import org.apache.commons.lang3.StringUtils;
import play.Logger;
import play.libs.F;
import play.libs.F.Promise;
import play.libs.Json;
import play.mvc.Result;
import play.mvc.With;
import repository.CustomerRepository;
import util.SecurityUtil;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;

import static configs.ReturnCodes.*;

/**
 * API customer controller
 *
 * @author nihilist - created 10.02.2016.
 * @since 0.1.0
 */
@Api(value = Constants.ADMIN_API_PATH + "/customer", description = "Operations to manage application customers stored in DB")
public class CustomerController extends BaseController {

    @Inject
    CustomerRepository customerRepository;

    @With(BaseMerchantApiAction.class)
    @ApiOperation(
            nickname = "listAllCustomers",
            value = "All customers list",
            notes = "Obtain list of all customers stored in DB",
            produces = "application/json",
            httpMethod = "GET",
            response = CustomerListResponse.class
    )
    @ApiResponses(value = {
            @ApiResponse(code = SUCCESS_CODE, message = SUCCESS_TEXT, response = CustomerListResponse.class),
            @ApiResponse(code = WRONG_REQUEST_ENCKEY_CODE, message = WRONG_REQUEST_ENCKEY_TEXT),
            @ApiResponse(code = WRONG_REQUEST_FORMAT_CODE, message = WRONG_REQUEST_FORMAT_TEXT),
            @ApiResponse(code = WRONG_CUSTOMER_ACCOUNT_CODE, message = WRONG_CUSTOMER_ACCOUNT_TEXT),
            @ApiResponse(code = GENERAL_ERROR_CODE, message = GENERAL_ERROR_TEXT),
            @ApiResponse(code = INCORRECT_AUTHORIZATION_DATA_CODE, message = INCORRECT_AUTHORIZATION_DATA_TEXT),
            @ApiResponse(code = INACTIVE_ACCOUNT_CODE, message = INACTIVE_ACCOUNT_TEXT)
    })
    @ApiImplicitParams({
            @ApiImplicitParam(value = "Account id header", required = true, dataType = "String", paramType = "header", name = "accountId"),
            @ApiImplicitParam(value = "Enckey header SHA256(accountId+orderId+secret)", required = true, dataType = "String", paramType = "header", name = "enckey"),
            @ApiImplicitParam(value = "orderId header", required = true, dataType = "String", paramType = "header", name = "orderId")})
    public Promise<Result> retrieveAll() {

        final Authentication authData = (Authentication) ctx().args.get("authData");

        if (!authData.getEnckey().equalsIgnoreCase(SecurityUtil.generateKeyFromArray(authData.getAccount().getId().toString(),
                authData.getOrderId(), authData.getAccount().getSecret()))) {
            Logger.error("Provided and calculated enckeys do not match");
            return Promise.pure(createWrongEncKeyResponse());
        }

        final F.Promise<Result> result = F.Promise.wrap(customerRepository.retrieveAll()).map(customers -> ok(Json.toJson(new CustomerListResponse(""+SUCCESS_CODE, SUCCESS_TEXT, customers))));

        return returnRecover(result);
    }

    @With(BaseMerchantApiAction.class)
    @ApiOperation(
            nickname = "retrieveByPhone",
            value = "Retrieve customer by phone",
            notes = "Get customer by its phone",
            produces = "application/json",
            httpMethod = "GET",
            response = CustomerResponse.class
    )

    @ApiResponses(value = {
            @ApiResponse(code = SUCCESS_CODE, message = SUCCESS_TEXT, response = CustomerResponse.class),
            @ApiResponse(code = WRONG_REQUEST_ENCKEY_CODE, message = WRONG_REQUEST_ENCKEY_TEXT),
            @ApiResponse(code = WRONG_REQUEST_FORMAT_CODE, message = WRONG_REQUEST_FORMAT_TEXT),
            @ApiResponse(code = WRONG_CUSTOMER_ACCOUNT_CODE, message = WRONG_CUSTOMER_ACCOUNT_TEXT),
            @ApiResponse(code = GENERAL_ERROR_CODE, message = GENERAL_ERROR_TEXT),
            @ApiResponse(code = INCORRECT_AUTHORIZATION_DATA_CODE, message = INCORRECT_AUTHORIZATION_DATA_TEXT),
            @ApiResponse(code = INACTIVE_ACCOUNT_CODE, message = INACTIVE_ACCOUNT_TEXT)
    })
    @ApiImplicitParams({
            @ApiImplicitParam(name = "phone", value = "Phone to retrieve", required = true, dataType = "string", paramType = "path"),
            @ApiImplicitParam(value = "Account id header", required = true, dataType = "String", paramType = "header", name = "accountId"),
            @ApiImplicitParam(value = "Enckey header SHA256(accountId+phone+orderId+secret)", required = true, dataType = "String", paramType = "header", name = "enckey"),
            @ApiImplicitParam(value = "orderId header", required = true, dataType = "String", paramType = "header", name = "orderId")})
    public Promise<Result> retrieveByPhone(String phone) {

        final Authentication authData = (Authentication) ctx().args.get("authData");

        if (StringUtils.isBlank(phone)) {

            return Promise.pure(createWrongRequestFormatResponse());
        }

        if (!authData.getEnckey().equalsIgnoreCase(SecurityUtil.generateKeyFromArray(authData.getAccount().getId().toString(),
                phone, authData.getOrderId(), authData.getAccount().getSecret()))) {
            Logger.error("Provided and calculated enckeys do not match");
            return Promise.pure(createWrongEncKeyResponse());
        }

        final F.Promise<Result> result = F.Promise.wrap(customerRepository.retrieveById(phone)).map(operationOpt
                -> operationOpt.map(customer -> ok(Json.toJson(new CustomerResponse(""+SUCCESS_CODE, SUCCESS_TEXT, customer))))
                .orElse(createWrongCustomerAccountResponse()));

        return returnRecover(result);
    }

    @With(BaseMerchantApiAction.class)
    @ApiOperation(
            nickname = "retrieveByRegistrationDate",
            value = "Retrieve customers by registration date",
            notes = "Get customer by registration date",
            produces = "application/json",
            httpMethod = "GET",
            response = CustomerListResponse.class
    )

    @ApiResponses(value = {
            @ApiResponse(code = SUCCESS_CODE, message = SUCCESS_TEXT, response = CustomerListResponse.class),
            @ApiResponse(code = WRONG_REQUEST_ENCKEY_CODE, message = WRONG_REQUEST_ENCKEY_TEXT),
            @ApiResponse(code = WRONG_REQUEST_FORMAT_CODE, message = WRONG_REQUEST_FORMAT_TEXT),
            @ApiResponse(code = WRONG_CUSTOMER_ACCOUNT_CODE, message = WRONG_CUSTOMER_ACCOUNT_TEXT),
            @ApiResponse(code = GENERAL_ERROR_CODE, message = GENERAL_ERROR_TEXT),
            @ApiResponse(code = INCORRECT_AUTHORIZATION_DATA_CODE, message = INCORRECT_AUTHORIZATION_DATA_TEXT),
            @ApiResponse(code = INACTIVE_ACCOUNT_CODE, message = INACTIVE_ACCOUNT_TEXT)
    })
    @ApiImplicitParams({
            @ApiImplicitParam(name = "startDate", value = "startDate to retrieve (yyyy-MM-dd)", required = true, dataType = "string", paramType = "path"),
            @ApiImplicitParam(name = "endDate", value = "endDate to retrieve (yyyy-MM-dd)", required = true, dataType = "string", paramType = "path"),
            @ApiImplicitParam(value = "Account id header", required = true, dataType = "String", paramType = "header", name = "accountId"),
            @ApiImplicitParam(value = "Enckey header SHA256(accountId+startDate+endDate+orderId+secret)", required = true, dataType = "String", paramType = "header", name = "enckey"),
            @ApiImplicitParam(value = "orderId header", required = true, dataType = "String", paramType = "header", name = "orderId")})
    public Promise<Result> retrieveByRegistrationDate(String startDate, String endDate) {

        final Authentication authData = (Authentication) ctx().args.get("authData");

        if (StringUtils.isBlank(startDate) || StringUtils.isBlank(endDate)) {
            return Promise.pure(createWrongRequestFormatResponse());
        }

        Date parsedStartDate;
        Date parsedEndDate;
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            parsedStartDate = simpleDateFormat.parse(startDate);
            parsedEndDate = simpleDateFormat.parse(endDate);
        } catch (ParseException e) {
            return Promise.pure(createWrongRequestFormatResponse());
        }

        if (!authData.getEnckey().equalsIgnoreCase(SecurityUtil.generateKeyFromArray(authData.getAccount().getId().toString(),
                startDate, endDate, authData.getOrderId(), authData.getAccount().getSecret()))) {
            Logger.error("Provided and calculated enckeys do not match");
            return Promise.pure(createWrongEncKeyResponse());
        }

        final Promise<Result> result = Promise.wrap(customerRepository.retrieveByRegistrationDate(parsedStartDate, parsedEndDate)).map(countries -> ok(Json.toJson(new CustomerListResponse(""+SUCCESS_CODE, SUCCESS_TEXT, countries))));

        return returnRecover(result);
    }

    @With(BaseMerchantApiAction.class)
    @ApiOperation(
            nickname = "retrieveByKYC",
            value = "Retrieve customers by KYC",
            notes = "Get customers by KYC",
            produces = "application/json",
            httpMethod = "GET",
            response = CustomerListResponse.class
    )

    @ApiResponses(value = {
            @ApiResponse(code = SUCCESS_CODE, message = SUCCESS_TEXT, response = CustomerListResponse.class),
            @ApiResponse(code = WRONG_REQUEST_ENCKEY_CODE, message = WRONG_REQUEST_ENCKEY_TEXT),
            @ApiResponse(code = WRONG_REQUEST_FORMAT_CODE, message = WRONG_REQUEST_FORMAT_TEXT),
            @ApiResponse(code = WRONG_CUSTOMER_ACCOUNT_CODE, message = WRONG_CUSTOMER_ACCOUNT_TEXT),
            @ApiResponse(code = GENERAL_ERROR_CODE, message = GENERAL_ERROR_TEXT),
            @ApiResponse(code = INCORRECT_AUTHORIZATION_DATA_CODE, message = INCORRECT_AUTHORIZATION_DATA_TEXT),
            @ApiResponse(code = INACTIVE_ACCOUNT_CODE, message = INACTIVE_ACCOUNT_TEXT)
    })
    @ApiImplicitParams({
            @ApiImplicitParam(name = "kyc", value = "kyc to retrieve customers", required = true, dataType = "string", paramType = "path"),
            @ApiImplicitParam(value = "Account id header", required = true, dataType = "String", paramType = "header", name = "accountId"),
            @ApiImplicitParam(value = "Enckey header SHA256(accountId+kyc+orderId+secret)", required = true, dataType = "String", paramType = "header", name = "enckey"),
            @ApiImplicitParam(value = "orderId header", required = true, dataType = "String", paramType = "header", name = "orderId")})
    public Promise<Result> retrieveByKYC(String kyc) {

        final Authentication authData = (Authentication) ctx().args.get("authData");

        if (StringUtils.isBlank(kyc)) {
            return Promise.pure(createWrongRequestFormatResponse());
        }

        if (!authData.getEnckey().equalsIgnoreCase(SecurityUtil.generateKeyFromArray(authData.getAccount().getId().toString(),
                kyc, authData.getOrderId(), authData.getAccount().getSecret()))) {
            Logger.error("Provided and calculated enckeys do not match");
            return Promise.pure(createWrongEncKeyResponse());
        }

        final Promise<Result> result = Promise.wrap(customerRepository.retrieveByKYC(KYC.valueOf(kyc))).map(countries -> ok(Json.toJson(new CustomerListResponse(""+SUCCESS_CODE, SUCCESS_TEXT, countries))));

        return returnRecover(result);
    }

    @With(BaseMerchantApiAction.class)
    @ApiOperation(
            nickname = "retrieveByEmail",
            value = "Retrieve customers by email",
            notes = "Get customers by email",
            produces = "application/json",
            httpMethod = "GET",
            response = CustomerListResponse.class
    )

    @ApiResponses(value = {
            @ApiResponse(code = SUCCESS_CODE, message = SUCCESS_TEXT, response = CustomerListResponse.class),
            @ApiResponse(code = WRONG_REQUEST_ENCKEY_CODE, message = WRONG_REQUEST_ENCKEY_TEXT),
            @ApiResponse(code = WRONG_REQUEST_FORMAT_CODE, message = WRONG_REQUEST_FORMAT_TEXT),
            @ApiResponse(code = WRONG_CUSTOMER_ACCOUNT_CODE, message = WRONG_CUSTOMER_ACCOUNT_TEXT),
            @ApiResponse(code = GENERAL_ERROR_CODE, message = GENERAL_ERROR_TEXT),
            @ApiResponse(code = INCORRECT_AUTHORIZATION_DATA_CODE, message = INCORRECT_AUTHORIZATION_DATA_TEXT),
            @ApiResponse(code = INACTIVE_ACCOUNT_CODE, message = INACTIVE_ACCOUNT_TEXT)
    })
    @ApiImplicitParams({
            @ApiImplicitParam(name = "email", value = "email to retrieve customers", required = true, dataType = "string", paramType = "path"),
            @ApiImplicitParam(value = "Account id header", required = true, dataType = "String", paramType = "header", name = "accountId"),
            @ApiImplicitParam(value = "Enckey header SHA256(accountId+email+orderId+secret)", required = true, dataType = "String", paramType = "header", name = "enckey"),
            @ApiImplicitParam(value = "orderId header", required = true, dataType = "String", paramType = "header", name = "orderId")})
    public Promise<Result> retrieveByEmail(String email) {

        final Authentication authData = (Authentication) ctx().args.get("authData");

        if (StringUtils.isBlank(email)) {
            return Promise.pure(createWrongRequestFormatResponse());
        }

        if (!authData.getEnckey().equalsIgnoreCase(SecurityUtil.generateKeyFromArray(authData.getAccount().getId().toString(),
                email, authData.getOrderId(), authData.getAccount().getSecret()))) {
            Logger.error("Provided and calculated enckeys do not match");
            return Promise.pure(createWrongEncKeyResponse());
        }

        final Promise<Result> result = Promise.wrap(customerRepository.retrieveByEmail(email)).map(countries -> ok(Json.toJson(new CustomerListResponse(""+SUCCESS_CODE, SUCCESS_TEXT, countries))));

        return returnRecover(result);
    }

    @With(BaseMerchantApiAction.class)
    @ApiOperation(
            nickname = "updateCustomer",
            value = "Update existed customer",
            notes = "Update existed application customer in DB",
            produces = "application/json",
            consumes = "application/json",
            httpMethod = "POST",
            response = BaseAPIResponse.class
    )
    @ApiResponses(value = {
            @ApiResponse(code = SUCCESS_CODE, message = SUCCESS_TEXT, response = BaseAPIResponse.class),
            @ApiResponse(code = WRONG_REQUEST_ENCKEY_CODE, message = WRONG_REQUEST_ENCKEY_TEXT),
            @ApiResponse(code = WRONG_REQUEST_FORMAT_CODE, message = WRONG_REQUEST_FORMAT_TEXT),
            @ApiResponse(code = WRONG_CUSTOMER_ACCOUNT_CODE, message = WRONG_CUSTOMER_ACCOUNT_TEXT),
            @ApiResponse(code = GENERAL_ERROR_CODE, message = GENERAL_ERROR_TEXT),
            @ApiResponse(code = INCORRECT_AUTHORIZATION_DATA_CODE, message = INCORRECT_AUTHORIZATION_DATA_TEXT),
            @ApiResponse(code = INACTIVE_ACCOUNT_CODE, message = INACTIVE_ACCOUNT_TEXT)
    })
    @ApiImplicitParams({
            @ApiImplicitParam(value = "Customer request", required = true, dataType = "model.Customer", paramType = "body"),
            @ApiImplicitParam(value = "Account id header", required = true, dataType = "String", paramType = "header", name = "accountId"),
            @ApiImplicitParam(value = "Enckey header SHA256(accountId+customer.id+orderId+secret)", required = true, dataType = "String", paramType = "header", name = "enckey"),
            @ApiImplicitParam(value = "orderId header", required = true, dataType = "String", paramType = "header", name = "orderId")})
    public Promise<Result> update() {

        final Authentication authData = (Authentication) ctx().args.get("authData");

        final JsonNode jsonNode = request().body().asJson();

        Customer customer = null;

        try {
            customer = Json.fromJson(jsonNode, Customer.class);

            if (!authData.getEnckey().equalsIgnoreCase(SecurityUtil.generateKeyFromArray(authData.getAccount().getId().toString(),
                    customer.getId(), authData.getOrderId(), authData.getAccount().getSecret()))) {
                Logger.error("Provided and calculated enckeys do not match");
                return Promise.pure(createWrongEncKeyResponse());
            }

        } catch (Exception e) {
            Logger.error("Wrong request format:", e);

            return Promise.pure(createWrongRequestFormatResponse());
        }

        final Promise<Customer> customerPromise = Promise.wrap(customerRepository.update(customer));

        Promise<Result> result = customerPromise.map(res -> ok(Json.toJson(createResponse(""+SUCCESS_CODE, SUCCESS_TEXT))));

        return returnRecover(result);
    }

    @With(BaseMerchantApiAction.class)
    @ApiOperation(
            nickname = "createCustomer",
            value = "Create customer",
            notes = "Create customer in DB",
            produces = "application/json",
            consumes = "application/json",
            httpMethod = "POST",
            response = BaseAPIResponse.class
    )

    @ApiResponses(value = {
            @ApiResponse(code = SUCCESS_CODE, message = SUCCESS_TEXT, response = BaseAPIResponse.class),
            @ApiResponse(code = WRONG_REQUEST_ENCKEY_CODE, message = WRONG_REQUEST_ENCKEY_TEXT),
            @ApiResponse(code = WRONG_REQUEST_FORMAT_CODE, message = WRONG_REQUEST_FORMAT_TEXT),
            @ApiResponse(code = WRONG_CUSTOMER_ACCOUNT_CODE, message = WRONG_CUSTOMER_ACCOUNT_TEXT),
            @ApiResponse(code = GENERAL_ERROR_CODE, message = GENERAL_ERROR_TEXT),
            @ApiResponse(code = INCORRECT_AUTHORIZATION_DATA_CODE, message = INCORRECT_AUTHORIZATION_DATA_TEXT),
            @ApiResponse(code = INACTIVE_ACCOUNT_CODE, message = INACTIVE_ACCOUNT_TEXT)
    })
    @ApiImplicitParams(value = {
            @ApiImplicitParam(value = "Customer request", required = true, dataType = "model.Customer", paramType = "body"),
            @ApiImplicitParam(value = "Account id header", required = true, dataType = "String", paramType = "header", name = "accountId"),
            @ApiImplicitParam(value = "Enckey header. SHA256(accountId+customer.id+customer.firstName+orderId+secret)",
                    required = true, dataType = "String", paramType = "header", name = "enckey"),
            @ApiImplicitParam(value = "orderId header", required = true, dataType = "String", paramType = "header", name = "orderId")})
    public Promise<Result> create() {

        final Authentication authData = (Authentication) ctx().args.get("authData");

        final JsonNode jsonNode = request().body().asJson();
        final Customer customer;
        try {
            customer = Json.fromJson(jsonNode, Customer.class);
        } catch (Exception e) {
            Logger.error("Wrong request format: ",e);
            return Promise.pure(createWrongRequestFormatResponse());
        }

        if (StringUtils.isBlank(customer.getId()) || StringUtils.isBlank(customer.getAddress1()) || StringUtils.isBlank(customer.getAddress2())) {
            Logger.error("Missing params");
            return Promise.pure(createWrongRequestFormatResponse());
        }

        if (!authData.getEnckey().equalsIgnoreCase(SecurityUtil.generateKeyFromArray(authData.getAccount().getId().toString(),
                customer.getId(), customer.getFirstName(), authData.getOrderId(),
                authData.getAccount().getSecret()))) {
            Logger.error("Provided and calculated enckeys do not match");
            return Promise.pure(createWrongEncKeyResponse());
        }

        if (customer.getRegistrationDate() == null) customer.setRegistrationDate(new Date());

        customer.setTemppassword(true);

        final Promise<Result> result = Promise.wrap(customerRepository.create(customer)).map(res ->
                ok(Json.toJson(new CustomerResponse(""+SUCCESS_CODE, SUCCESS_TEXT, res))));

        return returnRecover(result);
    }

}