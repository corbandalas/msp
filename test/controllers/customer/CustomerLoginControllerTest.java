package controllers.customer;

import com.fasterxml.jackson.databind.JsonNode;
import controllers.BaseControllerTest;
import dto.customer.CustomerLogin;
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
import static configs.ReturnCodes.*;

/**
 * Test for CustomerLoginController
 *
 * @author corbandalas created 15.02.2016.
 * @since 0.2.0
 */
public class CustomerLoginControllerTest extends BaseControllerTest {

    private String phone = "4524607605";

    @Test
    public void correctLogin() throws Exception {

        String password = "101dog101";

        final Customer customer = new Customer(phone, new Date(), "Mr", "Ivan", "Petrenko", "adress1", "adress2", "83004", "Donetsk", "sao@bao.com", new Date(), true, KYC.FULL_DUE_DILIGENCE, password, "USA");
        final JsonNode createResult = create(customer);

        TestCase.assertEquals("" + SUCCESS_CODE, createResult.get("code").asText());

        final String url = getCustomerApiUrl("/login");

        final String enckey = SecurityUtil.generateKeyFromArray(ACCOUNT_ID, ORDER_ID, phone, password, SECRET);

        CustomerLogin customerLogin = new CustomerLogin();

        customerLogin.setPhone(phone);
        customerLogin.setHashedPassword(password);

        final JsonNode loginResponse = WS.url(url).setHeader("accountId", ACCOUNT_ID).setHeader("enckey", enckey)
                .setHeader("orderId", ORDER_ID).post(Json.toJson(customerLogin)).get(TIMEOUT).asJson();

        assertEquals("" + SUCCESS_CODE, loginResponse.get("code").asText());
        assertNotNull(loginResponse.get("token").asText());
    }


    @Test
    public void incorrectLogin() throws Exception {

        String password = "101dog101";
        String password2 = "101dog10";

        final Customer customer = new Customer(phone, new Date(), "Mr", "Ivan", "Petrenko", "adress1", "adress2", "83004", "Donetsk", "sao@bao.com", new Date(), true, KYC.FULL_DUE_DILIGENCE, password, "USA");
        final JsonNode createResult = create(customer);

        TestCase.assertEquals("" + SUCCESS_CODE, createResult.get("code").asText());

        final String url = getCustomerApiUrl("/login");

        final String enckey = SecurityUtil.generateKeyFromArray(ACCOUNT_ID, ORDER_ID, phone, password2, SECRET);

        CustomerLogin customerLogin = new CustomerLogin();

        customerLogin.setPhone(phone);
        customerLogin.setHashedPassword(password2);

        final JsonNode loginResponse = WS.url(url).setHeader("accountId", ACCOUNT_ID).setHeader("enckey", enckey)
                .setHeader("orderId", ORDER_ID).post(Json.toJson(customerLogin)).get(TIMEOUT).asJson();

        assertEquals("" + PASSWORD_MISMATCH_CODE, loginResponse.get("code").asText());


        customerLogin = new CustomerLogin();

        customerLogin.setPhone(phone + "1");
        customerLogin.setHashedPassword(password2);

        final String enckey2 = SecurityUtil.generateKeyFromArray(ACCOUNT_ID, ORDER_ID, phone + "1", password2, SECRET);

        final JsonNode loginResponse2 = WS.url(url).setHeader("accountId", ACCOUNT_ID).setHeader("enckey", enckey2)
                .setHeader("orderId", ORDER_ID).post(Json.toJson(customerLogin)).get(TIMEOUT).asJson();

        assertEquals("" + WRONG_CUSTOMER_ACCOUNT_CODE, loginResponse2.get("code").asText());
    }

    private JsonNode create(Customer customer) {
        final String url = getAdminApiUrl("/customer/create");

        final String enckey = SecurityUtil.generateKeyFromArray(ACCOUNT_ID, customer.getId(), customer.getFirstName(), ORDER_ID, SECRET);

        return WS.url(url).setHeader("accountId", ACCOUNT_ID).setHeader("enckey", enckey)
                .setHeader("orderId", ORDER_ID).post(Json.toJson(customer)).get(TIMEOUT).asJson();
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
