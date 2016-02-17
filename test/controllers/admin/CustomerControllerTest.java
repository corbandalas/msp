package controllers.admin;

import com.fasterxml.jackson.databind.JsonNode;
import controllers.BaseControllerTest;
import junit.framework.TestCase;
import model.Customer;
import model.enums.KYC;
import org.junit.After;
import org.junit.Test;
import play.libs.Json;
import play.libs.ws.WS;
import repository.ConnectionPool;
import util.SecurityUtil;

import java.util.Date;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;

/**
 * Test for CustomerController
 *
 * @author nihilist created 12.02.2016.
 * @since 0.1.0
 */
public class CustomerControllerTest extends BaseControllerTest {

    private String phone = "380953055621";
    private String email = "nihilist.don@gmail.com";

    @Test
    public void createAndUpdate() throws Exception {
        final Customer customer = new Customer(phone, new Date(), "Mr", "Vladimir", "Kuznetsov", "adress1", "adress2", "83004", "Donetsk", email, new Date(), true, KYC.FULL_DUE_DILIGENCE, "101dog101", "USA");
        final JsonNode createResult = create(customer, this.testServer.port());

        TestCase.assertEquals("0", createResult.get("code").asText());

        final JsonNode afterCreate = retrieveByPhone(createResult.get("customer").get("id").asText());
        TestCase.assertEquals("0", afterCreate.get("code").asText());
        TestCase.assertEquals(email, afterCreate.get("customer").get("email").asText());

        final String updatedEmail = "nihilist.don2@gmail.com";
        customer.setEmail(updatedEmail);

        final String url = getAdminApiUrl("/customer/update");
        final String enckey = SecurityUtil.generateKeyFromArray(ACCOUNT_ID, customer.getId(), ORDER_ID, SECRET);

        final String updateEnckey = SecurityUtil.generateKeyFromArray(ACCOUNT_ID, customer.getId(), ORDER_ID, SECRET);

        final JsonNode updateResult = WS.url(url).setHeader("accountId", ACCOUNT_ID).setHeader("enckey", updateEnckey)
                .setHeader("orderId", ORDER_ID).post(Json.toJson(customer)).get(TIMEOUT).asJson();
        TestCase.assertEquals("0", updateResult.get("code").asText());

        final JsonNode afterUpdate = retrieveByPhone(customer.getId());
        TestCase.assertEquals("0", afterUpdate.get("code").asText());
        TestCase.assertEquals(updatedEmail, afterUpdate.get("customer").get("email").asText());
    }

    private JsonNode retrieveByPhone(String phone) {
        final String url = getAdminApiUrl("/customer/getByPhone/" + phone);

        final String enckey = SecurityUtil.generateKeyFromArray(ACCOUNT_ID, phone, ORDER_ID, SECRET);

        return WS.url(url).setHeader("accountId", ACCOUNT_ID).setHeader("enckey", enckey)
                .setHeader("orderId", ORDER_ID).get().get(TIMEOUT).asJson();
    }

    public JsonNode create(Customer customer, int port) {
        final String url = getAdminApiUrl("/customer/create");
        final String enckey = SecurityUtil.generateKeyFromArray(ACCOUNT_ID, customer.getId(), customer.getFirstName(), ORDER_ID, SECRET);

        return WS.url(url).setHeader("accountId", ACCOUNT_ID).setHeader("enckey", enckey)
                .setHeader("orderId", ORDER_ID).post(Json.toJson(customer)).get(TIMEOUT).asJson();
    }

