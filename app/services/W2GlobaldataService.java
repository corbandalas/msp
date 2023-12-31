package services;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.microsoft.schemas._2003._10.Serialization.Arrays.ArrayOfKeyValueOfstringstringKeyValueOfstringstring;
import exception.W2GlobaldataException;
import exception.W2GlobaldataValidationException;
import exception.WrongPropertyException;
import model.Property;
import org.apache.commons.lang3.StringUtils;
import org.datacontract.schemas._2004._07.DatabaseLibrary_Enums.DocumentTypeEnum;
import org.datacontract.schemas._2004._07.DatabaseLibrary_Enums.InterpretResultEnum;
import org.datacontract.schemas._2004._07.NeuromancerLibrary_DataContracts.*;
import org.datacontract.schemas._2004._07.NeuromancerLibrary_DataContracts_DocumentUpload.DocumentUploadRequest;
import org.datacontract.schemas._2004._07.NeuromancerLibrary_DataContracts_DocumentUpload.DocumentUploadResponse;
import org.datacontract.schemas._2004._07.NeuromancerLibrary_Resources.ProcessRequestResult;
import org.datacontract.schemas._2004._07.NeuromancerLibrary_Resources.ServiceTransactionInformation;
import org.datacontract.schemas._2004._07.NeuromancerLibrary_Resources.TransactionInformation;
import org.tempuri.IService;
import org.tempuri.ServiceLocator;
import play.Logger;
import play.libs.F;
import repository.PropertyRepository;

import java.net.URL;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Optional;

/**
 * W2 Global data client service
 *
 * @author nihilist - created 16.02.2016
 * @since 0.1.0
 */

@Singleton
public class W2GlobaldataService {

    @Inject
    private PropertyRepository propertyRepository;

    private QueryData fillDateOfBirth(QueryData queryData, Date dateOfBirth) {

        if (dateOfBirth == null)
            return queryData;

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(dateOfBirth);

        queryData.setDayOfBirth(calendar.get(Calendar.DAY_OF_MONTH));
        queryData.setMonthOfBirth(calendar.get(Calendar.MONTH) + 1);
        queryData.setYearOfBirth(calendar.get(Calendar.YEAR));
        return queryData;
    }


    private QueryData createQueryData(W2GlobaldataSettings w2GlobaldataSettings, String nameQuery, String forename, String middleNames, String surname, Date dateOfBirth, String houseNameNumber, String postcode, String flat, String street, String country, String city, String phoneNumber) throws W2GlobaldataValidationException {

        QueryData queryData = new QueryData();

        if (StringUtils.isNotBlank(nameQuery))
            queryData.setNameQuery(nameQuery);
        queryData.setForename(forename);
        queryData.setMiddleNames(middleNames);
        queryData.setSurname(surname);
        if (StringUtils.isNotBlank(houseNameNumber))
            queryData.setHouseNameNumber(houseNameNumber);
        if (StringUtils.isNotBlank(postcode))
            queryData.setPostcode(postcode);
        if (StringUtils.isNotBlank(flat))
            queryData.setFlat(flat);
        if (StringUtils.isNotBlank(street))
            queryData.setStreet(street);
        if (StringUtils.isNotBlank(country))
            queryData.setCountry(country);
        if (StringUtils.isNotBlank(city))
            queryData.setCity(city);
        if (StringUtils.isNotBlank(phoneNumber))
            queryData.setPhoneNumber(phoneNumber);

       /* queryData.setNameQueryMatchThreshold(w2GlobaldataSettings.nameQueryMatchThreshold);
        queryData.setDateOfBirthMatchThreshold(w2GlobaldataSettings.dateOfBirthMatchThreshold);*/

        queryData = fillDateOfBirth(queryData, dateOfBirth);

        return queryData;
    }

    private QueryData createQueryDataForSanctionCheck(String fullName, String dayOfBirth, String monthOfBirth, String yearOfBirth) throws W2GlobaldataValidationException {

        QueryData queryData = new QueryData();

        if (StringUtils.isNotBlank(fullName))
            queryData.setNameQuery(fullName);
        if (StringUtils.isNotBlank(dayOfBirth))
            queryData.setDayOfBirth(Integer.parseInt(dayOfBirth));

        if (StringUtils.isNotBlank(monthOfBirth))
            queryData.setMonthOfBirth(Integer.parseInt(monthOfBirth));

        if (StringUtils.isNotBlank(yearOfBirth))
            queryData.setYearOfBirth(Integer.parseInt(yearOfBirth));


       /* queryData.setNameQueryMatchThreshold(w2GlobaldataSettings.nameQueryMatchThreshold);
        queryData.setDateOfBirthMatchThreshold(w2GlobaldataSettings.dateOfBirthMatchThreshold);*/

//        queryData = fillDateOfBirth(queryData, dateOfBirth);

        return queryData;
    }

