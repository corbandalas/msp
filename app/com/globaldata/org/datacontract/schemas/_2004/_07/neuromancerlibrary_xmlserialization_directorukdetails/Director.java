
package org.datacontract.schemas._2004._07.neuromancerlibrary_xmlserialization_directorukdetails;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Director complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Director">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Address1" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Address2" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Address3" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Address4" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Address5" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="BirthDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="DirectorNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Directorships" type="{http://schemas.datacontract.org/2004/07/NeuromancerLibrary.XmlSerialization.DirectorUKDetails.Response}Directorships" minOccurs="0"/>
 *         &lt;element name="Honours" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Nationality" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Postcode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Title" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Director", propOrder = {
    "address1",
    "address2",
    "address3",
    "address4",
    "address5",
    "birthDate",
    "directorNumber",
    "directorships",
    "honours",
    "name",
    "nationality",
    "postcode",
    "title"
})
public class Director {

    @XmlElementRef(name = "Address1", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.XmlSerialization.DirectorUKDetails.Response", type = JAXBElement.class, required = false)
    protected JAXBElement<String> address1;
    @XmlElementRef(name = "Address2", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.XmlSerialization.DirectorUKDetails.Response", type = JAXBElement.class, required = false)
    protected JAXBElement<String> address2;
    @XmlElementRef(name = "Address3", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.XmlSerialization.DirectorUKDetails.Response", type = JAXBElement.class, required = false)
    protected JAXBElement<String> address3;
    @XmlElementRef(name = "Address4", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.XmlSerialization.DirectorUKDetails.Response", type = JAXBElement.class, required = false)
    protected JAXBElement<String> address4;
    @XmlElementRef(name = "Address5", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.XmlSerialization.DirectorUKDetails.Response", type = JAXBElement.class, required = false)
    protected JAXBElement<String> address5;
    @XmlElementRef(name = "BirthDate", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.XmlSerialization.DirectorUKDetails.Response", type = JAXBElement.class, required = false)
    protected JAXBElement<String> birthDate;
    @XmlElementRef(name = "DirectorNumber", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.XmlSerialization.DirectorUKDetails.Response", type = JAXBElement.class, required = false)
    protected JAXBElement<String> directorNumber;
    @XmlElementRef(name = "Directorships", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.XmlSerialization.DirectorUKDetails.Response", type = JAXBElement.class, required = false)
    protected JAXBElement<Directorships> directorships;
    @XmlElementRef(name = "Honours", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.XmlSerialization.DirectorUKDetails.Response", type = JAXBElement.class, required = false)
    protected JAXBElement<String> honours;
    @XmlElementRef(name = "Name", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.XmlSerialization.DirectorUKDetails.Response", type = JAXBElement.class, required = false)
    protected JAXBElement<String> name;
    @XmlElementRef(name = "Nationality", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.XmlSerialization.DirectorUKDetails.Response", type = JAXBElement.class, required = false)
    protected JAXBElement<String> nationality;
    @XmlElementRef(name = "Postcode", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.XmlSerialization.DirectorUKDetails.Response", type = JAXBElement.class, required = false)
    protected JAXBElement<String> postcode;
    @XmlElementRef(name = "Title", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.XmlSerialization.DirectorUKDetails.Response", type = JAXBElement.class, required = false)
    protected JAXBElement<String> title;

    /**
     * Gets the value of the address1 property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getAddress1() {
        return address1;
    }

    /**
     * Sets the value of the address1 property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setAddress1(JAXBElement<String> value) {
        this.address1 = value;
    }

    /**
     * Gets the value of the address2 property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getAddress2() {
        return address2;
    }

    /**
     * Sets the value of the address2 property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setAddress2(JAXBElement<String> value) {
        this.address2 = value;
    }

    /**
     * Gets the value of the address3 property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getAddress3() {
        return address3;
    }

    /**
     * Sets the value of the address3 property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setAddress3(JAXBElement<String> value) {
        this.address3 = value;
    }

    /**
     * Gets the value of the address4 property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getAddress4() {
        return address4;
    }

    /**
     * Sets the value of the address4 property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setAddress4(JAXBElement<String> value) {
        this.address4 = value;
    }

    /**
     * Gets the value of the address5 property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getAddress5() {
        return address5;
    }

    /**
     * Sets the value of the address5 property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setAddress5(JAXBElement<String> value) {
        this.address5 = value;
    }

    /**
     * Gets the value of the birthDate property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getBirthDate() {
        return birthDate;
    }

    /**
     * Sets the value of the birthDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setBirthDate(JAXBElement<String> value) {
        this.birthDate = value;
    }

    /**
     * Gets the value of the directorNumber property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getDirectorNumber() {
        return directorNumber;
    }

    /**
     * Sets the value of the directorNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setDirectorNumber(JAXBElement<String> value) {
        this.directorNumber = value;
    }

    /**
     * Gets the value of the directorships property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Directorships }{@code >}
     *     
     */
    public JAXBElement<Directorships> getDirectorships() {
        return directorships;
    }

    /**
     * Sets the value of the directorships property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Directorships }{@code >}
     *     
     */
    public void setDirectorships(JAXBElement<Directorships> value) {
        this.directorships = value;
    }

    /**
     * Gets the value of the honours property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getHonours() {
        return honours;
    }

    /**
     * Sets the value of the honours property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setHonours(JAXBElement<String> value) {
        this.honours = value;
    }

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setName(JAXBElement<String> value) {
        this.name = value;
    }

    /**
     * Gets the value of the nationality property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getNationality() {
        return nationality;
    }

    /**
     * Sets the value of the nationality property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setNationality(JAXBElement<String> value) {
        this.nationality = value;
    }

    /**
     * Gets the value of the postcode property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getPostcode() {
        return postcode;
    }

    /**
     * Sets the value of the postcode property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setPostcode(JAXBElement<String> value) {
        this.postcode = value;
    }

    /**
     * Gets the value of the title property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getTitle() {
        return title;
    }

    /**
     * Sets the value of the title property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setTitle(JAXBElement<String> value) {
        this.title = value;
    }

}
