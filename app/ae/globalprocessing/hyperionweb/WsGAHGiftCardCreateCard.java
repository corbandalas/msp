
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
 *         &lt;element name="Title" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="LastName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="FirstName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Addrl1" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Addrl2" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="City" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PostCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Country" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Mobile" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CardDesign" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ExternalRef" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="DOB" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="LocDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="LocTime" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="TerminalID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="LoadValue" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="CurCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Reason" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="AccCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ItemSrc" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="LoadFundsType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="LoadSrc" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="LoadFee" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="LoadedBy" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CreateImage" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="CreateType" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="CustAccount" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ActivateNow" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="Source_desc" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ExpDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
    "title",
    "lastName",
    "firstName",
    "addrl1",
    "addrl2",
    "city",
    "postCode",
    "country",
    "mobile",
    "cardDesign",
    "externalRef",
    "dob",
    "locDate",
    "locTime",
    "terminalID",
    "loadValue",
    "curCode",
    "reason",
    "accCode",
    "itemSrc",
    "loadFundsType",
    "loadSrc",
    "loadFee",
    "loadedBy",
    "createImage",
    "createType",
    "custAccount",
    "activateNow",
    "sourceDesc",
    "expDate"
})
@XmlRootElement(name = "Ws_GAH_GiftCard_CreateCard")
public class WsGAHGiftCardCreateCard {

