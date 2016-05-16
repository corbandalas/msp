
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
 *         &lt;element name="getPayoutCountriesResult" type="{http://merchantapi.envoyservices.com}PayoutCountriesResponse" minOccurs="0"/>
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
    "getPayoutCountriesResult"
})
@XmlRootElement(name = "getPayoutCountriesResponse")
public class GetPayoutCountriesResponse {

    protected PayoutCountriesResponse getPayoutCountriesResult;

    /**
     * Gets the value of the getPayoutCountriesResult property.
     * 
     * @return
     *     possible object is
     *     {@link PayoutCountriesResponse }
     *     
     */
    public PayoutCountriesResponse getGetPayoutCountriesResult() {
        return getPayoutCountriesResult;
    }

    /**
     * Sets the value of the getPayoutCountriesResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link PayoutCountriesResponse }
     *     
     */
    public void setGetPayoutCountriesResult(PayoutCountriesResponse value) {
        this.getPayoutCountriesResult = value;
    }

}
