
package ae.globalprocessing.hyperionweb;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ConvertCard complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ConvertCard">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ActionCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PublicToken" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ConvertDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ConvertCard", propOrder = {
    "actionCode",
    "publicToken",
    "convertDate"
})
public class ConvertCard {

    @XmlElement(name = "ActionCode")
    protected String actionCode;
    @XmlElement(name = "PublicToken")
    protected String publicToken;
    @XmlElement(name = "ConvertDate")
    protected String convertDate;

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
     * Gets the value of the convertDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getConvertDate() {
        return convertDate;
    }

    /**
     * Sets the value of the convertDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setConvertDate(String value) {
        this.convertDate = value;
    }

}
