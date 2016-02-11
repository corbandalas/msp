
package org.datacontract.schemas._2004._07.neuromancerlibrary_externalservices_iddocumentcheck_proxies;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ResultsResponseModel complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ResultsResponseModel">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="FailureResponse" type="{http://schemas.datacontract.org/2004/07/NeuromancerLibrary.ExternalServices.IDDocumentCheck.Proxies.Results}ResultsFailureResponseModel" minOccurs="0"/>
 *         &lt;element name="IsSuccessful" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="SuccessResponse" type="{http://schemas.datacontract.org/2004/07/NeuromancerLibrary.ExternalServices.IDDocumentCheck.Proxies.Results}ResultsSuccessResponseModel" minOccurs="0"/>
 *         &lt;element name="TransactionResult" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="TransactionStatus" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ResultsResponseModel", propOrder = {
    "failureResponse",
    "isSuccessful",
    "successResponse",
    "transactionResult",
    "transactionStatus"
})
public class ResultsResponseModel {

    @XmlElementRef(name = "FailureResponse", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.ExternalServices.IDDocumentCheck.Proxies.Results", type = JAXBElement.class, required = false)
    protected JAXBElement<ResultsFailureResponseModel> failureResponse;
    @XmlElement(name = "IsSuccessful")
    protected Boolean isSuccessful;
    @XmlElementRef(name = "SuccessResponse", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.ExternalServices.IDDocumentCheck.Proxies.Results", type = JAXBElement.class, required = false)
    protected JAXBElement<ResultsSuccessResponseModel> successResponse;
    @XmlElementRef(name = "TransactionResult", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.ExternalServices.IDDocumentCheck.Proxies.Results", type = JAXBElement.class, required = false)
    protected JAXBElement<String> transactionResult;
    @XmlElementRef(name = "TransactionStatus", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.ExternalServices.IDDocumentCheck.Proxies.Results", type = JAXBElement.class, required = false)
    protected JAXBElement<String> transactionStatus;

    /**
     * Gets the value of the failureResponse property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ResultsFailureResponseModel }{@code >}
     *     
     */
    public JAXBElement<ResultsFailureResponseModel> getFailureResponse() {
        return failureResponse;
    }

    /**
     * Sets the value of the failureResponse property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ResultsFailureResponseModel }{@code >}
     *     
     */
    public void setFailureResponse(JAXBElement<ResultsFailureResponseModel> value) {
        this.failureResponse = value;
    }

    /**
     * Gets the value of the isSuccessful property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isIsSuccessful() {
        return isSuccessful;
    }

    /**
     * Sets the value of the isSuccessful property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIsSuccessful(Boolean value) {
        this.isSuccessful = value;
    }

    /**
     * Gets the value of the successResponse property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ResultsSuccessResponseModel }{@code >}
     *     
     */
    public JAXBElement<ResultsSuccessResponseModel> getSuccessResponse() {
        return successResponse;
    }

    /**
     * Sets the value of the successResponse property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ResultsSuccessResponseModel }{@code >}
     *     
     */
    public void setSuccessResponse(JAXBElement<ResultsSuccessResponseModel> value) {
        this.successResponse = value;
    }

    /**
     * Gets the value of the transactionResult property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getTransactionResult() {
        return transactionResult;
    }

    /**
     * Sets the value of the transactionResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setTransactionResult(JAXBElement<String> value) {
        this.transactionResult = value;
    }

    /**
     * Gets the value of the transactionStatus property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getTransactionStatus() {
        return transactionStatus;
    }

    /**
     * Sets the value of the transactionStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setTransactionStatus(JAXBElement<String> value) {
        this.transactionStatus = value;
    }

}
