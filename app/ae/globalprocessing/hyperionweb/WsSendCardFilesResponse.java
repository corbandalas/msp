
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
 *         &lt;element name="Ws_Send_CardFilesResult" type="{http://www.globalprocessing.ae/HyperionWeb}Card_Params"/>
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
    "wsSendCardFilesResult"
})
@XmlRootElement(name = "Ws_Send_CardFilesResponse")
public class WsSendCardFilesResponse {

    @XmlElement(name = "Ws_Send_CardFilesResult", required = true)
    protected CardParams wsSendCardFilesResult;

    /**
     * Gets the value of the wsSendCardFilesResult property.
     * 
     * @return
     *     possible object is
     *     {@link CardParams }
     *     
     */
    public CardParams getWsSendCardFilesResult() {
        return wsSendCardFilesResult;
    }

    /**
     * Sets the value of the wsSendCardFilesResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link CardParams }
     *     
     */
    public void setWsSendCardFilesResult(CardParams value) {
        this.wsSendCardFilesResult = value;
    }

}
