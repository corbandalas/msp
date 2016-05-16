
package com.envoyservices.merchantapi;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for paymentResultV3 complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="paymentResultV3">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="epacsReference" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="merchantReference" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="paymentReference" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="paymentDetails" type="{http://merchantapi.envoyservices.com}PaymentDetailsV3" minOccurs="0"/>
 *         &lt;element name="bankDetails" type="{http://merchantapi.envoyservices.com}BankDetailsV3" minOccurs="0"/>
 *         &lt;element name="paymentTemplate" type="{http://merchantapi.envoyservices.com}PaymentTemplate" minOccurs="0"/>
 *         &lt;element name="paymentItemId" type="{http://microsoft.com/wsdl/types/}guid"/>
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
@XmlType(name = "paymentResultV3", propOrder = {
    "epacsReference",
    "merchantReference",
    "paymentReference",
    "paymentDetails",
    "bankDetails",
    "paymentTemplate",
    "paymentItemId",
    "paymentStatusCode",
    "paymentStatusMessage"
})
public class PaymentResultV3 {

    protected String epacsReference;
    protected String merchantReference;
    protected String paymentReference;
    protected PaymentDetailsV3 paymentDetails;
    protected BankDetailsV3 bankDetails;
    protected PaymentTemplate paymentTemplate;
    @XmlElement(required = true)
    protected String paymentItemId;
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
     * Gets the value of the bankDetails property.
     * 
     * @return
     *     possible object is
     *     {@link BankDetailsV3 }
     *     
     */
    public BankDetailsV3 getBankDetails() {
        return bankDetails;
    }

    /**
     * Sets the value of the bankDetails property.
     * 
     * @param value
     *     allowed object is
     *     {@link BankDetailsV3 }
     *     
     */
    public void setBankDetails(BankDetailsV3 value) {
        this.bankDetails = value;
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
