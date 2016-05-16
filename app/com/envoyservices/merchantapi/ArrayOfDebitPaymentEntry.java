
package com.envoyservices.merchantapi;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfDebitPaymentEntry complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfDebitPaymentEntry">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="DebitPaymentEntry" type="{http://merchantapi.envoyservices.com}DebitPaymentEntry" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfDebitPaymentEntry", propOrder = {
    "debitPaymentEntry"
})
public class ArrayOfDebitPaymentEntry {

    @XmlElement(name = "DebitPaymentEntry", nillable = true)
    protected List<DebitPaymentEntry> debitPaymentEntry;

    /**
     * Gets the value of the debitPaymentEntry property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the debitPaymentEntry property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDebitPaymentEntry().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DebitPaymentEntry }
     * 
     * 
     */
    public List<DebitPaymentEntry> getDebitPaymentEntry() {
        if (debitPaymentEntry == null) {
            debitPaymentEntry = new ArrayList<DebitPaymentEntry>();
        }
        return this.debitPaymentEntry;
    }

}
