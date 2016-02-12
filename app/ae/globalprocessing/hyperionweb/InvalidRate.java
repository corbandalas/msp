
package ae.globalprocessing.hyperionweb;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for InvalidRate complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="InvalidRate">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="RateNo" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="SrcCurCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="DesCurCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="BuyRate" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="SellRate" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="MidRate" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="ErrorCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ErrorDescription" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "InvalidRate", propOrder = {
    "rateNo",
    "srcCurCode",
    "desCurCode",
    "buyRate",
    "sellRate",
    "midRate",
    "errorCode",
    "errorDescription"
})
public class InvalidRate {

    @XmlElement(name = "RateNo")
    protected int rateNo;
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
    @XmlElement(name = "ErrorCode")
    protected String errorCode;
    @XmlElement(name = "ErrorDescription")
    protected String errorDescription;

    /**
     * Gets the value of the rateNo property.
     * 
     */
    public int getRateNo() {
        return rateNo;
    }

    /**
     * Sets the value of the rateNo property.
     * 
     */
    public void setRateNo(int value) {
        this.rateNo = value;
    }

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

    /**
     * Gets the value of the errorCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getErrorCode() {
        return errorCode;
    }

    /**
     * Sets the value of the errorCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setErrorCode(String value) {
        this.errorCode = value;
    }

    /**
     * Gets the value of the errorDescription property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getErrorDescription() {
        return errorDescription;
    }

    /**
     * Sets the value of the errorDescription property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setErrorDescription(String value) {
        this.errorDescription = value;
    }

}
