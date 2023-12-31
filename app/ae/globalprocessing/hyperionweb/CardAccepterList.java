
package ae.globalprocessing.hyperionweb;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for CardAccepterList complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CardAccepterList">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="PublicToken" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
@XmlType(name = "CardAccepterList", propOrder = {
    "publicToken",
    "currentBlackList",
    "currentWhiteList"
})
public class CardAccepterList {

    @XmlElement(name = "PublicToken")
    protected String publicToken;
    @XmlElement(name = "CurrentBlackList")
    protected String currentBlackList;
    @XmlElement(name = "CurrentWhiteList")
    protected String currentWhiteList;

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
