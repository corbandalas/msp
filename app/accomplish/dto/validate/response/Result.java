
package accomplish.dto.validate.response;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("jsonschema2pojo")
public class Result {

    @SerializedName("code")
    @Expose
    private String code;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("friendly_message")
    @Expose
    private String friendlyMessage;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getFriendlyMessage() {
        return friendlyMessage;
    }

    public void setFriendlyMessage(String friendlyMessage) {
        this.friendlyMessage = friendlyMessage;
    }

}
