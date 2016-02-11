
package org.datacontract.schemas._2004._07.neuromancerlibrary;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;
import com.microsoft.schemas._2003._10.serialization.arrays.ArrayOfKeyValueOfstringstring;


/**
 * <p>Java class for ServiceRequest complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ServiceRequest">
 *   &lt;complexContent>
 *     &lt;extension base="{http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts}BaseRequest">
 *       &lt;sequence>
 *         &lt;element name="BundleData" type="{http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts}BundleData" minOccurs="0"/>
 *         &lt;element name="QueryData" type="{http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts}QueryData" minOccurs="0"/>
 *         &lt;element name="QueryOptions" type="{http://schemas.microsoft.com/2003/10/Serialization/Arrays}ArrayOfKeyValueOfstringstring" minOccurs="0"/>
 *         &lt;element name="ServiceAuthorisation" type="{http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts}ServiceAuthorisation" minOccurs="0"/>
 *         &lt;element name="UploadedFiles" type="{http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts}ArrayOfUploadedFile" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ServiceRequest", propOrder = {
    "bundleData",
    "queryData",
    "queryOptions",
    "serviceAuthorisation",
    "uploadedFiles"
})
public class ServiceRequest
    extends BaseRequest
{

    @XmlElementRef(name = "BundleData", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts", type = JAXBElement.class, required = false)
    protected JAXBElement<BundleData> bundleData;
    @XmlElementRef(name = "QueryData", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts", type = JAXBElement.class, required = false)
    protected JAXBElement<QueryData> queryData;
    @XmlElementRef(name = "QueryOptions", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts", type = JAXBElement.class, required = false)
    protected JAXBElement<ArrayOfKeyValueOfstringstring> queryOptions;
    @XmlElementRef(name = "ServiceAuthorisation", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts", type = JAXBElement.class, required = false)
    protected JAXBElement<ServiceAuthorisation> serviceAuthorisation;
    @XmlElementRef(name = "UploadedFiles", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts", type = JAXBElement.class, required = false)
    protected JAXBElement<ArrayOfUploadedFile> uploadedFiles;

    /**
     * Gets the value of the bundleData property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link BundleData }{@code >}
     *     
     */
    public JAXBElement<BundleData> getBundleData() {
        return bundleData;
    }

    /**
     * Sets the value of the bundleData property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link BundleData }{@code >}
     *     
     */
    public void setBundleData(JAXBElement<BundleData> value) {
        this.bundleData = value;
    }

    /**
     * Gets the value of the queryData property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link QueryData }{@code >}
     *     
     */
    public JAXBElement<QueryData> getQueryData() {
        return queryData;
    }

    /**
     * Sets the value of the queryData property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link QueryData }{@code >}
     *     
     */
    public void setQueryData(JAXBElement<QueryData> value) {
        this.queryData = value;
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

    /**
     * Gets the value of the uploadedFiles property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfUploadedFile }{@code >}
     *     
     */
    public JAXBElement<ArrayOfUploadedFile> getUploadedFiles() {
        return uploadedFiles;
    }

    /**
     * Sets the value of the uploadedFiles property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfUploadedFile }{@code >}
     *     
     */
    public void setUploadedFiles(JAXBElement<ArrayOfUploadedFile> value) {
        this.uploadedFiles = value;
    }

}
