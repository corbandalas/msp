
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
 * <p>Java class for WatchlistEntityAliasData complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="WatchlistEntityAliasData">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="AliasType" type="{http://schemas.datacontract.org/2004/07/DatabaseLibrary.Enums}WatchlistAliasTypeEnum" minOccurs="0"/>
 *         &lt;element name="Name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="OriginalScriptName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SingleStringName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "WatchlistEntityAliasData", propOrder = {
    "aliasType",
    "name",
    "originalScriptName",
    "singleStringName"
})
public class WatchlistEntityAliasData {

    @XmlElement(name = "AliasType")
    @XmlSchemaType(name = "string")
    protected WatchlistAliasTypeEnum aliasType;
    @XmlElementRef(name = "Name", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts.Watchlist", type = JAXBElement.class, required = false)
    protected JAXBElement<String> name;
    @XmlElementRef(name = "OriginalScriptName", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts.Watchlist", type = JAXBElement.class, required = false)
    protected JAXBElement<String> originalScriptName;
    @XmlElementRef(name = "SingleStringName", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts.Watchlist", type = JAXBElement.class, required = false)
    protected JAXBElement<String> singleStringName;

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

}
