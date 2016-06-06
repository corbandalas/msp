package controllers;

import dto.BaseAPIResponse;
import dto.PropertyListResponse;
import dto.PropertyResponse;
import exception.*;
import model.Property;
import play.Logger;
import play.libs.F;
import play.libs.Json;
import play.mvc.Result;
import play.mvc.Results;

import java.util.List;

import static configs.ReturnCodes.*;

/**
 * Base Play controller
 *
 * @author corbandalas - created 31.01.2016
 * @since 0.1.0
 */

public class BaseController extends play.mvc.Controller {

    protected Results.Status createKycLimitResponse() {
        return badRequest(Json.toJson(new BaseAPIResponse(KYC_RESTRICTION_TEXT, "" + KYC_RESTRICTION_CODE)));
    }


    protected Results.Status createIncorrectCurrencyResponse() {
        return badRequest(Json.toJson(new BaseAPIResponse(INCORRECT_CURRENCY_TEXT, "" + INCORRECT_CURRENCY_CODE)));
    }

    protected Results.Status createIncorrectCountryResponse() {
        return badRequest(Json.toJson(new BaseAPIResponse(INCORRECT_COUNTRY_TEXT, "" + INCORRECT_COUNTRY_CODE)));
    }

    protected Results.Status createAlreadyRegisteredCustomerAccountResponse() {
        return badRequest(Json.toJson(new BaseAPIResponse(ALREADY_REGISTERED_CUSTOMER_ACCOUNT_TEXT, "" + ALREADY_REGISTERED_CUSTOMER_ACCOUNT_CODE)));
    }

    protected Results.Status createWrongCardResponse() {
        return badRequest(Json.toJson(new BaseAPIResponse(INCORRECT_CARD_TEXT, "" + INCORRECT_CARD_CODE)));
    }

    protected Results.Status createGeneralErrorResponse() {
        return badRequest(Json.toJson(new BaseAPIResponse(GENERAL_ERROR_TEXT, "" + GENERAL_ERROR_CODE)));
    }

    protected Results.Status createWrongCustomerAccountResponse() {
        return badRequest(Json.toJson(new BaseAPIResponse(WRONG_CUSTOMER_ACCOUNT_TEXT, "" + WRONG_CUSTOMER_ACCOUNT_CODE)));
    }

    protected Results.Status createPasswordMismatchResponse() {
        return badRequest(Json.toJson(new BaseAPIResponse(PASSWORD_MISMATCH_TEXT, "" + PASSWORD_MISMATCH_CODE)));
    }

    protected Results.Status createPasswordEqualsToExistedResponse() {
        return badRequest(Json.toJson(new BaseAPIResponse(PASSWORD_EQUALS_TO_EXISTED_TEXT, "" + PASSWORD_EQUALS_TO_EXISTED_CODE)));
    }


    protected Results.Status createWrongRequestFormatResponse() {
        return badRequest(Json.toJson(new BaseAPIResponse(WRONG_REQUEST_FORMAT_TEXT, "" + WRONG_REQUEST_FORMAT_CODE)));
    }

    protected Results.Status createWrongPhoneNumberResponse() {
        return badRequest(Json.toJson(new BaseAPIResponse(INCORRECT_PHONE_NUMBER_TEXT, "" + INCORRECT_PHONE_NUMBER_CODE)));
    }

    protected Results.Status createPasswordExceededResponse() {
        return badRequest(Json.toJson(new BaseAPIResponse(PASSWORD_ATTEMPTS_EXCEEDED_TEXT, "" + PASSWORD_ATTEMPTS_EXCEEDED_CODE)));
    }

    protected Result createRedirect(String url) {
        return redirect(url);
    }

    protected Results.Status createWrongEncKeyResponse() {
        return badRequest(Json.toJson(new BaseAPIResponse(WRONG_REQUEST_ENCKEY_TEXT, "" + WRONG_REQUEST_ENCKEY_CODE)));
    }


    protected BaseAPIResponse createResponse(String code, String text) {
        return new BaseAPIResponse(text, code);
    }

    protected PropertyListResponse createResponse(String code, String text, List<Property> propertyList) {
        return new PropertyListResponse(text, code, propertyList);
    }

    protected PropertyResponse createResponse(String code, String text, Property property) {
        return new PropertyResponse(text, code, property);
    }

    protected Results.Status createIncorrectAccountResponse() {
        return badRequest(Json.toJson(new BaseAPIResponse(INCORRECT_ACCOUNT_TEXT, "" + INCORRECT_ACCOUNT_CODE)));
    }

    protected F.Promise<Result> returnRecover(F.Promise<Result> result) {
        return result.recover(throwable -> {
                    Logger.error("Error: ", throwable);

                    if (throwable instanceof WrongCardException) {
                        return createWrongCardResponse();
                    }

                    if (throwable instanceof WrongCountryException) {
                        return createIncorrectCountryResponse();
                    }

                    if (throwable instanceof CustomerAlreadyRegisteredException) {
                        return createAlreadyRegisteredCustomerAccountResponse();
                    }

                    if (throwable instanceof CustomerNotRegisteredException) {
                        return createWrongCustomerAccountResponse();
                    }

                    if (throwable instanceof WrongPhoneNumberException) {
                        return createWrongPhoneNumberResponse();
                    }

                    return createGeneralErrorResponse();
                }

        );
    }
}
