
package org.datacontract.schemas._2004._07.neuromancerlibrary_xmlserialization_idcheckglobalalpha;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ReportSummary complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ReportSummary">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="DatablocksSummary" type="{http://schemas.datacontract.org/2004/07/NeuromancerLibrary.XmlSerialization.IDCheckGlobalAlpha.Response}DatablocksSummary" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ReportSummary", propOrder = {
    "datablocksSummary"
})
public class ReportSummary {

    @XmlElementRef(name = "DatablocksSummary", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.XmlSerialization.IDCheckGlobalAlpha.Response", type = JAXBElement.class, required = false)
    protected JAXBElement<DatablocksSummary> datablocksSummary;

    /**
     * Gets the value of the datablocksSummary property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link DatablocksSummary }{@code >}
     *     
     */
    public JAXBElement<DatablocksSummary> getDatablocksSummary() {
        return datablocksSummary;
    }

    /**
     * Sets the value of the datablocksSummary property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link DatablocksSummary }{@code >}
     *     
     */
    public void setDatablocksSummary(JAXBElement<DatablocksSummary> value) {
        this.datablocksSummary = value;
    }

}
