
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
 *         &lt;element name="Ws_AddressMatchCheckingResult" type="{http://www.globalprocessing.ae/HyperionWeb}KYC"/>
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
    "wsAddressMatchCheckingResult"
})
@XmlRootElement(name = "Ws_AddressMatchCheckingResponse")
public class WsAddressMatchCheckingResponse {

    @XmlElement(name = "Ws_AddressMatchCheckingResult", required = true)
    protected KYC wsAddressMatchCheckingResult;

    /**
     * Gets the value of the wsAddressMatchCheckingResult property.
     * 
     * @return
     *     possible object is
     *     {@link KYC }
     *     
     */
    public KYC getWsAddressMatchCheckingResult() {
        return wsAddressMatchCheckingResult;
    }

    /**
     * Sets the value of the wsAddressMatchCheckingResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link KYC }
     *     
     */
    public void setWsAddressMatchCheckingResult(KYC value) {
        this.wsAddressMatchCheckingResult = value;
    }

}
