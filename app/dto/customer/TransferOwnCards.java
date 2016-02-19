package dto.customer;

/**
 * API customer transfer between own cards request
 * @author ra created 19.02.2016.
 * @since 0.1.0
 */
public class TransferOwnCards {
    private Long cardFrom;
    private Long cardTo;
    private String description;
    private Long amount;
    private String currency;
    private String orderId;

    public Long getCardFrom() {
        return cardFrom;
    }

    public void setCardFrom(Long cardFrom) {
        this.cardFrom = cardFrom;
    }

    public Long getCardTo() {
        return cardTo;
    }

    public void setCardTo(Long cardTo) {
        this.cardTo = cardTo;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }
}
