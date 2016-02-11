
package org.datacontract.schemas._2004._07.neuromancerlibrary_externalservices_iddocumentcheck_proxies;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfDocumentCheckFailureItemElementModel complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfDocumentCheckFailureItemElementModel">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="DocumentCheckFailureItemElementModel" type="{http://schemas.datacontract.org/2004/07/NeuromancerLibrary.ExternalServices.IDDocumentCheck.Proxies.Results}DocumentCheckFailureItemElementModel" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfDocumentCheckFailureItemElementModel", propOrder = {
    "documentCheckFailureItemElementModel"
})
public class ArrayOfDocumentCheckFailureItemElementModel {

    @XmlElement(name = "DocumentCheckFailureItemElementModel", nillable = true)
    protected List<DocumentCheckFailureItemElementModel> documentCheckFailureItemElementModel;

    /**
     * Gets the value of the documentCheckFailureItemElementModel property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the documentCheckFailureItemElementModel property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDocumentCheckFailureItemElementModel().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DocumentCheckFailureItemElementModel }
     * 
     * 
     */
    public List<DocumentCheckFailureItemElementModel> getDocumentCheckFailureItemElementModel() {
        if (documentCheckFailureItemElementModel == null) {
            documentCheckFailureItemElementModel = new ArrayList<DocumentCheckFailureItemElementModel>();
        }
        return this.documentCheckFailureItemElementModel;
    }

}
