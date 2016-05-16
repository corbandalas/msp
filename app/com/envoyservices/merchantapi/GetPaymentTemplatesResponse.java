
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
 *         &lt;element name="getPaymentTemplatesResult" type="{http://merchantapi.envoyservices.com}PaymentTemplatesResponse" minOccurs="0"/>
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
    "getPaymentTemplatesResult"
})
@XmlRootElement(name = "getPaymentTemplatesResponse")
public class GetPaymentTemplatesResponse {

    protected PaymentTemplatesResponse getPaymentTemplatesResult;

    /**
     * Gets the value of the getPaymentTemplatesResult property.
     * 
     * @return
     *     possible object is
     *     {@link PaymentTemplatesResponse }
     *     
     */
    public PaymentTemplatesResponse getGetPaymentTemplatesResult() {
        return getPaymentTemplatesResult;
    }

    /**
     * Sets the value of the getPaymentTemplatesResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link PaymentTemplatesResponse }
     *     
     */
    public void setGetPaymentTemplatesResult(PaymentTemplatesResponse value) {
        this.getPaymentTemplatesResult = value;
    }

}
