
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
 *         &lt;element name="Ws_GiftCard_CardHolder_Details_EnquiryResult" type="{http://www.globalprocessing.ae/HyperionWeb}CardHolderDetails"/>
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
    "wsGiftCardCardHolderDetailsEnquiryResult"
})
@XmlRootElement(name = "Ws_GiftCard_CardHolder_Details_EnquiryResponse")
public class WsGiftCardCardHolderDetailsEnquiryResponse {

    @XmlElement(name = "Ws_GiftCard_CardHolder_Details_EnquiryResult", required = true)
    protected CardHolderDetails wsGiftCardCardHolderDetailsEnquiryResult;

    /**
     * Gets the value of the wsGiftCardCardHolderDetailsEnquiryResult property.
     * 
     * @return
     *     possible object is
     *     {@link CardHolderDetails }
     *     
     */
    public CardHolderDetails getWsGiftCardCardHolderDetailsEnquiryResult() {
        return wsGiftCardCardHolderDetailsEnquiryResult;
    }

    /**
     * Sets the value of the wsGiftCardCardHolderDetailsEnquiryResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link CardHolderDetails }
     *     
     */
    public void setWsGiftCardCardHolderDetailsEnquiryResult(CardHolderDetails value) {
        this.wsGiftCardCardHolderDetailsEnquiryResult = value;
    }

}
