package services;

import akka.dispatch.Futures;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
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
import services.dto.PaylikeCaptureRequest;
import services.dto.PaylikeRefundRequest;
import services.dto.PaylikeTransaction;

import java.util.Optional;

/**
 * Paylike gateway client service
 *
 * @author corbandalas - created 01.02.2017
 * @since 0.4.0
 */

@Singleton
public class PaylikePaymentService {

    @Inject
    private PropertyRepository propertyRepository;


    public F.Promise<String> getPaymentLinkDeposit(final CustomerPaylikeCreditCardDeposit customerWorldPayCreditCardDeposit) {
        return getPaylikeSettings(true).map(res -> {

            String paymentURL = res.paymentURL +
                    "?key=" + res.publicKey +
                    "&currency=" + customerWorldPayCreditCardDeposit.getCurrency() +
                    "&amount=" + customerWorldPayCreditCardDeposit.getAmount() +
                    "&reference=" + customerWorldPayCreditCardDeposit.getOrderId() +
                    "&redirect=" + res.redirectURL;

            return paymentURL;
        });
    }

    public F.Promise<String> getPaymentLinkPurchase(long totalAmount, final CustomerPaylikeCreditCardPurchase customerWorldPayCreditCardDeposit) {
        return getPaylikeSettings(false).map(res -> {

            String paymentURL = res.paymentURL +
                    "?key=" + res.publicKey +
                    "&currency=" + customerWorldPayCreditCardDeposit.getCurrency() +
                    "&amount=" + totalAmount +
                    "&reference=" + customerWorldPayCreditCardDeposit.getOrderId() +
                    "&redirect=" + res.redirectURL;

            return paymentURL;
        });
    }

    public F.Promise<PaylikeTransaction> fetchPaylikeTransaction(String transactionID) {
        return getPaylikeSettings(true).flatMap(res -> F.Promise.wrap(fetchTransaction(res, transactionID)));
    }


    public F.Promise<PaylikeTransaction> capturePaylikeTransaction(String transactionID, long amount, String currency) {
        return getPaylikeSettings(true).flatMap(res -> F.Promise.wrap(captureTansaction(res, transactionID, amount, currency)));
    }


    public F.Promise<PaylikeTransaction> refundPaylikeTransaction(String transactionID, long amount) {
        return getPaylikeSettings(true).flatMap(res -> F.Promise.wrap(refundTansaction(res, transactionID, amount)));
    }


