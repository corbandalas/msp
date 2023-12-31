
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
 *         &lt;element name="DOB" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CVV" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="accCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="newAccCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="crdProduct" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="lastName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Title" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="firstName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="addr1" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="addr2" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="city" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="postcode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="country" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="tel" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Workaddr1" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Workaddr2" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Workaddr3" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Workcity" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Workpostcode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Workcounty" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Workcountry" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Worktel" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="pobox" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="email" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="fax" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="mobTel" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="maritalStatus" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="sex" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="embossName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="refuseCheck" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="mailShots" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="discret" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="userdata" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="userdata1" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="userdata2" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="userdata3" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="userdata4" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="pin" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="imageID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="brncode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="renew" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="dlvMethod" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="denyMCC" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="denySvc" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="accType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="memo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="memoScope" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="memoUser" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="itemSrc" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="dlvTitle" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="dlvfirstName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="dlvlastName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="dlvaddr1" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="dlvaddr2" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="dlvaddr3" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="dlvcity" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="dlvpostcode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="dlvcounty" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="dlvcountry" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="dlvtel" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="dlvEffDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="dlvDaysValid" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="crdprogram" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="crddesign" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="feeTier" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="isoLang" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="fundcrdPAN" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="fundCrdEffDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="fundCrdExpDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="fundCrdType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="fundCrdIssNum" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="fundCrdCVC" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="svcSrc" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="svcType" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="svcStatus" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="secID" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="SecVal" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SecValPos" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="PublicToken" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SmsBalance" type="{http://www.w3.org/2001/XMLSchema}int"/>
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
    "dob",
    "cvv",
    "accCode",
    "newAccCode",
    "crdProduct",
    "lastName",
    "title",
    "firstName",
    "addr1",
    "addr2",
    "city",
    "postcode",
    "country",
    "tel",
    "workaddr1",
    "workaddr2",
    "workaddr3",
    "workcity",
    "workpostcode",
    "workcounty",
    "workcountry",
    "worktel",
    "pobox",
    "email",
    "fax",
    "mobTel",
    "maritalStatus",
    "sex",
    "embossName",
    "refuseCheck",
    "mailShots",
    "discret",
    "userdata",
    "userdata1",
    "userdata2",
    "userdata3",
    "userdata4",
    "pin",
    "imageID",
    "brncode",
    "renew",
    "dlvMethod",
    "denyMCC",
    "denySvc",
    "accType",
    "memo",
    "memoScope",
    "memoUser",
    "itemSrc",
    "dlvTitle",
    "dlvfirstName",
    "dlvlastName",
    "dlvaddr1",
    "dlvaddr2",
    "dlvaddr3",
    "dlvcity",
    "dlvpostcode",
    "dlvcounty",
    "dlvcountry",
    "dlvtel",
    "dlvEffDate",
    "dlvDaysValid",
    "crdprogram",
    "crddesign",
    "feeTier",
    "isoLang",
    "fundcrdPAN",
    "fundCrdEffDate",
    "fundCrdExpDate",
    "fundCrdType",
    "fundCrdIssNum",
    "fundCrdCVC",
    "svcSrc",
    "svcType",
    "svcStatus",
    "secID",
    "secVal",
    "secValPos",
    "publicToken",
    "smsBalance"
})
@XmlRootElement(name = "Ws_GiftCard_Update_Cardholder_Details")
public class WsGiftCardUpdateCardholderDetails {

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
    @XmlElement(name = "DOB")
    protected String dob;
    @XmlElement(name = "CVV")
    protected String cvv;
    protected String accCode;
    protected String newAccCode;
    protected String crdProduct;
    protected String lastName;
    @XmlElement(name = "Title")
    protected String title;
    protected String firstName;
    protected String addr1;
    protected String addr2;
    protected String city;
    protected String postcode;
    protected String country;
    protected String tel;
    @XmlElement(name = "Workaddr1")
    protected String workaddr1;
    @XmlElement(name = "Workaddr2")
    protected String workaddr2;
    @XmlElement(name = "Workaddr3")
    protected String workaddr3;
    @XmlElement(name = "Workcity")
    protected String workcity;
    @XmlElement(name = "Workpostcode")
    protected String workpostcode;
    @XmlElement(name = "Workcounty")
    protected String workcounty;
    @XmlElement(name = "Workcountry")
    protected String workcountry;
    @XmlElement(name = "Worktel")
    protected String worktel;
    protected String pobox;
    protected String email;
    protected String fax;
    protected String mobTel;
    protected String maritalStatus;
    protected String sex;
    protected String embossName;
    protected String refuseCheck;
    protected String mailShots;
    protected String discret;
    protected String userdata;
    protected String userdata1;
    protected String userdata2;
    protected String userdata3;
    protected String userdata4;
    protected String pin;
    protected String imageID;
    protected String brncode;
    protected String renew;
    protected String dlvMethod;
    protected String denyMCC;
    protected String denySvc;
    protected String accType;
    protected String memo;
    protected int memoScope;
    protected String memoUser;
    protected int itemSrc;
    protected String dlvTitle;
    protected String dlvfirstName;
    protected String dlvlastName;
    protected String dlvaddr1;
    protected String dlvaddr2;
    protected String dlvaddr3;
    protected String dlvcity;
    protected String dlvpostcode;
    protected String dlvcounty;
    protected String dlvcountry;
    protected String dlvtel;
    protected String dlvEffDate;
    protected int dlvDaysValid;
    protected String crdprogram;
    protected String crddesign;
    protected String feeTier;
    protected String isoLang;
    protected String fundcrdPAN;
    protected String fundCrdEffDate;
    protected String fundCrdExpDate;
    protected String fundCrdType;
    protected int fundCrdIssNum;
    protected int fundCrdCVC;
    protected int svcSrc;
    protected int svcType;
    protected int svcStatus;
    protected int secID;
    @XmlElement(name = "SecVal")
    protected String secVal;
    @XmlElement(name = "SecValPos")
    protected int secValPos;
    @XmlElement(name = "PublicToken")
    protected String publicToken;
    @XmlElement(name = "SmsBalance")
    protected int smsBalance;

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
     * Gets the value of the newAccCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNewAccCode() {
        return newAccCode;
    }

