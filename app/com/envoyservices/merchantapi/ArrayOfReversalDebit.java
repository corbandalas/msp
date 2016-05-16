
package com.envoyservices.merchantapi;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfReversalDebit complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfReversalDebit">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ReversalDebit" type="{http://merchantapi.envoyservices.com}ReversalDebit" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfReversalDebit", propOrder = {
    "reversalDebit"
})
public class ArrayOfReversalDebit {

    @XmlElement(name = "ReversalDebit", nillable = true)
    protected List<ReversalDebit> reversalDebit;

    /**
     * Gets the value of the reversalDebit property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the reversalDebit property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getReversalDebit().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ReversalDebit }
     * 
     * 
     */
    public List<ReversalDebit> getReversalDebit() {
        if (reversalDebit == null) {
            reversalDebit = new ArrayList<ReversalDebit>();
        }
        return this.reversalDebit;
    }

}
