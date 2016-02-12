
package ae.globalprocessing.hyperionweb;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="WSID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="IssCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CardSelector" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="CardSelectorValue" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="LocDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="LocTime" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="LimitsGroup" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="MCCGroup" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PERMSGroup" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="FeeGroup" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SchedFeeGroup" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="WSFeeGroup" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CurrentLimitsGroup" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CurrentMCCGroup" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CurrentPERMSGroup" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CurrentFeeGroup" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CurrentSchedFeeGroup" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CurrentWSFeeGroup" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="LinkageGroup" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
@XmlType(name = "", propOrder = {
    "wsid",
    "issCode",
    "cardSelector",
    "cardSelectorValue",
    "locDate",
    "locTime",
    "limitsGroup",
    "mccGroup",
    "permsGroup",
    "feeGroup",
    "schedFeeGroup",
    "wsFeeGroup",
    "currentLimitsGroup",
    "currentMCCGroup",
    "currentPERMSGroup",
    "currentFeeGroup",
    "currentSchedFeeGroup",
    "currentWSFeeGroup",
    "linkageGroup",
    "currentLinkageGroup"
})
@XmlRootElement(name = "Ws_Change_Groups")
public class WsChangeGroups {

    @XmlElement(name = "WSID")
    protected long wsid;
    @XmlElement(name = "IssCode")
    protected String issCode;
    @XmlElement(name = "CardSelector")
    protected int cardSelector;
    @XmlElement(name = "CardSelectorValue")
    protected String cardSelectorValue;
    @XmlElement(name = "LocDate")
    protected String locDate;
    @XmlElement(name = "LocTime")
    protected String locTime;
    @XmlElement(name = "LimitsGroup")
    protected String limitsGroup;
    @XmlElement(name = "MCCGroup")
    protected String mccGroup;
    @XmlElement(name = "PERMSGroup")
    protected String permsGroup;
    @XmlElement(name = "FeeGroup")
    protected String feeGroup;
    @XmlElement(name = "SchedFeeGroup")
    protected String schedFeeGroup;
    @XmlElement(name = "WSFeeGroup")
    protected String wsFeeGroup;
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
    @XmlElement(name = "LinkageGroup")
    protected String linkageGroup;
    @XmlElement(name = "CurrentLinkageGroup")
    protected String currentLinkageGroup;

    /**
     * Gets the value of the wsid property.
     * 
     */
    public long getWSID() {
        return wsid;
    }

    /**
     * Sets the value of the wsid property.
     * 
     */
    public void setWSID(long value) {
        this.wsid = value;
    }

    /**
     * Gets the value of the issCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIssCode() {
        return issCode;
    }

    /**
     * Sets the value of the issCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIssCode(String value) {
        this.issCode = value;
    }

    /**
     * Gets the value of the cardSelector property.
     * 
     */
    public int getCardSelector() {
        return cardSelector;
    }

    /**
     * Sets the value of the cardSelector property.
     * 
     */
    public void setCardSelector(int value) {
        this.cardSelector = value;
    }

    /**
     * Gets the value of the cardSelectorValue property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCardSelectorValue() {
        return cardSelectorValue;
    }

    /**
     * Sets the value of the cardSelectorValue property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCardSelectorValue(String value) {
        this.cardSelectorValue = value;
    }

    /**
     * Gets the value of the locDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLocDate() {
        return locDate;
    }

    /**
     * Sets the value of the locDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLocDate(String value) {
        this.locDate = value;
    }

    /**
     * Gets the value of the locTime property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLocTime() {
        return locTime;
    }

    /**
     * Sets the value of the locTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLocTime(String value) {
        this.locTime = value;
    }

    /**
     * Gets the value of the limitsGroup property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLimitsGroup() {
        return limitsGroup;
    }

    /**
     * Sets the value of the limitsGroup property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLimitsGroup(String value) {
        this.limitsGroup = value;
    }

    /**
     * Gets the value of the mccGroup property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMCCGroup() {
        return mccGroup;
    }

    /**
     * Sets the value of the mccGroup property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMCCGroup(String value) {
        this.mccGroup = value;
    }

    /**
     * Gets the value of the permsGroup property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPERMSGroup() {
        return permsGroup;
    }

    /**
     * Sets the value of the permsGroup property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPERMSGroup(String value) {
        this.permsGroup = value;
    }

    /**
     * Gets the value of the feeGroup property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFeeGroup() {
        return feeGroup;
    }

    /**
     * Sets the value of the feeGroup property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFeeGroup(String value) {
        this.feeGroup = value;
    }

    /**
     * Gets the value of the schedFeeGroup property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSchedFeeGroup() {
        return schedFeeGroup;
    }

    /**
     * Sets the value of the schedFeeGroup property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSchedFeeGroup(String value) {
        this.schedFeeGroup = value;
    }

    /**
     * Gets the value of the wsFeeGroup property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWSFeeGroup() {
        return wsFeeGroup;
    }

    /**
     * Sets the value of the wsFeeGroup property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWSFeeGroup(String value) {
        this.wsFeeGroup = value;
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
     * Gets the value of the linkageGroup property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLinkageGroup() {
        return linkageGroup;
    }

    /**
     * Sets the value of the linkageGroup property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLinkageGroup(String value) {
        this.linkageGroup = value;
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
