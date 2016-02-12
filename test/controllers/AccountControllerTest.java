package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import model.Account;
import org.junit.After;
import org.junit.Test;
import play.libs.Json;
import play.libs.ws.WS;
import play.test.WithServer;
import repository.ConnectionPool;
import util.SecurityUtil;

import java.util.Date;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;

/**
 * @author ra created 12.02.2016.
 * @since 0.1.0
 */
public class AccountControllerTest extends WithServer {

    private Integer newAccountId;

    @Test
    public void retrieveById() throws Exception {
        final JsonNode response = retrieveById("42");

        assertEquals("0", response.get("code").asText());
        assertEquals("God account", response.get("account").get("name").asText());
    }

    @Test
    public void retrieveAll() throws Exception {
        final String url = "http://localhost:" + this.testServer.port() + "/api/account/list";
        final int timeout = 1000;

        final String accountId = "42";
        final String orderId = "1";
        final String enckey = SecurityUtil.generateKeyFromArray(accountId, orderId, "OMG");

        final JsonNode response = WS.url(url).setHeader("accountId", accountId).setHeader("enckey", enckey)
                .setHeader("orderId", orderId).get().get(timeout).asJson();

        assertEquals("0", response.get("code").asText());
        assertEquals(true, response.get("accounts").isArray());
    }

    @Test
    public void createAndUpdate() throws Exception {
        final String createUrl = "http://localhost:" + this.testServer.port() + "/api/account/create";
        final int timeout = 1000;

        newAccountId = 1;
        final String name = "test account";

        final Account account = new Account(newAccountId, name, "USD", null, true, "mySecret");

        final String accountId = "42";
        final String orderId = "1";
        final String enckey = SecurityUtil.generateKeyFromArray(accountId, account.getId().toString(), account.getName(), account.getCurrencyId(),
                orderId, "OMG");

        final JsonNode createResponse = WS.url(createUrl).setHeader("accountId", accountId).setHeader("enckey", enckey)
                .setHeader("orderId", orderId).post(Json.toJson(account)).get(timeout).asJson();

        assertEquals("0", createResponse.get("code").asText());

        final JsonNode afterCreateResponse = retrieveById(newAccountId.toString());
        assertEquals("0", afterCreateResponse.get("code").asText());
        assertEquals(name, afterCreateResponse.get("account").get("name").asText());

        final String updateUrl = "http://localhost:" + this.testServer.port() + "/api/account/update";

        final String updatedName = "new test name";
        account.setName(updatedName);
        account.setCreateDate(new Date());

        final String updateEnckey = SecurityUtil.generateKeyFromArray(accountId,
                account.getName(), account.getCurrencyId(), orderId, "OMG");
        final JsonNode updateResponse = WS.url(updateUrl).setHeader("accountId", accountId).setHeader("enckey", updateEnckey)
                .setHeader("orderId", orderId).post(Json.toJson(account)).get(timeout).asJson();
        assertEquals("0", updateResponse.get("code").asText());

        final JsonNode afterUpdateResponse = retrieveById(newAccountId.toString());
        assertEquals("0", afterUpdateResponse.get("code").asText());
        assertEquals(updatedName, afterUpdateResponse.get("account").get("name").asText());
    }

    private JsonNode retrieveById(String id) {
        final String url = "http://localhost:" + this.testServer.port() + "/api/account/get/" + id;
        final int timeout = 1000;

        final String accountId = "42";
        final String orderId = "1";
        final String enckey = SecurityUtil.generateKeyFromArray(accountId, id, orderId, "OMG");

        return WS.url(url).setHeader("accountId", accountId).setHeader("enckey", enckey)
                .setHeader("orderId", orderId).get().get(timeout).asJson();
    }

    @After
    public void clean() {
        final ConnectionPool connectionPool = app.injector().instanceOf(ConnectionPool.class);
        connectionPool.getConnection().query("delete from " + connectionPool.getSchemaName() + ".account where id=$1", asList(newAccountId),
                resultSet -> {
                }, throwable -> {
                    throwable.printStackTrace();
                });
    }
}
