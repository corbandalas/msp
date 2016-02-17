package controllers.customer;

import com.google.inject.Inject;
import com.wordnik.swagger.annotations.*;
import configs.Constants;
import controllers.BaseController;
import dto.customer.CustomerCardBalanceResponse;
import dto.customer.CustomerCardListResponse;
import exception.WrongCardException;
import model.Card;
import model.Customer;
import play.Logger;
import play.libs.F;
import play.libs.F.Promise;
import play.libs.Json;
import play.mvc.Result;
import play.mvc.With;
import provider.CardProvider;
import repository.CardRepository;

import java.util.List;
import java.util.Optional;


/**
 * Customer card balance API controller
 *
 * @author corbandalas - created 17.02.2016.
 * @since 0.2.0
 */
@Api(value = Constants.CUSTOMER_API_PATH + "/card/balance", description = "Customer card balance")
public class CustomerCardBalanceController extends BaseController {

    @Inject
    CardRepository cardRepository;

    @Inject
    CardProvider cardProvider;

    @With(BaseCustomerApiAction.class)
    @ApiOperation(
            nickname = "cardBalance",
            value = "Get customer card balance",
            notes = "Allows to obtain balance of specified customer's card",
            produces = "application/json",
            httpMethod = "GET",
            response = CustomerCardBalanceResponse.class
    )

    @ApiResponses(value = {
            @ApiResponse(code = 0, message = "OK", response = CustomerCardBalanceResponse.class),
            @ApiResponse(code = 1, message = "Missing parameters"),
            @ApiResponse(code = 2, message = "Wrong request format"),
            @ApiResponse(code = 4, message = "Specified card does not exist"),
            @ApiResponse(code = 5, message = "Specified card doesn't belong for authorized customer cards"),
            @ApiResponse(code = 6, message = "General error")
    })
    @ApiImplicitParams(
            value = {
                    @ApiImplicitParam(value = "Access token header", required = true, dataType = "String", paramType = "header", name = "token")})


    public Promise<Result> cardBalance(Long cardID) {

        final Customer customer = (Customer) ctx().args.get("customer");

        final F.Promise<List<Card>> cardListPromise = F.Promise.wrap(cardRepository.retrieveListByCustomerId(customer.getId()));
        final F.Promise<Optional<Card>> cardPromise = F.Promise.wrap(cardRepository.retrieveById(cardID));

        final F.Promise<Result> result = cardPromise.zip(cardListPromise).flatMap(data -> {
            Card card = data._1.orElseThrow(WrongCardException::new);
            if (!data._2.stream().map(Card::getId).anyMatch(id -> id.equals(card.getId()))) {
                return F.Promise.pure(badRequest(Json.toJson(createResponse("5", "Specified card doesn't belong for authorized customer cards"))));
            }

            return cardProvider.getVirtualCardBalance(card).map(balanceResponse
                    -> ok(Json.toJson(new CustomerCardBalanceResponse("OK", "0", balanceResponse.getAvailableBalance(), balanceResponse.getCurrency()))));
        });


        return result.recover(throwable -> {
                    Logger.error("Error: ", throwable);

                    if (throwable instanceof WrongCardException) {
                        return ok(Json.toJson(createResponse("4", "Specified card does not exist")));
                    }

                    return ok(Json.toJson(createResponse("6", "General error")));
                }

        );

    }


}