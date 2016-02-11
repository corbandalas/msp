
package org.datacontract.schemas._2004._07.neuromancerlibrary_xmlserialization_idcheckglobalalpha;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for KYCSummary complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="KYCSummary">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Address" type="{http://schemas.datacontract.org/2004/07/NeuromancerLibrary.XmlSerialization.IDCheckGlobalAlpha.Response}Address" minOccurs="0"/>
 *         &lt;element name="Alerts" type="{http://schemas.datacontract.org/2004/07/NeuromancerLibrary.XmlSerialization.IDCheckGlobalAlpha.Response}Alerts" minOccurs="0"/>
 *         &lt;element name="DateOfBirth" type="{http://schemas.datacontract.org/2004/07/NeuromancerLibrary.XmlSerialization.IDCheckGlobalAlpha.Response}DateOfBirth" minOccurs="0"/>
 *         &lt;element name="FullNameAndAddress" type="{http://schemas.datacontract.org/2004/07/NeuromancerLibrary.XmlSerialization.IDCheckGlobalAlpha.Response}FullNameAndAddress" minOccurs="0"/>
 *         &lt;element name="SurnameAndAddress" type="{http://schemas.datacontract.org/2004/07/NeuromancerLibrary.XmlSerialization.IDCheckGlobalAlpha.Response}SurnameAndAddress" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "KYCSummary", propOrder = {
    "address",
    "alerts",
    "dateOfBirth",
    "fullNameAndAddress",
    "surnameAndAddress"
})
public class KYCSummary {

    @XmlElementRef(name = "Address", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.XmlSerialization.IDCheckGlobalAlpha.Response", type = JAXBElement.class, required = false)
    protected JAXBElement<Address> address;
    @XmlElementRef(name = "Alerts", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.XmlSerialization.IDCheckGlobalAlpha.Response", type = JAXBElement.class, required = false)
    protected JAXBElement<Alerts> alerts;
    @XmlElementRef(name = "DateOfBirth", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.XmlSerialization.IDCheckGlobalAlpha.Response", type = JAXBElement.class, required = false)
    protected JAXBElement<DateOfBirth> dateOfBirth;
    @XmlElementRef(name = "FullNameAndAddress", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.XmlSerialization.IDCheckGlobalAlpha.Response", type = JAXBElement.class, required = false)
    protected JAXBElement<FullNameAndAddress> fullNameAndAddress;
    @XmlElementRef(name = "SurnameAndAddress", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.XmlSerialization.IDCheckGlobalAlpha.Response", type = JAXBElement.class, required = false)
    protected JAXBElement<SurnameAndAddress> surnameAndAddress;

    /**
     * Gets the value of the address property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Address }{@code >}
     *     
     */
    public JAXBElement<Address> getAddress() {
        return address;
    }

    /**
     * Sets the value of the address property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Address }{@code >}
     *     
     */
    public void setAddress(JAXBElement<Address> value) {
        this.address = value;
    }

    /**
     * Gets the value of the alerts property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Alerts }{@code >}
     *     
     */
    public JAXBElement<Alerts> getAlerts() {
        return alerts;
    }

    /**
     * Sets the value of the alerts property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Alerts }{@code >}
     *     
     */
    public void setAlerts(JAXBElement<Alerts> value) {
        this.alerts = value;
    }

    /**
     * Gets the value of the dateOfBirth property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link DateOfBirth }{@code >}
     *     
     */
    public JAXBElement<DateOfBirth> getDateOfBirth() {
        return dateOfBirth;
    }

    /**
     * Sets the value of the dateOfBirth property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link DateOfBirth }{@code >}
     *     
     */
    public void setDateOfBirth(JAXBElement<DateOfBirth> value) {
        this.dateOfBirth = value;
    }

    /**
     * Gets the value of the fullNameAndAddress property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link FullNameAndAddress }{@code >}
     *     
     */
    public JAXBElement<FullNameAndAddress> getFullNameAndAddress() {
        return fullNameAndAddress;
    }

    /**
     * Sets the value of the fullNameAndAddress property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link FullNameAndAddress }{@code >}
     *     
     */
    public void setFullNameAndAddress(JAXBElement<FullNameAndAddress> value) {
        this.fullNameAndAddress = value;
    }

    /**
     * Gets the value of the surnameAndAddress property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link SurnameAndAddress }{@code >}
     *     
     */
    public JAXBElement<SurnameAndAddress> getSurnameAndAddress() {
        return surnameAndAddress;
    }

    /**
     * Sets the value of the surnameAndAddress property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link SurnameAndAddress }{@code >}
     *     
     */
    public void setSurnameAndAddress(JAXBElement<SurnameAndAddress> value) {
        this.surnameAndAddress = value;
    }

}
