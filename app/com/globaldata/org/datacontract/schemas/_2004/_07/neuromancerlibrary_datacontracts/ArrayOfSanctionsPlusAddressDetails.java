
package org.datacontract.schemas._2004._07.neuromancerlibrary_datacontracts;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfSanctionsPlusAddressDetails complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfSanctionsPlusAddressDetails">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="SanctionsPlusAddressDetails" type="{http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts.SanctionsPlus}SanctionsPlusAddressDetails" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfSanctionsPlusAddressDetails", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts.SanctionsPlus", propOrder = {
    "sanctionsPlusAddressDetails"
})
public class ArrayOfSanctionsPlusAddressDetails {

    @XmlElement(name = "SanctionsPlusAddressDetails", nillable = true)
    protected List<SanctionsPlusAddressDetails> sanctionsPlusAddressDetails;

    /**
     * Gets the value of the sanctionsPlusAddressDetails property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the sanctionsPlusAddressDetails property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSanctionsPlusAddressDetails().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SanctionsPlusAddressDetails }
     * 
     * 
     */
    public List<SanctionsPlusAddressDetails> getSanctionsPlusAddressDetails() {
        if (sanctionsPlusAddressDetails == null) {
            sanctionsPlusAddressDetails = new ArrayList<SanctionsPlusAddressDetails>();
        }
        return this.sanctionsPlusAddressDetails;
    }

}
