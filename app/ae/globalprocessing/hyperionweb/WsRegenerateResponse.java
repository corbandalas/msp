
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
 *         &lt;element name="Ws_RegenerateResult" type="{http://www.globalprocessing.ae/HyperionWeb}Regenerate"/>
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
    "wsRegenerateResult"
})
@XmlRootElement(name = "Ws_RegenerateResponse")
public class WsRegenerateResponse {

    @XmlElement(name = "Ws_RegenerateResult", required = true)
    protected Regenerate wsRegenerateResult;

    /**
     * Gets the value of the wsRegenerateResult property.
     * 
     * @return
     *     possible object is
     *     {@link Regenerate }
     *     
     */
    public Regenerate getWsRegenerateResult() {
        return wsRegenerateResult;
    }

    /**
     * Sets the value of the wsRegenerateResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link Regenerate }
     *     
     */
    public void setWsRegenerateResult(Regenerate value) {
        this.wsRegenerateResult = value;
    }

}
