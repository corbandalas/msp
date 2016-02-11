
package org.datacontract.schemas._2004._07.neuromancerlibrary;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import org.datacontract.schemas._2004._07.databaselibrary.ServiceEnum;
import org.datacontract.schemas._2004._07.databaselibrary.ValidationResultEnum;
import org.datacontract.schemas._2004._07.system_collections.ArrayOfKeyValuePairOfstringValidationFailureReasontYKHRTWk;


/**
 * <p>Java class for ServiceValidationResultDetails complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ServiceValidationResultDetails">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Service" type="{http://schemas.datacontract.org/2004/07/DatabaseLibrary.Enums}ServiceEnum" minOccurs="0"/>
 *         &lt;element name="ValidationFailureReasons" type="{http://schemas.datacontract.org/2004/07/System.Collections.Generic}ArrayOfKeyValuePairOfstringValidationFailureReasontYKHRTWk" minOccurs="0"/>
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
@XmlType(name = "ServiceValidationResultDetails", propOrder = {
    "service",
    "validationFailureReasons",
    "validationResult"
})
public class ServiceValidationResultDetails {

    @XmlElement(name = "Service")
    @XmlSchemaType(name = "string")
    protected ServiceEnum service;
    @XmlElementRef(name = "ValidationFailureReasons", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts", type = JAXBElement.class, required = false)
    protected JAXBElement<ArrayOfKeyValuePairOfstringValidationFailureReasontYKHRTWk> validationFailureReasons;
    @XmlElement(name = "ValidationResult")
    @XmlSchemaType(name = "string")
    protected ValidationResultEnum validationResult;

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
     * Gets the value of the validationFailureReasons property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfKeyValuePairOfstringValidationFailureReasontYKHRTWk }{@code >}
     *     
     */
    public JAXBElement<ArrayOfKeyValuePairOfstringValidationFailureReasontYKHRTWk> getValidationFailureReasons() {
        return validationFailureReasons;
    }

    /**
     * Sets the value of the validationFailureReasons property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfKeyValuePairOfstringValidationFailureReasontYKHRTWk }{@code >}
     *     
     */
    public void setValidationFailureReasons(JAXBElement<ArrayOfKeyValuePairOfstringValidationFailureReasontYKHRTWk> value) {
        this.validationFailureReasons = value;
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
