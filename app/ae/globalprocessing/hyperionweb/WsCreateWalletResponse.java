
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
 *         &lt;element name="Ws_CreateWalletResult" type="{http://www.globalprocessing.ae/HyperionWeb}Wallet"/>
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
    "wsCreateWalletResult"
})
@XmlRootElement(name = "Ws_CreateWalletResponse")
public class WsCreateWalletResponse {

    @XmlElement(name = "Ws_CreateWalletResult", required = true)
    protected Wallet wsCreateWalletResult;

    /**
     * Gets the value of the wsCreateWalletResult property.
     * 
     * @return
     *     possible object is
     *     {@link Wallet }
     *     
     */
    public Wallet getWsCreateWalletResult() {
        return wsCreateWalletResult;
    }

    /**
     * Sets the value of the wsCreateWalletResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link Wallet }
     *     
     */
    public void setWsCreateWalletResult(Wallet value) {
        this.wsCreateWalletResult = value;
    }

}
