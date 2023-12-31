
package ae.globalprocessing.hyperionweb;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Card2 complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Card2">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="WSID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="IssCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="TxnCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PublicToken" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="LocDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="LocTime" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="StartDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="EndDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ExpDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="StatCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="EmbossName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="AvlBal" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="BlkAmt" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="CurCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ClientCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SysDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ActionCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="IsLive" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="Scheme" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Product" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="MaskedPAN" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="LimitGroup" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="MCCGroup" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PERMSGroup" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="FeeGroup" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SchedFeeGroup" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="WSFeeGroup" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="LinkageGroup" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PrimaryToken" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="AuthCalendarGroup" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="FXGroup" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Card2", propOrder = {
    "wsid",
    "issCode",
    "txnCode",
    "publicToken",
    "locDate",
    "locTime",
    "startDate",
    "endDate",
    "expDate",
    "statCode",
    "embossName",
    "avlBal",
    "blkAmt",
    "curCode",
    "clientCode",
    "sysDate",
    "actionCode",
    "isLive",
    "scheme",
    "product",
    "maskedPAN",
    "limitGroup",
    "mccGroup",
    "permsGroup",
    "feeGroup",
    "schedFeeGroup",
    "wsFeeGroup",
    "linkageGroup",
    "primaryToken",
    "authCalendarGroup",
    "fxGroup"
})
public class Card2 {

    @XmlElement(name = "WSID")
    protected long wsid;
    @XmlElement(name = "IssCode")
    protected String issCode;
    @XmlElement(name = "TxnCode")
    protected String txnCode;
    @XmlElement(name = "PublicToken")
    protected String publicToken;
    @XmlElement(name = "LocDate")
    protected String locDate;
    @XmlElement(name = "LocTime")
    protected String locTime;
    @XmlElement(name = "StartDate")
    protected String startDate;
    @XmlElement(name = "EndDate")
    protected String endDate;
    @XmlElement(name = "ExpDate")
    protected String expDate;
    @XmlElement(name = "StatCode")
    protected String statCode;
    @XmlElement(name = "EmbossName")
    protected String embossName;
    @XmlElement(name = "AvlBal")
    protected double avlBal;
    @XmlElement(name = "BlkAmt")
    protected double blkAmt;
    @XmlElement(name = "CurCode")
    protected String curCode;
    @XmlElement(name = "ClientCode")
    protected String clientCode;
    @XmlElement(name = "SysDate")
    protected String sysDate;
    @XmlElement(name = "ActionCode")
    protected String actionCode;
    @XmlElement(name = "IsLive")
    protected boolean isLive;
    @XmlElement(name = "Scheme")
    protected String scheme;
    @XmlElement(name = "Product")
    protected String product;
    @XmlElement(name = "MaskedPAN")
    protected String maskedPAN;
    @XmlElement(name = "LimitGroup")
    protected String limitGroup;
    @XmlElement(name = "MCCGroup")
    protected String mccGroup;
    @XmlElement(name = "PERMSGroup")
    protected String permsGroup;
    @XmlElement(name = "FeeGroup")
    protected String feeGroup;
    @XmlElement(name = "SchedFeeGroup")
    protected String schedFeeGroup;
    @XmlElement(name = "WSFeeGroup")
    protected String wsFeeGroup;
    @XmlElement(name = "LinkageGroup")
    protected String linkageGroup;
    @XmlElement(name = "PrimaryToken")
    protected String primaryToken;
    @XmlElement(name = "AuthCalendarGroup")
    protected String authCalendarGroup;
    @XmlElement(name = "FXGroup")
    protected String fxGroup;

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
     * Gets the value of the issCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIssCode() {
        return issCode;
    }

    /**
     * Sets the value of the issCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIssCode(String value) {
        this.issCode = value;
    }

    /**
     * Gets the value of the txnCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTxnCode() {
        return txnCode;
    }

    /**
     * Sets the value of the txnCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTxnCode(String value) {
        this.txnCode = value;
    }

    /**
     * Gets the value of the publicToken property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPublicToken() {
        return publicToken;
    }

    /**
     * Sets the value of the publicToken property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPublicToken(String value) {
        this.publicToken = value;
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
     * Gets the value of the locTime property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLocTime() {
        return locTime;
    }

    /**
     * Sets the value of the locTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLocTime(String value) {
        this.locTime = value;
    }

    /**
     * Gets the value of the startDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStartDate() {
        return startDate;
    }

    /**
     * Sets the value of the startDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStartDate(String value) {
        this.startDate = value;
    }

    /**
     * Gets the value of the endDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEndDate() {
        return endDate;
    }

    /**
     * Sets the value of the endDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEndDate(String value) {
        this.endDate = value;
    }

    /**
     * Gets the value of the expDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getExpDate() {
        return expDate;
    }

    /**
     * Sets the value of the expDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setExpDate(String value) {
        this.expDate = value;
    }

    /**
     * Gets the value of the statCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStatCode() {
        return statCode;
    }

    /**
     * Sets the value of the statCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStatCode(String value) {
        this.statCode = value;
    }

    /**
     * Gets the value of the embossName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEmbossName() {
        return embossName;
    }

    /**
     * Sets the value of the embossName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEmbossName(String value) {
        this.embossName = value;
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
     * Gets the value of the curCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCurCode() {
        return curCode;
    }

    /**
     * Sets the value of the curCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCurCode(String value) {
        this.curCode = value;
    }

    /**
     * Gets the value of the clientCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getClientCode() {
        return clientCode;
    }

    /**
     * Sets the value of the clientCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setClientCode(String value) {
        this.clientCode = value;
    }

    /**
     * Gets the value of the sysDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSysDate() {
        return sysDate;
    }

    /**
     * Sets the value of the sysDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSysDate(String value) {
        this.sysDate = value;
    }

    /**
     * Gets the value of the actionCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getActionCode() {
        return actionCode;
    }

    /**
     * Sets the value of the actionCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setActionCode(String value) {
        this.actionCode = value;
    }

    /**
     * Gets the value of the isLive property.
     * 
     */
    public boolean isIsLive() {
        return isLive;
    }

