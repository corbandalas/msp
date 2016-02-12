
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
 *         &lt;element name="Ws_GiftCard_UpdateLoadSourceResult" type="{http://www.globalprocessing.ae/HyperionWeb}UpdateLoadSrc"/>
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
    "wsGiftCardUpdateLoadSourceResult"
})
@XmlRootElement(name = "Ws_GiftCard_UpdateLoadSourceResponse")
public class WsGiftCardUpdateLoadSourceResponse {

    @XmlElement(name = "Ws_GiftCard_UpdateLoadSourceResult", required = true)
    protected UpdateLoadSrc wsGiftCardUpdateLoadSourceResult;

    /**
     * Gets the value of the wsGiftCardUpdateLoadSourceResult property.
     * 
     * @return
     *     possible object is
     *     {@link UpdateLoadSrc }
     *     
     */
    public UpdateLoadSrc getWsGiftCardUpdateLoadSourceResult() {
        return wsGiftCardUpdateLoadSourceResult;
    }

    /**
     * Sets the value of the wsGiftCardUpdateLoadSourceResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link UpdateLoadSrc }
     *     
     */
    public void setWsGiftCardUpdateLoadSourceResult(UpdateLoadSrc value) {
        this.wsGiftCardUpdateLoadSourceResult = value;
    }

}
