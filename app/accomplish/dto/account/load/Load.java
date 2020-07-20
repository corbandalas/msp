
package accomplish.dto.account.load;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Load {

    @SerializedName("info")
    @Expose
    private Info info;
    @SerializedName("account")
    @Expose
    private Account account;
    @SerializedName("validate")
    @Expose
    private String validate;

    public Info getInfo() {
        return info;
    }

    public void setInfo(Info info) {
        this.info = info;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public String getValidate() {
        return validate;
    }

    public void setValidate(String validate) {
        this.validate = validate;
    }

}
