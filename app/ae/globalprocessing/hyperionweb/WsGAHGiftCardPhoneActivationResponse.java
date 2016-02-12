
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
 *         &lt;element name="Ws_GAH_GiftCard_Phone_ActivationResult" type="{http://www.globalprocessing.ae/HyperionWeb}PhoneActivate"/>
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
    "wsGAHGiftCardPhoneActivationResult"
})
@XmlRootElement(name = "Ws_GAH_GiftCard_Phone_ActivationResponse")
public class WsGAHGiftCardPhoneActivationResponse {

    @XmlElement(name = "Ws_GAH_GiftCard_Phone_ActivationResult", required = true)
    protected PhoneActivate wsGAHGiftCardPhoneActivationResult;

    /**
     * Gets the value of the wsGAHGiftCardPhoneActivationResult property.
     * 
     * @return
     *     possible object is
     *     {@link PhoneActivate }
     *     
     */
    public PhoneActivate getWsGAHGiftCardPhoneActivationResult() {
        return wsGAHGiftCardPhoneActivationResult;
    }

    /**
     * Sets the value of the wsGAHGiftCardPhoneActivationResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link PhoneActivate }
     *     
     */
    public void setWsGAHGiftCardPhoneActivationResult(PhoneActivate value) {
        this.wsGAHGiftCardPhoneActivationResult = value;
    }

}
