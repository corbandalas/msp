
package com.envoyservices.merchantapi;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


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
 *         &lt;element name="cancelPayinConfirmationResult" type="{http://merchantapi.envoyservices.com}CancelConfirmationResponse" minOccurs="0"/>
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
    "cancelPayinConfirmationResult"
})
@XmlRootElement(name = "cancelPayinConfirmationResponse")
public class CancelPayinConfirmationResponse {

    protected CancelConfirmationResponse cancelPayinConfirmationResult;

    /**
     * Gets the value of the cancelPayinConfirmationResult property.
     * 
     * @return
     *     possible object is
     *     {@link CancelConfirmationResponse }
     *     
     */
    public CancelConfirmationResponse getCancelPayinConfirmationResult() {
        return cancelPayinConfirmationResult;
    }

    /**
     * Sets the value of the cancelPayinConfirmationResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link CancelConfirmationResponse }
     *     
     */
    public void setCancelPayinConfirmationResult(CancelConfirmationResponse value) {
        this.cancelPayinConfirmationResult = value;
    }

}
