
package ae.globalprocessing.hyperionweb;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Transaction2 complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Transaction2">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="TxnDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PostDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="AmtBill" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="AmtTxn" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="BillConvRate" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="DebOrCred" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="TerminalId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Description" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="RRN" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CurTxn" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ItemId" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="AvlBal" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="BlkAmt" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="TransactionType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="StatusCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="StatusDesc" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="TxnTime" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="LocDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="FeeId" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="WSID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="FixedFee" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="RateFee" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="FxPdg" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="MCCPdg" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="LinkId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="MCC" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="OrigStan" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ProcCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="MCCDescription" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Dom_Fee_Fixed" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Dom_Fee_Rate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Non_Dom_Fee_Fixed" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Non_Dom_Fee_Rate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Fx_Fee_Fixed" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Fx_Fee_Rate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Other_Fee_Desc" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Other_Fee_Amt" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="TxnCodeType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Transaction2", propOrder = {
    "txnDate",
    "postDate",
    "amtBill",
    "amtTxn",
    "billConvRate",
    "debOrCred",
    "terminalId",
    "description",
    "rrn",
    "curTxn",
    "itemId",
    "avlBal",
    "blkAmt",
    "transactionType",
    "statusCode",
    "statusDesc",
    "txnTime",
    "locDate",
    "feeId",
    "wsid",
    "fixedFee",
    "rateFee",
    "fxPdg",
    "mccPdg",
    "linkId",
    "mcc",
    "origStan",
    "procCode",
    "mccDescription",
    "domFeeFixed",
    "domFeeRate",
    "nonDomFeeFixed",
    "nonDomFeeRate",
    "fxFeeFixed",
    "fxFeeRate",
    "otherFeeDesc",
    "otherFeeAmt",
    "txnCodeType"
})
public class Transaction2 {

    @XmlElement(name = "TxnDate")
    protected String txnDate;
    @XmlElement(name = "PostDate")
    protected String postDate;
    @XmlElement(name = "AmtBill")
    protected double amtBill;
    @XmlElement(name = "AmtTxn")
    protected double amtTxn;
    @XmlElement(name = "BillConvRate")
    protected double billConvRate;
    @XmlElement(name = "DebOrCred")
    protected int debOrCred;
    @XmlElement(name = "TerminalId")
    protected String terminalId;
    @XmlElement(name = "Description")
    protected String description;
    @XmlElement(name = "RRN")
    protected String rrn;
    @XmlElement(name = "CurTxn")
    protected String curTxn;
    @XmlElement(name = "ItemId")
    protected int itemId;
    @XmlElement(name = "AvlBal")
    protected double avlBal;
    @XmlElement(name = "BlkAmt")
    protected double blkAmt;
    @XmlElement(name = "TransactionType")
    protected String transactionType;
    @XmlElement(name = "StatusCode")
    protected String statusCode;
    @XmlElement(name = "StatusDesc")
    protected String statusDesc;
    @XmlElement(name = "TxnTime")
    protected String txnTime;
    @XmlElement(name = "LocDate")
    protected String locDate;
    @XmlElement(name = "FeeId")
    protected long feeId;
    @XmlElement(name = "WSID")
    protected long wsid;
    @XmlElement(name = "FixedFee")
    protected double fixedFee;
    @XmlElement(name = "RateFee")
    protected double rateFee;
    @XmlElement(name = "FxPdg")
    protected double fxPdg;
    @XmlElement(name = "MCCPdg")
    protected double mccPdg;
    @XmlElement(name = "LinkId")
    protected String linkId;
    @XmlElement(name = "MCC")
    protected String mcc;
    @XmlElement(name = "OrigStan")
    protected String origStan;
    @XmlElement(name = "ProcCode")
    protected String procCode;
    @XmlElement(name = "MCCDescription")
    protected String mccDescription;
    @XmlElement(name = "Dom_Fee_Fixed")
    protected String domFeeFixed;
    @XmlElement(name = "Dom_Fee_Rate")
    protected String domFeeRate;
    @XmlElement(name = "Non_Dom_Fee_Fixed")
    protected String nonDomFeeFixed;
    @XmlElement(name = "Non_Dom_Fee_Rate")
    protected String nonDomFeeRate;
    @XmlElement(name = "Fx_Fee_Fixed")
    protected String fxFeeFixed;
    @XmlElement(name = "Fx_Fee_Rate")
    protected String fxFeeRate;
    @XmlElement(name = "Other_Fee_Desc")
    protected String otherFeeDesc;
    @XmlElement(name = "Other_Fee_Amt")
    protected String otherFeeAmt;
    @XmlElement(name = "TxnCodeType")
    protected String txnCodeType;

