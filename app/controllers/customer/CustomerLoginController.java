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
import dto.customer.CustomerLogin;
import dto.customer.CustomerLoginResponse;
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
import util.SecurityUtil;

import java.util.Optional;

import static configs.ReturnCodes.*;


/**
 * Customer authorization API controller
 *
 * @author corbandalas - created 15.02.2016.
 * @since 0.2.0
 */
@Api(value = Constants.CUSTOMER_API_PATH + "/login", description = "Customer authorization")
public class CustomerLoginController extends BaseController {

    @Inject
    CustomerRepository customerRepository;

    @Inject
    CacheApi cache;

    @With(BaseMerchantApiAction.class)
    @ApiOperation(
            nickname = "auth",
            value = "Authorize customer by phone and password",
            notes = "Allows merchants to send customer authorization data",
            consumes = "application/json",
            produces = "application/json",
            httpMethod = "POST",
            response = CustomerLoginResponse.class
    )

    @ApiResponses(value = {
            @ApiResponse(code = SUCCESS_CODE, message = SUCCESS_TEXT, response = CustomerLoginResponse.class),
            @ApiResponse(code = WRONG_REQUEST_FORMAT_CODE, message = WRONG_REQUEST_FORMAT_TEXT),
            @ApiResponse(code = WRONG_REQUEST_ENCKEY_CODE, message = WRONG_REQUEST_ENCKEY_TEXT),
            @ApiResponse(code = WRONG_CUSTOMER_ACCOUNT_CODE, message = WRONG_CUSTOMER_ACCOUNT_TEXT),
            @ApiResponse(code = PASSWORD_MISMATCH_CODE, message = PASSWORD_MISMATCH_TEXT),
            @ApiResponse(code = GENERAL_ERROR_CODE, message = GENERAL_ERROR_TEXT)
    })


    @ApiImplicitParams(value = {@ApiImplicitParam(value = "Login request", required = true, dataType = "dto.customer.CustomerLogin", paramType = "body"),
            @ApiImplicitParam(value = "Account id header", required = true, dataType = "String", paramType = "header", name = "accountId"),
            @ApiImplicitParam(value = "Enckey header. SHA256(accountId+orderId+phone+hashedPassword+secret)",
                    required = true, dataType = "String", paramType = "header", name = "enckey"),
            @ApiImplicitParam(value = "orderId header", required = true, dataType = "String", paramType = "header", name = "orderId")})


    public Promise<Result> login() {

        final Authentication authData = (Authentication) ctx().args.get("authData");

        final JsonNode jsonNode = request().body().asJson();

        CustomerLogin customerLogin = null;

        try {
            customerLogin = Json.fromJson(jsonNode, CustomerLogin.class);

        } catch (Exception e) {
            Logger.error("Wrong request format:", e);

            return Promise.pure(createWrongRequestFormatResponse());
        }

        if (customerLogin == null || StringUtils.isBlank(customerLogin.getPhone()) || StringUtils.isBlank(customerLogin.getHashedPassword())) {
            Logger.error("Missing params");
            return F.Promise.pure(createWrongRequestFormatResponse());
        }

        if (!authData.getEnckey().equalsIgnoreCase(SecurityUtil.generateKeyFromArray(authData.getAccount().getId().toString(), authData.getOrderId(), customerLogin.getPhone(), customerLogin.getHashedPassword(),
                authData.getAccount().getSecret()))) {
            Logger.error("Provided and calculated enckeys do not match");
            return F.Promise.pure(createWrongEncKeyResponse());
        }

        final String password = customerLogin.getHashedPassword();

        final Promise<Optional<Customer>> propertyPromise = Promise.wrap(customerRepository.retrieveById(customerLogin.getPhone()));

        final Promise<Result> result = propertyPromise.map(customerOptional -> {

            Customer customer = customerOptional.orElseThrow(CustomerNotRegisteredException::new);

            if (!customer.getActive()) {
                Logger.error("Specified customer does not exist or inactive");

                return createWrongCustomerAccountResponse();
            }

            if (!customer.getPassword().equals(password)) {
                Logger.error("Password doesn't match");

                return createPasswordMismatchResponse();
            }

            String token = RandomStringUtils.randomAlphanumeric(10);

            Config conf = ConfigFactory.load();

            String sessionTimeOut = conf.getString("cache.customer.session.timeout");

            //Store token to cache with expiration time out
            cache.set(token, customer.getId(), Integer.parseInt(sessionTimeOut) * 60);

            return ok(Json.toJson(new CustomerLoginResponse("" + SUCCESS_CODE, SUCCESS_TEXT, token, customer.getTemppassword())));
        });


        return returnRecover(result);
    }


}