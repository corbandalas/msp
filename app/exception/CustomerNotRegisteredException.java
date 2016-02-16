package exception;

/**
 * Customer not registered exception
 *
 * @author corbandalas - created 16.02.2016
 * @since 0.2.0
 */
public class CustomerNotRegisteredException extends MspException{

    public CustomerNotRegisteredException() {
        super("");
    }

    public CustomerNotRegisteredException(String message) {
        super(message);
    }
}
