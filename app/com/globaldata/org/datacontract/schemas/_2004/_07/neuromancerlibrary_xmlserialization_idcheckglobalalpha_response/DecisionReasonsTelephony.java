
package org.datacontract.schemas._2004._07.neuromancerlibrary_xmlserialization_idcheckglobalalpha_response;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for DecisionReasonsTelephony complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DecisionReasonsTelephony">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="DecisionReasonList" type="{http://schemas.datacontract.org/2004/07/NeuromancerLibrary.XmlSerialization.IDCheckGlobalAlpha.Response.Telephony}ArrayOfDecisionReasonTelephony" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DecisionReasonsTelephony", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.XmlSerialization.IDCheckGlobalAlpha.Response.Telephony", propOrder = {
    "decisionReasonList"
})
public class DecisionReasonsTelephony {

    @XmlElementRef(name = "DecisionReasonList", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.XmlSerialization.IDCheckGlobalAlpha.Response.Telephony", type = JAXBElement.class, required = false)
    protected JAXBElement<ArrayOfDecisionReasonTelephony> decisionReasonList;

    /**
     * Gets the value of the decisionReasonList property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfDecisionReasonTelephony }{@code >}
     *     
     */
    public JAXBElement<ArrayOfDecisionReasonTelephony> getDecisionReasonList() {
        return decisionReasonList;
    }

    /**
     * Sets the value of the decisionReasonList property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfDecisionReasonTelephony }{@code >}
     *     
     */
    public void setDecisionReasonList(JAXBElement<ArrayOfDecisionReasonTelephony> value) {
        this.decisionReasonList = value;
    }

}
