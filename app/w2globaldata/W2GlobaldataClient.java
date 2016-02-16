package w2globaldata;

import com.google.inject.Inject;
import com.microsoft.schemas._2003._10.serialization.arrays.ArrayOfKeyValueOfstringstring;
import exception.W2GlobaldataException;
import model.Property;
import org.datacontract.schemas._2004._07.databaselibrary.IsoCountriesEnum;
import org.datacontract.schemas._2004._07.databaselibrary.ServiceEnum;
import org.datacontract.schemas._2004._07.neuromancerlibrary.*;
import org.tempuri.IService;
import org.tempuri.Service;
import play.Logger;
import play.libs.F;
import repository.PropertyRepository;

import javax.xml.bind.JAXBElement;
import javax.xml.namespace.QName;
import java.net.URL;

/**
 * W2 Global data client
 *
 * @author nihilist - created 16.02.2016
 * @since 0.1.0
 */

public class W2GlobaldataClient {

    @Inject
    private PropertyRepository propertyRepository;

    public F.Promise<ServiceResponse> SISPlusService(String nameQuery, Integer nameQueryMatchThreshold, Integer dateOfBirthMatchThreshold, Integer dayOfBirth, Integer monthOfBirth, Integer yearOfBirth) {
        return getW2GlobaldataSettings().flatMap(res -> invokeSISPlusService(res, nameQuery, nameQueryMatchThreshold, dateOfBirthMatchThreshold, dayOfBirth, monthOfBirth, yearOfBirth));
    }

    public F.Promise<ServiceResponse> SPFPlusService(String nameQuery, Integer nameQueryMatchThreshold, Integer dateOfBirthMatchThreshold, Integer dayOfBirth, Integer monthOfBirth, Integer yearOfBirth) {
        return getW2GlobaldataSettings().flatMap(res -> invokeSPFPlusService(res, nameQuery, nameQueryMatchThreshold, dateOfBirthMatchThreshold, dayOfBirth, monthOfBirth, yearOfBirth));
    }

    public F.Promise<ServiceResponse> W2DataEkycUk007Service(String forename, String middleNames, String surname, Integer dayOfBirth, Integer monthOfBirth, Integer yearOfBirth, String houseNameNumber, String street, String region, String county, String country, String city, String postcode) {
        return getW2GlobaldataSettings().flatMap(res -> invokeW2DataEkycUk007Service(res, forename, middleNames, surname, dayOfBirth, monthOfBirth, yearOfBirth, houseNameNumber, street, region, county, country, city, postcode));
    }

    public F.Promise<ServiceResponse> W2DataAddressLookup007Service(String houseNameNumber, String postcode, String street, String county, String city, String country) {
        return getW2GlobaldataSettings().flatMap(res -> invokeW2DataAddressLookup007Service(res, houseNameNumber, postcode, street, county, city, country));
    }

    public F.Promise<ServiceResponse> W2DATAIDVCHECKService(String forename, String surname, String houseNameNumber, String postcode, Integer dayOfBirth, Integer monthOfBirth, Integer yearOfBirth, String country, String gender, String phoneNumber, String mobileNumber, String flat, String city, String county) {
        return getW2GlobaldataSettings().flatMap(res -> invokeW2DATAIDVCHECKService(res, forename, surname, houseNameNumber, postcode, dayOfBirth, monthOfBirth, yearOfBirth, country, gender, phoneNumber, mobileNumber, flat, city, county));
    }