    /**
     * Gets the value of the txnDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTxnDate() {
        return txnDate;
    }

    /**
     * Sets the value of the txnDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTxnDate(String value) {
        this.txnDate = value;
    }

    /**
     * Gets the value of the postDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPostDate() {
        return postDate;
    }

    /**
     * Sets the value of the postDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPostDate(String value) {
        this.postDate = value;
    }

    /**
     * Gets the value of the amtBill property.
     * 
     */
    public double getAmtBill() {
        return amtBill;
    }

    /**
     * Sets the value of the amtBill property.
     * 
     */
    public void setAmtBill(double value) {
        this.amtBill = value;
    }

    /**
     * Gets the value of the amtTxn property.
     * 
     */
    public double getAmtTxn() {
        return amtTxn;
    }

    /**
     * Sets the value of the amtTxn property.
     * 
     */
    public void setAmtTxn(double value) {
        this.amtTxn = value;
    }

    /**
     * Gets the value of the billConvRate property.
     * 
     */
    public double getBillConvRate() {
        return billConvRate;
    }

    /**
     * Sets the value of the billConvRate property.
     * 
     */
    public void setBillConvRate(double value) {
        this.billConvRate = value;
    }

    /**
     * Gets the value of the debOrCred property.
     * 
     */
    public int getDebOrCred() {
        return debOrCred;
    }

    /**
     * Sets the value of the debOrCred property.
     * 
     */
    public void setDebOrCred(int value) {
        this.debOrCred = value;
    }

    /**
     * Gets the value of the terminalId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTerminalId() {
        return terminalId;
    }

    /**
     * Sets the value of the terminalId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTerminalId(String value) {
        this.terminalId = value;
    }

    /**
     * Gets the value of the description property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the value of the description property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescription(String value) {
        this.description = value;
    }

    /**
     * Gets the value of the rrn property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRRN() {
        return rrn;
    }

    /**
     * Sets the value of the rrn property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRRN(String value) {
        this.rrn = value;
    }

    /**
     * Gets the value of the curTxn property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCurTxn() {
        return curTxn;
    }

    /**
     * Sets the value of the curTxn property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCurTxn(String value) {
        this.curTxn = value;
    }

    /**
     * Gets the value of the itemId property.
     * 
     */
    public int getItemId() {
        return itemId;
    }

    /**
     * Sets the value of the itemId property.
     * 
     */
    public void setItemId(int value) {
        this.itemId = value;
    }

    /**
     * Gets the value of the avlBal property.
     * 
     */
    public double getAvlBal() {
        return avlBal;
    }

    /**
     * Sets the value of the avlBal property.
     * 
     */
    public void setAvlBal(double value) {
        this.avlBal = value;
    }

    /**
     * Gets the value of the blkAmt property.
     * 
     */
    public double getBlkAmt() {
        return blkAmt;
    }

    /**
     * Sets the value of the blkAmt property.
     * 
     */
    public void setBlkAmt(double value) {
        this.blkAmt = value;
    }

