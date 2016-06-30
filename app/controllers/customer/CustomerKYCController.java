package controllers.customer;

import com.fasterxml.jackson.databind.JsonNode;
import com.google.inject.Inject;
import com.wordnik.swagger.annotations.*;
import configs.Constants;
import controllers.BaseController;
import dto.BankDetailsListResponse;
import dto.customer.CustomerCardListResponse;
import dto.customer.CustomerKYCCheck;
import dto.customer.CustomerKYCCheckResponse;
import dto.customer.KYCServiceResult;
import model.Card;
import org.datacontract.schemas._2004._07.NeuromancerLibrary_DataContracts.ServiceResponse;
import org.datacontract.schemas._2004._07.NeuromancerLibrary_Resources.ServiceTransactionInformation;
import play.Logger;
import play.libs.F;
import play.libs.F.Promise;
import play.libs.Json;
import play.mvc.Result;
import play.mvc.With;
import services.W2GlobaldataService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static configs.ReturnCodes.*;


/**
 * Customer card list API controller
 *
 * @author corbandalas - created 17.02.2016.
 * @since 0.2.0
 */
@Api(value = Constants.CUSTOMER_API_PATH + "/kyc", description = "Customer KYC check UK")
public class CustomerKYCController extends BaseController {

    @Inject
    W2GlobaldataService w2GlobaldataService;

    @With(BaseCustomerApiAction.class)
    @ApiOperation(
            nickname = "kyc/checkUK",
            value = "Check kyc for UK",
            notes = "Allow check kyc by present data",
            produces = "application/json",
            consumes = "application/json",
            httpMethod = "POST",
            response = CustomerKYCCheckResponse.class
    )

    @ApiResponses(value = {
            @ApiResponse(code = SUCCESS_CODE, message = SUCCESS_TEXT, response = CustomerKYCCheckResponse.class),
            @ApiResponse(code = INCORRECT_AUTHORIZATION_DATA_CODE, message = INCORRECT_AUTHORIZATION_DATA_TEXT),
            @ApiResponse(code = WRONG_CUSTOMER_ACCOUNT_CODE, message = WRONG_CUSTOMER_ACCOUNT_TEXT),
            @ApiResponse(code = GENERAL_ERROR_CODE, message = GENERAL_ERROR_TEXT)
    })

    @ApiImplicitParams(value = {@ApiImplicitParam(value = "Check KYC request", required = true, dataType = "dto.customer.CustomerKYCCheck", paramType = "body"),
            @ApiImplicitParam(value = "Access token header", required = true, dataType = "String", paramType = "header", name = "token")})
    public Promise<Result> kycCheckUK() {

        String bundleName = "KYC_UK_SafePay_SDD";

        final JsonNode jsonNode = request().body().asJson();
        final CustomerKYCCheck request;

        try {
            request = Json.fromJson(jsonNode, CustomerKYCCheck.class);

        } catch (Exception e) {
            Logger.error("Wrong request format:", e);

            return F.Promise.pure(createWrongRequestFormatResponse());
        }
        if (request.getKycType().equalsIgnoreCase("FDD")) {
            bundleName = "KYC_UK_SafePay_FDD";
        }

        final F.Promise<Result> result = w2GlobaldataService.kycCheckUK(request.getNameQuery(), request.getForename(), request.getMiddleNames(), request.getSurname(), request.getDateOfBirth(), request.getHouseNameNumber(), request.getPostcode(), request.getFlat(), request.getStreet(), request.getCountry(), request.getCity(), request.getPhoneNumber(), bundleName).map(details ->
        {

        List<KYCServiceResult> kycServiceResults = new ArrayList<KYCServiceResult>();

            for (ServiceTransactionInformation serviceTransactionInformation : details.getProcessRequestResult().getTransactionInformation().getServiceTransactions()){
                kycServiceResults.add(new KYCServiceResult(serviceTransactionInformation.getService().getValue(), serviceTransactionInformation.getServiceInterpretResult().getValue(), serviceTransactionInformation.getServiceTransactionResultMessage()));
            }

            return ok(Json.toJson(
                    new CustomerKYCCheckResponse(SUCCESS_TEXT, String.valueOf(SUCCESS_CODE), details.getProcessRequestResult().getTransactionInformation().getInterpretResult().getValue(), kycServiceResults)));
        });
        return returnRecover(result);

    }


}