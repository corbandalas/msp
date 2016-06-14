package repository;

import akka.dispatch.Futures;
import model.*;
import model.enums.*;
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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Holds transaction repository tests
 *
 * @author ra created 08.02.2016.
 * @since 0.1.0
 */
public class TransactionRepositoryTest extends BaseRepositoryTest {

    public static final Integer ACCOUNT_1 = 1;
    public static final Integer ACCOUNT_2 = 2;
    public static final String CUSTOMER_ID = "380953055621";

    private TransactionRepository transactionRepository;
    private AccountRepository accountRepository;
    private OperationRepository operationRepository;
    private CardRepository cardRepository;
    private CustomerRepository customerRepository;
    private Card card1;
    private Card card2;


    @Before
    public void setup() throws Exception {
        transactionRepository = application.injector().instanceOf(TransactionRepository.class);
        accountRepository = application.injector().instanceOf(AccountRepository.class);
        operationRepository = application.injector().instanceOf(OperationRepository.class);
        cardRepository = application.injector().instanceOf(CardRepository.class);
        customerRepository = application.injector().instanceOf(CustomerRepository.class);

        assertNotNull(Await.result(accountRepository.create(new Account(ACCOUNT_1, "test account from", "USD",
                new Date(), true, "1234567")), Duration.apply(defaultDelay)));
        assertNotNull(Await.result(accountRepository.create(new Account(ACCOUNT_2, "test account to", "USD", new Date(),
                true, "1234567")), Duration.apply(defaultDelay)));
        assertNotNull(Await.result(customerRepository.create(new Customer(CUSTOMER_ID, new Date(), "Mr", "Vladimir",
                "Kuznetsov", "adress1", "adress2", "83004", "Donetsk", "nihilist.don@gmail.com", new Date(), true,
                KYC.FULL_DUE_DILIGENCE, "101dog101", "USA")), Duration.apply(defaultDelay)));
        card1 = Await.result(cardRepository.create(new Card(null, "token", CUSTOMER_ID, CardType.VIRTUAL, CardBrand.VISA,
                true, new Date(), "alias", true, "info", "USD", "adress1", "adress2", "adress3", "USA")), Duration.apply(defaultDelay));
        assertNotNull(card1);
        card2 = Await.result(cardRepository.create(new Card(null, "token", CUSTOMER_ID, CardType.VIRTUAL, CardBrand.VISA,
                true, new Date(), "alias", true, "info", "USD", "adress1", "adress2", "adress3", "USA")), Duration.apply(defaultDelay));
        assertNotNull(card2);

    }

    @Test
    public void create() throws Exception {

        final Operation operation = Await.result(operationRepository.create(new Operation(null, OperationType.DEPOSIT, "0001",
                "test deposit", new Date())), Duration.apply(defaultDelay));
        assertNotNull(operation.getId());

        final Transaction transaction = Await.result(transactionRepository.create(new Transaction(null, operation.getId(), 100L, "USD", ACCOUNT_1,
                ACCOUNT_2, null, card1.getId(), 1.0, 1.0, null, 1.0, TransactionType.DEPOSIT)), Duration.apply(defaultDelay));
        assertNotNull(transaction.getId());

        final Optional<Transaction> transactionById = Await.result(transactionRepository.retrieveById(transaction.getId()), Duration.apply(defaultDelay));
        assertNotNull(transactionById.get());
    }

    @Test
    public void update() throws Exception {

        final Operation operation = Await.result(operationRepository.create(new Operation(null, OperationType.DEPOSIT, "0001",
                "test deposit", new Date())), Duration.apply(defaultDelay));
        assertNotNull(operation.getId());

        final Transaction transaction = Await.result(transactionRepository.create(new Transaction(null, operation.getId(), 200L, "USD", ACCOUNT_1,
                ACCOUNT_2, null, card1.getId(), 1.0, 1.0, null, 1.0, TransactionType.DEPOSIT)), Duration.apply(defaultDelay));
        assertNotNull(transaction.getId());

        Long amount = 2000L;
        transaction.setAmount(amount);
        assertNotNull(Await.result(transactionRepository.update(transaction), Duration.apply(defaultDelay)));
        final Optional<Transaction> transactionUpdated = Await.result(transactionRepository.retrieveById(transaction.getId()), Duration.apply(defaultDelay));
        assertEquals(amount, transactionUpdated.get().getAmount());
    }

    @Test
    public void retrieveById() throws Exception {

        final Operation operation = Await.result(operationRepository.create(new Operation(null, OperationType.DEPOSIT, "0001",
                "test deposit", new Date())), Duration.apply(defaultDelay));
        assertNotNull(operation.getId());

        final Transaction transaction = Await.result(transactionRepository.create(new Transaction(null, operation.getId(), 300L, "USD", ACCOUNT_1,
                ACCOUNT_2, null, card1.getId(), 1.0, 1.0, null, 1.0, TransactionType.DEPOSIT)), Duration.apply(defaultDelay));
        assertNotNull(transaction.getId());

        final Optional<Transaction> transactionById = Await.result(transactionRepository.retrieveById(transaction.getId()), Duration.apply(defaultDelay));
        assertNotNull(transactionById.get());
    }

