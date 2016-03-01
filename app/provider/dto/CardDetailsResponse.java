package provider.dto;

/**
 * Card details response
 *
 * @author corbandalas - created 10.02.2016
 * @since 0.1.0
 */
public class CardDetailsResponse extends BaseCardResponse{

    private String pan;
    private String expDate;
    private String cvv;
    private double bal;
    private String currency;
    private String statCode;

    public CardDetailsResponse(String pan, String expDate, String cvv, double bal, String currency, String statCode, String actionCode) {
        super(actionCode);
        this.pan = pan;
        this.expDate = expDate;
        this.cvv = cvv;
        this.bal = bal;
        this.currency = currency;
        this.statCode = statCode;
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

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getStatCode() {
        return statCode;
    }

    public void setStatCode(String statCode) {
        this.statCode = statCode;
    }
}
