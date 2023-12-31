package trigger;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import exception.WrongPropertyException;
import model.Currency;
import model.Property;
import play.Logger;
import play.libs.F;
import repository.CurrencyRepository;
import repository.PropertyRepository;

import java.util.List;
import java.util.Optional;

/**
 * Exchange rates trigger job
 *
 * @author corbandalas - created 05.02.2016
 * @since 0.1.0
 *
 */

@Singleton
public class ExchangeRatesTriggerJob implements Runnable {

    @Inject
    private CurrencyRepository currencyRepository;

    @Inject
    private PropertyRepository propertyRepository;

    @Override
    public void run() {

        Logger.info("////////////////////////////// ExchangeRatesTriggerJob WORKS!!!!");


        final F.Promise<List<Currency>> listCurrencyPromise = F.Promise.wrap(currencyRepository.retrieveAll());
        final F.Promise<Optional<Property>> apiKeyPromise = F.Promise.wrap(propertyRepository.retrieveById("com.currencylayer.api.key"));
        final F.Promise<Optional<Property>> apiUrlPromise = F.Promise.wrap(propertyRepository.retrieveById("com.currencylayer.api.url"));


        final F.Promise<F.Tuple<F.Tuple<List<Currency>, Optional<Property>>, Optional<Property>>> zip = listCurrencyPromise.zip(apiKeyPromise).zip(apiUrlPromise);


        zip.flatMap(result -> {


            final F.Tuple<List<Currency>, Optional<Property>> listPropertyTuple2 = result._1;
            final Optional<Property> urlKeyProperty = result._2;
            final List<Currency> currencies = listPropertyTuple2._1;
            final Optional<Property> apiKeyProperty = listPropertyTuple2._2;

            return F.Promise.wrap(currencyRepository.updateCurrencyExchangeRates(currencies, urlKeyProperty.orElseThrow(WrongPropertyException::new).getValue(), apiKeyProperty.orElseThrow(WrongPropertyException::new).getValue()));

        });

    }

}
