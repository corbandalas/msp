package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import org.junit.Test;
import play.libs.ws.WS;
import play.test.WithServer;
import util.SecurityUtil;

import static org.junit.Assert.assertEquals;

/**
 *
 * Test for ExchangeRateHistoryController
 *
 * @author nihilist created 12.02.2016.
 * @since 0.1.0
 */
public class ExchangeRateHistoryControllerTest extends WithServer {

    @Test
    public void retrieveByCurrencyID() throws Exception {
        String url = "http://localhost:" + this.testServer.port() + "/api/exchangeRateHistory/get/USD";
        final int timeout = 5000;

        final String accountId="42";
        final String orderId="1";
        final String enckey= SecurityUtil.generateKeyFromArray(accountId+"USD",orderId+"OMG");

        final JsonNode response = WS.url(url).setHeader("accountId", accountId).setHeader("enckey", enckey)
                .setHeader("orderId", orderId).get().get(timeout).asJson();

        assertEquals("0",response.get("code").asText());
        assertEquals(true,response.get("exchangeRateHistoryList").isArray());
    }


}
