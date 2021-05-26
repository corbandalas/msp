
package accomplish.dto.validate.reset.response;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("jsonschema2pojo")
public class ResetPasswordResponse {

    @SerializedName("result")
    @Expose
    private Result result;
    @SerializedName("info")
    @Expose
    private Info info;
    @SerializedName("reset_security_data")
    @Expose
    private ResetSecurityData resetSecurityData;
    @SerializedName("validate")
    @Expose
    private String validate;

    public Result getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
    }

    public Info getInfo() {
        return info;
    }

    public void setInfo(Info info) {
        this.info = info;
    }

    public ResetSecurityData getResetSecurityData() {
        return resetSecurityData;
    }

    public void setResetSecurityData(ResetSecurityData resetSecurityData) {
        this.resetSecurityData = resetSecurityData;
    }

    public String getValidate() {
        return validate;
    }

    public void setValidate(String validate) {
        this.validate = validate;
    }

}
