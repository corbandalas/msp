package service;

import dto.customer.CustomerPaylikeCreditCardDeposit;
import dto.customer.CustomerPaylikeCreditCardPurchase;
import dto.customer.CustomerWorldPayCreditCardDeposit;
import module.PropertyLoader;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import play.Logger;
import provider.GlobalProcessingCardProvider;
import repository.BaseRepositoryTest;
import repository.CurrencyRepository;
import repository.PropertyRepository;
import services.PaylikePaymentService;
import services.dto.PaylikeTransaction;

import static org.junit.Assert.*;


/**
 * Paylike payment service test
 *
 * @author corbandalas created 01.02.2017.
 * @since 0.4.0
 */

public class PaylikePaymentServiceTest extends BaseRepositoryTest {

    private PropertyRepository propertyRepository;

    private GlobalProcessingCardProvider globalProcessingCardProvider;

    private PaylikePaymentService paylikePaymentService;

    private CurrencyRepository currencyRepository;


    private final long WS_TIMEOUT = 10000000L;

    @Before
    public void setup() {

        propertyRepository = application.injector().instanceOf(PropertyRepository.class);
        paylikePaymentService = application.injector().instanceOf(PaylikePaymentService.class);
        PropertyLoader propertyLoader = application.injector().instanceOf(PropertyLoader.class);
        propertyLoader.load("conf/properties.json", dispatcher);


    }


    @Test
    public void testGetPaymentLink() throws Exception {

        Thread.currentThread().sleep(1000);

        try {

            CustomerPaylikeCreditCardDeposit customerPaylikeCreditCardDeposit = new CustomerPaylikeCreditCardDeposit();

            customerPaylikeCreditCardDeposit.setAmount(1000L);
            customerPaylikeCreditCardDeposit.setCurrency("GBP");
            customerPaylikeCreditCardDeposit.setOrderId("" + System.currentTimeMillis());
            customerPaylikeCreditCardDeposit.setPhone("380632426303");

            String url = paylikePaymentService.getPaymentLinkDeposit(customerPaylikeCreditCardDeposit).get(WS_TIMEOUT);

            assertNotNull(url);

            System.out.println(url);


        } catch (Exception e) {
            Logger.error("Error", e);
            fail();
        }
    }


    @Test
    public void testFetchPaylikeTransaction() throws Exception {

        Thread.currentThread().sleep(1000);

        try {

            String reference = "589b647437c405317cd6523a";

            PaylikeTransaction paylikeTransaction = paylikePaymentService.fetchPaylikeTransaction(reference).get(WS_TIMEOUT);

            assertNotNull(paylikeTransaction);

            assertTrue(paylikeTransaction.getTransaction().getSuccessful());
            assertEquals(paylikeTransaction.getTransaction().getId(), reference);

        } catch (Exception e) {
            Logger.error("Error", e);
            fail();
        }
    }


    @Test
    public void testCapturePaylikeTransaction() throws Exception {

        Thread.currentThread().sleep(1000);

        try {

            String reference = "589b647437c405317cd6523a";

            PaylikeTransaction paylikeTransaction = paylikePaymentService.fetchPaylikeTransaction(reference).get(WS_TIMEOUT);

            assertNotNull(paylikeTransaction);

            assertTrue(paylikeTransaction.getTransaction().getSuccessful());
            assertEquals(paylikeTransaction.getTransaction().getId(), reference);

            PaylikeTransaction paylikeTransaction1 = paylikePaymentService.capturePaylikeTransaction(reference, (long) paylikeTransaction.getTransaction().getAmount(), paylikeTransaction.getTransaction().getCurrency()).get(WS_TIMEOUT);

            assertNotNull(paylikeTransaction1);

            assertTrue(paylikeTransaction1.getTransaction().getSuccessful());
            assertEquals(paylikeTransaction1.getTransaction().getId(), reference);
            assertEquals(paylikeTransaction1.getTransaction().getCapturedAmount(), paylikeTransaction.getTransaction().getAmount());


        } catch (Exception e) {
            Logger.error("Error", e);
            fail();
        }
    }


    @Test
    public void testRefundPaylikeTransaction() throws Exception {

        Thread.currentThread().sleep(1000);

        try {

            String reference = "589b647437c405317cd6523a";

            PaylikeTransaction paylikeTransaction = paylikePaymentService.fetchPaylikeTransaction(reference).get(WS_TIMEOUT);

            assertNotNull(paylikeTransaction);

            assertTrue(paylikeTransaction.getTransaction().getSuccessful());
            assertEquals(paylikeTransaction.getTransaction().getId(), reference);

            PaylikeTransaction paylikeTransaction1 = paylikePaymentService.refundPaylikeTransaction(reference, (long) paylikeTransaction.getTransaction().getAmount()).get(WS_TIMEOUT);

            assertNotNull(paylikeTransaction1);

            assertTrue(paylikeTransaction1.getTransaction().getSuccessful());
            assertEquals(paylikeTransaction1.getTransaction().getId(), reference);
            assertEquals(paylikeTransaction1.getTransaction().getCapturedAmount(), paylikeTransaction.getTransaction().getAmount());


        } catch (Exception e) {
            Logger.error("Error", e);
            fail();
        }
    }


    @After
    public void clean() {
        connectionPool.getConnection().query("delete from " + connectionPool.getSchemaName() + ".property;", resultSet -> {
        }, throwable -> {
            throwable.printStackTrace();
        });
    }


}
