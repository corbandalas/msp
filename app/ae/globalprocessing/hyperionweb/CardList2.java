
package ae.globalprocessing.hyperionweb;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for CardList2 complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CardList2">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="PAN" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ExpDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CurCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="StatCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CrdProduct" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Program" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="DesignRef" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="EmbossName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="AvlBal" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="BlkAmt" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="FirstName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="LastName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CustType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PublicToken" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Primary" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="IsLive" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="Scheme" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Product" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="MCCGroup" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="LimitGroup" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PERMSGroup" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="FeeGroup" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SchedFeeGroup" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="WsFeeGroup" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="LinkageGroup" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PrimaryToken" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="MaskedPAN" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ProductID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ProductRef" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="AuthCalendarGroup" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="FXGroup" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CardList2", propOrder = {
    "pan",
    "expDate",
    "curCode",
    "statCode",
    "crdProduct",
    "program",
    "designRef",
    "embossName",
    "avlBal",
    "blkAmt",
    "firstName",
    "lastName",
    "custType",
    "publicToken",
    "primary",
    "isLive",
    "scheme",
    "product",
    "mccGroup",
    "limitGroup",
    "permsGroup",
    "feeGroup",
    "schedFeeGroup",
    "wsFeeGroup",
    "linkageGroup",
    "primaryToken",
    "maskedPAN",
    "productID",
    "productRef",
    "authCalendarGroup",
    "fxGroup"
})
public class CardList2 {

    @XmlElement(name = "PAN")
    protected String pan;
    @XmlElement(name = "ExpDate")
    protected String expDate;
    @XmlElement(name = "CurCode")
    protected String curCode;
    @XmlElement(name = "StatCode")
    protected String statCode;
    @XmlElement(name = "CrdProduct")
    protected String crdProduct;
    @XmlElement(name = "Program")
    protected String program;
    @XmlElement(name = "DesignRef")
    protected String designRef;
    @XmlElement(name = "EmbossName")
    protected String embossName;
    @XmlElement(name = "AvlBal")
    protected double avlBal;
    @XmlElement(name = "BlkAmt")
    protected double blkAmt;
    @XmlElement(name = "FirstName")
    protected String firstName;
    @XmlElement(name = "LastName")
    protected String lastName;
    @XmlElement(name = "CustType")
    protected String custType;
    @XmlElement(name = "PublicToken")
    protected String publicToken;
    @XmlElement(name = "Primary")
    protected String primary;
    @XmlElement(name = "IsLive")
    protected int isLive;
    @XmlElement(name = "Scheme")
    protected String scheme;
    @XmlElement(name = "Product")
    protected String product;
    @XmlElement(name = "MCCGroup")
    protected String mccGroup;
    @XmlElement(name = "LimitGroup")
    protected String limitGroup;
    @XmlElement(name = "PERMSGroup")
    protected String permsGroup;
    @XmlElement(name = "FeeGroup")
    protected String feeGroup;
    @XmlElement(name = "SchedFeeGroup")
    protected String schedFeeGroup;
    @XmlElement(name = "WsFeeGroup")
    protected String wsFeeGroup;
    @XmlElement(name = "LinkageGroup")
    protected String linkageGroup;
    @XmlElement(name = "PrimaryToken")
    protected String primaryToken;
    @XmlElement(name = "MaskedPAN")
    protected String maskedPAN;
    @XmlElement(name = "ProductID")
    protected String productID;
    @XmlElement(name = "ProductRef")
    protected String productRef;
    @XmlElement(name = "AuthCalendarGroup")
    protected String authCalendarGroup;
    @XmlElement(name = "FXGroup")
    protected String fxGroup;

    /**
     * Gets the value of the pan property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPAN() {
        return pan;
    }

    /**
     * Sets the value of the pan property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPAN(String value) {
        this.pan = value;
    }

    /**
     * Gets the value of the expDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getExpDate() {
        return expDate;
    }

    /**
     * Sets the value of the expDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setExpDate(String value) {
        this.expDate = value;
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
     * Gets the value of the statCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStatCode() {
        return statCode;
    }

    /**
     * Sets the value of the statCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStatCode(String value) {
        this.statCode = value;
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
     * Gets the value of the program property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProgram() {
        return program;
    }

    /**
     * Sets the value of the program property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProgram(String value) {
        this.program = value;
    }

    /**
     * Gets the value of the designRef property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDesignRef() {
        return designRef;
    }

    /**
     * Sets the value of the designRef property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDesignRef(String value) {
        this.designRef = value;
    }

    /**
     * Gets the value of the embossName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEmbossName() {
        return embossName;
    }

    /**
     * Sets the value of the embossName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEmbossName(String value) {
        this.embossName = value;
    }

    /**
     * Gets the value of the avlBal property.
     * 
     */
    public double getAvlBal() {
        return avlBal;
    }

