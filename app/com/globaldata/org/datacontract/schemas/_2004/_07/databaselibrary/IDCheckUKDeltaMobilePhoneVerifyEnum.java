
package org.datacontract.schemas._2004._07.databaselibrary;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for IDCheckUKDeltaMobilePhoneVerifyEnum.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="IDCheckUKDeltaMobilePhoneVerifyEnum">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="NotChecked"/>
 *     &lt;enumeration value="Verified"/>
 *     &lt;enumeration value="Failed"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "IDCheckUKDeltaMobilePhoneVerifyEnum", namespace = "http://schemas.datacontract.org/2004/07/DatabaseLibrary.Enums")
@XmlEnum
public enum IDCheckUKDeltaMobilePhoneVerifyEnum {

    @XmlEnumValue("NotChecked")
    NOT_CHECKED("NotChecked"),
    @XmlEnumValue("Verified")
    VERIFIED("Verified"),
    @XmlEnumValue("Failed")
    FAILED("Failed");
    private final String value;

    IDCheckUKDeltaMobilePhoneVerifyEnum(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static IDCheckUKDeltaMobilePhoneVerifyEnum fromValue(String v) {
        for (IDCheckUKDeltaMobilePhoneVerifyEnum c: IDCheckUKDeltaMobilePhoneVerifyEnum.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
