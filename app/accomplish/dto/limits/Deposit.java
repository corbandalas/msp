
package accomplish.dto.limits;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("jsonschema2pojo")
public class Deposit {

    @SerializedName("monthly")
    @Expose
    private Monthly monthly;
    @SerializedName("yearly")
    @Expose
    private Yearly yearly;
    @SerializedName("manual")
    @Expose
    private Manual manual;
    @SerializedName("general")
    @Expose
    private General general;
    @SerializedName("bank_transfer")
    @Expose
    private BankTransfer bankTransfer;
    @SerializedName("check_load")
    @Expose
    private CheckLoad checkLoad;
    @SerializedName("ach")
    @Expose
    private Ach ach;
    @SerializedName("vouchers")
    @Expose
    private Vouchers vouchers;
    @SerializedName("fanapay_load")
    @Expose
    private FanapayLoad fanapayLoad;
    @SerializedName("cashu_load")
    @Expose
    private CashuLoad cashuLoad;
    @SerializedName("ukash_load")
    @Expose
    private UkashLoad ukashLoad;
    @SerializedName("onecard_load")
    @Expose
    private OnecardLoad onecardLoad;

    public Monthly getMonthly() {
        return monthly;
    }

    public void setMonthly(Monthly monthly) {
        this.monthly = monthly;
    }

    public Yearly getYearly() {
        return yearly;
    }

    public void setYearly(Yearly yearly) {
        this.yearly = yearly;
    }

    public Manual getManual() {
        return manual;
    }

    public void setManual(Manual manual) {
        this.manual = manual;
    }

    public General getGeneral() {
        return general;
    }

    public void setGeneral(General general) {
        this.general = general;
    }

    public BankTransfer getBankTransfer() {
        return bankTransfer;
    }

    public void setBankTransfer(BankTransfer bankTransfer) {
        this.bankTransfer = bankTransfer;
    }

    public CheckLoad getCheckLoad() {
        return checkLoad;
    }

    public void setCheckLoad(CheckLoad checkLoad) {
        this.checkLoad = checkLoad;
    }

    public Ach getAch() {
        return ach;
    }

    public void setAch(Ach ach) {
        this.ach = ach;
    }

    public Vouchers getVouchers() {
        return vouchers;
    }

    public void setVouchers(Vouchers vouchers) {
        this.vouchers = vouchers;
    }

    public FanapayLoad getFanapayLoad() {
        return fanapayLoad;
    }

    public void setFanapayLoad(FanapayLoad fanapayLoad) {
        this.fanapayLoad = fanapayLoad;
    }

    public CashuLoad getCashuLoad() {
        return cashuLoad;
    }

    public void setCashuLoad(CashuLoad cashuLoad) {
        this.cashuLoad = cashuLoad;
    }

    public UkashLoad getUkashLoad() {
        return ukashLoad;
    }

    public void setUkashLoad(UkashLoad ukashLoad) {
        this.ukashLoad = ukashLoad;
    }

    public OnecardLoad getOnecardLoad() {
        return onecardLoad;
    }

    public void setOnecardLoad(OnecardLoad onecardLoad) {
        this.onecardLoad = onecardLoad;
    }

}
