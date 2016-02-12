
package ae.globalprocessing.hyperionweb;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for PhoneActivate complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PhoneActivate">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="PublicToken" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ActionCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="IsLive" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="PinBlock" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PINStatus" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PhoneActivate", propOrder = {
    "publicToken",
    "actionCode",
    "isLive",
    "pinBlock",
    "pinStatus"
})
public class PhoneActivate {

    @XmlElement(name = "PublicToken")
    protected String publicToken;
    @XmlElement(name = "ActionCode")
    protected String actionCode;
    @XmlElement(name = "IsLive")
    protected boolean isLive;
    @XmlElement(name = "PinBlock")
    protected String pinBlock;
    @XmlElement(name = "PINStatus")
    protected int pinStatus;

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
     * Gets the value of the isLive property.
     * 
     */
    public boolean isIsLive() {
        return isLive;
    }

    /**
     * Sets the value of the isLive property.
     * 
     */
    public void setIsLive(boolean value) {
        this.isLive = value;
    }

    /**
     * Gets the value of the pinBlock property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPinBlock() {
        return pinBlock;
    }

    /**
     * Sets the value of the pinBlock property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPinBlock(String value) {
        this.pinBlock = value;
    }

    /**
     * Gets the value of the pinStatus property.
     * 
     */
    public int getPINStatus() {
        return pinStatus;
    }

    /**
     * Sets the value of the pinStatus property.
     * 
     */
    public void setPINStatus(int value) {
        this.pinStatus = value;
    }


    @Override
    public String toString() {
        return "PhoneActivate{" +
                "publicToken='" + publicToken + '\'' +
                ", actionCode='" + actionCode + '\'' +
                ", isLive=" + isLive +
                ", pinBlock='" + pinBlock + '\'' +
                ", pinStatus=" + pinStatus +
                '}';
    }
}
