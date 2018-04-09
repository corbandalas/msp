package dto.partner;

/**
 * Card balance transfer request DTO object
 *
 * @author corbandalas created 04.04.2018.
 * @since 0.6.0
 */

public class CardBalanceTransferRequest {

    private String token;

    private String newToken;

    private String feeWaiver;

    private double amount;
    private String currency;
    private String description;
    private String loadedBy;

    public CardBalanceTransferRequest() {
    }

    public CardBalanceTransferRequest(String token, String newToken, String feeWaiver, double amount, String currency, String description, String loadedBy) {
        this.token = token;
        this.newToken = newToken;
        this.feeWaiver = feeWaiver;
        this.amount = amount;
        this.currency = currency;
        this.description = description;
        this.loadedBy = loadedBy;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getNewToken() {
        return newToken;
    }

    public void setNewToken(String newToken) {
        this.newToken = newToken;
    }

    public String getFeeWaiver() {
        return feeWaiver;
    }

    public void setFeeWaiver(String feeWaiver) {
        this.feeWaiver = feeWaiver;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLoadedBy() {
        return loadedBy;
    }

    public void setLoadedBy(String loadedBy) {
        this.loadedBy = loadedBy;
    }
}


