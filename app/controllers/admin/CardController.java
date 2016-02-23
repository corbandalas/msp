package controllers.admin;

import com.fasterxml.jackson.databind.JsonNode;
import com.google.inject.Inject;
import com.wordnik.swagger.annotations.*;
import configs.Constants;
import controllers.BaseController;
import dto.Authentication;
import dto.BaseAPIResponse;
import dto.CardListResponse;
import dto.CardResponse;
import model.Card;
import model.enums.CardBrand;
import model.enums.CardType;
import org.apache.commons.lang3.StringUtils;
import play.Logger;
import play.libs.F.Promise;
import play.libs.Json;
import play.mvc.Result;
import play.mvc.With;
import repository.CardRepository;
import util.SecurityUtil;

import java.util.Date;

import static configs.ReturnCodes.*;

/**
 * API card controller
 *
 * @author nihilist - created 12.02.2016.
 * @since 0.1.0
 */
@Api(value = Constants.ADMIN_API_PATH + "/card", description = "Operations to manage application cards stored in DB")
public class CardController extends BaseController {

    @Inject
    CardRepository cardRepository;

    @With(BaseMerchantApiAction.class)
    @ApiOperation(
            nickname = "listAllCards",
            value = "All cards list",
            notes = "Obtain list of all cards stored in DB",
            produces = "application/json",
            httpMethod = "GET",
            response = CardListResponse.class
    )
    @ApiResponses(value = {
            @ApiResponse(code = SUCCESS_CODE, message = SUCCESS_TEXT, response = CardListResponse.class),
            @ApiResponse(code = WRONG_REQUEST_ENCKEY_CODE, message = WRONG_REQUEST_ENCKEY_TEXT),
            @ApiResponse(code = WRONG_REQUEST_FORMAT_CODE, message = WRONG_REQUEST_FORMAT_TEXT),
            @ApiResponse(code = INCORRECT_CARD_CODE, message = INCORRECT_CARD_TEXT),
            @ApiResponse(code = GENERAL_ERROR_CODE, message = GENERAL_ERROR_TEXT),
            @ApiResponse(code = INCORRECT_AUTHORIZATION_DATA_CODE, message = INCORRECT_AUTHORIZATION_DATA_TEXT),
            @ApiResponse(code = INACTIVE_ACCOUNT_CODE, message = INACTIVE_ACCOUNT_TEXT)
    })
    @ApiImplicitParams({
            @ApiImplicitParam(value = "Account id header", required = true, dataType = "String", paramType = "header", name = "accountId"),
            @ApiImplicitParam(value = "Enckey header SHA256(accountId+orderId+secret)", required = true, dataType = "String", paramType = "header", name = "enckey"),
            @ApiImplicitParam(value = "orderId header", required = true, dataType = "String", paramType = "header", name = "orderId")})
    public Promise<Result> retrieveAll() {

        final Authentication authData = (Authentication) ctx().args.get("authData");

        if (!authData.getEnckey().equalsIgnoreCase(SecurityUtil.generateKeyFromArray(authData.getAccount().getId().toString(),
                authData.getOrderId(), authData.getAccount().getSecret()))) {
            Logger.error("Provided and calculated enckeys do not match");
            return Promise.pure(createWrongEncKeyResponse());
        }

        final Promise<Result> result = Promise.wrap(cardRepository.retrieveAll()).map(cards -> ok(Json.toJson(new CardListResponse(""+SUCCESS_CODE, SUCCESS_TEXT, cards))));

        return returnRecover(result);
    }

