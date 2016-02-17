package controllers.customer;

import akka.dispatch.Futures;
import com.fasterxml.jackson.databind.JsonNode;
import controllers.BaseControllerTest;
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
 * API customer profile tests
 * @author ra created 17.02.2016.
 * @since 0.1.0
 */
public class CustomerProfileControllerTest extends BaseControllerTest {

    private String phone = "4524607605";

    @Test
    public void get() throws Exception {
        final String password = "hashedpass";
        final String name = "Ivan";
        final JsonNode createResponse = createCustomer(new Customer(phone, new Date(), "Mr", name, "Petrenko", "adress1", "adress2",
                "83004", "Donetsk", "sao@bao.com", new Date(), true, KYC.FULL_DUE_DILIGENCE, password, "USA"));
        assertEquals("0", createResponse.get("code").asText());

        final JsonNode authorizeResponse = authorizeCustomer(phone, password);
        assertEquals("0", authorizeResponse.get("code").asText());

        final String token = authorizeResponse.get("token").asText();

        final JsonNode profileResponse = WS.url(getCustomerApiUrl("/profile/get")).setHeader("token", token)
                .get().get(TIMEOUT).asJson();

        assertEquals("0",profileResponse.get("code").asText());
        assertEquals(name,profileResponse.get("firstName").asText());
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
