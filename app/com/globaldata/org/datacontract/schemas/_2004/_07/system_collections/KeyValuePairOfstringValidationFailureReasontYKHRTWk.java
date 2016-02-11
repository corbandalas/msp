
package org.datacontract.schemas._2004._07.system_collections;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import org.datacontract.schemas._2004._07.databaselibrary.ValidationFailureReason;


/**
 * <p>Java class for KeyValuePairOfstringValidationFailureReasontYKHRTWk complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="KeyValuePairOfstringValidationFailureReasontYKHRTWk">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="key" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="value" type="{http://schemas.datacontract.org/2004/07/DatabaseLibrary.Enums}ValidationFailureReason"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "KeyValuePairOfstringValidationFailureReasontYKHRTWk", propOrder = {
    "key",
    "value"
})
public class KeyValuePairOfstringValidationFailureReasontYKHRTWk {

    @XmlElement(required = true, nillable = true)
    protected String key;
    @XmlElement(required = true)
    @XmlSchemaType(name = "string")
    protected ValidationFailureReason value;

    /**
     * Gets the value of the key property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getKey() {
        return key;
    }

    /**
     * Sets the value of the key property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setKey(String value) {
        this.key = value;
    }

    /**
     * Gets the value of the value property.
     * 
     * @return
     *     possible object is
     *     {@link ValidationFailureReason }
     *     
     */
    public ValidationFailureReason getValue() {
        return value;
    }

    /**
     * Sets the value of the value property.
     * 
     * @param value
     *     allowed object is
     *     {@link ValidationFailureReason }
     *     
     */
    public void setValue(ValidationFailureReason value) {
        this.value = value;
    }

}
