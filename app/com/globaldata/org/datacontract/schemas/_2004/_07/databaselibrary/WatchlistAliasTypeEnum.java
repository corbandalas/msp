
package org.datacontract.schemas._2004._07.databaselibrary;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for WatchlistAliasTypeEnum.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="WatchlistAliasTypeEnum">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="PrimaryAlias"/>
 *     &lt;enumeration value="AlsoKnownAs"/>
 *     &lt;enumeration value="FormerlyKnownAs"/>
 *     &lt;enumeration value="NowKnownAs"/>
 *     &lt;enumeration value="Unknown"/>
 *     &lt;enumeration value="MaidenName"/>
 *     &lt;enumeration value="SpellingVariation"/>
 *     &lt;enumeration value="LowQualityAlsoKnownAs"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "WatchlistAliasTypeEnum", namespace = "http://schemas.datacontract.org/2004/07/DatabaseLibrary.Enums")
@XmlEnum
public enum WatchlistAliasTypeEnum {

    @XmlEnumValue("PrimaryAlias")
    PRIMARY_ALIAS("PrimaryAlias"),
    @XmlEnumValue("AlsoKnownAs")
    ALSO_KNOWN_AS("AlsoKnownAs"),
    @XmlEnumValue("FormerlyKnownAs")
    FORMERLY_KNOWN_AS("FormerlyKnownAs"),
    @XmlEnumValue("NowKnownAs")
    NOW_KNOWN_AS("NowKnownAs"),
    @XmlEnumValue("Unknown")
    UNKNOWN("Unknown"),
    @XmlEnumValue("MaidenName")
    MAIDEN_NAME("MaidenName"),
    @XmlEnumValue("SpellingVariation")
    SPELLING_VARIATION("SpellingVariation"),
    @XmlEnumValue("LowQualityAlsoKnownAs")
    LOW_QUALITY_ALSO_KNOWN_AS("LowQualityAlsoKnownAs");
    private final String value;

    WatchlistAliasTypeEnum(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static WatchlistAliasTypeEnum fromValue(String v) {
        for (WatchlistAliasTypeEnum c: WatchlistAliasTypeEnum.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
