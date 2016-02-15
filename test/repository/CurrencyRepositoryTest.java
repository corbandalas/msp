package repository;

import model.Currency;
import org.junit.Before;
import org.junit.Test;
import repository.CurrencyRepository;
import scala.concurrent.Await;
import scala.concurrent.Future;
import scala.concurrent.duration.Duration;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Holds currency repository tests
 *
 * @author ra created 06.02.2016.
 * @since 0.1.0
 */
public class CurrencyRepositoryTest extends BaseRepositoryTest {

    private CurrencyRepository currencyRepository;

    @Before
    public void setup() {
        currencyRepository = application.injector().instanceOf(CurrencyRepository.class);
    }

    @Test
    public void retrieveAll() throws Exception {

        Future<List<Currency>> listFuture = currencyRepository.retrieveAll();
        List<Currency> currencies = Await.result(listFuture, Duration.apply(defaultDelay));
        assertNotNull(currencies);
    }

    @Test
    public void retrieveById() throws Exception {

        Future<Currency> usdFuture = currencyRepository.retrieveById("USD");
        Currency usd = Await.result(usdFuture, Duration.apply(defaultDelay));
        assertNotNull(usd);
    }

    @Test
    public void update() throws Exception {

        final Currency usd = Await.result(currencyRepository.retrieveById("USD"), Duration.apply(defaultDelay));

        final BigDecimal euroIndexUpdated = new BigDecimal(1.2);
        usd.setEuroIndex(euroIndexUpdated);
        assertNotNull(Await.result(currencyRepository.update(usd), Duration.apply(defaultDelay)));

        final Currency usdUpdated = Await.result(currencyRepository.retrieveById("USD"), Duration.apply(defaultDelay));
        assertEquals(euroIndexUpdated, usdUpdated.getEuroIndex());
    }
}
