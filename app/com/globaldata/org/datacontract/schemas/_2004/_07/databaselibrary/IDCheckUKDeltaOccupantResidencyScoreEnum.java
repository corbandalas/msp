
package org.datacontract.schemas._2004._07.databaselibrary;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for IDCheckUKDeltaOccupantResidencyScoreEnum.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="IDCheckUKDeltaOccupantResidencyScoreEnum">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="VeryLow"/>
 *     &lt;enumeration value="Low"/>
 *     &lt;enumeration value="Medium"/>
 *     &lt;enumeration value="High"/>
 *     &lt;enumeration value="VeryHigh"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "IDCheckUKDeltaOccupantResidencyScoreEnum", namespace = "http://schemas.datacontract.org/2004/07/DatabaseLibrary.Enums")
@XmlEnum
public enum IDCheckUKDeltaOccupantResidencyScoreEnum {

    @XmlEnumValue("VeryLow")
    VERY_LOW("VeryLow"),
    @XmlEnumValue("Low")
    LOW("Low"),
    @XmlEnumValue("Medium")
    MEDIUM("Medium"),
    @XmlEnumValue("High")
    HIGH("High"),
    @XmlEnumValue("VeryHigh")
    VERY_HIGH("VeryHigh");
    private final String value;

    IDCheckUKDeltaOccupantResidencyScoreEnum(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static IDCheckUKDeltaOccupantResidencyScoreEnum fromValue(String v) {
        for (IDCheckUKDeltaOccupantResidencyScoreEnum c: IDCheckUKDeltaOccupantResidencyScoreEnum.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
