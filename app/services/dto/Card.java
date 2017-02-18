package services.dto;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "bin",
        "last4",
        "expiry",
        "scheme"
})
public class Card {

    @JsonProperty("bin")
    private String bin;
    @JsonProperty("last4")
    private String last4;
    @JsonProperty("expiry")
    private String expiry;
    @JsonProperty("scheme")
    private String scheme;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("bin")
    public String getBin() {
        return bin;
    }

    @JsonProperty("bin")
    public void setBin(String bin) {
        this.bin = bin;
    }

    @JsonProperty("last4")
    public String getLast4() {
        return last4;
    }

    @JsonProperty("last4")
    public void setLast4(String last4) {
        this.last4 = last4;
    }

    @JsonProperty("expiry")
    public String getExpiry() {
        return expiry;
    }

    @JsonProperty("expiry")
    public void setExpiry(String expiry) {
        this.expiry = expiry;
    }

    @JsonProperty("scheme")
    public String getScheme() {
        return scheme;
    }

    @JsonProperty("scheme")
    public void setScheme(String scheme) {
        this.scheme = scheme;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}