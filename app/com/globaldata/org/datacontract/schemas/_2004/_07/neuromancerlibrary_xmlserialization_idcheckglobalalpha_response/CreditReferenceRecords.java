
package org.datacontract.schemas._2004._07.neuromancerlibrary_xmlserialization_idcheckglobalalpha_response;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for CreditReferenceRecords complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CreditReferenceRecords">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="CreditReferenceRecordList" type="{http://schemas.datacontract.org/2004/07/NeuromancerLibrary.XmlSerialization.IDCheckGlobalAlpha.Response.CreditReference}ArrayOfCreditReferenceRecord" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CreditReferenceRecords", propOrder = {
    "creditReferenceRecordList"
})
public class CreditReferenceRecords {

    @XmlElementRef(name = "CreditReferenceRecordList", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.XmlSerialization.IDCheckGlobalAlpha.Response.CreditReference", type = JAXBElement.class, required = false)
    protected JAXBElement<ArrayOfCreditReferenceRecord> creditReferenceRecordList;

    /**
     * Gets the value of the creditReferenceRecordList property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfCreditReferenceRecord }{@code >}
     *     
     */
    public JAXBElement<ArrayOfCreditReferenceRecord> getCreditReferenceRecordList() {
        return creditReferenceRecordList;
    }

    /**
     * Sets the value of the creditReferenceRecordList property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfCreditReferenceRecord }{@code >}
     *     
     */
    public void setCreditReferenceRecordList(JAXBElement<ArrayOfCreditReferenceRecord> value) {
        this.creditReferenceRecordList = value;
    }

}
