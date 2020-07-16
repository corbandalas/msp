
package accomplish.dto.account;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Monthly__ {

    @SerializedName("maximum_transactions_amount_per_month")
    @Expose
    private String maximumTransactionsAmountPerMonth;
    @SerializedName("remaining_transactions_amount_per_month")
    @Expose
    private String remainingTransactionsAmountPerMonth;
    @SerializedName("maximum_transactions_count_per_month")
    @Expose
    private Integer maximumTransactionsCountPerMonth;
    @SerializedName("remaining_transactions_count_per_month")
    @Expose
    private Integer remainingTransactionsCountPerMonth;

    public String getMaximumTransactionsAmountPerMonth() {
        return maximumTransactionsAmountPerMonth;
    }

    public void setMaximumTransactionsAmountPerMonth(String maximumTransactionsAmountPerMonth) {
        this.maximumTransactionsAmountPerMonth = maximumTransactionsAmountPerMonth;
    }

    public String getRemainingTransactionsAmountPerMonth() {
        return remainingTransactionsAmountPerMonth;
    }

    public void setRemainingTransactionsAmountPerMonth(String remainingTransactionsAmountPerMonth) {
        this.remainingTransactionsAmountPerMonth = remainingTransactionsAmountPerMonth;
    }

    public Integer getMaximumTransactionsCountPerMonth() {
        return maximumTransactionsCountPerMonth;
    }

    public void setMaximumTransactionsCountPerMonth(Integer maximumTransactionsCountPerMonth) {
        this.maximumTransactionsCountPerMonth = maximumTransactionsCountPerMonth;
    }

    public Integer getRemainingTransactionsCountPerMonth() {
        return remainingTransactionsCountPerMonth;
    }

    public void setRemainingTransactionsCountPerMonth(Integer remainingTransactionsCountPerMonth) {
        this.remainingTransactionsCountPerMonth = remainingTransactionsCountPerMonth;
    }

}
