
package org.datacontract.schemas._2004._07.databaselibrary;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for IDCheckUKDeltaAddressGoneAwayEnum.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="IDCheckUKDeltaAddressGoneAwayEnum">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="No"/>
 *     &lt;enumeration value="High"/>
 *     &lt;enumeration value="VeryHigh"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "IDCheckUKDeltaAddressGoneAwayEnum", namespace = "http://schemas.datacontract.org/2004/07/DatabaseLibrary.Enums")
@XmlEnum
public enum IDCheckUKDeltaAddressGoneAwayEnum {

    @XmlEnumValue("No")
    NO("No"),
    @XmlEnumValue("High")
    HIGH("High"),
    @XmlEnumValue("VeryHigh")
    VERY_HIGH("VeryHigh");
    private final String value;

    IDCheckUKDeltaAddressGoneAwayEnum(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static IDCheckUKDeltaAddressGoneAwayEnum fromValue(String v) {
        for (IDCheckUKDeltaAddressGoneAwayEnum c: IDCheckUKDeltaAddressGoneAwayEnum.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