    /**
     * Sets the value of the newAccCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNewAccCode(String value) {
        this.newAccCode = value;
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
     * Gets the value of the addr1 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAddr1() {
        return addr1;
    }

    /**
     * Sets the value of the addr1 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAddr1(String value) {
        this.addr1 = value;
    }

    /**
     * Gets the value of the addr2 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAddr2() {
        return addr2;
    }

    /**
     * Sets the value of the addr2 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAddr2(String value) {
        this.addr2 = value;
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
     * Gets the value of the postcode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPostcode() {
        return postcode;
    }

    /**
     * Sets the value of the postcode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPostcode(String value) {
        this.postcode = value;
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
     * Gets the value of the workaddr1 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWorkaddr1() {
        return workaddr1;
    }

    /**
     * Sets the value of the workaddr1 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWorkaddr1(String value) {
        this.workaddr1 = value;
    }

    /**
     * Gets the value of the workaddr2 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWorkaddr2() {
        return workaddr2;
    }

    /**
     * Sets the value of the workaddr2 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWorkaddr2(String value) {
        this.workaddr2 = value;
    }

    /**
     * Gets the value of the workaddr3 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWorkaddr3() {
        return workaddr3;
    }

    /**
     * Sets the value of the workaddr3 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWorkaddr3(String value) {
        this.workaddr3 = value;
    }

    /**
     * Gets the value of the workcity property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWorkcity() {
        return workcity;
    }

    /**
     * Sets the value of the workcity property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWorkcity(String value) {
        this.workcity = value;
    }

    /**
     * Gets the value of the workpostcode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWorkpostcode() {
        return workpostcode;
    }

    /**
     * Sets the value of the workpostcode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWorkpostcode(String value) {
        this.workpostcode = value;
    }

    /**
     * Gets the value of the workcounty property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWorkcounty() {
        return workcounty;
    }

    /**
     * Sets the value of the workcounty property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWorkcounty(String value) {
        this.workcounty = value;
    }

    /**
     * Gets the value of the workcountry property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWorkcountry() {
        return workcountry;
    }

    /**
     * Sets the value of the workcountry property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWorkcountry(String value) {
        this.workcountry = value;
    }

    /**
     * Gets the value of the worktel property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWorktel() {
        return worktel;
    }

    /**
     * Sets the value of the worktel property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWorktel(String value) {
        this.worktel = value;
    }

    /**
     * Gets the value of the pobox property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPobox() {
        return pobox;
    }

    /**
     * Sets the value of the pobox property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPobox(String value) {
        this.pobox = value;
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
     * Gets the value of the userdata property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUserdata() {
        return userdata;
    }

    /**
     * Sets the value of the userdata property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUserdata(String value) {
        this.userdata = value;
    }

    /**
     * Gets the value of the userdata1 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUserdata1() {
        return userdata1;
    }

    /**
     * Sets the value of the userdata1 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUserdata1(String value) {
        this.userdata1 = value;
    }

    /**
     * Gets the value of the userdata2 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUserdata2() {
        return userdata2;
    }

    /**
     * Sets the value of the userdata2 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUserdata2(String value) {
        this.userdata2 = value;
    }

    /**
     * Gets the value of the userdata3 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUserdata3() {
        return userdata3;
    }

    /**
     * Sets the value of the userdata3 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUserdata3(String value) {
        this.userdata3 = value;
    }

    /**
     * Gets the value of the userdata4 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUserdata4() {
        return userdata4;
    }

    /**
     * Sets the value of the userdata4 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUserdata4(String value) {
        this.userdata4 = value;
    }

    /**
     * Gets the value of the pin property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPin() {
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
    public void setPin(String value) {
        this.pin = value;
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
     * Gets the value of the brncode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBrncode() {
        return brncode;
    }

    /**
     * Sets the value of the brncode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBrncode(String value) {
        this.brncode = value;
    }

    /**
     * Gets the value of the renew property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRenew() {
        return renew;
    }

    /**
     * Sets the value of the renew property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRenew(String value) {
        this.renew = value;
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
     * Gets the value of the denySvc property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDenySvc() {
        return denySvc;
    }

    /**
     * Sets the value of the denySvc property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDenySvc(String value) {
        this.denySvc = value;
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
     * Gets the value of the memo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMemo() {
        return memo;
    }

    /**
     * Sets the value of the memo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMemo(String value) {
        this.memo = value;
    }

    /**
     * Gets the value of the memoScope property.
     * 
     */
    public int getMemoScope() {
        return memoScope;
    }

