
package org.datacontract.schemas._2004._07.neuromancerlibrary_datacontracts;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfPEPDeskNameDetails complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfPEPDeskNameDetails">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="PEPDeskNameDetails" type="{http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts.PEPDesk}PEPDeskNameDetails" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfPEPDeskNameDetails", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts.PEPDesk", propOrder = {
    "pepDeskNameDetails"
})
public class ArrayOfPEPDeskNameDetails {

    @XmlElement(name = "PEPDeskNameDetails", nillable = true)
    protected List<PEPDeskNameDetails> pepDeskNameDetails;

    /**
     * Gets the value of the pepDeskNameDetails property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the pepDeskNameDetails property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPEPDeskNameDetails().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PEPDeskNameDetails }
     * 
     * 
     */
    public List<PEPDeskNameDetails> getPEPDeskNameDetails() {
        if (pepDeskNameDetails == null) {
            pepDeskNameDetails = new ArrayList<PEPDeskNameDetails>();
        }
        return this.pepDeskNameDetails;
    }

}
