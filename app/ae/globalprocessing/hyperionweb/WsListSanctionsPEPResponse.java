//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.7 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2015.12.16 at 11:33:22 PM MSK 
//


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
 *         &lt;element name="Ws_List_Sanctions_PEPResult" type="{http://www.globalprocessing.ae/HyperionWeb}ListSanctionPEP"/>
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
    "wsListSanctionsPEPResult"
})
@XmlRootElement(name = "Ws_List_Sanctions_PEPResponse")
public class WsListSanctionsPEPResponse {

    @XmlElement(name = "Ws_List_Sanctions_PEPResult", required = true)
    protected ListSanctionPEP wsListSanctionsPEPResult;

    /**
     * Gets the value of the wsListSanctionsPEPResult property.
     * 
     * @return
     *     possible object is
     *     {@link ListSanctionPEP }
     *     
     */
    public ListSanctionPEP getWsListSanctionsPEPResult() {
        return wsListSanctionsPEPResult;
    }

    /**
     * Sets the value of the wsListSanctionsPEPResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link ListSanctionPEP }
     *     
     */
    public void setWsListSanctionsPEPResult(ListSanctionPEP value) {
        this.wsListSanctionsPEPResult = value;
    }

}
