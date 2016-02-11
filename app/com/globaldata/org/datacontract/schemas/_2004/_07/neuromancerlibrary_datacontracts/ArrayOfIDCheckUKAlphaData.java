
package org.datacontract.schemas._2004._07.neuromancerlibrary_datacontracts;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfIDCheckUKAlphaData complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfIDCheckUKAlphaData">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="IDCheckUKAlphaData" type="{http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts.IDCheckUKAlpha}IDCheckUKAlphaData" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfIDCheckUKAlphaData", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts.IDCheckUKAlpha", propOrder = {
    "idCheckUKAlphaData"
})
public class ArrayOfIDCheckUKAlphaData {

    @XmlElement(name = "IDCheckUKAlphaData", nillable = true)
    protected List<IDCheckUKAlphaData> idCheckUKAlphaData;

    /**
     * Gets the value of the idCheckUKAlphaData property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the idCheckUKAlphaData property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getIDCheckUKAlphaData().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link IDCheckUKAlphaData }
     * 
     * 
     */
    public List<IDCheckUKAlphaData> getIDCheckUKAlphaData() {
        if (idCheckUKAlphaData == null) {
            idCheckUKAlphaData = new ArrayList<IDCheckUKAlphaData>();
        }
        return this.idCheckUKAlphaData;
    }

}
