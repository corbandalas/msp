package dto.customer;

/**
 * API customer card change pin request
 *
 * @author nihilist created 23.02.2016.
 * @since 0.1.0
 */
public class CustomerCardManagementChangePIN {

    private Long cardID;
    private String currentPIN;
    private String newPIN;
    private String confirmNewPIN;

    public Long getCardID() {
        return cardID;
    }

    public void setCardID(Long cardID) {
        this.cardID = cardID;
    }

    public String getCurrentPIN() {
        return currentPIN;
    }

    public void setCurrentPIN(String currentPIN) {
        this.currentPIN = currentPIN;
    }

    public String getNewPIN() {
        return newPIN;
    }

    public void setNewPIN(String newPIN) {
        this.newPIN = newPIN;
    }

    public String getConfirmNewPIN() {
        return confirmNewPIN;
    }

    public void setConfirmNewPIN(String confirmNewPIN) {
        this.confirmNewPIN = confirmNewPIN;
    }
}
