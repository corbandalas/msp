
package accomplish.dto.customerget;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Preferences {

    @SerializedName("preferred_language_code")
    @Expose
    private String preferredLanguageCode;
    @SerializedName("enable_facebook_account")
    @Expose
    private String enableFacebookAccount;
    @SerializedName("enable_promotion_notification")
    @Expose
    private String enablePromotionNotification;
    @SerializedName("enable_email_notification")
    @Expose
    private String enableEmailNotification;
    @SerializedName("enable_sms_notification")
    @Expose
    private String enableSmsNotification;
    @SerializedName("enable_push_notification")
    @Expose
    private String enablePushNotification;
    @SerializedName("enable_device_authentication")
    @Expose
    private String enableDeviceAuthentication;
    @SerializedName("time_zone")
    @Expose
    private String timeZone;
    @SerializedName("is_agent")
    @Expose
    private String isAgent;
    @SerializedName("is_reseller")
    @Expose
    private String isReseller;
    @SerializedName("is_seller")
    @Expose
    private String isSeller;

    public String getPreferredLanguageCode() {
        return preferredLanguageCode;
    }

    public void setPreferredLanguageCode(String preferredLanguageCode) {
        this.preferredLanguageCode = preferredLanguageCode;
    }

    public String getEnableFacebookAccount() {
        return enableFacebookAccount;
    }

    public void setEnableFacebookAccount(String enableFacebookAccount) {
        this.enableFacebookAccount = enableFacebookAccount;
    }

    public String getEnablePromotionNotification() {
        return enablePromotionNotification;
    }

    public void setEnablePromotionNotification(String enablePromotionNotification) {
        this.enablePromotionNotification = enablePromotionNotification;
    }

    public String getEnableEmailNotification() {
        return enableEmailNotification;
    }

    public void setEnableEmailNotification(String enableEmailNotification) {
        this.enableEmailNotification = enableEmailNotification;
    }

    public String getEnableSmsNotification() {
        return enableSmsNotification;
    }

    public void setEnableSmsNotification(String enableSmsNotification) {
        this.enableSmsNotification = enableSmsNotification;
    }

    public String getEnablePushNotification() {
        return enablePushNotification;
    }

    public void setEnablePushNotification(String enablePushNotification) {
        this.enablePushNotification = enablePushNotification;
    }

    public String getEnableDeviceAuthentication() {
        return enableDeviceAuthentication;
    }

    public void setEnableDeviceAuthentication(String enableDeviceAuthentication) {
        this.enableDeviceAuthentication = enableDeviceAuthentication;
    }

    public String getTimeZone() {
        return timeZone;
    }

    public void setTimeZone(String timeZone) {
        this.timeZone = timeZone;
    }

    public String getIsAgent() {
        return isAgent;
    }

    public void setIsAgent(String isAgent) {
        this.isAgent = isAgent;
    }

    public String getIsReseller() {
        return isReseller;
    }

    public void setIsReseller(String isReseller) {
        this.isReseller = isReseller;
    }

    public String getIsSeller() {
        return isSeller;
    }

    public void setIsSeller(String isSeller) {
        this.isSeller = isSeller;
    }

}
