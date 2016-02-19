package controllers.customer;

import com.google.inject.Inject;
import com.wordnik.swagger.annotations.*;
import configs.Constants;
import controllers.BaseController;
import dto.BaseAPIResponse;
import exception.WrongCardException;
import model.Card;
import model.Customer;
import play.Logger;
import play.libs.F.Promise;
import play.libs.Json;
import play.mvc.Result;
import play.mvc.With;
import provider.CardProvider;
import repository.CardRepository;

import java.util.List;
import java.util.Optional;


/**
 * Customer card management API controller
 *
 * @author nihilist - created 19.02.2016.
 * @since 0.2.0
 */
@Api(value = Constants.CUSTOMER_API_PATH + "/card/management", description = "Customer card management")
public class CardManagementController extends BaseController {

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
            @ApiResponse(code = 0, message = "OK", response = BaseAPIResponse.class),
            @ApiResponse(code = 1, message = "Missing parameters"),
            @ApiResponse(code = 2, message = "Wrong request format"),
            @ApiResponse(code = 4, message = "Specified card does not exist"),
            @ApiResponse(code = 5, message = "Specified card doesn't belong for authorized customer cards"),
            @ApiResponse(code = 6, message = "General error")
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
                return Promise.pure(badRequest(Json.toJson(createResponse("5", "Specified card doesn't belong for authorized customer cards"))));
            }

            switch (operation) {
                case 0:
                    return cardProvider.activateCard(card, reason).map(response
                            -> ok(Json.toJson(new BaseAPIResponse("OK", "0"))));
                case 1:
                    return cardProvider.blockCard(card, reason).map(response
                            -> ok(Json.toJson(new BaseAPIResponse("OK", "0"))));
                case 2:
                    return cardProvider.reportCardDamaged(card, reason).map(response
                            -> ok(Json.toJson(new BaseAPIResponse("OK", "0"))));
                case 3:
                    return cardProvider.reportCardLost(card, reason).map(response
                            -> ok(Json.toJson(new BaseAPIResponse("OK", "0"))));
                case 4:
                    return cardProvider.reportCardStolen(card, reason).map(response
                            -> ok(Json.toJson(new BaseAPIResponse("OK", "0"))));
                default:
                    return Promise.pure(badRequest(Json.toJson(createResponse("1", "Missing parameters"))));

            }

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
            @ApiResponse(code = 0, message = "OK", response = BaseAPIResponse.class),
            @ApiResponse(code = 1, message = "Missing parameters"),
            @ApiResponse(code = 2, message = "Wrong request format"),
            @ApiResponse(code = 4, message = "Specified card does not exist"),
            @ApiResponse(code = 5, message = "Specified card doesn't belong for authorized customer cards"),
            @ApiResponse(code = 6, message = "General error")
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
                return Promise.pure(badRequest(Json.toJson(createResponse("5", "Specified card doesn't belong for authorized customer cards"))));
            }

            return cardProvider.changePIN(card, currentPIN, newPIN, confirmNewPIN).map(response
                    -> ok(Json.toJson(new BaseAPIResponse("OK", "0"))));

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