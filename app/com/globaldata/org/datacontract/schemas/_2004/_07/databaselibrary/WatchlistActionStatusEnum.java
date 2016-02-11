
package org.datacontract.schemas._2004._07.databaselibrary;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for WatchlistActionStatusEnum.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="WatchlistActionStatusEnum">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Delete"/>
 *     &lt;enumeration value="Change"/>
 *     &lt;enumeration value="Add"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "WatchlistActionStatusEnum", namespace = "http://schemas.datacontract.org/2004/07/DatabaseLibrary.Enums")
@XmlEnum
public enum WatchlistActionStatusEnum {

    @XmlEnumValue("Delete")
    DELETE("Delete"),
    @XmlEnumValue("Change")
    CHANGE("Change"),
    @XmlEnumValue("Add")
    ADD("Add");
    private final String value;

    WatchlistActionStatusEnum(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static WatchlistActionStatusEnum fromValue(String v) {
        for (WatchlistActionStatusEnum c: WatchlistActionStatusEnum.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
