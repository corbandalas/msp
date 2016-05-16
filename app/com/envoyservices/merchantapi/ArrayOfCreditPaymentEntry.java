
package com.envoyservices.merchantapi;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfCreditPaymentEntry complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfCreditPaymentEntry">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="CreditPaymentEntry" type="{http://merchantapi.envoyservices.com}CreditPaymentEntry" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfCreditPaymentEntry", propOrder = {
    "creditPaymentEntry"
})
public class ArrayOfCreditPaymentEntry {

    @XmlElement(name = "CreditPaymentEntry", nillable = true)
    protected List<CreditPaymentEntry> creditPaymentEntry;

    /**
     * Gets the value of the creditPaymentEntry property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the creditPaymentEntry property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCreditPaymentEntry().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CreditPaymentEntry }
     * 
     * 
     */
    public List<CreditPaymentEntry> getCreditPaymentEntry() {
        if (creditPaymentEntry == null) {
            creditPaymentEntry = new ArrayList<CreditPaymentEntry>();
        }
        return this.creditPaymentEntry;
    }

}