    public F.Promise<ServiceResponse> scandyService(String forename, String surename, Date dateOfBirth, String houseNameNumber, String postcode, String street, String country, String city, String testdatanumber, Boolean skipScandiBankId) {
        return getW2GlobaldataSettings().flatMap(res -> invokeKycCheck(res, createQueryData(res, null, forename, null, surename, dateOfBirth, houseNameNumber, postcode, null, street, country, city, null), "KYC_SCANDI", testdatanumber, skipScandiBankId));
    }

    public F.Promise<ServiceResponse> kycCheckUK(String forename, String middleNames, String surname, Date dateOfBirth, String houseNameNumber, String postcode, String flat, String street, String country, String city, String phoneNumber, String bundleName) {
        return getW2GlobaldataSettings().flatMap(res -> invokeKycCheck(res, createQueryData(res, null, forename, middleNames, surname, dateOfBirth, houseNameNumber, postcode, flat, street, country, city, phoneNumber), bundleName, null, null));
    }

    public F.Promise<ServiceResponse> kycCheckCommon(String nameQuery, String forename, String middleNames, String surname, Date dateOfBirth) {
        return getW2GlobaldataSettings().flatMap(res -> invokeKycCheck(res, createQueryData(res, nameQuery, forename, middleNames, surname, dateOfBirth, null, null, null, null, null, null, null), "SafePay_CommonChecks", null, null));
    }

    public F.Promise<ServiceResponse> checkUserSanction(String fullName, String dayOfBirth, String monthOfBirth, String yearOfBirth) {
        return getW2GlobaldataSettings().flatMap(res -> invokeSanctionCheck(res, fullName, dayOfBirth, monthOfBirth, yearOfBirth, null));
    }


/*    public F.Promise<ServiceResponse> standardInternationalSanctionsService(String nameQuery, Date dateOfBirth) {
        return getW2GlobaldataSettings().flatMap(res -> invokeKycCheck(res, createQueryData(res, nameQuery, dateOfBirth)));
    }

    public F.Promise<ServiceResponse> seniorPoliticalFiguresService(String nameQuery, Date dateOfBirth) {
        return getW2GlobaldataSettings().flatMap(res -> invokeKycCheck(res, createQueryData(res, nameQuery, dateOfBirth)));
    }

    public F.Promise<ServiceResponse> eKYC_UKService(String forename, String surname, Date dateOfBirth, String houseNameNumber, String street, String country, String city, String postcode) throws W2GlobaldataValidationException {

        if (StringUtils.isBlank(forename) || StringUtils.isBlank(surname) || dateOfBirth == null || StringUtils.isBlank(houseNameNumber) || StringUtils.isBlank(postcode))
            throw new W2GlobaldataValidationException("eKYC_UKService validation exception");


        QueryData queryData = new QueryData();
        queryData.setForename(forename);
        //queryData.setMiddleNames(new JAXBElement<>(new QName("d4p1"), String.class, middleNames));
        queryData.setSurname(surname);
        fillDateOfBirth(queryData, dateOfBirth);
        queryData.setHouseNameNumber(houseNameNumber);
        queryData.setStreet(street);
        // queryData.setRegion(new JAXBElement<>(new QName("d4p1"), String.class, region));
        //queryData.setCounty(new JAXBElement<>(new QName("d4p1"), String.class, county));
        if (country != null)
            queryData.setCountry(IsoCountriesEnum.fromValue(country));
        queryData.setCity(city);
        queryData.setPostcode(postcode);

        return getW2GlobaldataSettings().flatMap(res -> invokeKycCheck(res, queryData));
    }

    public F.Promise<ServiceResponse> internationalAddressLookupService(String houseNameNumber, String postcode, String street, String city, String country) throws W2GlobaldataValidationException {

        if (StringUtils.isBlank(houseNameNumber) || StringUtils.isBlank(postcode))
            throw new W2GlobaldataValidationException("internationalAddressLookupService validation exception");


        QueryData queryData = new QueryData();
        queryData.setHouseNameNumber(houseNameNumber);
        queryData.setPostcode(postcode);
        queryData.setStreet(street);
        //queryData.setCounty(new JAXBElement<>(new QName("d4p1"), String.class, county));
        queryData.setCity(city);
        queryData.setCountry(IsoCountriesEnum.fromString(country));

        return getW2GlobaldataSettings().flatMap(res -> invokeKycCheck(res, queryData));
    }

    public F.Promise<ServiceResponse> manualValidationService(String forename, String surname, String houseNameNumber, String postcode, Date dateOfBirth, String country, String mobileNumber, String city) throws W2GlobaldataValidationException {

        if (StringUtils.isBlank(forename) || StringUtils.isBlank(surname) || dateOfBirth == null || StringUtils.isBlank(houseNameNumber) || StringUtils.isBlank(postcode) || StringUtils.isBlank(country))
            throw new W2GlobaldataValidationException("manualValidationService validation exception");


        QueryData queryData = new QueryData();
        queryData.setForename(forename);
        queryData.setSurname(surname);
        queryData.setHouseNameNumber(houseNameNumber);
        queryData.setPostcode(postcode);
        fillDateOfBirth(queryData, dateOfBirth);
        queryData.setCountry(IsoCountriesEnum.fromString(country));
        // queryData.setGender(new JAXBElement<>(new QName("d4p1"), String.class, gender));
        //queryData.setPhoneNumber(new JAXBElement<>(new QName("d4p1"), String.class, phoneNumber));
        queryData.setMobileNumber(mobileNumber);
        //queryData.setFlat(new JAXBElement<>(new QName("d4p1"), String.class, flat));
        queryData.setCity(city);
        // queryData.setCounty(new JAXBElement<>(new QName("d4p1"), String.class, county));

        return getW2GlobaldataSettings().flatMap(res -> invokeKycCheck(res, queryData));
    }*/

