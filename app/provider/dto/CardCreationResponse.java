package provider.dto;

/**
 * Card creation response
 *
 * @author corbandalas - created 09.02.2016
 * @since 0.1.0
 */
public class CardCreationResponse {

    private String token;
    private String resultCode;
    private String cvv;
    private String pan;
    private String expDate;

    public CardCreationResponse(String token, String resultCode, String cvv, String pan, String expDate) {
        this.token = token;
        this.resultCode = resultCode;
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

    public String getResultCode() {
        return resultCode;
    }

    public void setResultCode(String resultCode) {
        this.resultCode = resultCode;
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
