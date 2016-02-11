
package org.datacontract.schemas._2004._07.neuromancerlibrary_xmlserialization_idcheckglobalalpha_response;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfAddressCreditReferenceRecord complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfAddressCreditReferenceRecord">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="AddressCreditReferenceRecord" type="{http://schemas.datacontract.org/2004/07/NeuromancerLibrary.XmlSerialization.IDCheckGlobalAlpha.Response.CreditReference}AddressCreditReferenceRecord" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfAddressCreditReferenceRecord", propOrder = {
    "addressCreditReferenceRecord"
})
public class ArrayOfAddressCreditReferenceRecord {

    @XmlElement(name = "AddressCreditReferenceRecord", nillable = true)
    protected List<AddressCreditReferenceRecord> addressCreditReferenceRecord;

    /**
     * Gets the value of the addressCreditReferenceRecord property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the addressCreditReferenceRecord property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAddressCreditReferenceRecord().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AddressCreditReferenceRecord }
     * 
     * 
     */
    public List<AddressCreditReferenceRecord> getAddressCreditReferenceRecord() {
        if (addressCreditReferenceRecord == null) {
            addressCreditReferenceRecord = new ArrayList<AddressCreditReferenceRecord>();
        }
        return this.addressCreditReferenceRecord;
    }

}
