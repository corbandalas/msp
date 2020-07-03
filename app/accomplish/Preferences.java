
package accomplish;

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
    @SerializedName("time_zone")
    @Expose
    private String timeZone;
    @SerializedName("enable_device_authentication")
    @Expose
    private String enableDeviceAuthentication;

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

    public String getTimeZone() {
        return timeZone;
    }

    public void setTimeZone(String timeZone) {
        this.timeZone = timeZone;
    }

    public String getEnableDeviceAuthentication() {
        return enableDeviceAuthentication;
    }

    public void setEnableDeviceAuthentication(String enableDeviceAuthentication) {
        this.enableDeviceAuthentication = enableDeviceAuthentication;
    }

}
