
package org.datacontract.schemas._2004._07.neuromancerlibrary_xmlserialization_idcheckglobalalpha_response;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for IndividualSummary complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="IndividualSummary">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="AddressMatch" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="DateOfBirthMatch" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="HighRiskAddressMatch" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="NameAndAddressMatch" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="NameMatch" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="NoOfDateOfBirthMatch" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="NoOfNameAddressMatch" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="NoOfSurnameAddressMatch" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SurnameAndAddressMatch" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="TelephoneNumberMatch" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
@XmlType(name = "IndividualSummary", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.XmlSerialization.IDCheckGlobalAlpha.Response.Individuals", propOrder = {
    "addressMatch",
    "dateOfBirthMatch",
    "highRiskAddressMatch",
    "nameAndAddressMatch",
    "nameMatch",
    "noOfDateOfBirthMatch",
    "noOfNameAddressMatch",
    "noOfSurnameAddressMatch",
    "surnameAndAddressMatch",
    "telephoneNumberMatch",
    "totalNumberOfVerifications"
})
public class IndividualSummary {

    @XmlElementRef(name = "AddressMatch", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.XmlSerialization.IDCheckGlobalAlpha.Response.Individuals", type = JAXBElement.class, required = false)
    protected JAXBElement<String> addressMatch;
    @XmlElementRef(name = "DateOfBirthMatch", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.XmlSerialization.IDCheckGlobalAlpha.Response.Individuals", type = JAXBElement.class, required = false)
    protected JAXBElement<String> dateOfBirthMatch;
    @XmlElementRef(name = "HighRiskAddressMatch", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.XmlSerialization.IDCheckGlobalAlpha.Response.Individuals", type = JAXBElement.class, required = false)
    protected JAXBElement<String> highRiskAddressMatch;
    @XmlElementRef(name = "NameAndAddressMatch", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.XmlSerialization.IDCheckGlobalAlpha.Response.Individuals", type = JAXBElement.class, required = false)
    protected JAXBElement<String> nameAndAddressMatch;
    @XmlElementRef(name = "NameMatch", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.XmlSerialization.IDCheckGlobalAlpha.Response.Individuals", type = JAXBElement.class, required = false)
    protected JAXBElement<String> nameMatch;
    @XmlElementRef(name = "NoOfDateOfBirthMatch", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.XmlSerialization.IDCheckGlobalAlpha.Response.Individuals", type = JAXBElement.class, required = false)
    protected JAXBElement<String> noOfDateOfBirthMatch;
    @XmlElementRef(name = "NoOfNameAddressMatch", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.XmlSerialization.IDCheckGlobalAlpha.Response.Individuals", type = JAXBElement.class, required = false)
    protected JAXBElement<String> noOfNameAddressMatch;
    @XmlElementRef(name = "NoOfSurnameAddressMatch", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.XmlSerialization.IDCheckGlobalAlpha.Response.Individuals", type = JAXBElement.class, required = false)
    protected JAXBElement<String> noOfSurnameAddressMatch;
    @XmlElementRef(name = "SurnameAndAddressMatch", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.XmlSerialization.IDCheckGlobalAlpha.Response.Individuals", type = JAXBElement.class, required = false)
    protected JAXBElement<String> surnameAndAddressMatch;
    @XmlElementRef(name = "TelephoneNumberMatch", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.XmlSerialization.IDCheckGlobalAlpha.Response.Individuals", type = JAXBElement.class, required = false)
    protected JAXBElement<String> telephoneNumberMatch;
    @XmlElementRef(name = "TotalNumberOfVerifications", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.XmlSerialization.IDCheckGlobalAlpha.Response.Individuals", type = JAXBElement.class, required = false)
    protected JAXBElement<String> totalNumberOfVerifications;

    /**
     * Gets the value of the addressMatch property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getAddressMatch() {
        return addressMatch;
    }

    /**
     * Sets the value of the addressMatch property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setAddressMatch(JAXBElement<String> value) {
        this.addressMatch = value;
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
     * Gets the value of the nameAndAddressMatch property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getNameAndAddressMatch() {
        return nameAndAddressMatch;
    }

    /**
     * Sets the value of the nameAndAddressMatch property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setNameAndAddressMatch(JAXBElement<String> value) {
        this.nameAndAddressMatch = value;
    }

    /**
     * Gets the value of the nameMatch property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getNameMatch() {
        return nameMatch;
    }

    /**
     * Sets the value of the nameMatch property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setNameMatch(JAXBElement<String> value) {
        this.nameMatch = value;
    }

    /**
     * Gets the value of the noOfDateOfBirthMatch property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getNoOfDateOfBirthMatch() {
        return noOfDateOfBirthMatch;
    }

    /**
     * Sets the value of the noOfDateOfBirthMatch property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setNoOfDateOfBirthMatch(JAXBElement<String> value) {
        this.noOfDateOfBirthMatch = value;
    }

    /**
     * Gets the value of the noOfNameAddressMatch property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getNoOfNameAddressMatch() {
        return noOfNameAddressMatch;
    }

    /**
     * Sets the value of the noOfNameAddressMatch property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setNoOfNameAddressMatch(JAXBElement<String> value) {
        this.noOfNameAddressMatch = value;
    }

    /**
     * Gets the value of the noOfSurnameAddressMatch property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getNoOfSurnameAddressMatch() {
        return noOfSurnameAddressMatch;
    }

    /**
     * Sets the value of the noOfSurnameAddressMatch property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setNoOfSurnameAddressMatch(JAXBElement<String> value) {
        this.noOfSurnameAddressMatch = value;
    }

    /**
     * Gets the value of the surnameAndAddressMatch property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getSurnameAndAddressMatch() {
        return surnameAndAddressMatch;
    }

    /**
     * Sets the value of the surnameAndAddressMatch property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setSurnameAndAddressMatch(JAXBElement<String> value) {
        this.surnameAndAddressMatch = value;
    }

    /**
     * Gets the value of the telephoneNumberMatch property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getTelephoneNumberMatch() {
        return telephoneNumberMatch;
    }

    /**
     * Sets the value of the telephoneNumberMatch property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setTelephoneNumberMatch(JAXBElement<String> value) {
        this.telephoneNumberMatch = value;
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
