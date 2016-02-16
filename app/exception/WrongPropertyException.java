package exception;

/**
 * Wrong property exception
 *
 * @author corbandalas - created 16.02.2016
 * @since 0.2.0
 */
public class WrongPropertyException extends MspException{

    public WrongPropertyException() {
        super("Wrong property exception");
    }

    public WrongPropertyException(String message) {
        super(message);
    }
}
