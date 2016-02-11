
package org.datacontract.schemas._2004._07.databaselibrary;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ValidationResultEnum.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ValidationResultEnum">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Pass"/>
 *     &lt;enumeration value="Fail"/>
 *     &lt;enumeration value="Inconclusive"/>
 *     &lt;enumeration value="NoValidationPerformed"/>
 *     &lt;enumeration value="NotApplicable"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ValidationResultEnum", namespace = "http://schemas.datacontract.org/2004/07/DatabaseLibrary.Enums")
@XmlEnum
public enum ValidationResultEnum {

    @XmlEnumValue("Pass")
    PASS("Pass"),
    @XmlEnumValue("Fail")
    FAIL("Fail"),
    @XmlEnumValue("Inconclusive")
    INCONCLUSIVE("Inconclusive"),
    @XmlEnumValue("NoValidationPerformed")
    NO_VALIDATION_PERFORMED("NoValidationPerformed"),
    @XmlEnumValue("NotApplicable")
    NOT_APPLICABLE("NotApplicable");
    private final String value;

    ValidationResultEnum(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ValidationResultEnum fromValue(String v) {
        for (ValidationResultEnum c: ValidationResultEnum.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
