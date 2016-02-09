package provider;

import ae.globalprocessing.hyperionweb.VirtualCards;
import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;
import model.Currency;
import model.Customer;
import model.enums.KYC;
import module.PropertyLoader;
import org.junit.Before;
import org.junit.Test;
import play.Logger;
import repository.CurrencyRepository;
import repository.PropertyRepository;
import scala.concurrent.Await;
import scala.concurrent.duration.Duration;

import java.util.Date;

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

        final Currency currencyUSD = Await.result(currencyRepository.retrieveById("USD"), Duration.apply("10000 ms"));

        VirtualCards virtualCards = globalProcessingCardProvider.issueEmptyVirtualCard(new Customer("380632426303", new Date(), "Mr", "Corban", "Dallas",
                "adress1", "adress2", "83004", "Donetsk", "me@corbandalas.com", new Date(), true, KYC.BASIC, "101dog101", "UA"), "Vasya", currencyUSD).get(10000000L);

        if (virtualCards != null) {
            Logger.info("///Action code = " + virtualCards.getActionCode());
        }
    }


//    @After
//    public void clean() {
//        connectionPool.getConnection().query("delete from " + connectionPool.getSchemaName() + ".property;", resultSet -> {
//        }, throwable -> {
//            throwable.printStackTrace();
//        });
//    }
}
