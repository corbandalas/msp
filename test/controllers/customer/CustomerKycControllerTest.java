package controllers.customer;

import akka.actor.ActorSystem;
import akka.dispatch.Futures;
import com.fasterxml.jackson.databind.JsonNode;
import controllers.BaseControllerTest;
import dto.customer.CustomerChangePassword;
import dto.customer.CustomerKYCCheck;
import model.Customer;
import model.enums.KYC;
import module.PropertyLoader;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import play.Logger;
import play.libs.Json;
import play.libs.ws.WS;
import repository.ConnectionPool;
import scala.concurrent.Await;
import scala.concurrent.Promise;
import scala.concurrent.duration.Duration;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import static configs.ReturnCodes.*;
import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Customer password controller tests
 *
 * @author ra created 16.02.2016.
 * @since 0.2.0
 */
public class CustomerKycControllerTest extends BaseControllerTest {


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


    private String phone = "4524607605";

    @Test
    public void checkSuccessKYC_UK_SDD() throws Exception {
        final String password = "hashedpass";
        final JsonNode createResponse = createCustomer(new Customer(phone, new Date(), "Mr", "Ivan", "Petrenko", "adress1", "adress2",
                "83004", "Donetsk", "sao@bao.com", new Date(), true, KYC.NONE, password, "USA"));
        assertEquals("0", createResponse.get("code").asText());

        final JsonNode authorizeResponse = authorizeCustomer(phone, password);
        assertEquals("" + SUCCESS_CODE, authorizeResponse.get("code").asText());

        final String token = authorizeResponse.get("token").asText();

        String dt = "1992-05-09";  // Start date
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar c = Calendar.getInstance();
        c.setTime(sdf.parse(dt));


        final CustomerKYCCheck request = new CustomerKYCCheck();
        request.setNameQuery("David Robson");
        request.setForename("David");
        request.setSurname("Robson");
        request.setHouseNameNumber("42");
        request.setDateOfBirth(c.getTime());
        request.setPostcode("HU12 9FL");
        request.setKycType("SDD");
        request.setCountry("GBR");

        final JsonNode changeResponse = WS.url(getCustomerApiUrl("/kyc/check")).setHeader("token", token)
                .post(Json.toJson(request)).get(TIMEOUT).asJson();

        assertEquals("" + SUCCESS_CODE, changeResponse.get("code").asText());
        assertEquals("Pass", changeResponse.get("result").asText());

        final JsonNode profileResponse = WS.url(getCustomerApiUrl("/profile/get")).setHeader("token", token)
                .get().get(TIMEOUT).asJson();

        assertEquals("" + SUCCESS_CODE, profileResponse.get("code").asText());
        assertEquals(KYC.SIMPLIFIED_DUE_DILIGENCE.toString(), profileResponse.get("kyc").asText());
    }

    @Test
    public void checkSuccessKYC_UK_FDD() throws Exception {
        final String password = "hashedpass";
        final JsonNode createResponse = createCustomer(new Customer(phone, new Date(), "Mr", "Ivan", "Petrenko", "adress1", "adress2",
                "83004", "Donetsk", "sao@bao.com", new Date(), true, KYC.NONE, password, "USA"));
        assertEquals("0", createResponse.get("code").asText());

        final JsonNode authorizeResponse = authorizeCustomer(phone, password);
        assertEquals("" + SUCCESS_CODE, authorizeResponse.get("code").asText());

        final String token = authorizeResponse.get("token").asText();

        String dt = "1992-05-09";  // Start date
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar c = Calendar.getInstance();
        c.setTime(sdf.parse(dt));


        final CustomerKYCCheck request = new CustomerKYCCheck();
        request.setNameQuery("David Robson");
        request.setForename("David");
        request.setSurname("Robson");
        request.setHouseNameNumber("42");
        request.setDateOfBirth(c.getTime());
        request.setPostcode("HU12 9FL");
        request.setKycType("FDD");
        request.setCountry("GBR");

        final JsonNode changeResponse = WS.url(getCustomerApiUrl("/kyc/check")).setHeader("token", token)
                .post(Json.toJson(request)).get(TIMEOUT).asJson();

        assertEquals("" + SUCCESS_CODE, changeResponse.get("code").asText());
        assertEquals("Pass", changeResponse.get("result").asText());

        final JsonNode profileResponse = WS.url(getCustomerApiUrl("/profile/get")).setHeader("token", token)
                .get().get(TIMEOUT).asJson();

        assertEquals("" + SUCCESS_CODE, profileResponse.get("code").asText());
        assertEquals(KYC.FULL_DUE_DILIGENCE.toString(), profileResponse.get("kyc").asText());
    }

