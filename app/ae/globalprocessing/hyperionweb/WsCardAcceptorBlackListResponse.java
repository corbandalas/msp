
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
 *         &lt;element name="Ws_CardAcceptorBlackListResult" type="{http://www.globalprocessing.ae/HyperionWeb}CardAcceptorBlackList"/>
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
    "wsCardAcceptorBlackListResult"
})
@XmlRootElement(name = "Ws_CardAcceptorBlackListResponse")
public class WsCardAcceptorBlackListResponse {

    @XmlElement(name = "Ws_CardAcceptorBlackListResult", required = true)
    protected CardAcceptorBlackList wsCardAcceptorBlackListResult;

    /**
     * Gets the value of the wsCardAcceptorBlackListResult property.
     * 
     * @return
     *     possible object is
     *     {@link CardAcceptorBlackList }
     *     
     */
    public CardAcceptorBlackList getWsCardAcceptorBlackListResult() {
        return wsCardAcceptorBlackListResult;
    }

    /**
     * Sets the value of the wsCardAcceptorBlackListResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link CardAcceptorBlackList }
     *     
     */
    public void setWsCardAcceptorBlackListResult(CardAcceptorBlackList value) {
        this.wsCardAcceptorBlackListResult = value;
    }

}
