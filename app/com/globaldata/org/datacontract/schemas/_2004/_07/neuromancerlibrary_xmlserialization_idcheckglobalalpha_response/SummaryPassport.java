
package org.datacontract.schemas._2004._07.neuromancerlibrary_xmlserialization_idcheckglobalalpha_response;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for SummaryPassport complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SummaryPassport">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Decision" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="DecisionReasons" type="{http://schemas.datacontract.org/2004/07/NeuromancerLibrary.XmlSerialization.IDCheckGlobalAlpha.Response.Passport}DecisionReasonsPassport" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SummaryPassport", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.XmlSerialization.IDCheckGlobalAlpha.Response.Passport", propOrder = {
    "decision",
    "decisionReasons"
})
public class SummaryPassport {

    @XmlElementRef(name = "Decision", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.XmlSerialization.IDCheckGlobalAlpha.Response.Passport", type = JAXBElement.class, required = false)
    protected JAXBElement<String> decision;
    @XmlElementRef(name = "DecisionReasons", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.XmlSerialization.IDCheckGlobalAlpha.Response.Passport", type = JAXBElement.class, required = false)
    protected JAXBElement<DecisionReasonsPassport> decisionReasons;

    /**
     * Gets the value of the decision property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getDecision() {
        return decision;
    }

    /**
     * Sets the value of the decision property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setDecision(JAXBElement<String> value) {
        this.decision = value;
    }

    /**
     * Gets the value of the decisionReasons property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link DecisionReasonsPassport }{@code >}
     *     
     */
    public JAXBElement<DecisionReasonsPassport> getDecisionReasons() {
        return decisionReasons;
    }

    /**
     * Sets the value of the decisionReasons property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link DecisionReasonsPassport }{@code >}
     *     
     */
    public void setDecisionReasons(JAXBElement<DecisionReasonsPassport> value) {
        this.decisionReasons = value;
    }

}