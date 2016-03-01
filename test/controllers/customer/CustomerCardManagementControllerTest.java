package controllers.customer;

import com.fasterxml.jackson.databind.JsonNode;
import dto.customer.CustomerCardListResponse;
import dto.customer.CustomerCardManagementChangePIN;
import dto.customer.CustomerCardManagementChangeStatus;
import org.junit.Test;
import play.Logger;
import play.libs.Json;
import play.libs.ws.WS;

import static configs.ReturnCodes.SUCCESS_CODE;
import static org.junit.Assert.*;

/**
 * API customer card list tests
 *
 * @author corbandalas created 01.03.2016.
 * @since 0.2.0
 */
public class CustomerCardManagementControllerTest extends BaseCustomerControllerTest {


    @Test
    public void blockCard() throws Exception {
        changeStatus(1);
    }

    @Test
    public void activateCard() throws Exception {
        changeStatus(0);
    }

    @Test
    public void reportDamage() throws Exception {
        changeStatus(2);
    }

    @Test
    public void reportLost() throws Exception {
        changeStatus(3);
    }

    @Test
    public void reportStolen() throws Exception {
        changeStatus(4);
    }

    @Test
    public void changePIN() throws Exception {
        final JsonNode authorizeResponse = authorizeCustomer(PHONE_1, PASSWORD_1);
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
            CustomerCardManagementChangePIN request = new CustomerCardManagementChangePIN();
            request.setCardID(cardWrapper.getId());
            request.setConfirmNewPIN("1234");
            request.setNewPIN("1234");
            request.setCurrentPIN("4321");

            final JsonNode response = WS.url(getCustomerApiUrl("/card/management/changePIN")).setHeader("token", token).post(Json.toJson(request)).get(TIMEOUT).asJson();

            assertEquals("" + SUCCESS_CODE, response.get("code").asText());

        } catch (Exception e) {
            Logger.error("Wrong request format: ", e);
            fail();
        }
    }

    public void changeStatus(int operation) throws Exception {

        final JsonNode authorizeResponse = authorizeCustomer(PHONE_1, PASSWORD_1);
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
            CustomerCardManagementChangeStatus request = new CustomerCardManagementChangeStatus();
            request.setCardID(cardWrapper.getId());
            request.setOperation(operation);
            request.setReason("testing");

            final JsonNode response = WS.url(getCustomerApiUrl("/card/management/changeStatus")).setHeader("token", token).post(Json.toJson(request)).get(TIMEOUT).asJson();

            assertEquals("" + SUCCESS_CODE, response.get("code").asText());

        } catch (Exception e) {
            Logger.error("Wrong request format: ", e);
            fail();
        }
    }

}
