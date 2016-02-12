
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
 *         &lt;element name="IssCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="MVCToken" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="NewToken" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="AmtTxn" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="CurCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="LoadedBy" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
    "issCode",
    "mvcToken",
    "newToken",
    "amtTxn",
    "curCode",
    "loadedBy"
})
@XmlRootElement(name = "Ws_MVCLoad")
public class WsMVCLoad {

    @XmlElement(name = "IssCode")
    protected String issCode;
    @XmlElement(name = "MVCToken")
    protected String mvcToken;
    @XmlElement(name = "NewToken")
    protected String newToken;
    @XmlElement(name = "AmtTxn")
    protected double amtTxn;
    @XmlElement(name = "CurCode")
    protected String curCode;
    @XmlElement(name = "LoadedBy")
    protected String loadedBy;

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
     * Gets the value of the mvcToken property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMVCToken() {
        return mvcToken;
    }

    /**
     * Sets the value of the mvcToken property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMVCToken(String value) {
        this.mvcToken = value;
    }

    /**
     * Gets the value of the newToken property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNewToken() {
        return newToken;
    }

    /**
     * Sets the value of the newToken property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNewToken(String value) {
        this.newToken = value;
    }

    /**
     * Gets the value of the amtTxn property.
     * 
     */
    public double getAmtTxn() {
        return amtTxn;
    }

    /**
     * Sets the value of the amtTxn property.
     * 
     */
    public void setAmtTxn(double value) {
        this.amtTxn = value;
    }

    /**
     * Gets the value of the curCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCurCode() {
        return curCode;
    }

    /**
     * Sets the value of the curCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCurCode(String value) {
        this.curCode = value;
    }

    /**
     * Gets the value of the loadedBy property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLoadedBy() {
        return loadedBy;
    }

    /**
     * Sets the value of the loadedBy property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLoadedBy(String value) {
        this.loadedBy = value;
    }

}
