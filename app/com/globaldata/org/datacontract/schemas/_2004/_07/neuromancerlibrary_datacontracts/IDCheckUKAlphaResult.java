
package org.datacontract.schemas._2004._07.neuromancerlibrary_datacontracts;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for IDCheckUKAlphaResult complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="IDCheckUKAlphaResult">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="CreditHeaderMatches" type="{http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts.IDCheckUKAlpha}ArrayOfIDCheckUKAlphaCreditHeaderMatch" minOccurs="0"/>
 *         &lt;element name="DataSet" type="{http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts.IDCheckUKAlpha}ArrayOfIDCheckUKAlphaData" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "IDCheckUKAlphaResult", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts.IDCheckUKAlpha", propOrder = {
    "creditHeaderMatches",
    "dataSet"
})
public class IDCheckUKAlphaResult {

    @XmlElementRef(name = "CreditHeaderMatches", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts.IDCheckUKAlpha", type = JAXBElement.class, required = false)
    protected JAXBElement<ArrayOfIDCheckUKAlphaCreditHeaderMatch> creditHeaderMatches;
    @XmlElementRef(name = "DataSet", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts.IDCheckUKAlpha", type = JAXBElement.class, required = false)
    protected JAXBElement<ArrayOfIDCheckUKAlphaData> dataSet;

    /**
     * Gets the value of the creditHeaderMatches property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfIDCheckUKAlphaCreditHeaderMatch }{@code >}
     *     
     */
    public JAXBElement<ArrayOfIDCheckUKAlphaCreditHeaderMatch> getCreditHeaderMatches() {
        return creditHeaderMatches;
    }

    /**
     * Sets the value of the creditHeaderMatches property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfIDCheckUKAlphaCreditHeaderMatch }{@code >}
     *     
     */
    public void setCreditHeaderMatches(JAXBElement<ArrayOfIDCheckUKAlphaCreditHeaderMatch> value) {
        this.creditHeaderMatches = value;
    }

    /**
     * Gets the value of the dataSet property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfIDCheckUKAlphaData }{@code >}
     *     
     */
    public JAXBElement<ArrayOfIDCheckUKAlphaData> getDataSet() {
        return dataSet;
    }

    /**
     * Sets the value of the dataSet property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfIDCheckUKAlphaData }{@code >}
     *     
     */
    public void setDataSet(JAXBElement<ArrayOfIDCheckUKAlphaData> value) {
        this.dataSet = value;
    }

}
