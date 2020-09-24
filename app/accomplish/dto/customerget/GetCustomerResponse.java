
package accomplish.dto.customerget;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GetCustomerResponse {

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
    private List<Address_> addresses = null;
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
//    @Expose
    private List<Identification> identification = null;
    @SerializedName("bank_account")
//    @Expose
    private List<BankAccount> bankAccount = null;
    @SerializedName("credit_card")
//    @Expose
    private List<CreditCard> creditCard = null;
    @SerializedName("currency")
//    @Expose
    private List<Currency> currency = null;
    @SerializedName("account")
//    @Expose
    private List<Account> account = null;
    @SerializedName("terms_conditions")
//    @Expose
    private TermsConditions termsConditions;
    @SerializedName("device_info")
//    @Expose
    private DeviceInfo deviceInfo;
    @SerializedName("commerce_info")
//    @Expose
    private CommerceInfo commerceInfo;
    @SerializedName("external_auth")
//    @Expose
    private List<ExternalAuth> externalAuth = null;
    @SerializedName("last_activity")
//    @Expose
    private LastActivity lastActivity;

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

    public List<Address_> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<Address_> addresses) {
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

    public List<Identification> getIdentification() {
        return identification;
    }

    public void setIdentification(List<Identification> identification) {
        this.identification = identification;
    }

    public List<BankAccount> getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(List<BankAccount> bankAccount) {
        this.bankAccount = bankAccount;
    }

    public List<CreditCard> getCreditCard() {
        return creditCard;
    }

    public void setCreditCard(List<CreditCard> creditCard) {
        this.creditCard = creditCard;
    }

    public List<Currency> getCurrency() {
        return currency;
    }

    public void setCurrency(List<Currency> currency) {
        this.currency = currency;
    }

    public List<Account> getAccount() {
        return account;
    }

    public void setAccount(List<Account> account) {
        this.account = account;
    }

    public TermsConditions getTermsConditions() {
        return termsConditions;
    }

    public void setTermsConditions(TermsConditions termsConditions) {
        this.termsConditions = termsConditions;
    }

    public DeviceInfo getDeviceInfo() {
        return deviceInfo;
    }

    public void setDeviceInfo(DeviceInfo deviceInfo) {
        this.deviceInfo = deviceInfo;
    }

    public CommerceInfo getCommerceInfo() {
        return commerceInfo;
    }

    public void setCommerceInfo(CommerceInfo commerceInfo) {
        this.commerceInfo = commerceInfo;
    }

    public List<ExternalAuth> getExternalAuth() {
        return externalAuth;
    }

    public void setExternalAuth(List<ExternalAuth> externalAuth) {
        this.externalAuth = externalAuth;
    }

    public LastActivity getLastActivity() {
        return lastActivity;
    }

    public void setLastActivity(LastActivity lastActivity) {
        this.lastActivity = lastActivity;
    }




}
