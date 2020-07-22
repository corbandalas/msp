
package accomplish.dto.user.update.phone.response;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UpdateUserPhoneResponse {

    @SerializedName("result")
    @Expose
    private Result result;
    @SerializedName("info")
    @Expose
    private Info info;
    @SerializedName("phone")
    @Expose
    private List<Phone> phone = null;

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

    public List<Phone> getPhone() {
        return phone;
    }

    public void setPhone(List<Phone> phone) {
        this.phone = phone;
    }

}
