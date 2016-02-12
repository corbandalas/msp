package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import model.Operation;
import model.Transaction;
import model.enums.OperationType;
import model.enums.TransactionType;
import org.junit.Test;
import play.libs.Json;
import play.libs.ws.WS;
import play.test.WithServer;
import util.SecurityUtil;

import java.util.Date;

import static junit.framework.TestCase.assertEquals;

/**
 * Holds transaction controller tests
 *
 * @author ra - created 12.02.2016.
 * @since 0.1.0
 */
public class TransactionControllerTest extends WithServer {

    @Test
    public void retrieveById() throws Exception {
        final String orderId = "xxx";
        final JsonNode createOperationResult = OperationControllerTest.create(new Operation(null, OperationType.DEPOSIT, orderId, "test operation", null), testServer.port());
        assertEquals("0", createOperationResult.get("code").asText());

        final long amount = 1000L;
        final JsonNode createResult = create(new Transaction(null, createOperationResult.get("operation").get("id").asLong(),
                amount, "USD", 42, 43, null, 1.0, 1.0, TransactionType.DEPOSIT));
        assertEquals("0", createResult.get("code").asText());

        final JsonNode result = retrieveById(createResult.get("transaction").get("id").asText());
        assertEquals("0", result.get("code").asText());
        assertEquals(amount, result.get("transaction").get("amount").asLong());
    }

    @Test
    public void retrieveAll() throws Exception {
        final String url = "http://localhost:" + this.testServer.port() + "/api/transaction/list";
        final int timeout = 1000;

        final String accountId = "42";
        final String orderId = "1";
        final String enckey = SecurityUtil.generateKeyFromArray(accountId, orderId, "OMG");

        final JsonNode result = WS.url(url).setHeader("accountId", accountId).setHeader("enckey", enckey)
                .setHeader("orderId", orderId).get().get(timeout).asJson();
        assertEquals("0", result.get("code").asText());
        assertEquals(true, result.get("transactionList").isArray());
    }

    @Test
    public void retrieveByOperationId() throws Exception {
        final String operationOrderId = "xxx";
        final JsonNode createOperationResult = OperationControllerTest.create(new Operation(null, OperationType.DEPOSIT, operationOrderId, "test operation", null), testServer.port());
        assertEquals("0", createOperationResult.get("code").asText());

        final JsonNode createResult1 = create(new Transaction(null, createOperationResult.get("operation").get("id").asLong(),
                1000L, "USD", 42, 43, null, 1.0, 1.0, TransactionType.DEPOSIT));
        assertEquals("0", createResult1.get("code").asText());
        final JsonNode createResult2 = create(new Transaction(null, createOperationResult.get("operation").get("id").asLong(),
                100L, "USD", 42, 43, null, 1.0, 1.0, TransactionType.DEPOSIT_FEE));
        assertEquals("0", createResult2.get("code").asText());

        final String operationId = createOperationResult.get("operation").get("id").asText();
        final String url = "http://localhost:" + this.testServer.port() + "/api/transaction/listByOperation/"
                + operationId;
        final int timeout = 1000;

        final String accountId = "42";
        final String orderId = "1";
        final String enckey = SecurityUtil.generateKeyFromArray(accountId, operationId, orderId, "OMG");

        final JsonNode result = WS.url(url).setHeader("accountId", accountId).setHeader("enckey", enckey)
                .setHeader("orderId", orderId).get().get(timeout).asJson();
        assertEquals("0", result.get("code").asText());
        assertEquals(2, result.get("transactionList").size());
    }

    @Test
    public void createAndUpdate() throws Exception {
        String operationOrderId = "xxx";
        final JsonNode createOperationResult = OperationControllerTest.create(new Operation(null, OperationType.DEPOSIT,
                operationOrderId, "test operation", null), testServer.port());

        final long amount = 1000L;
        final Transaction transaction = new Transaction(null, createOperationResult.get("operation").get("id").asLong(),
                amount, "USD", 42, 43, null, 1.0, 1.0, TransactionType.DEPOSIT);

        final JsonNode createResult = create(transaction);

        assertEquals("0", createResult.get("code").asText());

        final Long transactionId = createResult.get("transaction").get("id").asLong();
        final JsonNode afterCreate = retrieveById(transactionId.toString());
        assertEquals("0", afterCreate.get("code").asText());
        assertEquals(amount, afterCreate.get("transaction").get("amount").asLong());

        transaction.setId(transactionId);

        final long updatedAmount = 2000L;
        transaction.setAmount(updatedAmount);

        final String url = "http://localhost:" + this.testServer.port() + "/api/transaction/update";
        final int timeout = 1000;

        final String accountId = "42";
        final String orderId = "1";

        final String enckey = SecurityUtil.generateKeyFromArray(accountId, transaction.getId().toString(), transaction.getCurrencyId(),
                transaction.getAmount().toString(), transaction.getFromAccountId().toString(),
                transaction.getToAccountId().toString(), transaction.getFromExchangeRate().toString(),
                transaction.getToExchangeRate().toString(), transaction.getType().name(), orderId, "OMG");

        final JsonNode updateResult = WS.url(url).setHeader("accountId", accountId).setHeader("enckey", enckey)
                .setHeader("orderId", orderId).post(Json.toJson(transaction)).get(timeout).asJson();
        assertEquals("0", updateResult.get("code").asText());

        final JsonNode afterUpdate = retrieveById(transactionId.toString());
        assertEquals("0", afterUpdate.get("code").asText());
        assertEquals(updatedAmount, afterUpdate.get("transaction").get("amount").asLong());
    }

    private JsonNode retrieveById(String id) {
        final String url = "http://localhost:" + this.testServer.port() + "/api/transaction/get/" + id;
        final int timeout = 1000;

        final String accountId = "42";
        final String orderId = "1";
        final String enckey = SecurityUtil.generateKeyFromArray(accountId, id.toString(), orderId, "OMG");

        return WS.url(url).setHeader("accountId", accountId).setHeader("enckey", enckey)
                .setHeader("orderId", orderId).get().get(timeout).asJson();
    }

    private JsonNode create(Transaction transaction) {
        final String url = "http://localhost:" + this.testServer.port() + "/api/transaction/create";
        final int timeout = 1000;

        final String accountId = "42";
        final String orderId = "1";
        final String enckey = SecurityUtil.generateKeyFromArray(accountId, transaction.getCurrencyId(),
                transaction.getAmount().toString(), transaction.getFromAccountId().toString(),
                transaction.getToAccountId().toString(), transaction.getFromExchangeRate().toString(),
                transaction.getToExchangeRate().toString(), transaction.getType().name(), orderId, "OMG");

        return WS.url(url).setHeader("accountId", accountId).setHeader("enckey", enckey)
                .setHeader("orderId", orderId).post(Json.toJson(transaction)).get(timeout).asJson();
    }
}
