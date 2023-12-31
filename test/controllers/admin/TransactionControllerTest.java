package controllers.admin;

import akka.dispatch.Futures;
import com.fasterxml.jackson.databind.JsonNode;
import controllers.BaseControllerTest;
import model.Operation;
import model.Transaction;
import model.enums.OperationType;
import model.enums.TransactionType;
import org.junit.After;
import org.junit.Test;
import play.libs.Json;
import play.libs.ws.WS;
import repository.ConnectionPool;
import scala.concurrent.Await;
import scala.concurrent.Promise;
import scala.concurrent.duration.Duration;
import util.SecurityUtil;

import static configs.ReturnCodes.SUCCESS_CODE;
import static junit.framework.TestCase.assertEquals;

/**
 * Holds transaction controller tests
 *
 * @author ra - created 12.02.2016.
 * @since 0.1.0
 */
public class TransactionControllerTest extends BaseControllerTest {

    @Test
    public void retrieveById() throws Exception {
        final String orderId = "xxx";
        final JsonNode createOperationResult = createOperation(new Operation(null, OperationType.DEPOSIT, orderId, "test operation", null), testServer.port());
        assertEquals(String.valueOf(SUCCESS_CODE), createOperationResult.get("code").asText());

        final long amount = 1000L;
        final JsonNode createResult = create(new Transaction(null, createOperationResult.get("operation").get("id").asLong(),
                amount, "USD", Integer.valueOf(ACCOUNT_ID), Integer.valueOf(ACCOUNT_2_ID), null, null, 1.0, 1.0, null, 1.0, TransactionType.DEPOSIT));
        assertEquals(String.valueOf(SUCCESS_CODE), createResult.get("code").asText());

        final JsonNode result = retrieveById(createResult.get("transaction").get("id").asText());
        assertEquals(String.valueOf(SUCCESS_CODE), result.get("code").asText());
        assertEquals(amount, result.get("transaction").get("amount").asLong());
    }

    @Test
    public void retrieveAll() throws Exception {
        final String url = getAdminApiUrl("/transaction/list");

        final String enckey = SecurityUtil.generateKeyFromArray(ACCOUNT_ID, ORDER_ID, SECRET);

        final JsonNode result = WS.url(url).setHeader("accountId", ACCOUNT_ID).setHeader("enckey", enckey)
                .setHeader("orderId", ORDER_ID).get().get(TIMEOUT).asJson();
        assertEquals(String.valueOf(SUCCESS_CODE), result.get("code").asText());
        assertEquals(true, result.get("transactionList").isArray());
    }

    @Test
    public void retrieveByOperationId() throws Exception {
        final String operationOrderId = "xxx";
        final JsonNode createOperationResult = createOperation(new Operation(null, OperationType.DEPOSIT, operationOrderId, "test operation", null), testServer.port());
        assertEquals(String.valueOf(SUCCESS_CODE), createOperationResult.get("code").asText());

        final JsonNode createResult1 = create(new Transaction(null, createOperationResult.get("operation").get("id").asLong(),
                1000L, "USD", Integer.valueOf(ACCOUNT_ID), Integer.valueOf(ACCOUNT_2_ID), null, null, 1.0, 1.0, null, 1.0, TransactionType.DEPOSIT));
        assertEquals(String.valueOf(SUCCESS_CODE), createResult1.get("code").asText());
        final JsonNode createResult2 = create(new Transaction(null, createOperationResult.get("operation").get("id").asLong(),
                100L, "USD", Integer.valueOf(ACCOUNT_ID), Integer.valueOf(ACCOUNT_2_ID), null, null, 1.0, 1.0, null, null, TransactionType.DEPOSIT_FEE));
        assertEquals(String.valueOf(SUCCESS_CODE), createResult2.get("code").asText());

        final String operationId = createOperationResult.get("operation").get("id").asText();
        final String url = getAdminApiUrl("/transaction/listByOperation/"
                + operationId);

        final String enckey = SecurityUtil.generateKeyFromArray(ACCOUNT_ID, operationId, ORDER_ID, SECRET);

        final JsonNode result = WS.url(url).setHeader("accountId", ACCOUNT_ID).setHeader("enckey", enckey)
                .setHeader("orderId", ORDER_ID).get().get(TIMEOUT).asJson();
        assertEquals(String.valueOf(SUCCESS_CODE), result.get("code").asText());
        assertEquals(2, result.get("transactionList").size());
    }

