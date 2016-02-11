
package org.datacontract.schemas._2004._07.neuromancerlibrary_datacontracts;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for PEPDeskFunctionDetails complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PEPDeskFunctionDetails">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Category" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="DateNotInchargeSince" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ExPEP" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="Function" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SpecificFunction" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PEPDeskFunctionDetails", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts.PEPDesk", propOrder = {
    "category",
    "dateNotInchargeSince",
    "exPEP",
    "function",
    "specificFunction"
})
public class PEPDeskFunctionDetails {

    @XmlElementRef(name = "Category", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts.PEPDesk", type = JAXBElement.class, required = false)
    protected JAXBElement<String> category;
    @XmlElementRef(name = "DateNotInchargeSince", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts.PEPDesk", type = JAXBElement.class, required = false)
    protected JAXBElement<String> dateNotInchargeSince;
    @XmlElement(name = "ExPEP")
    protected Boolean exPEP;
    @XmlElementRef(name = "Function", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts.PEPDesk", type = JAXBElement.class, required = false)
    protected JAXBElement<String> function;
    @XmlElementRef(name = "SpecificFunction", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts.PEPDesk", type = JAXBElement.class, required = false)
    protected JAXBElement<String> specificFunction;

    /**
     * Gets the value of the category property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getCategory() {
        return category;
    }

    /**
     * Sets the value of the category property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setCategory(JAXBElement<String> value) {
        this.category = value;
    }

    /**
     * Gets the value of the dateNotInchargeSince property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getDateNotInchargeSince() {
        return dateNotInchargeSince;
    }

    /**
     * Sets the value of the dateNotInchargeSince property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setDateNotInchargeSince(JAXBElement<String> value) {
        this.dateNotInchargeSince = value;
    }

    /**
     * Gets the value of the exPEP property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isExPEP() {
        return exPEP;
    }

    /**
     * Sets the value of the exPEP property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setExPEP(Boolean value) {
        this.exPEP = value;
    }

    /**
     * Gets the value of the function property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getFunction() {
        return function;
    }

    /**
     * Sets the value of the function property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setFunction(JAXBElement<String> value) {
        this.function = value;
    }

    /**
     * Gets the value of the specificFunction property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getSpecificFunction() {
        return specificFunction;
    }

    /**
     * Sets the value of the specificFunction property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setSpecificFunction(JAXBElement<String> value) {
        this.specificFunction = value;
    }

}
