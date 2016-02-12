
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
 *         &lt;element name="Ws_GiftCard_Balance_EnquiryResult" type="{http://www.globalprocessing.ae/HyperionWeb}BalanceEnquire"/>
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
    "wsGiftCardBalanceEnquiryResult"
})
@XmlRootElement(name = "Ws_GiftCard_Balance_EnquiryResponse")
public class WsGiftCardBalanceEnquiryResponse {

    @XmlElement(name = "Ws_GiftCard_Balance_EnquiryResult", required = true)
    protected BalanceEnquire wsGiftCardBalanceEnquiryResult;

    /**
     * Gets the value of the wsGiftCardBalanceEnquiryResult property.
     * 
     * @return
     *     possible object is
     *     {@link BalanceEnquire }
     *     
     */
    public BalanceEnquire getWsGiftCardBalanceEnquiryResult() {
        return wsGiftCardBalanceEnquiryResult;
    }

    /**
     * Sets the value of the wsGiftCardBalanceEnquiryResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link BalanceEnquire }
     *     
     */
    public void setWsGiftCardBalanceEnquiryResult(BalanceEnquire value) {
        this.wsGiftCardBalanceEnquiryResult = value;
    }

}
