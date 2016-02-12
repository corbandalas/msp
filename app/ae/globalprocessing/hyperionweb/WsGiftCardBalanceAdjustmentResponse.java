
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
 *         &lt;element name="Ws_GiftCard_BalanceAdjustmentResult" type="{http://www.globalprocessing.ae/HyperionWeb}BalanceAdjust"/>
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
    "wsGiftCardBalanceAdjustmentResult"
})
@XmlRootElement(name = "Ws_GiftCard_BalanceAdjustmentResponse")
public class WsGiftCardBalanceAdjustmentResponse {

    @XmlElement(name = "Ws_GiftCard_BalanceAdjustmentResult", required = true)
    protected BalanceAdjust wsGiftCardBalanceAdjustmentResult;

    /**
     * Gets the value of the wsGiftCardBalanceAdjustmentResult property.
     * 
     * @return
     *     possible object is
     *     {@link BalanceAdjust }
     *     
     */
    public BalanceAdjust getWsGiftCardBalanceAdjustmentResult() {
        return wsGiftCardBalanceAdjustmentResult;
    }

    /**
     * Sets the value of the wsGiftCardBalanceAdjustmentResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link BalanceAdjust }
     *     
     */
    public void setWsGiftCardBalanceAdjustmentResult(BalanceAdjust value) {
        this.wsGiftCardBalanceAdjustmentResult = value;
    }

}
