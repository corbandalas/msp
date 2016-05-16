
package com.envoyservices.merchantapi;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ReversalCredit complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ReversalCredit">
 *   &lt;complexContent>
 *     &lt;extension base="{http://merchantapi.envoyservices.com}PaymentEntry">
 *       &lt;sequence>
 *         &lt;element name="DstCurrency" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="TransferId" type="{http://microsoft.com/wsdl/types/}guid"/>
 *         &lt;element name="OriginalItem" type="{http://merchantapi.envoyservices.com}DebitPaymentTransaction" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ReversalCredit", propOrder = {
    "dstCurrency",
    "transferId",
    "originalItem"
})
public class ReversalCredit
    extends PaymentEntry
{

    @XmlElement(name = "DstCurrency")
    protected String dstCurrency;
    @XmlElement(name = "TransferId", required = true)
    protected String transferId;
    @XmlElement(name = "OriginalItem")
    protected DebitPaymentTransaction originalItem;

    /**
     * Gets the value of the dstCurrency property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDstCurrency() {
        return dstCurrency;
    }

    /**
     * Sets the value of the dstCurrency property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDstCurrency(String value) {
        this.dstCurrency = value;
    }

    /**
     * Gets the value of the transferId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTransferId() {
        return transferId;
    }

    /**
     * Sets the value of the transferId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTransferId(String value) {
        this.transferId = value;
    }

    /**
     * Gets the value of the originalItem property.
     * 
     * @return
     *     possible object is
     *     {@link DebitPaymentTransaction }
     *     
     */
    public DebitPaymentTransaction getOriginalItem() {
        return originalItem;
    }

    /**
     * Sets the value of the originalItem property.
     * 
     * @param value
     *     allowed object is
     *     {@link DebitPaymentTransaction }
     *     
     */
    public void setOriginalItem(DebitPaymentTransaction value) {
        this.originalItem = value;
    }

}
