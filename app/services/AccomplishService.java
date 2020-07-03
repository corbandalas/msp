package services;

import accomplish.*;
import accomplish.dto.identification.CreateIdentification;
import accomplish.dto.identification.CreateIdentificationResponse;
import accomplish.dto.identification.Identification;
import accomplish.dto.user.CreateUserResponse;
import akka.dispatch.Futures;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.ning.http.client.AsyncCompletionHandler;
import com.ning.http.client.AsyncHttpClient;
import com.ning.http.client.Response;
import exception.WrongPropertyException;
import model.Property;
import play.Logger;
import play.libs.F;
import repository.PropertyRepository;
import scala.concurrent.Future;
import scala.concurrent.Promise;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Accomplish payment service
 *
 * @author corbandalas - created 17.06.2020
 * @since 0.6.0
 */

@Singleton
public class AccomplishService {

    @Inject
    private PropertyRepository propertyRepository;


    private class AccomplishSettings {

        private String apiURL;
        private String userName;
        private String password;
        private String programID;

        public AccomplishSettings(String apiURL, String userName, String password, String programID) {
            this.apiURL = apiURL;
            this.userName = userName;
            this.password = password;
            this.programID = programID;
        }
    }

    public String getAccessUrl(AccomplishSettings accomplishSettings, String relativeURL) {
        return accomplishSettings.apiURL + relativeURL;
    }

    public Future<String> getOauth(AccomplishSettings accomplishSettings) {


        final String query = getAccessUrl(accomplishSettings, "Service/oauth/token");

        Logger.info("Query: " + query);

        final AsyncHttpClient asyncHttpClient = new AsyncHttpClient();
        final Promise<String> promise = Futures.promise();


        asyncHttpClient.preparePost(query)
                .addFormParam("grant_type", "program_credential")
                .addFormParam("user_name", accomplishSettings.userName)
                .addFormParam("password", accomplishSettings.password)
                .addFormParam("program_Id", accomplishSettings.programID)
                .addFormParam("language", "en")

                .execute(new AsyncCompletionHandler<String>() {

                    @Override
                    public String onCompleted(Response response) throws Exception {

                        String responseBody = response.getResponseBody();
                        Logger.info("///Accomplish OAuth API response: " + responseBody);

                        final GsonBuilder gsonBuilder = new GsonBuilder();
                        gsonBuilder.disableHtmlEscaping();

                        final Gson gson = gsonBuilder.create();

                        TokenResponse tokenResponse = gson.fromJson(responseBody, TokenResponse.class);

                        promise.success(tokenResponse.getAccessToken());

                        return responseBody;
                    }

                    @Override
                    public void onThrowable(Throwable t) {
                        Logger.error("/////Error while retrieving Accomplish API response", t);

                        promise.failure(t);
                    }
                });
        return promise.future();
    }


    public F.Promise<CreateUserResponse> createUser(String emailValue, String title, String firstName, String lastName,
                                                    String birthdayDate, String mobilePhone, String nationality,
                                                    String kycLevel, String address1, String address2, String city,
                                                    String zip, String country, String lang, String password, String partnerID) {
        CreateUser createUser = new CreateUser();

        PersonalInfo personalInfo = new PersonalInfo();

        personalInfo.setFirstName(firstName);
        personalInfo.setLastName(lastName);
        personalInfo.setJobTitle(title);
//        personalInfo.setNickName();
        personalInfo.setTitle(title);
        personalInfo.setGender("0");
        personalInfo.setDateOfBirth(birthdayDate);
        personalInfo.setVerificationStatus("1");

        Address address = new Address();
        address.setAddressLine1(address1);
        address.setAddressLine2(address2);
        address.setCityTown(city);
        address.setPostalZipCode(zip);
//        address.setStateRegion("DN");
        address.setCountryCode(country);
        address.setVerificationStatus(1);


        List<Email> emails = new ArrayList<Email>();
        Email email = new Email();
        email.setAddress(emailValue);
        email.setIsPrimary("1");
        email.setVerificationStatus("1");
        emails.add(email);

        List<Phone> phones = new ArrayList<Phone>();
        Phone phone = new Phone();
        phone.setCountryCode(country);
        phone.setIsPrimary(1);
        phone.setNumber(mobilePhone);
        phone.setType("1");
        phone.setVerificationStatus("1");
        phones.add(phone);


        List<Currency> currencies = new ArrayList<Currency>();
        Currency currency = new Currency();
        currency.setCode("EUR");
        currencies.add(currency);

        Preferences preferences = new Preferences();
        preferences.setTimeZone("UTC +03:00");
        preferences.setPreferredLanguageCode(lang);


        TermsConditions termsConditions = new TermsConditions();
        termsConditions.setAcceptance("1");

        Security security = new Security();

        security.setSecurityCode("1111");
        security.setPassword(password);
        security.setSecretAnswer1("soma");
        security.setSecretAnswer2("Alex");
        security.setSecretQuestion1("1");
        security.setSecretQuestion2("2");

        createUser.setSecurity(security);
        createUser.setTermsConditions(termsConditions);
        createUser.setPreferences(preferences);
        createUser.setCurrency(currencies);
        createUser.setPhone(phones);
        createUser.setEmail(emails);
        createUser.setAddress(address);
        createUser.setPersonalInfo(personalInfo);

        final GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.disableHtmlEscaping();

        final Gson gson = gsonBuilder.create();
        String json = gson.toJson(createUser);


        F.Promise<String> promise = execute("service/v1/user/", json, "POST", partnerID);

        return promise.map(res -> {
            CreateUserResponse createUserResponse = gson.fromJson(res, CreateUserResponse.class);

            Logger.info("Result = " + createUserResponse.getResult().getCode());

            return createUserResponse;
        });
    }


