package service;

import com.envoyservices.merchantapi.BankDetailsResponseV2;
import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;
import model.Card;
import model.Currency;
import model.Customer;
import model.enums.KYC;
import module.PropertyLoader;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import play.Logger;
import provider.BaseCardProviderTest;
import provider.GlobalProcessingCardProvider;
import provider.dto.*;
import repository.BaseRepositoryTest;
import repository.CurrencyRepository;
import repository.PropertyRepository;
import scala.concurrent.Await;
import scala.concurrent.duration.Duration;
import services.WorldPayPaymentService;

import java.util.Calendar;
import java.util.Date;

import static org.junit.Assert.*;

/**
 * WorldPay payment service test
 *
 * @author corbandalas created 08.06.2016.
 * @since 0.3.0
 */

public class WorldPayPaymentServiceTest extends BaseRepositoryTest {

    private PropertyRepository propertyRepository;

    private GlobalProcessingCardProvider globalProcessingCardProvider;

    private WorldPayPaymentService worldPayPaymentService;

    private CurrencyRepository currencyRepository;


    private final long WS_TIMEOUT = 10000000L;

    @Before
    public void setup() {

        propertyRepository = application.injector().instanceOf(PropertyRepository.class);
        worldPayPaymentService = application.injector().instanceOf(WorldPayPaymentService.class);
        PropertyLoader propertyLoader = application.injector().instanceOf(PropertyLoader.class);
        propertyLoader.load("conf/properties.json", dispatcher);


    }


    @Test
    public void testGetBanks() throws Exception {

        Thread.currentThread().sleep(1000);

        try {

            BankDetailsResponseV2 bankDetailsResponseV2 = worldPayPaymentService.getBankDetails("UK").get(WS_TIMEOUT);

            assertNotNull(bankDetailsResponseV2);
//            assertNotNull(cardCreationResponse.getToken());
//            assertEquals(cardCreationResponse.getLoadValue(), (double) amount / 100, 0.0001);

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
