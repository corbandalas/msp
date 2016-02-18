package w2globaldata;

import com.google.inject.Inject;
import com.microsoft.schemas._2003._10.serialization.arrays.ArrayOfKeyValueOfstringstring;
import exception.W2GlobaldataException;
import exception.W2GlobaldataValidationException;
import exception.WrongPropertyException;
import model.Property;
import org.apache.commons.lang3.StringUtils;
import org.datacontract.schemas._2004._07.databaselibrary.DocumentTypeEnum;
import org.datacontract.schemas._2004._07.databaselibrary.IsoCountriesEnum;
import org.datacontract.schemas._2004._07.neuromancerlibrary.*;
import org.datacontract.schemas._2004._07.neuromancerlibrary_datacontracts.DocumentUploadRequest;
import org.datacontract.schemas._2004._07.neuromancerlibrary_datacontracts.DocumentUploadResponse;
import org.tempuri.IService;
import org.tempuri.Service;
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
 * W2 Global data client
 *
 * @author nihilist - created 16.02.2016
 * @since 0.1.0
 */

public class W2GlobaldataClient {

    @Inject
    private PropertyRepository propertyRepository;

    private QueryData fillDateOfBirth(QueryData queryData, Date dateOfBirth) {

        if (dateOfBirth == null)
            return queryData;

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(dateOfBirth);
        calendar.get(Calendar.YEAR);
        calendar.get(Calendar.MONTH);
        calendar.get(Calendar.DAY_OF_MONTH);

        queryData.setDayOfBirth(new JAXBElement<>(new QName("d4p1"), Integer.class, calendar.get(Calendar.DAY_OF_MONTH)));
        queryData.setMonthOfBirth(new JAXBElement<>(new QName("d4p1"), Integer.class, calendar.get(Calendar.MONTH)));
        queryData.setYearOfBirth(new JAXBElement<>(new QName("d4p1"), Integer.class, calendar.get(Calendar.YEAR)));
        return queryData;
    }


    private QueryData createQueryData(W2GlobaldataSettings w2GlobaldataSettings, String nameQuery, Date dateOfBirth) throws W2GlobaldataValidationException {

        if (nameQuery == null || StringUtils.isBlank(nameQuery))
            throw new W2GlobaldataValidationException("SIS/SPF Validation exception");

        QueryData queryData = new QueryData();
        queryData.setNameQuery(new JAXBElement<>(new QName("d4p1"), String.class, nameQuery));
        queryData.setNameQueryMatchThreshold(new JAXBElement<>(new QName("d4p1"), Integer.class, w2GlobaldataSettings.nameQueryMatchThreshold));
        queryData.setDateOfBirthMatchThreshold(new JAXBElement<>(new QName("d4p1"), Integer.class, w2GlobaldataSettings.dateOfBirthMatchThreshold));

        fillDateOfBirth(queryData, dateOfBirth);

        return queryData;
    }


    public F.Promise<ServiceResponse> standardInternationalSanctionsService(String nameQuery, Date dateOfBirth) {
        return getW2GlobaldataSettings().flatMap(res -> invokeKycCheck(res, createQueryData(res, nameQuery, dateOfBirth)));
    }

    public F.Promise<ServiceResponse> seniorPoliticalFiguresService(String nameQuery, Date dateOfBirth) {
        return getW2GlobaldataSettings().flatMap(res -> invokeKycCheck(res, createQueryData(res, nameQuery, dateOfBirth)));
    }

    public F.Promise<ServiceResponse> eKYC_UKService(String forename, String surname, Date dateOfBirth, String houseNameNumber, String street, String country, String city, String postcode) throws W2GlobaldataValidationException {

        if (StringUtils.isBlank(forename) || StringUtils.isBlank(surname) || dateOfBirth == null || StringUtils.isBlank(houseNameNumber) || StringUtils.isBlank(postcode))
            throw new W2GlobaldataValidationException("eKYC_UKService validation exception");


        QueryData queryData = new QueryData();
        queryData.setForename(new JAXBElement<>(new QName("d4p1"), String.class, forename));
        //queryData.setMiddleNames(new JAXBElement<>(new QName("d4p1"), String.class, middleNames));
        queryData.setSurname(new JAXBElement<>(new QName("d4p1"), String.class, surname));
        fillDateOfBirth(queryData, dateOfBirth);
        queryData.setHouseNameNumber(new JAXBElement<>(new QName("d4p1"), String.class, houseNameNumber));
        queryData.setStreet(new JAXBElement<>(new QName("d4p1"), String.class, street));
        // queryData.setRegion(new JAXBElement<>(new QName("d4p1"), String.class, region));
        //queryData.setCounty(new JAXBElement<>(new QName("d4p1"), String.class, county));
        if (country != null)
            queryData.setCountry(IsoCountriesEnum.valueOf(country));
        queryData.setCity(new JAXBElement<>(new QName("d4p1"), String.class, city));
        queryData.setPostcode(new JAXBElement<>(new QName("d4p1"), String.class, postcode));

        return getW2GlobaldataSettings().flatMap(res -> invokeKycCheck(res, queryData));
    }

