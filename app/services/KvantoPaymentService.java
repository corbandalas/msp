package services;

import akka.dispatch.Futures;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.ning.http.client.*;
import dto.customer.CustomerPaylikeCreditCardDeposit;
import dto.customer.CustomerPaylikeCreditCardPurchase;
import exception.WrongPropertyException;
import model.Property;
import play.Logger;
import play.libs.F;
import repository.PropertyRepository;
import scala.concurrent.Future;
import scala.concurrent.Promise;
import services.dto.KvantoStatus;

import java.util.Optional;

/**
 * Kvanto gateway client service
 *
 * @author corbandalas - created 21.05.2018
 * @since 0.6.0
 */

@Singleton
public class KvantoPaymentService {

    @Inject
    private PropertyRepository propertyRepository;


    public F.Promise<String> getPaymentLinkDeposit(final CustomerPaylikeCreditCardDeposit customerWorldPayCreditCardDeposit) {
        return getPaylikeSettings(true).map(res -> {

            String paymentURL = res.paymentURL + res.customerID + "/payment.php" +
                    "?id=" + res.merchantID +
                    "&customerid=" + res.customerID +
                    "&orderid=" + customerWorldPayCreditCardDeposit.getOrderId() +
                    "&amount=" + (double)customerWorldPayCreditCardDeposit.getAmount() / 100 +
                    "&currency=" + customerWorldPayCreditCardDeposit.getCurrency() +
                    "&paymentcode=PA&iso=en" +
                    "&accepturl=" + res.redirectURL +
                    "&failurl=" + res.redirectURL +
                    "&callbackurl=" + res.redirectURL;

            return paymentURL;
        });
    }

    public F.Promise<String> getPaymentLinkPurchase(long totalAmount, final CustomerPaylikeCreditCardPurchase customerWorldPayCreditCardDeposit) {
        return getPaylikeSettings(false).map(res -> {

            String paymentURL = res.paymentURL + res.customerID + "/payment.php" +
                    "?id=" + res.merchantID +
                    "&customerid=" + res.customerID +
                    "&orderid=" + customerWorldPayCreditCardDeposit.getOrderId() +
                    "&amount=" + (double)totalAmount / 100 +
                    "&currency=" + customerWorldPayCreditCardDeposit.getCurrency() +
                    "&paymentcode=PA&iso=en" +
                    "&accepturl=" + res.redirectURL +
                    "&failurl=" + res.redirectURL +
                    "&callbackurl=" + res.redirectURL;

            return paymentURL;
        });
    }

    public F.Promise<KvantoStatus> fetchKvantoTransaction(String transactionID) {
        return getPaylikeSettings(true).flatMap(res -> F.Promise.wrap(fetchTransaction(res, transactionID)));
    }


    public F.Promise<KvantoStatus> capturePaylikeTransaction(String transactionID, long amount, String currency) {
        return getPaylikeSettings(true).flatMap(res -> F.Promise.wrap(captureTansaction(res, transactionID, amount, currency)));
    }


    public F.Promise<KvantoStatus> refundPaylikeTransaction(String transactionID, long amount, String currency) {
        return getPaylikeSettings(true).flatMap(res -> F.Promise.wrap(refundTansaction(res, transactionID, amount, currency)));
    }


    private Future<KvantoStatus> fetchTransaction(final KvantoSettings settings, String transactionID) {

        final AsyncHttpClient asyncHttpClient = new AsyncHttpClient();

        final Promise<KvantoStatus> promise = Futures.promise();

        asyncHttpClient.executeRequest(prepareFetchRequest(settings, transactionID), new AsyncCompletionHandler<KvantoStatus>() {

            @Override
            public KvantoStatus onCompleted(Response response) throws Exception {

                KvantoStatus result = handleKvantoTransactionResponse(response);

                promise.success(result);

                return result;
            }

            @Override
            public void onThrowable(Throwable t) {
                Logger.error("/////Error while retrieving response from WorldPay Hosted API", t);

                promise.failure(t);
            }
        });

        return promise.future();

    }


