
package org.datacontract.schemas._2004._07.neuromancerlibrary_datacontracts;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import org.datacontract.schemas._2004._07.databaselibrary.GenericMatchTypeEnum;


/**
 * <p>Java class for W2DataEkycUk007Result complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="W2DataEkycUk007Result">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="MortalityData" type="{http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts.W2DataEkycUk007}ArrayOfW2DataEkycUk007Mortality" minOccurs="0"/>
 *         &lt;element name="MortalityDataCheckType" type="{http://schemas.datacontract.org/2004/07/DatabaseLibrary.Enums}GenericMatchTypeEnum" minOccurs="0"/>
 *         &lt;element name="UniqueAddressMatchFound" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="VerificationData" type="{http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts.W2DataEkycUk007}W2DataEkycUk007Verification" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "W2DataEkycUk007Result", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts.W2DataEkycUk007", propOrder = {
    "mortalityData",
    "mortalityDataCheckType",
    "uniqueAddressMatchFound",
    "verificationData"
})
public class W2DataEkycUk007Result {

    @XmlElementRef(name = "MortalityData", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts.W2DataEkycUk007", type = JAXBElement.class, required = false)
    protected JAXBElement<ArrayOfW2DataEkycUk007Mortality> mortalityData;
    @XmlElement(name = "MortalityDataCheckType")
    @XmlSchemaType(name = "string")
    protected GenericMatchTypeEnum mortalityDataCheckType;
    @XmlElement(name = "UniqueAddressMatchFound")
    protected Boolean uniqueAddressMatchFound;
    @XmlElementRef(name = "VerificationData", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts.W2DataEkycUk007", type = JAXBElement.class, required = false)
    protected JAXBElement<W2DataEkycUk007Verification> verificationData;

    /**
     * Gets the value of the mortalityData property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfW2DataEkycUk007Mortality }{@code >}
     *     
     */
    public JAXBElement<ArrayOfW2DataEkycUk007Mortality> getMortalityData() {
        return mortalityData;
    }

    /**
     * Sets the value of the mortalityData property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfW2DataEkycUk007Mortality }{@code >}
     *     
     */
    public void setMortalityData(JAXBElement<ArrayOfW2DataEkycUk007Mortality> value) {
        this.mortalityData = value;
    }

    /**
     * Gets the value of the mortalityDataCheckType property.
     * 
     * @return
     *     possible object is
     *     {@link GenericMatchTypeEnum }
     *     
     */
    public GenericMatchTypeEnum getMortalityDataCheckType() {
        return mortalityDataCheckType;
    }

    /**
     * Sets the value of the mortalityDataCheckType property.
     * 
     * @param value
     *     allowed object is
     *     {@link GenericMatchTypeEnum }
     *     
     */
    public void setMortalityDataCheckType(GenericMatchTypeEnum value) {
        this.mortalityDataCheckType = value;
    }

    /**
     * Gets the value of the uniqueAddressMatchFound property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isUniqueAddressMatchFound() {
        return uniqueAddressMatchFound;
    }

    /**
     * Sets the value of the uniqueAddressMatchFound property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setUniqueAddressMatchFound(Boolean value) {
        this.uniqueAddressMatchFound = value;
    }

    /**
     * Gets the value of the verificationData property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link W2DataEkycUk007Verification }{@code >}
     *     
     */
    public JAXBElement<W2DataEkycUk007Verification> getVerificationData() {
        return verificationData;
    }

    /**
     * Sets the value of the verificationData property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link W2DataEkycUk007Verification }{@code >}
     *     
     */
    public void setVerificationData(JAXBElement<W2DataEkycUk007Verification> value) {
        this.verificationData = value;
    }

}
