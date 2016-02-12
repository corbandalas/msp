
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
 *         &lt;element name="Ws_GiftCard_Generic_FeesResult" type="{http://www.globalprocessing.ae/HyperionWeb}ApplyFees"/>
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
    "wsGiftCardGenericFeesResult"
})
@XmlRootElement(name = "Ws_GiftCard_Generic_FeesResponse")
public class WsGiftCardGenericFeesResponse {

    @XmlElement(name = "Ws_GiftCard_Generic_FeesResult", required = true)
    protected ApplyFees wsGiftCardGenericFeesResult;

    /**
     * Gets the value of the wsGiftCardGenericFeesResult property.
     * 
     * @return
     *     possible object is
     *     {@link ApplyFees }
     *     
     */
    public ApplyFees getWsGiftCardGenericFeesResult() {
        return wsGiftCardGenericFeesResult;
    }

    /**
     * Sets the value of the wsGiftCardGenericFeesResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link ApplyFees }
     *     
     */
    public void setWsGiftCardGenericFeesResult(ApplyFees value) {
        this.wsGiftCardGenericFeesResult = value;
    }

}
