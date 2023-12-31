
package ae.globalprocessing.hyperionweb;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for LimitInformation complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="LimitInformation">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="MaxAllowableBalance" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="DailyLoadLimit" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="DailyLoadFrequencyLimit" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="AmountLoaded" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="NoOfLoads" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="AmountLeftToLoad" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="NoOfLoadLeft" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="DailyPosLimit" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="DailyPosFrequencyLimit" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="POSUsage" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="NoOfPOSUsage" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="ValueOfPOSLeft" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="NoOfPOSTransactionsLeft" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="DailyCashLimit" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="DailyCashFrequencyLimit" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="CashWithdrawal" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="NoOfCashWithdrawal" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="ValueOfCashLeft" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="NoOfCashTransactionLeft" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="DailyUnLoadLimit" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="DailyUnLoadFrequencyLimit" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="AmountUnLoaded" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="NoOfUnLoads" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="AmountLeftToUnLoad" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="NoOfUnLoadLeft" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "LimitInformation", propOrder = {
    "maxAllowableBalance",
    "dailyLoadLimit",
    "dailyLoadFrequencyLimit",
    "amountLoaded",
    "noOfLoads",
    "amountLeftToLoad",
    "noOfLoadLeft",
    "dailyPosLimit",
    "dailyPosFrequencyLimit",
    "posUsage",
    "noOfPOSUsage",
    "valueOfPOSLeft",
    "noOfPOSTransactionsLeft",
    "dailyCashLimit",
    "dailyCashFrequencyLimit",
    "cashWithdrawal",
    "noOfCashWithdrawal",
    "valueOfCashLeft",
    "noOfCashTransactionLeft",
    "dailyUnLoadLimit",
    "dailyUnLoadFrequencyLimit",
    "amountUnLoaded",
    "noOfUnLoads",
    "amountLeftToUnLoad",
    "noOfUnLoadLeft"
})
public class LimitInformation {

    @XmlElement(name = "MaxAllowableBalance")
    protected double maxAllowableBalance;
    @XmlElement(name = "DailyLoadLimit")
    protected double dailyLoadLimit;
    @XmlElement(name = "DailyLoadFrequencyLimit")
    protected int dailyLoadFrequencyLimit;
    @XmlElement(name = "AmountLoaded")
    protected double amountLoaded;
    @XmlElement(name = "NoOfLoads")
    protected int noOfLoads;
    @XmlElement(name = "AmountLeftToLoad")
    protected double amountLeftToLoad;
    @XmlElement(name = "NoOfLoadLeft")
    protected int noOfLoadLeft;
    @XmlElement(name = "DailyPosLimit")
    protected double dailyPosLimit;
    @XmlElement(name = "DailyPosFrequencyLimit")
    protected int dailyPosFrequencyLimit;
    @XmlElement(name = "POSUsage")
    protected double posUsage;
    @XmlElement(name = "NoOfPOSUsage")
    protected int noOfPOSUsage;
    @XmlElement(name = "ValueOfPOSLeft")
    protected double valueOfPOSLeft;
    @XmlElement(name = "NoOfPOSTransactionsLeft")
    protected int noOfPOSTransactionsLeft;
    @XmlElement(name = "DailyCashLimit")
    protected double dailyCashLimit;
    @XmlElement(name = "DailyCashFrequencyLimit")
    protected int dailyCashFrequencyLimit;
    @XmlElement(name = "CashWithdrawal")
    protected double cashWithdrawal;
    @XmlElement(name = "NoOfCashWithdrawal")
    protected int noOfCashWithdrawal;
    @XmlElement(name = "ValueOfCashLeft")
    protected double valueOfCashLeft;
    @XmlElement(name = "NoOfCashTransactionLeft")
    protected int noOfCashTransactionLeft;
    @XmlElement(name = "DailyUnLoadLimit")
    protected double dailyUnLoadLimit;
    @XmlElement(name = "DailyUnLoadFrequencyLimit")
    protected int dailyUnLoadFrequencyLimit;
    @XmlElement(name = "AmountUnLoaded")
    protected double amountUnLoaded;
    @XmlElement(name = "NoOfUnLoads")
    protected int noOfUnLoads;
    @XmlElement(name = "AmountLeftToUnLoad")
    protected double amountLeftToUnLoad;
    @XmlElement(name = "NoOfUnLoadLeft")
    protected int noOfUnLoadLeft;

