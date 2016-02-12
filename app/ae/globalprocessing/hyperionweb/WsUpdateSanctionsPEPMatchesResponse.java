
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
 *         &lt;element name="Ws_Update_Sanctions_PEP_MatchesResult" type="{http://www.globalprocessing.ae/HyperionWeb}UpdateSanctionPEP"/>
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
    "wsUpdateSanctionsPEPMatchesResult"
})
@XmlRootElement(name = "Ws_Update_Sanctions_PEP_MatchesResponse")
public class WsUpdateSanctionsPEPMatchesResponse {

    @XmlElement(name = "Ws_Update_Sanctions_PEP_MatchesResult", required = true)
    protected UpdateSanctionPEP wsUpdateSanctionsPEPMatchesResult;

    /**
     * Gets the value of the wsUpdateSanctionsPEPMatchesResult property.
     * 
     * @return
     *     possible object is
     *     {@link UpdateSanctionPEP }
     *     
     */
    public UpdateSanctionPEP getWsUpdateSanctionsPEPMatchesResult() {
        return wsUpdateSanctionsPEPMatchesResult;
    }

    /**
     * Sets the value of the wsUpdateSanctionsPEPMatchesResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link UpdateSanctionPEP }
     *     
     */
    public void setWsUpdateSanctionsPEPMatchesResult(UpdateSanctionPEP value) {
        this.wsUpdateSanctionsPEPMatchesResult = value;
    }

}
