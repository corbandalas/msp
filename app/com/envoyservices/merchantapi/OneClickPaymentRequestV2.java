
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
 *         &lt;element name="oneClickServiceInfo" type="{http://merchantapi.envoyservices.com}OneClickServiceInfoV2" minOccurs="0"/>
 *         &lt;element name="paymentData" type="{http://merchantapi.envoyservices.com}PaymentData" minOccurs="0"/>
 *         &lt;element name="customerData" type="{http://merchantapi.envoyservices.com}CustomerDataV2" minOccurs="0"/>
 *         &lt;element name="customerAccountDetails" type="{http://merchantapi.envoyservices.com}CustomerAccountDetails" minOccurs="0"/>
 *         &lt;element name="redirectionUrls" type="{http://merchantapi.envoyservices.com}RedirectionUrls" minOccurs="0"/>
 *         &lt;element name="customerReturnValue" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="tokenOrder" type="{http://merchantapi.envoyservices.com}TokenOrder" minOccurs="0"/>
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
    "redirectionUrls",
    "customerReturnValue",
    "tokenOrder"
})
@XmlRootElement(name = "oneClickPaymentRequestV2")
public class OneClickPaymentRequestV2 {

    protected Authentication auth;
    protected OneClickServiceInfoV2 oneClickServiceInfo;
    protected PaymentData paymentData;
    protected CustomerDataV2 customerData;
    protected CustomerAccountDetails customerAccountDetails;
    protected RedirectionUrls redirectionUrls;
    protected String customerReturnValue;
    protected TokenOrder tokenOrder;

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
     *     {@link OneClickServiceInfoV2 }
     *     
     */
    public OneClickServiceInfoV2 getOneClickServiceInfo() {
        return oneClickServiceInfo;
    }

    /**
     * Sets the value of the oneClickServiceInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link OneClickServiceInfoV2 }
     *     
     */
    public void setOneClickServiceInfo(OneClickServiceInfoV2 value) {
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
     *     {@link CustomerDataV2 }
     *     
     */
    public CustomerDataV2 getCustomerData() {
        return customerData;
    }

    /**
     * Sets the value of the customerData property.
     * 
     * @param value
     *     allowed object is
     *     {@link CustomerDataV2 }
     *     
     */
    public void setCustomerData(CustomerDataV2 value) {
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
     * Gets the value of the redirectionUrls property.
     * 
     * @return
     *     possible object is
     *     {@link RedirectionUrls }
     *     
     */
    public RedirectionUrls getRedirectionUrls() {
        return redirectionUrls;
    }

    /**
     * Sets the value of the redirectionUrls property.
     * 
     * @param value
     *     allowed object is
     *     {@link RedirectionUrls }
     *     
     */
    public void setRedirectionUrls(RedirectionUrls value) {
        this.redirectionUrls = value;
    }

    /**
     * Gets the value of the customerReturnValue property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCustomerReturnValue() {
        return customerReturnValue;
    }

    /**
     * Sets the value of the customerReturnValue property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCustomerReturnValue(String value) {
        this.customerReturnValue = value;
    }

    /**
     * Gets the value of the tokenOrder property.
     * 
     * @return
     *     possible object is
     *     {@link TokenOrder }
     *     
     */
    public TokenOrder getTokenOrder() {
        return tokenOrder;
    }

    /**
     * Sets the value of the tokenOrder property.
     * 
     * @param value
     *     allowed object is
     *     {@link TokenOrder }
     *     
     */
    public void setTokenOrder(TokenOrder value) {
        this.tokenOrder = value;
    }

}
