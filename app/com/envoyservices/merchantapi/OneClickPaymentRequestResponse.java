
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
 *         &lt;element name="oneClickPaymentRequestResult" type="{http://merchantapi.envoyservices.com}OneClickPaymentResponse" minOccurs="0"/>
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
    "oneClickPaymentRequestResult"
})
@XmlRootElement(name = "oneClickPaymentRequestResponse")
public class OneClickPaymentRequestResponse {

    protected OneClickPaymentResponse oneClickPaymentRequestResult;

    /**
     * Gets the value of the oneClickPaymentRequestResult property.
     * 
     * @return
     *     possible object is
     *     {@link OneClickPaymentResponse }
     *     
     */
    public OneClickPaymentResponse getOneClickPaymentRequestResult() {
        return oneClickPaymentRequestResult;
    }

    /**
     * Sets the value of the oneClickPaymentRequestResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link OneClickPaymentResponse }
     *     
     */
    public void setOneClickPaymentRequestResult(OneClickPaymentResponse value) {
        this.oneClickPaymentRequestResult = value;
    }

}
