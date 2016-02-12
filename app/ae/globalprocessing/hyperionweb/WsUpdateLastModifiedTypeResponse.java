
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
 *         &lt;element name="Ws_UpdateLastModifiedTypeResult" type="{http://www.globalprocessing.ae/HyperionWeb}GPS3DSecure"/>
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
    "wsUpdateLastModifiedTypeResult"
})
@XmlRootElement(name = "Ws_UpdateLastModifiedTypeResponse")
public class WsUpdateLastModifiedTypeResponse {

    @XmlElement(name = "Ws_UpdateLastModifiedTypeResult", required = true)
    protected GPS3DSecure wsUpdateLastModifiedTypeResult;

    /**
     * Gets the value of the wsUpdateLastModifiedTypeResult property.
     * 
     * @return
     *     possible object is
     *     {@link GPS3DSecure }
     *     
     */
    public GPS3DSecure getWsUpdateLastModifiedTypeResult() {
        return wsUpdateLastModifiedTypeResult;
    }

    /**
     * Sets the value of the wsUpdateLastModifiedTypeResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link GPS3DSecure }
     *     
     */
    public void setWsUpdateLastModifiedTypeResult(GPS3DSecure value) {
        this.wsUpdateLastModifiedTypeResult = value;
    }

}
