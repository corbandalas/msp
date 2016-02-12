
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
 *         &lt;element name="WhiteList" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CardAcceptors" type="{http://www.globalprocessing.ae/HyperionWeb}ArrayOfCardAcceptorModifier" minOccurs="0"/>
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
    "whiteList",
    "cardAcceptors"
})
@XmlRootElement(name = "Ws_CardAcceptorWhiteList")
public class WsCardAcceptorWhiteList {

    @XmlElement(name = "WSID")
    protected long wsid;
    @XmlElement(name = "IssCode")
    protected String issCode;
    @XmlElement(name = "WhiteList")
    protected String whiteList;
    @XmlElement(name = "CardAcceptors")
    protected ArrayOfCardAcceptorModifier cardAcceptors;

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
     * Gets the value of the cardAcceptors property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfCardAcceptorModifier }
     *     
     */
    public ArrayOfCardAcceptorModifier getCardAcceptors() {
        return cardAcceptors;
    }

    /**
     * Sets the value of the cardAcceptors property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfCardAcceptorModifier }
     *     
     */
    public void setCardAcceptors(ArrayOfCardAcceptorModifier value) {
        this.cardAcceptors = value;
    }

}
