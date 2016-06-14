package services;

import akka.dispatch.Futures;
import com.envoyservices.merchantapi.*;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.ning.http.client.*;
import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;
import dto.customer.CustomerWorldPayCreditCardDeposit;
import exception.CardProviderException;
import exception.WrongPropertyException;
import model.Currency;
import model.Customer;
import model.Property;
import org.apache.commons.lang3.StringUtils;
import play.Logger;
import play.libs.F;
import repository.PropertyRepository;
import scala.concurrent.Future;
import scala.concurrent.Promise;
import util.DateUtil;

import java.math.BigDecimal;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Optional;

/**
 * WorldPay gateway client service
 *
 * @author corbandalas - created 16.05.2016
 * @since 0.3.0
 */

@Singleton
public class WorldPayPaymentService {

    @Inject
    private PropertyRepository propertyRepository;

    public F.Promise<OneClickPaymentResponseV2> oneClickPaymentRequest(String serviceName, String paymentMethod, String transactionDescription, String paymentChannel, long amount, Currency currency, Customer customer, String successURL, String cancelURL, String failureURL) {
        return getSettings().flatMap(res -> oneClickPaymentRequestV2(res, serviceName, paymentMethod, transactionDescription, paymentChannel, amount, currency, customer, successURL, cancelURL, failureURL));
    }

    public F.Promise<BankDetailsResponseV2> getBankDetails(String country) {
        return getSettings().flatMap(res -> getBankDetails(res, country));
    }


    public F.Promise<F.Tuple<String, String>> initHostedtWorldPayPayment(final CustomerWorldPayCreditCardDeposit customerWorldPayCreditCardDeposit) {
        return getHostedSettings().flatMap(res -> F.Promise.wrap(initWorldPayHostedPaymentPage(res, customerWorldPayCreditCardDeposit)));
    }

    private F.Promise<OneClickPaymentResponseV2> oneClickPaymentRequestV2(WorldPaySettings settings, String serviceName, String paymentMethod, String transactionDescription, String paymentChannel, long amount, Currency currency, Customer customer, String successURL, String cancelURL, String failureURL) {

        return F.Promise.promise(() -> {

            Service service = getService(settings.url);


            long wsid = System.currentTimeMillis();
            Logger.info("/////// OneClickServiceInfoV2 service invocation. WSID #" + wsid);

            OneClickPaymentResponseV2 oneClickPaymentResponseV2 = null;

            try {

                OneClickServiceInfoV2 oneClickServiceInfoV2 = new OneClickServiceInfoV2();

                oneClickServiceInfoV2.setServiceName(serviceName);
                oneClickServiceInfoV2.setTransactionCategoryCode(serviceName);
                oneClickServiceInfoV2.setTransactionLongDescription(transactionDescription);
                oneClickServiceInfoV2.setLanguageCode("en");
                oneClickServiceInfoV2.setTransactionShortDescription(transactionDescription);
                ArrayOfOneClickServiceData arrayOfOneClickServiceData = new ArrayOfOneClickServiceData();
                oneClickServiceInfoV2.setServiceData(arrayOfOneClickServiceData);

                PaymentData paymentData = new PaymentData();

                paymentData.setCustomerRef("customerRef"); //TODO:

                paymentData.setCountry("uk"); //TODO:
                paymentData.setAmount(new BigDecimal(amount)); //TODO:
                paymentData.setCurrency(currency.getId());
                paymentData.setPaymentMethod(paymentMethod);

                CustomerDataV2 customerDataV2 = new CustomerDataV2();

                customerDataV2.setAddress1(customer.getAddress1());
                customerDataV2.setAddress2(customer.getAddress2());
                customerDataV2.setCity(customer.getCity());
                customerDataV2.setCountry(customer.getCountry_id());
                customerDataV2.setCustomerId(customer.getId());
                customerDataV2.setDateOfBirth(DateUtil.toXmlGregorianCalendar(customer.getDateBirth()));
                customerDataV2.setEmail(customer.getEmail());
                customerDataV2.setFirstName(customer.getFirstName());
                customerDataV2.setLastName(customer.getLastName());
                customerDataV2.setMobile(customer.getId());
                customerDataV2.setPostcode(customer.getPostcode());
                customerDataV2.setTitle(customer.getTitle());

                CustomerAccountDetails customerAccountDetails = new CustomerAccountDetails();

                customerAccountDetails.setPaymentChannel(paymentChannel);

                RedirectionUrls redirectionUrls = new RedirectionUrls();
                redirectionUrls.setSuccessUrl(successURL);
                redirectionUrls.setErrorUrl(failureURL);
                redirectionUrls.setCancelUrl(cancelURL);


                oneClickPaymentResponseV2 = service.getServiceSoap().oneClickPaymentRequestV2(createAuthHeader(settings.headerUsername, settings.headerPassword), oneClickServiceInfoV2, paymentData, customerDataV2, customerAccountDetails, redirectionUrls, "", null);

                Logger.info("/////// OneClickServiceInfoV2 service invocation was ended. WSID #" + wsid + ". Result code: " + oneClickPaymentResponseV2.getStatusCode() + " . Details: " + oneClickPaymentResponseV2.getStatusMessage() + " // " + oneClickPaymentResponseV2.toString());

                if (0 != oneClickPaymentResponseV2.getStatusCode()) {
                    throw new CardProviderException("Bad Response");
                }

            } catch (Exception e) {
                Logger.error("WorldPay connection error: ", e);
                throw new CardProviderException("WorldPay error");
            }

            return oneClickPaymentResponseV2;
        });
    }

