
package accomplish.dto.card.request;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("jsonschema2pojo")
public class Fulfilment {

    @SerializedName("info")
    @Expose
    private Info__1 info;

    public Info__1 getInfo() {
        return info;
    }

    public void setInfo(Info__1 info) {
        this.info = info;
    }

}
