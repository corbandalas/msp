
package org.datacontract.schemas._2004._07.neuromancerlibrary_externalservices_iddocumentcheck_proxies;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for DocumentCheckFailureResponseElementModel complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DocumentCheckFailureResponseElementModel">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="DocumentCheck" type="{http://schemas.datacontract.org/2004/07/NeuromancerLibrary.ExternalServices.IDDocumentCheck.Proxies.Results}ArrayOfDocumentCheckFailureItemElementModel" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DocumentCheckFailureResponseElementModel", propOrder = {
    "documentCheck"
})
public class DocumentCheckFailureResponseElementModel {

    @XmlElementRef(name = "DocumentCheck", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.ExternalServices.IDDocumentCheck.Proxies.Results", type = JAXBElement.class, required = false)
    protected JAXBElement<ArrayOfDocumentCheckFailureItemElementModel> documentCheck;

    /**
     * Gets the value of the documentCheck property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfDocumentCheckFailureItemElementModel }{@code >}
     *     
     */
    public JAXBElement<ArrayOfDocumentCheckFailureItemElementModel> getDocumentCheck() {
        return documentCheck;
    }

    /**
     * Sets the value of the documentCheck property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfDocumentCheckFailureItemElementModel }{@code >}
     *     
     */
    public void setDocumentCheck(JAXBElement<ArrayOfDocumentCheckFailureItemElementModel> value) {
        this.documentCheck = value;
    }

}
