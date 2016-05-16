
package com.envoyservices.merchantapi;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for PaymentTemplate complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PaymentTemplate">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Row" type="{http://merchantapi.envoyservices.com}Row" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="TemplateID" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="Name" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="TransferTypeDesc" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="TemplateType" use="required" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="TemplateCurrency" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="TemplateCountry" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="ErrorCode" type="{http://www.w3.org/2001/XMLSchema}int" default="0" />
 *       &lt;attribute name="ErrorMsg" type="{http://www.w3.org/2001/XMLSchema}string" default="" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PaymentTemplate", propOrder = {
    "row"
})
public class PaymentTemplate {

    @XmlElement(name = "Row")
    protected List<Row> row;
    @XmlAttribute(name = "TemplateID")
    protected String templateID;
    @XmlAttribute(name = "Name")
    protected String name;
    @XmlAttribute(name = "TransferTypeDesc")
    protected String transferTypeDesc;
    @XmlAttribute(name = "TemplateType", required = true)
    protected int templateType;
    @XmlAttribute(name = "TemplateCurrency")
    protected String templateCurrency;
    @XmlAttribute(name = "TemplateCountry")
    protected String templateCountry;
    @XmlAttribute(name = "ErrorCode")
    protected Integer errorCode;
    @XmlAttribute(name = "ErrorMsg")
    protected String errorMsg;

    /**
     * Gets the value of the row property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the row property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRow().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Row }
     * 
     * 
     */
    public List<Row> getRow() {
        if (row == null) {
            row = new ArrayList<Row>();
        }
        return this.row;
    }

    /**
     * Gets the value of the templateID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTemplateID() {
        return templateID;
    }

    /**
     * Sets the value of the templateID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTemplateID(String value) {
        this.templateID = value;
    }

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Gets the value of the transferTypeDesc property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTransferTypeDesc() {
        return transferTypeDesc;
    }

    /**
     * Sets the value of the transferTypeDesc property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTransferTypeDesc(String value) {
        this.transferTypeDesc = value;
    }

    /**
     * Gets the value of the templateType property.
     * 
     */
    public int getTemplateType() {
        return templateType;
    }

    /**
     * Sets the value of the templateType property.
     * 
     */
    public void setTemplateType(int value) {
        this.templateType = value;
    }

    /**
     * Gets the value of the templateCurrency property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTemplateCurrency() {
        return templateCurrency;
    }

    /**
     * Sets the value of the templateCurrency property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTemplateCurrency(String value) {
        this.templateCurrency = value;
    }

    /**
     * Gets the value of the templateCountry property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTemplateCountry() {
        return templateCountry;
    }

    /**
     * Sets the value of the templateCountry property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTemplateCountry(String value) {
        this.templateCountry = value;
    }

    /**
     * Gets the value of the errorCode property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public int getErrorCode() {
        if (errorCode == null) {
            return  0;
        } else {
            return errorCode;
        }
    }

    /**
     * Sets the value of the errorCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setErrorCode(Integer value) {
        this.errorCode = value;
    }

    /**
     * Gets the value of the errorMsg property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getErrorMsg() {
        if (errorMsg == null) {
            return "";
        } else {
            return errorMsg;
        }
    }

    /**
     * Sets the value of the errorMsg property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setErrorMsg(String value) {
        this.errorMsg = value;
    }

}
