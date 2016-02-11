
package org.datacontract.schemas._2004._07.neuromancerlibrary_xmlserialization_idcheckglobalalpha_response;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfSourceCreditReference complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfSourceCreditReference">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="SourceCreditReference" type="{http://schemas.datacontract.org/2004/07/NeuromancerLibrary.XmlSerialization.IDCheckGlobalAlpha.Response.CreditReference}SourceCreditReference" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfSourceCreditReference", propOrder = {
    "sourceCreditReference"
})
public class ArrayOfSourceCreditReference {

    @XmlElement(name = "SourceCreditReference", nillable = true)
    protected List<SourceCreditReference> sourceCreditReference;

    /**
     * Gets the value of the sourceCreditReference property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the sourceCreditReference property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSourceCreditReference().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SourceCreditReference }
     * 
     * 
     */
    public List<SourceCreditReference> getSourceCreditReference() {
        if (sourceCreditReference == null) {
            sourceCreditReference = new ArrayList<SourceCreditReference>();
        }
        return this.sourceCreditReference;
    }

}
