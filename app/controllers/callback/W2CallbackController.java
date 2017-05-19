package controllers.callback;

import com.fasterxml.jackson.databind.JsonNode;
import com.google.inject.Inject;
import controllers.BaseController;
import model.Card;
import model.Customer;
import model.enums.KYC;
import org.apache.commons.lang3.StringUtils;
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

import java.util.List;
import java.util.Optional;

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


    @Inject
    private CardProvider cardProvider;

    @Inject
    CardRepository cardRepository;

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

            Logger.info("W2CallbackController auth = " + auth);

            String ourAuth = "Basic ".concat(SecurityUtil.encodeString("Safepay:" + apiKey));

            Logger.info("W2CallbackController our auth = ".concat(ourAuth));

            if (ourAuth.equalsIgnoreCase(auth)) {

                String interpretResult = request.get("ServiceResults").get("W2DataEkycScandi025").get("InterpretResult").asText();


                if (interpretResult.equalsIgnoreCase("Pass")) {

                    String callReference = request.get("CallReference").asText();

                    if (StringUtils.startsWith(callReference, "WSCR")) {
                        callReference = StringUtils.replace(callReference, "WSCR", "");
                    }

                    Logger.info("W2CallbackController callReference = " + callReference);

                    String cacheValue = cache.get(callReference);

                    String[] cacheResult = cacheValue.split("\\|");

                    String customerId = cacheResult[0];
                    String kycType = cacheResult[1];

                    Logger.info("W2CallbackController customerId = " + customerId);

                    F.Promise<Optional<Customer>> customerPromise = F.Promise.wrap(customerRepository.retrieveById(customerId));

                    customerPromise.flatMap(data -> {

                        Customer customer = data.get();

                        if (kycType.equalsIgnoreCase("FDD")) {
                            Logger.info("W2CallbackController setting customer FDD KYC");
                            customer.setKyc(KYC.FULL_DUE_DILIGENCE);
                        } else {
                            Logger.info("W2CallbackController setting customer SDD KYC");
                            customer.setKyc(KYC.SIMPLIFIED_DUE_DILIGENCE);
                        }

                        changeCardGroup(customer);




                        return F.Promise.wrap(customerRepository.update(customer));

                    });

                    cache.remove(callReference);

                } else {
                    Logger.info("W2CallbackController InterpretResult != Pass, skip");
                }

                return F.Promise.pure(ok("OK"));
            } else {
                Logger.info("W2CallbackController fail authorisation");

                return F.Promise.pure(ok("ERROR"));
            }


        });


        return result.recover(throwable -> {
            Logger.error("Error: ", throwable);
            return ok("OK");
        });

    }

    private void changeCardGroup(Customer customer) {

        final F.Promise<List<Card>> cardsPromise = F.Promise.wrap(cardRepository.retrieveListByCustomerId(customer.getId()));

        final F.Promise<Optional<Card>> defaultCardPromise = F.Promise.wrap(cardRepository.retrieveDefaultCard(customer.getId()));

        cardsPromise.map(res -> res.stream().map(card -> cardProvider.changeCardGroup(customer, card))).zip(defaultCardPromise).flatMap(result -> cardProvider.applyFee("80", result._2.get()));
    }


}