    /**
     * Gets the value of the maxAllowableBalance property.
     * 
     */
    public double getMaxAllowableBalance() {
        return maxAllowableBalance;
    }

    /**
     * Sets the value of the maxAllowableBalance property.
     * 
     */
    public void setMaxAllowableBalance(double value) {
        this.maxAllowableBalance = value;
    }

    /**
     * Gets the value of the dailyLoadLimit property.
     * 
     */
    public double getDailyLoadLimit() {
        return dailyLoadLimit;
    }

    /**
     * Sets the value of the dailyLoadLimit property.
     * 
     */
    public void setDailyLoadLimit(double value) {
        this.dailyLoadLimit = value;
    }

    /**
     * Gets the value of the dailyLoadFrequencyLimit property.
     * 
     */
    public int getDailyLoadFrequencyLimit() {
        return dailyLoadFrequencyLimit;
    }

    /**
     * Sets the value of the dailyLoadFrequencyLimit property.
     * 
     */
    public void setDailyLoadFrequencyLimit(int value) {
        this.dailyLoadFrequencyLimit = value;
    }

    /**
     * Gets the value of the amountLoaded property.
     * 
     */
    public double getAmountLoaded() {
        return amountLoaded;
    }

    /**
     * Sets the value of the amountLoaded property.
     * 
     */
    public void setAmountLoaded(double value) {
        this.amountLoaded = value;
    }

    /**
     * Gets the value of the noOfLoads property.
     * 
     */
    public int getNoOfLoads() {
        return noOfLoads;
    }

    /**
     * Sets the value of the noOfLoads property.
     * 
     */
    public void setNoOfLoads(int value) {
        this.noOfLoads = value;
    }

    /**
     * Gets the value of the amountLeftToLoad property.
     * 
     */
    public double getAmountLeftToLoad() {
        return amountLeftToLoad;
    }

    /**
     * Sets the value of the amountLeftToLoad property.
     * 
     */
    public void setAmountLeftToLoad(double value) {
        this.amountLeftToLoad = value;
    }

    /**
     * Gets the value of the noOfLoadLeft property.
     * 
     */
    public int getNoOfLoadLeft() {
        return noOfLoadLeft;
    }

    /**
     * Sets the value of the noOfLoadLeft property.
     * 
     */
    public void setNoOfLoadLeft(int value) {
        this.noOfLoadLeft = value;
    }

    /**
     * Gets the value of the dailyPosLimit property.
     * 
     */
    public double getDailyPosLimit() {
        return dailyPosLimit;
    }

    /**
     * Sets the value of the dailyPosLimit property.
     * 
     */
    public void setDailyPosLimit(double value) {
        this.dailyPosLimit = value;
    }

    /**
     * Gets the value of the dailyPosFrequencyLimit property.
     * 
     */
    public int getDailyPosFrequencyLimit() {
        return dailyPosFrequencyLimit;
    }

    /**
     * Sets the value of the dailyPosFrequencyLimit property.
     * 
     */
    public void setDailyPosFrequencyLimit(int value) {
        this.dailyPosFrequencyLimit = value;
    }

    /**
     * Gets the value of the posUsage property.
     * 
     */
    public double getPOSUsage() {
        return posUsage;
    }

    /**
     * Sets the value of the posUsage property.
     * 
     */
    public void setPOSUsage(double value) {
        this.posUsage = value;
    }

    /**
     * Gets the value of the noOfPOSUsage property.
     * 
     */
    public int getNoOfPOSUsage() {
        return noOfPOSUsage;
    }

    /**
     * Sets the value of the noOfPOSUsage property.
     * 
     */
    public void setNoOfPOSUsage(int value) {
        this.noOfPOSUsage = value;
    }

    /**
     * Gets the value of the valueOfPOSLeft property.
     * 
     */
    public double getValueOfPOSLeft() {
        return valueOfPOSLeft;
    }

    /**
     * Sets the value of the valueOfPOSLeft property.
     * 
     */
    public void setValueOfPOSLeft(double value) {
        this.valueOfPOSLeft = value;
    }

    /**
     * Gets the value of the noOfPOSTransactionsLeft property.
     * 
     */
    public int getNoOfPOSTransactionsLeft() {
        return noOfPOSTransactionsLeft;
    }

    /**
     * Sets the value of the noOfPOSTransactionsLeft property.
     * 
     */
    public void setNoOfPOSTransactionsLeft(int value) {
        this.noOfPOSTransactionsLeft = value;
    }

