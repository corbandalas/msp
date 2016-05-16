
package com.envoyservices.merchantapi;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for payment complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="payment">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="uniqueReference" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="merchantReference" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="epacsReference" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="postingDate" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="bankCurrency" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="bankAmount" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="appliedCurrency" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="appliedAmount" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="countryCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="bankInformation" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "payment", propOrder = {
    "uniqueReference",
    "merchantReference",
    "epacsReference",
    "postingDate",
    "bankCurrency",
    "bankAmount",
    "appliedCurrency",
    "appliedAmount",
    "countryCode",
    "bankInformation"
})
public class Payment {

    protected String uniqueReference;
    protected String merchantReference;
    protected String epacsReference;
    @XmlElement(required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar postingDate;
    protected String bankCurrency;
    protected double bankAmount;
    protected String appliedCurrency;
    protected double appliedAmount;
    protected String countryCode;
    protected String bankInformation;

    /**
     * Gets the value of the uniqueReference property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUniqueReference() {
        return uniqueReference;
    }

    /**
     * Sets the value of the uniqueReference property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUniqueReference(String value) {
        this.uniqueReference = value;
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
     * Gets the value of the postingDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getPostingDate() {
        return postingDate;
    }

    /**
     * Sets the value of the postingDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setPostingDate(XMLGregorianCalendar value) {
        this.postingDate = value;
    }

    /**
     * Gets the value of the bankCurrency property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBankCurrency() {
        return bankCurrency;
    }

    /**
     * Sets the value of the bankCurrency property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBankCurrency(String value) {
        this.bankCurrency = value;
    }

    /**
     * Gets the value of the bankAmount property.
     * 
     */
    public double getBankAmount() {
        return bankAmount;
    }

    /**
     * Sets the value of the bankAmount property.
     * 
     */
    public void setBankAmount(double value) {
        this.bankAmount = value;
    }

    /**
     * Gets the value of the appliedCurrency property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAppliedCurrency() {
        return appliedCurrency;
    }

    /**
     * Sets the value of the appliedCurrency property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAppliedCurrency(String value) {
        this.appliedCurrency = value;
    }

    /**
     * Gets the value of the appliedAmount property.
     * 
     */
    public double getAppliedAmount() {
        return appliedAmount;
    }

    /**
     * Sets the value of the appliedAmount property.
     * 
     */
    public void setAppliedAmount(double value) {
        this.appliedAmount = value;
    }

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
     * Gets the value of the bankInformation property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBankInformation() {
        return bankInformation;
    }

    /**
     * Sets the value of the bankInformation property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBankInformation(String value) {
        this.bankInformation = value;
    }

}
