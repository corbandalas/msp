
package ae.globalprocessing.hyperionweb;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ListSanctionPEPMatches complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ListSanctionPEPMatches">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="IssCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SysDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ActionCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SanctionPEPMatches" type="{http://www.globalprocessing.ae/HyperionWeb}ArrayOfSanctionPEPMatch" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ListSanctionPEPMatches", propOrder = {
    "issCode",
    "sysDate",
    "actionCode",
    "sanctionPEPMatches"
})
public class ListSanctionPEPMatches {

    @XmlElement(name = "IssCode")
    protected String issCode;
    @XmlElement(name = "SysDate")
    protected String sysDate;
    @XmlElement(name = "ActionCode")
    protected String actionCode;
    @XmlElement(name = "SanctionPEPMatches")
    protected ArrayOfSanctionPEPMatch sanctionPEPMatches;

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
     * Gets the value of the sanctionPEPMatches property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfSanctionPEPMatch }
     *     
     */
    public ArrayOfSanctionPEPMatch getSanctionPEPMatches() {
        return sanctionPEPMatches;
    }

    /**
     * Sets the value of the sanctionPEPMatches property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfSanctionPEPMatch }
     *     
     */
    public void setSanctionPEPMatches(ArrayOfSanctionPEPMatch value) {
        this.sanctionPEPMatches = value;
    }

}
