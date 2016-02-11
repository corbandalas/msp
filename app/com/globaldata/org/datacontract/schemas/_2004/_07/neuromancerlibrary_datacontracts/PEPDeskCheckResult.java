
package org.datacontract.schemas._2004._07.neuromancerlibrary_datacontracts;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;
import org.datacontract.schemas._2004._07.neuromancerlibrary.ArrayOfCheckMatch;


/**
 * <p>Java class for PEPDeskCheckResult complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PEPDeskCheckResult">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="MatchResults" type="{http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts}ArrayOfCheckMatch" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PEPDeskCheckResult", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts.PEPDesk", propOrder = {
    "matchResults"
})
public class PEPDeskCheckResult {

    @XmlElementRef(name = "MatchResults", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts.PEPDesk", type = JAXBElement.class, required = false)
    protected JAXBElement<ArrayOfCheckMatch> matchResults;

    /**
     * Gets the value of the matchResults property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfCheckMatch }{@code >}
     *     
     */
    public JAXBElement<ArrayOfCheckMatch> getMatchResults() {
        return matchResults;
    }

    /**
     * Sets the value of the matchResults property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfCheckMatch }{@code >}
     *     
     */
    public void setMatchResults(JAXBElement<ArrayOfCheckMatch> value) {
        this.matchResults = value;
    }

}
