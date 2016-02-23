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
    public static final String WRONG_CUSTOMER_ACCOUNT_TEXT = "Wrong customer account";

    public static final byte ALREADY_REGISTERED_CUSTOMER_ACCOUNT_CODE = 4;
    public static final String ALREADY_REGISTERED_CUSTOMER_ACCOUNT_TEXT = "Already registered customer account";

    public static final byte PASSWORD_MISMATCH_CODE = 5;
    public static final String PASSWORD_MISMATCH_TEXT = "Password mismatch";

    public static final byte PASSWORD_EQUALS_TO_EXISTED_CODE = 6;
    public static final String PASSWORD_EQUALS_TO_EXISTED_TEXT = "Specified password equals to existed";

    public static final byte INCORRECT_AUTHORIZATION_DATA_CODE = 7;
    public static final String INCORRECT_AUTHORIZATION_DATA_TEXT = "Incorrect authorization data";

    public static final byte INCORRECT_CARD_CODE = 8;
    public static final String INCORRECT_CARD_TEXT = "Incorrect card reference";

    public static final byte INCORRECT_COUNTRY_CODE = 9;
    public static final String INCORRECT_COUNTRY_TEXT = "Incorrect country code or country inactive";

    public static final byte INCORRECT_CURRENCY_CODE = 10;
    public static final String INCORRECT_CURRENCY_TEXT = "Incorrect currency code";

    public static final byte KYC_RESTRICTION_CODE = 11;
    public static final String KYC_RESTRICTION_TEXT = "Operation permitted due to KYC level";

    public static final byte INCORRECT_ACCOUNT_CODE = 12;
    public static final String INCORRECT_ACCOUNT_TEXT = "Incorrect account";

    public static final byte INCORRECT_OPERATION_CODE = 13;
    public static final String INCORRECT_OPERATION_TEXT = "Incorrect operation";

    public static final byte INCORRECT_PROPERTY_CODE = 14;
    public static final String INCORRECT_PROPERTY_TEXT = "Incorrect property";

    public static final byte INCORRECT_TRANSACTION_CODE = 15;
    public static final String INCORRECT_TRANSACTION_TEXT = "Incorrect transaction";


    public static final byte GENERAL_ERROR_CODE = 100;
    public static final String GENERAL_ERROR_TEXT = "General error";

}
