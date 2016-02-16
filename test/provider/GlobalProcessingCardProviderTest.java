package provider;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;
import model.Currency;
import model.Customer;
import model.enums.KYC;
import module.PropertyLoader;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import play.Logger;
import repository.CurrencyRepository;
import repository.PropertyRepository;
import scala.concurrent.Await;
import scala.concurrent.duration.Duration;
import static org.junit.Assert.fail;

import java.util.Date;
import java.util.Optional;

/**
 * Global processing card provider test
 *
 * @author corbandalas created 09.02.2016.
 * @since 0.1.0
 */

public class GlobalProcessingCardProviderTest extends BaseCardProviderTest {

    private PropertyRepository propertyRepository;

    private GlobalProcessingCardProvider globalProcessingCardProvider;

    private CurrencyRepository currencyRepository;

    @Before
    public void setup() {

        Config conf = ConfigFactory.load();

        propertyRepository = application.injector().instanceOf(PropertyRepository.class);
        globalProcessingCardProvider = application.injector().instanceOf(GlobalProcessingCardProvider.class);
        currencyRepository = application.injector().instanceOf(CurrencyRepository.class);
        PropertyLoader propertyLoader = application.injector().instanceOf(PropertyLoader.class);
        propertyLoader.load(conf.getString("project.path") + "/conf/properties.json", dispatcher);


    }


    @Test
    public void issueVirtualCard() throws Exception {

        Thread.currentThread().sleep(1000);

        final Optional<Currency> currencyUSD = Await.result(currencyRepository.retrieveById("DKK"), Duration.apply("1000 ms"));

        try {

            globalProcessingCardProvider.issueEmptyVirtualCard(new Customer("380632426303", new Date(), "Mr", "Corban", "Dallas",
                    "adress1", "adress2", "83004", "Donetsk", "me@corbandalas.com", new Date(), true, KYC.FULL_DUE_DILIGENCE, "101dog101", "UA"), "Vasya", currencyUSD.get()).get(10000000L);
        } catch (Exception e) {
            Logger.error("Error", e);
            fail();
        }


    }


    @After
    public void clean() {
        connectionPool.getConnection().query("delete from " + connectionPool.getSchemaName() + ".property;", resultSet -> {
        }, throwable -> {
            throwable.printStackTrace();
        });
    }
}
