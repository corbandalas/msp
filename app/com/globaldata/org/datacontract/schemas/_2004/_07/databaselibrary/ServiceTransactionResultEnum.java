
package org.datacontract.schemas._2004._07.databaselibrary;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ServiceTransactionResultEnum.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ServiceTransactionResultEnum">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="None"/>
 *     &lt;enumeration value="Success"/>
 *     &lt;enumeration value="SuccessNoResults"/>
 *     &lt;enumeration value="SuccessIncompleteResults"/>
 *     &lt;enumeration value="MultipleChoices"/>
 *     &lt;enumeration value="ClientErrorInformationFormatInvalid"/>
 *     &lt;enumeration value="ClientErrorInsufficientInformation"/>
 *     &lt;enumeration value="NotExecutedDueToPreviousHalt"/>
 *     &lt;enumeration value="ServerErrorGeneralError"/>
 *     &lt;enumeration value="ServiceFailureError"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ServiceTransactionResultEnum", namespace = "http://schemas.datacontract.org/2004/07/DatabaseLibrary.Enums")
@XmlEnum
public enum ServiceTransactionResultEnum {

    @XmlEnumValue("None")
    NONE("None"),
    @XmlEnumValue("Success")
    SUCCESS("Success"),
    @XmlEnumValue("SuccessNoResults")
    SUCCESS_NO_RESULTS("SuccessNoResults"),
    @XmlEnumValue("SuccessIncompleteResults")
    SUCCESS_INCOMPLETE_RESULTS("SuccessIncompleteResults"),
    @XmlEnumValue("MultipleChoices")
    MULTIPLE_CHOICES("MultipleChoices"),
    @XmlEnumValue("ClientErrorInformationFormatInvalid")
    CLIENT_ERROR_INFORMATION_FORMAT_INVALID("ClientErrorInformationFormatInvalid"),
    @XmlEnumValue("ClientErrorInsufficientInformation")
    CLIENT_ERROR_INSUFFICIENT_INFORMATION("ClientErrorInsufficientInformation"),
    @XmlEnumValue("NotExecutedDueToPreviousHalt")
    NOT_EXECUTED_DUE_TO_PREVIOUS_HALT("NotExecutedDueToPreviousHalt"),
    @XmlEnumValue("ServerErrorGeneralError")
    SERVER_ERROR_GENERAL_ERROR("ServerErrorGeneralError"),
    @XmlEnumValue("ServiceFailureError")
    SERVICE_FAILURE_ERROR("ServiceFailureError");
    private final String value;

    ServiceTransactionResultEnum(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ServiceTransactionResultEnum fromValue(String v) {
        for (ServiceTransactionResultEnum c: ServiceTransactionResultEnum.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
