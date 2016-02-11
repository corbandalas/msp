
package org.datacontract.schemas._2004._07.neuromancerlibrary_xmlserialization_idcheckglobalalpha_response;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for CreditReferenceRecord complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CreditReferenceRecord">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Addresses" type="{http://schemas.datacontract.org/2004/07/NeuromancerLibrary.XmlSerialization.IDCheckGlobalAlpha.Response.CreditReference}AddressesCreditReference" minOccurs="0"/>
 *         &lt;element name="Comments" type="{http://schemas.datacontract.org/2004/07/NeuromancerLibrary.XmlSerialization.IDCheckGlobalAlpha.Response.CreditReference}CommentsCreditReference" minOccurs="0"/>
 *         &lt;element name="DriverLicence" type="{http://schemas.datacontract.org/2004/07/NeuromancerLibrary.XmlSerialization.IDCheckGlobalAlpha.Response.DriverLicence}DriverLicenceResult" minOccurs="0"/>
 *         &lt;element name="IdentityDocuments" type="{http://schemas.datacontract.org/2004/07/NeuromancerLibrary.XmlSerialization.IDCheckGlobalAlpha.Response.CreditReference}IdentityDocuments" minOccurs="0"/>
 *         &lt;element name="Organisation" type="{http://schemas.datacontract.org/2004/07/NeuromancerLibrary.XmlSerialization.IDCheckGlobalAlpha.Response.Directors}OrganisationDirectors" minOccurs="0"/>
 *         &lt;element name="Person" type="{http://schemas.datacontract.org/2004/07/NeuromancerLibrary.XmlSerialization.IDCheckGlobalAlpha.Response.CreditReference}PersonCreditReferenceRecord" minOccurs="0"/>
 *         &lt;element name="Sources" type="{http://schemas.datacontract.org/2004/07/NeuromancerLibrary.XmlSerialization.IDCheckGlobalAlpha.Response.CreditReference}SourcesCreditReference" minOccurs="0"/>
 *         &lt;element name="Telephones" type="{http://schemas.datacontract.org/2004/07/NeuromancerLibrary.XmlSerialization.IDCheckGlobalAlpha.Response.Telephony}TelephonesTelephony" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CreditReferenceRecord", propOrder = {
    "addresses",
    "comments",
    "driverLicence",
    "identityDocuments",
    "organisation",
    "person",
    "sources",
    "telephones"
})
public class CreditReferenceRecord {

    @XmlElementRef(name = "Addresses", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.XmlSerialization.IDCheckGlobalAlpha.Response.CreditReference", type = JAXBElement.class, required = false)
    protected JAXBElement<AddressesCreditReference> addresses;
    @XmlElementRef(name = "Comments", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.XmlSerialization.IDCheckGlobalAlpha.Response.CreditReference", type = JAXBElement.class, required = false)
    protected JAXBElement<CommentsCreditReference> comments;
    @XmlElementRef(name = "DriverLicence", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.XmlSerialization.IDCheckGlobalAlpha.Response.CreditReference", type = JAXBElement.class, required = false)
    protected JAXBElement<DriverLicenceResult> driverLicence;
    @XmlElementRef(name = "IdentityDocuments", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.XmlSerialization.IDCheckGlobalAlpha.Response.CreditReference", type = JAXBElement.class, required = false)
    protected JAXBElement<IdentityDocuments> identityDocuments;
    @XmlElementRef(name = "Organisation", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.XmlSerialization.IDCheckGlobalAlpha.Response.CreditReference", type = JAXBElement.class, required = false)
    protected JAXBElement<OrganisationDirectors> organisation;
    @XmlElementRef(name = "Person", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.XmlSerialization.IDCheckGlobalAlpha.Response.CreditReference", type = JAXBElement.class, required = false)
    protected JAXBElement<PersonCreditReferenceRecord> person;
    @XmlElementRef(name = "Sources", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.XmlSerialization.IDCheckGlobalAlpha.Response.CreditReference", type = JAXBElement.class, required = false)
    protected JAXBElement<SourcesCreditReference> sources;
    @XmlElementRef(name = "Telephones", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.XmlSerialization.IDCheckGlobalAlpha.Response.CreditReference", type = JAXBElement.class, required = false)
    protected JAXBElement<TelephonesTelephony> telephones;

    /**
     * Gets the value of the addresses property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link AddressesCreditReference }{@code >}
     *     
     */
    public JAXBElement<AddressesCreditReference> getAddresses() {
        return addresses;
    }

    /**
     * Sets the value of the addresses property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link AddressesCreditReference }{@code >}
     *     
     */
    public void setAddresses(JAXBElement<AddressesCreditReference> value) {
        this.addresses = value;
    }

    /**
     * Gets the value of the comments property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link CommentsCreditReference }{@code >}
     *     
     */
    public JAXBElement<CommentsCreditReference> getComments() {
        return comments;
    }

    /**
     * Sets the value of the comments property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link CommentsCreditReference }{@code >}
     *     
     */
    public void setComments(JAXBElement<CommentsCreditReference> value) {
        this.comments = value;
    }

    /**
     * Gets the value of the driverLicence property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link DriverLicenceResult }{@code >}
     *     
     */
    public JAXBElement<DriverLicenceResult> getDriverLicence() {
        return driverLicence;
    }

    /**
     * Sets the value of the driverLicence property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link DriverLicenceResult }{@code >}
     *     
     */
    public void setDriverLicence(JAXBElement<DriverLicenceResult> value) {
        this.driverLicence = value;
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
     * Gets the value of the organisation property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link OrganisationDirectors }{@code >}
     *     
     */
    public JAXBElement<OrganisationDirectors> getOrganisation() {
        return organisation;
    }

    /**
     * Sets the value of the organisation property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link OrganisationDirectors }{@code >}
     *     
     */
    public void setOrganisation(JAXBElement<OrganisationDirectors> value) {
        this.organisation = value;
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
     * Gets the value of the sources property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link SourcesCreditReference }{@code >}
     *     
     */
    public JAXBElement<SourcesCreditReference> getSources() {
        return sources;
    }

    /**
     * Sets the value of the sources property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link SourcesCreditReference }{@code >}
     *     
     */
    public void setSources(JAXBElement<SourcesCreditReference> value) {
        this.sources = value;
    }

    /**
     * Gets the value of the telephones property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link TelephonesTelephony }{@code >}
     *     
     */
    public JAXBElement<TelephonesTelephony> getTelephones() {
        return telephones;
    }

    /**
     * Sets the value of the telephones property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link TelephonesTelephony }{@code >}
     *     
     */
    public void setTelephones(JAXBElement<TelephonesTelephony> value) {
        this.telephones = value;
    }

}
