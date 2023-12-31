package configs;


/**
 * API response code constants
 *
 * @author corbandalas - created 23.02.2016
 * @since 0.2.0
 */
public class ReturnCodes {

    public static final byte SUCCESS_CODE = 0;
    public static final String SUCCESS_TEXT = "Successful";

    public static final byte WRONG_REQUEST_FORMAT_CODE = 1;
    public static final String WRONG_REQUEST_FORMAT_TEXT = "Wrong request format";

    public static final byte WRONG_REQUEST_ENCKEY_CODE = 2;
    public static final String WRONG_REQUEST_ENCKEY_TEXT = "Invalid request encryption checksum";

    public static final byte WRONG_CUSTOMER_ACCOUNT_CODE = 3;
    public static final String WRONG_CUSTOMER_ACCOUNT_TEXT = "Сardholder account is invalid or does not exist in the system";

    public static final byte ALREADY_REGISTERED_CUSTOMER_ACCOUNT_CODE = 4;
    public static final String ALREADY_REGISTERED_CUSTOMER_ACCOUNT_TEXT = "Cardholder account is already registered in the system";

    public static final byte PASSWORD_MISMATCH_CODE = 5;
    public static final String PASSWORD_MISMATCH_TEXT = "Password mismatch";

    public static final byte PASSWORD_EQUALS_TO_EXISTED_CODE = 6;
    public static final String PASSWORD_EQUALS_TO_EXISTED_TEXT = "Specified password matches the existing password";

    public static final byte INCORRECT_AUTHORIZATION_DATA_CODE = 7;
    public static final String INCORRECT_AUTHORIZATION_DATA_TEXT = "Authorization data is incorrect";

    public static final byte INCORRECT_CARD_CODE = 8;
    public static final String INCORRECT_CARD_TEXT = "Card reference is invalid";

    public static final byte INCORRECT_COUNTRY_CODE = 9;
    public static final String INCORRECT_COUNTRY_TEXT = "Country code is incorrect or country is inactive";

    public static final byte INCORRECT_CURRENCY_CODE = 10;
    public static final String INCORRECT_CURRENCY_TEXT = "Сurrency code is incorrect";

    public static final byte KYC_RESTRICTION_CODE = 11;
    public static final String KYC_RESTRICTION_TEXT = "Operation is not permitted due to KYC restrictions";

    public static final byte INCORRECT_ACCOUNT_CODE = 12;
    public static final String INCORRECT_ACCOUNT_TEXT = "Account is invalid or does not exist";

    public static final byte INCORRECT_OPERATION_CODE = 13;
    public static final String INCORRECT_OPERATION_TEXT = "Operation is incorrect";

    public static final byte INCORRECT_PROPERTY_CODE = 14;
    public static final String INCORRECT_PROPERTY_TEXT = "Property is incorrect";

    public static final byte INCORRECT_TRANSACTION_CODE = 15;
    public static final String INCORRECT_TRANSACTION_TEXT = "Transaction is incorrect";

    public static final byte INACTIVE_ACCOUNT_CODE = 16;
    public static final String INACTIVE_ACCOUNT_TEXT = "Account is not active";

    public static final byte INCORRECT_PHONE_NUMBER_CODE = 17;
    public static final String INCORRECT_PHONE_NUMBER_TEXT = "Phone number is not valid";

    public static final byte PASSWORD_ATTEMPTS_EXCEEDED_CODE = 18;
    public static final String PASSWORD_ATTEMPTS_EXCEEDED_TEXT = "Password attempts number exceeded";

    public static final byte INCORRECT_KYC_CODE = 19;
    public static final String INCORRECT_KYC_TEXT = "KYC level is incorrect";

    public static final byte LIMITS_EXCEEDED_CODE = 20;
    public static final String LIMITS_EXCEEDED_TEXT = "Limits exceeded";

    public static final byte CURRENCIES_NOT_EQUAL_CODE = 21;
    public static final String CURRENCIES_NOT_EQUAL_TEXT = "Transfer currency must be the same";

    public static final byte KYC_TRANSFER_RESTRICTION_CODE = 22;
    public static final String KYC_TRANSFER_RESTRICTION_TEXT = "KYC level is not allowed for transfer";

    public static final byte NOT_ENOUGH_FUNDS_CODE = 23;
    public static final String NOT_ENOUGH_FUNDS_TEXT = "You don’t have enough funds";

    public static final byte CARD_PROVIDER_EXCEPTION_CODE = 24;
    public static final String CARD_PROVIDER_EXCEPTION_TEXT = "Card Provider exception";

    public static final byte GENERAL_ERROR_CODE = 100;
    public static final String GENERAL_ERROR_TEXT = "General error";

}
