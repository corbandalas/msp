
package org.datacontract.schemas._2004._07.neuromancerlibrary;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import org.datacontract.schemas._2004._07.databaselibrary.MatchTypeEnum;


/**
 * <p>Java class for CheckMatch complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CheckMatch">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="BirthDay" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="BirthMonth" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="BirthYear" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="DateOfBirthMatchScore" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="MatchType" type="{http://schemas.datacontract.org/2004/07/DatabaseLibrary.Enums}MatchTypeEnum" minOccurs="0"/>
 *         &lt;element name="Name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="NameMatchScore" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="ProfileId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CheckMatch", propOrder = {
    "birthDay",
    "birthMonth",
    "birthYear",
    "dateOfBirthMatchScore",
    "matchType",
    "name",
    "nameMatchScore",
    "profileId"
})
public class CheckMatch {

    @XmlElementRef(name = "BirthDay", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts", type = JAXBElement.class, required = false)
    protected JAXBElement<Integer> birthDay;
    @XmlElementRef(name = "BirthMonth", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts", type = JAXBElement.class, required = false)
    protected JAXBElement<Integer> birthMonth;
    @XmlElementRef(name = "BirthYear", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts", type = JAXBElement.class, required = false)
    protected JAXBElement<Integer> birthYear;
    @XmlElementRef(name = "DateOfBirthMatchScore", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts", type = JAXBElement.class, required = false)
    protected JAXBElement<Integer> dateOfBirthMatchScore;
    @XmlElement(name = "MatchType")
    @XmlSchemaType(name = "string")
    protected MatchTypeEnum matchType;
    @XmlElementRef(name = "Name", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts", type = JAXBElement.class, required = false)
    protected JAXBElement<String> name;
    @XmlElement(name = "NameMatchScore")
    protected Integer nameMatchScore;
    @XmlElementRef(name = "ProfileId", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts", type = JAXBElement.class, required = false)
    protected JAXBElement<String> profileId;

    /**
     * Gets the value of the birthDay property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Integer }{@code >}
     *     
     */
    public JAXBElement<Integer> getBirthDay() {
        return birthDay;
    }

    /**
     * Sets the value of the birthDay property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Integer }{@code >}
     *     
     */
    public void setBirthDay(JAXBElement<Integer> value) {
        this.birthDay = value;
    }

    /**
     * Gets the value of the birthMonth property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Integer }{@code >}
     *     
     */
    public JAXBElement<Integer> getBirthMonth() {
        return birthMonth;
    }

    /**
     * Sets the value of the birthMonth property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Integer }{@code >}
     *     
     */
    public void setBirthMonth(JAXBElement<Integer> value) {
        this.birthMonth = value;
    }

    /**
     * Gets the value of the birthYear property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Integer }{@code >}
     *     
     */
    public JAXBElement<Integer> getBirthYear() {
        return birthYear;
    }

    /**
     * Sets the value of the birthYear property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Integer }{@code >}
     *     
     */
    public void setBirthYear(JAXBElement<Integer> value) {
        this.birthYear = value;
    }

    /**
     * Gets the value of the dateOfBirthMatchScore property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Integer }{@code >}
     *     
     */
    public JAXBElement<Integer> getDateOfBirthMatchScore() {
        return dateOfBirthMatchScore;
    }

    /**
     * Sets the value of the dateOfBirthMatchScore property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Integer }{@code >}
     *     
     */
    public void setDateOfBirthMatchScore(JAXBElement<Integer> value) {
        this.dateOfBirthMatchScore = value;
    }

    /**
     * Gets the value of the matchType property.
     * 
     * @return
     *     possible object is
     *     {@link MatchTypeEnum }
     *     
     */
    public MatchTypeEnum getMatchType() {
        return matchType;
    }

    /**
     * Sets the value of the matchType property.
     * 
     * @param value
     *     allowed object is
     *     {@link MatchTypeEnum }
     *     
     */
    public void setMatchType(MatchTypeEnum value) {
        this.matchType = value;
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
     * Gets the value of the nameMatchScore property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getNameMatchScore() {
        return nameMatchScore;
    }

    /**
     * Sets the value of the nameMatchScore property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setNameMatchScore(Integer value) {
        this.nameMatchScore = value;
    }

    /**
     * Gets the value of the profileId property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getProfileId() {
        return profileId;
    }

    /**
     * Sets the value of the profileId property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setProfileId(JAXBElement<String> value) {
        this.profileId = value;
    }

}
