
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
 *         &lt;element name="Ws_GAH_GiftCard_ActivateResult" type="{http://www.globalprocessing.ae/HyperionWeb}Activate"/>
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
    "wsGAHGiftCardActivateResult"
})
@XmlRootElement(name = "Ws_GAH_GiftCard_ActivateResponse")
public class WsGAHGiftCardActivateResponse {

    @XmlElement(name = "Ws_GAH_GiftCard_ActivateResult", required = true)
    protected Activate wsGAHGiftCardActivateResult;

    /**
     * Gets the value of the wsGAHGiftCardActivateResult property.
     * 
     * @return
     *     possible object is
     *     {@link Activate }
     *     
     */
    public Activate getWsGAHGiftCardActivateResult() {
        return wsGAHGiftCardActivateResult;
    }

    /**
     * Sets the value of the wsGAHGiftCardActivateResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link Activate }
     *     
     */
    public void setWsGAHGiftCardActivateResult(Activate value) {
        this.wsGAHGiftCardActivateResult = value;
    }

}
