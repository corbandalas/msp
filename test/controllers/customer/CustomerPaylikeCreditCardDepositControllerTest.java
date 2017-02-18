package controllers.customer;

import akka.actor.ActorSystem;
import com.fasterxml.jackson.databind.JsonNode;
import dto.BankDetailsListResponse;
import dto.customer.*;
import model.enums.CardType;
import module.PropertyLoader;
import org.apache.commons.lang3.StringUtils;
import org.junit.Before;
import org.junit.Test;
import play.Logger;
import play.libs.Json;
import play.libs.ws.WS;
import play.libs.ws.WSResponse;

import static configs.ReturnCodes.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Paylike credit card deposit controller tests
 *
 * @author corbandalas created 03.02.2017.
 * @since 0.4.0
 */
public class CustomerPaylikeCreditCardDepositControllerTest extends BaseCustomerControllerTest {

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
    public void testInitCorrectCreditCardDeposit() throws Exception {

        final JsonNode authorizeResponse = authorizeCustomer(PHONE_1, PASSWORD_1);
        assertEquals("" + SUCCESS_CODE, authorizeResponse.get("code").asText());

        final String token = authorizeResponse.get("token").asText();

        final JsonNode cardListResponse = WS.url(getCustomerApiUrl("/card/list")).setHeader("token", token)
                .get().get(TIMEOUT).asJson();
        assertEquals("" + SUCCESS_CODE, cardListResponse.get("code").asText());

        final CustomerCardListResponse customerCardListResponse = Json.fromJson(cardListResponse, CustomerCardListResponse.class);


        final CustomerPaylikeCreditCardDeposit request = new CustomerPaylikeCreditCardDeposit();
        request.setAmount(100L);
        request.setCurrency("USD");
        request.setCardTo(customerCardListResponse.getList().get(1).getId());
        request.setOrderId("" + System.currentTimeMillis());
        request.setSuccessURL("http://google.com");
        request.setFailURL("http://google.com");
        request.setCancelURL("http://google.com");


//        WSResponse token1 = WS.url(getCustomerApiUrl("/paylike/initCreditCardDeposit")).setHeader("token", token)
//                .post(Json.toJson(request)).get(TIMEOUT);
//
        final JsonNode response = WS.url(getCustomerApiUrl("/paylike/initCreditCardDeposit")).setHeader("token", token)
                .post(Json.toJson(request)).get(TIMEOUT).asJson();
//
//        System.out.println("");
//
        assertEquals(String.valueOf(SUCCESS_CODE), response.get("code").asText());
        assertTrue(StringUtils.isNoneBlank(response.get("url").asText()));

    }


    @Test
    public void testLimitExceededCreditCardDeposit() throws Exception {

        final JsonNode authorizeResponse = authorizeCustomer(PHONE_1, PASSWORD_1);
        assertEquals("" + SUCCESS_CODE, authorizeResponse.get("code").asText());

        final String token = authorizeResponse.get("token").asText();

        final JsonNode cardListResponse = WS.url(getCustomerApiUrl("/card/list")).setHeader("token", token)
                .get().get(TIMEOUT).asJson();
        assertEquals("" + SUCCESS_CODE, cardListResponse.get("code").asText());

        final CustomerCardListResponse customerCardListResponse = Json.fromJson(cardListResponse, CustomerCardListResponse.class);


        final CustomerPaylikeCreditCardDeposit request = new CustomerPaylikeCreditCardDeposit();

        request.setAmount(100000L);
        request.setCurrency("USD");
        request.setCardTo(customerCardListResponse.getList().get(1).getId());
        request.setOrderId("" + System.currentTimeMillis());
        request.setSuccessURL("http://google.com");
        request.setFailURL("http://google.com");
        request.setCancelURL("http://google.com");

        final JsonNode response2 = WS.url(getCustomerApiUrl("/paylike/initCreditCardDeposit")).setHeader("token", token)
                .post(Json.toJson(request)).get(TIMEOUT).asJson();

        assertEquals(String.valueOf(LIMITS_EXCEEDED_CODE), response2.get("code").asText());

    }


    @Test
    public void testWrongRequestFormatCreditCardDeposit() throws Exception {

        final JsonNode authorizeResponse = authorizeCustomer(PHONE_2, PASSWORD_2);
        assertEquals("" + SUCCESS_CODE, authorizeResponse.get("code").asText());

        final String token = authorizeResponse.get("token").asText();

        final JsonNode cardListResponse = WS.url(getCustomerApiUrl("/card/list")).setHeader("token", token)
                .get().get(TIMEOUT).asJson();
        assertEquals("" + SUCCESS_CODE, cardListResponse.get("code").asText());

        final CustomerCardListResponse customerCardListResponse = Json.fromJson(cardListResponse, CustomerCardListResponse.class);

        final CustomerPaylikeCreditCardDeposit request = new CustomerPaylikeCreditCardDeposit();

        request.setAmount(-1000L);
        request.setCurrency("USD");
        request.setCardTo(customerCardListResponse.getList().get(1).getId());
        request.setOrderId("" + System.currentTimeMillis());
        request.setSuccessURL("http://google.com");
        request.setFailURL("http://google.com");
        request.setCancelURL("http://google.com");

        final JsonNode response2 = WS.url(getCustomerApiUrl("/paylike/initCreditCardDeposit")).setHeader("token", token)
                .post(Json.toJson(request)).get(TIMEOUT).asJson();

        assertEquals(String.valueOf(WRONG_REQUEST_FORMAT_CODE), response2.get("code").asText());

    }


