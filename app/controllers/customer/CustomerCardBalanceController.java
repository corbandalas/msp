package controllers.customer;

import com.google.inject.Inject;
import com.wordnik.swagger.annotations.*;
import configs.Constants;
import controllers.BaseController;
import dto.customer.CustomerCardBalanceResponse;
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

import static configs.ReturnCodes.*;


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
            @ApiResponse(code = SUCCESS_CODE, message = SUCCESS_TEXT, response = CustomerCardBalanceResponse.class),
            @ApiResponse(code = INCORRECT_CARD_CODE, message = INCORRECT_CARD_TEXT),
            @ApiResponse(code = INCORRECT_AUTHORIZATION_DATA_CODE, message = INCORRECT_AUTHORIZATION_DATA_TEXT),
            @ApiResponse(code = WRONG_CUSTOMER_ACCOUNT_CODE, message = WRONG_CUSTOMER_ACCOUNT_TEXT),
            @ApiResponse(code = GENERAL_ERROR_CODE, message = GENERAL_ERROR_TEXT)
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

                Logger.error("Specified card doesn't belong for authorized customer cards");

                return F.Promise.pure(createWrongCardResponse());
            }

            return cardProvider.getVirtualCardBalance(card).map(balanceResponse
                    -> ok(Json.toJson(new CustomerCardBalanceResponse(SUCCESS_TEXT, "" + SUCCESS_CODE, balanceResponse.getAvailableBalance(), balanceResponse.getCurrency()))));
        });


        return returnRecover(result);

    }


}