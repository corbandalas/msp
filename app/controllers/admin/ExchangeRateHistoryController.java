package controllers.admin;

import com.google.inject.Inject;
import com.wordnik.swagger.annotations.*;
import configs.Constants;
import controllers.BaseController;
import dto.Authentication;
import dto.BaseAPIResponse;
import dto.ExchangeRateHistoryListResponse;
import org.apache.commons.lang3.StringUtils;
import play.Logger;
import play.libs.F.Promise;
import play.libs.Json;
import play.mvc.Result;
import play.mvc.With;
import repository.ExchangeRateHistoryRepository;
import util.SecurityUtil;

import static configs.ReturnCodes.*;

/**
 * API exchangeRateHistory controller
 *
 * @author nihilist - created 09.02.2016.
 * @since 0.1.0
 */
@Api(value = Constants.ADMIN_API_PATH + "/exchangeRateHistory", description = "Operations to manage exchangeRateHistory stored in DB")
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
            @ApiResponse(code = SUCCESS_CODE, message = SUCCESS_TEXT, response = ExchangeRateHistoryListResponse.class),
            @ApiResponse(code = INCORRECT_AUTHORIZATION_DATA_CODE, message = INCORRECT_AUTHORIZATION_DATA_TEXT, response = BaseAPIResponse.class),
            @ApiResponse(code = INACTIVE_ACCOUNT_CODE, message = INACTIVE_ACCOUNT_TEXT, response = BaseAPIResponse.class),
            @ApiResponse(code = WRONG_REQUEST_FORMAT_CODE, message = WRONG_REQUEST_FORMAT_TEXT, response = BaseAPIResponse.class),
            @ApiResponse(code = GENERAL_ERROR_CODE, message = GENERAL_ERROR_TEXT, response = BaseAPIResponse.class)
    })
    @ApiImplicitParams({
            @ApiImplicitParam(name = "currencyID", value = "Currency ID to retrieve", required = true, dataType = "string", paramType = "path"),
            @ApiImplicitParam(value = "Account id header", required = true, dataType = "String", paramType = "header", name = "accountId"),
            @ApiImplicitParam(value = "Enckey header SHA256(accountId+currencyID+orderId+secret)", required = true, dataType = "String", paramType = "header", name = "enckey"),
            @ApiImplicitParam(value = "orderId header", required = true, dataType = "String", paramType = "header", name = "orderId")})
    public Promise<Result> retrieveByCurrencyID(String currencyID) {

        if (StringUtils.isBlank(currencyID)) {

            return Promise.pure(createWrongRequestFormatResponse());
        }

        final Authentication authData = (Authentication) ctx().args.get("authData");

        if (!authData.getEnckey().equalsIgnoreCase(SecurityUtil.generateKeyFromArray(authData.getAccount().getId().toString(), currencyID,
                authData.getOrderId(), authData.getAccount().getSecret()))) {
            Logger.error("Provided and calculated enckeys do not match");
            return Promise.pure(createWrongEncKeyResponse());
        }

        final Promise<Result> result = Promise.wrap(exchangeRateHistoryRepository.retrieveByCurrencyId(currencyID))
                .map(exchangeRateHistories -> ok(Json.toJson(new ExchangeRateHistoryListResponse(
                        String.valueOf(SUCCESS_CODE), SUCCESS_TEXT, exchangeRateHistories))));

        return returnRecover(result);
    }

}