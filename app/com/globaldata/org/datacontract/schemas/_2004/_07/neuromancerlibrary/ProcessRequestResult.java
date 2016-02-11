
package org.datacontract.schemas._2004._07.neuromancerlibrary;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ProcessRequestResult complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ProcessRequestResult">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ServiceResult" type="{http://schemas.datacontract.org/2004/07/NeuromancerLibrary.Resources}ServiceResult" minOccurs="0"/>
 *         &lt;element name="TransactionInformation" type="{http://schemas.datacontract.org/2004/07/NeuromancerLibrary.Resources}TransactionInformation" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ProcessRequestResult", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.Resources", propOrder = {
    "serviceResult",
    "transactionInformation"
})
public class ProcessRequestResult {

    @XmlElementRef(name = "ServiceResult", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.Resources", type = JAXBElement.class, required = false)
    protected JAXBElement<ServiceResult> serviceResult;
    @XmlElementRef(name = "TransactionInformation", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.Resources", type = JAXBElement.class, required = false)
    protected JAXBElement<TransactionInformation> transactionInformation;

    /**
     * Gets the value of the serviceResult property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ServiceResult }{@code >}
     *     
     */
    public JAXBElement<ServiceResult> getServiceResult() {
        return serviceResult;
    }

    /**
     * Sets the value of the serviceResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ServiceResult }{@code >}
     *     
     */
    public void setServiceResult(JAXBElement<ServiceResult> value) {
        this.serviceResult = value;
    }

    /**
     * Gets the value of the transactionInformation property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link TransactionInformation }{@code >}
     *     
     */
    public JAXBElement<TransactionInformation> getTransactionInformation() {
        return transactionInformation;
    }

    /**
     * Sets the value of the transactionInformation property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link TransactionInformation }{@code >}
     *     
     */
    public void setTransactionInformation(JAXBElement<TransactionInformation> value) {
        this.transactionInformation = value;
    }

}
