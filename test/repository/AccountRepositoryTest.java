package repository;

import model.Account;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import repository.AccountRepository;
import scala.concurrent.Await;
import scala.concurrent.duration.Duration;

import java.util.Date;
import java.util.List;

import static junit.framework.TestCase.assertNotNull;
import static org.junit.Assert.assertEquals;

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

        assertNotNull(Await.result(accountRepository.create(new Account(id, name, "USD", new Date(), true, "1234567")), Duration.apply("1000 ms")));

        final Account account = Await.result(accountRepository.retrieveById(id), Duration.apply("1000 ms"));
        assertEquals(name, account.getName());
    }

    @Test
    public void update() throws Exception {
        Integer id = 1;
        final Account account = new Account(id, "Test account", "USD", new Date(), true, "1234567");

        assertNotNull(Await.result(accountRepository.create(account), Duration.apply("1000 ms")));

        account.setActive(false);
        assertNotNull(Await.result(accountRepository.update(account), Duration.apply("1000 ms")));
        final Account accountUpdated = Await.result(accountRepository.retrieveById(id), Duration.apply("1000 ms"));
        assertEquals(false, accountUpdated.getActive());
    }

    @Test
    public void retrieveById() throws Exception {
        Integer id = 1;
        final String name = "My test account";

        assertNotNull(Await.result(accountRepository.create(new Account(id, name, "USD", new Date(), true, "1234567")), Duration.apply("1000 ms")));
        final Account account = Await.result(accountRepository.retrieveById(id), Duration.apply("1000 ms"));
        assertEquals(name, account.getName());
    }

    @Test
    public void retrieveAll() throws Exception {
        assertNotNull(Await.result(accountRepository.create(new Account(1, "Test account 1", "USD", new Date(), true, "1234567")), Duration.apply("1000 ms")));
        assertNotNull(Await.result(accountRepository.create(new Account(2, "Test account 2", "USD", new Date(), true, "1234567")), Duration.apply("1000 ms")));

        final List<Account> result = Await.result(accountRepository.retrieveAll(), Duration.apply("1000 ms"));
        assertEquals(2,result.size());
    }

    @After
    public void clean() {
        connectionPool.getConnection().query("delete from " + connectionPool.getSchemaName() + ".account", resultSet -> {
        }, throwable -> {throwable.printStackTrace();});
    }
}
