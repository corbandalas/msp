
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
 *         &lt;element name="oneClickPaymentRequestV2Result" type="{http://merchantapi.envoyservices.com}OneClickPaymentResponseV2" minOccurs="0"/>
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
    "oneClickPaymentRequestV2Result"
})
@XmlRootElement(name = "oneClickPaymentRequestV2Response")
public class OneClickPaymentRequestV2Response {

    protected OneClickPaymentResponseV2 oneClickPaymentRequestV2Result;

    /**
     * Gets the value of the oneClickPaymentRequestV2Result property.
     * 
     * @return
     *     possible object is
     *     {@link OneClickPaymentResponseV2 }
     *     
     */
    public OneClickPaymentResponseV2 getOneClickPaymentRequestV2Result() {
        return oneClickPaymentRequestV2Result;
    }

    /**
     * Sets the value of the oneClickPaymentRequestV2Result property.
     * 
     * @param value
     *     allowed object is
     *     {@link OneClickPaymentResponseV2 }
     *     
     */
    public void setOneClickPaymentRequestV2Result(OneClickPaymentResponseV2 value) {
        this.oneClickPaymentRequestV2Result = value;
    }

}