    private F.Promise<ServiceResponse> invokeSISPlusService(W2GlobaldataSettings w2GlobaldataSettings, String nameQuery, Integer nameQueryMatchThreshold, Integer dateOfBirthMatchThreshold, Integer dayOfBirth, Integer monthOfBirth, Integer yearOfBirth) {
        return F.Promise.promise(() -> {
            try {

                final Service service = new Service(new URL(w2GlobaldataSettings.wsdlURL));
                final IService servicePort = service.getPort(IService.class);

                ServiceRequest serviceRequest = new ServiceRequest();

                final BundleData bundleData = new BundleData();
                serviceRequest.setBundleData(new JAXBElement<>(new QName("d4p1"), BundleData.class, bundleData));

                final ArrayOfKeyValueOfstringstring queryOptions = new ArrayOfKeyValueOfstringstring();
                final ArrayOfKeyValueOfstringstring.KeyValueOfstringstring queryOption = new ArrayOfKeyValueOfstringstring.KeyValueOfstringstring();

                queryOption.setKey("Sandbox");
                queryOption.setValue("true");

                queryOptions.getKeyValueOfstringstring().add(queryOption);
                serviceRequest.setQueryOptions(new JAXBElement<>(new QName("d4p1"), ArrayOfKeyValueOfstringstring.class, queryOptions));

                QueryData queryData = new QueryData();

                queryData.setNameQuery(new JAXBElement<>(new QName("d4p1"), String.class, nameQuery));
                queryData.setNameQueryMatchThreshold(new JAXBElement<>(new QName("d4p1"), Integer.class, nameQueryMatchThreshold));
                queryData.setDateOfBirthMatchThreshold(new JAXBElement<>(new QName("d4p1"), Integer.class, dateOfBirthMatchThreshold));
                queryData.setDayOfBirth(new JAXBElement<>(new QName("d4p1"), Integer.class, dayOfBirth));
                queryData.setMonthOfBirth(new JAXBElement<>(new QName("d4p1"), Integer.class, monthOfBirth));
                queryData.setYearOfBirth(new JAXBElement<>(new QName("d4p1"), Integer.class, yearOfBirth));

                serviceRequest.setQueryData(new JAXBElement<>(new QName("d4p1"), QueryData.class, queryData));

                ServiceAuthorisation serviceAuthorisation = new ServiceAuthorisation();
                serviceAuthorisation.setAPIKey(new JAXBElement<>(new QName("d4p1"), String.class, "123456"));

                serviceRequest.setServiceAuthorisation(new JAXBElement<>(new QName("d4p1"), ServiceAuthorisation.class, serviceAuthorisation));

                final ServiceResponse serviceResponse = servicePort.kycCheck(serviceRequest);

                return serviceResponse;

            } catch (Exception ex) {
                Logger.error("W2 global data invokeSISPlusService error: ", ex);
                throw new W2GlobaldataException("W2 global data invokeSISPlusService error");
            }
        });
    }


    private F.Promise<ServiceResponse> invokeW2DataEkycUk007Service(W2GlobaldataSettings w2GlobaldataSettings, String forename, String middleNames, String surname, Integer dayOfBirth, Integer monthOfBirth, Integer yearOfBirth, String houseNameNumber, String street, String region, String county, String country, String city, String postcode) {
        return F.Promise.promise(() -> {
            try {

                final Service service = new Service(new URL(w2GlobaldataSettings.wsdlURL));
                final IService servicePort = service.getPort(IService.class);

                ServiceRequest serviceRequest = new ServiceRequest();

                final BundleData bundleData = new BundleData();
                serviceRequest.setBundleData(new JAXBElement<>(new QName("d4p1"), BundleData.class, bundleData));

                final ArrayOfKeyValueOfstringstring queryOptions = new ArrayOfKeyValueOfstringstring();
                final ArrayOfKeyValueOfstringstring.KeyValueOfstringstring queryOption = new ArrayOfKeyValueOfstringstring.KeyValueOfstringstring();

                queryOption.setKey("Sandbox");
                queryOption.setValue("true");

                queryOptions.getKeyValueOfstringstring().add(queryOption);
                serviceRequest.setQueryOptions(new JAXBElement<>(new QName("d4p1"), ArrayOfKeyValueOfstringstring.class, queryOptions));

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
                //TODO: FIND FIX
                //queryData.setCountry(IsoCountriesEnum.valueOf("country"));
                queryData.setCountry(null);
                queryData.setCity(new JAXBElement<>(new QName("d4p1"), String.class, city));
                queryData.setPostcode(new JAXBElement<>(new QName("d4p1"), String.class, postcode));


                serviceRequest.setQueryData(new JAXBElement<>(new QName("d4p1"), QueryData.class, queryData));

                ServiceAuthorisation serviceAuthorisation = new ServiceAuthorisation();
                serviceAuthorisation.setAPIKey(new JAXBElement<>(new QName("d4p1"), String.class, "123456"));

                serviceRequest.setServiceAuthorisation(new JAXBElement<>(new QName("d4p1"), ServiceAuthorisation.class, serviceAuthorisation));

                final ServiceResponse serviceResponse = servicePort.kycCheck(serviceRequest);

                return serviceResponse;

            } catch (Exception ex) {
                Logger.error("W2 global data invokeW2DataEkycUk007Service error: ", ex);
                throw new W2GlobaldataException("W2 global data invokeW2DataEkycUk007Service error");
            }
        });
    }

