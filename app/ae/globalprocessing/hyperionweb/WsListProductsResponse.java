
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
 *         &lt;element name="Ws_List_ProductsResult" type="{http://www.globalprocessing.ae/HyperionWeb}ProductList"/>
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
    "wsListProductsResult"
})
@XmlRootElement(name = "Ws_List_ProductsResponse")
public class WsListProductsResponse {

    @XmlElement(name = "Ws_List_ProductsResult", required = true)
    protected ProductList wsListProductsResult;

    /**
     * Gets the value of the wsListProductsResult property.
     * 
     * @return
     *     possible object is
     *     {@link ProductList }
     *     
     */
    public ProductList getWsListProductsResult() {
        return wsListProductsResult;
    }

    /**
     * Sets the value of the wsListProductsResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link ProductList }
     *     
     */
    public void setWsListProductsResult(ProductList value) {
        this.wsListProductsResult = value;
    }

}
