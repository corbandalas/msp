
package org.datacontract.schemas._2004._07.neuromancerlibrary_xmlserialization_directorukdetails;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Directorship complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Directorship">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="AppointDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CompanyName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CompanyNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CompanyStatus" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CreditLimit" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CreditRating" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Function" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Directorship", propOrder = {
    "appointDate",
    "companyName",
    "companyNumber",
    "companyStatus",
    "creditLimit",
    "creditRating",
    "function"
})
public class Directorship {

    @XmlElementRef(name = "AppointDate", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.XmlSerialization.DirectorUKDetails.Response", type = JAXBElement.class, required = false)
    protected JAXBElement<String> appointDate;
    @XmlElementRef(name = "CompanyName", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.XmlSerialization.DirectorUKDetails.Response", type = JAXBElement.class, required = false)
    protected JAXBElement<String> companyName;
    @XmlElementRef(name = "CompanyNumber", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.XmlSerialization.DirectorUKDetails.Response", type = JAXBElement.class, required = false)
    protected JAXBElement<String> companyNumber;
    @XmlElementRef(name = "CompanyStatus", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.XmlSerialization.DirectorUKDetails.Response", type = JAXBElement.class, required = false)
    protected JAXBElement<String> companyStatus;
    @XmlElementRef(name = "CreditLimit", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.XmlSerialization.DirectorUKDetails.Response", type = JAXBElement.class, required = false)
    protected JAXBElement<String> creditLimit;
    @XmlElementRef(name = "CreditRating", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.XmlSerialization.DirectorUKDetails.Response", type = JAXBElement.class, required = false)
    protected JAXBElement<String> creditRating;
    @XmlElementRef(name = "Function", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.XmlSerialization.DirectorUKDetails.Response", type = JAXBElement.class, required = false)
    protected JAXBElement<String> function;

    /**
     * Gets the value of the appointDate property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getAppointDate() {
        return appointDate;
    }

    /**
     * Sets the value of the appointDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setAppointDate(JAXBElement<String> value) {
        this.appointDate = value;
    }

    /**
     * Gets the value of the companyName property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getCompanyName() {
        return companyName;
    }

    /**
     * Sets the value of the companyName property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setCompanyName(JAXBElement<String> value) {
        this.companyName = value;
    }

    /**
     * Gets the value of the companyNumber property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getCompanyNumber() {
        return companyNumber;
    }

    /**
     * Sets the value of the companyNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setCompanyNumber(JAXBElement<String> value) {
        this.companyNumber = value;
    }

    /**
     * Gets the value of the companyStatus property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getCompanyStatus() {
        return companyStatus;
    }

    /**
     * Sets the value of the companyStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setCompanyStatus(JAXBElement<String> value) {
        this.companyStatus = value;
    }

    /**
     * Gets the value of the creditLimit property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getCreditLimit() {
        return creditLimit;
    }

    /**
     * Sets the value of the creditLimit property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setCreditLimit(JAXBElement<String> value) {
        this.creditLimit = value;
    }

    /**
     * Gets the value of the creditRating property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getCreditRating() {
        return creditRating;
    }

    /**
     * Sets the value of the creditRating property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setCreditRating(JAXBElement<String> value) {
        this.creditRating = value;
    }

    /**
     * Gets the value of the function property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getFunction() {
        return function;
    }

    /**
     * Sets the value of the function property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setFunction(JAXBElement<String> value) {
        this.function = value;
    }

}