    /**
     * Gets the value of the transactionType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTransactionType() {
        return transactionType;
    }

    /**
     * Sets the value of the transactionType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTransactionType(String value) {
        this.transactionType = value;
    }

    /**
     * Gets the value of the statusCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStatusCode() {
        return statusCode;
    }

    /**
     * Sets the value of the statusCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStatusCode(String value) {
        this.statusCode = value;
    }

    /**
     * Gets the value of the statusDesc property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStatusDesc() {
        return statusDesc;
    }

    /**
     * Sets the value of the statusDesc property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStatusDesc(String value) {
        this.statusDesc = value;
    }

    /**
     * Gets the value of the txnTime property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTxnTime() {
        return txnTime;
    }

    /**
     * Sets the value of the txnTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTxnTime(String value) {
        this.txnTime = value;
    }

    /**
     * Gets the value of the locDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLocDate() {
        return locDate;
    }

    /**
     * Sets the value of the locDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLocDate(String value) {
        this.locDate = value;
    }

    /**
     * Gets the value of the feeId property.
     * 
     */
    public long getFeeId() {
        return feeId;
    }

    /**
     * Sets the value of the feeId property.
     * 
     */
    public void setFeeId(long value) {
        this.feeId = value;
    }

    /**
     * Gets the value of the wsid property.
     * 
     */
    public long getWSID() {
        return wsid;
    }

    /**
     * Sets the value of the wsid property.
     * 
     */
    public void setWSID(long value) {
        this.wsid = value;
    }

    /**
     * Gets the value of the fixedFee property.
     * 
     */
    public double getFixedFee() {
        return fixedFee;
    }

    /**
     * Sets the value of the fixedFee property.
     * 
     */
    public void setFixedFee(double value) {
        this.fixedFee = value;
    }

    /**
     * Gets the value of the rateFee property.
     * 
     */
    public double getRateFee() {
        return rateFee;
    }

    /**
     * Sets the value of the rateFee property.
     * 
     */
    public void setRateFee(double value) {
        this.rateFee = value;
    }

    /**
     * Gets the value of the fxPdg property.
     * 
     */
    public double getFxPdg() {
        return fxPdg;
    }

    /**
     * Sets the value of the fxPdg property.
     * 
     */
    public void setFxPdg(double value) {
        this.fxPdg = value;
    }

    /**
     * Gets the value of the mccPdg property.
     * 
     */
    public double getMCCPdg() {
        return mccPdg;
    }

    /**
     * Sets the value of the mccPdg property.
     * 
     */
    public void setMCCPdg(double value) {
        this.mccPdg = value;
    }

