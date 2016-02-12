
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
 *         &lt;element name="Ws_GetCardRequestStatusResult" type="{http://www.globalprocessing.ae/HyperionWeb}CardRequestStatus"/>
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
    "wsGetCardRequestStatusResult"
})
@XmlRootElement(name = "Ws_GetCardRequestStatusResponse")
public class WsGetCardRequestStatusResponse {

    @XmlElement(name = "Ws_GetCardRequestStatusResult", required = true)
    protected CardRequestStatus wsGetCardRequestStatusResult;

    /**
     * Gets the value of the wsGetCardRequestStatusResult property.
     * 
     * @return
     *     possible object is
     *     {@link CardRequestStatus }
     *     
     */
    public CardRequestStatus getWsGetCardRequestStatusResult() {
        return wsGetCardRequestStatusResult;
    }

    /**
     * Sets the value of the wsGetCardRequestStatusResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link CardRequestStatus }
     *     
     */
    public void setWsGetCardRequestStatusResult(CardRequestStatus value) {
        this.wsGetCardRequestStatusResult = value;
    }

}
