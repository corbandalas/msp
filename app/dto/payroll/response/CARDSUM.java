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
        "DATA_FORMAT_VERSION",
        "FILEDATE",
        "FILETIME",
        "NO_OF_CARRIERS",
        "NO_OF_CARDS",
        "NO_OF_PRODUCTS",
        "TXREF"
})
public class CARDSUM {

    @JsonProperty("DATA_FORMAT_VERSION")
    private String dATAFORMATVERSION;
    @JsonProperty("FILEDATE")
    private String fILEDATE;
    @JsonProperty("FILETIME")
    private String fILETIME;
    @JsonProperty("NO_OF_CARRIERS")
    private String nOOFCARRIERS;
    @JsonProperty("NO_OF_CARDS")
    private String nOOFCARDS;
    @JsonProperty("NO_OF_PRODUCTS")
    private String nOOFPRODUCTS;
    @JsonProperty("TXREF")
    private String tXREF;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("DATA_FORMAT_VERSION")
    public String getDATAFORMATVERSION() {
        return dATAFORMATVERSION;
    }

    @JsonProperty("DATA_FORMAT_VERSION")
    public void setDATAFORMATVERSION(String dATAFORMATVERSION) {
        this.dATAFORMATVERSION = dATAFORMATVERSION;
    }

    @JsonProperty("FILEDATE")
    public String getFILEDATE() {
        return fILEDATE;
    }

    @JsonProperty("FILEDATE")
    public void setFILEDATE(String fILEDATE) {
        this.fILEDATE = fILEDATE;
    }

    @JsonProperty("FILETIME")
    public String getFILETIME() {
        return fILETIME;
    }

    @JsonProperty("FILETIME")
    public void setFILETIME(String fILETIME) {
        this.fILETIME = fILETIME;
    }

    @JsonProperty("NO_OF_CARRIERS")
    public String getNOOFCARRIERS() {
        return nOOFCARRIERS;
    }

    @JsonProperty("NO_OF_CARRIERS")
    public void setNOOFCARRIERS(String nOOFCARRIERS) {
        this.nOOFCARRIERS = nOOFCARRIERS;
    }

    @JsonProperty("NO_OF_CARDS")
    public String getNOOFCARDS() {
        return nOOFCARDS;
    }

    @JsonProperty("NO_OF_CARDS")
    public void setNOOFCARDS(String nOOFCARDS) {
        this.nOOFCARDS = nOOFCARDS;
    }

    @JsonProperty("NO_OF_PRODUCTS")
    public String getNOOFPRODUCTS() {
        return nOOFPRODUCTS;
    }

    @JsonProperty("NO_OF_PRODUCTS")
    public void setNOOFPRODUCTS(String nOOFPRODUCTS) {
        this.nOOFPRODUCTS = nOOFPRODUCTS;
    }

    @JsonProperty("TXREF")
    public String getTXREF() {
        return tXREF;
    }

    @JsonProperty("TXREF")
    public void setTXREF(String tXREF) {
        this.tXREF = tXREF;
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