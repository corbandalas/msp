
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
 *         &lt;element name="Ws_Phone_ActivationResult" type="{http://www.globalprocessing.ae/HyperionWeb}PhoneActivate"/>
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
    "wsPhoneActivationResult"
})
@XmlRootElement(name = "Ws_Phone_ActivationResponse")
public class WsPhoneActivationResponse {

    @XmlElement(name = "Ws_Phone_ActivationResult", required = true)
    protected PhoneActivate wsPhoneActivationResult;

    /**
     * Gets the value of the wsPhoneActivationResult property.
     * 
     * @return
     *     possible object is
     *     {@link PhoneActivate }
     *     
     */
    public PhoneActivate getWsPhoneActivationResult() {
        return wsPhoneActivationResult;
    }

    /**
     * Sets the value of the wsPhoneActivationResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link PhoneActivate }
     *     
     */
    public void setWsPhoneActivationResult(PhoneActivate value) {
        this.wsPhoneActivationResult = value;
    }

}