    /**
     * Gets the value of the dailyCashLimit property.
     * 
     */
    public double getDailyCashLimit() {
        return dailyCashLimit;
    }

    /**
     * Sets the value of the dailyCashLimit property.
     * 
     */
    public void setDailyCashLimit(double value) {
        this.dailyCashLimit = value;
    }

    /**
     * Gets the value of the dailyCashFrequencyLimit property.
     * 
     */
    public int getDailyCashFrequencyLimit() {
        return dailyCashFrequencyLimit;
    }

    /**
     * Sets the value of the dailyCashFrequencyLimit property.
     * 
     */
    public void setDailyCashFrequencyLimit(int value) {
        this.dailyCashFrequencyLimit = value;
    }

    /**
     * Gets the value of the cashWithdrawal property.
     * 
     */
    public double getCashWithdrawal() {
        return cashWithdrawal;
    }

    /**
     * Sets the value of the cashWithdrawal property.
     * 
     */
    public void setCashWithdrawal(double value) {
        this.cashWithdrawal = value;
    }

    /**
     * Gets the value of the noOfCashWithdrawal property.
     * 
     */
    public int getNoOfCashWithdrawal() {
        return noOfCashWithdrawal;
    }

    /**
     * Sets the value of the noOfCashWithdrawal property.
     * 
     */
    public void setNoOfCashWithdrawal(int value) {
        this.noOfCashWithdrawal = value;
    }

    /**
     * Gets the value of the valueOfCashLeft property.
     * 
     */
    public double getValueOfCashLeft() {
        return valueOfCashLeft;
    }

    /**
     * Sets the value of the valueOfCashLeft property.
     * 
     */
    public void setValueOfCashLeft(double value) {
        this.valueOfCashLeft = value;
    }

    /**
     * Gets the value of the noOfCashTransactionLeft property.
     * 
     */
    public int getNoOfCashTransactionLeft() {
        return noOfCashTransactionLeft;
    }

    /**
     * Sets the value of the noOfCashTransactionLeft property.
     * 
     */
    public void setNoOfCashTransactionLeft(int value) {
        this.noOfCashTransactionLeft = value;
    }

    /**
     * Gets the value of the dailyUnLoadLimit property.
     * 
     */
    public double getDailyUnLoadLimit() {
        return dailyUnLoadLimit;
    }

    /**
     * Sets the value of the dailyUnLoadLimit property.
     * 
     */
    public void setDailyUnLoadLimit(double value) {
        this.dailyUnLoadLimit = value;
    }

    /**
     * Gets the value of the dailyUnLoadFrequencyLimit property.
     * 
     */
    public int getDailyUnLoadFrequencyLimit() {
        return dailyUnLoadFrequencyLimit;
    }

    /**
     * Sets the value of the dailyUnLoadFrequencyLimit property.
     * 
     */
    public void setDailyUnLoadFrequencyLimit(int value) {
        this.dailyUnLoadFrequencyLimit = value;
    }

    /**
     * Gets the value of the amountUnLoaded property.
     * 
     */
    public double getAmountUnLoaded() {
        return amountUnLoaded;
    }

    /**
     * Sets the value of the amountUnLoaded property.
     * 
     */
    public void setAmountUnLoaded(double value) {
        this.amountUnLoaded = value;
    }

    /**
     * Gets the value of the noOfUnLoads property.
     * 
     */
    public int getNoOfUnLoads() {
        return noOfUnLoads;
    }

    /**
     * Sets the value of the noOfUnLoads property.
     * 
     */
    public void setNoOfUnLoads(int value) {
        this.noOfUnLoads = value;
    }

    /**
     * Gets the value of the amountLeftToUnLoad property.
     * 
     */
    public double getAmountLeftToUnLoad() {
        return amountLeftToUnLoad;
    }

    /**
     * Sets the value of the amountLeftToUnLoad property.
     * 
     */
    public void setAmountLeftToUnLoad(double value) {
        this.amountLeftToUnLoad = value;
    }

    /**
     * Gets the value of the noOfUnLoadLeft property.
     * 
     */
    public int getNoOfUnLoadLeft() {
        return noOfUnLoadLeft;
    }

    /**
     * Sets the value of the noOfUnLoadLeft property.
     * 
     */
    public void setNoOfUnLoadLeft(int value) {
        this.noOfUnLoadLeft = value;
    }

}
