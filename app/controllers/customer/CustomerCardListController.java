package controllers.customer;

import com.google.inject.Inject;
import com.wordnik.swagger.annotations.*;
import configs.Constants;
import controllers.BaseController;
import dto.customer.CustomerCardListResponse;
import model.Card;
import model.Customer;
import play.libs.F.Promise;
import play.libs.Json;
import play.mvc.Result;
import play.mvc.With;
import provider.CardProvider;
import repository.CardRepository;

import java.util.List;
import java.util.stream.Collectors;


/**
 * Customer card list API controller
 *
 * @author corbandalas - created 17.02.2016.
 * @since 0.2.0
 */
@Api(value = Constants.CUSTOMER_API_PATH + "/card/list", description = "Customer card list")
public class CustomerCardListController extends BaseController {

    @Inject
    CardRepository cardRepository;

    @Inject
    CardProvider cardProvider;

    @With(BaseCustomerApiAction.class)
    @ApiOperation(
            nickname = "cardList",
            value = "Get customer cards list",
            notes = "Allows to obtain all cards list for specified customer",
            produces = "application/json",
            httpMethod = "GET",
            response = CustomerCardListResponse.class
    )

    @ApiResponses(value = {
            @ApiResponse(code = 0, message = "OK", response = CustomerCardListResponse.class),
            @ApiResponse(code = 1, message = "Missing params"),
            @ApiResponse(code = 6, message = "General error")
    })
    @ApiImplicitParams(
            value = {
                    @ApiImplicitParam(value = "Access token header", required = true, dataType = "String", paramType = "header", name = "token")})


    public Promise<Result> cardList() {

        final Customer customer = (Customer) ctx().args.get("customer");


        Promise<List<Card>> wrap = Promise.wrap(cardRepository.retrieveListByCustomerId(customer.getId()));
        Promise<Result> result = wrap.flatMap(res -> Promise.sequence(res.stream().map(t -> cardProvider.getVirtualCardDetails(t).map(s -> new CustomerCardListResponse.CardWrapper(t.getId(), s))).collect(Collectors.toList())).map(z -> ok(Json.toJson(new CustomerCardListResponse("0", "Successful card list retrieval", z)))));

        return result.recover(error -> {

                    return badRequest(Json.toJson(createResponse("6", "General error")));

                }
        );

    }


}