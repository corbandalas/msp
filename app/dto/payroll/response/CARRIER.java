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
        "TITLE",
        "FNAME",
        "SNAME",
        "ADD1",
        "ADD2",
        "ADD3",
        "CITY",
        "POSTCODE",
        "COUNTRY",
        "BULK_ADD1",
        "BULK_ADD2",
        "BULK_ADD3",
        "BULK_CITY",
        "BULK_POSTCODE",
        "BULK_COUNTRY",
        "CARRIER_TYPE",
        "DELV_METHOD",
        "LANG"
})
public class CARRIER {

    @JsonProperty("TITLE")
    private String tITLE;
    @JsonProperty("FNAME")
    private String fNAME;
    @JsonProperty("SNAME")
    private String sNAME;
    @JsonProperty("ADD1")
    private String aDD1;
    @JsonProperty("ADD2")
    private String aDD2;
    @JsonProperty("ADD3")
    private String aDD3;
    @JsonProperty("CITY")
    private String cITY;
    @JsonProperty("POSTCODE")
    private String pOSTCODE;
    @JsonProperty("COUNTRY")
    private String cOUNTRY;
    @JsonProperty("BULK_ADD1")
    private String bULKADD1;
    @JsonProperty("BULK_ADD2")
    private String bULKADD2;
    @JsonProperty("BULK_ADD3")
    private String bULKADD3;
    @JsonProperty("BULK_CITY")
    private String bULKCITY;
    @JsonProperty("BULK_POSTCODE")
    private String bULKPOSTCODE;
    @JsonProperty("BULK_COUNTRY")
    private String bULKCOUNTRY;
    @JsonProperty("CARRIER_TYPE")
    private String cARRIERTYPE;
    @JsonProperty("DELV_METHOD")
    private String dELVMETHOD;
    @JsonProperty("LANG")
    private String lANG;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("TITLE")
    public String getTITLE() {
        return tITLE;
    }

    @JsonProperty("TITLE")
    public void setTITLE(String tITLE) {
        this.tITLE = tITLE;
    }

    @JsonProperty("FNAME")
    public String getFNAME() {
        return fNAME;
    }

    @JsonProperty("FNAME")
    public void setFNAME(String fNAME) {
        this.fNAME = fNAME;
    }

    @JsonProperty("SNAME")
    public String getSNAME() {
        return sNAME;
    }

    @JsonProperty("SNAME")
    public void setSNAME(String sNAME) {
        this.sNAME = sNAME;
    }

    @JsonProperty("ADD1")
    public String getADD1() {
        return aDD1;
    }

    @JsonProperty("ADD1")
    public void setADD1(String aDD1) {
        this.aDD1 = aDD1;
    }

    @JsonProperty("ADD2")
    public String getADD2() {
        return aDD2;
    }

    @JsonProperty("ADD2")
    public void setADD2(String aDD2) {
        this.aDD2 = aDD2;
    }

    @JsonProperty("ADD3")
    public String getADD3() {
        return aDD3;
    }

    @JsonProperty("ADD3")
    public void setADD3(String aDD3) {
        this.aDD3 = aDD3;
    }

    @JsonProperty("CITY")
    public String getCITY() {
        return cITY;
    }

    @JsonProperty("CITY")
    public void setCITY(String cITY) {
        this.cITY = cITY;
    }

    @JsonProperty("POSTCODE")
    public String getPOSTCODE() {
        return pOSTCODE;
    }

    @JsonProperty("POSTCODE")
    public void setPOSTCODE(String pOSTCODE) {
        this.pOSTCODE = pOSTCODE;
    }

    @JsonProperty("COUNTRY")
    public String getCOUNTRY() {
        return cOUNTRY;
    }

    @JsonProperty("COUNTRY")
    public void setCOUNTRY(String cOUNTRY) {
        this.cOUNTRY = cOUNTRY;
    }

    @JsonProperty("BULK_ADD1")
    public String getBULKADD1() {
        return bULKADD1;
    }

    @JsonProperty("BULK_ADD1")
    public void setBULKADD1(String bULKADD1) {
        this.bULKADD1 = bULKADD1;
    }

    @JsonProperty("BULK_ADD2")
    public String getBULKADD2() {
        return bULKADD2;
    }

    @JsonProperty("BULK_ADD2")
    public void setBULKADD2(String bULKADD2) {
        this.bULKADD2 = bULKADD2;
    }

    @JsonProperty("BULK_ADD3")
    public String getBULKADD3() {
        return bULKADD3;
    }

    @JsonProperty("BULK_ADD3")
    public void setBULKADD3(String bULKADD3) {
        this.bULKADD3 = bULKADD3;
    }

    @JsonProperty("BULK_CITY")
    public String getBULKCITY() {
        return bULKCITY;
    }

    @JsonProperty("BULK_CITY")
    public void setBULKCITY(String bULKCITY) {
        this.bULKCITY = bULKCITY;
    }

    @JsonProperty("BULK_POSTCODE")
    public String getBULKPOSTCODE() {
        return bULKPOSTCODE;
    }

    @JsonProperty("BULK_POSTCODE")
    public void setBULKPOSTCODE(String bULKPOSTCODE) {
        this.bULKPOSTCODE = bULKPOSTCODE;
    }

    @JsonProperty("BULK_COUNTRY")
    public String getBULKCOUNTRY() {
        return bULKCOUNTRY;
    }

    @JsonProperty("BULK_COUNTRY")
    public void setBULKCOUNTRY(String bULKCOUNTRY) {
        this.bULKCOUNTRY = bULKCOUNTRY;
    }

    @JsonProperty("CARRIER_TYPE")
    public String getCARRIERTYPE() {
        return cARRIERTYPE;
    }

    @JsonProperty("CARRIER_TYPE")
    public void setCARRIERTYPE(String cARRIERTYPE) {
        this.cARRIERTYPE = cARRIERTYPE;
    }

    @JsonProperty("DELV_METHOD")
    public String getDELVMETHOD() {
        return dELVMETHOD;
    }

    @JsonProperty("DELV_METHOD")
    public void setDELVMETHOD(String dELVMETHOD) {
        this.dELVMETHOD = dELVMETHOD;
    }

    @JsonProperty("LANG")
    public String getLANG() {
        return lANG;
    }

    @JsonProperty("LANG")
    public void setLANG(String lANG) {
        this.lANG = lANG;
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