
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
 *         &lt;element name="Ws_Card_StatementResult" type="{http://www.globalprocessing.ae/HyperionWeb}CardStatement2"/>
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
    "wsCardStatementResult"
})
@XmlRootElement(name = "Ws_Card_StatementResponse")
public class WsCardStatementResponse {

    @XmlElement(name = "Ws_Card_StatementResult", required = true)
    protected CardStatement2 wsCardStatementResult;

    /**
     * Gets the value of the wsCardStatementResult property.
     * 
     * @return
     *     possible object is
     *     {@link CardStatement2 }
     *     
     */
    public CardStatement2 getWsCardStatementResult() {
        return wsCardStatementResult;
    }

    /**
     * Sets the value of the wsCardStatementResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link CardStatement2 }
     *     
     */
    public void setWsCardStatementResult(CardStatement2 value) {
        this.wsCardStatementResult = value;
    }

}
