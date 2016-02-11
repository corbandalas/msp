
package org.datacontract.schemas._2004._07.neuromancerlibrary_xmlserialization_idcheckglobalalpha;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Summary complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Summary">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="DecisionMatrix" type="{http://schemas.datacontract.org/2004/07/NeuromancerLibrary.XmlSerialization.IDCheckGlobalAlpha.Response}DecisionMatrix" minOccurs="0"/>
 *         &lt;element name="KYCSummary" type="{http://schemas.datacontract.org/2004/07/NeuromancerLibrary.XmlSerialization.IDCheckGlobalAlpha.Response}KYCSummary" minOccurs="0"/>
 *         &lt;element name="ReportSummary" type="{http://schemas.datacontract.org/2004/07/NeuromancerLibrary.XmlSerialization.IDCheckGlobalAlpha.Response}ReportSummary" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Summary", propOrder = {
    "decisionMatrix",
    "kycSummary",
    "reportSummary"
})
public class Summary {

    @XmlElementRef(name = "DecisionMatrix", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.XmlSerialization.IDCheckGlobalAlpha.Response", type = JAXBElement.class, required = false)
    protected JAXBElement<DecisionMatrix> decisionMatrix;
    @XmlElementRef(name = "KYCSummary", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.XmlSerialization.IDCheckGlobalAlpha.Response", type = JAXBElement.class, required = false)
    protected JAXBElement<KYCSummary> kycSummary;
    @XmlElementRef(name = "ReportSummary", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.XmlSerialization.IDCheckGlobalAlpha.Response", type = JAXBElement.class, required = false)
    protected JAXBElement<ReportSummary> reportSummary;

    /**
     * Gets the value of the decisionMatrix property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link DecisionMatrix }{@code >}
     *     
     */
    public JAXBElement<DecisionMatrix> getDecisionMatrix() {
        return decisionMatrix;
    }

    /**
     * Sets the value of the decisionMatrix property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link DecisionMatrix }{@code >}
     *     
     */
    public void setDecisionMatrix(JAXBElement<DecisionMatrix> value) {
        this.decisionMatrix = value;
    }

    /**
     * Gets the value of the kycSummary property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link KYCSummary }{@code >}
     *     
     */
    public JAXBElement<KYCSummary> getKYCSummary() {
        return kycSummary;
    }

    /**
     * Sets the value of the kycSummary property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link KYCSummary }{@code >}
     *     
     */
    public void setKYCSummary(JAXBElement<KYCSummary> value) {
        this.kycSummary = value;
    }

    /**
     * Gets the value of the reportSummary property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ReportSummary }{@code >}
     *     
     */
    public JAXBElement<ReportSummary> getReportSummary() {
        return reportSummary;
    }

    /**
     * Sets the value of the reportSummary property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ReportSummary }{@code >}
     *     
     */
    public void setReportSummary(JAXBElement<ReportSummary> value) {
        this.reportSummary = value;
    }

}
