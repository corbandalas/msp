
package org.datacontract.schemas._2004._07.neuromancerlibrary_xmlserialization_idcheckglobalalpha_response;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for CreditReferenceSummary complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CreditReferenceSummary">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="BOEMatch" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CIFASMaHighRiskAddressMatchtch" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CIFASMatch" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="COAMatch" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CommercialEntitiesAtAddressMatch" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CreditReferenceDecision" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CreditReferenceScore" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="DFATMatch" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="DateOfBirthMatch" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="DeceasedMatch" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="DriverLicenceMatch" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ElectoralRollDateOfBirthMatch" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ElectoralRollMatch" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="GoneAwayMatch" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="HighRiskAddressMatch" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="IDVerified" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="NoOfCCJ" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="NoOfCommercialEntitiesAtAddress" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="NoOfOpenAccountsLenders" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="OFACMatch" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="OpenAccountsMatch" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PEPMatch" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PassportMatch" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PhoneNumberMatch" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="TelephoneDirectoryMatch" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="TotalNumberOfVerifications" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CreditReferenceSummary", propOrder = {
    "boeMatch",
    "cifasMaHighRiskAddressMatchtch",
    "cifasMatch",
    "coaMatch",
    "commercialEntitiesAtAddressMatch",
    "creditReferenceDecision",
    "creditReferenceScore",
    "dfatMatch",
    "dateOfBirthMatch",
    "deceasedMatch",
    "driverLicenceMatch",
    "electoralRollDateOfBirthMatch",
    "electoralRollMatch",
    "goneAwayMatch",
    "highRiskAddressMatch",
    "idVerified",
    "noOfCCJ",
    "noOfCommercialEntitiesAtAddress",
    "noOfOpenAccountsLenders",
    "ofacMatch",
    "openAccountsMatch",
    "pepMatch",
    "passportMatch",
    "phoneNumberMatch",
    "telephoneDirectoryMatch",
    "totalNumberOfVerifications"
})
public class CreditReferenceSummary {

