
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
 *         &lt;element name="Addrl3" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
 *         &lt;element name="CardName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="LimitsGroup" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="MCCGroup" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PERMSGroup" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ProductRef" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CarrierType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Fulfil1" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Fulfil2" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="DelvMethod" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ThermalLine1" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ThermalLine2" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="EmbossLine4" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ImageId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="LogoFrontId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="LogoBackId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Replacement" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="FeeGroup" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PrimaryToken" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Delv_AddrL1" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Delv_AddrL2" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Delv_AddrL3" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Delv_City" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Delv_County" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Delv_PostCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Delv_Country" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Delv_Code" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Lang" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Sms_Required" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SchedFeeGroup" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="WSFeeGroup" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CardManufacturer" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CoBrand" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PublicToken" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ExternalAuth" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="LinkageGroup" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="VanityName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PBlock" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PINMailer" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="FxGroup" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Email" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="MailOrSMS" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="AuthCalendarGroup" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Quantity" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="LoadToken" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
    "addrl3",
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
    "expDate",
    "cardName",
    "limitsGroup",
    "mccGroup",
    "permsGroup",
    "productRef",
    "carrierType",
    "fulfil1",
    "fulfil2",
    "delvMethod",
    "thermalLine1",
    "thermalLine2",
    "embossLine4",
    "imageId",
    "logoFrontId",
    "logoBackId",
    "replacement",
    "feeGroup",
    "primaryToken",
    "delvAddrL1",
    "delvAddrL2",
    "delvAddrL3",
    "delvCity",
    "delvCounty",
    "delvPostCode",
    "delvCountry",
    "delvCode",
    "lang",
    "smsRequired",
    "schedFeeGroup",
    "wsFeeGroup",
    "cardManufacturer",
    "coBrand",
    "publicToken",
    "externalAuth",
    "linkageGroup",
    "vanityName",
    "pBlock",
    "pinMailer",
    "fxGroup",
    "email",
    "mailOrSMS",
    "authCalendarGroup",
    "quantity",
    "loadToken"
})
@XmlRootElement(name = "Ws_CreateCard")
public class WsCreateCard {

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
    @XmlElement(name = "Addrl3")
    protected String addrl3;
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
    @XmlElement(name = "CardName")
    protected String cardName;
    @XmlElement(name = "LimitsGroup")
    protected String limitsGroup;
    @XmlElement(name = "MCCGroup")
    protected String mccGroup;
    @XmlElement(name = "PERMSGroup")
    protected String permsGroup;
    @XmlElement(name = "ProductRef")
    protected String productRef;
    @XmlElement(name = "CarrierType")
    protected String carrierType;
    @XmlElement(name = "Fulfil1")
    protected String fulfil1;
    @XmlElement(name = "Fulfil2")
    protected String fulfil2;
    @XmlElement(name = "DelvMethod")
    protected String delvMethod;
    @XmlElement(name = "ThermalLine1")
    protected String thermalLine1;
    @XmlElement(name = "ThermalLine2")
    protected String thermalLine2;
    @XmlElement(name = "EmbossLine4")
    protected String embossLine4;
    @XmlElement(name = "ImageId")
    protected String imageId;
    @XmlElement(name = "LogoFrontId")
    protected String logoFrontId;
    @XmlElement(name = "LogoBackId")
    protected String logoBackId;
    @XmlElement(name = "Replacement")
    protected boolean replacement;
    @XmlElement(name = "FeeGroup")
    protected String feeGroup;
    @XmlElement(name = "PrimaryToken")
    protected String primaryToken;
    @XmlElement(name = "Delv_AddrL1")
    protected String delvAddrL1;
    @XmlElement(name = "Delv_AddrL2")
    protected String delvAddrL2;
    @XmlElement(name = "Delv_AddrL3")
    protected String delvAddrL3;
    @XmlElement(name = "Delv_City")
    protected String delvCity;
    @XmlElement(name = "Delv_County")
    protected String delvCounty;
    @XmlElement(name = "Delv_PostCode")
    protected String delvPostCode;
    @XmlElement(name = "Delv_Country")
    protected String delvCountry;
    @XmlElement(name = "Delv_Code")
    protected String delvCode;
    @XmlElement(name = "Lang")
    protected String lang;
    @XmlElement(name = "Sms_Required")
    protected String smsRequired;
    @XmlElement(name = "SchedFeeGroup")
    protected String schedFeeGroup;
    @XmlElement(name = "WSFeeGroup")
    protected String wsFeeGroup;
    @XmlElement(name = "CardManufacturer")
    protected String cardManufacturer;
    @XmlElement(name = "CoBrand")
    protected String coBrand;
    @XmlElement(name = "PublicToken")
    protected String publicToken;
    @XmlElement(name = "ExternalAuth")
    protected String externalAuth;
    @XmlElement(name = "LinkageGroup")
    protected String linkageGroup;
    @XmlElement(name = "VanityName")
    protected String vanityName;
    @XmlElement(name = "PBlock")
    protected String pBlock;
    @XmlElement(name = "PINMailer")
    protected String pinMailer;
    @XmlElement(name = "FxGroup")
    protected String fxGroup;
    @XmlElement(name = "Email")
    protected String email;
    @XmlElement(name = "MailOrSMS")
    protected String mailOrSMS;
    @XmlElement(name = "AuthCalendarGroup")
    protected String authCalendarGroup;
    @XmlElement(name = "Quantity")
    protected String quantity;
    @XmlElement(name = "LoadToken")
    protected String loadToken;

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
     * Gets the value of the addrl3 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAddrl3() {
        return addrl3;
    }

