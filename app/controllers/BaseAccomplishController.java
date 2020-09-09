package controllers;

import dto.PropertyListResponse;
import dto.PropertyResponse;
import dto.partnerV2.BaseAPIV2ErrorResponse;
import exception.*;
import model.Property;
import play.Logger;
import play.libs.F;
import play.libs.Json;
import play.mvc.Result;
import play.mvc.Results;

import java.util.List;

import static configs.ReturnCodesV2.*;

/**
 * Base Play accomplish controller
 *
 * @author corbandalas - created 08.07.2020
 * @since 0.1.0
 */

public class BaseAccomplishController extends play.mvc.Controller {

    protected Results.Status createKycLimitResponse() {
        return badRequest(Json.toJson(new BaseAPIV2ErrorResponse(KYC_RESTRICTION_TEXT, "" + KYC_RESTRICTION_CODE, "", "")));
    }


    protected Results.Status createIncorrectCurrencyResponse() {
        return badRequest(Json.toJson(new BaseAPIV2ErrorResponse(INCORRECT_CURRENCY_TEXT, "" + INCORRECT_CURRENCY_CODE, "", "")));
    }

    protected Results.Status createIncorrectCountryResponse() {
        return badRequest(Json.toJson(new BaseAPIV2ErrorResponse(INCORRECT_COUNTRY_TEXT, "" + INCORRECT_COUNTRY_CODE, "", "")));
    }

    protected Results.Status createAlreadyRegisteredCustomerAccountResponse() {
        return badRequest(Json.toJson(new BaseAPIV2ErrorResponse(ALREADY_REGISTERED_CUSTOMER_ACCOUNT_TEXT, "" + ALREADY_REGISTERED_CUSTOMER_ACCOUNT_CODE, "", "")));
    }

    protected Results.Status createWrongCardResponse() {
        return badRequest(Json.toJson(new BaseAPIV2ErrorResponse(INCORRECT_CARD_TEXT, "" + INCORRECT_CARD_CODE, "", "")));
    }

    protected Results.Status createCurrencyNotTheSameResponse() {
        return badRequest(Json.toJson(new BaseAPIV2ErrorResponse(CURRENCIES_NOT_EQUAL_TEXT, "" + CURRENCIES_NOT_EQUAL_CODE, "", "")));
    }

    protected Results.Status createWrongTransferKYCResponse() {
        return badRequest(Json.toJson(new BaseAPIV2ErrorResponse(KYC_TRANSFER_RESTRICTION_TEXT, "" + KYC_TRANSFER_RESTRICTION_CODE, "", "")));
    }

    protected Results.Status createNotEnoughFundsResponse() {
        return badRequest(Json.toJson(new BaseAPIV2ErrorResponse(NOT_ENOUGH_FUNDS_TEXT, "" + NOT_ENOUGH_FUNDS_CODE, "", "")));
    }

    protected Results.Status createCardProviderException(String errorCode, String message) {
        return badRequest(Json.toJson(new BaseAPIV2ErrorResponse(CARD_PROVIDER_EXCEPTION_TEXT, "" + CARD_PROVIDER_EXCEPTION_CODE, errorCode, message)));
    }

    protected Results.Status createWrongKYCResponse() {
        return badRequest(Json.toJson(new BaseAPIV2ErrorResponse(INCORRECT_KYC_TEXT, "" + INCORRECT_KYC_CODE, "", "")));
    }

    protected Results.Status createLimitsExceededResponse() {
        return badRequest(Json.toJson(new BaseAPIV2ErrorResponse(LIMITS_EXCEEDED_TEXT, "" + LIMITS_EXCEEDED_CODE, "", "")));
    }

    protected Results.Status createGeneralErrorResponse() {
        return badRequest(Json.toJson(new BaseAPIV2ErrorResponse(GENERAL_ERROR_TEXT, "" + GENERAL_ERROR_CODE, "", "")));
    }

    protected Results.Status createWrongCustomerAccountResponse() {
        return badRequest(Json.toJson(new BaseAPIV2ErrorResponse(WRONG_CUSTOMER_ACCOUNT_TEXT, "" + WRONG_CUSTOMER_ACCOUNT_CODE, "", "")));
    }

    protected Results.Status createPasswordMismatchResponse() {
        return badRequest(Json.toJson(new BaseAPIV2ErrorResponse(PASSWORD_MISMATCH_TEXT, "" + PASSWORD_MISMATCH_CODE, "", "")));
    }

    protected Results.Status createPasswordEqualsToExistedResponse() {
        return badRequest(Json.toJson(new BaseAPIV2ErrorResponse(PASSWORD_EQUALS_TO_EXISTED_TEXT, "" + PASSWORD_EQUALS_TO_EXISTED_CODE, "", "")));
    }


    protected Results.Status createWrongRequestFormatResponse() {
        return badRequest(Json.toJson(new BaseAPIV2ErrorResponse(WRONG_REQUEST_FORMAT_TEXT, "" + WRONG_REQUEST_FORMAT_CODE, "", "")));
    }

    protected Results.Status createWrongRequestFormatResponse(String details) {
        return badRequest(Json.toJson(new BaseAPIV2ErrorResponse(WRONG_REQUEST_FORMAT_TEXT, "" + WRONG_REQUEST_FORMAT_CODE, details, "")));
    }


    protected Results.Status createWrongPhoneNumberResponse() {
        return badRequest(Json.toJson(new BaseAPIV2ErrorResponse(INCORRECT_PHONE_NUMBER_TEXT, "" + INCORRECT_PHONE_NUMBER_CODE, "", "")));
    }

    protected Results.Status createPasswordExceededResponse() {
        return badRequest(Json.toJson(new BaseAPIV2ErrorResponse(PASSWORD_ATTEMPTS_EXCEEDED_TEXT, "" + PASSWORD_ATTEMPTS_EXCEEDED_CODE, "", "")));
    }

    protected Result createRedirect(String url) {
        return redirect(url);
    }

    protected Results.Status createWrongEncKeyResponse() {
        return badRequest(Json.toJson(new BaseAPIV2ErrorResponse(WRONG_REQUEST_ENCKEY_TEXT, "" + WRONG_REQUEST_ENCKEY_CODE, "", "")));
    }


    protected BaseAPIV2ErrorResponse createResponse(String code, String text, String details, String number) {
        return new BaseAPIV2ErrorResponse(text, code, details, number);
    }

    protected PropertyListResponse createResponse(String code, String text, List<Property> propertyList) {
        return new PropertyListResponse(text, code, propertyList);
    }

    protected PropertyResponse createResponse(String code, String text, Property property) {
        return new PropertyResponse(text, code, property);
    }

    protected Results.Status createIncorrectAccountResponse() {
        return badRequest(Json.toJson(new BaseAPIV2ErrorResponse(INCORRECT_ACCOUNT_TEXT, "" + INCORRECT_ACCOUNT_CODE, "", "")));
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

                    if (throwable instanceof NotEnoughFundsException) {
                        return createNotEnoughFundsResponse();
                    }

                    if (throwable instanceof CardProviderException) {
                        return createCardProviderException(((CardProviderException) throwable).getErrorCode(), ((CardProviderException) throwable).getText());
                    }

                    return createGeneralErrorResponse();
                }

        );
    }




}
