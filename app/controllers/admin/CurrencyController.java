package controllers.admin;

import com.fasterxml.jackson.databind.JsonNode;
import com.google.inject.Inject;
import com.wordnik.swagger.annotations.*;
import configs.Constants;
import controllers.BaseController;
import dto.*;
import model.Currency;
import org.apache.commons.lang3.StringUtils;
import play.Logger;
import play.libs.F.Promise;
import play.libs.Json;
import play.mvc.Result;
import play.mvc.With;
import repository.CurrencyRepository;
import util.CurrencyUtil;
import util.SecurityUtil;

import java.util.Optional;

import static configs.ReturnCodes.*;
import static configs.ReturnCodes.GENERAL_ERROR_TEXT;

/**
 * API currency controller
 *
 * @author nihilist - created 09.02.2016.
 * @since 0.1.0
 */
@Api(value = Constants.ADMIN_API_PATH + "/currency", description = "Allows to manage currencies created for administration use.")
public class CurrencyController extends BaseController {

    @Inject
    CurrencyRepository currencyRepository;

    @With(BaseMerchantApiAction.class)
    @ApiOperation(
            nickname = "listAllCurrency",
            value = "All currency list",
            notes = "Method allows to get list of all currencies in admin system",
            produces = "application/json",
            httpMethod = "GET",
            response = CurrencyListResponse.class
    )
    @ApiResponses(value = {
            @ApiResponse(code = SUCCESS_CODE, message = SUCCESS_TEXT, response = CurrencyListResponse.class),
            @ApiResponse(code = WRONG_REQUEST_ENCKEY_CODE, message = WRONG_REQUEST_ENCKEY_TEXT),
            @ApiResponse(code = INCORRECT_CURRENCY_CODE, message = INCORRECT_CURRENCY_TEXT),
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

        final Promise<Result> result = Promise.wrap(currencyRepository.retrieveAll()).map(currencies -> ok(Json.toJson(new CurrencyListResponse("0", "OK", currencies))));

        return returnRecover(result);
    }

    @With(BaseMerchantApiAction.class)
    @ApiOperation(
            nickname = "retrieveById",
            value = "Get by ID",
            notes = "Method allows to get currency by ID in admin system",
            produces = "application/json",
            httpMethod = "GET",
            response = CurrencyResponse.class
    )
    @ApiResponses(value = {
            @ApiResponse(code = SUCCESS_CODE, message = SUCCESS_TEXT, response = CurrencyResponse.class),
            @ApiResponse(code = WRONG_REQUEST_ENCKEY_CODE, message = WRONG_REQUEST_ENCKEY_TEXT),
            @ApiResponse(code = INCORRECT_CURRENCY_CODE, message = INCORRECT_CURRENCY_TEXT),
            @ApiResponse(code = GENERAL_ERROR_CODE, message = GENERAL_ERROR_TEXT),
            @ApiResponse(code = INCORRECT_AUTHORIZATION_DATA_CODE, message = INCORRECT_AUTHORIZATION_DATA_TEXT),
            @ApiResponse(code = INACTIVE_ACCOUNT_CODE, message = INACTIVE_ACCOUNT_TEXT)
    })
    @ApiImplicitParams({
            @ApiImplicitParam(name = "currencyID", value = "Currency ID to retrieve", required = true, dataType = "string", paramType = "path"),
            @ApiImplicitParam(value = "Account id header", required = true, dataType = "String", paramType = "header", name = "accountId"),
            @ApiImplicitParam(value = "Enckey header SHA256(accountId+currencyID+orderId+secret)", required = true, dataType = "String", paramType = "header", name = "enckey"),
            @ApiImplicitParam(value = "orderId header", required = true, dataType = "String", paramType = "header", name = "orderId")})
    public Promise<Result> retrieveByID(String currencyID) {

        final Authentication authData = (Authentication) ctx().args.get("authData");

        if (StringUtils.isBlank(currencyID)) {
            return Promise.pure(createWrongRequestFormatResponse());
        }

        if (!authData.getEnckey().equalsIgnoreCase(SecurityUtil.generateKeyFromArray(authData.getAccount().getId().toString(), currencyID,
                authData.getOrderId(), authData.getAccount().getSecret()))) {
            Logger.error("Provided and calculated enckeys do not match");
            return Promise.pure(createWrongEncKeyResponse());
        }

        Promise<Result> result = Promise.wrap(currencyRepository.retrieveById(currencyID)).map(res -> res.map(curr
                -> ok(Json.toJson(new CurrencyResponse(""+SUCCESS_CODE, SUCCESS_TEXT, curr)))).orElse(createIncorrectCurrencyResponse()));

        return returnRecover(result);
    }

    @With(BaseMerchantApiAction.class)
    @ApiOperation(
            nickname = "updateCurrency",
            value = "Update currency",
            notes = "Method allows to update currency in admin system",
            produces = "application/json",
            consumes = "application/json",
            httpMethod = "POST",
            response = dto.BaseAPIResponse.class
    )
    @ApiResponses(value = {
            @ApiResponse(code = SUCCESS_CODE, message = SUCCESS_TEXT, response = BaseAPIResponse.class),
            @ApiResponse(code = WRONG_REQUEST_ENCKEY_CODE, message = WRONG_REQUEST_ENCKEY_TEXT),
            @ApiResponse(code = INCORRECT_CURRENCY_CODE, message = INCORRECT_CURRENCY_TEXT),
            @ApiResponse(code = GENERAL_ERROR_CODE, message = GENERAL_ERROR_TEXT),
            @ApiResponse(code = INCORRECT_AUTHORIZATION_DATA_CODE, message = INCORRECT_AUTHORIZATION_DATA_TEXT),
            @ApiResponse(code = INACTIVE_ACCOUNT_CODE, message = INACTIVE_ACCOUNT_TEXT)
    })
    @ApiImplicitParams({
            @ApiImplicitParam(value = "Currency request", required = true, dataType = "model.Currency", paramType = "body"),
            @ApiImplicitParam(value = "Account id header", required = true, dataType = "String", paramType = "header", name = "accountId"),
            @ApiImplicitParam(value = "Enckey header SHA256(accountId+currency.id+orderId+secret)", required = true, dataType = "String", paramType = "header", name = "enckey"),
            @ApiImplicitParam(value = "orderId header", required = true, dataType = "String", paramType = "header", name = "orderId")})
    public Promise<Result> update() {

        final Authentication authData = (Authentication) ctx().args.get("authData");

        final JsonNode jsonNode = request().body().asJson();

        Currency currency = null;

        try {
            currency = Json.fromJson(jsonNode, Currency.class);

            if (!authData.getEnckey().equalsIgnoreCase(SecurityUtil.generateKeyFromArray(authData.getAccount().getId().toString(), currency.getId(),
                    authData.getOrderId(), authData.getAccount().getSecret()))) {
                Logger.error("Provided and calculated enckeys do not match");
                return Promise.pure(createWrongEncKeyResponse());
            }

        } catch (Exception e) {
            Logger.error("Wrong request format:", e);
            return Promise.pure(createWrongRequestFormatResponse());
        }

        final Promise<Currency> currencyPromise = Promise.wrap(currencyRepository.update(currency));

        Promise<Result> result = currencyPromise.map(res -> ok(Json.toJson(createResponse(""+SUCCESS_CODE, SUCCESS_TEXT))));

        return returnRecover(result);
    }


    @With(BaseMerchantApiAction.class)
    @ApiOperation(
            nickname = "currencyConversation",
            value = "Provide amount conversation from one currency to another",
            notes = "Method allows to convert provided amount from one currency to another based on stored currency exchange rates",
            produces = "application/json",
            httpMethod = "GET",
            response = CurrencyExchangeResponse.class
    )
    @ApiResponses(value = {
            @ApiResponse(code = SUCCESS_CODE, message = SUCCESS_TEXT, response = CurrencyExchangeResponse.class),
            @ApiResponse(code = WRONG_REQUEST_ENCKEY_CODE, message = WRONG_REQUEST_ENCKEY_TEXT),
            @ApiResponse(code = INCORRECT_CURRENCY_CODE, message = INCORRECT_CURRENCY_TEXT),
            @ApiResponse(code = GENERAL_ERROR_CODE, message = GENERAL_ERROR_TEXT),
            @ApiResponse(code = INCORRECT_AUTHORIZATION_DATA_CODE, message = INCORRECT_AUTHORIZATION_DATA_TEXT),
            @ApiResponse(code = INACTIVE_ACCOUNT_CODE, message = INACTIVE_ACCOUNT_TEXT)
    })
    @ApiImplicitParams({
            @ApiImplicitParam(name = "fromCurrencyID", value = "Original currency", required = true, dataType = "string", paramType = "path"),
            @ApiImplicitParam(name = "toCurrencyID", value = "Desired currency", required = true, dataType = "string", paramType = "path"),
            @ApiImplicitParam(name = "amount", value = "Original amount", required = true, dataType = "string", paramType = "path"),
            @ApiImplicitParam(value = "Account id header", required = true, dataType = "String", paramType = "header", name = "accountId"),
            @ApiImplicitParam(value = "Enckey header SHA256(accountId+fromCurrencyID+toCurrencyID+amount+orderId+secret)", required = true, dataType = "String", paramType = "header", name = "enckey"),
            @ApiImplicitParam(value = "orderId header", required = true, dataType = "String", paramType = "header", name = "orderId")})
    public Promise<Result> exchange(long amount, String fromCurrencyID, String toCurrencyID) {

        final Authentication authData = (Authentication) ctx().args.get("authData");

        if (StringUtils.isBlank(fromCurrencyID) || StringUtils.isBlank(toCurrencyID)) {

            return Promise.pure(createWrongRequestFormatResponse());
        }

        if (!authData.getEnckey().equalsIgnoreCase(SecurityUtil.generateKeyFromArray(authData.getAccount().getId().toString(), fromCurrencyID, toCurrencyID, "" + amount,
                authData.getOrderId(), authData.getAccount().getSecret()))) {
            Logger.error("Provided and calculated enckeys do not match");
            return Promise.pure(createWrongEncKeyResponse());
        }

        Promise<Optional<Currency>> currencyFromPromise = Promise.wrap(currencyRepository.retrieveById(fromCurrencyID));
        Promise<Optional<Currency>> currencyToPromise = Promise.wrap(currencyRepository.retrieveById(toCurrencyID));

        Promise<Result> result = currencyFromPromise.zip(currencyToPromise).map(res -> CurrencyUtil.convert(amount, res._1, res._2)).
                map(res -> ok(Json.toJson(new CurrencyExchangeResponse(""+SUCCESS_CODE, "" + (double) amount / 100 + " " + fromCurrencyID + " equals to " + (double) res / 100 + " " + toCurrencyID, fromCurrencyID, toCurrencyID, amount, res))));

        return returnRecover(result);
    }

}