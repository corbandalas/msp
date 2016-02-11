
package org.datacontract.schemas._2004._07.neuromancerlibrary_datacontracts;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for IDCheckUKDeltaDrivingLicence complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="IDCheckUKDeltaDrivingLicence">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="MiddleNameWarning" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="ResultFlag" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "IDCheckUKDeltaDrivingLicence", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts.IDCheckUKDelta", propOrder = {
    "middleNameWarning",
    "resultFlag"
})
public class IDCheckUKDeltaDrivingLicence {

    @XmlElement(name = "MiddleNameWarning")
    protected Boolean middleNameWarning;
    @XmlElement(name = "ResultFlag")
    protected Boolean resultFlag;

    /**
     * Gets the value of the middleNameWarning property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isMiddleNameWarning() {
        return middleNameWarning;
    }

    /**
     * Sets the value of the middleNameWarning property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setMiddleNameWarning(Boolean value) {
        this.middleNameWarning = value;
    }

    /**
     * Gets the value of the resultFlag property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isResultFlag() {
        return resultFlag;
    }

    /**
     * Sets the value of the resultFlag property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setResultFlag(Boolean value) {
        this.resultFlag = value;
    }

}