    @Test
    public void checkFailKYC_UK_SDD() throws Exception {
        final String password = "hashedpass";
        final JsonNode createResponse = createCustomer(new Customer(phone, new Date(), "Mr", "Ivan", "Petrenko", "adress1", "adress2",
                "83004", "Donetsk", "sao@bao.com", new Date(), true, KYC.NONE, password, "USA"));
        assertEquals("0", createResponse.get("code").asText());

        final JsonNode authorizeResponse = authorizeCustomer(phone, password);
        assertEquals("" + SUCCESS_CODE, authorizeResponse.get("code").asText());

        final String token = authorizeResponse.get("token").asText();

        String dt = "1944-12-31";  // Start date
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar c = Calendar.getInstance();
        c.setTime(sdf.parse(dt));


        final CustomerKYCCheck request = new CustomerKYCCheck();
        request.setNameQuery("Billy Jones");
        request.setForename("Billy");
        request.setSurname("Jones");
        request.setHouseNameNumber("68");
        request.setDateOfBirth(c.getTime());
        request.setPostcode("RH13 3HE");
        request.setKycType("SDD");
        request.setCountry("GBR");

        final JsonNode changeResponse = WS.url(getCustomerApiUrl("/kyc/check")).setHeader("token", token)
                .post(Json.toJson(request)).get(TIMEOUT).asJson();

        assertEquals("" + SUCCESS_CODE, changeResponse.get("code").asText());
        assertEquals("Fail", changeResponse.get("result").asText());

        final JsonNode profileResponse = WS.url(getCustomerApiUrl("/profile/get")).setHeader("token", token)
                .get().get(TIMEOUT).asJson();

        assertEquals("" + SUCCESS_CODE, profileResponse.get("code").asText());
        assertEquals(KYC.NONE.toString(), profileResponse.get("kyc").asText());

    }

    @Test
    public void checkFailKYC_UK_FDD() throws Exception {
        final String password = "hashedpass";
        final JsonNode createResponse = createCustomer(new Customer(phone, new Date(), "Mr", "Ivan", "Petrenko", "adress1", "adress2",
                "83004", "Donetsk", "sao@bao.com", new Date(), true, KYC.NONE, password, "USA"));
        assertEquals("0", createResponse.get("code").asText());

        final JsonNode authorizeResponse = authorizeCustomer(phone, password);
        assertEquals("" + SUCCESS_CODE, authorizeResponse.get("code").asText());

        final String token = authorizeResponse.get("token").asText();

        String dt = "1944-12-31";  // Start date
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar c = Calendar.getInstance();
        c.setTime(sdf.parse(dt));


        final CustomerKYCCheck request = new CustomerKYCCheck();
        request.setNameQuery("Billy Jones");
        request.setForename("Billy");
        request.setSurname("Jones");
        request.setHouseNameNumber("68");
        request.setDateOfBirth(c.getTime());
        request.setPostcode("RH13 3HE");
        request.setKycType("FDD");
        request.setCountry("GBR");

        final JsonNode changeResponse = WS.url(getCustomerApiUrl("/kyc/check")).setHeader("token", token)
                .post(Json.toJson(request)).get(TIMEOUT).asJson();

        assertEquals("" + SUCCESS_CODE, changeResponse.get("code").asText());
        assertEquals("Fail", changeResponse.get("result").asText());

        final JsonNode profileResponse = WS.url(getCustomerApiUrl("/profile/get")).setHeader("token", token)
                .get().get(TIMEOUT).asJson();

        assertEquals("" + SUCCESS_CODE, profileResponse.get("code").asText());
        assertEquals(KYC.NONE.toString(), profileResponse.get("kyc").asText());

    }


