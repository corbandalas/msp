package controllers.customer;

import com.fasterxml.jackson.databind.JsonNode;
import com.google.inject.Inject;
import com.wordnik.swagger.annotations.*;
import configs.Constants;
import controllers.BaseController;
import controllers.admin.BaseMerchantApiAction;
import dto.Authentication;
import dto.customer.CustomerLogin;
import dto.customer.CustomerLoginResponse;
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
            httpMethod = "GET",
            response = CustomerLoginResponse.class
    )

    @ApiResponses(value = {
            @ApiResponse(code = 0, message = "OK", response = CustomerLoginResponse.class),
            @ApiResponse(code = 1, message = "Wrong request format"),
            @ApiResponse(code = 2, message = "DB error"),
            @ApiResponse(code = 3, message = "Authorization failed")
    })
    @ApiImplicitParams(value = {@ApiImplicitParam(value = "Property request", required = true, dataType = "dto.customer.CustomerLogin", paramType = "body"),
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

            return Promise.pure(badRequest(Json.toJson(createResponse("1", "Wrong request format"))));
        }

        if (customerLogin == null || StringUtils.isBlank(customerLogin.getPhone()) || StringUtils.isBlank(customerLogin.getHashedPassword())) {
            Logger.error("Missing params");
            return F.Promise.pure(ok(Json.toJson(createResponse("1", "Missing params"))));
        }

        if (!authData.getEnckey().equalsIgnoreCase(SecurityUtil.generateKeyFromArray(authData.getAccount().getId().toString(), authData.getOrderId(), customerLogin.getPhone(), customerLogin.getHashedPassword(),
                authData.getAccount().getSecret()))) {
            Logger.error("Provided and calculated enckeys do not match");
            return F.Promise.pure(ok(Json.toJson(createResponse("2", "Provided and calculated enckeys do not match"))));
        }

        final String password = customerLogin.getHashedPassword();

        final Promise<Customer> propertyPromise = Promise.wrap(customerRepository.retrieveById(customerLogin.getPhone()));

        Promise<Result> result = propertyPromise.map(customer -> {

            if (customer == null || !customer.getActive()) {
                Logger.error("Specified customer does not exist or inactive");

                return ok(Json.toJson(createResponse("3", "Authorization failed. Specified account does not exist or inactive")));
            }

            if (!customer.getPassword().equals(password)) {
                Logger.error("Password doesn't match");

                return ok(Json.toJson(createResponse("3", "Password doesn't match")));
            }

            String token = RandomStringUtils.randomAlphanumeric(10);

            cache.set(token, customer);

            return ok(Json.toJson(new CustomerLoginResponse("0", "Authorization is OK", token)));
        });


        return result.recover(error -> {
                    Logger.error("Error:", error);

                    return ok(Json.toJson(createResponse("2", error.getMessage())));

                }
        );
    }


}