
package org.datacontract.schemas._2004._07.neuromancerlibrary_datacontracts;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import org.datacontract.schemas._2004._07.databaselibrary.WatchlistAliasTypeEnum;


/**
 * <p>Java class for WatchlistPersonAliasData complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="WatchlistPersonAliasData">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="AliasType" type="{http://schemas.datacontract.org/2004/07/DatabaseLibrary.Enums}WatchlistAliasTypeEnum" minOccurs="0"/>
 *         &lt;element name="CombinedName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="FirstName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="MaidenName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="MiddleName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="OriginalScriptName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SingleStringName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Suffix" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Surname" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="TitleHonorific" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "WatchlistPersonAliasData", propOrder = {
    "aliasType",
    "combinedName",
    "firstName",
    "maidenName",
    "middleName",
    "originalScriptName",
    "singleStringName",
    "suffix",
    "surname",
    "titleHonorific"
})
public class WatchlistPersonAliasData {

    @XmlElement(name = "AliasType")
    @XmlSchemaType(name = "string")
    protected WatchlistAliasTypeEnum aliasType;
    @XmlElementRef(name = "CombinedName", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts.Watchlist", type = JAXBElement.class, required = false)
    protected JAXBElement<String> combinedName;
    @XmlElementRef(name = "FirstName", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts.Watchlist", type = JAXBElement.class, required = false)
    protected JAXBElement<String> firstName;
    @XmlElementRef(name = "MaidenName", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts.Watchlist", type = JAXBElement.class, required = false)
    protected JAXBElement<String> maidenName;
    @XmlElementRef(name = "MiddleName", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts.Watchlist", type = JAXBElement.class, required = false)
    protected JAXBElement<String> middleName;
    @XmlElementRef(name = "OriginalScriptName", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts.Watchlist", type = JAXBElement.class, required = false)
    protected JAXBElement<String> originalScriptName;
    @XmlElementRef(name = "SingleStringName", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts.Watchlist", type = JAXBElement.class, required = false)
    protected JAXBElement<String> singleStringName;
    @XmlElementRef(name = "Suffix", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts.Watchlist", type = JAXBElement.class, required = false)
    protected JAXBElement<String> suffix;
    @XmlElementRef(name = "Surname", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts.Watchlist", type = JAXBElement.class, required = false)
    protected JAXBElement<String> surname;
    @XmlElementRef(name = "TitleHonorific", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts.Watchlist", type = JAXBElement.class, required = false)
    protected JAXBElement<String> titleHonorific;

    /**
     * Gets the value of the aliasType property.
     * 
     * @return
     *     possible object is
     *     {@link WatchlistAliasTypeEnum }
     *     
     */
    public WatchlistAliasTypeEnum getAliasType() {
        return aliasType;
    }

    /**
     * Sets the value of the aliasType property.
     * 
     * @param value
     *     allowed object is
     *     {@link WatchlistAliasTypeEnum }
     *     
     */
    public void setAliasType(WatchlistAliasTypeEnum value) {
        this.aliasType = value;
    }

    /**
     * Gets the value of the combinedName property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getCombinedName() {
        return combinedName;
    }

    /**
     * Sets the value of the combinedName property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setCombinedName(JAXBElement<String> value) {
        this.combinedName = value;
    }

    /**
     * Gets the value of the firstName property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getFirstName() {
        return firstName;
    }

    /**
     * Sets the value of the firstName property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setFirstName(JAXBElement<String> value) {
        this.firstName = value;
    }

    /**
     * Gets the value of the maidenName property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getMaidenName() {
        return maidenName;
    }

    /**
     * Sets the value of the maidenName property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setMaidenName(JAXBElement<String> value) {
        this.maidenName = value;
    }

    /**
     * Gets the value of the middleName property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getMiddleName() {
        return middleName;
    }

    /**
     * Sets the value of the middleName property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setMiddleName(JAXBElement<String> value) {
        this.middleName = value;
    }

    /**
     * Gets the value of the originalScriptName property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getOriginalScriptName() {
        return originalScriptName;
    }

    /**
     * Sets the value of the originalScriptName property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setOriginalScriptName(JAXBElement<String> value) {
        this.originalScriptName = value;
    }

    /**
     * Gets the value of the singleStringName property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getSingleStringName() {
        return singleStringName;
    }

    /**
     * Sets the value of the singleStringName property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setSingleStringName(JAXBElement<String> value) {
        this.singleStringName = value;
    }

    /**
     * Gets the value of the suffix property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getSuffix() {
        return suffix;
    }

    /**
     * Sets the value of the suffix property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setSuffix(JAXBElement<String> value) {
        this.suffix = value;
    }

    /**
     * Gets the value of the surname property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getSurname() {
        return surname;
    }

    /**
     * Sets the value of the surname property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setSurname(JAXBElement<String> value) {
        this.surname = value;
    }

    /**
     * Gets the value of the titleHonorific property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getTitleHonorific() {
        return titleHonorific;
    }

    /**
     * Sets the value of the titleHonorific property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setTitleHonorific(JAXBElement<String> value) {
        this.titleHonorific = value;
    }

}
