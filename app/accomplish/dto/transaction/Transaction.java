
package accomplish.dto.transaction;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Transaction {

    @SerializedName("result")
    @Expose
    private Object result;
    @SerializedName("info")
    @Expose
    private Info info;
    @SerializedName("account")
    @Expose
    private Account account;
    @SerializedName("fee")
    @Expose
    private Fee fee;
    @SerializedName("tax")
    @Expose
    private Object tax;
    @SerializedName("conversion")
    @Expose
    private Conversion conversion;
    @SerializedName("transfer")
    @Expose
    private Object transfer;
    @SerializedName("credit_card")
    @Expose
    private Object creditCard;
    @SerializedName("bank_account")
    @Expose
    private Object bankAccount;
    @SerializedName("custom_field")
    @Expose
    private Object customField;
    @SerializedName("geo_coordinates")
    @Expose
    private Object geoCoordinates;
    @SerializedName("validate")
    @Expose
    private String validate;

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }

    public Info getInfo() {
        return info;
    }

    public void setInfo(Info info) {
        this.info = info;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Fee getFee() {
        return fee;
    }

    public void setFee(Fee fee) {
        this.fee = fee;
    }

    public Object getTax() {
        return tax;
    }

    public void setTax(Object tax) {
        this.tax = tax;
    }

    public Conversion getConversion() {
        return conversion;
    }

    public void setConversion(Conversion conversion) {
        this.conversion = conversion;
    }

    public Object getTransfer() {
        return transfer;
    }

    public void setTransfer(Object transfer) {
        this.transfer = transfer;
    }

    public Object getCreditCard() {
        return creditCard;
    }

    public void setCreditCard(Object creditCard) {
        this.creditCard = creditCard;
    }

    public Object getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(Object bankAccount) {
        this.bankAccount = bankAccount;
    }

    public Object getCustomField() {
        return customField;
    }

    public void setCustomField(Object customField) {
        this.customField = customField;
    }

    public Object getGeoCoordinates() {
        return geoCoordinates;
    }

    public void setGeoCoordinates(Object geoCoordinates) {
        this.geoCoordinates = geoCoordinates;
    }

    public String getValidate() {
        return validate;
    }

    public void setValidate(String validate) {
        this.validate = validate;
    }

}
