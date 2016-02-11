
package org.datacontract.schemas._2004._07.neuromancerlibrary_xmlserialization_idcheckglobalalpha_response;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Principles complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Principles">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="DirectorshipDirectorships" type="{http://schemas.datacontract.org/2004/07/NeuromancerLibrary.XmlSerialization.IDCheckGlobalAlpha.Response.Directors}DirectorshipDirectorships" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Principles", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.XmlSerialization.IDCheckGlobalAlpha.Response.Directors", propOrder = {
    "directorshipDirectorships"
})
public class Principles {

    @XmlElementRef(name = "DirectorshipDirectorships", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.XmlSerialization.IDCheckGlobalAlpha.Response.Directors", type = JAXBElement.class, required = false)
    protected JAXBElement<DirectorshipDirectorships> directorshipDirectorships;

    /**
     * Gets the value of the directorshipDirectorships property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link DirectorshipDirectorships }{@code >}
     *     
     */
    public JAXBElement<DirectorshipDirectorships> getDirectorshipDirectorships() {
        return directorshipDirectorships;
    }

    /**
     * Sets the value of the directorshipDirectorships property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link DirectorshipDirectorships }{@code >}
     *     
     */
    public void setDirectorshipDirectorships(JAXBElement<DirectorshipDirectorships> value) {
        this.directorshipDirectorships = value;
    }

}
