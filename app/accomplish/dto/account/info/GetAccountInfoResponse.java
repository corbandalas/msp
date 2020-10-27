
package accomplish.dto.account.info;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GetAccountInfoResponse {

    @SerializedName("result")
    @Expose
    private Result result;
    @SerializedName("info")
    @Expose
    private Info info;
    @SerializedName("last_activity")
    @Expose
    private LastActivity lastActivity;

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

    public LastActivity getLastActivity() {
        return lastActivity;
    }

    public void setLastActivity(LastActivity lastActivity) {
        this.lastActivity = lastActivity;
    }

}
