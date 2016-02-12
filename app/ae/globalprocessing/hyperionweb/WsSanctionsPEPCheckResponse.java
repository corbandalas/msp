
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
 *         &lt;element name="Ws_Sanctions_PEP_CheckResult" type="{http://www.globalprocessing.ae/HyperionWeb}Sanctions_PEP"/>
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
    "wsSanctionsPEPCheckResult"
})
@XmlRootElement(name = "Ws_Sanctions_PEP_CheckResponse")
public class WsSanctionsPEPCheckResponse {

    @XmlElement(name = "Ws_Sanctions_PEP_CheckResult", required = true)
    protected SanctionsPEP wsSanctionsPEPCheckResult;

    /**
     * Gets the value of the wsSanctionsPEPCheckResult property.
     * 
     * @return
     *     possible object is
     *     {@link SanctionsPEP }
     *     
     */
    public SanctionsPEP getWsSanctionsPEPCheckResult() {
        return wsSanctionsPEPCheckResult;
    }

    /**
     * Sets the value of the wsSanctionsPEPCheckResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link SanctionsPEP }
     *     
     */
    public void setWsSanctionsPEPCheckResult(SanctionsPEP value) {
        this.wsSanctionsPEPCheckResult = value;
    }

}
