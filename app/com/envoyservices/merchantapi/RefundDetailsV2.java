
package com.envoyservices.merchantapi;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for RefundDetailsV2 complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="RefundDetailsV2">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="epacsReference" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="merchantReference" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="targetAmount" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="targetCurrency" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="fxReference" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="customerEmail" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="reason" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="language" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="refundAdditionalData" type="{http://merchantapi.envoyservices.com}ArrayOfAdditionalData" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RefundDetailsV2", propOrder = {
    "epacsReference",
    "merchantReference",
    "targetAmount",
    "targetCurrency",
    "fxReference",
    "customerEmail",
    "reason",
    "language",
    "refundAdditionalData"
})
public class RefundDetailsV2 {

    protected String epacsReference;
    protected String merchantReference;
    protected double targetAmount;
    protected String targetCurrency;
    protected String fxReference;
    protected String customerEmail;
    protected String reason;
    protected String language;
    protected ArrayOfAdditionalData refundAdditionalData;

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
     * Gets the value of the fxReference property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFxReference() {
        return fxReference;
    }

    /**
     * Sets the value of the fxReference property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFxReference(String value) {
        this.fxReference = value;
    }

    /**
     * Gets the value of the customerEmail property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCustomerEmail() {
        return customerEmail;
    }

    /**
     * Sets the value of the customerEmail property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCustomerEmail(String value) {
        this.customerEmail = value;
    }

    /**
     * Gets the value of the reason property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReason() {
        return reason;
    }

    /**
     * Sets the value of the reason property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReason(String value) {
        this.reason = value;
    }

    /**
     * Gets the value of the language property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLanguage() {
        return language;
    }

    /**
     * Sets the value of the language property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLanguage(String value) {
        this.language = value;
    }

    /**
     * Gets the value of the refundAdditionalData property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfAdditionalData }
     *     
     */
    public ArrayOfAdditionalData getRefundAdditionalData() {
        return refundAdditionalData;
    }

    /**
     * Sets the value of the refundAdditionalData property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfAdditionalData }
     *     
     */
    public void setRefundAdditionalData(ArrayOfAdditionalData value) {
        this.refundAdditionalData = value;
    }

}
