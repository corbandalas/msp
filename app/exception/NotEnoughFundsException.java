package exception;

/**
 * Not enough funds exception
 *
 * @author corbandalas - created 07.09.2017
 * @since 0.3.0
 *
 */
public class NotEnoughFundsException extends MspException{

    public NotEnoughFundsException(String message) {
        super(message);
    }
}
