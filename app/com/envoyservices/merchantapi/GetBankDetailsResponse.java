
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
 *         &lt;element name="getBankDetailsResult" type="{http://merchantapi.envoyservices.com}BankDetailsResponse" minOccurs="0"/>
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
    "getBankDetailsResult"
})
@XmlRootElement(name = "getBankDetailsResponse")
public class GetBankDetailsResponse {

    protected BankDetailsResponse getBankDetailsResult;

    /**
     * Gets the value of the getBankDetailsResult property.
     * 
     * @return
     *     possible object is
     *     {@link BankDetailsResponse }
     *     
     */
    public BankDetailsResponse getGetBankDetailsResult() {
        return getBankDetailsResult;
    }

    /**
     * Sets the value of the getBankDetailsResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link BankDetailsResponse }
     *     
     */
    public void setGetBankDetailsResult(BankDetailsResponse value) {
        this.getBankDetailsResult = value;
    }

}