    @Test
    public void retrieveAll() throws Exception {

        final Operation operation = Await.result(operationRepository.create(new Operation(null, OperationType.TRANSFER, "0001",
                "test deposit", new Date())), Duration.apply(defaultDelay));
        assertNotNull(operation.getId());

        assertNotNull(Await.result(transactionRepository.create(new Transaction(null, operation.getId(), 400L, "USD", ACCOUNT_1,
                ACCOUNT_2, card1.getId(), null, 1.0, 1.0, 1.0, null, TransactionType.TRANSFER_FROM)), Duration.apply(defaultDelay)));
        assertNotNull(Await.result(transactionRepository.create(new Transaction(null, operation.getId(), 400L, "USD", ACCOUNT_2,
                ACCOUNT_1, null, card2.getId(), 1.0, 1.0, null, 1.0, TransactionType.TRANSFER_TO)), Duration.apply(defaultDelay)));

        final List<Transaction> transactions = Await.result(transactionRepository.retrieveAll(), Duration.apply(defaultDelay));

        assertEquals(2, transactions.size());
    }

    @Test
    public void retrieveByFromAccountId() throws Exception {

        final Operation operation1 = Await.result(operationRepository.create(new Operation(null, OperationType.TRANSFER, "0001",
                "test deposit", new Date())), Duration.apply(defaultDelay));
        assertNotNull(operation1.getId());

        final Operation operation2 = Await.result(operationRepository.create(new Operation(null, OperationType.TRANSFER, "0002",
                "test deposit", new Date())), Duration.apply(defaultDelay));
        assertNotNull(operation2.getId());

        assertNotNull(Await.result(transactionRepository.create(new Transaction(null, operation1.getId(), 400L, "USD", ACCOUNT_1,
                ACCOUNT_2, card1.getId(), null, 1.0, 1.0, 1.0, null, TransactionType.TRANSFER_FROM)), Duration.apply(defaultDelay)));
        assertNotNull(Await.result(transactionRepository.create(new Transaction(null, operation1.getId(), 400L, "USD", ACCOUNT_2,
                ACCOUNT_1, null, card2.getId(), 1.0, 1.0, null, 1.0, TransactionType.TRANSFER_TO)), Duration.apply(defaultDelay)));
        assertNotNull(Await.result(transactionRepository.create(new Transaction(null, operation2.getId(), 500L, "USD", ACCOUNT_1,
                ACCOUNT_2, card1.getId(), null, 1.0, 1.0, 1.0, null, TransactionType.TRANSFER_FROM)), Duration.apply(defaultDelay)));
        assertNotNull(Await.result(transactionRepository.create(new Transaction(null, operation2.getId(), 500L, "USD", ACCOUNT_2,
                ACCOUNT_1, null, card2.getId(), 1.0, 1.0, null, 1.0, TransactionType.TRANSFER_TO)), Duration.apply(defaultDelay)));

        final List<Transaction> transactions = Await.result(transactionRepository.retrieveByFromAccountId(ACCOUNT_1), Duration.apply(defaultDelay));

        assertEquals(2, transactions.size());
    }

    @Test
    public void retrieveByToAccountId() throws Exception {

        final Operation operation1 = Await.result(operationRepository.create(new Operation(null, OperationType.TRANSFER, "0001",
                "test deposit", new Date())), Duration.apply(defaultDelay));
        assertNotNull(operation1.getId());

        final Operation operation2 = Await.result(operationRepository.create(new Operation(null, OperationType.TRANSFER, "0002",
                "test deposit", new Date())), Duration.apply(defaultDelay));
        assertNotNull(operation2.getId());

        assertNotNull(Await.result(transactionRepository.create(new Transaction(null, operation1.getId(), 600L, "USD", ACCOUNT_1,
                ACCOUNT_2, card1.getId(), null, 1.0, 1.0, 1.0, null, TransactionType.TRANSFER_FROM)), Duration.apply(defaultDelay)));
        assertNotNull(Await.result(transactionRepository.create(new Transaction(null, operation1.getId(), 600L, "USD", ACCOUNT_2,
                ACCOUNT_1, null, card2.getId(), 1.0, 1.0, null, 1.0, TransactionType.TRANSFER_TO)), Duration.apply(defaultDelay)));
        assertNotNull(Await.result(transactionRepository.create(new Transaction(null, operation2.getId(), 700L, "USD", ACCOUNT_1,
                ACCOUNT_2, card1.getId(), null, 1.0, 1.0, 1.0, null, TransactionType.TRANSFER_FROM)), Duration.apply(defaultDelay)));
        assertNotNull(Await.result(transactionRepository.create(new Transaction(null, operation2.getId(), 700L, "USD", ACCOUNT_2,
                ACCOUNT_1, null, card2.getId(), 1.0, 1.0, null, 1.0, TransactionType.TRANSFER_TO)), Duration.apply(defaultDelay)));

        final List<Transaction> transactions = Await.result(transactionRepository.retrieveByToAccountId(ACCOUNT_2), Duration.apply(defaultDelay));

        assertEquals(2, transactions.size());
    }

