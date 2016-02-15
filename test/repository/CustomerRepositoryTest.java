package repository;

import akka.dispatch.Futures;
import model.Account;
import model.Customer;
import model.enums.KYC;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import play.Logger;
import scala.concurrent.Await;
import scala.concurrent.Promise;
import scala.concurrent.duration.Duration;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import static junit.framework.TestCase.assertNotNull;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

/**
 * Holds customer repository tests
 *
 * @author nihilist created 08.02.2016.
 * @since 0.1.0
 */
public class CustomerRepositoryTest extends BaseRepositoryTest {

    private CustomerRepository customerRepository;

    @Before
    public void setup() {
        customerRepository = application.injector().instanceOf(CustomerRepository.class);
    }

    @Test
    public void create() {
        try {
            assertNotNull(Await.result(customerRepository.create(new Customer("380953055621", new Date(), "Mr", "Vladimir", "Kuznetsov", "adress1", "adress2", "83004", "Donetsk", "nihilist.don@gmail.com", new Date(), true, KYC.FULL_DUE_DILIGENCE, "101dog101", "USA")), Duration.apply(defaultDelay)));
        } catch (Exception e) {
            fail();
        }
    }

    @Test
    public void update() {
        try {
            Customer customer = new Customer("380953055621", new Date(), "Mr", "Vladimir", "Kuznetsov", "adress1", "adress2", "83004", "Donetsk", "nihilist.don@gmail.com", new Date(), true, KYC.FULL_DUE_DILIGENCE, "101dog101", "USA");
            assertNotNull(Await.result(customerRepository.create(customer), Duration.apply(defaultDelay)));
            customer.setActive(false);
            customer.setFirstName("Dima");
            assertNotNull(Await.result(customerRepository.update(customer), Duration.apply(defaultDelay)));
            final Customer customerUpdated = Await.result(customerRepository.retrieveById("380953055621"), Duration.apply(defaultDelay));
            assertEquals(false, customerUpdated.getActive());
            assertEquals("Dima", customerUpdated.getFirstName());
        } catch (Exception e) {
            fail();
        }
    }


    @Test
    public void retrieveById() throws Exception {
        try {
            String phone = "380953055621";
            assertNotNull(Await.result(customerRepository.create(new Customer(phone, new Date(), "Mr", "Vladimir", "Kuznetsov", "adress1", "adress2", "83004", "Donetsk", "nihilist.don@gmail.com", new Date(), true, KYC.FULL_DUE_DILIGENCE, "101dog101", "USA")), Duration.apply(defaultDelay)));
            final Customer customer = Await.result(customerRepository.retrieveById(phone), Duration.apply(defaultDelay));
            assertEquals(phone, customer.getId());
        } catch (Exception e) {
            fail();
        }
    }

    @Test
    public void retrieveByIdAndPassword() throws Exception {
        try {
            String phone = "380953055621";
            String password = "101dog101";
            assertNotNull(Await.result(customerRepository.create(new Customer(phone, new Date(), "Mr", "Vladimir", "Kuznetsov", "adress1", "adress2", "83004", "Donetsk", "nihilist.don@gmail.com", new Date(), true, KYC.FULL_DUE_DILIGENCE, password, "USA")), Duration.apply("1000 ms")));
            final Customer customer = Await.result(customerRepository.retrieveByIdAndPassword(phone, password), Duration.apply("1000 ms"));
            assertEquals(phone, customer.getId());
            assertEquals(password, customer.getPassword());
        } catch (Exception e) {
            fail();
        }
    }

    @Test
    public void retrieveAll() throws Exception {
        assertNotNull(Await.result(customerRepository.create(new Customer("380953055621", new Date(), "Mr", "Vladimir", "Kuznetsov", "adress1", "adress2", "83004", "Donetsk", "nihilist.don@gmail.com", new Date(), true, KYC.FULL_DUE_DILIGENCE, "101dog101", "USA")), Duration.apply(defaultDelay)));
        assertNotNull(Await.result(customerRepository.create(new Customer("380953055622", new Date(), "Mr", "Dmitriy", "Kuznetsov", "adress1", "adress2", "83004", "Donetsk", "nihilist.don@gmail.com", new Date(), true, KYC.FULL_DUE_DILIGENCE, "101dog101", "USA")), Duration.apply(defaultDelay)));

        final List<Customer> result = Await.result(customerRepository.retrieveAll(), Duration.apply(defaultDelay));
        assertEquals(2, result.size());
    }

