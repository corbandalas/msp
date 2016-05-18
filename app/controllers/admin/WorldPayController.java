package controllers.admin;

import com.google.inject.Inject;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.*;
import configs.Constants;
import controllers.BaseController;
import dto.*;
import play.Logger;
import play.libs.F;
import play.libs.Json;
import play.mvc.Result;
import play.mvc.With;
import util.SecurityUtil;
import worldpay.WorldPayPaymentClient;

import static configs.ReturnCodes.*;

/**
 * WorldPay API account controller
 *
 * @author corbandalas created 18.05.2016.
 * @since 0.2.0
 */
@Api(value = Constants.ADMIN_API_PATH + "/worldpay", description = "Allows to use WorldPay payment API.")
public class WorldPayController extends BaseController {

    @Inject
    private WorldPayPaymentClient worldPayPaymentClient;

    @With(BaseMerchantApiAction.class)
    @ApiOperation(
            nickname = "getBankDetails",
            value = "Obtain list of bank details",
            notes = "Method allows to obtain list of bank account details supported by WorldPay gateway",
            produces = "application/json",
            consumes = "application/json",
            httpMethod = "POST",
            response = BankDetailsListResponse.class
    )

    @ApiResponses(value = {
            @ApiResponse(code = SUCCESS_CODE, message = SUCCESS_TEXT, response = BankDetailsListResponse.class),
            @ApiResponse(code = INCORRECT_AUTHORIZATION_DATA_CODE, message = INCORRECT_AUTHORIZATION_DATA_TEXT, response = BaseAPIResponse.class),
            @ApiResponse(code = INACTIVE_ACCOUNT_CODE, message = INACTIVE_ACCOUNT_TEXT, response = BaseAPIResponse.class),
            @ApiResponse(code = WRONG_REQUEST_FORMAT_CODE, message = WRONG_REQUEST_FORMAT_TEXT, response = BaseAPIResponse.class),
            @ApiResponse(code = WRONG_REQUEST_ENCKEY_CODE, message = WRONG_REQUEST_ENCKEY_TEXT, response = BaseAPIResponse.class),
            @ApiResponse(code = GENERAL_ERROR_CODE, message = GENERAL_ERROR_TEXT, response = BaseAPIResponse.class),
    })
    @ApiImplicitParams(value = {
            @ApiImplicitParam(name = "country", value = "Country", required = true, dataType = "String", paramType = "path"),
            @ApiImplicitParam(value = "Account id header", required = true, dataType = "String", paramType = "header", name = "accountId"),
            @ApiImplicitParam(value = "Enckey header. SHA256(accountId+orderId+country+secret)",
                    required = true, dataType = "String", paramType = "header", name = "enckey"),
            @ApiImplicitParam(value = "orderId header", required = true, dataType = "String", paramType = "header", name = "orderId")})
    public F.Promise<Result> getBankDetails(String country) {

        final Authentication authData = (Authentication) ctx().args.get("authData");
        if (!authData.getEnckey().equalsIgnoreCase(SecurityUtil.generateKeyFromArray(authData.getAccount().getId().toString(), authData.getOrderId(), country, authData.getAccount().getSecret()))) {
            Logger.error("Provided and calculated enckeys do not match");
            return F.Promise.pure(createWrongEncKeyResponse());
        }

        final F.Promise<Result> result = worldPayPaymentClient.getBankDetails(country).map(details ->
                ok(Json.toJson(new BankDetailsListResponse(SUCCESS_TEXT, String.valueOf(SUCCESS_CODE), details.getBankDetails().getBankDetailsResultV2()))));
        return returnRecover(result);
    }


}
