package services;

import accomplish.*;
import accomplish.Email;
import accomplish.Security;
import accomplish.dto.account.GetAccountResponse;
import accomplish.dto.account.activate.*;
import accomplish.dto.account.activate.response.ActivateResponse;
import accomplish.dto.account.load.Account;
import accomplish.dto.account.load.response.LoadResponse;
import accomplish.dto.card.CreateCard;
import accomplish.dto.card.CreateCardResponse;
import accomplish.dto.card.Info;
import accomplish.dto.customerget.Address_;
import accomplish.dto.customerget.GetCustomerResponse;
import accomplish.dto.identification.CreateIdentification;
import accomplish.dto.identification.CreateIdentificationResponse;
import accomplish.dto.identification.Identification;
import accomplish.dto.identification.document.Attachment;
import accomplish.dto.identification.document.CreateDocument;
import accomplish.dto.identification.document.CreateDocumentResponse;
import accomplish.dto.transaction.GetTransactionResponse;
import accomplish.dto.transfer.AccountInfo;
import accomplish.dto.transfer.Info_;
import accomplish.dto.transfer.Transfer;
import accomplish.dto.transfer.Transfer_;
import accomplish.dto.transfer.response.TransferResponse;
import accomplish.dto.user.CreateUserResponse;
import accomplish.dto.user.update.address.UpdateUserAddressRequest;
import accomplish.dto.user.update.address.response.AddressRequestBean;
import accomplish.dto.user.update.address.response.UpdateUserAddressResponse;
import accomplish.dto.user.update.email.*;
import accomplish.dto.user.update.email.response.UpdateUserEmailResponse;
import accomplish.dto.user.update.phone.UpdateUserPhone;
import accomplish.dto.user.update.phone.response.UpdateUserPhoneResponse;
import akka.dispatch.Futures;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.ning.http.client.AsyncCompletionHandler;
import com.ning.http.client.AsyncHttpClient;
import com.ning.http.client.Response;
import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;
import exception.WrongPropertyException;
import model.Property;
import org.apache.commons.lang3.StringUtils;
import play.Logger;
import play.libs.F;
import repository.CustomerRepository;
import repository.PropertyRepository;
import scala.concurrent.Future;
import scala.concurrent.Promise;
import util.Utils;

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

    @Inject
    private CustomerRepository customerRepository;


    private class AccomplishSettings {

        private String apiURL;
        private String userName;
        private String password;
        private String programID;
        private String productID1;
        private String productID2;


        public AccomplishSettings(String apiURL, String userName, String password, String programID, String productID1,
                                  String productID2) {
            this.apiURL = apiURL;
            this.userName = userName;
            this.password = password;
            this.programID = programID;
            this.productID1 = productID1;
            this.productID2 = productID2;
        }
    }

    public String getAccessUrl(AccomplishSettings accomplishSettings, String relativeURL) {

        Logger.info("accomplishSettings.apiURL = " + accomplishSettings.apiURL);

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
                                                    String zip, String country, String lang, String password, String cdata1, String cdata2, String cdata3, String partnerID) {

        String data = cdata3;

        if (StringUtils.isEmpty(cdata3)) {
            data = "fake";
        }

        return F.Promise.wrap(customerRepository.retrieveByUUID(data)).flatMap(rez -> {
            CreateUser createUser = new CreateUser();

            PersonalInfo personalInfo = new PersonalInfo();


            personalInfo.setFirstName(Utils.trasliterateDanish(firstName));
            personalInfo.setLastName(Utils.trasliterateDanish(lastName));
            personalInfo.setJobTitle(title);
//        personalInfo.setNickName();

            String titleValue = "10";

            if (title.equalsIgnoreCase("Mr")) {
                titleValue = "1";
            } else if (title.equalsIgnoreCase("Mrs")) {
                titleValue = "1";
            } else if (title.equalsIgnoreCase("Ms")) {
                titleValue = "1";
            }

            personalInfo.setTitle(titleValue);
            personalInfo.setGender("0");
            personalInfo.setDateOfBirth(birthdayDate);
            personalInfo.setVerificationStatus("1");

            Address address = new Address();
            address.setAddressLine1(Utils.trasliterateDanish(address1));
            address.setAddressLine2(Utils.trasliterateDanish(address2));
            address.setCityTown(Utils.trasliterateDanish(city));
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

            CustomField customField = new CustomField();



            customField.setCdata1(cdata1);
            if (StringUtils.isBlank(cdata2)) {
                customField.setCdata2("");
            } else {
                customField.setCdata2(cdata2);
            }
            if (StringUtils.isNotEmpty(cdata3)) {
                customField.setCdata3(cdata3);
                customField.setLinkedUserId(rez.get().getReferral());
            }


            createUser.setCustomField(customField);

            final GsonBuilder gsonBuilder = new GsonBuilder();
            gsonBuilder.disableHtmlEscaping();

            final Gson gson = gsonBuilder.create();
            String json = gson.toJson(createUser);


            F.Promise<String> promise = execute("service/v1/user/", json, "POST", partnerID, true);

            return promise.map(res -> {
                CreateUserResponse createUserResponse = gson.fromJson(res, CreateUserResponse.class);

                Logger.info("Result = " + createUserResponse.getResult().getCode());

                return createUserResponse;
            });
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


        F.Promise<String> promise = execute("service/v1/user/identification/" + userID, json, "POST", partnerID, false);

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


        F.Promise<String> promise = execute("service/v1/user/" + userID, "", "GET", partnerID, true);

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

        attachment.setFileName(Utils.trasliterateDanish(fileName));
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


        F.Promise<String> promise = execute("service/v1/user/document/" + userID, json, "POST", partnerID, false);

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

            Config conf = ConfigFactory.load();

            String accomplishProd = conf.getString("accomplish.environment.prod");

            if (accomplishProd.equalsIgnoreCase("false")) {
                bin = Long.parseLong(accomplishSettings.productID1);
                type = 0;
                status = 1;
                currency = "EUR";

            } else {
                if (cardModel.equalsIgnoreCase("mymonii_parentwallet")) {
                    bin = Long.parseLong(accomplishSettings.productID1);
                    type = 1;
                    status = 1;
                } else if (cardModel.equalsIgnoreCase("mymonii_childcard")) {
                    bin = Long.parseLong(accomplishSettings.productID2);
                    status = 12;
                    type = 0;
                }
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

            F.Promise<String> promise = execute("service/v1/account/", json, "POST", partnerID, false);

            return promise.map(res -> {
                CreateCardResponse createCardresponse = gson.fromJson(res, CreateCardResponse.class);

                return createCardresponse;
            });
        });
    }

    public F.Promise<TransferResponse> transfer(String senderID, String receiverID, String amount, String currency, String partnerID) {

        return getSettingsForPartner(partnerID).flatMap(accomplishSettings -> {


            Transfer transfer = new Transfer();

            accomplish.dto.transfer.Account account = new accomplish.dto.transfer.Account();

            accomplish.dto.transfer.Info info = new accomplish.dto.transfer.Info();

            info.setAmount(amount);
            info.setCurrency(currency);
            info.setType("220"); //TODO: wtf?

            Info_ info_ = new Info_();
            info_.setId(Integer.parseInt(senderID));
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

            F.Promise<String> promise = execute("service/v1/transaction/", json, "POST", partnerID, false);

            return promise.map(res -> {
                TransferResponse createCardresponse = gson.fromJson(res, TransferResponse.class);

                return createCardresponse;
            });
        });
    }


    public F.Promise<GetAccountResponse> getAccount(String cardID, String partnerID) {

        final GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.disableHtmlEscaping();

        final Gson gson = gsonBuilder.create();

        F.Promise<String> promise = execute("service/v1/account/" + cardID, "", "GET", partnerID, true);
        return promise.map(res -> {
            GetAccountResponse getAccountResponse = gson.fromJson(res, GetAccountResponse.class);

            return getAccountResponse;
        });
    }

    public F.Promise<ActivateResponse> activateAccount(String cardID, String binID, String userID, String currency,
                                                       String number, String type, String activationCode,
                                                       String partnerID) {

        Activate activate = new Activate();

        accomplish.dto.account.activate.Info info = new accomplish.dto.account.activate.Info();

        info.setId(cardID);
        info.setBinId(binID);
        info.setCurrency(currency);
//        info.setNumber(number);
        info.setUserId(userID);
        info.setType(type);

        accomplish.dto.account.activate.Security security = new accomplish.dto.account.activate.Security();
        security.setActivationCode(activationCode);

        info.setSecurity(security);

        activate.setInfo(info);


        final GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.disableHtmlEscaping();

        final Gson gson = gsonBuilder.create();

        F.Promise<String> promise = execute("service/v1/account/activate/" + cardID, gson.toJson(activate), "POST", partnerID, true);
        return promise.map(res -> {
            ActivateResponse getAccountResponse = gson.fromJson(res, ActivateResponse.class);

            return getAccountResponse;
        });
    }

    public F.Promise<LoadResponse> load(String amount, String currency, String token,
                                        String partnerID) {

        accomplish.dto.account.load.Load load = new accomplish.dto.account.load.Load();

        accomplish.dto.account.load.Account account = new Account();

        accomplish.dto.account.load.Info info = new accomplish.dto.account.load.Info();
        info.setAmount(amount);
        info.setCurrency(currency);
        info.setType("138");

        accomplish.dto.account.load.Info_ info_ = new accomplish.dto.account.load.Info_();

        info_.setId(Integer.parseInt(token));

        account.setInfo(info_);

        load.setInfo(info);
        load.setAccount(account);

        final GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.disableHtmlEscaping();

        final Gson gson = gsonBuilder.create();

        String body = gson.toJson(load);

        F.Promise<String> promise = execute("service/v1/transaction", body, "POST", partnerID, false);
        return promise.map(res -> {
            LoadResponse loadResponse = gson.fromJson(res, LoadResponse.class);

            return loadResponse;
        });
    }


    public F.Promise<UpdateUserEmailResponse> updateUserEmail(String userID, String emailValue,

                                                              String partnerID) {


        return getCustomer(userID, partnerID).flatMap(cust -> {

            accomplish.dto.customerget.Email serverEmail = cust.getEmail().get(0);

            UpdateUserEmailRequest request = new UpdateUserEmailRequest();

            List<accomplish.dto.user.update.email.Email> emails = new ArrayList<>();
            accomplish.dto.user.update.email.Email email = new accomplish.dto.user.update.email.Email();
            email.setAddress(emailValue);
            email.setId(serverEmail.getId());
            email.setVerificationStatus(serverEmail.getVerificationStatus());

            emails.add(email);
            request.setEmail(emails);

            final GsonBuilder gsonBuilder = new GsonBuilder();
            gsonBuilder.disableHtmlEscaping();

            final Gson gson = gsonBuilder.create();

            String body = gson.toJson(request);

            F.Promise<String> promise = execute("service/v1/user/email/" + userID, body, "PUT", partnerID, false);
            return promise.map(res -> {
                UpdateUserEmailResponse loadResponse = gson.fromJson(res, UpdateUserEmailResponse.class);

                return loadResponse;
            });
        });
    }

    public F.Promise<UpdateUserAddressResponse> updateUserAddress(String userID, AddressRequestBean addressRequestBean,

                                                                  String partnerID) {

        return getCustomer(userID, partnerID).flatMap(cust -> {

            Address_ serverEmail = cust.getAddresses().get(0);

            UpdateUserAddressRequest request = new UpdateUserAddressRequest();

            List<accomplish.dto.user.update.address.Address> addresses = new ArrayList<>();

            accomplish.dto.user.update.address.Address address1 = new accomplish.dto.user.update.address.Address();
            address1.setAddressLine1(Utils.trasliterateDanish(addressRequestBean.getAddress1()));
            address1.setAddressLine2(Utils.trasliterateDanish(addressRequestBean.getAddress2()));
            address1.setCityTown(Utils.trasliterateDanish(addressRequestBean.getCity()));
            address1.setCountryCode(addressRequestBean.getCountry());
            address1.setPostalZipCode(addressRequestBean.getZip());
            address1.setId(serverEmail.getId());

            addresses.add(address1);
            request.setAddresses(addresses);

            final GsonBuilder gsonBuilder = new GsonBuilder();
            gsonBuilder.disableHtmlEscaping();

            final Gson gson = gsonBuilder.create();

            String body = gson.toJson(request);

            F.Promise<String> promise = execute("service/v1/user/address/" + userID, body, "PUT", partnerID, false);
            return promise.map(res -> {
                UpdateUserAddressResponse loadResponse = gson.fromJson(res, UpdateUserAddressResponse.class);

                return loadResponse;
            });
        });
    }

    public F.Promise<UpdateUserPhoneResponse> updateUserPhone(String userID, String phoneValue,

                                                              String partnerID) {


        return getCustomer(userID, partnerID).flatMap(cust -> {

            accomplish.dto.customerget.Phone phoneFromServer = cust.getPhone().get(0);

            UpdateUserPhone request = new UpdateUserPhone();

            List<accomplish.dto.user.update.phone.Phone> phones = new ArrayList<>();
            accomplish.dto.user.update.phone.Phone phone = new accomplish.dto.user.update.phone.Phone();

            phone.setCountryCode(phoneFromServer.getCountryCode());
            phone.setId(phoneFromServer.getId());
            phone.setNumber(phoneValue);
            phone.setIsPrimary(phoneFromServer.getIsPrimary());
            phone.setType(phoneFromServer.getType());
            phone.setVerificationStatus(phoneFromServer.getVerificationStatus());

            phones.add(phone);
            request.setPhone(phones);

            final GsonBuilder gsonBuilder = new GsonBuilder();
            gsonBuilder.disableHtmlEscaping();

            final Gson gson = gsonBuilder.create();

            String body = gson.toJson(request);

            F.Promise<String> promise = execute("service/v1/user/phone/" + userID, body, "PUT", partnerID, false);
            return promise.map(res -> {
                UpdateUserPhoneResponse loadResponse = gson.fromJson(res, UpdateUserPhoneResponse.class);

                return loadResponse;
            });
        });
    }

    public F.Promise<GetTransactionResponse> getTransaction(String userID, String cardID, int limit, int offset, String fromDate, String toDate, String partnerID) {

        final GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.disableHtmlEscaping();

        final Gson gson = gsonBuilder.create();


        F.Promise<String> promise = execute("service/v1/transaction/inquiry?user_id=" + userID +
                "&account_id=" + cardID + "&status=0&from_date=" + fromDate + "&to_date=" + toDate +
                "&page_size=" + limit + "&start_index=" + offset + "&sort_flag=asc&show_custom_field=1", "", "GET", partnerID, false);

        return promise.map(res -> {
            GetTransactionResponse createUserResponse = gson.fromJson(res, GetTransactionResponse.class);

            Logger.info("Result = " + createUserResponse.getResult().getCode());

            return createUserResponse;
        });
    }


    private F.Promise<String> execute(String url, String body, String method, String partnerID, boolean showSensetiveData) {
        return getSettingsForPartner(partnerID).flatMap(res -> F.Promise.wrap(getOauth(res)).flatMap(token -> F.Promise.wrap(invokeAPI(url, body, token, method, showSensetiveData, res))));
    }


    private Future<String> invokeAPI(String url, String body, String token, String method, boolean showSensetiveData, AccomplishSettings accomplishSettings) {

        final String query = accomplishSettings.apiURL + url;

        Logger.info("Accomplish Query: " + query);

        Logger.info("Accomplish request body: " + body);

        final AsyncHttpClient asyncHttpClient = new AsyncHttpClient();
        final Promise<String> promise = Futures.promise();

        AsyncHttpClient.BoundRequestBuilder boundRequestBuilder = null;

        if (method.equalsIgnoreCase("POST")) {

            boundRequestBuilder = asyncHttpClient.preparePost(query);

        } else if (method.equalsIgnoreCase("GET")) {
            boundRequestBuilder = asyncHttpClient.prepareGet(query);
        } else if (method.equalsIgnoreCase("PUT")) {
            boundRequestBuilder = asyncHttpClient.preparePut(query);
        }

        String sourceID = "" + System.currentTimeMillis();

        Logger.info("Source ID = " + sourceID);


        boundRequestBuilder = boundRequestBuilder.setBody(body)
                .addHeader("Content-type", "application/json")
                .addHeader("Authorization", "Bearer " + token)
                .addHeader("source_id", sourceID)
                .addHeader("lang", "en")
                .addHeader("time_zone", "UTC +03:00");
//                .addHeader("show_sensitive_data", "1")
//                .addHeader("show_custom_field", "1");

        if (showSensetiveData) {

            Logger.info("Added headers show_sensetive_data  = 1");
            boundRequestBuilder = boundRequestBuilder.addHeader("show_sensitive_data", "1");
            boundRequestBuilder = boundRequestBuilder.addHeader("show_custom_field", "1");
        }
//
//        }


        boundRequestBuilder.execute(new AsyncCompletionHandler<String>() {

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

            Logger.info("gpsConfigStringValue = " + gpsConfigStringValue);

            String[] split = StringUtils.split(gpsConfigStringValue, "|");

            return new AccomplishSettings(split[0], split[1], split[2], split[5], split[3], split[4]);
        });
    }
}
