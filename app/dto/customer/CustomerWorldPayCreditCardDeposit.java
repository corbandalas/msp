package dto.customer;

import java.io.Serializable;

/**
 * API customer WorldPay credit card deposit request
 * @author corbandalas created 24.05.2016.
 * @since 0.2.0
 */
public class CustomerWorldPayCreditCardDeposit implements Serializable{

    private Long cardTo;
    private Long amount;
    private String currency;
    private String orderId;
    private String successURL;
    private String cancelURL;
    private String failURL;

    public Long getCardTo() {
        return cardTo;
    }

    public void setCardTo(Long cardTo) {
        this.cardTo = cardTo;
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
}
