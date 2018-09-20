package dto.payroll;


import java.util.List;

/**
 * Payroll create card request DTO object
 *
 * @author corbandalas created 29.09.2017.
 * @since 0.7.0
 */
public class PayrollCreateCardRequest {

    private String description;
    private long totalSum;
    private String currency;
    private List<PayrollCardBean> cards;

    public PayrollCreateCardRequest() {
    }

    public PayrollCreateCardRequest(String description, long totalSum, String currency, List<PayrollCardBean> cards) {
        this.description = description;
        this.cards = cards;
        this.totalSum = totalSum;
        this.currency = currency;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<PayrollCardBean> getCards() {
        return cards;
    }

    public void setCards(List<PayrollCardBean> cards) {
        this.cards = cards;
    }

    public long getTotalSum() {
        return totalSum;
    }

    public void setTotalSum(long totalSum) {
        this.totalSum = totalSum;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }
}
