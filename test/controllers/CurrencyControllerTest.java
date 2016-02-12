package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import org.junit.After;
import org.junit.Test;
import play.libs.ws.WS;
import play.test.WithServer;
import repository.ConnectionPool;
import util.SecurityUtil;

import static org.junit.Assert.assertEquals;

/**
 *
 * Test for CurrencyController
 *
 * @author nihilist created 12.02.2016.
 * @since 0.1.0
 */
public class CurrencyControllerTest extends WithServer {


    @Test
    public void retrieveById() throws Exception {
        String url = "http://localhost:" + this.testServer.port() + "/api/currency/get/USD";
        final int timeout = 3000;

        final String accountId="42";
        final String orderId="1";
        final String enckey= SecurityUtil.generateKeyFromArray(accountId+"USD"+orderId+"OMG");

        final JsonNode response = WS.url(url).setHeader("accountId", accountId).setHeader("enckey", enckey)
                .setHeader("orderId", orderId).get().get(timeout).asJson();

        assertEquals("0",response.get("code").asText());
        assertEquals("USD",response.get("currency").get("displayText").asText());
    }

    @Test
    public void retrieveAll() throws Exception {
        String url = "http://localhost:" + this.testServer.port() + "/api/currency/list";
        final int timeout = 5000;

        final String accountId="42";
        final String orderId="1";
        final String enckey= SecurityUtil.generateKeyFromArray(accountId+orderId+"OMG");

        final JsonNode response = WS.url(url).setHeader("accountId", accountId).setHeader("enckey", enckey)
                .setHeader("orderId", orderId).get().get(timeout).asJson();

        assertEquals("0",response.get("code").asText());
        assertEquals(true,response.get("currencyList").isArray());
    }

    @Test
    public void update() throws Exception {
        //TODO: later...
    }

    @Test
    public void exchange() throws Exception {
        //TODO: later...
    }

}
