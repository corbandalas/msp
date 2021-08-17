
package accomplish.dto.limits;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("jsonschema2pojo")
public class Withdraw {

    @SerializedName("monthly")
    @Expose
    private Monthly__1 monthly;
    @SerializedName("yearly")
    @Expose
    private Yearly__1 yearly;
    @SerializedName("manual")
    @Expose
    private Manual__1 manual;
    @SerializedName("general")
    @Expose
    private General__1 general;
    @SerializedName("reseller_purchase")
    @Expose
    private ResellerPurchase resellerPurchase;
    @SerializedName("user_purchase")
    @Expose
    private UserPurchase userPurchase;
    @SerializedName("bank_transfer")
    @Expose
    private BankTransfer__1 bankTransfer;
    @SerializedName("checks")
    @Expose
    private Checks checks;
    @SerializedName("ach")
    @Expose
    private Ach__1 ach;
    @SerializedName("purchase")
    @Expose
    private Purchase purchase;
    @SerializedName("cashWithdrawal")
    @Expose
    private CashWithdrawal cashWithdrawal;

    public Monthly__1 getMonthly() {
        return monthly;
    }

    public void setMonthly(Monthly__1 monthly) {
        this.monthly = monthly;
    }

    public Yearly__1 getYearly() {
        return yearly;
    }

    public void setYearly(Yearly__1 yearly) {
        this.yearly = yearly;
    }

    public Manual__1 getManual() {
        return manual;
    }

    public void setManual(Manual__1 manual) {
        this.manual = manual;
    }

    public General__1 getGeneral() {
        return general;
    }

    public void setGeneral(General__1 general) {
        this.general = general;
    }

    public ResellerPurchase getResellerPurchase() {
        return resellerPurchase;
    }

    public void setResellerPurchase(ResellerPurchase resellerPurchase) {
        this.resellerPurchase = resellerPurchase;
    }

    public UserPurchase getUserPurchase() {
        return userPurchase;
    }

    public void setUserPurchase(UserPurchase userPurchase) {
        this.userPurchase = userPurchase;
    }

    public BankTransfer__1 getBankTransfer() {
        return bankTransfer;
    }

    public void setBankTransfer(BankTransfer__1 bankTransfer) {
        this.bankTransfer = bankTransfer;
    }

    public Checks getChecks() {
        return checks;
    }

    public void setChecks(Checks checks) {
        this.checks = checks;
    }

    public Ach__1 getAch() {
        return ach;
    }

    public void setAch(Ach__1 ach) {
        this.ach = ach;
    }

    public Purchase getPurchase() {
        return purchase;
    }

    public void setPurchase(Purchase purchase) {
        this.purchase = purchase;
    }

    public CashWithdrawal getCashWithdrawal() {
        return cashWithdrawal;
    }

    public void setCashWithdrawal(CashWithdrawal cashWithdrawal) {
        this.cashWithdrawal = cashWithdrawal;
    }

}
