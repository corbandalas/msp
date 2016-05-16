
package com.envoyservices.merchantapi;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for PaymentRecord complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PaymentRecord">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="DateTimeReturned" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="Signature" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Errors" type="{http://merchantapi.envoyservices.com}ArrayOfPaymentRecordError" minOccurs="0"/>
 *         &lt;element name="PayinPaymentEntries" type="{http://merchantapi.envoyservices.com}ArrayOfCreditPaymentEntry" minOccurs="0"/>
 *         &lt;element name="PayOutPaymentEntries" type="{http://merchantapi.envoyservices.com}ArrayOfDebitPaymentEntry" minOccurs="0"/>
 *         &lt;element name="PayinReversals" type="{http://merchantapi.envoyservices.com}ArrayOfReversalDebit" minOccurs="0"/>
 *         &lt;element name="PayOutReversals" type="{http://merchantapi.envoyservices.com}ArrayOfReversalCredit" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PaymentRecord", propOrder = {
    "dateTimeReturned",
    "signature",
    "errors",
    "payinPaymentEntries",
    "payOutPaymentEntries",
    "payinReversals",
    "payOutReversals"
})
public class PaymentRecord {

    @XmlElement(name = "DateTimeReturned", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar dateTimeReturned;
    @XmlElement(name = "Signature")
    protected String signature;
    @XmlElement(name = "Errors")
    protected ArrayOfPaymentRecordError errors;
    @XmlElement(name = "PayinPaymentEntries")
    protected ArrayOfCreditPaymentEntry payinPaymentEntries;
    @XmlElement(name = "PayOutPaymentEntries")
    protected ArrayOfDebitPaymentEntry payOutPaymentEntries;
    @XmlElement(name = "PayinReversals")
    protected ArrayOfReversalDebit payinReversals;
    @XmlElement(name = "PayOutReversals")
    protected ArrayOfReversalCredit payOutReversals;

    /**
     * Gets the value of the dateTimeReturned property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDateTimeReturned() {
        return dateTimeReturned;
    }

    /**
     * Sets the value of the dateTimeReturned property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDateTimeReturned(XMLGregorianCalendar value) {
        this.dateTimeReturned = value;
    }

    /**
     * Gets the value of the signature property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSignature() {
        return signature;
    }

    /**
     * Sets the value of the signature property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSignature(String value) {
        this.signature = value;
    }

    /**
     * Gets the value of the errors property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfPaymentRecordError }
     *     
     */
    public ArrayOfPaymentRecordError getErrors() {
        return errors;
    }

    /**
     * Sets the value of the errors property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfPaymentRecordError }
     *     
     */
    public void setErrors(ArrayOfPaymentRecordError value) {
        this.errors = value;
    }

    /**
     * Gets the value of the payinPaymentEntries property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfCreditPaymentEntry }
     *     
     */
    public ArrayOfCreditPaymentEntry getPayinPaymentEntries() {
        return payinPaymentEntries;
    }

    /**
     * Sets the value of the payinPaymentEntries property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfCreditPaymentEntry }
     *     
     */
    public void setPayinPaymentEntries(ArrayOfCreditPaymentEntry value) {
        this.payinPaymentEntries = value;
    }

    /**
     * Gets the value of the payOutPaymentEntries property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfDebitPaymentEntry }
     *     
     */
    public ArrayOfDebitPaymentEntry getPayOutPaymentEntries() {
        return payOutPaymentEntries;
    }

    /**
     * Sets the value of the payOutPaymentEntries property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfDebitPaymentEntry }
     *     
     */
    public void setPayOutPaymentEntries(ArrayOfDebitPaymentEntry value) {
        this.payOutPaymentEntries = value;
    }

    /**
     * Gets the value of the payinReversals property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfReversalDebit }
     *     
     */
    public ArrayOfReversalDebit getPayinReversals() {
        return payinReversals;
    }

    /**
     * Sets the value of the payinReversals property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfReversalDebit }
     *     
     */
    public void setPayinReversals(ArrayOfReversalDebit value) {
        this.payinReversals = value;
    }

    /**
     * Gets the value of the payOutReversals property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfReversalCredit }
     *     
     */
    public ArrayOfReversalCredit getPayOutReversals() {
        return payOutReversals;
    }

    /**
     * Sets the value of the payOutReversals property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfReversalCredit }
     *     
     */
    public void setPayOutReversals(ArrayOfReversalCredit value) {
        this.payOutReversals = value;
    }

}
