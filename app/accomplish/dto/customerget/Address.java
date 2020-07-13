
package accomplish.dto.customerget;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Address {

    @SerializedName("type")
    @Expose
    private Integer type;
    @SerializedName("is_billing")
    @Expose
    private Integer isBilling;
    @SerializedName("address_line1")
    @Expose
    private String addressLine1;
    @SerializedName("address_line2")
    @Expose
    private String addressLine2;
    @SerializedName("postal_zip_code")
    @Expose
    private String postalZipCode;
    @SerializedName("country_code")
    @Expose
    private String countryCode;
    @SerializedName("state_region")
    @Expose
    private String stateRegion;
    @SerializedName("city_town")
    @Expose
    private String cityTown;
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

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getIsBilling() {
        return isBilling;
    }

    public void setIsBilling(Integer isBilling) {
        this.isBilling = isBilling;
    }

    public String getAddressLine1() {
        return addressLine1;
    }

    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }

    public String getAddressLine2() {
        return addressLine2;
    }

    public void setAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
    }

    public String getPostalZipCode() {
        return postalZipCode;
    }

    public void setPostalZipCode(String postalZipCode) {
        this.postalZipCode = postalZipCode;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getStateRegion() {
        return stateRegion;
    }

    public void setStateRegion(String stateRegion) {
        this.stateRegion = stateRegion;
    }

    public String getCityTown() {
        return cityTown;
    }

    public void setCityTown(String cityTown) {
        this.cityTown = cityTown;
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

}
