package exception;

/**
 * General MSP API exception
 *
 * @author corbandalas - created 02.02.2016
 * @since 0.1.0
 *
 */
public class MspException extends Exception {


    public MspException(String message) {
        super(message);
    }


    public MspException(String message, Throwable cause) {
        super(message, cause);
    }
}
