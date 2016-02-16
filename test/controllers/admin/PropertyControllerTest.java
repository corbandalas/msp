package controllers.admin;

import com.fasterxml.jackson.databind.JsonNode;
import controllers.BaseControllerTest;
import model.Property;
import model.PropertyCategory;
import org.junit.After;
import org.junit.Test;
import play.libs.Json;
import play.libs.ws.WS;
import repository.ConnectionPool;
import util.SecurityUtil;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;

/**
 * Holds operation controller tests
 *
 * @author ra created 12.02.2016.
 * @since 0.1.0
 */
public class PropertyControllerTest extends BaseControllerTest {

    private String newPropertyId;

    @Test
    public void retrieveById() throws Exception {
        final JsonNode response = retrieveById("cardprovider.gps.wsdl.soap.header.username");

        assertEquals("0", response.get("code").asText());
        assertEquals("Safepaytest", response.get("property").get("value").asText());
    }

    @Test
    public void retrieveAll() throws Exception {
        final String url = getAdminApiUrl("/property/list");
        final String enckey = SecurityUtil.generateKeyFromArray(ACCOUNT_ID, ORDER_ID, SECRET);

        final JsonNode response = WS.url(url).setHeader("accountId", ACCOUNT_ID).setHeader("enckey", enckey)
                .setHeader("orderId", ORDER_ID).get().get(TIMEOUT).asJson();

        assertEquals("0", response.get("code").asText());
        assertEquals(true, response.get("propertyList").isArray());
    }

    @Test
    public void createAndUpdate() throws Exception {
        final String createUrl = getAdminApiUrl("/property/create");

        newPropertyId = "test.property";

        final String value = "test property value";
        final Property property = new Property(newPropertyId, value, "test property description", PropertyCategory.GPS_INTEGRATION);

        final String enckey = SecurityUtil.generateKeyFromArray(ACCOUNT_ID, property.getId(), property.getValue(),
                property.getDescription(), property.getCategory().name(), ORDER_ID, SECRET);

        final JsonNode createResponse = WS.url(createUrl).setHeader("accountId", ACCOUNT_ID).setHeader("enckey", enckey)
                .setHeader("orderId", ORDER_ID).post(Json.toJson(property)).get(TIMEOUT).asJson();

        assertEquals("0", createResponse.get("code").asText());

        final JsonNode afterCreateResponse = retrieveById(newPropertyId);
        assertEquals("0", afterCreateResponse.get("code").asText());
        assertEquals(value, afterCreateResponse.get("property").get("value").asText());

        final String updateUrl = getAdminApiUrl("/property/update");

        final String newValue = "updated property value";
        property.setValue(newValue);

        final String updateEnckey = SecurityUtil.generateKeyFromArray(ACCOUNT_ID, property.getId(), property.getValue(),
                property.getDescription(), property.getCategory().name(), ORDER_ID, SECRET);
        final JsonNode updateResponse = WS.url(updateUrl).setHeader("accountId", ACCOUNT_ID).setHeader("enckey", updateEnckey)
                .setHeader("orderId", ORDER_ID).post(Json.toJson(property)).get(TIMEOUT).asJson();
        assertEquals("0", updateResponse.get("code").asText());

        final JsonNode afterUpdateResponse = retrieveById(newPropertyId);
        assertEquals("0", afterUpdateResponse.get("code").asText());
        assertEquals(newValue, afterUpdateResponse.get("property").get("value").asText());
    }

    private JsonNode retrieveById(String id) {
        final String url = getAdminApiUrl("/property/get/" + id);
        final String enckey = SecurityUtil.generateKeyFromArray(ACCOUNT_ID, id, ORDER_ID, SECRET);

        return WS.url(url).setHeader("accountId", ACCOUNT_ID).setHeader("enckey", enckey)
                .setHeader("orderId", ORDER_ID).get().get(TIMEOUT).asJson();
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