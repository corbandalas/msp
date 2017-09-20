package dto.partner;

/**
 * Activate card request DTO object
 *
 * @author corbandalas created 20.09.2017.
 * @since 0.6.0
 */
public class ActivateCardRequest {

    private String token;

    private String cvv;

    private String cardNumber;


    public ActivateCardRequest() {
    }

    public ActivateCardRequest(String token, String cvv, String cardNumber) {
        this.token = token;
        this.cvv = cvv;
        this.cardNumber = cardNumber;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getCvv() {
        return cvv;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }
}


