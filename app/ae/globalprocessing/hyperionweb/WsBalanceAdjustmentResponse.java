
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
 *         &lt;element name="Ws_BalanceAdjustmentResult" type="{http://www.globalprocessing.ae/HyperionWeb}BalanceAdjust"/>
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
    "wsBalanceAdjustmentResult"
})
@XmlRootElement(name = "Ws_BalanceAdjustmentResponse")
public class WsBalanceAdjustmentResponse {

    @XmlElement(name = "Ws_BalanceAdjustmentResult", required = true)
    protected BalanceAdjust wsBalanceAdjustmentResult;

    /**
     * Gets the value of the wsBalanceAdjustmentResult property.
     * 
     * @return
     *     possible object is
     *     {@link BalanceAdjust }
     *     
     */
    public BalanceAdjust getWsBalanceAdjustmentResult() {
        return wsBalanceAdjustmentResult;
    }

    /**
     * Sets the value of the wsBalanceAdjustmentResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link BalanceAdjust }
     *     
     */
    public void setWsBalanceAdjustmentResult(BalanceAdjust value) {
        this.wsBalanceAdjustmentResult = value;
    }

}
