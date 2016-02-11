
package org.datacontract.schemas._2004._07.neuromancerlibrary_datacontracts;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import org.datacontract.schemas._2004._07.databaselibrary.IDCheckUKDeltaFoundTypeEnum;
import org.datacontract.schemas._2004._07.databaselibrary.IDCheckUKDeltaMatchTypeEnum;


/**
 * <p>Java class for IDCheckUKDeltaResult complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="IDCheckUKDeltaResult">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Address" type="{http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts.IDCheckUKDelta}IDCheckUKDeltaAddress" minOccurs="0"/>
 *         &lt;element name="CCJ" type="{http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts.IDCheckUKDelta}ArrayOfIDCheckUKDeltaCCJ" minOccurs="0"/>
 *         &lt;element name="CCJResultTypeEnum" type="{http://schemas.datacontract.org/2004/07/DatabaseLibrary.Enums}IDCheckUKDeltaFoundTypeEnum" minOccurs="0"/>
 *         &lt;element name="CompanyDirector" type="{http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts.IDCheckUKDelta}ArrayOfIDCheckUKDeltaCompanyDirector" minOccurs="0"/>
 *         &lt;element name="DateOfBirth" type="{http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts.IDCheckUKDelta}IDCheckUKDeltaDateOfBirth" minOccurs="0"/>
 *         &lt;element name="DateOfBirthResultTypeEnum" type="{http://schemas.datacontract.org/2004/07/DatabaseLibrary.Enums}IDCheckUKDeltaMatchTypeEnum" minOccurs="0"/>
 *         &lt;element name="DrivingLicence" type="{http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts.IDCheckUKDelta}IDCheckUKDeltaDrivingLicence" minOccurs="0"/>
 *         &lt;element name="DrivingLicenceResultTypeEnum" type="{http://schemas.datacontract.org/2004/07/DatabaseLibrary.Enums}IDCheckUKDeltaMatchTypeEnum" minOccurs="0"/>
 *         &lt;element name="ElectoralRoll" type="{http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts.IDCheckUKDelta}IDCheckUKDeltaElectoralRoll" minOccurs="0"/>
 *         &lt;element name="ElectoralRollResultTypeEnum" type="{http://schemas.datacontract.org/2004/07/DatabaseLibrary.Enums}IDCheckUKDeltaMatchTypeEnum" minOccurs="0"/>
 *         &lt;element name="IDCard" type="{http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts.IDCheckUKDelta}IDCheckUKDeltaIDCard" minOccurs="0"/>
 *         &lt;element name="IdCardResultTypeEnum" type="{http://schemas.datacontract.org/2004/07/DatabaseLibrary.Enums}IDCheckUKDeltaMatchTypeEnum" minOccurs="0"/>
 *         &lt;element name="Insolvency" type="{http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts.IDCheckUKDelta}ArrayOfIDCheckUKDeltaInsolvency" minOccurs="0"/>
 *         &lt;element name="Mobile" type="{http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts.IDCheckUKDelta}IDCheckUKDeltaMobile" minOccurs="0"/>
 *         &lt;element name="MobileResultTypeEnum" type="{http://schemas.datacontract.org/2004/07/DatabaseLibrary.Enums}IDCheckUKDeltaMatchTypeEnum" minOccurs="0"/>
 *         &lt;element name="Mortality" type="{http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts.IDCheckUKDelta}ArrayOfIDCheckUKDeltaMortality" minOccurs="0"/>
 *         &lt;element name="MortalityResultTypeEnum" type="{http://schemas.datacontract.org/2004/07/DatabaseLibrary.Enums}IDCheckUKDeltaFoundTypeEnum" minOccurs="0"/>
 *         &lt;element name="Passport" type="{http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts.IDCheckUKDelta}IDCheckUKDeltaPassport" minOccurs="0"/>
 *         &lt;element name="PassportResultTypeEnum" type="{http://schemas.datacontract.org/2004/07/DatabaseLibrary.Enums}IDCheckUKDeltaMatchTypeEnum" minOccurs="0"/>
 *         &lt;element name="Smartlink" type="{http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts.IDCheckUKDelta}ArrayOfIDCheckUKDeltaSmartlink" minOccurs="0"/>
 *         &lt;element name="Summary" type="{http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts.IDCheckUKDelta}IDCheckUKDeltaSummary" minOccurs="0"/>
 *         &lt;element name="Telephone" type="{http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts.IDCheckUKDelta}IDCheckUKDeltaTelephone" minOccurs="0"/>
 *         &lt;element name="TelephoneResultTypeEnum" type="{http://schemas.datacontract.org/2004/07/DatabaseLibrary.Enums}IDCheckUKDeltaMatchTypeEnum" minOccurs="0"/>
 *         &lt;element name="TravelVisa" type="{http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts.IDCheckUKDelta}IDCheckUKDeltaTravelVisa" minOccurs="0"/>
 *         &lt;element name="TravelVisaResultTypeEnum" type="{http://schemas.datacontract.org/2004/07/DatabaseLibrary.Enums}IDCheckUKDeltaMatchTypeEnum" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "IDCheckUKDeltaResult", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts.IDCheckUKDelta", propOrder = {
    "address",
    "ccj",
    "ccjResultTypeEnum",
    "companyDirector",
    "dateOfBirth",
    "dateOfBirthResultTypeEnum",
    "drivingLicence",
    "drivingLicenceResultTypeEnum",
    "electoralRoll",
    "electoralRollResultTypeEnum",
    "idCard",
    "idCardResultTypeEnum",
    "insolvency",
    "mobile",
    "mobileResultTypeEnum",
    "mortality",
    "mortalityResultTypeEnum",
    "passport",
    "passportResultTypeEnum",
    "smartlink",
    "summary",
    "telephone",
    "telephoneResultTypeEnum",
    "travelVisa",
    "travelVisaResultTypeEnum"
})
public class IDCheckUKDeltaResult {

    @XmlElementRef(name = "Address", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts.IDCheckUKDelta", type = JAXBElement.class, required = false)
    protected JAXBElement<IDCheckUKDeltaAddress> address;
    @XmlElementRef(name = "CCJ", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts.IDCheckUKDelta", type = JAXBElement.class, required = false)
    protected JAXBElement<ArrayOfIDCheckUKDeltaCCJ> ccj;
    @XmlElement(name = "CCJResultTypeEnum")
    @XmlSchemaType(name = "string")
    protected IDCheckUKDeltaFoundTypeEnum ccjResultTypeEnum;
    @XmlElementRef(name = "CompanyDirector", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts.IDCheckUKDelta", type = JAXBElement.class, required = false)
    protected JAXBElement<ArrayOfIDCheckUKDeltaCompanyDirector> companyDirector;
    @XmlElementRef(name = "DateOfBirth", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts.IDCheckUKDelta", type = JAXBElement.class, required = false)
    protected JAXBElement<IDCheckUKDeltaDateOfBirth> dateOfBirth;
    @XmlElement(name = "DateOfBirthResultTypeEnum")
    @XmlSchemaType(name = "string")
    protected IDCheckUKDeltaMatchTypeEnum dateOfBirthResultTypeEnum;
    @XmlElementRef(name = "DrivingLicence", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts.IDCheckUKDelta", type = JAXBElement.class, required = false)
    protected JAXBElement<IDCheckUKDeltaDrivingLicence> drivingLicence;
    @XmlElement(name = "DrivingLicenceResultTypeEnum")
    @XmlSchemaType(name = "string")
    protected IDCheckUKDeltaMatchTypeEnum drivingLicenceResultTypeEnum;
    @XmlElementRef(name = "ElectoralRoll", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts.IDCheckUKDelta", type = JAXBElement.class, required = false)
    protected JAXBElement<IDCheckUKDeltaElectoralRoll> electoralRoll;
    @XmlElement(name = "ElectoralRollResultTypeEnum")
    @XmlSchemaType(name = "string")
    protected IDCheckUKDeltaMatchTypeEnum electoralRollResultTypeEnum;
    @XmlElementRef(name = "IDCard", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts.IDCheckUKDelta", type = JAXBElement.class, required = false)
    protected JAXBElement<IDCheckUKDeltaIDCard> idCard;
    @XmlElement(name = "IdCardResultTypeEnum")
    @XmlSchemaType(name = "string")
    protected IDCheckUKDeltaMatchTypeEnum idCardResultTypeEnum;
    @XmlElementRef(name = "Insolvency", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts.IDCheckUKDelta", type = JAXBElement.class, required = false)
    protected JAXBElement<ArrayOfIDCheckUKDeltaInsolvency> insolvency;
    @XmlElementRef(name = "Mobile", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts.IDCheckUKDelta", type = JAXBElement.class, required = false)
    protected JAXBElement<IDCheckUKDeltaMobile> mobile;
    @XmlElement(name = "MobileResultTypeEnum")
    @XmlSchemaType(name = "string")
    protected IDCheckUKDeltaMatchTypeEnum mobileResultTypeEnum;
    @XmlElementRef(name = "Mortality", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts.IDCheckUKDelta", type = JAXBElement.class, required = false)
    protected JAXBElement<ArrayOfIDCheckUKDeltaMortality> mortality;
    @XmlElement(name = "MortalityResultTypeEnum")
    @XmlSchemaType(name = "string")
    protected IDCheckUKDeltaFoundTypeEnum mortalityResultTypeEnum;
    @XmlElementRef(name = "Passport", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts.IDCheckUKDelta", type = JAXBElement.class, required = false)
    protected JAXBElement<IDCheckUKDeltaPassport> passport;
    @XmlElement(name = "PassportResultTypeEnum")
    @XmlSchemaType(name = "string")
    protected IDCheckUKDeltaMatchTypeEnum passportResultTypeEnum;
    @XmlElementRef(name = "Smartlink", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts.IDCheckUKDelta", type = JAXBElement.class, required = false)
    protected JAXBElement<ArrayOfIDCheckUKDeltaSmartlink> smartlink;
    @XmlElementRef(name = "Summary", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts.IDCheckUKDelta", type = JAXBElement.class, required = false)
    protected JAXBElement<IDCheckUKDeltaSummary> summary;
    @XmlElementRef(name = "Telephone", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts.IDCheckUKDelta", type = JAXBElement.class, required = false)
    protected JAXBElement<IDCheckUKDeltaTelephone> telephone;
    @XmlElement(name = "TelephoneResultTypeEnum")
    @XmlSchemaType(name = "string")
    protected IDCheckUKDeltaMatchTypeEnum telephoneResultTypeEnum;
    @XmlElementRef(name = "TravelVisa", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts.IDCheckUKDelta", type = JAXBElement.class, required = false)
    protected JAXBElement<IDCheckUKDeltaTravelVisa> travelVisa;
    @XmlElement(name = "TravelVisaResultTypeEnum")
    @XmlSchemaType(name = "string")
    protected IDCheckUKDeltaMatchTypeEnum travelVisaResultTypeEnum;

    /**
     * Gets the value of the address property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link IDCheckUKDeltaAddress }{@code >}
     *     
     */
    public JAXBElement<IDCheckUKDeltaAddress> getAddress() {
        return address;
    }

    /**
     * Sets the value of the address property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link IDCheckUKDeltaAddress }{@code >}
     *     
     */
    public void setAddress(JAXBElement<IDCheckUKDeltaAddress> value) {
        this.address = value;
    }

    /**
     * Gets the value of the ccj property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfIDCheckUKDeltaCCJ }{@code >}
     *     
     */
    public JAXBElement<ArrayOfIDCheckUKDeltaCCJ> getCCJ() {
        return ccj;
    }

    /**
     * Sets the value of the ccj property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfIDCheckUKDeltaCCJ }{@code >}
     *     
     */
    public void setCCJ(JAXBElement<ArrayOfIDCheckUKDeltaCCJ> value) {
        this.ccj = value;
    }

    /**
     * Gets the value of the ccjResultTypeEnum property.
     * 
     * @return
     *     possible object is
     *     {@link IDCheckUKDeltaFoundTypeEnum }
     *     
     */
    public IDCheckUKDeltaFoundTypeEnum getCCJResultTypeEnum() {
        return ccjResultTypeEnum;
    }

    /**
     * Sets the value of the ccjResultTypeEnum property.
     * 
     * @param value
     *     allowed object is
     *     {@link IDCheckUKDeltaFoundTypeEnum }
     *     
     */
    public void setCCJResultTypeEnum(IDCheckUKDeltaFoundTypeEnum value) {
        this.ccjResultTypeEnum = value;
    }

    /**
     * Gets the value of the companyDirector property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfIDCheckUKDeltaCompanyDirector }{@code >}
     *     
     */
    public JAXBElement<ArrayOfIDCheckUKDeltaCompanyDirector> getCompanyDirector() {
        return companyDirector;
    }

    /**
     * Sets the value of the companyDirector property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfIDCheckUKDeltaCompanyDirector }{@code >}
     *     
     */
    public void setCompanyDirector(JAXBElement<ArrayOfIDCheckUKDeltaCompanyDirector> value) {
        this.companyDirector = value;
    }

    /**
     * Gets the value of the dateOfBirth property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link IDCheckUKDeltaDateOfBirth }{@code >}
     *     
     */
    public JAXBElement<IDCheckUKDeltaDateOfBirth> getDateOfBirth() {
        return dateOfBirth;
    }

    /**
     * Sets the value of the dateOfBirth property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link IDCheckUKDeltaDateOfBirth }{@code >}
     *     
     */
    public void setDateOfBirth(JAXBElement<IDCheckUKDeltaDateOfBirth> value) {
        this.dateOfBirth = value;
    }

    /**
     * Gets the value of the dateOfBirthResultTypeEnum property.
     * 
     * @return
     *     possible object is
     *     {@link IDCheckUKDeltaMatchTypeEnum }
     *     
     */
    public IDCheckUKDeltaMatchTypeEnum getDateOfBirthResultTypeEnum() {
        return dateOfBirthResultTypeEnum;
    }

    /**
     * Sets the value of the dateOfBirthResultTypeEnum property.
     * 
     * @param value
     *     allowed object is
     *     {@link IDCheckUKDeltaMatchTypeEnum }
     *     
     */
    public void setDateOfBirthResultTypeEnum(IDCheckUKDeltaMatchTypeEnum value) {
        this.dateOfBirthResultTypeEnum = value;
    }

    /**
     * Gets the value of the drivingLicence property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link IDCheckUKDeltaDrivingLicence }{@code >}
     *     
     */
    public JAXBElement<IDCheckUKDeltaDrivingLicence> getDrivingLicence() {
        return drivingLicence;
    }

    /**
     * Sets the value of the drivingLicence property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link IDCheckUKDeltaDrivingLicence }{@code >}
     *     
     */
    public void setDrivingLicence(JAXBElement<IDCheckUKDeltaDrivingLicence> value) {
        this.drivingLicence = value;
    }

    /**
     * Gets the value of the drivingLicenceResultTypeEnum property.
     * 
     * @return
     *     possible object is
     *     {@link IDCheckUKDeltaMatchTypeEnum }
     *     
     */
    public IDCheckUKDeltaMatchTypeEnum getDrivingLicenceResultTypeEnum() {
        return drivingLicenceResultTypeEnum;
    }

    /**
     * Sets the value of the drivingLicenceResultTypeEnum property.
     * 
     * @param value
     *     allowed object is
     *     {@link IDCheckUKDeltaMatchTypeEnum }
     *     
     */
    public void setDrivingLicenceResultTypeEnum(IDCheckUKDeltaMatchTypeEnum value) {
        this.drivingLicenceResultTypeEnum = value;
    }

    /**
     * Gets the value of the electoralRoll property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link IDCheckUKDeltaElectoralRoll }{@code >}
     *     
     */
    public JAXBElement<IDCheckUKDeltaElectoralRoll> getElectoralRoll() {
        return electoralRoll;
    }

    /**
     * Sets the value of the electoralRoll property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link IDCheckUKDeltaElectoralRoll }{@code >}
     *     
     */
    public void setElectoralRoll(JAXBElement<IDCheckUKDeltaElectoralRoll> value) {
        this.electoralRoll = value;
    }

    /**
     * Gets the value of the electoralRollResultTypeEnum property.
     * 
     * @return
     *     possible object is
     *     {@link IDCheckUKDeltaMatchTypeEnum }
     *     
     */
    public IDCheckUKDeltaMatchTypeEnum getElectoralRollResultTypeEnum() {
        return electoralRollResultTypeEnum;
    }

    /**
     * Sets the value of the electoralRollResultTypeEnum property.
     * 
     * @param value
     *     allowed object is
     *     {@link IDCheckUKDeltaMatchTypeEnum }
     *     
     */
    public void setElectoralRollResultTypeEnum(IDCheckUKDeltaMatchTypeEnum value) {
        this.electoralRollResultTypeEnum = value;
    }

    /**
     * Gets the value of the idCard property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link IDCheckUKDeltaIDCard }{@code >}
     *     
     */
    public JAXBElement<IDCheckUKDeltaIDCard> getIDCard() {
        return idCard;
    }

    /**
     * Sets the value of the idCard property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link IDCheckUKDeltaIDCard }{@code >}
     *     
     */
    public void setIDCard(JAXBElement<IDCheckUKDeltaIDCard> value) {
        this.idCard = value;
    }

    /**
     * Gets the value of the idCardResultTypeEnum property.
     * 
     * @return
     *     possible object is
     *     {@link IDCheckUKDeltaMatchTypeEnum }
     *     
     */
    public IDCheckUKDeltaMatchTypeEnum getIdCardResultTypeEnum() {
        return idCardResultTypeEnum;
    }

    /**
     * Sets the value of the idCardResultTypeEnum property.
     * 
     * @param value
     *     allowed object is
     *     {@link IDCheckUKDeltaMatchTypeEnum }
     *     
     */
    public void setIdCardResultTypeEnum(IDCheckUKDeltaMatchTypeEnum value) {
        this.idCardResultTypeEnum = value;
    }

    /**
     * Gets the value of the insolvency property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfIDCheckUKDeltaInsolvency }{@code >}
     *     
     */
    public JAXBElement<ArrayOfIDCheckUKDeltaInsolvency> getInsolvency() {
        return insolvency;
    }

    /**
     * Sets the value of the insolvency property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfIDCheckUKDeltaInsolvency }{@code >}
     *     
     */
    public void setInsolvency(JAXBElement<ArrayOfIDCheckUKDeltaInsolvency> value) {
        this.insolvency = value;
    }

    /**
     * Gets the value of the mobile property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link IDCheckUKDeltaMobile }{@code >}
     *     
     */
    public JAXBElement<IDCheckUKDeltaMobile> getMobile() {
        return mobile;
    }

    /**
     * Sets the value of the mobile property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link IDCheckUKDeltaMobile }{@code >}
     *     
     */
    public void setMobile(JAXBElement<IDCheckUKDeltaMobile> value) {
        this.mobile = value;
    }

    /**
     * Gets the value of the mobileResultTypeEnum property.
     * 
     * @return
     *     possible object is
     *     {@link IDCheckUKDeltaMatchTypeEnum }
     *     
     */
    public IDCheckUKDeltaMatchTypeEnum getMobileResultTypeEnum() {
        return mobileResultTypeEnum;
    }

    /**
     * Sets the value of the mobileResultTypeEnum property.
     * 
     * @param value
     *     allowed object is
     *     {@link IDCheckUKDeltaMatchTypeEnum }
     *     
     */
    public void setMobileResultTypeEnum(IDCheckUKDeltaMatchTypeEnum value) {
        this.mobileResultTypeEnum = value;
    }

    /**
     * Gets the value of the mortality property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfIDCheckUKDeltaMortality }{@code >}
     *     
     */
    public JAXBElement<ArrayOfIDCheckUKDeltaMortality> getMortality() {
        return mortality;
    }

    /**
     * Sets the value of the mortality property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfIDCheckUKDeltaMortality }{@code >}
     *     
     */
    public void setMortality(JAXBElement<ArrayOfIDCheckUKDeltaMortality> value) {
        this.mortality = value;
    }

    /**
     * Gets the value of the mortalityResultTypeEnum property.
     * 
     * @return
     *     possible object is
     *     {@link IDCheckUKDeltaFoundTypeEnum }
     *     
     */
    public IDCheckUKDeltaFoundTypeEnum getMortalityResultTypeEnum() {
        return mortalityResultTypeEnum;
    }

    /**
     * Sets the value of the mortalityResultTypeEnum property.
     * 
     * @param value
     *     allowed object is
     *     {@link IDCheckUKDeltaFoundTypeEnum }
     *     
     */
    public void setMortalityResultTypeEnum(IDCheckUKDeltaFoundTypeEnum value) {
        this.mortalityResultTypeEnum = value;
    }

    /**
     * Gets the value of the passport property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link IDCheckUKDeltaPassport }{@code >}
     *     
     */
    public JAXBElement<IDCheckUKDeltaPassport> getPassport() {
        return passport;
    }

    /**
     * Sets the value of the passport property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link IDCheckUKDeltaPassport }{@code >}
     *     
     */
    public void setPassport(JAXBElement<IDCheckUKDeltaPassport> value) {
        this.passport = value;
    }

    /**
     * Gets the value of the passportResultTypeEnum property.
     * 
     * @return
     *     possible object is
     *     {@link IDCheckUKDeltaMatchTypeEnum }
     *     
     */
    public IDCheckUKDeltaMatchTypeEnum getPassportResultTypeEnum() {
        return passportResultTypeEnum;
    }

    /**
     * Sets the value of the passportResultTypeEnum property.
     * 
     * @param value
     *     allowed object is
     *     {@link IDCheckUKDeltaMatchTypeEnum }
     *     
     */
    public void setPassportResultTypeEnum(IDCheckUKDeltaMatchTypeEnum value) {
        this.passportResultTypeEnum = value;
    }

    /**
     * Gets the value of the smartlink property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfIDCheckUKDeltaSmartlink }{@code >}
     *     
     */
    public JAXBElement<ArrayOfIDCheckUKDeltaSmartlink> getSmartlink() {
        return smartlink;
    }

    /**
     * Sets the value of the smartlink property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfIDCheckUKDeltaSmartlink }{@code >}
     *     
     */
    public void setSmartlink(JAXBElement<ArrayOfIDCheckUKDeltaSmartlink> value) {
        this.smartlink = value;
    }

    /**
     * Gets the value of the summary property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link IDCheckUKDeltaSummary }{@code >}
     *     
     */
    public JAXBElement<IDCheckUKDeltaSummary> getSummary() {
        return summary;
    }

    /**
     * Sets the value of the summary property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link IDCheckUKDeltaSummary }{@code >}
     *     
     */
    public void setSummary(JAXBElement<IDCheckUKDeltaSummary> value) {
        this.summary = value;
    }

    /**
     * Gets the value of the telephone property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link IDCheckUKDeltaTelephone }{@code >}
     *     
     */
    public JAXBElement<IDCheckUKDeltaTelephone> getTelephone() {
        return telephone;
    }

    /**
     * Sets the value of the telephone property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link IDCheckUKDeltaTelephone }{@code >}
     *     
     */
    public void setTelephone(JAXBElement<IDCheckUKDeltaTelephone> value) {
        this.telephone = value;
    }

    /**
     * Gets the value of the telephoneResultTypeEnum property.
     * 
     * @return
     *     possible object is
     *     {@link IDCheckUKDeltaMatchTypeEnum }
     *     
     */
    public IDCheckUKDeltaMatchTypeEnum getTelephoneResultTypeEnum() {
        return telephoneResultTypeEnum;
    }

    /**
     * Sets the value of the telephoneResultTypeEnum property.
     * 
     * @param value
     *     allowed object is
     *     {@link IDCheckUKDeltaMatchTypeEnum }
     *     
     */
    public void setTelephoneResultTypeEnum(IDCheckUKDeltaMatchTypeEnum value) {
        this.telephoneResultTypeEnum = value;
    }

    /**
     * Gets the value of the travelVisa property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link IDCheckUKDeltaTravelVisa }{@code >}
     *     
     */
    public JAXBElement<IDCheckUKDeltaTravelVisa> getTravelVisa() {
        return travelVisa;
    }

    /**
     * Sets the value of the travelVisa property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link IDCheckUKDeltaTravelVisa }{@code >}
     *     
     */
    public void setTravelVisa(JAXBElement<IDCheckUKDeltaTravelVisa> value) {
        this.travelVisa = value;
    }

    /**
     * Gets the value of the travelVisaResultTypeEnum property.
     * 
     * @return
     *     possible object is
     *     {@link IDCheckUKDeltaMatchTypeEnum }
     *     
     */
    public IDCheckUKDeltaMatchTypeEnum getTravelVisaResultTypeEnum() {
        return travelVisaResultTypeEnum;
    }

    /**
     * Sets the value of the travelVisaResultTypeEnum property.
     * 
     * @param value
     *     allowed object is
     *     {@link IDCheckUKDeltaMatchTypeEnum }
     *     
     */
    public void setTravelVisaResultTypeEnum(IDCheckUKDeltaMatchTypeEnum value) {
        this.travelVisaResultTypeEnum = value;
    }

}
