
package org.datacontract.schemas._2004._07.neuromancerlibrary_datacontracts;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import org.datacontract.schemas._2004._07.databaselibrary.MatchTypeEnum;
import org.datacontract.schemas._2004._07.databaselibrary.WatchlistActionStatusEnum;
import org.datacontract.schemas._2004._07.databaselibrary.WatchlistActiveStatusEnum;


/**
 * <p>Java class for WatchlistEntityDetailsMatch complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="WatchlistEntityDetailsMatch">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Action" type="{http://schemas.datacontract.org/2004/07/DatabaseLibrary.Enums}WatchlistActionStatusEnum" minOccurs="0"/>
 *         &lt;element name="ActionDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ActiveStatus" type="{http://schemas.datacontract.org/2004/07/DatabaseLibrary.Enums}WatchlistActiveStatusEnum" minOccurs="0"/>
 *         &lt;element name="Addresses" type="{http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts.Watchlist}ArrayOfWatchlistAddressData" minOccurs="0"/>
 *         &lt;element name="Aliases" type="{http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts.Watchlist}ArrayOfWatchlistEntityAliasData" minOccurs="0"/>
 *         &lt;element name="Associations" type="{http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts.Watchlist}ArrayOfWatchlistAssociateData" minOccurs="0"/>
 *         &lt;element name="Classifications" type="{http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts.Watchlist}ArrayOfWatchlistClassificationData" minOccurs="0"/>
 *         &lt;element name="Countries" type="{http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts.Watchlist}ArrayOfWatchlistCountryData" minOccurs="0"/>
 *         &lt;element name="DateEvents" type="{http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts.Watchlist}ArrayOfWatchlistDateEventData" minOccurs="0"/>
 *         &lt;element name="Identifiers" type="{http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts.Watchlist}ArrayOfWatchlistIdentifierData" minOccurs="0"/>
 *         &lt;element name="MatchType" type="{http://schemas.datacontract.org/2004/07/DatabaseLibrary.Enums}MatchTypeEnum" minOccurs="0"/>
 *         &lt;element name="PrimaryAlias" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ProfileId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ProfileNotes" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Sanctions" type="{http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts.Watchlist}ArrayOfWatchlistSanctionData" minOccurs="0"/>
 *         &lt;element name="Sources" type="{http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts.Watchlist}ArrayOfWatchlistSourceData" minOccurs="0"/>
 *         &lt;element name="Vessels" type="{http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts.Watchlist}ArrayOfWatchlistVesselData" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "WatchlistEntityDetailsMatch", propOrder = {
    "action",
    "actionDate",
    "activeStatus",
    "addresses",
    "aliases",
    "associations",
    "classifications",
    "countries",
    "dateEvents",
    "identifiers",
    "matchType",
    "primaryAlias",
    "profileId",
    "profileNotes",
    "sanctions",
    "sources",
    "vessels"
})
public class WatchlistEntityDetailsMatch {

    @XmlElement(name = "Action")
    @XmlSchemaType(name = "string")
    protected WatchlistActionStatusEnum action;
    @XmlElementRef(name = "ActionDate", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts.Watchlist", type = JAXBElement.class, required = false)
    protected JAXBElement<String> actionDate;
    @XmlElement(name = "ActiveStatus")
    @XmlSchemaType(name = "string")
    protected WatchlistActiveStatusEnum activeStatus;
    @XmlElementRef(name = "Addresses", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts.Watchlist", type = JAXBElement.class, required = false)
    protected JAXBElement<ArrayOfWatchlistAddressData> addresses;
    @XmlElementRef(name = "Aliases", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts.Watchlist", type = JAXBElement.class, required = false)
    protected JAXBElement<ArrayOfWatchlistEntityAliasData> aliases;
    @XmlElementRef(name = "Associations", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts.Watchlist", type = JAXBElement.class, required = false)
    protected JAXBElement<ArrayOfWatchlistAssociateData> associations;
    @XmlElementRef(name = "Classifications", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts.Watchlist", type = JAXBElement.class, required = false)
    protected JAXBElement<ArrayOfWatchlistClassificationData> classifications;
    @XmlElementRef(name = "Countries", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts.Watchlist", type = JAXBElement.class, required = false)
    protected JAXBElement<ArrayOfWatchlistCountryData> countries;
    @XmlElementRef(name = "DateEvents", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts.Watchlist", type = JAXBElement.class, required = false)
    protected JAXBElement<ArrayOfWatchlistDateEventData> dateEvents;
    @XmlElementRef(name = "Identifiers", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts.Watchlist", type = JAXBElement.class, required = false)
    protected JAXBElement<ArrayOfWatchlistIdentifierData> identifiers;
    @XmlElement(name = "MatchType")
    @XmlSchemaType(name = "string")
    protected MatchTypeEnum matchType;
    @XmlElementRef(name = "PrimaryAlias", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts.Watchlist", type = JAXBElement.class, required = false)
    protected JAXBElement<String> primaryAlias;
    @XmlElementRef(name = "ProfileId", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts.Watchlist", type = JAXBElement.class, required = false)
    protected JAXBElement<String> profileId;
    @XmlElementRef(name = "ProfileNotes", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts.Watchlist", type = JAXBElement.class, required = false)
    protected JAXBElement<String> profileNotes;
    @XmlElementRef(name = "Sanctions", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts.Watchlist", type = JAXBElement.class, required = false)
    protected JAXBElement<ArrayOfWatchlistSanctionData> sanctions;
    @XmlElementRef(name = "Sources", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts.Watchlist", type = JAXBElement.class, required = false)
    protected JAXBElement<ArrayOfWatchlistSourceData> sources;
    @XmlElementRef(name = "Vessels", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts.Watchlist", type = JAXBElement.class, required = false)
    protected JAXBElement<ArrayOfWatchlistVesselData> vessels;

    /**
     * Gets the value of the action property.
     * 
     * @return
     *     possible object is
     *     {@link WatchlistActionStatusEnum }
     *     
     */
    public WatchlistActionStatusEnum getAction() {
        return action;
    }

    /**
     * Sets the value of the action property.
     * 
     * @param value
     *     allowed object is
     *     {@link WatchlistActionStatusEnum }
     *     
     */
    public void setAction(WatchlistActionStatusEnum value) {
        this.action = value;
    }

    /**
     * Gets the value of the actionDate property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getActionDate() {
        return actionDate;
    }

    /**
     * Sets the value of the actionDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setActionDate(JAXBElement<String> value) {
        this.actionDate = value;
    }

    /**
     * Gets the value of the activeStatus property.
     * 
     * @return
     *     possible object is
     *     {@link WatchlistActiveStatusEnum }
     *     
     */
    public WatchlistActiveStatusEnum getActiveStatus() {
        return activeStatus;
    }

    /**
     * Sets the value of the activeStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link WatchlistActiveStatusEnum }
     *     
     */
    public void setActiveStatus(WatchlistActiveStatusEnum value) {
        this.activeStatus = value;
    }

    /**
     * Gets the value of the addresses property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfWatchlistAddressData }{@code >}
     *     
     */
    public JAXBElement<ArrayOfWatchlistAddressData> getAddresses() {
        return addresses;
    }

    /**
     * Sets the value of the addresses property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfWatchlistAddressData }{@code >}
     *     
     */
    public void setAddresses(JAXBElement<ArrayOfWatchlistAddressData> value) {
        this.addresses = value;
    }

    /**
     * Gets the value of the aliases property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfWatchlistEntityAliasData }{@code >}
     *     
     */
    public JAXBElement<ArrayOfWatchlistEntityAliasData> getAliases() {
        return aliases;
    }

    /**
     * Sets the value of the aliases property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfWatchlistEntityAliasData }{@code >}
     *     
     */
    public void setAliases(JAXBElement<ArrayOfWatchlistEntityAliasData> value) {
        this.aliases = value;
    }

    /**
     * Gets the value of the associations property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfWatchlistAssociateData }{@code >}
     *     
     */
    public JAXBElement<ArrayOfWatchlistAssociateData> getAssociations() {
        return associations;
    }

    /**
     * Sets the value of the associations property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfWatchlistAssociateData }{@code >}
     *     
     */
    public void setAssociations(JAXBElement<ArrayOfWatchlistAssociateData> value) {
        this.associations = value;
    }

    /**
     * Gets the value of the classifications property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfWatchlistClassificationData }{@code >}
     *     
     */
    public JAXBElement<ArrayOfWatchlistClassificationData> getClassifications() {
        return classifications;
    }

    /**
     * Sets the value of the classifications property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfWatchlistClassificationData }{@code >}
     *     
     */
    public void setClassifications(JAXBElement<ArrayOfWatchlistClassificationData> value) {
        this.classifications = value;
    }

    /**
     * Gets the value of the countries property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfWatchlistCountryData }{@code >}
     *     
     */
    public JAXBElement<ArrayOfWatchlistCountryData> getCountries() {
        return countries;
    }

    /**
     * Sets the value of the countries property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfWatchlistCountryData }{@code >}
     *     
     */
    public void setCountries(JAXBElement<ArrayOfWatchlistCountryData> value) {
        this.countries = value;
    }

    /**
     * Gets the value of the dateEvents property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfWatchlistDateEventData }{@code >}
     *     
     */
    public JAXBElement<ArrayOfWatchlistDateEventData> getDateEvents() {
        return dateEvents;
    }

    /**
     * Sets the value of the dateEvents property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfWatchlistDateEventData }{@code >}
     *     
     */
    public void setDateEvents(JAXBElement<ArrayOfWatchlistDateEventData> value) {
        this.dateEvents = value;
    }

    /**
     * Gets the value of the identifiers property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfWatchlistIdentifierData }{@code >}
     *     
     */
    public JAXBElement<ArrayOfWatchlistIdentifierData> getIdentifiers() {
        return identifiers;
    }

    /**
     * Sets the value of the identifiers property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfWatchlistIdentifierData }{@code >}
     *     
     */
    public void setIdentifiers(JAXBElement<ArrayOfWatchlistIdentifierData> value) {
        this.identifiers = value;
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
     * Gets the value of the primaryAlias property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getPrimaryAlias() {
        return primaryAlias;
    }

    /**
     * Sets the value of the primaryAlias property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setPrimaryAlias(JAXBElement<String> value) {
        this.primaryAlias = value;
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

    /**
     * Gets the value of the profileNotes property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getProfileNotes() {
        return profileNotes;
    }

    /**
     * Sets the value of the profileNotes property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setProfileNotes(JAXBElement<String> value) {
        this.profileNotes = value;
    }

    /**
     * Gets the value of the sanctions property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfWatchlistSanctionData }{@code >}
     *     
     */
    public JAXBElement<ArrayOfWatchlistSanctionData> getSanctions() {
        return sanctions;
    }

    /**
     * Sets the value of the sanctions property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfWatchlistSanctionData }{@code >}
     *     
     */
    public void setSanctions(JAXBElement<ArrayOfWatchlistSanctionData> value) {
        this.sanctions = value;
    }

    /**
     * Gets the value of the sources property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfWatchlistSourceData }{@code >}
     *     
     */
    public JAXBElement<ArrayOfWatchlistSourceData> getSources() {
        return sources;
    }

    /**
     * Sets the value of the sources property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfWatchlistSourceData }{@code >}
     *     
     */
    public void setSources(JAXBElement<ArrayOfWatchlistSourceData> value) {
        this.sources = value;
    }

    /**
     * Gets the value of the vessels property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfWatchlistVesselData }{@code >}
     *     
     */
    public JAXBElement<ArrayOfWatchlistVesselData> getVessels() {
        return vessels;
    }

    /**
     * Sets the value of the vessels property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfWatchlistVesselData }{@code >}
     *     
     */
    public void setVessels(JAXBElement<ArrayOfWatchlistVesselData> value) {
        this.vessels = value;
    }

}
