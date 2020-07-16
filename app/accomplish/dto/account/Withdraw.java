
package accomplish.dto.account;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Withdraw {

    @SerializedName("monthly")
    @Expose
    private Monthly_ monthly;
    @SerializedName("yearly")
    @Expose
    private Yearly_ yearly;
    @SerializedName("manual")
    @Expose
    private Manual_ manual;
    @SerializedName("general")
    @Expose
    private General_ general;
    @SerializedName("reseller_purchase")
    @Expose
    private ResellerPurchase resellerPurchase;
    @SerializedName("user_purchase")
    @Expose
    private UserPurchase userPurchase;
    @SerializedName("bank_transfer")
    @Expose
    private BankTransfer_ bankTransfer;
    @SerializedName("checks")
    @Expose
    private Checks checks;
    @SerializedName("ach")
    @Expose
    private Ach_ ach;
    @SerializedName("purchase")
    @Expose
    private Purchase purchase;
    @SerializedName("cashWithdrawal")
    @Expose
    private CashWithdrawal cashWithdrawal;

    public Monthly_ getMonthly() {
        return monthly;
    }

    public void setMonthly(Monthly_ monthly) {
        this.monthly = monthly;
    }

    public Yearly_ getYearly() {
        return yearly;
    }

    public void setYearly(Yearly_ yearly) {
        this.yearly = yearly;
    }

    public Manual_ getManual() {
        return manual;
    }

    public void setManual(Manual_ manual) {
        this.manual = manual;
    }

    public General_ getGeneral() {
        return general;
    }

    public void setGeneral(General_ general) {
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

    public BankTransfer_ getBankTransfer() {
        return bankTransfer;
    }

    public void setBankTransfer(BankTransfer_ bankTransfer) {
        this.bankTransfer = bankTransfer;
    }

    public Checks getChecks() {
        return checks;
    }

    public void setChecks(Checks checks) {
        this.checks = checks;
    }

    public Ach_ getAch() {
        return ach;
    }

    public void setAch(Ach_ ach) {
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
