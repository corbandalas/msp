
package com.envoyservices.merchantapi;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfBankDetailsResultV2 complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfBankDetailsResultV2">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="BankDetailsResultV2" type="{http://merchantapi.envoyservices.com}BankDetailsResultV2" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfBankDetailsResultV2", propOrder = {
    "bankDetailsResultV2"
})
public class ArrayOfBankDetailsResultV2 {

    @XmlElement(name = "BankDetailsResultV2", nillable = true)
    protected List<BankDetailsResultV2> bankDetailsResultV2;

    /**
     * Gets the value of the bankDetailsResultV2 property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the bankDetailsResultV2 property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getBankDetailsResultV2().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link BankDetailsResultV2 }
     * 
     * 
     */
    public List<BankDetailsResultV2> getBankDetailsResultV2() {
        if (bankDetailsResultV2 == null) {
            bankDetailsResultV2 = new ArrayList<BankDetailsResultV2>();
        }
        return this.bankDetailsResultV2;
    }

}
