package exception;

/**
 * Customer not registered exception
 *
 * @author corbandalas - created 16.02.2016
 * @since 0.2.0
 */
public class WrongAccountException extends MspException{

    public WrongAccountException() {
        super("");
    }

    public WrongAccountException(String message) {
        super(message);
    }
}
