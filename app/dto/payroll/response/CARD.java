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
        "TYPE",
        "CURRENCY",
        "TRACK3",
        "PASSCODE",
        "EMBOSS_NAME",
        "EMBOSS_START",
        "EMBOSS_EXPIRY"
})
public class CARD {

    @JsonProperty("TYPE")
    private String tYPE;
    @JsonProperty("CURRENCY")
    private String cURRENCY;
    @JsonProperty("TRACK3")
    private String tRACK3;
    @JsonProperty("PASSCODE")
    private String pASSCODE;
    @JsonProperty("EMBOSS_NAME")
    private String eMBOSSNAME;
    @JsonProperty("EMBOSS_START")
    private String eMBOSSSTART;
    @JsonProperty("EMBOSS_EXPIRY")
    private String eMBOSSEXPIRY;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("TYPE")
    public String getTYPE() {
        return tYPE;
    }

    @JsonProperty("TYPE")
    public void setTYPE(String tYPE) {
        this.tYPE = tYPE;
    }

    @JsonProperty("CURRENCY")
    public String getCURRENCY() {
        return cURRENCY;
    }

    @JsonProperty("CURRENCY")
    public void setCURRENCY(String cURRENCY) {
        this.cURRENCY = cURRENCY;
    }

    @JsonProperty("TRACK3")
    public String getTRACK3() {
        return tRACK3;
    }

    @JsonProperty("TRACK3")
    public void setTRACK3(String tRACK3) {
        this.tRACK3 = tRACK3;
    }

    @JsonProperty("PASSCODE")
    public String getPASSCODE() {
        return pASSCODE;
    }

    @JsonProperty("PASSCODE")
    public void setPASSCODE(String pASSCODE) {
        this.pASSCODE = pASSCODE;
    }

    @JsonProperty("EMBOSS_NAME")
    public String getEMBOSSNAME() {
        return eMBOSSNAME;
    }

    @JsonProperty("EMBOSS_NAME")
    public void setEMBOSSNAME(String eMBOSSNAME) {
        this.eMBOSSNAME = eMBOSSNAME;
    }

    @JsonProperty("EMBOSS_START")
    public String getEMBOSSSTART() {
        return eMBOSSSTART;
    }

    @JsonProperty("EMBOSS_START")
    public void setEMBOSSSTART(String eMBOSSSTART) {
        this.eMBOSSSTART = eMBOSSSTART;
    }

    @JsonProperty("EMBOSS_EXPIRY")
    public String getEMBOSSEXPIRY() {
        return eMBOSSEXPIRY;
    }

    @JsonProperty("EMBOSS_EXPIRY")
    public void setEMBOSSEXPIRY(String eMBOSSEXPIRY) {
        this.eMBOSSEXPIRY = eMBOSSEXPIRY;
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