    @With(BaseMerchantApiAction.class)
    @ApiOperation(
            nickname = "listByCardBrand",
            value = "All cards by card brand",
            notes = "Obtain list of all cards stored in DB by card brand",
            produces = "application/json",
            httpMethod = "GET",
            response = CardListResponse.class
    )
    @ApiResponses(value = {
            @ApiResponse(code = SUCCESS_CODE, message = SUCCESS_TEXT, response = CardListResponse.class),
            @ApiResponse(code = WRONG_REQUEST_ENCKEY_CODE, message = WRONG_REQUEST_ENCKEY_TEXT),
            @ApiResponse(code = WRONG_REQUEST_FORMAT_CODE, message = WRONG_REQUEST_FORMAT_TEXT),
            @ApiResponse(code = INCORRECT_CARD_CODE, message = INCORRECT_CARD_TEXT),
            @ApiResponse(code = GENERAL_ERROR_CODE, message = GENERAL_ERROR_TEXT),
            @ApiResponse(code = INCORRECT_AUTHORIZATION_DATA_CODE, message = INCORRECT_AUTHORIZATION_DATA_TEXT),
            @ApiResponse(code = INACTIVE_ACCOUNT_CODE, message = INACTIVE_ACCOUNT_TEXT)
    })
    @ApiImplicitParams({
            @ApiImplicitParam(name = "cardBrand", value = "Card brand to retrieve", required = true, dataType = "string", paramType = "path"),
            @ApiImplicitParam(value = "Account id header", required = true, dataType = "String", paramType = "header", name = "accountId"),
            @ApiImplicitParam(value = "Enckey header SHA256(accountId+cardBrand+orderId+secret)", required = true, dataType = "String", paramType = "header", name = "enckey"),
            @ApiImplicitParam(value = "orderId header", required = true, dataType = "String", paramType = "header", name = "orderId")})
    public Promise<Result> retrieveByCardBrand(String cardBrand) {

        final Authentication authData = (Authentication) ctx().args.get("authData");

        if (!authData.getEnckey().equalsIgnoreCase(SecurityUtil.generateKeyFromArray(authData.getAccount().getId().toString(), cardBrand,
                authData.getOrderId(), authData.getAccount().getSecret()))) {
            Logger.error("Provided and calculated enckeys do not match");
            return Promise.pure(createWrongEncKeyResponse());
        }

        if (StringUtils.isBlank(cardBrand)) {
            return Promise.pure(createWrongRequestFormatResponse());
        }

        CardBrand cardBrandValue = CardBrand.valueOf(cardBrand);

        final Promise<Result> result = Promise.wrap(cardRepository.retrieveListByCardBrand(cardBrandValue)).map(cards -> ok(Json.toJson(new CardListResponse(""+SUCCESS_CODE, SUCCESS_TEXT, cards))));

        return returnRecover(result);
    }

    @With(BaseMerchantApiAction.class)
    @ApiOperation(
            nickname = "listByCardType",
            value = "All cards by card type",
            notes = "Obtain list of all cards stored in DB by card type",
            produces = "application/json",
            httpMethod = "GET",
            response = CardListResponse.class
    )
    @ApiResponses(value = {
            @ApiResponse(code = SUCCESS_CODE, message = SUCCESS_TEXT, response = CardListResponse.class),
            @ApiResponse(code = WRONG_REQUEST_ENCKEY_CODE, message = WRONG_REQUEST_ENCKEY_TEXT),
            @ApiResponse(code = WRONG_REQUEST_FORMAT_CODE, message = WRONG_REQUEST_FORMAT_TEXT),
            @ApiResponse(code = INCORRECT_CARD_CODE, message = INCORRECT_CARD_TEXT),
            @ApiResponse(code = GENERAL_ERROR_CODE, message = GENERAL_ERROR_TEXT),
            @ApiResponse(code = INCORRECT_AUTHORIZATION_DATA_CODE, message = INCORRECT_AUTHORIZATION_DATA_TEXT),
            @ApiResponse(code = INACTIVE_ACCOUNT_CODE, message = INACTIVE_ACCOUNT_TEXT)
    })
    @ApiImplicitParams({
            @ApiImplicitParam(name = "cardType", value = "Card type to retrieve", required = true, dataType = "string", paramType = "path"),
            @ApiImplicitParam(value = "Account id header", required = true, dataType = "String", paramType = "header", name = "accountId"),
            @ApiImplicitParam(value = "Enckey header SHA256(accountId+cardType+orderId+secret)", required = true, dataType = "String", paramType = "header", name = "enckey"),
            @ApiImplicitParam(value = "orderId header", required = true, dataType = "String", paramType = "header", name = "orderId")})
    public Promise<Result> retrieveByCardType(String cardType) {

        final Authentication authData = (Authentication) ctx().args.get("authData");

        if (!authData.getEnckey().equalsIgnoreCase(SecurityUtil.generateKeyFromArray(authData.getAccount().getId().toString(), cardType,
                authData.getOrderId(), authData.getAccount().getSecret()))) {
            Logger.error("Provided and calculated enckeys do not match");
            return Promise.pure(createWrongEncKeyResponse());
        }

        if (StringUtils.isBlank(cardType)) {
            return Promise.pure(createWrongRequestFormatResponse());
        }

        CardType cardTypeValue = CardType.valueOf(cardType);

        final Promise<Result> result = Promise.wrap(cardRepository.retrieveListByCardType(cardTypeValue)).map(cards -> ok(Json.toJson(new CardListResponse(""+SUCCESS_CODE, SUCCESS_TEXT, cards))));

        return returnRecover(result);
    }

