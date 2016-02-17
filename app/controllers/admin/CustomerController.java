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
            @ApiResponse(code = 0, message = "OK", response = CustomerListResponse.class),
            @ApiResponse(code = 1, message = "DB error"),
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
            return Promise.pure(ok(Json.toJson(createResponse("1", "Specified account does not exist or inactive"))));
        }

        final F.Promise<Result> result = F.Promise.wrap(customerRepository.retrieveAll()).map(customers -> ok(Json.toJson(new CustomerListResponse("0", "OK", customers))));

        return result.recover(error -> {
            Logger.error("Error:", error);
            return ok(Json.toJson(createResponse("6", error.getMessage())));
        });
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
            @ApiResponse(code = 0, message = "OK", response = CustomerResponse.class),
            @ApiResponse(code = 1, message = "Wrong request format"),
            @ApiResponse(code = 2, message = "DB error")
    })
    @ApiImplicitParams({
            @ApiImplicitParam(name = "phone", value = "Phone to retrieve", required = true, dataType = "string", paramType = "path"),
            @ApiImplicitParam(value = "Account id header", required = true, dataType = "String", paramType = "header", name = "accountId"),
            @ApiImplicitParam(value = "Enckey header SHA256(accountId+phone+orderId+secret)", required = true, dataType = "String", paramType = "header", name = "enckey"),
            @ApiImplicitParam(value = "orderId header", required = true, dataType = "String", paramType = "header", name = "orderId")})
    public Promise<Result> retrieveByPhone(String phone) {

        final Authentication authData = (Authentication) ctx().args.get("authData");

        if (StringUtils.isBlank(phone)) {

            return Promise.pure(badRequest(Json.toJson(createResponse("1", "Wrong request format"))));
        }

        if (!authData.getEnckey().equalsIgnoreCase(SecurityUtil.generateKeyFromArray(authData.getAccount().getId().toString(),
                phone, authData.getOrderId(), authData.getAccount().getSecret()))) {
            Logger.error("Provided and calculated enckeys do not match");
            return Promise.pure(ok(Json.toJson(createResponse("1", "Specified account does not exist or inactive"))));
        }

        final F.Promise<Result> result = F.Promise.wrap(customerRepository.retrieveById(phone)).map(operationOpt
                -> operationOpt.map(customer -> ok(Json.toJson(new CustomerResponse("0", "OK", customer))))
                .orElse(ok(Json.toJson(createResponse("4", "Specified operation does not exist")))));

        return result.recover(error -> {

                    Logger.error("Error:", error);

                    return ok(Json.toJson(createResponse("2", error.getMessage())));

                }
        );
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
            @ApiResponse(code = 0, message = "OK", response = CustomerListResponse.class),
            @ApiResponse(code = 1, message = "Wrong request format"),
            @ApiResponse(code = 2, message = "DB error")
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
            return Promise.pure(badRequest(Json.toJson(createResponse("1", "Wrong request format"))));
        }

        Date parsedStartDate;
        Date parsedEndDate;
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            parsedStartDate = simpleDateFormat.parse(startDate);
            parsedEndDate = simpleDateFormat.parse(endDate);
        } catch (ParseException e) {
            return Promise.pure(badRequest(Json.toJson(createResponse("1", "Wrong request format"))));
        }

        if (!authData.getEnckey().equalsIgnoreCase(SecurityUtil.generateKeyFromArray(authData.getAccount().getId().toString(),
                startDate, endDate, authData.getOrderId(), authData.getAccount().getSecret()))) {
            Logger.error("Provided and calculated enckeys do not match");
            return Promise.pure(ok(Json.toJson(createResponse("1", "Specified account does not exist or inactive"))));
        }

        final Promise<Result> result = Promise.wrap(customerRepository.retrieveByRegistrationDate(parsedStartDate, parsedEndDate)).map(countries -> ok(Json.toJson(new CustomerListResponse("0", "OK", countries))));

        return result.recover(error -> {

                    Logger.error("Error:", error);

                    return ok(Json.toJson(createResponse("2", error.getMessage())));

                }
        );
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
            @ApiResponse(code = 0, message = "OK", response = CustomerListResponse.class),
            @ApiResponse(code = 1, message = "Wrong request format"),
            @ApiResponse(code = 2, message = "DB error")
    })
    @ApiImplicitParams({
            @ApiImplicitParam(name = "kyc", value = "kyc to retrieve customers", required = true, dataType = "string", paramType = "path"),
            @ApiImplicitParam(value = "Account id header", required = true, dataType = "String", paramType = "header", name = "accountId"),
            @ApiImplicitParam(value = "Enckey header SHA256(accountId+kyc+orderId+secret)", required = true, dataType = "String", paramType = "header", name = "enckey"),
            @ApiImplicitParam(value = "orderId header", required = true, dataType = "String", paramType = "header", name = "orderId")})
    public Promise<Result> retrieveByKYC(String kyc) {

        final Authentication authData = (Authentication) ctx().args.get("authData");

        if (StringUtils.isBlank(kyc)) {
            return Promise.pure(badRequest(Json.toJson(createResponse("1", "Wrong request format"))));
        }

        if (!authData.getEnckey().equalsIgnoreCase(SecurityUtil.generateKeyFromArray(authData.getAccount().getId().toString(),
                kyc, authData.getOrderId(), authData.getAccount().getSecret()))) {
            Logger.error("Provided and calculated enckeys do not match");
            return Promise.pure(ok(Json.toJson(createResponse("1", "Specified account does not exist or inactive"))));
        }

        final Promise<Result> result = Promise.wrap(customerRepository.retrieveByKYC(KYC.valueOf(kyc))).map(countries -> ok(Json.toJson(new CustomerListResponse("0", "OK", countries))));

        return result.recover(error -> {

                    Logger.error("Error:", error);

                    return ok(Json.toJson(createResponse("2", error.getMessage())));

                }
        );
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
            @ApiResponse(code = 0, message = "OK", response = CustomerListResponse.class),
            @ApiResponse(code = 1, message = "Wrong request format"),
            @ApiResponse(code = 2, message = "DB error")
    })
    @ApiImplicitParams({
            @ApiImplicitParam(name = "email", value = "email to retrieve customers", required = true, dataType = "string", paramType = "path"),
            @ApiImplicitParam(value = "Account id header", required = true, dataType = "String", paramType = "header", name = "accountId"),
            @ApiImplicitParam(value = "Enckey header SHA256(accountId+email+orderId+secret)", required = true, dataType = "String", paramType = "header", name = "enckey"),
            @ApiImplicitParam(value = "orderId header", required = true, dataType = "String", paramType = "header", name = "orderId")})
    public Promise<Result> retrieveByEmail(String email) {

        final Authentication authData = (Authentication) ctx().args.get("authData");

        if (StringUtils.isBlank(email)) {
            return Promise.pure(badRequest(Json.toJson(createResponse("1", "Wrong request format"))));
        }

        if (!authData.getEnckey().equalsIgnoreCase(SecurityUtil.generateKeyFromArray(authData.getAccount().getId().toString(),
                email, authData.getOrderId(), authData.getAccount().getSecret()))) {
            Logger.error("Provided and calculated enckeys do not match");
            return Promise.pure(ok(Json.toJson(createResponse("1", "Specified account does not exist or inactive"))));
        }

        final Promise<Result> result = Promise.wrap(customerRepository.retrieveByEmail(email)).map(countries -> ok(Json.toJson(new CustomerListResponse("0", "OK", countries))));

        return result.recover(error -> {

                    Logger.error("Error:", error);

                    return ok(Json.toJson(createResponse("2", error.getMessage())));

                }
        );
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
            @ApiResponse(code = 0, message = "Customer was updated successfully"),
            @ApiResponse(code = 1, message = "Wrong request format"),
            @ApiResponse(code = 2, message = "DB error"),
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
                return Promise.pure(ok(Json.toJson(createResponse("1", "Specified account does not exist or inactive"))));
            }

        } catch (Exception e) {
            Logger.error("Wrong request format:", e);

            return Promise.pure(badRequest(Json.toJson(createResponse("1", "Wrong request format"))));
        }

        final Promise<Customer> customerPromise = Promise.wrap(customerRepository.update(customer));

        Promise<Result> result = customerPromise.map(res -> ok(Json.toJson(createResponse("0", "Customer was updated successfully"))));

        return result.recover(error -> {

                    Logger.error("Error:", error);

                    return ok(Json.toJson(createResponse("2", error.getMessage())));

                }
        );
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
            @ApiResponse(code = 0, message = "Customer was created successfully"),
            @ApiResponse(code = 1, message = "Wrong request format"),
            @ApiResponse(code = 2, message = "DB error"),
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
        final Customer customer = Json.fromJson(jsonNode, Customer.class);

        if (StringUtils.isBlank(customer.getId()) || StringUtils.isBlank(customer.getAddress1()) || StringUtils.isBlank(customer.getAddress2())) {
            Logger.error("Missing params");
            return Promise.pure(ok(Json.toJson(createResponse("1", "Missing params"))));
        }

        if (!authData.getEnckey().equalsIgnoreCase(SecurityUtil.generateKeyFromArray(authData.getAccount().getId().toString(),
                customer.getId(), customer.getFirstName(), authData.getOrderId(),
                authData.getAccount().getSecret()))) {
            Logger.error("Provided and calculated enckeys do not match");
            return Promise.pure(ok(Json.toJson(createResponse("1", "Provided and calculated enckeys do not match"))));
        }

        if (customer.getRegistrationDate() == null) customer.setRegistrationDate(new Date());

        final Promise<Result> result = Promise.wrap(customerRepository.create(customer)).map(res ->
                ok(Json.toJson(new CustomerResponse("0", "Customer created successfully", res))));

        return result.recover(error -> {
            Logger.error("Error: ", error);
            return ok(Json.toJson(createResponse("2", error.getMessage())));
        });
    }

}