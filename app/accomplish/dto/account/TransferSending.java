
package accomplish.dto.account;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TransferSending {

    @SerializedName("monthly")
    @Expose
    private Monthly__ monthly;
    @SerializedName("ewallet_send_internal")
    @Expose
    private EwalletSendInternal ewalletSendInternal;
    @SerializedName("ewallet_send_external")
    @Expose
    private EwalletSendExternal ewalletSendExternal;
    @SerializedName("points_send_internal")
    @Expose
    private PointsSendInternal pointsSendInternal;
    @SerializedName("points_send_external")
    @Expose
    private PointsSendExternal pointsSendExternal;
    @SerializedName("debit_card_send_internal")
    @Expose
    private DebitCardSendInternal debitCardSendInternal;
    @SerializedName("debit_card_send_external")
    @Expose
    private DebitCardSendExternal debitCardSendExternal;
    @SerializedName("program_payout")
    @Expose
    private ProgramPayout programPayout;
    @SerializedName("yearly")
    @Expose
    private Yearly__ yearly;
    @SerializedName("generic_transfer_send")
    @Expose
    private GenericTransferSend genericTransferSend;

    public Monthly__ getMonthly() {
        return monthly;
    }

    public void setMonthly(Monthly__ monthly) {
        this.monthly = monthly;
    }

    public EwalletSendInternal getEwalletSendInternal() {
        return ewalletSendInternal;
    }

    public void setEwalletSendInternal(EwalletSendInternal ewalletSendInternal) {
        this.ewalletSendInternal = ewalletSendInternal;
    }

    public EwalletSendExternal getEwalletSendExternal() {
        return ewalletSendExternal;
    }

    public void setEwalletSendExternal(EwalletSendExternal ewalletSendExternal) {
        this.ewalletSendExternal = ewalletSendExternal;
    }

    public PointsSendInternal getPointsSendInternal() {
        return pointsSendInternal;
    }

    public void setPointsSendInternal(PointsSendInternal pointsSendInternal) {
        this.pointsSendInternal = pointsSendInternal;
    }

    public PointsSendExternal getPointsSendExternal() {
        return pointsSendExternal;
    }

    public void setPointsSendExternal(PointsSendExternal pointsSendExternal) {
        this.pointsSendExternal = pointsSendExternal;
    }

    public DebitCardSendInternal getDebitCardSendInternal() {
        return debitCardSendInternal;
    }

    public void setDebitCardSendInternal(DebitCardSendInternal debitCardSendInternal) {
        this.debitCardSendInternal = debitCardSendInternal;
    }

    public DebitCardSendExternal getDebitCardSendExternal() {
        return debitCardSendExternal;
    }

    public void setDebitCardSendExternal(DebitCardSendExternal debitCardSendExternal) {
        this.debitCardSendExternal = debitCardSendExternal;
    }

    public ProgramPayout getProgramPayout() {
        return programPayout;
    }

    public void setProgramPayout(ProgramPayout programPayout) {
        this.programPayout = programPayout;
    }

    public Yearly__ getYearly() {
        return yearly;
    }

    public void setYearly(Yearly__ yearly) {
        this.yearly = yearly;
    }

    public GenericTransferSend getGenericTransferSend() {
        return genericTransferSend;
    }

    public void setGenericTransferSend(GenericTransferSend genericTransferSend) {
        this.genericTransferSend = genericTransferSend;
    }

}
