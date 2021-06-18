
package accomplish.dto.card.request;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("jsonschema2pojo")
public class Security {

    @SerializedName("predefined_pin_code")
    @Expose
    private String predefinedPinCode;

    public String getPredefinedPinCode() {
        return predefinedPinCode;
    }

    public void setPredefinedPinCode(String predefinedPinCode) {
        this.predefinedPinCode = predefinedPinCode;
    }

}
