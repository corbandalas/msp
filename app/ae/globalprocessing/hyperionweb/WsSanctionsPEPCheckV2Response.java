
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
 *         &lt;element name="Ws_Sanctions_PEP_Check_V2Result" type="{http://www.globalprocessing.ae/HyperionWeb}Sanctions_PEP_V2"/>
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
    "wsSanctionsPEPCheckV2Result"
})
@XmlRootElement(name = "Ws_Sanctions_PEP_Check_V2Response")
public class WsSanctionsPEPCheckV2Response {

    @XmlElement(name = "Ws_Sanctions_PEP_Check_V2Result", required = true)
    protected SanctionsPEPV2 wsSanctionsPEPCheckV2Result;

    /**
     * Gets the value of the wsSanctionsPEPCheckV2Result property.
     * 
     * @return
     *     possible object is
     *     {@link SanctionsPEPV2 }
     *     
     */
    public SanctionsPEPV2 getWsSanctionsPEPCheckV2Result() {
        return wsSanctionsPEPCheckV2Result;
    }

    /**
     * Sets the value of the wsSanctionsPEPCheckV2Result property.
     * 
     * @param value
     *     allowed object is
     *     {@link SanctionsPEPV2 }
     *     
     */
    public void setWsSanctionsPEPCheckV2Result(SanctionsPEPV2 value) {
        this.wsSanctionsPEPCheckV2Result = value;
    }

}
