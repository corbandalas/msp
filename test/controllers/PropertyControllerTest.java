package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import model.Account;
import model.Property;
import model.PropertyCategory;
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
 * Holds operation controller tests
 *
 * @author ra created 12.02.2016.
 * @since 0.1.0
 */
public class PropertyControllerTest extends WithServer {

    private String newPropertyId;

    @Test
    public void retrieveById() throws Exception {
        final JsonNode response = retrieveById("cardprovider.gps.wsdl.soap.header.username");

        assertEquals("0", response.get("code").asText());
        assertEquals("Safepaytest", response.get("property").get("value").asText());
    }

    @Test
    public void retrieveAll() throws Exception {
        final String url = "http://localhost:" + this.testServer.port() + "/api/property/list";
        final int timeout = 1000;

        final String accountId = "42";
        final String orderId = "1";
        final String enckey = SecurityUtil.generateKeyFromArray(accountId, orderId, "OMG");

        final JsonNode response = WS.url(url).setHeader("accountId", accountId).setHeader("enckey", enckey)
                .setHeader("orderId", orderId).get().get(timeout).asJson();

        assertEquals("0", response.get("code").asText());
        assertEquals(true, response.get("propertyList").isArray());
    }

    @Test
    public void createAndUpdate() throws Exception {
        final String createUrl = "http://localhost:" + this.testServer.port() + "/api/property/create";
        final int timeout = 1000;

        newPropertyId = "test.property";

        final String value = "test property value";
        final Property property = new Property(newPropertyId, value, "test property description", PropertyCategory.GPS_INTEGRATION);

        final String accountId = "42";
        final String orderId = "1";
        final String enckey = SecurityUtil.generateKeyFromArray(accountId, property.getId(), property.getValue(),
                property.getDescription(), property.getCategory().name(), orderId, "OMG");

        final JsonNode createResponse = WS.url(createUrl).setHeader("accountId", accountId).setHeader("enckey", enckey)
                .setHeader("orderId", orderId).post(Json.toJson(property)).get(timeout).asJson();

        assertEquals("0", createResponse.get("code").asText());

        final JsonNode afterCreateResponse = retrieveById(newPropertyId);
        assertEquals("0", afterCreateResponse.get("code").asText());
        assertEquals(value, afterCreateResponse.get("property").get("value").asText());

        final String updateUrl = "http://localhost:" + this.testServer.port() + "/api/property/update";

        final String newValue = "updated property value";
        property.setValue(newValue);

        final String updateEnckey = SecurityUtil.generateKeyFromArray(accountId, property.getId(), property.getValue(),
                property.getDescription(), property.getCategory().name(), orderId, "OMG");
        final JsonNode updateResponse = WS.url(updateUrl).setHeader("accountId", accountId).setHeader("enckey", updateEnckey)
                .setHeader("orderId", orderId).post(Json.toJson(property)).get(timeout).asJson();
        assertEquals("0", updateResponse.get("code").asText());

        final JsonNode afterUpdateResponse = retrieveById(newPropertyId);
        assertEquals("0", afterUpdateResponse.get("code").asText());
        assertEquals(newValue, afterUpdateResponse.get("property").get("value").asText());
    }

    private JsonNode retrieveById(String id) {
        final String url = "http://localhost:" + this.testServer.port() + "/api/property/get/" + id;
        final int timeout = 1000;

        final String accountId = "42";
        final String orderId = "1";
        final String enckey = SecurityUtil.generateKeyFromArray(accountId, id, orderId, "OMG");

        return WS.url(url).setHeader("accountId", accountId).setHeader("enckey", enckey)
                .setHeader("orderId", orderId).get().get(timeout).asJson();
    }

    @After
    public void clean() {
        final ConnectionPool connectionPool = app.injector().instanceOf(ConnectionPool.class);
        connectionPool.getConnection().query("delete from " + connectionPool.getSchemaName() + ".property where id=$1", asList(newPropertyId),
                resultSet -> {
                }, throwable -> {
                    throwable.printStackTrace();
                });
    }
}
