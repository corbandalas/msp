package controllers.customer;

import com.fasterxml.jackson.databind.JsonNode;
import com.google.inject.Inject;
import com.wordnik.swagger.annotations.*;
import configs.Constants;
import controllers.BaseController;
import dto.BaseAPIResponse;
import dto.customer.CustomerChangePassword;
import dto.customer.CustomerChangeToNewPassword;
import dto.customer.CustomerLoginResponse;
import model.Customer;
import org.apache.commons.lang3.StringUtils;
import play.Logger;
import play.cache.CacheApi;
import play.libs.F;
import play.libs.Json;
import play.mvc.Result;
import play.mvc.With;
import repository.CustomerRepository;
import sms.SmsGateway;

import static configs.ReturnCodes.*;

/**
 * Customer password operations
 *
 * @author ra created 16.02.2016.
 * @since 0.2.0
 */
@Api(value = Constants.CUSTOMER_API_PATH + "/password", description = "Password Management")
public class CustomerPasswordController extends BaseController {

    @Inject
    CacheApi cache;

    @Inject
    CustomerRepository customerRepository;

    @Inject
    SmsGateway smsGateway;

    @With(BaseCustomerApiAction.class)
    @ApiOperation(
            nickname = "changePassword",
            value = "change cardholder password",
            notes = "Method allows to change cardholder account password",
            consumes = "application/json",
            produces = "application/json",
            httpMethod = "GET",
            response = CustomerLoginResponse.class
    )

    @ApiResponses(value = {
            @ApiResponse(code = SUCCESS_CODE, message = SUCCESS_TEXT, response = BaseAPIResponse.class),
            @ApiResponse(code = WRONG_REQUEST_FORMAT_CODE, message = WRONG_REQUEST_FORMAT_TEXT),
            @ApiResponse(code = PASSWORD_MISMATCH_CODE, message = PASSWORD_MISMATCH_TEXT),
            @ApiResponse(code = PASSWORD_EQUALS_TO_EXISTED_CODE, message = PASSWORD_EQUALS_TO_EXISTED_TEXT),
            @ApiResponse(code = PASSWORD_ATTEMPTS_EXCEEDED_CODE, message = PASSWORD_ATTEMPTS_EXCEEDED_TEXT),
            @ApiResponse(code = GENERAL_ERROR_CODE, message = GENERAL_ERROR_TEXT)
    })
    @ApiImplicitParams(value = {@ApiImplicitParam(value = "Change pin request", required = true, dataType = "dto.customer.CustomerChangePassword", paramType = "body"),
            @ApiImplicitParam(value = "Access token header", required = true, dataType = "String", paramType = "header", name = "token")})
    public F.Promise<Result> change() {
        final Customer customer = (Customer) ctx().args.get("customer");

        final JsonNode jsonNode = request().body().asJson();
        final CustomerChangePassword request;


        try {
            request = Json.fromJson(jsonNode, CustomerChangePassword.class);

        } catch (Exception e) {
            Logger.error("Wrong request format:", e);

            return F.Promise.pure(createWrongRequestFormatResponse());
        }

        if (checkLoginAttempt(customer)) {
            Logger.error("Customer has exceeded number of wrong change pin attempts per day");

            return F.Promise.pure(createPasswordExceededResponse());
        }

        if (StringUtils.isBlank(request.getHashedPassword()) || StringUtils.isBlank(request.getOldHashedPassword())) {
            Logger.error("Missing parameters");

            return F.Promise.pure(createWrongRequestFormatResponse());
        }

        if (!customer.getPassword().equalsIgnoreCase(request.getOldHashedPassword())) {

            increaseWrongLoginAttempt(customer);

            Logger.error("Specified old password does not match with existing");

            return F.Promise.pure(createPasswordMismatchResponse());
        }

        if (customer.getPassword().equalsIgnoreCase(request.getHashedPassword())) {
            Logger.error("Specified password equals to existing");

            return F.Promise.pure(createPasswordEqualsToExistedResponse());
        }

        customer.setPassword(request.getHashedPassword());
        customer.setTemppassword(false);
        putLoginAttempt(customer, 0);

        final F.Promise<Result> result = F.Promise.wrap(customerRepository.update(customer)).map(updCustomer ->
                ok(Json.toJson(new BaseAPIResponse(SUCCESS_TEXT, "" + SUCCESS_CODE))));

        return returnRecover(result);
    }

