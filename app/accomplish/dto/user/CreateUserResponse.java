
package accomplish.dto.user;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class CreateUserResponse {

    @SerializedName("result")
    @Expose
    private Result result;
    @SerializedName("info")
    @Expose
    private Info info;
    @SerializedName("personal_info")
    @Expose
    private PersonalInfo personalInfo;
    @SerializedName("address")
    @Expose
    private Address address;
    @SerializedName("addresses")
    @Expose
    private Object addresses;
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
    @SerializedName("identification")
    @Expose
    private Object identification;
    @SerializedName("bank_account")
    @Expose
    private Object bankAccount;
    @SerializedName("credit_card")
    @Expose
    private Object creditCard;
    @SerializedName("notification")
    @Expose
    private Object notification;
    @SerializedName("documents")
    @Expose
    private Object documents;
    @SerializedName("currency")
    @Expose
    private List<Currency> currency = null;
    @SerializedName("account")
    @Expose
    private Object account;
    @SerializedName("group")
    @Expose
    private Object group;
    @SerializedName("access_rule")
    @Expose
    private Object accessRule;
    @SerializedName("terms_conditions")
    @Expose
    private TermsConditions termsConditions;
    @SerializedName("device_info")
    @Expose
    private Object deviceInfo;
    @SerializedName("commerce_info")
    @Expose
    private Object commerceInfo;
    @SerializedName("external_auth")
    @Expose
    private Object externalAuth;
    @SerializedName("validation_data")
    @Expose
    private Object validationData;
    @SerializedName("geo_coordinates")
    @Expose
    private Object geoCoordinates;
    @SerializedName("custom_field")
    @Expose
    private Object customField;
    @SerializedName("history")
    @Expose
    private Object history;
    @SerializedName("notes")
    @Expose
    private Object notes;
    @SerializedName("last_activity")
    @Expose
    private Object lastActivity;
    @SerializedName("authentication")
    @Expose
    private Object authentication;
    @SerializedName("validate")
    @Expose
    private Object validate;

    public Result getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
    }

    public Info getInfo() {
        return info;
    }

    public void setInfo(Info info) {
        this.info = info;
    }

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

    public Object getAddresses() {
        return addresses;
    }

    public void setAddresses(Object addresses) {
        this.addresses = addresses;
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

    public Object getIdentification() {
        return identification;
    }

    public void setIdentification(Object identification) {
        this.identification = identification;
    }

    public Object getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(Object bankAccount) {
        this.bankAccount = bankAccount;
    }

    public Object getCreditCard() {
        return creditCard;
    }

    public void setCreditCard(Object creditCard) {
        this.creditCard = creditCard;
    }

    public Object getNotification() {
        return notification;
    }

    public void setNotification(Object notification) {
        this.notification = notification;
    }

    public Object getDocuments() {
        return documents;
    }

    public void setDocuments(Object documents) {
        this.documents = documents;
    }

    public List<Currency> getCurrency() {
        return currency;
    }

    public void setCurrency(List<Currency> currency) {
        this.currency = currency;
    }

    public Object getAccount() {
        return account;
    }

    public void setAccount(Object account) {
        this.account = account;
    }

    public Object getGroup() {
        return group;
    }

    public void setGroup(Object group) {
        this.group = group;
    }

    public Object getAccessRule() {
        return accessRule;
    }

    public void setAccessRule(Object accessRule) {
        this.accessRule = accessRule;
    }

    public TermsConditions getTermsConditions() {
        return termsConditions;
    }

    public void setTermsConditions(TermsConditions termsConditions) {
        this.termsConditions = termsConditions;
    }

    public Object getDeviceInfo() {
        return deviceInfo;
    }

    public void setDeviceInfo(Object deviceInfo) {
        this.deviceInfo = deviceInfo;
    }

    public Object getCommerceInfo() {
        return commerceInfo;
    }

    public void setCommerceInfo(Object commerceInfo) {
        this.commerceInfo = commerceInfo;
    }

    public Object getExternalAuth() {
        return externalAuth;
    }

    public void setExternalAuth(Object externalAuth) {
        this.externalAuth = externalAuth;
    }

    public Object getValidationData() {
        return validationData;
    }

    public void setValidationData(Object validationData) {
        this.validationData = validationData;
    }

    public Object getGeoCoordinates() {
        return geoCoordinates;
    }

    public void setGeoCoordinates(Object geoCoordinates) {
        this.geoCoordinates = geoCoordinates;
    }

    public Object getCustomField() {
        return customField;
    }

    public void setCustomField(Object customField) {
        this.customField = customField;
    }

    public Object getHistory() {
        return history;
    }

    public void setHistory(Object history) {
        this.history = history;
    }

    public Object getNotes() {
        return notes;
    }

    public void setNotes(Object notes) {
        this.notes = notes;
    }

    public Object getLastActivity() {
        return lastActivity;
    }

    public void setLastActivity(Object lastActivity) {
        this.lastActivity = lastActivity;
    }

    public Object getAuthentication() {
        return authentication;
    }

    public void setAuthentication(Object authentication) {
        this.authentication = authentication;
    }

    public Object getValidate() {
        return validate;
    }

    public void setValidate(Object validate) {
        this.validate = validate;
    }

}
