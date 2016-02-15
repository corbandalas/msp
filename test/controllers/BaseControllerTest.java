package controllers;


import com.fasterxml.jackson.databind.JsonNode;
import configs.Constants;
import model.Operation;
import play.libs.Json;
import play.libs.ws.WS;
import play.test.WithServer;
import util.SecurityUtil;

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
    public final String SECRET = "OMG";
    public final String ACCOUNT_NAME = "God account";
    public final long TIMEOUT = 1000;

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
}
