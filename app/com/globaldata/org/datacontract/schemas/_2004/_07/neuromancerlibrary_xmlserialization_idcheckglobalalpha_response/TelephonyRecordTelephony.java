
package org.datacontract.schemas._2004._07.neuromancerlibrary_xmlserialization_idcheckglobalalpha_response;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for TelephonyRecordTelephony complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TelephonyRecordTelephony">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Address" type="{http://schemas.datacontract.org/2004/07/NeuromancerLibrary.XmlSerialization.IDCheckGlobalAlpha.Response.Telephony}AddressTelephony" minOccurs="0"/>
 *         &lt;element name="Person" type="{http://schemas.datacontract.org/2004/07/NeuromancerLibrary.XmlSerialization.IDCheckGlobalAlpha.Response.Telephony}PersonTelephony" minOccurs="0"/>
 *         &lt;element name="Telephones" type="{http://schemas.datacontract.org/2004/07/NeuromancerLibrary.XmlSerialization.IDCheckGlobalAlpha.Response.Telephony}TelephonesTelephony" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TelephonyRecordTelephony", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.XmlSerialization.IDCheckGlobalAlpha.Response.Telephony", propOrder = {
    "address",
    "person",
    "telephones"
})
public class TelephonyRecordTelephony {

    @XmlElementRef(name = "Address", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.XmlSerialization.IDCheckGlobalAlpha.Response.Telephony", type = JAXBElement.class, required = false)
    protected JAXBElement<AddressTelephony> address;
    @XmlElementRef(name = "Person", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.XmlSerialization.IDCheckGlobalAlpha.Response.Telephony", type = JAXBElement.class, required = false)
    protected JAXBElement<PersonTelephony> person;
    @XmlElementRef(name = "Telephones", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.XmlSerialization.IDCheckGlobalAlpha.Response.Telephony", type = JAXBElement.class, required = false)
    protected JAXBElement<TelephonesTelephony> telephones;

    /**
     * Gets the value of the address property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link AddressTelephony }{@code >}
     *     
     */
    public JAXBElement<AddressTelephony> getAddress() {
        return address;
    }

    /**
     * Sets the value of the address property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link AddressTelephony }{@code >}
     *     
     */
    public void setAddress(JAXBElement<AddressTelephony> value) {
        this.address = value;
    }

    /**
     * Gets the value of the person property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link PersonTelephony }{@code >}
     *     
     */
    public JAXBElement<PersonTelephony> getPerson() {
        return person;
    }

    /**
     * Sets the value of the person property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link PersonTelephony }{@code >}
     *     
     */
    public void setPerson(JAXBElement<PersonTelephony> value) {
        this.person = value;
    }

    /**
     * Gets the value of the telephones property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link TelephonesTelephony }{@code >}
     *     
     */
    public JAXBElement<TelephonesTelephony> getTelephones() {
        return telephones;
    }

    /**
     * Sets the value of the telephones property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link TelephonesTelephony }{@code >}
     *     
     */
    public void setTelephones(JAXBElement<TelephonesTelephony> value) {
        this.telephones = value;
    }

}
