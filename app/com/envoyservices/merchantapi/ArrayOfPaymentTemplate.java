
package com.envoyservices.merchantapi;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import com.envoyservices.epacsapi.PaymentTemplate;


/**
 * <p>Java class for ArrayOfPaymentTemplate complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfPaymentTemplate">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="PaymentTemplate" type="{http://envoyservices.com/epacsapi}PaymentTemplate" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfPaymentTemplate", propOrder = {
    "paymentTemplate"
})
public class ArrayOfPaymentTemplate {

    @XmlElement(name = "PaymentTemplate", nillable = true)
    protected List<PaymentTemplate> paymentTemplate;

    /**
     * Gets the value of the paymentTemplate property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the paymentTemplate property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPaymentTemplate().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PaymentTemplate }
     * 
     * 
     */
    public List<PaymentTemplate> getPaymentTemplate() {
        if (paymentTemplate == null) {
            paymentTemplate = new ArrayList<PaymentTemplate>();
        }
        return this.paymentTemplate;
    }

}
