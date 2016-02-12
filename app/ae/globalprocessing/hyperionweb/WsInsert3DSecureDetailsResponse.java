
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
 *         &lt;element name="Ws_Insert3DSecureDetailsResult" type="{http://www.globalprocessing.ae/HyperionWeb}GPS3DSecure"/>
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
    "wsInsert3DSecureDetailsResult"
})
@XmlRootElement(name = "Ws_Insert3DSecureDetailsResponse")
public class WsInsert3DSecureDetailsResponse {

    @XmlElement(name = "Ws_Insert3DSecureDetailsResult", required = true)
    protected GPS3DSecure wsInsert3DSecureDetailsResult;

    /**
     * Gets the value of the wsInsert3DSecureDetailsResult property.
     * 
     * @return
     *     possible object is
     *     {@link GPS3DSecure }
     *     
     */
    public GPS3DSecure getWsInsert3DSecureDetailsResult() {
        return wsInsert3DSecureDetailsResult;
    }

    /**
     * Sets the value of the wsInsert3DSecureDetailsResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link GPS3DSecure }
     *     
     */
    public void setWsInsert3DSecureDetailsResult(GPS3DSecure value) {
        this.wsInsert3DSecureDetailsResult = value;
    }

}
