package controllers.customer;

import com.google.inject.Inject;
import com.wordnik.swagger.annotations.*;
import configs.Constants;
import controllers.BaseController;
import dto.BaseAPIResponse;
import dto.customer.CustomerProfileResponse;
import dto.customer.ObtainFeeRequest;
import dto.customer.ObtainFeeResponse;
import model.Customer;
import model.FeeInterval;
import play.Logger;
import play.cache.CacheApi;
import play.libs.F;
import play.libs.Json;
import play.mvc.Result;
import play.mvc.With;
import repository.CustomerRepository;
import repository.FeeIntervalRepository;
import repository.FeeRepository;
import util.FeeUtil;

import java.util.List;

import static configs.ReturnCodes.*;


/**
 * API customer fee controller
 *
 * @author corbandalas created 18.05.2017.
 * @since 0.4.0
 */
@Api(value = Constants.CUSTOMER_API_PATH + "/fee", description = "Get transaction operation fees")
public class CustomerFeeController extends BaseController {

    @Inject
    CustomerRepository customerRepository;

    @Inject
    FeeIntervalRepository feeIntervalRepository;

    @Inject
    FeeRepository feeRepository;

    @Inject
    CacheApi cache;

    @With(BaseCustomerApiAction.class)
    @ApiOperation(
            nickname = "getFee",
            value = "Get transaction operation fee account information",
            notes = "Method allows to retrieve transaction operation fee info",
            consumes = "application/json",
            produces = "application/json",
            httpMethod = "GET",
            response = ObtainFeeResponse.class
    )
    @ApiResponses(value = {
            @ApiResponse(code = SUCCESS_CODE, message = SUCCESS_TEXT, response = BaseAPIResponse.class),
            @ApiResponse(code = INCORRECT_AUTHORIZATION_DATA_CODE, message = INCORRECT_AUTHORIZATION_DATA_TEXT),
            @ApiResponse(code = WRONG_REQUEST_FORMAT_CODE, message = WRONG_REQUEST_FORMAT_TEXT),
            @ApiResponse(code = GENERAL_ERROR_CODE, message = GENERAL_ERROR_TEXT)
    })
    @ApiImplicitParams(value = {
            @ApiImplicitParam(value = "Access token header", required = true, dataType = "String", paramType = "header", name = "token"),
            @ApiImplicitParam(value = "Profile request", required = true, dataType = "dto.customer.ObtainFeeRequest", paramType = "body")})
    public F.Promise<Result> obtainFee() {
        final Customer customer = (Customer) ctx().args.get("customer");

        Integer accountID = (Integer) cache.get("account_" + customer.getId());

        final ObtainFeeRequest obtainFeeRequest;
        try {
            obtainFeeRequest = Json.fromJson(request().body().asJson(), ObtainFeeRequest.class);
        } catch (Exception e) {
            Logger.error("Wrong request format:", e);

            return F.Promise.pure(createWrongRequestFormatResponse());
        }

        F.Promise<Long> totalSumWithFee = FeeUtil.getTotalSumWithFee(accountID, obtainFeeRequest.getAmount(), obtainFeeRequest.getCurrency(), obtainFeeRequest.getOperationType(), obtainFeeRequest.getFeeDestinationType(), feeRepository, feeIntervalRepository);

        F.Promise<List<FeeInterval>> fees = FeeUtil.getFees(accountID, obtainFeeRequest.getAmount(), obtainFeeRequest.getCurrency(), obtainFeeRequest.getOperationType(), obtainFeeRequest.getFeeDestinationType(), feeRepository, feeIntervalRepository);

        final F.Promise<Result> result = totalSumWithFee.zip(fees).map(res -> ok(Json.toJson(new ObtainFeeResponse(SUCCESS_TEXT, "" + SUCCESS_CODE, res._1, res._2))));

        return returnRecover(result);
    }

}
