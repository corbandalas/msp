
package org.datacontract.schemas._2004._07.neuromancerlibrary_externalservices_equifax;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfAddressMatch complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfAddressMatch">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="AddressMatch" type="{http://schemas.datacontract.org/2004/07/NeuromancerLibrary.ExternalServices.Equifax.AddressMatching}AddressMatch" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfAddressMatch", propOrder = {
    "addressMatch"
})
public class ArrayOfAddressMatch {

    @XmlElement(name = "AddressMatch", nillable = true)
    protected List<AddressMatch> addressMatch;

    /**
     * Gets the value of the addressMatch property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the addressMatch property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAddressMatch().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AddressMatch }
     * 
     * 
     */
    public List<AddressMatch> getAddressMatch() {
        if (addressMatch == null) {
            addressMatch = new ArrayList<AddressMatch>();
        }
        return this.addressMatch;
    }

}
