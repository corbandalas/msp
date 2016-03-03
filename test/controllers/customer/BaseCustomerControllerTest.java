package controllers.customer;

import akka.actor.ActorSystem;
import akka.dispatch.Futures;
import controllers.BaseControllerTest;
import model.Card;
import model.Currency;
import model.Customer;
import model.enums.CardBrand;
import model.enums.CardType;
import model.enums.KYC;
import module.PropertyLoader;
import org.junit.After;
import org.junit.Before;
import play.Logger;
import provider.GlobalProcessingCardProvider;
import provider.dto.CardCreationResponse;
import repository.*;
import scala.concurrent.Await;
import scala.concurrent.Promise;
import scala.concurrent.duration.Duration;

import java.util.Date;
import java.util.Optional;

import static java.util.Arrays.asList;

/**
 * Base customer controller test
 *
 * @author corbandalas created 01.03.2016.
 * @since 0.2.0
 */
public class BaseCustomerControllerTest extends BaseControllerTest {

    public static final long TIMEOUT = 20000;

    public static final String PHONE_1 = "4921142172244";
    public static final String PHONE_2 = "4921142172243";

    public static final String PASSWORD_1 = "4921142172244";
    public static final String PASSWORD_2 = "4921142172243";

    @Before
    public void init() {

        super.init();

        try {
            insertCustomersAndCards();

            PropertyLoader propertyLoader = app.injector().instanceOf(PropertyLoader.class);
            propertyLoader.load("conf/properties.json", app.injector().instanceOf(ActorSystem.class).dispatcher());
        } catch (Exception e) {
            Logger.error("Test error", e);
        }
    }

    @After
    public void delete() throws Exception {

        super.delete();

        final ConnectionPool connectionPool = app.injector().instanceOf(ConnectionPool.class);

        final Promise<Object> promise2 = Futures.promise();
        connectionPool.getConnection().query("delete from " + connectionPool.getSchemaName()  + ".card;", null,
                promise2::success, promise2::failure);
        Await.result(promise2.future(), Duration.apply(TIMEOUT, "ms"));

        final Promise<Object> promise = Futures.promise();
        connectionPool.getConnection().query("delete from " + connectionPool.getSchemaName() + ".customer where id=$1 OR id=$2", asList(PHONE_1, PHONE_2),
                promise::success, promise::failure);
        Await.result(promise.future(), Duration.apply(TIMEOUT, "ms"));

        connectionPool.close();


    }


    private void insertCustomersAndCards() throws Exception {

        final CustomerRepository customerRepository = app.injector().instanceOf(CustomerRepository.class);

        final CardRepository cardRepository = app.injector().instanceOf(CardRepository.class);

        final CurrencyRepository currencyRepository = app.injector().instanceOf(CurrencyRepository.class);

        final Customer customer1 = createCustomer(PHONE_1, PASSWORD_1, "mr_ivanoff@gmail.com", "Ivan", "Ivanoff");

        final Customer customer2 = createCustomer(PHONE_2, PASSWORD_2, "mr_petroff@gmail.com", "Petr", "Petroff");

        Await.result(customerRepository.create(customer1), Duration.apply(TIMEOUT, "ms"));

        Await.result(customerRepository.create(customer2), Duration.apply(TIMEOUT, "ms"));

        GlobalProcessingCardProvider globalProcessingCardProvider = app.injector().instanceOf(GlobalProcessingCardProvider.class);


        Optional<Currency> currency = Await.result(currencyRepository.retrieveById("EUR"), Duration.apply(TIMEOUT, "ms"));

        CardCreationResponse cardCreationResponse1 = globalProcessingCardProvider.issuePrepaidVirtualCard(customer1, "Test card", 1000L, currency.get()).get(TIMEOUT);
        CardCreationResponse cardCreationResponse2 = globalProcessingCardProvider.issuePrepaidVirtualCard(customer1, "Test card", 1000L, currency.get()).get(TIMEOUT);
        CardCreationResponse cardCreationResponse3 = globalProcessingCardProvider.issuePrepaidVirtualCard(customer2, "Test card", 1000L, currency.get()).get(TIMEOUT);
        CardCreationResponse cardCreationResponse4 = globalProcessingCardProvider.issuePrepaidVirtualCard(customer2, "Test card", 1000L, currency.get()).get(TIMEOUT);

        Await.result(cardRepository.create(createCard(PHONE_1, cardCreationResponse1.getToken(), true)), Duration.apply(TIMEOUT, "ms"));

        Await.result(cardRepository.create(createCard(PHONE_1, cardCreationResponse2.getToken(), false)), Duration.apply(TIMEOUT, "ms"));

        Await.result(cardRepository.create(createCard(PHONE_2, cardCreationResponse3.getToken(), true)), Duration.apply(TIMEOUT, "ms"));

        Await.result(cardRepository.create(createCard(PHONE_2, cardCreationResponse4.getToken(), false)), Duration.apply(TIMEOUT, "ms"));

    }

    private model.Customer createCustomer(String phone, String password, String email, String firstName, String lastName) {
        return new model.Customer(phone, new Date(), "Mr", firstName, lastName,
                "adress1", "adress2", "83004", "Berlin", email, new Date(), true, KYC.FULL_DUE_DILIGENCE, password, "DE");
    }

    private Card createCard(String customerPhone, String token, boolean cardDefault) {
        return new Card(null, token, customerPhone, CardType.VIRTUAL, CardBrand.VISA, cardDefault, new Date(), "alias", true, "info", "EUR", "adress1", "adress2", "adress3", "DE");
    }

}
