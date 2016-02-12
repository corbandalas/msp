
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
 *         &lt;element name="Ws_CardHolder_Details_EnquiryResult" type="{http://www.globalprocessing.ae/HyperionWeb}CardHolderDetails"/>
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
    "wsCardHolderDetailsEnquiryResult"
})
@XmlRootElement(name = "Ws_CardHolder_Details_EnquiryResponse")
public class WsCardHolderDetailsEnquiryResponse {

    @XmlElement(name = "Ws_CardHolder_Details_EnquiryResult", required = true)
    protected CardHolderDetails wsCardHolderDetailsEnquiryResult;

    /**
     * Gets the value of the wsCardHolderDetailsEnquiryResult property.
     * 
     * @return
     *     possible object is
     *     {@link CardHolderDetails }
     *     
     */
    public CardHolderDetails getWsCardHolderDetailsEnquiryResult() {
        return wsCardHolderDetailsEnquiryResult;
    }

    /**
     * Sets the value of the wsCardHolderDetailsEnquiryResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link CardHolderDetails }
     *     
     */
    public void setWsCardHolderDetailsEnquiryResult(CardHolderDetails value) {
        this.wsCardHolderDetailsEnquiryResult = value;
    }

}
