
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
 *         &lt;element name="Ws_GiftCard_UnLoad_StatusChangeResult" type="{http://www.globalprocessing.ae/HyperionWeb}UnLoad"/>
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
    "wsGiftCardUnLoadStatusChangeResult"
})
@XmlRootElement(name = "Ws_GiftCard_UnLoad_StatusChangeResponse")
public class WsGiftCardUnLoadStatusChangeResponse {

    @XmlElement(name = "Ws_GiftCard_UnLoad_StatusChangeResult", required = true)
    protected UnLoad wsGiftCardUnLoadStatusChangeResult;

    /**
     * Gets the value of the wsGiftCardUnLoadStatusChangeResult property.
     * 
     * @return
     *     possible object is
     *     {@link UnLoad }
     *     
     */
    public UnLoad getWsGiftCardUnLoadStatusChangeResult() {
        return wsGiftCardUnLoadStatusChangeResult;
    }

    /**
     * Sets the value of the wsGiftCardUnLoadStatusChangeResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link UnLoad }
     *     
     */
    public void setWsGiftCardUnLoadStatusChangeResult(UnLoad value) {
        this.wsGiftCardUnLoadStatusChangeResult = value;
    }

}
