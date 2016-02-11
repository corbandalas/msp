
package org.datacontract.schemas._2004._07.neuromancerlibrary_datacontracts;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;
import org.datacontract.schemas._2004._07.neuromancerlibrary_xmlserialization_idcheckglobalalpha.Summary;
import org.datacontract.schemas._2004._07.neuromancerlibrary_xmlserialization_idcheckglobalalpha_response.IndividualsResult;
import org.datacontract.schemas._2004._07.neuromancerlibrary_xmlserialization_idcheckglobalalpha_response.PassportResult;


/**
 * <p>Java class for IDCheckZAAlphaResult complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="IDCheckZAAlphaResult">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Individuals" type="{http://schemas.datacontract.org/2004/07/NeuromancerLibrary.XmlSerialization.IDCheckGlobalAlpha.Response.Individuals}IndividualsResult" minOccurs="0"/>
 *         &lt;element name="Passport" type="{http://schemas.datacontract.org/2004/07/NeuromancerLibrary.XmlSerialization.IDCheckGlobalAlpha.Response.Passport}PassportResult" minOccurs="0"/>
 *         &lt;element name="SearchRef" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Summary" type="{http://schemas.datacontract.org/2004/07/NeuromancerLibrary.XmlSerialization.IDCheckGlobalAlpha.Response}Summary" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "IDCheckZAAlphaResult", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts.IDCheckGlobalAlpha", propOrder = {
    "individuals",
    "passport",
    "searchRef",
    "summary"
})
public class IDCheckZAAlphaResult {

    @XmlElementRef(name = "Individuals", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts.IDCheckGlobalAlpha", type = JAXBElement.class, required = false)
    protected JAXBElement<IndividualsResult> individuals;
    @XmlElementRef(name = "Passport", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts.IDCheckGlobalAlpha", type = JAXBElement.class, required = false)
    protected JAXBElement<PassportResult> passport;
    @XmlElementRef(name = "SearchRef", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts.IDCheckGlobalAlpha", type = JAXBElement.class, required = false)
    protected JAXBElement<String> searchRef;
    @XmlElementRef(name = "Summary", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts.IDCheckGlobalAlpha", type = JAXBElement.class, required = false)
    protected JAXBElement<Summary> summary;

    /**
     * Gets the value of the individuals property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link IndividualsResult }{@code >}
     *     
     */
    public JAXBElement<IndividualsResult> getIndividuals() {
        return individuals;
    }

    /**
     * Sets the value of the individuals property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link IndividualsResult }{@code >}
     *     
     */
    public void setIndividuals(JAXBElement<IndividualsResult> value) {
        this.individuals = value;
    }

    /**
     * Gets the value of the passport property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link PassportResult }{@code >}
     *     
     */
    public JAXBElement<PassportResult> getPassport() {
        return passport;
    }

    /**
     * Sets the value of the passport property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link PassportResult }{@code >}
     *     
     */
    public void setPassport(JAXBElement<PassportResult> value) {
        this.passport = value;
    }

    /**
     * Gets the value of the searchRef property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getSearchRef() {
        return searchRef;
    }

    /**
     * Sets the value of the searchRef property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setSearchRef(JAXBElement<String> value) {
        this.searchRef = value;
    }

    /**
     * Gets the value of the summary property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Summary }{@code >}
     *     
     */
    public JAXBElement<Summary> getSummary() {
        return summary;
    }

    /**
     * Sets the value of the summary property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Summary }{@code >}
     *     
     */
    public void setSummary(JAXBElement<Summary> value) {
        this.summary = value;
    }

}
