import com.fasterxml.jackson.databind.JsonNode;
import org.junit.Test;
import play.libs.ws.WS;
import play.test.WithServer;
import util.SecurityUtil;

import static org.junit.Assert.assertEquals;

/**
 * @author ra created 12.02.2016.
 * @since 0.1.0
 */
public class AccountControllerTest extends WithServer {

    @Test
    public void retrieveById() throws Exception {
        String url = "http://localhost:" + this.testServer.port() + "/api/account/get/42";
        final int timeout = 1000;

        final String accountId="42";
        final String orderId="1";
        final String enckey= SecurityUtil.generateKeyFromArray(accountId+"42"+orderId+"OMG");

        final JsonNode response = WS.url(url).setHeader("accountId", accountId).setHeader("enckey", enckey)
                .setHeader("orderId", orderId).get().get(timeout).asJson();

        assertEquals("God account",response.get("account").get("name").asText());
    }
}
