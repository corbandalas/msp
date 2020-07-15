
package accomplish.dto.transfer.response;

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
    @SerializedName("options")
    @Expose
    private Object options;
    @SerializedName("history")
    @Expose
    private Object history;
    @SerializedName("notes")
    @Expose
    private Object notes;
    @SerializedName("last_activity")
    @Expose
    private Object lastActivity;
    @SerializedName("validate")
    @Expose
    private Object validate;

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

    public Object getOptions() {
        return options;
    }

    public void setOptions(Object options) {
        this.options = options;
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

    public Object getValidate() {
        return validate;
    }

    public void setValidate(Object validate) {
        this.validate = validate;
    }

}
