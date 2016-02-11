
package org.datacontract.schemas._2004._07.neuromancerlibrary_datacontracts;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;
import org.datacontract.schemas._2004._07.neuromancerlibrary_xmlserialization_directorukcheck.Errors;
import org.datacontract.schemas._2004._07.neuromancerlibrary_xmlserialization_directorukcheck.Results;


/**
 * <p>Java class for DirectorUKCheckResult complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DirectorUKCheckResult">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="DirectorUKCheckErrors" type="{http://schemas.datacontract.org/2004/07/NeuromancerLibrary.XmlSerialization.DirectorUKCheck.Response}Errors" minOccurs="0"/>
 *         &lt;element name="DirectorUKCheckResults" type="{http://schemas.datacontract.org/2004/07/NeuromancerLibrary.XmlSerialization.DirectorUKCheck.Response}Results" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DirectorUKCheckResult", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts.DirectorUKCheck", propOrder = {
    "directorUKCheckErrors",
    "directorUKCheckResults"
})
public class DirectorUKCheckResult {

    @XmlElementRef(name = "DirectorUKCheckErrors", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts.DirectorUKCheck", type = JAXBElement.class, required = false)
    protected JAXBElement<Errors> directorUKCheckErrors;
    @XmlElementRef(name = "DirectorUKCheckResults", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts.DirectorUKCheck", type = JAXBElement.class, required = false)
    protected JAXBElement<Results> directorUKCheckResults;

    /**
     * Gets the value of the directorUKCheckErrors property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Errors }{@code >}
     *     
     */
    public JAXBElement<Errors> getDirectorUKCheckErrors() {
        return directorUKCheckErrors;
    }

    /**
     * Sets the value of the directorUKCheckErrors property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Errors }{@code >}
     *     
     */
    public void setDirectorUKCheckErrors(JAXBElement<Errors> value) {
        this.directorUKCheckErrors = value;
    }

    /**
     * Gets the value of the directorUKCheckResults property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Results }{@code >}
     *     
     */
    public JAXBElement<Results> getDirectorUKCheckResults() {
        return directorUKCheckResults;
    }

    /**
     * Sets the value of the directorUKCheckResults property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Results }{@code >}
     *     
     */
    public void setDirectorUKCheckResults(JAXBElement<Results> value) {
        this.directorUKCheckResults = value;
    }

}
