package dto.partner;

/**
 * Card balance adjustment request DTO object
 *
 * @author corbandalas created 24.08.2018.
 * @since 0.6.0
 */
public class BalanceAdjustmentRequest {

    private String token;
    private double balance;
    private String currencyCode;
    private String debOrCredit;
    private String description;
    private boolean forcePost;

    public BalanceAdjustmentRequest(String token, double balance, String currencyCode, String debOrCredit, String description, boolean forcePost) {
        this.token = token;
        this.balance = balance;
        this.currencyCode = currencyCode;
        this.debOrCredit = debOrCredit;
        this.description = description;
        this.forcePost = forcePost;
    }

    public BalanceAdjustmentRequest() {
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public String getDebOrCredit() {
        return debOrCredit;
    }

    public void setDebOrCredit(String debOrCredit) {
        this.debOrCredit = debOrCredit;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isForcePost() {
        return forcePost;
    }

    public void setForcePost(boolean forcePost) {
        this.forcePost = forcePost;
    }
}
