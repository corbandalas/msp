
package accomplish.dto.user.delete;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DeleteUserResponse {

    @SerializedName("result")
    @Expose
    private Result result;
    @SerializedName("info")
    @Expose
    private Info info;

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

}
