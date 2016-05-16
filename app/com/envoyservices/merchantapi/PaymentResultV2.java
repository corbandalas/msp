
package com.envoyservices.merchantapi;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for paymentResultV2 complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="paymentResultV2">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="epacsReference" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="merchantReference" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="paymentReference" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="paymentDetails" type="{http://merchantapi.envoyservices.com}PaymentDetailsV2" minOccurs="0"/>
 *         &lt;element name="bankDetails" type="{http://merchantapi.envoyservices.com}BankDetailsV2" minOccurs="0"/>
 *         &lt;element name="paymentStatusCode" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="paymentStatusMessage" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "paymentResultV2", propOrder = {
    "epacsReference",
    "merchantReference",
    "paymentReference",
    "paymentDetails",
    "bankDetails",
    "paymentStatusCode",
    "paymentStatusMessage"
})
public class PaymentResultV2 {

    protected String epacsReference;
    protected String merchantReference;
    protected String paymentReference;
    protected PaymentDetailsV2 paymentDetails;
    protected BankDetailsV2 bankDetails;
    protected int paymentStatusCode;
    protected String paymentStatusMessage;

    /**
     * Gets the value of the epacsReference property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEpacsReference() {
        return epacsReference;
    }

    /**
     * Sets the value of the epacsReference property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEpacsReference(String value) {
        this.epacsReference = value;
    }

    /**
     * Gets the value of the merchantReference property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMerchantReference() {
        return merchantReference;
    }

    /**
     * Sets the value of the merchantReference property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMerchantReference(String value) {
        this.merchantReference = value;
    }

    /**
     * Gets the value of the paymentReference property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPaymentReference() {
        return paymentReference;
    }

    /**
     * Sets the value of the paymentReference property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPaymentReference(String value) {
        this.paymentReference = value;
    }

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

    /**
     * Gets the value of the paymentStatusCode property.
     * 
     */
    public int getPaymentStatusCode() {
        return paymentStatusCode;
    }

    /**
     * Sets the value of the paymentStatusCode property.
     * 
     */
    public void setPaymentStatusCode(int value) {
        this.paymentStatusCode = value;
    }

    /**
     * Gets the value of the paymentStatusMessage property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPaymentStatusMessage() {
        return paymentStatusMessage;
    }

    /**
     * Sets the value of the paymentStatusMessage property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPaymentStatusMessage(String value) {
        this.paymentStatusMessage = value;
    }

}
