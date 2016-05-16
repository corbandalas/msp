
package com.envoyservices.merchantapi;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for PaymentIdent complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PaymentIdent">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ItemNumber" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="StatementId" type="{http://microsoft.com/wsdl/types/}guid"/>
 *         &lt;element name="EpacsReference" type="{http://microsoft.com/wsdl/types/}guid"/>
 *         &lt;element name="MerchantReference" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PaymentReference" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PaymentIdent", propOrder = {
    "itemNumber",
    "statementId",
    "epacsReference",
    "merchantReference",
    "paymentReference"
})
@XmlSeeAlso({
    PaymentEntry.class,
    CreditPaymentEntry.class
})
public abstract class PaymentIdent {

    @XmlElement(name = "ItemNumber")
    protected long itemNumber;
    @XmlElement(name = "StatementId", required = true)
    protected String statementId;
    @XmlElement(name = "EpacsReference", required = true)
    protected String epacsReference;
    @XmlElement(name = "MerchantReference")
    protected String merchantReference;
    @XmlElement(name = "PaymentReference")
    protected String paymentReference;

    /**
     * Gets the value of the itemNumber property.
     * 
     */
    public long getItemNumber() {
        return itemNumber;
    }

    /**
     * Sets the value of the itemNumber property.
     * 
     */
    public void setItemNumber(long value) {
        this.itemNumber = value;
    }

    /**
     * Gets the value of the statementId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStatementId() {
        return statementId;
    }

    /**
     * Sets the value of the statementId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStatementId(String value) {
        this.statementId = value;
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
     * Gets the value of the paymentReference property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPaymentReference() {
        return paymentReference;
    }

    /**
     * Sets the value of the paymentReference property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPaymentReference(String value) {
        this.paymentReference = value;
    }

}
