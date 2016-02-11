
package org.datacontract.schemas._2004._07.neuromancerlibrary_datacontracts;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for IDCheckUKDeltaTravelVisa complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="IDCheckUKDeltaTravelVisa">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="InDate" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="IsMRZValid" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="IsUKResidenceValid" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "IDCheckUKDeltaTravelVisa", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts.IDCheckUKDelta", propOrder = {
    "inDate",
    "isMRZValid",
    "isUKResidenceValid"
})
public class IDCheckUKDeltaTravelVisa {

    @XmlElement(name = "InDate")
    protected Boolean inDate;
    @XmlElement(name = "IsMRZValid")
    protected Boolean isMRZValid;
    @XmlElement(name = "IsUKResidenceValid")
    protected Boolean isUKResidenceValid;

    /**
     * Gets the value of the inDate property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isInDate() {
        return inDate;
    }

    /**
     * Sets the value of the inDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setInDate(Boolean value) {
        this.inDate = value;
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

    /**
     * Gets the value of the isUKResidenceValid property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isIsUKResidenceValid() {
        return isUKResidenceValid;
    }

    /**
     * Sets the value of the isUKResidenceValid property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIsUKResidenceValid(Boolean value) {
        this.isUKResidenceValid = value;
    }

}
