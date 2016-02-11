
package org.datacontract.schemas._2004._07.neuromancerlibrary_datacontracts;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfIDCheckAddressLookupMatch complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfIDCheckAddressLookupMatch">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="IDCheckAddressLookupMatch" type="{http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts.IDCheckAddressLookup}IDCheckAddressLookupMatch" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfIDCheckAddressLookupMatch", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts.IDCheckAddressLookup", propOrder = {
    "idCheckAddressLookupMatch"
})
public class ArrayOfIDCheckAddressLookupMatch {

    @XmlElement(name = "IDCheckAddressLookupMatch", nillable = true)
    protected List<IDCheckAddressLookupMatch> idCheckAddressLookupMatch;

    /**
     * Gets the value of the idCheckAddressLookupMatch property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the idCheckAddressLookupMatch property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getIDCheckAddressLookupMatch().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link IDCheckAddressLookupMatch }
     * 
     * 
     */
    public List<IDCheckAddressLookupMatch> getIDCheckAddressLookupMatch() {
        if (idCheckAddressLookupMatch == null) {
            idCheckAddressLookupMatch = new ArrayList<IDCheckAddressLookupMatch>();
        }
        return this.idCheckAddressLookupMatch;
    }

}
