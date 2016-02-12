
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
 *         &lt;element name="Ws_EnquiryResult" type="{http://www.globalprocessing.ae/HyperionWeb}Card2"/>
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
    "wsEnquiryResult"
})
@XmlRootElement(name = "Ws_EnquiryResponse")
public class WsEnquiryResponse {

    @XmlElement(name = "Ws_EnquiryResult", required = true)
    protected Card2 wsEnquiryResult;

    /**
     * Gets the value of the wsEnquiryResult property.
     * 
     * @return
     *     possible object is
     *     {@link Card2 }
     *     
     */
    public Card2 getWsEnquiryResult() {
        return wsEnquiryResult;
    }

    /**
     * Sets the value of the wsEnquiryResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link Card2 }
     *     
     */
    public void setWsEnquiryResult(Card2 value) {
        this.wsEnquiryResult = value;
    }

}
