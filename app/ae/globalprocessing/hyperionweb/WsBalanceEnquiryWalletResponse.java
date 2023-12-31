
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
 *         &lt;element name="Ws_Balance_Enquiry_WalletResult" type="{http://www.globalprocessing.ae/HyperionWeb}BalanceEnquireWallet"/>
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
    "wsBalanceEnquiryWalletResult"
})
@XmlRootElement(name = "Ws_Balance_Enquiry_WalletResponse")
public class WsBalanceEnquiryWalletResponse {

    @XmlElement(name = "Ws_Balance_Enquiry_WalletResult", required = true)
    protected BalanceEnquireWallet wsBalanceEnquiryWalletResult;

    /**
     * Gets the value of the wsBalanceEnquiryWalletResult property.
     * 
     * @return
     *     possible object is
     *     {@link BalanceEnquireWallet }
     *     
     */
    public BalanceEnquireWallet getWsBalanceEnquiryWalletResult() {
        return wsBalanceEnquiryWalletResult;
    }

    /**
     * Sets the value of the wsBalanceEnquiryWalletResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link BalanceEnquireWallet }
     *     
     */
    public void setWsBalanceEnquiryWalletResult(BalanceEnquireWallet value) {
        this.wsBalanceEnquiryWalletResult = value;
    }

}
