
package org.datacontract.schemas._2004._07.neuromancerlibrary_datacontracts;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;
import com.microsoft.schemas._2003._10.serialization.arrays.ArrayOfKeyValueOfstringstring;
import org.datacontract.schemas._2004._07.databaselibrary.DocumentTypeEnum;
import org.datacontract.schemas._2004._07.neuromancerlibrary.BaseRequest;
import org.datacontract.schemas._2004._07.neuromancerlibrary.ServiceAuthorisation;


/**
 * <p>Java class for DocumentUploadRequest complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DocumentUploadRequest">
 *   &lt;complexContent>
 *     &lt;extension base="{http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts}BaseRequest">
 *       &lt;sequence>
 *         &lt;element name="DocumentData" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="DocumentExpiry" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="DocumentReference" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="DocumentType" type="{http://schemas.datacontract.org/2004/07/DatabaseLibrary.Enums}DocumentTypeEnum" minOccurs="0"/>
 *         &lt;element name="QueryOptions" type="{http://schemas.microsoft.com/2003/10/Serialization/Arrays}ArrayOfKeyValueOfstringstring" minOccurs="0"/>
 *         &lt;element name="ServiceAuthorisation" type="{http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts}ServiceAuthorisation" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DocumentUploadRequest", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts.DocumentUpload", propOrder = {
    "documentData",
    "documentExpiry",
    "documentReference",
    "documentType",
    "queryOptions",
    "serviceAuthorisation"
})
public class DocumentUploadRequest
    extends BaseRequest
{

    @XmlElementRef(name = "DocumentData", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts.DocumentUpload", type = JAXBElement.class, required = false)
    protected JAXBElement<String> documentData;
    @XmlElementRef(name = "DocumentExpiry", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts.DocumentUpload", type = JAXBElement.class, required = false)
    protected JAXBElement<XMLGregorianCalendar> documentExpiry;
    @XmlElementRef(name = "DocumentReference", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts.DocumentUpload", type = JAXBElement.class, required = false)
    protected JAXBElement<String> documentReference;
    @XmlElement(name = "DocumentType")
    @XmlSchemaType(name = "string")
    protected DocumentTypeEnum documentType;
    @XmlElementRef(name = "QueryOptions", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts.DocumentUpload", type = JAXBElement.class, required = false)
    protected JAXBElement<ArrayOfKeyValueOfstringstring> queryOptions;
    @XmlElementRef(name = "ServiceAuthorisation", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts.DocumentUpload", type = JAXBElement.class, required = false)
    protected JAXBElement<ServiceAuthorisation> serviceAuthorisation;

    /**
     * Gets the value of the documentData property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getDocumentData() {
        return documentData;
    }

    /**
     * Sets the value of the documentData property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setDocumentData(JAXBElement<String> value) {
        this.documentData = value;
    }

    /**
     * Gets the value of the documentExpiry property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     *     
     */
    public JAXBElement<XMLGregorianCalendar> getDocumentExpiry() {
        return documentExpiry;
    }

    /**
     * Sets the value of the documentExpiry property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     *     
     */
    public void setDocumentExpiry(JAXBElement<XMLGregorianCalendar> value) {
        this.documentExpiry = value;
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
     * Gets the value of the documentType property.
     * 
     * @return
     *     possible object is
     *     {@link DocumentTypeEnum }
     *     
     */
    public DocumentTypeEnum getDocumentType() {
        return documentType;
    }

    /**
     * Sets the value of the documentType property.
     * 
     * @param value
     *     allowed object is
     *     {@link DocumentTypeEnum }
     *     
     */
    public void setDocumentType(DocumentTypeEnum value) {
        this.documentType = value;
    }

    /**
     * Gets the value of the queryOptions property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfKeyValueOfstringstring }{@code >}
     *     
     */
    public JAXBElement<ArrayOfKeyValueOfstringstring> getQueryOptions() {
        return queryOptions;
    }

    /**
     * Sets the value of the queryOptions property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfKeyValueOfstringstring }{@code >}
     *     
     */
    public void setQueryOptions(JAXBElement<ArrayOfKeyValueOfstringstring> value) {
        this.queryOptions = value;
    }

    /**
     * Gets the value of the serviceAuthorisation property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ServiceAuthorisation }{@code >}
     *     
     */
    public JAXBElement<ServiceAuthorisation> getServiceAuthorisation() {
        return serviceAuthorisation;
    }

    /**
     * Sets the value of the serviceAuthorisation property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ServiceAuthorisation }{@code >}
     *     
     */
    public void setServiceAuthorisation(JAXBElement<ServiceAuthorisation> value) {
        this.serviceAuthorisation = value;
    }

}
