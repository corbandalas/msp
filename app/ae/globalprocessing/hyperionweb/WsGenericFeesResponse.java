
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
 *         &lt;element name="Ws_Generic_FeesResult" type="{http://www.globalprocessing.ae/HyperionWeb}ApplyFees"/>
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
    "wsGenericFeesResult"
})
@XmlRootElement(name = "Ws_Generic_FeesResponse")
public class WsGenericFeesResponse {

    @XmlElement(name = "Ws_Generic_FeesResult", required = true)
    protected ApplyFees wsGenericFeesResult;

    /**
     * Gets the value of the wsGenericFeesResult property.
     * 
     * @return
     *     possible object is
     *     {@link ApplyFees }
     *     
     */
    public ApplyFees getWsGenericFeesResult() {
        return wsGenericFeesResult;
    }

    /**
     * Sets the value of the wsGenericFeesResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link ApplyFees }
     *     
     */
    public void setWsGenericFeesResult(ApplyFees value) {
        this.wsGenericFeesResult = value;
    }

}