    private Future<PaylikeTransaction> fetchTransaction(final PaylikeSettings settings, String transactionID) {

        final AsyncHttpClient asyncHttpClient = new AsyncHttpClient();

        final Promise<PaylikeTransaction> promise = Futures.promise();

        asyncHttpClient.executeRequest(prepareFetchRequest(settings, transactionID), new AsyncCompletionHandler<PaylikeTransaction>() {

            @Override
            public PaylikeTransaction onCompleted(Response response) throws Exception {

                PaylikeTransaction result = handlePaylikeTransactionResponse(response);

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


    private Future<PaylikeTransaction> captureTansaction(final PaylikeSettings settings, String transactionID, long amount, String currency) throws JsonProcessingException {

        final AsyncHttpClient asyncHttpClient = new AsyncHttpClient();

        final Promise<PaylikeTransaction> promise = Futures.promise();

        asyncHttpClient.executeRequest(prepareCaptureRequest(settings, transactionID, amount, currency), new AsyncCompletionHandler<PaylikeTransaction>() {

            @Override
            public PaylikeTransaction onCompleted(Response response) throws Exception {

                PaylikeTransaction result = handlePaylikeTransactionResponse(response);

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


    private Future<PaylikeTransaction> refundTansaction(final PaylikeSettings settings, String transactionID, long amount) throws JsonProcessingException {

        final AsyncHttpClient asyncHttpClient = new AsyncHttpClient();

        final Promise<PaylikeTransaction> promise = Futures.promise();

        asyncHttpClient.executeRequest(prepareRefundRequest(settings, transactionID, amount), new AsyncCompletionHandler<PaylikeTransaction>() {

            @Override
            public PaylikeTransaction onCompleted(Response response) throws Exception {

                PaylikeTransaction result = handlePaylikeTransactionResponse(response);

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


    private F.Promise<PaylikeSettings> getPaylikeSettings(boolean depositOrPurchase) {

        final F.Promise<Optional<Property>> appPromise = F.Promise.wrap(propertyRepository.retrieveById("paylike.app.id"));
        final F.Promise<Optional<Property>> publicKeyPromise = F.Promise.wrap(propertyRepository.retrieveById("paylike.public.key"));
        final F.Promise<Optional<Property>> paymentUrlPromise = F.Promise.wrap(propertyRepository.retrieveById("paylike.payment.url"));
        final F.Promise<Optional<Property>> apiUrlPromise = F.Promise.wrap(propertyRepository.retrieveById("paylike.api.url"));

        final F.Promise<Optional<Property>> redirectUrlPromise;

        if (depositOrPurchase) {
            redirectUrlPromise = F.Promise.wrap(propertyRepository.retrieveById("paylike.api.msp.deposit.callback.url"));
        } else {
            redirectUrlPromise = F.Promise.wrap(propertyRepository.retrieveById("paylike.api.msp.purchase.callback.url"));
        }

        return appPromise.zip(publicKeyPromise).zip(paymentUrlPromise).zip(apiUrlPromise).zip(redirectUrlPromise).map(res -> {

            String redirectURL = res._2.orElseThrow(WrongPropertyException::new).getValue();
            String apiURL = res._1._2.orElseThrow(WrongPropertyException::new).getValue();
            String paymentURL = res._1._1._2.orElseThrow(WrongPropertyException::new).getValue();
            String publicKey = res._1._1._1._2.orElseThrow(WrongPropertyException::new).getValue();
            String app = res._1._1._1._1.orElseThrow(WrongPropertyException::new).getValue();

            return new PaylikeSettings(app, publicKey, paymentURL, apiURL, redirectURL);
        });
    }

    private class PaylikeSettings {

        private String appKey;
        private String publicKey;
        private String paymentURL;
        private String apiURL;
        private String redirectURL;

        public PaylikeSettings(String appKey, String publicKey, String paymentURL, String apiURL, String redirectURL) {
            this.appKey = appKey;
            this.publicKey = publicKey;
            this.paymentURL = paymentURL;
            this.apiURL = apiURL;
            this.redirectURL = redirectURL;
        }

    }

    private Request prepareFetchRequest(final PaylikeSettings settings, String transactionID) {

        RequestBuilder builder = new RequestBuilder("GET");

        builder.addHeader("Content-Type", "application/json");

        Realm realm = new Realm.RealmBuilder()
                .setPrincipal("")
                .setPassword(settings.appKey)
                .setUsePreemptiveAuth(true)
                .setScheme(Realm.AuthScheme.BASIC)
                .build();

        builder.setUrl(settings.apiURL + "transactions/" + transactionID);

        builder.setRealm(realm);

        return builder.build();

    }

    private Request prepareCaptureRequest(final PaylikeSettings settings, String transactionID, Long amount, String currency) throws JsonProcessingException {

        RequestBuilder builder = new RequestBuilder("POST");

        builder.addHeader("Content-Type", "application/json");

        Realm realm = new Realm.RealmBuilder()
                .setPrincipal("")
                .setPassword(settings.appKey)
                .setUsePreemptiveAuth(true)
                .setScheme(Realm.AuthScheme.BASIC)
                .build();

        ObjectMapper mapper = new ObjectMapper();

        PaylikeCaptureRequest paylikeCaptureRequest = new PaylikeCaptureRequest();
        paylikeCaptureRequest.setAmount(amount);
        paylikeCaptureRequest.setCurrency(currency);

        String body = mapper.writeValueAsString(paylikeCaptureRequest);

        builder.setUrl(settings.apiURL + "transactions/" + transactionID + "/captures").setBody(body);

        Logger.info("////Paylike Capture body " + body);

        builder.setRealm(realm);

        return builder.build();

    }

    private Request prepareRefundRequest(final PaylikeSettings settings, String transactionID, Long amount) throws JsonProcessingException {

        RequestBuilder builder = new RequestBuilder("POST");

        builder.addHeader("Content-Type", "application/json");

        Realm realm = new Realm.RealmBuilder()
                .setPrincipal("")
                .setPassword(settings.appKey)
                .setUsePreemptiveAuth(true)
                .setScheme(Realm.AuthScheme.BASIC)
                .build();

        ObjectMapper mapper = new ObjectMapper();

        PaylikeRefundRequest paylikeCaptureRequest = new PaylikeRefundRequest();
        paylikeCaptureRequest.setAmount(amount);

        String body = mapper.writeValueAsString(paylikeCaptureRequest);

        builder.setUrl(settings.apiURL + "transactions/" + transactionID + "/refunds").setBody(body);

        Logger.info("////Paylike Refund body " + body);

        builder.setRealm(realm);

        return builder.build();

    }

    private PaylikeTransaction handlePaylikeTransactionResponse(Response response) throws Exception {

        String responseBody = response.getResponseBody();
        Logger.info("/// Paylike response: " + responseBody);

        ObjectMapper mapper = new ObjectMapper();

        PaylikeTransaction transaction = mapper.readValue(responseBody.getBytes(), PaylikeTransaction.class);

        return transaction;
    }

}