    public F.Promise<ServiceResponse> internationalAddressLookupService(String houseNameNumber, String postcode, String street, String city, String country) throws W2GlobaldataValidationException {

        if (StringUtils.isBlank(houseNameNumber) || StringUtils.isBlank(postcode))
            throw new W2GlobaldataValidationException("internationalAddressLookupService validation exception");


        QueryData queryData = new QueryData();
        queryData.setHouseNameNumber(new JAXBElement<>(new QName("d4p1"), String.class, houseNameNumber));
        queryData.setPostcode(new JAXBElement<>(new QName("d4p1"), String.class, postcode));
        queryData.setStreet(new JAXBElement<>(new QName("d4p1"), String.class, street));
        //queryData.setCounty(new JAXBElement<>(new QName("d4p1"), String.class, county));
        queryData.setCity(new JAXBElement<>(new QName("d4p1"), String.class, city));
        queryData.setCountry(IsoCountriesEnum.valueOf(country));

        return getW2GlobaldataSettings().flatMap(res -> invokeKycCheck(res, queryData));
    }

    public F.Promise<ServiceResponse> manualValidationService(String forename, String surname, String houseNameNumber, String postcode, Date dateOfBirth, String country, String mobileNumber, String city) throws W2GlobaldataValidationException {

        if (StringUtils.isBlank(forename) || StringUtils.isBlank(surname) || dateOfBirth == null || StringUtils.isBlank(houseNameNumber) || StringUtils.isBlank(postcode) || StringUtils.isBlank(country))
            throw new W2GlobaldataValidationException("manualValidationService validation exception");


        QueryData queryData = new QueryData();
        queryData.setForename(new JAXBElement<>(new QName("d4p1"), String.class, forename));
        queryData.setSurname(new JAXBElement<>(new QName("d4p1"), String.class, surname));
        queryData.setHouseNameNumber(new JAXBElement<>(new QName("d4p1"), String.class, houseNameNumber));
        queryData.setPostcode(new JAXBElement<>(new QName("d4p1"), String.class, postcode));
        fillDateOfBirth(queryData, dateOfBirth);
        queryData.setCountry(IsoCountriesEnum.valueOf(country));
        // queryData.setGender(new JAXBElement<>(new QName("d4p1"), String.class, gender));
        //queryData.setPhoneNumber(new JAXBElement<>(new QName("d4p1"), String.class, phoneNumber));
        queryData.setMobileNumber(new JAXBElement<>(new QName("d4p1"), String.class, mobileNumber));
        //queryData.setFlat(new JAXBElement<>(new QName("d4p1"), String.class, flat));
        queryData.setCity(new JAXBElement<>(new QName("d4p1"), String.class, city));
        // queryData.setCounty(new JAXBElement<>(new QName("d4p1"), String.class, county));

        return getW2GlobaldataSettings().flatMap(res -> invokeKycCheck(res, queryData));
    }

    public F.Promise<DocumentUploadResponse> uploadDocument(String documentData, String documentReference, String documentType, Date documentExpiry) throws W2GlobaldataValidationException {

        if (StringUtils.isBlank(documentData) || StringUtils.isBlank(documentType))
            throw new W2GlobaldataValidationException("uploadDocument validation exception");

        return getW2GlobaldataSettings().flatMap(res -> invokeUploadDocument(res, documentData, documentReference, documentType, documentExpiry));
    }

