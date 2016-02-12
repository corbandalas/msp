
package ae.globalprocessing.hyperionweb;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ProductListInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ProductListInfo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ProductID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ProductName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ProductDesc" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ProgramID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Currency" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CrdProduct" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="GroupLimitCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="GroupFeeTranCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="GroupFeeMasterCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="GroupFeeWebCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="GroupMCCCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="GroupUsageCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ProductListInfo", propOrder = {
    "productID",
    "productName",
    "productDesc",
    "programID",
    "currency",
    "crdProduct",
    "groupLimitCode",
    "groupFeeTranCode",
    "groupFeeMasterCode",
    "groupFeeWebCode",
    "groupMCCCode",
    "groupUsageCode"
})
public class ProductListInfo {

    @XmlElement(name = "ProductID")
    protected String productID;
    @XmlElement(name = "ProductName")
    protected String productName;
    @XmlElement(name = "ProductDesc")
    protected String productDesc;
    @XmlElement(name = "ProgramID")
    protected String programID;
    @XmlElement(name = "Currency")
    protected String currency;
    @XmlElement(name = "CrdProduct")
    protected String crdProduct;
    @XmlElement(name = "GroupLimitCode")
    protected String groupLimitCode;
    @XmlElement(name = "GroupFeeTranCode")
    protected String groupFeeTranCode;
    @XmlElement(name = "GroupFeeMasterCode")
    protected String groupFeeMasterCode;
    @XmlElement(name = "GroupFeeWebCode")
    protected String groupFeeWebCode;
    @XmlElement(name = "GroupMCCCode")
    protected String groupMCCCode;
    @XmlElement(name = "GroupUsageCode")
    protected String groupUsageCode;

    /**
     * Gets the value of the productID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProductID() {
        return productID;
    }

    /**
     * Sets the value of the productID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProductID(String value) {
        this.productID = value;
    }

    /**
     * Gets the value of the productName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProductName() {
        return productName;
    }

    /**
     * Sets the value of the productName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProductName(String value) {
        this.productName = value;
    }

    /**
     * Gets the value of the productDesc property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProductDesc() {
        return productDesc;
    }

    /**
     * Sets the value of the productDesc property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProductDesc(String value) {
        this.productDesc = value;
    }

    /**
     * Gets the value of the programID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProgramID() {
        return programID;
    }

    /**
     * Sets the value of the programID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProgramID(String value) {
        this.programID = value;
    }

    /**
     * Gets the value of the currency property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCurrency() {
        return currency;
    }

    /**
     * Sets the value of the currency property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCurrency(String value) {
        this.currency = value;
    }

    /**
     * Gets the value of the crdProduct property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCrdProduct() {
        return crdProduct;
    }

    /**
     * Sets the value of the crdProduct property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCrdProduct(String value) {
        this.crdProduct = value;
    }

    /**
     * Gets the value of the groupLimitCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGroupLimitCode() {
        return groupLimitCode;
    }

    /**
     * Sets the value of the groupLimitCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGroupLimitCode(String value) {
        this.groupLimitCode = value;
    }

    /**
     * Gets the value of the groupFeeTranCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGroupFeeTranCode() {
        return groupFeeTranCode;
    }

    /**
     * Sets the value of the groupFeeTranCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGroupFeeTranCode(String value) {
        this.groupFeeTranCode = value;
    }

    /**
     * Gets the value of the groupFeeMasterCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGroupFeeMasterCode() {
        return groupFeeMasterCode;
    }

    /**
     * Sets the value of the groupFeeMasterCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGroupFeeMasterCode(String value) {
        this.groupFeeMasterCode = value;
    }

    /**
     * Gets the value of the groupFeeWebCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGroupFeeWebCode() {
        return groupFeeWebCode;
    }

    /**
     * Sets the value of the groupFeeWebCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGroupFeeWebCode(String value) {
        this.groupFeeWebCode = value;
    }

    /**
     * Gets the value of the groupMCCCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGroupMCCCode() {
        return groupMCCCode;
    }

    /**
     * Sets the value of the groupMCCCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGroupMCCCode(String value) {
        this.groupMCCCode = value;
    }

    /**
     * Gets the value of the groupUsageCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGroupUsageCode() {
        return groupUsageCode;
    }

    /**
     * Sets the value of the groupUsageCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGroupUsageCode(String value) {
        this.groupUsageCode = value;
    }

}
