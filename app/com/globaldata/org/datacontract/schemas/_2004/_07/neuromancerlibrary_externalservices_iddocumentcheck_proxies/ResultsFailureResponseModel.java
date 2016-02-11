
package org.datacontract.schemas._2004._07.neuromancerlibrary_externalservices_iddocumentcheck_proxies;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ResultsFailureResponseModel complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ResultsFailureResponseModel">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="AgeCheck" type="{http://schemas.datacontract.org/2004/07/NeuromancerLibrary.ExternalServices.IDDocumentCheck.Proxies.Results}AgeCheckResponseElementModel" minOccurs="0"/>
 *         &lt;element name="DocumentCheck" type="{http://schemas.datacontract.org/2004/07/NeuromancerLibrary.ExternalServices.IDDocumentCheck.Proxies.Results}DocumentCheckFailureResponseElementModel" minOccurs="0"/>
 *         &lt;element name="Enrollment" type="{http://schemas.datacontract.org/2004/07/NeuromancerLibrary.ExternalServices.IDDocumentCheck.Proxies.Results}EnrollmentResponseElementModel" minOccurs="0"/>
 *         &lt;element name="FlagsBlock" type="{http://schemas.datacontract.org/2004/07/NeuromancerLibrary.ExternalServices.IDDocumentCheck.Proxies.Results}FlagsBlockResponseElementModel" minOccurs="0"/>
 *         &lt;element name="IssuesBlock" type="{http://schemas.datacontract.org/2004/07/NeuromancerLibrary.ExternalServices.IDDocumentCheck.Proxies.Results}IssuesBlockResponseElementModel" minOccurs="0"/>
 *         &lt;element name="Transaction" type="{http://schemas.datacontract.org/2004/07/NeuromancerLibrary.ExternalServices.IDDocumentCheck.Proxies.Results}TransactionResponseElementModel" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ResultsFailureResponseModel", propOrder = {
    "ageCheck",
    "documentCheck",
    "enrollment",
    "flagsBlock",
    "issuesBlock",
    "transaction"
})
public class ResultsFailureResponseModel {

    @XmlElementRef(name = "AgeCheck", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.ExternalServices.IDDocumentCheck.Proxies.Results", type = JAXBElement.class, required = false)
    protected JAXBElement<AgeCheckResponseElementModel> ageCheck;
    @XmlElementRef(name = "DocumentCheck", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.ExternalServices.IDDocumentCheck.Proxies.Results", type = JAXBElement.class, required = false)
    protected JAXBElement<DocumentCheckFailureResponseElementModel> documentCheck;
    @XmlElementRef(name = "Enrollment", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.ExternalServices.IDDocumentCheck.Proxies.Results", type = JAXBElement.class, required = false)
    protected JAXBElement<EnrollmentResponseElementModel> enrollment;
    @XmlElementRef(name = "FlagsBlock", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.ExternalServices.IDDocumentCheck.Proxies.Results", type = JAXBElement.class, required = false)
    protected JAXBElement<FlagsBlockResponseElementModel> flagsBlock;
    @XmlElementRef(name = "IssuesBlock", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.ExternalServices.IDDocumentCheck.Proxies.Results", type = JAXBElement.class, required = false)
    protected JAXBElement<IssuesBlockResponseElementModel> issuesBlock;
    @XmlElementRef(name = "Transaction", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.ExternalServices.IDDocumentCheck.Proxies.Results", type = JAXBElement.class, required = false)
    protected JAXBElement<TransactionResponseElementModel> transaction;

    /**
     * Gets the value of the ageCheck property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link AgeCheckResponseElementModel }{@code >}
     *     
     */
    public JAXBElement<AgeCheckResponseElementModel> getAgeCheck() {
        return ageCheck;
    }

    /**
     * Sets the value of the ageCheck property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link AgeCheckResponseElementModel }{@code >}
     *     
     */
    public void setAgeCheck(JAXBElement<AgeCheckResponseElementModel> value) {
        this.ageCheck = value;
    }

    /**
     * Gets the value of the documentCheck property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link DocumentCheckFailureResponseElementModel }{@code >}
     *     
     */
    public JAXBElement<DocumentCheckFailureResponseElementModel> getDocumentCheck() {
        return documentCheck;
    }

    /**
     * Sets the value of the documentCheck property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link DocumentCheckFailureResponseElementModel }{@code >}
     *     
     */
    public void setDocumentCheck(JAXBElement<DocumentCheckFailureResponseElementModel> value) {
        this.documentCheck = value;
    }

    /**
     * Gets the value of the enrollment property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link EnrollmentResponseElementModel }{@code >}
     *     
     */
    public JAXBElement<EnrollmentResponseElementModel> getEnrollment() {
        return enrollment;
    }

    /**
     * Sets the value of the enrollment property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link EnrollmentResponseElementModel }{@code >}
     *     
     */
    public void setEnrollment(JAXBElement<EnrollmentResponseElementModel> value) {
        this.enrollment = value;
    }

    /**
     * Gets the value of the flagsBlock property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link FlagsBlockResponseElementModel }{@code >}
     *     
     */
    public JAXBElement<FlagsBlockResponseElementModel> getFlagsBlock() {
        return flagsBlock;
    }

    /**
     * Sets the value of the flagsBlock property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link FlagsBlockResponseElementModel }{@code >}
     *     
     */
    public void setFlagsBlock(JAXBElement<FlagsBlockResponseElementModel> value) {
        this.flagsBlock = value;
    }

    /**
     * Gets the value of the issuesBlock property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link IssuesBlockResponseElementModel }{@code >}
     *     
     */
    public JAXBElement<IssuesBlockResponseElementModel> getIssuesBlock() {
        return issuesBlock;
    }

    /**
     * Sets the value of the issuesBlock property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link IssuesBlockResponseElementModel }{@code >}
     *     
     */
    public void setIssuesBlock(JAXBElement<IssuesBlockResponseElementModel> value) {
        this.issuesBlock = value;
    }

    /**
     * Gets the value of the transaction property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link TransactionResponseElementModel }{@code >}
     *     
     */
    public JAXBElement<TransactionResponseElementModel> getTransaction() {
        return transaction;
    }

    /**
     * Sets the value of the transaction property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link TransactionResponseElementModel }{@code >}
     *     
     */
    public void setTransaction(JAXBElement<TransactionResponseElementModel> value) {
        this.transaction = value;
    }

}
