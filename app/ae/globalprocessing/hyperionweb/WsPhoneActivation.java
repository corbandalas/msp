
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
 *         &lt;element name="PAN" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PublicToken" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SecurityCode" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="ActivateIfNot" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="AuthType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
    "pan",
    "publicToken",
    "securityCode",
    "activateIfNot",
    "authType"
})
@XmlRootElement(name = "Ws_Phone_Activation")
public class WsPhoneActivation {

    @XmlElement(name = "PAN")
    protected String pan;
    @XmlElement(name = "PublicToken")
    protected String publicToken;
    @XmlElement(name = "SecurityCode")
    protected int securityCode;
    @XmlElement(name = "ActivateIfNot")
    protected int activateIfNot;
    @XmlElement(name = "AuthType")
    protected String authType;

    /**
     * Gets the value of the pan property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPAN() {
        return pan;
    }

    /**
     * Sets the value of the pan property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPAN(String value) {
        this.pan = value;
    }

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
     * Gets the value of the securityCode property.
     * 
     */
    public int getSecurityCode() {
        return securityCode;
    }

    /**
     * Sets the value of the securityCode property.
     * 
     */
    public void setSecurityCode(int value) {
        this.securityCode = value;
    }

    /**
     * Gets the value of the activateIfNot property.
     * 
     */
    public int getActivateIfNot() {
        return activateIfNot;
    }

    /**
     * Sets the value of the activateIfNot property.
     * 
     */
    public void setActivateIfNot(int value) {
        this.activateIfNot = value;
    }

    /**
     * Gets the value of the authType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAuthType() {
        return authType;
    }

    /**
     * Sets the value of the authType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAuthType(String value) {
        this.authType = value;
    }

}
