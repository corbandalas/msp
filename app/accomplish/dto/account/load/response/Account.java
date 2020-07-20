
package accomplish.dto.account.load.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Account {

    @SerializedName("result")
    @Expose
    private Object result;
    @SerializedName("info")
    @Expose
    private Info_ info;
    @SerializedName("limits")
    @Expose
    private Object limits;
    @SerializedName("archive")
    @Expose
    private Object archive;
    @SerializedName("custom_field")
    @Expose
    private Object customField;
    @SerializedName("geo_coordinates")
    @Expose
    private Object geoCoordinates;
    @SerializedName("validate")
    @Expose
    private String validate;

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }

    public Info_ getInfo() {
        return info;
    }

    public void setInfo(Info_ info) {
        this.info = info;
    }

    public Object getLimits() {
        return limits;
    }

    public void setLimits(Object limits) {
        this.limits = limits;
    }

    public Object getArchive() {
        return archive;
    }

    public void setArchive(Object archive) {
        this.archive = archive;
    }

    public Object getCustomField() {
        return customField;
    }

    public void setCustomField(Object customField) {
        this.customField = customField;
    }

    public Object getGeoCoordinates() {
        return geoCoordinates;
    }

    public void setGeoCoordinates(Object geoCoordinates) {
        this.geoCoordinates = geoCoordinates;
    }

    public String getValidate() {
        return validate;
    }

    public void setValidate(String validate) {
        this.validate = validate;
    }

}
