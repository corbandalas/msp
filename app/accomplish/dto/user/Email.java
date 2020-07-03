
package accomplish.dto.user;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Email {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("type")
    @Expose
    private Integer type;
    @SerializedName("address")
    @Expose
    private String address;
    @SerializedName("is_primary")
    @Expose
    private Integer isPrimary;
    @SerializedName("status")
    @Expose
    private Integer status;
    @SerializedName("verification_status")
    @Expose
    private Integer verificationStatus;
    @SerializedName("original_source_id")
    @Expose
    private Object originalSourceId;
    @SerializedName("server_date")
    @Expose
    private Object serverDate;
    @SerializedName("date_utc")
    @Expose
    private Object dateUtc;
    @SerializedName("update_date_utc")
    @Expose
    private Object updateDateUtc;
    @SerializedName("custom_field")
    @Expose
    private Object customField;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getIsPrimary() {
        return isPrimary;
    }

    public void setIsPrimary(Integer isPrimary) {
        this.isPrimary = isPrimary;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getVerificationStatus() {
        return verificationStatus;
    }

    public void setVerificationStatus(Integer verificationStatus) {
        this.verificationStatus = verificationStatus;
    }

    public Object getOriginalSourceId() {
        return originalSourceId;
    }

    public void setOriginalSourceId(Object originalSourceId) {
        this.originalSourceId = originalSourceId;
    }

    public Object getServerDate() {
        return serverDate;
    }

    public void setServerDate(Object serverDate) {
        this.serverDate = serverDate;
    }

    public Object getDateUtc() {
        return dateUtc;
    }

    public void setDateUtc(Object dateUtc) {
        this.dateUtc = dateUtc;
    }

    public Object getUpdateDateUtc() {
        return updateDateUtc;
    }

    public void setUpdateDateUtc(Object updateDateUtc) {
        this.updateDateUtc = updateDateUtc;
    }

    public Object getCustomField() {
        return customField;
    }

    public void setCustomField(Object customField) {
        this.customField = customField;
    }

}
