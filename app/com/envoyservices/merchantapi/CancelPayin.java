
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
 *         &lt;element name="cancelMerchantReference" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="cancelInstruction" type="{http://merchantapi.envoyservices.com}CancelInstruction" minOccurs="0"/>
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
    "cancelMerchantReference",
    "cancelInstruction"
})
@XmlRootElement(name = "cancelPayin")
public class CancelPayin {

    protected Authentication auth;
    protected String cancelMerchantReference;
    protected CancelInstruction cancelInstruction;

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
     * Gets the value of the cancelMerchantReference property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCancelMerchantReference() {
        return cancelMerchantReference;
    }

    /**
     * Sets the value of the cancelMerchantReference property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCancelMerchantReference(String value) {
        this.cancelMerchantReference = value;
    }

    /**
     * Gets the value of the cancelInstruction property.
     * 
     * @return
     *     possible object is
     *     {@link CancelInstruction }
     *     
     */
    public CancelInstruction getCancelInstruction() {
        return cancelInstruction;
    }

    /**
     * Sets the value of the cancelInstruction property.
     * 
     * @param value
     *     allowed object is
     *     {@link CancelInstruction }
     *     
     */
    public void setCancelInstruction(CancelInstruction value) {
        this.cancelInstruction = value;
    }

}