    /**
     * Sets the value of the avlBal property.
     * 
     */
    public void setAvlBal(double value) {
        this.avlBal = value;
    }

    /**
     * Gets the value of the blkAmt property.
     * 
     */
    public double getBlkAmt() {
        return blkAmt;
    }

    /**
     * Sets the value of the blkAmt property.
     * 
     */
    public void setBlkAmt(double value) {
        this.blkAmt = value;
    }

    /**
     * Gets the value of the firstName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets the value of the firstName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFirstName(String value) {
        this.firstName = value;
    }

    /**
     * Gets the value of the lastName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets the value of the lastName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLastName(String value) {
        this.lastName = value;
    }

    /**
     * Gets the value of the custType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCustType() {
        return custType;
    }

    /**
     * Sets the value of the custType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCustType(String value) {
        this.custType = value;
    }

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
     * Gets the value of the primary property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPrimary() {
        return primary;
    }

    /**
     * Sets the value of the primary property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPrimary(String value) {
        this.primary = value;
    }

    /**
     * Gets the value of the isLive property.
     * 
     */
    public int getIsLive() {
        return isLive;
    }

    /**
     * Sets the value of the isLive property.
     * 
     */
    public void setIsLive(int value) {
        this.isLive = value;
    }

    /**
     * Gets the value of the scheme property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getScheme() {
        return scheme;
    }

    /**
     * Sets the value of the scheme property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setScheme(String value) {
        this.scheme = value;
    }

    /**
     * Gets the value of the product property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProduct() {
        return product;
    }

    /**
     * Sets the value of the product property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProduct(String value) {
        this.product = value;
    }

    /**
     * Gets the value of the mccGroup property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMCCGroup() {
        return mccGroup;
    }

    /**
     * Sets the value of the mccGroup property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMCCGroup(String value) {
        this.mccGroup = value;
    }

    /**
     * Gets the value of the limitGroup property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLimitGroup() {
        return limitGroup;
    }

    /**
     * Sets the value of the limitGroup property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLimitGroup(String value) {
        this.limitGroup = value;
    }

    /**
     * Gets the value of the permsGroup property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPERMSGroup() {
        return permsGroup;
    }

    /**
     * Sets the value of the permsGroup property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPERMSGroup(String value) {
        this.permsGroup = value;
    }

    /**
     * Gets the value of the feeGroup property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFeeGroup() {
        return feeGroup;
    }

    /**
     * Sets the value of the feeGroup property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFeeGroup(String value) {
        this.feeGroup = value;
    }

    /**
     * Gets the value of the schedFeeGroup property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSchedFeeGroup() {
        return schedFeeGroup;
    }

    /**
     * Sets the value of the schedFeeGroup property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSchedFeeGroup(String value) {
        this.schedFeeGroup = value;
    }

    /**
     * Gets the value of the wsFeeGroup property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWsFeeGroup() {
        return wsFeeGroup;
    }

    /**
     * Sets the value of the wsFeeGroup property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWsFeeGroup(String value) {
        this.wsFeeGroup = value;
    }

    /**
     * Gets the value of the linkageGroup property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLinkageGroup() {
        return linkageGroup;
    }

    /**
     * Sets the value of the linkageGroup property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLinkageGroup(String value) {
        this.linkageGroup = value;
    }

    /**
     * Gets the value of the primaryToken property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPrimaryToken() {
        return primaryToken;
    }

    /**
     * Sets the value of the primaryToken property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPrimaryToken(String value) {
        this.primaryToken = value;
    }

    /**
     * Gets the value of the maskedPAN property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMaskedPAN() {
        return maskedPAN;
    }

    /**
     * Sets the value of the maskedPAN property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMaskedPAN(String value) {
        this.maskedPAN = value;
    }

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
     * Gets the value of the productRef property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProductRef() {
        return productRef;
    }

    /**
     * Sets the value of the productRef property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProductRef(String value) {
        this.productRef = value;
    }

    /**
     * Gets the value of the authCalendarGroup property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAuthCalendarGroup() {
        return authCalendarGroup;
    }

    /**
     * Sets the value of the authCalendarGroup property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAuthCalendarGroup(String value) {
        this.authCalendarGroup = value;
    }

    /**
     * Gets the value of the fxGroup property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFXGroup() {
        return fxGroup;
    }

    /**
     * Sets the value of the fxGroup property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFXGroup(String value) {
        this.fxGroup = value;
    }

}
