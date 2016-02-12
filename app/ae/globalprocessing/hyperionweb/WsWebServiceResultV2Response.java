
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
 *         &lt;element name="Ws_WebServiceResult_V2Result" type="{http://www.globalprocessing.ae/HyperionWeb}WSResult2"/>
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
    "wsWebServiceResultV2Result"
})
@XmlRootElement(name = "Ws_WebServiceResult_V2Response")
public class WsWebServiceResultV2Response {

    @XmlElement(name = "Ws_WebServiceResult_V2Result", required = true)
    protected WSResult2 wsWebServiceResultV2Result;

    /**
     * Gets the value of the wsWebServiceResultV2Result property.
     * 
     * @return
     *     possible object is
     *     {@link WSResult2 }
     *     
     */
    public WSResult2 getWsWebServiceResultV2Result() {
        return wsWebServiceResultV2Result;
    }

    /**
     * Sets the value of the wsWebServiceResultV2Result property.
     * 
     * @param value
     *     allowed object is
     *     {@link WSResult2 }
     *     
     */
    public void setWsWebServiceResultV2Result(WSResult2 value) {
        this.wsWebServiceResultV2Result = value;
    }

}
