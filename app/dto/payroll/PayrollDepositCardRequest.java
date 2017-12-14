package dto.payroll;


import java.util.List;

/**
 * Payroll create card request DTO object
 *
 * @author corbandalas created 12.12.2017.
 * @since 0.7.0
 */
public class PayrollDepositCardRequest {

    private String description;
    private List<PayrollCardDepositBean> cards;

    public PayrollDepositCardRequest() {
    }

    public PayrollDepositCardRequest(String description, List<PayrollCardDepositBean> cards) {
        this.description = description;
        this.cards = cards;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<PayrollCardDepositBean> getCards() {
        return cards;
    }

    public void setCards(List<PayrollCardDepositBean> cards) {
        this.cards = cards;
    }
}