    @Test
    public void retrieveByRegistrationDate() throws Exception {
        Calendar dateUser1 = Calendar.getInstance();
        dateUser1.add(Calendar.DAY_OF_MONTH, -1);

        Calendar dateUser2 = Calendar.getInstance();
        dateUser2.add(Calendar.DAY_OF_MONTH, +11);

        Calendar date_start = Calendar.getInstance();
        date_start.add(Calendar.DAY_OF_MONTH, -10);

        Calendar date_end = Calendar.getInstance();
        date_end.add(Calendar.DAY_OF_MONTH, +10);

        assertNotNull(Await.result(customerRepository.create(new Customer("380953055621", dateUser1.getTime(), "Mr", "Vladimir", "Kuznetsov", "adress1", "adress2", "83004", "Donetsk", "nihilist.don@gmail.com", new Date(), true, KYC.FULL_DUE_DILIGENCE, "101dog101", "USA")), Duration.apply(defaultDelay)));
        assertNotNull(Await.result(customerRepository.create(new Customer("380953055622", dateUser2.getTime(), "Mr", "Dmitriy", "Kuznetsov", "adress1", "adress2", "83004", "Donetsk", "nihilist.don@gmail.com", new Date(), true, KYC.FULL_DUE_DILIGENCE, "101dog101", "USA")), Duration.apply(defaultDelay)));

        final List<Customer> result = Await.result(customerRepository.retrieveByRegistrationDate(date_start.getTime(), date_end.getTime()), Duration.apply(defaultDelay));
        assertEquals(1, result.size());
    }

    @Test
    public void retrieveByKYC() throws Exception {
        assertNotNull(Await.result(customerRepository.create(new Customer("380953055621", new Date(), "Mr", "Vladimir", "Kuznetsov", "adress1", "adress2", "83004", "Donetsk", "nihilist.don@gmail.com", new Date(), true, KYC.FULL_DUE_DILIGENCE, "101dog101", "USA")), Duration.apply(defaultDelay)));
        assertNotNull(Await.result(customerRepository.create(new Customer("380953055622", new Date(), "Mr", "Dmitriy", "Kuznetsov", "adress1", "adress2", "83004", "Donetsk", "nihilist.don@gmail.com", new Date(), true, KYC.FULL_DUE_DILIGENCE, "101dog101", "USA")), Duration.apply(defaultDelay)));
        assertNotNull(Await.result(customerRepository.create(new Customer("380953055623", new Date(), "Mr", "Vladimir", "Kuznetsov", "adress1", "adress2", "83004", "Donetsk", "nihilist.don@gmail.com", new Date(), true, KYC.SIMPLIFIED_DUE_DILIGENCE, "101dog101", "USA")), Duration.apply(defaultDelay)));

        final List<Customer> result = Await.result(customerRepository.retrieveByKYC(KYC.FULL_DUE_DILIGENCE), Duration.apply(defaultDelay));
        assertEquals(2, result.size());
    }


    @Test
    public void retrieveByEmail() throws Exception {
        assertNotNull(Await.result(customerRepository.create(new Customer("380953055621", new Date(), "Mr", "Vladimir", "Kuznetsov", "adress1", "adress2", "83004", "Donetsk", "nihilist.don@gmail.com", new Date(), true, KYC.FULL_DUE_DILIGENCE, "101dog101", "USA")), Duration.apply(defaultDelay)));
        assertNotNull(Await.result(customerRepository.create(new Customer("380953055622", new Date(), "Mr", "Dmitriy", "Kuznetsov", "adress1", "adress2", "83004", "Donetsk", "nihilist.don2@gmail.com", new Date(), true, KYC.FULL_DUE_DILIGENCE, "101dog101", "USA")), Duration.apply(defaultDelay)));

        final List<Customer> result = Await.result(customerRepository.retrieveByEmail("nihilist.don@gmail.com"), Duration.apply(defaultDelay));
        assertEquals(1, result.size());
    }

    @After
    public void clean() {
        final Promise<Customer> promise = Futures.promise();
        connectionPool.getConnection().query("delete from " + connectionPool.getSchemaName() + ".customer", resultSet -> promise.success(null), promise::failure);
        try {
            Await.result(promise.future(), Duration.apply(defaultDelay));
        } catch (Exception e) {
            Logger.error("Error", e);
        }
    }
}
