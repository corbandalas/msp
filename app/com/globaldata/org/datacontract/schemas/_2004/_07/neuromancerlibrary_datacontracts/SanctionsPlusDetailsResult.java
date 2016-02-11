
package org.datacontract.schemas._2004._07.neuromancerlibrary_datacontracts;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;
import com.microsoft.schemas._2003._10.serialization.arrays.ArrayOfstring;
import org.datacontract.schemas._2004._07.system.ArrayOfNullableOfdateTime;


/**
 * <p>Java class for SanctionsPlusDetailsResult complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SanctionsPlusDetailsResult">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Active" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="AddressDetails" type="{http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts.SanctionsPlus}ArrayOfSanctionsPlusAddressDetails" minOccurs="0"/>
 *         &lt;element name="AliasDetails" type="{http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts.SanctionsPlus}ArrayOfSanctionsPlusAliasDetails" minOccurs="0"/>
 *         &lt;element name="Callsign" type="{http://schemas.microsoft.com/2003/10/Serialization/Arrays}ArrayOfstring" minOccurs="0"/>
 *         &lt;element name="CitizenShip" type="{http://schemas.microsoft.com/2003/10/Serialization/Arrays}ArrayOfstring" minOccurs="0"/>
 *         &lt;element name="Constituancy" type="{http://schemas.microsoft.com/2003/10/Serialization/Arrays}ArrayOfstring" minOccurs="0"/>
 *         &lt;element name="DateOfBirth" type="{http://schemas.microsoft.com/2003/10/Serialization/Arrays}ArrayOfstring" minOccurs="0"/>
 *         &lt;element name="Documents" type="{http://schemas.microsoft.com/2003/10/Serialization/Arrays}ArrayOfstring" minOccurs="0"/>
 *         &lt;element name="Email" type="{http://schemas.microsoft.com/2003/10/Serialization/Arrays}ArrayOfstring" minOccurs="0"/>
 *         &lt;element name="Eyes" type="{http://schemas.microsoft.com/2003/10/Serialization/Arrays}ArrayOfstring" minOccurs="0"/>
 *         &lt;element name="Fax" type="{http://schemas.microsoft.com/2003/10/Serialization/Arrays}ArrayOfstring" minOccurs="0"/>
 *         &lt;element name="GRT" type="{http://schemas.microsoft.com/2003/10/Serialization/Arrays}ArrayOfstring" minOccurs="0"/>
 *         &lt;element name="Hair" type="{http://schemas.microsoft.com/2003/10/Serialization/Arrays}ArrayOfstring" minOccurs="0"/>
 *         &lt;element name="Height" type="{http://schemas.microsoft.com/2003/10/Serialization/Arrays}ArrayOfstring" minOccurs="0"/>
 *         &lt;element name="ImageUrl" type="{http://schemas.microsoft.com/2003/10/Serialization/Arrays}ArrayOfstring" minOccurs="0"/>
 *         &lt;element name="Languages" type="{http://schemas.microsoft.com/2003/10/Serialization/Arrays}ArrayOfstring" minOccurs="0"/>
 *         &lt;element name="LegalBasis" type="{http://schemas.microsoft.com/2003/10/Serialization/Arrays}ArrayOfstring" minOccurs="0"/>
 *         &lt;element name="ListingDate" type="{http://schemas.datacontract.org/2004/07/System}ArrayOfNullableOfdateTime" minOccurs="0"/>
 *         &lt;element name="Marks" type="{http://schemas.microsoft.com/2003/10/Serialization/Arrays}ArrayOfstring" minOccurs="0"/>
 *         &lt;element name="NameDetails" type="{http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts.SanctionsPlus}ArrayOfSanctionsPlusNameDetails" minOccurs="0"/>
 *         &lt;element name="Offense" type="{http://schemas.microsoft.com/2003/10/Serialization/Arrays}ArrayOfstring" minOccurs="0"/>
 *         &lt;element name="PageUrl" type="{http://schemas.microsoft.com/2003/10/Serialization/Arrays}ArrayOfstring" minOccurs="0"/>
 *         &lt;element name="Phone" type="{http://schemas.microsoft.com/2003/10/Serialization/Arrays}ArrayOfstring" minOccurs="0"/>
 *         &lt;element name="PlaceOfBirth" type="{http://schemas.microsoft.com/2003/10/Serialization/Arrays}ArrayOfstring" minOccurs="0"/>
 *         &lt;element name="PoliticalParty" type="{http://schemas.microsoft.com/2003/10/Serialization/Arrays}ArrayOfstring" minOccurs="0"/>
 *         &lt;element name="Program" type="{http://schemas.microsoft.com/2003/10/Serialization/Arrays}ArrayOfstring" minOccurs="0"/>
 *         &lt;element name="Remarks" type="{http://schemas.microsoft.com/2003/10/Serialization/Arrays}ArrayOfstring" minOccurs="0"/>
 *         &lt;element name="RiskCode" type="{http://schemas.microsoft.com/2003/10/Serialization/Arrays}ArrayOfstring" minOccurs="0"/>
 *         &lt;element name="Sex" type="{http://schemas.microsoft.com/2003/10/Serialization/Arrays}ArrayOfstring" minOccurs="0"/>
 *         &lt;element name="Source" type="{http://schemas.microsoft.com/2003/10/Serialization/Arrays}ArrayOfstring" minOccurs="0"/>
 *         &lt;element name="TIN" type="{http://schemas.microsoft.com/2003/10/Serialization/Arrays}ArrayOfstring" minOccurs="0"/>
 *         &lt;element name="Tonnage" type="{http://schemas.microsoft.com/2003/10/Serialization/Arrays}ArrayOfstring" minOccurs="0"/>
 *         &lt;element name="Type" type="{http://schemas.microsoft.com/2003/10/Serialization/Arrays}ArrayOfstring" minOccurs="0"/>
 *         &lt;element name="VesselFlag" type="{http://schemas.microsoft.com/2003/10/Serialization/Arrays}ArrayOfstring" minOccurs="0"/>
 *         &lt;element name="VesselOwner" type="{http://schemas.microsoft.com/2003/10/Serialization/Arrays}ArrayOfstring" minOccurs="0"/>
 *         &lt;element name="VesselType" type="{http://schemas.microsoft.com/2003/10/Serialization/Arrays}ArrayOfstring" minOccurs="0"/>
 *         &lt;element name="WantedBy" type="{http://schemas.microsoft.com/2003/10/Serialization/Arrays}ArrayOfstring" minOccurs="0"/>
 *         &lt;element name="Website" type="{http://schemas.microsoft.com/2003/10/Serialization/Arrays}ArrayOfstring" minOccurs="0"/>
 *         &lt;element name="Weight" type="{http://schemas.microsoft.com/2003/10/Serialization/Arrays}ArrayOfstring" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SanctionsPlusDetailsResult", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts.SanctionsPlus", propOrder = {
    "active",
    "addressDetails",
    "aliasDetails",
    "callsign",
    "citizenShip",
    "constituancy",
    "dateOfBirth",
    "documents",
    "email",
    "eyes",
    "fax",
    "grt",
    "hair",
    "height",
    "imageUrl",
    "languages",
    "legalBasis",
    "listingDate",
    "marks",
    "nameDetails",
    "offense",
    "pageUrl",
    "phone",
    "placeOfBirth",
    "politicalParty",
    "program",
    "remarks",
    "riskCode",
    "sex",
    "source",
    "tin",
    "tonnage",
    "type",
    "vesselFlag",
    "vesselOwner",
    "vesselType",
    "wantedBy",
    "website",
    "weight"
})
public class SanctionsPlusDetailsResult {

    @XmlElementRef(name = "Active", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts.SanctionsPlus", type = JAXBElement.class, required = false)
    protected JAXBElement<Boolean> active;
    @XmlElementRef(name = "AddressDetails", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts.SanctionsPlus", type = JAXBElement.class, required = false)
    protected JAXBElement<ArrayOfSanctionsPlusAddressDetails> addressDetails;
    @XmlElementRef(name = "AliasDetails", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts.SanctionsPlus", type = JAXBElement.class, required = false)
    protected JAXBElement<ArrayOfSanctionsPlusAliasDetails> aliasDetails;
    @XmlElementRef(name = "Callsign", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts.SanctionsPlus", type = JAXBElement.class, required = false)
    protected JAXBElement<ArrayOfstring> callsign;
    @XmlElementRef(name = "CitizenShip", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts.SanctionsPlus", type = JAXBElement.class, required = false)
    protected JAXBElement<ArrayOfstring> citizenShip;
    @XmlElementRef(name = "Constituancy", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts.SanctionsPlus", type = JAXBElement.class, required = false)
    protected JAXBElement<ArrayOfstring> constituancy;
    @XmlElementRef(name = "DateOfBirth", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts.SanctionsPlus", type = JAXBElement.class, required = false)
    protected JAXBElement<ArrayOfstring> dateOfBirth;
    @XmlElementRef(name = "Documents", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts.SanctionsPlus", type = JAXBElement.class, required = false)
    protected JAXBElement<ArrayOfstring> documents;
    @XmlElementRef(name = "Email", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts.SanctionsPlus", type = JAXBElement.class, required = false)
    protected JAXBElement<ArrayOfstring> email;
    @XmlElementRef(name = "Eyes", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts.SanctionsPlus", type = JAXBElement.class, required = false)
    protected JAXBElement<ArrayOfstring> eyes;
    @XmlElementRef(name = "Fax", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts.SanctionsPlus", type = JAXBElement.class, required = false)
    protected JAXBElement<ArrayOfstring> fax;
    @XmlElementRef(name = "GRT", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts.SanctionsPlus", type = JAXBElement.class, required = false)
    protected JAXBElement<ArrayOfstring> grt;
    @XmlElementRef(name = "Hair", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts.SanctionsPlus", type = JAXBElement.class, required = false)
    protected JAXBElement<ArrayOfstring> hair;
    @XmlElementRef(name = "Height", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts.SanctionsPlus", type = JAXBElement.class, required = false)
    protected JAXBElement<ArrayOfstring> height;
    @XmlElementRef(name = "ImageUrl", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts.SanctionsPlus", type = JAXBElement.class, required = false)
    protected JAXBElement<ArrayOfstring> imageUrl;
    @XmlElementRef(name = "Languages", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts.SanctionsPlus", type = JAXBElement.class, required = false)
    protected JAXBElement<ArrayOfstring> languages;
    @XmlElementRef(name = "LegalBasis", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts.SanctionsPlus", type = JAXBElement.class, required = false)
    protected JAXBElement<ArrayOfstring> legalBasis;
    @XmlElementRef(name = "ListingDate", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts.SanctionsPlus", type = JAXBElement.class, required = false)
    protected JAXBElement<ArrayOfNullableOfdateTime> listingDate;
    @XmlElementRef(name = "Marks", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts.SanctionsPlus", type = JAXBElement.class, required = false)
    protected JAXBElement<ArrayOfstring> marks;
    @XmlElementRef(name = "NameDetails", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts.SanctionsPlus", type = JAXBElement.class, required = false)
    protected JAXBElement<ArrayOfSanctionsPlusNameDetails> nameDetails;
    @XmlElementRef(name = "Offense", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts.SanctionsPlus", type = JAXBElement.class, required = false)
    protected JAXBElement<ArrayOfstring> offense;
    @XmlElementRef(name = "PageUrl", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts.SanctionsPlus", type = JAXBElement.class, required = false)
    protected JAXBElement<ArrayOfstring> pageUrl;
    @XmlElementRef(name = "Phone", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts.SanctionsPlus", type = JAXBElement.class, required = false)
    protected JAXBElement<ArrayOfstring> phone;
    @XmlElementRef(name = "PlaceOfBirth", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts.SanctionsPlus", type = JAXBElement.class, required = false)
    protected JAXBElement<ArrayOfstring> placeOfBirth;
    @XmlElementRef(name = "PoliticalParty", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts.SanctionsPlus", type = JAXBElement.class, required = false)
    protected JAXBElement<ArrayOfstring> politicalParty;
    @XmlElementRef(name = "Program", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts.SanctionsPlus", type = JAXBElement.class, required = false)
    protected JAXBElement<ArrayOfstring> program;
    @XmlElementRef(name = "Remarks", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts.SanctionsPlus", type = JAXBElement.class, required = false)
    protected JAXBElement<ArrayOfstring> remarks;
    @XmlElementRef(name = "RiskCode", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts.SanctionsPlus", type = JAXBElement.class, required = false)
    protected JAXBElement<ArrayOfstring> riskCode;
    @XmlElementRef(name = "Sex", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts.SanctionsPlus", type = JAXBElement.class, required = false)
    protected JAXBElement<ArrayOfstring> sex;
    @XmlElementRef(name = "Source", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts.SanctionsPlus", type = JAXBElement.class, required = false)
    protected JAXBElement<ArrayOfstring> source;
    @XmlElementRef(name = "TIN", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts.SanctionsPlus", type = JAXBElement.class, required = false)
    protected JAXBElement<ArrayOfstring> tin;
    @XmlElementRef(name = "Tonnage", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts.SanctionsPlus", type = JAXBElement.class, required = false)
    protected JAXBElement<ArrayOfstring> tonnage;
    @XmlElementRef(name = "Type", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts.SanctionsPlus", type = JAXBElement.class, required = false)
    protected JAXBElement<ArrayOfstring> type;
    @XmlElementRef(name = "VesselFlag", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts.SanctionsPlus", type = JAXBElement.class, required = false)
    protected JAXBElement<ArrayOfstring> vesselFlag;
    @XmlElementRef(name = "VesselOwner", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts.SanctionsPlus", type = JAXBElement.class, required = false)
    protected JAXBElement<ArrayOfstring> vesselOwner;
    @XmlElementRef(name = "VesselType", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts.SanctionsPlus", type = JAXBElement.class, required = false)
    protected JAXBElement<ArrayOfstring> vesselType;
    @XmlElementRef(name = "WantedBy", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts.SanctionsPlus", type = JAXBElement.class, required = false)
    protected JAXBElement<ArrayOfstring> wantedBy;
    @XmlElementRef(name = "Website", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts.SanctionsPlus", type = JAXBElement.class, required = false)
    protected JAXBElement<ArrayOfstring> website;
    @XmlElementRef(name = "Weight", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts.SanctionsPlus", type = JAXBElement.class, required = false)
    protected JAXBElement<ArrayOfstring> weight;

    /**
     * Gets the value of the active property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     *     
     */
    public JAXBElement<Boolean> getActive() {
        return active;
    }

    /**
     * Sets the value of the active property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     *     
     */
    public void setActive(JAXBElement<Boolean> value) {
        this.active = value;
    }

    /**
     * Gets the value of the addressDetails property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfSanctionsPlusAddressDetails }{@code >}
     *     
     */
    public JAXBElement<ArrayOfSanctionsPlusAddressDetails> getAddressDetails() {
        return addressDetails;
    }

    /**
     * Sets the value of the addressDetails property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfSanctionsPlusAddressDetails }{@code >}
     *     
     */
    public void setAddressDetails(JAXBElement<ArrayOfSanctionsPlusAddressDetails> value) {
        this.addressDetails = value;
    }

    /**
     * Gets the value of the aliasDetails property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfSanctionsPlusAliasDetails }{@code >}
     *     
     */
    public JAXBElement<ArrayOfSanctionsPlusAliasDetails> getAliasDetails() {
        return aliasDetails;
    }

    /**
     * Sets the value of the aliasDetails property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfSanctionsPlusAliasDetails }{@code >}
     *     
     */
    public void setAliasDetails(JAXBElement<ArrayOfSanctionsPlusAliasDetails> value) {
        this.aliasDetails = value;
    }

    /**
     * Gets the value of the callsign property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfstring }{@code >}
     *     
     */
    public JAXBElement<ArrayOfstring> getCallsign() {
        return callsign;
    }

    /**
     * Sets the value of the callsign property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfstring }{@code >}
     *     
     */
    public void setCallsign(JAXBElement<ArrayOfstring> value) {
        this.callsign = value;
    }

    /**
     * Gets the value of the citizenShip property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfstring }{@code >}
     *     
     */
    public JAXBElement<ArrayOfstring> getCitizenShip() {
        return citizenShip;
    }

    /**
     * Sets the value of the citizenShip property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfstring }{@code >}
     *     
     */
    public void setCitizenShip(JAXBElement<ArrayOfstring> value) {
        this.citizenShip = value;
    }

    /**
     * Gets the value of the constituancy property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfstring }{@code >}
     *     
     */
    public JAXBElement<ArrayOfstring> getConstituancy() {
        return constituancy;
    }

    /**
     * Sets the value of the constituancy property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfstring }{@code >}
     *     
     */
    public void setConstituancy(JAXBElement<ArrayOfstring> value) {
        this.constituancy = value;
    }

    /**
     * Gets the value of the dateOfBirth property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfstring }{@code >}
     *     
     */
    public JAXBElement<ArrayOfstring> getDateOfBirth() {
        return dateOfBirth;
    }

    /**
     * Sets the value of the dateOfBirth property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfstring }{@code >}
     *     
     */
    public void setDateOfBirth(JAXBElement<ArrayOfstring> value) {
        this.dateOfBirth = value;
    }

    /**
     * Gets the value of the documents property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfstring }{@code >}
     *     
     */
    public JAXBElement<ArrayOfstring> getDocuments() {
        return documents;
    }

    /**
     * Sets the value of the documents property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfstring }{@code >}
     *     
     */
    public void setDocuments(JAXBElement<ArrayOfstring> value) {
        this.documents = value;
    }

    /**
     * Gets the value of the email property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfstring }{@code >}
     *     
     */
    public JAXBElement<ArrayOfstring> getEmail() {
        return email;
    }

    /**
     * Sets the value of the email property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfstring }{@code >}
     *     
     */
    public void setEmail(JAXBElement<ArrayOfstring> value) {
        this.email = value;
    }

    /**
     * Gets the value of the eyes property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfstring }{@code >}
     *     
     */
    public JAXBElement<ArrayOfstring> getEyes() {
        return eyes;
    }

    /**
     * Sets the value of the eyes property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfstring }{@code >}
     *     
     */
    public void setEyes(JAXBElement<ArrayOfstring> value) {
        this.eyes = value;
    }

    /**
     * Gets the value of the fax property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfstring }{@code >}
     *     
     */
    public JAXBElement<ArrayOfstring> getFax() {
        return fax;
    }

    /**
     * Sets the value of the fax property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfstring }{@code >}
     *     
     */
    public void setFax(JAXBElement<ArrayOfstring> value) {
        this.fax = value;
    }

    /**
     * Gets the value of the grt property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfstring }{@code >}
     *     
     */
    public JAXBElement<ArrayOfstring> getGRT() {
        return grt;
    }

    /**
     * Sets the value of the grt property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfstring }{@code >}
     *     
     */
    public void setGRT(JAXBElement<ArrayOfstring> value) {
        this.grt = value;
    }

    /**
     * Gets the value of the hair property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfstring }{@code >}
     *     
     */
    public JAXBElement<ArrayOfstring> getHair() {
        return hair;
    }

    /**
     * Sets the value of the hair property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfstring }{@code >}
     *     
     */
    public void setHair(JAXBElement<ArrayOfstring> value) {
        this.hair = value;
    }

    /**
     * Gets the value of the height property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfstring }{@code >}
     *     
     */
    public JAXBElement<ArrayOfstring> getHeight() {
        return height;
    }

    /**
     * Sets the value of the height property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfstring }{@code >}
     *     
     */
    public void setHeight(JAXBElement<ArrayOfstring> value) {
        this.height = value;
    }

    /**
     * Gets the value of the imageUrl property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfstring }{@code >}
     *     
     */
    public JAXBElement<ArrayOfstring> getImageUrl() {
        return imageUrl;
    }

    /**
     * Sets the value of the imageUrl property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfstring }{@code >}
     *     
     */
    public void setImageUrl(JAXBElement<ArrayOfstring> value) {
        this.imageUrl = value;
    }

    /**
     * Gets the value of the languages property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfstring }{@code >}
     *     
     */
    public JAXBElement<ArrayOfstring> getLanguages() {
        return languages;
    }

    /**
     * Sets the value of the languages property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfstring }{@code >}
     *     
     */
    public void setLanguages(JAXBElement<ArrayOfstring> value) {
        this.languages = value;
    }

    /**
     * Gets the value of the legalBasis property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfstring }{@code >}
     *     
     */
    public JAXBElement<ArrayOfstring> getLegalBasis() {
        return legalBasis;
    }

    /**
     * Sets the value of the legalBasis property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfstring }{@code >}
     *     
     */
    public void setLegalBasis(JAXBElement<ArrayOfstring> value) {
        this.legalBasis = value;
    }

    /**
     * Gets the value of the listingDate property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfNullableOfdateTime }{@code >}
     *     
     */
    public JAXBElement<ArrayOfNullableOfdateTime> getListingDate() {
        return listingDate;
    }

    /**
     * Sets the value of the listingDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfNullableOfdateTime }{@code >}
     *     
     */
    public void setListingDate(JAXBElement<ArrayOfNullableOfdateTime> value) {
        this.listingDate = value;
    }

    /**
     * Gets the value of the marks property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfstring }{@code >}
     *     
     */
    public JAXBElement<ArrayOfstring> getMarks() {
        return marks;
    }

    /**
     * Sets the value of the marks property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfstring }{@code >}
     *     
     */
    public void setMarks(JAXBElement<ArrayOfstring> value) {
        this.marks = value;
    }

    /**
     * Gets the value of the nameDetails property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfSanctionsPlusNameDetails }{@code >}
     *     
     */
    public JAXBElement<ArrayOfSanctionsPlusNameDetails> getNameDetails() {
        return nameDetails;
    }

    /**
     * Sets the value of the nameDetails property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfSanctionsPlusNameDetails }{@code >}
     *     
     */
    public void setNameDetails(JAXBElement<ArrayOfSanctionsPlusNameDetails> value) {
        this.nameDetails = value;
    }

    /**
     * Gets the value of the offense property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfstring }{@code >}
     *     
     */
    public JAXBElement<ArrayOfstring> getOffense() {
        return offense;
    }

    /**
     * Sets the value of the offense property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfstring }{@code >}
     *     
     */
    public void setOffense(JAXBElement<ArrayOfstring> value) {
        this.offense = value;
    }

    /**
     * Gets the value of the pageUrl property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfstring }{@code >}
     *     
     */
    public JAXBElement<ArrayOfstring> getPageUrl() {
        return pageUrl;
    }

    /**
     * Sets the value of the pageUrl property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfstring }{@code >}
     *     
     */
    public void setPageUrl(JAXBElement<ArrayOfstring> value) {
        this.pageUrl = value;
    }

    /**
     * Gets the value of the phone property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfstring }{@code >}
     *     
     */
    public JAXBElement<ArrayOfstring> getPhone() {
        return phone;
    }

    /**
     * Sets the value of the phone property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfstring }{@code >}
     *     
     */
    public void setPhone(JAXBElement<ArrayOfstring> value) {
        this.phone = value;
    }

    /**
     * Gets the value of the placeOfBirth property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfstring }{@code >}
     *     
     */
    public JAXBElement<ArrayOfstring> getPlaceOfBirth() {
        return placeOfBirth;
    }

    /**
     * Sets the value of the placeOfBirth property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfstring }{@code >}
     *     
     */
    public void setPlaceOfBirth(JAXBElement<ArrayOfstring> value) {
        this.placeOfBirth = value;
    }

    /**
     * Gets the value of the politicalParty property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfstring }{@code >}
     *     
     */
    public JAXBElement<ArrayOfstring> getPoliticalParty() {
        return politicalParty;
    }

    /**
     * Sets the value of the politicalParty property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfstring }{@code >}
     *     
     */
    public void setPoliticalParty(JAXBElement<ArrayOfstring> value) {
        this.politicalParty = value;
    }

    /**
     * Gets the value of the program property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfstring }{@code >}
     *     
     */
    public JAXBElement<ArrayOfstring> getProgram() {
        return program;
    }

    /**
     * Sets the value of the program property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfstring }{@code >}
     *     
     */
    public void setProgram(JAXBElement<ArrayOfstring> value) {
        this.program = value;
    }

    /**
     * Gets the value of the remarks property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfstring }{@code >}
     *     
     */
    public JAXBElement<ArrayOfstring> getRemarks() {
        return remarks;
    }

    /**
     * Sets the value of the remarks property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfstring }{@code >}
     *     
     */
    public void setRemarks(JAXBElement<ArrayOfstring> value) {
        this.remarks = value;
    }

    /**
     * Gets the value of the riskCode property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfstring }{@code >}
     *     
     */
    public JAXBElement<ArrayOfstring> getRiskCode() {
        return riskCode;
    }

    /**
     * Sets the value of the riskCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfstring }{@code >}
     *     
     */
    public void setRiskCode(JAXBElement<ArrayOfstring> value) {
        this.riskCode = value;
    }

    /**
     * Gets the value of the sex property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfstring }{@code >}
     *     
     */
    public JAXBElement<ArrayOfstring> getSex() {
        return sex;
    }

    /**
     * Sets the value of the sex property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfstring }{@code >}
     *     
     */
    public void setSex(JAXBElement<ArrayOfstring> value) {
        this.sex = value;
    }

    /**
     * Gets the value of the source property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfstring }{@code >}
     *     
     */
    public JAXBElement<ArrayOfstring> getSource() {
        return source;
    }

    /**
     * Sets the value of the source property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfstring }{@code >}
     *     
     */
    public void setSource(JAXBElement<ArrayOfstring> value) {
        this.source = value;
    }

    /**
     * Gets the value of the tin property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfstring }{@code >}
     *     
     */
    public JAXBElement<ArrayOfstring> getTIN() {
        return tin;
    }

    /**
     * Sets the value of the tin property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfstring }{@code >}
     *     
     */
    public void setTIN(JAXBElement<ArrayOfstring> value) {
        this.tin = value;
    }

    /**
     * Gets the value of the tonnage property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfstring }{@code >}
     *     
     */
    public JAXBElement<ArrayOfstring> getTonnage() {
        return tonnage;
    }

    /**
     * Sets the value of the tonnage property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfstring }{@code >}
     *     
     */
    public void setTonnage(JAXBElement<ArrayOfstring> value) {
        this.tonnage = value;
    }

    /**
     * Gets the value of the type property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfstring }{@code >}
     *     
     */
    public JAXBElement<ArrayOfstring> getType() {
        return type;
    }

    /**
     * Sets the value of the type property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfstring }{@code >}
     *     
     */
    public void setType(JAXBElement<ArrayOfstring> value) {
        this.type = value;
    }

    /**
     * Gets the value of the vesselFlag property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfstring }{@code >}
     *     
     */
    public JAXBElement<ArrayOfstring> getVesselFlag() {
        return vesselFlag;
    }

    /**
     * Sets the value of the vesselFlag property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfstring }{@code >}
     *     
     */
    public void setVesselFlag(JAXBElement<ArrayOfstring> value) {
        this.vesselFlag = value;
    }

    /**
     * Gets the value of the vesselOwner property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfstring }{@code >}
     *     
     */
    public JAXBElement<ArrayOfstring> getVesselOwner() {
        return vesselOwner;
    }

    /**
     * Sets the value of the vesselOwner property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfstring }{@code >}
     *     
     */
    public void setVesselOwner(JAXBElement<ArrayOfstring> value) {
        this.vesselOwner = value;
    }

    /**
     * Gets the value of the vesselType property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfstring }{@code >}
     *     
     */
    public JAXBElement<ArrayOfstring> getVesselType() {
        return vesselType;
    }

    /**
     * Sets the value of the vesselType property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfstring }{@code >}
     *     
     */
    public void setVesselType(JAXBElement<ArrayOfstring> value) {
        this.vesselType = value;
    }

    /**
     * Gets the value of the wantedBy property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfstring }{@code >}
     *     
     */
    public JAXBElement<ArrayOfstring> getWantedBy() {
        return wantedBy;
    }

    /**
     * Sets the value of the wantedBy property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfstring }{@code >}
     *     
     */
    public void setWantedBy(JAXBElement<ArrayOfstring> value) {
        this.wantedBy = value;
    }

    /**
     * Gets the value of the website property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfstring }{@code >}
     *     
     */
    public JAXBElement<ArrayOfstring> getWebsite() {
        return website;
    }

    /**
     * Sets the value of the website property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfstring }{@code >}
     *     
     */
    public void setWebsite(JAXBElement<ArrayOfstring> value) {
        this.website = value;
    }

    /**
     * Gets the value of the weight property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfstring }{@code >}
     *     
     */
    public JAXBElement<ArrayOfstring> getWeight() {
        return weight;
    }

    /**
     * Sets the value of the weight property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfstring }{@code >}
     *     
     */
    public void setWeight(JAXBElement<ArrayOfstring> value) {
        this.weight = value;
    }

}
