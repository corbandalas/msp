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

import javax.validation.constraints.AssertTrue;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
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

        Optional<Country> ru = Await.result(countryRepository.retrieveById("RU"), Duration.apply(defaultDelay));
        assertNotNull(ru.get());
    }

    @Test
    public void checkCountry() throws Exception {

        assertTrue(Await.result(countryRepository.checkCountry("RU"), Duration.apply(defaultDelay)));
        assertTrue(!Await.result(countryRepository.checkCountry("RUBL"), Duration.apply(defaultDelay)));
    }

    @Test
    public void retrieveByActive() {

        final Future<List<Country>> listActive = countryRepository.retrieveByActive(true);
        try {
            List<Country> countries = Await.result(listActive, Duration.apply(defaultDelay));
            assertNotNull(countries);
        } catch (Exception e) {
            fail();
        }

        final Future<List<Country>> listInactive = countryRepository.retrieveByActive(false);
        try {
            List<Country> countries = Await.result(listInactive, Duration.apply(defaultDelay));
            assertNotNull(countries);
        } catch (Exception e) {
            fail();
        }
    }

}