    private Future<KvantoStatus> captureTansaction(final KvantoSettings settings, String transactionID, long amount, String currency) throws JsonProcessingException {

        final AsyncHttpClient asyncHttpClient = new AsyncHttpClient();

        final Promise<KvantoStatus> promise = Futures.promise();

        asyncHttpClient.executeRequest(prepareCaptureRequest(settings, transactionID, amount, currency), new AsyncCompletionHandler<KvantoStatus>() {

            @Override
            public KvantoStatus onCompleted(Response response) throws Exception {

                KvantoStatus result = handleKvantoTransactionResponse(response);

                promise.success(result);

                return result;
            }

            @Override
            public void onThrowable(Throwable t) {
                Logger.error("/////Error while retrieving response from WorldPay Hosted API", t);

                promise.failure(t);
            }
        });

        return promise.future();

    }


    private Future<KvantoStatus> refundTansaction(final KvantoSettings settings, String transactionID, long amount, String currency) throws JsonProcessingException {

        final AsyncHttpClient asyncHttpClient = new AsyncHttpClient();

        final Promise<KvantoStatus> promise = Futures.promise();

        asyncHttpClient.executeRequest(prepareRefundRequest(settings, transactionID, amount, currency), new AsyncCompletionHandler<KvantoStatus>() {

            @Override
            public KvantoStatus onCompleted(Response response) throws Exception {

                KvantoStatus result = handleKvantoTransactionResponse(response);

                promise.success(result);

                return result;
            }

            @Override
            public void onThrowable(Throwable t) {
                Logger.error("/////Error while retrieving response from WorldPay Hosted API", t);

                promise.failure(t);
            }
        });

        return promise.future();

    }


    private F.Promise<KvantoSettings> getPaylikeSettings(boolean depositOrPurchase) {

        final F.Promise<Optional<Property>> kvantoIDPromise = F.Promise.wrap(propertyRepository.retrieveById("kvanto.api.msp.id"));
        final F.Promise<Optional<Property>> paymentUrlPromise = F.Promise.wrap(propertyRepository.retrieveById("kvanto.api.msp.url"));
        final F.Promise<Optional<Property>> apiUrlPromise = F.Promise.wrap(propertyRepository.retrieveById("kvanto.api.msp.url"));

        final F.Promise<Optional<Property>> redirectUrlPromise;

        if (depositOrPurchase) {
            redirectUrlPromise = F.Promise.wrap(propertyRepository.retrieveById("kvanto.api.msp.deposit.callback.url"));
        } else {
            redirectUrlPromise = F.Promise.wrap(propertyRepository.retrieveById("kvanto.api.msp.purchase.callback.url"));
        }

        return kvantoIDPromise.zip(paymentUrlPromise).zip(apiUrlPromise).zip(redirectUrlPromise).map(res -> {

            String kvantoIDS = res._1._1._1.orElseThrow(WrongPropertyException::new).getValue();
            String paymentURL = res._1._1._2.orElseThrow(WrongPropertyException::new).getValue();
            String apiURL = res._1._2.orElseThrow(WrongPropertyException::new).getValue();
            String redirectURL = res._2.orElseThrow(WrongPropertyException::new).getValue();

            String[] split = kvantoIDS.split("|");

            return new KvantoSettings(split[0], split[1], split[2], paymentURL, apiURL, redirectURL);
        });
    }

    private class KvantoSettings {

        private String kvantoID;
        private String customerID;
        private String merchantID;
        private String paymentURL;
        private String apiURL;
        private String redirectURL;

        public KvantoSettings(String kvantoID, String customerID, String merchantID, String paymentURL, String apiURL, String redirectURL) {
            this.kvantoID = kvantoID;
            this.customerID = customerID;
            this.merchantID = merchantID;
            this.paymentURL = paymentURL;
            this.apiURL = apiURL;
            this.redirectURL = redirectURL;
        }

    }

