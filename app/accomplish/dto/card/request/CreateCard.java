
package accomplish.dto.card.request;

import javax.annotation.Generated;

import accomplish.dto.card.CustomField;
import accomplish.dto.card.GeoCoordinates;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("jsonschema2pojo")
public class CreateCard {

    @SerializedName("info")
    @Expose
    private Info info;
    @SerializedName("options")
    @Expose
    private Options options;

    @SerializedName("geo_coordinates")
    @Expose
    private GeoCoordinates geoCoordinates;
    @SerializedName("custom_field")
    @Expose
    private CustomField customField;

    public Info getInfo() {
        return info;
    }

    public void setInfo(Info info) {
        this.info = info;
    }

    public Options getOptions() {
        return options;
    }

    public void setOptions(Options options) {
        this.options = options;
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

}
