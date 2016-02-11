
package org.datacontract.schemas._2004._07.neuromancerlibrary_datacontracts;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;
import org.datacontract.schemas._2004._07.neuromancerlibrary_externalservices_iddocumentcheck_proxies.ResultsResponseModel;


/**
 * <p>Java class for IDDocumentCheckResult complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="IDDocumentCheckResult">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ResultsResponse" type="{http://schemas.datacontract.org/2004/07/NeuromancerLibrary.ExternalServices.IDDocumentCheck.Proxies.Results}ResultsResponseModel" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "IDDocumentCheckResult", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts.IDDocumentCheck", propOrder = {
    "resultsResponse"
})
public class IDDocumentCheckResult {

    @XmlElementRef(name = "ResultsResponse", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts.IDDocumentCheck", type = JAXBElement.class, required = false)
    protected JAXBElement<ResultsResponseModel> resultsResponse;

    /**
     * Gets the value of the resultsResponse property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ResultsResponseModel }{@code >}
     *     
     */
    public JAXBElement<ResultsResponseModel> getResultsResponse() {
        return resultsResponse;
    }

    /**
     * Sets the value of the resultsResponse property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ResultsResponseModel }{@code >}
     *     
     */
    public void setResultsResponse(JAXBElement<ResultsResponseModel> value) {
        this.resultsResponse = value;
    }

}
