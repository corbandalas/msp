
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
 *         &lt;element name="paymentRecordConfirmationResult" type="{http://merchantapi.envoyservices.com}PaymentRecord" minOccurs="0"/>
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
    "paymentRecordConfirmationResult"
})
@XmlRootElement(name = "paymentRecordConfirmationResponse")
public class PaymentRecordConfirmationResponse {

    protected PaymentRecord paymentRecordConfirmationResult;

    /**
     * Gets the value of the paymentRecordConfirmationResult property.
     * 
     * @return
     *     possible object is
     *     {@link PaymentRecord }
     *     
     */
    public PaymentRecord getPaymentRecordConfirmationResult() {
        return paymentRecordConfirmationResult;
    }

    /**
     * Sets the value of the paymentRecordConfirmationResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link PaymentRecord }
     *     
     */
    public void setPaymentRecordConfirmationResult(PaymentRecord value) {
        this.paymentRecordConfirmationResult = value;
    }

}
