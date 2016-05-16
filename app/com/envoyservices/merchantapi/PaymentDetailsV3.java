
package com.envoyservices.merchantapi;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for PaymentDetailsV3 complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PaymentDetailsV3">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="countryCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="sourceCurrency" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="sourceAmount" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="targetCurrency" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="targetAmount" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="sourceOrTarget" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="merchantReference" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="paymentReference" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="email" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="mobile" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="fastPayment" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="forexReference" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="paymentDescription" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="paymentAdditionalData" type="{http://merchantapi.envoyservices.com}ArrayOfAdditionalData" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PaymentDetailsV3", propOrder = {
    "countryCode",
    "sourceCurrency",
    "sourceAmount",
    "targetCurrency",
    "targetAmount",
    "sourceOrTarget",
    "merchantReference",
    "paymentReference",
    "email",
    "mobile",
    "fastPayment",
    "forexReference",
    "paymentDescription",
    "paymentAdditionalData"
})
public class PaymentDetailsV3 {

    protected String countryCode;
    protected String sourceCurrency;
    protected double sourceAmount;
    protected String targetCurrency;
    protected double targetAmount;
    protected String sourceOrTarget;
    protected String merchantReference;
    protected String paymentReference;
    protected String email;
    protected String mobile;
    protected String fastPayment;
    protected String forexReference;
    protected String paymentDescription;
    protected ArrayOfAdditionalData paymentAdditionalData;

    /**
     * Gets the value of the countryCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCountryCode() {
        return countryCode;
    }

    /**
     * Sets the value of the countryCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCountryCode(String value) {
        this.countryCode = value;
    }

    /**
     * Gets the value of the sourceCurrency property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSourceCurrency() {
        return sourceCurrency;
    }

    /**
     * Sets the value of the sourceCurrency property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSourceCurrency(String value) {
        this.sourceCurrency = value;
    }

    /**
     * Gets the value of the sourceAmount property.
     * 
     */
    public double getSourceAmount() {
        return sourceAmount;
    }

    /**
     * Sets the value of the sourceAmount property.
     * 
     */
    public void setSourceAmount(double value) {
        this.sourceAmount = value;
    }

    /**
     * Gets the value of the targetCurrency property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTargetCurrency() {
        return targetCurrency;
    }

    /**
     * Sets the value of the targetCurrency property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTargetCurrency(String value) {
        this.targetCurrency = value;
    }

    /**
     * Gets the value of the targetAmount property.
     * 
     */
    public double getTargetAmount() {
        return targetAmount;
    }

    /**
     * Sets the value of the targetAmount property.
     * 
     */
    public void setTargetAmount(double value) {
        this.targetAmount = value;
    }

    /**
     * Gets the value of the sourceOrTarget property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSourceOrTarget() {
        return sourceOrTarget;
    }

    /**
     * Sets the value of the sourceOrTarget property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSourceOrTarget(String value) {
        this.sourceOrTarget = value;
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
     * Gets the value of the email property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the value of the email property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEmail(String value) {
        this.email = value;
    }

    /**
     * Gets the value of the mobile property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMobile() {
        return mobile;
    }

    /**
     * Sets the value of the mobile property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMobile(String value) {
        this.mobile = value;
    }

    /**
     * Gets the value of the fastPayment property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFastPayment() {
        return fastPayment;
    }

    /**
     * Sets the value of the fastPayment property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFastPayment(String value) {
        this.fastPayment = value;
    }

    /**
     * Gets the value of the forexReference property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getForexReference() {
        return forexReference;
    }

    /**
     * Sets the value of the forexReference property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setForexReference(String value) {
        this.forexReference = value;
    }

    /**
     * Gets the value of the paymentDescription property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPaymentDescription() {
        return paymentDescription;
    }

    /**
     * Sets the value of the paymentDescription property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPaymentDescription(String value) {
        this.paymentDescription = value;
    }

    /**
     * Gets the value of the paymentAdditionalData property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfAdditionalData }
     *     
     */
    public ArrayOfAdditionalData getPaymentAdditionalData() {
        return paymentAdditionalData;
    }

    /**
     * Sets the value of the paymentAdditionalData property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfAdditionalData }
     *     
     */
    public void setPaymentAdditionalData(ArrayOfAdditionalData value) {
        this.paymentAdditionalData = value;
    }

}
