package controllers.admin;

import com.fasterxml.jackson.databind.JsonNode;
import controllers.BaseControllerTest;
import org.junit.Test;
import play.libs.ws.WS;
import util.SecurityUtil;

import static configs.ReturnCodes.SUCCESS_CODE;
import static org.junit.Assert.assertEquals;

/**
 * Test for ExchangeRateHistoryController
 *
 * @author nihilist created 12.02.2016.
 * @since 0.1.0
 */
public class ExchangeRateHistoryControllerTest extends BaseControllerTest {

    @Test
    public void retrieveByCurrencyID() throws Exception {
        String url = getAdminApiUrl("/exchangeRateHistory/get/USD");
        final int timeout = 5000;

        final String enckey = SecurityUtil.generateKeyFromArray(ACCOUNT_ID + "USD", ORDER_ID + SECRET);

        final JsonNode response = WS.url(url).setHeader("accountId", ACCOUNT_ID).setHeader("enckey", enckey)
                .setHeader("orderId", ORDER_ID).get().get(timeout).asJson();

        assertEquals(String.valueOf(SUCCESS_CODE), response.get("code").asText());
        assertEquals(true, response.get("exchangeRateHistoryList").isArray());
    }


}
