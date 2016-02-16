package controllers.customer;

import com.fasterxml.jackson.databind.JsonNode;
import com.google.inject.Inject;
import com.wordnik.swagger.annotations.*;
import configs.Constants;
import controllers.BaseController;
import dto.BaseAPIResponse;
import dto.customer.CustomerChangePassword;
import dto.customer.CustomerLoginResponse;
import model.Customer;
import org.apache.commons.lang3.StringUtils;
import play.Logger;
import play.libs.F;
import play.libs.Json;
import play.mvc.Result;
import play.mvc.With;
import repository.CustomerRepository;

/**
 * Customer password operations
 *
 * @author ra created 16.02.2016.
 * @since 0.2.0
 */
@Api(value = Constants.CUSTOMER_API_PATH + "/password", description = "Customer password operations")
public class CustomerPasswordController extends BaseController {

    @Inject
    CustomerRepository customerRepository;

    @With(BaseCustomerApiAction.class)
    @ApiOperation(
            nickname = "changePassword",
            value = "Change customer password",
            notes = "Allows customer to change his password",
            consumes = "application/json",
            produces = "application/json",
            httpMethod = "GET",
            response = CustomerLoginResponse.class
    )

    @ApiResponses(value = {
            @ApiResponse(code = 0, message = "OK", response = BaseAPIResponse.class),
            @ApiResponse(code = 1, message = "Wrong request format"),
            @ApiResponse(code = 2, message = "DB error"),
            @ApiResponse(code = 3, message = "Old password does not match with existing"),
            @ApiResponse(code = 4, message = "Specified password equals to existing")
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

            return F.Promise.pure(badRequest(Json.toJson(createResponse("1", "Wrong request format"))));
        }

        if (StringUtils.isBlank(request.getHashedPassword()) || StringUtils.isBlank(request.getOldHashedPassword())) {
            Logger.error("Missing parameters");

            return F.Promise.pure(badRequest(Json.toJson(createResponse("1", "Missing parameters"))));
        }

        if (!customer.getPassword().equals(request.getOldHashedPassword())) {
            Logger.error("Specified old password does not match with existing");

            return F.Promise.pure(badRequest(Json.toJson(createResponse("3", "Specified old password does not match with existing"))));
        }

        if(customer.getPassword().equals(request.getHashedPassword())) {
            Logger.error("Specified password equals to existing");

            return F.Promise.pure(badRequest(Json.toJson(createResponse("4", "Specified password equals to existing"))));
        }

        customer.setPassword(request.getHashedPassword());

        final F.Promise<Result> result = F.Promise.wrap(customerRepository.update(customer)).map(updCustomer ->
                ok(Json.toJson(new BaseAPIResponse("Password was updated successfully", "0"))));

        return result.recover(throwable -> {
            Logger.error("Error: ", throwable);
            return ok(Json.toJson(new BaseAPIResponse(throwable.getMessage(), "2")));
        });
    }
}
