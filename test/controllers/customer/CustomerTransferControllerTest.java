package controllers.customer;

import com.fasterxml.jackson.databind.JsonNode;
import dto.customer.CustomerCardListResponse;
import dto.customer.CustomerTransferOwnCards;
import model.Account;
import org.junit.Test;
import play.libs.Json;
import play.libs.ws.WS;

import static configs.ReturnCodes.INCORRECT_CARD_CODE;
import static configs.ReturnCodes.SUCCESS_CODE;
import static org.junit.Assert.assertEquals;

/**
 * API customer transfer controller tests
 * @author ra created 19.02.2016.
 * @since 0.1.0
 */
public class CustomerTransferControllerTest extends BaseCustomerControllerTest {

    @Test
    public void transferOwnWrongCard() throws Exception {
        final JsonNode authorizeResponse = authorizeCustomer(PHONE_1, PASSWORD_1);
        assertEquals("" + SUCCESS_CODE, authorizeResponse.get("code").asText());

        final String token = authorizeResponse.get("token").asText();

        final CustomerTransferOwnCards request = new CustomerTransferOwnCards();
        request.setAmount(1000L);
        request.setCurrency("USD");
        request.setCardFrom(0L);
        request.setCardTo(1L);
        request.setDescription("test transfer");
        request.setOrderId("xxxx");

        final JsonNode transferResponse = WS.url(getCustomerApiUrl("/transfer/own")).setHeader("token", token)
                .post(Json.toJson(request)).get(TIMEOUT).asJson();

        assertEquals("" + INCORRECT_CARD_CODE,transferResponse.get("code").asText());
    }

    @Test
    public void transferOwn() throws Exception {
        final JsonNode authorizeResponse = authorizeCustomer(PHONE_1, PASSWORD_1);
        assertEquals("" + SUCCESS_CODE, authorizeResponse.get("code").asText());

        final String token = authorizeResponse.get("token").asText();

        final JsonNode cardListResponse = WS.url(getCustomerApiUrl("/card/list")).setHeader("token", token)
                .get().get(TIMEOUT).asJson();
        assertEquals("" + SUCCESS_CODE, cardListResponse.get("code").asText());
        final CustomerCardListResponse customerCardListResponse = Json.fromJson(cardListResponse, CustomerCardListResponse.class);

        final CustomerTransferOwnCards request = new CustomerTransferOwnCards();
        request.setAmount(100L);
        request.setCurrency("USD");
        request.setCardFrom(customerCardListResponse.getList().get(0).getId());
        request.setCardTo(customerCardListResponse.getList().get(1).getId());
        request.setDescription("test transfer");
        request.setOrderId("xxxx");

        final JsonNode transferResponse = WS.url(getCustomerApiUrl("/transfer/own")).setHeader("token", token)
                .post(Json.toJson(request)).get(TIMEOUT).asJson();
        assertEquals(""+SUCCESS_CODE,transferResponse.get("code").asText());

        final CustomerTransferOwnCards request2 = new CustomerTransferOwnCards();
        request2.setAmount(100L);
        request2.setCurrency("USD");
        request2.setCardFrom(customerCardListResponse.getList().get(1).getId());
        request2.setCardTo(customerCardListResponse.getList().get(0).getId());
        request2.setDescription("test transfer");
        request2.setOrderId("xxxx");

        final JsonNode transferResponse2 = WS.url(getCustomerApiUrl("/transfer/own")).setHeader("token", token)
                .post(Json.toJson(request)).get(TIMEOUT).asJson();
        assertEquals(""+SUCCESS_CODE,transferResponse2.get("code").asText());
    }
}
