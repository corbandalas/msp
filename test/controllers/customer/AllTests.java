package controllers.customer;

import junit.framework.JUnit4TestAdapter;
import junit.framework.Test;
import junit.framework.TestSuite;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;


@RunWith(Suite.class)
@SuiteClasses(
        {
                CustomerCardBalanceControllerTest.class,
                CustomerCardListControllerTest.class,
                CustomerCardManagementControllerTest.class,
                CustomerLoginControllerTest.class,
                CustomerPasswordControllerTest.class,
                CustomerProfileControllerTest.class,
                CustomerRegisterControllerTest.class,
                CustomerTransactionControllerTest.class,
                CustomerTransferControllerTest.class,
                CustomerKycControllerTest.class
        }
)
public class AllTests extends TestSuite {
    public static Test suite() {
        return new JUnit4TestAdapter(AllTests.class);
    }
}
