package controllers.customer;

import com.fasterxml.jackson.databind.JsonNode;
import org.junit.Test;
import play.libs.ws.WS;

import static configs.ReturnCodes.SUCCESS_CODE;
import static org.junit.Assert.assertEquals;

/**
 * API customer card list tests
 *
 * @author corbandalas created 01.03.2016.
 * @since 0.2.0
 */
public class CustomerCardListControllerTest extends BaseCustomerControllerTest {

    @Test
    public void list() throws Exception {

        final JsonNode authorizeResponse = authorizeCustomer(PHONE_1, PASSWORD_1);
        assertEquals("" + SUCCESS_CODE, authorizeResponse.get("code").asText());

        final String token = authorizeResponse.get("token").asText();

        final JsonNode cardListResponse = WS.url(getCustomerApiUrl("/card/list")).setHeader("token", token)
                .get().get(TIMEOUT).asJson();

        assertEquals("" + SUCCESS_CODE, cardListResponse.get("code").asText());
    }

}
