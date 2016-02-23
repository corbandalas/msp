package controllers.admin;

import com.fasterxml.jackson.databind.JsonNode;
import controllers.BaseControllerTest;
import org.junit.Test;
import play.libs.ws.WS;
import util.SecurityUtil;

import static org.junit.Assert.assertEquals;
import static configs.ReturnCodes.SUCCESS_CODE;

/**
 * Test for CurrencyController
 *
 * @author nihilist created 12.02.2016.
 * @since 0.1.0
 */
public class CurrencyControllerTest extends BaseControllerTest {


    @Test
    public void retrieveById() throws Exception {
        String url = getAdminApiUrl("/currency/get/USD");
        final int timeout = 3000;

        final String enckey = SecurityUtil.generateKeyFromArray(ACCOUNT_ID + "USD" + ORDER_ID + SECRET);

        final JsonNode response = WS.url(url).setHeader("accountId", ACCOUNT_ID).setHeader("enckey", enckey)
                .setHeader("orderId", ORDER_ID).get().get(timeout).asJson();

        assertEquals("" + SUCCESS_CODE, response.get("code").asText());
        assertEquals("USD", response.get("currency").get("displayText").asText());
    }

    @Test
    public void retrieveAll() throws Exception {
        String url = getAdminApiUrl("/currency/list");
        final int timeout = 5000;

        final String enckey = SecurityUtil.generateKeyFromArray(ACCOUNT_ID + ORDER_ID + SECRET);

        final JsonNode response = WS.url(url).setHeader("accountId", ACCOUNT_ID).setHeader("enckey", enckey)
                .setHeader("orderId", ORDER_ID).get().get(timeout).asJson();

        assertEquals("" + SUCCESS_CODE, response.get("code").asText());
        assertEquals(true, response.get("currencyList").isArray());
    }

}
