
package org.datacontract.schemas._2004._07.neuromancerlibrary;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ClientProvidedData complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ClientProvidedData">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ClientReference" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ClientSubaccount" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ClientUser" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="RefersToServiceCallReference" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ClientProvidedData", propOrder = {
    "clientReference",
    "clientSubaccount",
    "clientUser",
    "refersToServiceCallReference"
})
public class ClientProvidedData {

    @XmlElementRef(name = "ClientReference", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts", type = JAXBElement.class, required = false)
    protected JAXBElement<String> clientReference;
    @XmlElementRef(name = "ClientSubaccount", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts", type = JAXBElement.class, required = false)
    protected JAXBElement<String> clientSubaccount;
    @XmlElementRef(name = "ClientUser", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts", type = JAXBElement.class, required = false)
    protected JAXBElement<String> clientUser;
    @XmlElementRef(name = "RefersToServiceCallReference", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts", type = JAXBElement.class, required = false)
    protected JAXBElement<String> refersToServiceCallReference;

    /**
     * Gets the value of the clientReference property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getClientReference() {
        return clientReference;
    }

    /**
     * Sets the value of the clientReference property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setClientReference(JAXBElement<String> value) {
        this.clientReference = value;
    }

    /**
     * Gets the value of the clientSubaccount property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getClientSubaccount() {
        return clientSubaccount;
    }

    /**
     * Sets the value of the clientSubaccount property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setClientSubaccount(JAXBElement<String> value) {
        this.clientSubaccount = value;
    }

    /**
     * Gets the value of the clientUser property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getClientUser() {
        return clientUser;
    }

    /**
     * Sets the value of the clientUser property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setClientUser(JAXBElement<String> value) {
        this.clientUser = value;
    }

    /**
     * Gets the value of the refersToServiceCallReference property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getRefersToServiceCallReference() {
        return refersToServiceCallReference;
    }

    /**
     * Sets the value of the refersToServiceCallReference property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setRefersToServiceCallReference(JAXBElement<String> value) {
        this.refersToServiceCallReference = value;
    }

}
