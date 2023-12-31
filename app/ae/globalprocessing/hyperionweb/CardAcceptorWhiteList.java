
package ae.globalprocessing.hyperionweb;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for CardAcceptorWhiteList complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CardAcceptorWhiteList">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="WSID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="IssCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ActionCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SysDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="WhiteList" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="NoOfInvalidCardAcceptors" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="InvalidCardAcceptors" type="{http://www.globalprocessing.ae/HyperionWeb}ArrayOfInvalidCardAcceptor" minOccurs="0"/>
 *         &lt;element name="CardWAcceptors" type="{http://www.globalprocessing.ae/HyperionWeb}ArrayOfCardWAcceptor" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CardAcceptorWhiteList", propOrder = {
    "wsid",
    "issCode",
    "actionCode",
    "sysDate",
    "whiteList",
    "noOfInvalidCardAcceptors",
    "invalidCardAcceptors",
    "cardWAcceptors"
})
public class CardAcceptorWhiteList {

    @XmlElement(name = "WSID")
    protected long wsid;
    @XmlElement(name = "IssCode")
    protected String issCode;
    @XmlElement(name = "ActionCode")
    protected String actionCode;
    @XmlElement(name = "SysDate")
    protected String sysDate;
    @XmlElement(name = "WhiteList")
    protected String whiteList;
    @XmlElement(name = "NoOfInvalidCardAcceptors")
    protected int noOfInvalidCardAcceptors;
    @XmlElement(name = "InvalidCardAcceptors")
    protected ArrayOfInvalidCardAcceptor invalidCardAcceptors;
    @XmlElement(name = "CardWAcceptors")
    protected ArrayOfCardWAcceptor cardWAcceptors;

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
     * Gets the value of the noOfInvalidCardAcceptors property.
     * 
     */
    public int getNoOfInvalidCardAcceptors() {
        return noOfInvalidCardAcceptors;
    }

    /**
     * Sets the value of the noOfInvalidCardAcceptors property.
     * 
     */
    public void setNoOfInvalidCardAcceptors(int value) {
        this.noOfInvalidCardAcceptors = value;
    }

    /**
     * Gets the value of the invalidCardAcceptors property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfInvalidCardAcceptor }
     *     
     */
    public ArrayOfInvalidCardAcceptor getInvalidCardAcceptors() {
        return invalidCardAcceptors;
    }

    /**
     * Sets the value of the invalidCardAcceptors property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfInvalidCardAcceptor }
     *     
     */
    public void setInvalidCardAcceptors(ArrayOfInvalidCardAcceptor value) {
        this.invalidCardAcceptors = value;
    }

    /**
     * Gets the value of the cardWAcceptors property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfCardWAcceptor }
     *     
     */
    public ArrayOfCardWAcceptor getCardWAcceptors() {
        return cardWAcceptors;
    }

    /**
     * Sets the value of the cardWAcceptors property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfCardWAcceptor }
     *     
     */
    public void setCardWAcceptors(ArrayOfCardWAcceptor value) {
        this.cardWAcceptors = value;
    }

}
