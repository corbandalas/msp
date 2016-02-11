
package org.datacontract.schemas._2004._07.neuromancerlibrary;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;
import org.datacontract.schemas._2004._07.neuromancerlibrary_datacontracts.DirectorUKDetailsResult;
import org.datacontract.schemas._2004._07.neuromancerlibrary_datacontracts.PEPDeskDetailsResult;
import org.datacontract.schemas._2004._07.neuromancerlibrary_datacontracts.SanctionsPlusDetailsResult;
import org.datacontract.schemas._2004._07.neuromancerlibrary_datacontracts.WatchlistDetailsResult;


/**
 * <p>Java class for ProfileDetailsResult complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ProfileDetailsResult">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="DirectorUKDetailsResult" type="{http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts.DirectorUKDetails}DirectorUKDetailsResult" minOccurs="0"/>
 *         &lt;element name="PEPDeskDetailsResult" type="{http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts.PEPDesk}PEPDeskDetailsResult" minOccurs="0"/>
 *         &lt;element name="SISPlusDetailsResult" type="{http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts.SanctionsPlus}SanctionsPlusDetailsResult" minOccurs="0"/>
 *         &lt;element name="SPFPlusDetailsResult" type="{http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts.SanctionsPlus}SanctionsPlusDetailsResult" minOccurs="0"/>
 *         &lt;element name="WatchlistDetailsResult" type="{http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts.Watchlist}WatchlistDetailsResult" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ProfileDetailsResult", propOrder = {
    "directorUKDetailsResult",
    "pepDeskDetailsResult",
    "sisPlusDetailsResult",
    "spfPlusDetailsResult",
    "watchlistDetailsResult"
})
public class ProfileDetailsResult {

    @XmlElementRef(name = "DirectorUKDetailsResult", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts", type = JAXBElement.class, required = false)
    protected JAXBElement<DirectorUKDetailsResult> directorUKDetailsResult;
    @XmlElementRef(name = "PEPDeskDetailsResult", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts", type = JAXBElement.class, required = false)
    protected JAXBElement<PEPDeskDetailsResult> pepDeskDetailsResult;
    @XmlElementRef(name = "SISPlusDetailsResult", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts", type = JAXBElement.class, required = false)
    protected JAXBElement<SanctionsPlusDetailsResult> sisPlusDetailsResult;
    @XmlElementRef(name = "SPFPlusDetailsResult", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts", type = JAXBElement.class, required = false)
    protected JAXBElement<SanctionsPlusDetailsResult> spfPlusDetailsResult;
    @XmlElementRef(name = "WatchlistDetailsResult", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts", type = JAXBElement.class, required = false)
    protected JAXBElement<WatchlistDetailsResult> watchlistDetailsResult;

    /**
     * Gets the value of the directorUKDetailsResult property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link DirectorUKDetailsResult }{@code >}
     *     
     */
    public JAXBElement<DirectorUKDetailsResult> getDirectorUKDetailsResult() {
        return directorUKDetailsResult;
    }

    /**
     * Sets the value of the directorUKDetailsResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link DirectorUKDetailsResult }{@code >}
     *     
     */
    public void setDirectorUKDetailsResult(JAXBElement<DirectorUKDetailsResult> value) {
        this.directorUKDetailsResult = value;
    }

    /**
     * Gets the value of the pepDeskDetailsResult property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link PEPDeskDetailsResult }{@code >}
     *     
     */
    public JAXBElement<PEPDeskDetailsResult> getPEPDeskDetailsResult() {
        return pepDeskDetailsResult;
    }

    /**
     * Sets the value of the pepDeskDetailsResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link PEPDeskDetailsResult }{@code >}
     *     
     */
    public void setPEPDeskDetailsResult(JAXBElement<PEPDeskDetailsResult> value) {
        this.pepDeskDetailsResult = value;
    }

    /**
     * Gets the value of the sisPlusDetailsResult property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link SanctionsPlusDetailsResult }{@code >}
     *     
     */
    public JAXBElement<SanctionsPlusDetailsResult> getSISPlusDetailsResult() {
        return sisPlusDetailsResult;
    }

    /**
     * Sets the value of the sisPlusDetailsResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link SanctionsPlusDetailsResult }{@code >}
     *     
     */
    public void setSISPlusDetailsResult(JAXBElement<SanctionsPlusDetailsResult> value) {
        this.sisPlusDetailsResult = value;
    }

    /**
     * Gets the value of the spfPlusDetailsResult property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link SanctionsPlusDetailsResult }{@code >}
     *     
     */
    public JAXBElement<SanctionsPlusDetailsResult> getSPFPlusDetailsResult() {
        return spfPlusDetailsResult;
    }

    /**
     * Sets the value of the spfPlusDetailsResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link SanctionsPlusDetailsResult }{@code >}
     *     
     */
    public void setSPFPlusDetailsResult(JAXBElement<SanctionsPlusDetailsResult> value) {
        this.spfPlusDetailsResult = value;
    }

    /**
     * Gets the value of the watchlistDetailsResult property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link WatchlistDetailsResult }{@code >}
     *     
     */
    public JAXBElement<WatchlistDetailsResult> getWatchlistDetailsResult() {
        return watchlistDetailsResult;
    }

    /**
     * Sets the value of the watchlistDetailsResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link WatchlistDetailsResult }{@code >}
     *     
     */
    public void setWatchlistDetailsResult(JAXBElement<WatchlistDetailsResult> value) {
        this.watchlistDetailsResult = value;
    }

}
