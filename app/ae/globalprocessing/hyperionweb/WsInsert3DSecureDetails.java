
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
 *         &lt;element name="IssCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Token" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="MemorableName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="MemorablePlace" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="MemorableDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ActivationCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Phone" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
    "issCode",
    "token",
    "memorableName",
    "memorablePlace",
    "memorableDate",
    "activationCode",
    "phone"
})
@XmlRootElement(name = "Ws_Insert3DSecureDetails")
public class WsInsert3DSecureDetails {

    @XmlElement(name = "IssCode")
    protected String issCode;
    @XmlElement(name = "Token")
    protected String token;
    @XmlElement(name = "MemorableName")
    protected String memorableName;
    @XmlElement(name = "MemorablePlace")
    protected String memorablePlace;
    @XmlElement(name = "MemorableDate")
    protected String memorableDate;
    @XmlElement(name = "ActivationCode")
    protected String activationCode;
    @XmlElement(name = "Phone")
    protected String phone;

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
     * Gets the value of the token property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getToken() {
        return token;
    }

    /**
     * Sets the value of the token property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setToken(String value) {
        this.token = value;
    }

    /**
     * Gets the value of the memorableName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMemorableName() {
        return memorableName;
    }

    /**
     * Sets the value of the memorableName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMemorableName(String value) {
        this.memorableName = value;
    }

    /**
     * Gets the value of the memorablePlace property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMemorablePlace() {
        return memorablePlace;
    }

    /**
     * Sets the value of the memorablePlace property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMemorablePlace(String value) {
        this.memorablePlace = value;
    }

    /**
     * Gets the value of the memorableDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMemorableDate() {
        return memorableDate;
    }

    /**
     * Sets the value of the memorableDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMemorableDate(String value) {
        this.memorableDate = value;
    }

    /**
     * Gets the value of the activationCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getActivationCode() {
        return activationCode;
    }

    /**
     * Sets the value of the activationCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setActivationCode(String value) {
        this.activationCode = value;
    }

    /**
     * Gets the value of the phone property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPhone() {
        return phone;
    }

    /**
     * Sets the value of the phone property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPhone(String value) {
        this.phone = value;
    }

}
