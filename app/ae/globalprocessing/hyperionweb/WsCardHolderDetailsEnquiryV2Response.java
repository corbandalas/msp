
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
 *         &lt;element name="Ws_CardHolder_Details_Enquiry_V2Result" type="{http://www.globalprocessing.ae/HyperionWeb}CardHolderDetails2"/>
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
    "wsCardHolderDetailsEnquiryV2Result"
})
@XmlRootElement(name = "Ws_CardHolder_Details_Enquiry_V2Response")
public class WsCardHolderDetailsEnquiryV2Response {

    @XmlElement(name = "Ws_CardHolder_Details_Enquiry_V2Result", required = true)
    protected CardHolderDetails2 wsCardHolderDetailsEnquiryV2Result;

    /**
     * Gets the value of the wsCardHolderDetailsEnquiryV2Result property.
     * 
     * @return
     *     possible object is
     *     {@link CardHolderDetails2 }
     *     
     */
    public CardHolderDetails2 getWsCardHolderDetailsEnquiryV2Result() {
        return wsCardHolderDetailsEnquiryV2Result;
    }

    /**
     * Sets the value of the wsCardHolderDetailsEnquiryV2Result property.
     * 
     * @param value
     *     allowed object is
     *     {@link CardHolderDetails2 }
     *     
     */
    public void setWsCardHolderDetailsEnquiryV2Result(CardHolderDetails2 value) {
        this.wsCardHolderDetailsEnquiryV2Result = value;
    }

}
