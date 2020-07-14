
package accomplish.dto.card;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BulkShipping {

    @SerializedName("enabled")
    @Expose
    private Boolean enabled;

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

}
