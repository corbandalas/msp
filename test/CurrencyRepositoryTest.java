import model.Currency;
import org.junit.Before;
import org.junit.Test;
import repository.CurrencyRepository;
import scala.concurrent.Await;
import scala.concurrent.Future;
import scala.concurrent.duration.Duration;

import java.util.List;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

/**
 * Holds currency repository tests
 * @author ra created 06.02.2016.
 * @since 0.1.0
 */
public class CurrencyRepositoryTest extends BaseRepositoryTest{

    private CurrencyRepository currencyRepository;

    @Before
    public void setup() {
        currencyRepository = application.injector().instanceOf(CurrencyRepository.class);
    }

    @Test
    public void retrieveAll() {

        Future<List<Currency>> listFuture = currencyRepository.retrieveAll();
        try {
            List<Currency> currencies = Await.result(listFuture, Duration.apply("1000 ms"));
            assertNotNull(currencies);
        } catch (Exception e) {
            fail();
        }
    }

    @Test
    public void retrieveById() throws Exception {

        Future<Currency> usdFuture = currencyRepository.retrieveById("USD");
        Currency usd = Await.result(usdFuture, Duration.apply("1000 ms"));
        assertNotNull(usd);
    }
}
