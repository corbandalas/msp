
package com.envoyservices.merchantapi;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for CancelResult complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CancelResult">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ReceivedDate" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="CancelMerchantReference" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CancelResult", propOrder = {
    "receivedDate",
    "cancelMerchantReference"
})
public class CancelResult {

    @XmlElement(name = "ReceivedDate", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar receivedDate;
    @XmlElement(name = "CancelMerchantReference")
    protected String cancelMerchantReference;

    /**
     * Gets the value of the receivedDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getReceivedDate() {
        return receivedDate;
    }

    /**
     * Sets the value of the receivedDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setReceivedDate(XMLGregorianCalendar value) {
        this.receivedDate = value;
    }

    /**
     * Gets the value of the cancelMerchantReference property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCancelMerchantReference() {
        return cancelMerchantReference;
    }

    /**
     * Sets the value of the cancelMerchantReference property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCancelMerchantReference(String value) {
        this.cancelMerchantReference = value;
    }

}
