
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
 *         &lt;element name="payInConfirmationResult" type="{http://merchantapi.envoyservices.com}PaymentConfirmation" minOccurs="0"/>
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
    "payInConfirmationResult"
})
@XmlRootElement(name = "payInConfirmationResponse")
public class PayInConfirmationResponse {

    protected PaymentConfirmation payInConfirmationResult;

    /**
     * Gets the value of the payInConfirmationResult property.
     * 
     * @return
     *     possible object is
     *     {@link PaymentConfirmation }
     *     
     */
    public PaymentConfirmation getPayInConfirmationResult() {
        return payInConfirmationResult;
    }

    /**
     * Sets the value of the payInConfirmationResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link PaymentConfirmation }
     *     
     */
    public void setPayInConfirmationResult(PaymentConfirmation value) {
        this.payInConfirmationResult = value;
    }

}
