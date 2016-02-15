package repository;

import akka.dispatch.Futures;
import model.Account;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import play.Logger;
import repository.AccountRepository;
import scala.concurrent.Await;
import scala.concurrent.Promise;
import scala.concurrent.duration.Duration;

import java.util.Date;
import java.util.List;

import static junit.framework.TestCase.assertNotNull;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

/**
 * Holds account repository tests
 *
 * @author ra created 08.02.2016.
 * @since 0.1.0
 */
public class AccountRepositoryTest extends BaseRepositoryTest {

    private AccountRepository accountRepository;

    @Before
    public void setup() {
        accountRepository = application.injector().instanceOf(AccountRepository.class);
    }

    @Test
    public void create() throws Exception {
        Integer id = 1;
        final String name = "Test account";

        assertNotNull(Await.result(accountRepository.create(new Account(id, name, "USD", new Date(), true, "1234567")), Duration.apply(defaultDelay)));

        final Account account = Await.result(accountRepository.retrieveById(id), Duration.apply(defaultDelay));
        assertEquals(name, account.getName());
    }

    @Test
    public void update() throws Exception {
        Integer id = 1;
        final Account account = new Account(id, "Test account", "USD", new Date(), true, "1234567");

        assertNotNull(Await.result(accountRepository.create(account), Duration.apply(defaultDelay)));

        account.setActive(false);
        assertNotNull(Await.result(accountRepository.update(account), Duration.apply(defaultDelay)));
        final Account accountUpdated = Await.result(accountRepository.retrieveById(id), Duration.apply(defaultDelay));
        assertEquals(false, accountUpdated.getActive());
    }

    @Test
    public void retrieveById() throws Exception {
        Integer id = 1;
        final String name = "My test account";

        assertNotNull(Await.result(accountRepository.create(new Account(id, name, "USD", new Date(), true, "1234567")), Duration.apply(defaultDelay)));
        final Account account = Await.result(accountRepository.retrieveById(id), Duration.apply(defaultDelay));
        assertEquals(name, account.getName());
    }

    @Test
    public void retrieveAll() throws Exception {
        assertNotNull(Await.result(accountRepository.create(new Account(1, "Test account 1", "USD", new Date(), true, "1234567")), Duration.apply(defaultDelay)));
        assertNotNull(Await.result(accountRepository.create(new Account(2, "Test account 2", "USD", new Date(), true, "1234567")), Duration.apply(defaultDelay)));

        final List<Account> result = Await.result(accountRepository.retrieveAll(), Duration.apply(defaultDelay));
        assertEquals(2,result.size());
    }

    @After
    public void clean() {
        final Promise<Account> promise = Futures.promise();
        connectionPool.getConnection().query("delete from " + connectionPool.getSchemaName() + ".account", resultSet -> promise.success(null), promise::failure);
        try {
            Await.result(promise.future(), Duration.apply(defaultDelay));
        } catch (Exception e) {
            Logger.error("Error", e);
        }
    }
}
