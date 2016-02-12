
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
 *         &lt;element name="Ws_ActivateResult" type="{http://www.globalprocessing.ae/HyperionWeb}Activate"/>
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
    "wsActivateResult"
})
@XmlRootElement(name = "Ws_ActivateResponse")
public class WsActivateResponse {

    @XmlElement(name = "Ws_ActivateResult", required = true)
    protected Activate wsActivateResult;

    /**
     * Gets the value of the wsActivateResult property.
     * 
     * @return
     *     possible object is
     *     {@link Activate }
     *     
     */
    public Activate getWsActivateResult() {
        return wsActivateResult;
    }

    /**
     * Sets the value of the wsActivateResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link Activate }
     *     
     */
    public void setWsActivateResult(Activate value) {
        this.wsActivateResult = value;
    }

}
