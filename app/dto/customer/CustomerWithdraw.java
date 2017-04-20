package dto.customer;

import java.io.Serializable;

/**
 * API customer withdraw request
 * @author corbandalas created 19.04.2017.
 * @since 0.5.0
 */
public class CustomerWithdraw implements Serializable{

    private Long cardFrom;
    private Long amount;
    private String currency;
    private String orderId;
    private String description;

    public Long getCardFrom() {
        return cardFrom;
    }

    public void setCardFrom(Long cardFrom) {
        this.cardFrom = cardFrom;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
