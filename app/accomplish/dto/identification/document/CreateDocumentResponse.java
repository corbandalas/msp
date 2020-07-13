
package accomplish.dto.identification.document;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CreateDocumentResponse {

    @SerializedName("result")
    @Expose
    private Result result;
    @SerializedName("info")
    @Expose
    private Info info;
    @SerializedName("attachment")
    @Expose
    private List<Attachment> attachment = null;
    @SerializedName("custom_field")
    @Expose
    private CustomField customField;
    @SerializedName("geo_coordinates")
    @Expose
    private GeoCoordinates geoCoordinates;
    @SerializedName("validate")
    @Expose
    private String validate;

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

    public List<Attachment> getAttachment() {
        return attachment;
    }

    public void setAttachment(List<Attachment> attachment) {
        this.attachment = attachment;
    }

    public CustomField getCustomField() {
        return customField;
    }

    public void setCustomField(CustomField customField) {
        this.customField = customField;
    }

    public GeoCoordinates getGeoCoordinates() {
        return geoCoordinates;
    }

    public void setGeoCoordinates(GeoCoordinates geoCoordinates) {
        this.geoCoordinates = geoCoordinates;
    }

    public String getValidate() {
        return validate;
    }

    public void setValidate(String validate) {
        this.validate = validate;
    }

}
