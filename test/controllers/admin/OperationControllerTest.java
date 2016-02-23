package controllers.admin;

import akka.dispatch.Futures;
import com.fasterxml.jackson.databind.JsonNode;
import controllers.BaseControllerTest;
import dto.OperationFilter;
import model.Operation;
import model.enums.OperationType;
import org.junit.After;
import org.junit.Test;
import play.libs.Json;
import play.libs.ws.WS;
import repository.ConnectionPool;
import scala.concurrent.Await;
import scala.concurrent.Promise;
import scala.concurrent.duration.Duration;
import util.SecurityUtil;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import static configs.ReturnCodes.SUCCESS_CODE;
import static junit.framework.TestCase.assertEquals;

/**
 * Holds operation controller tests
 *
 * @author ra - created 12.02.2016.
 * @since 0.1.0
 */
public class OperationControllerTest extends BaseControllerTest {

    @Test
    public void retrieveById() throws Exception {
        final String orderId = "xxx";
        final JsonNode createResult = createOperation(new Operation(null, OperationType.DEPOSIT, orderId, "test operation", null), this.testServer.port());
        assertEquals(String.valueOf(SUCCESS_CODE), createResult.get("code").asText());

        final JsonNode result = retrieveById(createResult.get("operation").get("id").asText());
        assertEquals(String.valueOf(SUCCESS_CODE), result.get("code").asText());
        assertEquals(orderId, result.get("operation").get("orderId").asText());
    }

    @Test
    public void retrieveAll() throws Exception {
        final String url = getAdminApiUrl("/operation/list");
        final String enckey = SecurityUtil.generateKeyFromArray(ACCOUNT_ID, ORDER_ID, SECRET);

        final JsonNode result = WS.url(url).setHeader("accountId", ACCOUNT_ID).setHeader("enckey", enckey)
                .setHeader("orderId", ORDER_ID).get().get(TIMEOUT).asJson();
        assertEquals(String.valueOf(SUCCESS_CODE), result.get("code").asText());
        assertEquals(true, result.get("operationList").isArray());
    }

    @Test
    public void retrieveFiltered() throws Exception {
        final String url = getAdminApiUrl("/operation/list/filtered");

        final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

        final OperationFilter filter = new OperationFilter();
        filter.setDateFrom(simpleDateFormat.format(new Date()));
        final Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_MONTH, 1);
        filter.setDateTo(simpleDateFormat.format(calendar.getTime()));

        final String enckey = SecurityUtil.generateKeyFromArray(ACCOUNT_ID, filter.getDateFrom(), filter.getDateTo(), ORDER_ID, SECRET);

        final JsonNode result = WS.url(url).setHeader("accountId", ACCOUNT_ID).setHeader("enckey", enckey)
                .setHeader("orderId", ORDER_ID).post(Json.toJson(filter)).get(TIMEOUT).asJson();
        assertEquals(String.valueOf(SUCCESS_CODE), result.get("code").asText());
        assertEquals(true, result.get("operationList").isArray());

        filter.setType(OperationType.DEPOSIT.name());

        final JsonNode resultWithType = WS.url(url).setHeader("accountId", ACCOUNT_ID).setHeader("enckey", enckey)
                .setHeader("orderId", ORDER_ID).post(Json.toJson(filter)).get(TIMEOUT).asJson();
        assertEquals(String.valueOf(SUCCESS_CODE), resultWithType.get("code").asText());
        assertEquals(true, resultWithType.get("operationList").isArray());
    }

    @Test
    public void createAndUpdate() throws Exception {
        String operationOrderId = "xxx";
        final Operation operation = new Operation(null, OperationType.DEPOSIT, operationOrderId, "test operation", null);
        final JsonNode createResult = createOperation(operation, this.testServer.port());

        assertEquals(String.valueOf(SUCCESS_CODE), createResult.get("code").asText());

        final JsonNode afterCreate = retrieveById(createResult.get("operation").get("id").asText());
        assertEquals(String.valueOf(SUCCESS_CODE), afterCreate.get("code").asText());
        assertEquals(operationOrderId, afterCreate.get("operation").get("orderId").asText());

        operation.setId(createResult.get("operation").get("id").asLong());
        operation.setCreateDate(new Date());
        final String updatedDescription = "updated test operation";
        operation.setDescription(updatedDescription);

        final String url = getAdminApiUrl("/operation/update");

        final String updateEnckey = SecurityUtil.generateKeyFromArray(ACCOUNT_ID, operation.getId().toString(), operation.getOrderId(), operation.getDescription(),
                operation.getType().name(), ORDER_ID, SECRET);

        final JsonNode updateResult = WS.url(url).setHeader("accountId", ACCOUNT_ID).setHeader("enckey", updateEnckey)
                .setHeader("orderId", ORDER_ID).post(Json.toJson(operation)).get(TIMEOUT).asJson();
        assertEquals(String.valueOf(SUCCESS_CODE), updateResult.get("code").asText());

        final JsonNode afterUpdate = retrieveById(operation.getId().toString());
        assertEquals(String.valueOf(SUCCESS_CODE), afterUpdate.get("code").asText());
        assertEquals(updatedDescription, afterUpdate.get("operation").get("description").asText());
    }

    private JsonNode retrieveById(String id) {
        final String url = getAdminApiUrl("/operation/get/" + id);
        final String enckey = SecurityUtil.generateKeyFromArray(ACCOUNT_ID, id.toString(), ORDER_ID, SECRET);

        return WS.url(url).setHeader("accountId", ACCOUNT_ID).setHeader("enckey", enckey)
                .setHeader("orderId", ORDER_ID).get().get(TIMEOUT).asJson();
    }


    @After
    public void clean() throws Exception {
        final ConnectionPool connectionPool = app.injector().instanceOf(ConnectionPool.class);
        final Promise<Object> promise = Futures.promise();
        connectionPool.getConnection().query("delete from " + connectionPool.getSchemaName() + ".operation;",
                promise::success, promise::failure);
        Await.result(promise.future(), Duration.apply(TIMEOUT, "ms"));
    }

}
