package repository;

import akka.dispatch.Futures;
import model.*;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import play.Logger;
import scala.concurrent.Await;
import scala.concurrent.Promise;
import scala.concurrent.duration.Duration;

import java.util.Date;
import java.util.List;

import static junit.framework.Assert.assertEquals;
import static junit.framework.TestCase.assertNotNull;

/**
 * Holds payroll requests repository tests
 *
 * @author corbandalas created 27.11.2017.
 * @since 0.5.0
 */
public class PayrollRequestRepositoryTest extends BaseRepositoryTest {

    private PayrollRequestRepository payrollRequestRepository;
    private AccountRepository accountRepository;

    public static final Integer ACCOUNT_1 = 1;
    public static final Integer ACCOUNT_2 = 2;

    @Before
    public void setup() throws Exception {
        payrollRequestRepository = application.injector().instanceOf(PayrollRequestRepository.class);
        accountRepository = application.injector().instanceOf(AccountRepository.class);
        Assert.assertNotNull(Await.result(accountRepository.create(new Account(ACCOUNT_1, "test account from", "USD",
                new Date(), true, "1234567")), Duration.apply(defaultDelay)));
        Assert.assertNotNull(Await.result(accountRepository.create(new Account(ACCOUNT_2, "test account from2", "USD",
                new Date(), true, "1234561")), Duration.apply(defaultDelay)));
    }

    @Test
    public void create() throws Exception {

        PayrollRequest payrollRequest = new PayrollRequest(1L, "orderID", "description", new Date(), "daysequence", ACCOUNT_1, PayrollRequestStatus.REQUESTED);

        PayrollRequest result = Await.result(payrollRequestRepository.create(payrollRequest), Duration.apply("15000 ms"));

        assertNotNull(result);

        assertEquals("01", result.getDaySequence());

        Thread.currentThread().sleep(1000);

        PayrollRequest payrollRequest2 = new PayrollRequest(2L, "orderID", "description", new Date(), "daysequence", ACCOUNT_1, PayrollRequestStatus.REQUESTED);

        PayrollRequest result2 = Await.result(payrollRequestRepository.create(payrollRequest2), Duration.apply("15000 ms"));

        assertNotNull(result2);

        assertEquals("02", result2.getDaySequence());

    }

    @Test
    public void retrieveAndUpdate() throws Exception {

        PayrollRequest payrollRequest = new PayrollRequest(1L, "orderID", "description", new Date(), "daysequence", ACCOUNT_1, PayrollRequestStatus.REQUESTED);

        PayrollRequest result = Await.result(payrollRequestRepository.create(payrollRequest), Duration.apply("15000 ms"));

        assertNotNull(result);

        assertEquals("01", result.getDaySequence());


        payrollRequest.setPayrollRequestStatus(PayrollRequestStatus.CANCELED);

        Await.result(payrollRequestRepository.update(payrollRequest), Duration.apply("15000 ms"));

        PayrollRequest payrollRequest1 = Await.result(payrollRequestRepository.retrieveById(result.getId()), Duration.apply("15000 ms")).get();

        assertNotNull(payrollRequest1);

        assertEquals(PayrollRequestStatus.CANCELED, payrollRequest1.getPayrollRequestStatus());
    }


    @Test
    public void retrieveAll() throws Exception {

        PayrollRequest payrollRequest = new PayrollRequest(1L, "orderID", "description", new Date(), "daysequence", ACCOUNT_1, PayrollRequestStatus.REQUESTED);

        PayrollRequest result = Await.result(payrollRequestRepository.create(payrollRequest), Duration.apply("15000 ms"));

        assertNotNull(result);

        assertEquals("01", result.getDaySequence());

        Thread.currentThread().sleep(1000);

        PayrollRequest payrollRequest2 = new PayrollRequest(2L, "orderID", "description", new Date(), "daysequence", ACCOUNT_1, PayrollRequestStatus.REQUESTED);

        PayrollRequest result2 = Await.result(payrollRequestRepository.create(payrollRequest2), Duration.apply("15000 ms"));

        assertNotNull(result2);

        assertEquals("02", result2.getDaySequence());

        List<PayrollRequest> result1 = Await.result(payrollRequestRepository.retrieveAll(), Duration.apply("15000 ms"));

        assertNotNull(result1);

        assertEquals(2, result1.size());

    }

    @Test
    public void retrieveAllByAccountID() throws Exception {

        PayrollRequest payrollRequest = new PayrollRequest(1L, "orderID", "description", new Date(), "daysequence", ACCOUNT_1, PayrollRequestStatus.REQUESTED);

        PayrollRequest result = Await.result(payrollRequestRepository.create(payrollRequest), Duration.apply("15000 ms"));

        assertNotNull(result);

        assertEquals("01", result.getDaySequence());

        Thread.currentThread().sleep(1000);

        PayrollRequest payrollRequest2 = new PayrollRequest(2L, "orderID", "description", new Date(), "daysequence", ACCOUNT_1, PayrollRequestStatus.REQUESTED);

        PayrollRequest result2 = Await.result(payrollRequestRepository.create(payrollRequest2), Duration.apply("15000 ms"));

        assertNotNull(result2);

        assertEquals("02", result2.getDaySequence());

        List<PayrollRequest> result1 = Await.result(payrollRequestRepository.retrieveAllByAccountID(ACCOUNT_1), Duration.apply("15000 ms"));

        assertNotNull(result1);

        assertEquals(2, result1.size());


        PayrollRequest payrollRequest3 = new PayrollRequest(1L, "orderID", "description", new Date(), "daysequence", ACCOUNT_2, PayrollRequestStatus.REQUESTED);

        PayrollRequest result4 = Await.result(payrollRequestRepository.create(payrollRequest3), Duration.apply("15000 ms"));

        assertNotNull(result4);

        List<PayrollRequest> result5 = Await.result(payrollRequestRepository.retrieveAllByAccountID(ACCOUNT_2), Duration.apply("15000 ms"));

        assertNotNull(result5);

        assertEquals(1, result5.size());

    }

    @After
    public void clean() {
        final Promise<Property> promise = Futures.promise();
        connectionPool.getConnection().query("delete from " + connectionPool.getSchemaName() + ".payroll_request", resultSet -> promise.success(null), promise::failure);
        connectionPool.getConnection().query("delete from " + connectionPool.getSchemaName() + ".account", resultSet -> promise.success(null), promise::failure);
        connectionPool.getConnection().query("delete from " + connectionPool.getSchemaName() + ".payroll_request_sequence", resultSet -> promise.success(null), promise::failure);
        try {
            Await.result(promise.future(), Duration.apply(defaultDelay));
        } catch (Exception e) {
            Logger.error("Error", e);
        }
    }
}
