package repository;

import model.Country;
import model.Currency;
import org.junit.Before;
import org.junit.Test;
import repository.CountryRepository;
import repository.CurrencyRepository;
import scala.concurrent.Await;
import scala.concurrent.Future;
import scala.concurrent.duration.Duration;

import java.util.List;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

/**
 * Holds country repository tests
 * @author nihilist created 08.02.2016.
 * @since 0.1.0
 */
public class CountryRepositoryTest extends BaseRepositoryTest {

    private CountryRepository countryRepository;

    @Before
    public void setup() {
        countryRepository = application.injector().instanceOf(CountryRepository.class);
    }

    @Test
    public void retrieveAll() {

        Future<List<Country>> listFuture = countryRepository.retrieveAll();
        try {
            List<Country> countries = Await.result(listFuture, Duration.apply(defaultDelay));
            assertNotNull(countries);
        } catch (Exception e) {
            fail();
        }
    }

    @Test
    public void retrieveById() throws Exception {

        Future<Country> ruFuture = countryRepository.retrieveById("RU");
        Country ru = Await.result(ruFuture, Duration.apply(defaultDelay));
        assertNotNull(ru);
    }

}
