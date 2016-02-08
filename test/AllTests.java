import junit.framework.JUnit4TestAdapter;
import junit.framework.Test;
import junit.framework.TestSuite;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
import repository.*;


@RunWith(Suite.class)
@SuiteClasses(
        {
                CurrencyRepositoryTest.class,
                AccountRepositoryTest.class,
                CountryRepositoryTest.class,
                CardRepositoryTest.class,
                CustomerRepositoryTest.class,
                OperationRepositoryTest.class,
                TransactionRepositoryTest.class
        }
)
public class AllTests extends TestSuite {
    public static Test suite() {
        return new JUnit4TestAdapter(AllTests.class);
    }
}
