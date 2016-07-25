package dto.customer;

/**
 * Plastic card activation request
 *
 * @author nihilist created 25.07.2016.
 * @since 0.3.0
 */
public class PlasticCardActivation {

    private Long cardID;
    private String pan;
    private String cvv;

    public void setCardID(Long cardID) {
        this.cardID = cardID;
    }

    public Long getCardID() {
        return cardID;
    }

    public String getPan() {
        return pan;
    }

    public void setPan(String pan) {
        this.pan = pan;
    }

    public String getCvv() {
        return cvv;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }
}