    @With(BaseMerchantApiAction.class)
    @ApiOperation(
            nickname = "listByCustomerID",
            value = "All cards by customerID",
            notes = "Obtain list of all cards stored in DB by customerID",
            produces = "application/json",
            httpMethod = "GET",
            response = CardListResponse.class
    )
    @ApiResponses(value = {
            @ApiResponse(code = SUCCESS_CODE, message = SUCCESS_TEXT, response = CardListResponse.class),
            @ApiResponse(code = WRONG_REQUEST_ENCKEY_CODE, message = WRONG_REQUEST_ENCKEY_TEXT),
            @ApiResponse(code = WRONG_REQUEST_FORMAT_CODE, message = WRONG_REQUEST_FORMAT_TEXT),
            @ApiResponse(code = INCORRECT_CARD_CODE, message = INCORRECT_CARD_TEXT),
            @ApiResponse(code = GENERAL_ERROR_CODE, message = GENERAL_ERROR_TEXT),
            @ApiResponse(code = INCORRECT_AUTHORIZATION_DATA_CODE, message = INCORRECT_AUTHORIZATION_DATA_TEXT),
            @ApiResponse(code = INACTIVE_ACCOUNT_CODE, message = INACTIVE_ACCOUNT_TEXT)
    })
    @ApiImplicitParams({
            @ApiImplicitParam(name = "customerID", value = "customerID to retrieve", required = true, dataType = "string", paramType = "path"),
            @ApiImplicitParam(value = "Account id header", required = true, dataType = "String", paramType = "header", name = "accountId"),
            @ApiImplicitParam(value = "Enckey header SHA256(accountId+customerID+orderId+secret)", required = true, dataType = "String", paramType = "header", name = "enckey"),
            @ApiImplicitParam(value = "orderId header", required = true, dataType = "String", paramType = "header", name = "orderId")})
    public Promise<Result> retrieveByCustomerID(String customerID) {

        final Authentication authData = (Authentication) ctx().args.get("authData");

        if (!authData.getEnckey().equalsIgnoreCase(SecurityUtil.generateKeyFromArray(authData.getAccount().getId().toString(), customerID,
                authData.getOrderId(), authData.getAccount().getSecret()))) {
            Logger.error("Provided and calculated enckeys do not match");
            return Promise.pure(createWrongEncKeyResponse());
        }

        if (StringUtils.isBlank(customerID)) {
            return Promise.pure(createWrongRequestFormatResponse());
        }

        final Promise<Result> result = Promise.wrap(cardRepository.retrieveListByCustomerId(customerID)).map(cards -> ok(Json.toJson(new CardListResponse(""+SUCCESS_CODE, SUCCESS_TEXT, cards))));

        return returnRecover(result);
    }

    @With(BaseMerchantApiAction.class)
    @ApiOperation(
            nickname = "retrieveById",
            value = "Retrieve card by ID",
            notes = "Get card by its ID",
            produces = "application/json",
            httpMethod = "GET",
            response = CardResponse.class
    )

