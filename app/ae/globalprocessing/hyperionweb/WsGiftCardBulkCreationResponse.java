
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
 *         &lt;element name="Ws_GiftCard_BulkCreationResult" type="{http://www.globalprocessing.ae/HyperionWeb}BulkCards"/>
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
    "wsGiftCardBulkCreationResult"
})
@XmlRootElement(name = "Ws_GiftCard_BulkCreationResponse")
public class WsGiftCardBulkCreationResponse {

    @XmlElement(name = "Ws_GiftCard_BulkCreationResult", required = true)
    protected BulkCards wsGiftCardBulkCreationResult;

    /**
     * Gets the value of the wsGiftCardBulkCreationResult property.
     * 
     * @return
     *     possible object is
     *     {@link BulkCards }
     *     
     */
    public BulkCards getWsGiftCardBulkCreationResult() {
        return wsGiftCardBulkCreationResult;
    }

    /**
     * Sets the value of the wsGiftCardBulkCreationResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link BulkCards }
     *     
     */
    public void setWsGiftCardBulkCreationResult(BulkCards value) {
        this.wsGiftCardBulkCreationResult = value;
    }

}
