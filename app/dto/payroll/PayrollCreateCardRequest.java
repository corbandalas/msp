package dto.payroll;


import model.PayrollCard;

import java.util.List;

/**
 * Payroll create card request DTO object
 *
 * @author corbandalas created 29.09.2017.
 * @since 0.7.0
 */
public class PayrollCreateCardRequest {

    private String orderId;
    private String description;
    private Integer accountID;
    private List<PayrollCard> cards;

    public PayrollCreateCardRequest() {
    }

    public PayrollCreateCardRequest(String orderId, String description, Integer accountID, List<PayrollCard> cards) {
        this.orderId = orderId;
        this.description = description;
        this.accountID = accountID;
        this.cards = cards;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getAccountID() {
        return accountID;
    }

    public void setAccountID(Integer accountID) {
        this.accountID = accountID;
    }

    public List<PayrollCard> getCards() {
        return cards;
    }

    public void setCards(List<PayrollCard> cards) {
        this.cards = cards;
    }
}
