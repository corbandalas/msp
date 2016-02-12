
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
 *         &lt;element name="Ws_RemoveBlockedAmt_PostingResult" type="{http://www.globalprocessing.ae/HyperionWeb}RemoveAuth"/>
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
    "wsRemoveBlockedAmtPostingResult"
})
@XmlRootElement(name = "Ws_RemoveBlockedAmt_PostingResponse")
public class WsRemoveBlockedAmtPostingResponse {

    @XmlElement(name = "Ws_RemoveBlockedAmt_PostingResult", required = true)
    protected RemoveAuth wsRemoveBlockedAmtPostingResult;

    /**
     * Gets the value of the wsRemoveBlockedAmtPostingResult property.
     * 
     * @return
     *     possible object is
     *     {@link RemoveAuth }
     *     
     */
    public RemoveAuth getWsRemoveBlockedAmtPostingResult() {
        return wsRemoveBlockedAmtPostingResult;
    }

    /**
     * Sets the value of the wsRemoveBlockedAmtPostingResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link RemoveAuth }
     *     
     */
    public void setWsRemoveBlockedAmtPostingResult(RemoveAuth value) {
        this.wsRemoveBlockedAmtPostingResult = value;
    }

}
