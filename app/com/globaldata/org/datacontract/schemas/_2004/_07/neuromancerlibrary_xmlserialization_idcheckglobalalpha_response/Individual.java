
package org.datacontract.schemas._2004._07.neuromancerlibrary_xmlserialization_idcheckglobalalpha_response;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Individual complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Individual">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Addresses" type="{http://schemas.datacontract.org/2004/07/NeuromancerLibrary.XmlSerialization.IDCheckGlobalAlpha.Response.Individuals}AddressesIndividuals" minOccurs="0"/>
 *         &lt;element name="IdentityDocuments" type="{http://schemas.datacontract.org/2004/07/NeuromancerLibrary.XmlSerialization.IDCheckGlobalAlpha.Response.CreditReference}IdentityDocuments" minOccurs="0"/>
 *         &lt;element name="IndividualSummary" type="{http://schemas.datacontract.org/2004/07/NeuromancerLibrary.XmlSerialization.IDCheckGlobalAlpha.Response.Individuals}IndividualSummary" minOccurs="0"/>
 *         &lt;element name="Person" type="{http://schemas.datacontract.org/2004/07/NeuromancerLibrary.XmlSerialization.IDCheckGlobalAlpha.Response.CreditReference}PersonCreditReferenceRecord" minOccurs="0"/>
 *         &lt;element name="Source" type="{http://schemas.datacontract.org/2004/07/NeuromancerLibrary.XmlSerialization.IDCheckGlobalAlpha.Response.Individuals}SourceIndividuals" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Individual", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.XmlSerialization.IDCheckGlobalAlpha.Response.Individuals", propOrder = {
    "addresses",
    "identityDocuments",
    "individualSummary",
    "person",
    "source"
})
public class Individual {

    @XmlElementRef(name = "Addresses", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.XmlSerialization.IDCheckGlobalAlpha.Response.Individuals", type = JAXBElement.class, required = false)
    protected JAXBElement<AddressesIndividuals> addresses;
    @XmlElementRef(name = "IdentityDocuments", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.XmlSerialization.IDCheckGlobalAlpha.Response.Individuals", type = JAXBElement.class, required = false)
    protected JAXBElement<IdentityDocuments> identityDocuments;
    @XmlElementRef(name = "IndividualSummary", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.XmlSerialization.IDCheckGlobalAlpha.Response.Individuals", type = JAXBElement.class, required = false)
    protected JAXBElement<IndividualSummary> individualSummary;
    @XmlElementRef(name = "Person", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.XmlSerialization.IDCheckGlobalAlpha.Response.Individuals", type = JAXBElement.class, required = false)
    protected JAXBElement<PersonCreditReferenceRecord> person;
    @XmlElementRef(name = "Source", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.XmlSerialization.IDCheckGlobalAlpha.Response.Individuals", type = JAXBElement.class, required = false)
    protected JAXBElement<SourceIndividuals> source;

    /**
     * Gets the value of the addresses property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link AddressesIndividuals }{@code >}
     *     
     */
    public JAXBElement<AddressesIndividuals> getAddresses() {
        return addresses;
    }

    /**
     * Sets the value of the addresses property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link AddressesIndividuals }{@code >}
     *     
     */
    public void setAddresses(JAXBElement<AddressesIndividuals> value) {
        this.addresses = value;
    }

    /**
     * Gets the value of the identityDocuments property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link IdentityDocuments }{@code >}
     *     
     */
    public JAXBElement<IdentityDocuments> getIdentityDocuments() {
        return identityDocuments;
    }

    /**
     * Sets the value of the identityDocuments property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link IdentityDocuments }{@code >}
     *     
     */
    public void setIdentityDocuments(JAXBElement<IdentityDocuments> value) {
        this.identityDocuments = value;
    }

    /**
     * Gets the value of the individualSummary property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link IndividualSummary }{@code >}
     *     
     */
    public JAXBElement<IndividualSummary> getIndividualSummary() {
        return individualSummary;
    }

    /**
     * Sets the value of the individualSummary property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link IndividualSummary }{@code >}
     *     
     */
    public void setIndividualSummary(JAXBElement<IndividualSummary> value) {
        this.individualSummary = value;
    }

    /**
     * Gets the value of the person property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link PersonCreditReferenceRecord }{@code >}
     *     
     */
    public JAXBElement<PersonCreditReferenceRecord> getPerson() {
        return person;
    }

    /**
     * Sets the value of the person property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link PersonCreditReferenceRecord }{@code >}
     *     
     */
    public void setPerson(JAXBElement<PersonCreditReferenceRecord> value) {
        this.person = value;
    }

    /**
     * Gets the value of the source property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link SourceIndividuals }{@code >}
     *     
     */
    public JAXBElement<SourceIndividuals> getSource() {
        return source;
    }

    /**
     * Sets the value of the source property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link SourceIndividuals }{@code >}
     *     
     */
    public void setSource(JAXBElement<SourceIndividuals> value) {
        this.source = value;
    }

}
