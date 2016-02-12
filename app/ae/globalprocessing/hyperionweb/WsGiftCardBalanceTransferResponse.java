
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
 *         &lt;element name="Ws_GiftCard_BalanceTransferResult" type="{http://www.globalprocessing.ae/HyperionWeb}BalanceTransfer"/>
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
    "wsGiftCardBalanceTransferResult"
})
@XmlRootElement(name = "Ws_GiftCard_BalanceTransferResponse")
public class WsGiftCardBalanceTransferResponse {

    @XmlElement(name = "Ws_GiftCard_BalanceTransferResult", required = true)
    protected BalanceTransfer wsGiftCardBalanceTransferResult;

    /**
     * Gets the value of the wsGiftCardBalanceTransferResult property.
     * 
     * @return
     *     possible object is
     *     {@link BalanceTransfer }
     *     
     */
    public BalanceTransfer getWsGiftCardBalanceTransferResult() {
        return wsGiftCardBalanceTransferResult;
    }

    /**
     * Sets the value of the wsGiftCardBalanceTransferResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link BalanceTransfer }
     *     
     */
    public void setWsGiftCardBalanceTransferResult(BalanceTransfer value) {
        this.wsGiftCardBalanceTransferResult = value;
    }

}
