package controllers.customer;

import com.fasterxml.jackson.databind.JsonNode;
import com.google.inject.Inject;
import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;
import com.wordnik.swagger.annotations.*;
import configs.Constants;
import controllers.BaseController;
import controllers.admin.BaseMerchantApiAction;
import dto.Authentication;
import dto.BaseAPIResponse;
import dto.customer.*;
import exception.CustomerNotRegisteredException;
import model.Customer;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;
import play.Logger;
import play.cache.CacheApi;
import play.libs.F;
import play.libs.F.Promise;
import play.libs.Json;
import play.mvc.Result;
import play.mvc.With;
import repository.CustomerRepository;
import sms.SmsGateway;
import util.SecurityUtil;

import java.util.Optional;

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

    @With(BaseMerchantApiAction.class)
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
    @ApiImplicitParams(value = {@ApiImplicitParam(value = "Change pin request", required = true, dataType = "dto.customer.CustomerChangeToNewPassword", paramType = "body"),
            @ApiImplicitParam(value = "Account id header", required = true, dataType = "String", paramType = "header", name = "accountId"),
            @ApiImplicitParam(value = "orderId header", required = true, dataType = "String", paramType = "header", name = "orderId"),
            @ApiImplicitParam(value = "Enckey header. SHA256(accountId+orderId+phone+secret)",
                    required = true, dataType = "String", paramType = "header", name = "enckey")
    })
    public Promise<Result> changeToNew() {

        final JsonNode jsonNode = request().body().asJson();
        final CustomerChangeToNewPassword request;



        try {
            request = Json.fromJson(jsonNode, CustomerChangeToNewPassword.class);

        } catch (Exception e) {
            Logger.error("Wrong request format:", e);

            return F.Promise.pure(createWrongRequestFormatResponse());
        }

        F.Promise<Optional<Customer>> customerPromise = F.Promise.wrap(customerRepository.retrieveById(request.getPhone()));


        final Promise<Result> result = customerPromise.map(res -> {

            Customer customer = res.get();

            if (checkLoginAttempt(customer)) {
                Logger.error("Customer has exceeded number of wrong change pin attempts per day");

                return createPasswordExceededResponse();
            }

            if (StringUtils.isBlank(request.getHashedPassword())) {
                Logger.error("Missing parameters");

                return createWrongRequestFormatResponse();
            }

            if (customer.getPassword().equalsIgnoreCase(request.getHashedPassword())) {
                Logger.error("Specified password equals to existing");

                return createPasswordEqualsToExistedResponse();
            }

            customer.setPassword(request.getHashedPassword());
            customer.setTemppassword(false);
            putLoginAttempt(customer, 0);

            smsGateway.sendSMS(customer.getId(), "Your password was changed");

            customerRepository.update(customer);
            return ok(Json.toJson(new BaseAPIResponse(SUCCESS_TEXT, "" + SUCCESS_CODE)));

        });

        return returnRecover(result);
    }

    @With(BaseMerchantApiAction.class)
    @ApiOperation(
            nickname = "getEmailByPhone",
            value = "Get customer email by phone",
            notes = "Method allows to obtain customer email by phone",
            consumes = "application/json",
            produces = "application/json",
            httpMethod = "GET",
            response = CustomerEmailResponse.class
    )

    @ApiResponses(value = {
            @ApiResponse(code = SUCCESS_CODE, message = SUCCESS_TEXT, response = CustomerEmailResponse.class),
            @ApiResponse(code = WRONG_REQUEST_FORMAT_CODE, message = WRONG_REQUEST_FORMAT_TEXT),
            @ApiResponse(code = PASSWORD_MISMATCH_CODE, message = PASSWORD_MISMATCH_TEXT),
            @ApiResponse(code = PASSWORD_EQUALS_TO_EXISTED_CODE, message = PASSWORD_EQUALS_TO_EXISTED_TEXT),
            @ApiResponse(code = PASSWORD_ATTEMPTS_EXCEEDED_CODE, message = PASSWORD_ATTEMPTS_EXCEEDED_TEXT),
            @ApiResponse(code = GENERAL_ERROR_CODE, message = GENERAL_ERROR_TEXT)
    })
    @ApiImplicitParams(value = {@ApiImplicitParam(value = "Get customer email request", required = true, dataType = "dto.customer.CustomerEmail", paramType = "body"),
            @ApiImplicitParam(value = "Account id header", required = true, dataType = "String", paramType = "header", name = "accountId"),
            @ApiImplicitParam(value = "orderId header", required = true, dataType = "String", paramType = "header", name = "orderId"),
            @ApiImplicitParam(value = "Enckey header. SHA256(accountId+orderId+phone+secret)",
                    required = true, dataType = "String", paramType = "header", name = "enckey")
    })
    public F.Promise<Result> obtainEmail() {

        final Authentication authData = (Authentication) ctx().args.get("authData");
        final JsonNode jsonNode = request().body().asJson();
        final CustomerEmail request;

        try {
            request = Json.fromJson(jsonNode, CustomerEmail.class);

        } catch (Exception e) {
            Logger.error("Wrong request format:", e);

            return F.Promise.pure(createWrongRequestFormatResponse());
        }

        if (StringUtils.isBlank(request.getPhone())) {
            Logger.error("Missing parameters");

            return F.Promise.pure(createWrongRequestFormatResponse());
        }

        if (!authData.getEnckey().equalsIgnoreCase(SecurityUtil.generateKeyFromArray(authData.getAccount().getId().toString(), authData.getOrderId(), request.getPhone(),
                authData.getAccount().getSecret()))) {
            Logger.error("Provided and calculated enckeys do not match");
            return F.Promise.pure(createWrongEncKeyResponse());
        }


        final F.Promise<Result> result = F.Promise.wrap(customerRepository.retrieveById(request.getPhone())).map(customerOptional ->
                ok(Json.toJson(new CustomerEmailResponse(SUCCESS_TEXT, "" + SUCCESS_CODE, customerOptional.get().getEmail()))));

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
