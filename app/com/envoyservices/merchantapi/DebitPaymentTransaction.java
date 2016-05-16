
package com.envoyservices.merchantapi;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for DebitPaymentTransaction complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DebitPaymentTransaction">
 *   &lt;complexContent>
 *     &lt;extension base="{http://merchantapi.envoyservices.com}PaymentEntry">
 *       &lt;sequence>
 *         &lt;element name="DstCurrency" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="DomainName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DebitPaymentTransaction", propOrder = {
    "dstCurrency",
    "domainName"
})
public class DebitPaymentTransaction
    extends PaymentEntry
{

    @XmlElement(name = "DstCurrency")
    protected String dstCurrency;
    @XmlElement(name = "DomainName")
    protected String domainName;

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
     * Gets the value of the domainName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDomainName() {
        return domainName;
    }

    /**
     * Sets the value of the domainName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDomainName(String value) {
        this.domainName = value;
    }

}
