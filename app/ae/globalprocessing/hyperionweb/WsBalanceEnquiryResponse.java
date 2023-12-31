
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
 *         &lt;element name="Ws_Balance_EnquiryResult" type="{http://www.globalprocessing.ae/HyperionWeb}BalanceEnquire"/>
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
    "wsBalanceEnquiryResult"
})
@XmlRootElement(name = "Ws_Balance_EnquiryResponse")
public class WsBalanceEnquiryResponse {

    @XmlElement(name = "Ws_Balance_EnquiryResult", required = true)
    protected BalanceEnquire wsBalanceEnquiryResult;

    /**
     * Gets the value of the wsBalanceEnquiryResult property.
     * 
     * @return
     *     possible object is
     *     {@link BalanceEnquire }
     *     
     */
    public BalanceEnquire getWsBalanceEnquiryResult() {
        return wsBalanceEnquiryResult;
    }

    /**
     * Sets the value of the wsBalanceEnquiryResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link BalanceEnquire }
     *     
     */
    public void setWsBalanceEnquiryResult(BalanceEnquire value) {
        this.wsBalanceEnquiryResult = value;
    }

}
