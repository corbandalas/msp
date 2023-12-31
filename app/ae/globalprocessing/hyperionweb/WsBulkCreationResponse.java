
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
 *         &lt;element name="Ws_BulkCreationResult" type="{http://www.globalprocessing.ae/HyperionWeb}BulkCards"/>
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
    "wsBulkCreationResult"
})
@XmlRootElement(name = "Ws_BulkCreationResponse")
public class WsBulkCreationResponse {

    @XmlElement(name = "Ws_BulkCreationResult", required = true)
    protected BulkCards wsBulkCreationResult;

    /**
     * Gets the value of the wsBulkCreationResult property.
     * 
     * @return
     *     possible object is
     *     {@link BulkCards }
     *     
     */
    public BulkCards getWsBulkCreationResult() {
        return wsBulkCreationResult;
    }

    /**
     * Sets the value of the wsBulkCreationResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link BulkCards }
     *     
     */
    public void setWsBulkCreationResult(BulkCards value) {
        this.wsBulkCreationResult = value;
    }

}
