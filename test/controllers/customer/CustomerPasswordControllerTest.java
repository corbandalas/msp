package controllers.customer;

import akka.dispatch.Futures;
import com.fasterxml.jackson.databind.JsonNode;
import controllers.BaseControllerTest;
import dto.customer.CustomerChangePassword;
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

/**
 * Customer password controller tests
 *
 * @author ra created 16.02.2016.
 * @since 0.2.0
 */
public class CustomerPasswordControllerTest extends BaseControllerTest {

    private String phone = "4524607605";

    @Test
    public void changeOk() throws Exception {
        final String password = "hashedpass";
        final JsonNode createResponse = createCustomer(new Customer(phone, new Date(), "Mr", "Ivan", "Petrenko", "adress1", "adress2",
                "83004", "Donetsk", "sao@bao.com", new Date(), true, KYC.FULL_DUE_DILIGENCE, password, "USA"));
        assertEquals("0", createResponse.get("code").asText());

        final JsonNode authorizeResponse = authorizeCustomer(phone, password);
        assertEquals("0", authorizeResponse.get("code").asText());

        final String token = authorizeResponse.get("token").asText();

        final CustomerChangePassword request = new CustomerChangePassword();
        request.setOldHashedPassword(password);
        request.setHashedPassword("newhashedpass");

        final JsonNode changeResponse = WS.url(getCustomerApiUrl("/password/change")).setHeader("token", token)
                .post(Json.toJson(request)).get(TIMEOUT).asJson();

        assertEquals("0",changeResponse.get("code").asText());
    }

    @Test
    public void changeWrongOld() throws Exception {
        final String password = "hashedpass";
        final JsonNode createResponse = createCustomer(new Customer(phone, new Date(), "Mr", "Ivan", "Petrenko", "adress1", "adress2",
                "83004", "Donetsk", "sao@bao.com", new Date(), true, KYC.FULL_DUE_DILIGENCE, password, "USA"));
        assertEquals("0", createResponse.get("code").asText());

        final JsonNode authorizeResponse = authorizeCustomer(phone, password);
        assertEquals("0", authorizeResponse.get("code").asText());

        final String token = authorizeResponse.get("token").asText();

        final CustomerChangePassword request = new CustomerChangePassword();
        request.setOldHashedPassword("wronghashedpass");
        request.setHashedPassword("newhashedpass");

        final JsonNode changeResponse = WS.url(getCustomerApiUrl("/password/change")).setHeader("token", token)
                .post(Json.toJson(request)).get(TIMEOUT).asJson();

        assertEquals("3",changeResponse.get("code").asText());
    }

    @Test
    public void changeEquals() throws Exception {
        final String password = "hashedpass";
        final JsonNode createResponse = createCustomer(new Customer(phone, new Date(), "Mr", "Ivan", "Petrenko", "adress1", "adress2",
                "83004", "Donetsk", "sao@bao.com", new Date(), true, KYC.FULL_DUE_DILIGENCE, password, "USA"));
        assertEquals("0", createResponse.get("code").asText());

        final JsonNode authorizeResponse = authorizeCustomer(phone, password);
        assertEquals("0", authorizeResponse.get("code").asText());

        final String token = authorizeResponse.get("token").asText();

        final CustomerChangePassword request = new CustomerChangePassword();
        request.setOldHashedPassword(password);
        request.setHashedPassword(password);

        final JsonNode changeResponse = WS.url(getCustomerApiUrl("/password/change")).setHeader("token", token)
                .post(Json.toJson(request)).get(TIMEOUT).asJson();

        assertEquals("4",changeResponse.get("code").asText());
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