    private F.Promise<ServiceResponse> invokeKycCheck(W2GlobaldataSettings w2GlobaldataSettings, QueryData queryData) {
        return F.Promise.promise(() -> {
            try {

                final Service service = new Service(new URL(w2GlobaldataSettings.wsdlURL));
                final IService servicePort = service.getPort(IService.class);

                ServiceRequest serviceRequest = new ServiceRequest();

                final BundleData bundleData = new BundleData();
                serviceRequest.setBundleData(new JAXBElement<>(new QName("d4p1"), BundleData.class, bundleData));

                final ArrayOfKeyValueOfstringstring queryOptions = new ArrayOfKeyValueOfstringstring();
                final ArrayOfKeyValueOfstringstring.KeyValueOfstringstring queryOption = new ArrayOfKeyValueOfstringstring.KeyValueOfstringstring();

                if (w2GlobaldataSettings.sandbox) {
                    queryOption.setKey("Sandbox");
                    queryOption.setValue("true");
                }

                queryOptions.getKeyValueOfstringstring().add(queryOption);
                serviceRequest.setQueryOptions(new JAXBElement<>(new QName("d4p1"), ArrayOfKeyValueOfstringstring.class, queryOptions));

                serviceRequest.setQueryData(new JAXBElement<>(new QName("d4p1"), QueryData.class, queryData));

                ServiceAuthorisation serviceAuthorisation = new ServiceAuthorisation();
                serviceAuthorisation.setAPIKey(new JAXBElement<>(new QName("d4p1"), String.class, "123456"));

                serviceRequest.setServiceAuthorisation(new JAXBElement<>(new QName("d4p1"), ServiceAuthorisation.class, serviceAuthorisation));

                final ServiceResponse serviceResponse = servicePort.kycCheck(serviceRequest);

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

                final Service service = new Service(new URL(w2GlobaldataSettings.wsdlURL));
                final IService servicePort = service.getPort(IService.class);

                DocumentUploadRequest documentUploadRequest = new DocumentUploadRequest();

                documentUploadRequest.setDocumentData(new JAXBElement<>(new QName("d4p1"), String.class, SecurityUtil.encodeString(documentData)));

                if (documentExpiry != null) {
                    GregorianCalendar c = new GregorianCalendar();
                    c.setTime(documentExpiry);
                    XMLGregorianCalendar date2 = DatatypeFactory.newInstance().newXMLGregorianCalendar(c);
                    documentUploadRequest.setDocumentExpiry(new JAXBElement<>(new QName("d4p1"), XMLGregorianCalendar.class, date2));
                }

                if (StringUtils.isNoneBlank(documentReference)) {
                    documentUploadRequest.setDocumentReference(new JAXBElement<>(new QName("d4p1"), String.class, documentReference));
                }

                documentUploadRequest.setDocumentType(DocumentTypeEnum.valueOf(documentType));

                final ArrayOfKeyValueOfstringstring queryOptions = new ArrayOfKeyValueOfstringstring();
                final ArrayOfKeyValueOfstringstring.KeyValueOfstringstring queryOption = new ArrayOfKeyValueOfstringstring.KeyValueOfstringstring();

                if (w2GlobaldataSettings.sandbox) {
                    queryOption.setKey("Sandbox");
                    queryOption.setValue("true");
                }

                queryOptions.getKeyValueOfstringstring().add(queryOption);
                documentUploadRequest.setQueryOptions(new JAXBElement<>(new QName("d4p1"), ArrayOfKeyValueOfstringstring.class, queryOptions));

                ServiceAuthorisation serviceAuthorisation = new ServiceAuthorisation();
                serviceAuthorisation.setAPIKey(new JAXBElement<>(new QName("d5p1"), String.class, "123456"));

                documentUploadRequest.setServiceAuthorisation(new JAXBElement<>(new QName("d4p1"), ServiceAuthorisation.class, serviceAuthorisation));

                final DocumentUploadResponse documentUploadResponse = servicePort.uploadDocument(documentUploadRequest);

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

        return wsdlPromise.zip(sandboxPromise).zip(nameQueryMatchThresholdPromise).zip(dateOfBirthMatchThresholdPromise).map(res -> {

            String url = res._1._1._1.orElseThrow(WrongPropertyException::new).getValue();
            Boolean sandbox = Boolean.parseBoolean(res._1._1._2.orElseThrow(WrongPropertyException::new).getValue());
            Integer nameQueryMatchThreshold = Integer.parseInt(res._1._2.orElseThrow(WrongPropertyException::new).getValue());
            String dateOfBirthMatchThresholdString = res._2.orElseThrow(WrongPropertyException::new).getValue();
            Integer dateOfBirthMatchThreshold = null;
            if (!StringUtils.isBlank(dateOfBirthMatchThresholdString)) {
                dateOfBirthMatchThreshold = Integer.parseInt(dateOfBirthMatchThresholdString);
            }

            return new W2GlobaldataSettings(url, sandbox, nameQueryMatchThreshold, dateOfBirthMatchThreshold);

        });
    }

    private class W2GlobaldataSettings {
        private String wsdlURL;
        private Boolean sandbox;
        private Integer nameQueryMatchThreshold;
        private Integer dateOfBirthMatchThreshold;

        public W2GlobaldataSettings(String wsdlURL, Boolean sandbox, Integer nameQueryMatchThreshold, Integer dateOfBirthMatchThreshold) {
            this.wsdlURL = wsdlURL;
            this.sandbox = sandbox;
            this.nameQueryMatchThreshold = nameQueryMatchThreshold;
            this.dateOfBirthMatchThreshold = dateOfBirthMatchThreshold;
        }
    }


}
