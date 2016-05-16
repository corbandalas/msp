
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
 *         &lt;element name="payToBankAccountV2Result" type="{http://merchantapi.envoyservices.com}PaymentResponseV2" minOccurs="0"/>
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
    "payToBankAccountV2Result"
})
@XmlRootElement(name = "payToBankAccountV2Response")
public class PayToBankAccountV2Response {

    protected PaymentResponseV2 payToBankAccountV2Result;

    /**
     * Gets the value of the payToBankAccountV2Result property.
     * 
     * @return
     *     possible object is
     *     {@link PaymentResponseV2 }
     *     
     */
    public PaymentResponseV2 getPayToBankAccountV2Result() {
        return payToBankAccountV2Result;
    }

    /**
     * Sets the value of the payToBankAccountV2Result property.
     * 
     * @param value
     *     allowed object is
     *     {@link PaymentResponseV2 }
     *     
     */
    public void setPayToBankAccountV2Result(PaymentResponseV2 value) {
        this.payToBankAccountV2Result = value;
    }

}
