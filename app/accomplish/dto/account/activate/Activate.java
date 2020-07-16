
package accomplish.dto.account.activate;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Activate {

    @SerializedName("info")
    @Expose
    private Info info;
    @SerializedName("validate")
    @Expose
    private String validate;

    public Info getInfo() {
        return info;
    }

    public void setInfo(Info info) {
        this.info = info;
    }

    public String getValidate() {
        return validate;
    }

    public void setValidate(String validate) {
        this.validate = validate;
    }

}
