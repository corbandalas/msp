package repository;

import akka.dispatch.Futures;
import model.Account;
import model.Card;
import model.Customer;
import model.enums.CardBrand;
import model.enums.CardType;
import model.enums.KYC;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import play.Logger;
import scala.concurrent.Await;
import scala.concurrent.Promise;
import scala.concurrent.duration.Duration;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import static junit.framework.TestCase.assertNotNull;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

/**
 * Holds card repository tests
 *
 * @author nihilist created 08.02.2016.
 * @since 0.1.0
 */
public class CardRepositoryTest extends BaseRepositoryTest {

    private CardRepository cardRepository;
    private CustomerRepository customerRepository;

    @Before
    public void setup() {
        cardRepository = application.injector().instanceOf(CardRepository.class);
        customerRepository = application.injector().instanceOf(CustomerRepository.class);
    }

    @Test
    public void create() {
        try {
            Customer customer = Await.result(customerRepository.create(new Customer("380953055621", new Date(), "Mr", "Vladimir", "Kuznetsov", "adress1", "adress2", "83004", "Donetsk", "nihilist.don@gmail.com", new Date(), true, KYC.FULL_DUE_DILIGENCE, "101dog101", "USA")), Duration.apply(defaultDelay));
            assertNotNull(customer);
            final Card card = Await.result(cardRepository.create(new Card(null,"token",customer.getId(), CardType.VIRTUAL, CardBrand.VISA, true, new Date(),"alias", true, "info", "USD", "adress1", "adress2", "adress3", "USA")), Duration.apply(defaultDelay));
            assertNotNull(card.getId());
        } catch (Exception e) {
            Logger.error("Error", e);
            fail();
        }
    }

    @Test
    public void update() {
        try {
            Customer customer = Await.result(customerRepository.create(new Customer("380953055621", new Date(), "Mr", "Vladimir", "Kuznetsov", "adress1", "adress2", "83004", "Donetsk", "nihilist.don@gmail.com", new Date(), true, KYC.FULL_DUE_DILIGENCE, "101dog101", "USA")), Duration.apply(defaultDelay));
            assertNotNull(customer);
            Card card = Await.result(cardRepository.create(new Card(null,"token",customer.getId(), CardType.VIRTUAL, CardBrand.VISA, true, new Date(),"alias", true, "info", "USD", "adress1", "adress2", "adress3", "USA")), Duration.apply(defaultDelay));
            assertNotNull(card.getId());
            card.setActive(false);
            card.setBrand(CardBrand.MASTERCARD);
            final Card newCard = Await.result(cardRepository.update(card), Duration.apply(defaultDelay));
            final Optional<Card> updatedCard = Await.result(cardRepository.retrieveById(newCard.getId()), Duration.apply(defaultDelay));
            assertEquals(false, updatedCard.get().getActive());
            assertEquals(CardBrand.MASTERCARD, updatedCard.get().getBrand());
        } catch (Exception e) {
            Logger.error("Error", e);
            fail();
        }
    }


    @Test
    public void retrieveById() throws Exception {
        try {
            Customer customer = Await.result(customerRepository.create(new Customer("380953055621", new Date(), "Mr", "Vladimir", "Kuznetsov", "adress1", "adress2", "83004", "Donetsk", "nihilist.don@gmail.com", new Date(), true, KYC.FULL_DUE_DILIGENCE, "101dog101", "USA")), Duration.apply(defaultDelay));
            assertNotNull(customer);
            Card card = Await.result(cardRepository.create(new Card(null,"token",customer.getId(), CardType.VIRTUAL, CardBrand.VISA, true, new Date(),"alias", true, "info", "USD", "adress1", "adress2", "adress3", "USA")), Duration.apply(defaultDelay));
            assertNotNull(card.getId());

            final Optional<Card> cardById = Await.result(cardRepository.retrieveById(card.getId()), Duration.apply(defaultDelay));
            assertEquals(cardById.get().getId(), card.getId());
        } catch (Exception e) {
            Logger.error("Error", e);
            fail();
        }
    }


