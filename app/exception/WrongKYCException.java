package exception;

/**
 * Wrong KYC exception
 *
 * @author corbandalas - created 14.06.2016
 * @since 0.3.0
 */
public class WrongKYCException extends MspException{

    public WrongKYCException() {
        super("Wrong KYC exception");
    }

    public WrongKYCException(String message) {
        super(message);
    }
}
