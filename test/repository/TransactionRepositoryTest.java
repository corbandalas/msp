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
import java.util.List;

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

        Long amount = 2000L;
        transaction.setAmount(amount);
        assertNotNull(Await.result(transactionRepository.update(transaction), Duration.apply("1000 ms")));
        final Transaction transactionUpdated = Await.result(transactionRepository.retrieveById(transaction.getId()), Duration.apply("1000 ms"));
        assertEquals(amount, transactionUpdated.getAmount());
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

    @Test
    public void retrieveAll() throws Exception {
        Integer account1 = 1;
        Integer account2 = 2;

        assertNotNull(Await.result(accountRepository.create(new Account(account1, "test account 1", "USD",
                new Date(), true)), Duration.apply("1000 ms")));
        assertNotNull(Await.result(accountRepository.create(new Account(account2, "test account 2", "USD", new Date(),
                true)), Duration.apply("1000 ms")));

        final Operation operation = Await.result(operationRepository.create(new Operation(null, OperationType.TRANSFER, "0001",
                "test deposit", new Date())), Duration.apply("1000 ms"));
        assertNotNull(operation.getId());

        assertNotNull(Await.result(transactionRepository.create(new Transaction(null, operation.getId(), 400L, "USD", account1,
                account2, null, 1.0, 1.0, TransactionType.TRANSFER_FROM)), Duration.apply("1000 ms")));
        assertNotNull(Await.result(transactionRepository.create(new Transaction(null, operation.getId(), 400L, "USD", account2,
                account1, null, 1.0, 1.0, TransactionType.TRANSFER_TO)), Duration.apply("1000 ms")));

        final List<Transaction> transactions = Await.result(transactionRepository.retrieveAll(), Duration.apply("1000 ms"));

        assertEquals(2, transactions.size());
    }

    @Test
    public void retrieveByFromAccountId() throws Exception {
        Integer account1 = 1;
        Integer account2 = 2;

        assertNotNull(Await.result(accountRepository.create(new Account(account1, "test account 1", "USD",
                new Date(), true)), Duration.apply("1000 ms")));
        assertNotNull(Await.result(accountRepository.create(new Account(account2, "test account 2", "USD", new Date(),
                true)), Duration.apply("1000 ms")));

        final Operation operation1 = Await.result(operationRepository.create(new Operation(null, OperationType.TRANSFER, "0001",
                "test deposit", new Date())), Duration.apply("1000 ms"));
        assertNotNull(operation1.getId());

        final Operation operation2 = Await.result(operationRepository.create(new Operation(null, OperationType.TRANSFER, "0002",
                "test deposit", new Date())), Duration.apply("1000 ms"));
        assertNotNull(operation2.getId());

        assertNotNull(Await.result(transactionRepository.create(new Transaction(null, operation1.getId(), 400L, "USD", account1,
                account2, null, 1.0, 1.0, TransactionType.TRANSFER_FROM)), Duration.apply("1000 ms")));
        assertNotNull(Await.result(transactionRepository.create(new Transaction(null, operation1.getId(), 400L, "USD", account2,
                account1, null, 1.0, 1.0, TransactionType.TRANSFER_TO)), Duration.apply("1000 ms")));
        assertNotNull(Await.result(transactionRepository.create(new Transaction(null, operation2.getId(), 500L, "USD", account1,
                account2, null, 1.0, 1.0, TransactionType.TRANSFER_FROM)), Duration.apply("1000 ms")));
        assertNotNull(Await.result(transactionRepository.create(new Transaction(null, operation2.getId(), 500L, "USD", account2,
                account1, null, 1.0, 1.0, TransactionType.TRANSFER_TO)), Duration.apply("1000 ms")));

        final List<Transaction> transactions = Await.result(transactionRepository.retrieveByFromAccountId(account1), Duration.apply("1000 ms"));

        assertEquals(2, transactions.size());
    }

    @Test
    public void retrieveByToAccountId() throws Exception {
        Integer account1 = 1;
        Integer account2 = 2;

        assertNotNull(Await.result(accountRepository.create(new Account(account1, "test account 1", "USD",
                new Date(), true)), Duration.apply("1000 ms")));
        assertNotNull(Await.result(accountRepository.create(new Account(account2, "test account 2", "USD", new Date(),
                true)), Duration.apply("1000 ms")));

        final Operation operation1 = Await.result(operationRepository.create(new Operation(null, OperationType.TRANSFER, "0001",
                "test deposit", new Date())), Duration.apply("1000 ms"));
        assertNotNull(operation1.getId());

        final Operation operation2 = Await.result(operationRepository.create(new Operation(null, OperationType.TRANSFER, "0002",
                "test deposit", new Date())), Duration.apply("1000 ms"));
        assertNotNull(operation2.getId());

        assertNotNull(Await.result(transactionRepository.create(new Transaction(null, operation1.getId(), 600L, "USD", account1,
                account2, null, 1.0, 1.0, TransactionType.TRANSFER_FROM)), Duration.apply("1000 ms")));
        assertNotNull(Await.result(transactionRepository.create(new Transaction(null, operation1.getId(), 600L, "USD", account2,
                account1, null, 1.0, 1.0, TransactionType.TRANSFER_TO)), Duration.apply("1000 ms")));
        assertNotNull(Await.result(transactionRepository.create(new Transaction(null, operation2.getId(), 700L, "USD", account1,
                account2, null, 1.0, 1.0, TransactionType.TRANSFER_FROM)), Duration.apply("1000 ms")));
        assertNotNull(Await.result(transactionRepository.create(new Transaction(null, operation2.getId(), 700L, "USD", account2,
                account1, null, 1.0, 1.0, TransactionType.TRANSFER_TO)), Duration.apply("1000 ms")));

        final List<Transaction> transactions = Await.result(transactionRepository.retrieveByToAccountId(account2), Duration.apply("1000 ms"));

        assertEquals(2, transactions.size());
    }

    @Test
    public void retrieveByOperationId() throws Exception {
        Integer account1 = 1;
        Integer account2 = 2;

        assertNotNull(Await.result(accountRepository.create(new Account(account1, "test account 1", "USD",
                new Date(), true)), Duration.apply("1000 ms")));
        assertNotNull(Await.result(accountRepository.create(new Account(account2, "test account 2", "USD", new Date(),
                true)), Duration.apply("1000 ms")));

        final Operation operation1 = Await.result(operationRepository.create(new Operation(null, OperationType.TRANSFER, "0001",
                "test deposit", new Date())), Duration.apply("1000 ms"));
        assertNotNull(operation1.getId());

        final Operation operation2 = Await.result(operationRepository.create(new Operation(null, OperationType.TRANSFER, "0002",
                "test deposit", new Date())), Duration.apply("1000 ms"));
        assertNotNull(operation2.getId());

        assertNotNull(Await.result(transactionRepository.create(new Transaction(null, operation1.getId(), 700L, "USD", account1,
                account2, null, 1.0, 1.0, TransactionType.TRANSFER_FROM)), Duration.apply("1000 ms")));
        assertNotNull(Await.result(transactionRepository.create(new Transaction(null, operation1.getId(), 700L, "USD", account2,
                account1, null, 1.0, 1.0, TransactionType.TRANSFER_TO)), Duration.apply("1000 ms")));
        assertNotNull(Await.result(transactionRepository.create(new Transaction(null, operation2.getId(), 800L, "USD", account1,
                account2, null, 1.0, 1.0, TransactionType.TRANSFER_FROM)), Duration.apply("1000 ms")));
        assertNotNull(Await.result(transactionRepository.create(new Transaction(null, operation2.getId(), 800L, "USD", account2,
                account1, null, 1.0, 1.0, TransactionType.TRANSFER_TO)), Duration.apply("1000 ms")));

        final List<Transaction> transactions = Await.result(transactionRepository.retrieveByOperationId(operation1.getId()), Duration.apply("1000 ms"));

        assertEquals(2, transactions.size());
    }

    @After
    public void clean() {
        connectionPool.getConnection().query("delete from " + connectionPool.getSchemaName() + ".transaction; delete from "
                + connectionPool.getSchemaName() + ".operation; delete from " + connectionPool.getSchemaName()
                + ".account;", resultSet -> {
        }, Throwable::printStackTrace);
    }

}
