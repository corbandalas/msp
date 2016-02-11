
package org.datacontract.schemas._2004._07.databaselibrary;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ServiceTransactionResultCategoryEnum.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ServiceTransactionResultCategoryEnum">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Pass"/>
 *     &lt;enumeration value="Fail"/>
 *     &lt;enumeration value="Inconclusive"/>
 *     &lt;enumeration value="NoResults"/>
 *     &lt;enumeration value="OneResult"/>
 *     &lt;enumeration value="MultipleResults"/>
 *     &lt;enumeration value="NotApplicable"/>
 *     &lt;enumeration value="NotPerformed"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ServiceTransactionResultCategoryEnum", namespace = "http://schemas.datacontract.org/2004/07/DatabaseLibrary.Enums")
@XmlEnum
public enum ServiceTransactionResultCategoryEnum {

    @XmlEnumValue("Pass")
    PASS("Pass"),
    @XmlEnumValue("Fail")
    FAIL("Fail"),
    @XmlEnumValue("Inconclusive")
    INCONCLUSIVE("Inconclusive"),
    @XmlEnumValue("NoResults")
    NO_RESULTS("NoResults"),
    @XmlEnumValue("OneResult")
    ONE_RESULT("OneResult"),
    @XmlEnumValue("MultipleResults")
    MULTIPLE_RESULTS("MultipleResults"),
    @XmlEnumValue("NotApplicable")
    NOT_APPLICABLE("NotApplicable"),
    @XmlEnumValue("NotPerformed")
    NOT_PERFORMED("NotPerformed");
    private final String value;

    ServiceTransactionResultCategoryEnum(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ServiceTransactionResultCategoryEnum fromValue(String v) {
        for (ServiceTransactionResultCategoryEnum c: ServiceTransactionResultCategoryEnum.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
