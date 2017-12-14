package sms;

import akka.dispatch.Futures;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.ning.http.client.AsyncCompletionHandler;
import com.ning.http.client.AsyncHttpClient;
import com.ning.http.client.Response;
import dto.CurrencyExchangeRatesResponse;
import exception.WrongPropertyException;
import model.BaseEntity;
import model.Currency;
import model.ExchangeRateHistory;
import model.Property;
import org.apache.commons.lang3.RandomStringUtils;
import play.Logger;
import play.libs.F;
import repository.PropertyRepository;
import scala.concurrent.Future;
import scala.concurrent.Promise;

import java.util.Optional;

/**
 * SMS Gateway implementation
 *
 * @author corbandalas - created 15.02.2016
 * @since 0.2.0
 */

@Singleton
public class SmsGateway {

    @Inject
    private PropertyRepository propertyRepository;

    public void sendSMS(String phone, String text) {

        final F.Promise<Optional<Property>> apiLoginPromise = F.Promise.wrap(propertyRepository.retrieveById("com.msp.sms.textanywhere.login"));
        final F.Promise<Optional<Property>> apiPasswordPromise = F.Promise.wrap(propertyRepository.retrieveById("com.msp.sms.textanywhere.password"));
        final F.Promise<Optional<Property>> apiUrlPromise = F.Promise.wrap(propertyRepository.retrieveById("com.msp.sms.textanywhere.url"));


        final F.Promise<F.Tuple<F.Tuple<Optional<Property>, Optional<Property>>, Optional<Property>>> zip = apiLoginPromise.zip(apiPasswordPromise).zip(apiUrlPromise);


        zip.flatMap(result -> F.Promise.wrap(invokeService(result._1._1.orElseThrow(WrongPropertyException::new).getValue(), result._1._2.orElseThrow(WrongPropertyException::new).getValue(), result._2.orElseThrow(WrongPropertyException::new).getValue(), phone, text)));

    }


    public Future<String> invokeService(final String apiLogin, final String apiPassword, final String url, final String destPhone, final String text) {

        final AsyncHttpClient asyncHttpClient = new AsyncHttpClient();

        final Promise<String> promise = Futures.promise();

        final String clientBillingRef = RandomStringUtils.randomAlphanumeric(10);
        final String clientMessageRef = RandomStringUtils.randomAlphanumeric(10);

        final String query = url + "?method=sendsms&returncsvstring=false&externallogin=" + apiLogin + "&password=" + apiPassword +
                "&clientbillingreference=" + clientBillingRef + "&originator=+00000000&clientmessagereference=" + clientMessageRef + "&destinations=%2b" + destPhone + "&body=" + text + "&validity=72&charactersetid=2&replymethodid=4&replydata=&statusnotificationurl=";


        Logger.info("::::::::::: Sending SMS[ clientBillingRef = " + clientBillingRef + ", clientMessageRef = " + clientMessageRef + "]: " + query);

        asyncHttpClient.prepareGet(query).execute(new AsyncCompletionHandler<String>() {

            @Override
            public String onCompleted(Response response) throws Exception {

                String responseBody = response.getResponseBody();
                Logger.info("///SMS Gateway response: " + responseBody);


                promise.success(responseBody);


                return responseBody;
            }

            @Override
            public void onThrowable(Throwable t) {
                Logger.error("/////Error while sending SMS message", t);

                promise.failure(t);
            }
        });

        return promise.future();

    }
}
