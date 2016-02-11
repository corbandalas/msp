
package org.datacontract.schemas._2004._07.neuromancerlibrary;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;
import com.microsoft.schemas._2003._10.serialization.arrays.ArrayOfKeyValueOfstringstring;
import org.datacontract.schemas._2004._07.neuromancerlibrary_datacontracts.DirectorUKCheckResult;
import org.datacontract.schemas._2004._07.neuromancerlibrary_datacontracts.DirectorUKDetailsResult;
import org.datacontract.schemas._2004._07.neuromancerlibrary_datacontracts.IDCheckATBravoResult;
import org.datacontract.schemas._2004._07.neuromancerlibrary_datacontracts.IDCheckAddressLookupResult;
import org.datacontract.schemas._2004._07.neuromancerlibrary_datacontracts.IDCheckCHBravoResult;
import org.datacontract.schemas._2004._07.neuromancerlibrary_datacontracts.IDCheckCZBravoResult;
import org.datacontract.schemas._2004._07.neuromancerlibrary_datacontracts.IDCheckDEAlphaResult;
import org.datacontract.schemas._2004._07.neuromancerlibrary_datacontracts.IDCheckDEBravoResult;
import org.datacontract.schemas._2004._07.neuromancerlibrary_datacontracts.IDCheckITBravoResult;
import org.datacontract.schemas._2004._07.neuromancerlibrary_datacontracts.IDCheckNLAlphaResult;
import org.datacontract.schemas._2004._07.neuromancerlibrary_datacontracts.IDCheckNameLookupResult;
import org.datacontract.schemas._2004._07.neuromancerlibrary_datacontracts.IDCheckPassportMRZResult;
import org.datacontract.schemas._2004._07.neuromancerlibrary_datacontracts.IDCheckRUBravoResult;
import org.datacontract.schemas._2004._07.neuromancerlibrary_datacontracts.IDCheckSKBravoResult;
import org.datacontract.schemas._2004._07.neuromancerlibrary_datacontracts.IDCheckUKAlphaResult;
import org.datacontract.schemas._2004._07.neuromancerlibrary_datacontracts.IDCheckUKDeltaResult;
import org.datacontract.schemas._2004._07.neuromancerlibrary_datacontracts.IDCheckUKDrivingLicenceNumberResult;
import org.datacontract.schemas._2004._07.neuromancerlibrary_datacontracts.IDCheckZAAlphaResult;
import org.datacontract.schemas._2004._07.neuromancerlibrary_datacontracts.IDDocumentCheckResult;
import org.datacontract.schemas._2004._07.neuromancerlibrary_datacontracts.PEPDeskCheckResult;
import org.datacontract.schemas._2004._07.neuromancerlibrary_datacontracts.PEPDeskDetailsResult;
import org.datacontract.schemas._2004._07.neuromancerlibrary_datacontracts.SanctionsPlusCheckResult;
import org.datacontract.schemas._2004._07.neuromancerlibrary_datacontracts.SanctionsPlusDetailsResult;
import org.datacontract.schemas._2004._07.neuromancerlibrary_datacontracts.W2DataAddressLookUp007Result;
import org.datacontract.schemas._2004._07.neuromancerlibrary_datacontracts.W2DataEkycUk007Result;
import org.datacontract.schemas._2004._07.neuromancerlibrary_datacontracts.W2DataIdvcheck013Result;
import org.datacontract.schemas._2004._07.neuromancerlibrary_datacontracts.WatchlistCheckResult;
import org.datacontract.schemas._2004._07.neuromancerlibrary_datacontracts.WatchlistDetailsResult;
import org.datacontract.schemas._2004._07.system_collections.ArrayOfKeyValuePairOfstringValidationFailureReasontYKHRTWk;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the org.datacontract.schemas._2004._07.neuromancerlibrary package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _ServiceFault_QNAME = new QName("http://schemas.datacontract.org/2004/07/NeuromancerLibrary.Exceptions", "ServiceFault");
    private final static QName _ServiceValidationResultDetails_QNAME = new QName("http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts", "ServiceValidationResultDetails");
    private final static QName _ServiceRequest_QNAME = new QName("http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts", "ServiceRequest");
    private final static QName _ServiceResponse_QNAME = new QName("http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts", "ServiceResponse");
    private final static QName _BaseResponse_QNAME = new QName("http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts", "BaseResponse");
    private final static QName _ArrayOfUploadedFile_QNAME = new QName("http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts", "ArrayOfUploadedFile");
    private final static QName _ProcessRequestResult_QNAME = new QName("http://schemas.datacontract.org/2004/07/NeuromancerLibrary.Resources", "ProcessRequestResult");
    private final static QName _TransactionInformation_QNAME = new QName("http://schemas.datacontract.org/2004/07/NeuromancerLibrary.Resources", "TransactionInformation");
    private final static QName _ServiceAuthorisation_QNAME = new QName("http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts", "ServiceAuthorisation");
    private final static QName _ServiceTransactionInformation_QNAME = new QName("http://schemas.datacontract.org/2004/07/NeuromancerLibrary.Resources", "ServiceTransactionInformation");
    private final static QName _UploadedFile_QNAME = new QName("http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts", "UploadedFile");
    private final static QName _ProfileDetailsResult_QNAME = new QName("http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts", "ProfileDetailsResult");
    private final static QName _ArrayOfCheckMatch_QNAME = new QName("http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts", "ArrayOfCheckMatch");
    private final static QName _CheckMatch_QNAME = new QName("http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts", "CheckMatch");
    private final static QName _ClientProvidedData_QNAME = new QName("http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts", "ClientProvidedData");
    private final static QName _BundleData_QNAME = new QName("http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts", "BundleData");
    private final static QName _BaseRequest_QNAME = new QName("http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts", "BaseRequest");
    private final static QName _QueryData_QNAME = new QName("http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts", "QueryData");
    private final static QName _ArrayOfServiceTransactionInformation_QNAME = new QName("http://schemas.datacontract.org/2004/07/NeuromancerLibrary.Resources", "ArrayOfServiceTransactionInformation");
    private final static QName _ServiceResult_QNAME = new QName("http://schemas.datacontract.org/2004/07/NeuromancerLibrary.Resources", "ServiceResult");
    private final static QName _QueryDataPlaceOfBirth_QNAME = new QName("http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts", "PlaceOfBirth");
    private final static QName _QueryDataCounty_QNAME = new QName("http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts", "County");
    private final static QName _QueryDataGender_QNAME = new QName("http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts", "Gender");
    private final static QName _QueryDataIdCardNumber_QNAME = new QName("http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts", "IdCardNumber");
    private final static QName _QueryDataDayOfBirth_QNAME = new QName("http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts", "DayOfBirth");
    private final static QName _QueryDataDrivingLicenceNumber_QNAME = new QName("http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts", "DrivingLicenceNumber");
    private final static QName _QueryDataProfileId_QNAME = new QName("http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts", "ProfileId");
    private final static QName _QueryDataHouseNameNumber_QNAME = new QName("http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts", "HouseNameNumber");
    private final static QName _QueryDataMiddleNames_QNAME = new QName("http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts", "MiddleNames");
    private final static QName _QueryDataStreet_QNAME = new QName("http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts", "Street");
    private final static QName _QueryDataNameQueryMatchThreshold_QNAME = new QName("http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts", "NameQueryMatchThreshold");
    private final static QName _QueryDataForename_QNAME = new QName("http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts", "Forename");
    private final static QName _QueryDataYearOfBirth_QNAME = new QName("http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts", "YearOfBirth");
    private final static QName _QueryDataMaiden_QNAME = new QName("http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts", "Maiden");
    private final static QName _QueryDataTaxCode_QNAME = new QName("http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts", "TaxCode");
    private final static QName _QueryDataDateOfBirthMatchThreshold_QNAME = new QName("http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts", "DateOfBirthMatchThreshold");
    private final static QName _QueryDataPostcode_QNAME = new QName("http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts", "Postcode");
    private final static QName _QueryDataCity_QNAME = new QName("http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts", "City");
    private final static QName _QueryDataNationalId_QNAME = new QName("http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts", "NationalId");
    private final static QName _QueryDataNameQuery_QNAME = new QName("http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts", "NameQuery");
    private final static QName _QueryDataSurname_QNAME = new QName("http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts", "Surname");
    private final static QName _QueryDataMonthOfBirth_QNAME = new QName("http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts", "MonthOfBirth");
    private final static QName _QueryDataPassportNumber_QNAME = new QName("http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts", "PassportNumber");
    private final static QName _QueryDataPhoneNumber_QNAME = new QName("http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts", "PhoneNumber");
    private final static QName _QueryDataRegion_QNAME = new QName("http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts", "Region");
    private final static QName _QueryDataFlat_QNAME = new QName("http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts", "Flat");
    private final static QName _QueryDataTravelVisaNumber_QNAME = new QName("http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts", "TravelVisaNumber");
    private final static QName _QueryDataMobileNumber_QNAME = new QName("http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts", "MobileNumber");
    private final static QName _ServiceFaultErrorMessage_QNAME = new QName("http://schemas.datacontract.org/2004/07/NeuromancerLibrary.Exceptions", "ErrorMessage");
    private final static QName _ServiceFaultServiceCallReference_QNAME = new QName("http://schemas.datacontract.org/2004/07/NeuromancerLibrary.Exceptions", "ServiceCallReference");
    private final static QName _CheckMatchDateOfBirthMatchScore_QNAME = new QName("http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts", "DateOfBirthMatchScore");
    private final static QName _CheckMatchName_QNAME = new QName("http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts", "Name");
    private final static QName _CheckMatchBirthDay_QNAME = new QName("http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts", "BirthDay");
    private final static QName _CheckMatchBirthMonth_QNAME = new QName("http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts", "BirthMonth");
    private final static QName _CheckMatchBirthYear_QNAME = new QName("http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts", "BirthYear");
    private final static QName _ServiceRequestQueryOptions_QNAME = new QName("http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts", "QueryOptions");
    private final static QName _ServiceRequestUploadedFiles_QNAME = new QName("http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts", "UploadedFiles");
    private final static QName _ServiceValidationResultDetailsValidationFailureReasons_QNAME = new QName("http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts", "ValidationFailureReasons");
    private final static QName _BundleDataBundleName_QNAME = new QName("http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts", "BundleName");
    private final static QName _ServiceResultIDCheckITBravoResult_QNAME = new QName("http://schemas.datacontract.org/2004/07/NeuromancerLibrary.Resources", "IDCheckITBravoResult");
    private final static QName _ServiceResultSPFPlusCheckResult_QNAME = new QName("http://schemas.datacontract.org/2004/07/NeuromancerLibrary.Resources", "SPFPlusCheckResult");
    private final static QName _ServiceResultWatchlistCheckResult_QNAME = new QName("http://schemas.datacontract.org/2004/07/NeuromancerLibrary.Resources", "WatchlistCheckResult");
    private final static QName _ServiceResultIDCheckCHBravoResult_QNAME = new QName("http://schemas.datacontract.org/2004/07/NeuromancerLibrary.Resources", "IDCheckCHBravoResult");
    private final static QName _ServiceResultIDCheckPassportMRZResult_QNAME = new QName("http://schemas.datacontract.org/2004/07/NeuromancerLibrary.Resources", "IDCheckPassportMRZResult");
    private final static QName _ServiceResultIDCheckDEAlphaResult_QNAME = new QName("http://schemas.datacontract.org/2004/07/NeuromancerLibrary.Resources", "IDCheckDEAlphaResult");
    private final static QName _ServiceResultSISPlusCheckResult_QNAME = new QName("http://schemas.datacontract.org/2004/07/NeuromancerLibrary.Resources", "SISPlusCheckResult");
    private final static QName _ServiceResultIDCheckCZBravoResult_QNAME = new QName("http://schemas.datacontract.org/2004/07/NeuromancerLibrary.Resources", "IDCheckCZBravoResult");
    private final static QName _ServiceResultIDCheckNameLookupResult_QNAME = new QName("http://schemas.datacontract.org/2004/07/NeuromancerLibrary.Resources", "IDCheckNameLookupResult");
    private final static QName _ServiceResultW2DataIdvcheck013Result_QNAME = new QName("http://schemas.datacontract.org/2004/07/NeuromancerLibrary.Resources", "W2DataIdvcheck013Result");
    private final static QName _ServiceResultW2DataAddressLookUp007Result_QNAME = new QName("http://schemas.datacontract.org/2004/07/NeuromancerLibrary.Resources", "W2DataAddressLookUp007Result");
    private final static QName _ServiceResultIDCheckATBravoResult_QNAME = new QName("http://schemas.datacontract.org/2004/07/NeuromancerLibrary.Resources", "IDCheckATBravoResult");
    private final static QName _ServiceResultIDCheckUKDrivingLicenceNumberResult_QNAME = new QName("http://schemas.datacontract.org/2004/07/NeuromancerLibrary.Resources", "IDCheckUKDrivingLicenceNumberResult");
    private final static QName _ServiceResultIDDocumentCheckResult_QNAME = new QName("http://schemas.datacontract.org/2004/07/NeuromancerLibrary.Resources", "IDDocumentCheckResult");
    private final static QName _ServiceResultIDCheckAddressLookupResult_QNAME = new QName("http://schemas.datacontract.org/2004/07/NeuromancerLibrary.Resources", "IDCheckAddressLookupResult");
    private final static QName _ServiceResultProfileDetailsResult_QNAME = new QName("http://schemas.datacontract.org/2004/07/NeuromancerLibrary.Resources", "ProfileDetailsResult");
    private final static QName _ServiceResultW2DataEkycUk007Result_QNAME = new QName("http://schemas.datacontract.org/2004/07/NeuromancerLibrary.Resources", "W2DataEkycUk007Result");
    private final static QName _ServiceResultIDCheckZAAlphaResult_QNAME = new QName("http://schemas.datacontract.org/2004/07/NeuromancerLibrary.Resources", "IDCheckZAAlphaResult");
    private final static QName _ServiceResultIDCheckSKBravoResult_QNAME = new QName("http://schemas.datacontract.org/2004/07/NeuromancerLibrary.Resources", "IDCheckSKBravoResult");
    private final static QName _ServiceResultIDCheckUKAlphaResult_QNAME = new QName("http://schemas.datacontract.org/2004/07/NeuromancerLibrary.Resources", "IDCheckUKAlphaResult");
    private final static QName _ServiceResultDirectorUKCheckResult_QNAME = new QName("http://schemas.datacontract.org/2004/07/NeuromancerLibrary.Resources", "DirectorUKCheckResult");
    private final static QName _ServiceResultIDCheckUKDeltaResult_QNAME = new QName("http://schemas.datacontract.org/2004/07/NeuromancerLibrary.Resources", "IDCheckUKDeltaResult");
    private final static QName _ServiceResultPEPDeskCheckResult_QNAME = new QName("http://schemas.datacontract.org/2004/07/NeuromancerLibrary.Resources", "PEPDeskCheckResult");
    private final static QName _ServiceResultIDCheckRUBravoResult_QNAME = new QName("http://schemas.datacontract.org/2004/07/NeuromancerLibrary.Resources", "IDCheckRUBravoResult");
    private final static QName _ServiceResultIDCheckDEBravoResult_QNAME = new QName("http://schemas.datacontract.org/2004/07/NeuromancerLibrary.Resources", "IDCheckDEBravoResult");
    private final static QName _ServiceResultIDCheckNLAlphaResult_QNAME = new QName("http://schemas.datacontract.org/2004/07/NeuromancerLibrary.Resources", "IDCheckNLAlphaResult");
    private final static QName _UploadedFileDocumentReference_QNAME = new QName("http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts", "DocumentReference");
    private final static QName _UploadedFileIndex_QNAME = new QName("http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts", "Index");
    private final static QName _UploadedFileGroup_QNAME = new QName("http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts", "Group");
    private final static QName _TransactionInformationServiceTransactions_QNAME = new QName("http://schemas.datacontract.org/2004/07/NeuromancerLibrary.Resources", "ServiceTransactions");
    private final static QName _TransactionInformationServiceCallReference_QNAME = new QName("http://schemas.datacontract.org/2004/07/NeuromancerLibrary.Resources", "ServiceCallReference");
    private final static QName _ClientProvidedDataClientUser_QNAME = new QName("http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts", "ClientUser");
    private final static QName _ClientProvidedDataClientReference_QNAME = new QName("http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts", "ClientReference");
    private final static QName _ClientProvidedDataClientSubaccount_QNAME = new QName("http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts", "ClientSubaccount");
    private final static QName _ClientProvidedDataRefersToServiceCallReference_QNAME = new QName("http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts", "RefersToServiceCallReference");
    private final static QName _ServiceResponseProcessRequestResult_QNAME = new QName("http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts", "ProcessRequestResult");
    private final static QName _ServiceAuthorisationAPIKey_QNAME = new QName("http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts", "APIKey");
    private final static QName _ProfileDetailsResultDirectorUKDetailsResult_QNAME = new QName("http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts", "DirectorUKDetailsResult");
    private final static QName _ProfileDetailsResultWatchlistDetailsResult_QNAME = new QName("http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts", "WatchlistDetailsResult");
    private final static QName _ProfileDetailsResultSPFPlusDetailsResult_QNAME = new QName("http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts", "SPFPlusDetailsResult");
    private final static QName _ProfileDetailsResultPEPDeskDetailsResult_QNAME = new QName("http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts", "PEPDeskDetailsResult");
    private final static QName _ProfileDetailsResultSISPlusDetailsResult_QNAME = new QName("http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts", "SISPlusDetailsResult");
    private final static QName _ServiceTransactionInformationServiceTransactionResultMessage_QNAME = new QName("http://schemas.datacontract.org/2004/07/NeuromancerLibrary.Resources", "ServiceTransactionResultMessage");
    private final static QName _ServiceTransactionInformationServiceValidationDetails_QNAME = new QName("http://schemas.datacontract.org/2004/07/NeuromancerLibrary.Resources", "ServiceValidationDetails");
    private final static QName _ServiceTransactionInformationFailedOverTo_QNAME = new QName("http://schemas.datacontract.org/2004/07/NeuromancerLibrary.Resources", "FailedOverTo");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: org.datacontract.schemas._2004._07.neuromancerlibrary
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ServiceResponse }
     * 
     */
    public ServiceResponse createServiceResponse() {
        return new ServiceResponse();
    }

    /**
     * Create an instance of {@link ServiceRequest }
     * 
     */
    public ServiceRequest createServiceRequest() {
        return new ServiceRequest();
    }

    /**
     * Create an instance of {@link ArrayOfUploadedFile }
     * 
     */
    public ArrayOfUploadedFile createArrayOfUploadedFile() {
        return new ArrayOfUploadedFile();
    }

    /**
     * Create an instance of {@link QueryData }
     * 
     */
    public QueryData createQueryData() {
        return new QueryData();
    }

    /**
     * Create an instance of {@link ProfileDetailsResult }
     * 
     */
    public ProfileDetailsResult createProfileDetailsResult() {
        return new ProfileDetailsResult();
    }

    /**
     * Create an instance of {@link BundleData }
     * 
     */
    public BundleData createBundleData() {
        return new BundleData();
    }

    /**
     * Create an instance of {@link BaseResponse }
     * 
     */
    public BaseResponse createBaseResponse() {
        return new BaseResponse();
    }

    /**
     * Create an instance of {@link ServiceAuthorisation }
     * 
     */
    public ServiceAuthorisation createServiceAuthorisation() {
        return new ServiceAuthorisation();
    }

    /**
     * Create an instance of {@link UploadedFile }
     * 
     */
    public UploadedFile createUploadedFile() {
        return new UploadedFile();
    }

    /**
     * Create an instance of {@link ServiceValidationResultDetails }
     * 
     */
    public ServiceValidationResultDetails createServiceValidationResultDetails() {
        return new ServiceValidationResultDetails();
    }

    /**
     * Create an instance of {@link ClientProvidedData }
     * 
     */
    public ClientProvidedData createClientProvidedData() {
        return new ClientProvidedData();
    }

    /**
     * Create an instance of {@link ArrayOfCheckMatch }
     * 
     */
    public ArrayOfCheckMatch createArrayOfCheckMatch() {
        return new ArrayOfCheckMatch();
    }

    /**
     * Create an instance of {@link BaseRequest }
     * 
     */
    public BaseRequest createBaseRequest() {
        return new BaseRequest();
    }

    /**
     * Create an instance of {@link CheckMatch }
     * 
     */
    public CheckMatch createCheckMatch() {
        return new CheckMatch();
    }

    /**
     * Create an instance of {@link TransactionInformation }
     * 
     */
    public TransactionInformation createTransactionInformation() {
        return new TransactionInformation();
    }

    /**
     * Create an instance of {@link ServiceResult }
     * 
     */
    public ServiceResult createServiceResult() {
        return new ServiceResult();
    }

    /**
     * Create an instance of {@link ArrayOfServiceTransactionInformation }
     * 
     */
    public ArrayOfServiceTransactionInformation createArrayOfServiceTransactionInformation() {
        return new ArrayOfServiceTransactionInformation();
    }

    /**
     * Create an instance of {@link ProcessRequestResult }
     * 
     */
    public ProcessRequestResult createProcessRequestResult() {
        return new ProcessRequestResult();
    }

    /**
     * Create an instance of {@link ServiceTransactionInformation }
     * 
     */
    public ServiceTransactionInformation createServiceTransactionInformation() {
        return new ServiceTransactionInformation();
    }

    /**
     * Create an instance of {@link ServiceFault }
     * 
     */
    public ServiceFault createServiceFault() {
        return new ServiceFault();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ServiceFault }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.Exceptions", name = "ServiceFault")
    public JAXBElement<ServiceFault> createServiceFault(ServiceFault value) {
        return new JAXBElement<ServiceFault>(_ServiceFault_QNAME, ServiceFault.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ServiceValidationResultDetails }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts", name = "ServiceValidationResultDetails")
    public JAXBElement<ServiceValidationResultDetails> createServiceValidationResultDetails(ServiceValidationResultDetails value) {
        return new JAXBElement<ServiceValidationResultDetails>(_ServiceValidationResultDetails_QNAME, ServiceValidationResultDetails.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ServiceRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts", name = "ServiceRequest")
    public JAXBElement<ServiceRequest> createServiceRequest(ServiceRequest value) {
        return new JAXBElement<ServiceRequest>(_ServiceRequest_QNAME, ServiceRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ServiceResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts", name = "ServiceResponse")
    public JAXBElement<ServiceResponse> createServiceResponse(ServiceResponse value) {
        return new JAXBElement<ServiceResponse>(_ServiceResponse_QNAME, ServiceResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BaseResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts", name = "BaseResponse")
    public JAXBElement<BaseResponse> createBaseResponse(BaseResponse value) {
        return new JAXBElement<BaseResponse>(_BaseResponse_QNAME, BaseResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfUploadedFile }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts", name = "ArrayOfUploadedFile")
    public JAXBElement<ArrayOfUploadedFile> createArrayOfUploadedFile(ArrayOfUploadedFile value) {
        return new JAXBElement<ArrayOfUploadedFile>(_ArrayOfUploadedFile_QNAME, ArrayOfUploadedFile.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ProcessRequestResult }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.Resources", name = "ProcessRequestResult")
    public JAXBElement<ProcessRequestResult> createProcessRequestResult(ProcessRequestResult value) {
        return new JAXBElement<ProcessRequestResult>(_ProcessRequestResult_QNAME, ProcessRequestResult.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TransactionInformation }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.Resources", name = "TransactionInformation")
    public JAXBElement<TransactionInformation> createTransactionInformation(TransactionInformation value) {
        return new JAXBElement<TransactionInformation>(_TransactionInformation_QNAME, TransactionInformation.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ServiceAuthorisation }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts", name = "ServiceAuthorisation")
    public JAXBElement<ServiceAuthorisation> createServiceAuthorisation(ServiceAuthorisation value) {
        return new JAXBElement<ServiceAuthorisation>(_ServiceAuthorisation_QNAME, ServiceAuthorisation.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ServiceTransactionInformation }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.Resources", name = "ServiceTransactionInformation")
    public JAXBElement<ServiceTransactionInformation> createServiceTransactionInformation(ServiceTransactionInformation value) {
        return new JAXBElement<ServiceTransactionInformation>(_ServiceTransactionInformation_QNAME, ServiceTransactionInformation.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UploadedFile }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts", name = "UploadedFile")
    public JAXBElement<UploadedFile> createUploadedFile(UploadedFile value) {
        return new JAXBElement<UploadedFile>(_UploadedFile_QNAME, UploadedFile.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ProfileDetailsResult }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts", name = "ProfileDetailsResult")
    public JAXBElement<ProfileDetailsResult> createProfileDetailsResult(ProfileDetailsResult value) {
        return new JAXBElement<ProfileDetailsResult>(_ProfileDetailsResult_QNAME, ProfileDetailsResult.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfCheckMatch }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts", name = "ArrayOfCheckMatch")
    public JAXBElement<ArrayOfCheckMatch> createArrayOfCheckMatch(ArrayOfCheckMatch value) {
        return new JAXBElement<ArrayOfCheckMatch>(_ArrayOfCheckMatch_QNAME, ArrayOfCheckMatch.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CheckMatch }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts", name = "CheckMatch")
    public JAXBElement<CheckMatch> createCheckMatch(CheckMatch value) {
        return new JAXBElement<CheckMatch>(_CheckMatch_QNAME, CheckMatch.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ClientProvidedData }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts", name = "ClientProvidedData")
    public JAXBElement<ClientProvidedData> createClientProvidedData(ClientProvidedData value) {
        return new JAXBElement<ClientProvidedData>(_ClientProvidedData_QNAME, ClientProvidedData.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BundleData }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts", name = "BundleData")
    public JAXBElement<BundleData> createBundleData(BundleData value) {
        return new JAXBElement<BundleData>(_BundleData_QNAME, BundleData.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BaseRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts", name = "BaseRequest")
    public JAXBElement<BaseRequest> createBaseRequest(BaseRequest value) {
        return new JAXBElement<BaseRequest>(_BaseRequest_QNAME, BaseRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link QueryData }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts", name = "QueryData")
    public JAXBElement<QueryData> createQueryData(QueryData value) {
        return new JAXBElement<QueryData>(_QueryData_QNAME, QueryData.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfServiceTransactionInformation }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.Resources", name = "ArrayOfServiceTransactionInformation")
    public JAXBElement<ArrayOfServiceTransactionInformation> createArrayOfServiceTransactionInformation(ArrayOfServiceTransactionInformation value) {
        return new JAXBElement<ArrayOfServiceTransactionInformation>(_ArrayOfServiceTransactionInformation_QNAME, ArrayOfServiceTransactionInformation.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ServiceResult }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.Resources", name = "ServiceResult")
    public JAXBElement<ServiceResult> createServiceResult(ServiceResult value) {
        return new JAXBElement<ServiceResult>(_ServiceResult_QNAME, ServiceResult.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts", name = "PlaceOfBirth", scope = QueryData.class)
    public JAXBElement<String> createQueryDataPlaceOfBirth(String value) {
        return new JAXBElement<String>(_QueryDataPlaceOfBirth_QNAME, String.class, QueryData.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts", name = "County", scope = QueryData.class)
    public JAXBElement<String> createQueryDataCounty(String value) {
        return new JAXBElement<String>(_QueryDataCounty_QNAME, String.class, QueryData.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts", name = "Gender", scope = QueryData.class)
    public JAXBElement<String> createQueryDataGender(String value) {
        return new JAXBElement<String>(_QueryDataGender_QNAME, String.class, QueryData.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts", name = "IdCardNumber", scope = QueryData.class)
    public JAXBElement<String> createQueryDataIdCardNumber(String value) {
        return new JAXBElement<String>(_QueryDataIdCardNumber_QNAME, String.class, QueryData.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts", name = "DayOfBirth", scope = QueryData.class)
    public JAXBElement<Integer> createQueryDataDayOfBirth(Integer value) {
        return new JAXBElement<Integer>(_QueryDataDayOfBirth_QNAME, Integer.class, QueryData.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts", name = "DrivingLicenceNumber", scope = QueryData.class)
    public JAXBElement<String> createQueryDataDrivingLicenceNumber(String value) {
        return new JAXBElement<String>(_QueryDataDrivingLicenceNumber_QNAME, String.class, QueryData.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts", name = "ProfileId", scope = QueryData.class)
    public JAXBElement<String> createQueryDataProfileId(String value) {
        return new JAXBElement<String>(_QueryDataProfileId_QNAME, String.class, QueryData.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts", name = "HouseNameNumber", scope = QueryData.class)
    public JAXBElement<String> createQueryDataHouseNameNumber(String value) {
        return new JAXBElement<String>(_QueryDataHouseNameNumber_QNAME, String.class, QueryData.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts", name = "MiddleNames", scope = QueryData.class)
    public JAXBElement<String> createQueryDataMiddleNames(String value) {
        return new JAXBElement<String>(_QueryDataMiddleNames_QNAME, String.class, QueryData.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts", name = "Street", scope = QueryData.class)
    public JAXBElement<String> createQueryDataStreet(String value) {
        return new JAXBElement<String>(_QueryDataStreet_QNAME, String.class, QueryData.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts", name = "NameQueryMatchThreshold", scope = QueryData.class)
    public JAXBElement<Integer> createQueryDataNameQueryMatchThreshold(Integer value) {
        return new JAXBElement<Integer>(_QueryDataNameQueryMatchThreshold_QNAME, Integer.class, QueryData.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts", name = "Forename", scope = QueryData.class)
    public JAXBElement<String> createQueryDataForename(String value) {
        return new JAXBElement<String>(_QueryDataForename_QNAME, String.class, QueryData.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts", name = "YearOfBirth", scope = QueryData.class)
    public JAXBElement<Integer> createQueryDataYearOfBirth(Integer value) {
        return new JAXBElement<Integer>(_QueryDataYearOfBirth_QNAME, Integer.class, QueryData.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts", name = "Maiden", scope = QueryData.class)
    public JAXBElement<String> createQueryDataMaiden(String value) {
        return new JAXBElement<String>(_QueryDataMaiden_QNAME, String.class, QueryData.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts", name = "TaxCode", scope = QueryData.class)
    public JAXBElement<String> createQueryDataTaxCode(String value) {
        return new JAXBElement<String>(_QueryDataTaxCode_QNAME, String.class, QueryData.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts", name = "DateOfBirthMatchThreshold", scope = QueryData.class)
    public JAXBElement<Integer> createQueryDataDateOfBirthMatchThreshold(Integer value) {
        return new JAXBElement<Integer>(_QueryDataDateOfBirthMatchThreshold_QNAME, Integer.class, QueryData.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts", name = "Postcode", scope = QueryData.class)
    public JAXBElement<String> createQueryDataPostcode(String value) {
        return new JAXBElement<String>(_QueryDataPostcode_QNAME, String.class, QueryData.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts", name = "City", scope = QueryData.class)
    public JAXBElement<String> createQueryDataCity(String value) {
        return new JAXBElement<String>(_QueryDataCity_QNAME, String.class, QueryData.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts", name = "NationalId", scope = QueryData.class)
    public JAXBElement<String> createQueryDataNationalId(String value) {
        return new JAXBElement<String>(_QueryDataNationalId_QNAME, String.class, QueryData.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts", name = "NameQuery", scope = QueryData.class)
    public JAXBElement<String> createQueryDataNameQuery(String value) {
        return new JAXBElement<String>(_QueryDataNameQuery_QNAME, String.class, QueryData.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts", name = "Surname", scope = QueryData.class)
    public JAXBElement<String> createQueryDataSurname(String value) {
        return new JAXBElement<String>(_QueryDataSurname_QNAME, String.class, QueryData.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts", name = "MonthOfBirth", scope = QueryData.class)
    public JAXBElement<Integer> createQueryDataMonthOfBirth(Integer value) {
        return new JAXBElement<Integer>(_QueryDataMonthOfBirth_QNAME, Integer.class, QueryData.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts", name = "PassportNumber", scope = QueryData.class)
    public JAXBElement<String> createQueryDataPassportNumber(String value) {
        return new JAXBElement<String>(_QueryDataPassportNumber_QNAME, String.class, QueryData.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts", name = "PhoneNumber", scope = QueryData.class)
    public JAXBElement<String> createQueryDataPhoneNumber(String value) {
        return new JAXBElement<String>(_QueryDataPhoneNumber_QNAME, String.class, QueryData.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts", name = "Region", scope = QueryData.class)
    public JAXBElement<String> createQueryDataRegion(String value) {
        return new JAXBElement<String>(_QueryDataRegion_QNAME, String.class, QueryData.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts", name = "Flat", scope = QueryData.class)
    public JAXBElement<String> createQueryDataFlat(String value) {
        return new JAXBElement<String>(_QueryDataFlat_QNAME, String.class, QueryData.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts", name = "TravelVisaNumber", scope = QueryData.class)
    public JAXBElement<String> createQueryDataTravelVisaNumber(String value) {
        return new JAXBElement<String>(_QueryDataTravelVisaNumber_QNAME, String.class, QueryData.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts", name = "MobileNumber", scope = QueryData.class)
    public JAXBElement<String> createQueryDataMobileNumber(String value) {
        return new JAXBElement<String>(_QueryDataMobileNumber_QNAME, String.class, QueryData.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.Exceptions", name = "ErrorMessage", scope = ServiceFault.class)
    public JAXBElement<String> createServiceFaultErrorMessage(String value) {
        return new JAXBElement<String>(_ServiceFaultErrorMessage_QNAME, String.class, ServiceFault.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.Exceptions", name = "ServiceCallReference", scope = ServiceFault.class)
    public JAXBElement<String> createServiceFaultServiceCallReference(String value) {
        return new JAXBElement<String>(_ServiceFaultServiceCallReference_QNAME, String.class, ServiceFault.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts", name = "DateOfBirthMatchScore", scope = CheckMatch.class)
    public JAXBElement<Integer> createCheckMatchDateOfBirthMatchScore(Integer value) {
        return new JAXBElement<Integer>(_CheckMatchDateOfBirthMatchScore_QNAME, Integer.class, CheckMatch.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts", name = "Name", scope = CheckMatch.class)
    public JAXBElement<String> createCheckMatchName(String value) {
        return new JAXBElement<String>(_CheckMatchName_QNAME, String.class, CheckMatch.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts", name = "BirthDay", scope = CheckMatch.class)
    public JAXBElement<Integer> createCheckMatchBirthDay(Integer value) {
        return new JAXBElement<Integer>(_CheckMatchBirthDay_QNAME, Integer.class, CheckMatch.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts", name = "BirthMonth", scope = CheckMatch.class)
    public JAXBElement<Integer> createCheckMatchBirthMonth(Integer value) {
        return new JAXBElement<Integer>(_CheckMatchBirthMonth_QNAME, Integer.class, CheckMatch.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts", name = "BirthYear", scope = CheckMatch.class)
    public JAXBElement<Integer> createCheckMatchBirthYear(Integer value) {
        return new JAXBElement<Integer>(_CheckMatchBirthYear_QNAME, Integer.class, CheckMatch.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts", name = "ProfileId", scope = CheckMatch.class)
    public JAXBElement<String> createCheckMatchProfileId(String value) {
        return new JAXBElement<String>(_QueryDataProfileId_QNAME, String.class, CheckMatch.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ServiceResult }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.Resources", name = "ServiceResult", scope = ProcessRequestResult.class)
    public JAXBElement<ServiceResult> createProcessRequestResultServiceResult(ServiceResult value) {
        return new JAXBElement<ServiceResult>(_ServiceResult_QNAME, ServiceResult.class, ProcessRequestResult.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TransactionInformation }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.Resources", name = "TransactionInformation", scope = ProcessRequestResult.class)
    public JAXBElement<TransactionInformation> createProcessRequestResultTransactionInformation(TransactionInformation value) {
        return new JAXBElement<TransactionInformation>(_TransactionInformation_QNAME, TransactionInformation.class, ProcessRequestResult.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BundleData }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts", name = "BundleData", scope = ServiceRequest.class)
    public JAXBElement<BundleData> createServiceRequestBundleData(BundleData value) {
        return new JAXBElement<BundleData>(_BundleData_QNAME, BundleData.class, ServiceRequest.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfKeyValueOfstringstring }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts", name = "QueryOptions", scope = ServiceRequest.class)
    public JAXBElement<ArrayOfKeyValueOfstringstring> createServiceRequestQueryOptions(ArrayOfKeyValueOfstringstring value) {
        return new JAXBElement<ArrayOfKeyValueOfstringstring>(_ServiceRequestQueryOptions_QNAME, ArrayOfKeyValueOfstringstring.class, ServiceRequest.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link QueryData }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts", name = "QueryData", scope = ServiceRequest.class)
    public JAXBElement<QueryData> createServiceRequestQueryData(QueryData value) {
        return new JAXBElement<QueryData>(_QueryData_QNAME, QueryData.class, ServiceRequest.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ServiceAuthorisation }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts", name = "ServiceAuthorisation", scope = ServiceRequest.class)
    public JAXBElement<ServiceAuthorisation> createServiceRequestServiceAuthorisation(ServiceAuthorisation value) {
        return new JAXBElement<ServiceAuthorisation>(_ServiceAuthorisation_QNAME, ServiceAuthorisation.class, ServiceRequest.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfUploadedFile }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts", name = "UploadedFiles", scope = ServiceRequest.class)
    public JAXBElement<ArrayOfUploadedFile> createServiceRequestUploadedFiles(ArrayOfUploadedFile value) {
        return new JAXBElement<ArrayOfUploadedFile>(_ServiceRequestUploadedFiles_QNAME, ArrayOfUploadedFile.class, ServiceRequest.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfKeyValuePairOfstringValidationFailureReasontYKHRTWk }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts", name = "ValidationFailureReasons", scope = ServiceValidationResultDetails.class)
    public JAXBElement<ArrayOfKeyValuePairOfstringValidationFailureReasontYKHRTWk> createServiceValidationResultDetailsValidationFailureReasons(ArrayOfKeyValuePairOfstringValidationFailureReasontYKHRTWk value) {
        return new JAXBElement<ArrayOfKeyValuePairOfstringValidationFailureReasontYKHRTWk>(_ServiceValidationResultDetailsValidationFailureReasons_QNAME, ArrayOfKeyValuePairOfstringValidationFailureReasontYKHRTWk.class, ServiceValidationResultDetails.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts", name = "BundleName", scope = BundleData.class)
    public JAXBElement<String> createBundleDataBundleName(String value) {
        return new JAXBElement<String>(_BundleDataBundleName_QNAME, String.class, BundleData.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link IDCheckITBravoResult }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.Resources", name = "IDCheckITBravoResult", scope = ServiceResult.class)
    public JAXBElement<IDCheckITBravoResult> createServiceResultIDCheckITBravoResult(IDCheckITBravoResult value) {
        return new JAXBElement<IDCheckITBravoResult>(_ServiceResultIDCheckITBravoResult_QNAME, IDCheckITBravoResult.class, ServiceResult.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SanctionsPlusCheckResult }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.Resources", name = "SPFPlusCheckResult", scope = ServiceResult.class)
    public JAXBElement<SanctionsPlusCheckResult> createServiceResultSPFPlusCheckResult(SanctionsPlusCheckResult value) {
        return new JAXBElement<SanctionsPlusCheckResult>(_ServiceResultSPFPlusCheckResult_QNAME, SanctionsPlusCheckResult.class, ServiceResult.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link WatchlistCheckResult }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.Resources", name = "WatchlistCheckResult", scope = ServiceResult.class)
    public JAXBElement<WatchlistCheckResult> createServiceResultWatchlistCheckResult(WatchlistCheckResult value) {
        return new JAXBElement<WatchlistCheckResult>(_ServiceResultWatchlistCheckResult_QNAME, WatchlistCheckResult.class, ServiceResult.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link IDCheckCHBravoResult }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.Resources", name = "IDCheckCHBravoResult", scope = ServiceResult.class)
    public JAXBElement<IDCheckCHBravoResult> createServiceResultIDCheckCHBravoResult(IDCheckCHBravoResult value) {
        return new JAXBElement<IDCheckCHBravoResult>(_ServiceResultIDCheckCHBravoResult_QNAME, IDCheckCHBravoResult.class, ServiceResult.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link IDCheckPassportMRZResult }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.Resources", name = "IDCheckPassportMRZResult", scope = ServiceResult.class)
    public JAXBElement<IDCheckPassportMRZResult> createServiceResultIDCheckPassportMRZResult(IDCheckPassportMRZResult value) {
        return new JAXBElement<IDCheckPassportMRZResult>(_ServiceResultIDCheckPassportMRZResult_QNAME, IDCheckPassportMRZResult.class, ServiceResult.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link IDCheckDEAlphaResult }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.Resources", name = "IDCheckDEAlphaResult", scope = ServiceResult.class)
    public JAXBElement<IDCheckDEAlphaResult> createServiceResultIDCheckDEAlphaResult(IDCheckDEAlphaResult value) {
        return new JAXBElement<IDCheckDEAlphaResult>(_ServiceResultIDCheckDEAlphaResult_QNAME, IDCheckDEAlphaResult.class, ServiceResult.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SanctionsPlusCheckResult }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.Resources", name = "SISPlusCheckResult", scope = ServiceResult.class)
    public JAXBElement<SanctionsPlusCheckResult> createServiceResultSISPlusCheckResult(SanctionsPlusCheckResult value) {
        return new JAXBElement<SanctionsPlusCheckResult>(_ServiceResultSISPlusCheckResult_QNAME, SanctionsPlusCheckResult.class, ServiceResult.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link IDCheckCZBravoResult }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.Resources", name = "IDCheckCZBravoResult", scope = ServiceResult.class)
    public JAXBElement<IDCheckCZBravoResult> createServiceResultIDCheckCZBravoResult(IDCheckCZBravoResult value) {
        return new JAXBElement<IDCheckCZBravoResult>(_ServiceResultIDCheckCZBravoResult_QNAME, IDCheckCZBravoResult.class, ServiceResult.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link IDCheckNameLookupResult }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.Resources", name = "IDCheckNameLookupResult", scope = ServiceResult.class)
    public JAXBElement<IDCheckNameLookupResult> createServiceResultIDCheckNameLookupResult(IDCheckNameLookupResult value) {
        return new JAXBElement<IDCheckNameLookupResult>(_ServiceResultIDCheckNameLookupResult_QNAME, IDCheckNameLookupResult.class, ServiceResult.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link W2DataIdvcheck013Result }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.Resources", name = "W2DataIdvcheck013Result", scope = ServiceResult.class)
    public JAXBElement<W2DataIdvcheck013Result> createServiceResultW2DataIdvcheck013Result(W2DataIdvcheck013Result value) {
        return new JAXBElement<W2DataIdvcheck013Result>(_ServiceResultW2DataIdvcheck013Result_QNAME, W2DataIdvcheck013Result.class, ServiceResult.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link W2DataAddressLookUp007Result }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.Resources", name = "W2DataAddressLookUp007Result", scope = ServiceResult.class)
    public JAXBElement<W2DataAddressLookUp007Result> createServiceResultW2DataAddressLookUp007Result(W2DataAddressLookUp007Result value) {
        return new JAXBElement<W2DataAddressLookUp007Result>(_ServiceResultW2DataAddressLookUp007Result_QNAME, W2DataAddressLookUp007Result.class, ServiceResult.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link IDCheckATBravoResult }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.Resources", name = "IDCheckATBravoResult", scope = ServiceResult.class)
    public JAXBElement<IDCheckATBravoResult> createServiceResultIDCheckATBravoResult(IDCheckATBravoResult value) {
        return new JAXBElement<IDCheckATBravoResult>(_ServiceResultIDCheckATBravoResult_QNAME, IDCheckATBravoResult.class, ServiceResult.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link IDCheckUKDrivingLicenceNumberResult }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.Resources", name = "IDCheckUKDrivingLicenceNumberResult", scope = ServiceResult.class)
    public JAXBElement<IDCheckUKDrivingLicenceNumberResult> createServiceResultIDCheckUKDrivingLicenceNumberResult(IDCheckUKDrivingLicenceNumberResult value) {
        return new JAXBElement<IDCheckUKDrivingLicenceNumberResult>(_ServiceResultIDCheckUKDrivingLicenceNumberResult_QNAME, IDCheckUKDrivingLicenceNumberResult.class, ServiceResult.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link IDDocumentCheckResult }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.Resources", name = "IDDocumentCheckResult", scope = ServiceResult.class)
    public JAXBElement<IDDocumentCheckResult> createServiceResultIDDocumentCheckResult(IDDocumentCheckResult value) {
        return new JAXBElement<IDDocumentCheckResult>(_ServiceResultIDDocumentCheckResult_QNAME, IDDocumentCheckResult.class, ServiceResult.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link IDCheckAddressLookupResult }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.Resources", name = "IDCheckAddressLookupResult", scope = ServiceResult.class)
    public JAXBElement<IDCheckAddressLookupResult> createServiceResultIDCheckAddressLookupResult(IDCheckAddressLookupResult value) {
        return new JAXBElement<IDCheckAddressLookupResult>(_ServiceResultIDCheckAddressLookupResult_QNAME, IDCheckAddressLookupResult.class, ServiceResult.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ProfileDetailsResult }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.Resources", name = "ProfileDetailsResult", scope = ServiceResult.class)
    public JAXBElement<ProfileDetailsResult> createServiceResultProfileDetailsResult(ProfileDetailsResult value) {
        return new JAXBElement<ProfileDetailsResult>(_ServiceResultProfileDetailsResult_QNAME, ProfileDetailsResult.class, ServiceResult.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link W2DataEkycUk007Result }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.Resources", name = "W2DataEkycUk007Result", scope = ServiceResult.class)
    public JAXBElement<W2DataEkycUk007Result> createServiceResultW2DataEkycUk007Result(W2DataEkycUk007Result value) {
        return new JAXBElement<W2DataEkycUk007Result>(_ServiceResultW2DataEkycUk007Result_QNAME, W2DataEkycUk007Result.class, ServiceResult.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link IDCheckZAAlphaResult }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.Resources", name = "IDCheckZAAlphaResult", scope = ServiceResult.class)
    public JAXBElement<IDCheckZAAlphaResult> createServiceResultIDCheckZAAlphaResult(IDCheckZAAlphaResult value) {
        return new JAXBElement<IDCheckZAAlphaResult>(_ServiceResultIDCheckZAAlphaResult_QNAME, IDCheckZAAlphaResult.class, ServiceResult.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link IDCheckSKBravoResult }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.Resources", name = "IDCheckSKBravoResult", scope = ServiceResult.class)
    public JAXBElement<IDCheckSKBravoResult> createServiceResultIDCheckSKBravoResult(IDCheckSKBravoResult value) {
        return new JAXBElement<IDCheckSKBravoResult>(_ServiceResultIDCheckSKBravoResult_QNAME, IDCheckSKBravoResult.class, ServiceResult.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link IDCheckUKAlphaResult }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.Resources", name = "IDCheckUKAlphaResult", scope = ServiceResult.class)
    public JAXBElement<IDCheckUKAlphaResult> createServiceResultIDCheckUKAlphaResult(IDCheckUKAlphaResult value) {
        return new JAXBElement<IDCheckUKAlphaResult>(_ServiceResultIDCheckUKAlphaResult_QNAME, IDCheckUKAlphaResult.class, ServiceResult.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DirectorUKCheckResult }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.Resources", name = "DirectorUKCheckResult", scope = ServiceResult.class)
    public JAXBElement<DirectorUKCheckResult> createServiceResultDirectorUKCheckResult(DirectorUKCheckResult value) {
        return new JAXBElement<DirectorUKCheckResult>(_ServiceResultDirectorUKCheckResult_QNAME, DirectorUKCheckResult.class, ServiceResult.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link IDCheckUKDeltaResult }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.Resources", name = "IDCheckUKDeltaResult", scope = ServiceResult.class)
    public JAXBElement<IDCheckUKDeltaResult> createServiceResultIDCheckUKDeltaResult(IDCheckUKDeltaResult value) {
        return new JAXBElement<IDCheckUKDeltaResult>(_ServiceResultIDCheckUKDeltaResult_QNAME, IDCheckUKDeltaResult.class, ServiceResult.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PEPDeskCheckResult }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.Resources", name = "PEPDeskCheckResult", scope = ServiceResult.class)
    public JAXBElement<PEPDeskCheckResult> createServiceResultPEPDeskCheckResult(PEPDeskCheckResult value) {
        return new JAXBElement<PEPDeskCheckResult>(_ServiceResultPEPDeskCheckResult_QNAME, PEPDeskCheckResult.class, ServiceResult.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link IDCheckRUBravoResult }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.Resources", name = "IDCheckRUBravoResult", scope = ServiceResult.class)
    public JAXBElement<IDCheckRUBravoResult> createServiceResultIDCheckRUBravoResult(IDCheckRUBravoResult value) {
        return new JAXBElement<IDCheckRUBravoResult>(_ServiceResultIDCheckRUBravoResult_QNAME, IDCheckRUBravoResult.class, ServiceResult.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link IDCheckDEBravoResult }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.Resources", name = "IDCheckDEBravoResult", scope = ServiceResult.class)
    public JAXBElement<IDCheckDEBravoResult> createServiceResultIDCheckDEBravoResult(IDCheckDEBravoResult value) {
        return new JAXBElement<IDCheckDEBravoResult>(_ServiceResultIDCheckDEBravoResult_QNAME, IDCheckDEBravoResult.class, ServiceResult.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link IDCheckNLAlphaResult }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.Resources", name = "IDCheckNLAlphaResult", scope = ServiceResult.class)
    public JAXBElement<IDCheckNLAlphaResult> createServiceResultIDCheckNLAlphaResult(IDCheckNLAlphaResult value) {
        return new JAXBElement<IDCheckNLAlphaResult>(_ServiceResultIDCheckNLAlphaResult_QNAME, IDCheckNLAlphaResult.class, ServiceResult.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts", name = "DocumentReference", scope = UploadedFile.class)
    public JAXBElement<String> createUploadedFileDocumentReference(String value) {
        return new JAXBElement<String>(_UploadedFileDocumentReference_QNAME, String.class, UploadedFile.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts", name = "Index", scope = UploadedFile.class)
    public JAXBElement<Integer> createUploadedFileIndex(Integer value) {
        return new JAXBElement<Integer>(_UploadedFileIndex_QNAME, Integer.class, UploadedFile.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts", name = "Group", scope = UploadedFile.class)
    public JAXBElement<String> createUploadedFileGroup(String value) {
        return new JAXBElement<String>(_UploadedFileGroup_QNAME, String.class, UploadedFile.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfServiceTransactionInformation }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.Resources", name = "ServiceTransactions", scope = TransactionInformation.class)
    public JAXBElement<ArrayOfServiceTransactionInformation> createTransactionInformationServiceTransactions(ArrayOfServiceTransactionInformation value) {
        return new JAXBElement<ArrayOfServiceTransactionInformation>(_TransactionInformationServiceTransactions_QNAME, ArrayOfServiceTransactionInformation.class, TransactionInformation.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.Resources", name = "ServiceCallReference", scope = TransactionInformation.class)
    public JAXBElement<String> createTransactionInformationServiceCallReference(String value) {
        return new JAXBElement<String>(_TransactionInformationServiceCallReference_QNAME, String.class, TransactionInformation.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts", name = "ClientUser", scope = ClientProvidedData.class)
    public JAXBElement<String> createClientProvidedDataClientUser(String value) {
        return new JAXBElement<String>(_ClientProvidedDataClientUser_QNAME, String.class, ClientProvidedData.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts", name = "ClientReference", scope = ClientProvidedData.class)
    public JAXBElement<String> createClientProvidedDataClientReference(String value) {
        return new JAXBElement<String>(_ClientProvidedDataClientReference_QNAME, String.class, ClientProvidedData.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts", name = "ClientSubaccount", scope = ClientProvidedData.class)
    public JAXBElement<String> createClientProvidedDataClientSubaccount(String value) {
        return new JAXBElement<String>(_ClientProvidedDataClientSubaccount_QNAME, String.class, ClientProvidedData.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts", name = "RefersToServiceCallReference", scope = ClientProvidedData.class)
    public JAXBElement<String> createClientProvidedDataRefersToServiceCallReference(String value) {
        return new JAXBElement<String>(_ClientProvidedDataRefersToServiceCallReference_QNAME, String.class, ClientProvidedData.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ProcessRequestResult }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts", name = "ProcessRequestResult", scope = ServiceResponse.class)
    public JAXBElement<ProcessRequestResult> createServiceResponseProcessRequestResult(ProcessRequestResult value) {
        return new JAXBElement<ProcessRequestResult>(_ServiceResponseProcessRequestResult_QNAME, ProcessRequestResult.class, ServiceResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ClientProvidedData }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts", name = "ClientProvidedData", scope = ServiceResponse.class)
    public JAXBElement<ClientProvidedData> createServiceResponseClientProvidedData(ClientProvidedData value) {
        return new JAXBElement<ClientProvidedData>(_ClientProvidedData_QNAME, ClientProvidedData.class, ServiceResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts", name = "ClientUser", scope = ServiceAuthorisation.class)
    public JAXBElement<String> createServiceAuthorisationClientUser(String value) {
        return new JAXBElement<String>(_ClientProvidedDataClientUser_QNAME, String.class, ServiceAuthorisation.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts", name = "ClientReference", scope = ServiceAuthorisation.class)
    public JAXBElement<String> createServiceAuthorisationClientReference(String value) {
        return new JAXBElement<String>(_ClientProvidedDataClientReference_QNAME, String.class, ServiceAuthorisation.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts", name = "ClientSubaccount", scope = ServiceAuthorisation.class)
    public JAXBElement<String> createServiceAuthorisationClientSubaccount(String value) {
        return new JAXBElement<String>(_ClientProvidedDataClientSubaccount_QNAME, String.class, ServiceAuthorisation.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts", name = "RefersToServiceCallReference", scope = ServiceAuthorisation.class)
    public JAXBElement<String> createServiceAuthorisationRefersToServiceCallReference(String value) {
        return new JAXBElement<String>(_ClientProvidedDataRefersToServiceCallReference_QNAME, String.class, ServiceAuthorisation.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts", name = "APIKey", scope = ServiceAuthorisation.class)
    public JAXBElement<String> createServiceAuthorisationAPIKey(String value) {
        return new JAXBElement<String>(_ServiceAuthorisationAPIKey_QNAME, String.class, ServiceAuthorisation.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DirectorUKDetailsResult }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts", name = "DirectorUKDetailsResult", scope = ProfileDetailsResult.class)
    public JAXBElement<DirectorUKDetailsResult> createProfileDetailsResultDirectorUKDetailsResult(DirectorUKDetailsResult value) {
        return new JAXBElement<DirectorUKDetailsResult>(_ProfileDetailsResultDirectorUKDetailsResult_QNAME, DirectorUKDetailsResult.class, ProfileDetailsResult.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link WatchlistDetailsResult }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts", name = "WatchlistDetailsResult", scope = ProfileDetailsResult.class)
    public JAXBElement<WatchlistDetailsResult> createProfileDetailsResultWatchlistDetailsResult(WatchlistDetailsResult value) {
        return new JAXBElement<WatchlistDetailsResult>(_ProfileDetailsResultWatchlistDetailsResult_QNAME, WatchlistDetailsResult.class, ProfileDetailsResult.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SanctionsPlusDetailsResult }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts", name = "SPFPlusDetailsResult", scope = ProfileDetailsResult.class)
    public JAXBElement<SanctionsPlusDetailsResult> createProfileDetailsResultSPFPlusDetailsResult(SanctionsPlusDetailsResult value) {
        return new JAXBElement<SanctionsPlusDetailsResult>(_ProfileDetailsResultSPFPlusDetailsResult_QNAME, SanctionsPlusDetailsResult.class, ProfileDetailsResult.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PEPDeskDetailsResult }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts", name = "PEPDeskDetailsResult", scope = ProfileDetailsResult.class)
    public JAXBElement<PEPDeskDetailsResult> createProfileDetailsResultPEPDeskDetailsResult(PEPDeskDetailsResult value) {
        return new JAXBElement<PEPDeskDetailsResult>(_ProfileDetailsResultPEPDeskDetailsResult_QNAME, PEPDeskDetailsResult.class, ProfileDetailsResult.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SanctionsPlusDetailsResult }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.DataContracts", name = "SISPlusDetailsResult", scope = ProfileDetailsResult.class)
    public JAXBElement<SanctionsPlusDetailsResult> createProfileDetailsResultSISPlusDetailsResult(SanctionsPlusDetailsResult value) {
        return new JAXBElement<SanctionsPlusDetailsResult>(_ProfileDetailsResultSISPlusDetailsResult_QNAME, SanctionsPlusDetailsResult.class, ProfileDetailsResult.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.Resources", name = "ServiceTransactionResultMessage", scope = ServiceTransactionInformation.class)
    public JAXBElement<String> createServiceTransactionInformationServiceTransactionResultMessage(String value) {
        return new JAXBElement<String>(_ServiceTransactionInformationServiceTransactionResultMessage_QNAME, String.class, ServiceTransactionInformation.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ServiceValidationResultDetails }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.Resources", name = "ServiceValidationDetails", scope = ServiceTransactionInformation.class)
    public JAXBElement<ServiceValidationResultDetails> createServiceTransactionInformationServiceValidationDetails(ServiceValidationResultDetails value) {
        return new JAXBElement<ServiceValidationResultDetails>(_ServiceTransactionInformationServiceValidationDetails_QNAME, ServiceValidationResultDetails.class, ServiceTransactionInformation.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/NeuromancerLibrary.Resources", name = "FailedOverTo", scope = ServiceTransactionInformation.class)
    public JAXBElement<String> createServiceTransactionInformationFailedOverTo(String value) {
        return new JAXBElement<String>(_ServiceTransactionInformationFailedOverTo_QNAME, String.class, ServiceTransactionInformation.class, value);
    }

}
