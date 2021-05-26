
package accomplish.dto.validate;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("jsonschema2pojo")
public class ValidatePassword {

    @SerializedName("validate_data")
    @Expose
    private ValidateData validateData;
    @SerializedName("info")
    @Expose
    private Info info;

    public ValidateData getValidateData() {
        return validateData;
    }

    public void setValidateData(ValidateData validateData) {
        this.validateData = validateData;
    }

    public Info getInfo() {
        return info;
    }

    public void setInfo(Info info) {
        this.info = info;
    }

}
