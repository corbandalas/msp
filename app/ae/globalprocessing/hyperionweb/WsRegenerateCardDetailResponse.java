
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
 *         &lt;element name="Ws_Regenerate_CardDetailResult" type="{http://www.globalprocessing.ae/HyperionWeb}CardRegenerate"/>
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
    "wsRegenerateCardDetailResult"
})
@XmlRootElement(name = "Ws_Regenerate_CardDetailResponse")
public class WsRegenerateCardDetailResponse {

    @XmlElement(name = "Ws_Regenerate_CardDetailResult", required = true)
    protected CardRegenerate wsRegenerateCardDetailResult;

    /**
     * Gets the value of the wsRegenerateCardDetailResult property.
     * 
     * @return
     *     possible object is
     *     {@link CardRegenerate }
     *     
     */
    public CardRegenerate getWsRegenerateCardDetailResult() {
        return wsRegenerateCardDetailResult;
    }

    /**
     * Sets the value of the wsRegenerateCardDetailResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link CardRegenerate }
     *     
     */
    public void setWsRegenerateCardDetailResult(CardRegenerate value) {
        this.wsRegenerateCardDetailResult = value;
    }

}
