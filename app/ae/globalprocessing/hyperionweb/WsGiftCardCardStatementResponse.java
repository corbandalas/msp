
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
 *         &lt;element name="Ws_GiftCard_Card_StatementResult" type="{http://www.globalprocessing.ae/HyperionWeb}CardStatement"/>
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
    "wsGiftCardCardStatementResult"
})
@XmlRootElement(name = "Ws_GiftCard_Card_StatementResponse")
public class WsGiftCardCardStatementResponse {

    @XmlElement(name = "Ws_GiftCard_Card_StatementResult", required = true)
    protected CardStatement wsGiftCardCardStatementResult;

    /**
     * Gets the value of the wsGiftCardCardStatementResult property.
     * 
     * @return
     *     possible object is
     *     {@link CardStatement }
     *     
     */
    public CardStatement getWsGiftCardCardStatementResult() {
        return wsGiftCardCardStatementResult;
    }

    /**
     * Sets the value of the wsGiftCardCardStatementResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link CardStatement }
     *     
     */
    public void setWsGiftCardCardStatementResult(CardStatement value) {
        this.wsGiftCardCardStatementResult = value;
    }

}