    public F.Promise<DocumentUploadResponse> uploadDocument(String documentData, String documentReference, String documentType, Date documentExpiry) throws W2GlobaldataValidationException {

        if (StringUtils.isBlank(documentData) || StringUtils.isBlank(documentType))
            throw new W2GlobaldataValidationException("uploadDocument validation exception");

        return getW2GlobaldataSettings().flatMap(res -> invokeUploadDocument(res, documentData, documentReference, documentType, documentExpiry));
    }

    private F.Promise<ServiceResponse> invokeKycCheck(W2GlobaldataSettings w2GlobaldataSettings, QueryData queryData, String bundleName, String testdatanumber, Boolean skipScandiBankId) {
        return F.Promise.promise(() -> {
            try {

                ServiceLocator serviceLocator = new ServiceLocator();
                IService basicHttpsBinding_iService = serviceLocator.getBasicHttpsBinding_IService(new URL(w2GlobaldataSettings.wsdlURL));

                ServiceRequest serviceRequest = new ServiceRequest();

                final BundleData bundleData = new BundleData(bundleName);
                serviceRequest.setBundleData(bundleData);

                final ArrayOfKeyValueOfstringstringKeyValueOfstringstring[] queryOptions = new ArrayOfKeyValueOfstringstringKeyValueOfstringstring[4];

                final ArrayOfKeyValueOfstringstringKeyValueOfstringstring queryOption = new ArrayOfKeyValueOfstringstringKeyValueOfstringstring();

                final ArrayOfKeyValueOfstringstringKeyValueOfstringstring queryOption1 = new ArrayOfKeyValueOfstringstringKeyValueOfstringstring();

                final ArrayOfKeyValueOfstringstringKeyValueOfstringstring queryOption2 = new ArrayOfKeyValueOfstringstringKeyValueOfstringstring();

                final ArrayOfKeyValueOfstringstringKeyValueOfstringstring queryOption3 = new ArrayOfKeyValueOfstringstringKeyValueOfstringstring();


                int size = 1;

                queryOption.setKey("RedirectUrl");
                queryOption.setValue(w2GlobaldataSettings.redirectUrl);
                queryOptions[0] = queryOption;

                if (!bundleName.equalsIgnoreCase("KYC_SCANDI") && w2GlobaldataSettings.sandbox) {
                    size++;
                    queryOption1.setKey("Sandbox");
                    queryOption1.setValue("true");
                    queryOptions[1] = queryOption1;
                }

                if (StringUtils.isNotBlank(testdatanumber)) {
                    size++;
                    queryOption2.setKey("testdatanumber");
                    queryOption2.setValue(testdatanumber);
                    queryOptions[2] = queryOption2;
                }

                if (bundleName.equalsIgnoreCase("KYC_SCANDI")) {
                    size++;
                    queryOption3.setKey("SkipScandiBankId");
                    if (skipScandiBankId != null && skipScandiBankId) {
                        queryOption3.setValue("true");
                    } else {
                        queryOption3.setValue("false");
                    }
                    queryOptions[3] = queryOption3;
                }

                final ArrayOfKeyValueOfstringstringKeyValueOfstringstring[] resultQueryOptions = new ArrayOfKeyValueOfstringstringKeyValueOfstringstring[size];

                for (ArrayOfKeyValueOfstringstringKeyValueOfstringstring item : queryOptions) {
                    if (item != null && item.getKey() != null) {
                        resultQueryOptions[--size] = item;
                    }
                }

                serviceRequest.setQueryOptions(resultQueryOptions);

                serviceRequest.setQueryData(queryData);

                ServiceAuthorisation serviceAuthorisation = new ServiceAuthorisation();
                serviceAuthorisation.setAPIKey(w2GlobaldataSettings.apiKey);

                serviceRequest.setServiceAuthorisation(serviceAuthorisation);

                ServiceResponse serviceResponse = basicHttpsBinding_iService.KYCCheck(serviceRequest);


/*                ServiceResponse serviceResponse = null;
                if (bundleName.equalsIgnoreCase("SafePay_CommonChecks")) {
                    serviceResponse = new ServiceResponse();
                    ProcessRequestResult pr = new ProcessRequestResult();
                    TransactionInformation tr = new TransactionInformation();
                    tr.setInterpretResult(InterpretResultEnum.Pass);
                    pr.setTransactionInformation(tr);
                    serviceResponse.setProcessRequestResult(pr);
                } else {
                    serviceResponse = basicHttpsBinding_iService.KYCCheck(serviceRequest);
                }*/

               // if (!bundleName.equalsIgnoreCase("SafePay_CommonChecks"))
                    Logger.info("invokeKycCheck response: " + serviceResponseToString(serviceResponse));

                return serviceResponse;

            } catch (Exception ex) {
                Logger.error("W2 global data kycCheck error: ", ex);
                throw new W2GlobaldataException("W2 global data  kycCheck error");
            }
        });
    }

