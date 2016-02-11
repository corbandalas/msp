
package org.datacontract.schemas._2004._07.databaselibrary;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for IDCheckAddressLookupDataLevelEnum.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="IDCheckAddressLookupDataLevelEnum">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Unknown"/>
 *     &lt;enumeration value="Premise"/>
 *     &lt;enumeration value="RangedPremise"/>
 *     &lt;enumeration value="Street"/>
 *     &lt;enumeration value="City"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "IDCheckAddressLookupDataLevelEnum", namespace = "http://schemas.datacontract.org/2004/07/DatabaseLibrary.Enums")
@XmlEnum
public enum IDCheckAddressLookupDataLevelEnum {

    @XmlEnumValue("Unknown")
    UNKNOWN("Unknown"),
    @XmlEnumValue("Premise")
    PREMISE("Premise"),
    @XmlEnumValue("RangedPremise")
    RANGED_PREMISE("RangedPremise"),
    @XmlEnumValue("Street")
    STREET("Street"),
    @XmlEnumValue("City")
    CITY("City");
    private final String value;

    IDCheckAddressLookupDataLevelEnum(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static IDCheckAddressLookupDataLevelEnum fromValue(String v) {
        for (IDCheckAddressLookupDataLevelEnum c: IDCheckAddressLookupDataLevelEnum.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
