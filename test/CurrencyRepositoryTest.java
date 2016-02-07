import akka.actor.ActorSystem;
import model.Currency;
import org.junit.Before;
import org.junit.Test;
import play.api.Application;
import play.api.inject.guice.GuiceApplicationBuilder;
import repository.ConnectionPool;
import repository.CurrencyRepository;
import scala.concurrent.Await;
import scala.concurrent.ExecutionContextExecutor;
import scala.concurrent.Future;
import scala.concurrent.duration.Duration;

import java.util.List;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

/**
 * @author ra created 06.02.2016.
 * @since 0.1.0
 */
public class CurrencyRepositoryTest extends BaseRepositoryTest{

    @Before
    public void setup() {
        System.out.print("hello");
    }

    @Test
    public void retrieveAll() {
        CurrencyRepository currencyRepository = application.injector().instanceOf(CurrencyRepository.class);
        Future<List<Currency>> listFuture = currencyRepository.retrieveAll();
        try {
            List<Currency> currencies = Await.result(listFuture, Duration.apply("1000 ms"));
            assertNotNull(currencies);
        } catch (Exception e) {
            fail();
        }
    }
}
