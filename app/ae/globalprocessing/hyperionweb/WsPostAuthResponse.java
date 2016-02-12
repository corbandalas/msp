
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
 *         &lt;element name="Ws_Post_AuthResult" type="{http://www.globalprocessing.ae/HyperionWeb}PostAuth"/>
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
    "wsPostAuthResult"
})
@XmlRootElement(name = "Ws_Post_AuthResponse")
public class WsPostAuthResponse {

    @XmlElement(name = "Ws_Post_AuthResult", required = true)
    protected PostAuth wsPostAuthResult;

    /**
     * Gets the value of the wsPostAuthResult property.
     * 
     * @return
     *     possible object is
     *     {@link PostAuth }
     *     
     */
    public PostAuth getWsPostAuthResult() {
        return wsPostAuthResult;
    }

    /**
     * Sets the value of the wsPostAuthResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link PostAuth }
     *     
     */
    public void setWsPostAuthResult(PostAuth value) {
        this.wsPostAuthResult = value;
    }

}
