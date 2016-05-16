
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
 *         &lt;element name="getPaymentTemplatesV2Result" type="{http://merchantapi.envoyservices.com}PaymentTemplatesResponseV2" minOccurs="0"/>
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
    "getPaymentTemplatesV2Result"
})
@XmlRootElement(name = "getPaymentTemplatesV2Response")
public class GetPaymentTemplatesV2Response {

    protected PaymentTemplatesResponseV2 getPaymentTemplatesV2Result;

    /**
     * Gets the value of the getPaymentTemplatesV2Result property.
     * 
     * @return
     *     possible object is
     *     {@link PaymentTemplatesResponseV2 }
     *     
     */
    public PaymentTemplatesResponseV2 getGetPaymentTemplatesV2Result() {
        return getPaymentTemplatesV2Result;
    }

    /**
     * Sets the value of the getPaymentTemplatesV2Result property.
     * 
     * @param value
     *     allowed object is
     *     {@link PaymentTemplatesResponseV2 }
     *     
     */
    public void setGetPaymentTemplatesV2Result(PaymentTemplatesResponseV2 value) {
        this.getPaymentTemplatesV2Result = value;
    }

}
