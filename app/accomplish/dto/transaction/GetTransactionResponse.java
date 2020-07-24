
package accomplish.dto.transaction;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GetTransactionResponse {

    @SerializedName("result")
    @Expose
    private Result result;
    @SerializedName("result_set")
    @Expose
    private ResultSet resultSet;
    @SerializedName("transactions")
    @Expose
    private List<Transaction> transactions = null;
    @SerializedName("archive")
    @Expose
    private Object archive;
    @SerializedName("validate")
    @Expose
    private String validate;

    public Result getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
    }

    public ResultSet getResultSet() {
        return resultSet;
    }

    public void setResultSet(ResultSet resultSet) {
        this.resultSet = resultSet;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }

    public Object getArchive() {
        return archive;
    }

    public void setArchive(Object archive) {
        this.archive = archive;
    }

    public String getValidate() {
        return validate;
    }

    public void setValidate(String validate) {
        this.validate = validate;
    }

}