    @With(BaseCustomerApiAction.class)
    @ApiOperation(
            nickname = "changePassword",
            value = "change cardholder password",
            notes = "Method allows to change cardholder account password",
            consumes = "application/json",
            produces = "application/json",
            httpMethod = "GET",
            response = CustomerLoginResponse.class
    )

    @ApiResponses(value = {
            @ApiResponse(code = SUCCESS_CODE, message = SUCCESS_TEXT, response = BaseAPIResponse.class),
            @ApiResponse(code = WRONG_REQUEST_FORMAT_CODE, message = WRONG_REQUEST_FORMAT_TEXT),
            @ApiResponse(code = PASSWORD_MISMATCH_CODE, message = PASSWORD_MISMATCH_TEXT),
            @ApiResponse(code = PASSWORD_EQUALS_TO_EXISTED_CODE, message = PASSWORD_EQUALS_TO_EXISTED_TEXT),
            @ApiResponse(code = PASSWORD_ATTEMPTS_EXCEEDED_CODE, message = PASSWORD_ATTEMPTS_EXCEEDED_TEXT),
            @ApiResponse(code = GENERAL_ERROR_CODE, message = GENERAL_ERROR_TEXT)
    })
    @ApiImplicitParams(value = {@ApiImplicitParam(value = "Change pin request", required = true, dataType = "dto.customer.CustomerChangePassword", paramType = "body"),
            @ApiImplicitParam(value = "Access token header", required = true, dataType = "String", paramType = "header", name = "token")})
    public F.Promise<Result> changeToNew() {
        final Customer customer = (Customer) ctx().args.get("customer");

        final JsonNode jsonNode = request().body().asJson();
        final CustomerChangeToNewPassword request;


        try {
            request = Json.fromJson(jsonNode, CustomerChangeToNewPassword.class);

        } catch (Exception e) {
            Logger.error("Wrong request format:", e);

            return F.Promise.pure(createWrongRequestFormatResponse());
        }

        if (checkLoginAttempt(customer)) {
            Logger.error("Customer has exceeded number of wrong change pin attempts per day");

            return F.Promise.pure(createPasswordExceededResponse());
        }

        if (StringUtils.isBlank(request.getHashedPassword())) {
            Logger.error("Missing parameters");

            return F.Promise.pure(createWrongRequestFormatResponse());
        }

        if (customer.getPassword().equalsIgnoreCase(request.getHashedPassword())) {
            Logger.error("Specified password equals to existing");

            return F.Promise.pure(createPasswordEqualsToExistedResponse());
        }

        customer.setPassword(request.getHashedPassword());
        customer.setTemppassword(false);
        putLoginAttempt(customer, 0);

        smsGateway.sendSMS(customer.getId(), "Your password was changed");

        final F.Promise<Result> result = F.Promise.wrap(customerRepository.update(customer)).map(updCustomer ->
                ok(Json.toJson(new BaseAPIResponse(SUCCESS_TEXT, "" + SUCCESS_CODE))));

        return returnRecover(result);
    }

    private void increaseWrongLoginAttempt(Customer customer) {

        int count = getWrongLoginAttempt(customer);

        putLoginAttempt(customer, ++count);
    }

    private void putLoginAttempt(Customer customer, Integer count) {
        //Store login attepmpts to cache with expiration time out
        cache.set("setpin#attempt#" + customer.getId(), count, 60 * 24 * 60);
    }

    private boolean checkLoginAttempt(Customer customer) {

        int count = getWrongLoginAttempt(customer);

        return (++count >= 5);
    }

    private Integer getWrongLoginAttempt(Customer customer) {
        Object objeAttempt = cache.get("setpin#attempt#" + customer.getId());

        int count = 0;

        if (objeAttempt != null) {
            count = (Integer) objeAttempt;
        }

        return count;

    }
}
