
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
 *         &lt;element name="Ws_GiftCard_WebServiceResultResult" type="{http://www.globalprocessing.ae/HyperionWeb}WsResult"/>
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
    "wsGiftCardWebServiceResultResult"
})
@XmlRootElement(name = "Ws_GiftCard_WebServiceResultResponse")
public class WsGiftCardWebServiceResultResponse {

    @XmlElement(name = "Ws_GiftCard_WebServiceResultResult", required = true)
    protected WsResult wsGiftCardWebServiceResultResult;

    /**
     * Gets the value of the wsGiftCardWebServiceResultResult property.
     * 
     * @return
     *     possible object is
     *     {@link WsResult }
     *     
     */
    public WsResult getWsGiftCardWebServiceResultResult() {
        return wsGiftCardWebServiceResultResult;
    }

    /**
     * Sets the value of the wsGiftCardWebServiceResultResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link WsResult }
     *     
     */
    public void setWsGiftCardWebServiceResultResult(WsResult value) {
        this.wsGiftCardWebServiceResultResult = value;
    }

}
