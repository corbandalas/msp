package controllers;

import com.google.inject.Inject;
import com.wordnik.swagger.annotations.*;
import dto.Authentication;
import dto.CurrencyListResponse;
import dto.ExchangeRateHistoryListResponse;
import org.apache.commons.lang3.StringUtils;
import play.Logger;
import play.libs.F;
import play.libs.F.Promise;
import play.libs.Json;
import play.mvc.Result;
import play.mvc.With;
import repository.ExchangeRateHistoryRepository;
import util.SecurityUtil;

/**
 * API exchangeRateHistory controller
 *
 * @author nihilist - created 09.02.2016.
 * @since 0.1.0
 */
@Api(value = "/api/exchangeRateHistory", description = "Operations to manage exchangeRateHistory stored in DB")
public class ExchangeRateHistoryController extends BaseController {

    @Inject
    ExchangeRateHistoryRepository exchangeRateHistoryRepository;

    @With(BaseMerchantApiAction.class)
    @ApiOperation(
            nickname = "retrieveByCurrency",
            value = "Retrieve exchangeRateHistory by currencyID",
            notes = "Get exchangeRateHistory by currencyID",
            produces = "application/json",
            httpMethod = "GET",
            response = ExchangeRateHistoryListResponse.class
    )

    @ApiResponses(value = {
            @ApiResponse(code = 0, message = "OK", response = ExchangeRateHistoryListResponse.class),
            @ApiResponse(code = 1, message = "Wrong request format"),
            @ApiResponse(code = 2, message = "DB error")
    })
    @ApiImplicitParams({
            @ApiImplicitParam(name = "currencyID", value = "Currency ID to retrieve", required = true, dataType = "string", paramType = "path"),
            @ApiImplicitParam(value = "Account id header", required = true, dataType = "String", paramType = "header", name = "accountId"),
            @ApiImplicitParam(value = "Enckey header SHA256(accountId+currencyID+orderId+secret)", required = true, dataType = "String", paramType = "header", name = "enckey"),
            @ApiImplicitParam(value = "orderId header", required = true, dataType = "String", paramType = "header", name = "orderId")})
    public Promise<Result> retrieveByCurrencyID(String currencyID) {

        if (StringUtils.isBlank(currencyID)) {

            return Promise.pure(badRequest(Json.toJson(createResponse("1", "Wrong request format"))));
        }

        final Authentication authData = (Authentication) ctx().args.get("authData");

        if (!authData.getEnckey().equalsIgnoreCase(SecurityUtil.generateKeyFromArray(authData.getAccount().getId().toString(), currencyID,
                authData.getOrderId(), authData.getAccount().getSecret()))) {
            Logger.error("Provided and calculated enckeys do not match");
            return F.Promise.pure(ok(Json.toJson(createResponse("1", "Specified account does not exist or inactive"))));
        }

        final Promise<Result> result = Promise.wrap(exchangeRateHistoryRepository.retrieveByCurrencyId(currencyID)).map(exchangeRateHistories -> ok(Json.toJson(new ExchangeRateHistoryListResponse("0", "OK", exchangeRateHistories))));

        return result.recover(error -> {
            Logger.error("Error:", error);
            return ok(Json.toJson(createResponse("1", error.getMessage())));
        });
    }

}