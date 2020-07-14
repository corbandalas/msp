
package accomplish.dto.card;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CardProduction {

    @SerializedName("card_design_id")
    @Expose
    private String cardDesignId;
    @SerializedName("card_logo_id")
    @Expose
    private String cardLogoId;
    @SerializedName("include_user_id")
    @Expose
    private Boolean includeUserId;
    @SerializedName("include_activation_code")
    @Expose
    private Boolean includeActivationCode;
    @SerializedName("pin_mailer")
    @Expose
    private Boolean pinMailer;
    @SerializedName("bulk_shipping")
    @Expose
    private BulkShipping bulkShipping;

    public String getCardDesignId() {
        return cardDesignId;
    }

    public void setCardDesignId(String cardDesignId) {
        this.cardDesignId = cardDesignId;
    }

    public String getCardLogoId() {
        return cardLogoId;
    }

    public void setCardLogoId(String cardLogoId) {
        this.cardLogoId = cardLogoId;
    }

    public Boolean getIncludeUserId() {
        return includeUserId;
    }

    public void setIncludeUserId(Boolean includeUserId) {
        this.includeUserId = includeUserId;
    }

    public Boolean getIncludeActivationCode() {
        return includeActivationCode;
    }

    public void setIncludeActivationCode(Boolean includeActivationCode) {
        this.includeActivationCode = includeActivationCode;
    }

    public Boolean getPinMailer() {
        return pinMailer;
    }

    public void setPinMailer(Boolean pinMailer) {
        this.pinMailer = pinMailer;
    }

    public BulkShipping getBulkShipping() {
        return bulkShipping;
    }

    public void setBulkShipping(BulkShipping bulkShipping) {
        this.bulkShipping = bulkShipping;
    }

}
