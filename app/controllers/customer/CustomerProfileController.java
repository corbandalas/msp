package controllers.customer;

import com.google.inject.Inject;
import com.wordnik.swagger.annotations.*;
import configs.Constants;
import controllers.BaseController;
import dto.BaseAPIResponse;
import dto.customer.CustomerProfileRequest;
import dto.customer.CustomerProfileResponse;
import model.Customer;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import play.Logger;
import play.libs.F;
import play.libs.Json;
import play.mvc.Result;
import play.mvc.With;
import repository.CustomerRepository;

import java.text.ParseException;

import static configs.ReturnCodes.*;


/**
 * API customer profile controller
 *
 * @author ra created 17.02.2016.
 * @since 0.2.0
 */
@Api(value = Constants.CUSTOMER_API_PATH + "/profile", description = "Get Cardholder profile methods")
public class CustomerProfileController extends BaseController {

    @Inject
    CustomerRepository customerRepository;

    @With(BaseCustomerApiAction.class)
    @ApiOperation(
            nickname = "getProfile",
            value = "Get cardholder account information",
            notes = "Method allows to retrieve cardholder account information stored in the profile",
            consumes = "application/json",
            produces = "application/json",
            httpMethod = "GET",
            response = CustomerProfileResponse.class
    )
    @ApiResponses(value = {
            @ApiResponse(code = SUCCESS_CODE, message = SUCCESS_TEXT, response = CustomerProfileResponse.class),
            @ApiResponse(code = INCORRECT_AUTHORIZATION_DATA_CODE, message = INCORRECT_AUTHORIZATION_DATA_TEXT),
            @ApiResponse(code = WRONG_CUSTOMER_ACCOUNT_CODE, message = WRONG_CUSTOMER_ACCOUNT_TEXT),
            @ApiResponse(code = GENERAL_ERROR_CODE, message = GENERAL_ERROR_TEXT)
    })
    @ApiImplicitParams(value = {
            @ApiImplicitParam(value = "Access token header", required = true, dataType = "String", paramType = "header", name = "token")})
    public F.Promise<Result> retrieve() {
        final Customer customer = (Customer) ctx().args.get("customer");

        return F.Promise.pure(ok(Json.toJson(new CustomerProfileResponse(SUCCESS_TEXT, "" + SUCCESS_CODE, customer))));
    }

    @With(BaseCustomerApiAction.class)
    @ApiOperation(
            nickname = "updateProfile",
            value = "Update cardholder account information",
            notes = "Method allows to update cardholder account information stored in the profile",
            consumes = "application/json",
            produces = "application/json",
            httpMethod = "POST",
            response = BaseAPIResponse.class
    )
    @ApiResponses(value = {
            @ApiResponse(code = SUCCESS_CODE, message = SUCCESS_TEXT, response = BaseAPIResponse.class),
            @ApiResponse(code = INCORRECT_AUTHORIZATION_DATA_CODE, message = INCORRECT_AUTHORIZATION_DATA_TEXT),
            @ApiResponse(code = WRONG_REQUEST_FORMAT_CODE, message = WRONG_REQUEST_FORMAT_TEXT),
            @ApiResponse(code = GENERAL_ERROR_CODE, message = GENERAL_ERROR_TEXT)
    })
    @ApiImplicitParams(value = {
            @ApiImplicitParam(value = "Access token header", required = true, dataType = "String", paramType = "header", name = "token"),
            @ApiImplicitParam(value = "Profile request", required = true, dataType = "dto.customer.CustomerProfileRequest", paramType = "body")})
    public F.Promise<Result> update() {
        final Customer customer = (Customer) ctx().args.get("customer");

        final CustomerProfileRequest profile;
        try {
            profile = Json.fromJson(request().body().asJson(), CustomerProfileRequest.class);
        } catch (Exception e) {
            Logger.error("Wrong request format:", e);

            return F.Promise.pure(createWrongRequestFormatResponse());
        }

        if (profile == null || StringUtils.isBlank(profile.getAddress1()) || StringUtils.isBlank(profile.getAddress2())
                || StringUtils.isBlank(profile.getCity()) || StringUtils.isBlank(profile.getCountry_id())
                || StringUtils.isBlank(profile.getDateBirth()) || StringUtils.isBlank(profile.getEmail())
                || StringUtils.isBlank(profile.getFirstName()) || StringUtils.isBlank(profile.getLastName())
                || StringUtils.isBlank(profile.getPostcode()) || StringUtils.isBlank(profile.getRegistrationDate())
                || StringUtils.isBlank(profile.getTitle()) || StringUtils.isBlank(profile.getFlat()) || StringUtils.isBlank(profile.getHouseNameNumber()) || profile.getKyc() == null) {
            Logger.error("Missing params");
            return F.Promise.pure(createWrongRequestFormatResponse());
        }

        try {
            profile.copyToCustomer(customer);
        } catch (ParseException e) {
            Logger.error("Couldn't copy properties from customer to profile");
            return F.Promise.pure(createWrongRequestFormatResponse());
        }

        final F.Promise<Result> result = F.Promise.wrap(customerRepository.update(customer))
                .map(cust -> ok(Json.toJson(createResponse(String.valueOf(SUCCESS_CODE), SUCCESS_TEXT))));
        return returnRecover(result);
    }
}
