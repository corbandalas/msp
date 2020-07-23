
package accomplish.dto.account;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Security {
    @SerializedName("activation_code")
    @Expose
    private String activationCode;

    @SerializedName("pin_code")
    @Expose
    private String pin_code;

    public String getPin_code() {
        return pin_code;
    }

    public void setPin_code(String pin_code) {
        this.pin_code = pin_code;
    }

    public String getActivationCode() {
        return activationCode;
    }

    public void setActivationCode(String activationCode) {
        this.activationCode = activationCode;
    }

}
