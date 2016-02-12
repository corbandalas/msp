
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
 *         &lt;element name="Ws_GiftCard_UnLoadResult" type="{http://www.globalprocessing.ae/HyperionWeb}UnLoad"/>
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
    "wsGiftCardUnLoadResult"
})
@XmlRootElement(name = "Ws_GiftCard_UnLoadResponse")
public class WsGiftCardUnLoadResponse {

    @XmlElement(name = "Ws_GiftCard_UnLoadResult", required = true)
    protected UnLoad wsGiftCardUnLoadResult;

    /**
     * Gets the value of the wsGiftCardUnLoadResult property.
     * 
     * @return
     *     possible object is
     *     {@link UnLoad }
     *     
     */
    public UnLoad getWsGiftCardUnLoadResult() {
        return wsGiftCardUnLoadResult;
    }

    /**
     * Sets the value of the wsGiftCardUnLoadResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link UnLoad }
     *     
     */
    public void setWsGiftCardUnLoadResult(UnLoad value) {
        this.wsGiftCardUnLoadResult = value;
    }

}
