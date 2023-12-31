
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
 *         &lt;element name="BlackList" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="WhiteList" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CurrentBlackList" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CurrentWhiteList" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
    "blackList",
    "whiteList",
    "currentBlackList",
    "currentWhiteList"
})
@XmlRootElement(name = "Ws_Change_Cardacceptor_List")
public class WsChangeCardacceptorList {

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
    @XmlElement(name = "BlackList")
    protected String blackList;
    @XmlElement(name = "WhiteList")
    protected String whiteList;
    @XmlElement(name = "CurrentBlackList")
    protected String currentBlackList;
    @XmlElement(name = "CurrentWhiteList")
    protected String currentWhiteList;

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
     * Gets the value of the blackList property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBlackList() {
        return blackList;
    }

    /**
     * Sets the value of the blackList property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBlackList(String value) {
        this.blackList = value;
    }

    /**
     * Gets the value of the whiteList property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWhiteList() {
        return whiteList;
    }

    /**
     * Sets the value of the whiteList property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWhiteList(String value) {
        this.whiteList = value;
    }

    /**
     * Gets the value of the currentBlackList property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCurrentBlackList() {
        return currentBlackList;
    }

    /**
     * Sets the value of the currentBlackList property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCurrentBlackList(String value) {
        this.currentBlackList = value;
    }

    /**
     * Gets the value of the currentWhiteList property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCurrentWhiteList() {
        return currentWhiteList;
    }

    /**
     * Sets the value of the currentWhiteList property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCurrentWhiteList(String value) {
        this.currentWhiteList = value;
    }

}
