
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
 *         &lt;element name="WS_PinControlResult" type="{http://www.globalprocessing.ae/HyperionWeb}PINControl"/>
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
    "wsPinControlResult"
})
@XmlRootElement(name = "WS_PinControlResponse")
public class WSPinControlResponse {

    @XmlElement(name = "WS_PinControlResult", required = true)
    protected PINControl wsPinControlResult;

    /**
     * Gets the value of the wsPinControlResult property.
     * 
     * @return
     *     possible object is
     *     {@link PINControl }
     *     
     */
    public PINControl getWSPinControlResult() {
        return wsPinControlResult;
    }

    /**
     * Sets the value of the wsPinControlResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link PINControl }
     *     
     */
    public void setWSPinControlResult(PINControl value) {
        this.wsPinControlResult = value;
    }

}
