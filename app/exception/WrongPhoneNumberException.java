package exception;

/**
 * Wrong phone number exception
 *
 * @author corbandalas - created 06.06.2016
 * @since 0.3.0
 */
public class WrongPhoneNumberException extends MspException{

    public WrongPhoneNumberException() {
        super("Wrong phone number exception");
    }

    public WrongPhoneNumberException(String message) {
        super(message);
    }
}
