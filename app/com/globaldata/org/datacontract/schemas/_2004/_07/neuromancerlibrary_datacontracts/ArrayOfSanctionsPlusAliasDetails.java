
package org.datacontract.schemas._2004._07.neuromancerlibrary_datacontracts;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfSanctionsPlusAliasDetails complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfSanctionsPlusAliasDetails">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="SanctionsPlusAliasDetails" type="{http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts.SanctionsPlus}SanctionsPlusAliasDetails" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfSanctionsPlusAliasDetails", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts.SanctionsPlus", propOrder = {
    "sanctionsPlusAliasDetails"
})
public class ArrayOfSanctionsPlusAliasDetails {

    @XmlElement(name = "SanctionsPlusAliasDetails", nillable = true)
    protected List<SanctionsPlusAliasDetails> sanctionsPlusAliasDetails;

    /**
     * Gets the value of the sanctionsPlusAliasDetails property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the sanctionsPlusAliasDetails property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSanctionsPlusAliasDetails().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SanctionsPlusAliasDetails }
     * 
     * 
     */
    public List<SanctionsPlusAliasDetails> getSanctionsPlusAliasDetails() {
        if (sanctionsPlusAliasDetails == null) {
            sanctionsPlusAliasDetails = new ArrayList<SanctionsPlusAliasDetails>();
        }
        return this.sanctionsPlusAliasDetails;
    }

}
