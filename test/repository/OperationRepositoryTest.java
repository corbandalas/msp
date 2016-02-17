package repository;

import akka.dispatch.Futures;
import model.ExchangeRateHistory;
import model.Operation;
import model.enums.OperationType;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import play.Logger;
import scala.concurrent.Await;
import scala.concurrent.Promise;
import scala.concurrent.duration.Duration;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import static junit.framework.Assert.assertEquals;
import static junit.framework.TestCase.assertNotNull;

/**
 * Holds operation repository test
 *
 * @author ra created 08.02.2016.
 * @since 0.1.0
 */
public class OperationRepositoryTest extends BaseRepositoryTest {

    private OperationRepository operationRepository;

    @Before
    public void setup() {
        operationRepository = application.injector().instanceOf(OperationRepository.class);
    }

    @Test
    public void create() throws Exception {
        final String orderId = "00001";
        final Operation operation = Await.result(operationRepository.create(new Operation(null, OperationType.DEPOSIT, orderId,
                "test deposit", new Date())), Duration.apply(defaultDelay));
        assertNotNull(operation.getId());

        final Optional<Operation> operationById = Await.result(operationRepository.retrieveById(operation.getId()), Duration.apply(defaultDelay));
        assertEquals(orderId, operationById.get().getOrderId());
    }

    @Test
    public void update() throws Exception {
        final Operation operation = Await.result(operationRepository.create(new Operation(null, OperationType.DEPOSIT,
                "0001", "test deposit", new Date())), Duration.apply(defaultDelay));
        assertNotNull(operation.getId());

        final String orderId = "0002";
        operation.setOrderId(orderId);
        assertNotNull(Await.result(operationRepository.update(operation), Duration.apply(defaultDelay)));
        final Optional<Operation> operationUpdated = Await.result(operationRepository.retrieveById(operation.getId()), Duration.apply(defaultDelay));

        assertEquals(orderId, operationUpdated.get().getOrderId());
    }

    @Test
    public void retrieveById() throws Exception {
        final String orderId = "0001";
        final Operation operation = Await.result(operationRepository.create(new Operation(null, OperationType.DEPOSIT, orderId,
                "test deposit", new Date())), Duration.apply(defaultDelay));
        assertNotNull(operation.getId());

        final Optional<Operation> operationById = Await.result(operationRepository.retrieveById(operation.getId()), Duration.apply(defaultDelay));
        assertEquals(orderId, operationById.get().getOrderId());
    }

    @Test
    public void retrieveAll() throws Exception {
        assertNotNull(Await.result(operationRepository.create(new Operation(null, OperationType.DEPOSIT, "0001",
                "test deposit 1", new Date())), Duration.apply(defaultDelay)));
        assertNotNull(Await.result(operationRepository.create(new Operation(null, OperationType.DEPOSIT, "0002",
                "test deposit 2", new Date())), Duration.apply(defaultDelay)));

        final List<Operation> operations = Await.result(operationRepository.retrieveAll(), Duration.apply(defaultDelay));
        assertEquals(2, operations.size());
    }

    @Test
    public void retrieveByDateAndType() throws Exception {
        final Date startDate = new Date();

        assertNotNull(Await.result(operationRepository.create(new Operation(null, OperationType.DEPOSIT, "0001",
                "test deposit 1", new Date())), Duration.apply(defaultDelay)));
        assertNotNull(Await.result(operationRepository.create(new Operation(null, OperationType.DEPOSIT, "0002",
                "test deposit 2", new Date())), Duration.apply(defaultDelay)));
        assertNotNull(Await.result(operationRepository.create(new Operation(null, OperationType.WITHDRAW, "0002",
                "test withdraw 1", new Date())), Duration.apply(defaultDelay)));

        final Date endDate = new Date();

        Thread.sleep(10);

        assertNotNull(Await.result(operationRepository.create(new Operation(null, OperationType.DEPOSIT, "0002",
                "test deposit 3", new Date())), Duration.apply(defaultDelay)));

        final List<Operation> operations = Await.result(operationRepository.retrieveByDateAndType(startDate, endDate,
                null, (short) 100, 0L), Duration.apply(defaultDelay));
        assertEquals(4, operations.size());

        final List<Operation> deposits = Await.result(operationRepository.retrieveByDateAndType(startDate, endDate,
                OperationType.DEPOSIT, (short) 100, 0L), Duration.apply(defaultDelay));
        assertEquals(3, deposits.size());
    }

    @After
    public void clean() {
        final Promise<Operation> promise = Futures.promise();
        connectionPool.getConnection().query("delete from " + connectionPool.getSchemaName() + ".operation", resultSet -> promise.success(null), promise::failure);
        try {
            Await.result(promise.future(), Duration.apply(defaultDelay));
        } catch (Exception e) {
            Logger.error("Error", e);
        }
    }
}
