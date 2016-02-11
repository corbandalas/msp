
package org.datacontract.schemas._2004._07.neuromancerlibrary_externalservices_iddocumentcheck_proxies;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for DocumentCheckSuccessItemElementModel complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DocumentCheckSuccessItemElementModel">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Document" type="{http://schemas.datacontract.org/2004/07/NeuromancerLibrary.ExternalServices.IDDocumentCheck.Proxies.Results}DocumentDetailsSuccessResponseElementModel" minOccurs="0"/>
 *         &lt;element name="DocumentIndex" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="Id" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PersonalInfo" type="{http://schemas.datacontract.org/2004/07/NeuromancerLibrary.ExternalServices.IDDocumentCheck.Proxies.Results}PersonalInformationResponseElementModel" minOccurs="0"/>
 *         &lt;element name="Status" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DocumentCheckSuccessItemElementModel", propOrder = {
    "document",
    "documentIndex",
    "id",
    "personalInfo",
    "status"
})
public class DocumentCheckSuccessItemElementModel {

    @XmlElementRef(name = "Document", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.ExternalServices.IDDocumentCheck.Proxies.Results", type = JAXBElement.class, required = false)
    protected JAXBElement<DocumentDetailsSuccessResponseElementModel> document;
    @XmlElement(name = "DocumentIndex")
    protected Integer documentIndex;
    @XmlElementRef(name = "Id", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.ExternalServices.IDDocumentCheck.Proxies.Results", type = JAXBElement.class, required = false)
    protected JAXBElement<String> id;
    @XmlElementRef(name = "PersonalInfo", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.ExternalServices.IDDocumentCheck.Proxies.Results", type = JAXBElement.class, required = false)
    protected JAXBElement<PersonalInformationResponseElementModel> personalInfo;
    @XmlElementRef(name = "Status", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.ExternalServices.IDDocumentCheck.Proxies.Results", type = JAXBElement.class, required = false)
    protected JAXBElement<String> status;

    /**
     * Gets the value of the document property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link DocumentDetailsSuccessResponseElementModel }{@code >}
     *     
     */
    public JAXBElement<DocumentDetailsSuccessResponseElementModel> getDocument() {
        return document;
    }

    /**
     * Sets the value of the document property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link DocumentDetailsSuccessResponseElementModel }{@code >}
     *     
     */
    public void setDocument(JAXBElement<DocumentDetailsSuccessResponseElementModel> value) {
        this.document = value;
    }

    /**
     * Gets the value of the documentIndex property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getDocumentIndex() {
        return documentIndex;
    }

    /**
     * Sets the value of the documentIndex property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setDocumentIndex(Integer value) {
        this.documentIndex = value;
    }

    /**
     * Gets the value of the id property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setId(JAXBElement<String> value) {
        this.id = value;
    }

    /**
     * Gets the value of the personalInfo property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link PersonalInformationResponseElementModel }{@code >}
     *     
     */
    public JAXBElement<PersonalInformationResponseElementModel> getPersonalInfo() {
        return personalInfo;
    }

    /**
     * Sets the value of the personalInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link PersonalInformationResponseElementModel }{@code >}
     *     
     */
    public void setPersonalInfo(JAXBElement<PersonalInformationResponseElementModel> value) {
        this.personalInfo = value;
    }

    /**
     * Gets the value of the status property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getStatus() {
        return status;
    }

    /**
     * Sets the value of the status property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setStatus(JAXBElement<String> value) {
        this.status = value;
    }

}
