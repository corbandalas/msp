
package org.datacontract.schemas._2004._07.neuromancerlibrary_datacontracts;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import org.datacontract.schemas._2004._07.databaselibrary.DocumentTypeEnum;
import org.datacontract.schemas._2004._07.neuromancerlibrary.BaseResponse;


/**
 * <p>Java class for DocumentUploadResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DocumentUploadResponse">
 *   &lt;complexContent>
 *     &lt;extension base="{http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts}BaseResponse">
 *       &lt;sequence>
 *         &lt;element name="BytesUploaded" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="DocumentReference" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="DocumentTypeValidationSucceeded" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="DocumentUID" type="{http://schemas.microsoft.com/2003/10/Serialization/}guid" minOccurs="0"/>
 *         &lt;element name="ResolvedDocumentType" type="{http://schemas.datacontract.org/2004/07/DatabaseLibrary.Enums}DocumentTypeEnum" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DocumentUploadResponse", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts.DocumentUpload", propOrder = {
    "bytesUploaded",
    "documentReference",
    "documentTypeValidationSucceeded",
    "documentUID",
    "resolvedDocumentType"
})
public class DocumentUploadResponse
    extends BaseResponse
{

    @XmlElement(name = "BytesUploaded")
    protected Long bytesUploaded;
    @XmlElementRef(name = "DocumentReference", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts.DocumentUpload", type = JAXBElement.class, required = false)
    protected JAXBElement<String> documentReference;
    @XmlElement(name = "DocumentTypeValidationSucceeded")
    protected Boolean documentTypeValidationSucceeded;
    @XmlElement(name = "DocumentUID")
    protected String documentUID;
    @XmlElement(name = "ResolvedDocumentType")
    @XmlSchemaType(name = "string")
    protected DocumentTypeEnum resolvedDocumentType;

    /**
     * Gets the value of the bytesUploaded property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getBytesUploaded() {
        return bytesUploaded;
    }

    /**
     * Sets the value of the bytesUploaded property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setBytesUploaded(Long value) {
        this.bytesUploaded = value;
    }

    /**
     * Gets the value of the documentReference property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getDocumentReference() {
        return documentReference;
    }

    /**
     * Sets the value of the documentReference property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setDocumentReference(JAXBElement<String> value) {
        this.documentReference = value;
    }

    /**
     * Gets the value of the documentTypeValidationSucceeded property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isDocumentTypeValidationSucceeded() {
        return documentTypeValidationSucceeded;
    }

    /**
     * Sets the value of the documentTypeValidationSucceeded property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setDocumentTypeValidationSucceeded(Boolean value) {
        this.documentTypeValidationSucceeded = value;
    }

    /**
     * Gets the value of the documentUID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDocumentUID() {
        return documentUID;
    }

    /**
     * Sets the value of the documentUID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDocumentUID(String value) {
        this.documentUID = value;
    }

    /**
     * Gets the value of the resolvedDocumentType property.
     * 
     * @return
     *     possible object is
     *     {@link DocumentTypeEnum }
     *     
     */
    public DocumentTypeEnum getResolvedDocumentType() {
        return resolvedDocumentType;
    }

    /**
     * Sets the value of the resolvedDocumentType property.
     * 
     * @param value
     *     allowed object is
     *     {@link DocumentTypeEnum }
     *     
     */
    public void setResolvedDocumentType(DocumentTypeEnum value) {
        this.resolvedDocumentType = value;
    }

}
