
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
 *         &lt;element name="Ws_GAH_GiftCard_CreateCardResult" type="{http://www.globalprocessing.ae/HyperionWeb}VirtualCard"/>
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
    "wsGAHGiftCardCreateCardResult"
})
@XmlRootElement(name = "Ws_GAH_GiftCard_CreateCardResponse")
public class WsGAHGiftCardCreateCardResponse {

    @XmlElement(name = "Ws_GAH_GiftCard_CreateCardResult", required = true)
    protected VirtualCard wsGAHGiftCardCreateCardResult;

    /**
     * Gets the value of the wsGAHGiftCardCreateCardResult property.
     * 
     * @return
     *     possible object is
     *     {@link VirtualCard }
     *     
     */
    public VirtualCard getWsGAHGiftCardCreateCardResult() {
        return wsGAHGiftCardCreateCardResult;
    }

    /**
     * Sets the value of the wsGAHGiftCardCreateCardResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link VirtualCard }
     *     
     */
    public void setWsGAHGiftCardCreateCardResult(VirtualCard value) {
        this.wsGAHGiftCardCreateCardResult = value;
    }

}