    /**
     * Sets the value of the isLive property.
     * 
     */
    public void setIsLive(boolean value) {
        this.isLive = value;
    }

    /**
     * Gets the value of the scheme property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getScheme() {
        return scheme;
    }

    /**
     * Sets the value of the scheme property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setScheme(String value) {
        this.scheme = value;
    }

    /**
     * Gets the value of the product property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProduct() {
        return product;
    }

    /**
     * Sets the value of the product property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProduct(String value) {
        this.product = value;
    }

    /**
     * Gets the value of the maskedPAN property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMaskedPAN() {
        return maskedPAN;
    }

    /**
     * Sets the value of the maskedPAN property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMaskedPAN(String value) {
        this.maskedPAN = value;
    }

    /**
     * Gets the value of the limitGroup property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLimitGroup() {
        return limitGroup;
    }

    /**
     * Sets the value of the limitGroup property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLimitGroup(String value) {
        this.limitGroup = value;
    }

    /**
     * Gets the value of the mccGroup property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMCCGroup() {
        return mccGroup;
    }

    /**
     * Sets the value of the mccGroup property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMCCGroup(String value) {
        this.mccGroup = value;
    }

    /**
     * Gets the value of the permsGroup property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPERMSGroup() {
        return permsGroup;
    }

    /**
     * Sets the value of the permsGroup property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPERMSGroup(String value) {
        this.permsGroup = value;
    }

    /**
     * Gets the value of the feeGroup property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFeeGroup() {
        return feeGroup;
    }

    /**
     * Sets the value of the feeGroup property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFeeGroup(String value) {
        this.feeGroup = value;
    }

    /**
     * Gets the value of the schedFeeGroup property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSchedFeeGroup() {
        return schedFeeGroup;
    }

    /**
     * Sets the value of the schedFeeGroup property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSchedFeeGroup(String value) {
        this.schedFeeGroup = value;
    }

    /**
     * Gets the value of the wsFeeGroup property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWSFeeGroup() {
        return wsFeeGroup;
    }

    /**
     * Sets the value of the wsFeeGroup property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWSFeeGroup(String value) {
        this.wsFeeGroup = value;
    }

    /**
     * Gets the value of the linkageGroup property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLinkageGroup() {
        return linkageGroup;
    }

    /**
     * Sets the value of the linkageGroup property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLinkageGroup(String value) {
        this.linkageGroup = value;
    }

    /**
     * Gets the value of the primaryToken property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPrimaryToken() {
        return primaryToken;
    }

    /**
     * Sets the value of the primaryToken property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPrimaryToken(String value) {
        this.primaryToken = value;
    }

    /**
     * Gets the value of the authCalendarGroup property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAuthCalendarGroup() {
        return authCalendarGroup;
    }

    /**
     * Sets the value of the authCalendarGroup property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAuthCalendarGroup(String value) {
        this.authCalendarGroup = value;
    }

    /**
     * Gets the value of the fxGroup property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFXGroup() {
        return fxGroup;
    }

    /**
     * Sets the value of the fxGroup property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFXGroup(String value) {
        this.fxGroup = value;
    }

    @Override
    public String toString() {
        return "Card2{" +
                "wsid=" + wsid +
                ", issCode='" + issCode + '\'' +
                ", txnCode='" + txnCode + '\'' +
                ", publicToken='" + publicToken + '\'' +
                ", locDate='" + locDate + '\'' +
                ", locTime='" + locTime + '\'' +
                ", startDate='" + startDate + '\'' +
                ", endDate='" + endDate + '\'' +
                ", expDate='" + expDate + '\'' +
                ", statCode='" + statCode + '\'' +
                ", embossName='" + embossName + '\'' +
                ", avlBal=" + avlBal +
                ", blkAmt=" + blkAmt +
                ", curCode='" + curCode + '\'' +
                ", clientCode='" + clientCode + '\'' +
                ", sysDate='" + sysDate + '\'' +
                ", actionCode='" + actionCode + '\'' +
                ", isLive=" + isLive +
                ", scheme='" + scheme + '\'' +
                ", product='" + product + '\'' +
                ", maskedPAN='" + maskedPAN + '\'' +
                ", limitGroup='" + limitGroup + '\'' +
                ", mccGroup='" + mccGroup + '\'' +
                ", permsGroup='" + permsGroup + '\'' +
                ", feeGroup='" + feeGroup + '\'' +
                ", schedFeeGroup='" + schedFeeGroup + '\'' +
                ", wsFeeGroup='" + wsFeeGroup + '\'' +
                ", linkageGroup='" + linkageGroup + '\'' +
                ", primaryToken='" + primaryToken + '\'' +
                ", authCalendarGroup='" + authCalendarGroup + '\'' +
                ", fxGroup='" + fxGroup + '\'' +
                '}';
    }
}
