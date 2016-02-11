
package org.datacontract.schemas._2004._07.neuromancerlibrary_datacontracts;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for IDCheckUKAlphaData complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="IDCheckUKAlphaData">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="AddressData" type="{http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts.IDCheckUKAlpha}IDCheckUKAlphaAddress" minOccurs="0"/>
 *         &lt;element name="ElectoralData" type="{http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts.IDCheckUKAlpha}IDCheckUKAlphaElectoral" minOccurs="0"/>
 *         &lt;element name="MortalityData" type="{http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts.IDCheckUKAlpha}IDCheckUKAlphaMortality" minOccurs="0"/>
 *         &lt;element name="ReferenceNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="VerificationData" type="{http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts.IDCheckUKAlpha}IDCheckUKAlphaVerification" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "IDCheckUKAlphaData", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts.IDCheckUKAlpha", propOrder = {
    "addressData",
    "electoralData",
    "mortalityData",
    "referenceNumber",
    "verificationData"
})
public class IDCheckUKAlphaData {

    @XmlElementRef(name = "AddressData", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts.IDCheckUKAlpha", type = JAXBElement.class, required = false)
    protected JAXBElement<IDCheckUKAlphaAddress> addressData;
    @XmlElementRef(name = "ElectoralData", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts.IDCheckUKAlpha", type = JAXBElement.class, required = false)
    protected JAXBElement<IDCheckUKAlphaElectoral> electoralData;
    @XmlElementRef(name = "MortalityData", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts.IDCheckUKAlpha", type = JAXBElement.class, required = false)
    protected JAXBElement<IDCheckUKAlphaMortality> mortalityData;
    @XmlElementRef(name = "ReferenceNumber", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts.IDCheckUKAlpha", type = JAXBElement.class, required = false)
    protected JAXBElement<String> referenceNumber;
    @XmlElementRef(name = "VerificationData", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts.IDCheckUKAlpha", type = JAXBElement.class, required = false)
    protected JAXBElement<IDCheckUKAlphaVerification> verificationData;

    /**
     * Gets the value of the addressData property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link IDCheckUKAlphaAddress }{@code >}
     *     
     */
    public JAXBElement<IDCheckUKAlphaAddress> getAddressData() {
        return addressData;
    }

    /**
     * Sets the value of the addressData property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link IDCheckUKAlphaAddress }{@code >}
     *     
     */
    public void setAddressData(JAXBElement<IDCheckUKAlphaAddress> value) {
        this.addressData = value;
    }

    /**
     * Gets the value of the electoralData property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link IDCheckUKAlphaElectoral }{@code >}
     *     
     */
    public JAXBElement<IDCheckUKAlphaElectoral> getElectoralData() {
        return electoralData;
    }

    /**
     * Sets the value of the electoralData property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link IDCheckUKAlphaElectoral }{@code >}
     *     
     */
    public void setElectoralData(JAXBElement<IDCheckUKAlphaElectoral> value) {
        this.electoralData = value;
    }

    /**
     * Gets the value of the mortalityData property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link IDCheckUKAlphaMortality }{@code >}
     *     
     */
    public JAXBElement<IDCheckUKAlphaMortality> getMortalityData() {
        return mortalityData;
    }

    /**
     * Sets the value of the mortalityData property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link IDCheckUKAlphaMortality }{@code >}
     *     
     */
    public void setMortalityData(JAXBElement<IDCheckUKAlphaMortality> value) {
        this.mortalityData = value;
    }

    /**
     * Gets the value of the referenceNumber property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getReferenceNumber() {
        return referenceNumber;
    }

    /**
     * Sets the value of the referenceNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setReferenceNumber(JAXBElement<String> value) {
        this.referenceNumber = value;
    }

    /**
     * Gets the value of the verificationData property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link IDCheckUKAlphaVerification }{@code >}
     *     
     */
    public JAXBElement<IDCheckUKAlphaVerification> getVerificationData() {
        return verificationData;
    }

    /**
     * Sets the value of the verificationData property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link IDCheckUKAlphaVerification }{@code >}
     *     
     */
    public void setVerificationData(JAXBElement<IDCheckUKAlphaVerification> value) {
        this.verificationData = value;
    }

}
