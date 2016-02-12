
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
 *         &lt;element name="Ws_UpdateLoadSourceResult" type="{http://www.globalprocessing.ae/HyperionWeb}UpdateLoadSrc"/>
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
    "wsUpdateLoadSourceResult"
})
@XmlRootElement(name = "Ws_UpdateLoadSourceResponse")
public class WsUpdateLoadSourceResponse {

    @XmlElement(name = "Ws_UpdateLoadSourceResult", required = true)
    protected UpdateLoadSrc wsUpdateLoadSourceResult;

    /**
     * Gets the value of the wsUpdateLoadSourceResult property.
     * 
     * @return
     *     possible object is
     *     {@link UpdateLoadSrc }
     *     
     */
    public UpdateLoadSrc getWsUpdateLoadSourceResult() {
        return wsUpdateLoadSourceResult;
    }

    /**
     * Sets the value of the wsUpdateLoadSourceResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link UpdateLoadSrc }
     *     
     */
    public void setWsUpdateLoadSourceResult(UpdateLoadSrc value) {
        this.wsUpdateLoadSourceResult = value;
    }

}
