
package com.envoyservices.merchantapi;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for OneClickServiceInfoV2 complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="OneClickServiceInfoV2">
 *   &lt;complexContent>
 *     &lt;extension base="{http://merchantapi.envoyservices.com}OneClickServiceInfo">
 *       &lt;sequence>
 *         &lt;element name="transactionShortDescription" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="transactionLongDescription" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="transactionCategoryCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "OneClickServiceInfoV2", propOrder = {
    "transactionShortDescription",
    "transactionLongDescription",
    "transactionCategoryCode"
})
public class OneClickServiceInfoV2
    extends OneClickServiceInfo
{

    protected String transactionShortDescription;
    protected String transactionLongDescription;
    protected String transactionCategoryCode;

    /**
     * Gets the value of the transactionShortDescription property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTransactionShortDescription() {
        return transactionShortDescription;
    }

    /**
     * Sets the value of the transactionShortDescription property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTransactionShortDescription(String value) {
        this.transactionShortDescription = value;
    }

    /**
     * Gets the value of the transactionLongDescription property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTransactionLongDescription() {
        return transactionLongDescription;
    }

    /**
     * Sets the value of the transactionLongDescription property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTransactionLongDescription(String value) {
        this.transactionLongDescription = value;
    }

    /**
     * Gets the value of the transactionCategoryCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTransactionCategoryCode() {
        return transactionCategoryCode;
    }

    /**
     * Sets the value of the transactionCategoryCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTransactionCategoryCode(String value) {
        this.transactionCategoryCode = value;
    }

}