    @Test
    public void testWrongCurrencyCreditCardDeposit() throws Exception {

        final JsonNode authorizeResponse = authorizeCustomer(PHONE_2, PASSWORD_2);
        assertEquals("" + SUCCESS_CODE, authorizeResponse.get("code").asText());

        final String token = authorizeResponse.get("token").asText();

        final JsonNode cardListResponse = WS.url(getCustomerApiUrl("/card/list")).setHeader("token", token)
                .get().get(TIMEOUT).asJson();
        assertEquals("" + SUCCESS_CODE, cardListResponse.get("code").asText());

        final CustomerCardListResponse customerCardListResponse = Json.fromJson(cardListResponse, CustomerCardListResponse.class);

        final CustomerPaylikeCreditCardDeposit request = new CustomerPaylikeCreditCardDeposit();

        request.setAmount(1000L);
        request.setCurrency("USDF");
        request.setCardTo(customerCardListResponse.getList().get(1).getId());
        request.setOrderId("" + System.currentTimeMillis());
        request.setSuccessURL("http://google.com");
        request.setFailURL("http://google.com");
        request.setCancelURL("http://google.com");

        final JsonNode response2 = WS.url(getCustomerApiUrl("/paylike/initCreditCardDeposit")).setHeader("token", token)
                .post(Json.toJson(request)).get(TIMEOUT).asJson();

        assertEquals(String.valueOf(INCORRECT_CURRENCY_CODE), response2.get("code").asText());

    }


    @Test
    public void testInitCorrectCreditCardPurchase() throws Exception {

        final JsonNode authorizeResponse = authorizeCustomer(PHONE_1, PASSWORD_1);
        assertEquals("" + SUCCESS_CODE, authorizeResponse.get("code").asText());

        final String token = authorizeResponse.get("token").asText();

        final long amount = 100L;

        final CustomerPaylikeCreditCardPurchase request = new CustomerPaylikeCreditCardPurchase();
        request.setAmount(amount);
        request.setCurrency("USD");
        request.setCardType(CardType.PLASTIC.name());
        request.setOrderId("" + System.currentTimeMillis());
        request.setSuccessURL("http://google.com");
        request.setFailURL("http://google.com");
        request.setCancelURL("http://google.com");

        final JsonNode response = WS.url(getCustomerApiUrl("/paylike/" +
                "initCreditCardPurchase")).setHeader("token", token)
                .post(Json.toJson(request)).get(TIMEOUT).asJson();

        assertEquals(String.valueOf(SUCCESS_CODE), response.get("code").asText());

        String totalAmount = response.get("totalAmount").asText();

        assertTrue(StringUtils.isNoneBlank(response.get("url").asText()));
        assertTrue(StringUtils.isNoneBlank(totalAmount));

        assertTrue(Long.parseLong(totalAmount) > amount);
    }


    @Test
    public void testInitLimitExceededCreditCardPurchase() throws Exception {

        final JsonNode authorizeResponse = authorizeCustomer(PHONE_1, PASSWORD_1);
        assertEquals("" + SUCCESS_CODE, authorizeResponse.get("code").asText());

        final String token = authorizeResponse.get("token").asText();

        final CustomerPaylikeCreditCardPurchase request = new CustomerPaylikeCreditCardPurchase();
        request.setAmount(10000000L);
        request.setCurrency("USD");
        request.setCardType(CardType.PLASTIC.name());
        request.setOrderId("" + System.currentTimeMillis());
        request.setSuccessURL("http://google.com");
        request.setFailURL("http://google.com");
        request.setCancelURL("http://google.com");

        final JsonNode response = WS.url(getCustomerApiUrl("/paylike/" +
                "initCreditCardPurchase")).setHeader("token", token)
                .post(Json.toJson(request)).get(TIMEOUT).asJson();

        assertEquals(String.valueOf(LIMITS_EXCEEDED_CODE), response.get("code").asText());

    }


    @Test
    public void testInitWrongCardTypeCreditCardPurchase() throws Exception {

        final JsonNode authorizeResponse = authorizeCustomer(PHONE_1, PASSWORD_1);
        assertEquals("" + SUCCESS_CODE, authorizeResponse.get("code").asText());

        final String token = authorizeResponse.get("token").asText();

        final CustomerPaylikeCreditCardPurchase request = new CustomerPaylikeCreditCardPurchase();
        request.setAmount(1000L);
        request.setCurrency("USD");
        request.setCardType("PHYSICAL");
        request.setOrderId("" + System.currentTimeMillis());
        request.setSuccessURL("http://google.com");
        request.setFailURL("http://google.com");
        request.setCancelURL("http://google.com");

        final JsonNode response = WS.url(getCustomerApiUrl("/paylike/" +
                "initCreditCardPurchase")).setHeader("token", token)
                .post(Json.toJson(request)).get(TIMEOUT).asJson();

        assertEquals(String.valueOf(WRONG_REQUEST_FORMAT_CODE), response.get("code").asText());

    }


}
