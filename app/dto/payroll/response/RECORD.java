package dto.payroll.response;

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
        "REQUEST_TYPE",
        "UID",
        "CARRIER",
        "CARD",
        "CUST_ACCNO"
})
public class RECORD {

    @JsonProperty("REQUEST_TYPE")
    private String rEQUESTTYPE;
    @JsonProperty("UID")
    private String uID;
    @JsonProperty("CARRIER")
    private CARRIER cARRIER;
    @JsonProperty("CARD")
    private CARD cARD;
    @JsonProperty("CUST_ACCNO")
    private String cUSTACCNO;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("REQUEST_TYPE")
    public String getREQUESTTYPE() {
        return rEQUESTTYPE;
    }

    @JsonProperty("REQUEST_TYPE")
    public void setREQUESTTYPE(String rEQUESTTYPE) {
        this.rEQUESTTYPE = rEQUESTTYPE;
    }

    @JsonProperty("UID")
    public String getUID() {
        return uID;
    }

    @JsonProperty("UID")
    public void setUID(String uID) {
        this.uID = uID;
    }

    @JsonProperty("CARRIER")
    public CARRIER getCARRIER() {
        return cARRIER;
    }

    @JsonProperty("CARRIER")
    public void setCARRIER(CARRIER cARRIER) {
        this.cARRIER = cARRIER;
    }

    @JsonProperty("CARD")
    public CARD getCARD() {
        return cARD;
    }

    @JsonProperty("CARD")
    public void setCARD(CARD cARD) {
        this.cARD = cARD;
    }

    @JsonProperty("CUST_ACCNO")
    public String getCUSTACCNO() {
        return cUSTACCNO;
    }

    @JsonProperty("CUST_ACCNO")
    public void setCUSTACCNO(String cUSTACCNO) {
        this.cUSTACCNO = cUSTACCNO;
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