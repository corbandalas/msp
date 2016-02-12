
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
 *         &lt;element name="Ws_Client_FxResult" type="{http://www.globalprocessing.ae/HyperionWeb}FxRates"/>
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
    "wsClientFxResult"
})
@XmlRootElement(name = "Ws_Client_FxResponse")
public class WsClientFxResponse {

    @XmlElement(name = "Ws_Client_FxResult", required = true)
    protected FxRates wsClientFxResult;

    /**
     * Gets the value of the wsClientFxResult property.
     * 
     * @return
     *     possible object is
     *     {@link FxRates }
     *     
     */
    public FxRates getWsClientFxResult() {
        return wsClientFxResult;
    }

    /**
     * Sets the value of the wsClientFxResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link FxRates }
     *     
     */
    public void setWsClientFxResult(FxRates value) {
        this.wsClientFxResult = value;
    }

}
