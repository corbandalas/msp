
package org.datacontract.schemas._2004._07.neuromancerlibrary_datacontracts;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for IDCheckUKAlphaCreditHeaderMatch complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="IDCheckUKAlphaCreditHeaderMatch">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="CAISAgeMatchCount" type="{http://www.w3.org/2001/XMLSchema}unsignedInt" minOccurs="0"/>
 *         &lt;element name="CAISCloseMatchCount" type="{http://www.w3.org/2001/XMLSchema}unsignedInt" minOccurs="0"/>
 *         &lt;element name="CAISExactMatchCount" type="{http://www.w3.org/2001/XMLSchema}unsignedInt" minOccurs="0"/>
 *         &lt;element name="CAISValidMatchCount" type="{http://www.w3.org/2001/XMLSchema}unsignedInt" minOccurs="0"/>
 *         &lt;element name="CAPSAgeMatchCount" type="{http://www.w3.org/2001/XMLSchema}unsignedInt" minOccurs="0"/>
 *         &lt;element name="CAPSDobMatchCount" type="{http://www.w3.org/2001/XMLSchema}unsignedInt" minOccurs="0"/>
 *         &lt;element name="CloseCAPSMatchCount" type="{http://www.w3.org/2001/XMLSchema}unsignedInt" minOccurs="0"/>
 *         &lt;element name="CloseMatchActiveCCJCount" type="{http://www.w3.org/2001/XMLSchema}unsignedInt" minOccurs="0"/>
 *         &lt;element name="CloseMatchLendersOfSettledCAISCount" type="{http://www.w3.org/2001/XMLSchema}unsignedInt" minOccurs="0"/>
 *         &lt;element name="CloseMatchSatisfiedCCJCount" type="{http://www.w3.org/2001/XMLSchema}unsignedInt" minOccurs="0"/>
 *         &lt;element name="ElectoralMatch" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="ExactCAPSMatchCount" type="{http://www.w3.org/2001/XMLSchema}unsignedInt" minOccurs="0"/>
 *         &lt;element name="ExactMatchActiveCCJCount" type="{http://www.w3.org/2001/XMLSchema}unsignedInt" minOccurs="0"/>
 *         &lt;element name="ExactMatchLendersOfSettledCAISCount" type="{http://www.w3.org/2001/XMLSchema}unsignedInt" minOccurs="0"/>
 *         &lt;element name="ExactMatchSatisfiedCCJCount" type="{http://www.w3.org/2001/XMLSchema}unsignedInt" minOccurs="0"/>
 *         &lt;element name="ValidNameDobLendersOfSettledCAISCount" type="{http://www.w3.org/2001/XMLSchema}unsignedInt" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "IDCheckUKAlphaCreditHeaderMatch", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts.IDCheckUKAlpha", propOrder = {
    "caisAgeMatchCount",
    "caisCloseMatchCount",
    "caisExactMatchCount",
    "caisValidMatchCount",
    "capsAgeMatchCount",
    "capsDobMatchCount",
    "closeCAPSMatchCount",
    "closeMatchActiveCCJCount",
    "closeMatchLendersOfSettledCAISCount",
    "closeMatchSatisfiedCCJCount",
    "electoralMatch",
    "exactCAPSMatchCount",
    "exactMatchActiveCCJCount",
    "exactMatchLendersOfSettledCAISCount",
    "exactMatchSatisfiedCCJCount",
    "validNameDobLendersOfSettledCAISCount"
})
public class IDCheckUKAlphaCreditHeaderMatch {

