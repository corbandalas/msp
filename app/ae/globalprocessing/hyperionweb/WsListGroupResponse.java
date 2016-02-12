
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
 *         &lt;element name="Ws_List_GroupResult" type="{http://www.globalprocessing.ae/HyperionWeb}GroupList"/>
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
    "wsListGroupResult"
})
@XmlRootElement(name = "Ws_List_GroupResponse")
public class WsListGroupResponse {

    @XmlElement(name = "Ws_List_GroupResult", required = true)
    protected GroupList wsListGroupResult;

    /**
     * Gets the value of the wsListGroupResult property.
     * 
     * @return
     *     possible object is
     *     {@link GroupList }
     *     
     */
    public GroupList getWsListGroupResult() {
        return wsListGroupResult;
    }

    /**
     * Sets the value of the wsListGroupResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link GroupList }
     *     
     */
    public void setWsListGroupResult(GroupList value) {
        this.wsListGroupResult = value;
    }

}
