
package org.datacontract.schemas._2004._07.neuromancerlibrary;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import org.datacontract.schemas._2004._07.databaselibrary.ServiceEnum;
import org.datacontract.schemas._2004._07.databaselibrary.ServiceTransactionResultCategoryEnum;
import org.datacontract.schemas._2004._07.databaselibrary.ServiceTransactionResultEnum;
import org.datacontract.schemas._2004._07.databaselibrary.ValidationResultEnum;


/**
 * <p>Java class for ServiceTransactionInformation complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ServiceTransactionInformation">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="FailedOverTo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="HaltTriggered" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="Service" type="{http://schemas.datacontract.org/2004/07/DatabaseLibrary.Enums}ServiceEnum" minOccurs="0"/>
 *         &lt;element name="ServiceInterpretResult" type="{http://schemas.datacontract.org/2004/07/DatabaseLibrary.Enums}ServiceTransactionResultCategoryEnum" minOccurs="0"/>
 *         &lt;element name="ServiceTransactionResult" type="{http://schemas.datacontract.org/2004/07/DatabaseLibrary.Enums}ServiceTransactionResultEnum" minOccurs="0"/>
 *         &lt;element name="ServiceTransactionResultMessage" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ServiceValidationDetails" type="{http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts}ServiceValidationResultDetails" minOccurs="0"/>
 *         &lt;element name="ValidationResult" type="{http://schemas.datacontract.org/2004/07/DatabaseLibrary.Enums}ValidationResultEnum" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ServiceTransactionInformation", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.Resources", propOrder = {
    "failedOverTo",
    "haltTriggered",
    "service",
    "serviceInterpretResult",
    "serviceTransactionResult",
    "serviceTransactionResultMessage",
    "serviceValidationDetails",
    "validationResult"
})
public class ServiceTransactionInformation {

    @XmlElementRef(name = "FailedOverTo", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.Resources", type = JAXBElement.class, required = false)
    protected JAXBElement<String> failedOverTo;
    @XmlElement(name = "HaltTriggered")
    protected Boolean haltTriggered;
    @XmlElement(name = "Service")
    @XmlSchemaType(name = "string")
    protected ServiceEnum service;
    @XmlElement(name = "ServiceInterpretResult")
    @XmlSchemaType(name = "string")
    protected ServiceTransactionResultCategoryEnum serviceInterpretResult;
    @XmlElement(name = "ServiceTransactionResult")
    @XmlSchemaType(name = "string")
    protected ServiceTransactionResultEnum serviceTransactionResult;
    @XmlElementRef(name = "ServiceTransactionResultMessage", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.Resources", type = JAXBElement.class, required = false)
    protected JAXBElement<String> serviceTransactionResultMessage;
    @XmlElementRef(name = "ServiceValidationDetails", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.Resources", type = JAXBElement.class, required = false)
    protected JAXBElement<ServiceValidationResultDetails> serviceValidationDetails;
    @XmlElement(name = "ValidationResult")
    @XmlSchemaType(name = "string")
    protected ValidationResultEnum validationResult;

    /**
     * Gets the value of the failedOverTo property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getFailedOverTo() {
        return failedOverTo;
    }

    /**
     * Sets the value of the failedOverTo property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setFailedOverTo(JAXBElement<String> value) {
        this.failedOverTo = value;
    }

    /**
     * Gets the value of the haltTriggered property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isHaltTriggered() {
        return haltTriggered;
    }

    /**
     * Sets the value of the haltTriggered property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setHaltTriggered(Boolean value) {
        this.haltTriggered = value;
    }

    /**
     * Gets the value of the service property.
     * 
     * @return
     *     possible object is
     *     {@link ServiceEnum }
     *     
     */
    public ServiceEnum getService() {
        return service;
    }

    /**
     * Sets the value of the service property.
     * 
     * @param value
     *     allowed object is
     *     {@link ServiceEnum }
     *     
     */
    public void setService(ServiceEnum value) {
        this.service = value;
    }

    /**
     * Gets the value of the serviceInterpretResult property.
     * 
     * @return
     *     possible object is
     *     {@link ServiceTransactionResultCategoryEnum }
     *     
     */
    public ServiceTransactionResultCategoryEnum getServiceInterpretResult() {
        return serviceInterpretResult;
    }

    /**
     * Sets the value of the serviceInterpretResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link ServiceTransactionResultCategoryEnum }
     *     
     */
    public void setServiceInterpretResult(ServiceTransactionResultCategoryEnum value) {
        this.serviceInterpretResult = value;
    }

    /**
     * Gets the value of the serviceTransactionResult property.
     * 
     * @return
     *     possible object is
     *     {@link ServiceTransactionResultEnum }
     *     
     */
    public ServiceTransactionResultEnum getServiceTransactionResult() {
        return serviceTransactionResult;
    }

    /**
     * Sets the value of the serviceTransactionResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link ServiceTransactionResultEnum }
     *     
     */
    public void setServiceTransactionResult(ServiceTransactionResultEnum value) {
        this.serviceTransactionResult = value;
    }

    /**
     * Gets the value of the serviceTransactionResultMessage property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getServiceTransactionResultMessage() {
        return serviceTransactionResultMessage;
    }

    /**
     * Sets the value of the serviceTransactionResultMessage property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setServiceTransactionResultMessage(JAXBElement<String> value) {
        this.serviceTransactionResultMessage = value;
    }

    /**
     * Gets the value of the serviceValidationDetails property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ServiceValidationResultDetails }{@code >}
     *     
     */
    public JAXBElement<ServiceValidationResultDetails> getServiceValidationDetails() {
        return serviceValidationDetails;
    }

    /**
     * Sets the value of the serviceValidationDetails property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ServiceValidationResultDetails }{@code >}
     *     
     */
    public void setServiceValidationDetails(JAXBElement<ServiceValidationResultDetails> value) {
        this.serviceValidationDetails = value;
    }

    /**
     * Gets the value of the validationResult property.
     * 
     * @return
     *     possible object is
     *     {@link ValidationResultEnum }
     *     
     */
    public ValidationResultEnum getValidationResult() {
        return validationResult;
    }

    /**
     * Sets the value of the validationResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link ValidationResultEnum }
     *     
     */
    public void setValidationResult(ValidationResultEnum value) {
        this.validationResult = value;
    }

}
