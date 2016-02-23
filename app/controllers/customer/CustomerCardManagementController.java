package controllers.customer;

import com.fasterxml.jackson.databind.JsonNode;
import com.google.inject.Inject;
import com.wordnik.swagger.annotations.*;
import configs.Constants;
import controllers.BaseController;
import dto.BaseAPIResponse;
import dto.customer.CustomerCardManagementChangePIN;
import dto.customer.CustomerCardManagementChangeStatus;
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
                    @ApiImplicitParam(value = "changeStatus request. Operation number [0-activateCard;1-blockCard;2-reportCardDamaged;3-reportCardLost;4-reportCardStolen;]", required = true, dataType = "dto.customer.CustomerCardManagementChangeStatus", paramType = "body"),
                    @ApiImplicitParam(value = "Access token header", required = true, dataType = "String", paramType = "header", name = "token")})
    public Promise<Result> changeStatus() {

        final Customer customer = (Customer) ctx().args.get("customer");

        final JsonNode jsonNode = request().body().asJson();
        final CustomerCardManagementChangeStatus request;
        try {
            request = Json.fromJson(jsonNode, CustomerCardManagementChangeStatus.class);
        } catch (Exception e) {
            Logger.error("Wrong request format: ", e);
            return F.Promise.pure(createWrongRequestFormatResponse());
        }

        if (request.getCardID() == null || request.getOperation() == null || request.getReason() == null) {
            Logger.error("Missing parameters");
            return F.Promise.pure(createWrongRequestFormatResponse());
        }

        final Promise<List<Card>> cardListPromise = Promise.wrap(cardRepository.retrieveListByCustomerId(customer.getId()));
        final Promise<Optional<Card>> cardPromise = Promise.wrap(cardRepository.retrieveById(request.getCardID()));

        final Promise<Result> result = cardPromise.zip(cardListPromise).flatMap(data -> {
            Card card = data._1.orElseThrow(WrongCardException::new);
            if (!data._2.stream().map(Card::getId).anyMatch(id -> id.equals(card.getId()))) {
                return Promise.pure(createWrongCardResponse());
            }

            switch (request.getOperation()) {
                case 0:
                    return cardProvider.activateCard(card, request.getReason()).map(response
                            -> okResponse());
                case 1:
                    return cardProvider.blockCard(card, request.getReason()).map(response
                            -> okResponse());
                case 2:
                    return cardProvider.reportCardDamaged(card, request.getReason()).map(response
                            -> okResponse());
                case 3:
                    return cardProvider.reportCardLost(card, request.getReason()).map(response
                            -> okResponse());
                case 4:
                    return cardProvider.reportCardStolen(card, request.getReason()).map(response
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
                    @ApiImplicitParam(value = "changePIN request", required = true, dataType = "dto.customer.CustomerCardManagementChangePIN", paramType = "body"),
                    @ApiImplicitParam(value = "Access token header", required = true, dataType = "String", paramType = "header", name = "token")})
    public Promise<Result> changePIN() {

        final Customer customer = (Customer) ctx().args.get("customer");

        final JsonNode jsonNode = request().body().asJson();
        final CustomerCardManagementChangePIN request;
        try {
            request = Json.fromJson(jsonNode, CustomerCardManagementChangePIN.class);
        } catch (Exception e) {
            Logger.error("Wrong request format: ", e);
            return F.Promise.pure(createWrongRequestFormatResponse());
        }

        if (request.getCardID() == null || request.getConfirmNewPIN() == null || request.getCurrentPIN() == null || request.getNewPIN() == null) {
            Logger.error("Missing parameters");
            return F.Promise.pure(createWrongRequestFormatResponse());
        }

        final Promise<List<Card>> cardListPromise = Promise.wrap(cardRepository.retrieveListByCustomerId(customer.getId()));
        final Promise<Optional<Card>> cardPromise = Promise.wrap(cardRepository.retrieveById(request.getCardID()));

        final Promise<Result> result = cardPromise.zip(cardListPromise).flatMap(data -> {
            Card card = data._1.orElseThrow(WrongCardException::new);
            if (!data._2.stream().map(Card::getId).anyMatch(id -> id.equals(card.getId()))) {
                return Promise.pure(createWrongCardResponse());
            }

            return cardProvider.changePIN(card, request.getCurrentPIN(), request.getNewPIN(), request.getConfirmNewPIN()).map(response
                    -> okResponse());

        });

        return returnRecover(result);

    }

    private Status okResponse() {
        return ok(Json.toJson(new BaseAPIResponse(SUCCESS_TEXT, "" + SUCCESS_CODE)));
    }

}