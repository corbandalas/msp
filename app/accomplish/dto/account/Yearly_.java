
package accomplish.dto.account;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Yearly_ {

    @SerializedName("maximum_transactions_amount_per_year")
    @Expose
    private Double maximumTransactionsAmountPerYear;
    @SerializedName("maximum_transactions_count_per_year")
    @Expose
    private Integer maximumTransactionsCountPerYear;
    @SerializedName("remaining_transactions_amount_per_year")
    @Expose
    private Double remainingTransactionsAmountPerYear;
    @SerializedName("remaining_transactions_count_per_year")
    @Expose
    private Integer remainingTransactionsCountPerYear;

    public Double getMaximumTransactionsAmountPerYear() {
        return maximumTransactionsAmountPerYear;
    }

    public void setMaximumTransactionsAmountPerYear(Double maximumTransactionsAmountPerYear) {
        this.maximumTransactionsAmountPerYear = maximumTransactionsAmountPerYear;
    }

    public Integer getMaximumTransactionsCountPerYear() {
        return maximumTransactionsCountPerYear;
    }

    public void setMaximumTransactionsCountPerYear(Integer maximumTransactionsCountPerYear) {
        this.maximumTransactionsCountPerYear = maximumTransactionsCountPerYear;
    }

    public Double getRemainingTransactionsAmountPerYear() {
        return remainingTransactionsAmountPerYear;
    }

    public void setRemainingTransactionsAmountPerYear(Double remainingTransactionsAmountPerYear) {
        this.remainingTransactionsAmountPerYear = remainingTransactionsAmountPerYear;
    }

    public Integer getRemainingTransactionsCountPerYear() {
        return remainingTransactionsCountPerYear;
    }

    public void setRemainingTransactionsCountPerYear(Integer remainingTransactionsCountPerYear) {
        this.remainingTransactionsCountPerYear = remainingTransactionsCountPerYear;
    }

}
