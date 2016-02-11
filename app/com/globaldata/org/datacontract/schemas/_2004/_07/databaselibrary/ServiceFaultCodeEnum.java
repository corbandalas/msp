
package org.datacontract.schemas._2004._07.databaselibrary;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ServiceFaultCodeEnum.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ServiceFaultCodeEnum">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="None"/>
 *     &lt;enumeration value="InvalidCredentials"/>
 *     &lt;enumeration value="InvalidServiceBundleName"/>
 *     &lt;enumeration value="AccessDenied"/>
 *     &lt;enumeration value="InternalError"/>
 *     &lt;enumeration value="InvalidClientUser"/>
 *     &lt;enumeration value="DocumentTooLarge"/>
 *     &lt;enumeration value="InvalidImage"/>
 *     &lt;enumeration value="DocumentExpiryInvalid"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ServiceFaultCodeEnum", namespace = "http://schemas.datacontract.org/2004/07/DatabaseLibrary.Enums")
@XmlEnum
public enum ServiceFaultCodeEnum {

    @XmlEnumValue("None")
    NONE("None"),
    @XmlEnumValue("InvalidCredentials")
    INVALID_CREDENTIALS("InvalidCredentials"),
    @XmlEnumValue("InvalidServiceBundleName")
    INVALID_SERVICE_BUNDLE_NAME("InvalidServiceBundleName"),
    @XmlEnumValue("AccessDenied")
    ACCESS_DENIED("AccessDenied"),
    @XmlEnumValue("InternalError")
    INTERNAL_ERROR("InternalError"),
    @XmlEnumValue("InvalidClientUser")
    INVALID_CLIENT_USER("InvalidClientUser"),
    @XmlEnumValue("DocumentTooLarge")
    DOCUMENT_TOO_LARGE("DocumentTooLarge"),
    @XmlEnumValue("InvalidImage")
    INVALID_IMAGE("InvalidImage"),
    @XmlEnumValue("DocumentExpiryInvalid")
    DOCUMENT_EXPIRY_INVALID("DocumentExpiryInvalid");
    private final String value;

    ServiceFaultCodeEnum(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ServiceFaultCodeEnum fromValue(String v) {
        for (ServiceFaultCodeEnum c: ServiceFaultCodeEnum.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
