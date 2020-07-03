
package accomplish;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class CreateUser {

    @SerializedName("personal_info")
    @Expose
    private PersonalInfo personalInfo;
    @SerializedName("address")
    @Expose
    private Address address;
    @SerializedName("email")
    @Expose
    private List<Email> email = null;
    @SerializedName("phone")
    @Expose
    private List<Phone> phone = null;
    @SerializedName("security")
    @Expose
    private Security security;
    @SerializedName("preferences")
    @Expose
    private Preferences preferences;
    @SerializedName("currency")
    @Expose
    private List<Currency> currency = null;
    @SerializedName("terms_conditions")
    @Expose
    private TermsConditions termsConditions;
    @SerializedName("geo_coordinates")
    @Expose
    private GeoCoordinates geoCoordinates;
    @SerializedName("custom_field")
    @Expose
    private CustomField customField;
    @SerializedName("notation")
    @Expose
    private Notation notation;
    @SerializedName("validate")
    @Expose
    private Integer validate;

    public PersonalInfo getPersonalInfo() {
        return personalInfo;
    }

    public void setPersonalInfo(PersonalInfo personalInfo) {
        this.personalInfo = personalInfo;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public List<Email> getEmail() {
        return email;
    }

    public void setEmail(List<Email> email) {
        this.email = email;
    }

    public List<Phone> getPhone() {
        return phone;
    }

    public void setPhone(List<Phone> phone) {
        this.phone = phone;
    }

    public Security getSecurity() {
        return security;
    }

    public void setSecurity(Security security) {
        this.security = security;
    }

    public Preferences getPreferences() {
        return preferences;
    }

    public void setPreferences(Preferences preferences) {
        this.preferences = preferences;
    }

    public List<Currency> getCurrency() {
        return currency;
    }

    public void setCurrency(List<Currency> currency) {
        this.currency = currency;
    }

    public TermsConditions getTermsConditions() {
        return termsConditions;
    }

    public void setTermsConditions(TermsConditions termsConditions) {
        this.termsConditions = termsConditions;
    }

    public GeoCoordinates getGeoCoordinates() {
        return geoCoordinates;
    }

    public void setGeoCoordinates(GeoCoordinates geoCoordinates) {
        this.geoCoordinates = geoCoordinates;
    }

    public CustomField getCustomField() {
        return customField;
    }

    public void setCustomField(CustomField customField) {
        this.customField = customField;
    }

    public Notation getNotation() {
        return notation;
    }

    public void setNotation(Notation notation) {
        this.notation = notation;
    }

    public Integer getValidate() {
        return validate;
    }

    public void setValidate(Integer validate) {
        this.validate = validate;
    }

}
