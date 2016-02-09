package controllers;

import com.google.inject.Inject;
import com.wordnik.swagger.annotations.*;
import dto.CurrencyListResponse;
import dto.ExchangeRateHistoryListResponse;
import org.apache.commons.lang3.StringUtils;
import play.Logger;
import play.libs.F.Promise;
import play.libs.Json;
import play.mvc.Result;
import repository.ExchangeRateHistoryRepository;

/**
 * API exchangeRateHistory controller
 * @author nihilist - created 09.02.2016.
 * @since 0.1.0
 */
@Api(value = "/api/exchangeRateHistory", description = "Operations to manage exchangeRateHistory stored in DB")
public class ExchangeRateHistoryController extends BaseController {

    @Inject
    ExchangeRateHistoryRepository exchangeRateHistoryRepository;

    @ApiOperation(
            nickname = "retrieveByCurrency",
            value = "Retrieve exchangeRateHistory by currencyID",
            notes = "Get exchangeRateHistory by currencyID",
            produces = "application/json",
            httpMethod = "GET",
            response = ExchangeRateHistoryListResponse.class
    )

    @ApiResponses( value = {
            @ApiResponse(code = 0, message = "OK", response = ExchangeRateHistoryListResponse.class),
            @ApiResponse(code = 1, message = "Wrong request format"),
            @ApiResponse(code = 2, message = "DB error")
    })
    @ApiImplicitParams({
            @ApiImplicitParam(name = "currencyID", value = "Currency ID to retrieve", required = true, dataType = "string", paramType = "path")
    })
    public Promise<Result> retrieveByCurrencyID(String currencyID) {

        if (StringUtils.isBlank(currencyID)) {

            return Promise.pure(badRequest(Json.toJson(createResponse("1", "Wrong request format"))));
        }

        final Promise<Result> result = Promise.wrap(exchangeRateHistoryRepository.retrieveByCurrencyId(currencyID)).map(exchangeRateHistories -> ok(Json.toJson(new ExchangeRateHistoryListResponse("0", "OK", exchangeRateHistories))));

        return result.recover(error -> {
            Logger.error("Error:",error);
            return ok(Json.toJson(createResponse("1", error.getMessage())));
        });
    }

}