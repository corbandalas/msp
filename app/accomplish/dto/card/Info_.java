
package accomplish.dto.card;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Info_ {

    @SerializedName("fulfilment_config_id")
    @Expose
    private Integer fulfilmentConfigId;
    @SerializedName("fulfilment_reason")
    @Expose
    private Integer fulfilmentReason;
    @SerializedName("fulfilment_type")
    @Expose
    private Integer fulfilmentType;
    @SerializedName("status")
    @Expose
    private Integer status;
    @SerializedName("status_date")
    @Expose
    private String statusDate;
    @SerializedName("batch_id")
    @Expose
    private Integer batchId;

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

    public Integer getFulfilmentType() {
        return fulfilmentType;
    }

    public void setFulfilmentType(Integer fulfilmentType) {
        this.fulfilmentType = fulfilmentType;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getStatusDate() {
        return statusDate;
    }

    public void setStatusDate(String statusDate) {
        this.statusDate = statusDate;
    }

    public Integer getBatchId() {
        return batchId;
    }

    public void setBatchId(Integer batchId) {
        this.batchId = batchId;
    }

}
