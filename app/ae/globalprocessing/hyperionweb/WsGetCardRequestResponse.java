
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
 *         &lt;element name="Ws_GetCardRequestResult" type="{http://www.globalprocessing.ae/HyperionWeb}CardRequestResponse"/>
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
    "wsGetCardRequestResult"
})
@XmlRootElement(name = "Ws_GetCardRequestResponse")
public class WsGetCardRequestResponse {

    @XmlElement(name = "Ws_GetCardRequestResult", required = true)
    protected CardRequestResponse wsGetCardRequestResult;

    /**
     * Gets the value of the wsGetCardRequestResult property.
     * 
     * @return
     *     possible object is
     *     {@link CardRequestResponse }
     *     
     */
    public CardRequestResponse getWsGetCardRequestResult() {
        return wsGetCardRequestResult;
    }

    /**
     * Sets the value of the wsGetCardRequestResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link CardRequestResponse }
     *     
     */
    public void setWsGetCardRequestResult(CardRequestResponse value) {
        this.wsGetCardRequestResult = value;
    }

}
