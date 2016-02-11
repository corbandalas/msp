
package org.datacontract.schemas._2004._07.databaselibrary;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for IDCheckUKDeltaCompanyDirectorMatchTypeEnum.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="IDCheckUKDeltaCompanyDirectorMatchTypeEnum">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="NameAndDateOfBirth"/>
 *     &lt;enumeration value="NameAndAddress"/>
 *     &lt;enumeration value="NameDateOfBirthAndAddress"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "IDCheckUKDeltaCompanyDirectorMatchTypeEnum", namespace = "http://schemas.datacontract.org/2004/07/DatabaseLibrary.Enums")
@XmlEnum
public enum IDCheckUKDeltaCompanyDirectorMatchTypeEnum {

    @XmlEnumValue("NameAndDateOfBirth")
    NAME_AND_DATE_OF_BIRTH("NameAndDateOfBirth"),
    @XmlEnumValue("NameAndAddress")
    NAME_AND_ADDRESS("NameAndAddress"),
    @XmlEnumValue("NameDateOfBirthAndAddress")
    NAME_DATE_OF_BIRTH_AND_ADDRESS("NameDateOfBirthAndAddress");
    private final String value;

    IDCheckUKDeltaCompanyDirectorMatchTypeEnum(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static IDCheckUKDeltaCompanyDirectorMatchTypeEnum fromValue(String v) {
        for (IDCheckUKDeltaCompanyDirectorMatchTypeEnum c: IDCheckUKDeltaCompanyDirectorMatchTypeEnum.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
