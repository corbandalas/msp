
package ae.globalprocessing.hyperionweb;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="WSID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="IssCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="TxnCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ClientCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="AuthType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PAN" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Track2" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PublicToken" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="DOB" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CVV" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="AccCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="LastName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="LocDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="LocTime" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="NewStatCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Reason" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ItemSrc" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="TerminalID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SecID" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="SecVal" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SecValPos" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="Sms_Required" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "wsid",
    "issCode",
    "txnCode",
    "clientCode",
    "authType",
    "pan",
    "track2",
    "publicToken",
    "dob",
    "cvv",
    "accCode",
    "lastName",
    "locDate",
    "locTime",
    "newStatCode",
    "reason",
    "itemSrc",
    "terminalID",
    "secID",
    "secVal",
    "secValPos",
    "smsRequired"
})
@XmlRootElement(name = "Ws_StatusChange")
public class WsStatusChange {

    @XmlElement(name = "WSID")
    protected long wsid;
    @XmlElement(name = "IssCode")
    protected String issCode;
    @XmlElement(name = "TxnCode")
    protected String txnCode;
    @XmlElement(name = "ClientCode")
    protected String clientCode;
    @XmlElement(name = "AuthType")
    protected String authType;
    @XmlElement(name = "PAN")
    protected String pan;
    @XmlElement(name = "Track2")
    protected String track2;
    @XmlElement(name = "PublicToken")
    protected String publicToken;
    @XmlElement(name = "DOB")
    protected String dob;
    @XmlElement(name = "CVV")
    protected String cvv;
    @XmlElement(name = "AccCode")
    protected String accCode;
    @XmlElement(name = "LastName")
    protected String lastName;
    @XmlElement(name = "LocDate")
    protected String locDate;
    @XmlElement(name = "LocTime")
    protected String locTime;
    @XmlElement(name = "NewStatCode")
    protected String newStatCode;
    @XmlElement(name = "Reason")
    protected String reason;
    @XmlElement(name = "ItemSrc")
    protected int itemSrc;
    @XmlElement(name = "TerminalID")
    protected String terminalID;
    @XmlElement(name = "SecID")
    protected int secID;
    @XmlElement(name = "SecVal")
    protected String secVal;
    @XmlElement(name = "SecValPos")
    protected int secValPos;
    @XmlElement(name = "Sms_Required")
    protected String smsRequired;

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
     * Gets the value of the authType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAuthType() {
        return authType;
    }

    /**
     * Sets the value of the authType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAuthType(String value) {
        this.authType = value;
    }

    /**
     * Gets the value of the pan property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPAN() {
        return pan;
    }

    /**
     * Sets the value of the pan property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPAN(String value) {
        this.pan = value;
    }

    /**
     * Gets the value of the track2 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTrack2() {
        return track2;
    }

    /**
     * Sets the value of the track2 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTrack2(String value) {
        this.track2 = value;
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
     * Gets the value of the dob property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDOB() {
        return dob;
    }

    /**
     * Sets the value of the dob property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDOB(String value) {
        this.dob = value;
    }

    /**
     * Gets the value of the cvv property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCVV() {
        return cvv;
    }

    /**
     * Sets the value of the cvv property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCVV(String value) {
        this.cvv = value;
    }

    /**
     * Gets the value of the accCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAccCode() {
        return accCode;
    }

    /**
     * Sets the value of the accCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAccCode(String value) {
        this.accCode = value;
    }

    /**
     * Gets the value of the lastName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets the value of the lastName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLastName(String value) {
        this.lastName = value;
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
     * Gets the value of the newStatCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNewStatCode() {
        return newStatCode;
    }

    /**
     * Sets the value of the newStatCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNewStatCode(String value) {
        this.newStatCode = value;
    }

    /**
     * Gets the value of the reason property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReason() {
        return reason;
    }

    /**
     * Sets the value of the reason property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReason(String value) {
        this.reason = value;
    }

    /**
     * Gets the value of the itemSrc property.
     * 
     */
    public int getItemSrc() {
        return itemSrc;
    }

    /**
     * Sets the value of the itemSrc property.
     * 
     */
    public void setItemSrc(int value) {
        this.itemSrc = value;
    }

    /**
     * Gets the value of the terminalID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTerminalID() {
        return terminalID;
    }

    /**
     * Sets the value of the terminalID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTerminalID(String value) {
        this.terminalID = value;
    }

    /**
     * Gets the value of the secID property.
     * 
     */
    public int getSecID() {
        return secID;
    }

    /**
     * Sets the value of the secID property.
     * 
     */
    public void setSecID(int value) {
        this.secID = value;
    }

    /**
     * Gets the value of the secVal property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSecVal() {
        return secVal;
    }

    /**
     * Sets the value of the secVal property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSecVal(String value) {
        this.secVal = value;
    }

    /**
     * Gets the value of the secValPos property.
     * 
     */
    public int getSecValPos() {
        return secValPos;
    }

    /**
     * Sets the value of the secValPos property.
     * 
     */
    public void setSecValPos(int value) {
        this.secValPos = value;
    }

    /**
     * Gets the value of the smsRequired property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSmsRequired() {
        return smsRequired;
    }

    /**
     * Sets the value of the smsRequired property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSmsRequired(String value) {
        this.smsRequired = value;
    }

}
