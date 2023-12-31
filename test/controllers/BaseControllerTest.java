package controllers;


import akka.dispatch.Futures;
import com.fasterxml.jackson.databind.JsonNode;
import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;
import configs.Constants;
import dto.customer.CustomerLogin;
import model.Account;
import model.Customer;
import model.Operation;
import org.junit.After;
import org.junit.Before;
import play.libs.Json;
import play.libs.ws.WS;
import play.test.WithServer;
import repository.ConnectionPool;
import scala.concurrent.Await;
import scala.concurrent.Promise;
import scala.concurrent.duration.Duration;
import util.SecurityUtil;

import java.sql.Timestamp;
import java.util.Date;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

/**
 * Base API controller test
 *
 * @author corbandalas created 15.02.2016.
 * @since 0.2.0
 */
public class BaseControllerTest extends WithServer {

    public final String ORDER_ID = "1";
    public final String ACCOUNT_ID = "42";
    public final String ACCOUNT_2_ID = "43";
    public final String ACCOUNT_3_ID = "44";
    public final String SECRET = "OMG";
    public final String ACCOUNT_NAME = "God account";
    public final long TIMEOUT = 20000;

    public ConnectionPool connectionPool;

    @Before
    public void init() {
        Config conf = ConfigFactory.load();
        connectionPool = app.injector().instanceOf(ConnectionPool.class);
        connectionPool.setSchemaName(conf.getString("database.test.schema"));
        try {
            insertAccount(ACCOUNT_ID);
            insertAccount(ACCOUNT_2_ID);
            insertAccount(ACCOUNT_3_ID);
        } catch (Exception e) {
            e.printStackTrace();
            fail();
        }
    }

    private void insertAccount(String account_id) throws Exception {
        final ConnectionPool connectionPool = app.injector().instanceOf(ConnectionPool.class);
        final Promise<Object> promise = Futures.promise();
        connectionPool.getConnection().query("INSERT INTO " + connectionPool.getSchemaName() + ".account(id, currency_id, name," +
                        " createdate, active, secret) VALUES ($1, $2, $3, $4, $5, $6)", asList(account_id, "USD", "God account",
                new Timestamp(new Date().getTime()), true, SECRET),
                promise::success, promise::failure);
        Await.result(promise.future(), Duration.apply(TIMEOUT, "ms"));
    }

    @After
    public void delete() throws Exception {
        deleteTransactions();
        deleteAccounts();
    }

    private void deleteTransactions() throws Exception {
        final ConnectionPool connectionPool = app.injector().instanceOf(ConnectionPool.class);
        final Promise<Object> promise = Futures.promise();
        connectionPool.getConnection().query("delete from " + connectionPool.getSchemaName() + ".transaction", promise::success, promise::failure);
        Await.result(promise.future(), Duration.apply(TIMEOUT, "ms"));
    }


    private void deleteAccounts() throws Exception {

        final ConnectionPool connectionPool = app.injector().instanceOf(ConnectionPool.class);
        final Promise<Object> promise = Futures.promise();
        connectionPool.getConnection().query("delete from " + connectionPool.getSchemaName() + ".account where id=$1 or id=$2 or id=$3", asList(ACCOUNT_ID, ACCOUNT_2_ID, ACCOUNT_3_ID),
                promise::success, promise::failure);
        Await.result(promise.future(), Duration.apply(TIMEOUT, "ms"));
    }

    public String getAdminApiUrl(String locaApiUrl) {
        return "http://localhost:" + this.testServer.port() + Constants.ADMIN_API_PATH + locaApiUrl;
    }

    public String getCustomerApiUrl(String locaApiUrl) {
        return "http://localhost:" + this.testServer.port() + Constants.CUSTOMER_API_PATH + locaApiUrl;
    }

    public JsonNode createOperation(Operation operation, int port) {
        final java.lang.String url = getAdminApiUrl("/operation/create");
        final java.lang.String enckey = SecurityUtil.generateKeyFromArray(ACCOUNT_ID, operation.getOrderId(), operation.getDescription(),
                operation.getType().name(), ORDER_ID, SECRET);

        return WS.url(url).setHeader("accountId", ACCOUNT_ID).setHeader("enckey", enckey)
                .setHeader("orderId", ORDER_ID).post(Json.toJson(operation)).get(TIMEOUT).asJson();
    }

    protected JsonNode createCustomer(Customer customer) {
        final String url = getAdminApiUrl("/customer/create");

        final String enckey = SecurityUtil.generateKeyFromArray(ACCOUNT_ID, customer.getId(), customer.getFirstName(), ORDER_ID, SECRET);

        return WS.url(url).setHeader("accountId", ACCOUNT_ID).setHeader("enckey", enckey)
                .setHeader("orderId", ORDER_ID).post(Json.toJson(customer)).get(TIMEOUT).asJson();
    }

    protected JsonNode createAccount(Account account) {
        final String url = getAdminApiUrl("/account/create");
        final String enckey = SecurityUtil.generateKeyFromArray(ACCOUNT_ID, account.getId().toString(), account.getName(), account.getCurrencyId(), ORDER_ID, SECRET);
        return WS.url(url).setHeader("accountId", ACCOUNT_ID).setHeader("enckey", enckey)
                .setHeader("orderId", ORDER_ID).post(Json.toJson(account)).get(TIMEOUT).asJson();
    }

    protected JsonNode authorizeCustomer(String phone, String password) {
        final String url = getCustomerApiUrl("/login");

        final String enckey = SecurityUtil.generateKeyFromArray(ACCOUNT_ID, ORDER_ID, phone, password, SECRET);

        CustomerLogin customerLogin = new CustomerLogin();

        customerLogin.setPhone(phone);
        customerLogin.setHashedPassword(password);

        return WS.url(url).setHeader("accountId", ACCOUNT_ID).setHeader("enckey", enckey)
                .setHeader("orderId", ORDER_ID).post(Json.toJson(customerLogin)).get(TIMEOUT).asJson();
    }
}
