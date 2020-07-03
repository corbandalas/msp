
package accomplish.dto.identification.document;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class CreateDocument {

    @SerializedName("info")
    @Expose
    private Info info;
    @SerializedName("attachment")
    @Expose
    private List<Attachment> attachment = null;
    @SerializedName("geo_coordinates")
    @Expose
    private GeoCoordinates geoCoordinates;
    @SerializedName("custom_field")
    @Expose
    private CustomField customField;
    @SerializedName("validate")
    @Expose
    private String validate;

    public Info getInfo() {
        return info;
    }

    public void setInfo(Info info) {
        this.info = info;
    }

    public List<Attachment> getAttachment() {
        return attachment;
    }

    public void setAttachment(List<Attachment> attachment) {
        this.attachment = attachment;
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

    public String getValidate() {
        return validate;
    }

    public void setValidate(String validate) {
        this.validate = validate;
    }

}
