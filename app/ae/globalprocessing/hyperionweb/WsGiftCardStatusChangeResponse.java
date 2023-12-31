
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
 *         &lt;element name="Ws_GiftCard_StatusChangeResult" type="{http://www.globalprocessing.ae/HyperionWeb}StatusChange"/>
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
    "wsGiftCardStatusChangeResult"
})
@XmlRootElement(name = "Ws_GiftCard_StatusChangeResponse")
public class WsGiftCardStatusChangeResponse {

    @XmlElement(name = "Ws_GiftCard_StatusChangeResult", required = true)
    protected StatusChange wsGiftCardStatusChangeResult;

    /**
     * Gets the value of the wsGiftCardStatusChangeResult property.
     * 
     * @return
     *     possible object is
     *     {@link StatusChange }
     *     
     */
    public StatusChange getWsGiftCardStatusChangeResult() {
        return wsGiftCardStatusChangeResult;
    }

    /**
     * Sets the value of the wsGiftCardStatusChangeResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link StatusChange }
     *     
     */
    public void setWsGiftCardStatusChangeResult(StatusChange value) {
        this.wsGiftCardStatusChangeResult = value;
    }

}
