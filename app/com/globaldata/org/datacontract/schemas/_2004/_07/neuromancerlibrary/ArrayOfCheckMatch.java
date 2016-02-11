
package org.datacontract.schemas._2004._07.neuromancerlibrary;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfCheckMatch complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfCheckMatch">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="CheckMatch" type="{http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts}CheckMatch" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfCheckMatch", propOrder = {
    "checkMatch"
})
public class ArrayOfCheckMatch {

    @XmlElement(name = "CheckMatch", nillable = true)
    protected List<CheckMatch> checkMatch;

    /**
     * Gets the value of the checkMatch property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the checkMatch property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCheckMatch().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CheckMatch }
     * 
     * 
     */
    public List<CheckMatch> getCheckMatch() {
        if (checkMatch == null) {
            checkMatch = new ArrayList<CheckMatch>();
        }
        return this.checkMatch;
    }

}
