
package org.datacontract.schemas._2004._07.databaselibrary;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ServiceEnum.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ServiceEnum">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="ProfileDetails"/>
 *     &lt;enumeration value="WatchlistCheck"/>
 *     &lt;enumeration value="PEPDeskCheck"/>
 *     &lt;enumeration value="SPFPlusCheck"/>
 *     &lt;enumeration value="SISPlusCheck"/>
 *     &lt;enumeration value="IDCheckUKAlphaFull"/>
 *     &lt;enumeration value="IDCheckUKAlphaEdited"/>
 *     &lt;enumeration value="IDCheckUKDelta"/>
 *     &lt;enumeration value="IDCheckBlank"/>
 *     &lt;enumeration value="IDCheckNameLookup"/>
 *     &lt;enumeration value="IDCheckAddressLookup"/>
 *     &lt;enumeration value="IDCheckPassportMRZ"/>
 *     &lt;enumeration value="IDCheckUKDrivingLicenceNumber"/>
 *     &lt;enumeration value="WatchlistCheckIMM"/>
 *     &lt;enumeration value="SISPlusCheckIMM"/>
 *     &lt;enumeration value="SPFPlusCheckIMM"/>
 *     &lt;enumeration value="DirectorUKCheck"/>
 *     &lt;enumeration value="IDCheckITBravo"/>
 *     &lt;enumeration value="PEPDeskCheckIMM"/>
 *     &lt;enumeration value="IDCheckUKCharlie"/>
 *     &lt;enumeration value="IDDocumentCheck"/>
 *     &lt;enumeration value="IDCheckDEAlpha"/>
 *     &lt;enumeration value="IDCheckNLAlpha"/>
 *     &lt;enumeration value="IDCheckCHBravo"/>
 *     &lt;enumeration value="IDCheckATBravo"/>
 *     &lt;enumeration value="IDCheckZAAlpha"/>
 *     &lt;enumeration value="IDCheckCZBravo"/>
 *     &lt;enumeration value="IDCheckRUBravo"/>
 *     &lt;enumeration value="IDCheckSKBravo"/>
 *     &lt;enumeration value="IDCheckDEBravo"/>
 *     &lt;enumeration value="W2_DATA_IDVCHECK_013"/>
 *     &lt;enumeration value="W2DataEkycUk007"/>
 *     &lt;enumeration value="W2DataAddressLookUp007"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ServiceEnum", namespace = "http://schemas.datacontract.org/2004/07/DatabaseLibrary.Enums")
@XmlEnum
public enum ServiceEnum {

    @XmlEnumValue("ProfileDetails")
    PROFILE_DETAILS("ProfileDetails"),
    @XmlEnumValue("WatchlistCheck")
    WATCHLIST_CHECK("WatchlistCheck"),
    @XmlEnumValue("PEPDeskCheck")
    PEP_DESK_CHECK("PEPDeskCheck"),
    @XmlEnumValue("SPFPlusCheck")
    SPF_PLUS_CHECK("SPFPlusCheck"),
    @XmlEnumValue("SISPlusCheck")
    SIS_PLUS_CHECK("SISPlusCheck"),
    @XmlEnumValue("IDCheckUKAlphaFull")
    ID_CHECK_UK_ALPHA_FULL("IDCheckUKAlphaFull"),
    @XmlEnumValue("IDCheckUKAlphaEdited")
    ID_CHECK_UK_ALPHA_EDITED("IDCheckUKAlphaEdited"),
    @XmlEnumValue("IDCheckUKDelta")
    ID_CHECK_UK_DELTA("IDCheckUKDelta"),
    @XmlEnumValue("IDCheckBlank")
    ID_CHECK_BLANK("IDCheckBlank"),
    @XmlEnumValue("IDCheckNameLookup")
    ID_CHECK_NAME_LOOKUP("IDCheckNameLookup"),
    @XmlEnumValue("IDCheckAddressLookup")
    ID_CHECK_ADDRESS_LOOKUP("IDCheckAddressLookup"),
    @XmlEnumValue("IDCheckPassportMRZ")
    ID_CHECK_PASSPORT_MRZ("IDCheckPassportMRZ"),
    @XmlEnumValue("IDCheckUKDrivingLicenceNumber")
    ID_CHECK_UK_DRIVING_LICENCE_NUMBER("IDCheckUKDrivingLicenceNumber"),
    @XmlEnumValue("WatchlistCheckIMM")
    WATCHLIST_CHECK_IMM("WatchlistCheckIMM"),
    @XmlEnumValue("SISPlusCheckIMM")
    SIS_PLUS_CHECK_IMM("SISPlusCheckIMM"),
    @XmlEnumValue("SPFPlusCheckIMM")
    SPF_PLUS_CHECK_IMM("SPFPlusCheckIMM"),
    @XmlEnumValue("DirectorUKCheck")
    DIRECTOR_UK_CHECK("DirectorUKCheck"),
    @XmlEnumValue("IDCheckITBravo")
    ID_CHECK_IT_BRAVO("IDCheckITBravo"),
    @XmlEnumValue("PEPDeskCheckIMM")
    PEP_DESK_CHECK_IMM("PEPDeskCheckIMM"),
    @XmlEnumValue("IDCheckUKCharlie")
    ID_CHECK_UK_CHARLIE("IDCheckUKCharlie"),
    @XmlEnumValue("IDDocumentCheck")
    ID_DOCUMENT_CHECK("IDDocumentCheck"),
    @XmlEnumValue("IDCheckDEAlpha")
    ID_CHECK_DE_ALPHA("IDCheckDEAlpha"),
    @XmlEnumValue("IDCheckNLAlpha")
    ID_CHECK_NL_ALPHA("IDCheckNLAlpha"),
    @XmlEnumValue("IDCheckCHBravo")
    ID_CHECK_CH_BRAVO("IDCheckCHBravo"),
    @XmlEnumValue("IDCheckATBravo")
    ID_CHECK_AT_BRAVO("IDCheckATBravo"),
    @XmlEnumValue("IDCheckZAAlpha")
    ID_CHECK_ZA_ALPHA("IDCheckZAAlpha"),
    @XmlEnumValue("IDCheckCZBravo")
    ID_CHECK_CZ_BRAVO("IDCheckCZBravo"),
    @XmlEnumValue("IDCheckRUBravo")
    ID_CHECK_RU_BRAVO("IDCheckRUBravo"),
    @XmlEnumValue("IDCheckSKBravo")
    ID_CHECK_SK_BRAVO("IDCheckSKBravo"),
    @XmlEnumValue("IDCheckDEBravo")
    ID_CHECK_DE_BRAVO("IDCheckDEBravo"),
    @XmlEnumValue("W2_DATA_IDVCHECK_013")
    W_2_DATA_IDVCHECK_013("W2_DATA_IDVCHECK_013"),
    @XmlEnumValue("W2DataEkycUk007")
    W_2_DATA_EKYC_UK_007("W2DataEkycUk007"),
    @XmlEnumValue("W2DataAddressLookUp007")
    W_2_DATA_ADDRESS_LOOK_UP_007("W2DataAddressLookUp007");
    private final String value;

    ServiceEnum(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ServiceEnum fromValue(String v) {
        for (ServiceEnum c: ServiceEnum.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
