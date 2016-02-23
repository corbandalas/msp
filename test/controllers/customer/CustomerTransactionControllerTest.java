package controllers.customer;

import akka.dispatch.Futures;
import com.fasterxml.jackson.databind.JsonNode;
import controllers.BaseControllerTest;
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
public class CustomerTransactionControllerTest extends BaseControllerTest {

    private String phone = "4524607605";

    @Test
    public void listWrongCard() throws Exception {
        final String password = "hashedpass";
        final JsonNode createResponse = createCustomer(new Customer(phone, new Date(), "Mr", "Ivan", "Petrenko", "adress1", "adress2",
                "83004", "Donetsk", "sao@bao.com", new Date(), true, KYC.FULL_DUE_DILIGENCE, password, "USA"));
        assertEquals("" + SUCCESS_CODE, createResponse.get("code").asText());

        final JsonNode authorizeResponse = authorizeCustomer(phone, password);
        assertEquals("" + SUCCESS_CODE, authorizeResponse.get("code").asText());

        final String token = authorizeResponse.get("token").asText();

        final CustomerTransactionFilter request = new CustomerTransactionFilter();
        request.setCardId(1L);
        request.setFromDate("2016-02-17");
        request.setToDate("2016-02-18");

        final JsonNode changeResponse = WS.url(getCustomerApiUrl("/transaction/list")).setHeader("token", token)
                .post(Json.toJson(request)).get(TIMEOUT).asJson();

        assertEquals("" + INCORRECT_CARD_CODE,changeResponse.get("code").asText());
    }

    @After
    public void clean() throws Exception {
        final ConnectionPool connectionPool = app.injector().instanceOf(ConnectionPool.class);
        final Promise<Object> promise = Futures.promise();
        connectionPool.getConnection().query("delete from " + connectionPool.getSchemaName() + ".customer where id=$1", asList(phone),
                promise::success, promise::failure);
        Await.result(promise.future(), Duration.apply(TIMEOUT,"ms"));
    }
}
