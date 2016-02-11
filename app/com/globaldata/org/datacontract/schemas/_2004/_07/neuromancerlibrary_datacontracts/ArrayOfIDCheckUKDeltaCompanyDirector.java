
package org.datacontract.schemas._2004._07.neuromancerlibrary_datacontracts;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfIDCheckUKDeltaCompanyDirector complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfIDCheckUKDeltaCompanyDirector">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="IDCheckUKDeltaCompanyDirector" type="{http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts.IDCheckUKDelta}IDCheckUKDeltaCompanyDirector" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfIDCheckUKDeltaCompanyDirector", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts.IDCheckUKDelta", propOrder = {
    "idCheckUKDeltaCompanyDirector"
})
public class ArrayOfIDCheckUKDeltaCompanyDirector {

    @XmlElement(name = "IDCheckUKDeltaCompanyDirector", nillable = true)
    protected List<IDCheckUKDeltaCompanyDirector> idCheckUKDeltaCompanyDirector;

    /**
     * Gets the value of the idCheckUKDeltaCompanyDirector property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the idCheckUKDeltaCompanyDirector property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getIDCheckUKDeltaCompanyDirector().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link IDCheckUKDeltaCompanyDirector }
     * 
     * 
     */
    public List<IDCheckUKDeltaCompanyDirector> getIDCheckUKDeltaCompanyDirector() {
        if (idCheckUKDeltaCompanyDirector == null) {
            idCheckUKDeltaCompanyDirector = new ArrayList<IDCheckUKDeltaCompanyDirector>();
        }
        return this.idCheckUKDeltaCompanyDirector;
    }

}
