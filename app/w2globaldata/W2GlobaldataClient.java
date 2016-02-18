package w2globaldata;

import com.google.inject.Inject;
import com.microsoft.schemas._2003._10.serialization.arrays.ArrayOfKeyValueOfstringstring;
import exception.W2GlobaldataException;
import exception.WrongPropertyException;
import model.Property;
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


    private QueryData createQueryData(String nameQuery, Integer nameQueryMatchThreshold, Integer dateOfBirthMatchThreshold, Integer dayOfBirth, Integer monthOfBirth, Integer yearOfBirth) {
        QueryData queryData = new QueryData();
        queryData.setNameQuery(new JAXBElement<>(new QName("d4p1"), String.class, nameQuery));
        queryData.setNameQueryMatchThreshold(new JAXBElement<>(new QName("d4p1"), Integer.class, nameQueryMatchThreshold));
        queryData.setDateOfBirthMatchThreshold(new JAXBElement<>(new QName("d4p1"), Integer.class, dateOfBirthMatchThreshold));
        queryData.setDayOfBirth(new JAXBElement<>(new QName("d4p1"), Integer.class, dayOfBirth));
        queryData.setMonthOfBirth(new JAXBElement<>(new QName("d4p1"), Integer.class, monthOfBirth));
        queryData.setYearOfBirth(new JAXBElement<>(new QName("d4p1"), Integer.class, yearOfBirth));
        return queryData;
    }


    public F.Promise<ServiceResponse> standardInternationalSanctionsService(String nameQuery, Integer nameQueryMatchThreshold, Integer dateOfBirthMatchThreshold, Integer dayOfBirth, Integer monthOfBirth, Integer yearOfBirth) {
        return getW2GlobaldataSettings().flatMap(res -> invokeKycCheck(res, createQueryData(nameQuery, nameQueryMatchThreshold, dateOfBirthMatchThreshold, dayOfBirth, monthOfBirth, yearOfBirth)));
    }

    public F.Promise<ServiceResponse> seniorPoliticalFiguresService(String nameQuery, Integer nameQueryMatchThreshold, Integer dateOfBirthMatchThreshold, Integer dayOfBirth, Integer monthOfBirth, Integer yearOfBirth) {
        return getW2GlobaldataSettings().flatMap(res -> invokeKycCheck(res, createQueryData(nameQuery, nameQueryMatchThreshold, dateOfBirthMatchThreshold, dayOfBirth, monthOfBirth, yearOfBirth)));
    }

    public F.Promise<ServiceResponse> eKYC_UKService(String forename, String middleNames, String surname, Integer dayOfBirth, Integer monthOfBirth, Integer yearOfBirth, String houseNameNumber, String street, String region, String county, String country, String city, String postcode) {
        QueryData queryData = new QueryData();
        queryData.setForename(new JAXBElement<>(new QName("d4p1"), String.class, forename));
        queryData.setMiddleNames(new JAXBElement<>(new QName("d4p1"), String.class, middleNames));
        queryData.setSurname(new JAXBElement<>(new QName("d4p1"), String.class, surname));
        queryData.setDayOfBirth(new JAXBElement<>(new QName("d4p1"), Integer.class, dayOfBirth));
        queryData.setMonthOfBirth(new JAXBElement<>(new QName("d4p1"), Integer.class, monthOfBirth));
        queryData.setYearOfBirth(new JAXBElement<>(new QName("d4p1"), Integer.class, yearOfBirth));
        queryData.setHouseNameNumber(new JAXBElement<>(new QName("d4p1"), String.class, houseNameNumber));
        queryData.setStreet(new JAXBElement<>(new QName("d4p1"), String.class, street));
        queryData.setRegion(new JAXBElement<>(new QName("d4p1"), String.class, region));
        queryData.setCounty(new JAXBElement<>(new QName("d4p1"), String.class, county));
        if (country != null)
            queryData.setCountry(IsoCountriesEnum.valueOf(country));
        queryData.setCity(new JAXBElement<>(new QName("d4p1"), String.class, city));
        queryData.setPostcode(new JAXBElement<>(new QName("d4p1"), String.class, postcode));

        return getW2GlobaldataSettings().flatMap(res -> invokeKycCheck(res, queryData));
    }

    public F.Promise<ServiceResponse> internationalAddressLookupService(String houseNameNumber, String postcode, String street, String county, String city, String country) {
        QueryData queryData = new QueryData();
        queryData.setHouseNameNumber(new JAXBElement<>(new QName("d4p1"), String.class, houseNameNumber));
        queryData.setPostcode(new JAXBElement<>(new QName("d4p1"), String.class, postcode));
        queryData.setStreet(new JAXBElement<>(new QName("d4p1"), String.class, street));
        queryData.setCounty(new JAXBElement<>(new QName("d4p1"), String.class, county));
        queryData.setCity(new JAXBElement<>(new QName("d4p1"), String.class, city));
        queryData.setCountry(IsoCountriesEnum.valueOf("country"));
        queryData.setCountry(null);

        return getW2GlobaldataSettings().flatMap(res -> invokeKycCheck(res, queryData));
    }

    public F.Promise<ServiceResponse> manualValidationService(String forename, String surname, String houseNameNumber, String postcode, Integer dayOfBirth, Integer monthOfBirth, Integer yearOfBirth, String country, String gender, String phoneNumber, String mobileNumber, String flat, String city, String county) {
        QueryData queryData = new QueryData();
        queryData.setForename(new JAXBElement<>(new QName("d4p1"), String.class, forename));
        queryData.setSurname(new JAXBElement<>(new QName("d4p1"), String.class, surname));
        queryData.setHouseNameNumber(new JAXBElement<>(new QName("d4p1"), String.class, houseNameNumber));
        queryData.setPostcode(new JAXBElement<>(new QName("d4p1"), String.class, postcode));
        queryData.setDayOfBirth(new JAXBElement<>(new QName("d4p1"), Integer.class, dayOfBirth));
        queryData.setMonthOfBirth(new JAXBElement<>(new QName("d4p1"), Integer.class, monthOfBirth));
        queryData.setYearOfBirth(new JAXBElement<>(new QName("d4p1"), Integer.class, yearOfBirth));
        queryData.setCountry(IsoCountriesEnum.valueOf(country));
        queryData.setGender(new JAXBElement<>(new QName("d4p1"), String.class, gender));
        queryData.setPhoneNumber(new JAXBElement<>(new QName("d4p1"), String.class, phoneNumber));
        queryData.setMobileNumber(new JAXBElement<>(new QName("d4p1"), String.class, mobileNumber));
        queryData.setFlat(new JAXBElement<>(new QName("d4p1"), String.class, flat));
        queryData.setCity(new JAXBElement<>(new QName("d4p1"), String.class, city));
        queryData.setCounty(new JAXBElement<>(new QName("d4p1"), String.class, county));

        return getW2GlobaldataSettings().flatMap(res -> invokeKycCheck(res, queryData));
    }

    public F.Promise<DocumentUploadResponse> uploadDocument(String documentData, String documentReference, String documentType, Date documentExpiry) {
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

                GregorianCalendar c = new GregorianCalendar();
                c.setTime(documentExpiry);
                XMLGregorianCalendar date2 = DatatypeFactory.newInstance().newXMLGregorianCalendar(c);

                documentUploadRequest.setDocumentExpiry(new JAXBElement<>(new QName("d4p1"), XMLGregorianCalendar.class, date2));
                documentUploadRequest.setDocumentReference(new JAXBElement<>(new QName("d4p1"), String.class, documentReference));
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

        return wsdlPromise.zip(sandboxPromise).map(res -> {

            String url = res._1.orElseThrow(WrongPropertyException::new).getValue();
            Boolean sandbox = Boolean.parseBoolean(res._2.orElseThrow(WrongPropertyException::new).getValue());

            return new W2GlobaldataSettings(url, sandbox);

        });
    }

    private class W2GlobaldataSettings {
        private String wsdlURL;
        private Boolean sandbox;

        public W2GlobaldataSettings(String wsdlURL, Boolean sandbox) {
            this.wsdlURL = wsdlURL;
            this.sandbox = sandbox;
        }
    }


}
