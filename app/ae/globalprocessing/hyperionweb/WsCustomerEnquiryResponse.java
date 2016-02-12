
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
 *         &lt;element name="Ws_Customer_EnquiryResult" type="{http://www.globalprocessing.ae/HyperionWeb}Customer"/>
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
    "wsCustomerEnquiryResult"
})
@XmlRootElement(name = "Ws_Customer_EnquiryResponse")
public class WsCustomerEnquiryResponse {

    @XmlElement(name = "Ws_Customer_EnquiryResult", required = true)
    protected Customer wsCustomerEnquiryResult;

    /**
     * Gets the value of the wsCustomerEnquiryResult property.
     * 
     * @return
     *     possible object is
     *     {@link Customer }
     *     
     */
    public Customer getWsCustomerEnquiryResult() {
        return wsCustomerEnquiryResult;
    }

    /**
     * Sets the value of the wsCustomerEnquiryResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link Customer }
     *     
     */
    public void setWsCustomerEnquiryResult(Customer value) {
        this.wsCustomerEnquiryResult = value;
    }

}
