
package org.datacontract.schemas._2004._07.neuromancerlibrary;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import org.datacontract.schemas._2004._07.databaselibrary.ServiceFaultCodeEnum;


/**
 * <p>Java class for ServiceFault complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ServiceFault">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ErrorMessage" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ServiceCallReference" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ServiceFaultCode" type="{http://schemas.datacontract.org/2004/07/DatabaseLibrary.Enums}ServiceFaultCodeEnum" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ServiceFault", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.Exceptions", propOrder = {
    "errorMessage",
    "serviceCallReference",
    "serviceFaultCode"
})
public class ServiceFault {

    @XmlElementRef(name = "ErrorMessage", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.Exceptions", type = JAXBElement.class, required = false)
    protected JAXBElement<String> errorMessage;
    @XmlElementRef(name = "ServiceCallReference", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.Exceptions", type = JAXBElement.class, required = false)
    protected JAXBElement<String> serviceCallReference;
    @XmlElement(name = "ServiceFaultCode")
    @XmlSchemaType(name = "string")
    protected ServiceFaultCodeEnum serviceFaultCode;

    /**
     * Gets the value of the errorMessage property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getErrorMessage() {
        return errorMessage;
    }

    /**
     * Sets the value of the errorMessage property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setErrorMessage(JAXBElement<String> value) {
        this.errorMessage = value;
    }

    /**
     * Gets the value of the serviceCallReference property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getServiceCallReference() {
        return serviceCallReference;
    }

    /**
     * Sets the value of the serviceCallReference property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setServiceCallReference(JAXBElement<String> value) {
        this.serviceCallReference = value;
    }

    /**
     * Gets the value of the serviceFaultCode property.
     * 
     * @return
     *     possible object is
     *     {@link ServiceFaultCodeEnum }
     *     
     */
    public ServiceFaultCodeEnum getServiceFaultCode() {
        return serviceFaultCode;
    }

    /**
     * Sets the value of the serviceFaultCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link ServiceFaultCodeEnum }
     *     
     */
    public void setServiceFaultCode(ServiceFaultCodeEnum value) {
        this.serviceFaultCode = value;
    }

}
