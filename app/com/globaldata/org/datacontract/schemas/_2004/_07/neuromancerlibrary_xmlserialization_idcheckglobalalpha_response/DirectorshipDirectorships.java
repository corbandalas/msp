
package org.datacontract.schemas._2004._07.neuromancerlibrary_xmlserialization_idcheckglobalalpha_response;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for DirectorshipDirectorships complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DirectorshipDirectorships">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="DirectorshipDirectorshipList" type="{http://schemas.datacontract.org/2004/07/NeuromancerLibrary.XmlSerialization.IDCheckGlobalAlpha.Response.Directors}ArrayOfDirectorshipDirectorship" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DirectorshipDirectorships", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.XmlSerialization.IDCheckGlobalAlpha.Response.Directors", propOrder = {
    "directorshipDirectorshipList"
})
public class DirectorshipDirectorships {

    @XmlElementRef(name = "DirectorshipDirectorshipList", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.XmlSerialization.IDCheckGlobalAlpha.Response.Directors", type = JAXBElement.class, required = false)
    protected JAXBElement<ArrayOfDirectorshipDirectorship> directorshipDirectorshipList;

    /**
     * Gets the value of the directorshipDirectorshipList property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfDirectorshipDirectorship }{@code >}
     *     
     */
    public JAXBElement<ArrayOfDirectorshipDirectorship> getDirectorshipDirectorshipList() {
        return directorshipDirectorshipList;
    }

    /**
     * Sets the value of the directorshipDirectorshipList property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfDirectorshipDirectorship }{@code >}
     *     
     */
    public void setDirectorshipDirectorshipList(JAXBElement<ArrayOfDirectorshipDirectorship> value) {
        this.directorshipDirectorshipList = value;
    }

}
