package exception;

/**
 * Wrong country exception
 *
 * @author corbandalas - created 16.02.2016
 * @since 0.2.0
 */
public class WrongCountryException extends MspException {

    public WrongCountryException() {
        super("Wrong country exception");
    }

    public WrongCountryException(String message) {
        super(message);
    }
}
