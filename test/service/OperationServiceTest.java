package service;

import model.*;
import model.enums.*;
import module.PropertyLoader;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import play.libs.F;
import repository.*;
import scala.concurrent.Await;
import scala.concurrent.duration.Duration;
import services.OperationService;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Operation service test
 * Created by yakov_000 on 14.06.2016.
 */
public class OperationServiceTest extends BaseRepositoryTest {

    public static final String CUSTOMER_ID = "380953055621";
    public static final long TIMEOUT = 5000L;

    private OperationService operationService;
    private Card card1;
    private Card card2;
    private Currency usd;
    private OperationRepository operationRepository;
    private TransactionRepository transactionRepository;
    private Integer depositAccountId;
    private Integer cardAccountId;
    private Integer transferAccountId;

    @Before
    public void setup() throws Exception {

        PropertyLoader propertyLoader = application.injector().instanceOf(PropertyLoader.class);
        propertyLoader.load("conf/properties.json", dispatcher);

        Thread.currentThread().sleep(1000);

        PropertyRepository propertyRepository = application.injector().instanceOf(PropertyRepository.class);

        depositAccountId = Integer.valueOf(Await.result(propertyRepository.retrieveById("com.msp.accounts.deposit"),
                Duration.apply(defaultDelay)).map(Property::getValue).get());
        cardAccountId = Integer.valueOf(Await.result(propertyRepository.retrieveById("com.msp.accounts.card"),
                Duration.apply(defaultDelay)).map(Property::getValue).get());
        transferAccountId = Integer.valueOf(Await.result(propertyRepository.retrieveById("com.msp.accounts.transfer"),
                Duration.apply(defaultDelay)).map(Property::getValue).get());

        AccountRepository accountRepository = application.injector().instanceOf(AccountRepository.class);

        Await.result(accountRepository.create(new Account(depositAccountId, "deposit account", "USD", new Date(), true, "secret")), Duration.apply(defaultDelay));
        Await.result(accountRepository.create(new Account(cardAccountId, "card account", "USD", new Date(), true, "secret")), Duration.apply(defaultDelay));
        Await.result(accountRepository.create(new Account(transferAccountId, "transfer account", "USD", new Date(), true, "secret")), Duration.apply(defaultDelay));

        final CustomerRepository customerRepository = application.injector().instanceOf(CustomerRepository.class);

        assertNotNull(Await.result(customerRepository.create(new Customer(CUSTOMER_ID, new Date(), "Mr", "Vladimir",
                "Kuznetsov", "adress1", "adress2", "83004", "Donetsk", "nihilist.don@gmail.com", new Date(), true,
                KYC.FULL_DUE_DILIGENCE, "101dog101", "USA")), Duration.apply(defaultDelay)));

        final CardRepository cardRepository = application.injector().instanceOf(CardRepository.class);

        card1 = Await.result(cardRepository.create(new Card(null, "token", CUSTOMER_ID, CardType.VIRTUAL, CardBrand.VISA,
                true, new Date(), "alias", true, "info", "USD", "adress1", "adress2", "adress3", "USA")), Duration.apply(defaultDelay));
        assertNotNull(card1);
        card2 = Await.result(cardRepository.create(new Card(null, "token", CUSTOMER_ID, CardType.VIRTUAL, CardBrand.VISA,
                true, new Date(), "alias", true, "info", "USD", "adress1", "adress2", "adress3", "USA")), Duration.apply(defaultDelay));
        assertNotNull(card2);

        final CurrencyRepository currencyRepository = application.injector().instanceOf(CurrencyRepository.class);
        usd = Await.result(currencyRepository.retrieveById("USD"), Duration.apply(defaultDelay)).get();

        operationRepository = application.injector().instanceOf(OperationRepository.class);
        transactionRepository = application.injector().instanceOf(TransactionRepository.class);

        operationService = application.injector().instanceOf(OperationService.class);
    }

    @After
    public void clean() {
        connectionPool.getConnection().query("delete from " + connectionPool.getSchemaName() + ".property;" +
                        " delete from " + connectionPool.getSchemaName() + ".transaction;" +
                        " delete from " + connectionPool.getSchemaName() + ".operation;" +
                        " delete from " + connectionPool.getSchemaName() + ".account;" +
                        " delete from " + connectionPool.getSchemaName() + ".card;" +
                        " delete from " + connectionPool.getSchemaName() + ".customer;"
                , resultSet -> {
                }, throwable -> {
                    throwable.printStackTrace();
                });
    }

