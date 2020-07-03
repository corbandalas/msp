
package accomplish.dto.identification;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Identification {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("type")
    @Expose
    private Integer type;
    @SerializedName("country_of_issue")
    @Expose
    private String countryOfIssue;
    @SerializedName("country_of_residence")
    @Expose
    private String countryOfResidence;
    @SerializedName("number")
    @Expose
    private String number;
    @SerializedName("issue_date")
    @Expose
    private String issueDate;
    @SerializedName("expiry_date")
    @Expose
    private String expiryDate;
    @SerializedName("status")
    @Expose
    private Integer status;
    @SerializedName("verification_status")
    @Expose
    private Integer verificationStatus;
    @SerializedName("original_source_id")
    @Expose
    private String originalSourceId;
    @SerializedName("server_date")
    @Expose
    private String serverDate;
    @SerializedName("date_utc")
    @Expose
    private String dateUtc;
    @SerializedName("update_date_utc")
    @Expose
    private String updateDateUtc;
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

    public String getCountryOfIssue() {
        return countryOfIssue;
    }

    public void setCountryOfIssue(String countryOfIssue) {
        this.countryOfIssue = countryOfIssue;
    }

    public String getCountryOfResidence() {
        return countryOfResidence;
    }

    public void setCountryOfResidence(String countryOfResidence) {
        this.countryOfResidence = countryOfResidence;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(String issueDate) {
        this.issueDate = issueDate;
    }

    public String getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
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

    public String getOriginalSourceId() {
        return originalSourceId;
    }

    public void setOriginalSourceId(String originalSourceId) {
        this.originalSourceId = originalSourceId;
    }

    public String getServerDate() {
        return serverDate;
    }

    public void setServerDate(String serverDate) {
        this.serverDate = serverDate;
    }

    public String getDateUtc() {
        return dateUtc;
    }

    public void setDateUtc(String dateUtc) {
        this.dateUtc = dateUtc;
    }

    public String getUpdateDateUtc() {
        return updateDateUtc;
    }

    public void setUpdateDateUtc(String updateDateUtc) {
        this.updateDateUtc = updateDateUtc;
    }

    public Object getCustomField() {
        return customField;
    }

    public void setCustomField(Object customField) {
        this.customField = customField;
    }

}
