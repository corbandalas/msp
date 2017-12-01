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

    private String description;
    private List<PayrollCard> cards;

    public PayrollCreateCardRequest() {
    }

    public PayrollCreateCardRequest(String description, List<PayrollCard> cards) {
        this.description = description;
        this.cards = cards;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<PayrollCard> getCards() {
        return cards;
    }

    public void setCards(List<PayrollCard> cards) {
        this.cards = cards;
    }
}
