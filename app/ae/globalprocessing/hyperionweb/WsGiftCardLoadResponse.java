
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
 *         &lt;element name="Ws_GiftCard_LoadResult" type="{http://www.globalprocessing.ae/HyperionWeb}LoadCard"/>
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
    "wsGiftCardLoadResult"
})
@XmlRootElement(name = "Ws_GiftCard_LoadResponse")
public class WsGiftCardLoadResponse {

    @XmlElement(name = "Ws_GiftCard_LoadResult", required = true)
    protected LoadCard wsGiftCardLoadResult;

    /**
     * Gets the value of the wsGiftCardLoadResult property.
     * 
     * @return
     *     possible object is
     *     {@link LoadCard }
     *     
     */
    public LoadCard getWsGiftCardLoadResult() {
        return wsGiftCardLoadResult;
    }

    /**
     * Sets the value of the wsGiftCardLoadResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link LoadCard }
     *     
     */
    public void setWsGiftCardLoadResult(LoadCard value) {
        this.wsGiftCardLoadResult = value;
    }

}
