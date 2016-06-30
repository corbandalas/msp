package services;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.microsoft.schemas._2003._10.Serialization.Arrays.ArrayOfKeyValueOfstringstringKeyValueOfstringstring;
import exception.W2GlobaldataException;
import exception.W2GlobaldataValidationException;
import exception.WrongPropertyException;
import model.Country;
import model.Property;
import org.apache.commons.lang3.StringUtils;
import org.datacontract.schemas._2004._07.DatabaseLibrary_Enums.DocumentTypeEnum;
import org.datacontract.schemas._2004._07.DatabaseLibrary_Enums.IsoCountriesEnum;
import org.datacontract.schemas._2004._07.NeuromancerLibrary_DataContracts.*;
import org.datacontract.schemas._2004._07.NeuromancerLibrary_DataContracts_DocumentUpload.DocumentUploadRequest;
import org.datacontract.schemas._2004._07.NeuromancerLibrary_DataContracts_DocumentUpload.DocumentUploadResponse;
import org.tempuri.IService;
import org.tempuri.ServiceLocator;
import play.Logger;
import play.libs.F;
import repository.PropertyRepository;
import util.SecurityUtil;

import javax.xml.bind.JAXBElement;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.namespace.QName;
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
        queryData.setNameQuery(nameQuery);
        queryData.setForename(forename);
        queryData.setMiddleNames(middleNames);
        queryData.setSurname(surname);
        queryData.setHouseNameNumber(houseNameNumber);
        queryData.setPostcode(postcode);
        if (StringUtils.isNotBlank(flat))
        queryData.setFlat(flat);
        if (StringUtils.isNotBlank(street))
        queryData.setStreet(street);
        if (StringUtils.isNotBlank(country))
            queryData.setCountry(IsoCountriesEnum.fromString(country));
        if (StringUtils.isNotBlank(city))
        queryData.setCity(city);
        if (StringUtils.isNotBlank(phoneNumber))
        queryData.setPhoneNumber(phoneNumber);

       /* queryData.setNameQueryMatchThreshold(w2GlobaldataSettings.nameQueryMatchThreshold);
        queryData.setDateOfBirthMatchThreshold(w2GlobaldataSettings.dateOfBirthMatchThreshold);*/

        queryData = fillDateOfBirth(queryData, dateOfBirth);

        return queryData;
    }

/*    public F.Promise<ServiceResponse> scandyService(String city, String country, Date dateOfBirth, String forename, String nationalId, String postcode, String street, String surename, String houseNameNumber, String testdatanumber) {
        return getW2GlobaldataSettings().flatMap(res -> invokeKycCheck(res, createQueryData(res, city, country, dateOfBirth, forename, nationalId, postcode, null, street, surename, houseNameNumber), "TEST_SCANDI", testdatanumber));
    }*/

    public F.Promise<ServiceResponse> kycCheckUK(String nameQuery, String forename, String middleNames, String surname, Date dateOfBirth, String houseNameNumber, String postcode, String flat, String street, String country, String city, String phoneNumber, String bundleName) {
        return getW2GlobaldataSettings().flatMap(res -> invokeKycCheck(res, createQueryData(res, nameQuery, forename, middleNames, surname, dateOfBirth, houseNameNumber, postcode, flat, street, country, city, phoneNumber), bundleName));
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

    private F.Promise<ServiceResponse> invokeKycCheck(W2GlobaldataSettings w2GlobaldataSettings, QueryData queryData, String bundleName) {
        return F.Promise.promise(() -> {
            try {

                ServiceLocator serviceLocator = new ServiceLocator();
                IService basicHttpsBinding_iService = serviceLocator.getBasicHttpsBinding_IService(new URL(w2GlobaldataSettings.wsdlURL));

                ServiceRequest serviceRequest = new ServiceRequest();

                final BundleData bundleData = new BundleData(bundleName);
                serviceRequest.setBundleData(bundleData);

                final ArrayOfKeyValueOfstringstringKeyValueOfstringstring[] queryOptions = new ArrayOfKeyValueOfstringstringKeyValueOfstringstring[2];

                final ArrayOfKeyValueOfstringstringKeyValueOfstringstring queryOption = new ArrayOfKeyValueOfstringstringKeyValueOfstringstring();

                final ArrayOfKeyValueOfstringstringKeyValueOfstringstring queryOption2 = new ArrayOfKeyValueOfstringstringKeyValueOfstringstring();


                queryOption.setKey("RedirectUrl");
                queryOption.setValue("http://google.com");

                if (w2GlobaldataSettings.sandbox) {
                    queryOption2.setKey("Sandbox");
                    queryOption2.setValue("true");
                }

   /*             queryOption2.setKey("testdatanumber");
                queryOption2.setValue(testdatanumber);
*/

                queryOptions[0] = queryOption;
                queryOptions[1] = queryOption2;

                serviceRequest.setQueryOptions(queryOptions);

                serviceRequest.setQueryData(queryData);

                ServiceAuthorisation serviceAuthorisation = new ServiceAuthorisation();
                serviceAuthorisation.setAPIKey(w2GlobaldataSettings.apiKey);

                serviceRequest.setServiceAuthorisation(serviceAuthorisation);

                final ServiceResponse serviceResponse = basicHttpsBinding_iService.KYCCheck(serviceRequest);

                return serviceResponse;

            } catch (Exception ex) {
                Logger.error("W2 global data kycCheck error: ", ex);
                throw new W2GlobaldataException("W2 global data  kycCheck error");
            }
        });
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

        return wsdlPromise.zip(sandboxPromise).zip(nameQueryMatchThresholdPromise).zip(dateOfBirthMatchThresholdPromise).zip(apiKeyPromise).map(res -> {

            String url = res._1._1._1._1.orElseThrow(WrongPropertyException::new).getValue();
            Boolean sandbox = Boolean.parseBoolean(res._1._1._1._2.orElseThrow(WrongPropertyException::new).getValue());
            Integer nameQueryMatchThreshold = Integer.parseInt(res._1._1._2.orElseThrow(WrongPropertyException::new).getValue());
            String dateOfBirthMatchThresholdString = res._1._2.orElseThrow(WrongPropertyException::new).getValue();
            Integer dateOfBirthMatchThreshold = null;
            if (!StringUtils.isBlank(dateOfBirthMatchThresholdString)) {
                dateOfBirthMatchThreshold = Integer.parseInt(dateOfBirthMatchThresholdString);
            }
            String apiKeyString = res._2.orElseThrow(WrongPropertyException::new).getValue();

            return new W2GlobaldataSettings(url, sandbox, nameQueryMatchThreshold, dateOfBirthMatchThreshold, apiKeyString);

        });
    }

    private class W2GlobaldataSettings {
        private String wsdlURL;
        private Boolean sandbox;
        private Integer nameQueryMatchThreshold;
        private Integer dateOfBirthMatchThreshold;
        private String apiKey;

        public W2GlobaldataSettings(String wsdlURL, Boolean sandbox, Integer nameQueryMatchThreshold, Integer dateOfBirthMatchThreshold, String apiKey) {
            this.wsdlURL = wsdlURL;
            this.sandbox = sandbox;
            this.nameQueryMatchThreshold = nameQueryMatchThreshold;
            this.dateOfBirthMatchThreshold = dateOfBirthMatchThreshold;
            this.apiKey = apiKey;
        }
    }


}