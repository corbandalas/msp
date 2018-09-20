package dto.payroll;


/**
 * Payroll deposit account request DTO object
 *
 * @author corbandalas created 17.09.2018.
 * @since 0.7.0
 */
public class PayrollDepositAccountRequest {

    private Long amount;
    private String currency;
    private String orderId;
    private String description;

    public PayrollDepositAccountRequest(Long amount, String currency, String orderId, String description) {
        this.amount = amount;
        this.currency = currency;
        this.orderId = orderId;
        this.description = description;
    }


    public PayrollDepositAccountRequest(Long amount, String currency) {
        this.amount = amount;
        this.currency = currency;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
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
}
