
package com.envoyservices.merchantapi;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for paymentInstructionV2 complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="paymentInstructionV2">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="paymentDetails" type="{http://merchantapi.envoyservices.com}PaymentDetailsV2" minOccurs="0"/>
 *         &lt;element name="bankDetails" type="{http://merchantapi.envoyservices.com}BankDetailsV2" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "paymentInstructionV2", propOrder = {
    "paymentDetails",
    "bankDetails"
})
public class PaymentInstructionV2 {

    protected PaymentDetailsV2 paymentDetails;
    protected BankDetailsV2 bankDetails;

    /**
     * Gets the value of the paymentDetails property.
     * 
     * @return
     *     possible object is
     *     {@link PaymentDetailsV2 }
     *     
     */
    public PaymentDetailsV2 getPaymentDetails() {
        return paymentDetails;
    }

    /**
     * Sets the value of the paymentDetails property.
     * 
     * @param value
     *     allowed object is
     *     {@link PaymentDetailsV2 }
     *     
     */
    public void setPaymentDetails(PaymentDetailsV2 value) {
        this.paymentDetails = value;
    }

    /**
     * Gets the value of the bankDetails property.
     * 
     * @return
     *     possible object is
     *     {@link BankDetailsV2 }
     *     
     */
    public BankDetailsV2 getBankDetails() {
        return bankDetails;
    }

    /**
     * Sets the value of the bankDetails property.
     * 
     * @param value
     *     allowed object is
     *     {@link BankDetailsV2 }
     *     
     */
    public void setBankDetails(BankDetailsV2 value) {
        this.bankDetails = value;
    }

}
