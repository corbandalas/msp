
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
 *         &lt;element name="WSID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="IssCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="GroupFxID" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="Rates" type="{http://www.globalprocessing.ae/HyperionWeb}ArrayOfRates" minOccurs="0"/>
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
    "wsid",
    "issCode",
    "groupFxID",
    "rates"
})
@XmlRootElement(name = "Ws_Client_Fx")
public class WsClientFx {

    @XmlElement(name = "WSID")
    protected long wsid;
    @XmlElement(name = "IssCode")
    protected String issCode;
    @XmlElement(name = "GroupFxID")
    protected int groupFxID;
    @XmlElement(name = "Rates")
    protected ArrayOfRates rates;

    /**
     * Gets the value of the wsid property.
     * 
     */
    public long getWSID() {
        return wsid;
    }

    /**
     * Sets the value of the wsid property.
     * 
     */
    public void setWSID(long value) {
        this.wsid = value;
    }

    /**
     * Gets the value of the issCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIssCode() {
        return issCode;
    }

    /**
     * Sets the value of the issCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIssCode(String value) {
        this.issCode = value;
    }

    /**
     * Gets the value of the groupFxID property.
     * 
     */
    public int getGroupFxID() {
        return groupFxID;
    }

    /**
     * Sets the value of the groupFxID property.
     * 
     */
    public void setGroupFxID(int value) {
        this.groupFxID = value;
    }

    /**
     * Gets the value of the rates property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfRates }
     *     
     */
    public ArrayOfRates getRates() {
        return rates;
    }

    /**
     * Sets the value of the rates property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfRates }
     *     
     */
    public void setRates(ArrayOfRates value) {
        this.rates = value;
    }

}
