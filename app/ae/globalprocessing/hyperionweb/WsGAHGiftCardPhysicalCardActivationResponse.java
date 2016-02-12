
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
 *         &lt;element name="Ws_GAH_GiftCard_PhysicalCard_ActivationResult" type="{http://www.globalprocessing.ae/HyperionWeb}PhysicalCards"/>
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
    "wsGAHGiftCardPhysicalCardActivationResult"
})
@XmlRootElement(name = "Ws_GAH_GiftCard_PhysicalCard_ActivationResponse")
public class WsGAHGiftCardPhysicalCardActivationResponse {

    @XmlElement(name = "Ws_GAH_GiftCard_PhysicalCard_ActivationResult", required = true)
    protected PhysicalCards wsGAHGiftCardPhysicalCardActivationResult;

    /**
     * Gets the value of the wsGAHGiftCardPhysicalCardActivationResult property.
     * 
     * @return
     *     possible object is
     *     {@link PhysicalCards }
     *     
     */
    public PhysicalCards getWsGAHGiftCardPhysicalCardActivationResult() {
        return wsGAHGiftCardPhysicalCardActivationResult;
    }

    /**
     * Sets the value of the wsGAHGiftCardPhysicalCardActivationResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link PhysicalCards }
     *     
     */
    public void setWsGAHGiftCardPhysicalCardActivationResult(PhysicalCards value) {
        this.wsGAHGiftCardPhysicalCardActivationResult = value;
    }

}
