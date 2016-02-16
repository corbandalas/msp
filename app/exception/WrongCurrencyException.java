package exception;

/**
 * Wrong currency exception
 *
 * @author corbandalas - created 16.02.2016
 * @since 0.2.0
 */
public class WrongCurrencyException extends MspException{

    public WrongCurrencyException() {
        super("Wrong currency exception");
    }

    public WrongCurrencyException(String message) {
        super(message);
    }
}
