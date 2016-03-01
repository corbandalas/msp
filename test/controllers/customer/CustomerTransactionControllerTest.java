package controllers.customer;

import akka.dispatch.Futures;
import com.fasterxml.jackson.databind.JsonNode;
import controllers.BaseControllerTest;
import dto.customer.CustomerCardListResponse;
import dto.customer.CustomerTransactionFilter;
import model.Customer;
import model.enums.KYC;
import org.junit.After;
import org.junit.Test;
import play.libs.Json;
import play.libs.ws.WS;
import repository.ConnectionPool;
import scala.concurrent.Await;
import scala.concurrent.Promise;
import scala.concurrent.duration.Duration;

import java.util.Date;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;
import static configs.ReturnCodes.*;

/**
 * API customer transaction test
 * @author ra created 17.02.2016.
 * @since 0.1.0
 */
public class CustomerTransactionControllerTest extends BaseCustomerControllerTest {

    @Test
    public void listWrongCard() throws Exception {
        final JsonNode authorizeResponse = authorizeCustomer(PHONE_1, PASSWORD_1);
        assertEquals("" + SUCCESS_CODE, authorizeResponse.get("code").asText());

        final String token = authorizeResponse.get("token").asText();

        final CustomerTransactionFilter request = new CustomerTransactionFilter();
        request.setCardId(0L);
        request.setFromDate("2016-02-17");
        request.setToDate("2016-02-18");

        final JsonNode changeResponse = WS.url(getCustomerApiUrl("/transaction/list")).setHeader("token", token)
                .post(Json.toJson(request)).get(TIMEOUT).asJson();

        assertEquals("" + INCORRECT_CARD_CODE,changeResponse.get("code").asText());
    }

    @Test
    public void list() throws Exception {
        final JsonNode authorizeResponse = authorizeCustomer(PHONE_1, PASSWORD_1);
        assertEquals("" + SUCCESS_CODE, authorizeResponse.get("code").asText());

        final String token = authorizeResponse.get("token").asText();

        final JsonNode cardListResponse = WS.url(getCustomerApiUrl("/card/list")).setHeader("token", token)
                .get().get(TIMEOUT).asJson();
        assertEquals("" + SUCCESS_CODE, cardListResponse.get("code").asText());
        final CustomerCardListResponse customerCardListResponse = Json.fromJson(cardListResponse, CustomerCardListResponse.class);

        final CustomerTransactionFilter request = new CustomerTransactionFilter();
        request.setCardId(customerCardListResponse.getList().get(0).getId());
        request.setFromDate("2016-02-17");
        request.setToDate("2016-02-18");

        final JsonNode changeResponse = WS.url(getCustomerApiUrl("/transaction/list")).setHeader("token", token)
                .post(Json.toJson(request)).get(TIMEOUT).asJson();

        assertEquals("" + INCORRECT_CARD_CODE,changeResponse.get("code").asText());
    }
}
