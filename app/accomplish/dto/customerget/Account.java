
package accomplish.dto.customerget;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Account {

    @SerializedName("info")
    @Expose
    private Info_ info;
    @SerializedName("bank_account")
    @Expose
    private List<BankAccount_> bankAccount = null;

    public Info_ getInfo() {
        return info;
    }

    public void setInfo(Info_ info) {
        this.info = info;
    }

    public List<BankAccount_> getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(List<BankAccount_> bankAccount) {
        this.bankAccount = bankAccount;
    }

}
