
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
 *         &lt;element name="Ws_CardAcceptorWhiteListResult" type="{http://www.globalprocessing.ae/HyperionWeb}CardAcceptorWhiteList"/>
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
    "wsCardAcceptorWhiteListResult"
})
@XmlRootElement(name = "Ws_CardAcceptorWhiteListResponse")
public class WsCardAcceptorWhiteListResponse {

    @XmlElement(name = "Ws_CardAcceptorWhiteListResult", required = true)
    protected CardAcceptorWhiteList wsCardAcceptorWhiteListResult;

    /**
     * Gets the value of the wsCardAcceptorWhiteListResult property.
     * 
     * @return
     *     possible object is
     *     {@link CardAcceptorWhiteList }
     *     
     */
    public CardAcceptorWhiteList getWsCardAcceptorWhiteListResult() {
        return wsCardAcceptorWhiteListResult;
    }

    /**
     * Sets the value of the wsCardAcceptorWhiteListResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link CardAcceptorWhiteList }
     *     
     */
    public void setWsCardAcceptorWhiteListResult(CardAcceptorWhiteList value) {
        this.wsCardAcceptorWhiteListResult = value;
    }

}