    private F.Promise<ServiceResponse> invokeSanctionCheck(W2GlobaldataSettings w2GlobaldataSettings, String fullName, String dayOfBirth, String monthOfBirth, String yearOfBirth, String testdatanumber) {
        return F.Promise.promise(() -> {
            try {

                ServiceLocator serviceLocator = new ServiceLocator();
                IService basicHttpsBinding_iService = serviceLocator.getBasicHttpsBinding_IService(new URL(w2GlobaldataSettings.wsdlURL));

                ServiceRequest serviceRequest = new ServiceRequest();

                final BundleData bundleData = new BundleData("Safepay_SIS_PEP");
                serviceRequest.setBundleData(bundleData);

                final ArrayOfKeyValueOfstringstringKeyValueOfstringstring[] queryOptions = new ArrayOfKeyValueOfstringstringKeyValueOfstringstring[4];

                final ArrayOfKeyValueOfstringstringKeyValueOfstringstring queryOption = new ArrayOfKeyValueOfstringstringKeyValueOfstringstring();

                final ArrayOfKeyValueOfstringstringKeyValueOfstringstring queryOption1 = new ArrayOfKeyValueOfstringstringKeyValueOfstringstring();

                final ArrayOfKeyValueOfstringstringKeyValueOfstringstring queryOption2 = new ArrayOfKeyValueOfstringstringKeyValueOfstringstring();

                final ArrayOfKeyValueOfstringstringKeyValueOfstringstring queryOption3 = new ArrayOfKeyValueOfstringstringKeyValueOfstringstring();


                int size = 1;

                queryOption.setKey("RedirectUrl");
                queryOption.setValue(w2GlobaldataSettings.redirectUrl);
                queryOptions[0] = queryOption;

                if (w2GlobaldataSettings.sandbox) {
                    size++;
                    queryOption1.setKey("Sandbox");
                    queryOption1.setValue("true");
                    queryOptions[1] = queryOption1;
                }

                if (StringUtils.isNotBlank(testdatanumber)) {
                    size++;
                    queryOption2.setKey("testdatanumber");
                    queryOption2.setValue(testdatanumber);
                    queryOptions[2] = queryOption2;
                }


                final ArrayOfKeyValueOfstringstringKeyValueOfstringstring[] resultQueryOptions = new ArrayOfKeyValueOfstringstringKeyValueOfstringstring[size];

                for (ArrayOfKeyValueOfstringstringKeyValueOfstringstring item : queryOptions) {
                    if (item != null && item.getKey() != null) {
                        resultQueryOptions[--size] = item;
                    }
                }

                serviceRequest.setQueryOptions(resultQueryOptions);

                QueryData queryData = createQueryDataForSanctionCheck(fullName, dayOfBirth, monthOfBirth, yearOfBirth);

                serviceRequest.setQueryData(queryData);

                ServiceAuthorisation serviceAuthorisation = new ServiceAuthorisation();
                serviceAuthorisation.setAPIKey(w2GlobaldataSettings.apiKey);

                serviceRequest.setServiceAuthorisation(serviceAuthorisation);

                ServiceResponse serviceResponse = basicHttpsBinding_iService.KYCCheck(serviceRequest);


                // if (!bundleName.equalsIgnoreCase("SafePay_CommonChecks"))
                Logger.info("invokeSanctionCheck response: " + serviceResponseToString(serviceResponse));

                return serviceResponse;

            } catch (Exception ex) {
                Logger.error("W2 global data invokeSanctionCheck error: ", ex);
                throw new W2GlobaldataException("W2 global data  invokeSanctionCheck error");
            }
        });
    }


