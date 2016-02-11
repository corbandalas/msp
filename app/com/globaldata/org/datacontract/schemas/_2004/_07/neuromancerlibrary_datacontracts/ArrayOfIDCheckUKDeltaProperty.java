
package org.datacontract.schemas._2004._07.neuromancerlibrary_datacontracts;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfIDCheckUKDeltaProperty complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfIDCheckUKDeltaProperty">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="IDCheckUKDeltaProperty" type="{http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts.IDCheckUKDelta}IDCheckUKDeltaProperty" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfIDCheckUKDeltaProperty", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts.IDCheckUKDelta", propOrder = {
    "idCheckUKDeltaProperty"
})
public class ArrayOfIDCheckUKDeltaProperty {

    @XmlElement(name = "IDCheckUKDeltaProperty", nillable = true)
    protected List<IDCheckUKDeltaProperty> idCheckUKDeltaProperty;

    /**
     * Gets the value of the idCheckUKDeltaProperty property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the idCheckUKDeltaProperty property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getIDCheckUKDeltaProperty().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link IDCheckUKDeltaProperty }
     * 
     * 
     */
    public List<IDCheckUKDeltaProperty> getIDCheckUKDeltaProperty() {
        if (idCheckUKDeltaProperty == null) {
            idCheckUKDeltaProperty = new ArrayList<IDCheckUKDeltaProperty>();
        }
        return this.idCheckUKDeltaProperty;
    }

}