    @ApiResponses(value = {
            @ApiResponse(code = SUCCESS_CODE, message = SUCCESS_TEXT, response = CardResponse.class),
            @ApiResponse(code = WRONG_REQUEST_ENCKEY_CODE, message = WRONG_REQUEST_ENCKEY_TEXT),
            @ApiResponse(code = WRONG_REQUEST_FORMAT_CODE, message = WRONG_REQUEST_FORMAT_TEXT),
            @ApiResponse(code = INCORRECT_CARD_CODE, message = INCORRECT_CARD_TEXT),
            @ApiResponse(code = GENERAL_ERROR_CODE, message = GENERAL_ERROR_TEXT),
            @ApiResponse(code = INCORRECT_AUTHORIZATION_DATA_CODE, message = INCORRECT_AUTHORIZATION_DATA_TEXT),
            @ApiResponse(code = INACTIVE_ACCOUNT_CODE, message = INACTIVE_ACCOUNT_TEXT)
    })
    @ApiImplicitParams({
            @ApiImplicitParam(name = "cardID", value = "Card ID to retrieve", required = true, dataType = "string", paramType = "path"),
            @ApiImplicitParam(value = "Account id header", required = true, dataType = "String", paramType = "header", name = "accountId"),
            @ApiImplicitParam(value = "Enckey header SHA256(accountId+cardID+orderId+secret)", required = true, dataType = "String", paramType = "header", name = "enckey"),
            @ApiImplicitParam(value = "orderId header", required = true, dataType = "String", paramType = "header", name = "orderId")})
    public Promise<Result> retrieveById(String cardID) {

        final Authentication authData = (Authentication) ctx().args.get("authData");

        if (!authData.getEnckey().equalsIgnoreCase(SecurityUtil.generateKeyFromArray(authData.getAccount().getId().toString(),
                cardID, authData.getOrderId(), authData.getAccount().getSecret()))) {
            Logger.error("Provided and calculated enckeys do not match");
            return Promise.pure(createWrongEncKeyResponse());
        }

        if (StringUtils.isBlank(cardID)) {

            return Promise.pure(createWrongRequestFormatResponse());
        }

        Promise<Result> result = Promise.wrap(cardRepository.retrieveById(cardID)).map(res -> res.map(card
                -> ok(Json.toJson(new CardResponse(""+SUCCESS_CODE, SUCCESS_TEXT, card)))).orElse(createWrongCardResponse()));

        return returnRecover(result);
    }

    @With(BaseMerchantApiAction.class)
    @ApiOperation(
            nickname = "updateCard",
            value = "Update existed card",
            notes = "Update existed application card in DB",
            produces = "application/json",
            consumes = "application/json",
            httpMethod = "POST",
            response = BaseAPIResponse.class
    )
    @ApiResponses(value = {
            @ApiResponse(code = SUCCESS_CODE, message = SUCCESS_TEXT, response = BaseAPIResponse.class),
            @ApiResponse(code = WRONG_REQUEST_ENCKEY_CODE, message = WRONG_REQUEST_ENCKEY_TEXT),
            @ApiResponse(code = WRONG_REQUEST_FORMAT_CODE, message = WRONG_REQUEST_FORMAT_TEXT),
            @ApiResponse(code = INCORRECT_CARD_CODE, message = INCORRECT_CARD_TEXT),
            @ApiResponse(code = GENERAL_ERROR_CODE, message = GENERAL_ERROR_TEXT),
            @ApiResponse(code = INCORRECT_AUTHORIZATION_DATA_CODE, message = INCORRECT_AUTHORIZATION_DATA_TEXT),
            @ApiResponse(code = INACTIVE_ACCOUNT_CODE, message = INACTIVE_ACCOUNT_TEXT)
    })
    @ApiImplicitParams({
            @ApiImplicitParam(value = "Card request", required = true, dataType = "model.Card", paramType = "body"),
            @ApiImplicitParam(value = "Account id header", required = true, dataType = "String", paramType = "header", name = "accountId"),
            @ApiImplicitParam(value = "Enckey header SHA256(accountId+card.id+orderId+secret)", required = true, dataType = "String", paramType = "header", name = "enckey"),
            @ApiImplicitParam(value = "orderId header", required = true, dataType = "String", paramType = "header", name = "orderId")})
    public Promise<Result> update() {

        final Authentication authData = (Authentication) ctx().args.get("authData");

        final JsonNode jsonNode = request().body().asJson();

        Card card = null;

        try {
            card = Json.fromJson(jsonNode, Card.class);

            if (!authData.getEnckey().equalsIgnoreCase(SecurityUtil.generateKeyFromArray(authData.getAccount().getId().toString(),
                    card.getId().toString(), authData.getOrderId(), authData.getAccount().getSecret()))) {
                Logger.error("Provided and calculated enckeys do not match");
                return Promise.pure(createWrongEncKeyResponse());
            }

        } catch (Exception e) {
            Logger.error("Wrong request format:", e);

            return Promise.pure(createWrongRequestFormatResponse());
        }

        final Promise<Card> cardPromise = Promise.wrap(cardRepository.update(card));

        Promise<Result> result = cardPromise.map(res -> ok(Json.toJson(createResponse(""+SUCCESS_CODE, SUCCESS_TEXT))));

        return returnRecover(result);
    }

