
package org.datacontract.schemas._2004._07.neuromancerlibrary_datacontracts;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import org.datacontract.schemas._2004._07.databaselibrary.GenericMatchTypeEnum;


/**
 * <p>Java class for W2DataEkycUk007Verification complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="W2DataEkycUk007Verification">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ElectoralRollNameAndAddressMatch" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="ElectoralRollNameAndDateOfBirthMatch" type="{http://schemas.datacontract.org/2004/07/DatabaseLibrary.Enums}GenericMatchTypeEnum" minOccurs="0"/>
 *         &lt;element name="LendersContributingToTheCreditFileCount" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="MatchDateOfBirthUsingCreditRecords" type="{http://schemas.datacontract.org/2004/07/DatabaseLibrary.Enums}GenericMatchTypeEnum" minOccurs="0"/>
 *         &lt;element name="NumberCcj" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "W2DataEkycUk007Verification", namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts.W2DataEkycUk007", propOrder = {
    "electoralRollNameAndAddressMatch",
    "electoralRollNameAndDateOfBirthMatch",
    "lendersContributingToTheCreditFileCount",
    "matchDateOfBirthUsingCreditRecords",
    "numberCcj"
})
public class W2DataEkycUk007Verification {

    @XmlElement(name = "ElectoralRollNameAndAddressMatch")
    protected Boolean electoralRollNameAndAddressMatch;
    @XmlElement(name = "ElectoralRollNameAndDateOfBirthMatch")
    @XmlSchemaType(name = "string")
    protected GenericMatchTypeEnum electoralRollNameAndDateOfBirthMatch;
    @XmlElement(name = "LendersContributingToTheCreditFileCount")
    protected Integer lendersContributingToTheCreditFileCount;
    @XmlElement(name = "MatchDateOfBirthUsingCreditRecords")
    @XmlSchemaType(name = "string")
    protected GenericMatchTypeEnum matchDateOfBirthUsingCreditRecords;
    @XmlElement(name = "NumberCcj")
    protected Integer numberCcj;

    /**
     * Gets the value of the electoralRollNameAndAddressMatch property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isElectoralRollNameAndAddressMatch() {
        return electoralRollNameAndAddressMatch;
    }

    /**
     * Sets the value of the electoralRollNameAndAddressMatch property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setElectoralRollNameAndAddressMatch(Boolean value) {
        this.electoralRollNameAndAddressMatch = value;
    }

    /**
     * Gets the value of the electoralRollNameAndDateOfBirthMatch property.
     * 
     * @return
     *     possible object is
     *     {@link GenericMatchTypeEnum }
     *     
     */
    public GenericMatchTypeEnum getElectoralRollNameAndDateOfBirthMatch() {
        return electoralRollNameAndDateOfBirthMatch;
    }

    /**
     * Sets the value of the electoralRollNameAndDateOfBirthMatch property.
     * 
     * @param value
     *     allowed object is
     *     {@link GenericMatchTypeEnum }
     *     
     */
    public void setElectoralRollNameAndDateOfBirthMatch(GenericMatchTypeEnum value) {
        this.electoralRollNameAndDateOfBirthMatch = value;
    }

    /**
     * Gets the value of the lendersContributingToTheCreditFileCount property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getLendersContributingToTheCreditFileCount() {
        return lendersContributingToTheCreditFileCount;
    }

    /**
     * Sets the value of the lendersContributingToTheCreditFileCount property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setLendersContributingToTheCreditFileCount(Integer value) {
        this.lendersContributingToTheCreditFileCount = value;
    }

    /**
     * Gets the value of the matchDateOfBirthUsingCreditRecords property.
     * 
     * @return
     *     possible object is
     *     {@link GenericMatchTypeEnum }
     *     
     */
    public GenericMatchTypeEnum getMatchDateOfBirthUsingCreditRecords() {
        return matchDateOfBirthUsingCreditRecords;
    }

    /**
     * Sets the value of the matchDateOfBirthUsingCreditRecords property.
     * 
     * @param value
     *     allowed object is
     *     {@link GenericMatchTypeEnum }
     *     
     */
    public void setMatchDateOfBirthUsingCreditRecords(GenericMatchTypeEnum value) {
        this.matchDateOfBirthUsingCreditRecords = value;
    }

    /**
     * Gets the value of the numberCcj property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getNumberCcj() {
        return numberCcj;
    }

    /**
     * Sets the value of the numberCcj property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setNumberCcj(Integer value) {
        this.numberCcj = value;
    }

}
