
package accomplish.dto.account;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GetAccountResponse {

    @SerializedName("result")
    @Expose
    private Result result;
    @SerializedName("info")
    @Expose
    private Info info;
    @JsonIgnore
    @SerializedName("limits")
    @Expose
    private transient Limits limits;
    @SerializedName("options")
    @Expose
    private transient Options options;

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

    public Limits getLimits() {
        return limits;
    }

    public void setLimits(Limits limits) {
        this.limits = limits;
    }

    public Options getOptions() {
        return options;
    }

    public void setOptions(Options options) {
        this.options = options;
    }

}
