
package org.datacontract.schemas._2004._07.neuromancerlibrary_xmlserialization_idcheckglobalalpha_response;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for NameDriverLicence complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="NameDriverLicence">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Forename" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="OtherNames" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Surname" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "NameDriverLicence", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.XmlSerialization.IDCheckGlobalAlpha.Response.DriverLicence", propOrder = {
    "forename",
    "otherNames",
    "surname"
})
public class NameDriverLicence {

    @XmlElementRef(name = "Forename", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.XmlSerialization.IDCheckGlobalAlpha.Response.DriverLicence", type = JAXBElement.class, required = false)
    protected JAXBElement<String> forename;
    @XmlElementRef(name = "OtherNames", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.XmlSerialization.IDCheckGlobalAlpha.Response.DriverLicence", type = JAXBElement.class, required = false)
    protected JAXBElement<String> otherNames;
    @XmlElementRef(name = "Surname", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.XmlSerialization.IDCheckGlobalAlpha.Response.DriverLicence", type = JAXBElement.class, required = false)
    protected JAXBElement<String> surname;

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
     * Gets the value of the otherNames property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getOtherNames() {
        return otherNames;
    }

    /**
     * Sets the value of the otherNames property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setOtherNames(JAXBElement<String> value) {
        this.otherNames = value;
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

}
