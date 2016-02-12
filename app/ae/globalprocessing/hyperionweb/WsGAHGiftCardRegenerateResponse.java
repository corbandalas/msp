
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
 *         &lt;element name="Ws_GAH_GiftCard_RegenerateResult" type="{http://www.globalprocessing.ae/HyperionWeb}Regenerate"/>
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
    "wsGAHGiftCardRegenerateResult"
})
@XmlRootElement(name = "Ws_GAH_GiftCard_RegenerateResponse")
public class WsGAHGiftCardRegenerateResponse {

    @XmlElement(name = "Ws_GAH_GiftCard_RegenerateResult", required = true)
    protected Regenerate wsGAHGiftCardRegenerateResult;

    /**
     * Gets the value of the wsGAHGiftCardRegenerateResult property.
     * 
     * @return
     *     possible object is
     *     {@link Regenerate }
     *     
     */
    public Regenerate getWsGAHGiftCardRegenerateResult() {
        return wsGAHGiftCardRegenerateResult;
    }

    /**
     * Sets the value of the wsGAHGiftCardRegenerateResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link Regenerate }
     *     
     */
    public void setWsGAHGiftCardRegenerateResult(Regenerate value) {
        this.wsGAHGiftCardRegenerateResult = value;
    }

}
