
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
 *         &lt;element name="Ws_LicenseVerificationResult" type="{http://www.globalprocessing.ae/HyperionWeb}KYC"/>
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
    "wsLicenseVerificationResult"
})
@XmlRootElement(name = "Ws_LicenseVerificationResponse")
public class WsLicenseVerificationResponse {

    @XmlElement(name = "Ws_LicenseVerificationResult", required = true)
    protected KYC wsLicenseVerificationResult;

    /**
     * Gets the value of the wsLicenseVerificationResult property.
     * 
     * @return
     *     possible object is
     *     {@link KYC }
     *     
     */
    public KYC getWsLicenseVerificationResult() {
        return wsLicenseVerificationResult;
    }

    /**
     * Sets the value of the wsLicenseVerificationResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link KYC }
     *     
     */
    public void setWsLicenseVerificationResult(KYC value) {
        this.wsLicenseVerificationResult = value;
    }

}
