
package org.tempuri;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import org.datacontract.schemas._2004._07.neuromancerlibrary_datacontracts.DocumentUploadRequest;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="documentUploadRequest" type="{http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts.DocumentUpload}DocumentUploadRequest" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "documentUploadRequest"
})
@XmlRootElement(name = "UploadDocument")
public class UploadDocument {

    @XmlElementRef(name = "documentUploadRequest", namespace = "http://tempuri.org/", type = JAXBElement.class, required = false)
    protected JAXBElement<DocumentUploadRequest> documentUploadRequest;

    /**
     * Gets the value of the documentUploadRequest property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link DocumentUploadRequest }{@code >}
     *     
     */
    public JAXBElement<DocumentUploadRequest> getDocumentUploadRequest() {
        return documentUploadRequest;
    }

    /**
     * Sets the value of the documentUploadRequest property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link DocumentUploadRequest }{@code >}
     *     
     */
    public void setDocumentUploadRequest(JAXBElement<DocumentUploadRequest> value) {
        this.documentUploadRequest = value;
    }

}
