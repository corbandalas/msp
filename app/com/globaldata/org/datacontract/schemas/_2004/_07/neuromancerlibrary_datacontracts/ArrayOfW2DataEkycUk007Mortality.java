
package org.datacontract.schemas._2004._07.neuromancerlibrary_datacontracts;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfW2DataEkycUk007Mortality complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfW2DataEkycUk007Mortality">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="W2DataEkycUk007Mortality" type="{http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts.W2DataEkycUk007}W2DataEkycUk007Mortality" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfW2DataEkycUk007Mortality", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts.W2DataEkycUk007", propOrder = {
    "w2DataEkycUk007Mortality"
})
public class ArrayOfW2DataEkycUk007Mortality {

    @XmlElement(name = "W2DataEkycUk007Mortality", nillable = true)
    protected List<W2DataEkycUk007Mortality> w2DataEkycUk007Mortality;

    /**
     * Gets the value of the w2DataEkycUk007Mortality property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the w2DataEkycUk007Mortality property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getW2DataEkycUk007Mortality().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link W2DataEkycUk007Mortality }
     * 
     * 
     */
    public List<W2DataEkycUk007Mortality> getW2DataEkycUk007Mortality() {
        if (w2DataEkycUk007Mortality == null) {
            w2DataEkycUk007Mortality = new ArrayList<W2DataEkycUk007Mortality>();
        }
        return this.w2DataEkycUk007Mortality;
    }

}
