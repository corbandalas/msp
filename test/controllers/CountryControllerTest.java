package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import org.junit.After;
import org.junit.Test;
import play.libs.ws.WS;
import play.test.WithServer;
import repository.ConnectionPool;
import util.SecurityUtil;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;

/**
 *
 * Test for CountryController
 *
 * @author nihilist created 12.02.2016.
 * @since 0.1.0
 */
public class CountryControllerTest extends WithServer {

    private Integer newAccountId;

    @Test
    public void retrieveById() throws Exception {
        String url = "http://localhost:" + this.testServer.port() + "/api/country/get/UA";
        final int timeout = 5000;

        final String accountId="42";
        final String orderId="1";
        final String enckey= SecurityUtil.generateKeyFromArray(accountId+"UA"+orderId+"OMG");

        final JsonNode response = WS.url(url).setHeader("accountId", accountId).setHeader("enckey", enckey)
                .setHeader("orderId", orderId).get().get(timeout).asJson();

        assertEquals("0",response.get("code").asText());
        assertEquals("380",response.get("country").get("phoneCode").asText());
    }

    @Test
    public void retrieveAll() throws Exception {
        String url = "http://localhost:" + this.testServer.port() + "/api/country/list";
        final int timeout = 10000;

        final String accountId="42";
        final String orderId="1";
        final String enckey= SecurityUtil.generateKeyFromArray(accountId+orderId+"OMG");

        final JsonNode response = WS.url(url).setHeader("accountId", accountId).setHeader("enckey", enckey)
                .setHeader("orderId", orderId).get().get(timeout).asJson();

        assertEquals("0",response.get("code").asText());
        assertEquals(true,response.get("countryList").isArray());
    }

    @Test
    public void update() throws Exception {
        //TODO: later...
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
