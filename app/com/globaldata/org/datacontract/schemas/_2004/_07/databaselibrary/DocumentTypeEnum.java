
package org.datacontract.schemas._2004._07.databaselibrary;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for DocumentTypeEnum.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="DocumentTypeEnum">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="None"/>
 *     &lt;enumeration value="JPEG"/>
 *     &lt;enumeration value="PNG"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "DocumentTypeEnum", namespace = "http://schemas.datacontract.org/2004/07/DatabaseLibrary.Enums")
@XmlEnum
public enum DocumentTypeEnum {

    @XmlEnumValue("None")
    NONE("None"),
    JPEG("JPEG"),
    PNG("PNG");
    private final String value;

    DocumentTypeEnum(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static DocumentTypeEnum fromValue(String v) {
        for (DocumentTypeEnum c: DocumentTypeEnum.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
