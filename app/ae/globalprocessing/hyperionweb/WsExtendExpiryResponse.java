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
 *         &lt;element name="Ws_ExtendExpiryResult" type="{http://www.globalprocessing.ae/HyperionWeb}ExtendExpiry"/>
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
    "wsExtendExpiryResult"
})
@XmlRootElement(name = "Ws_ExtendExpiryResponse")
public class WsExtendExpiryResponse {

    @XmlElement(name = "Ws_ExtendExpiryResult", required = true)
    protected ExtendExpiry wsExtendExpiryResult;

    /**
     * Gets the value of the wsExtendExpiryResult property.
     * 
     * @return
     *     possible object is
     *     {@link ExtendExpiry }
     *     
     */
    public ExtendExpiry getWsExtendExpiryResult() {
        return wsExtendExpiryResult;
    }

    /**
     * Sets the value of the wsExtendExpiryResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link ExtendExpiry }
     *     
     */
    public void setWsExtendExpiryResult(ExtendExpiry value) {
        this.wsExtendExpiryResult = value;
    }

}
