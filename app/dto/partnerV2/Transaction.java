
package dto.partnerV2;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Transaction {

    @SerializedName("amount")
    @Expose
    private Double amount;
    @SerializedName("currency")
    @Expose
    private String currency;
    @SerializedName("desc")
    @Expose
    private String desc;
    @SerializedName("localDate")
    @Expose
    private Long localDate;

    public Long getLocalDate() {
        return localDate;
    }

    public Long getSettlementDate() {
        return settlementDate;
    }

    @SerializedName("settlementDate")
    @Expose
    private Long settlementDate;
    @SerializedName("originalAmount")
    @Expose
    private Double originalAmount;
    @SerializedName("originalCurrency")
    @Expose
    private String originalCurrency;
    @SerializedName("direction")
    @Expose
    private String direction;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("originalSourceId")
    @Expose
    private String originalSourceId;
    @SerializedName("balance")
    @Expose
    private Double balance;

    @SerializedName("status")
    @Expose
    private String status;

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Double getOriginalAmount() {
        return originalAmount;
    }

    public void setOriginalAmount(Double originalAmount) {
        this.originalAmount = originalAmount;
    }

    public String getOriginalCurrency() {
        return originalCurrency;
    }

    public void setOriginalCurrency(String originalCurrency) {
        this.originalCurrency = originalCurrency;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getOriginalSourceId() {
        return originalSourceId;
    }

    public void setOriginalSourceId(String originalSourceId) {
        this.originalSourceId = originalSourceId;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public void setLocalDate(Long localDate) {
        this.localDate = localDate;
    }

    public void setSettlementDate(Long settlementDate) {
        this.settlementDate = settlementDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
