
package org.datacontract.schemas._2004._07.neuromancerlibrary_datacontracts;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for WatchlistVesselData complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="WatchlistVesselData">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="VesselCallSign" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="VesselFlag" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="VesselGRT" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="VesselOwner" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="VesselTonnage" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="VesselType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "WatchlistVesselData", propOrder = {
    "vesselCallSign",
    "vesselFlag",
    "vesselGRT",
    "vesselOwner",
    "vesselTonnage",
    "vesselType"
})
public class WatchlistVesselData {

    @XmlElementRef(name = "VesselCallSign", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts.Watchlist", type = JAXBElement.class, required = false)
    protected JAXBElement<String> vesselCallSign;
    @XmlElementRef(name = "VesselFlag", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts.Watchlist", type = JAXBElement.class, required = false)
    protected JAXBElement<String> vesselFlag;
    @XmlElementRef(name = "VesselGRT", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts.Watchlist", type = JAXBElement.class, required = false)
    protected JAXBElement<String> vesselGRT;
    @XmlElementRef(name = "VesselOwner", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts.Watchlist", type = JAXBElement.class, required = false)
    protected JAXBElement<String> vesselOwner;
    @XmlElementRef(name = "VesselTonnage", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts.Watchlist", type = JAXBElement.class, required = false)
    protected JAXBElement<String> vesselTonnage;
    @XmlElementRef(name = "VesselType", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts.Watchlist", type = JAXBElement.class, required = false)
    protected JAXBElement<String> vesselType;

    /**
     * Gets the value of the vesselCallSign property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getVesselCallSign() {
        return vesselCallSign;
    }

    /**
     * Sets the value of the vesselCallSign property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setVesselCallSign(JAXBElement<String> value) {
        this.vesselCallSign = value;
    }

    /**
     * Gets the value of the vesselFlag property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getVesselFlag() {
        return vesselFlag;
    }

    /**
     * Sets the value of the vesselFlag property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setVesselFlag(JAXBElement<String> value) {
        this.vesselFlag = value;
    }

    /**
     * Gets the value of the vesselGRT property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getVesselGRT() {
        return vesselGRT;
    }

    /**
     * Sets the value of the vesselGRT property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setVesselGRT(JAXBElement<String> value) {
        this.vesselGRT = value;
    }

    /**
     * Gets the value of the vesselOwner property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getVesselOwner() {
        return vesselOwner;
    }

    /**
     * Sets the value of the vesselOwner property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setVesselOwner(JAXBElement<String> value) {
        this.vesselOwner = value;
    }

    /**
     * Gets the value of the vesselTonnage property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getVesselTonnage() {
        return vesselTonnage;
    }

    /**
     * Sets the value of the vesselTonnage property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setVesselTonnage(JAXBElement<String> value) {
        this.vesselTonnage = value;
    }

    /**
     * Gets the value of the vesselType property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getVesselType() {
        return vesselType;
    }

    /**
     * Sets the value of the vesselType property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setVesselType(JAXBElement<String> value) {
        this.vesselType = value;
    }

}
