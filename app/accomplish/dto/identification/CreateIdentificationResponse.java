
package accomplish.dto.identification;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class CreateIdentificationResponse {

    @SerializedName("result")
    @Expose
    private Result result;
    @SerializedName("info")
    @Expose
    private Info info;
    @SerializedName("personal_info")
    @Expose
    private Object personalInfo;
    @SerializedName("address")
    @Expose
    private Object address;
    @SerializedName("addresses")
    @Expose
    private Object addresses;
    @SerializedName("email")
    @Expose
    private Object email;
    @SerializedName("phone")
    @Expose
    private Object phone;
    @SerializedName("security")
    @Expose
    private Object security;
    @SerializedName("preferences")
    @Expose
    private Object preferences;
    @SerializedName("identification")
    @Expose
    private List<Identification> identification = null;
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
    private Object currency;
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
    private Object termsConditions;
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

    public Object getPersonalInfo() {
        return personalInfo;
    }

    public void setPersonalInfo(Object personalInfo) {
        this.personalInfo = personalInfo;
    }

    public Object getAddress() {
        return address;
    }

    public void setAddress(Object address) {
        this.address = address;
    }

    public Object getAddresses() {
        return addresses;
    }

    public void setAddresses(Object addresses) {
        this.addresses = addresses;
    }

    public Object getEmail() {
        return email;
    }

    public void setEmail(Object email) {
        this.email = email;
    }

    public Object getPhone() {
        return phone;
    }

    public void setPhone(Object phone) {
        this.phone = phone;
    }

    public Object getSecurity() {
        return security;
    }

    public void setSecurity(Object security) {
        this.security = security;
    }

    public Object getPreferences() {
        return preferences;
    }

    public void setPreferences(Object preferences) {
        this.preferences = preferences;
    }

    public List<Identification> getIdentification() {
        return identification;
    }

    public void setIdentification(List<Identification> identification) {
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

    public Object getCurrency() {
        return currency;
    }

    public void setCurrency(Object currency) {
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

    public Object getTermsConditions() {
        return termsConditions;
    }

    public void setTermsConditions(Object termsConditions) {
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
