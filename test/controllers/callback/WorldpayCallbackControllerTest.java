package controllers.callback;

import controllers.BaseControllerTest;
import controllers.customer.BaseCustomerControllerTest;
import org.junit.Assert;
import org.junit.Test;
import play.libs.ws.WS;
import play.libs.ws.WSResponse;

/**
 * Worldpay callback controller test
 *
 * @author ra - created 24.05.2016.
 * @since 0.2.0
 */
public class WorldpayCallbackControllerTest extends BaseCustomerControllerTest {

    public static final String SOAP_REQUEST = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
            "<soap:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"\n" +
            "xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\"\n" +
            "xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\">\n" +
            " <soap:Body>\n" +
            " <PaymentNotification xmlns=\"http://apilistener.envoyservices.com\">\n" +
            " <payment>\n" +
            " <uniqueReference>uniqueReference</uniqueReference>\n" +
            " <epacsReference>epacsReference</epacsReference>\n" +
            " <postingDate>date</postingDate>\n" +
            " <bankAccountNumber>String</bankAccountNumber>\n" +
            " <bankName>String</bankName>\n" +
            " <bankCurrency>String</bankCurrency>\n" +
            " <bankAmount>Double</bankAmount>\n" +
            " <appliedCurrency>String</appliedCurrency>\n" +
            " <appliedAmount>Double</appliedAmount>\n" +
            " <countryCode>String</countryCode>\n" +
            " <bankInformation>String</bankInformation>\n" +
            " <merchantReference>String</merchantReference>\n" +
            " <envoyMerchantAccountNumber>String</envoyMerchantAccountNumber>\n" +
            " <envoyBankAccountNumber>String</envoyBankAccountNumber>\n" +
            " <itemNumber>%s</itemNumber>\n" +
            " <statementId>String</statementId>\n" +
            " <transferType>String</transferType>\n" +
            " <refererType>String</refererType>\n" +
            " </payment>\n" +
            " </PaymentNotification>\n" +
            " </soap:Body>\n" +
            "</soap:Envelope>";

    @Test
    public void depositWrongPhone() {

        final WSResponse response = WS.url("http://localhost:" + testServer.port() + "/api/callbacks/worldpay/deposit")
                .post(String.format(SOAP_REQUEST,"380501234567")).get(TIMEOUT);

        Assert.assertTrue(response.getBody().contains("PaymentNotificationResult"));
    }

    @Test
    public void depositToNewCard() {

        final WSResponse response = WS.url("http://localhost:" + testServer.port() + "/api/callbacks/worldpay/deposit")
                .post(String.format(SOAP_REQUEST,PHONE_1)).get(TIMEOUT);

        Assert.assertTrue(response.getBody().contains("PaymentNotificationResult"));
    }
}
