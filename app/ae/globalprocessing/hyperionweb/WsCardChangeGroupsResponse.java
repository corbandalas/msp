
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
 *         &lt;element name="Ws_Card_Change_GroupsResult" type="{http://www.globalprocessing.ae/HyperionWeb}ChangeGroup"/>
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
    "wsCardChangeGroupsResult"
})
@XmlRootElement(name = "Ws_Card_Change_GroupsResponse")
public class WsCardChangeGroupsResponse {

    @XmlElement(name = "Ws_Card_Change_GroupsResult", required = true)
    protected ChangeGroup wsCardChangeGroupsResult;

    /**
     * Gets the value of the wsCardChangeGroupsResult property.
     * 
     * @return
     *     possible object is
     *     {@link ChangeGroup }
     *     
     */
    public ChangeGroup getWsCardChangeGroupsResult() {
        return wsCardChangeGroupsResult;
    }

    /**
     * Sets the value of the wsCardChangeGroupsResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link ChangeGroup }
     *     
     */
    public void setWsCardChangeGroupsResult(ChangeGroup value) {
        this.wsCardChangeGroupsResult = value;
    }

}
