package repository;

import model.Operation;
import model.enums.OperationType;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import scala.concurrent.Await;
import scala.concurrent.duration.Duration;

import java.util.Date;
import java.util.List;

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
        final Operation operation = Await.result(operationRepository.create(new Operation(null, OperationType.DEPOSIT, "0001",
                "test deposit", new Date())), Duration.apply("1000 ms"));
        assertNotNull(operation.getId());
    }

    @Test
    public void update() throws Exception {
        final Operation operation = Await.result(operationRepository.create(new Operation(null, OperationType.DEPOSIT,
                "0001", "test deposit", new Date())), Duration.apply("1000 ms"));
        assertNotNull(operation.getId());

        final String orderId = "0002";
        operation.setOrderId(orderId);
        assertNotNull(Await.result(operationRepository.update(operation), Duration.apply("1000 ms")));
        final Operation operationUpdated = Await.result(operationRepository.retrieveById(operation.getId()), Duration.apply("1000 ms"));

        assertEquals(orderId,operationUpdated.getOrderId());
    }

    @Test
    public void retrieveById() throws Exception {
        final String orderId = "0001";
        final Operation operation = Await.result(operationRepository.create(new Operation(null, OperationType.DEPOSIT, orderId,
                "test deposit", new Date())), Duration.apply("1000 ms"));
        assertNotNull(operation.getId());

        final Operation operationById = Await.result(operationRepository.retrieveById(operation.getId()), Duration.apply("1000 ms"));
        assertEquals(orderId,operationById.getOrderId());
    }

    @Test
    public void retrieveAll() throws Exception {
        assertNotNull(Await.result(operationRepository.create(new Operation(null, OperationType.DEPOSIT, "0001",
                "test deposit 1", new Date())),Duration.apply("1000 ms")));
        assertNotNull(Await.result(operationRepository.create(new Operation(null, OperationType.DEPOSIT, "0002",
                "test deposit 2", new Date())),Duration.apply("1000 ms")));

        final List<Operation> operations = Await.result(operationRepository.retrieveAll(), Duration.apply("1000 ms"));
        assertEquals(2,operations.size());
    }

    @After
    public void clean() {
        connectionPool.getConnection().query("delete from " + connectionPool.getSchemaName() + ".operation", resultSet -> {
        }, throwable -> {
            throwable.printStackTrace();
        });
    }
}
