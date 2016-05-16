
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
 *         &lt;element name="auth" type="{http://merchantapi.envoyservices.com}Authentication" minOccurs="0"/>
 *         &lt;element name="oneClickServiceInfo" type="{http://merchantapi.envoyservices.com}OneClickServiceInfo" minOccurs="0"/>
 *         &lt;element name="paymentData" type="{http://merchantapi.envoyservices.com}PaymentData" minOccurs="0"/>
 *         &lt;element name="customerData" type="{http://merchantapi.envoyservices.com}CustomerData" minOccurs="0"/>
 *         &lt;element name="customerAccountDetails" type="{http://merchantapi.envoyservices.com}CustomerAccountDetails" minOccurs="0"/>
 *         &lt;element name="successUrl" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="cancelUrl" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="errorUrl" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
    "auth",
    "oneClickServiceInfo",
    "paymentData",
    "customerData",
    "customerAccountDetails",
    "successUrl",
    "cancelUrl",
    "errorUrl"
})
@XmlRootElement(name = "oneClickPaymentRequest")
public class OneClickPaymentRequest {

    protected Authentication auth;
    protected OneClickServiceInfo oneClickServiceInfo;
    protected PaymentData paymentData;
    protected CustomerData customerData;
    protected CustomerAccountDetails customerAccountDetails;
    protected String successUrl;
    protected String cancelUrl;
    protected String errorUrl;

    /**
     * Gets the value of the auth property.
     * 
     * @return
     *     possible object is
     *     {@link Authentication }
     *     
     */
    public Authentication getAuth() {
        return auth;
    }

    /**
     * Sets the value of the auth property.
     * 
     * @param value
     *     allowed object is
     *     {@link Authentication }
     *     
     */
    public void setAuth(Authentication value) {
        this.auth = value;
    }

    /**
     * Gets the value of the oneClickServiceInfo property.
     * 
     * @return
     *     possible object is
     *     {@link OneClickServiceInfo }
     *     
     */
    public OneClickServiceInfo getOneClickServiceInfo() {
        return oneClickServiceInfo;
    }

    /**
     * Sets the value of the oneClickServiceInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link OneClickServiceInfo }
     *     
     */
    public void setOneClickServiceInfo(OneClickServiceInfo value) {
        this.oneClickServiceInfo = value;
    }

    /**
     * Gets the value of the paymentData property.
     * 
     * @return
     *     possible object is
     *     {@link PaymentData }
     *     
     */
    public PaymentData getPaymentData() {
        return paymentData;
    }

    /**
     * Sets the value of the paymentData property.
     * 
     * @param value
     *     allowed object is
     *     {@link PaymentData }
     *     
     */
    public void setPaymentData(PaymentData value) {
        this.paymentData = value;
    }

    /**
     * Gets the value of the customerData property.
     * 
     * @return
     *     possible object is
     *     {@link CustomerData }
     *     
     */
    public CustomerData getCustomerData() {
        return customerData;
    }

    /**
     * Sets the value of the customerData property.
     * 
     * @param value
     *     allowed object is
     *     {@link CustomerData }
     *     
     */
    public void setCustomerData(CustomerData value) {
        this.customerData = value;
    }

    /**
     * Gets the value of the customerAccountDetails property.
     * 
     * @return
     *     possible object is
     *     {@link CustomerAccountDetails }
     *     
     */
    public CustomerAccountDetails getCustomerAccountDetails() {
        return customerAccountDetails;
    }

    /**
     * Sets the value of the customerAccountDetails property.
     * 
     * @param value
     *     allowed object is
     *     {@link CustomerAccountDetails }
     *     
     */
    public void setCustomerAccountDetails(CustomerAccountDetails value) {
        this.customerAccountDetails = value;
    }

    /**
     * Gets the value of the successUrl property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSuccessUrl() {
        return successUrl;
    }

    /**
     * Sets the value of the successUrl property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSuccessUrl(String value) {
        this.successUrl = value;
    }

    /**
     * Gets the value of the cancelUrl property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCancelUrl() {
        return cancelUrl;
    }

    /**
     * Sets the value of the cancelUrl property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCancelUrl(String value) {
        this.cancelUrl = value;
    }

    /**
     * Gets the value of the errorUrl property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getErrorUrl() {
        return errorUrl;
    }

    /**
     * Sets the value of the errorUrl property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setErrorUrl(String value) {
        this.errorUrl = value;
    }

}
