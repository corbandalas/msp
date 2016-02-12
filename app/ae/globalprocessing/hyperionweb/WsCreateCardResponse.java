
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
 *         &lt;element name="Ws_CreateCardResult" type="{http://www.globalprocessing.ae/HyperionWeb}VirtualCards"/>
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
    "wsCreateCardResult"
})
@XmlRootElement(name = "Ws_CreateCardResponse")
public class WsCreateCardResponse {

    @XmlElement(name = "Ws_CreateCardResult", required = true)
    protected VirtualCards wsCreateCardResult;

    /**
     * Gets the value of the wsCreateCardResult property.
     * 
     * @return
     *     possible object is
     *     {@link VirtualCards }
     *     
     */
    public VirtualCards getWsCreateCardResult() {
        return wsCreateCardResult;
    }

    /**
     * Sets the value of the wsCreateCardResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link VirtualCards }
     *     
     */
    public void setWsCreateCardResult(VirtualCards value) {
        this.wsCreateCardResult = value;
    }

}