    @With(BaseMerchantApiAction.class)
    @ApiOperation(
            nickname = "createCard",
            value = "Create card",
            notes = "Create card in DB",
            produces = "application/json",
            consumes = "application/json",
            httpMethod = "POST",
            response = BaseAPIResponse.class
    )

    @ApiResponses(value = {
            @ApiResponse(code = SUCCESS_CODE, message = SUCCESS_TEXT, response = BaseAPIResponse.class),
            @ApiResponse(code = WRONG_REQUEST_ENCKEY_CODE, message = WRONG_REQUEST_ENCKEY_TEXT),
            @ApiResponse(code = WRONG_REQUEST_FORMAT_CODE, message = WRONG_REQUEST_FORMAT_TEXT),
            @ApiResponse(code = INCORRECT_CARD_CODE, message = INCORRECT_CARD_TEXT),
            @ApiResponse(code = GENERAL_ERROR_CODE, message = GENERAL_ERROR_TEXT),
            @ApiResponse(code = INCORRECT_AUTHORIZATION_DATA_CODE, message = INCORRECT_AUTHORIZATION_DATA_TEXT),
            @ApiResponse(code = INACTIVE_ACCOUNT_CODE, message = INACTIVE_ACCOUNT_TEXT)
    })
    @ApiImplicitParams(value = {
            @ApiImplicitParam(value = "Card request", required = true, dataType = "model.Card", paramType = "body"),
            @ApiImplicitParam(value = "Account id header", required = true, dataType = "String", paramType = "header", name = "accountId"),
            @ApiImplicitParam(value = "Enckey header. SHA256(accountId+card.customerId+orderId+secret)",
                    required = true, dataType = "String", paramType = "header", name = "enckey"),
            @ApiImplicitParam(value = "orderId header", required = true, dataType = "String", paramType = "header", name = "orderId")})
    public Promise<Result> create() {

        final Authentication authData = (Authentication) ctx().args.get("authData");

        final JsonNode jsonNode = request().body().asJson();
        final Card card = Json.fromJson(jsonNode, Card.class);

        if (StringUtils.isBlank(card.getAlias()) || StringUtils.isBlank(card.getCurrencyId()) || StringUtils.isBlank(card.getCustomerId()) || card.getType() == null || card.getBrand() == null || card.getActive() == null || card.getCardDefault() == null || StringUtils.isBlank(card.getInfo()) || StringUtils.isBlank(card.getDeliveryAddress1()) || StringUtils.isBlank(card.getDeliveryAddress2()) || StringUtils.isBlank(card.getDeliveryAddress3()) || StringUtils.isBlank(card.getDeliveryCountry())) {
            Logger.error("Missing params");
            return Promise.pure(createWrongRequestFormatResponse());
        }

        if (!authData.getEnckey().equalsIgnoreCase(SecurityUtil.generateKeyFromArray(authData.getAccount().getId().toString(),
                card.getCustomerId(), authData.getOrderId(),
                authData.getAccount().getSecret()))) {
            Logger.error("Provided and calculated enckeys do not match");
            return Promise.pure(createWrongEncKeyResponse());
        }

        if (card.getCreateDate() == null) card.setCreateDate(new Date());

        final Promise<Result> result = Promise.wrap(cardRepository.create(card)).map(res ->
                ok(Json.toJson(new CardResponse(""+SUCCESS_CODE, SUCCESS_TEXT, res))));

        return returnRecover(result);
    }

}