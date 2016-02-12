
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
 *         &lt;element name="Ws_PassportVerificationResult" type="{http://www.globalprocessing.ae/HyperionWeb}KYC"/>
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
    "wsPassportVerificationResult"
})
@XmlRootElement(name = "Ws_PassportVerificationResponse")
public class WsPassportVerificationResponse {

    @XmlElement(name = "Ws_PassportVerificationResult", required = true)
    protected KYC wsPassportVerificationResult;

    /**
     * Gets the value of the wsPassportVerificationResult property.
     * 
     * @return
     *     possible object is
     *     {@link KYC }
     *     
     */
    public KYC getWsPassportVerificationResult() {
        return wsPassportVerificationResult;
    }

    /**
     * Sets the value of the wsPassportVerificationResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link KYC }
     *     
     */
    public void setWsPassportVerificationResult(KYC value) {
        this.wsPassportVerificationResult = value;
    }

}
