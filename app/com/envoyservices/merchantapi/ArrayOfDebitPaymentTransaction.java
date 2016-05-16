
package com.envoyservices.merchantapi;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfDebitPaymentTransaction complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfDebitPaymentTransaction">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="DebitPaymentTransaction" type="{http://merchantapi.envoyservices.com}DebitPaymentTransaction" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfDebitPaymentTransaction", propOrder = {
    "debitPaymentTransaction"
})
public class ArrayOfDebitPaymentTransaction {

    @XmlElement(name = "DebitPaymentTransaction", nillable = true)
    protected List<DebitPaymentTransaction> debitPaymentTransaction;

    /**
     * Gets the value of the debitPaymentTransaction property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the debitPaymentTransaction property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDebitPaymentTransaction().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DebitPaymentTransaction }
     * 
     * 
     */
    public List<DebitPaymentTransaction> getDebitPaymentTransaction() {
        if (debitPaymentTransaction == null) {
            debitPaymentTransaction = new ArrayList<DebitPaymentTransaction>();
        }
        return this.debitPaymentTransaction;
    }

}
