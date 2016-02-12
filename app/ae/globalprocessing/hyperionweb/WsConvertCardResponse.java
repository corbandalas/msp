
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
 *         &lt;element name="Ws_Convert_CardResult" type="{http://www.globalprocessing.ae/HyperionWeb}ConvertCard"/>
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
    "wsConvertCardResult"
})
@XmlRootElement(name = "Ws_Convert_CardResponse")
public class WsConvertCardResponse {

    @XmlElement(name = "Ws_Convert_CardResult", required = true)
    protected ConvertCard wsConvertCardResult;

    /**
     * Gets the value of the wsConvertCardResult property.
     * 
     * @return
     *     possible object is
     *     {@link ConvertCard }
     *     
     */
    public ConvertCard getWsConvertCardResult() {
        return wsConvertCardResult;
    }

    /**
     * Sets the value of the wsConvertCardResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link ConvertCard }
     *     
     */
    public void setWsConvertCardResult(ConvertCard value) {
        this.wsConvertCardResult = value;
    }

}
