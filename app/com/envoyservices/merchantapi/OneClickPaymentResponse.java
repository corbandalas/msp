
package com.envoyservices.merchantapi;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for OneClickPaymentResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="OneClickPaymentResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="statusCode" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="statusMessage" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="tokenId" type="{http://microsoft.com/wsdl/types/}guid"/>
 *         &lt;element name="tokenTTL" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="tokenExpiryUtcTime" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="customerRedirectUrl" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "OneClickPaymentResponse", propOrder = {
    "statusCode",
    "statusMessage",
    "tokenId",
    "tokenTTL",
    "tokenExpiryUtcTime",
    "customerRedirectUrl"
})
@XmlSeeAlso({
    OneClickPaymentResponseV2 .class
})
public class OneClickPaymentResponse {

    protected int statusCode;
    protected String statusMessage;
    @XmlElement(required = true)
    protected String tokenId;
    protected int tokenTTL;
    @XmlElement(required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar tokenExpiryUtcTime;
    protected String customerRedirectUrl;

    /**
     * Gets the value of the statusCode property.
     * 
     */
    public int getStatusCode() {
        return statusCode;
    }

    /**
     * Sets the value of the statusCode property.
     * 
     */
    public void setStatusCode(int value) {
        this.statusCode = value;
    }

    /**
     * Gets the value of the statusMessage property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStatusMessage() {
        return statusMessage;
    }

    /**
     * Sets the value of the statusMessage property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStatusMessage(String value) {
        this.statusMessage = value;
    }

    /**
     * Gets the value of the tokenId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTokenId() {
        return tokenId;
    }

    /**
     * Sets the value of the tokenId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTokenId(String value) {
        this.tokenId = value;
    }

    /**
     * Gets the value of the tokenTTL property.
     * 
     */
    public int getTokenTTL() {
        return tokenTTL;
    }

    /**
     * Sets the value of the tokenTTL property.
     * 
     */
    public void setTokenTTL(int value) {
        this.tokenTTL = value;
    }

    /**
     * Gets the value of the tokenExpiryUtcTime property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getTokenExpiryUtcTime() {
        return tokenExpiryUtcTime;
    }

    /**
     * Sets the value of the tokenExpiryUtcTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setTokenExpiryUtcTime(XMLGregorianCalendar value) {
        this.tokenExpiryUtcTime = value;
    }

    /**
     * Gets the value of the customerRedirectUrl property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCustomerRedirectUrl() {
        return customerRedirectUrl;
    }

    /**
     * Sets the value of the customerRedirectUrl property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCustomerRedirectUrl(String value) {
        this.customerRedirectUrl = value;
    }

}
