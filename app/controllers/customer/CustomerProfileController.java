package controllers.customer;

import com.wordnik.swagger.annotations.*;
import configs.Constants;
import controllers.BaseController;
import dto.BaseAPIResponse;
import dto.customer.CustomerProfileResponse;
import dto.customer.CustomerTransactionResponse;
import model.Customer;
import play.libs.F;
import play.libs.Json;
import play.mvc.Result;
import play.mvc.With;

/**
 * API customer profile controller
 * @author ra created 17.02.2016.
 * @since 0.2.0
 */
@Api(value = Constants.CUSTOMER_API_PATH + "/profile", description = "Customer profile methods")
public class CustomerProfileController extends BaseController {

    @With(BaseCustomerApiAction.class)
    @ApiOperation(
            nickname = "getProfile",
            value = "Get customer profile",
            notes = "Allows customer to retrieve his profile",
            consumes = "application/json",
            produces = "application/json",
            httpMethod = "GET",
            response = CustomerProfileResponse.class
    )
    @ApiResponses(value = {
            @ApiResponse(code = 0, message = "OK", response = BaseAPIResponse.class),
    })
    @ApiImplicitParams(value = {
            @ApiImplicitParam(value = "Access token header", required = true, dataType = "String", paramType = "header", name = "token")})
    public F.Promise<Result>retrieve() {
        final Customer customer = (Customer) ctx().args.get("customer");

        return F.Promise.pure(ok(Json.toJson(new CustomerProfileResponse("OK","0",customer))));
    }
}
