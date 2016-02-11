
package org.tempuri;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import org.datacontract.schemas._2004._07.neuromancerlibrary.ServiceResponse;


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
 *         &lt;element name="KYCCheckResult" type="{http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts}ServiceResponse" minOccurs="0"/>
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
    "kycCheckResult"
})
@XmlRootElement(name = "KYCCheckResponse")
public class KYCCheckResponse {

    @XmlElementRef(name = "KYCCheckResult", namespace = "http://tempuri.org/", type = JAXBElement.class, required = false)
    protected JAXBElement<ServiceResponse> kycCheckResult;

    /**
     * Gets the value of the kycCheckResult property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ServiceResponse }{@code >}
     *     
     */
    public JAXBElement<ServiceResponse> getKYCCheckResult() {
        return kycCheckResult;
    }

    /**
     * Sets the value of the kycCheckResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ServiceResponse }{@code >}
     *     
     */
    public void setKYCCheckResult(JAXBElement<ServiceResponse> value) {
        this.kycCheckResult = value;
    }

}
