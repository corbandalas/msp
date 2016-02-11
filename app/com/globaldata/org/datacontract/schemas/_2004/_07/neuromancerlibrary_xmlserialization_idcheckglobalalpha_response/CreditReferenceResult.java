
package org.datacontract.schemas._2004._07.neuromancerlibrary_xmlserialization_idcheckglobalalpha_response;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for CreditReferenceResult complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CreditReferenceResult">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="CreditReferenceDetails" type="{http://schemas.datacontract.org/2004/07/NeuromancerLibrary.XmlSerialization.IDCheckGlobalAlpha.Response.CreditReference}CreditReferenceDetails" minOccurs="0"/>
 *         &lt;element name="CreditReferenceRecords" type="{http://schemas.datacontract.org/2004/07/NeuromancerLibrary.XmlSerialization.IDCheckGlobalAlpha.Response.CreditReference}CreditReferenceRecords" minOccurs="0"/>
 *         &lt;element name="CreditReferenceSummary" type="{http://schemas.datacontract.org/2004/07/NeuromancerLibrary.XmlSerialization.IDCheckGlobalAlpha.Response.CreditReference}CreditReferenceSummary" minOccurs="0"/>
 *         &lt;element name="ErrorCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ErrorMessage" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Summary" type="{http://schemas.datacontract.org/2004/07/NeuromancerLibrary.XmlSerialization.IDCheckGlobalAlpha.Response.CreditReference}SummaryCreditReference" minOccurs="0"/>
 *         &lt;element name="Type" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CreditReferenceResult", propOrder = {
    "creditReferenceDetails",
    "creditReferenceRecords",
    "creditReferenceSummary",
    "errorCode",
    "errorMessage",
    "summary",
    "type"
})
public class CreditReferenceResult {

    @XmlElementRef(name = "CreditReferenceDetails", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.XmlSerialization.IDCheckGlobalAlpha.Response.CreditReference", type = JAXBElement.class, required = false)
    protected JAXBElement<CreditReferenceDetails> creditReferenceDetails;
    @XmlElementRef(name = "CreditReferenceRecords", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.XmlSerialization.IDCheckGlobalAlpha.Response.CreditReference", type = JAXBElement.class, required = false)
    protected JAXBElement<CreditReferenceRecords> creditReferenceRecords;
    @XmlElementRef(name = "CreditReferenceSummary", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.XmlSerialization.IDCheckGlobalAlpha.Response.CreditReference", type = JAXBElement.class, required = false)
    protected JAXBElement<CreditReferenceSummary> creditReferenceSummary;
    @XmlElementRef(name = "ErrorCode", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.XmlSerialization.IDCheckGlobalAlpha.Response.CreditReference", type = JAXBElement.class, required = false)
    protected JAXBElement<String> errorCode;
    @XmlElementRef(name = "ErrorMessage", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.XmlSerialization.IDCheckGlobalAlpha.Response.CreditReference", type = JAXBElement.class, required = false)
    protected JAXBElement<String> errorMessage;
    @XmlElementRef(name = "Summary", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.XmlSerialization.IDCheckGlobalAlpha.Response.CreditReference", type = JAXBElement.class, required = false)
    protected JAXBElement<SummaryCreditReference> summary;
    @XmlElementRef(name = "Type", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.XmlSerialization.IDCheckGlobalAlpha.Response.CreditReference", type = JAXBElement.class, required = false)
    protected JAXBElement<String> type;

    /**
     * Gets the value of the creditReferenceDetails property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link CreditReferenceDetails }{@code >}
     *     
     */
    public JAXBElement<CreditReferenceDetails> getCreditReferenceDetails() {
        return creditReferenceDetails;
    }

    /**
     * Sets the value of the creditReferenceDetails property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link CreditReferenceDetails }{@code >}
     *     
     */
    public void setCreditReferenceDetails(JAXBElement<CreditReferenceDetails> value) {
        this.creditReferenceDetails = value;
    }

    /**
     * Gets the value of the creditReferenceRecords property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link CreditReferenceRecords }{@code >}
     *     
     */
    public JAXBElement<CreditReferenceRecords> getCreditReferenceRecords() {
        return creditReferenceRecords;
    }

    /**
     * Sets the value of the creditReferenceRecords property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link CreditReferenceRecords }{@code >}
     *     
     */
    public void setCreditReferenceRecords(JAXBElement<CreditReferenceRecords> value) {
        this.creditReferenceRecords = value;
    }

    /**
     * Gets the value of the creditReferenceSummary property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link CreditReferenceSummary }{@code >}
     *     
     */
    public JAXBElement<CreditReferenceSummary> getCreditReferenceSummary() {
        return creditReferenceSummary;
    }

    /**
     * Sets the value of the creditReferenceSummary property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link CreditReferenceSummary }{@code >}
     *     
     */
    public void setCreditReferenceSummary(JAXBElement<CreditReferenceSummary> value) {
        this.creditReferenceSummary = value;
    }

    /**
     * Gets the value of the errorCode property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getErrorCode() {
        return errorCode;
    }

    /**
     * Sets the value of the errorCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setErrorCode(JAXBElement<String> value) {
        this.errorCode = value;
    }

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
     * Gets the value of the summary property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link SummaryCreditReference }{@code >}
     *     
     */
    public JAXBElement<SummaryCreditReference> getSummary() {
        return summary;
    }

    /**
     * Sets the value of the summary property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link SummaryCreditReference }{@code >}
     *     
     */
    public void setSummary(JAXBElement<SummaryCreditReference> value) {
        this.summary = value;
    }

    /**
     * Gets the value of the type property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getType() {
        return type;
    }

    /**
     * Sets the value of the type property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setType(JAXBElement<String> value) {
        this.type = value;
    }

}
