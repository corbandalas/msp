
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
 *         &lt;element name="ConvertDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Apply_Fee" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="ExpDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
    "convertDate",
    "applyFee",
    "expDate"
})
@XmlRootElement(name = "Ws_GAH_GiftCard_Convert_Card")
public class WsGAHGiftCardConvertCard {

    @XmlElement(name = "PublicToken")
    protected String publicToken;
    @XmlElement(name = "ConvertDate")
    protected String convertDate;
    @XmlElement(name = "Apply_Fee")
    protected int applyFee;
    @XmlElement(name = "ExpDate")
    protected String expDate;

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

    /**
     * Gets the value of the applyFee property.
     * 
     */
    public int getApplyFee() {
        return applyFee;
    }

    /**
     * Sets the value of the applyFee property.
     * 
     */
    public void setApplyFee(int value) {
        this.applyFee = value;
    }

    /**
     * Gets the value of the expDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getExpDate() {
        return expDate;
    }

    /**
     * Sets the value of the expDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setExpDate(String value) {
        this.expDate = value;
    }

}
