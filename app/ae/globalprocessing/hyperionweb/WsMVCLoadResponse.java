
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
 *         &lt;element name="Ws_MVCLoadResult" type="{http://www.globalprocessing.ae/HyperionWeb}MVCLoad"/>
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
    "wsMVCLoadResult"
})
@XmlRootElement(name = "Ws_MVCLoadResponse")
public class WsMVCLoadResponse {

    @XmlElement(name = "Ws_MVCLoadResult", required = true)
    protected MVCLoad wsMVCLoadResult;

    /**
     * Gets the value of the wsMVCLoadResult property.
     * 
     * @return
     *     possible object is
     *     {@link MVCLoad }
     *     
     */
    public MVCLoad getWsMVCLoadResult() {
        return wsMVCLoadResult;
    }

    /**
     * Sets the value of the wsMVCLoadResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link MVCLoad }
     *     
     */
    public void setWsMVCLoadResult(MVCLoad value) {
        this.wsMVCLoadResult = value;
    }

}
