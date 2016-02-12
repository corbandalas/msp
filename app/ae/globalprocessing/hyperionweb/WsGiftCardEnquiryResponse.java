
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
 *         &lt;element name="Ws_GiftCard_EnquiryResult" type="{http://www.globalprocessing.ae/HyperionWeb}Card"/>
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
    "wsGiftCardEnquiryResult"
})
@XmlRootElement(name = "Ws_GiftCard_EnquiryResponse")
public class WsGiftCardEnquiryResponse {

    @XmlElement(name = "Ws_GiftCard_EnquiryResult", required = true)
    protected Card wsGiftCardEnquiryResult;

    /**
     * Gets the value of the wsGiftCardEnquiryResult property.
     * 
     * @return
     *     possible object is
     *     {@link Card }
     *     
     */
    public Card getWsGiftCardEnquiryResult() {
        return wsGiftCardEnquiryResult;
    }

    /**
     * Sets the value of the wsGiftCardEnquiryResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link Card }
     *     
     */
    public void setWsGiftCardEnquiryResult(Card value) {
        this.wsGiftCardEnquiryResult = value;
    }

}