    /**
     * Sets the value of the memoScope property.
     * 
     */
    public void setMemoScope(int value) {
        this.memoScope = value;
    }

    /**
     * Gets the value of the memoUser property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMemoUser() {
        return memoUser;
    }

    /**
     * Sets the value of the memoUser property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMemoUser(String value) {
        this.memoUser = value;
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
     * Gets the value of the dlvfirstName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDlvfirstName() {
        return dlvfirstName;
    }

    /**
     * Sets the value of the dlvfirstName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDlvfirstName(String value) {
        this.dlvfirstName = value;
    }

    /**
     * Gets the value of the dlvlastName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDlvlastName() {
        return dlvlastName;
    }

    /**
     * Sets the value of the dlvlastName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDlvlastName(String value) {
        this.dlvlastName = value;
    }

    /**
     * Gets the value of the dlvaddr1 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDlvaddr1() {
        return dlvaddr1;
    }

    /**
     * Sets the value of the dlvaddr1 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDlvaddr1(String value) {
        this.dlvaddr1 = value;
    }

    /**
     * Gets the value of the dlvaddr2 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDlvaddr2() {
        return dlvaddr2;
    }

    /**
     * Sets the value of the dlvaddr2 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDlvaddr2(String value) {
        this.dlvaddr2 = value;
    }

    /**
     * Gets the value of the dlvaddr3 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDlvaddr3() {
        return dlvaddr3;
    }

    /**
     * Sets the value of the dlvaddr3 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDlvaddr3(String value) {
        this.dlvaddr3 = value;
    }

    /**
     * Gets the value of the dlvcity property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDlvcity() {
        return dlvcity;
    }

    /**
     * Sets the value of the dlvcity property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDlvcity(String value) {
        this.dlvcity = value;
    }

    /**
     * Gets the value of the dlvpostcode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDlvpostcode() {
        return dlvpostcode;
    }

    /**
     * Sets the value of the dlvpostcode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDlvpostcode(String value) {
        this.dlvpostcode = value;
    }

    /**
     * Gets the value of the dlvcounty property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDlvcounty() {
        return dlvcounty;
    }

    /**
     * Sets the value of the dlvcounty property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDlvcounty(String value) {
        this.dlvcounty = value;
    }

    /**
     * Gets the value of the dlvcountry property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDlvcountry() {
        return dlvcountry;
    }

    /**
     * Sets the value of the dlvcountry property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDlvcountry(String value) {
        this.dlvcountry = value;
    }

    /**
     * Gets the value of the dlvtel property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDlvtel() {
        return dlvtel;
    }

    /**
     * Sets the value of the dlvtel property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDlvtel(String value) {
        this.dlvtel = value;
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
     * Gets the value of the dlvDaysValid property.
     * 
     */
    public int getDlvDaysValid() {
        return dlvDaysValid;
    }

