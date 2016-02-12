
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
 *         &lt;element name="Ws_Card_BalEnqResult" type="{http://www.globalprocessing.ae/HyperionWeb}CardEnquiry"/>
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
    "wsCardBalEnqResult"
})
@XmlRootElement(name = "Ws_Card_BalEnqResponse")
public class WsCardBalEnqResponse {

    @XmlElement(name = "Ws_Card_BalEnqResult", required = true)
    protected CardEnquiry wsCardBalEnqResult;

    /**
     * Gets the value of the wsCardBalEnqResult property.
     * 
     * @return
     *     possible object is
     *     {@link CardEnquiry }
     *     
     */
    public CardEnquiry getWsCardBalEnqResult() {
        return wsCardBalEnqResult;
    }

    /**
     * Sets the value of the wsCardBalEnqResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link CardEnquiry }
     *     
     */
    public void setWsCardBalEnqResult(CardEnquiry value) {
        this.wsCardBalEnqResult = value;
    }

}
