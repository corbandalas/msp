
package com.envoyservices.merchantapi;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for CancelInstruction complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CancelInstruction">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="CancelAdditionalData" type="{http://merchantapi.envoyservices.com}ArrayOfAdditionalData" minOccurs="0"/>
 *         &lt;element name="CancelDetails" type="{http://merchantapi.envoyservices.com}CancelDetails" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CancelInstruction", propOrder = {
    "cancelAdditionalData",
    "cancelDetails"
})
public class CancelInstruction {

    @XmlElement(name = "CancelAdditionalData")
    protected ArrayOfAdditionalData cancelAdditionalData;
    @XmlElement(name = "CancelDetails")
    protected CancelDetails cancelDetails;

    /**
     * Gets the value of the cancelAdditionalData property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfAdditionalData }
     *     
     */
    public ArrayOfAdditionalData getCancelAdditionalData() {
        return cancelAdditionalData;
    }

    /**
     * Sets the value of the cancelAdditionalData property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfAdditionalData }
     *     
     */
    public void setCancelAdditionalData(ArrayOfAdditionalData value) {
        this.cancelAdditionalData = value;
    }

    /**
     * Gets the value of the cancelDetails property.
     * 
     * @return
     *     possible object is
     *     {@link CancelDetails }
     *     
     */
    public CancelDetails getCancelDetails() {
        return cancelDetails;
    }

    /**
     * Sets the value of the cancelDetails property.
     * 
     * @param value
     *     allowed object is
     *     {@link CancelDetails }
     *     
     */
    public void setCancelDetails(CancelDetails value) {
        this.cancelDetails = value;
    }

}
