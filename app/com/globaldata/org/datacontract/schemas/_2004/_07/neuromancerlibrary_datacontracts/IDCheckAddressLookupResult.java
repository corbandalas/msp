
package org.datacontract.schemas._2004._07.neuromancerlibrary_datacontracts;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for IDCheckAddressLookupResult complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="IDCheckAddressLookupResult">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="IDCheckAddressLookupMatches" type="{http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts.IDCheckAddressLookup}ArrayOfIDCheckAddressLookupMatch" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "IDCheckAddressLookupResult", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts.IDCheckAddressLookup", propOrder = {
    "idCheckAddressLookupMatches"
})
public class IDCheckAddressLookupResult {

    @XmlElementRef(name = "IDCheckAddressLookupMatches", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts.IDCheckAddressLookup", type = JAXBElement.class, required = false)
    protected JAXBElement<ArrayOfIDCheckAddressLookupMatch> idCheckAddressLookupMatches;

    /**
     * Gets the value of the idCheckAddressLookupMatches property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfIDCheckAddressLookupMatch }{@code >}
     *     
     */
    public JAXBElement<ArrayOfIDCheckAddressLookupMatch> getIDCheckAddressLookupMatches() {
        return idCheckAddressLookupMatches;
    }

    /**
     * Sets the value of the idCheckAddressLookupMatches property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfIDCheckAddressLookupMatch }{@code >}
     *     
     */
    public void setIDCheckAddressLookupMatches(JAXBElement<ArrayOfIDCheckAddressLookupMatch> value) {
        this.idCheckAddressLookupMatches = value;
    }

}
