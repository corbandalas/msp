
package com.envoyservices.merchantapi;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for OneClickPaymentResponseV2 complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="OneClickPaymentResponseV2">
 *   &lt;complexContent>
 *     &lt;extension base="{http://merchantapi.envoyservices.com}OneClickPaymentResponse">
 *       &lt;sequence>
 *         &lt;element name="qrCodeImageUrl" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="referenceDetails" type="{http://merchantapi.envoyservices.com}ReferenceDetails" minOccurs="0"/>
 *         &lt;element name="forexDetails" type="{http://merchantapi.envoyservices.com}ForexDetails" minOccurs="0"/>
 *         &lt;element name="customerReturnValue" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "OneClickPaymentResponseV2", propOrder = {
    "qrCodeImageUrl",
    "referenceDetails",
    "forexDetails",
    "customerReturnValue"
})
public class OneClickPaymentResponseV2
    extends OneClickPaymentResponse
{

    protected String qrCodeImageUrl;
    protected ReferenceDetails referenceDetails;
    protected ForexDetails forexDetails;
    protected String customerReturnValue;

    /**
     * Gets the value of the qrCodeImageUrl property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getQrCodeImageUrl() {
        return qrCodeImageUrl;
    }

    /**
     * Sets the value of the qrCodeImageUrl property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setQrCodeImageUrl(String value) {
        this.qrCodeImageUrl = value;
    }

    /**
     * Gets the value of the referenceDetails property.
     * 
     * @return
     *     possible object is
     *     {@link ReferenceDetails }
     *     
     */
    public ReferenceDetails getReferenceDetails() {
        return referenceDetails;
    }

    /**
     * Sets the value of the referenceDetails property.
     * 
     * @param value
     *     allowed object is
     *     {@link ReferenceDetails }
     *     
     */
    public void setReferenceDetails(ReferenceDetails value) {
        this.referenceDetails = value;
    }

    /**
     * Gets the value of the forexDetails property.
     * 
     * @return
     *     possible object is
     *     {@link ForexDetails }
     *     
     */
    public ForexDetails getForexDetails() {
        return forexDetails;
    }

    /**
     * Sets the value of the forexDetails property.
     * 
     * @param value
     *     allowed object is
     *     {@link ForexDetails }
     *     
     */
    public void setForexDetails(ForexDetails value) {
        this.forexDetails = value;
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

}
