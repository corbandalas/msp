
package accomplish.dto.transaction;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Conversion {

    @SerializedName("transaction_currency")
    @Expose
    private String transactionCurrency;
    @SerializedName("account_currency")
    @Expose
    private String accountCurrency;
    @SerializedName("original_amount")
    @Expose
    private String originalAmount;
    @SerializedName("converted_amount")
    @Expose
    private String convertedAmount;
    @SerializedName("rate")
    @Expose
    private String rate;

    public String getTransactionCurrency() {
        return transactionCurrency;
    }

    public void setTransactionCurrency(String transactionCurrency) {
        this.transactionCurrency = transactionCurrency;
    }

    public String getAccountCurrency() {
        return accountCurrency;
    }

    public void setAccountCurrency(String accountCurrency) {
        this.accountCurrency = accountCurrency;
    }

    public String getOriginalAmount() {
        return originalAmount;
    }

    public void setOriginalAmount(String originalAmount) {
        this.originalAmount = originalAmount;
    }

    public String getConvertedAmount() {
        return convertedAmount;
    }

    public void setConvertedAmount(String convertedAmount) {
        this.convertedAmount = convertedAmount;
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

}
