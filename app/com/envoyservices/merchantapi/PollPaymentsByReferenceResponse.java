
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
 *         &lt;element name="pollPaymentsByReferenceResult" type="{http://merchantapi.envoyservices.com}PollResponse" minOccurs="0"/>
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
    "pollPaymentsByReferenceResult"
})
@XmlRootElement(name = "pollPaymentsByReferenceResponse")
public class PollPaymentsByReferenceResponse {

    protected PollResponse pollPaymentsByReferenceResult;

    /**
     * Gets the value of the pollPaymentsByReferenceResult property.
     * 
     * @return
     *     possible object is
     *     {@link PollResponse }
     *     
     */
    public PollResponse getPollPaymentsByReferenceResult() {
        return pollPaymentsByReferenceResult;
    }

    /**
     * Sets the value of the pollPaymentsByReferenceResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link PollResponse }
     *     
     */
    public void setPollPaymentsByReferenceResult(PollResponse value) {
        this.pollPaymentsByReferenceResult = value;
    }

}