    @XmlElementRef(name = "CAISAgeMatchCount", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts.IDCheckUKAlpha", type = JAXBElement.class, required = false)
    protected JAXBElement<Long> caisAgeMatchCount;
    @XmlElementRef(name = "CAISCloseMatchCount", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts.IDCheckUKAlpha", type = JAXBElement.class, required = false)
    protected JAXBElement<Long> caisCloseMatchCount;
    @XmlElementRef(name = "CAISExactMatchCount", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts.IDCheckUKAlpha", type = JAXBElement.class, required = false)
    protected JAXBElement<Long> caisExactMatchCount;
    @XmlElementRef(name = "CAISValidMatchCount", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts.IDCheckUKAlpha", type = JAXBElement.class, required = false)
    protected JAXBElement<Long> caisValidMatchCount;
    @XmlElementRef(name = "CAPSAgeMatchCount", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts.IDCheckUKAlpha", type = JAXBElement.class, required = false)
    protected JAXBElement<Long> capsAgeMatchCount;
    @XmlElementRef(name = "CAPSDobMatchCount", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts.IDCheckUKAlpha", type = JAXBElement.class, required = false)
    protected JAXBElement<Long> capsDobMatchCount;
    @XmlElementRef(name = "CloseCAPSMatchCount", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts.IDCheckUKAlpha", type = JAXBElement.class, required = false)
    protected JAXBElement<Long> closeCAPSMatchCount;
    @XmlElementRef(name = "CloseMatchActiveCCJCount", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts.IDCheckUKAlpha", type = JAXBElement.class, required = false)
    protected JAXBElement<Long> closeMatchActiveCCJCount;
    @XmlElementRef(name = "CloseMatchLendersOfSettledCAISCount", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts.IDCheckUKAlpha", type = JAXBElement.class, required = false)
    protected JAXBElement<Long> closeMatchLendersOfSettledCAISCount;
    @XmlElementRef(name = "CloseMatchSatisfiedCCJCount", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts.IDCheckUKAlpha", type = JAXBElement.class, required = false)
    protected JAXBElement<Long> closeMatchSatisfiedCCJCount;
    @XmlElementRef(name = "ElectoralMatch", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts.IDCheckUKAlpha", type = JAXBElement.class, required = false)
    protected JAXBElement<Boolean> electoralMatch;
    @XmlElementRef(name = "ExactCAPSMatchCount", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts.IDCheckUKAlpha", type = JAXBElement.class, required = false)
    protected JAXBElement<Long> exactCAPSMatchCount;
    @XmlElementRef(name = "ExactMatchActiveCCJCount", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts.IDCheckUKAlpha", type = JAXBElement.class, required = false)
    protected JAXBElement<Long> exactMatchActiveCCJCount;
    @XmlElementRef(name = "ExactMatchLendersOfSettledCAISCount", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts.IDCheckUKAlpha", type = JAXBElement.class, required = false)
    protected JAXBElement<Long> exactMatchLendersOfSettledCAISCount;
    @XmlElementRef(name = "ExactMatchSatisfiedCCJCount", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts.IDCheckUKAlpha", type = JAXBElement.class, required = false)
    protected JAXBElement<Long> exactMatchSatisfiedCCJCount;
    @XmlElementRef(name = "ValidNameDobLendersOfSettledCAISCount", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts.IDCheckUKAlpha", type = JAXBElement.class, required = false)
    protected JAXBElement<Long> validNameDobLendersOfSettledCAISCount;

    /**
     * Gets the value of the caisAgeMatchCount property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Long }{@code >}
     *     
     */
    public JAXBElement<Long> getCAISAgeMatchCount() {
        return caisAgeMatchCount;
    }

    /**
     * Sets the value of the caisAgeMatchCount property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Long }{@code >}
     *     
     */
    public void setCAISAgeMatchCount(JAXBElement<Long> value) {
        this.caisAgeMatchCount = value;
    }

    /**
     * Gets the value of the caisCloseMatchCount property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Long }{@code >}
     *     
     */
    public JAXBElement<Long> getCAISCloseMatchCount() {
        return caisCloseMatchCount;
    }

    /**
     * Sets the value of the caisCloseMatchCount property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Long }{@code >}
     *     
     */
    public void setCAISCloseMatchCount(JAXBElement<Long> value) {
        this.caisCloseMatchCount = value;
    }

    /**
     * Gets the value of the caisExactMatchCount property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Long }{@code >}
     *     
     */
    public JAXBElement<Long> getCAISExactMatchCount() {
        return caisExactMatchCount;
    }

    /**
     * Sets the value of the caisExactMatchCount property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Long }{@code >}
     *     
     */
    public void setCAISExactMatchCount(JAXBElement<Long> value) {
        this.caisExactMatchCount = value;
    }

    /**
     * Gets the value of the caisValidMatchCount property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Long }{@code >}
     *     
     */
    public JAXBElement<Long> getCAISValidMatchCount() {
        return caisValidMatchCount;
    }

    /**
     * Sets the value of the caisValidMatchCount property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Long }{@code >}
     *     
     */
    public void setCAISValidMatchCount(JAXBElement<Long> value) {
        this.caisValidMatchCount = value;
    }

    /**
     * Gets the value of the capsAgeMatchCount property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Long }{@code >}
     *     
     */
    public JAXBElement<Long> getCAPSAgeMatchCount() {
        return capsAgeMatchCount;
    }

    /**
     * Sets the value of the capsAgeMatchCount property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Long }{@code >}
     *     
     */
    public void setCAPSAgeMatchCount(JAXBElement<Long> value) {
        this.capsAgeMatchCount = value;
    }

    /**
     * Gets the value of the capsDobMatchCount property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Long }{@code >}
     *     
     */
    public JAXBElement<Long> getCAPSDobMatchCount() {
        return capsDobMatchCount;
    }

    /**
     * Sets the value of the capsDobMatchCount property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Long }{@code >}
     *     
     */
    public void setCAPSDobMatchCount(JAXBElement<Long> value) {
        this.capsDobMatchCount = value;
    }

    /**
     * Gets the value of the closeCAPSMatchCount property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Long }{@code >}
     *     
     */
    public JAXBElement<Long> getCloseCAPSMatchCount() {
        return closeCAPSMatchCount;
    }

    /**
     * Sets the value of the closeCAPSMatchCount property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Long }{@code >}
     *     
     */
    public void setCloseCAPSMatchCount(JAXBElement<Long> value) {
        this.closeCAPSMatchCount = value;
    }

    /**
     * Gets the value of the closeMatchActiveCCJCount property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Long }{@code >}
     *     
     */
    public JAXBElement<Long> getCloseMatchActiveCCJCount() {
        return closeMatchActiveCCJCount;
    }

    /**
     * Sets the value of the closeMatchActiveCCJCount property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Long }{@code >}
     *     
     */
    public void setCloseMatchActiveCCJCount(JAXBElement<Long> value) {
        this.closeMatchActiveCCJCount = value;
    }

    /**
     * Gets the value of the closeMatchLendersOfSettledCAISCount property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Long }{@code >}
     *     
     */
    public JAXBElement<Long> getCloseMatchLendersOfSettledCAISCount() {
        return closeMatchLendersOfSettledCAISCount;
    }

    /**
     * Sets the value of the closeMatchLendersOfSettledCAISCount property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Long }{@code >}
     *     
     */
    public void setCloseMatchLendersOfSettledCAISCount(JAXBElement<Long> value) {
        this.closeMatchLendersOfSettledCAISCount = value;
    }

    /**
     * Gets the value of the closeMatchSatisfiedCCJCount property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Long }{@code >}
     *     
     */
    public JAXBElement<Long> getCloseMatchSatisfiedCCJCount() {
        return closeMatchSatisfiedCCJCount;
    }

    /**
     * Sets the value of the closeMatchSatisfiedCCJCount property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Long }{@code >}
     *     
     */
    public void setCloseMatchSatisfiedCCJCount(JAXBElement<Long> value) {
        this.closeMatchSatisfiedCCJCount = value;
    }

    /**
     * Gets the value of the electoralMatch property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     *     
     */
    public JAXBElement<Boolean> getElectoralMatch() {
        return electoralMatch;
    }

    /**
     * Sets the value of the electoralMatch property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     *     
     */
    public void setElectoralMatch(JAXBElement<Boolean> value) {
        this.electoralMatch = value;
    }

    /**
     * Gets the value of the exactCAPSMatchCount property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Long }{@code >}
     *     
     */
    public JAXBElement<Long> getExactCAPSMatchCount() {
        return exactCAPSMatchCount;
    }

    /**
     * Sets the value of the exactCAPSMatchCount property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Long }{@code >}
     *     
     */
    public void setExactCAPSMatchCount(JAXBElement<Long> value) {
        this.exactCAPSMatchCount = value;
    }

    /**
     * Gets the value of the exactMatchActiveCCJCount property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Long }{@code >}
     *     
     */
    public JAXBElement<Long> getExactMatchActiveCCJCount() {
        return exactMatchActiveCCJCount;
    }

    /**
     * Sets the value of the exactMatchActiveCCJCount property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Long }{@code >}
     *     
     */
    public void setExactMatchActiveCCJCount(JAXBElement<Long> value) {
        this.exactMatchActiveCCJCount = value;
    }

    /**
     * Gets the value of the exactMatchLendersOfSettledCAISCount property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Long }{@code >}
     *     
     */
    public JAXBElement<Long> getExactMatchLendersOfSettledCAISCount() {
        return exactMatchLendersOfSettledCAISCount;
    }

    /**
     * Sets the value of the exactMatchLendersOfSettledCAISCount property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Long }{@code >}
     *     
     */
    public void setExactMatchLendersOfSettledCAISCount(JAXBElement<Long> value) {
        this.exactMatchLendersOfSettledCAISCount = value;
    }

    /**
     * Gets the value of the exactMatchSatisfiedCCJCount property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Long }{@code >}
     *     
     */
    public JAXBElement<Long> getExactMatchSatisfiedCCJCount() {
        return exactMatchSatisfiedCCJCount;
    }

    /**
     * Sets the value of the exactMatchSatisfiedCCJCount property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Long }{@code >}
     *     
     */
    public void setExactMatchSatisfiedCCJCount(JAXBElement<Long> value) {
        this.exactMatchSatisfiedCCJCount = value;
    }

    /**
     * Gets the value of the validNameDobLendersOfSettledCAISCount property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Long }{@code >}
     *     
     */
    public JAXBElement<Long> getValidNameDobLendersOfSettledCAISCount() {
        return validNameDobLendersOfSettledCAISCount;
    }

    /**
     * Sets the value of the validNameDobLendersOfSettledCAISCount property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Long }{@code >}
     *     
     */
    public void setValidNameDobLendersOfSettledCAISCount(JAXBElement<Long> value) {
        this.validNameDobLendersOfSettledCAISCount = value;
    }

}
