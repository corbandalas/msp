
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
 *         &lt;element name="Ws_BalanceTransferResult" type="{http://www.globalprocessing.ae/HyperionWeb}BalanceTransfer"/>
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
    "wsBalanceTransferResult"
})
@XmlRootElement(name = "Ws_BalanceTransferResponse")
public class WsBalanceTransferResponse {

    @XmlElement(name = "Ws_BalanceTransferResult", required = true)
    protected BalanceTransfer wsBalanceTransferResult;

    /**
     * Gets the value of the wsBalanceTransferResult property.
     * 
     * @return
     *     possible object is
     *     {@link BalanceTransfer }
     *     
     */
    public BalanceTransfer getWsBalanceTransferResult() {
        return wsBalanceTransferResult;
    }

    /**
     * Sets the value of the wsBalanceTransferResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link BalanceTransfer }
     *     
     */
    public void setWsBalanceTransferResult(BalanceTransfer value) {
        this.wsBalanceTransferResult = value;
    }

}
