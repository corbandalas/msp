
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
 *         &lt;element name="Ws_GiftCard_Activate_Load_ProductTpye_CPResult" type="{http://www.globalprocessing.ae/HyperionWeb}ActivateAndLoad"/>
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
    "wsGiftCardActivateLoadProductTpyeCPResult"
})
@XmlRootElement(name = "Ws_GiftCard_Activate_Load_ProductTpye_CPResponse")
public class WsGiftCardActivateLoadProductTpyeCPResponse {

    @XmlElement(name = "Ws_GiftCard_Activate_Load_ProductTpye_CPResult", required = true)
    protected ActivateAndLoad wsGiftCardActivateLoadProductTpyeCPResult;

    /**
     * Gets the value of the wsGiftCardActivateLoadProductTpyeCPResult property.
     * 
     * @return
     *     possible object is
     *     {@link ActivateAndLoad }
     *     
     */
    public ActivateAndLoad getWsGiftCardActivateLoadProductTpyeCPResult() {
        return wsGiftCardActivateLoadProductTpyeCPResult;
    }

    /**
     * Sets the value of the wsGiftCardActivateLoadProductTpyeCPResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link ActivateAndLoad }
     *     
     */
    public void setWsGiftCardActivateLoadProductTpyeCPResult(ActivateAndLoad value) {
        this.wsGiftCardActivateLoadProductTpyeCPResult = value;
    }

}
