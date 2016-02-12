
package ae.globalprocessing.hyperionweb;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for CardHolderDetails complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CardHolderDetails">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="WSID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="IssCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="TxnCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="LocDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="LocTime" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ClientCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PublicToken" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="DOB" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="StatCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Title" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="FirstName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="LastName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Addrl1" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Addrl2" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="City" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PostCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Country" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Tel" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="WorkAddrl1" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="WorkAddrl2" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="WorkAddrl3" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="WorkCity" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="WorkPostCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="WorkCounty" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="WorkCountry" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="WorkTel" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="EMail" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Fax" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="POBox" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="MobTel" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="MaritalStatus" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Sex" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="AccNo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CrdProduct" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="EmbossName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="RefuseCheck" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="MailShots" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Discret" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="UsrData" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="UsrData1" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="UsrData2" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="UsrData3" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="UsrData4" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CurrCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ExpDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="EffDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SvcCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="AdditionalNo" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="DateCreated" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="DateActivated" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CrdDesign" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PIN" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="DlvMethod" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ImageID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="BrnCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ReNew" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="DenyMCC" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="DenySVC" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="AccType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CVC2" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="DlvTitle" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="DlvFirstName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="DlvLastName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="DlvAddrL1" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="DlvAddrL2" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="DlvAddrL3" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="DlvCity" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="DlvCounty" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="DlvCountry" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="DlvTel" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="DlvEffDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="DlvExpDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="IsoLang" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SysDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ActionCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CardHolderDetails", propOrder = {
    "wsid",
    "issCode",
    "txnCode",
    "locDate",
    "locTime",
    "clientCode",
    "publicToken",
    "dob",
    "statCode",
    "title",
    "firstName",
    "lastName",
    "addrl1",
    "addrl2",
    "city",
    "postCode",
    "country",
    "tel",
    "workAddrl1",
    "workAddrl2",
    "workAddrl3",
    "workCity",
    "workPostCode",
    "workCounty",
    "workCountry",
    "workTel",
    "eMail",
    "fax",
    "poBox",
    "mobTel",
    "maritalStatus",
    "sex",
    "accNo",
    "crdProduct",
    "embossName",
    "refuseCheck",
    "mailShots",
    "discret",
    "usrData",
    "usrData1",
    "usrData2",
    "usrData3",
    "usrData4",
    "currCode",
    "expDate",
    "effDate",
    "svcCode",
    "additionalNo",
    "dateCreated",
    "dateActivated",
    "crdDesign",
    "pin",
    "dlvMethod",
    "imageID",
    "brnCode",
    "reNew",
    "denyMCC",
    "denySVC",
    "accType",
    "cvc2",
    "dlvTitle",
    "dlvFirstName",
    "dlvLastName",
    "dlvAddrL1",
    "dlvAddrL2",
    "dlvAddrL3",
    "dlvCity",
    "dlvCounty",
    "dlvCountry",
    "dlvTel",
    "dlvEffDate",
    "dlvExpDate",
    "isoLang",
    "sysDate",
    "actionCode"
})
public class CardHolderDetails {

