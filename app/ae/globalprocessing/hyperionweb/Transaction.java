
package ae.globalprocessing.hyperionweb;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Transaction complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Transaction">
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
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Transaction", propOrder = {
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
    "mccPdg"
})
public class Transaction {

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

}
