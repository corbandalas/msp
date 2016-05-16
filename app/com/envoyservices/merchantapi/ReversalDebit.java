
package com.envoyservices.merchantapi;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ReversalDebit complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ReversalDebit">
 *   &lt;complexContent>
 *     &lt;extension base="{http://merchantapi.envoyservices.com}PaymentEntry">
 *       &lt;sequence>
 *         &lt;element name="SrcCurrency" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="OriginalItem" type="{http://merchantapi.envoyservices.com}CreditPaymentEntry" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ReversalDebit", propOrder = {
    "srcCurrency",
    "originalItem"
})
public class ReversalDebit
    extends PaymentEntry
{

    @XmlElement(name = "SrcCurrency")
    protected String srcCurrency;
    @XmlElement(name = "OriginalItem")
    protected CreditPaymentEntry originalItem;

    /**
     * Gets the value of the srcCurrency property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSrcCurrency() {
        return srcCurrency;
    }

    /**
     * Sets the value of the srcCurrency property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSrcCurrency(String value) {
        this.srcCurrency = value;
    }

    /**
     * Gets the value of the originalItem property.
     * 
     * @return
     *     possible object is
     *     {@link CreditPaymentEntry }
     *     
     */
    public CreditPaymentEntry getOriginalItem() {
        return originalItem;
    }

    /**
     * Sets the value of the originalItem property.
     * 
     * @param value
     *     allowed object is
     *     {@link CreditPaymentEntry }
     *     
     */
    public void setOriginalItem(CreditPaymentEntry value) {
        this.originalItem = value;
    }

}
