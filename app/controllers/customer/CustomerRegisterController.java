package controllers.customer;

import com.fasterxml.jackson.databind.JsonNode;
import com.google.inject.Inject;
import com.wordnik.swagger.annotations.*;
import configs.Constants;
import controllers.BaseController;
import controllers.admin.BaseMerchantApiAction;
import dto.Authentication;
import dto.customer.CustomerLoginResponse;
import dto.customer.CustomerRegister;
import dto.customer.CustomerRegisterResponse;
import exception.CustomerAlreadyRegisteredException;
import exception.WrongCountryException;
import exception.WrongPhoneNumberException;
import model.Customer;
import model.enums.KYC;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;
import play.Logger;
import play.libs.F;
import play.libs.F.Promise;
import play.libs.Json;
import play.mvc.Result;
import play.mvc.With;
import repository.CountryRepository;
import repository.CustomerRepository;
import sms.SmsGateway;
import util.SecurityUtil;
import util.Utils;

import java.util.Date;

import static configs.ReturnCodes.*;


/**
 * Customer registration API controller
 *
 * @author corbandalas - created 16.02.2016.
 * @since 0.2.0
 */
@Api(value = Constants.CUSTOMER_API_PATH + "/register", description = "Cardholder registration")
public class CustomerRegisterController extends BaseController {

    @Inject
    CustomerRepository customerRepository;

    @Inject
    CountryRepository countryRepository;

    @Inject
    SmsGateway smsGateway;

    @With(BaseMerchantApiAction.class)
    @ApiOperation(
            nickname = "register",
            value = "Register cardholder",
            notes = "Method allows to register cardholder information in the system",
            consumes = "application/json",
            produces = "application/json",
            httpMethod = "POST",
            response = CustomerRegisterResponse.class
    )

    @ApiResponses(value = {
            @ApiResponse(code = SUCCESS_CODE, message = SUCCESS_TEXT, response = CustomerRegisterResponse.class),
            @ApiResponse(code = WRONG_REQUEST_FORMAT_CODE, message = WRONG_REQUEST_FORMAT_TEXT),
            @ApiResponse(code = WRONG_REQUEST_ENCKEY_CODE, message = WRONG_REQUEST_ENCKEY_TEXT),
            @ApiResponse(code = WRONG_CUSTOMER_ACCOUNT_CODE, message = WRONG_CUSTOMER_ACCOUNT_TEXT),
            @ApiResponse(code = PASSWORD_MISMATCH_CODE, message = PASSWORD_MISMATCH_TEXT),
            @ApiResponse(code = INCORRECT_COUNTRY_CODE, message = INCORRECT_COUNTRY_TEXT),
            @ApiResponse(code = INCORRECT_PHONE_NUMBER_CODE, message = INCORRECT_PHONE_NUMBER_TEXT),
            @ApiResponse(code = GENERAL_ERROR_CODE, message = GENERAL_ERROR_TEXT)
    })
    @ApiImplicitParams(value = {@ApiImplicitParam(value = "Registration request", required = true, dataType = "dto.customer.CustomerRegister", paramType = "body"),
            @ApiImplicitParam(value = "Account id header", required = true, dataType = "String", paramType = "header", name = "accountId"),
            @ApiImplicitParam(value = "Enckey header. SHA256(accountId+orderId+phone+country+secret)",
                    required = true, dataType = "String", paramType = "header", name = "enckey"),
            @ApiImplicitParam(value = "orderId header", required = true, dataType = "String", paramType = "header", name = "orderId")})


    public Promise<Result> register() {

        final Authentication authData = (Authentication) ctx().args.get("authData");

        final JsonNode jsonNode = request().body().asJson();

        CustomerRegister customerRegister = null;

        try {
            customerRegister = Json.fromJson(jsonNode, CustomerRegister.class);

        } catch (Exception e) {
            Logger.error("Wrong request format:", e);

            return Promise.pure(createWrongRequestFormatResponse());
        }

        if (customerRegister == null || StringUtils.isBlank(customerRegister.getPhone()) || StringUtils.isBlank(customerRegister.getCountry())) {
            Logger.error("Missing params");
            return Promise.pure(createWrongRequestFormatResponse());
        }

        if (!authData.getEnckey().equalsIgnoreCase(SecurityUtil.generateKeyFromArray(authData.getAccount().getId().toString(), authData.getOrderId(), customerRegister.getPhone(), customerRegister.getCountry(),
                authData.getAccount().getSecret()))) {
            Logger.error("Provided and calculated enckeys do not match");
            return Promise.pure(createWrongEncKeyResponse());
        }

        final String country = customerRegister.getCountry();
        final String phone = customerRegister.getPhone();

        final Promise<F.Tuple<Boolean, Boolean>> resultPromise = Promise.wrap(countryRepository.checkCountry(customerRegister.getCountry())).zip(Promise.wrap(customerRepository.isRegistered(customerRegister.getPhone())));

        final Promise<Result> result = resultPromise.flatMap(rez -> {

            if (!rez._1) {
                Logger.error("Country is not exist");

                throw new WrongCountryException("Country is not exist or inactive");
            }

            if (rez._2) {
                Logger.error("Customer is already registered");

                throw new CustomerAlreadyRegisteredException("Customer is already registered");
            }

            final String password = RandomStringUtils.randomNumeric(4);
            final Customer customer = new Customer();

            if (!Utils.isValidPhoneNumber(phone, country)) {
               throw new WrongPhoneNumberException();
            }


            customer.setActive(true);
            customer.setCountry_id(country);
            customer.setKyc(KYC.NONE);
            customer.setPassword(SecurityUtil.generateKeyFromArray(password));
            customer.setId(phone);
            customer.setRegistrationDate(new Date());
            customer.setDateBirth(new Date());
            customer.setTemppassword(true);

            return Promise.wrap(customerRepository.create(customer)).zip(Promise.pure(password));

        }).map(res -> {

            smsGateway.sendSMS(phone, "Dear customer! Thank you for registration. Your temporary PIN code is " + res._2 + ". Please visit mysafepay.dk to complete registration.");

            return ok(Json.toJson(new CustomerRegisterResponse("" + SUCCESS_CODE, SUCCESS_TEXT)));
        });

        return returnRecover(result);

    }


}