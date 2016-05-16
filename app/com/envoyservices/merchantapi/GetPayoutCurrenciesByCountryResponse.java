
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
 *         &lt;element name="getPayoutCurrenciesByCountryResult" type="{http://merchantapi.envoyservices.com}PayoutCurrenciesResponse" minOccurs="0"/>
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
    "getPayoutCurrenciesByCountryResult"
})
@XmlRootElement(name = "getPayoutCurrenciesByCountryResponse")
public class GetPayoutCurrenciesByCountryResponse {

    protected PayoutCurrenciesResponse getPayoutCurrenciesByCountryResult;

    /**
     * Gets the value of the getPayoutCurrenciesByCountryResult property.
     * 
     * @return
     *     possible object is
     *     {@link PayoutCurrenciesResponse }
     *     
     */
    public PayoutCurrenciesResponse getGetPayoutCurrenciesByCountryResult() {
        return getPayoutCurrenciesByCountryResult;
    }

    /**
     * Sets the value of the getPayoutCurrenciesByCountryResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link PayoutCurrenciesResponse }
     *     
     */
    public void setGetPayoutCurrenciesByCountryResult(PayoutCurrenciesResponse value) {
        this.getPayoutCurrenciesByCountryResult = value;
    }

}