    private F.Promise<ServiceResponse> invokeSPFPlusService(W2GlobaldataSettings w2GlobaldataSettings, String nameQuery, Integer nameQueryMatchThreshold, Integer dateOfBirthMatchThreshold, Integer dayOfBirth, Integer monthOfBirth, Integer yearOfBirth) {
        return F.Promise.promise(() -> {
            try {

                final Service service = new Service(new URL(w2GlobaldataSettings.wsdlURL));
                final IService servicePort = service.getPort(IService.class);

                ServiceRequest serviceRequest = new ServiceRequest();

                final BundleData bundleData = new BundleData();
                serviceRequest.setBundleData(new JAXBElement<>(new QName("d4p1"), BundleData.class, bundleData));

                final ArrayOfKeyValueOfstringstring queryOptions = new ArrayOfKeyValueOfstringstring();
                final ArrayOfKeyValueOfstringstring.KeyValueOfstringstring queryOption = new ArrayOfKeyValueOfstringstring.KeyValueOfstringstring();

                queryOption.setKey("Sandbox");
                queryOption.setValue("true");

                queryOptions.getKeyValueOfstringstring().add(queryOption);
                serviceRequest.setQueryOptions(new JAXBElement<>(new QName("d4p1"), ArrayOfKeyValueOfstringstring.class, queryOptions));

                QueryData queryData = new QueryData();

                queryData.setNameQuery(new JAXBElement<>(new QName("d4p1"), String.class, nameQuery));
                queryData.setNameQueryMatchThreshold(new JAXBElement<>(new QName("d4p1"), Integer.class, nameQueryMatchThreshold));
                queryData.setDateOfBirthMatchThreshold(new JAXBElement<>(new QName("d4p1"), Integer.class, dateOfBirthMatchThreshold));
                queryData.setDayOfBirth(new JAXBElement<>(new QName("d4p1"), Integer.class, dayOfBirth));
                queryData.setMonthOfBirth(new JAXBElement<>(new QName("d4p1"), Integer.class, monthOfBirth));
                queryData.setYearOfBirth(new JAXBElement<>(new QName("d4p1"), Integer.class, yearOfBirth));

                serviceRequest.setQueryData(new JAXBElement<>(new QName("d4p1"), QueryData.class, queryData));

                ServiceAuthorisation serviceAuthorisation = new ServiceAuthorisation();
                serviceAuthorisation.setAPIKey(new JAXBElement<>(new QName("d4p1"), String.class, "123456"));

                serviceRequest.setServiceAuthorisation(new JAXBElement<>(new QName("d4p1"), ServiceAuthorisation.class, serviceAuthorisation));

                final ServiceResponse serviceResponse = servicePort.kycCheck(serviceRequest);

                return serviceResponse;

            } catch (Exception ex) {
                Logger.error("W2 global data invokeW2DataEkycUk007Service error: ", ex);
                throw new W2GlobaldataException("W2 global data invokeW2DataEkycUk007Service error");
            }
        });
    }


