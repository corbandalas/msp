
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
 *         &lt;element name="Ws_BulkWalletCreationResult" type="{http://www.globalprocessing.ae/HyperionWeb}BulkWallets"/>
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
    "wsBulkWalletCreationResult"
})
@XmlRootElement(name = "Ws_BulkWalletCreationResponse")
public class WsBulkWalletCreationResponse {

    @XmlElement(name = "Ws_BulkWalletCreationResult", required = true)
    protected BulkWallets wsBulkWalletCreationResult;

    /**
     * Gets the value of the wsBulkWalletCreationResult property.
     * 
     * @return
     *     possible object is
     *     {@link BulkWallets }
     *     
     */
    public BulkWallets getWsBulkWalletCreationResult() {
        return wsBulkWalletCreationResult;
    }

    /**
     * Sets the value of the wsBulkWalletCreationResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link BulkWallets }
     *     
     */
    public void setWsBulkWalletCreationResult(BulkWallets value) {
        this.wsBulkWalletCreationResult = value;
    }

}
