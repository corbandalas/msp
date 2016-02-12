
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
 *         &lt;element name="Ws_Change_GroupsResult" type="{http://www.globalprocessing.ae/HyperionWeb}GroupChange"/>
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
    "wsChangeGroupsResult"
})
@XmlRootElement(name = "Ws_Change_GroupsResponse")
public class WsChangeGroupsResponse {

    @XmlElement(name = "Ws_Change_GroupsResult", required = true)
    protected GroupChange wsChangeGroupsResult;

    /**
     * Gets the value of the wsChangeGroupsResult property.
     * 
     * @return
     *     possible object is
     *     {@link GroupChange }
     *     
     */
    public GroupChange getWsChangeGroupsResult() {
        return wsChangeGroupsResult;
    }

    /**
     * Sets the value of the wsChangeGroupsResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link GroupChange }
     *     
     */
    public void setWsChangeGroupsResult(GroupChange value) {
        this.wsChangeGroupsResult = value;
    }

}
