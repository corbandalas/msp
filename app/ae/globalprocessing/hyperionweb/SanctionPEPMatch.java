
package ae.globalprocessing.hyperionweb;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for SanctionPEPMatch complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SanctionPEPMatch">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="WSID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="Firstname" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Lastname" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Nationality" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="DOB" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PostCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Address" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ListType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="RecordID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ReportedDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="LoggedDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="MatchFlag" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="PublicToken" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Flag" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="Comment" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Id" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="CardHolder" type="{http://www.globalprocessing.ae/HyperionWeb}CardHolder"/>
 *         &lt;element name="CardPurchaser" type="{http://www.globalprocessing.ae/HyperionWeb}CardHolder"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SanctionPEPMatch", propOrder = {
    "wsid",
    "firstname",
    "lastname",
    "nationality",
    "dob",
    "postCode",
    "address",
    "listType",
    "recordID",
    "reportedDate",
    "loggedDate",
    "matchFlag",
    "publicToken",
    "flag",
    "comment",
    "id",
    "cardHolder",
    "cardPurchaser"
})
public class SanctionPEPMatch {

    @XmlElement(name = "WSID")
    protected long wsid;
    @XmlElement(name = "Firstname")
    protected String firstname;
    @XmlElement(name = "Lastname")
    protected String lastname;
    @XmlElement(name = "Nationality")
    protected String nationality;
    @XmlElement(name = "DOB")
    protected String dob;
    @XmlElement(name = "PostCode")
    protected String postCode;
    @XmlElement(name = "Address")
    protected String address;
    @XmlElement(name = "ListType")
    protected String listType;
    @XmlElement(name = "RecordID")
    protected String recordID;
    @XmlElement(name = "ReportedDate")
    protected String reportedDate;
    @XmlElement(name = "LoggedDate")
    protected String loggedDate;
    @XmlElement(name = "MatchFlag")
    protected boolean matchFlag;
    @XmlElement(name = "PublicToken")
    protected String publicToken;
    @XmlElement(name = "Flag")
    protected int flag;
    @XmlElement(name = "Comment")
    protected String comment;
    @XmlElement(name = "Id")
    protected int id;
    @XmlElement(name = "CardHolder", required = true)
    protected CardHolder cardHolder;
    @XmlElement(name = "CardPurchaser", required = true)
    protected CardHolder cardPurchaser;

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
     * Gets the value of the firstname property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFirstname() {
        return firstname;
    }

    /**
     * Sets the value of the firstname property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFirstname(String value) {
        this.firstname = value;
    }

    /**
     * Gets the value of the lastname property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLastname() {
        return lastname;
    }

    /**
     * Sets the value of the lastname property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLastname(String value) {
        this.lastname = value;
    }

    /**
     * Gets the value of the nationality property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNationality() {
        return nationality;
    }

    /**
     * Sets the value of the nationality property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNationality(String value) {
        this.nationality = value;
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
     * Gets the value of the address property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAddress() {
        return address;
    }

    /**
     * Sets the value of the address property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAddress(String value) {
        this.address = value;
    }

    /**
     * Gets the value of the listType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getListType() {
        return listType;
    }

    /**
     * Sets the value of the listType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setListType(String value) {
        this.listType = value;
    }

    /**
     * Gets the value of the recordID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRecordID() {
        return recordID;
    }

    /**
     * Sets the value of the recordID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRecordID(String value) {
        this.recordID = value;
    }

    /**
     * Gets the value of the reportedDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReportedDate() {
        return reportedDate;
    }

    /**
     * Sets the value of the reportedDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReportedDate(String value) {
        this.reportedDate = value;
    }

    /**
     * Gets the value of the loggedDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLoggedDate() {
        return loggedDate;
    }

    /**
     * Sets the value of the loggedDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLoggedDate(String value) {
        this.loggedDate = value;
    }

    /**
     * Gets the value of the matchFlag property.
     * 
     */
    public boolean isMatchFlag() {
        return matchFlag;
    }

    /**
     * Sets the value of the matchFlag property.
     * 
     */
    public void setMatchFlag(boolean value) {
        this.matchFlag = value;
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
     * Gets the value of the flag property.
     * 
     */
    public int getFlag() {
        return flag;
    }

    /**
     * Sets the value of the flag property.
     * 
     */
    public void setFlag(int value) {
        this.flag = value;
    }

    /**
     * Gets the value of the comment property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getComment() {
        return comment;
    }

    /**
     * Sets the value of the comment property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setComment(String value) {
        this.comment = value;
    }

    /**
     * Gets the value of the id property.
     * 
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     */
    public void setId(int value) {
        this.id = value;
    }

    /**
     * Gets the value of the cardHolder property.
     * 
     * @return
     *     possible object is
     *     {@link CardHolder }
     *     
     */
    public CardHolder getCardHolder() {
        return cardHolder;
    }

    /**
     * Sets the value of the cardHolder property.
     * 
     * @param value
     *     allowed object is
     *     {@link CardHolder }
     *     
     */
    public void setCardHolder(CardHolder value) {
        this.cardHolder = value;
    }

    /**
     * Gets the value of the cardPurchaser property.
     * 
     * @return
     *     possible object is
     *     {@link CardHolder }
     *     
     */
    public CardHolder getCardPurchaser() {
        return cardPurchaser;
    }

    /**
     * Sets the value of the cardPurchaser property.
     * 
     * @param value
     *     allowed object is
     *     {@link CardHolder }
     *     
     */
    public void setCardPurchaser(CardHolder value) {
        this.cardPurchaser = value;
    }

}
