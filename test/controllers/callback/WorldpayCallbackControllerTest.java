package controllers.callback;

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

    public static final String SOAP_REQUEST = "<?xml version=\"1.0\" encoding=\"utf-8\"?>" +
            "<soap:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"" +
            " xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\"" +
            " xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\">" +
            "<soap:Body>" +
            "<PaymentNotification xmlns=\"http://apilistener.envoyservices.com\">" +
            "<payment>" +
            "<uniqueReference>uniqueReference</uniqueReference>" +
            "<epacsReference>epacsReference</epacsReference>" +
            "<postingDate>date</postingDate>" +
            "<bankAccountNumber>String</bankAccountNumber>" +
            "<bankName>String</bankName>" +
            "<bankCurrency>String</bankCurrency>" +
            "<bankAmount>Double</bankAmount>" +
            "<appliedCurrency>USD</appliedCurrency>" +
            "<appliedAmount>100.00</appliedAmount>" +
            "<countryCode>String</countryCode>" +
            "<bankInformation>String</bankInformation>" +
            "<merchantReference>String</merchantReference>" +
            "<envoyMerchantAccountNumber>String</envoyMerchantAccountNumber>" +
            "<envoyBankAccountNumber>String</envoyBankAccountNumber>" +
            "<itemNumber>%s</itemNumber>" +
            "<statementId>String</statementId>" +
            "<transferType>String</transferType>" +
            "<refererType>String</refererType>" +
            "</payment>" +
            "</PaymentNotification>" +
            "</soap:Body>" +
            "</soap:Envelope>";

    @Test
    public void depositWrongPhone() {

        final WSResponse response = WS.url("http://localhost:" + testServer.port() + "/api/callbacks/worldpay/bankDeposit")
                .setHeader("Content-Type","application/xml").post(String.format(SOAP_REQUEST,"380501234567")).get(TIMEOUT);

        Assert.assertTrue(response.getBody().contains("PaymentNotificationResult"));
    }

    @Test
    public void depositToNew() {

        final WSResponse response = WS.url("http://localhost:" + testServer.port() + "/api/callbacks/worldpay/bankDeposit")
                .setHeader("Content-Type","application/xml").post(String.format(SOAP_REQUEST,PHONE_3_NON_KYC)).get(TIMEOUT);

        Assert.assertTrue(response.getBody().contains("PaymentNotificationResult"));
    }

    @Test
    public void depositToExisting() {

        final WSResponse response = WS.url("http://localhost:" + testServer.port() + "/api/callbacks/worldpay/bankDeposit")
                .setHeader("Content-Type","application/xml").post(String.format(SOAP_REQUEST,PHONE_1)).get(TIMEOUT);

        Assert.assertTrue(response.getBody().contains("PaymentNotificationResult"));
    }
}
