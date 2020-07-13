
package accomplish.dto.customerget;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BankAccount_ {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("linked_account_id")
    @Expose
    private Integer linkedAccountId;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("holder_name")
    @Expose
    private String holderName;
    @SerializedName("country_code")
    @Expose
    private String countryCode;
    @SerializedName("currency_code")
    @Expose
    private String currencyCode;
    @SerializedName("type")
    @Expose
    private Integer type;
    @SerializedName("number")
    @Expose
    private String number;
    @SerializedName("swift_code")
    @Expose
    private String swiftCode;
    @SerializedName("iban")
    @Expose
    private String iban;
    @SerializedName("transit_number")
    @Expose
    private String transitNumber;
    @SerializedName("institution_number")
    @Expose
    private String institutionNumber;
    @SerializedName("routing_number")
    @Expose
    private String routingNumber;
    @SerializedName("phone_id")
    @Expose
    private Integer phoneId;
    @SerializedName("address_id")
    @Expose
    private Integer addressId;
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getLinkedAccountId() {
        return linkedAccountId;
    }

    public void setLinkedAccountId(Integer linkedAccountId) {
        this.linkedAccountId = linkedAccountId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHolderName() {
        return holderName;
    }

    public void setHolderName(String holderName) {
        this.holderName = holderName;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getSwiftCode() {
        return swiftCode;
    }

    public void setSwiftCode(String swiftCode) {
        this.swiftCode = swiftCode;
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public String getTransitNumber() {
        return transitNumber;
    }

    public void setTransitNumber(String transitNumber) {
        this.transitNumber = transitNumber;
    }

    public String getInstitutionNumber() {
        return institutionNumber;
    }

    public void setInstitutionNumber(String institutionNumber) {
        this.institutionNumber = institutionNumber;
    }

    public String getRoutingNumber() {
        return routingNumber;
    }

    public void setRoutingNumber(String routingNumber) {
        this.routingNumber = routingNumber;
    }

    public Integer getPhoneId() {
        return phoneId;
    }

    public void setPhoneId(Integer phoneId) {
        this.phoneId = phoneId;
    }

    public Integer getAddressId() {
        return addressId;
    }

    public void setAddressId(Integer addressId) {
        this.addressId = addressId;
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
