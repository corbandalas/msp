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
    private long totalSum;
    private String currency;

    public PayrollDepositCardRequest() {
    }

    public PayrollDepositCardRequest(Long totalSum, String currency, String description, List<PayrollCardDepositBean> cards) {
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

    public List<PayrollCardDepositBean> getCards() {
        return cards;
    }

    public void setCards(List<PayrollCardDepositBean> cards) {
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