    /**
     * Sets the value of the addrl3 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAddrl3(String value) {
        this.addrl3 = value;
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

    /**
     * Gets the value of the cardName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCardName() {
        return cardName;
    }

    /**
     * Sets the value of the cardName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCardName(String value) {
        this.cardName = value;
    }

    /**
     * Gets the value of the limitsGroup property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLimitsGroup() {
        return limitsGroup;
    }

    /**
     * Sets the value of the limitsGroup property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLimitsGroup(String value) {
        this.limitsGroup = value;
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
     * Gets the value of the productRef property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProductRef() {
        return productRef;
    }

    /**
     * Sets the value of the productRef property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProductRef(String value) {
        this.productRef = value;
    }

    /**
     * Gets the value of the carrierType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCarrierType() {
        return carrierType;
    }

    /**
     * Sets the value of the carrierType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCarrierType(String value) {
        this.carrierType = value;
    }

    /**
     * Gets the value of the fulfil1 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFulfil1() {
        return fulfil1;
    }

    /**
     * Sets the value of the fulfil1 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFulfil1(String value) {
        this.fulfil1 = value;
    }

    /**
     * Gets the value of the fulfil2 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFulfil2() {
        return fulfil2;
    }

    /**
     * Sets the value of the fulfil2 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFulfil2(String value) {
        this.fulfil2 = value;
    }

    /**
     * Gets the value of the delvMethod property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDelvMethod() {
        return delvMethod;
    }

    /**
     * Sets the value of the delvMethod property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDelvMethod(String value) {
        this.delvMethod = value;
    }

    /**
     * Gets the value of the thermalLine1 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getThermalLine1() {
        return thermalLine1;
    }

    /**
     * Sets the value of the thermalLine1 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setThermalLine1(String value) {
        this.thermalLine1 = value;
    }

    /**
     * Gets the value of the thermalLine2 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getThermalLine2() {
        return thermalLine2;
    }

    /**
     * Sets the value of the thermalLine2 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setThermalLine2(String value) {
        this.thermalLine2 = value;
    }

    /**
     * Gets the value of the embossLine4 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEmbossLine4() {
        return embossLine4;
    }

    /**
     * Sets the value of the embossLine4 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEmbossLine4(String value) {
        this.embossLine4 = value;
    }

    /**
     * Gets the value of the imageId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getImageId() {
        return imageId;
    }

    /**
     * Sets the value of the imageId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setImageId(String value) {
        this.imageId = value;
    }

    /**
     * Gets the value of the logoFrontId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLogoFrontId() {
        return logoFrontId;
    }

    /**
     * Sets the value of the logoFrontId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLogoFrontId(String value) {
        this.logoFrontId = value;
    }

    /**
     * Gets the value of the logoBackId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLogoBackId() {
        return logoBackId;
    }

    /**
     * Sets the value of the logoBackId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLogoBackId(String value) {
        this.logoBackId = value;
    }

    /**
     * Gets the value of the replacement property.
     * 
     */
    public boolean isReplacement() {
        return replacement;
    }

