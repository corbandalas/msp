
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
 *         &lt;element name="requestReference" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="criteria" type="{http://merchantapi.envoyservices.com}paymentTemplatesCriteriaV2" minOccurs="0"/>
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
    "requestReference",
    "criteria"
})
@XmlRootElement(name = "getPaymentTemplatesV2")
public class GetPaymentTemplatesV2 {

    protected Authentication auth;
    protected String requestReference;
    protected PaymentTemplatesCriteriaV2 criteria;

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
     * Gets the value of the requestReference property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRequestReference() {
        return requestReference;
    }

    /**
     * Sets the value of the requestReference property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRequestReference(String value) {
        this.requestReference = value;
    }

    /**
     * Gets the value of the criteria property.
     * 
     * @return
     *     possible object is
     *     {@link PaymentTemplatesCriteriaV2 }
     *     
     */
    public PaymentTemplatesCriteriaV2 getCriteria() {
        return criteria;
    }

    /**
     * Sets the value of the criteria property.
     * 
     * @param value
     *     allowed object is
     *     {@link PaymentTemplatesCriteriaV2 }
     *     
     */
    public void setCriteria(PaymentTemplatesCriteriaV2 value) {
        this.criteria = value;
    }

}