    private F.Promise<ServiceResponse> invokeW2DataAddressLookup007Service(W2GlobaldataSettings w2GlobaldataSettings, String houseNameNumber, String postcode, String street, String county, String city, String country) {
        return F.Promise.promise(() -> {
            try {

                final Service service = new Service(new URL(w2GlobaldataSettings.wsdlURL));
                final IService servicePort = service.getPort(IService.class);

                ServiceRequest serviceRequest = new ServiceRequest();

                final BundleData bundleData = new BundleData();
                serviceRequest.setBundleData(new JAXBElement<>(new QName("d4p1"), BundleData.class, bundleData));

                final ArrayOfKeyValueOfstringstring queryOptions = new ArrayOfKeyValueOfstringstring();
                final ArrayOfKeyValueOfstringstring.KeyValueOfstringstring queryOption = new ArrayOfKeyValueOfstringstring.KeyValueOfstringstring();

                queryOption.setKey("Sandbox");
                queryOption.setValue("true");

                queryOptions.getKeyValueOfstringstring().add(queryOption);
                serviceRequest.setQueryOptions(new JAXBElement<>(new QName("d4p1"), ArrayOfKeyValueOfstringstring.class, queryOptions));

                QueryData queryData = new QueryData();

                queryData.setHouseNameNumber(new JAXBElement<>(new QName("d4p1"), String.class, houseNameNumber));
                queryData.setPostcode(new JAXBElement<>(new QName("d4p1"), String.class, postcode));
                queryData.setStreet(new JAXBElement<>(new QName("d4p1"), String.class, street));
                queryData.setCounty(new JAXBElement<>(new QName("d4p1"), String.class, county));
                queryData.setCity(new JAXBElement<>(new QName("d4p1"), String.class, city));
                //TODO: FIND FIX
                //queryData.setCountry(IsoCountriesEnum.valueOf("country"));
                queryData.setCountry(null);

                serviceRequest.setQueryData(new JAXBElement<>(new QName("d4p1"), QueryData.class, queryData));

                ServiceAuthorisation serviceAuthorisation = new ServiceAuthorisation();
                serviceAuthorisation.setAPIKey(new JAXBElement<>(new QName("d4p1"), String.class, "123456"));

                serviceRequest.setServiceAuthorisation(new JAXBElement<>(new QName("d4p1"), ServiceAuthorisation.class, serviceAuthorisation));

                final ServiceResponse serviceResponse = servicePort.kycCheck(serviceRequest);

                return serviceResponse;

            } catch (Exception ex) {
                Logger.error("W2 global data invokeW2DataEkycUk007Service error: ", ex);
                throw new W2GlobaldataException("W2 global data invokeW2DataEkycUk007Service error");
            }
        });
    }