    @XmlElement(name = "WSID")
    protected long wsid;
    @XmlElement(name = "IssCode")
    protected String issCode;
    @XmlElement(name = "TxnCode")
    protected String txnCode;
    @XmlElement(name = "LocDate")
    protected String locDate;
    @XmlElement(name = "LocTime")
    protected String locTime;
    @XmlElement(name = "ClientCode")
    protected String clientCode;
    @XmlElement(name = "PublicToken")
    protected String publicToken;
    @XmlElement(name = "DOB")
    protected String dob;
    @XmlElement(name = "StatCode")
    protected String statCode;
    @XmlElement(name = "Title")
    protected String title;
    @XmlElement(name = "FirstName")
    protected String firstName;
    @XmlElement(name = "LastName")
    protected String lastName;
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
    @XmlElement(name = "Tel")
    protected String tel;
    @XmlElement(name = "WorkAddrl1")
    protected String workAddrl1;
    @XmlElement(name = "WorkAddrl2")
    protected String workAddrl2;
    @XmlElement(name = "WorkAddrl3")
    protected String workAddrl3;
    @XmlElement(name = "WorkCity")
    protected String workCity;
    @XmlElement(name = "WorkPostCode")
    protected String workPostCode;
    @XmlElement(name = "WorkCounty")
    protected String workCounty;
    @XmlElement(name = "WorkCountry")
    protected String workCountry;
    @XmlElement(name = "WorkTel")
    protected String workTel;
    @XmlElement(name = "EMail")
    protected String eMail;
    @XmlElement(name = "Fax")
    protected String fax;
    @XmlElement(name = "POBox")
    protected String poBox;
    @XmlElement(name = "MobTel")
    protected String mobTel;
    @XmlElement(name = "MaritalStatus")
    protected String maritalStatus;
    @XmlElement(name = "Sex")
    protected String sex;
    @XmlElement(name = "AccNo")
    protected String accNo;
    @XmlElement(name = "CrdProduct")
    protected String crdProduct;
    @XmlElement(name = "EmbossName")
    protected String embossName;
    @XmlElement(name = "RefuseCheck")
    protected String refuseCheck;
    @XmlElement(name = "MailShots")
    protected String mailShots;
    @XmlElement(name = "Discret")
    protected String discret;
    @XmlElement(name = "UsrData")
    protected String usrData;
    @XmlElement(name = "UsrData1")
    protected String usrData1;
    @XmlElement(name = "UsrData2")
    protected String usrData2;
    @XmlElement(name = "UsrData3")
    protected String usrData3;
    @XmlElement(name = "UsrData4")
    protected String usrData4;
    @XmlElement(name = "CurrCode")
    protected String currCode;
    @XmlElement(name = "ExpDate")
    protected String expDate;
    @XmlElement(name = "EffDate")
    protected String effDate;
    @XmlElement(name = "SvcCode")
    protected String svcCode;
    @XmlElement(name = "AdditionalNo")
    protected int additionalNo;
    @XmlElement(name = "DateCreated")
    protected String dateCreated;
    @XmlElement(name = "DateActivated")
    protected String dateActivated;
    @XmlElement(name = "CrdDesign")
    protected String crdDesign;
    @XmlElement(name = "PIN")
    protected String pin;
    @XmlElement(name = "DlvMethod")
    protected String dlvMethod;
    @XmlElement(name = "ImageID")
    protected String imageID;
    @XmlElement(name = "BrnCode")
    protected String brnCode;
    @XmlElement(name = "ReNew")
    protected String reNew;
    @XmlElement(name = "DenyMCC")
    protected String denyMCC;
    @XmlElement(name = "DenySVC")
    protected String denySVC;
    @XmlElement(name = "AccType")
    protected String accType;
    @XmlElement(name = "CVC2")
    protected String cvc2;
    @XmlElement(name = "DlvTitle")
    protected String dlvTitle;
    @XmlElement(name = "DlvFirstName")
    protected String dlvFirstName;
    @XmlElement(name = "DlvLastName")
    protected String dlvLastName;
    @XmlElement(name = "DlvAddrL1")
    protected String dlvAddrL1;
    @XmlElement(name = "DlvAddrL2")
    protected String dlvAddrL2;
    @XmlElement(name = "DlvAddrL3")
    protected String dlvAddrL3;
    @XmlElement(name = "DlvCity")
    protected String dlvCity;
    @XmlElement(name = "DlvCounty")
    protected String dlvCounty;
    @XmlElement(name = "DlvCountry")
    protected String dlvCountry;
    @XmlElement(name = "DlvTel")
    protected String dlvTel;
    @XmlElement(name = "DlvEffDate")
    protected String dlvEffDate;
    @XmlElement(name = "DlvExpDate")
    protected String dlvExpDate;
    @XmlElement(name = "IsoLang")
    protected String isoLang;
    @XmlElement(name = "SysDate")
    protected String sysDate;
    @XmlElement(name = "ActionCode")
    protected String actionCode;

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
     * Gets the value of the tel property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTel() {
        return tel;
    }

