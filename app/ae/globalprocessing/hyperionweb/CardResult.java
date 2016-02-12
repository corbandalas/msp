
package ae.globalprocessing.hyperionweb;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for CardResult complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CardResult">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="WSID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="IssCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SysDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ActionCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="cardList" type="{http://www.globalprocessing.ae/HyperionWeb}ArrayOfCard_Details" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CardResult", propOrder = {
    "wsid",
    "issCode",
    "sysDate",
    "actionCode",
    "cardList"
})
public class CardResult {

    @XmlElement(name = "WSID")
    protected String wsid;
    @XmlElement(name = "IssCode")
    protected String issCode;
    @XmlElement(name = "SysDate")
    protected String sysDate;
    @XmlElement(name = "ActionCode")
    protected String actionCode;
    protected ArrayOfCardDetails cardList;

    /**
     * Gets the value of the wsid property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWSID() {
        return wsid;
    }

    /**
     * Sets the value of the wsid property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWSID(String value) {
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
     * Gets the value of the sysDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSysDate() {
        return sysDate;
    }

    /**
     * Sets the value of the sysDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSysDate(String value) {
        this.sysDate = value;
    }

    /**
     * Gets the value of the actionCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getActionCode() {
        return actionCode;
    }

    /**
     * Sets the value of the actionCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setActionCode(String value) {
        this.actionCode = value;
    }

    /**
     * Gets the value of the cardList property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfCardDetails }
     *     
     */
    public ArrayOfCardDetails getCardList() {
        return cardList;
    }

    /**
     * Sets the value of the cardList property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfCardDetails }
     *     
     */
    public void setCardList(ArrayOfCardDetails value) {
        this.cardList = value;
    }

}
