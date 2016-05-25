package controllers.admin;

import akka.actor.ActorSystem;
import akka.dispatch.Futures;
import com.fasterxml.jackson.databind.JsonNode;
import controllers.BaseControllerTest;
import model.Property;
import model.PropertyCategory;
import module.PropertyLoader;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import play.Logger;
import play.libs.Json;
import play.libs.ws.WS;
import play.libs.ws.WSResponse;
import repository.ConnectionPool;
import scala.concurrent.Await;
import scala.concurrent.Promise;
import scala.concurrent.duration.Duration;
import util.SecurityUtil;

import static configs.ReturnCodes.SUCCESS_CODE;
import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;

/**
 * Holds operation controller tests
 *
 * @author corbandalas created 18.05.2016.
 * @since 0.2.0
 */
public class WorldPayControllerTest extends BaseControllerTest {

    @Before
    public void init() {

        super.init();

        try {

            PropertyLoader propertyLoader = app.injector().instanceOf(PropertyLoader.class);
            propertyLoader.load("conf/properties.json", app.injector().instanceOf(ActorSystem.class).dispatcher());
        } catch (Exception e) {
            Logger.error("Test error", e);
        }
    }

    @Test
    public void getBanks() throws Exception {

        final String country = "uk";

        final String url = getAdminApiUrl("/worldpay/getbanks/" + country);
        final String enckey = SecurityUtil.generateKeyFromArray(ACCOUNT_ID, ORDER_ID, country, SECRET);

        WSResponse wsResponse = WS.url(url).setHeader("accountId", ACCOUNT_ID).setHeader("enckey", enckey)
                .setHeader("orderId", ORDER_ID).get().get(TIMEOUT);

        String body = wsResponse.getBody();

//        final JsonNode response = WS.url(url).setHeader("accountId", ACCOUNT_ID).setHeader("enckey", enckey)
//                .setHeader("orderId", ORDER_ID).get().get(TIMEOUT).asJson();

//        assertEquals(String.valueOf(SUCCESS_CODE), response.get("code").asText());
//        assertEquals(true, response.get("propertyList").isArray());
    }

}