    /**
     * Sets the value of the dlvDaysValid property.
     * 
     */
    public void setDlvDaysValid(int value) {
        this.dlvDaysValid = value;
    }

    /**
     * Gets the value of the crdprogram property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCrdprogram() {
        return crdprogram;
    }

    /**
     * Sets the value of the crdprogram property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCrdprogram(String value) {
        this.crdprogram = value;
    }

    /**
     * Gets the value of the crddesign property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCrddesign() {
        return crddesign;
    }

    /**
     * Sets the value of the crddesign property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCrddesign(String value) {
        this.crddesign = value;
    }

    /**
     * Gets the value of the feeTier property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFeeTier() {
        return feeTier;
    }

    /**
     * Sets the value of the feeTier property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFeeTier(String value) {
        this.feeTier = value;
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
     * Gets the value of the fundcrdPAN property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFundcrdPAN() {
        return fundcrdPAN;
    }

    /**
     * Sets the value of the fundcrdPAN property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFundcrdPAN(String value) {
        this.fundcrdPAN = value;
    }

    /**
     * Gets the value of the fundCrdEffDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFundCrdEffDate() {
        return fundCrdEffDate;
    }

    /**
     * Sets the value of the fundCrdEffDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFundCrdEffDate(String value) {
        this.fundCrdEffDate = value;
    }

    /**
     * Gets the value of the fundCrdExpDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFundCrdExpDate() {
        return fundCrdExpDate;
    }

    /**
     * Sets the value of the fundCrdExpDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFundCrdExpDate(String value) {
        this.fundCrdExpDate = value;
    }

    /**
     * Gets the value of the fundCrdType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFundCrdType() {
        return fundCrdType;
    }

    /**
     * Sets the value of the fundCrdType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFundCrdType(String value) {
        this.fundCrdType = value;
    }

    /**
     * Gets the value of the fundCrdIssNum property.
     * 
     */
    public int getFundCrdIssNum() {
        return fundCrdIssNum;
    }

    /**
     * Sets the value of the fundCrdIssNum property.
     * 
     */
    public void setFundCrdIssNum(int value) {
        this.fundCrdIssNum = value;
    }

    /**
     * Gets the value of the fundCrdCVC property.
     * 
     */
    public int getFundCrdCVC() {
        return fundCrdCVC;
    }

    /**
     * Sets the value of the fundCrdCVC property.
     * 
     */
    public void setFundCrdCVC(int value) {
        this.fundCrdCVC = value;
    }

    /**
     * Gets the value of the svcSrc property.
     * 
     */
    public int getSvcSrc() {
        return svcSrc;
    }

    /**
     * Sets the value of the svcSrc property.
     * 
     */
    public void setSvcSrc(int value) {
        this.svcSrc = value;
    }

    /**
     * Gets the value of the svcType property.
     * 
     */
    public int getSvcType() {
        return svcType;
    }

    /**
     * Sets the value of the svcType property.
     * 
     */
    public void setSvcType(int value) {
        this.svcType = value;
    }

    /**
     * Gets the value of the svcStatus property.
     * 
     */
    public int getSvcStatus() {
        return svcStatus;
    }

    /**
     * Sets the value of the svcStatus property.
     * 
     */
    public void setSvcStatus(int value) {
        this.svcStatus = value;
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
     * Gets the value of the smsBalance property.
     * 
     */
    public int getSmsBalance() {
        return smsBalance;
    }

    /**
     * Sets the value of the smsBalance property.
     * 
     */
    public void setSmsBalance(int value) {
        this.smsBalance = value;
    }

}
