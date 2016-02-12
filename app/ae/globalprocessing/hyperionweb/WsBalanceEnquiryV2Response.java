
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
 *         &lt;element name="Ws_Balance_Enquiry_V2Result" type="{http://www.globalprocessing.ae/HyperionWeb}BalanceEnquire2" minOccurs="0"/>
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
    "wsBalanceEnquiryV2Result"
})
@XmlRootElement(name = "Ws_Balance_Enquiry_V2Response")
public class WsBalanceEnquiryV2Response {

    @XmlElement(name = "Ws_Balance_Enquiry_V2Result")
    protected BalanceEnquire2 wsBalanceEnquiryV2Result;

    /**
     * Gets the value of the wsBalanceEnquiryV2Result property.
     * 
     * @return
     *     possible object is
     *     {@link BalanceEnquire2 }
     *     
     */
    public BalanceEnquire2 getWsBalanceEnquiryV2Result() {
        return wsBalanceEnquiryV2Result;
    }

    /**
     * Sets the value of the wsBalanceEnquiryV2Result property.
     * 
     * @param value
     *     allowed object is
     *     {@link BalanceEnquire2 }
     *     
     */
    public void setWsBalanceEnquiryV2Result(BalanceEnquire2 value) {
        this.wsBalanceEnquiryV2Result = value;
    }

}
