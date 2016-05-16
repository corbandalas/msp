
package com.envoyservices.merchantapi;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="payToBankAccountV3Result" type="{http://merchantapi.envoyservices.com}PaymentResponseV3" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "payToBankAccountV3Result"
})
@XmlRootElement(name = "payToBankAccountV3Response")
public class PayToBankAccountV3Response {

    protected PaymentResponseV3 payToBankAccountV3Result;

    /**
     * Gets the value of the payToBankAccountV3Result property.
     * 
     * @return
     *     possible object is
     *     {@link PaymentResponseV3 }
     *     
     */
    public PaymentResponseV3 getPayToBankAccountV3Result() {
        return payToBankAccountV3Result;
    }

    /**
     * Sets the value of the payToBankAccountV3Result property.
     * 
     * @param value
     *     allowed object is
     *     {@link PaymentResponseV3 }
     *     
     */
    public void setPayToBankAccountV3Result(PaymentResponseV3 value) {
        this.payToBankAccountV3Result = value;
    }

}
