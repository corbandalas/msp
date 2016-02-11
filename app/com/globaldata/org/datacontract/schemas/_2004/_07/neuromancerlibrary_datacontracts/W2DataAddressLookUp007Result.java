
package org.datacontract.schemas._2004._07.neuromancerlibrary_datacontracts;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import org.datacontract.schemas._2004._07.databaselibrary.GenericMatchTypeEnum;
import org.datacontract.schemas._2004._07.neuromancerlibrary_externalservices_equifax.ArrayOfAddressMatch;


/**
 * <p>Java class for W2DataAddressLookUp007Result complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="W2DataAddressLookUp007Result">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="AddressMatches" type="{http://schemas.datacontract.org/2004/07/NeuromancerLibrary.ExternalServices.Equifax.AddressMatching}ArrayOfAddressMatch" minOccurs="0"/>
 *         &lt;element name="MatchType" type="{http://schemas.datacontract.org/2004/07/DatabaseLibrary.Enums}GenericMatchTypeEnum" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "W2DataAddressLookUp007Result", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts.W2DataAddressLookup007", propOrder = {
    "addressMatches",
    "matchType"
})
public class W2DataAddressLookUp007Result {

    @XmlElementRef(name = "AddressMatches", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts.W2DataAddressLookup007", type = JAXBElement.class, required = false)
    protected JAXBElement<ArrayOfAddressMatch> addressMatches;
    @XmlElement(name = "MatchType")
    @XmlSchemaType(name = "string")
    protected GenericMatchTypeEnum matchType;

    /**
     * Gets the value of the addressMatches property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfAddressMatch }{@code >}
     *     
     */
    public JAXBElement<ArrayOfAddressMatch> getAddressMatches() {
        return addressMatches;
    }

    /**
     * Sets the value of the addressMatches property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfAddressMatch }{@code >}
     *     
     */
    public void setAddressMatches(JAXBElement<ArrayOfAddressMatch> value) {
        this.addressMatches = value;
    }

    /**
     * Gets the value of the matchType property.
     * 
     * @return
     *     possible object is
     *     {@link GenericMatchTypeEnum }
     *     
     */
    public GenericMatchTypeEnum getMatchType() {
        return matchType;
    }

    /**
     * Sets the value of the matchType property.
     * 
     * @param value
     *     allowed object is
     *     {@link GenericMatchTypeEnum }
     *     
     */
    public void setMatchType(GenericMatchTypeEnum value) {
        this.matchType = value;
    }

}
