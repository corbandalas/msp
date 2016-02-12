
package ae.globalprocessing.hyperionweb;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Fee complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Fee">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="PublicToken" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PostDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="TransDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ProcCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ActualAmt" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="AmtTaken" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="RemainingAmt" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="Description" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PartialAllowed" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="Collected" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="PendingFeesEnabled" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Fee", propOrder = {
    "publicToken",
    "postDate",
    "transDate",
    "procCode",
    "actualAmt",
    "amtTaken",
    "remainingAmt",
    "description",
    "partialAllowed",
    "collected",
    "pendingFeesEnabled"
})
public class Fee {

    @XmlElement(name = "PublicToken")
    protected String publicToken;
    @XmlElement(name = "PostDate")
    protected String postDate;
    @XmlElement(name = "TransDate")
    protected String transDate;
    @XmlElement(name = "ProcCode")
    protected String procCode;
    @XmlElement(name = "ActualAmt")
    protected double actualAmt;
    @XmlElement(name = "AmtTaken")
    protected double amtTaken;
    @XmlElement(name = "RemainingAmt")
    protected double remainingAmt;
    @XmlElement(name = "Description")
    protected String description;
    @XmlElement(name = "PartialAllowed")
    protected boolean partialAllowed;
    @XmlElement(name = "Collected")
    protected boolean collected;
    @XmlElement(name = "PendingFeesEnabled")
    protected boolean pendingFeesEnabled;

    /**
     * Gets the value of the publicToken property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPublicToken() {
        return publicToken;
    }

    /**
     * Sets the value of the publicToken property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPublicToken(String value) {
        this.publicToken = value;
    }

    /**
     * Gets the value of the postDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPostDate() {
        return postDate;
    }

    /**
     * Sets the value of the postDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPostDate(String value) {
        this.postDate = value;
    }

    /**
     * Gets the value of the transDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTransDate() {
        return transDate;
    }

    /**
     * Sets the value of the transDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTransDate(String value) {
        this.transDate = value;
    }

    /**
     * Gets the value of the procCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProcCode() {
        return procCode;
    }

    /**
     * Sets the value of the procCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProcCode(String value) {
        this.procCode = value;
    }

    /**
     * Gets the value of the actualAmt property.
     * 
     */
    public double getActualAmt() {
        return actualAmt;
    }

    /**
     * Sets the value of the actualAmt property.
     * 
     */
    public void setActualAmt(double value) {
        this.actualAmt = value;
    }

    /**
     * Gets the value of the amtTaken property.
     * 
     */
    public double getAmtTaken() {
        return amtTaken;
    }

    /**
     * Sets the value of the amtTaken property.
     * 
     */
    public void setAmtTaken(double value) {
        this.amtTaken = value;
    }

    /**
     * Gets the value of the remainingAmt property.
     * 
     */
    public double getRemainingAmt() {
        return remainingAmt;
    }

    /**
     * Sets the value of the remainingAmt property.
     * 
     */
    public void setRemainingAmt(double value) {
        this.remainingAmt = value;
    }

    /**
     * Gets the value of the description property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the value of the description property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescription(String value) {
        this.description = value;
    }

    /**
     * Gets the value of the partialAllowed property.
     * 
     */
    public boolean isPartialAllowed() {
        return partialAllowed;
    }

    /**
     * Sets the value of the partialAllowed property.
     * 
     */
    public void setPartialAllowed(boolean value) {
        this.partialAllowed = value;
    }

    /**
     * Gets the value of the collected property.
     * 
     */
    public boolean isCollected() {
        return collected;
    }

    /**
     * Sets the value of the collected property.
     * 
     */
    public void setCollected(boolean value) {
        this.collected = value;
    }

    /**
     * Gets the value of the pendingFeesEnabled property.
     * 
     */
    public boolean isPendingFeesEnabled() {
        return pendingFeesEnabled;
    }

    /**
     * Sets the value of the pendingFeesEnabled property.
     * 
     */
    public void setPendingFeesEnabled(boolean value) {
        this.pendingFeesEnabled = value;
    }

}
