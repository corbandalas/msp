
package org.datacontract.schemas._2004._07.neuromancerlibrary_datacontracts;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;
import org.datacontract.schemas._2004._07.databaselibrary.IDCheckUKDeltaAddressGoneAwayEnum;
import org.datacontract.schemas._2004._07.databaselibrary.IDCheckUKDeltaAddressMatchTypeEnum;


/**
 * <p>Java class for IDCheckUKDeltaAddress complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="IDCheckUKDeltaAddress">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="AddressValidated" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="DateOfBirth" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="DateOfBirthAppended" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="Forename" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ForenameAppended" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="GoneAway" type="{http://schemas.datacontract.org/2004/07/DatabaseLibrary.Enums}IDCheckUKDeltaAddressGoneAwayEnum" minOccurs="0"/>
 *         &lt;element name="MatchType" type="{http://schemas.datacontract.org/2004/07/DatabaseLibrary.Enums}IDCheckUKDeltaAddressMatchTypeEnum" minOccurs="0"/>
 *         &lt;element name="MiddleName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="MiddleNameAppended" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="Mosaic" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Occupants" type="{http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts.IDCheckUKDelta}ArrayOfIDCheckUKDeltaOccupant" minOccurs="0"/>
 *         &lt;element name="Properties" type="{http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts.IDCheckUKDelta}ArrayOfIDCheckUKDeltaProperty" minOccurs="0"/>
 *         &lt;element name="Recency" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Source" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Surname" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Telephone" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="TelephoneName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "IDCheckUKDeltaAddress", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts.IDCheckUKDelta", propOrder = {
    "addressValidated",
    "dateOfBirth",
    "dateOfBirthAppended",
    "forename",
    "forenameAppended",
    "goneAway",
    "matchType",
    "middleName",
    "middleNameAppended",
    "mosaic",
    "occupants",
    "properties",
    "recency",
    "source",
    "surname",
    "telephone",
    "telephoneName"
})
public class IDCheckUKDeltaAddress {

    @XmlElement(name = "AddressValidated")
    protected Boolean addressValidated;
    @XmlElementRef(name = "DateOfBirth", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts.IDCheckUKDelta", type = JAXBElement.class, required = false)
    protected JAXBElement<XMLGregorianCalendar> dateOfBirth;
    @XmlElement(name = "DateOfBirthAppended")
    protected Boolean dateOfBirthAppended;
    @XmlElementRef(name = "Forename", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts.IDCheckUKDelta", type = JAXBElement.class, required = false)
    protected JAXBElement<String> forename;
    @XmlElement(name = "ForenameAppended")
    protected Boolean forenameAppended;
    @XmlElement(name = "GoneAway")
    @XmlSchemaType(name = "string")
    protected IDCheckUKDeltaAddressGoneAwayEnum goneAway;
    @XmlElement(name = "MatchType")
    @XmlSchemaType(name = "string")
    protected IDCheckUKDeltaAddressMatchTypeEnum matchType;
    @XmlElementRef(name = "MiddleName", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts.IDCheckUKDelta", type = JAXBElement.class, required = false)
    protected JAXBElement<String> middleName;
    @XmlElement(name = "MiddleNameAppended")
    protected Boolean middleNameAppended;
    @XmlElementRef(name = "Mosaic", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts.IDCheckUKDelta", type = JAXBElement.class, required = false)
    protected JAXBElement<String> mosaic;
    @XmlElementRef(name = "Occupants", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts.IDCheckUKDelta", type = JAXBElement.class, required = false)
    protected JAXBElement<ArrayOfIDCheckUKDeltaOccupant> occupants;
    @XmlElementRef(name = "Properties", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts.IDCheckUKDelta", type = JAXBElement.class, required = false)
    protected JAXBElement<ArrayOfIDCheckUKDeltaProperty> properties;
    @XmlElementRef(name = "Recency", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts.IDCheckUKDelta", type = JAXBElement.class, required = false)
    protected JAXBElement<String> recency;
    @XmlElementRef(name = "Source", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts.IDCheckUKDelta", type = JAXBElement.class, required = false)
    protected JAXBElement<String> source;
    @XmlElementRef(name = "Surname", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts.IDCheckUKDelta", type = JAXBElement.class, required = false)
    protected JAXBElement<String> surname;
    @XmlElementRef(name = "Telephone", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts.IDCheckUKDelta", type = JAXBElement.class, required = false)
    protected JAXBElement<String> telephone;
    @XmlElementRef(name = "TelephoneName", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts.IDCheckUKDelta", type = JAXBElement.class, required = false)
    protected JAXBElement<String> telephoneName;

    /**
     * Gets the value of the addressValidated property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isAddressValidated() {
        return addressValidated;
    }

    /**
     * Sets the value of the addressValidated property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setAddressValidated(Boolean value) {
        this.addressValidated = value;
    }

    /**
     * Gets the value of the dateOfBirth property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     *     
     */
    public JAXBElement<XMLGregorianCalendar> getDateOfBirth() {
        return dateOfBirth;
    }

    /**
     * Sets the value of the dateOfBirth property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     *     
     */
    public void setDateOfBirth(JAXBElement<XMLGregorianCalendar> value) {
        this.dateOfBirth = value;
    }

    /**
     * Gets the value of the dateOfBirthAppended property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isDateOfBirthAppended() {
        return dateOfBirthAppended;
    }

    /**
     * Sets the value of the dateOfBirthAppended property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setDateOfBirthAppended(Boolean value) {
        this.dateOfBirthAppended = value;
    }

    /**
     * Gets the value of the forename property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getForename() {
        return forename;
    }

    /**
     * Sets the value of the forename property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setForename(JAXBElement<String> value) {
        this.forename = value;
    }

    /**
     * Gets the value of the forenameAppended property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isForenameAppended() {
        return forenameAppended;
    }

    /**
     * Sets the value of the forenameAppended property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setForenameAppended(Boolean value) {
        this.forenameAppended = value;
    }

    /**
     * Gets the value of the goneAway property.
     * 
     * @return
     *     possible object is
     *     {@link IDCheckUKDeltaAddressGoneAwayEnum }
     *     
     */
    public IDCheckUKDeltaAddressGoneAwayEnum getGoneAway() {
        return goneAway;
    }

    /**
     * Sets the value of the goneAway property.
     * 
     * @param value
     *     allowed object is
     *     {@link IDCheckUKDeltaAddressGoneAwayEnum }
     *     
     */
    public void setGoneAway(IDCheckUKDeltaAddressGoneAwayEnum value) {
        this.goneAway = value;
    }

    /**
     * Gets the value of the matchType property.
     * 
     * @return
     *     possible object is
     *     {@link IDCheckUKDeltaAddressMatchTypeEnum }
     *     
     */
    public IDCheckUKDeltaAddressMatchTypeEnum getMatchType() {
        return matchType;
    }

    /**
     * Sets the value of the matchType property.
     * 
     * @param value
     *     allowed object is
     *     {@link IDCheckUKDeltaAddressMatchTypeEnum }
     *     
     */
    public void setMatchType(IDCheckUKDeltaAddressMatchTypeEnum value) {
        this.matchType = value;
    }

    /**
     * Gets the value of the middleName property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getMiddleName() {
        return middleName;
    }

    /**
     * Sets the value of the middleName property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setMiddleName(JAXBElement<String> value) {
        this.middleName = value;
    }

    /**
     * Gets the value of the middleNameAppended property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isMiddleNameAppended() {
        return middleNameAppended;
    }

    /**
     * Sets the value of the middleNameAppended property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setMiddleNameAppended(Boolean value) {
        this.middleNameAppended = value;
    }

    /**
     * Gets the value of the mosaic property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getMosaic() {
        return mosaic;
    }

    /**
     * Sets the value of the mosaic property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setMosaic(JAXBElement<String> value) {
        this.mosaic = value;
    }

    /**
     * Gets the value of the occupants property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfIDCheckUKDeltaOccupant }{@code >}
     *     
     */
    public JAXBElement<ArrayOfIDCheckUKDeltaOccupant> getOccupants() {
        return occupants;
    }

    /**
     * Sets the value of the occupants property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfIDCheckUKDeltaOccupant }{@code >}
     *     
     */
    public void setOccupants(JAXBElement<ArrayOfIDCheckUKDeltaOccupant> value) {
        this.occupants = value;
    }

    /**
     * Gets the value of the properties property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfIDCheckUKDeltaProperty }{@code >}
     *     
     */
    public JAXBElement<ArrayOfIDCheckUKDeltaProperty> getProperties() {
        return properties;
    }

    /**
     * Sets the value of the properties property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfIDCheckUKDeltaProperty }{@code >}
     *     
     */
    public void setProperties(JAXBElement<ArrayOfIDCheckUKDeltaProperty> value) {
        this.properties = value;
    }

    /**
     * Gets the value of the recency property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getRecency() {
        return recency;
    }

    /**
     * Sets the value of the recency property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setRecency(JAXBElement<String> value) {
        this.recency = value;
    }

    /**
     * Gets the value of the source property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getSource() {
        return source;
    }

    /**
     * Sets the value of the source property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setSource(JAXBElement<String> value) {
        this.source = value;
    }

    /**
     * Gets the value of the surname property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getSurname() {
        return surname;
    }

    /**
     * Sets the value of the surname property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setSurname(JAXBElement<String> value) {
        this.surname = value;
    }

    /**
     * Gets the value of the telephone property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getTelephone() {
        return telephone;
    }

    /**
     * Sets the value of the telephone property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setTelephone(JAXBElement<String> value) {
        this.telephone = value;
    }

    /**
     * Gets the value of the telephoneName property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getTelephoneName() {
        return telephoneName;
    }

    /**
     * Sets the value of the telephoneName property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setTelephoneName(JAXBElement<String> value) {
        this.telephoneName = value;
    }

}
