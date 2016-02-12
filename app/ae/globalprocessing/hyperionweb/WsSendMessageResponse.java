
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
 *         &lt;element name="Ws_SendMessageResult" type="{http://www.globalprocessing.ae/HyperionWeb}AlertResponse"/>
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
    "wsSendMessageResult"
})
@XmlRootElement(name = "Ws_SendMessageResponse")
public class WsSendMessageResponse {

    @XmlElement(name = "Ws_SendMessageResult", required = true)
    protected AlertResponse wsSendMessageResult;

    /**
     * Gets the value of the wsSendMessageResult property.
     * 
     * @return
     *     possible object is
     *     {@link AlertResponse }
     *     
     */
    public AlertResponse getWsSendMessageResult() {
        return wsSendMessageResult;
    }

    /**
     * Sets the value of the wsSendMessageResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link AlertResponse }
     *     
     */
    public void setWsSendMessageResult(AlertResponse value) {
        this.wsSendMessageResult = value;
    }

}
