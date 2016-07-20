package controllers.callback;

import com.fasterxml.jackson.databind.JsonNode;
import com.google.inject.Inject;
import controllers.BaseController;
import play.Logger;
import play.cache.CacheApi;
import play.libs.F;
import play.mvc.Result;
import provider.CardProvider;
import repository.CardRepository;
import repository.CurrencyRepository;
import repository.CustomerRepository;
import repository.PropertyRepository;
import services.OperationService;
import util.SecurityUtil;

/**
 * Controller holds  Worldpay callback SOAP methods.
 *
 * @author vladimir created 23.05.2016.
 * @since 0.3.0
 */
public class W2CallbackController extends BaseController {

    @Inject
    CustomerRepository customerRepository;

    @Inject
    CacheApi cache;

    @Inject
    private PropertyRepository propertyRepository;

    /**
     * Deposit callback
     *
     * @return
     */
    public F.Promise<Result> kycCallback() {

        final JsonNode request = request().body().asJson();

        Logger.info(request.asText());

        String auth = request().getHeader("Authorization");

        F.Promise<Result> result = F.Promise.wrap(propertyRepository.retrieveById("w2.globaldata.api.key")).flatMap(rez -> {
            String apiKey = rez.get().getValue();

            if (SecurityUtil.encodeString("Bancore:" + apiKey).equalsIgnoreCase(auth)) {

                String interpretResult = request.get("ServiceResults").get("W2DataEkycScandi025").get("InterpretResult").asText();

                return F.Promise.pure(ok("OK"));
            } else {
                return F.Promise.pure(ok("ERROR"));
            }


        });


        return result.recover(throwable -> {
            Logger.error("Error: ", throwable);
            return ok("OK");
        });

    }


}
