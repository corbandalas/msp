
package org.datacontract.schemas._2004._07.databaselibrary;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for GenericMatchTypeEnum.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="GenericMatchTypeEnum">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="NotChecked"/>
 *     &lt;enumeration value="FullMatch"/>
 *     &lt;enumeration value="PartialMatch"/>
 *     &lt;enumeration value="NoMatch"/>
 *     &lt;enumeration value="MultipleMatch"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "GenericMatchTypeEnum", namespace = "http://schemas.datacontract.org/2004/07/DatabaseLibrary.Enums")
@XmlEnum
public enum GenericMatchTypeEnum {

    @XmlEnumValue("NotChecked")
    NOT_CHECKED("NotChecked"),
    @XmlEnumValue("FullMatch")
    FULL_MATCH("FullMatch"),
    @XmlEnumValue("PartialMatch")
    PARTIAL_MATCH("PartialMatch"),
    @XmlEnumValue("NoMatch")
    NO_MATCH("NoMatch"),
    @XmlEnumValue("MultipleMatch")
    MULTIPLE_MATCH("MultipleMatch");
    private final String value;

    GenericMatchTypeEnum(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static GenericMatchTypeEnum fromValue(String v) {
        for (GenericMatchTypeEnum c: GenericMatchTypeEnum.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
