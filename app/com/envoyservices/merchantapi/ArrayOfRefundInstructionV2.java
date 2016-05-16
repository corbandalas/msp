
package com.envoyservices.merchantapi;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfRefundInstructionV2 complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfRefundInstructionV2">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="refundInstructionV2" type="{http://merchantapi.envoyservices.com}refundInstructionV2" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfRefundInstructionV2", propOrder = {
    "refundInstructionV2"
})
public class ArrayOfRefundInstructionV2 {

    @XmlElement(nillable = true)
    protected List<RefundInstructionV2> refundInstructionV2;

    /**
     * Gets the value of the refundInstructionV2 property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the refundInstructionV2 property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRefundInstructionV2().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link RefundInstructionV2 }
     * 
     * 
     */
    public List<RefundInstructionV2> getRefundInstructionV2() {
        if (refundInstructionV2 == null) {
            refundInstructionV2 = new ArrayList<RefundInstructionV2>();
        }
        return this.refundInstructionV2;
    }

}