    @Test
    public void retrieveDefaultCard() throws Exception {
        try {
            Customer customer = Await.result(customerRepository.create(new Customer("380953055621", new Date(), "Mr", "Vladimir", "Kuznetsov", "adress1", "adress2", "83004", "Donetsk", "nihilist.don@gmail.com", new Date(), true, KYC.FULL_DUE_DILIGENCE, "101dog101", "USA")), Duration.apply(defaultDelay));
            assertNotNull(customer);
            Card card = Await.result(cardRepository.create(new Card(null,"token",customer.getId(), CardType.VIRTUAL, CardBrand.VISA, true, new Date(),"alias", true, "info", "USD", "adress1", "adress2", "adress3", "USA", true)), Duration.apply(defaultDelay));

            Optional<Card> defaultCard = Await.result(cardRepository.retrieveDefaultCard(customer.getId()), Duration.apply(defaultDelay));
            assertNotNull(defaultCard.get());
            assertEquals(card.getId(), defaultCard.get().getId());

            Card card2 = Await.result(cardRepository.create(new Card(null,"token",customer.getId(), CardType.VIRTUAL, CardBrand.VISA, true, new Date(),"alias", true, "info", "USD", "adress1", "adress2", "adress3", "USA", false)), Duration.apply(defaultDelay));

            Optional<Card> defaultCard2 = Await.result(cardRepository.retrieveDefaultCard(customer.getId()), Duration.apply(defaultDelay));

            assertEquals(defaultCard2.get().getId(), defaultCard.get().getId());

        } catch (Exception e) {
            Logger.error("Error", e);
            fail();
        }
    }

    @Test
    public void retrieveAll() throws Exception {
        Customer customer = Await.result(customerRepository.create(new Customer("380953055621", new Date(), "Mr", "Vladimir", "Kuznetsov", "adress1", "adress2", "83004", "Donetsk", "nihilist.don@gmail.com", new Date(), true, KYC.FULL_DUE_DILIGENCE, "101dog101", "USA")), Duration.apply(defaultDelay));
        assertNotNull(customer);

        Await.result(cardRepository.create(new Card(null,"token2",customer.getId(), CardType.VIRTUAL, CardBrand.VISA, true, new Date(),"alias", true, "info", "USD", "adress1", "adress2", "adress3", "USA")), Duration.apply(defaultDelay));
        Await.result(cardRepository.create(new Card(null,"token3",customer.getId(), CardType.PLASTIC, CardBrand.MASTERCARD, true, new Date(),"alias", true, "info", "USD", "adress1", "adress2", "adress3", "USA")), Duration.apply(defaultDelay));

        final List<Card> result = Await.result(cardRepository.retrieveAll(), Duration.apply(defaultDelay));
        assertEquals(2,result.size());
    }

    @Test
    public void retrieveListByCardBrand() throws Exception {
        Customer customer = Await.result(customerRepository.create(new Customer("380953055621", new Date(), "Mr", "Vladimir", "Kuznetsov", "adress1", "adress2", "83004", "Donetsk", "nihilist.don@gmail.com", new Date(), true, KYC.FULL_DUE_DILIGENCE, "101dog101", "USA")), Duration.apply(defaultDelay));
        assertNotNull(customer);

        Await.result(cardRepository.create(new Card(null,"token2",customer.getId(), CardType.VIRTUAL, CardBrand.VISA, true, new Date(),"alias", true, "info", "USD", "adress1", "adress2", "adress3", "USA")), Duration.apply(defaultDelay));
        Await.result(cardRepository.create(new Card(null,"token3",customer.getId(), CardType.VIRTUAL, CardBrand.VISA, true, new Date(),"alias", true, "info", "USD", "adress1", "adress2", "adress3", "USA")), Duration.apply(defaultDelay));
        Await.result(cardRepository.create(new Card(null,"token4",customer.getId(), CardType.PLASTIC, CardBrand.MASTERCARD, true, new Date(),"alias", true, "info", "USD", "adress1", "adress2", "adress3", "USA")), Duration.apply(defaultDelay));

        final List<Card> result = Await.result(cardRepository.retrieveListByCardBrand(CardBrand.VISA), Duration.apply(defaultDelay));
        assertEquals(2,result.size());
    }

    @Test
    public void retrieveListByCardType() throws Exception {
        Customer customer = Await.result(customerRepository.create(new Customer("380953055621", new Date(), "Mr", "Vladimir", "Kuznetsov", "adress1", "adress2", "83004", "Donetsk", "nihilist.don@gmail.com", new Date(), true, KYC.FULL_DUE_DILIGENCE, "101dog101", "USA")), Duration.apply(defaultDelay));
        assertNotNull(customer);

        Await.result(cardRepository.create(new Card(null,"token2",customer.getId(), CardType.VIRTUAL, CardBrand.MASTERCARD, true, new Date(),"alias", true, "info", "USD", "adress1", "adress2", "adress3", "USA")), Duration.apply(defaultDelay));
        Await.result(cardRepository.create(new Card(null,"token3",customer.getId(), CardType.PLASTIC, CardBrand.VISA, true, new Date(),"alias", true, "info", "USD", "adress1", "adress2", "adress3", "USA")), Duration.apply(defaultDelay));
        Await.result(cardRepository.create(new Card(null,"token4",customer.getId(), CardType.PLASTIC, CardBrand.MASTERCARD, true, new Date(),"alias", true, "info", "USD", "adress1", "adress2", "adress3", "USA")), Duration.apply(defaultDelay));

        final List<Card> result = Await.result(cardRepository.retrieveListByCardType(CardType.PLASTIC), Duration.apply(defaultDelay));
        assertEquals(2,result.size());
    }

