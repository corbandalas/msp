
package org.datacontract.schemas._2004._07.neuromancerlibrary;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import org.datacontract.schemas._2004._07.databaselibrary.InterpretResultEnum;


/**
 * <p>Java class for TransactionInformation complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TransactionInformation">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="InterpretResult" type="{http://schemas.datacontract.org/2004/07/DatabaseLibrary.Enums}InterpretResultEnum" minOccurs="0"/>
 *         &lt;element name="ServiceCallReference" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ServiceTransactions" type="{http://schemas.datacontract.org/2004/07/NeuromancerLibrary.Resources}ArrayOfServiceTransactionInformation" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TransactionInformation", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.Resources", propOrder = {
    "interpretResult",
    "serviceCallReference",
    "serviceTransactions"
})
public class TransactionInformation {

    @XmlElement(name = "InterpretResult")
    @XmlSchemaType(name = "string")
    protected InterpretResultEnum interpretResult;
    @XmlElementRef(name = "ServiceCallReference", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.Resources", type = JAXBElement.class, required = false)
    protected JAXBElement<String> serviceCallReference;
    @XmlElementRef(name = "ServiceTransactions", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.Resources", type = JAXBElement.class, required = false)
    protected JAXBElement<ArrayOfServiceTransactionInformation> serviceTransactions;

    /**
     * Gets the value of the interpretResult property.
     * 
     * @return
     *     possible object is
     *     {@link InterpretResultEnum }
     *     
     */
    public InterpretResultEnum getInterpretResult() {
        return interpretResult;
    }

    /**
     * Sets the value of the interpretResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link InterpretResultEnum }
     *     
     */
    public void setInterpretResult(InterpretResultEnum value) {
        this.interpretResult = value;
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
     * Gets the value of the serviceTransactions property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfServiceTransactionInformation }{@code >}
     *     
     */
    public JAXBElement<ArrayOfServiceTransactionInformation> getServiceTransactions() {
        return serviceTransactions;
    }

    /**
     * Sets the value of the serviceTransactions property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfServiceTransactionInformation }{@code >}
     *     
     */
    public void setServiceTransactions(JAXBElement<ArrayOfServiceTransactionInformation> value) {
        this.serviceTransactions = value;
    }

}
