
package org.datacontract.schemas._2004._07.neuromancerlibrary_xmlserialization_idcheckglobalalpha_response;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for OrganisationDirectors complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="OrganisationDirectors">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Address" type="{http://schemas.datacontract.org/2004/07/NeuromancerLibrary.XmlSerialization.IDCheckGlobalAlpha.Response.Directors}AddressDirectors" minOccurs="0"/>
 *         &lt;element name="LOB" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="NumberOfEmployees" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Principles" type="{http://schemas.datacontract.org/2004/07/NeuromancerLibrary.XmlSerialization.IDCheckGlobalAlpha.Response.Directors}Principles" minOccurs="0"/>
 *         &lt;element name="RegistrationNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SIC" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Telephones" type="{http://schemas.datacontract.org/2004/07/NeuromancerLibrary.XmlSerialization.IDCheckGlobalAlpha.Response.Directors}TelephonesDirectors" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "OrganisationDirectors", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.XmlSerialization.IDCheckGlobalAlpha.Response.Directors", propOrder = {
    "address",
    "lob",
    "numberOfEmployees",
    "principles",
    "registrationNumber",
    "sic",
    "telephones"
})
public class OrganisationDirectors {

    @XmlElementRef(name = "Address", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.XmlSerialization.IDCheckGlobalAlpha.Response.Directors", type = JAXBElement.class, required = false)
    protected JAXBElement<AddressDirectors> address;
    @XmlElementRef(name = "LOB", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.XmlSerialization.IDCheckGlobalAlpha.Response.Directors", type = JAXBElement.class, required = false)
    protected JAXBElement<String> lob;
    @XmlElementRef(name = "NumberOfEmployees", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.XmlSerialization.IDCheckGlobalAlpha.Response.Directors", type = JAXBElement.class, required = false)
    protected JAXBElement<String> numberOfEmployees;
    @XmlElementRef(name = "Principles", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.XmlSerialization.IDCheckGlobalAlpha.Response.Directors", type = JAXBElement.class, required = false)
    protected JAXBElement<Principles> principles;
    @XmlElementRef(name = "RegistrationNumber", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.XmlSerialization.IDCheckGlobalAlpha.Response.Directors", type = JAXBElement.class, required = false)
    protected JAXBElement<String> registrationNumber;
    @XmlElementRef(name = "SIC", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.XmlSerialization.IDCheckGlobalAlpha.Response.Directors", type = JAXBElement.class, required = false)
    protected JAXBElement<String> sic;
    @XmlElementRef(name = "Telephones", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.XmlSerialization.IDCheckGlobalAlpha.Response.Directors", type = JAXBElement.class, required = false)
    protected JAXBElement<TelephonesDirectors> telephones;

    /**
     * Gets the value of the address property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link AddressDirectors }{@code >}
     *     
     */
    public JAXBElement<AddressDirectors> getAddress() {
        return address;
    }

    /**
     * Sets the value of the address property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link AddressDirectors }{@code >}
     *     
     */
    public void setAddress(JAXBElement<AddressDirectors> value) {
        this.address = value;
    }

    /**
     * Gets the value of the lob property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getLOB() {
        return lob;
    }

    /**
     * Sets the value of the lob property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setLOB(JAXBElement<String> value) {
        this.lob = value;
    }

    /**
     * Gets the value of the numberOfEmployees property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getNumberOfEmployees() {
        return numberOfEmployees;
    }

    /**
     * Sets the value of the numberOfEmployees property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setNumberOfEmployees(JAXBElement<String> value) {
        this.numberOfEmployees = value;
    }

    /**
     * Gets the value of the principles property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Principles }{@code >}
     *     
     */
    public JAXBElement<Principles> getPrinciples() {
        return principles;
    }

    /**
     * Sets the value of the principles property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Principles }{@code >}
     *     
     */
    public void setPrinciples(JAXBElement<Principles> value) {
        this.principles = value;
    }

    /**
     * Gets the value of the registrationNumber property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getRegistrationNumber() {
        return registrationNumber;
    }

    /**
     * Sets the value of the registrationNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setRegistrationNumber(JAXBElement<String> value) {
        this.registrationNumber = value;
    }

    /**
     * Gets the value of the sic property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getSIC() {
        return sic;
    }

    /**
     * Sets the value of the sic property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setSIC(JAXBElement<String> value) {
        this.sic = value;
    }

    /**
     * Gets the value of the telephones property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link TelephonesDirectors }{@code >}
     *     
     */
    public JAXBElement<TelephonesDirectors> getTelephones() {
        return telephones;
    }

    /**
     * Sets the value of the telephones property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link TelephonesDirectors }{@code >}
     *     
     */
    public void setTelephones(JAXBElement<TelephonesDirectors> value) {
        this.telephones = value;
    }

}
