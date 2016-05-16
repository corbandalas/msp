
package com.envoyservices.merchantapi;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for DebitPaymentEntry complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DebitPaymentEntry">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="OriginalPaymentRequest" type="{http://merchantapi.envoyservices.com}OPBPayment" minOccurs="0"/>
 *         &lt;element name="Transactions" type="{http://merchantapi.envoyservices.com}ArrayOfDebitPaymentTransaction" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DebitPaymentEntry", propOrder = {
    "originalPaymentRequest",
    "transactions"
})
public class DebitPaymentEntry {

    @XmlElement(name = "OriginalPaymentRequest")
    protected OPBPayment originalPaymentRequest;
    @XmlElement(name = "Transactions")
    protected ArrayOfDebitPaymentTransaction transactions;

    /**
     * Gets the value of the originalPaymentRequest property.
     * 
     * @return
     *     possible object is
     *     {@link OPBPayment }
     *     
     */
    public OPBPayment getOriginalPaymentRequest() {
        return originalPaymentRequest;
    }

    /**
     * Sets the value of the originalPaymentRequest property.
     * 
     * @param value
     *     allowed object is
     *     {@link OPBPayment }
     *     
     */
    public void setOriginalPaymentRequest(OPBPayment value) {
        this.originalPaymentRequest = value;
    }

    /**
     * Gets the value of the transactions property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfDebitPaymentTransaction }
     *     
     */
    public ArrayOfDebitPaymentTransaction getTransactions() {
        return transactions;
    }

    /**
     * Sets the value of the transactions property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfDebitPaymentTransaction }
     *     
     */
    public void setTransactions(ArrayOfDebitPaymentTransaction value) {
        this.transactions = value;
    }

}
