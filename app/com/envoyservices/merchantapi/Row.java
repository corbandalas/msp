
package com.envoyservices.merchantapi;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Row complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Row">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Row" type="{http://merchantapi.envoyservices.com}Row" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="Section" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="SectionTag" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="Title" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="FieldType" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="Id" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="InputType" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="Required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="Visibility" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="LabelTooltip" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="Tooltip" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="MinLength" use="required" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="MaxLength" use="required" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="MaxLengthIncludesNonAlpha" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="ErrorCode" type="{http://www.w3.org/2001/XMLSchema}int" default="0" />
 *       &lt;attribute name="ErrorMsg" type="{http://www.w3.org/2001/XMLSchema}string" default="" />
 *       &lt;attribute name="OptionValue" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="OptionText" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="Spacer" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="Value" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Row", propOrder = {
    "row"
})
public class Row {

    @XmlElement(name = "Row")
    protected List<Row> row;
    @XmlAttribute(name = "Section")
    protected String section;
    @XmlAttribute(name = "SectionTag")
    protected String sectionTag;
    @XmlAttribute(name = "Title")
    protected String title;
    @XmlAttribute(name = "FieldType")
    protected String fieldType;
    @XmlAttribute(name = "Id")
    protected String id;
    @XmlAttribute(name = "InputType")
    protected String inputType;
    @XmlAttribute(name = "Required")
    protected String required;
    @XmlAttribute(name = "Visibility")
    protected String visibility;
    @XmlAttribute(name = "LabelTooltip")
    protected String labelTooltip;
    @XmlAttribute(name = "Tooltip")
    protected String tooltip;
    @XmlAttribute(name = "MinLength", required = true)
    protected int minLength;
    @XmlAttribute(name = "MaxLength", required = true)
    protected int maxLength;
    @XmlAttribute(name = "MaxLengthIncludesNonAlpha")
    protected String maxLengthIncludesNonAlpha;
    @XmlAttribute(name = "ErrorCode")
    protected Integer errorCode;
    @XmlAttribute(name = "ErrorMsg")
    protected String errorMsg;
    @XmlAttribute(name = "OptionValue")
    protected String optionValue;
    @XmlAttribute(name = "OptionText")
    protected String optionText;
    @XmlAttribute(name = "Spacer")
    protected String spacer;
    @XmlAttribute(name = "Value")
    protected String value;

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
     * Gets the value of the section property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSection() {
        return section;
    }

    /**
     * Sets the value of the section property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSection(String value) {
        this.section = value;
    }

    /**
     * Gets the value of the sectionTag property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSectionTag() {
        return sectionTag;
    }

    /**
     * Sets the value of the sectionTag property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSectionTag(String value) {
        this.sectionTag = value;
    }

    /**
     * Gets the value of the title property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets the value of the title property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTitle(String value) {
        this.title = value;
    }

    /**
     * Gets the value of the fieldType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFieldType() {
        return fieldType;
    }

    /**
     * Sets the value of the fieldType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFieldType(String value) {
        this.fieldType = value;
    }

    /**
     * Gets the value of the id property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setId(String value) {
        this.id = value;
    }

    /**
     * Gets the value of the inputType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInputType() {
        return inputType;
    }

    /**
     * Sets the value of the inputType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInputType(String value) {
        this.inputType = value;
    }

    /**
     * Gets the value of the required property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRequired() {
        return required;
    }

    /**
     * Sets the value of the required property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRequired(String value) {
        this.required = value;
    }

    /**
     * Gets the value of the visibility property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVisibility() {
        return visibility;
    }

    /**
     * Sets the value of the visibility property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVisibility(String value) {
        this.visibility = value;
    }

    /**
     * Gets the value of the labelTooltip property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLabelTooltip() {
        return labelTooltip;
    }

    /**
     * Sets the value of the labelTooltip property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLabelTooltip(String value) {
        this.labelTooltip = value;
    }

    /**
     * Gets the value of the tooltip property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTooltip() {
        return tooltip;
    }

    /**
     * Sets the value of the tooltip property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTooltip(String value) {
        this.tooltip = value;
    }

    /**
     * Gets the value of the minLength property.
     * 
     */
    public int getMinLength() {
        return minLength;
    }

    /**
     * Sets the value of the minLength property.
     * 
     */
    public void setMinLength(int value) {
        this.minLength = value;
    }

    /**
     * Gets the value of the maxLength property.
     * 
     */
    public int getMaxLength() {
        return maxLength;
    }

    /**
     * Sets the value of the maxLength property.
     * 
     */
    public void setMaxLength(int value) {
        this.maxLength = value;
    }

    /**
     * Gets the value of the maxLengthIncludesNonAlpha property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMaxLengthIncludesNonAlpha() {
        return maxLengthIncludesNonAlpha;
    }

    /**
     * Sets the value of the maxLengthIncludesNonAlpha property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMaxLengthIncludesNonAlpha(String value) {
        this.maxLengthIncludesNonAlpha = value;
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

    /**
     * Gets the value of the optionValue property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOptionValue() {
        return optionValue;
    }

    /**
     * Sets the value of the optionValue property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOptionValue(String value) {
        this.optionValue = value;
    }

    /**
     * Gets the value of the optionText property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOptionText() {
        return optionText;
    }

    /**
     * Sets the value of the optionText property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOptionText(String value) {
        this.optionText = value;
    }

    /**
     * Gets the value of the spacer property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSpacer() {
        return spacer;
    }

    /**
     * Sets the value of the spacer property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSpacer(String value) {
        this.spacer = value;
    }

    /**
     * Gets the value of the value property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getValue() {
        return value;
    }

    /**
     * Sets the value of the value property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setValue(String value) {
        this.value = value;
    }

}
