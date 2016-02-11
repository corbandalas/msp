
package org.datacontract.schemas._2004._07.neuromancerlibrary_xmlserialization_idcheckglobalalpha;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for DatablocksSummary complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DatablocksSummary">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="DatablockSummaryList" type="{http://schemas.datacontract.org/2004/07/NeuromancerLibrary.XmlSerialization.IDCheckGlobalAlpha.Response}ArrayOfDatablockSummary" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DatablocksSummary", propOrder = {
    "datablockSummaryList"
})
public class DatablocksSummary {

    @XmlElementRef(name = "DatablockSummaryList", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.XmlSerialization.IDCheckGlobalAlpha.Response", type = JAXBElement.class, required = false)
    protected JAXBElement<ArrayOfDatablockSummary> datablockSummaryList;

    /**
     * Gets the value of the datablockSummaryList property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfDatablockSummary }{@code >}
     *     
     */
    public JAXBElement<ArrayOfDatablockSummary> getDatablockSummaryList() {
        return datablockSummaryList;
    }

    /**
     * Sets the value of the datablockSummaryList property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfDatablockSummary }{@code >}
     *     
     */
    public void setDatablockSummaryList(JAXBElement<ArrayOfDatablockSummary> value) {
        this.datablockSummaryList = value;
    }

}
