package repository;

import model.ExchangeRateHistory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import scala.concurrent.Await;
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
            ExchangeRateHistory exchangeRateHistory = Await.result(exchangeRateHistoryRepository.create(new ExchangeRateHistory(null, new BigDecimal(10.24), new Date(), "USD")), Duration.apply("1000 ms"));
            assertNotNull(exchangeRateHistory.getId());
        } catch (Exception e) {
            fail();
        }
    }


    @Test
    public void update() {
        try {
            ExchangeRateHistory exchangeRateHistory = Await.result(exchangeRateHistoryRepository.create(new ExchangeRateHistory(null, new BigDecimal(10.24), new Date(), "USD")), Duration.apply("1000 ms"));
            assertNotNull(exchangeRateHistory.getId());
            exchangeRateHistory.setCurrencyId("EUR");

            ExchangeRateHistory exchangeRateHistoryUpdated = Await.result(exchangeRateHistoryRepository.update(exchangeRateHistory), Duration.apply("1000 ms"));
            assertEquals(exchangeRateHistoryUpdated.getCurrencyId(), exchangeRateHistory.getCurrencyId());
        } catch (Exception e) {
            fail();
        }
    }


    @Test
    public void retrieveById() throws Exception {
        try {
            ExchangeRateHistory exchangeRateHistory = Await.result(exchangeRateHistoryRepository.create(new ExchangeRateHistory(null, new BigDecimal(10.24), new Date(), "USD")), Duration.apply("1000 ms"));
            assertNotNull(exchangeRateHistory.getId());

            final ExchangeRateHistory exchangeRateHistoryById = Await.result(exchangeRateHistoryRepository.retrieveById(exchangeRateHistory.getId()), Duration.apply("1000 ms"));
            assertEquals(exchangeRateHistoryById.getId(), exchangeRateHistory.getId());
        } catch (Exception e) {
            fail();
        }
    }

    @Test
    public void retrieveAll() throws Exception {
        Await.result(exchangeRateHistoryRepository.create(new ExchangeRateHistory(null, new BigDecimal(10.24), new Date(), "USD")), Duration.apply("1000 ms"));
        Await.result(exchangeRateHistoryRepository.create(new ExchangeRateHistory(null, new BigDecimal(12.24), new Date(), "EUR")), Duration.apply("1000 ms"));

        final List<ExchangeRateHistory> result = Await.result(exchangeRateHistoryRepository.retrieveAll(), Duration.apply("1000 ms"));
        assertEquals(2,result.size());
    }


    @After
    public void clean() {
        connectionPool.getConnection().query("delete from " + connectionPool.getSchemaName() + ".exchange_rate_history;",resultSet -> {},throwable -> {throwable.printStackTrace();});
    }

}
