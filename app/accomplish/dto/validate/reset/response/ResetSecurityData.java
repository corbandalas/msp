
package accomplish.dto.validate.reset.response;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("jsonschema2pojo")
public class ResetSecurityData {

    @SerializedName("forget_password")
    @Expose
    private ForgetPassword forgetPassword;

    public ForgetPassword getForgetPassword() {
        return forgetPassword;
    }

    public void setForgetPassword(ForgetPassword forgetPassword) {
        this.forgetPassword = forgetPassword;
    }

}
