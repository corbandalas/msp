package controllers.customer;

import com.fasterxml.jackson.databind.JsonNode;
import controllers.BaseControllerTest;
import dto.customer.CustomerLogin;
import dto.customer.CustomerRegister;
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
import static org.junit.Assert.assertNotNull;

/**
 * Test for CustomerRegisterController
 *
 * @author corbandalas created 17.02.2016.
 * @since 0.2.0
 */
public class CustomerRegisterControllerTest extends BaseControllerTest {

    private String phone = "380632426303";

    @Test
    public void correctRegister() throws Exception {


        final String url = getCustomerApiUrl("/register");

        final String enckey = SecurityUtil.generateKeyFromArray(ACCOUNT_ID, ORDER_ID, phone, "UA", SECRET);

        CustomerRegister customerRegister = new CustomerRegister();

        customerRegister.setPhone(phone);
        customerRegister.setCountry("UA");

        final JsonNode registerResponse = WS.url(url).setHeader("accountId", ACCOUNT_ID).setHeader("enckey", enckey)
                .setHeader("orderId", ORDER_ID).post(Json.toJson(customerRegister)).get(TIMEOUT).asJson();

        assertEquals("0", registerResponse.get("code").asText());
    }


    @Test
    public void alreadyRegistered() throws Exception {

        correctRegister();

        final String url = getCustomerApiUrl("/register");

        final String enckey = SecurityUtil.generateKeyFromArray(ACCOUNT_ID, ORDER_ID, phone, "UA", SECRET);

        CustomerRegister customerRegister = new CustomerRegister();

        customerRegister.setPhone(phone);
        customerRegister.setCountry("UA");

        final JsonNode registerResponse = WS.url(url).setHeader("accountId", ACCOUNT_ID).setHeader("enckey", enckey)
                .setHeader("orderId", ORDER_ID).post(Json.toJson(customerRegister)).get(TIMEOUT).asJson();

        assertEquals("5", registerResponse.get("code").asText());
    }

    @Test
    public void missingParams() throws Exception {

        final String url = getCustomerApiUrl("/register");

        final String enckey = SecurityUtil.generateKeyFromArray(ACCOUNT_ID, ORDER_ID, phone, "UA", SECRET);

        final JsonNode registerResponse = WS.url(url).setHeader("accountId", ACCOUNT_ID).setHeader("enckey", enckey)
                .setHeader("orderId", ORDER_ID).post(Json.toJson(new Boolean(true))).get(TIMEOUT).asJson();

        assertEquals("1", registerResponse.get("code").asText());
    }


    @Test
    public void wrongRequestParams() throws Exception {

        final String url = getCustomerApiUrl("/register");

        final String enckey = SecurityUtil.generateKeyFromArray(ACCOUNT_ID, ORDER_ID, phone, "UA", SECRET);

        CustomerRegister customerRegister = new CustomerRegister();

        customerRegister.setPhone("");
        customerRegister.setCountry("UA");

        final JsonNode registerResponse = WS.url(url).setHeader("accountId", ACCOUNT_ID).setHeader("enckey", enckey)
                .setHeader("orderId", ORDER_ID).post(Json.toJson(customerRegister)).get(TIMEOUT).asJson();

        assertEquals("2", registerResponse.get("code").asText());
    }

    @Test
    public void wrongEnckey() throws Exception {


        final String url = getCustomerApiUrl("/register");

        final String enckey = SecurityUtil.generateKeyFromArray(ACCOUNT_ID, ORDER_ID, phone, "UA", SECRET);

        CustomerRegister customerRegister = new CustomerRegister();

        customerRegister.setPhone(phone);
        customerRegister.setCountry("404");

        final JsonNode registerResponse = WS.url(url).setHeader("accountId", ACCOUNT_ID).setHeader("enckey", enckey)
                .setHeader("orderId", ORDER_ID).post(Json.toJson(customerRegister)).get(TIMEOUT).asJson();

        assertEquals("3", registerResponse.get("code").asText());
    }

    @Test
    public void wrongCountry() throws Exception {


        final String url = getCustomerApiUrl("/register");

        final String enckey = SecurityUtil.generateKeyFromArray(ACCOUNT_ID, ORDER_ID, phone, "404", SECRET);

        CustomerRegister customerRegister = new CustomerRegister();

        customerRegister.setPhone(phone);
        customerRegister.setCountry("404");

        final JsonNode registerResponse = WS.url(url).setHeader("accountId", ACCOUNT_ID).setHeader("enckey", enckey)
                .setHeader("orderId", ORDER_ID).post(Json.toJson(customerRegister)).get(TIMEOUT).asJson();

        assertEquals("4", registerResponse.get("code").asText());
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
