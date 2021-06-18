
package accomplish.dto.card.request;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("jsonschema2pojo")
public class Options {

    @SerializedName("fulfilment")
    @Expose
    private Fulfilment fulfilment;

    public Fulfilment getFulfilment() {
        return fulfilment;
    }

    public void setFulfilment(Fulfilment fulfilment) {
        this.fulfilment = fulfilment;
    }

}
