package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import com.google.inject.Inject;
import com.wordnik.swagger.annotations.*;
import dto.CurrencyListResponse;
import dto.CurrencyResponse;
import model.Currency;
import model.Property;
import org.apache.commons.lang3.StringUtils;
import play.Logger;
import play.libs.F.Promise;
import play.libs.Json;
import play.mvc.Result;
import repository.CurrencyRepository;

/**
 * API currency controller
 * @author nihilist - created 09.02.2016.
 * @since 0.1.0
 */
@Api(value = "/api/currency", description = "Operations to manage application currencies stored in DB")
public class CurrencyController extends BaseController {

    @Inject
    CurrencyRepository currencyRepository;

    @ApiOperation(
            nickname = "listAllCurrency",
            value = "All currency list",
            notes = "Obtain list of all currencies stored in DB",
            produces = "application/json",
            httpMethod = "GET",
            response = dto.CurrencyListResponse.class
    )

    @ApiResponses( value = {
            @ApiResponse(code = 0, message = "OK", response = dto.CurrencyListResponse.class),
            @ApiResponse(code = 1, message = "DB error"),
    })
    public Promise<Result> retrieveAll() {

        final Promise<Result> result = Promise.wrap(currencyRepository.retrieveAll()).map(currencies -> ok(Json.toJson(new CurrencyListResponse("0", "OK", currencies))));

        return result.recover(error -> {
            Logger.error("Error:",error);
            return ok(Json.toJson(createResponse("1", error.getMessage())));
        });
    }

    @ApiOperation(
            nickname = "retrieveById",
            value = "Retrieve currency by ID",
            notes = "Get currency by its ID",
            produces = "application/json",
            httpMethod = "GET",
            response = dto.CurrencyResponse.class
    )

    @ApiResponses( value = {
            @ApiResponse(code = 0, message = "OK", response = dto.CurrencyResponse.class),
            @ApiResponse(code = 1, message = "Wrong request format"),
            @ApiResponse(code = 2, message = "DB error")
    })
    @ApiImplicitParams({
            @ApiImplicitParam(name = "currencyID", value = "Currency ID to retrieve", required = true, dataType = "string", paramType = "path")
    })
    public Promise<Result> retrieveByID(String currencyID) {

        if (StringUtils.isBlank(currencyID)) {

            return Promise.pure(badRequest(Json.toJson(createResponse("1", "Wrong request format"))));
        }

        Promise<Currency> currencyPromise = Promise.wrap(currencyRepository.retrieveById(currencyID));

        Promise<Result> result = currencyPromise.map(res -> ok(Json.toJson(new CurrencyResponse("0", "OK", res))));

        return result.recover(error -> {

                    Logger.error("Error:", error);

                    return ok(Json.toJson(createResponse("2", error.getMessage())));

                }
        );
    }

    @ApiOperation(
            nickname = "updateCurrency",
            value = "Update existed currency",
            notes = "Update existed application currency in DB",
            produces = "application/json",
            consumes = "application/json",
            httpMethod = "POST",
            response = dto.BaseAPIResponse.class
    )

    @ApiResponses( value = {
            @ApiResponse(code = 0, message = "Currency was updated successfully"),
            @ApiResponse(code = 1, message = "Wrong request format"),
            @ApiResponse(code = 2, message = "DB error"),
    })
    @ApiImplicitParams(value = {@ApiImplicitParam(value = "Currency request", required = true, dataType = "model.Currency", paramType = "body")})


    public Promise<Result> update() {

        final JsonNode jsonNode = request().body().asJson();

        Currency currency = null;

        try {
            currency = Json.fromJson(jsonNode, Currency.class);

        } catch (Exception e) {
            Logger.error("Wrong request format:", e);

            return Promise.pure(badRequest(Json.toJson(createResponse("1", "Wrong request format"))));
        }

        final Promise<Currency> currencyPromise = Promise.wrap(currencyRepository.update(currency));

        Promise<Result> result = currencyPromise.map(res -> ok(Json.toJson(createResponse("0", "Property was updated successfully"))));

        return result.recover(error -> {

                    Logger.error("Error:", error);

                    return ok(Json.toJson(createResponse("2", error.getMessage())));

                }
        );
    }

}