
package org.datacontract.schemas._2004._07.neuromancerlibrary_xmlserialization_directorukcheck;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Errors complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Errors">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ErrorDetails" type="{http://schemas.datacontract.org/2004/07/NeuromancerLibrary.XmlSerialization.DirectorUKCheck.Response}ArrayOfErrorDetail" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Errors", propOrder = {
    "errorDetails"
})
public class Errors {

    @XmlElementRef(name = "ErrorDetails", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.XmlSerialization.DirectorUKCheck.Response", type = JAXBElement.class, required = false)
    protected JAXBElement<ArrayOfErrorDetail> errorDetails;

    /**
     * Gets the value of the errorDetails property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfErrorDetail }{@code >}
     *     
     */
    public JAXBElement<ArrayOfErrorDetail> getErrorDetails() {
        return errorDetails;
    }

    /**
     * Sets the value of the errorDetails property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfErrorDetail }{@code >}
     *     
     */
    public void setErrorDetails(JAXBElement<ArrayOfErrorDetail> value) {
        this.errorDetails = value;
    }

}
