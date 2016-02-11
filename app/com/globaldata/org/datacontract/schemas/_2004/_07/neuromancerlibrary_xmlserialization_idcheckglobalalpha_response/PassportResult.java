
package org.datacontract.schemas._2004._07.neuromancerlibrary_xmlserialization_idcheckglobalalpha_response;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for PassportResult complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PassportResult">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ErrorCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ErrorMessage" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PassportDetails" type="{http://schemas.datacontract.org/2004/07/NeuromancerLibrary.XmlSerialization.IDCheckGlobalAlpha.Response.Passport}PassportDetails" minOccurs="0"/>
 *         &lt;element name="Summary" type="{http://schemas.datacontract.org/2004/07/NeuromancerLibrary.XmlSerialization.IDCheckGlobalAlpha.Response.Passport}SummaryPassport" minOccurs="0"/>
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
@XmlType(name = "PassportResult", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.XmlSerialization.IDCheckGlobalAlpha.Response.Passport", propOrder = {
    "errorCode",
    "errorMessage",
    "passportDetails",
    "summary",
    "type"
})
public class PassportResult {

    @XmlElementRef(name = "ErrorCode", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.XmlSerialization.IDCheckGlobalAlpha.Response.Passport", type = JAXBElement.class, required = false)
    protected JAXBElement<String> errorCode;
    @XmlElementRef(name = "ErrorMessage", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.XmlSerialization.IDCheckGlobalAlpha.Response.Passport", type = JAXBElement.class, required = false)
    protected JAXBElement<String> errorMessage;
    @XmlElementRef(name = "PassportDetails", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.XmlSerialization.IDCheckGlobalAlpha.Response.Passport", type = JAXBElement.class, required = false)
    protected JAXBElement<PassportDetails> passportDetails;
    @XmlElementRef(name = "Summary", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.XmlSerialization.IDCheckGlobalAlpha.Response.Passport", type = JAXBElement.class, required = false)
    protected JAXBElement<SummaryPassport> summary;
    @XmlElementRef(name = "Type", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.XmlSerialization.IDCheckGlobalAlpha.Response.Passport", type = JAXBElement.class, required = false)
    protected JAXBElement<String> type;

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
     * Gets the value of the passportDetails property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link PassportDetails }{@code >}
     *     
     */
    public JAXBElement<PassportDetails> getPassportDetails() {
        return passportDetails;
    }

    /**
     * Sets the value of the passportDetails property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link PassportDetails }{@code >}
     *     
     */
    public void setPassportDetails(JAXBElement<PassportDetails> value) {
        this.passportDetails = value;
    }

    /**
     * Gets the value of the summary property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link SummaryPassport }{@code >}
     *     
     */
    public JAXBElement<SummaryPassport> getSummary() {
        return summary;
    }

    /**
     * Sets the value of the summary property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link SummaryPassport }{@code >}
     *     
     */
    public void setSummary(JAXBElement<SummaryPassport> value) {
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
