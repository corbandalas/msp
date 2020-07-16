
package accomplish.dto.account;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TransferRecieving {

    @SerializedName("ewallet_receive_internal")
    @Expose
    private EwalletReceiveInternal ewalletReceiveInternal;
    @SerializedName("ewallet_receive_external")
    @Expose
    private EwalletReceiveExternal ewalletReceiveExternal;
    @SerializedName("points_receive_internal")
    @Expose
    private PointsReceiveInternal pointsReceiveInternal;
    @SerializedName("points_receive_external")
    @Expose
    private PointsReceiveExternal pointsReceiveExternal;
    @SerializedName("monthly")
    @Expose
    private Monthly___ monthly;
    @SerializedName("yearly")
    @Expose
    private Yearly___ yearly;
    @SerializedName("debit_card_receive_internal")
    @Expose
    private DebitCardReceiveInternal debitCardReceiveInternal;
    @SerializedName("debit_card_receive_external")
    @Expose
    private DebitCardReceiveExternal debitCardReceiveExternal;
    @SerializedName("generic_transfer_receive")
    @Expose
    private GenericTransferReceive genericTransferReceive;

    public EwalletReceiveInternal getEwalletReceiveInternal() {
        return ewalletReceiveInternal;
    }

    public void setEwalletReceiveInternal(EwalletReceiveInternal ewalletReceiveInternal) {
        this.ewalletReceiveInternal = ewalletReceiveInternal;
    }

    public EwalletReceiveExternal getEwalletReceiveExternal() {
        return ewalletReceiveExternal;
    }

    public void setEwalletReceiveExternal(EwalletReceiveExternal ewalletReceiveExternal) {
        this.ewalletReceiveExternal = ewalletReceiveExternal;
    }

    public PointsReceiveInternal getPointsReceiveInternal() {
        return pointsReceiveInternal;
    }

    public void setPointsReceiveInternal(PointsReceiveInternal pointsReceiveInternal) {
        this.pointsReceiveInternal = pointsReceiveInternal;
    }

    public PointsReceiveExternal getPointsReceiveExternal() {
        return pointsReceiveExternal;
    }

    public void setPointsReceiveExternal(PointsReceiveExternal pointsReceiveExternal) {
        this.pointsReceiveExternal = pointsReceiveExternal;
    }

    public Monthly___ getMonthly() {
        return monthly;
    }

    public void setMonthly(Monthly___ monthly) {
        this.monthly = monthly;
    }

    public Yearly___ getYearly() {
        return yearly;
    }

    public void setYearly(Yearly___ yearly) {
        this.yearly = yearly;
    }

    public DebitCardReceiveInternal getDebitCardReceiveInternal() {
        return debitCardReceiveInternal;
    }

    public void setDebitCardReceiveInternal(DebitCardReceiveInternal debitCardReceiveInternal) {
        this.debitCardReceiveInternal = debitCardReceiveInternal;
    }

    public DebitCardReceiveExternal getDebitCardReceiveExternal() {
        return debitCardReceiveExternal;
    }

    public void setDebitCardReceiveExternal(DebitCardReceiveExternal debitCardReceiveExternal) {
        this.debitCardReceiveExternal = debitCardReceiveExternal;
    }

    public GenericTransferReceive getGenericTransferReceive() {
        return genericTransferReceive;
    }

    public void setGenericTransferReceive(GenericTransferReceive genericTransferReceive) {
        this.genericTransferReceive = genericTransferReceive;
    }

}