    private Request prepareFetchRequest(final KvantoSettings settings, String transactionID) {
//
        RequestBuilder builder = new RequestBuilder("GET");

//        builder.addHeader("Content-Type", "application/json");

//        Realm realm = new Realm.RealmBuilder()
//                .setPrincipal("")
//                .setPassword(settings.appKey)
//                .setUsePreemptiveAuth(true)
//                .setScheme(Realm.AuthScheme.BASIC)
//                .build();

//        ObjectMapper mapper = new ObjectMapper();
//
//        PaylikeCaptureRequest paylikeCaptureRequest = new PaylikeCaptureRequest();
//        paylikeCaptureRequest.setAmount(amount);
//        paylikeCaptureRequest.setCurrency(currency);

//        String body = mapper.writeValueAsString(paylikeCaptureRequest);

        builder.setUrl(settings.apiURL + settings.kvantoID + "/status?orderid=" + transactionID);
//                .setBody(body);

//        Logger.info("////Paylike Capture body " + body);

//        builder.setRealm(realm);

        return builder.build();

    }

    private Request prepareCaptureRequest(final KvantoSettings settings, String transactionID, Long amount, String currency) throws JsonProcessingException {

        RequestBuilder builder = new RequestBuilder("GET");

//        builder.addHeader("Content-Type", "application/json");

//        Realm realm = new Realm.RealmBuilder()
//                .setPrincipal("")
//                .setPassword(settings.appKey)
//                .setUsePreemptiveAuth(true)
//                .setScheme(Realm.AuthScheme.BASIC)
//                .build();

//        ObjectMapper mapper = new ObjectMapper();
//
//        PaylikeCaptureRequest paylikeCaptureRequest = new PaylikeCaptureRequest();
//        paylikeCaptureRequest.setAmount(amount);
//        paylikeCaptureRequest.setCurrency(currency);

//        String body = mapper.writeValueAsString(paylikeCaptureRequest);

        builder.setUrl(settings.apiURL + settings.kvantoID + "/capture?orderid=" + transactionID + "&amount=" + (double)amount / 100 + "&currency=" + currency);
//                .setBody(body);

//        Logger.info("////Paylike Capture body " + body);

//        builder.setRealm(realm);

        return builder.build();

    }

    private Request prepareRefundRequest(final KvantoSettings settings, String transactionID, Long amount, String currency) throws JsonProcessingException {

        RequestBuilder builder = new RequestBuilder("GET");

//        builder.addHeader("Content-Type", "application/json");

//        Realm realm = new Realm.RealmBuilder()
//                .setPrincipal("")
//                .setPassword(settings.appKey)
//                .setUsePreemptiveAuth(true)
//                .setScheme(Realm.AuthScheme.BASIC)
//                .build();

//        ObjectMapper mapper = new ObjectMapper();
//
//        PaylikeCaptureRequest paylikeCaptureRequest = new PaylikeCaptureRequest();
//        paylikeCaptureRequest.setAmount(amount);
//        paylikeCaptureRequest.setCurrency(currency);

//        String body = mapper.writeValueAsString(paylikeCaptureRequest);

        builder.setUrl(settings.apiURL + settings.kvantoID + "/void?orderid=" + transactionID + "&amount=" + (double)amount / 100 + "&currency=" + currency);
//                .setBody(body);

//        Logger.info("////Paylike Capture body " + body);

//        builder.setRealm(realm);

        return builder.build();

    }

    private KvantoStatus handleKvantoTransactionResponse(Response response) throws Exception {

        String responseBody = response.getResponseBody();
        Logger.info("/// Kvanto response: " + responseBody);

        String[] split = responseBody.split("&");

        KvantoStatus status = new KvantoStatus(split[1], split[0]);

        return status;
    }

}
