
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
 *         &lt;element name="pollPaymentsResult" type="{http://merchantapi.envoyservices.com}PollResponse" minOccurs="0"/>
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
    "pollPaymentsResult"
})
@XmlRootElement(name = "pollPaymentsResponse")
public class PollPaymentsResponse {

    protected PollResponse pollPaymentsResult;

    /**
     * Gets the value of the pollPaymentsResult property.
     * 
     * @return
     *     possible object is
     *     {@link PollResponse }
     *     
     */
    public PollResponse getPollPaymentsResult() {
        return pollPaymentsResult;
    }

    /**
     * Sets the value of the pollPaymentsResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link PollResponse }
     *     
     */
    public void setPollPaymentsResult(PollResponse value) {
        this.pollPaymentsResult = value;
    }

}
