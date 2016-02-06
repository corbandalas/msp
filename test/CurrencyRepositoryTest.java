import akka.actor.ActorSystem;
import akka.dispatch.OnFailure;
import akka.dispatch.OnSuccess;
import model.Currency;
import org.junit.Before;
import org.junit.Test;
import play.api.Application;
import play.api.inject.guice.GuiceApplicationBuilder;
import repository.CurrencyRepository;
import scala.concurrent.ExecutionContextExecutor;
import scala.concurrent.Future;

import java.util.List;

/**
 * @author ra created 06.02.2016.
 * @since 0.1.0
 */
public class CurrencyRepositoryTest {

    private Application application;
    private ExecutionContextExecutor dispatcher;

    @Before
    public void setup() {
        application = new GuiceApplicationBuilder().build();

        dispatcher = application.injector().instanceOf(ActorSystem.class).dispatcher();
    }

    @Test
    public void create() {
        CurrencyRepository currencyRepository = application.injector().instanceOf(CurrencyRepository.class);
        Future<List<Currency>> listFuture = currencyRepository.retrieveAll();
        listFuture.onSuccess(new OnSuccess<List<Currency>>() {
            @Override
            public void onSuccess(List<Currency> result) throws Throwable {
                System.out.println(result.get(0));
            }
        }, dispatcher);

        listFuture.onFailure(new OnFailure() {
            @Override
            public void onFailure(Throwable failure) throws Throwable {
                failure.printStackTrace();
            }
        }, dispatcher);
    }
}
