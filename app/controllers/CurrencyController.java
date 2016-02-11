package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import com.google.inject.Inject;
import com.wordnik.swagger.annotations.*;
import dto.Authentication;
import dto.CurrencyExchangeResponse;
import dto.CurrencyListResponse;
import dto.CurrencyResponse;
import model.Currency;
import model.Property;
import org.apache.commons.lang3.StringUtils;
import play.Logger;
import play.libs.F;
import play.libs.F.Promise;
import play.libs.Json;
import play.mvc.Result;
import play.mvc.With;
import repository.CurrencyRepository;
import util.CurrencyUtil;
import util.SecurityUtil;

/**
 * API currency controller
 *
 * @author nihilist - created 09.02.2016.
 * @since 0.1.0
 */
@Api(value = "/api/currency", description = "Operations to manage application currencies stored in DB")
public class CurrencyController extends BaseController {

    @Inject
    CurrencyRepository currencyRepository;

    @With(BaseMerchantApiAction.class)
    @ApiOperation(
            nickname = "listAllCurrency",
            value = "All currency list",
            notes = "Obtain list of all currencies stored in DB",
            produces = "application/json",
            httpMethod = "GET",
            response = dto.CurrencyListResponse.class
    )
    @ApiResponses(value = {
            @ApiResponse(code = 0, message = "OK", response = dto.CurrencyListResponse.class),
            @ApiResponse(code = 1, message = "DB error"),
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
            return F.Promise.pure(ok(Json.toJson(createResponse("1", "Specified account does not exist or inactive"))));
        }

        final Promise<Result> result = Promise.wrap(currencyRepository.retrieveAll()).map(currencies -> ok(Json.toJson(new CurrencyListResponse("0", "OK", currencies))));

        return result.recover(error -> {
            Logger.error("Error:", error);
            return ok(Json.toJson(createResponse("1", error.getMessage())));
        });
    }

    @With(BaseMerchantApiAction.class)
    @ApiOperation(
            nickname = "retrieveById",
            value = "Retrieve currency by ID",
            notes = "Get currency by its ID",
            produces = "application/json",
            httpMethod = "GET",
            response = dto.CurrencyResponse.class
    )
    @ApiResponses(value = {
            @ApiResponse(code = 0, message = "OK", response = dto.CurrencyResponse.class),
            @ApiResponse(code = 1, message = "Wrong request format"),
            @ApiResponse(code = 2, message = "DB error")
    })
    @ApiImplicitParams({
            @ApiImplicitParam(name = "currencyID", value = "Currency ID to retrieve", required = true, dataType = "string", paramType = "path"),
            @ApiImplicitParam(value = "Account id header", required = true, dataType = "String", paramType = "header", name = "accountId"),
            @ApiImplicitParam(value = "Enckey header SHA256(accountId+currencyID+orderId+secret)", required = true, dataType = "String", paramType = "header", name = "enckey"),
            @ApiImplicitParam(value = "orderId header", required = true, dataType = "String", paramType = "header", name = "orderId")})
    public Promise<Result> retrieveByID(String currencyID) {

        final Authentication authData = (Authentication) ctx().args.get("authData");

        if (StringUtils.isBlank(currencyID)) {

            return Promise.pure(badRequest(Json.toJson(createResponse("1", "Wrong request format"))));
        }

        if (!authData.getEnckey().equalsIgnoreCase(SecurityUtil.generateKeyFromArray(authData.getAccount().getId().toString(), currencyID,
                authData.getOrderId(), authData.getAccount().getSecret()))) {
            Logger.error("Provided and calculated enckeys do not match");
            return F.Promise.pure(ok(Json.toJson(createResponse("1", "Specified account does not exist or inactive"))));
        }

        Promise<Currency> currencyPromise = Promise.wrap(currencyRepository.retrieveById(currencyID));

        Promise<Result> result = currencyPromise.map(res -> ok(Json.toJson(new CurrencyResponse("0", "OK", res))));

        return result.recover(error -> {

                    Logger.error("Error:", error);

                    return ok(Json.toJson(createResponse("2", error.getMessage())));

                }
        );
    }

    @With(BaseMerchantApiAction.class)
    @ApiOperation(
            nickname = "updateCurrency",
            value = "Update existed currency",
            notes = "Update existed application currency in DB",
            produces = "application/json",
            consumes = "application/json",
            httpMethod = "POST",
            response = dto.BaseAPIResponse.class
    )
    @ApiResponses(value = {
            @ApiResponse(code = 0, message = "Currency was updated successfully"),
            @ApiResponse(code = 1, message = "Wrong request format"),
            @ApiResponse(code = 2, message = "DB error"),
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
                return F.Promise.pure(ok(Json.toJson(createResponse("1", "Specified account does not exist or inactive"))));
            }

        } catch (Exception e) {
            Logger.error("Wrong request format:", e);

            return Promise.pure(badRequest(Json.toJson(createResponse("1", "Wrong request format"))));
        }

        final Promise<Currency> currencyPromise = Promise.wrap(currencyRepository.update(currency));

        Promise<Result> result = currencyPromise.map(res -> ok(Json.toJson(createResponse("0", "Currency was updated successfully"))));

        return result.recover(error -> {

                    Logger.error("Error:", error);

                    return ok(Json.toJson(createResponse("2", error.getMessage())));

                }
        );
    }


    @With(BaseMerchantApiAction.class)
    @ApiOperation(
            nickname = "currencyConversation",
            value = "Provide amount conversation from one currency to another",
            notes = "Convert provided amount from one currency to another based on stored currency exchange rates",
            produces = "application/json",
            httpMethod = "GET",
            response = dto.CurrencyExchangeResponse.class
    )
    @ApiResponses(value = {
            @ApiResponse(code = 0, message = "OK", response = dto.CurrencyExchangeResponse.class),
            @ApiResponse(code = 1, message = "Wrong request format"),
            @ApiResponse(code = 2, message = "DB error")
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

            return Promise.pure(badRequest(Json.toJson(createResponse("1", "Wrong request format"))));
        }

        if (!authData.getEnckey().equalsIgnoreCase(SecurityUtil.generateKeyFromArray(authData.getAccount().getId().toString(), fromCurrencyID, toCurrencyID, "" + amount,
                authData.getOrderId(), authData.getAccount().getSecret()))) {
            Logger.error("Provided and calculated enckeys do not match");
            return F.Promise.pure(ok(Json.toJson(createResponse("1", "Specified account does not exist or inactive"))));
        }

        Promise<Currency> currencyFromPromise = Promise.wrap(currencyRepository.retrieveById(fromCurrencyID));
        Promise<Currency> currencyToPromise = Promise.wrap(currencyRepository.retrieveById(toCurrencyID));

        Promise<Result> result = currencyFromPromise.zip(currencyToPromise).map(res -> CurrencyUtil.convert(amount, res._1, res._2)).
                map(res -> ok(Json.toJson(new CurrencyExchangeResponse("0", "" + (double) amount / 100 + " " + fromCurrencyID + " equals to " + (double) res / 100 + " " + toCurrencyID, fromCurrencyID, toCurrencyID, amount, res))));

        return result.recover(error -> {

                    Logger.error("Error:", error);

                    return ok(Json.toJson(createResponse("2", error.getMessage())));

                }
        );
    }

}