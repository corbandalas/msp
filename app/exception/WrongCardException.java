package exception;

/**
 * Customer not registered exception
 *
 * @author corbandalas - created 16.02.2016
 * @since 0.2.0
 */
public class WrongCardException extends MspException{

    public WrongCardException() {
        super("");
    }

    public WrongCardException(String message) {
        super(message);
    }
}
