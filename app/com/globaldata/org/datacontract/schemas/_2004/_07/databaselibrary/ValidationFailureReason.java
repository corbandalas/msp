
package org.datacontract.schemas._2004._07.databaselibrary;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ValidationFailureReason.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ValidationFailureReason">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="None"/>
 *     &lt;enumeration value="MissingMandatoryField"/>
 *     &lt;enumeration value="FieldLengthExceeded"/>
 *     &lt;enumeration value="PatternNotMatched"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ValidationFailureReason", namespace = "http://schemas.datacontract.org/2004/07/DatabaseLibrary.Enums")
@XmlEnum
public enum ValidationFailureReason {

    @XmlEnumValue("None")
    NONE("None"),
    @XmlEnumValue("MissingMandatoryField")
    MISSING_MANDATORY_FIELD("MissingMandatoryField"),
    @XmlEnumValue("FieldLengthExceeded")
    FIELD_LENGTH_EXCEEDED("FieldLengthExceeded"),
    @XmlEnumValue("PatternNotMatched")
    PATTERN_NOT_MATCHED("PatternNotMatched");
    private final String value;

    ValidationFailureReason(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ValidationFailureReason fromValue(String v) {
        for (ValidationFailureReason c: ValidationFailureReason.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
