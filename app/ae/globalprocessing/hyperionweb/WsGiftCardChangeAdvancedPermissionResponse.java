
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
 *         &lt;element name="Ws_GiftCard_Change_Advanced_PermissionResult" type="{http://www.globalprocessing.ae/HyperionWeb}AdvancePermission"/>
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
    "wsGiftCardChangeAdvancedPermissionResult"
})
@XmlRootElement(name = "Ws_GiftCard_Change_Advanced_PermissionResponse")
public class WsGiftCardChangeAdvancedPermissionResponse {

    @XmlElement(name = "Ws_GiftCard_Change_Advanced_PermissionResult", required = true)
    protected AdvancePermission wsGiftCardChangeAdvancedPermissionResult;

    /**
     * Gets the value of the wsGiftCardChangeAdvancedPermissionResult property.
     * 
     * @return
     *     possible object is
     *     {@link AdvancePermission }
     *     
     */
    public AdvancePermission getWsGiftCardChangeAdvancedPermissionResult() {
        return wsGiftCardChangeAdvancedPermissionResult;
    }

    /**
     * Sets the value of the wsGiftCardChangeAdvancedPermissionResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link AdvancePermission }
     *     
     */
    public void setWsGiftCardChangeAdvancedPermissionResult(AdvancePermission value) {
        this.wsGiftCardChangeAdvancedPermissionResult = value;
    }

}
