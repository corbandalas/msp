package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import org.junit.Test;
import play.libs.ws.WS;
import play.test.WithServer;
import util.SecurityUtil;

import static org.junit.Assert.assertEquals;

/**
 *
 * Test for CustomerController
 *
 * @author nihilist created 12.02.2016.
 * @since 0.1.0
 */
public class CustomerControllerTest extends WithServer {


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
        assertEquals("83004",response.get("customer").get("postcode").asText());
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

    @Test
    public void update() throws Exception {
        //TODO: later...
    }

    @Test
    public void exchange() throws Exception {
        //TODO: later...
    }

}
