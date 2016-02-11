
package org.datacontract.schemas._2004._07.databaselibrary;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for MatchTypeEnum.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="MatchTypeEnum">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Person"/>
 *     &lt;enumeration value="Entity"/>
 *     &lt;enumeration value="Unknown"/>
 *     &lt;enumeration value="Vessel"/>
 *     &lt;enumeration value="Aircraft"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "MatchTypeEnum", namespace = "http://schemas.datacontract.org/2004/07/DatabaseLibrary.Enums")
@XmlEnum
public enum MatchTypeEnum {

    @XmlEnumValue("Person")
    PERSON("Person"),
    @XmlEnumValue("Entity")
    ENTITY("Entity"),
    @XmlEnumValue("Unknown")
    UNKNOWN("Unknown"),
    @XmlEnumValue("Vessel")
    VESSEL("Vessel"),
    @XmlEnumValue("Aircraft")
    AIRCRAFT("Aircraft");
    private final String value;

    MatchTypeEnum(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static MatchTypeEnum fromValue(String v) {
        for (MatchTypeEnum c: MatchTypeEnum.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