    @XmlElementRef(name = "BOEMatch", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.XmlSerialization.IDCheckGlobalAlpha.Response.CreditReference", type = JAXBElement.class, required = false)
    protected JAXBElement<String> boeMatch;
    @XmlElementRef(name = "CIFASMaHighRiskAddressMatchtch", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.XmlSerialization.IDCheckGlobalAlpha.Response.CreditReference", type = JAXBElement.class, required = false)
    protected JAXBElement<String> cifasMaHighRiskAddressMatchtch;
    @XmlElementRef(name = "CIFASMatch", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.XmlSerialization.IDCheckGlobalAlpha.Response.CreditReference", type = JAXBElement.class, required = false)
    protected JAXBElement<String> cifasMatch;
    @XmlElementRef(name = "COAMatch", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.XmlSerialization.IDCheckGlobalAlpha.Response.CreditReference", type = JAXBElement.class, required = false)
    protected JAXBElement<String> coaMatch;
    @XmlElementRef(name = "CommercialEntitiesAtAddressMatch", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.XmlSerialization.IDCheckGlobalAlpha.Response.CreditReference", type = JAXBElement.class, required = false)
    protected JAXBElement<String> commercialEntitiesAtAddressMatch;
    @XmlElementRef(name = "CreditReferenceDecision", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.XmlSerialization.IDCheckGlobalAlpha.Response.CreditReference", type = JAXBElement.class, required = false)
    protected JAXBElement<String> creditReferenceDecision;
    @XmlElementRef(name = "CreditReferenceScore", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.XmlSerialization.IDCheckGlobalAlpha.Response.CreditReference", type = JAXBElement.class, required = false)
    protected JAXBElement<String> creditReferenceScore;
    @XmlElementRef(name = "DFATMatch", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.XmlSerialization.IDCheckGlobalAlpha.Response.CreditReference", type = JAXBElement.class, required = false)
    protected JAXBElement<String> dfatMatch;
    @XmlElementRef(name = "DateOfBirthMatch", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.XmlSerialization.IDCheckGlobalAlpha.Response.CreditReference", type = JAXBElement.class, required = false)
    protected JAXBElement<String> dateOfBirthMatch;
    @XmlElementRef(name = "DeceasedMatch", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.XmlSerialization.IDCheckGlobalAlpha.Response.CreditReference", type = JAXBElement.class, required = false)
    protected JAXBElement<String> deceasedMatch;
    @XmlElementRef(name = "DriverLicenceMatch", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.XmlSerialization.IDCheckGlobalAlpha.Response.CreditReference", type = JAXBElement.class, required = false)
    protected JAXBElement<String> driverLicenceMatch;
    @XmlElementRef(name = "ElectoralRollDateOfBirthMatch", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.XmlSerialization.IDCheckGlobalAlpha.Response.CreditReference", type = JAXBElement.class, required = false)
    protected JAXBElement<String> electoralRollDateOfBirthMatch;
    @XmlElementRef(name = "ElectoralRollMatch", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.XmlSerialization.IDCheckGlobalAlpha.Response.CreditReference", type = JAXBElement.class, required = false)
    protected JAXBElement<String> electoralRollMatch;
    @XmlElementRef(name = "GoneAwayMatch", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.XmlSerialization.IDCheckGlobalAlpha.Response.CreditReference", type = JAXBElement.class, required = false)
    protected JAXBElement<String> goneAwayMatch;
    @XmlElementRef(name = "HighRiskAddressMatch", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.XmlSerialization.IDCheckGlobalAlpha.Response.CreditReference", type = JAXBElement.class, required = false)
    protected JAXBElement<String> highRiskAddressMatch;
    @XmlElementRef(name = "IDVerified", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.XmlSerialization.IDCheckGlobalAlpha.Response.CreditReference", type = JAXBElement.class, required = false)
    protected JAXBElement<String> idVerified;
    @XmlElementRef(name = "NoOfCCJ", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.XmlSerialization.IDCheckGlobalAlpha.Response.CreditReference", type = JAXBElement.class, required = false)
    protected JAXBElement<String> noOfCCJ;
    @XmlElementRef(name = "NoOfCommercialEntitiesAtAddress", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.XmlSerialization.IDCheckGlobalAlpha.Response.CreditReference", type = JAXBElement.class, required = false)
    protected JAXBElement<String> noOfCommercialEntitiesAtAddress;
    @XmlElementRef(name = "NoOfOpenAccountsLenders", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.XmlSerialization.IDCheckGlobalAlpha.Response.CreditReference", type = JAXBElement.class, required = false)
    protected JAXBElement<String> noOfOpenAccountsLenders;
    @XmlElementRef(name = "OFACMatch", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.XmlSerialization.IDCheckGlobalAlpha.Response.CreditReference", type = JAXBElement.class, required = false)
    protected JAXBElement<String> ofacMatch;
    @XmlElementRef(name = "OpenAccountsMatch", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.XmlSerialization.IDCheckGlobalAlpha.Response.CreditReference", type = JAXBElement.class, required = false)
    protected JAXBElement<String> openAccountsMatch;
    @XmlElementRef(name = "PEPMatch", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.XmlSerialization.IDCheckGlobalAlpha.Response.CreditReference", type = JAXBElement.class, required = false)
    protected JAXBElement<String> pepMatch;
    @XmlElementRef(name = "PassportMatch", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.XmlSerialization.IDCheckGlobalAlpha.Response.CreditReference", type = JAXBElement.class, required = false)
    protected JAXBElement<String> passportMatch;
    @XmlElementRef(name = "PhoneNumberMatch", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.XmlSerialization.IDCheckGlobalAlpha.Response.CreditReference", type = JAXBElement.class, required = false)
    protected JAXBElement<String> phoneNumberMatch;
    @XmlElementRef(name = "TelephoneDirectoryMatch", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.XmlSerialization.IDCheckGlobalAlpha.Response.CreditReference", type = JAXBElement.class, required = false)
    protected JAXBElement<String> telephoneDirectoryMatch;
    @XmlElementRef(name = "TotalNumberOfVerifications", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.XmlSerialization.IDCheckGlobalAlpha.Response.CreditReference", type = JAXBElement.class, required = false)
    protected JAXBElement<String> totalNumberOfVerifications;

    /**
     * Gets the value of the boeMatch property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getBOEMatch() {
        return boeMatch;
    }

    /**
     * Sets the value of the boeMatch property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setBOEMatch(JAXBElement<String> value) {
        this.boeMatch = value;
    }

    /**
     * Gets the value of the cifasMaHighRiskAddressMatchtch property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getCIFASMaHighRiskAddressMatchtch() {
        return cifasMaHighRiskAddressMatchtch;
    }

    /**
     * Sets the value of the cifasMaHighRiskAddressMatchtch property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setCIFASMaHighRiskAddressMatchtch(JAXBElement<String> value) {
        this.cifasMaHighRiskAddressMatchtch = value;
    }

    /**
     * Gets the value of the cifasMatch property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getCIFASMatch() {
        return cifasMatch;
    }

    /**
     * Sets the value of the cifasMatch property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setCIFASMatch(JAXBElement<String> value) {
        this.cifasMatch = value;
    }

    /**
     * Gets the value of the coaMatch property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getCOAMatch() {
        return coaMatch;
    }

    /**
     * Sets the value of the coaMatch property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setCOAMatch(JAXBElement<String> value) {
        this.coaMatch = value;
    }

    /**
     * Gets the value of the commercialEntitiesAtAddressMatch property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getCommercialEntitiesAtAddressMatch() {
        return commercialEntitiesAtAddressMatch;
    }

    /**
     * Sets the value of the commercialEntitiesAtAddressMatch property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setCommercialEntitiesAtAddressMatch(JAXBElement<String> value) {
        this.commercialEntitiesAtAddressMatch = value;
    }

    /**
     * Gets the value of the creditReferenceDecision property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getCreditReferenceDecision() {
        return creditReferenceDecision;
    }

    /**
     * Sets the value of the creditReferenceDecision property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setCreditReferenceDecision(JAXBElement<String> value) {
        this.creditReferenceDecision = value;
    }

    /**
     * Gets the value of the creditReferenceScore property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getCreditReferenceScore() {
        return creditReferenceScore;
    }

    /**
     * Sets the value of the creditReferenceScore property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setCreditReferenceScore(JAXBElement<String> value) {
        this.creditReferenceScore = value;
    }

    /**
     * Gets the value of the dfatMatch property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getDFATMatch() {
        return dfatMatch;
    }

    /**
     * Sets the value of the dfatMatch property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setDFATMatch(JAXBElement<String> value) {
        this.dfatMatch = value;
    }

    /**
     * Gets the value of the dateOfBirthMatch property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getDateOfBirthMatch() {
        return dateOfBirthMatch;
    }

    /**
     * Sets the value of the dateOfBirthMatch property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setDateOfBirthMatch(JAXBElement<String> value) {
        this.dateOfBirthMatch = value;
    }

    /**
     * Gets the value of the deceasedMatch property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getDeceasedMatch() {
        return deceasedMatch;
    }

    /**
     * Sets the value of the deceasedMatch property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setDeceasedMatch(JAXBElement<String> value) {
        this.deceasedMatch = value;
    }

    /**
     * Gets the value of the driverLicenceMatch property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getDriverLicenceMatch() {
        return driverLicenceMatch;
    }

    /**
     * Sets the value of the driverLicenceMatch property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setDriverLicenceMatch(JAXBElement<String> value) {
        this.driverLicenceMatch = value;
    }

    /**
     * Gets the value of the electoralRollDateOfBirthMatch property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getElectoralRollDateOfBirthMatch() {
        return electoralRollDateOfBirthMatch;
    }

    /**
     * Sets the value of the electoralRollDateOfBirthMatch property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setElectoralRollDateOfBirthMatch(JAXBElement<String> value) {
        this.electoralRollDateOfBirthMatch = value;
    }

    /**
     * Gets the value of the electoralRollMatch property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getElectoralRollMatch() {
        return electoralRollMatch;
    }

    /**
     * Sets the value of the electoralRollMatch property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setElectoralRollMatch(JAXBElement<String> value) {
        this.electoralRollMatch = value;
    }

    /**
     * Gets the value of the goneAwayMatch property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getGoneAwayMatch() {
        return goneAwayMatch;
    }

    /**
     * Sets the value of the goneAwayMatch property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setGoneAwayMatch(JAXBElement<String> value) {
        this.goneAwayMatch = value;
    }

    /**
     * Gets the value of the highRiskAddressMatch property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getHighRiskAddressMatch() {
        return highRiskAddressMatch;
    }

    /**
     * Sets the value of the highRiskAddressMatch property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setHighRiskAddressMatch(JAXBElement<String> value) {
        this.highRiskAddressMatch = value;
    }

    /**
     * Gets the value of the idVerified property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getIDVerified() {
        return idVerified;
    }

    /**
     * Sets the value of the idVerified property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setIDVerified(JAXBElement<String> value) {
        this.idVerified = value;
    }

    /**
     * Gets the value of the noOfCCJ property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getNoOfCCJ() {
        return noOfCCJ;
    }

    /**
     * Sets the value of the noOfCCJ property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setNoOfCCJ(JAXBElement<String> value) {
        this.noOfCCJ = value;
    }

    /**
     * Gets the value of the noOfCommercialEntitiesAtAddress property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getNoOfCommercialEntitiesAtAddress() {
        return noOfCommercialEntitiesAtAddress;
    }

    /**
     * Sets the value of the noOfCommercialEntitiesAtAddress property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setNoOfCommercialEntitiesAtAddress(JAXBElement<String> value) {
        this.noOfCommercialEntitiesAtAddress = value;
    }

    /**
     * Gets the value of the noOfOpenAccountsLenders property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getNoOfOpenAccountsLenders() {
        return noOfOpenAccountsLenders;
    }

    /**
     * Sets the value of the noOfOpenAccountsLenders property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setNoOfOpenAccountsLenders(JAXBElement<String> value) {
        this.noOfOpenAccountsLenders = value;
    }

    /**
     * Gets the value of the ofacMatch property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getOFACMatch() {
        return ofacMatch;
    }

    /**
     * Sets the value of the ofacMatch property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setOFACMatch(JAXBElement<String> value) {
        this.ofacMatch = value;
    }

    /**
     * Gets the value of the openAccountsMatch property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getOpenAccountsMatch() {
        return openAccountsMatch;
    }

    /**
     * Sets the value of the openAccountsMatch property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setOpenAccountsMatch(JAXBElement<String> value) {
        this.openAccountsMatch = value;
    }

    /**
     * Gets the value of the pepMatch property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getPEPMatch() {
        return pepMatch;
    }

    /**
     * Sets the value of the pepMatch property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setPEPMatch(JAXBElement<String> value) {
        this.pepMatch = value;
    }

    /**
     * Gets the value of the passportMatch property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getPassportMatch() {
        return passportMatch;
    }

    /**
     * Sets the value of the passportMatch property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setPassportMatch(JAXBElement<String> value) {
        this.passportMatch = value;
    }

    /**
     * Gets the value of the phoneNumberMatch property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getPhoneNumberMatch() {
        return phoneNumberMatch;
    }

    /**
     * Sets the value of the phoneNumberMatch property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setPhoneNumberMatch(JAXBElement<String> value) {
        this.phoneNumberMatch = value;
    }

    /**
     * Gets the value of the telephoneDirectoryMatch property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getTelephoneDirectoryMatch() {
        return telephoneDirectoryMatch;
    }

    /**
     * Sets the value of the telephoneDirectoryMatch property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setTelephoneDirectoryMatch(JAXBElement<String> value) {
        this.telephoneDirectoryMatch = value;
    }

    /**
     * Gets the value of the totalNumberOfVerifications property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getTotalNumberOfVerifications() {
        return totalNumberOfVerifications;
    }

    /**
     * Sets the value of the totalNumberOfVerifications property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setTotalNumberOfVerifications(JAXBElement<String> value) {
        this.totalNumberOfVerifications = value;
    }

}