    private F.Promise<BankDetailsResponseV2> getBankDetails(WorldPaySettings settings, String country) {

        return F.Promise.promise(() -> {

            Service service = getService(settings.url);


            long wsid = System.currentTimeMillis();
            Logger.info("/////// GetBankDetailsV2 service invocation. WSID #" + wsid);

            BankDetailsResponseV2 bankDetailsV2 = null;

            System.setProperty("com.sun.xml.ws.transport.http.client.HttpTransportPipe.dump", "true");
            System.setProperty("com.sun.xml.internal.ws.transport.http.client.HttpTransportPipe.dump", "true");
            System.setProperty("com.sun.xml.ws.transport.http.HttpAdapter.dump", "true");
            System.setProperty("com.sun.xml.internal.ws.transport.http.HttpAdapter.dump", "true");

            try {


                bankDetailsV2 = service.getServiceSoap().getBankDetailsV2(createAuthHeader(settings.headerUsername, settings.headerPassword), country);


                Logger.info("/////// GetBankDetailsV2 service invocation was ended. WSID #" + wsid + ". Result code: " + bankDetailsV2.getStatusCode() + " . Details: " + bankDetailsV2.getStatusMessage() + " // " + bankDetailsV2.toString());

                if (0 != bankDetailsV2.getStatusCode()) {
                    throw new CardProviderException("Bad Response");
                }

            } catch (Exception e) {
                Logger.error("WorldPay connection error: ", e);
                throw new CardProviderException("WorldPay error");
            }

            return bankDetailsV2;
        });
    }


    private Future<F.Tuple<String, String>> initWorldPayHostedPaymentPage(final WorldPaySettings settings, CustomerWorldPayCreditCardDeposit customerWorldPayCreditCardDeposit) {

        final AsyncHttpClient asyncHttpClient = new AsyncHttpClient();

        RequestBuilder builder = new RequestBuilder("GET");

        Realm realm = new Realm.RealmBuilder()
                .setPrincipal(settings.headerUsername)
                .setPassword(settings.headerPassword)
                .setUsePreemptiveAuth(true)
                .setScheme(Realm.AuthScheme.BASIC)
                .build();


        builder.setUrl(settings.url)
                .setBody(createXML(settings.merchantCode, settings.installationID, customerWorldPayCreditCardDeposit.getAmount(),
                        customerWorldPayCreditCardDeposit.getCurrency(), customerWorldPayCreditCardDeposit.getOrderId(), "Deposit for " + (double) customerWorldPayCreditCardDeposit.getAmount() / 100 + " " + customerWorldPayCreditCardDeposit.getCurrency()));


        builder.setRealm(realm);

        Request request = builder.build();
        final Promise<F.Tuple<String, String>> promise = Futures.promise();

        asyncHttpClient.executeRequest(request, new AsyncCompletionHandler<String>() {

            @Override
            public String onCompleted(Response response) throws Exception {

                String responseBody = response.getResponseBody();
                Logger.info("///Obtained WorldPay response: " + responseBody);

                String worldPayRedirectionURL = "https://" + StringUtils.substringBetween(responseBody, "https://", "</reference>");

                String orderKey = StringUtils.substringBetween(worldPayRedirectionURL, "OrderKey=", "Ticket");

                Config conf = ConfigFactory.load();

                final String webHost = conf.getString("application.web.host");

                final String callbackURL = webHost + "/api/callbacks/worldpay/cardDeposit";

                worldPayRedirectionURL = worldPayRedirectionURL.concat("&successURL=" + callbackURL +
                        "&failureURL=" + callbackURL + "&cancelURL=" + callbackURL + "&ordk=" + orderKey);


                F.Tuple result = new F.Tuple(worldPayRedirectionURL, orderKey);

                promise.success(result);

                return worldPayRedirectionURL;
            }

            @Override
            public void onThrowable(Throwable t) {
                Logger.error("/////Error while retrieving response from WorldPay Hosted API", t);

                promise.failure(t);
            }
        });

        return promise.future();

    }