    private String serviceResponseToString(ServiceResponse serviceResponse) {
        String result = "InterpretResult: ".concat(serviceResponse.getProcessRequestResult().getTransactionInformation().getInterpretResult().getValue()).concat(", serviceCallReference: ").concat(serviceResponse.getProcessRequestResult().getTransactionInformation().getServiceCallReference());

        result = result.concat(", ServiceTransactions: { ");

        for (ServiceTransactionInformation serviceTransactionInformation : serviceResponse.getProcessRequestResult().getTransactionInformation().getServiceTransactions()) {
            if (serviceTransactionInformation.getService() != null)
                result = result.concat("{ serviceName: ").concat(serviceTransactionInformation.getService().getValue());
            if (serviceTransactionInformation.getServiceInterpretResult() != null)
                result = result.concat(", serviceInterpretResult: ").concat(serviceTransactionInformation.getServiceInterpretResult().getValue());
            if (serviceTransactionInformation.getServiceTransactionResult() != null)
                result = result.concat(", serviceTransactionResult: ").concat(serviceTransactionInformation.getServiceTransactionResult().getValue());
            if (serviceTransactionInformation.getServiceTransactionResultMessage() != null)
                result = result.concat(", serviceTransactionResultMessage: ").concat(serviceTransactionInformation.getServiceTransactionResultMessage());
            if (serviceTransactionInformation.getValidationResult() != null)
                result = result.concat(", validationResult: ").concat(serviceTransactionInformation.getValidationResult().getValue()).concat(" }, ");
        }

        result = result.concat(" }");


        return result;


    }

    private F.Promise<DocumentUploadResponse> invokeUploadDocument(W2GlobaldataSettings w2GlobaldataSettings, String documentData, String documentReference, String documentType, Date documentExpiry) {
        return F.Promise.promise(() -> {
            try {


                ServiceLocator serviceLocator = new ServiceLocator();

                IService basicHttpsBinding_iService = serviceLocator.getBasicHttpsBinding_IService(new URL(w2GlobaldataSettings.wsdlURL));

                DocumentUploadRequest documentUploadRequest = new DocumentUploadRequest();

                documentUploadRequest.setDocumentData(documentData);

                if (documentExpiry != null) {
                    GregorianCalendar calendar = new GregorianCalendar();
                    calendar.setTime(documentExpiry);
                    documentUploadRequest.setDocumentExpiry(calendar);
                }

                if (StringUtils.isNoneBlank(documentReference)) {
                    documentUploadRequest.setDocumentReference(documentReference);
                }

                documentUploadRequest.setDocumentType(DocumentTypeEnum.fromString(documentType));

                final ArrayOfKeyValueOfstringstringKeyValueOfstringstring[] queryOptions = new ArrayOfKeyValueOfstringstringKeyValueOfstringstring[1];

                final ArrayOfKeyValueOfstringstringKeyValueOfstringstring queryOption = new ArrayOfKeyValueOfstringstringKeyValueOfstringstring();


                if (w2GlobaldataSettings.sandbox) {
                    queryOption.setKey("Sandbox");
                    queryOption.setValue("true");
                }

                queryOptions[0] = queryOption;

                documentUploadRequest.setQueryOptions(queryOptions);

                ServiceAuthorisation serviceAuthorisation = new ServiceAuthorisation();
                serviceAuthorisation.setAPIKey("123456");

                documentUploadRequest.setServiceAuthorisation(serviceAuthorisation);

                final DocumentUploadResponse documentUploadResponse = basicHttpsBinding_iService.uploadDocument(documentUploadRequest);




                return documentUploadResponse;

            } catch (Exception ex) {
                Logger.error("W2 global data UploadDocument error: ", ex);
                throw new W2GlobaldataException("W2 global data UploadDocument error");
            }
        });
    }

