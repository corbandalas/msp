
package org.datacontract.schemas._2004._07.neuromancerlibrary_datacontracts;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;
import com.microsoft.schemas._2003._10.serialization.arrays.ArrayOfstring;


/**
 * <p>Java class for PEPDeskDetailsResult complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PEPDeskDetailsResult">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="AdditionalInformation" type="{http://schemas.microsoft.com/2003/10/Serialization/Arrays}ArrayOfstring" minOccurs="0"/>
 *         &lt;element name="Country" type="{http://schemas.microsoft.com/2003/10/Serialization/Arrays}ArrayOfstring" minOccurs="0"/>
 *         &lt;element name="DateOfBirth" type="{http://schemas.microsoft.com/2003/10/Serialization/Arrays}ArrayOfstring" minOccurs="0"/>
 *         &lt;element name="FunctionDetails" type="{http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts.PEPDesk}ArrayOfPEPDeskFunctionDetails" minOccurs="0"/>
 *         &lt;element name="Gender" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="NameDetails" type="{http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts.PEPDesk}ArrayOfPEPDeskNameDetails" minOccurs="0"/>
 *         &lt;element name="PlaceOfBirth" type="{http://schemas.microsoft.com/2003/10/Serialization/Arrays}ArrayOfstring" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PEPDeskDetailsResult", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts.PEPDesk", propOrder = {
    "additionalInformation",
    "country",
    "dateOfBirth",
    "functionDetails",
    "gender",
    "nameDetails",
    "placeOfBirth"
})
public class PEPDeskDetailsResult {

    @XmlElementRef(name = "AdditionalInformation", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts.PEPDesk", type = JAXBElement.class, required = false)
    protected JAXBElement<ArrayOfstring> additionalInformation;
    @XmlElementRef(name = "Country", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts.PEPDesk", type = JAXBElement.class, required = false)
    protected JAXBElement<ArrayOfstring> country;
    @XmlElementRef(name = "DateOfBirth", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts.PEPDesk", type = JAXBElement.class, required = false)
    protected JAXBElement<ArrayOfstring> dateOfBirth;
    @XmlElementRef(name = "FunctionDetails", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts.PEPDesk", type = JAXBElement.class, required = false)
    protected JAXBElement<ArrayOfPEPDeskFunctionDetails> functionDetails;
    @XmlElementRef(name = "Gender", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts.PEPDesk", type = JAXBElement.class, required = false)
    protected JAXBElement<String> gender;
    @XmlElementRef(name = "NameDetails", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts.PEPDesk", type = JAXBElement.class, required = false)
    protected JAXBElement<ArrayOfPEPDeskNameDetails> nameDetails;
    @XmlElementRef(name = "PlaceOfBirth", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts.PEPDesk", type = JAXBElement.class, required = false)
    protected JAXBElement<ArrayOfstring> placeOfBirth;

    /**
     * Gets the value of the additionalInformation property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfstring }{@code >}
     *     
     */
    public JAXBElement<ArrayOfstring> getAdditionalInformation() {
        return additionalInformation;
    }

    /**
     * Sets the value of the additionalInformation property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfstring }{@code >}
     *     
     */
    public void setAdditionalInformation(JAXBElement<ArrayOfstring> value) {
        this.additionalInformation = value;
    }

    /**
     * Gets the value of the country property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfstring }{@code >}
     *     
     */
    public JAXBElement<ArrayOfstring> getCountry() {
        return country;
    }

    /**
     * Sets the value of the country property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfstring }{@code >}
     *     
     */
    public void setCountry(JAXBElement<ArrayOfstring> value) {
        this.country = value;
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
     * Gets the value of the functionDetails property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfPEPDeskFunctionDetails }{@code >}
     *     
     */
    public JAXBElement<ArrayOfPEPDeskFunctionDetails> getFunctionDetails() {
        return functionDetails;
    }

    /**
     * Sets the value of the functionDetails property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfPEPDeskFunctionDetails }{@code >}
     *     
     */
    public void setFunctionDetails(JAXBElement<ArrayOfPEPDeskFunctionDetails> value) {
        this.functionDetails = value;
    }

    /**
     * Gets the value of the gender property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getGender() {
        return gender;
    }

    /**
     * Sets the value of the gender property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setGender(JAXBElement<String> value) {
        this.gender = value;
    }

    /**
     * Gets the value of the nameDetails property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfPEPDeskNameDetails }{@code >}
     *     
     */
    public JAXBElement<ArrayOfPEPDeskNameDetails> getNameDetails() {
        return nameDetails;
    }

    /**
     * Sets the value of the nameDetails property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfPEPDeskNameDetails }{@code >}
     *     
     */
    public void setNameDetails(JAXBElement<ArrayOfPEPDeskNameDetails> value) {
        this.nameDetails = value;
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

}
