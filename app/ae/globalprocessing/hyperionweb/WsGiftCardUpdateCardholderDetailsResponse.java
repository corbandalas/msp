
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
 *         &lt;element name="Ws_GiftCard_Update_Cardholder_DetailsResult" type="{http://www.globalprocessing.ae/HyperionWeb}CustomerUpdate"/>
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
    "wsGiftCardUpdateCardholderDetailsResult"
})
@XmlRootElement(name = "Ws_GiftCard_Update_Cardholder_DetailsResponse")
public class WsGiftCardUpdateCardholderDetailsResponse {

    @XmlElement(name = "Ws_GiftCard_Update_Cardholder_DetailsResult", required = true)
    protected CustomerUpdate wsGiftCardUpdateCardholderDetailsResult;

    /**
     * Gets the value of the wsGiftCardUpdateCardholderDetailsResult property.
     * 
     * @return
     *     possible object is
     *     {@link CustomerUpdate }
     *     
     */
    public CustomerUpdate getWsGiftCardUpdateCardholderDetailsResult() {
        return wsGiftCardUpdateCardholderDetailsResult;
    }

    /**
     * Sets the value of the wsGiftCardUpdateCardholderDetailsResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link CustomerUpdate }
     *     
     */
    public void setWsGiftCardUpdateCardholderDetailsResult(CustomerUpdate value) {
        this.wsGiftCardUpdateCardholderDetailsResult = value;
    }

}
