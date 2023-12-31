package controllers.customer;

import com.fasterxml.jackson.databind.JsonNode;
import dto.customer.*;
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
    public void testChangeAlias() {
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
            CustomerCardManagementChangeAlias request = new CustomerCardManagementChangeAlias();
            request.setCardID(cardWrapper.getId());
            request.setAlias("corbandalas");

            final JsonNode response = WS.url(getCustomerApiUrl("/card/management/changeAlias")).setHeader("token", token).post(Json.toJson(request)).get(TIMEOUT).asJson();

            assertEquals("" + SUCCESS_CODE, response.get("code").asText());

            final JsonNode cardListResponse2 = WS.url(getCustomerApiUrl("/card/list")).setHeader("token", token)
                    .get().get(TIMEOUT).asJson();

            assertEquals("" + SUCCESS_CODE, cardListResponse2.get("code").asText());

            customerCardListResponse = Json.fromJson(cardListResponse2, CustomerCardListResponse.class);
            cardWrapper = customerCardListResponse.getList().get(0);

            assertEquals("corbandalas", cardWrapper.getAlias());

        } catch (Exception e) {
            Logger.error("Wrong request format: ", e);
            fail();
        }
    }

    //@Test /*Permanently block card*/
    public void reportDamage() throws Exception {
        changeStatus(2);
    }

    //@Test /*Permanently block card*/
    public void reportLost() throws Exception {
        changeStatus(3);
    }

    //@Test /*Permanently block card*/
    public void reportStolen() throws Exception {
        changeStatus(4);
    }

    // @Test  /*Only plastic*/
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

            final JsonNode cardListResponse2 = WS.url(getCustomerApiUrl("/card/list")).setHeader("token", token)
                    .get().get(TIMEOUT).asJson();

            assertEquals("" + SUCCESS_CODE, cardListResponse2.get("code").asText());

            customerCardListResponse = Json.fromJson(cardListResponse2, CustomerCardListResponse.class);
            cardWrapper = customerCardListResponse.getList().get(0);

            if (operation == 0) {
                assertEquals("00", cardWrapper.getCardDetails().getStatCode());
            } else if (operation == 1) {
                assertEquals("05", cardWrapper.getCardDetails().getStatCode());
            }

        } catch (Exception e) {
            Logger.error("Wrong request format: ", e);
            fail();
        }
    }


    @Test
    public void testConvertVirtualToPlastic() {
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

            PlasticCardConversion plasticCardConversion = new PlasticCardConversion();


            plasticCardConversion.setCardID(cardWrapper.getId());

            final JsonNode response = WS.url(getCustomerApiUrl("/card/convert")).setHeader("token", token).post(Json.toJson(plasticCardConversion)).get(TIMEOUT).asJson();

            assertEquals("" + SUCCESS_CODE, response.get("code").asText());

//            final JsonNode cardListResponse2 = WS.url(getCustomerApiUrl("/card/list")).setHeader("token", token)
//                    .get().get(TIMEOUT).asJson();
//
//            assertEquals("" + SUCCESS_CODE, cardListResponse2.get("code").asText());
//
//            customerCardListResponse = Json.fromJson(cardListResponse2, CustomerCardListResponse.class);
//            cardWrapper = customerCardListResponse.getList().get(0);
//
//            assertEquals("corbandalas", cardWrapper.getAlias());

        } catch (Exception e) {
            Logger.error("Wrong request format: ", e);
            fail();
        }
    }

}
