
package org.datacontract.schemas._2004._07.neuromancerlibrary_xmlserialization_idcheckglobalalpha_response;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for DecisionReasonsDriverLicence complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DecisionReasonsDriverLicence">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="DecisionReasonList" type="{http://schemas.datacontract.org/2004/07/NeuromancerLibrary.XmlSerialization.IDCheckGlobalAlpha.Response.DriverLicence}ArrayOfDecisionReasonDriverLicence" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DecisionReasonsDriverLicence", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.XmlSerialization.IDCheckGlobalAlpha.Response.DriverLicence", propOrder = {
    "decisionReasonList"
})
public class DecisionReasonsDriverLicence {

    @XmlElementRef(name = "DecisionReasonList", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.XmlSerialization.IDCheckGlobalAlpha.Response.DriverLicence", type = JAXBElement.class, required = false)
    protected JAXBElement<ArrayOfDecisionReasonDriverLicence> decisionReasonList;

    /**
     * Gets the value of the decisionReasonList property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfDecisionReasonDriverLicence }{@code >}
     *     
     */
    public JAXBElement<ArrayOfDecisionReasonDriverLicence> getDecisionReasonList() {
        return decisionReasonList;
    }

    /**
     * Sets the value of the decisionReasonList property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfDecisionReasonDriverLicence }{@code >}
     *     
     */
    public void setDecisionReasonList(JAXBElement<ArrayOfDecisionReasonDriverLicence> value) {
        this.decisionReasonList = value;
    }

}
