
package com.envoyservices.merchantapi;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for paymentInstructionV3 complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="paymentInstructionV3">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="paymentDetails" type="{http://merchantapi.envoyservices.com}PaymentDetailsV3" minOccurs="0"/>
 *         &lt;element name="paymentTemplate" type="{http://merchantapi.envoyservices.com}PaymentTemplate" minOccurs="0"/>
 *         &lt;element name="paymentItemId" type="{http://microsoft.com/wsdl/types/}guid"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "paymentInstructionV3", propOrder = {
    "paymentDetails",
    "paymentTemplate",
    "paymentItemId"
})
public class PaymentInstructionV3 {

    protected PaymentDetailsV3 paymentDetails;
    protected PaymentTemplate paymentTemplate;
    @XmlElement(required = true)
    protected String paymentItemId;

    /**
     * Gets the value of the paymentDetails property.
     * 
     * @return
     *     possible object is
     *     {@link PaymentDetailsV3 }
     *     
     */
    public PaymentDetailsV3 getPaymentDetails() {
        return paymentDetails;
    }

    /**
     * Sets the value of the paymentDetails property.
     * 
     * @param value
     *     allowed object is
     *     {@link PaymentDetailsV3 }
     *     
     */
    public void setPaymentDetails(PaymentDetailsV3 value) {
        this.paymentDetails = value;
    }

    /**
     * Gets the value of the paymentTemplate property.
     * 
     * @return
     *     possible object is
     *     {@link PaymentTemplate }
     *     
     */
    public PaymentTemplate getPaymentTemplate() {
        return paymentTemplate;
    }

    /**
     * Sets the value of the paymentTemplate property.
     * 
     * @param value
     *     allowed object is
     *     {@link PaymentTemplate }
     *     
     */
    public void setPaymentTemplate(PaymentTemplate value) {
        this.paymentTemplate = value;
    }

    /**
     * Gets the value of the paymentItemId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPaymentItemId() {
        return paymentItemId;
    }

    /**
     * Sets the value of the paymentItemId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPaymentItemId(String value) {
        this.paymentItemId = value;
    }

}
