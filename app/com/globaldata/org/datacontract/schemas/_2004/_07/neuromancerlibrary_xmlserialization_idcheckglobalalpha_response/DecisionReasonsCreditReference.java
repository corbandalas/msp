
package org.datacontract.schemas._2004._07.neuromancerlibrary_xmlserialization_idcheckglobalalpha_response;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for DecisionReasonsCreditReference complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DecisionReasonsCreditReference">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="DecisionReasonList" type="{http://schemas.datacontract.org/2004/07/NeuromancerLibrary.XmlSerialization.IDCheckGlobalAlpha.Response.CreditReference}ArrayOfDecisionReasonCreditReference" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DecisionReasonsCreditReference", propOrder = {
    "decisionReasonList"
})
public class DecisionReasonsCreditReference {

    @XmlElementRef(name = "DecisionReasonList", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.XmlSerialization.IDCheckGlobalAlpha.Response.CreditReference", type = JAXBElement.class, required = false)
    protected JAXBElement<ArrayOfDecisionReasonCreditReference> decisionReasonList;

    /**
     * Gets the value of the decisionReasonList property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfDecisionReasonCreditReference }{@code >}
     *     
     */
    public JAXBElement<ArrayOfDecisionReasonCreditReference> getDecisionReasonList() {
        return decisionReasonList;
    }

    /**
     * Sets the value of the decisionReasonList property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfDecisionReasonCreditReference }{@code >}
     *     
     */
    public void setDecisionReasonList(JAXBElement<ArrayOfDecisionReasonCreditReference> value) {
        this.decisionReasonList = value;
    }

}
