
package ae.globalprocessing.hyperionweb;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Rates complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Rates">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="SrcCurCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="DesCurCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="BuyRate" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="SellRate" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="MidRate" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Rates", propOrder = {
    "srcCurCode",
    "desCurCode",
    "buyRate",
    "sellRate",
    "midRate"
})
public class Rates {

    @XmlElement(name = "SrcCurCode")
    protected String srcCurCode;
    @XmlElement(name = "DesCurCode")
    protected String desCurCode;
    @XmlElement(name = "BuyRate")
    protected double buyRate;
    @XmlElement(name = "SellRate")
    protected double sellRate;
    @XmlElement(name = "MidRate")
    protected double midRate;

    /**
     * Gets the value of the srcCurCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSrcCurCode() {
        return srcCurCode;
    }

    /**
     * Sets the value of the srcCurCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSrcCurCode(String value) {
        this.srcCurCode = value;
    }

    /**
     * Gets the value of the desCurCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDesCurCode() {
        return desCurCode;
    }

    /**
     * Sets the value of the desCurCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDesCurCode(String value) {
        this.desCurCode = value;
    }

    /**
     * Gets the value of the buyRate property.
     * 
     */
    public double getBuyRate() {
        return buyRate;
    }

    /**
     * Sets the value of the buyRate property.
     * 
     */
    public void setBuyRate(double value) {
        this.buyRate = value;
    }

    /**
     * Gets the value of the sellRate property.
     * 
     */
    public double getSellRate() {
        return sellRate;
    }

    /**
     * Sets the value of the sellRate property.
     * 
     */
    public void setSellRate(double value) {
        this.sellRate = value;
    }

    /**
     * Gets the value of the midRate property.
     * 
     */
    public double getMidRate() {
        return midRate;
    }

    /**
     * Sets the value of the midRate property.
     * 
     */
    public void setMidRate(double value) {
        this.midRate = value;
    }

}
