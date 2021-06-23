
package accomplish.dto.validate.reset.password;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("jsonschema2pojo")
public class ResetPassword {

    @SerializedName("reset_security_data")
    @Expose
    private ResetSecurityData resetSecurityData;
    @SerializedName("info")
    @Expose
    private Info info;

    public ResetSecurityData getResetSecurityData() {
        return resetSecurityData;
    }

    public void setResetSecurityData(ResetSecurityData resetSecurityData) {
        this.resetSecurityData = resetSecurityData;
    }

    public Info getInfo() {
        return info;
    }

    public void setInfo(Info info) {
        this.info = info;
    }

}
