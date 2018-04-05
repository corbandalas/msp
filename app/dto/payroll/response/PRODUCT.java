package dto.payroll.response;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "PRODUCT_REF",
        "RECORD"
})
public class PRODUCT {

    @JsonProperty("PRODUCT_REF")
    private String pRODUCTREF;
    @JsonProperty("RECORD")
    private List<RECORD> rECORD = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("PRODUCT_REF")
    public String getPRODUCTREF() {
        return pRODUCTREF;
    }

    @JsonProperty("PRODUCT_REF")
    public void setPRODUCTREF(String pRODUCTREF) {
        this.pRODUCTREF = pRODUCTREF;
    }

    @JsonProperty("RECORD")
    public List<RECORD> getRECORD() {
        return rECORD;
    }

    @JsonProperty("RECORD")
    public void setRECORD(List<RECORD> rECORD) {
        this.rECORD = rECORD;
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