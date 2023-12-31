
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
 *         &lt;element name="PublicToken" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="RegenType" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="Sms_Required" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="Sms_Content" type="{http://www.w3.org/2001/XMLSchema}int"/>
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
    "publicToken",
    "regenType",
    "smsRequired",
    "smsContent"
})
@XmlRootElement(name = "Ws_Regenerate_CardDetail")
public class WsRegenerateCardDetail {

    @XmlElement(name = "PublicToken")
    protected String publicToken;
    @XmlElement(name = "RegenType")
    protected int regenType;
    @XmlElement(name = "Sms_Required")
    protected int smsRequired;
    @XmlElement(name = "Sms_Content")
    protected int smsContent;

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
     * Gets the value of the regenType property.
     * 
     */
    public int getRegenType() {
        return regenType;
    }

    /**
     * Sets the value of the regenType property.
     * 
     */
    public void setRegenType(int value) {
        this.regenType = value;
    }

    /**
     * Gets the value of the smsRequired property.
     * 
     */
    public int getSmsRequired() {
        return smsRequired;
    }

    /**
     * Sets the value of the smsRequired property.
     * 
     */
    public void setSmsRequired(int value) {
        this.smsRequired = value;
    }

    /**
     * Gets the value of the smsContent property.
     * 
     */
    public int getSmsContent() {
        return smsContent;
    }

    /**
     * Sets the value of the smsContent property.
     * 
     */
    public void setSmsContent(int value) {
        this.smsContent = value;
    }

}
