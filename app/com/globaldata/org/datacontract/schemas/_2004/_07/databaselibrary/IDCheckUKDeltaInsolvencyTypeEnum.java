
package org.datacontract.schemas._2004._07.databaselibrary;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for IDCheckUKDeltaInsolvencyTypeEnum.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="IDCheckUKDeltaInsolvencyTypeEnum">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="NorthernIrelandBankruptcy"/>
 *     &lt;enumeration value="ScottishSequestrationBankruptcy"/>
 *     &lt;enumeration value="EnglandAndWalesIVA"/>
 *     &lt;enumeration value="EnglandAndWalesDRO"/>
 *     &lt;enumeration value="EnglandAndWalesBankruptcy"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "IDCheckUKDeltaInsolvencyTypeEnum", namespace = "http://schemas.datacontract.org/2004/07/DatabaseLibrary.Enums")
@XmlEnum
public enum IDCheckUKDeltaInsolvencyTypeEnum {

    @XmlEnumValue("NorthernIrelandBankruptcy")
    NORTHERN_IRELAND_BANKRUPTCY("NorthernIrelandBankruptcy"),
    @XmlEnumValue("ScottishSequestrationBankruptcy")
    SCOTTISH_SEQUESTRATION_BANKRUPTCY("ScottishSequestrationBankruptcy"),
    @XmlEnumValue("EnglandAndWalesIVA")
    ENGLAND_AND_WALES_IVA("EnglandAndWalesIVA"),
    @XmlEnumValue("EnglandAndWalesDRO")
    ENGLAND_AND_WALES_DRO("EnglandAndWalesDRO"),
    @XmlEnumValue("EnglandAndWalesBankruptcy")
    ENGLAND_AND_WALES_BANKRUPTCY("EnglandAndWalesBankruptcy");
    private final String value;

    IDCheckUKDeltaInsolvencyTypeEnum(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static IDCheckUKDeltaInsolvencyTypeEnum fromValue(String v) {
        for (IDCheckUKDeltaInsolvencyTypeEnum c: IDCheckUKDeltaInsolvencyTypeEnum.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
