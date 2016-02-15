package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import junit.framework.TestCase;
import model.Card;
import model.Customer;
import model.enums.CardBrand;
import model.enums.CardType;
import model.enums.KYC;
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
 * Test for CardController
 *
 * @author nihilist created 15.02.2016.
 * @since 0.1.0
 */
public class CardControllerTest extends WithServer {

    private String customer_id = "380953055621";
    private String alias = "alias";
    private String newCardId;

    @Test
    public void createAndUpdate() throws Exception {
        final Card card = new Card(null,"token", customer_id, CardType.VIRTUAL, CardBrand.VISA, true, new Date(),alias, true, "info", "USD", "adress1", "adress2", "adress3", "USA");
        final JsonNode createResult = create(card, this.testServer.port());

        TestCase.assertEquals("0", createResult.get("code").asText());

        final JsonNode afterCreate = retrieveById(createResult.get("card").get("id").asText());
        TestCase.assertEquals("0", afterCreate.get("code").asText());
        TestCase.assertEquals(customer_id, afterCreate.get("card").get("customerId").asText());

        newCardId = afterCreate.get("card").get("id").asText();
        card.setId(afterCreate.get("card").get("id").asLong());

        final String updatedAlias = "alias_new";
        card.setAlias(updatedAlias);

        final String url = "http://localhost:" + this.testServer.port() + "/api/card/update";
        final int timeout = 1000;

        final String accountId = "42";
        final String orderId = "1";

        final String updateEnckey = SecurityUtil.generateKeyFromArray(accountId, card.getId().toString(), orderId, "OMG");

        final JsonNode updateResult = WS.url(url).setHeader("accountId", accountId).setHeader("enckey", updateEnckey)
                .setHeader("orderId", orderId).post(Json.toJson(card)).get(timeout).asJson();
        TestCase.assertEquals("0", updateResult.get("code").asText());

        final JsonNode afterUpdate = retrieveById(newCardId);
        TestCase.assertEquals("0", afterUpdate.get("code").asText());
        TestCase.assertEquals(updatedAlias, afterUpdate.get("card").get("alias").asText());
    }

    private JsonNode retrieveById(String id) {
        final String url = "http://localhost:" + this.testServer.port() + "/api/card/get/" + id;
        final int timeout = 1000;

        final String accountId = "42";
        final String orderId = "1";
        final String enckey = SecurityUtil.generateKeyFromArray(accountId, id, orderId, "OMG");

        return WS.url(url).setHeader("accountId", accountId).setHeader("enckey", enckey)
                .setHeader("orderId", orderId).get().get(timeout).asJson();
    }

    public static JsonNode create(Card card, int port) {
        final String url = "http://localhost:" + port + "/api/card/create";
        final int timeout = 1000;

        final String accountId = "42";
        final String orderId = "1";
        final String enckey = SecurityUtil.generateKeyFromArray(accountId, card.getCustomerId(), orderId, "OMG");

        return WS.url(url).setHeader("accountId", accountId).setHeader("enckey", enckey)
                .setHeader("orderId", orderId).post(Json.toJson(card)).get(timeout).asJson();
    }

    @Test
    public void retrieveAll() throws Exception {
        String url = "http://localhost:" + this.testServer.port() + "/api/card/list";
        final int timeout = 5000;

        final String accountId="42";
        final String orderId="1";
        final String enckey= SecurityUtil.generateKeyFromArray(accountId+orderId+"OMG");

        final JsonNode response = WS.url(url).setHeader("accountId", accountId).setHeader("enckey", enckey)
                .setHeader("orderId", orderId).get().get(timeout).asJson();

        assertEquals("0",response.get("code").asText());
        assertEquals(true,response.get("cardList").isArray());
    }

    @Test
    public void retrieveByCustomerID() throws Exception {
        String url = "http://localhost:" + this.testServer.port() + "/api/card/getByCustomerID/".concat(customer_id);
        final int timeout = 5000;

        final String accountId="42";
        final String orderId="1";
        final String enckey= SecurityUtil.generateKeyFromArray(accountId+customer_id+orderId+"OMG");

        final JsonNode response = WS.url(url).setHeader("accountId", accountId).setHeader("enckey", enckey)
                .setHeader("orderId", orderId).get().get(timeout).asJson();
        assertEquals("0",response.get("code").asText());
        assertEquals(true,response.get("cardList").isArray());
    }

    @Test
    public void retrieveByCardType() throws Exception {
        String url = "http://localhost:" + this.testServer.port() + "/api/card/getByCardType/VIRTUAL";
        final int timeout = 5000;

        final String accountId="42";
        final String orderId="1";
        final String enckey= SecurityUtil.generateKeyFromArray(accountId+"VIRTUAL"+orderId+"OMG");

        final JsonNode response = WS.url(url).setHeader("accountId", accountId).setHeader("enckey", enckey)
                .setHeader("orderId", orderId).get().get(timeout).asJson();
        assertEquals("0",response.get("code").asText());
        assertEquals(true,response.get("cardList").isArray());
    }

    @Test
    public void retrieveByCardBrand() throws Exception {
        String url = "http://localhost:" + this.testServer.port() + "/api/card/getByCardBrand/VISA";
        final int timeout = 5000;

        final String accountId="42";
        final String orderId="1";
        final String enckey= SecurityUtil.generateKeyFromArray(accountId+"VISA"+orderId+"OMG");

        final JsonNode response = WS.url(url).setHeader("accountId", accountId).setHeader("enckey", enckey)
                .setHeader("orderId", orderId).get().get(timeout).asJson();
        assertEquals("0",response.get("code").asText());
        assertEquals(true,response.get("cardList").isArray());
    }

    @After
    public void clean() {
        final ConnectionPool connectionPool = app.injector().instanceOf(ConnectionPool.class);
        connectionPool.getConnection().query("delete from " + connectionPool.getSchemaName() + ".card where id=$1", asList(newCardId),
                resultSet -> {
                }, throwable -> {
                    throwable.printStackTrace();
                });
    }

}
