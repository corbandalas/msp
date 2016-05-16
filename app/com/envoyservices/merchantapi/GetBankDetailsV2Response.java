
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
 *         &lt;element name="getBankDetailsV2Result" type="{http://merchantapi.envoyservices.com}BankDetailsResponseV2" minOccurs="0"/>
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
    "getBankDetailsV2Result"
})
@XmlRootElement(name = "getBankDetailsV2Response")
public class GetBankDetailsV2Response {

    protected BankDetailsResponseV2 getBankDetailsV2Result;

    /**
     * Gets the value of the getBankDetailsV2Result property.
     * 
     * @return
     *     possible object is
     *     {@link BankDetailsResponseV2 }
     *     
     */
    public BankDetailsResponseV2 getGetBankDetailsV2Result() {
        return getBankDetailsV2Result;
    }

    /**
     * Sets the value of the getBankDetailsV2Result property.
     * 
     * @param value
     *     allowed object is
     *     {@link BankDetailsResponseV2 }
     *     
     */
    public void setGetBankDetailsV2Result(BankDetailsResponseV2 value) {
        this.getBankDetailsV2Result = value;
    }

}
