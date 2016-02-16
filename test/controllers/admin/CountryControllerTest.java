package controllers.admin;

import com.fasterxml.jackson.databind.JsonNode;
import controllers.BaseControllerTest;
import org.junit.Test;
import play.libs.ws.WS;
import util.SecurityUtil;

import static org.junit.Assert.assertEquals;

/**
 * Test for CountryController
 *
 * @author nihilist created 12.02.2016.
 * @since 0.1.0
 */
public class CountryControllerTest extends BaseControllerTest {

    @Test
    public void retrieveById() throws Exception {
        String url = getAdminApiUrl("/country/get/UA");
        final int timeout = 5000;

        final String enckey = SecurityUtil.generateKeyFromArray(ACCOUNT_ID + "UA" + ORDER_ID + SECRET);

        final JsonNode response = WS.url(url).setHeader("accountId", ACCOUNT_ID).setHeader("enckey", enckey)
                .setHeader("orderId", ORDER_ID).get().get(timeout).asJson();

        assertEquals("0", response.get("code").asText());
        assertEquals("380", response.get("country").get("phoneCode").asText());
    }

    @Test
    public void retrieveAll() throws Exception {
        String url = getAdminApiUrl("/country/list");
        final int timeout = 10000;

        final String enckey = SecurityUtil.generateKeyFromArray(ACCOUNT_ID + ORDER_ID + SECRET);

        final JsonNode response = WS.url(url).setHeader("accountId", ACCOUNT_ID).setHeader("enckey", enckey)
                .setHeader("orderId", ORDER_ID).get().get(timeout).asJson();

        assertEquals("0", response.get("code").asText());
        assertEquals(true, response.get("countryList").isArray());
    }

    @Test
    public void retrieveActive() throws Exception {
        String url = getAdminApiUrl("/country/list/active");
        final int timeout = 10000;

        final String enckey = SecurityUtil.generateKeyFromArray(ACCOUNT_ID + ORDER_ID + SECRET);

        final JsonNode response = WS.url(url).setHeader("accountId", ACCOUNT_ID).setHeader("enckey", enckey)
                .setHeader("orderId", ORDER_ID).get().get(timeout).asJson();

        assertEquals("0", response.get("code").asText());
        assertEquals(true, response.get("countryList").isArray());
    }
}
