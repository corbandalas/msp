
package com.envoyservices.merchantapi;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for refundResultV2 complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="refundResultV2">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="refundQueueReference" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="refundDetails" type="{http://merchantapi.envoyservices.com}RefundDetailsV2" minOccurs="0"/>
 *         &lt;element name="paymentTemplate" type="{http://merchantapi.envoyservices.com}PaymentTemplate" minOccurs="0"/>
 *         &lt;element name="paymentItemId" type="{http://microsoft.com/wsdl/types/}guid"/>
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
@XmlType(name = "refundResultV2", propOrder = {
    "refundQueueReference",
    "refundDetails",
    "paymentTemplate",
    "paymentItemId",
    "refundErrors"
})
public class RefundResultV2 {

    protected String refundQueueReference;
    protected RefundDetailsV2 refundDetails;
    protected PaymentTemplate paymentTemplate;
    @XmlElement(required = true)
    protected String paymentItemId;
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
     *     {@link RefundDetailsV2 }
     *     
     */
    public RefundDetailsV2 getRefundDetails() {
        return refundDetails;
    }

    /**
     * Sets the value of the refundDetails property.
     * 
     * @param value
     *     allowed object is
     *     {@link RefundDetailsV2 }
     *     
     */
    public void setRefundDetails(RefundDetailsV2 value) {
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