    @XmlElement(name = "WSID")
    protected long wsid;
    @XmlElement(name = "IssCode")
    protected String issCode;
    @XmlElement(name = "TxnCode")
    protected String txnCode;
    @XmlElement(name = "ClientCode")
    protected String clientCode;
    @XmlElement(name = "Title")
    protected String title;
    @XmlElement(name = "LastName")
    protected String lastName;
    @XmlElement(name = "FirstName")
    protected String firstName;
    @XmlElement(name = "Addrl1")
    protected String addrl1;
    @XmlElement(name = "Addrl2")
    protected String addrl2;
    @XmlElement(name = "City")
    protected String city;
    @XmlElement(name = "PostCode")
    protected String postCode;
    @XmlElement(name = "Country")
    protected String country;
    @XmlElement(name = "Mobile")
    protected String mobile;
    @XmlElement(name = "CardDesign")
    protected String cardDesign;
    @XmlElement(name = "ExternalRef")
    protected String externalRef;
    @XmlElement(name = "DOB")
    protected String dob;
    @XmlElement(name = "LocDate")
    protected String locDate;
    @XmlElement(name = "LocTime")
    protected String locTime;
    @XmlElement(name = "TerminalID")
    protected String terminalID;
    @XmlElement(name = "LoadValue")
    protected double loadValue;
    @XmlElement(name = "CurCode")
    protected String curCode;
    @XmlElement(name = "Reason")
    protected String reason;
    @XmlElement(name = "AccCode")
    protected String accCode;
    @XmlElement(name = "ItemSrc")
    protected int itemSrc;
    @XmlElement(name = "LoadFundsType")
    protected String loadFundsType;
    @XmlElement(name = "LoadSrc")
    protected String loadSrc;
    @XmlElement(name = "LoadFee")
    protected double loadFee;
    @XmlElement(name = "LoadedBy")
    protected String loadedBy;
    @XmlElement(name = "CreateImage")
    protected int createImage;
    @XmlElement(name = "CreateType")
    protected int createType;
    @XmlElement(name = "CustAccount")
    protected String custAccount;
    @XmlElement(name = "ActivateNow")
    protected int activateNow;
    @XmlElement(name = "Source_desc")
    protected String sourceDesc;
    @XmlElement(name = "ExpDate")
    protected String expDate;

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
     * Gets the value of the title property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets the value of the title property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTitle(String value) {
        this.title = value;
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
     * Gets the value of the firstName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets the value of the firstName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFirstName(String value) {
        this.firstName = value;
    }

    /**
     * Gets the value of the addrl1 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAddrl1() {
        return addrl1;
    }

    /**
     * Sets the value of the addrl1 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAddrl1(String value) {
        this.addrl1 = value;
    }

    /**
     * Gets the value of the addrl2 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAddrl2() {
        return addrl2;
    }

    /**
     * Sets the value of the addrl2 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAddrl2(String value) {
        this.addrl2 = value;
    }

    /**
     * Gets the value of the city property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCity() {
        return city;
    }

    /**
     * Sets the value of the city property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCity(String value) {
        this.city = value;
    }

    /**
     * Gets the value of the postCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPostCode() {
        return postCode;
    }

    /**
     * Sets the value of the postCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPostCode(String value) {
        this.postCode = value;
    }

    /**
     * Gets the value of the country property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCountry() {
        return country;
    }

    /**
     * Sets the value of the country property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCountry(String value) {
        this.country = value;
    }

    /**
     * Gets the value of the mobile property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMobile() {
        return mobile;
    }

    /**
     * Sets the value of the mobile property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMobile(String value) {
        this.mobile = value;
    }

    /**
     * Gets the value of the cardDesign property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCardDesign() {
        return cardDesign;
    }

    /**
     * Sets the value of the cardDesign property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCardDesign(String value) {
        this.cardDesign = value;
    }

    /**
     * Gets the value of the externalRef property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getExternalRef() {
        return externalRef;
    }

    /**
     * Sets the value of the externalRef property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setExternalRef(String value) {
        this.externalRef = value;
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
     * Gets the value of the loadValue property.
     * 
     */
    public double getLoadValue() {
        return loadValue;
    }

    /**
     * Sets the value of the loadValue property.
     * 
     */
    public void setLoadValue(double value) {
        this.loadValue = value;
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
     * Gets the value of the loadFundsType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLoadFundsType() {
        return loadFundsType;
    }

    /**
     * Sets the value of the loadFundsType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLoadFundsType(String value) {
        this.loadFundsType = value;
    }

    /**
     * Gets the value of the loadSrc property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLoadSrc() {
        return loadSrc;
    }

    /**
     * Sets the value of the loadSrc property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLoadSrc(String value) {
        this.loadSrc = value;
    }

    /**
     * Gets the value of the loadFee property.
     * 
     */
    public double getLoadFee() {
        return loadFee;
    }

    /**
     * Sets the value of the loadFee property.
     * 
     */
    public void setLoadFee(double value) {
        this.loadFee = value;
    }

    /**
     * Gets the value of the loadedBy property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLoadedBy() {
        return loadedBy;
    }

    /**
     * Sets the value of the loadedBy property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLoadedBy(String value) {
        this.loadedBy = value;
    }

    /**
     * Gets the value of the createImage property.
     * 
     */
    public int getCreateImage() {
        return createImage;
    }

    /**
     * Sets the value of the createImage property.
     * 
     */
    public void setCreateImage(int value) {
        this.createImage = value;
    }

    /**
     * Gets the value of the createType property.
     * 
     */
    public int getCreateType() {
        return createType;
    }

    /**
     * Sets the value of the createType property.
     * 
     */
    public void setCreateType(int value) {
        this.createType = value;
    }

    /**
     * Gets the value of the custAccount property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCustAccount() {
        return custAccount;
    }

    /**
     * Sets the value of the custAccount property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCustAccount(String value) {
        this.custAccount = value;
    }

    /**
     * Gets the value of the activateNow property.
     * 
     */
    public int getActivateNow() {
        return activateNow;
    }

    /**
     * Sets the value of the activateNow property.
     * 
     */
    public void setActivateNow(int value) {
        this.activateNow = value;
    }

    /**
     * Gets the value of the sourceDesc property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSourceDesc() {
        return sourceDesc;
    }

    /**
     * Sets the value of the sourceDesc property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSourceDesc(String value) {
        this.sourceDesc = value;
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

}
