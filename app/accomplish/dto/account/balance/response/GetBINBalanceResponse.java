
package accomplish.dto.account.balance.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GetBINBalanceResponse {

    @SerializedName("result")
    @Expose
    private Result result;
    @SerializedName("info")
    @Expose
    private Info info;
    @SerializedName("requirements")
    @Expose
    private Object requirements;
    @SerializedName("account_features")
    @Expose
    private Object accountFeatures;
    @SerializedName("deposit_methods")
    @Expose
    private Object depositMethods;
    @SerializedName("withdrawal_methods")
    @Expose
    private Object withdrawalMethods;
    @SerializedName("fee_setup")
    @Expose
    private Object feeSetup;
    @SerializedName("limits")
    @Expose
    private Object limits;
    @SerializedName("multi_currency")
    @Expose
    private Object multiCurrency;
    @SerializedName("localization")
    @Expose
    private Object localization;
    @SerializedName("configuration")
    @Expose
    private Object configuration;
    @SerializedName("history")
    @Expose
    private Object history;
    @SerializedName("notes")
    @Expose
    private Object notes;
    @SerializedName("last_activity")
    @Expose
    private Object lastActivity;
    @SerializedName("authentication")
    @Expose
    private Object authentication;
    @SerializedName("validate")
    @Expose
    private Object validate;

    public Result getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
    }

    public Info getInfo() {
        return info;
    }

    public void setInfo(Info info) {
        this.info = info;
    }

    public Object getRequirements() {
        return requirements;
    }

    public void setRequirements(Object requirements) {
        this.requirements = requirements;
    }

    public Object getAccountFeatures() {
        return accountFeatures;
    }

    public void setAccountFeatures(Object accountFeatures) {
        this.accountFeatures = accountFeatures;
    }

    public Object getDepositMethods() {
        return depositMethods;
    }

    public void setDepositMethods(Object depositMethods) {
        this.depositMethods = depositMethods;
    }

    public Object getWithdrawalMethods() {
        return withdrawalMethods;
    }

    public void setWithdrawalMethods(Object withdrawalMethods) {
        this.withdrawalMethods = withdrawalMethods;
    }

    public Object getFeeSetup() {
        return feeSetup;
    }

    public void setFeeSetup(Object feeSetup) {
        this.feeSetup = feeSetup;
    }

    public Object getLimits() {
        return limits;
    }

    public void setLimits(Object limits) {
        this.limits = limits;
    }

    public Object getMultiCurrency() {
        return multiCurrency;
    }

    public void setMultiCurrency(Object multiCurrency) {
        this.multiCurrency = multiCurrency;
    }

    public Object getLocalization() {
        return localization;
    }

    public void setLocalization(Object localization) {
        this.localization = localization;
    }

    public Object getConfiguration() {
        return configuration;
    }

    public void setConfiguration(Object configuration) {
        this.configuration = configuration;
    }

    public Object getHistory() {
        return history;
    }

    public void setHistory(Object history) {
        this.history = history;
    }

    public Object getNotes() {
        return notes;
    }

    public void setNotes(Object notes) {
        this.notes = notes;
    }

    public Object getLastActivity() {
        return lastActivity;
    }

    public void setLastActivity(Object lastActivity) {
        this.lastActivity = lastActivity;
    }

    public Object getAuthentication() {
        return authentication;
    }

    public void setAuthentication(Object authentication) {
        this.authentication = authentication;
    }

    public Object getValidate() {
        return validate;
    }

    public void setValidate(Object validate) {
        this.validate = validate;
    }

}
