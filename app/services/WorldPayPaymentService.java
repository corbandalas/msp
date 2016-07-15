package services;

import akka.dispatch.Futures;
import com.envoyservices.merchantapi.Authentication;
import com.envoyservices.merchantapi.BankDetailsResponseV2;
import com.envoyservices.merchantapi.Service;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.ning.http.client.*;
import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;
import dto.customer.CustomerWorldPayCreditCardDeposit;
import dto.customer.CustomerWorldPayCreditCardPurchase;
import exception.CardProviderException;
import exception.WrongPropertyException;
import model.Property;
import org.apache.commons.lang3.StringEscapeUtils;
import org.apache.commons.lang3.StringUtils;
import play.Logger;
import play.libs.F;
import repository.PropertyRepository;
import scala.concurrent.Future;
import scala.concurrent.Promise;

import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
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

    public F.Promise<BankDetailsResponseV2> getBankDetails(String country) {
        return getSettings().flatMap(res -> getBankDetails(res, country));
    }


    public F.Promise<F.Tuple<String, String>> initDepositHostedtWorldPayPayment(final CustomerWorldPayCreditCardDeposit customerWorldPayCreditCardDeposit) {
        return getHostedSettings().flatMap(res -> F.Promise.wrap(initDepositWorldPayHostedPaymentPage(res, customerWorldPayCreditCardDeposit)));
    }

    public F.Promise<F.Tuple<String, String>> initPurchaseHostedtWorldPayPayment(final CustomerWorldPayCreditCardPurchase customerWorldPayCreditCardPurchase, long totalAmount) {
        return getHostedSettings().flatMap(res -> F.Promise.wrap(initPurchaseWorldPayHostedPaymentPage(res, totalAmount, customerWorldPayCreditCardPurchase)));
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


    private Future<F.Tuple<String, String>> initDepositWorldPayHostedPaymentPage(final WorldPaySettings settings, CustomerWorldPayCreditCardDeposit customerWorldPayCreditCardDeposit) {

        final AsyncHttpClient asyncHttpClient = new AsyncHttpClient();

        final Promise<F.Tuple<String, String>> promise = Futures.promise();

        asyncHttpClient.executeRequest(prepareRequest(settings, customerWorldPayCreditCardDeposit.getAmount(), customerWorldPayCreditCardDeposit.getCurrency(), customerWorldPayCreditCardDeposit.getOrderId(), "Credit card deposit"), new AsyncCompletionHandler<String>() {

            @Override
            public String onCompleted(Response response) throws Exception {

                F.Tuple<String, String> result = handleResponse(response, "/api/callbacks/worldpay/cardDeposit", customerWorldPayCreditCardDeposit.getOrderId());

                promise.success(result);

                return result._1;
            }

            @Override
            public void onThrowable(Throwable t) {
                Logger.error("/////Error while retrieving response from WorldPay Hosted API", t);

                promise.failure(t);
            }
        });

        return promise.future();

    }


    private Future<F.Tuple<String, String>> initPurchaseWorldPayHostedPaymentPage(final WorldPaySettings settings, long totalAmount, CustomerWorldPayCreditCardPurchase customerWorldPayCreditCardPurchase) {

        final AsyncHttpClient asyncHttpClient = new AsyncHttpClient();

        final Promise<F.Tuple<String, String>> promise = Futures.promise();

        asyncHttpClient.executeRequest(prepareRequest(settings, totalAmount, customerWorldPayCreditCardPurchase.getCurrency(), customerWorldPayCreditCardPurchase.getOrderId(), "Credit card deposit"), new AsyncCompletionHandler<String>() {

            @Override
            public String onCompleted(Response response) throws Exception {


                F.Tuple<String, String> result = handleResponse(response, "/api/callbacks/worldpay/cardPurchase", customerWorldPayCreditCardPurchase.getOrderId());

                promise.success(result);

                return result._1;

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
//        xmlMessage.append("<shopper>");
//        xmlMessage.append("<shopperEmailAddress>" + "me@corbandalas.com" + "</shopperEmailAddress>");
//        xmlMessage.append("</shopper>");
//        xmlMessage.append("<shippingAddress>\n" +
//                "<address>\n" +
//                "<firstName>John</firstName> <lastName>Shopper</lastName> <address1>Shopperstreet</address1> <address2>Shopperaddress2</address2> <address3>Shopperaddress3</address3> <postalCode>1234</postalCode> <city>Shoppercity</city> <state>Shopperregion</state> <countryCode>NL</countryCode> <telephoneNumber>0123456789</telephoneNumber>\n" +
//                "</address>\n" +
//                "</shippingAddress> <billingAddress>\n" +
//                "<address>\n" +
//                "<firstName>John</firstName> <lastName>Shopper</lastName> <address1>Shopperstreet</address1> <address2>Shopperaddress2</address2> <address3>Shopperaddress3</address3> <postalCode>1234</postalCode> <city>Shoppercity</city> <state>Shopperregion</state> <countryCode>NL</countryCode> <telephoneNumber>0123456789</telephoneNumber>\n" +
//                "</address>\n" +
//                "</billingAddress>");

        xmlMessage.append("</order>");
        xmlMessage.append("</submit>");
        xmlMessage.append("</paymentService>");
        return xmlMessage.toString();
    }


    private Request prepareRequest(final WorldPaySettings settings, long amount, String currency, String orderID, String orderDesciption) {

        RequestBuilder builder = new RequestBuilder("GET");

        Realm realm = new Realm.RealmBuilder()
                .setPrincipal(settings.headerUsername)
                .setPassword(settings.headerPassword)
                .setUsePreemptiveAuth(true)
                .setScheme(Realm.AuthScheme.BASIC)
                .build();


        builder.setUrl(settings.url)
                .setBody(createXML(settings.merchantCode, settings.installationID, amount,
                        currency, orderID, "Payment for " + (double) amount / 100 + " " + currency));


        builder.setRealm(realm);

        return builder.build();

    }

    private F.Tuple handleResponse(Response response, String callback, String orderID) throws Exception {

        String responseBody = response.getResponseBody();
        Logger.info("///Obtained WorldPay response: " + responseBody);
        responseBody = StringEscapeUtils.unescapeHtml4(responseBody);

        String url = StringUtils.substringBetween(responseBody, "https://", "</reference>");

        if (!StringUtils.isNotBlank(url)) {
            throw new Exception();
        }

        String worldPayRedirectionURL = "https://" + url;

//                String orderKey = StringUtils.substringBetween(worldPayRedirectionURL, "OrderKey=", "&Ticket");

        Config conf = ConfigFactory.load();

        final String webHost = conf.getString("application.web.host");

        final String callbackURL = webHost + callback;

        final String additionalParams = "&successURL=" + URLEncoder.encode(callbackURL + "?ordk=" + orderID, "UTF-8") +
                "&failureURL=" + URLEncoder.encode(callbackURL + "?ordk=" + orderID, "UTF-8") + "&cancelURL=" + URLEncoder.encode(callbackURL + "?ordk=" + orderID, "UTF-8");


        worldPayRedirectionURL = worldPayRedirectionURL.concat(additionalParams);


        return new F.Tuple(worldPayRedirectionURL, orderID);
    }

}