    /**
     * Sets the value of the tel property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTel(String value) {
        this.tel = value;
    }

    /**
     * Gets the value of the workAddrl1 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWorkAddrl1() {
        return workAddrl1;
    }

    /**
     * Sets the value of the workAddrl1 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWorkAddrl1(String value) {
        this.workAddrl1 = value;
    }

    /**
     * Gets the value of the workAddrl2 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWorkAddrl2() {
        return workAddrl2;
    }

    /**
     * Sets the value of the workAddrl2 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWorkAddrl2(String value) {
        this.workAddrl2 = value;
    }

    /**
     * Gets the value of the workAddrl3 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWorkAddrl3() {
        return workAddrl3;
    }

    /**
     * Sets the value of the workAddrl3 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWorkAddrl3(String value) {
        this.workAddrl3 = value;
    }

    /**
     * Gets the value of the workCity property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWorkCity() {
        return workCity;
    }

    /**
     * Sets the value of the workCity property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWorkCity(String value) {
        this.workCity = value;
    }

    /**
     * Gets the value of the workPostCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWorkPostCode() {
        return workPostCode;
    }

    /**
     * Sets the value of the workPostCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWorkPostCode(String value) {
        this.workPostCode = value;
    }

    /**
     * Gets the value of the workCounty property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWorkCounty() {
        return workCounty;
    }

    /**
     * Sets the value of the workCounty property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWorkCounty(String value) {
        this.workCounty = value;
    }

    /**
     * Gets the value of the workCountry property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWorkCountry() {
        return workCountry;
    }

    /**
     * Sets the value of the workCountry property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWorkCountry(String value) {
        this.workCountry = value;
    }

    /**
     * Gets the value of the workTel property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWorkTel() {
        return workTel;
    }

    /**
     * Sets the value of the workTel property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWorkTel(String value) {
        this.workTel = value;
    }

    /**
     * Gets the value of the eMail property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEMail() {
        return eMail;
    }

    /**
     * Sets the value of the eMail property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEMail(String value) {
        this.eMail = value;
    }

    /**
     * Gets the value of the fax property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFax() {
        return fax;
    }

    /**
     * Sets the value of the fax property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFax(String value) {
        this.fax = value;
    }

    /**
     * Gets the value of the poBox property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPOBox() {
        return poBox;
    }

    /**
     * Sets the value of the poBox property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPOBox(String value) {
        this.poBox = value;
    }

    /**
     * Gets the value of the mobTel property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMobTel() {
        return mobTel;
    }

    /**
     * Sets the value of the mobTel property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMobTel(String value) {
        this.mobTel = value;
    }

    /**
     * Gets the value of the maritalStatus property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMaritalStatus() {
        return maritalStatus;
    }

    /**
     * Sets the value of the maritalStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMaritalStatus(String value) {
        this.maritalStatus = value;
    }

    /**
     * Gets the value of the sex property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSex() {
        return sex;
    }

    /**
     * Sets the value of the sex property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSex(String value) {
        this.sex = value;
    }

    /**
     * Gets the value of the accNo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAccNo() {
        return accNo;
    }

    /**
     * Sets the value of the accNo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAccNo(String value) {
        this.accNo = value;
    }

    /**
     * Gets the value of the crdProduct property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCrdProduct() {
        return crdProduct;
    }

    /**
     * Sets the value of the crdProduct property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCrdProduct(String value) {
        this.crdProduct = value;
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
     * Gets the value of the refuseCheck property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRefuseCheck() {
        return refuseCheck;
    }

    /**
     * Sets the value of the refuseCheck property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRefuseCheck(String value) {
        this.refuseCheck = value;
    }

    /**
     * Gets the value of the mailShots property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMailShots() {
        return mailShots;
    }

    /**
     * Sets the value of the mailShots property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMailShots(String value) {
        this.mailShots = value;
    }

    /**
     * Gets the value of the discret property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDiscret() {
        return discret;
    }

    /**
     * Sets the value of the discret property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDiscret(String value) {
        this.discret = value;
    }

    /**
     * Gets the value of the usrData property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUsrData() {
        return usrData;
    }

    /**
     * Sets the value of the usrData property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUsrData(String value) {
        this.usrData = value;
    }

    /**
     * Gets the value of the usrData1 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUsrData1() {
        return usrData1;
    }

    /**
     * Sets the value of the usrData1 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUsrData1(String value) {
        this.usrData1 = value;
    }

    /**
     * Gets the value of the usrData2 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUsrData2() {
        return usrData2;
    }

    /**
     * Sets the value of the usrData2 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUsrData2(String value) {
        this.usrData2 = value;
    }

    /**
     * Gets the value of the usrData3 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUsrData3() {
        return usrData3;
    }

    /**
     * Sets the value of the usrData3 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUsrData3(String value) {
        this.usrData3 = value;
    }

    /**
     * Gets the value of the usrData4 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUsrData4() {
        return usrData4;
    }

    /**
     * Sets the value of the usrData4 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUsrData4(String value) {
        this.usrData4 = value;
    }

    /**
     * Gets the value of the currCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCurrCode() {
        return currCode;
    }

    /**
     * Sets the value of the currCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCurrCode(String value) {
        this.currCode = value;
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
     * Gets the value of the effDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEffDate() {
        return effDate;
    }

    /**
     * Sets the value of the effDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEffDate(String value) {
        this.effDate = value;
    }

    /**
     * Gets the value of the svcCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSvcCode() {
        return svcCode;
    }

    /**
     * Sets the value of the svcCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSvcCode(String value) {
        this.svcCode = value;
    }

    /**
     * Gets the value of the additionalNo property.
     * 
     */
    public int getAdditionalNo() {
        return additionalNo;
    }

