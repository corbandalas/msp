
package com.envoyservices.merchantapi;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfReversalCredit complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfReversalCredit">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ReversalCredit" type="{http://merchantapi.envoyservices.com}ReversalCredit" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfReversalCredit", propOrder = {
    "reversalCredit"
})
public class ArrayOfReversalCredit {

    @XmlElement(name = "ReversalCredit", nillable = true)
    protected List<ReversalCredit> reversalCredit;

    /**
     * Gets the value of the reversalCredit property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the reversalCredit property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getReversalCredit().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ReversalCredit }
     * 
     * 
     */
    public List<ReversalCredit> getReversalCredit() {
        if (reversalCredit == null) {
            reversalCredit = new ArrayList<ReversalCredit>();
        }
        return this.reversalCredit;
    }

}