    @Test
    public void createAndUpdate() throws Exception {
        String operationOrderId = "xxx";
        final JsonNode createOperationResult = createOperation(new Operation(null, OperationType.DEPOSIT,
                operationOrderId, "test operation", null), testServer.port());

        final long amount = 1000L;
        final Transaction transaction = new Transaction(null, createOperationResult.get("operation").get("id").asLong(),
                amount, "USD", Integer.valueOf(ACCOUNT_ID), Integer.valueOf(ACCOUNT_2_ID), null, null, 1.0, 1.0, null, 1.0, TransactionType.DEPOSIT);

        final JsonNode createResult = create(transaction);

        assertEquals(String.valueOf(SUCCESS_CODE), createResult.get("code").asText());

        final Long transactionId = createResult.get("transaction").get("id").asLong();
        final JsonNode afterCreate = retrieveById(transactionId.toString());
        assertEquals(String.valueOf(SUCCESS_CODE), afterCreate.get("code").asText());
        assertEquals(amount, afterCreate.get("transaction").get("amount").asLong());

        transaction.setId(transactionId);

        final long updatedAmount = 2000L;
        transaction.setAmount(updatedAmount);

        final String url = getAdminApiUrl("/transaction/update");

        final String enckey = SecurityUtil.generateKeyFromArray(ACCOUNT_ID, transaction.getId().toString(), transaction.getCurrencyId(),
                transaction.getAmount().toString(), transaction.getFromAccountId().toString(),
                transaction.getToAccountId().toString(), transaction.getFromAccountExchangeRate().toString(),
                transaction.getToAccountExchangeRate().toString(), transaction.getType().name(), ORDER_ID, SECRET);

        final JsonNode updateResult = WS.url(url).setHeader("accountId", ACCOUNT_ID).setHeader("enckey", enckey)
                .setHeader("orderId", ORDER_ID).post(Json.toJson(transaction)).get(TIMEOUT).asJson();
        assertEquals(String.valueOf(SUCCESS_CODE), updateResult.get("code").asText());

        final JsonNode afterUpdate = retrieveById(transactionId.toString());
        assertEquals(String.valueOf(SUCCESS_CODE), afterUpdate.get("code").asText());
        assertEquals(updatedAmount, afterUpdate.get("transaction").get("amount").asLong());
    }

    private JsonNode retrieveById(String id) {
        final String url = getAdminApiUrl("/transaction/get/" + id);
        final String enckey = SecurityUtil.generateKeyFromArray(ACCOUNT_ID, id, ORDER_ID, SECRET);

        return WS.url(url).setHeader("accountId", ACCOUNT_ID).setHeader("enckey", enckey)
                .setHeader("orderId", ORDER_ID).get().get(TIMEOUT).asJson();
    }

    private JsonNode create(Transaction transaction) {
        final String url = getAdminApiUrl("/transaction/create");
        final String enckey = SecurityUtil.generateKeyFromArray(ACCOUNT_ID, transaction.getCurrencyId(),
                transaction.getAmount().toString(), transaction.getFromAccountId().toString(),
                transaction.getToAccountId().toString(), transaction.getFromAccountExchangeRate().toString(),
                transaction.getToAccountExchangeRate().toString(), transaction.getType().name(), ORDER_ID, SECRET);

        return WS.url(url).setHeader("accountId", ACCOUNT_ID).setHeader("enckey", enckey)
                .setHeader("orderId", ORDER_ID).post(Json.toJson(transaction)).get(TIMEOUT).asJson();
    }


    @After
    public void clean() throws Exception {
        final ConnectionPool connectionPool = app.injector().instanceOf(ConnectionPool.class);
        final Promise<Object> promise = Futures.promise();
        connectionPool.getConnection().query("delete from " + connectionPool.getSchemaName() + ".transaction; delete from " + connectionPool.getSchemaName() + ".operation; delete from " + connectionPool.getSchemaName() + ".account;",
                promise::success, promise::failure);
        Await.result(promise.future(), Duration.apply(TIMEOUT, "ms"));
    }

}
