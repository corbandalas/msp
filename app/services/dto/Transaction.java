package services.dto;

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
        "id",
        "test",
        "merchantId",
        "created",
        "amount",
        "refundedAmount",
        "capturedAmount",
        "voidedAmount",
        "pendingAmount",
        "disputedAmount",
        "card",
        "tds",
        "currency",
        "custom",
        "recurring",
        "successful",
        "error",
        "descriptor",
        "trail"
})
public class Transaction {

    @JsonProperty("id")
    private String id;
    @JsonProperty("test")
    private Boolean test;
    @JsonProperty("merchantId")
    private String merchantId;
    @JsonProperty("created")
    private String created;
    @JsonProperty("amount")
    private Integer amount;
    @JsonProperty("refundedAmount")
    private Integer refundedAmount;
    @JsonProperty("capturedAmount")
    private Integer capturedAmount;
    @JsonProperty("voidedAmount")
    private Integer voidedAmount;
    @JsonProperty("pendingAmount")
    private Integer pendingAmount;
    @JsonProperty("disputedAmount")
    private Integer disputedAmount;
    @JsonProperty("card")
    private Card card;
    @JsonProperty("tds")
    private String tds;
    @JsonProperty("currency")
    private String currency;
    @JsonProperty("custom")
    private Custom custom;
    @JsonProperty("recurring")
    private Boolean recurring;
    @JsonProperty("successful")
    private Boolean successful;
    @JsonProperty("error")
    private Boolean error;
    @JsonProperty("descriptor")
    private String descriptor;
    @JsonProperty("trail")
    private List<Object> trail = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("id")
    public String getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }

    @JsonProperty("test")
    public Boolean getTest() {
        return test;
    }

    @JsonProperty("test")
    public void setTest(Boolean test) {
        this.test = test;
    }

    @JsonProperty("merchantId")
    public String getMerchantId() {
        return merchantId;
    }

    @JsonProperty("merchantId")
    public void setMerchantId(String merchantId) {
        this.merchantId = merchantId;
    }

    @JsonProperty("created")
    public String getCreated() {
        return created;
    }

    @JsonProperty("created")
    public void setCreated(String created) {
        this.created = created;
    }

    @JsonProperty("amount")
    public Integer getAmount() {
        return amount;
    }

    @JsonProperty("amount")
    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    @JsonProperty("refundedAmount")
    public Integer getRefundedAmount() {
        return refundedAmount;
    }

    @JsonProperty("refundedAmount")
    public void setRefundedAmount(Integer refundedAmount) {
        this.refundedAmount = refundedAmount;
    }

    @JsonProperty("capturedAmount")
    public Integer getCapturedAmount() {
        return capturedAmount;
    }

    @JsonProperty("capturedAmount")
    public void setCapturedAmount(Integer capturedAmount) {
        this.capturedAmount = capturedAmount;
    }

    @JsonProperty("voidedAmount")
    public Integer getVoidedAmount() {
        return voidedAmount;
    }

    @JsonProperty("voidedAmount")
    public void setVoidedAmount(Integer voidedAmount) {
        this.voidedAmount = voidedAmount;
    }

    @JsonProperty("pendingAmount")
    public Integer getPendingAmount() {
        return pendingAmount;
    }

    @JsonProperty("pendingAmount")
    public void setPendingAmount(Integer pendingAmount) {
        this.pendingAmount = pendingAmount;
    }

    @JsonProperty("disputedAmount")
    public Integer getDisputedAmount() {
        return disputedAmount;
    }

    @JsonProperty("disputedAmount")
    public void setDisputedAmount(Integer disputedAmount) {
        this.disputedAmount = disputedAmount;
    }

    @JsonProperty("card")
    public Card getCard() {
        return card;
    }

    @JsonProperty("card")
    public void setCard(Card card) {
        this.card = card;
    }

    @JsonProperty("tds")
    public String getTds() {
        return tds;
    }

    @JsonProperty("tds")
    public void setTds(String tds) {
        this.tds = tds;
    }

    @JsonProperty("currency")
    public String getCurrency() {
        return currency;
    }

    @JsonProperty("currency")
    public void setCurrency(String currency) {
        this.currency = currency;
    }

    @JsonProperty("custom")
    public Custom getCustom() {
        return custom;
    }

    @JsonProperty("custom")
    public void setCustom(Custom custom) {
        this.custom = custom;
    }

    @JsonProperty("recurring")
    public Boolean getRecurring() {
        return recurring;
    }

    @JsonProperty("recurring")
    public void setRecurring(Boolean recurring) {
        this.recurring = recurring;
    }

    @JsonProperty("successful")
    public Boolean getSuccessful() {
        return successful;
    }

    @JsonProperty("successful")
    public void setSuccessful(Boolean successful) {
        this.successful = successful;
    }

    @JsonProperty("error")
    public Boolean getError() {
        return error;
    }

    @JsonProperty("error")
    public void setError(Boolean error) {
        this.error = error;
    }

    @JsonProperty("descriptor")
    public String getDescriptor() {
        return descriptor;
    }

    @JsonProperty("descriptor")
    public void setDescriptor(String descriptor) {
        this.descriptor = descriptor;
    }

    @JsonProperty("trail")
    public List<Object> getTrail() {
        return trail;
    }

    @JsonProperty("trail")
    public void setTrail(List<Object> trail) {
        this.trail = trail;
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