
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
 *         &lt;element name="Ws_Get_Card_ExpireSoonResult" type="{http://www.globalprocessing.ae/HyperionWeb}CardResult" minOccurs="0"/>
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
    "wsGetCardExpireSoonResult"
})
@XmlRootElement(name = "Ws_Get_Card_ExpireSoonResponse")
public class WsGetCardExpireSoonResponse {

    @XmlElement(name = "Ws_Get_Card_ExpireSoonResult")
    protected CardResult wsGetCardExpireSoonResult;

    /**
     * Gets the value of the wsGetCardExpireSoonResult property.
     * 
     * @return
     *     possible object is
     *     {@link CardResult }
     *     
     */
    public CardResult getWsGetCardExpireSoonResult() {
        return wsGetCardExpireSoonResult;
    }

    /**
     * Sets the value of the wsGetCardExpireSoonResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link CardResult }
     *     
     */
    public void setWsGetCardExpireSoonResult(CardResult value) {
        this.wsGetCardExpireSoonResult = value;
    }

}
