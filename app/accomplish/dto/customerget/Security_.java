
package accomplish.dto.customerget;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Security_ {

    @SerializedName("expiry_date")
    @Expose
    private String expiryDate;

    public String getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
    }

}