    @Test
    public void createDepositOperation() throws Exception {
        final Long amount = 100L;
        final String orderId = "1111";
        final String description = "deposit";

        final F.Tuple<Operation, Transaction> result = operationService.createDepositOperation(card1, amount, usd, orderId, description).get(TIMEOUT);
        assertNotNull(result);
        assertNotNull(result._1.getId());

        final Operation operation = Await.result(operationRepository.retrieveById(result._1.getId()), Duration.apply(defaultDelay)).get();

        assertEquals(OperationType.DEPOSIT, operation.getType());
        assertNotNull(operation.getCreateDate());
        assertEquals(description, operation.getDescription());
        assertEquals(orderId, operation.getOrderId());

        final Transaction transaction = Await.result(transactionRepository.retrieveByOperationId(result._1.getId()), Duration.apply(defaultDelay)).get(0);

        assertEquals(TransactionType.DEPOSIT, transaction.getType());
        assertEquals(amount, transaction.getAmount());
        assertEquals("USD", transaction.getCurrencyId());
        assertEquals(depositAccountId, transaction.getFromAccountId());
        assertEquals(cardAccountId, transaction.getToAccountId());
        assertNull(transaction.getFromCardId());
        assertEquals(card1.getId(), transaction.getToCardId());
        assertEquals(Double.valueOf(1.0), transaction.getFromAccountExchangeRate());
        assertEquals(Double.valueOf(1.0), transaction.getToAccountExchangeRate());
        assertNull(transaction.getFromCardExchangeRate());
        assertEquals(Double.valueOf(1.0), transaction.getToCardExchangeRate());
    }

    @Test
    public void createTransferOperation() throws Exception {
        final Long amount = 100L;
        final String orderId = "1111";
        final String description = "transfer";

        final F.Tuple<Operation, List<Transaction>> result = operationService.createTransferOperation(card1, card2, amount, usd, orderId, description).get(TIMEOUT);
        assertNotNull(result);
        assertNotNull(result._1.getId());

        final Operation operation = Await.result(operationRepository.retrieveById(result._1.getId()), Duration.apply(defaultDelay)).get();

        assertEquals(OperationType.TRANSFER, operation.getType());
        assertNotNull(operation.getCreateDate());
        assertEquals(description, operation.getDescription());
        assertEquals(orderId, operation.getOrderId());

        final List<Transaction> transactions = Await.result(transactionRepository.retrieveByOperationId(result._1.getId()), Duration.apply(defaultDelay));

        final Transaction fromTransaction = transactions.stream().filter(itm -> itm.getType().equals(TransactionType.TRANSFER_FROM)).findFirst().get();

        assertEquals(amount, fromTransaction.getAmount());
        assertEquals("USD", fromTransaction.getCurrencyId());
        assertEquals(cardAccountId, fromTransaction.getFromAccountId());
        assertEquals(transferAccountId, fromTransaction.getToAccountId());
        assertEquals(card1.getId(), fromTransaction.getFromCardId());
        assertNull(fromTransaction.getToCardId());
        assertEquals(Double.valueOf(1.0), fromTransaction.getFromAccountExchangeRate());
        assertEquals(Double.valueOf(1.0), fromTransaction.getToAccountExchangeRate());
        assertEquals(Double.valueOf(1.0), fromTransaction.getFromCardExchangeRate());
        assertNull(fromTransaction.getToCardExchangeRate());

        final Transaction toTransaction = transactions.stream().filter(itm -> itm.getType().equals(TransactionType.TRANSFER_TO)).findFirst().get();

        assertEquals(amount, toTransaction.getAmount());
        assertEquals("USD", toTransaction.getCurrencyId());
        assertEquals(transferAccountId, toTransaction.getFromAccountId());
        assertEquals(cardAccountId, toTransaction.getToAccountId());
        assertNull(toTransaction.getFromCardId());
        assertEquals(card2.getId(), toTransaction.getToCardId());
        assertEquals(Double.valueOf(1.0), toTransaction.getFromAccountExchangeRate());
        assertEquals(Double.valueOf(1.0), toTransaction.getToAccountExchangeRate());
        assertNull(toTransaction.getFromCardExchangeRate());
        assertEquals(Double.valueOf(1.0), toTransaction.getToCardExchangeRate());
    }

    @Test
    public void getDepositSumByCard() throws Exception {

        final Double result1 = operationService.getDepositSumByCard(card1).get(TIMEOUT);
        assertEquals(Double.valueOf(0),result1);

        assertNotNull(operationService.createDepositOperation(card1, 100L, usd, "1111", "deposit1").get(TIMEOUT));
        assertNotNull(operationService.createDepositOperation(card1, 200L, usd, "2222", "deposit2").get(TIMEOUT));
        assertNotNull(operationService.createDepositOperation(card2, 300L, usd, "3333", "deposit3").get(TIMEOUT));

        final Double result2 = operationService.getDepositSumByCard(card1).get(TIMEOUT);

        assertEquals(Double.valueOf(300), result2);
    }
}
