
package accomplish.dto.account;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PointsReceiveExternal {

    @SerializedName("minimum_transaction_amount")
    @Expose
    private String minimumTransactionAmount;
    @SerializedName("maximum_transaction_amount")
    @Expose
    private String maximumTransactionAmount;
    @SerializedName("maximum_transactions_amount_per_day")
    @Expose
    private String maximumTransactionsAmountPerDay;
    @SerializedName("remaining_transactions_amount_per_day")
    @Expose
    private String remainingTransactionsAmountPerDay;
    @SerializedName("maximum_transactions_count_per_day")
    @Expose
    private Integer maximumTransactionsCountPerDay;
    @SerializedName("remaining_transactions_count_per_day")
    @Expose
    private Integer remainingTransactionsCountPerDay;

    public String getMinimumTransactionAmount() {
        return minimumTransactionAmount;
    }

    public void setMinimumTransactionAmount(String minimumTransactionAmount) {
        this.minimumTransactionAmount = minimumTransactionAmount;
    }

    public String getMaximumTransactionAmount() {
        return maximumTransactionAmount;
    }

    public void setMaximumTransactionAmount(String maximumTransactionAmount) {
        this.maximumTransactionAmount = maximumTransactionAmount;
    }

    public String getMaximumTransactionsAmountPerDay() {
        return maximumTransactionsAmountPerDay;
    }

    public void setMaximumTransactionsAmountPerDay(String maximumTransactionsAmountPerDay) {
        this.maximumTransactionsAmountPerDay = maximumTransactionsAmountPerDay;
    }

    public String getRemainingTransactionsAmountPerDay() {
        return remainingTransactionsAmountPerDay;
    }

    public void setRemainingTransactionsAmountPerDay(String remainingTransactionsAmountPerDay) {
        this.remainingTransactionsAmountPerDay = remainingTransactionsAmountPerDay;
    }

    public Integer getMaximumTransactionsCountPerDay() {
        return maximumTransactionsCountPerDay;
    }

    public void setMaximumTransactionsCountPerDay(Integer maximumTransactionsCountPerDay) {
        this.maximumTransactionsCountPerDay = maximumTransactionsCountPerDay;
    }

    public Integer getRemainingTransactionsCountPerDay() {
        return remainingTransactionsCountPerDay;
    }

    public void setRemainingTransactionsCountPerDay(Integer remainingTransactionsCountPerDay) {
        this.remainingTransactionsCountPerDay = remainingTransactionsCountPerDay;
    }

}
