
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
 *         &lt;element name="Ws_Card_Change_Cardacceptor_ListResult" type="{http://www.globalprocessing.ae/HyperionWeb}ChangeCardacceptor"/>
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
    "wsCardChangeCardacceptorListResult"
})
@XmlRootElement(name = "Ws_Card_Change_Cardacceptor_ListResponse")
public class WsCardChangeCardacceptorListResponse {

    @XmlElement(name = "Ws_Card_Change_Cardacceptor_ListResult", required = true)
    protected ChangeCardacceptor wsCardChangeCardacceptorListResult;

    /**
     * Gets the value of the wsCardChangeCardacceptorListResult property.
     * 
     * @return
     *     possible object is
     *     {@link ChangeCardacceptor }
     *     
     */
    public ChangeCardacceptor getWsCardChangeCardacceptorListResult() {
        return wsCardChangeCardacceptorListResult;
    }

    /**
     * Sets the value of the wsCardChangeCardacceptorListResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link ChangeCardacceptor }
     *     
     */
    public void setWsCardChangeCardacceptorListResult(ChangeCardacceptor value) {
        this.wsCardChangeCardacceptorListResult = value;
    }

}
