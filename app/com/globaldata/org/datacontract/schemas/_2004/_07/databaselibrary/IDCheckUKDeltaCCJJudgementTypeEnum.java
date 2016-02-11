
package org.datacontract.schemas._2004._07.databaselibrary;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for IDCheckUKDeltaCCJJudgementTypeEnum.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="IDCheckUKDeltaCCJJudgementTypeEnum">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="AO"/>
 *     &lt;enumeration value="AS"/>
 *     &lt;enumeration value="C"/>
 *     &lt;enumeration value="C1"/>
 *     &lt;enumeration value="J"/>
 *     &lt;enumeration value="JG"/>
 *     &lt;enumeration value="SS"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "IDCheckUKDeltaCCJJudgementTypeEnum", namespace = "http://schemas.datacontract.org/2004/07/DatabaseLibrary.Enums")
@XmlEnum
public enum IDCheckUKDeltaCCJJudgementTypeEnum {

    AO("AO"),
    AS("AS"),
    C("C"),
    @XmlEnumValue("C1")
    C_1("C1"),
    J("J"),
    JG("JG"),
    SS("SS");
    private final String value;

    IDCheckUKDeltaCCJJudgementTypeEnum(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static IDCheckUKDeltaCCJJudgementTypeEnum fromValue(String v) {
        for (IDCheckUKDeltaCCJJudgementTypeEnum c: IDCheckUKDeltaCCJJudgementTypeEnum.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
