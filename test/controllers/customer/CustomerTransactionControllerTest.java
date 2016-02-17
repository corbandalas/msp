package controllers.customer;

import com.fasterxml.jackson.databind.JsonNode;
import controllers.BaseControllerTest;
import dto.customer.CustomerTransactionFilter;
import model.Customer;
import model.enums.KYC;
import org.junit.Test;
import play.libs.Json;
import play.libs.ws.WS;

import java.util.Date;

import static org.junit.Assert.assertEquals;

/**
 * API customer transaction test
 * @author ra created 17.02.2016.
 * @since 0.1.0
 */
public class CustomerTransactionControllerTest extends BaseControllerTest {

    private String phone = "4524607605";

    @Test
    public void listWrongCard() throws Exception {
        final String password = "hashedpass";
        final JsonNode createResponse = createCustomer(new Customer(phone, new Date(), "Mr", "Ivan", "Petrenko", "adress1", "adress2",
                "83004", "Donetsk", "sao@bao.com", new Date(), true, KYC.FULL_DUE_DILIGENCE, password, "USA"));
        assertEquals("0", createResponse.get("code").asText());

        final JsonNode authorizeResponse = authorizeCustomer(phone, password);
        assertEquals("0", authorizeResponse.get("code").asText());

        final String token = authorizeResponse.get("token").asText();

        final CustomerTransactionFilter request = new CustomerTransactionFilter();
        request.setCardId(1L);
        request.setFromDate("2016-02-17");
        request.setToDate("2016-02-18");

        final JsonNode changeResponse = WS.url(getCustomerApiUrl("/transaction/list")).setHeader("token", token)
                .post(Json.toJson(request)).get(TIMEOUT).asJson();

        assertEquals("4",changeResponse.get("code").asText());
    }
}
