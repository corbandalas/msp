
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
 *         &lt;element name="Ws_UnLoadResult" type="{http://www.globalprocessing.ae/HyperionWeb}UnLoad"/>
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
    "wsUnLoadResult"
})
@XmlRootElement(name = "Ws_UnLoadResponse")
public class WsUnLoadResponse {

    @XmlElement(name = "Ws_UnLoadResult", required = true)
    protected UnLoad wsUnLoadResult;

    /**
     * Gets the value of the wsUnLoadResult property.
     * 
     * @return
     *     possible object is
     *     {@link UnLoad }
     *     
     */
    public UnLoad getWsUnLoadResult() {
        return wsUnLoadResult;
    }

    /**
     * Sets the value of the wsUnLoadResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link UnLoad }
     *     
     */
    public void setWsUnLoadResult(UnLoad value) {
        this.wsUnLoadResult = value;
    }

}