    /**
     * Gets the value of the linkId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLinkId() {
        return linkId;
    }

    /**
     * Sets the value of the linkId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLinkId(String value) {
        this.linkId = value;
    }

    /**
     * Gets the value of the mcc property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMCC() {
        return mcc;
    }

    /**
     * Sets the value of the mcc property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMCC(String value) {
        this.mcc = value;
    }

    /**
     * Gets the value of the origStan property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOrigStan() {
        return origStan;
    }

    /**
     * Sets the value of the origStan property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOrigStan(String value) {
        this.origStan = value;
    }

    /**
     * Gets the value of the procCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProcCode() {
        return procCode;
    }

    /**
     * Sets the value of the procCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProcCode(String value) {
        this.procCode = value;
    }

    /**
     * Gets the value of the mccDescription property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMCCDescription() {
        return mccDescription;
    }

    /**
     * Sets the value of the mccDescription property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMCCDescription(String value) {
        this.mccDescription = value;
    }

    /**
     * Gets the value of the domFeeFixed property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDomFeeFixed() {
        return domFeeFixed;
    }

    /**
     * Sets the value of the domFeeFixed property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDomFeeFixed(String value) {
        this.domFeeFixed = value;
    }

    /**
     * Gets the value of the domFeeRate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDomFeeRate() {
        return domFeeRate;
    }

    /**
     * Sets the value of the domFeeRate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDomFeeRate(String value) {
        this.domFeeRate = value;
    }

    /**
     * Gets the value of the nonDomFeeFixed property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNonDomFeeFixed() {
        return nonDomFeeFixed;
    }

    /**
     * Sets the value of the nonDomFeeFixed property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNonDomFeeFixed(String value) {
        this.nonDomFeeFixed = value;
    }

    /**
     * Gets the value of the nonDomFeeRate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNonDomFeeRate() {
        return nonDomFeeRate;
    }

    /**
     * Sets the value of the nonDomFeeRate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNonDomFeeRate(String value) {
        this.nonDomFeeRate = value;
    }

    /**
     * Gets the value of the fxFeeFixed property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFxFeeFixed() {
        return fxFeeFixed;
    }

    /**
     * Sets the value of the fxFeeFixed property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFxFeeFixed(String value) {
        this.fxFeeFixed = value;
    }

    /**
     * Gets the value of the fxFeeRate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFxFeeRate() {
        return fxFeeRate;
    }

    /**
     * Sets the value of the fxFeeRate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFxFeeRate(String value) {
        this.fxFeeRate = value;
    }

    /**
     * Gets the value of the otherFeeDesc property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOtherFeeDesc() {
        return otherFeeDesc;
    }

    /**
     * Sets the value of the otherFeeDesc property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOtherFeeDesc(String value) {
        this.otherFeeDesc = value;
    }

    /**
     * Gets the value of the otherFeeAmt property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOtherFeeAmt() {
        return otherFeeAmt;
    }

    /**
     * Sets the value of the otherFeeAmt property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOtherFeeAmt(String value) {
        this.otherFeeAmt = value;
    }

    /**
     * Gets the value of the txnCodeType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTxnCodeType() {
        return txnCodeType;
    }

    /**
     * Sets the value of the txnCodeType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTxnCodeType(String value) {
        this.txnCodeType = value;
    }

    @Override
    public String toString() {
        return "Transaction2{" +
                "txnDate='" + txnDate + '\'' +
                ", postDate='" + postDate + '\'' +
                ", amtBill=" + amtBill +
                ", amtTxn=" + amtTxn +
                ", billConvRate=" + billConvRate +
                ", debOrCred=" + debOrCred +
                ", terminalId='" + terminalId + '\'' +
                ", description='" + description + '\'' +
                ", rrn='" + rrn + '\'' +
                ", curTxn='" + curTxn + '\'' +
                ", itemId=" + itemId +
                ", avlBal=" + avlBal +
                ", blkAmt=" + blkAmt +
                ", transactionType='" + transactionType + '\'' +
                ", statusCode='" + statusCode + '\'' +
                ", statusDesc='" + statusDesc + '\'' +
                ", txnTime='" + txnTime + '\'' +
                ", locDate='" + locDate + '\'' +
                ", feeId=" + feeId +
                ", wsid=" + wsid +
                ", fixedFee=" + fixedFee +
                ", rateFee=" + rateFee +
                ", fxPdg=" + fxPdg +
                ", mccPdg=" + mccPdg +
                ", linkId='" + linkId + '\'' +
                ", mcc='" + mcc + '\'' +
                ", origStan='" + origStan + '\'' +
                ", procCode='" + procCode + '\'' +
                ", mccDescription='" + mccDescription + '\'' +
                ", domFeeFixed='" + domFeeFixed + '\'' +
                ", domFeeRate='" + domFeeRate + '\'' +
                ", nonDomFeeFixed='" + nonDomFeeFixed + '\'' +
                ", nonDomFeeRate='" + nonDomFeeRate + '\'' +
                ", fxFeeFixed='" + fxFeeFixed + '\'' +
                ", fxFeeRate='" + fxFeeRate + '\'' +
                ", otherFeeDesc='" + otherFeeDesc + '\'' +
                ", otherFeeAmt='" + otherFeeAmt + '\'' +
                ", txnCodeType='" + txnCodeType + '\'' +
                '}';
    }
}
