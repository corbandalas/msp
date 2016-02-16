package controllers.customer;

import com.fasterxml.jackson.databind.JsonNode;
import com.google.inject.Inject;
import com.wordnik.swagger.annotations.*;
import configs.Constants;
import controllers.BaseController;
import controllers.admin.BaseMerchantApiAction;
import dto.Authentication;
import dto.customer.CustomerRegister;
import dto.customer.CustomerRegisterResponse;
import exception.CustomerAlreadyRegisteredException;
import exception.WrongCountryException;
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

import java.util.Date;


/**
 * Customer registration API controller
 *
 * @author corbandalas - created 16.02.2016.
 * @since 0.2.0
 */
@Api(value = Constants.CUSTOMER_API_PATH + "/register", description = "Customer registration")
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
            value = "Register customer by phone and country",
            notes = "Allows merchants to send customer registration data",
            consumes = "application/json",
            produces = "application/json",
            httpMethod = "POST",
            response = CustomerRegisterResponse.class
    )

    @ApiResponses(value = {
            @ApiResponse(code = 0, message = "OK", response = CustomerRegisterResponse.class),
            @ApiResponse(code = 1, message = "Missing params"),
            @ApiResponse(code = 2, message = "Wrong request format"),
            @ApiResponse(code = 3, message = "Wrong enckey"),
            @ApiResponse(code = 4, message = "Country not exist or inactive"),
            @ApiResponse(code = 5, message = "Customer already registered"),
            @ApiResponse(code = 6, message = "General error")
    })
    @ApiImplicitParams(value = {@ApiImplicitParam(value = "Registration request", required = true, dataType = "dto.customer.CustomerRegister", paramType = "body"),
            @ApiImplicitParam(value = "Account id header", required = true, dataType = "String", paramType = "header", name = "accountId"),
            @ApiImplicitParam(value = "Enckey header. SHA256(accountId+orderId+phone+country++secret)",
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

            return Promise.pure(badRequest(Json.toJson(createResponse("1", "Missing params"))));
        }

        if (customerRegister == null || StringUtils.isBlank(customerRegister.getPhone()) || StringUtils.isBlank(customerRegister.getCountry())) {
            Logger.error("Missing params");
            return Promise.pure(ok(Json.toJson(createResponse("2", "Missing params"))));
        }

        if (!authData.getEnckey().equalsIgnoreCase(SecurityUtil.generateKeyFromArray(authData.getAccount().getId().toString(), authData.getOrderId(), customerRegister.getPhone(), customerRegister.getCountry(),
                authData.getAccount().getSecret()))) {
            Logger.error("Provided and calculated enckeys do not match");
            return Promise.pure(ok(Json.toJson(createResponse("3", "Wrong enckey"))));
        }

        final String country = customerRegister.getCountry();
        final String phone = customerRegister.getPhone();

        final Promise<F.Tuple<Boolean, Boolean>> resultPromise = Promise.wrap(countryRepository.checkCountry(customerRegister.getCountry())).zip(Promise.wrap(customerRepository.isRegistered(customerRegister.getPhone())));

        final Promise<Result> result = resultPromise.flatMap(rez -> {

            if (!rez._1) {
                Logger.error("Country is not exist");

                throw new WrongCountryException("Country is not exist or inactive");
            }

            if (!rez._2) {
                Logger.error("Customer is already registered");

                throw new CustomerAlreadyRegisteredException("Customer is already registered");
            }

            final String password = RandomStringUtils.randomNumeric(4);
            final Customer customer = new Customer();

            customer.setActive(true);
            customer.setCountry_id(country);
            customer.setKyc(KYC.SIMPLIFIED_DUE_DILIGENCE);
            customer.setPassword(SecurityUtil.generateKeyFromArray(password));
            customer.setId(phone);
            customer.setRegistrationDate(new Date());
            customer.setTemppassword(true);

            return Promise.wrap(customerRepository.create(customer)).zip(Promise.pure(password));

        }).map(res -> {

            smsGateway.sendSms(phone, "Dear " + res._1.getFullName() + "! Thank you for registration. Your temporary PIN code is " + res._2 + ". Please visit mysafepay.com to complete registration.");

            return ok(Json.toJson(new CustomerRegisterResponse("0", "Registration is OK")));
        });

        return result.recover(error -> {

                    Logger.error("Error:", error);

                    if (error instanceof WrongCountryException) {
                        return ok(Json.toJson(createResponse("4", error.getMessage())));
                    }

                    if (error instanceof CustomerAlreadyRegisteredException) {
                        return ok(Json.toJson(createResponse("5", error.getMessage())));
                    }

                    return ok(Json.toJson(createResponse("6", "General error")));

                }
        );

    }


}