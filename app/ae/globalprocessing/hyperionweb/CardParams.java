
package ae.globalprocessing.hyperionweb;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Card_Params complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Card_Params">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="IssCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CustAccount" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Password" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SFTP" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="WSID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ActionCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Card_Params", propOrder = {
    "issCode",
    "custAccount",
    "password",
    "sftp",
    "wsid",
    "actionCode"
})
public class CardParams {

    @XmlElement(name = "IssCode")
    protected String issCode;
    @XmlElement(name = "CustAccount")
    protected String custAccount;
    @XmlElement(name = "Password")
    protected String password;
    @XmlElement(name = "SFTP")
    protected String sftp;
    @XmlElement(name = "WSID")
    protected String wsid;
    @XmlElement(name = "ActionCode")
    protected String actionCode;

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
     * Gets the value of the custAccount property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCustAccount() {
        return custAccount;
    }

    /**
     * Sets the value of the custAccount property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCustAccount(String value) {
        this.custAccount = value;
    }

    /**
     * Gets the value of the password property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets the value of the password property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPassword(String value) {
        this.password = value;
    }

    /**
     * Gets the value of the sftp property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSFTP() {
        return sftp;
    }

    /**
     * Sets the value of the sftp property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSFTP(String value) {
        this.sftp = value;
    }

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

}
