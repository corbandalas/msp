
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
 *         &lt;element name="Ws_List_Sanctions_PEP_MatchesResult" type="{http://www.globalprocessing.ae/HyperionWeb}ListSanctionPEPMatches"/>
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
    "wsListSanctionsPEPMatchesResult"
})
@XmlRootElement(name = "Ws_List_Sanctions_PEP_MatchesResponse")
public class WsListSanctionsPEPMatchesResponse {

    @XmlElement(name = "Ws_List_Sanctions_PEP_MatchesResult", required = true)
    protected ListSanctionPEPMatches wsListSanctionsPEPMatchesResult;

    /**
     * Gets the value of the wsListSanctionsPEPMatchesResult property.
     * 
     * @return
     *     possible object is
     *     {@link ListSanctionPEPMatches }
     *     
     */
    public ListSanctionPEPMatches getWsListSanctionsPEPMatchesResult() {
        return wsListSanctionsPEPMatchesResult;
    }

    /**
     * Sets the value of the wsListSanctionsPEPMatchesResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link ListSanctionPEPMatches }
     *     
     */
    public void setWsListSanctionsPEPMatchesResult(ListSanctionPEPMatches value) {
        this.wsListSanctionsPEPMatchesResult = value;
    }

}