    @Test
    public void retrieveByPhone() throws Exception {
        final Customer customer = new Customer(phone, new Date(), "Mr", "Vladimir", "Kuznetsov", "adress1", "adress2", "83004", "Donetsk", email, new Date(), true, KYC.FULL_DUE_DILIGENCE, "101dog101", "USA");
        final JsonNode createResult = create(customer, this.testServer.port());
        TestCase.assertEquals("0", createResult.get("code").asText());

        String url = getAdminApiUrl("/customer/getByPhone/380953055621");
        final int timeout = 5000;

        final String enckey = SecurityUtil.generateKeyFromArray(ACCOUNT_ID + "380953055621" + ORDER_ID + SECRET);

        final JsonNode response = WS.url(url).setHeader("accountId", ACCOUNT_ID).setHeader("enckey", enckey)
                .setHeader("orderId", ORDER_ID).get().get(timeout).asJson();
        assertEquals("0", response.get("code").asText());

        final JsonNode result = retrieveByPhone(response.get("customer").get("id").asText());
        assertEquals("0", result.get("code").asText());
        assertEquals("83004", result.get("customer").get("postcode").asText());
    }

    @Test
    public void retrieveByEmail() throws Exception {
        final Customer customer = new Customer(phone, new Date(), "Mr", "Vladimir", "Kuznetsov", "adress1", "adress2", "83004", "Donetsk", email, new Date(), true, KYC.FULL_DUE_DILIGENCE, "101dog101", "USA");
        final JsonNode createResult = create(customer, this.testServer.port());
        TestCase.assertEquals("0", createResult.get("code").asText());

        String url = getAdminApiUrl("/customer/getByEmail/".concat(email));
        final int timeout = 5000;

        final String enckey = SecurityUtil.generateKeyFromArray(ACCOUNT_ID + email + ORDER_ID + SECRET);

        final JsonNode response = WS.url(url).setHeader("accountId", ACCOUNT_ID).setHeader("enckey", enckey)
                .setHeader("orderId", ORDER_ID).get().get(timeout).asJson();
        assertEquals("0", response.get("code").asText());

        final JsonNode result = retrieveByPhone(response.get("customerList").get(0).get("id").asText());
        assertEquals("0", result.get("code").asText());

        assertEquals("83004", result.get("customer").get("postcode").asText());
    }

    @Test
    public void retrieveByKYC() throws Exception {
        String url = getAdminApiUrl("/customer/getByKYC/FULL_DUE_DILIGENCE");
        final int timeout = 5000;

        final String enckey = SecurityUtil.generateKeyFromArray(ACCOUNT_ID + "FULL_DUE_DILIGENCE" + ORDER_ID + SECRET);

        final JsonNode response = WS.url(url).setHeader("accountId", ACCOUNT_ID).setHeader("enckey", enckey)
                .setHeader("orderId", ORDER_ID).get().get(timeout).asJson();
        assertEquals("0", response.get("code").asText());

    }

    @Test
    public void retrieveAll() throws Exception {
        String url = getAdminApiUrl("/customer/list");
        final int timeout = 5000;

        final String enckey = SecurityUtil.generateKeyFromArray(ACCOUNT_ID + ORDER_ID + SECRET);

        final JsonNode response = WS.url(url).setHeader("accountId", ACCOUNT_ID).setHeader("enckey", enckey)
                .setHeader("orderId", ORDER_ID).get().get(timeout).asJson();

        assertEquals("0", response.get("code").asText());
        assertEquals(true, response.get("customerList").isArray());
    }

    @Test
    public void retrieveByRegistrationDate() throws Exception {
        String url = getAdminApiUrl("/customer/getByRegistrationDate/2016-01-03/2016-02-05");
        final int timeout = 5000;

        final String enckey = SecurityUtil.generateKeyFromArray(ACCOUNT_ID + "2016-01-03" + "2016-02-05" + ORDER_ID + SECRET);

        final JsonNode response = WS.url(url).setHeader("accountId", ACCOUNT_ID).setHeader("enckey", enckey)
                .setHeader("orderId", ORDER_ID).get().get(timeout).asJson();

        assertEquals("0", response.get("code").asText());
        assertEquals(true, response.get("customerList").isArray());
    }

    @After
    public void clean() {
        final ConnectionPool connectionPool = app.injector().instanceOf(ConnectionPool.class);
        connectionPool.getConnection().query("delete from " + connectionPool.getSchemaName() + ".customer where id=$1", asList(phone),
                resultSet -> {
                }, throwable -> {
                    throwable.printStackTrace();
                });
    }

}
