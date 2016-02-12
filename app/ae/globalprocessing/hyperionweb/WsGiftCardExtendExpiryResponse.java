
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
 *         &lt;element name="Ws_GiftCard_ExtendExpiryResult" type="{http://www.globalprocessing.ae/HyperionWeb}ExtendExpiry"/>
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
    "wsGiftCardExtendExpiryResult"
})
@XmlRootElement(name = "Ws_GiftCard_ExtendExpiryResponse")
public class WsGiftCardExtendExpiryResponse {

    @XmlElement(name = "Ws_GiftCard_ExtendExpiryResult", required = true)
    protected ExtendExpiry wsGiftCardExtendExpiryResult;

    /**
     * Gets the value of the wsGiftCardExtendExpiryResult property.
     * 
     * @return
     *     possible object is
     *     {@link ExtendExpiry }
     *     
     */
    public ExtendExpiry getWsGiftCardExtendExpiryResult() {
        return wsGiftCardExtendExpiryResult;
    }

    /**
     * Sets the value of the wsGiftCardExtendExpiryResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link ExtendExpiry }
     *     
     */
    public void setWsGiftCardExtendExpiryResult(ExtendExpiry value) {
        this.wsGiftCardExtendExpiryResult = value;
    }

}
