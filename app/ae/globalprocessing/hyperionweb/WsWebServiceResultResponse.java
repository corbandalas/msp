
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
 *         &lt;element name="Ws_WebServiceResultResult" type="{http://www.globalprocessing.ae/HyperionWeb}WsResult"/>
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
    "wsWebServiceResultResult"
})
@XmlRootElement(name = "Ws_WebServiceResultResponse")
public class WsWebServiceResultResponse {

    @XmlElement(name = "Ws_WebServiceResultResult", required = true)
    protected WsResult wsWebServiceResultResult;

    /**
     * Gets the value of the wsWebServiceResultResult property.
     * 
     * @return
     *     possible object is
     *     {@link WsResult }
     *     
     */
    public WsResult getWsWebServiceResultResult() {
        return wsWebServiceResultResult;
    }

    /**
     * Sets the value of the wsWebServiceResultResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link WsResult }
     *     
     */
    public void setWsWebServiceResultResult(WsResult value) {
        this.wsWebServiceResultResult = value;
    }

}
