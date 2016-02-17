package controllers.admin;

import akka.dispatch.Futures;
import com.fasterxml.jackson.databind.JsonNode;
import controllers.BaseControllerTest;
import junit.framework.TestCase;
import model.Card;
import model.Customer;
import model.Operation;
import model.enums.CardBrand;
import model.enums.CardType;
import model.enums.KYC;
import org.junit.After;
import org.junit.Test;
import play.Logger;
import play.libs.Json;
import play.libs.ws.WS;
import repository.ConnectionPool;
import scala.concurrent.Await;
import scala.concurrent.Promise;
import scala.concurrent.duration.Duration;
import util.SecurityUtil;

import java.util.Date;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;

/**
 * Test for CardController
 *
 * @author nihilist created 15.02.2016.
 * @since 0.1.0
 */
public class CardControllerTest extends BaseControllerTest {

    private String customer_id = "380953055621";
    private String alias = "alias";
    private String newCardId;

    @Test
    public void createAndUpdate() throws Exception {
        final Customer customer = new Customer(customer_id, new Date(), "Mr", "Vladimir", "Kuznetsov", "adress1", "adress2", "83004", "Donetsk", "nihilist.don@gmail.com", new Date(), true, KYC.FULL_DUE_DILIGENCE, "101dog101", "USA");
        final JsonNode createResultCustomer = createCustomer(customer);
        TestCase.assertEquals("0", createResultCustomer.get("code").asText());

        final Card card = new Card(null, "token", customer_id, CardType.VIRTUAL, CardBrand.VISA, true, new Date(), alias, true, "info", "USD", "adress1", "adress2", "adress3", "USA");
        final JsonNode createResult = create(card, this.testServer.port());

        TestCase.assertEquals("0", createResult.get("code").asText());

        final JsonNode afterCreate = retrieveById(createResult.get("card").get("id").asText());
        TestCase.assertEquals("0", afterCreate.get("code").asText());
        TestCase.assertEquals(customer_id, afterCreate.get("card").get("customerId").asText());

        newCardId = afterCreate.get("card").get("id").asText();
        card.setId(afterCreate.get("card").get("id").asLong());

        final String updatedAlias = "alias_new";
        card.setAlias(updatedAlias);

        final String url = getAdminApiUrl("/card/update");


        final String updateEnckey = SecurityUtil.generateKeyFromArray(ACCOUNT_ID, card.getId().toString(), ORDER_ID, SECRET);

        final JsonNode updateResult = WS.url(url).setHeader("accountId", ACCOUNT_ID).setHeader("enckey", updateEnckey)
                .setHeader("orderId", ORDER_ID).post(Json.toJson(card)).get(TIMEOUT).asJson();
        TestCase.assertEquals("0", updateResult.get("code").asText());

        final JsonNode afterUpdate = retrieveById(newCardId);
        TestCase.assertEquals("0", afterUpdate.get("code").asText());
        TestCase.assertEquals(updatedAlias, afterUpdate.get("card").get("alias").asText());
    }

    private JsonNode retrieveById(String id) {
        final String url = getAdminApiUrl("/card/get/" + id);

        final String accountId = ACCOUNT_ID;
        final String enckey = SecurityUtil.generateKeyFromArray(accountId, id, ORDER_ID, SECRET);

        return WS.url(url).setHeader("accountId", accountId).setHeader("enckey", enckey)
                .setHeader("orderId", ORDER_ID).get().get(TIMEOUT).asJson();
    }

    public JsonNode create(Card card, int port) {
        final String url = getAdminApiUrl("/card/create");

        final String accountId = ACCOUNT_ID;
        final String enckey = SecurityUtil.generateKeyFromArray(accountId, card.getCustomerId(), ORDER_ID, SECRET);

        return WS.url(url).setHeader("accountId", accountId).setHeader("enckey", enckey)
                .setHeader("orderId", ORDER_ID).post(Json.toJson(card)).get(TIMEOUT).asJson();
    }

    @Test
    public void retrieveAll() throws Exception {
        String url = getAdminApiUrl("/card/list");
        final int timeout = 5000;

        final String enckey = SecurityUtil.generateKeyFromArray(ACCOUNT_ID + ORDER_ID + SECRET);

        final JsonNode response = WS.url(url).setHeader("accountId", ACCOUNT_ID).setHeader("enckey", enckey)
                .setHeader("orderId", ORDER_ID).get().get(timeout).asJson();

        assertEquals("0", response.get("code").asText());
        assertEquals(true, response.get("cardList").isArray());
    }

    @Test
    public void retrieveByCustomerID() throws Exception {
        String url = getAdminApiUrl("/card/getByCustomerID/".concat(customer_id));
        final int timeout = 5000;

        final String enckey = SecurityUtil.generateKeyFromArray(ACCOUNT_ID + customer_id + ORDER_ID + SECRET);

        final JsonNode response = WS.url(url).setHeader("accountId", ACCOUNT_ID).setHeader("enckey", enckey)
                .setHeader("orderId", ORDER_ID).get().get(timeout).asJson();
        assertEquals("0", response.get("code").asText());
        assertEquals(true, response.get("cardList").isArray());
    }

    @Test
    public void retrieveByCardType() throws Exception {
        String url = getAdminApiUrl("/card/getByCardType/VIRTUAL");
        final int timeout = 5000;

        final String enckey = SecurityUtil.generateKeyFromArray(ACCOUNT_ID + "VIRTUAL" + ORDER_ID + SECRET);

        final JsonNode response = WS.url(url).setHeader("accountId", ACCOUNT_ID).setHeader("enckey", enckey)
                .setHeader("orderId", ORDER_ID).get().get(timeout).asJson();
        assertEquals("0", response.get("code").asText());
        assertEquals(true, response.get("cardList").isArray());
    }

    @Test
    public void retrieveByCardBrand() throws Exception {
        String url = getAdminApiUrl("/card/getByCardBrand/VISA");
        final int timeout = 5000;

        final String enckey = SecurityUtil.generateKeyFromArray(ACCOUNT_ID + "VISA" + ORDER_ID + SECRET);

        final JsonNode response = WS.url(url).setHeader("accountId", ACCOUNT_ID).setHeader("enckey", enckey)
                .setHeader("orderId", ORDER_ID).get().get(timeout).asJson();
        assertEquals("0", response.get("code").asText());
        assertEquals(true, response.get("cardList").isArray());
    }

    @After
    public void clean() {
        final Promise<Operation> promise = Futures.promise();
        connectionPool.getConnection().query("delete from " + connectionPool.getSchemaName() + ".card; delete from " + connectionPool.getSchemaName() + ".customer", resultSet -> promise.success(null), promise::failure);
        try {
            Await.result(promise.future(), Duration.apply(String.valueOf(TIMEOUT)));
        } catch (Exception e) {
            Logger.error("Error", e);
        }
    }

}
