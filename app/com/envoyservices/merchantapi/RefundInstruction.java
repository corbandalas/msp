
package com.envoyservices.merchantapi;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;
import com.envoyservices.epacsapi.PaymentTemplate;


/**
 * <p>Java class for refundInstruction complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="refundInstruction">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="refundDetails" type="{http://merchantapi.envoyservices.com}RefundDetails" minOccurs="0"/>
 *         &lt;element name="paymentTemplate" type="{http://envoyservices.com/epacsapi}PaymentTemplate" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "refundInstruction", propOrder = {
    "refundDetails",
    "paymentTemplate"
})
public class RefundInstruction {

    protected RefundDetails refundDetails;
    protected PaymentTemplate paymentTemplate;

    /**
     * Gets the value of the refundDetails property.
     * 
     * @return
     *     possible object is
     *     {@link RefundDetails }
     *     
     */
    public RefundDetails getRefundDetails() {
        return refundDetails;
    }

    /**
     * Sets the value of the refundDetails property.
     * 
     * @param value
     *     allowed object is
     *     {@link RefundDetails }
     *     
     */
    public void setRefundDetails(RefundDetails value) {
        this.refundDetails = value;
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

}