    /**
     * Sets the value of the additionalNo property.
     * 
     */
    public void setAdditionalNo(int value) {
        this.additionalNo = value;
    }

    /**
     * Gets the value of the dateCreated property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDateCreated() {
        return dateCreated;
    }

    /**
     * Sets the value of the dateCreated property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDateCreated(String value) {
        this.dateCreated = value;
    }

    /**
     * Gets the value of the dateActivated property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDateActivated() {
        return dateActivated;
    }

    /**
     * Sets the value of the dateActivated property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDateActivated(String value) {
        this.dateActivated = value;
    }

    /**
     * Gets the value of the crdDesign property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCrdDesign() {
        return crdDesign;
    }

    /**
     * Sets the value of the crdDesign property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCrdDesign(String value) {
        this.crdDesign = value;
    }

    /**
     * Gets the value of the pin property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPIN() {
        return pin;
    }

    /**
     * Sets the value of the pin property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPIN(String value) {
        this.pin = value;
    }

    /**
     * Gets the value of the dlvMethod property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDlvMethod() {
        return dlvMethod;
    }

    /**
     * Sets the value of the dlvMethod property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDlvMethod(String value) {
        this.dlvMethod = value;
    }

    /**
     * Gets the value of the imageID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getImageID() {
        return imageID;
    }

    /**
     * Sets the value of the imageID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setImageID(String value) {
        this.imageID = value;
    }

    /**
     * Gets the value of the brnCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBrnCode() {
        return brnCode;
    }

    /**
     * Sets the value of the brnCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBrnCode(String value) {
        this.brnCode = value;
    }

    /**
     * Gets the value of the reNew property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReNew() {
        return reNew;
    }

    /**
     * Sets the value of the reNew property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReNew(String value) {
        this.reNew = value;
    }

    /**
     * Gets the value of the denyMCC property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDenyMCC() {
        return denyMCC;
    }

    /**
     * Sets the value of the denyMCC property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDenyMCC(String value) {
        this.denyMCC = value;
    }

    /**
     * Gets the value of the denySVC property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDenySVC() {
        return denySVC;
    }

    /**
     * Sets the value of the denySVC property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDenySVC(String value) {
        this.denySVC = value;
    }

    /**
     * Gets the value of the accType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAccType() {
        return accType;
    }

    /**
     * Sets the value of the accType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAccType(String value) {
        this.accType = value;
    }

    /**
     * Gets the value of the cvc2 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCVC2() {
        return cvc2;
    }

    /**
     * Sets the value of the cvc2 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCVC2(String value) {
        this.cvc2 = value;
    }

    /**
     * Gets the value of the dlvTitle property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDlvTitle() {
        return dlvTitle;
    }

    /**
     * Sets the value of the dlvTitle property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDlvTitle(String value) {
        this.dlvTitle = value;
    }

    /**
     * Gets the value of the dlvFirstName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDlvFirstName() {
        return dlvFirstName;
    }

    /**
     * Sets the value of the dlvFirstName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDlvFirstName(String value) {
        this.dlvFirstName = value;
    }

    /**
     * Gets the value of the dlvLastName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDlvLastName() {
        return dlvLastName;
    }

    /**
     * Sets the value of the dlvLastName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDlvLastName(String value) {
        this.dlvLastName = value;
    }

    /**
     * Gets the value of the dlvAddrL1 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDlvAddrL1() {
        return dlvAddrL1;
    }

    /**
     * Sets the value of the dlvAddrL1 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDlvAddrL1(String value) {
        this.dlvAddrL1 = value;
    }

    /**
     * Gets the value of the dlvAddrL2 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDlvAddrL2() {
        return dlvAddrL2;
    }

    /**
     * Sets the value of the dlvAddrL2 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDlvAddrL2(String value) {
        this.dlvAddrL2 = value;
    }

    /**
     * Gets the value of the dlvAddrL3 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDlvAddrL3() {
        return dlvAddrL3;
    }

    /**
     * Sets the value of the dlvAddrL3 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDlvAddrL3(String value) {
        this.dlvAddrL3 = value;
    }

    /**
     * Gets the value of the dlvCity property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDlvCity() {
        return dlvCity;
    }

    /**
     * Sets the value of the dlvCity property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDlvCity(String value) {
        this.dlvCity = value;
    }

    /**
     * Gets the value of the dlvCounty property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDlvCounty() {
        return dlvCounty;
    }

    /**
     * Sets the value of the dlvCounty property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDlvCounty(String value) {
        this.dlvCounty = value;
    }

    /**
     * Gets the value of the dlvCountry property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDlvCountry() {
        return dlvCountry;
    }

    /**
     * Sets the value of the dlvCountry property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDlvCountry(String value) {
        this.dlvCountry = value;
    }

    /**
     * Gets the value of the dlvTel property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDlvTel() {
        return dlvTel;
    }

    /**
     * Sets the value of the dlvTel property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDlvTel(String value) {
        this.dlvTel = value;
    }

    /**
     * Gets the value of the dlvEffDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDlvEffDate() {
        return dlvEffDate;
    }

    /**
     * Sets the value of the dlvEffDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDlvEffDate(String value) {
        this.dlvEffDate = value;
    }

    /**
     * Gets the value of the dlvExpDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDlvExpDate() {
        return dlvExpDate;
    }

    /**
     * Sets the value of the dlvExpDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDlvExpDate(String value) {
        this.dlvExpDate = value;
    }

    /**
     * Gets the value of the isoLang property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIsoLang() {
        return isoLang;
    }

    /**
     * Sets the value of the isoLang property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIsoLang(String value) {
        this.isoLang = value;
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

}
