
package com.envoyservices.merchantapi;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfPaymentInstructionV3 complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfPaymentInstructionV3">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="paymentInstructionV3" type="{http://merchantapi.envoyservices.com}paymentInstructionV3" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfPaymentInstructionV3", propOrder = {
    "paymentInstructionV3"
})
public class ArrayOfPaymentInstructionV3 {

    @XmlElement(nillable = true)
    protected List<PaymentInstructionV3> paymentInstructionV3;

    /**
     * Gets the value of the paymentInstructionV3 property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the paymentInstructionV3 property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPaymentInstructionV3().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PaymentInstructionV3 }
     * 
     * 
     */
    public List<PaymentInstructionV3> getPaymentInstructionV3() {
        if (paymentInstructionV3 == null) {
            paymentInstructionV3 = new ArrayList<PaymentInstructionV3>();
        }
        return this.paymentInstructionV3;
    }

}
