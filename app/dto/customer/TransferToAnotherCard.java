package dto.customer;

/**
 * DTO object for Transfer to another card
 * @author corbandalas created 19.02.2016.
 * @since 0.2.0
 */
public class TransferToAnotherCard {

    private Long cardFrom;
    private String phone;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
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
