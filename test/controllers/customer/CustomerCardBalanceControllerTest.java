package controllers.customer;

import com.fasterxml.jackson.databind.JsonNode;
import dto.customer.CustomerCardBalanceResponse;
import dto.customer.CustomerCardListResponse;
import org.junit.Test;
import play.Logger;
import play.libs.Json;
import play.libs.ws.WS;

import static configs.ReturnCodes.*;
import static org.junit.Assert.*;

/**
 * API customer card list tests
 *
 * @author corbandalas created 01.03.2016.
 * @since 0.2.0
 */
public class CustomerCardBalanceControllerTest extends BaseCustomerControllerTest {

    @Test
    public void balance() throws Exception {

        final JsonNode authorizeResponse = authorizeCustomer(PHONE_2, PASSWORD_2);
        assertEquals("" + SUCCESS_CODE, authorizeResponse.get("code").asText());

        final String token = authorizeResponse.get("token").asText();

        final JsonNode cardListResponse = WS.url(getCustomerApiUrl("/card/list")).setHeader("token", token)
                .get().get(TIMEOUT).asJson();

        assertEquals("" + SUCCESS_CODE, cardListResponse.get("code").asText());


        try {
            CustomerCardListResponse customerCardListResponse = Json.fromJson(cardListResponse, CustomerCardListResponse.class);

            assertTrue(customerCardListResponse.getList().size() == 2);
            assertTrue(customerCardListResponse.getList().get(0).getCardDetails().getCurrency().equals("EUR"));
            assertNotNull(customerCardListResponse.getList().get(1).getId());

            CustomerCardListResponse.CardWrapper cardWrapper = customerCardListResponse.getList().get(0);

            JsonNode jNode = WS.url(getCustomerApiUrl("/card/balance/" + cardWrapper.getId())).setHeader("token", token)
                    .get().get(TIMEOUT).asJson();

            assertEquals("" + SUCCESS_CODE, jNode.get("code").asText());

            CustomerCardBalanceResponse customerCardBalanceResponse = Json.fromJson(jNode, CustomerCardBalanceResponse.class);


            assertNotNull(customerCardBalanceResponse);

            assertNotNull(customerCardBalanceResponse.getAvailableBalance());
            assertEquals(customerCardBalanceResponse.getCurrency(), "EUR");


            JsonNode resp = WS.url(getCustomerApiUrl("/card/balance/" + 123)).setHeader("token", token)
                    .get().get(TIMEOUT).asJson();

            assertEquals("" + INCORRECT_CARD_CODE, resp.get("code").asText());


        } catch (Exception e) {
            Logger.error("Wrong request format: ", e);
            fail();
        }
    }

}
