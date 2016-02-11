
package org.datacontract.schemas._2004._07.neuromancerlibrary_externalservices_iddocumentcheck_proxies;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfRejectionReasonsItemResponseElementModel complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfRejectionReasonsItemResponseElementModel">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="RejectionReasonsItemResponseElementModel" type="{http://schemas.datacontract.org/2004/07/NeuromancerLibrary.ExternalServices.IDDocumentCheck.Proxies.Results}RejectionReasonsItemResponseElementModel" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfRejectionReasonsItemResponseElementModel", propOrder = {
    "rejectionReasonsItemResponseElementModel"
})
public class ArrayOfRejectionReasonsItemResponseElementModel {

    @XmlElement(name = "RejectionReasonsItemResponseElementModel", nillable = true)
    protected List<RejectionReasonsItemResponseElementModel> rejectionReasonsItemResponseElementModel;

    /**
     * Gets the value of the rejectionReasonsItemResponseElementModel property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the rejectionReasonsItemResponseElementModel property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRejectionReasonsItemResponseElementModel().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link RejectionReasonsItemResponseElementModel }
     * 
     * 
     */
    public List<RejectionReasonsItemResponseElementModel> getRejectionReasonsItemResponseElementModel() {
        if (rejectionReasonsItemResponseElementModel == null) {
            rejectionReasonsItemResponseElementModel = new ArrayList<RejectionReasonsItemResponseElementModel>();
        }
        return this.rejectionReasonsItemResponseElementModel;
    }

}
