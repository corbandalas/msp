package controllers.customer;

import akka.actor.ActorSystem;
import com.fasterxml.jackson.databind.JsonNode;
import controllers.BaseControllerTest;
import dto.customer.CustomerCardListResponse;
import dto.customer.CustomerTransferOwnCards;
import dto.customer.CustomerWorldPayCreditCardDeposit;
import module.PropertyLoader;
import org.junit.Before;
import org.junit.Test;
import play.Logger;
import play.libs.Json;
import play.libs.ws.WS;
import play.libs.ws.WSResponse;
import util.SecurityUtil;

import static configs.ReturnCodes.SUCCESS_CODE;
import static org.junit.Assert.assertEquals;

/**
 * Holds operation controller tests
 *
 * @author corbandalas created 18.05.2016.
 * @since 0.2.0
 */
public class WorldPayControllerTest extends BaseCustomerControllerTest  {

    @Before
    public void init() {

        super.init();

        try {

            PropertyLoader propertyLoader = app.injector().instanceOf(PropertyLoader.class);
            propertyLoader.load("conf/properties.json", app.injector().instanceOf(ActorSystem.class).dispatcher());
        } catch (Exception e) {
            Logger.error("Test error", e);
        }
    }

    @Test
    public void getBanks() throws Exception {

        final JsonNode authorizeResponse = authorizeCustomer(PHONE_1, PASSWORD_1);
        assertEquals("" + SUCCESS_CODE, authorizeResponse.get("code").asText());

        final String token = authorizeResponse.get("token").asText();

        final String country = "uk";

        final String url = getCustomerApiUrl("/worldpay/getbanks/" + country);

        WSResponse wsResponse = WS.url(url).setHeader("accountId", ACCOUNT_ID).setHeader("token", token).get().get(TIMEOUT);

        String body = wsResponse.getBody();

//        final JsonNode response = WS.url(url).setHeader("accountId", ACCOUNT_ID).setHeader("enckey", enckey)
//                .setHeader("orderId", ORDER_ID).get().get(TIMEOUT).asJson();

//        assertEquals(String.valueOf(SUCCESS_CODE), response.get("code").asText());
//        assertEquals(true, response.get("propertyList").isArray());
    }


    @Test
    public void initCreditCardDeposit() throws Exception {

        final JsonNode authorizeResponse = authorizeCustomer(PHONE_1, PASSWORD_1);
        assertEquals("" + SUCCESS_CODE, authorizeResponse.get("code").asText());

        final String token = authorizeResponse.get("token").asText();

        final JsonNode cardListResponse = WS.url(getCustomerApiUrl("/card/list")).setHeader("token", token)
                .get().get(TIMEOUT).asJson();
        assertEquals("" + SUCCESS_CODE, cardListResponse.get("code").asText());

        final CustomerCardListResponse customerCardListResponse = Json.fromJson(cardListResponse, CustomerCardListResponse.class);


        final CustomerWorldPayCreditCardDeposit request = new CustomerWorldPayCreditCardDeposit();
        request.setAmount(100L);
        request.setCurrency("USD");
        request.setCardTo(customerCardListResponse.getList().get(1).getId());
        request.setOrderId("" + System.currentTimeMillis());
        request.setSuccessURL("http://google.com");
        request.setFailURL("http://google.com");
        request.setCancelURL("http://google.com");

        final JsonNode transferResponse = WS.url(getCustomerApiUrl("/worldpay/initCreditCardDeposit")).setHeader("token", token)
                .post(Json.toJson(request)).get(TIMEOUT).asJson();


    }

}
