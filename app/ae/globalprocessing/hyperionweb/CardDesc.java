
package ae.globalprocessing.hyperionweb;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for CardDesc complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CardDesc">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="PublicToken" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CurrentLimitsGroup" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CurrentMCCGroup" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CurrentPERMSGroup" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CurrentFeeGroup" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CurrentSchedFeeGroup" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CurrentWSFeeGroup" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CurrentLinkageGroup" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CardDesc", propOrder = {
    "publicToken",
    "currentLimitsGroup",
    "currentMCCGroup",
    "currentPERMSGroup",
    "currentFeeGroup",
    "currentSchedFeeGroup",
    "currentWSFeeGroup",
    "currentLinkageGroup"
})
public class CardDesc {

    @XmlElement(name = "PublicToken")
    protected String publicToken;
    @XmlElement(name = "CurrentLimitsGroup")
    protected String currentLimitsGroup;
    @XmlElement(name = "CurrentMCCGroup")
    protected String currentMCCGroup;
    @XmlElement(name = "CurrentPERMSGroup")
    protected String currentPERMSGroup;
    @XmlElement(name = "CurrentFeeGroup")
    protected String currentFeeGroup;
    @XmlElement(name = "CurrentSchedFeeGroup")
    protected String currentSchedFeeGroup;
    @XmlElement(name = "CurrentWSFeeGroup")
    protected String currentWSFeeGroup;
    @XmlElement(name = "CurrentLinkageGroup")
    protected String currentLinkageGroup;

    /**
     * Gets the value of the publicToken property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPublicToken() {
        return publicToken;
    }

    /**
     * Sets the value of the publicToken property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPublicToken(String value) {
        this.publicToken = value;
    }

    /**
     * Gets the value of the currentLimitsGroup property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCurrentLimitsGroup() {
        return currentLimitsGroup;
    }

    /**
     * Sets the value of the currentLimitsGroup property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCurrentLimitsGroup(String value) {
        this.currentLimitsGroup = value;
    }

    /**
     * Gets the value of the currentMCCGroup property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCurrentMCCGroup() {
        return currentMCCGroup;
    }

    /**
     * Sets the value of the currentMCCGroup property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCurrentMCCGroup(String value) {
        this.currentMCCGroup = value;
    }

    /**
     * Gets the value of the currentPERMSGroup property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCurrentPERMSGroup() {
        return currentPERMSGroup;
    }

    /**
     * Sets the value of the currentPERMSGroup property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCurrentPERMSGroup(String value) {
        this.currentPERMSGroup = value;
    }

    /**
     * Gets the value of the currentFeeGroup property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCurrentFeeGroup() {
        return currentFeeGroup;
    }

    /**
     * Sets the value of the currentFeeGroup property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCurrentFeeGroup(String value) {
        this.currentFeeGroup = value;
    }

    /**
     * Gets the value of the currentSchedFeeGroup property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCurrentSchedFeeGroup() {
        return currentSchedFeeGroup;
    }

    /**
     * Sets the value of the currentSchedFeeGroup property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCurrentSchedFeeGroup(String value) {
        this.currentSchedFeeGroup = value;
    }

    /**
     * Gets the value of the currentWSFeeGroup property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCurrentWSFeeGroup() {
        return currentWSFeeGroup;
    }

    /**
     * Sets the value of the currentWSFeeGroup property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCurrentWSFeeGroup(String value) {
        this.currentWSFeeGroup = value;
    }

    /**
     * Gets the value of the currentLinkageGroup property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCurrentLinkageGroup() {
        return currentLinkageGroup;
    }

    /**
     * Sets the value of the currentLinkageGroup property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCurrentLinkageGroup(String value) {
        this.currentLinkageGroup = value;
    }

}
