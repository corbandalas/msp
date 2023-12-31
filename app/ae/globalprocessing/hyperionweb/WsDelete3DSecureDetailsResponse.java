
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
 *         &lt;element name="Ws_Delete3DSecureDetailsResult" type="{http://www.globalprocessing.ae/HyperionWeb}GPS3DSecure"/>
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
    "wsDelete3DSecureDetailsResult"
})
@XmlRootElement(name = "Ws_Delete3DSecureDetailsResponse")
public class WsDelete3DSecureDetailsResponse {

    @XmlElement(name = "Ws_Delete3DSecureDetailsResult", required = true)
    protected GPS3DSecure wsDelete3DSecureDetailsResult;

    /**
     * Gets the value of the wsDelete3DSecureDetailsResult property.
     * 
     * @return
     *     possible object is
     *     {@link GPS3DSecure }
     *     
     */
    public GPS3DSecure getWsDelete3DSecureDetailsResult() {
        return wsDelete3DSecureDetailsResult;
    }

    /**
     * Sets the value of the wsDelete3DSecureDetailsResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link GPS3DSecure }
     *     
     */
    public void setWsDelete3DSecureDetailsResult(GPS3DSecure value) {
        this.wsDelete3DSecureDetailsResult = value;
    }

}