    public F.Promise<CreateIdentificationResponse> createIdentification(String userID, String issuanceCountry,
                                            String residenceCountry, String issueDate, String expiryDate, String type, String number, String partnerID) {

        CreateIdentification createIdentification = new CreateIdentification();

        List<Identification> identifications = new ArrayList<>();

        Identification identification = new Identification();
        identification.setCountryOfIssue(issuanceCountry);
        identification.setCountryOfResidence(residenceCountry);
        identification.setExpiryDate(expiryDate);
        identification.setIssueDate(issueDate);
        identification.setNumber(number);

        int typeValue = 3;

        //TODO:

        if (type.equalsIgnoreCase("passport")) {
            typeValue = 3;

        } else if (type.equalsIgnoreCase("driverLicence")) {
            typeValue = 3;
        } else if (type.equalsIgnoreCase("nationalId")) {
            typeValue = 3;
        } else if (type.equalsIgnoreCase("socialSecurityNumber")) {
            typeValue = 3;
        } else if (type.equalsIgnoreCase("socialInsuranceNumber")) {
            typeValue = 3;
        }


        identification.setType(typeValue);
        identification.setVerificationStatus(1);

        identifications.add(identification);

        createIdentification.setIdentification(identifications);

        final GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.disableHtmlEscaping();

        final Gson gson = gsonBuilder.create();
        String json = gson.toJson(createIdentification);


        F.Promise<String> promise = execute("service/v1/user/identification/" + userID, json, "POST", partnerID);

        return promise.map(res -> {
            CreateIdentificationResponse createUserResponse = gson.fromJson(res, CreateIdentificationResponse.class);

            Logger.info("Result = " + createUserResponse.getResult().getCode());

            return createUserResponse;
        });
    }


    private F.Promise<String> execute(String url, String body, String method, String partnerID) {
        return getSettingsForPartner(partnerID).flatMap(res -> F.Promise.wrap(getOauth(res)).flatMap(token -> F.Promise.wrap(invokeAPI(url, body, token, method, res))));
    }


    private Future<String> invokeAPI(String url, String body, String token, String method, AccomplishSettings accomplishSettings) {

        final String query = accomplishSettings.apiURL + url;

        Logger.info("Accomplish Query: " + query);

        final AsyncHttpClient asyncHttpClient = new AsyncHttpClient();
        final Promise<String> promise = Futures.promise();

        AsyncHttpClient.BoundRequestBuilder boundRequestBuilder = null;

        if (method.equalsIgnoreCase("POST")) {

            boundRequestBuilder = asyncHttpClient.preparePost(query);

        } else if (method.equalsIgnoreCase("GET")) {
            boundRequestBuilder = asyncHttpClient.prepareGet(query);
        }


        boundRequestBuilder.setBody(body)
                .addHeader("Content-type", "application/json")
                .addHeader("Authorization", "Bearer " + token)
                .addHeader("source_id", "" + System.currentTimeMillis())
                .addHeader("lang", "en")
                .addHeader("time_zone", "UTC +03:00")
                .execute(new AsyncCompletionHandler<String>() {

                    @Override
                    public String onCompleted(Response response) throws Exception {

                        String responseBody = response.getResponseBody();
                        Logger.info("///Accomplish API response: " + responseBody);


                        promise.success(responseBody);


                        return responseBody;
                    }

                    @Override
                    public void onThrowable(Throwable t) {
                        Logger.error("/////Error while retrieving Accomplish API response", t);

                        promise.failure(t);
                    }
                });
        return promise.future();
    }


    private F.Promise<AccomplishSettings> getSettingsForPartner(String partnerID) {

        final F.Promise<Optional<Property>> otherSettingsPromise = F.Promise.wrap(propertyRepository.retrieveById("cardprovider.accomplish.api.settings." + partnerID));

        return otherSettingsPromise.map(res -> {

            String gpsConfigStringValue = res.orElseThrow(WrongPropertyException::new).getValue();

            String[] split = gpsConfigStringValue.split("|");

            return new AccomplishSettings(split[0], split[1], split[2], split[3]);
        });
    }
}
