
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
 *         &lt;element name="Ws_GAH_GiftCard_LoadResult" type="{http://www.globalprocessing.ae/HyperionWeb}LoadCard"/>
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
    "wsGAHGiftCardLoadResult"
})
@XmlRootElement(name = "Ws_GAH_GiftCard_LoadResponse")
public class WsGAHGiftCardLoadResponse {

    @XmlElement(name = "Ws_GAH_GiftCard_LoadResult", required = true)
    protected LoadCard wsGAHGiftCardLoadResult;

    /**
     * Gets the value of the wsGAHGiftCardLoadResult property.
     * 
     * @return
     *     possible object is
     *     {@link LoadCard }
     *     
     */
    public LoadCard getWsGAHGiftCardLoadResult() {
        return wsGAHGiftCardLoadResult;
    }

    /**
     * Sets the value of the wsGAHGiftCardLoadResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link LoadCard }
     *     
     */
    public void setWsGAHGiftCardLoadResult(LoadCard value) {
        this.wsGAHGiftCardLoadResult = value;
    }

}
