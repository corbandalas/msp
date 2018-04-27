package exception;

/**
 * Card provider exception
 *
 * @author corbandalas - created 08.02.2016
 * @since 0.1.0
 *
 */
public class CardProviderException extends MspException{

    private String errorCode;

    public CardProviderException(String message) {
        super(message);
    }

    public CardProviderException(String message, String errorCode) {
        super(message);
        this.errorCode = errorCode;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }
}
