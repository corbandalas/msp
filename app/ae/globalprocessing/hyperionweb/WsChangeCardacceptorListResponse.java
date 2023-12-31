
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
 *         &lt;element name="Ws_Change_Cardacceptor_ListResult" type="{http://www.globalprocessing.ae/HyperionWeb}ChangeAccepter"/>
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
    "wsChangeCardacceptorListResult"
})
@XmlRootElement(name = "Ws_Change_Cardacceptor_ListResponse")
public class WsChangeCardacceptorListResponse {

    @XmlElement(name = "Ws_Change_Cardacceptor_ListResult", required = true)
    protected ChangeAccepter wsChangeCardacceptorListResult;

    /**
     * Gets the value of the wsChangeCardacceptorListResult property.
     * 
     * @return
     *     possible object is
     *     {@link ChangeAccepter }
     *     
     */
    public ChangeAccepter getWsChangeCardacceptorListResult() {
        return wsChangeCardacceptorListResult;
    }

    /**
     * Sets the value of the wsChangeCardacceptorListResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link ChangeAccepter }
     *     
     */
    public void setWsChangeCardacceptorListResult(ChangeAccepter value) {
        this.wsChangeCardacceptorListResult = value;
    }

}
