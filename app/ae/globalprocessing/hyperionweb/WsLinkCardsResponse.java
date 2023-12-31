
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
 *         &lt;element name="Ws_Link_CardsResult" type="{http://www.globalprocessing.ae/HyperionWeb}LinkCard"/>
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
    "wsLinkCardsResult"
})
@XmlRootElement(name = "Ws_Link_CardsResponse")
public class WsLinkCardsResponse {

    @XmlElement(name = "Ws_Link_CardsResult", required = true)
    protected LinkCard wsLinkCardsResult;

    /**
     * Gets the value of the wsLinkCardsResult property.
     * 
     * @return
     *     possible object is
     *     {@link LinkCard }
     *     
     */
    public LinkCard getWsLinkCardsResult() {
        return wsLinkCardsResult;
    }

    /**
     * Sets the value of the wsLinkCardsResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link LinkCard }
     *     
     */
    public void setWsLinkCardsResult(LinkCard value) {
        this.wsLinkCardsResult = value;
    }

}
