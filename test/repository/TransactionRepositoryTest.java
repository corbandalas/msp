package repository;

import model.Account;
import model.Operation;
import model.Transaction;
import model.enums.OperationType;
import model.enums.TransactionType;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import scala.concurrent.Await;
import scala.concurrent.duration.Duration;

import java.util.Date;

import static junit.framework.TestCase.assertNotNull;
import static org.junit.Assert.assertEquals;

/**
 * Holds transaction repository tests
 *
 * @author ra created 08.02.2016.
 * @since 0.1.0
 */
public class TransactionRepositoryTest extends BaseRepositoryTest {

    private TransactionRepository transactionRepository;
    private AccountRepository accountRepository;
    private OperationRepository operationRepository;

    @Before
    public void setup() throws Exception {
        transactionRepository = application.injector().instanceOf(TransactionRepository.class);
        accountRepository = application.injector().instanceOf(AccountRepository.class);
        operationRepository = application.injector().instanceOf(OperationRepository.class);
    }

    @Test
    public void create() throws Exception {
        Integer fromAccountId = 1;
        Integer toAccountId = 2;

        assertNotNull(Await.result(accountRepository.create(new Account(fromAccountId, "test account from", "USD",
                new Date(), true)), Duration.apply("1000 ms")));
        assertNotNull(Await.result(accountRepository.create(new Account(toAccountId, "test account to", "USD", new Date(),
                true)), Duration.apply("1000 ms")));

        final Operation operation = Await.result(operationRepository.create(new Operation(null, OperationType.DEPOSIT, "0001",
                "test deposit", new Date())), Duration.apply("1000 ms"));
        assertNotNull(operation.getId());

        final Transaction transaction = Await.result(transactionRepository.create(new Transaction(null, operation.getId(), 100L, "USD", fromAccountId,
                toAccountId, null, 1.0, 1.0, TransactionType.DEPOSIT)), Duration.apply("1000 ms"));
        assertNotNull(transaction.getId());

        final Transaction transactionById = Await.result(transactionRepository.retrieveById(transaction.getId()), Duration.apply("1000 ms"));
        assertNotNull(transactionById);
    }

    @Test
    public void update() throws Exception {
        Integer fromAccountId = 1;
        Integer toAccountId = 2;

        assertNotNull(Await.result(accountRepository.create(new Account(fromAccountId, "test account from", "USD",
                new Date(), true)), Duration.apply("1000 ms")));
        assertNotNull(Await.result(accountRepository.create(new Account(toAccountId, "test account to", "USD", new Date(),
                true)), Duration.apply("1000 ms")));

        final Operation operation = Await.result(operationRepository.create(new Operation(null, OperationType.DEPOSIT, "0001",
                "test deposit", new Date())), Duration.apply("1000 ms"));
        assertNotNull(operation.getId());

        final Transaction transaction = Await.result(transactionRepository.create(new Transaction(null, operation.getId(), 200L, "USD", fromAccountId,
                toAccountId, null, 1.0, 1.0, TransactionType.DEPOSIT)), Duration.apply("1000 ms"));
        assertNotNull(transaction.getId());

        Long amount=2000L;
        transaction.setAmount(amount);
        assertNotNull(Await.result(transactionRepository.update(transaction), Duration.apply("1000 ms")));
        final Transaction transactionUpdated = Await.result(transactionRepository.retrieveById(transaction.getId()), Duration.apply("1000 ms"));
        assertEquals(amount,transactionUpdated.getAmount());
    }

    @Test
    public void retrieveById() throws Exception {
        Integer fromAccountId = 1;
        Integer toAccountId = 2;

        assertNotNull(Await.result(accountRepository.create(new Account(fromAccountId, "test account from", "USD",
                new Date(), true)), Duration.apply("1000 ms")));
        assertNotNull(Await.result(accountRepository.create(new Account(toAccountId, "test account to", "USD", new Date(),
                true)), Duration.apply("1000 ms")));

        final Operation operation = Await.result(operationRepository.create(new Operation(null, OperationType.DEPOSIT, "0001",
                "test deposit", new Date())), Duration.apply("1000 ms"));
        assertNotNull(operation.getId());

        final Transaction transaction = Await.result(transactionRepository.create(new Transaction(null, operation.getId(), 300L, "USD", fromAccountId,
                toAccountId, null, 1.0, 1.0, TransactionType.DEPOSIT)), Duration.apply("1000 ms"));
        assertNotNull(transaction.getId());

        final Transaction transactionById = Await.result(transactionRepository.retrieveById(transaction.getId()), Duration.apply("1000 ms"));
        assertNotNull(transactionById);
    }

    @After
    public void clean() {
        connectionPool.getConnection().query("delete from " + connectionPool.getSchemaName() + ".account; delete from "
                + connectionPool.getSchemaName() + ".operation; delete from " + connectionPool.getSchemaName()
                + ".transaction;",resultSet -> {},throwable -> {throwable.printStackTrace();});
    }

}
