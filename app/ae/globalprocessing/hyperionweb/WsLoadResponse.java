
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
 *         &lt;element name="Ws_LoadResult" type="{http://www.globalprocessing.ae/HyperionWeb}LoadCard"/>
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
    "wsLoadResult"
})
@XmlRootElement(name = "Ws_LoadResponse")
public class WsLoadResponse {

    @XmlElement(name = "Ws_LoadResult", required = true)
    protected LoadCard wsLoadResult;

    /**
     * Gets the value of the wsLoadResult property.
     * 
     * @return
     *     possible object is
     *     {@link LoadCard }
     *     
     */
    public LoadCard getWsLoadResult() {
        return wsLoadResult;
    }

    /**
     * Sets the value of the wsLoadResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link LoadCard }
     *     
     */
    public void setWsLoadResult(LoadCard value) {
        this.wsLoadResult = value;
    }

}
