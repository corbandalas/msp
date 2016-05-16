
package com.envoyservices.merchantapi;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfRefundResultV2 complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfRefundResultV2">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="refundResultV2" type="{http://merchantapi.envoyservices.com}refundResultV2" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfRefundResultV2", propOrder = {
    "refundResultV2"
})
public class ArrayOfRefundResultV2 {

    @XmlElement(nillable = true)
    protected List<RefundResultV2> refundResultV2;

    /**
     * Gets the value of the refundResultV2 property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the refundResultV2 property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRefundResultV2().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link RefundResultV2 }
     * 
     * 
     */
    public List<RefundResultV2> getRefundResultV2() {
        if (refundResultV2 == null) {
            refundResultV2 = new ArrayList<RefundResultV2>();
        }
        return this.refundResultV2;
    }

}
