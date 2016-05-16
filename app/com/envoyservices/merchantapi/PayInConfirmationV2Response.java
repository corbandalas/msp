
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
 *         &lt;element name="payInConfirmationV2Result" type="{http://merchantapi.envoyservices.com}PaymentConfirmationV2" minOccurs="0"/>
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
    "payInConfirmationV2Result"
})
@XmlRootElement(name = "payInConfirmationV2Response")
public class PayInConfirmationV2Response {

    protected PaymentConfirmationV2 payInConfirmationV2Result;

    /**
     * Gets the value of the payInConfirmationV2Result property.
     * 
     * @return
     *     possible object is
     *     {@link PaymentConfirmationV2 }
     *     
     */
    public PaymentConfirmationV2 getPayInConfirmationV2Result() {
        return payInConfirmationV2Result;
    }

    /**
     * Sets the value of the payInConfirmationV2Result property.
     * 
     * @param value
     *     allowed object is
     *     {@link PaymentConfirmationV2 }
     *     
     */
    public void setPayInConfirmationV2Result(PaymentConfirmationV2 value) {
        this.payInConfirmationV2Result = value;
    }

}
