
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
 *         &lt;element name="Ws_Customer_Enquiry_V2Result" type="{http://www.globalprocessing.ae/HyperionWeb}Customer2"/>
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
    "wsCustomerEnquiryV2Result"
})
@XmlRootElement(name = "Ws_Customer_Enquiry_V2Response")
public class WsCustomerEnquiryV2Response {

    @XmlElement(name = "Ws_Customer_Enquiry_V2Result", required = true)
    protected Customer2 wsCustomerEnquiryV2Result;

    /**
     * Gets the value of the wsCustomerEnquiryV2Result property.
     * 
     * @return
     *     possible object is
     *     {@link Customer2 }
     *     
     */
    public Customer2 getWsCustomerEnquiryV2Result() {
        return wsCustomerEnquiryV2Result;
    }

    /**
     * Sets the value of the wsCustomerEnquiryV2Result property.
     * 
     * @param value
     *     allowed object is
     *     {@link Customer2 }
     *     
     */
    public void setWsCustomerEnquiryV2Result(Customer2 value) {
        this.wsCustomerEnquiryV2Result = value;
    }

}
