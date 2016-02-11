
package org.datacontract.schemas._2004._07.neuromancerlibrary_xmlserialization_directorukcheck;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Results complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Results">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Result" type="{http://schemas.datacontract.org/2004/07/NeuromancerLibrary.XmlSerialization.DirectorUKCheck.Response}ArrayOfResult" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Results", propOrder = {
    "result"
})
public class Results {

    @XmlElementRef(name = "Result", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.XmlSerialization.DirectorUKCheck.Response", type = JAXBElement.class, required = false)
    protected JAXBElement<ArrayOfResult> result;

    /**
     * Gets the value of the result property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfResult }{@code >}
     *     
     */
    public JAXBElement<ArrayOfResult> getResult() {
        return result;
    }

    /**
     * Sets the value of the result property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfResult }{@code >}
     *     
     */
    public void setResult(JAXBElement<ArrayOfResult> value) {
        this.result = value;
    }

}