    @Test
    public void checkSuccessKYC_SCANDI_SDD() throws Exception {
        final String password = "hashedpass";
        final JsonNode createResponse = createCustomer(new Customer(phone, new Date(), "Mr", "Ivan", "Petrenko", "adress1", "adress2",
                "83004", "Donetsk", "sao@bao.com", new Date(), true, KYC.NONE, password, "USA"));
        assertEquals("0", createResponse.get("code").asText());

        final JsonNode authorizeResponse = authorizeCustomer(phone, password);
        assertEquals("" + SUCCESS_CODE, authorizeResponse.get("code").asText());

        final String token = authorizeResponse.get("token").asText();

        String dt = "1952-06-04";  // Start date
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar c = Calendar.getInstance();
        c.setTime(sdf.parse(dt));

        final CustomerKYCCheck request = new CustomerKYCCheck();
        request.setForename("SIRI");
        request.setSurname("PETERSSON");
        request.setHouseNameNumber("47");
        request.setDateOfBirth(c.getTime());
        request.setPostcode("42715");
        request.setKycType("SDD");
        request.setCountry("SWE");
        request.setCity("BILLDAL");
        request.setStreet("Eriksbo Västergärde");
        request.setScandyTestdatanumber("1");

        final JsonNode changeResponse = WS.url(getCustomerApiUrl("/kyc/check")).setHeader("token", token)
                .post(Json.toJson(request)).get(TIMEOUT).asJson();

        assertEquals("" + SUCCESS_CODE, changeResponse.get("code").asText());

    }


    @Test
    public void checkSuccessKYC_SCANDI_FDD() throws Exception {
        final String password = "hashedpass";
        final JsonNode createResponse = createCustomer(new Customer(phone, new Date(), "Mr", "Ivan", "Petrenko", "adress1", "adress2",
                "83004", "Donetsk", "sao@bao.com", new Date(), true, KYC.NONE, password, "USA"));
        assertEquals("0", createResponse.get("code").asText());

        final JsonNode authorizeResponse = authorizeCustomer(phone, password);
        assertEquals("" + SUCCESS_CODE, authorizeResponse.get("code").asText());

        final String token = authorizeResponse.get("token").asText();

        String dt = "1952-06-04";  // Start date
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar c = Calendar.getInstance();
        c.setTime(sdf.parse(dt));


        final CustomerKYCCheck request = new CustomerKYCCheck();
        request.setForename("SIRI");
        request.setSurname("PETERSSON");
        request.setHouseNameNumber("47");
        request.setDateOfBirth(c.getTime());
        request.setPostcode("42715");
        request.setKycType("FDD");
        request.setCountry("SWE");
        request.setCity("BILLDAL");
        request.setStreet("Eriksbo Västergärde");
        request.setScandyTestdatanumber("1");

        final JsonNode changeResponse = WS.url(getCustomerApiUrl("/kyc/check")).setHeader("token", token)
                .post(Json.toJson(request)).get(TIMEOUT).asJson();

        assertEquals("" + SUCCESS_CODE, changeResponse.get("code").asText());
        assertNotNull(changeResponse.get("redirectUrl"));

    }

    @Test
    public void getKYC() throws Exception {
        final String password = "hashedpass";
        final JsonNode createResponse = createCustomer(new Customer(phone, new Date(), "Mr", "Ivan", "Petrenko", "adress1", "adress2",
                "83004", "Donetsk", "sao@bao.com", new Date(), true, KYC.NONE, password, "USA"));
        assertEquals("0", createResponse.get("code").asText());

        final JsonNode authorizeResponse = authorizeCustomer(phone, password);
        assertEquals("" + SUCCESS_CODE, authorizeResponse.get("code").asText());

        final String token = authorizeResponse.get("token").asText();


        final JsonNode profileResponse = WS.url(getCustomerApiUrl("/kyc/get")).setHeader("token", token)
                .get().get(TIMEOUT).asJson();

        assertEquals("" + SUCCESS_CODE, profileResponse.get("code").asText());
        assertEquals(KYC.NONE.toString(), profileResponse.get("kyc").asText());

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
