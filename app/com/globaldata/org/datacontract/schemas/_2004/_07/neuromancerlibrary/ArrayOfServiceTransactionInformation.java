
package org.datacontract.schemas._2004._07.neuromancerlibrary;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfServiceTransactionInformation complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfServiceTransactionInformation">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ServiceTransactionInformation" type="{http://schemas.datacontract.org/2004/07/NeuromancerLibrary.Resources}ServiceTransactionInformation" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfServiceTransactionInformation", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.Resources", propOrder = {
    "serviceTransactionInformation"
})
public class ArrayOfServiceTransactionInformation {

    @XmlElement(name = "ServiceTransactionInformation", nillable = true)
    protected List<ServiceTransactionInformation> serviceTransactionInformation;

    /**
     * Gets the value of the serviceTransactionInformation property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the serviceTransactionInformation property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getServiceTransactionInformation().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ServiceTransactionInformation }
     * 
     * 
     */
    public List<ServiceTransactionInformation> getServiceTransactionInformation() {
        if (serviceTransactionInformation == null) {
            serviceTransactionInformation = new ArrayList<ServiceTransactionInformation>();
        }
        return this.serviceTransactionInformation;
    }

}
