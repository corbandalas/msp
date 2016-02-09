package repository;

import model.Customer;
import model.enums.KYC;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import scala.concurrent.Await;
import scala.concurrent.duration.Duration;

import java.text.SimpleDateFormat;
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
            assertNotNull(Await.result(customerRepository.create(new Customer("380953055621", new Date(), "Mr", "Vladimir", "Kuznetsov", "adress1", "adress2", "83004", "Donetsk", "nihilist.don@gmail.com", new Date(), true, KYC.BASIC, "101dog101", "USA")), Duration.apply("1000 ms")));
        } catch (Exception e) {
            fail();
        }
    }

    @Test
    public void update() {
        try {
            Customer customer = new Customer("380953055621", new Date(), "Mr", "Vladimir", "Kuznetsov", "adress1", "adress2", "83004", "Donetsk", "nihilist.don@gmail.com", new Date(), true, KYC.BASIC, "101dog101", "USA");
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
            assertNotNull(Await.result(customerRepository.create(new Customer(phone, new Date(), "Mr", "Vladimir", "Kuznetsov", "adress1", "adress2", "83004", "Donetsk", "nihilist.don@gmail.com", new Date(), true, KYC.BASIC, "101dog101", "USA")), Duration.apply("1000 ms")));
            final Customer customer = Await.result(customerRepository.retrieveById(phone), Duration.apply("1000 ms"));
            assertEquals(phone, customer.getId());
        } catch (Exception e) {
            fail();
        }
    }

    @Test
    public void retrieveAll() throws Exception {
        assertNotNull(Await.result(customerRepository.create(new Customer("380953055621", new Date(), "Mr", "Vladimir", "Kuznetsov", "adress1", "adress2", "83004", "Donetsk", "nihilist.don@gmail.com", new Date(), true, KYC.BASIC, "101dog101", "USA")), Duration.apply("1000 ms")));
        assertNotNull(Await.result(customerRepository.create(new Customer("380953055622", new Date(), "Mr", "Dmitriy", "Kuznetsov", "adress1", "adress2", "83004", "Donetsk", "nihilist.don@gmail.com", new Date(), true, KYC.BASIC, "101dog101", "USA")), Duration.apply("1000 ms")));

        final List<Customer> result = Await.result(customerRepository.retrieveAll(), Duration.apply("1000 ms"));
        assertEquals(2,result.size());
    }


    @Test
    public void retrieveByRegistrationDate() throws Exception {
        Date dsfas= new Date();
        String startDate = "2016-02-03 00:00:00.000";
        String endDate = "2016-03-12 00:00:00.000";
        String dat2 = "2016-02-13 00:000:00.122";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        Date date1 = sdf.parse(startDate);
        Date date2 = sdf.parse(endDate);
        Date date3 = sdf.parse(dat2);


        assertNotNull(Await.result(customerRepository.create(new Customer("380953055621", dsfas, "Mr", "Vladimir", "Kuznetsov", "adress1", "adress2", "83004", "Donetsk", "nihilist.don@gmail.com", new Date(), true, KYC.BASIC, "101dog101", "USA")), Duration.apply("1000 ms")));
        assertNotNull(Await.result(customerRepository.create(new Customer("380953055622", date3, "Mr", "Dmitriy", "Kuznetsov", "adress1", "adress2", "83004", "Donetsk", "nihilist.don@gmail.com", new Date(), true, KYC.BASIC, "101dog101", "USA")), Duration.apply("1000 ms")));

        final List<Customer> result = Await.result(customerRepository.retrieveByRegistrationDate(date1, date2), Duration.apply("1000 ms"));
        assertEquals(2, result.size());
    }



    @After
    public void clean() {
        connectionPool.getConnection().query("delete from " + connectionPool.getSchemaName() + ".customer", resultSet -> {
        }, throwable -> {
            throwable.printStackTrace();
        });
    }

}
