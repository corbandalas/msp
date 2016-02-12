
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
 *         &lt;element name="Ws_GiftCard_PinControlResult" type="{http://www.globalprocessing.ae/HyperionWeb}PIN"/>
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
    "wsGiftCardPinControlResult"
})
@XmlRootElement(name = "Ws_GiftCard_PinControlResponse")
public class WsGiftCardPinControlResponse {

    @XmlElement(name = "Ws_GiftCard_PinControlResult", required = true)
    protected PIN wsGiftCardPinControlResult;

    /**
     * Gets the value of the wsGiftCardPinControlResult property.
     * 
     * @return
     *     possible object is
     *     {@link PIN }
     *     
     */
    public PIN getWsGiftCardPinControlResult() {
        return wsGiftCardPinControlResult;
    }

    /**
     * Sets the value of the wsGiftCardPinControlResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link PIN }
     *     
     */
    public void setWsGiftCardPinControlResult(PIN value) {
        this.wsGiftCardPinControlResult = value;
    }

}
