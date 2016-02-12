package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import model.Operation;
import model.enums.OperationType;
import org.junit.Test;
import play.libs.Json;
import play.libs.ws.WS;
import play.test.WithServer;
import util.SecurityUtil;

import java.util.Date;

import static junit.framework.TestCase.assertEquals;

/**
 * Holds operation controller tests
 *
 * @author ra - created 12.02.2016.
 * @since 0.1.0
 */
public class OperationControllerTest extends WithServer {

    @Test
    public void retrieveById() throws Exception {
        final String orderId = "xxx";
        final JsonNode createResult = create(new Operation(null, OperationType.DEPOSIT, orderId, "test operation", null));
        assertEquals("0", createResult.get("code").asText());

        final JsonNode result = retrieveById(createResult.get("operation").get("id").asText());
        assertEquals("0", result.get("code").asText());
        assertEquals(orderId, result.get("operation").get("orderId").asText());
    }

    @Test
    public void retrieveAll() throws Exception {
        final java.lang.String url = "http://localhost:" + this.testServer.port() + "/api/operation/list";
        final int timeout = 1000;

        final java.lang.String accountId = "42";
        final java.lang.String orderId = "1";
        final java.lang.String enckey = SecurityUtil.generateKeyFromArray(accountId, orderId, "OMG");

        final JsonNode result = WS.url(url).setHeader("accountId", accountId).setHeader("enckey", enckey)
                .setHeader("orderId", orderId).get().get(timeout).asJson();
        assertEquals("0", result.get("code").asText());
        assertEquals(true, result.get("operationList").isArray());
    }

    @Test
    public void createAndUpdate() throws Exception {
        String operationOrderId="xxx";
        final Operation operation = new Operation(null, OperationType.DEPOSIT, operationOrderId, "test operation", null);
        final JsonNode createResult = create(operation);

        assertEquals("0", createResult.get("code").asText());

        final JsonNode afterCreate = retrieveById(createResult.get("operation").get("id").asText());
        assertEquals("0", afterCreate.get("code").asText());
        assertEquals(operationOrderId, afterCreate.get("operation").get("orderId").asText());

        operation.setId(createResult.get("operation").get("id").asLong());
        operation.setCreateDate(new Date());
        final String updatedDescription = "updated test operation";
        operation.setDescription(updatedDescription);

        final java.lang.String url = "http://localhost:" + this.testServer.port() + "/api/operation/update";
        final int timeout = 1000;

        final java.lang.String accountId = "42";
        final java.lang.String orderId = "1";
        final java.lang.String enckey = SecurityUtil.generateKeyFromArray(accountId, operation.getOrderId(), operation.getDescription(),
                operation.getType().name(), orderId, "OMG");

        final String updateEnckey = SecurityUtil.generateKeyFromArray(accountId, operation.getId().toString(), operation.getOrderId(), operation.getDescription(),
                operation.getType().name(), orderId, "OMG");

        final JsonNode updateResult = WS.url(url).setHeader("accountId", accountId).setHeader("enckey", updateEnckey)
                .setHeader("orderId", orderId).post(Json.toJson(operation)).get(timeout).asJson();
        assertEquals("0", updateResult.get("code").asText());

        final JsonNode afterUpdate = retrieveById(operation.getId().toString());
        assertEquals("0", afterUpdate.get("code").asText());
        assertEquals(updatedDescription, afterUpdate.get("operation").get("description").asText());
    }

    private JsonNode retrieveById(String id) {
        final java.lang.String url = "http://localhost:" + this.testServer.port() + "/api/operation/get/" + id;
        final int timeout = 1000;

        final java.lang.String accountId = "42";
        final java.lang.String orderId = "1";
        final java.lang.String enckey = SecurityUtil.generateKeyFromArray(accountId, id.toString(), orderId, "OMG");

        return WS.url(url).setHeader("accountId", accountId).setHeader("enckey", enckey)
                .setHeader("orderId", orderId).get().get(timeout).asJson();
    }

    private JsonNode create(Operation operation) {
        final java.lang.String url = "http://localhost:" + this.testServer.port() + "/api/operation/create";
        final int timeout = 1000;

        final java.lang.String accountId = "42";
        final java.lang.String orderId = "1";
        final java.lang.String enckey = SecurityUtil.generateKeyFromArray(accountId, operation.getOrderId(), operation.getDescription(),
                operation.getType().name(), orderId, "OMG");

        return WS.url(url).setHeader("accountId", accountId).setHeader("enckey", enckey)
                .setHeader("orderId", orderId).post(Json.toJson(operation)).get(timeout).asJson();
    }
}
