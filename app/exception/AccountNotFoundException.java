package exception;

/**
 * Account not found exception
 *
 * @author corbandalas - created 17.02.2016
 * @since 0.2.0
 */
public class AccountNotFoundException extends MspException{

    public AccountNotFoundException() {
        super("Account not found exception");
    }

    public AccountNotFoundException(String message) {
        super(message);
    }
}