    private Authentication createAuthHeader(String soapHeaderUsername, String soapHeaderPassword) {
        Authentication authHeader = new Authentication();

        authHeader.setUsername(soapHeaderUsername);
        authHeader.setPassword(soapHeaderPassword);

        return authHeader;
    }

    private Service getService(String wsdlURL) {
        try {

            return new Service(new URL(wsdlURL));
        } catch (MalformedURLException e) {
            Logger.error("Error while constructing service by WSDL" + wsdlURL);
        }

        return new Service();
    }

    private F.Promise<WorldPaySettings> getSettings() {

        final F.Promise<Optional<Property>> wsdlPromise = F.Promise.wrap(propertyRepository.retrieveById("worldpay.wsdl.url"));
        final F.Promise<Optional<Property>> usernameHeaderPromise = F.Promise.wrap(propertyRepository.retrieveById("worldpay.wsdl.soap.header.username"));
        final F.Promise<Optional<Property>> passwrodHeaderPromise = F.Promise.wrap(propertyRepository.retrieveById("worldpay.wsdl.soap.header.password"));

        return wsdlPromise.zip(usernameHeaderPromise).zip(passwrodHeaderPromise).map(res -> {

            String url = res._1._1.orElseThrow(WrongPropertyException::new).getValue();
            String userName = res._1._2.orElseThrow(WrongPropertyException::new).getValue();
            String password = res._2.orElseThrow(WrongPropertyException::new).getValue();
            return new WorldPaySettings(url, userName, password, "", "");
        });
    }

    private F.Promise<WorldPaySettings> getHostedSettings() {

        final F.Promise<Optional<Property>> wsdlPromise = F.Promise.wrap(propertyRepository.retrieveById("worldpay.hosted.payment.url"));
        final F.Promise<Optional<Property>> usernameHeaderPromise = F.Promise.wrap(propertyRepository.retrieveById("worldpay.hosted.payment.username"));
        final F.Promise<Optional<Property>> passwordHeaderPromise = F.Promise.wrap(propertyRepository.retrieveById("worldpay.hosted.payment.password"));
        final F.Promise<Optional<Property>> merchantCodePromise = F.Promise.wrap(propertyRepository.retrieveById("worldpay.hosted.payment.merchantcode"));
        final F.Promise<Optional<Property>> installationIDPromise = F.Promise.wrap(propertyRepository.retrieveById("worldpay.hosted.payment.installation.id"));


        return wsdlPromise.zip(usernameHeaderPromise).zip(passwordHeaderPromise).zip(merchantCodePromise).zip(installationIDPromise).map(res -> {

            String installationID = res._2.orElseThrow(WrongPropertyException::new).getValue();
            String merchantCode = res._1._2.orElseThrow(WrongPropertyException::new).getValue();
            String password = res._1._1._2.orElseThrow(WrongPropertyException::new).getValue();
            String userName = res._1._1._1._2.orElseThrow(WrongPropertyException::new).getValue();
            String url = res._1._1._1._1.orElseThrow(WrongPropertyException::new).getValue();

            return new WorldPaySettings(url, userName, password, merchantCode, installationID);
        });
    }

    private class WorldPaySettings {

        private String url;
        private String headerUsername;
        private String headerPassword;
        private String merchantCode;
        private String installationID;

        public WorldPaySettings(String url, String headerUsername, String headerPassword, String merchantCode, String installationID) {
            this.url = url;
            this.headerUsername = headerUsername;
            this.headerPassword = headerPassword;
            this.merchantCode = merchantCode;
            this.installationID = installationID;
        }

    }

    private String createXML(String merchantCode, String installationID, long amount, String currency, String orderID, String orderDesciption) {
        StringBuffer xmlMessage = new StringBuffer();

        xmlMessage.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?><!DOCTYPE paymentService PUBLIC \"-//Worldpay//DTD Worldpay PaymentService v1//EN\" \"http://dtd.worldpay.com/paymentService_v1.dtd\">");

        xmlMessage.append("<paymentService version=\"1.4\" merchantCode=\"" + merchantCode + "\">");
        xmlMessage.append("<submit>");
        xmlMessage.append("<order orderCode=\"" + orderID + "\" installationId=\"" + installationID + "\">");
        xmlMessage.append("<description>" + orderDesciption + "</description>");
        xmlMessage.append("<amount currencyCode=\"" + currency + "\" value=\"" + amount + "\" exponent=\"2\"/>");
        xmlMessage.append("<orderContent>" + orderDesciption + "</orderContent>");
        xmlMessage.append("<paymentMethodMask>");
        xmlMessage.append("<include code=\"ALL\"/>");
        xmlMessage.append("</paymentMethodMask>");
        xmlMessage.append("</order>");
        xmlMessage.append("</submit>");
        xmlMessage.append("</paymentService>");
        return xmlMessage.toString();
    }


}
