
package org.datacontract.schemas._2004._07.neuromancerlibrary_datacontracts;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for WatchlistDetailsResult complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="WatchlistDetailsResult">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="EntityProfileMatchDetails" type="{http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts.Watchlist}WatchlistEntityDetailsMatch" minOccurs="0"/>
 *         &lt;element name="PersonProfileMatchDetails" type="{http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts.Watchlist}WatchlistPersonDetailsMatch" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "WatchlistDetailsResult", propOrder = {
    "entityProfileMatchDetails",
    "personProfileMatchDetails"
})
public class WatchlistDetailsResult {

    @XmlElementRef(name = "EntityProfileMatchDetails", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts.Watchlist", type = JAXBElement.class, required = false)
    protected JAXBElement<WatchlistEntityDetailsMatch> entityProfileMatchDetails;
    @XmlElementRef(name = "PersonProfileMatchDetails", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts.Watchlist", type = JAXBElement.class, required = false)
    protected JAXBElement<WatchlistPersonDetailsMatch> personProfileMatchDetails;

    /**
     * Gets the value of the entityProfileMatchDetails property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link WatchlistEntityDetailsMatch }{@code >}
     *     
     */
    public JAXBElement<WatchlistEntityDetailsMatch> getEntityProfileMatchDetails() {
        return entityProfileMatchDetails;
    }

    /**
     * Sets the value of the entityProfileMatchDetails property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link WatchlistEntityDetailsMatch }{@code >}
     *     
     */
    public void setEntityProfileMatchDetails(JAXBElement<WatchlistEntityDetailsMatch> value) {
        this.entityProfileMatchDetails = value;
    }

    /**
     * Gets the value of the personProfileMatchDetails property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link WatchlistPersonDetailsMatch }{@code >}
     *     
     */
    public JAXBElement<WatchlistPersonDetailsMatch> getPersonProfileMatchDetails() {
        return personProfileMatchDetails;
    }

    /**
     * Sets the value of the personProfileMatchDetails property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link WatchlistPersonDetailsMatch }{@code >}
     *     
     */
    public void setPersonProfileMatchDetails(JAXBElement<WatchlistPersonDetailsMatch> value) {
        this.personProfileMatchDetails = value;
    }

}
