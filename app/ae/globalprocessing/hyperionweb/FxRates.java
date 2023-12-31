
package ae.globalprocessing.hyperionweb;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for FxRates complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="FxRates">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="WSID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="IssCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ActionCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SysDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="GroupFxID" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="NoOfInvalidRates" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="InvalidRates" type="{http://www.globalprocessing.ae/HyperionWeb}ArrayOfInvalidRate" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FxRates", propOrder = {
    "wsid",
    "issCode",
    "actionCode",
    "sysDate",
    "groupFxID",
    "noOfInvalidRates",
    "invalidRates"
})
public class FxRates {

    @XmlElement(name = "WSID")
    protected long wsid;
    @XmlElement(name = "IssCode")
    protected String issCode;
    @XmlElement(name = "ActionCode")
    protected String actionCode;
    @XmlElement(name = "SysDate")
    protected String sysDate;
    @XmlElement(name = "GroupFxID")
    protected int groupFxID;
    @XmlElement(name = "NoOfInvalidRates")
    protected int noOfInvalidRates;
    @XmlElement(name = "InvalidRates")
    protected ArrayOfInvalidRate invalidRates;

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
     * Gets the value of the actionCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getActionCode() {
        return actionCode;
    }

    /**
     * Sets the value of the actionCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setActionCode(String value) {
        this.actionCode = value;
    }

    /**
     * Gets the value of the sysDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSysDate() {
        return sysDate;
    }

    /**
     * Sets the value of the sysDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSysDate(String value) {
        this.sysDate = value;
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
     * Gets the value of the noOfInvalidRates property.
     * 
     */
    public int getNoOfInvalidRates() {
        return noOfInvalidRates;
    }

    /**
     * Sets the value of the noOfInvalidRates property.
     * 
     */
    public void setNoOfInvalidRates(int value) {
        this.noOfInvalidRates = value;
    }

    /**
     * Gets the value of the invalidRates property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfInvalidRate }
     *     
     */
    public ArrayOfInvalidRate getInvalidRates() {
        return invalidRates;
    }

    /**
     * Sets the value of the invalidRates property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfInvalidRate }
     *     
     */
    public void setInvalidRates(ArrayOfInvalidRate value) {
        this.invalidRates = value;
    }

}
