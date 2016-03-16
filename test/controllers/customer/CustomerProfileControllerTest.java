package controllers.customer;

import akka.dispatch.Futures;
import com.fasterxml.jackson.databind.JsonNode;
import controllers.BaseControllerTest;
import dto.customer.CustomerProfileRequest;
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
 * API customer profile tests
 *
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
        assertEquals("" + SUCCESS_CODE, createResponse.get("code").asText());

        final JsonNode authorizeResponse = authorizeCustomer(phone, password);
        assertEquals("" + SUCCESS_CODE, authorizeResponse.get("code").asText());

        final String token = authorizeResponse.get("token").asText();

        final JsonNode profileResponse = WS.url(getCustomerApiUrl("/profile/get")).setHeader("token", token)
                .get().get(TIMEOUT).asJson();

        assertEquals("" + SUCCESS_CODE, profileResponse.get("code").asText());
        assertEquals(name, profileResponse.get("firstName").asText());
    }

    @Test
    public void update() throws Exception {
        final String password = "hashedpass";
        final String name = "Ivan";
        final JsonNode createResponse = createCustomer(new Customer(phone, new Date(), "Mr", name, "Petrenko", "adress1", "adress2",
                "83004", "Donetsk", "sao@bao.com", new Date(), true, KYC.FULL_DUE_DILIGENCE, password, "USA"));
        assertEquals("" + SUCCESS_CODE, createResponse.get("code").asText());

        final JsonNode authorizeResponse = authorizeCustomer(phone, password);
        assertEquals("" + SUCCESS_CODE, authorizeResponse.get("code").asText());

        final String token = authorizeResponse.get("token").asText();

        final CustomerProfileRequest customerProfileRequest = new CustomerProfileRequest();
        customerProfileRequest.setAddress1("address 1 updated");
        customerProfileRequest.setAddress2("address 2 updated");
        customerProfileRequest.setCity("Donetsk");
        customerProfileRequest.setCountry_id("USA");
        customerProfileRequest.setPostcode("83004");

        customerProfileRequest.setEmail("sao@bao.com");
        final String updatedName = "Petr";
        customerProfileRequest.setFirstName(updatedName);
        customerProfileRequest.setLastName("Petrenko");
        customerProfileRequest.setTitle("Mr");

        customerProfileRequest.setDateBirth("2000-03-16");
        customerProfileRequest.setRegistrationDate("2016-03-16");

        customerProfileRequest.setKyc(KYC.FULL_DUE_DILIGENCE);

        final JsonNode updateResponse = WS.url(getCustomerApiUrl("/profile/update")).setHeader("token", token)
                .post(Json.toJson(customerProfileRequest)).get(TIMEOUT).asJson();
        assertEquals(""+SUCCESS_CODE,updateResponse.get("code").asText());

        final JsonNode profileResponse = WS.url(getCustomerApiUrl("/profile/get")).setHeader("token", token)
                .get().get(TIMEOUT).asJson();

        assertEquals("" + SUCCESS_CODE, profileResponse.get("code").asText());
        assertEquals(updatedName, profileResponse.get("firstName").asText());
    }

    @After
    public void clean() throws Exception {
        final ConnectionPool connectionPool = app.injector().instanceOf(ConnectionPool.class);
        final Promise<Object> promise = Futures.promise();
        connectionPool.getConnection().query("delete from " + connectionPool.getSchemaName() + ".customer where id=$1", asList(phone),
                promise::success, promise::failure);
        Await.result(promise.future(), Duration.apply(TIMEOUT, "ms"));
    }
}
