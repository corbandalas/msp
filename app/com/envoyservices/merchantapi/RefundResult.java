
package com.envoyservices.merchantapi;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;
import com.envoyservices.epacsapi.PaymentTemplate;


/**
 * <p>Java class for refundResult complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="refundResult">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="refundQueueReference" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="refundDetails" type="{http://merchantapi.envoyservices.com}RefundDetails" minOccurs="0"/>
 *         &lt;element name="paymentTemplate" type="{http://envoyservices.com/epacsapi}PaymentTemplate" minOccurs="0"/>
 *         &lt;element name="refundErrors" type="{http://merchantapi.envoyservices.com}ArrayOfRefundError" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "refundResult", propOrder = {
    "refundQueueReference",
    "refundDetails",
    "paymentTemplate",
    "refundErrors"
})
public class RefundResult {

    protected String refundQueueReference;
    protected RefundDetails refundDetails;
    protected PaymentTemplate paymentTemplate;
    protected ArrayOfRefundError refundErrors;

    /**
     * Gets the value of the refundQueueReference property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRefundQueueReference() {
        return refundQueueReference;
    }

    /**
     * Sets the value of the refundQueueReference property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRefundQueueReference(String value) {
        this.refundQueueReference = value;
    }

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

    /**
     * Gets the value of the refundErrors property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfRefundError }
     *     
     */
    public ArrayOfRefundError getRefundErrors() {
        return refundErrors;
    }

    /**
     * Sets the value of the refundErrors property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfRefundError }
     *     
     */
    public void setRefundErrors(ArrayOfRefundError value) {
        this.refundErrors = value;
    }

}
