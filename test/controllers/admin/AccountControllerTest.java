package controllers.admin;

import akka.dispatch.Futures;
import com.fasterxml.jackson.databind.JsonNode;
import configs.ReturnCodes;
import controllers.BaseControllerTest;
import model.Account;
import org.junit.After;
import org.junit.Test;
import play.libs.Json;
import play.libs.ws.WS;
import repository.ConnectionPool;
import scala.concurrent.Await;
import scala.concurrent.Promise;
import scala.concurrent.duration.Duration;
import util.SecurityUtil;

import java.util.Date;

import static configs.ReturnCodes.SUCCESS_CODE;
import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;

/**
 * Holds operation controller tests
 *
 * @author ra created 12.02.2016.
 * @since 0.1.0
 */
public class AccountControllerTest extends BaseControllerTest {

    private Integer newAccountId;

    @Test
    public void retrieveById() throws Exception {
        final JsonNode response = retrieveById(ACCOUNT_ID);

        assertEquals(String.valueOf(SUCCESS_CODE), response.get("code").asText());
        assertEquals(ACCOUNT_NAME, response.get("account").get("name").asText());
    }

    @Test
    public void retrieveAll() throws Exception {
        final String url = getAdminApiUrl("/account/list");

        final String enckey = SecurityUtil.generateKeyFromArray(ACCOUNT_ID, ORDER_ID, SECRET);

        final JsonNode response = WS.url(url).setHeader("accountId", ACCOUNT_ID).setHeader("enckey", enckey)
                .setHeader("orderId", ORDER_ID).get().get(TIMEOUT).asJson();

        assertEquals(String.valueOf(SUCCESS_CODE), response.get("code").asText());
        assertEquals(true, response.get("accounts").isArray());
    }

    @Test
    public void createAndUpdate() throws Exception {
        newAccountId = 1;
        final String name = "test account";

        final Account account = new Account(newAccountId, name, "USD", null, true, "mySecret");

        final JsonNode createResponse = createAccount(account);
        assertEquals(String.valueOf(SUCCESS_CODE), createResponse.get("code").asText());

        final JsonNode afterCreateResponse = retrieveById(newAccountId.toString());
        assertEquals(String.valueOf(SUCCESS_CODE), afterCreateResponse.get("code").asText());
        assertEquals(name, afterCreateResponse.get("account").get("name").asText());

        final String updateUrl = getAdminApiUrl("/account/update");

        final String updatedName = "new test name";
        account.setName(updatedName);
        account.setCreateDate(new Date());

        final String updateEnckey = SecurityUtil.generateKeyFromArray(ACCOUNT_ID,
                account.getName(), account.getCurrencyId(), ORDER_ID, SECRET);
        final JsonNode updateResponse = WS.url(updateUrl).setHeader("accountId", ACCOUNT_ID).setHeader("enckey", updateEnckey)
                .setHeader("orderId", ORDER_ID).post(Json.toJson(account)).get(TIMEOUT).asJson();
        assertEquals(String.valueOf(SUCCESS_CODE), updateResponse.get("code").asText());

        final JsonNode afterUpdateResponse = retrieveById(newAccountId.toString());
        assertEquals(String.valueOf(SUCCESS_CODE), afterUpdateResponse.get("code").asText());
        assertEquals(updatedName, afterUpdateResponse.get("account").get("name").asText());
    }

    private JsonNode retrieveById(String id) {
        final String url = getAdminApiUrl("/account/get/" + id);

        final String enckey = SecurityUtil.generateKeyFromArray(ACCOUNT_ID, id, ORDER_ID, SECRET);

        return WS.url(url).setHeader("accountId", ACCOUNT_ID).setHeader("enckey", enckey)
                .setHeader("orderId", ORDER_ID).get().get(TIMEOUT).asJson();
    }

    @After
    public void clean() throws Exception {
        final ConnectionPool connectionPool = app.injector().instanceOf(ConnectionPool.class);
        final Promise<Object> promise = Futures.promise();
        connectionPool.getConnection().query("delete from " + connectionPool.getSchemaName() + ".account where id=$1", asList(newAccountId),
                promise::success, promise::failure);
        Await.result(promise.future(), Duration.apply(TIMEOUT,"ms"));
    }
}
