package services;

import accomplish.*;
import accomplish.dto.account.GetAccountResponse;
import accomplish.dto.account.activate.Activate;
import accomplish.dto.card.CreateCard;
import accomplish.dto.card.CreateCardResponse;
import accomplish.dto.card.Info;
import accomplish.dto.customerget.Account;
import accomplish.dto.customerget.GetCustomerResponse;
import accomplish.dto.identification.CreateIdentification;
import accomplish.dto.identification.CreateIdentificationResponse;
import accomplish.dto.identification.Identification;
import accomplish.dto.identification.document.Attachment;
import accomplish.dto.identification.document.CreateDocument;
import accomplish.dto.identification.document.CreateDocumentResponse;
import accomplish.dto.transfer.AccountInfo;
import accomplish.dto.transfer.Info_;
import accomplish.dto.transfer.Transfer;
import accomplish.dto.transfer.Transfer_;
import accomplish.dto.transfer.response.TransferResponse;
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
import org.springframework.util.StringUtils;
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
        private String programID1;
        private String programID2;

        public AccomplishSettings(String apiURL, String userName, String password, String programID1, String programID2) {
            this.apiURL = apiURL;
            this.userName = userName;
            this.password = password;
            this.programID1 = programID1;
            this.programID2 = programID2;
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
                .addFormParam("program_Id", accomplishSettings.programID1)
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

        if (type.equalsIgnoreCase("passport")) {
            typeValue = 0;
        } else if (type.equalsIgnoreCase("driverLicence")) {
            typeValue = 1;
        } else if (type.equalsIgnoreCase("nationalId")) {
            typeValue = 2;
        } else if (type.equalsIgnoreCase("socialSecurityNumber")) {
            typeValue = 3;
        } else if (type.equalsIgnoreCase("socialInsuranceNumber")) {
            typeValue = 4;
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

    public F.Promise<GetCustomerResponse> getCustomer(String userID, String partnerID) {

        final GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.disableHtmlEscaping();

        final Gson gson = gsonBuilder.create();


        F.Promise<String> promise = execute("service/v1/user/" + userID, "", "GET", partnerID);

        return promise.map(res -> {
            GetCustomerResponse createUserResponse = gson.fromJson(res, GetCustomerResponse.class);

            Logger.info("Result = " + createUserResponse.getResult().getCode());

            return createUserResponse;
        });
    }

    public F.Promise<CreateDocumentResponse> sendDocument(String userID, String fileName, String content, String type, String partnerID) {

        CreateDocument createDocument = new CreateDocument();

        List<Attachment> attachments = new ArrayList<>();

        Attachment attachment = new Attachment();

        attachment.setFileName(fileName);
        attachment.setFileExtension(".jpg");
        attachment.setContent(content);

        attachments.add(attachment);

        createDocument.setAttachment(attachments);

        accomplish.dto.identification.document.Info info = new accomplish.dto.identification.document.Info();

        int entityValue = 15;
        int typeValue = 1;

        if (type.equalsIgnoreCase("profilePicture")) {
            typeValue = 1;
            entityValue = 25;
        } else if (type.equalsIgnoreCase("passport")) {
            typeValue = 2;
            entityValue = 25;
        } else if (type.equalsIgnoreCase("nationalId")) {
            typeValue = 3;
            entityValue = 25;
        } else if (type.equalsIgnoreCase("driverLicence")) {
            typeValue = 4;
            entityValue = 25;
        } else if (type.equalsIgnoreCase("utilityBill")) {
            typeValue = 5;
            entityValue = 15;
        } else if (type.equalsIgnoreCase("creditcardStatement")) {
            typeValue = 6;
            entityValue = 15;
        } else if (type.equalsIgnoreCase("bankStatement")) {
            typeValue = 7;
            entityValue = 15;
        } else if (type.equalsIgnoreCase("financialStatement")) {
            typeValue = 8;
            entityValue = 60;
        } else if (type.equalsIgnoreCase("receipt")) {
            typeValue = 9;
            entityValue = 25;
        } else if (type.equalsIgnoreCase("taxDocument")) {
            typeValue = 10;
            entityValue = 60;
        } else if (type.equalsIgnoreCase("insuranceDocument")) {
            typeValue = 11;
            entityValue = 60;
        } else if (type.equalsIgnoreCase("other")) {
            typeValue = 12;
            entityValue = 60;
        }


        info.setEntity(entityValue);
        info.setType(typeValue);
        info.setSubject("Identification");
//        info.setFirstName("Artyom");
//        info.setLastName("Terehschenko");
        info.setLanguage("en");
        info.setEntityId(0);

        createDocument.setInfo(info);

        final GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.disableHtmlEscaping();

        final Gson gson = gsonBuilder.create();
        String json = gson.toJson(createDocument);


        F.Promise<String> promise = execute("service/v1/user/document/" + userID, json, "POST", partnerID);

        return promise.map(res -> {
            CreateDocumentResponse createUserResponse = gson.fromJson(res, CreateDocumentResponse.class);

            Logger.info("Result = " + createUserResponse.getResult().getCode());

            return createUserResponse;
        });
    }

    public F.Promise<CreateCardResponse> createCard(String userID, String cardModel, String partnerID) {

        return getSettingsForPartner(partnerID).flatMap(accomplishSettings -> {
            CreateCard createCard = new CreateCard();

            long bin = 0;
            String currency = "DKK";
            int type = 0;
            int status = 0;

            if (cardModel.equalsIgnoreCase("mymonii_parentwallet")) {
                bin = Long.parseLong(accomplishSettings.programID1);
                type = 1;
                status = 1;
            } else if (cardModel.equalsIgnoreCase("mymonii_childcard")) {
                bin = Long.parseLong(accomplishSettings.programID2);
                status = 12;
                type = 0;
            }

//        if (currency.equalsIgnoreCase("EUR")) {
//            bin = 4560;
//        } else if (currency.equalsIgnoreCase("GBP")) {
//            bin = 4560;
//        }


            Info info = new Info();
            info.setBinId("" + bin);
            info.setCurrency(currency);
            info.setType("" + type);
            info.setStatus("" + status);
            info.setUserId(Integer.parseInt(userID));

            createCard.setInfo(info);

            accomplish.dto.card.CustomField customField = new accomplish.dto.card.CustomField();
            customField.setAcceptance("1");
            customField.setAcceptance2("2");

            createCard.setCustomField(customField);

            final GsonBuilder gsonBuilder = new GsonBuilder();
            gsonBuilder.disableHtmlEscaping();

            final Gson gson = gsonBuilder.create();
            String json = gson.toJson(createCard);

            F.Promise<String> promise = execute("service/v1/account/", json, "POST", partnerID);

            return promise.map(res -> {
                CreateCardResponse createCardresponse = gson.fromJson(res, CreateCardResponse.class);

                return createCardresponse;
            });
        });
    }

    public F.Promise<TransferResponse> transfer(String userID, String receiverID, String amount, String currency, String partnerID) {

        return getSettingsForPartner(partnerID).flatMap(accomplishSettings -> {


            Transfer transfer = new Transfer();

            accomplish.dto.transfer.Account account = new accomplish.dto.transfer.Account();

            accomplish.dto.transfer.Info info = new accomplish.dto.transfer.Info();

            info.setAmount(amount);
            info.setCurrency(currency);
            info.setType("220"); //TODO: wtf?

            Info_ info_ = new Info_();
            info_.setId(Integer.parseInt(userID));
            account.setInfo(info_);

            Transfer_ transfer_ = new Transfer_();

            AccountInfo accountInfo = new AccountInfo();
            accountInfo.setId(Integer.parseInt(receiverID));
            transfer_.setAccountInfo(accountInfo);


            transfer.setAccount(account);
            transfer.setInfo(info);
            transfer.setTransfer(transfer_);
            transfer.setValidate("0");

            final GsonBuilder gsonBuilder = new GsonBuilder();
            gsonBuilder.disableHtmlEscaping();

            final Gson gson = gsonBuilder.create();
            String json = gson.toJson(transfer);

            F.Promise<String> promise = execute("service/v1/transaction/", json, "POST", partnerID);

            return promise.map(res -> {
                TransferResponse createCardresponse = gson.fromJson(res, TransferResponse.class);

                return createCardresponse;
            });
        });
    }


    public F.Promise<GetAccountResponse> getAccount(String card, String partnerID) {

        final GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.disableHtmlEscaping();

        final Gson gson = gsonBuilder.create();

        F.Promise<String> promise = execute("service/v1/account/" + card, "", "GET", partnerID);
        return promise.map(res -> {
            GetAccountResponse getAccountResponse = gson.fromJson(res, GetAccountResponse.class);

            return getAccountResponse;
        });
    }

    public F.Promise<GetAccountResponse> activateAccount(String card, String partnerID) {

        Activate activate = new Activate();

        accomplish.dto.account.activate.Info info = new accomplish.dto.account.activate.Info();

//        info.set

//        activate.setInfo();


        final GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.disableHtmlEscaping();

        final Gson gson = gsonBuilder.create();

        F.Promise<String> promise = execute("service/v1/account/" + card, "", "GET", partnerID);
        return promise.map(res -> {
            GetAccountResponse getAccountResponse = gson.fromJson(res, GetAccountResponse.class);

            return getAccountResponse;
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

            return new AccomplishSettings(split[0], split[1], split[2], split[3], split[4]);
        });
    }
}
