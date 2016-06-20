package dto.customer;

import java.io.Serializable;

/**
 * API customer WorldPay credit card purchase request
 * @author corbandalas created 17.06.2016.
 * @since 0.3.0
 */
public class CustomerWorldPayCreditCardPurchase implements Serializable{

    private Long amount;
    private String cardType;
    private String currency;
    private String orderId;
    private String successURL;
    private String cancelURL;
    private String failURL;
    private String phone;

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

    public String getSuccessURL() {
        return successURL;
    }

    public void setSuccessURL(String successURL) {
        this.successURL = successURL;
    }

    public String getCancelURL() {
        return cancelURL;
    }

    public void setCancelURL(String cancelURL) {
        this.cancelURL = cancelURL;
    }

    public String getFailURL() {
        return failURL;
    }

    public void setFailURL(String failURL) {
        this.failURL = failURL;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCardType() {
        return cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }
}
