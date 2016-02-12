
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
 *         &lt;element name="Ws_GiftCard_Activate_LoadResult" type="{http://www.globalprocessing.ae/HyperionWeb}ActivateAndLoad"/>
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
    "wsGiftCardActivateLoadResult"
})
@XmlRootElement(name = "Ws_GiftCard_Activate_LoadResponse")
public class WsGiftCardActivateLoadResponse {

    @XmlElement(name = "Ws_GiftCard_Activate_LoadResult", required = true)
    protected ActivateAndLoad wsGiftCardActivateLoadResult;

    /**
     * Gets the value of the wsGiftCardActivateLoadResult property.
     * 
     * @return
     *     possible object is
     *     {@link ActivateAndLoad }
     *     
     */
    public ActivateAndLoad getWsGiftCardActivateLoadResult() {
        return wsGiftCardActivateLoadResult;
    }

    /**
     * Sets the value of the wsGiftCardActivateLoadResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link ActivateAndLoad }
     *     
     */
    public void setWsGiftCardActivateLoadResult(ActivateAndLoad value) {
        this.wsGiftCardActivateLoadResult = value;
    }

}