    /**
     * Sets the value of the replacement property.
     * 
     */
    public void setReplacement(boolean value) {
        this.replacement = value;
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
     * Gets the value of the delvAddrL1 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDelvAddrL1() {
        return delvAddrL1;
    }

    /**
     * Sets the value of the delvAddrL1 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDelvAddrL1(String value) {
        this.delvAddrL1 = value;
    }

    /**
     * Gets the value of the delvAddrL2 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDelvAddrL2() {
        return delvAddrL2;
    }

    /**
     * Sets the value of the delvAddrL2 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDelvAddrL2(String value) {
        this.delvAddrL2 = value;
    }

    /**
     * Gets the value of the delvAddrL3 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDelvAddrL3() {
        return delvAddrL3;
    }

    /**
     * Sets the value of the delvAddrL3 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDelvAddrL3(String value) {
        this.delvAddrL3 = value;
    }

    /**
     * Gets the value of the delvCity property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDelvCity() {
        return delvCity;
    }

    /**
     * Sets the value of the delvCity property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDelvCity(String value) {
        this.delvCity = value;
    }

    /**
     * Gets the value of the delvCounty property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDelvCounty() {
        return delvCounty;
    }

    /**
     * Sets the value of the delvCounty property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDelvCounty(String value) {
        this.delvCounty = value;
    }

    /**
     * Gets the value of the delvPostCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDelvPostCode() {
        return delvPostCode;
    }

    /**
     * Sets the value of the delvPostCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDelvPostCode(String value) {
        this.delvPostCode = value;
    }

    /**
     * Gets the value of the delvCountry property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDelvCountry() {
        return delvCountry;
    }

    /**
     * Sets the value of the delvCountry property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDelvCountry(String value) {
        this.delvCountry = value;
    }

    /**
     * Gets the value of the delvCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDelvCode() {
        return delvCode;
    }

    /**
     * Sets the value of the delvCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDelvCode(String value) {
        this.delvCode = value;
    }

    /**
     * Gets the value of the lang property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLang() {
        return lang;
    }

    /**
     * Sets the value of the lang property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLang(String value) {
        this.lang = value;
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
     * Gets the value of the cardManufacturer property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCardManufacturer() {
        return cardManufacturer;
    }

    /**
     * Sets the value of the cardManufacturer property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCardManufacturer(String value) {
        this.cardManufacturer = value;
    }

    /**
     * Gets the value of the coBrand property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCoBrand() {
        return coBrand;
    }

    /**
     * Sets the value of the coBrand property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCoBrand(String value) {
        this.coBrand = value;
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
     * Gets the value of the externalAuth property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getExternalAuth() {
        return externalAuth;
    }

    /**
     * Sets the value of the externalAuth property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setExternalAuth(String value) {
        this.externalAuth = value;
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
     * Gets the value of the vanityName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVanityName() {
        return vanityName;
    }

    /**
     * Sets the value of the vanityName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVanityName(String value) {
        this.vanityName = value;
    }

    /**
     * Gets the value of the pBlock property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPBlock() {
        return pBlock;
    }

    /**
     * Sets the value of the pBlock property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPBlock(String value) {
        this.pBlock = value;
    }

    /**
     * Gets the value of the pinMailer property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPINMailer() {
        return pinMailer;
    }

    /**
     * Sets the value of the pinMailer property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPINMailer(String value) {
        this.pinMailer = value;
    }

    /**
     * Gets the value of the fxGroup property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFxGroup() {
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
    public void setFxGroup(String value) {
        this.fxGroup = value;
    }

    /**
     * Gets the value of the email property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the value of the email property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEmail(String value) {
        this.email = value;
    }

    /**
     * Gets the value of the mailOrSMS property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMailOrSMS() {
        return mailOrSMS;
    }

    /**
     * Sets the value of the mailOrSMS property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMailOrSMS(String value) {
        this.mailOrSMS = value;
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
     * Gets the value of the quantity property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getQuantity() {
        return quantity;
    }

    /**
     * Sets the value of the quantity property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setQuantity(String value) {
        this.quantity = value;
    }

    /**
     * Gets the value of the loadToken property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLoadToken() {
        return loadToken;
    }

    /**
     * Sets the value of the loadToken property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLoadToken(String value) {
        this.loadToken = value;
    }

}
