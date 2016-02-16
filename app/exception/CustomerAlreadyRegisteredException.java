package exception;

/**
 * Customer already registered exception
 *
 * @author corbandalas - created 16.02.2016
 * @since 0.2.0
 */
public class CustomerAlreadyRegisteredException extends MspException{

    public CustomerAlreadyRegisteredException(String message) {
        super(message);
    }
}
