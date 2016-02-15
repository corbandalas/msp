package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import junit.framework.TestCase;
import model.Customer;
import model.Operation;
import model.enums.KYC;
import model.enums.OperationType;
import org.junit.After;
import org.junit.Test;
import play.libs.Json;
import play.libs.ws.WS;
import play.test.WithServer;
import repository.ConnectionPool;
import util.SecurityUtil;

import java.util.Date;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;

/**
 *
 * Test for CustomerController
 *
 * @author nihilist created 12.02.2016.
 * @since 0.1.0
 */
public class CustomerControllerTest extends WithServer {

    private String phone = "380953055623";
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

        final java.lang.String url = "http://localhost:" + this.testServer.port() + "/api/customer/update";
        final int timeout = 1000;

        final java.lang.String accountId = "42";
        final java.lang.String orderId = "1";
        final java.lang.String enckey = SecurityUtil.generateKeyFromArray(accountId, customer.getId(), orderId, "OMG");

        final String updateEnckey = SecurityUtil.generateKeyFromArray(accountId, customer.getId(), orderId, "OMG");

        final JsonNode updateResult = WS.url(url).setHeader("accountId", accountId).setHeader("enckey", updateEnckey)
                .setHeader("orderId", orderId).post(Json.toJson(customer)).get(timeout).asJson();
        TestCase.assertEquals("0", updateResult.get("code").asText());

        final JsonNode afterUpdate = retrieveByPhone(customer.getId());
        TestCase.assertEquals("0", afterUpdate.get("code").asText());
        TestCase.assertEquals(updatedEmail, afterUpdate.get("customer").get("email").asText());
    }

    private JsonNode retrieveByPhone(String phone) {
        final java.lang.String url = "http://localhost:" + this.testServer.port() + "/api/customer/getByPhone/" + phone;
        final int timeout = 1000;

        final java.lang.String accountId = "42";
        final java.lang.String orderId = "1";
        final java.lang.String enckey = SecurityUtil.generateKeyFromArray(accountId, phone, orderId, "OMG");

        return WS.url(url).setHeader("accountId", accountId).setHeader("enckey", enckey)
                .setHeader("orderId", orderId).get().get(timeout).asJson();
    }

    public static JsonNode create(Customer customer, int port) {
        final java.lang.String url = "http://localhost:" + port + "/api/customer/create";
        final int timeout = 1000;

        final java.lang.String accountId = "42";
        final java.lang.String orderId = "1";
        final java.lang.String enckey = SecurityUtil.generateKeyFromArray(accountId, customer.getId(), customer.getFirstName(), orderId, "OMG");

        return WS.url(url).setHeader("accountId", accountId).setHeader("enckey", enckey)
                .setHeader("orderId", orderId).post(Json.toJson(customer)).get(timeout).asJson();
    }

    @Test
    public void retrieveByPhone() throws Exception {
        String url = "http://localhost:" + this.testServer.port() + "/api/customer/getByPhone/380953055621";
        final int timeout = 5000;

        final String accountId="42";
        final String orderId="1";
        final String enckey= SecurityUtil.generateKeyFromArray(accountId+"380953055621"+orderId+"OMG");

        final JsonNode response = WS.url(url).setHeader("accountId", accountId).setHeader("enckey", enckey)
                .setHeader("orderId", orderId).get().get(timeout).asJson();
        assertEquals("0",response.get("code").asText());

        final JsonNode result = retrieveByPhone(response.get("customer").get("id").asText());
        assertEquals("0",result.get("code").asText());
        assertEquals("83004",result.get("customer").get("postcode").asText());
    }

    @Test
    public void retrieveByEmail() throws Exception {
        String url = "http://localhost:" + this.testServer.port() + "/api/customer/getByEmail/".concat(email);
        final int timeout = 5000;

        final String accountId="42";
        final String orderId="1";
        final String enckey= SecurityUtil.generateKeyFromArray(accountId+email+orderId+"OMG");

        final JsonNode response = WS.url(url).setHeader("accountId", accountId).setHeader("enckey", enckey)
                .setHeader("orderId", orderId).get().get(timeout).asJson();
        assertEquals("0",response.get("code").asText());

        final JsonNode result = retrieveByPhone(response.get("customerList").get(1).get("id").asText());
        assertEquals("0",result.get("code").asText());

        assertEquals("83004",result.get("customer").get("postcode").asText());
    }

    @Test
    public void retrieveByKYC() throws Exception {
        String url = "http://localhost:" + this.testServer.port() + "/api/customer/getByKYC/FULL_DUE_DILIGENCE";
        final int timeout = 5000;

        final String accountId="42";
        final String orderId="1";
        final String enckey= SecurityUtil.generateKeyFromArray(accountId+"FULL_DUE_DILIGENCE"+orderId+"OMG");

        final JsonNode response = WS.url(url).setHeader("accountId", accountId).setHeader("enckey", enckey)
                .setHeader("orderId", orderId).get().get(timeout).asJson();
        assertEquals("0",response.get("code").asText());

    }

    @Test
    public void retrieveAll() throws Exception {
        String url = "http://localhost:" + this.testServer.port() + "/api/customer/list";
        final int timeout = 5000;

        final String accountId="42";
        final String orderId="1";
        final String enckey= SecurityUtil.generateKeyFromArray(accountId+orderId+"OMG");

        final JsonNode response = WS.url(url).setHeader("accountId", accountId).setHeader("enckey", enckey)
                .setHeader("orderId", orderId).get().get(timeout).asJson();

        assertEquals("0",response.get("code").asText());
        assertEquals(true,response.get("customerList").isArray());
    }

    @Test
    public void retrieveByRegistrationDate() throws Exception {
        String url = "http://localhost:" + this.testServer.port() + "/api/customer/getByRegistrationDate/2016-01-03/2016-02-05";
        final int timeout = 5000;

        final String accountId="42";
        final String orderId="1";
        final String enckey= SecurityUtil.generateKeyFromArray(accountId+"2016-01-03"+"2016-02-05"+orderId+"OMG");

        final JsonNode response = WS.url(url).setHeader("accountId", accountId).setHeader("enckey", enckey)
                .setHeader("orderId", orderId).get().get(timeout).asJson();

        assertEquals("0",response.get("code").asText());
        assertEquals(true,response.get("customerList").isArray());
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
