package controllers.customer;

import com.google.inject.Inject;
import com.wordnik.swagger.annotations.*;
import configs.Constants;
import controllers.BaseController;
import dto.BaseAPIResponse;
import exception.WrongCardException;
import model.Card;
import model.Customer;
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
 * Customer card management API controller
 *
 * @author nihilist - created 19.02.2016.
 * @since 0.2.0
 */
@Api(value = Constants.CUSTOMER_API_PATH + "/card/management", description = "Customer card management")
public class CustomerCardManagementController extends BaseController {

    @Inject
    CardRepository cardRepository;

    @Inject
    CardProvider cardProvider;

    @With(BaseCustomerApiAction.class)
    @ApiOperation(
            nickname = "changeStatus",
            value = "Change customer card status",
            notes = "Change specified customer's card status",
            produces = "application/json",
            httpMethod = "GET",
            response = BaseAPIResponse.class
    )

    @ApiResponses(value = {

            @ApiResponse(code = SUCCESS_CODE, message = SUCCESS_TEXT, response = BaseAPIResponse.class),
            @ApiResponse(code = WRONG_REQUEST_FORMAT_CODE, message = WRONG_REQUEST_FORMAT_TEXT),
            @ApiResponse(code = INCORRECT_CARD_CODE, message = INCORRECT_CARD_TEXT),
            @ApiResponse(code = INCORRECT_AUTHORIZATION_DATA_CODE, message = INCORRECT_AUTHORIZATION_DATA_TEXT),
            @ApiResponse(code = WRONG_CUSTOMER_ACCOUNT_CODE, message = WRONG_CUSTOMER_ACCOUNT_TEXT),
            @ApiResponse(code = GENERAL_ERROR_CODE, message = GENERAL_ERROR_TEXT)

    })
    @ApiImplicitParams(
            value = {
                    @ApiImplicitParam(name = "cardID", value = "Card ID to retrieve", required = true, dataType = "string", paramType = "path"),
                    @ApiImplicitParam(name = "reason", value = "reason for operation", required = true, dataType = "string", paramType = "path"),
                    @ApiImplicitParam(name = "operation", value = "Operation number [0-activateCard;1-blockCard;2-reportCardDamaged;3-reportCardLost;4-reportCardStolen;]", required = true, dataType = "integer", paramType = "path"),
                    @ApiImplicitParam(value = "Access token header", required = true, dataType = "String", paramType = "header", name = "token")})
    public Promise<Result> changeStatus(Long cardID, String reason, Integer operation) {

        final Customer customer = (Customer) ctx().args.get("customer");

        final Promise<List<Card>> cardListPromise = Promise.wrap(cardRepository.retrieveListByCustomerId(customer.getId()));
        final Promise<Optional<Card>> cardPromise = Promise.wrap(cardRepository.retrieveById(cardID));

        final Promise<Result> result = cardPromise.zip(cardListPromise).flatMap(data -> {
            Card card = data._1.orElseThrow(WrongCardException::new);
            if (!data._2.stream().map(Card::getId).anyMatch(id -> id.equals(card.getId()))) {
                return Promise.pure(createWrongCardResponse());
            }

            switch (operation) {
                case 0:
                    return cardProvider.activateCard(card, reason).map(response
                            -> okResponse());
                case 1:
                    return cardProvider.blockCard(card, reason).map(response
                            -> okResponse());
                case 2:
                    return cardProvider.reportCardDamaged(card, reason).map(response
                            -> okResponse());
                case 3:
                    return cardProvider.reportCardLost(card, reason).map(response
                            -> okResponse());
                case 4:
                    return cardProvider.reportCardStolen(card, reason).map(response
                            -> okResponse());
                default:
                    return Promise.pure(createWrongRequestFormatResponse());

            }

        });

        return returnRecover(result);

    }


    @With(BaseCustomerApiAction.class)
    @ApiOperation(
            nickname = "changePIN",
            value = "Change card PIN",
            notes = "Change specified customer's card PIN",
            produces = "application/json",
            httpMethod = "GET",
            response = BaseAPIResponse.class
    )

    @ApiResponses(value = {
            @ApiResponse(code = SUCCESS_CODE, message = SUCCESS_TEXT, response = BaseAPIResponse.class),
            @ApiResponse(code = WRONG_REQUEST_FORMAT_CODE, message = WRONG_REQUEST_FORMAT_TEXT),
            @ApiResponse(code = INCORRECT_CARD_CODE, message = INCORRECT_CARD_TEXT),
            @ApiResponse(code = INCORRECT_AUTHORIZATION_DATA_CODE, message = INCORRECT_AUTHORIZATION_DATA_TEXT),
            @ApiResponse(code = WRONG_CUSTOMER_ACCOUNT_CODE, message = WRONG_CUSTOMER_ACCOUNT_TEXT),
            @ApiResponse(code = GENERAL_ERROR_CODE, message = GENERAL_ERROR_TEXT)
    })
    @ApiImplicitParams(
            value = {
                    @ApiImplicitParam(name = "cardID", value = "Card ID to retrieve", required = true, dataType = "string", paramType = "path"),
                    @ApiImplicitParam(name = "currentPIN", value = "current card PIN", required = true, dataType = "string", paramType = "path"),
                    @ApiImplicitParam(name = "newPIN", value = "new card PIN", required = true, dataType = "string", paramType = "path"),
                    @ApiImplicitParam(name = "confirmNewPIN", value = "confirm new card PIN", required = true, dataType = "string", paramType = "path"),
                    @ApiImplicitParam(value = "Access token header", required = true, dataType = "String", paramType = "header", name = "token")})
    public Promise<Result> changePIN(Long cardID, String currentPIN, String newPIN, String confirmNewPIN) {

        final Customer customer = (Customer) ctx().args.get("customer");

        final Promise<List<Card>> cardListPromise = Promise.wrap(cardRepository.retrieveListByCustomerId(customer.getId()));
        final Promise<Optional<Card>> cardPromise = Promise.wrap(cardRepository.retrieveById(cardID));

        final Promise<Result> result = cardPromise.zip(cardListPromise).flatMap(data -> {
            Card card = data._1.orElseThrow(WrongCardException::new);
            if (!data._2.stream().map(Card::getId).anyMatch(id -> id.equals(card.getId()))) {
                return Promise.pure(createWrongCardResponse());
            }

            return cardProvider.changePIN(card, currentPIN, newPIN, confirmNewPIN).map(response
                    -> okResponse());

        });

        return returnRecover(result);

    }

    private Status okResponse() {
        return ok(Json.toJson(new BaseAPIResponse(SUCCESS_TEXT, "" + SUCCESS_CODE)));
    }

}