    @Test
    public void retrieveListByCustomerId() throws Exception {
        Customer customer = Await.result(customerRepository.create(new Customer("380953055621", new Date(), "Mr", "Vladimir", "Kuznetsov", "adress1", "adress2", "83004", "Donetsk", "nihilist.don@gmail.com", new Date(), true, KYC.FULL_DUE_DILIGENCE, "101dog101", "USA")), Duration.apply(defaultDelay));
        assertNotNull(customer);

        Customer customer2 = Await.result(customerRepository.create(new Customer("380953055622", new Date(), "Mr", "Vladimir", "Kuznetsov", "adress1", "adress2", "83004", "Donetsk", "nihilist.don@gmail.com", new Date(), true, KYC.FULL_DUE_DILIGENCE, "101dog101", "USA")), Duration.apply(defaultDelay));
        assertNotNull(customer);

        Await.result(cardRepository.create(new Card(null,"token2",customer.getId(), CardType.VIRTUAL, CardBrand.MASTERCARD, true, new Date(),"alias", true, "info", "USD", "adress1", "adress2", "adress3", "USA")), Duration.apply(defaultDelay));
        Await.result(cardRepository.create(new Card(null,"token3",customer.getId(), CardType.PLASTIC, CardBrand.VISA, true, new Date(),"alias", true, "info", "USD", "adress1", "adress2", "adress3", "USA")), Duration.apply(defaultDelay));
        Await.result(cardRepository.create(new Card(null,"token4",customer2.getId(), CardType.PLASTIC, CardBrand.MASTERCARD, true, new Date(),"alias", true, "info", "USD", "adress1", "adress2", "adress3", "USA")), Duration.apply(defaultDelay));

        final List<Card> result = Await.result(cardRepository.retrieveListByCustomerId(customer.getId()), Duration.apply(defaultDelay));
        assertEquals(2,result.size());
    }

    @Test
    public void countCardsByCardType() throws Exception {
        Customer customer = Await.result(customerRepository.create(new Customer("380953055621", new Date(), "Mr", "Vladimir", "Kuznetsov", "adress1", "adress2", "83004", "Donetsk", "nihilist.don@gmail.com", new Date(), true, KYC.FULL_DUE_DILIGENCE, "101dog101", "USA")), Duration.apply(defaultDelay));
        assertNotNull(customer);

        Customer customer2 = Await.result(customerRepository.create(new Customer("380953055622", new Date(), "Mr", "Vladimir", "Kuznetsov", "adress1", "adress2", "83004", "Donetsk", "nihilist.don@gmail.com", new Date(), true, KYC.FULL_DUE_DILIGENCE, "101dog101", "USA")), Duration.apply(defaultDelay));
        assertNotNull(customer);

        Await.result(cardRepository.create(new Card(null,"token2",customer.getId(), CardType.VIRTUAL, CardBrand.MASTERCARD, true, new Date(),"alias", true, "info", "USD", "adress1", "adress2", "adress3", "USA")), Duration.apply(defaultDelay));
        Await.result(cardRepository.create(new Card(null,"token3",customer.getId(), CardType.PLASTIC, CardBrand.VISA, true, new Date(),"alias", true, "info", "USD", "adress1", "adress2", "adress3", "USA")), Duration.apply(defaultDelay));
        Await.result(cardRepository.create(new Card(null,"token3",customer.getId(), CardType.PLASTIC, CardBrand.VISA, true, new Date(),"alias", true, "info", "USD", "adress1", "adress2", "adress3", "USA")), Duration.apply(defaultDelay));
        Await.result(cardRepository.create(new Card(null,"token4",customer2.getId(), CardType.PLASTIC, CardBrand.MASTERCARD, true, new Date(),"alias", true, "info", "USD", "adress1", "adress2", "adress3", "USA")), Duration.apply(defaultDelay));

        long result = Await.result(cardRepository.countCardsByType(customer.getId(), CardType.PLASTIC), Duration.apply(defaultDelay));
        assertEquals(2, result);
        result = Await.result(cardRepository.countCardsByType(customer.getId(), CardType.VIRTUAL), Duration.apply(defaultDelay));
        assertEquals(1, result);
        result = Await.result(cardRepository.countCardsByType(customer2.getId(), CardType.PLASTIC), Duration.apply(defaultDelay));
        assertEquals(1, result);

    }

    @After
    public void clean() {
        final Promise<Card> promise = Futures.promise();
        connectionPool.getConnection().query("delete from " + connectionPool.getSchemaName() + ".card;delete from "+ connectionPool.getSchemaName() + ".customer;", resultSet -> promise.success(null), promise::failure);
        try {
            Await.result(promise.future(), Duration.apply(defaultDelay));
        } catch (Exception e) {
            Logger.error("Error", e);
        }

    }

}