    private F.Promise<ServiceResponse> invokeW2DATAIDVCHECKService(W2GlobaldataSettings w2GlobaldataSettings, String forename, String surname, String houseNameNumber, String postcode, Integer dayOfBirth, Integer monthOfBirth, Integer yearOfBirth, String country, String gender, String phoneNumber, String mobileNumber, String flat, String city, String county) {
        return F.Promise.promise(() -> {
            try {

                final Service service = new Service(new URL(w2GlobaldataSettings.wsdlURL));
                final IService servicePort = service.getPort(IService.class);

                ServiceRequest serviceRequest = new ServiceRequest();

                final BundleData bundleData = new BundleData();
                serviceRequest.setBundleData(new JAXBElement<>(new QName("d4p1"), BundleData.class, bundleData));

                final ArrayOfKeyValueOfstringstring queryOptions = new ArrayOfKeyValueOfstringstring();
                final ArrayOfKeyValueOfstringstring.KeyValueOfstringstring queryOption = new ArrayOfKeyValueOfstringstring.KeyValueOfstringstring();

                queryOption.setKey("Sandbox");
                queryOption.setValue("true");

                queryOptions.getKeyValueOfstringstring().add(queryOption);
                serviceRequest.setQueryOptions(new JAXBElement<>(new QName("d4p1"), ArrayOfKeyValueOfstringstring.class, queryOptions));

                QueryData queryData = new QueryData();

                queryData.setForename(new JAXBElement<>(new QName("d4p1"), String.class, forename));
                queryData.setSurname(new JAXBElement<>(new QName("d4p1"), String.class, surname));
                queryData.setHouseNameNumber(new JAXBElement<>(new QName("d4p1"), String.class, houseNameNumber));
                queryData.setPostcode(new JAXBElement<>(new QName("d4p1"), String.class, postcode));
                queryData.setDayOfBirth(new JAXBElement<>(new QName("d4p1"), Integer.class, dayOfBirth));
                queryData.setMonthOfBirth(new JAXBElement<>(new QName("d4p1"), Integer.class, monthOfBirth));
                queryData.setYearOfBirth(new JAXBElement<>(new QName("d4p1"), Integer.class, yearOfBirth));

                //TODO: FIND FIX
                queryData.setCountry(IsoCountriesEnum.valueOf(country));

                queryData.setGender(new JAXBElement<>(new QName("d4p1"), String.class, gender));
                queryData.setPhoneNumber(new JAXBElement<>(new QName("d4p1"), String.class, phoneNumber));
                queryData.setMobileNumber(new JAXBElement<>(new QName("d4p1"), String.class, mobileNumber));
                queryData.setFlat(new JAXBElement<>(new QName("d4p1"), String.class, flat));
                queryData.setCity(new JAXBElement<>(new QName("d4p1"), String.class, city));
                queryData.setCounty(new JAXBElement<>(new QName("d4p1"), String.class, county));

                serviceRequest.setQueryData(new JAXBElement<>(new QName("d4p1"), QueryData.class, queryData));

                UploadedFile uploadedFile = new UploadedFile();
                uploadedFile.setDocumentReference(new JAXBElement<>(new QName("d4p1"), String.class, "test"));
                uploadedFile.setService(ServiceEnum.W_2_DATA_ADDRESS_LOOK_UP_007);
                JAXBElement<ArrayOfUploadedFile> arrayOfUploadedFileJAXBElement = new JAXBElement(new QName("d4p1"), UploadedFile.class, uploadedFile);

                serviceRequest.setUploadedFiles(arrayOfUploadedFileJAXBElement);


                ServiceAuthorisation serviceAuthorisation = new ServiceAuthorisation();
                serviceAuthorisation.setAPIKey(new JAXBElement<>(new QName("d4p1"), String.class, "123456"));

                serviceRequest.setServiceAuthorisation(new JAXBElement<>(new QName("d4p1"), ServiceAuthorisation.class, serviceAuthorisation));

                final ServiceResponse serviceResponse = servicePort.kycCheck(serviceRequest);

                return serviceResponse;

            } catch (Exception ex) {
                Logger.error("W2 global data invokeW2DataEkycUk007Service error: ", ex);
                throw new W2GlobaldataException("W2 global data invokeW2DataEkycUk007Service error");
            }
        });
    }

    private F.Promise<W2GlobaldataSettings> getW2GlobaldataSettings() {

        final F.Promise<Property> wsdlPromise = F.Promise.wrap(propertyRepository.retrieveById("w2.globaldata.wsdl.url"));

        return wsdlPromise.map(res -> {

            String url = res.getValue();

            return new W2GlobaldataSettings(url);

        });
    }


    private class W2GlobaldataSettings {

        private String wsdlURL;

        public W2GlobaldataSettings(String wsdlURL) {
            this.wsdlURL = wsdlURL;
        }

    }


}
