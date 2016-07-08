package service;

import com.envoyservices.merchantapi.BankDetailsResponseV2;
import dto.customer.CustomerWorldPayCreditCardDeposit;
import dto.customer.CustomerWorldPayCreditCardPurchase;
import module.PropertyLoader;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import play.Logger;
import play.libs.F;
import provider.GlobalProcessingCardProvider;
import repository.BaseRepositoryTest;
import repository.CurrencyRepository;
import repository.PropertyRepository;
import services.WorldPayPaymentService;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;


/**
 * WorldPay payment service test
 *
 * @author corbandalas created 08.06.2016.
 * @since 0.3.0
 */

public class WorldPayPaymentServiceTest extends BaseRepositoryTest {

    private PropertyRepository propertyRepository;

    private GlobalProcessingCardProvider globalProcessingCardProvider;

    private WorldPayPaymentService worldPayPaymentService;

    private CurrencyRepository currencyRepository;


    private final long WS_TIMEOUT = 10000000L;

    @Before
    public void setup() {

        propertyRepository = application.injector().instanceOf(PropertyRepository.class);
        worldPayPaymentService = application.injector().instanceOf(WorldPayPaymentService.class);
        PropertyLoader propertyLoader = application.injector().instanceOf(PropertyLoader.class);
        propertyLoader.load("conf/properties.json", dispatcher);


    }


    @Test
    public void testGetBanks() throws Exception {

        Thread.currentThread().sleep(1000);

        try {

            BankDetailsResponseV2 bankDetailsResponseV2 = worldPayPaymentService.getBankDetails("UK").get(WS_TIMEOUT);

            assertNotNull(bankDetailsResponseV2);
//            assertNotNull(cardCreationResponse.getToken());
//            assertEquals(cardCreationResponse.getLoadValue(), (double) amount / 100, 0.0001);

        } catch (Exception e) {
            Logger.error("Error", e);
            fail();
        }
    }


    @Test
    public void testDepositInitHostedPage() throws Exception {

        Thread.currentThread().sleep(1000);

        try {


            CustomerWorldPayCreditCardDeposit customerWorldPayCreditCardDeposit = new CustomerWorldPayCreditCardDeposit();

            customerWorldPayCreditCardDeposit.setAmount(1000L);
            customerWorldPayCreditCardDeposit.setCurrency("GBP");
            customerWorldPayCreditCardDeposit.setCancelURL("https://google.com");
            customerWorldPayCreditCardDeposit.setCardTo(null);
            customerWorldPayCreditCardDeposit.setFailURL("https://google.com");
            customerWorldPayCreditCardDeposit.setOrderId("" + System.currentTimeMillis());
            customerWorldPayCreditCardDeposit.setPhone("380632426303");
            customerWorldPayCreditCardDeposit.setSuccessURL("https://google.com");


            F.Tuple<String, String> stringStringTuple = worldPayPaymentService.initDepositHostedtWorldPayPayment(customerWorldPayCreditCardDeposit).get(WS_TIMEOUT);

            assertNotNull(stringStringTuple);
            assertNotNull(stringStringTuple._1);
            assertNotNull(stringStringTuple._2);

        } catch (Exception e) {
            Logger.error("Error", e);
            fail();
        }
    }


    @Test
    public void testPurchaseInitHostedPage() throws Exception {

        Thread.currentThread().sleep(1000);

        try {


            CustomerWorldPayCreditCardPurchase customerWorldPayCreditCardDeposit = new CustomerWorldPayCreditCardPurchase();

            customerWorldPayCreditCardDeposit.setAmount(1000L);
            customerWorldPayCreditCardDeposit.setCurrency("GBP");
            customerWorldPayCreditCardDeposit.setCancelURL("https://google.com");
            customerWorldPayCreditCardDeposit.setFailURL("https://google.com");
            customerWorldPayCreditCardDeposit.setOrderId("" + System.currentTimeMillis());
            customerWorldPayCreditCardDeposit.setPhone("380632426303");
            customerWorldPayCreditCardDeposit.setSuccessURL("https://google.com");


            F.Tuple<String, String> stringStringTuple = worldPayPaymentService.initPurchaseHostedtWorldPayPayment(customerWorldPayCreditCardDeposit, 1000L).get(WS_TIMEOUT);

            assertNotNull(stringStringTuple);
            assertNotNull(stringStringTuple._1);
            assertNotNull(stringStringTuple._2);

        } catch (Exception e) {
            Logger.error("Error", e);
            fail();
        }
    }

//    @Test
//    public void testWrongOrderPurchaseInitHostedPage() throws Exception {
//
//        Thread.currentThread().sleep(1000);
//
//        try {
//
//
//            CustomerWorldPayCreditCardPurchase customerWorldPayCreditCardDeposit = new CustomerWorldPayCreditCardPurchase();
//
//            customerWorldPayCreditCardDeposit.setAmount(1000L);
//            customerWorldPayCreditCardDeposit.setCurrency("GBP");
//            customerWorldPayCreditCardDeposit.setCancelURL("https://google.com");
//            customerWorldPayCreditCardDeposit.setFailURL("https://google.com");
//            customerWorldPayCreditCardDeposit.setOrderId("" + 123);
//            customerWorldPayCreditCardDeposit.setPhone("380632426303");
//            customerWorldPayCreditCardDeposit.setSuccessURL("https://google.com");
//
//
//            F.Tuple<String, String> stringStringTuple = worldPayPaymentService.initPurchaseHostedtWorldPayPayment(customerWorldPayCreditCardDeposit, 1000L).get(WS_TIMEOUT);
//
//            assertNotNull(stringStringTuple);
//            assertNotNull(stringStringTuple._1);
//            assertNotNull(stringStringTuple._2);
//
//
//            stringStringTuple = worldPayPaymentService.initPurchaseHostedtWorldPayPayment(customerWorldPayCreditCardDeposit, 1000L).get(WS_TIMEOUT);
//
//            assertNotNull(stringStringTuple);
//            assertNotNull(stringStringTuple._1);
//            assertNotNull(stringStringTuple._2);
//
//        } catch (Exception e) {
//            Logger.error("Error", e);
//            fail();
//        }
//    }

    @After
    public void clean() {
        connectionPool.getConnection().query("delete from " + connectionPool.getSchemaName() + ".property;", resultSet -> {
        }, throwable -> {
            throwable.printStackTrace();
        });
    }



}
