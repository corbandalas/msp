package repository;

import model.Customer;
import model.enums.KYC;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import scala.concurrent.Await;
import scala.concurrent.duration.Duration;

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
            assertNotNull(Await.result(customerRepository.create(new Customer("380953055621", new Date(), "Mr", "Vladimir", "Kuznetsov", "adress1", "adress2", "83004", "Donetsk", "nihilist.don@gmail.com", new Date(), true, KYC.BASIC, "101dog101")), Duration.apply("1000 ms")));
        } catch (Exception e) {
            fail();
        }
    }

    @Test
    public void update() {
        try {
            Customer customer = new Customer("380953055621", new Date(), "Mr", "Vladimir", "Kuznetsov", "adress1", "adress2", "83004", "Donetsk", "nihilist.don@gmail.com", new Date(), true, KYC.BASIC, "101dog101");
            assertNotNull(Await.result(customerRepository.create(customer), Duration.apply("1000 ms")));
            customer.setActive(false);
            customer.setFirstName("Dima");
            assertNotNull(Await.result(customerRepository.update(customer), Duration.apply("1000 ms")));
            final Customer customerUpdated = Await.result(customerRepository.retrieveById("380953055621"), Duration.apply("1000 ms"));
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
            assertNotNull(Await.result(customerRepository.create(new Customer(phone, new Date(), "Mr", "Vladimir", "Kuznetsov", "adress1", "adress2", "83004", "Donetsk", "nihilist.don@gmail.com", new Date(), true, KYC.BASIC, "101dog101")), Duration.apply("1000 ms")));
            final Customer customer = Await.result(customerRepository.retrieveById(phone), Duration.apply("1000 ms"));
            assertEquals(phone, customer.getId());
        } catch (Exception e) {
            fail();
        }
    }

    @Test
    public void retrieveAll() throws Exception {
        assertNotNull(Await.result(customerRepository.create(new Customer("380953055621", new Date(), "Mr", "Vladimir", "Kuznetsov", "adress1", "adress2", "83004", "Donetsk", "nihilist.don@gmail.com", new Date(), true, KYC.BASIC, "101dog101")), Duration.apply("1000 ms")));
        assertNotNull(Await.result(customerRepository.create(new Customer("380953055622", new Date(), "Mr", "Dmitriy", "Kuznetsov", "adress1", "adress2", "83004", "Donetsk", "nihilist.don@gmail.com", new Date(), true, KYC.BASIC, "101dog101")), Duration.apply("1000 ms")));

        final List<Customer> result = Await.result(customerRepository.retrieveAll(), Duration.apply("1000 ms"));
        assertEquals(2,result.size());
    }


    @After
    public void clean() {
        connectionPool.getConnection().query("delete from " + connectionPool.getSchemaName() + ".customer", resultSet -> {
        }, throwable -> {
            throwable.printStackTrace();
        });
    }

}
