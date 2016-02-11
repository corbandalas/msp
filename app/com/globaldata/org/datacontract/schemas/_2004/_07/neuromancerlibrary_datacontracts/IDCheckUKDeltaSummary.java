
package org.datacontract.schemas._2004._07.neuromancerlibrary_datacontracts;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for IDCheckUKDeltaSummary complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="IDCheckUKDeltaSummary">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Reference" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ResultText" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Scorecard" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Smartscore" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="UniqueSearchId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="UniqueSearchIdKey" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "IDCheckUKDeltaSummary", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts.IDCheckUKDelta", propOrder = {
    "reference",
    "resultText",
    "scorecard",
    "smartscore",
    "uniqueSearchId",
    "uniqueSearchIdKey"
})
public class IDCheckUKDeltaSummary {

    @XmlElementRef(name = "Reference", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts.IDCheckUKDelta", type = JAXBElement.class, required = false)
    protected JAXBElement<String> reference;
    @XmlElementRef(name = "ResultText", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts.IDCheckUKDelta", type = JAXBElement.class, required = false)
    protected JAXBElement<String> resultText;
    @XmlElementRef(name = "Scorecard", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts.IDCheckUKDelta", type = JAXBElement.class, required = false)
    protected JAXBElement<String> scorecard;
    @XmlElement(name = "Smartscore")
    protected Integer smartscore;
    @XmlElementRef(name = "UniqueSearchId", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts.IDCheckUKDelta", type = JAXBElement.class, required = false)
    protected JAXBElement<String> uniqueSearchId;
    @XmlElementRef(name = "UniqueSearchIdKey", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts.IDCheckUKDelta", type = JAXBElement.class, required = false)
    protected JAXBElement<String> uniqueSearchIdKey;

    /**
     * Gets the value of the reference property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getReference() {
        return reference;
    }

    /**
     * Sets the value of the reference property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setReference(JAXBElement<String> value) {
        this.reference = value;
    }

    /**
     * Gets the value of the resultText property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getResultText() {
        return resultText;
    }

    /**
     * Sets the value of the resultText property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setResultText(JAXBElement<String> value) {
        this.resultText = value;
    }

    /**
     * Gets the value of the scorecard property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getScorecard() {
        return scorecard;
    }

    /**
     * Sets the value of the scorecard property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setScorecard(JAXBElement<String> value) {
        this.scorecard = value;
    }

    /**
     * Gets the value of the smartscore property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getSmartscore() {
        return smartscore;
    }

    /**
     * Sets the value of the smartscore property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setSmartscore(Integer value) {
        this.smartscore = value;
    }

    /**
     * Gets the value of the uniqueSearchId property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getUniqueSearchId() {
        return uniqueSearchId;
    }

    /**
     * Sets the value of the uniqueSearchId property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setUniqueSearchId(JAXBElement<String> value) {
        this.uniqueSearchId = value;
    }

    /**
     * Gets the value of the uniqueSearchIdKey property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getUniqueSearchIdKey() {
        return uniqueSearchIdKey;
    }

    /**
     * Sets the value of the uniqueSearchIdKey property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setUniqueSearchIdKey(JAXBElement<String> value) {
        this.uniqueSearchIdKey = value;
    }

}
