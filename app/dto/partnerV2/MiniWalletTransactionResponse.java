package dto.partnerV2;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MiniWalletTransactionResponse {

@SerializedName("uuid")
@Expose
private String uuid;
@SerializedName("transactions")
@Expose
private List<Transaction2> transactions = null;

public String getUuid() {
return uuid;
}

public void setUuid(String uuid) {
this.uuid = uuid;
}

public List<Transaction2> getTransactions() {
return transactions;
}

public void setTransactions(List<Transaction2> transactions) {
this.transactions = transactions;
}

}