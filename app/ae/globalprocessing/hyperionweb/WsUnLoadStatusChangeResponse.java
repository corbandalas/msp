//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.7 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2015.12.16 at 11:33:22 PM MSK 
//


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
 *         &lt;element name="Ws_UnLoad_StatusChangeResult" type="{http://www.globalprocessing.ae/HyperionWeb}UnLoad"/>
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
    "wsUnLoadStatusChangeResult"
})
@XmlRootElement(name = "Ws_UnLoad_StatusChangeResponse")
public class WsUnLoadStatusChangeResponse {

    @XmlElement(name = "Ws_UnLoad_StatusChangeResult", required = true)
    protected UnLoad wsUnLoadStatusChangeResult;

    /**
     * Gets the value of the wsUnLoadStatusChangeResult property.
     * 
     * @return
     *     possible object is
     *     {@link UnLoad }
     *     
     */
    public UnLoad getWsUnLoadStatusChangeResult() {
        return wsUnLoadStatusChangeResult;
    }

    /**
     * Sets the value of the wsUnLoadStatusChangeResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link UnLoad }
     *     
     */
    public void setWsUnLoadStatusChangeResult(UnLoad value) {
        this.wsUnLoadStatusChangeResult = value;
    }

}