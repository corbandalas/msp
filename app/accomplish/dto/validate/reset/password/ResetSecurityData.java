
package accomplish.dto.validate.reset.password;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("jsonschema2pojo")
public class ResetSecurityData {

    @SerializedName("reset_password")
    @Expose
    private ResetPassword__1 resetPassword;

    public ResetPassword__1 getResetPassword() {
        return resetPassword;
    }

    public void setResetPassword(ResetPassword__1 resetPassword) {
        this.resetPassword = resetPassword;
    }

}
