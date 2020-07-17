
package accomplish.dto.account;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Security {
    @SerializedName("activation_code")
    @Expose
    private String activationCode;

    public String getActivationCode() {
        return activationCode;
    }

    public void setActivationCode(String activationCode) {
        this.activationCode = activationCode;
    }

}
