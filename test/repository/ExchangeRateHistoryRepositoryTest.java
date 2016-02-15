package repository;

import akka.dispatch.Futures;
import model.Customer;
import model.ExchangeRateHistory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import play.Logger;
import scala.concurrent.Await;
import scala.concurrent.Promise;
import scala.concurrent.duration.Duration;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import static junit.framework.TestCase.assertNotNull;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

/**
 * Holds card repository tests
 *
 * @author nihilist created 08.02.2016.
 * @since 0.1.0
 */
public class ExchangeRateHistoryRepositoryTest extends BaseRepositoryTest {

    private ExchangeRateHistoryRepository exchangeRateHistoryRepository;

    @Before
    public void setup() {
        exchangeRateHistoryRepository = application.injector().instanceOf(ExchangeRateHistoryRepository.class);
    }

    @Test
    public void create() {
        try {
            ExchangeRateHistory exchangeRateHistory = Await.result(exchangeRateHistoryRepository.create(new ExchangeRateHistory(null, new BigDecimal(10.24), new Date(), "USD")), Duration.apply(defaultDelay));
            assertNotNull(exchangeRateHistory.getId());
        } catch (Exception e) {
            Logger.error("Error", e);
            fail();
        }
    }


    @Test
    public void update() {
        try {
            ExchangeRateHistory exchangeRateHistory = Await.result(exchangeRateHistoryRepository.create(new ExchangeRateHistory(null, new BigDecimal(10.24), new Date(), "USD")), Duration.apply(defaultDelay));
            assertNotNull(exchangeRateHistory.getId());
            exchangeRateHistory.setCurrencyId("EUR");

            Await.result(exchangeRateHistoryRepository.update(exchangeRateHistory), Duration.apply(defaultDelay));
            final ExchangeRateHistory exchangeRateHistoryUpdated = Await.result(exchangeRateHistoryRepository.retrieveById(exchangeRateHistory.getId()), Duration.apply(defaultDelay));
            assertEquals(exchangeRateHistoryUpdated.getCurrencyId(), exchangeRateHistory.getCurrencyId());
        } catch (Exception e) {
            Logger.error("Error", e);
            fail();
        }
    }


    @Test
    public void retrieveById() throws Exception {
        try {
            ExchangeRateHistory exchangeRateHistory = Await.result(exchangeRateHistoryRepository.create(new ExchangeRateHistory(null, new BigDecimal(10.24), new Date(), "USD")), Duration.apply(defaultDelay));
            assertNotNull(exchangeRateHistory.getId());

            final ExchangeRateHistory exchangeRateHistoryById = Await.result(exchangeRateHistoryRepository.retrieveById(exchangeRateHistory.getId()), Duration.apply(defaultDelay));
            assertEquals(exchangeRateHistoryById.getId(), exchangeRateHistory.getId());
        } catch (Exception e) {
            Logger.error("Error", e);
            fail();
        }
    }

    @Test
    public void retrieveByCurrencyId() throws Exception {
        try {
            Await.result(exchangeRateHistoryRepository.create(new ExchangeRateHistory(null, new BigDecimal(10.24), new Date(), "USD")), Duration.apply(defaultDelay));
            Await.result(exchangeRateHistoryRepository.create(new ExchangeRateHistory(null, new BigDecimal(11.24), new Date(), "EUR")), Duration.apply(defaultDelay));
            Await.result(exchangeRateHistoryRepository.create(new ExchangeRateHistory(null, new BigDecimal(12.24), new Date(), "EUR")), Duration.apply(defaultDelay));

            List<ExchangeRateHistory> result = Await.result(exchangeRateHistoryRepository.retrieveByCurrencyId("EUR"), Duration.apply(defaultDelay));
            assertEquals(2, result.size());
        } catch (Exception e) {
            Logger.error("Error", e);
            fail();
        }
    }


    @Test
    public void retrieveAll() throws Exception {
        Await.result(exchangeRateHistoryRepository.create(new ExchangeRateHistory(null, new BigDecimal(10.24), new Date(), "USD")), Duration.apply(defaultDelay));
        Await.result(exchangeRateHistoryRepository.create(new ExchangeRateHistory(null, new BigDecimal(12.24), new Date(), "EUR")), Duration.apply(defaultDelay));

        final List<ExchangeRateHistory> result = Await.result(exchangeRateHistoryRepository.retrieveAll(), Duration.apply(defaultDelay));
        assertEquals(2, result.size());
    }


    @After
    public void clean() {
        final Promise<ExchangeRateHistory> promise = Futures.promise();
        connectionPool.getConnection().query("delete from " + connectionPool.getSchemaName() + ".exchange_rate_history", resultSet -> promise.success(null), promise::failure);
        try {
            Await.result(promise.future(), Duration.apply(defaultDelay));
        } catch (Exception e) {
            Logger.error("Error", e);
        }
    }
}
