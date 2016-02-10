package provider.dto;

/**
 * Card details response
 *
 * @author corbandalas - created 10.02.2016
 * @since 0.1.0
 */
public class CardDetailsResponse {

    private String pan;
    private String expDate;
    private String cvv;
    private double bal;
    private String actionCode;

    public CardDetailsResponse(String pan, String expDate, String cvv, double bal, String actionCode) {
        this.pan = pan;
        this.expDate = expDate;
        this.cvv = cvv;
        this.bal = bal;
        this.actionCode = actionCode;
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

    public String getCvv() {
        return cvv;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }

    public double getBal() {
        return bal;
    }

    public void setBal(double bal) {
        this.bal = bal;
    }

    public String getActionCode() {
        return actionCode;
    }

    public void setActionCode(String actionCode) {
        this.actionCode = actionCode;
    }
}
