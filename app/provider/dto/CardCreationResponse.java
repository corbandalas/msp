package provider.dto;

/**
 * Card creation response
 *
 * @author corbandalas - created 09.02.2016
 * @since 0.1.0
 */
public class CardCreationResponse extends BaseCardResponse{

    private String token;
    private String cvv;
    private String pan;
    private String expDate;

    public CardCreationResponse(String token, String actionCode, String cvv, String pan, String expDate) {
        super(actionCode);
        this.token = token;
        this.cvv = cvv;
        this.pan = pan;
        this.expDate = expDate;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getCvv() {
        return cvv;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }

    public String getPan() {
        return pan;
    }

    public void setPan(String pan) {
        this.pan = pan;
    }

    public String getExpDate() {
        return expDate;
    }

    public void setExpDate(String expDate) {
        this.expDate = expDate;
    }
}
