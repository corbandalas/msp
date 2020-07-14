
package accomplish.dto.card;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Options {

    @SerializedName("is_visible")
    @Expose
    private Integer isVisible;
    @SerializedName("fulfilment")
    @Expose
    private Fulfilment fulfilment;

    public Integer getIsVisible() {
        return isVisible;
    }

    public void setIsVisible(Integer isVisible) {
        this.isVisible = isVisible;
    }

    public Fulfilment getFulfilment() {
        return fulfilment;
    }

    public void setFulfilment(Fulfilment fulfilment) {
        this.fulfilment = fulfilment;
    }

}
