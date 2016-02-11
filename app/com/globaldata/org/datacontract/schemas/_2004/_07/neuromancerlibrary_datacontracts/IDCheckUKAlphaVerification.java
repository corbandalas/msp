
package org.datacontract.schemas._2004._07.neuromancerlibrary_datacontracts;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for IDCheckUKAlphaVerification complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="IDCheckUKAlphaVerification">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="COAMatch" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="DateOfBirthMatch" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="DeceasedMatch" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="ElectoralRollDobMatch" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="ElectoralRollMatch" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="LendersOfActiveCAISAccountsCount" type="{http://www.w3.org/2001/XMLSchema}unsignedShort" minOccurs="0"/>
 *         &lt;element name="NumberCCJ" type="{http://www.w3.org/2001/XMLSchema}unsignedShort" minOccurs="0"/>
 *         &lt;element name="TelephoneDirectoryMatch" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="TelephoneNumberMatch" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "IDCheckUKAlphaVerification", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts.IDCheckUKAlpha", propOrder = {
    "coaMatch",
    "dateOfBirthMatch",
    "deceasedMatch",
    "electoralRollDobMatch",
    "electoralRollMatch",
    "lendersOfActiveCAISAccountsCount",
    "numberCCJ",
    "telephoneDirectoryMatch",
    "telephoneNumberMatch"
})
public class IDCheckUKAlphaVerification {

    @XmlElement(name = "COAMatch")
    protected Boolean coaMatch;
    @XmlElementRef(name = "DateOfBirthMatch", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts.IDCheckUKAlpha", type = JAXBElement.class, required = false)
    protected JAXBElement<Boolean> dateOfBirthMatch;
    @XmlElement(name = "DeceasedMatch")
    protected Boolean deceasedMatch;
    @XmlElementRef(name = "ElectoralRollDobMatch", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts.IDCheckUKAlpha", type = JAXBElement.class, required = false)
    protected JAXBElement<Boolean> electoralRollDobMatch;
    @XmlElement(name = "ElectoralRollMatch")
    protected Boolean electoralRollMatch;
    @XmlElement(name = "LendersOfActiveCAISAccountsCount")
    @XmlSchemaType(name = "unsignedShort")
    protected Integer lendersOfActiveCAISAccountsCount;
    @XmlElement(name = "NumberCCJ")
    @XmlSchemaType(name = "unsignedShort")
    protected Integer numberCCJ;
    @XmlElementRef(name = "TelephoneDirectoryMatch", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts.IDCheckUKAlpha", type = JAXBElement.class, required = false)
    protected JAXBElement<Boolean> telephoneDirectoryMatch;
    @XmlElementRef(name = "TelephoneNumberMatch", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts.IDCheckUKAlpha", type = JAXBElement.class, required = false)
    protected JAXBElement<Boolean> telephoneNumberMatch;

    /**
     * Gets the value of the coaMatch property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isCOAMatch() {
        return coaMatch;
    }

    /**
     * Sets the value of the coaMatch property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setCOAMatch(Boolean value) {
        this.coaMatch = value;
    }

    /**
     * Gets the value of the dateOfBirthMatch property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     *     
     */
    public JAXBElement<Boolean> getDateOfBirthMatch() {
        return dateOfBirthMatch;
    }

    /**
     * Sets the value of the dateOfBirthMatch property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     *     
     */
    public void setDateOfBirthMatch(JAXBElement<Boolean> value) {
        this.dateOfBirthMatch = value;
    }

    /**
     * Gets the value of the deceasedMatch property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isDeceasedMatch() {
        return deceasedMatch;
    }

    /**
     * Sets the value of the deceasedMatch property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setDeceasedMatch(Boolean value) {
        this.deceasedMatch = value;
    }

    /**
     * Gets the value of the electoralRollDobMatch property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     *     
     */
    public JAXBElement<Boolean> getElectoralRollDobMatch() {
        return electoralRollDobMatch;
    }

    /**
     * Sets the value of the electoralRollDobMatch property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     *     
     */
    public void setElectoralRollDobMatch(JAXBElement<Boolean> value) {
        this.electoralRollDobMatch = value;
    }

    /**
     * Gets the value of the electoralRollMatch property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isElectoralRollMatch() {
        return electoralRollMatch;
    }

    /**
     * Sets the value of the electoralRollMatch property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setElectoralRollMatch(Boolean value) {
        this.electoralRollMatch = value;
    }

    /**
     * Gets the value of the lendersOfActiveCAISAccountsCount property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getLendersOfActiveCAISAccountsCount() {
        return lendersOfActiveCAISAccountsCount;
    }

    /**
     * Sets the value of the lendersOfActiveCAISAccountsCount property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setLendersOfActiveCAISAccountsCount(Integer value) {
        this.lendersOfActiveCAISAccountsCount = value;
    }

    /**
     * Gets the value of the numberCCJ property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getNumberCCJ() {
        return numberCCJ;
    }

    /**
     * Sets the value of the numberCCJ property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setNumberCCJ(Integer value) {
        this.numberCCJ = value;
    }

    /**
     * Gets the value of the telephoneDirectoryMatch property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     *     
     */
    public JAXBElement<Boolean> getTelephoneDirectoryMatch() {
        return telephoneDirectoryMatch;
    }

    /**
     * Sets the value of the telephoneDirectoryMatch property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     *     
     */
    public void setTelephoneDirectoryMatch(JAXBElement<Boolean> value) {
        this.telephoneDirectoryMatch = value;
    }

    /**
     * Gets the value of the telephoneNumberMatch property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     *     
     */
    public JAXBElement<Boolean> getTelephoneNumberMatch() {
        return telephoneNumberMatch;
    }

    /**
     * Sets the value of the telephoneNumberMatch property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     *     
     */
    public void setTelephoneNumberMatch(JAXBElement<Boolean> value) {
        this.telephoneNumberMatch = value;
    }

}
