
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
 *         &lt;element name="Ws_Update3DSecureDetailsResult" type="{http://www.globalprocessing.ae/HyperionWeb}GPS3DSecure"/>
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
    "wsUpdate3DSecureDetailsResult"
})
@XmlRootElement(name = "Ws_Update3DSecureDetailsResponse")
public class WsUpdate3DSecureDetailsResponse {

    @XmlElement(name = "Ws_Update3DSecureDetailsResult", required = true)
    protected GPS3DSecure wsUpdate3DSecureDetailsResult;

    /**
     * Gets the value of the wsUpdate3DSecureDetailsResult property.
     * 
     * @return
     *     possible object is
     *     {@link GPS3DSecure }
     *     
     */
    public GPS3DSecure getWsUpdate3DSecureDetailsResult() {
        return wsUpdate3DSecureDetailsResult;
    }

    /**
     * Sets the value of the wsUpdate3DSecureDetailsResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link GPS3DSecure }
     *     
     */
    public void setWsUpdate3DSecureDetailsResult(GPS3DSecure value) {
        this.wsUpdate3DSecureDetailsResult = value;
    }

}
