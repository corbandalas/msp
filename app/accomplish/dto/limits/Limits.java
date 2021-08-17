
package accomplish.dto.limits;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("jsonschema2pojo")
public class Limits {

    @SerializedName("deposit")
    @Expose
    private Deposit deposit;
    @SerializedName("withdraw")
    @Expose
    private Withdraw withdraw;
    @SerializedName("transfer_sending")
    @Expose
    private TransferSending transferSending;
    @SerializedName("transfer_recieving")
    @Expose
    private TransferRecieving transferRecieving;

    public Deposit getDeposit() {
        return deposit;
    }

    public void setDeposit(Deposit deposit) {
        this.deposit = deposit;
    }

    public Withdraw getWithdraw() {
        return withdraw;
    }

    public void setWithdraw(Withdraw withdraw) {
        this.withdraw = withdraw;
    }

    public TransferSending getTransferSending() {
        return transferSending;
    }

    public void setTransferSending(TransferSending transferSending) {
        this.transferSending = transferSending;
    }

    public TransferRecieving getTransferRecieving() {
        return transferRecieving;
    }

    public void setTransferRecieving(TransferRecieving transferRecieving) {
        this.transferRecieving = transferRecieving;
    }

}
