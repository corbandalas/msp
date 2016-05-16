
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
 *         &lt;element name="cancelPayinResult" type="{http://merchantapi.envoyservices.com}CancelResponse" minOccurs="0"/>
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
    "cancelPayinResult"
})
@XmlRootElement(name = "cancelPayinResponse")
public class CancelPayinResponse {

    protected CancelResponse cancelPayinResult;

    /**
     * Gets the value of the cancelPayinResult property.
     * 
     * @return
     *     possible object is
     *     {@link CancelResponse }
     *     
     */
    public CancelResponse getCancelPayinResult() {
        return cancelPayinResult;
    }

    /**
     * Sets the value of the cancelPayinResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link CancelResponse }
     *     
     */
    public void setCancelPayinResult(CancelResponse value) {
        this.cancelPayinResult = value;
    }

}
