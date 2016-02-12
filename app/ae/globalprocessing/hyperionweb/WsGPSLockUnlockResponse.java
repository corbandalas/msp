
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
 *         &lt;element name="Ws_GPS_Lock_UnlockResult" type="{http://www.globalprocessing.ae/HyperionWeb}GPS_Lock_Unlock"/>
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
    "wsGPSLockUnlockResult"
})
@XmlRootElement(name = "Ws_GPS_Lock_UnlockResponse")
public class WsGPSLockUnlockResponse {

    @XmlElement(name = "Ws_GPS_Lock_UnlockResult", required = true)
    protected GPSLockUnlock wsGPSLockUnlockResult;

    /**
     * Gets the value of the wsGPSLockUnlockResult property.
     * 
     * @return
     *     possible object is
     *     {@link GPSLockUnlock }
     *     
     */
    public GPSLockUnlock getWsGPSLockUnlockResult() {
        return wsGPSLockUnlockResult;
    }

    /**
     * Sets the value of the wsGPSLockUnlockResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link GPSLockUnlock }
     *     
     */
    public void setWsGPSLockUnlockResult(GPSLockUnlock value) {
        this.wsGPSLockUnlockResult = value;
    }

}