    private F.Promise<W2GlobaldataSettings> getW2GlobaldataSettings() {

        final F.Promise<Optional<Property>> wsdlPromise = F.Promise.wrap(propertyRepository.retrieveById("w2.globaldata.wsdl.url"));
        final F.Promise<Optional<Property>> sandboxPromise = F.Promise.wrap(propertyRepository.retrieveById("w2.globaldata.sandbox.mode"));
        final F.Promise<Optional<Property>> nameQueryMatchThresholdPromise = F.Promise.wrap(propertyRepository.retrieveById("w2.globaldata.nameQueryMatchThreshold"));
        final F.Promise<Optional<Property>> dateOfBirthMatchThresholdPromise = F.Promise.wrap(propertyRepository.retrieveById("w2.globaldata.dateOfBirthMatchThreshold"));
        final F.Promise<Optional<Property>> apiKeyPromise = F.Promise.wrap(propertyRepository.retrieveById("w2.globaldata.api.key"));
        final F.Promise<Optional<Property>> redirectUrl = F.Promise.wrap(propertyRepository.retrieveById("w2.globaldata.redirect.url"));

        return wsdlPromise.zip(sandboxPromise).zip(nameQueryMatchThresholdPromise).zip(dateOfBirthMatchThresholdPromise).zip(apiKeyPromise).zip(redirectUrl).map(res -> {

            String url = res._1._1._1._1._1.orElseThrow(WrongPropertyException::new).getValue();
            Boolean sandbox = Boolean.parseBoolean(res._1._1._1._1._2.orElseThrow(WrongPropertyException::new).getValue());
            Integer nameQueryMatchThreshold = Integer.parseInt(res._1._1._1._2.orElseThrow(WrongPropertyException::new).getValue());
            String dateOfBirthMatchThresholdString = res._1._1._2.orElseThrow(WrongPropertyException::new).getValue();
            Integer dateOfBirthMatchThreshold = null;
            if (!StringUtils.isBlank(dateOfBirthMatchThresholdString)) {
                dateOfBirthMatchThreshold = Integer.parseInt(dateOfBirthMatchThresholdString);
            }
            String apiKeyString = res._1._2.orElseThrow(WrongPropertyException::new).getValue();
            String redirectUrlString = res._2.orElseThrow(WrongPropertyException::new).getValue();

            return new W2GlobaldataSettings(url, sandbox, nameQueryMatchThreshold, dateOfBirthMatchThreshold, apiKeyString, redirectUrlString);

        });
    }

    private class W2GlobaldataSettings {
        private String wsdlURL;
        private Boolean sandbox;
        private Integer nameQueryMatchThreshold;
        private Integer dateOfBirthMatchThreshold;
        private String apiKey;
        private String redirectUrl;

        public W2GlobaldataSettings(String wsdlURL, Boolean sandbox, Integer nameQueryMatchThreshold, Integer dateOfBirthMatchThreshold, String apiKey, String redirectUrl) {
            this.wsdlURL = wsdlURL;
            this.sandbox = sandbox;
            this.nameQueryMatchThreshold = nameQueryMatchThreshold;
            this.dateOfBirthMatchThreshold = dateOfBirthMatchThreshold;
            this.apiKey = apiKey;
            this.redirectUrl = redirectUrl;
        }
    }


}