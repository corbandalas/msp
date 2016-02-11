
package org.datacontract.schemas._2004._07.neuromancerlibrary_datacontracts;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;
import org.datacontract.schemas._2004._07.neuromancerlibrary_xmlserialization_directorukdetails.Director;
import org.datacontract.schemas._2004._07.neuromancerlibrary_xmlserialization_directorukdetails.Errors;


/**
 * <p>Java class for DirectorUKDetailsResult complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DirectorUKDetailsResult">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="DirectorUKDetailsDirector" type="{http://schemas.datacontract.org/2004/07/NeuromancerLibrary.XmlSerialization.DirectorUKDetails.Response}Director" minOccurs="0"/>
 *         &lt;element name="DirectorUKDetailsErrors" type="{http://schemas.datacontract.org/2004/07/NeuromancerLibrary.XmlSerialization.DirectorUKDetails.Response}Errors" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DirectorUKDetailsResult", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts.DirectorUKDetails", propOrder = {
    "directorUKDetailsDirector",
    "directorUKDetailsErrors"
})
public class DirectorUKDetailsResult {

    @XmlElementRef(name = "DirectorUKDetailsDirector", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts.DirectorUKDetails", type = JAXBElement.class, required = false)
    protected JAXBElement<Director> directorUKDetailsDirector;
    @XmlElementRef(name = "DirectorUKDetailsErrors", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts.DirectorUKDetails", type = JAXBElement.class, required = false)
    protected JAXBElement<Errors> directorUKDetailsErrors;

    /**
     * Gets the value of the directorUKDetailsDirector property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Director }{@code >}
     *     
     */
    public JAXBElement<Director> getDirectorUKDetailsDirector() {
        return directorUKDetailsDirector;
    }

    /**
     * Sets the value of the directorUKDetailsDirector property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Director }{@code >}
     *     
     */
    public void setDirectorUKDetailsDirector(JAXBElement<Director> value) {
        this.directorUKDetailsDirector = value;
    }

    /**
     * Gets the value of the directorUKDetailsErrors property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Errors }{@code >}
     *     
     */
    public JAXBElement<Errors> getDirectorUKDetailsErrors() {
        return directorUKDetailsErrors;
    }

    /**
     * Sets the value of the directorUKDetailsErrors property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Errors }{@code >}
     *     
     */
    public void setDirectorUKDetailsErrors(JAXBElement<Errors> value) {
        this.directorUKDetailsErrors = value;
    }

}
