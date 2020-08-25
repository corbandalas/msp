package dto.partnerV2;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Transaction2 {

    @SerializedName("token")
    @Expose
    private String token;
    @SerializedName("receiver")
    @Expose
    private String receiver;
    @SerializedName("date")
    @Expose
    private long date;
    @SerializedName("amount")
    @Expose
    private double amount;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("currency")
    @Expose
    private String currency;
    @SerializedName("type")
    @Expose
    private String type;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public long getDate() {
        return date;
    }

    public void setDate(long date) {
        this.date = date;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}