    @Test
    public void retrieveByOperationId() throws Exception {

        final Operation operation1 = Await.result(operationRepository.create(new Operation(null, OperationType.TRANSFER, "0001",
                "test deposit", new Date())), Duration.apply(defaultDelay));
        assertNotNull(operation1.getId());

        final Operation operation2 = Await.result(operationRepository.create(new Operation(null, OperationType.TRANSFER, "0002",
                "test deposit", new Date())), Duration.apply(defaultDelay));
        assertNotNull(operation2.getId());

        assertNotNull(Await.result(transactionRepository.create(new Transaction(null, operation1.getId(), 700L, "USD", ACCOUNT_1,
                ACCOUNT_2, card1.getId(), null, 1.0, 1.0, 1.0, null, TransactionType.TRANSFER_FROM)), Duration.apply(defaultDelay)));
        assertNotNull(Await.result(transactionRepository.create(new Transaction(null, operation1.getId(), 700L, "USD", ACCOUNT_2,
                ACCOUNT_1, null, card2.getId(), 1.0, 1.0, null, 1.0, TransactionType.TRANSFER_TO)), Duration.apply(defaultDelay)));
        assertNotNull(Await.result(transactionRepository.create(new Transaction(null, operation2.getId(), 800L, "USD", ACCOUNT_1,
                ACCOUNT_2, null, null, 1.0, 1.0, 1.0, null, TransactionType.TRANSFER_FROM)), Duration.apply(defaultDelay)));
        assertNotNull(Await.result(transactionRepository.create(new Transaction(null, operation2.getId(), 800L, "USD", ACCOUNT_2,
                ACCOUNT_1, null, null, 1.0, 1.0, null, 1.0, TransactionType.TRANSFER_TO)), Duration.apply(defaultDelay)));

        final List<Transaction> transactions = Await.result(transactionRepository.retrieveByOperationId(operation1.getId()), Duration.apply(defaultDelay));

        assertEquals(2, transactions.size());
    }

    @Test
    public void retrieveSumByToCardId() throws Exception {
        final Operation operation1 = Await.result(operationRepository.create(new Operation(null, OperationType.TRANSFER, "0001",
                "test deposit", new Date())), Duration.apply(defaultDelay));
        assertNotNull(operation1.getId());

        final Operation operation2 = Await.result(operationRepository.create(new Operation(null, OperationType.TRANSFER, "0002",
                "test deposit", new Date())), Duration.apply(defaultDelay));
        assertNotNull(operation2.getId());

        final Transaction transaction1 = Await.result(transactionRepository.create(new Transaction(null, operation1.getId(), 300L, "USD", ACCOUNT_1,
                ACCOUNT_2, null, card1.getId(), 1.0, 1.0, null, 1.0, TransactionType.DEPOSIT)), Duration.apply(defaultDelay));
        assertNotNull(transaction1.getId());

        final Transaction transaction2 = Await.result(transactionRepository.create(new Transaction(null, operation1.getId(), 400L, "USD", ACCOUNT_1,
                ACCOUNT_2, null, card1.getId(), 1.0, 1.0, null, 1.0, TransactionType.DEPOSIT)), Duration.apply(defaultDelay));
        assertNotNull(transaction2.getId());

        Double result = Await.result(transactionRepository.retrieveSumByToCardId(card1.getId()), Duration.apply(defaultDelay));
        assertEquals(700, result, 0.1);
    }

    @After
    public void clean() {
        final Promise<Transaction> promise = Futures.promise();
        connectionPool.getConnection().query("delete from " + connectionPool.getSchemaName() + ".transaction;" +
                " delete from " + connectionPool.getSchemaName() + ".operation;" +
                " delete from " + connectionPool.getSchemaName() + ".account;" +
                " delete from " + connectionPool.getSchemaName() + ".card;" +
                " delete from " + connectionPool.getSchemaName() + ".customer;", resultSet -> promise.success(null), promise::failure);
        try {
            Await.result(promise.future(), Duration.apply(defaultDelay));
        } catch (Exception e) {
            Logger.error("Error", e);
        }
    }

}
