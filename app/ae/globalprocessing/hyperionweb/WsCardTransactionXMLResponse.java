
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
 *         &lt;element name="Ws_Card_TransactionXMLResult" type="{http://www.globalprocessing.ae/HyperionWeb}TransactionXML"/>
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
    "wsCardTransactionXMLResult"
})
@XmlRootElement(name = "Ws_Card_TransactionXMLResponse")
public class WsCardTransactionXMLResponse {

    @XmlElement(name = "Ws_Card_TransactionXMLResult", required = true)
    protected TransactionXML wsCardTransactionXMLResult;

    /**
     * Gets the value of the wsCardTransactionXMLResult property.
     * 
     * @return
     *     possible object is
     *     {@link TransactionXML }
     *     
     */
    public TransactionXML getWsCardTransactionXMLResult() {
        return wsCardTransactionXMLResult;
    }

    /**
     * Sets the value of the wsCardTransactionXMLResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link TransactionXML }
     *     
     */
    public void setWsCardTransactionXMLResult(TransactionXML value) {
        this.wsCardTransactionXMLResult = value;
    }

}
