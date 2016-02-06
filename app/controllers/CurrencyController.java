package controllers;

import com.google.inject.Inject;
import com.wordnik.swagger.annotations.*;
import dto.CurrencyListResponse;
import play.Logger;
import play.libs.F.Promise;
import play.libs.Json;
import play.mvc.Result;
import repository.CurrencyRepository;

/**
 * API currency controller
 * @author ra - created 06.02.2016.
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
}
