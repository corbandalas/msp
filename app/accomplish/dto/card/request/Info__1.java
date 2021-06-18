
package accomplish.dto.card.request;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("jsonschema2pojo")
public class Info__1 {

    @SerializedName("fulfilment_config_id")
    @Expose
    private Integer fulfilmentConfigId;
    @SerializedName("fulfilment_reason")
    @Expose
    private Integer fulfilmentReason;
    @SerializedName("fulfilment_notes")
    @Expose
    private String fulfilmentNotes;
    @SerializedName("fulfillment_type")
    @Expose
    private Integer fulfillmentType;
    @SerializedName("security")
    @Expose
    private Security security;

    public Integer getFulfilmentConfigId() {
        return fulfilmentConfigId;
    }

    public void setFulfilmentConfigId(Integer fulfilmentConfigId) {
        this.fulfilmentConfigId = fulfilmentConfigId;
    }

    public Integer getFulfilmentReason() {
        return fulfilmentReason;
    }

    public void setFulfilmentReason(Integer fulfilmentReason) {
        this.fulfilmentReason = fulfilmentReason;
    }

    public String getFulfilmentNotes() {
        return fulfilmentNotes;
    }

    public void setFulfilmentNotes(String fulfilmentNotes) {
        this.fulfilmentNotes = fulfilmentNotes;
    }

    public Integer getFulfillmentType() {
        return fulfillmentType;
    }

    public void setFulfillmentType(Integer fulfillmentType) {
        this.fulfillmentType = fulfillmentType;
    }

    public Security getSecurity() {
        return security;
    }

    public void setSecurity(Security security) {
        this.security = security;
    }

}
