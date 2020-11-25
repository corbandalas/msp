
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

    @SerializedName("security_code")
    @Expose
    private String security_code;

    @SerializedName("expiry_date")
    @Expose
    private String expiry_date;

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

    public String getSecurity_code() {
        return security_code;
    }

    public void setSecurity_code(String security_code) {
        this.security_code = security_code;
    }

    public String getExpiry_date() {
        return expiry_date;
    }

    public void setExpiry_date(String expiry_date) {
        this.expiry_date = expiry_date;
    }
}
