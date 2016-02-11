
package org.datacontract.schemas._2004._07.neuromancerlibrary;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import org.datacontract.schemas._2004._07.databaselibrary.ServiceEnum;


/**
 * <p>Java class for UploadedFile complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="UploadedFile">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="DocumentReference" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="DocumentUID" type="{http://schemas.microsoft.com/2003/10/Serialization/}guid"/>
 *         &lt;element name="Group" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Index" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="Service" type="{http://schemas.datacontract.org/2004/07/DatabaseLibrary.Enums}ServiceEnum"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "UploadedFile", propOrder = {
    "documentReference",
    "documentUID",
    "group",
    "index",
    "service"
})
public class UploadedFile {

    @XmlElementRef(name = "DocumentReference", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts", type = JAXBElement.class, required = false)
    protected JAXBElement<String> documentReference;
    @XmlElement(name = "DocumentUID", required = true)
    protected String documentUID;
    @XmlElementRef(name = "Group", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts", type = JAXBElement.class, required = false)
    protected JAXBElement<String> group;
    @XmlElementRef(name = "Index", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts", type = JAXBElement.class, required = false)
    protected JAXBElement<Integer> index;
    @XmlElement(name = "Service", required = true)
    @XmlSchemaType(name = "string")
    protected ServiceEnum service;

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
     * Gets the value of the group property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getGroup() {
        return group;
    }

    /**
     * Sets the value of the group property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setGroup(JAXBElement<String> value) {
        this.group = value;
    }

    /**
     * Gets the value of the index property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Integer }{@code >}
     *     
     */
    public JAXBElement<Integer> getIndex() {
        return index;
    }

    /**
     * Sets the value of the index property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Integer }{@code >}
     *     
     */
    public void setIndex(JAXBElement<Integer> value) {
        this.index = value;
    }

    /**
     * Gets the value of the service property.
     * 
     * @return
     *     possible object is
     *     {@link ServiceEnum }
     *     
     */
    public ServiceEnum getService() {
        return service;
    }

    /**
     * Sets the value of the service property.
     * 
     * @param value
     *     allowed object is
     *     {@link ServiceEnum }
     *     
     */
    public void setService(ServiceEnum value) {
        this.service = value;
    }

}
