
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
 *         &lt;element name="Ws_Transaction_VoidResult" type="{http://www.globalprocessing.ae/HyperionWeb}TransactionVoid"/>
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
    "wsTransactionVoidResult"
})
@XmlRootElement(name = "Ws_Transaction_VoidResponse")
public class WsTransactionVoidResponse {

    @XmlElement(name = "Ws_Transaction_VoidResult", required = true)
    protected TransactionVoid wsTransactionVoidResult;

    /**
     * Gets the value of the wsTransactionVoidResult property.
     * 
     * @return
     *     possible object is
     *     {@link TransactionVoid }
     *     
     */
    public TransactionVoid getWsTransactionVoidResult() {
        return wsTransactionVoidResult;
    }

    /**
     * Sets the value of the wsTransactionVoidResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link TransactionVoid }
     *     
     */
    public void setWsTransactionVoidResult(TransactionVoid value) {
        this.wsTransactionVoidResult = value;
    }

}
