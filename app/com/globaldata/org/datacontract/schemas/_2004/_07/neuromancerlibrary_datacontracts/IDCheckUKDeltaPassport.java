
package org.datacontract.schemas._2004._07.neuromancerlibrary_datacontracts;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for IDCheckUKDeltaPassport complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="IDCheckUKDeltaPassport">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="IsDateOfBirthValid" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="IsExpiryValid" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="IsGenderValid" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="IsMRZValid" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "IDCheckUKDeltaPassport", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts.IDCheckUKDelta", propOrder = {
    "isDateOfBirthValid",
    "isExpiryValid",
    "isGenderValid",
    "isMRZValid"
})
public class IDCheckUKDeltaPassport {

    @XmlElement(name = "IsDateOfBirthValid")
    protected Boolean isDateOfBirthValid;
    @XmlElement(name = "IsExpiryValid")
    protected Boolean isExpiryValid;
    @XmlElement(name = "IsGenderValid")
    protected Boolean isGenderValid;
    @XmlElement(name = "IsMRZValid")
    protected Boolean isMRZValid;

    /**
     * Gets the value of the isDateOfBirthValid property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isIsDateOfBirthValid() {
        return isDateOfBirthValid;
    }

    /**
     * Sets the value of the isDateOfBirthValid property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIsDateOfBirthValid(Boolean value) {
        this.isDateOfBirthValid = value;
    }

    /**
     * Gets the value of the isExpiryValid property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isIsExpiryValid() {
        return isExpiryValid;
    }

    /**
     * Sets the value of the isExpiryValid property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIsExpiryValid(Boolean value) {
        this.isExpiryValid = value;
    }

    /**
     * Gets the value of the isGenderValid property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isIsGenderValid() {
        return isGenderValid;
    }

    /**
     * Sets the value of the isGenderValid property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIsGenderValid(Boolean value) {
        this.isGenderValid = value;
    }

    /**
     * Gets the value of the isMRZValid property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isIsMRZValid() {
        return isMRZValid;
    }

    /**
     * Sets the value of the isMRZValid property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIsMRZValid(Boolean value) {
        this.isMRZValid = value;
    }

}
