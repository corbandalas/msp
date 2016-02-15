package controllers;

import controllers.admin.*;
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
                ExchangeRateHistoryControllerTest.class,
                CustomerControllerTest.class,
                CurrencyControllerTest.class,
                CountryControllerTest.class,
                AccountControllerTest.class,
                PropertyControllerTest.class,
                TransactionControllerTest.class,
                CardControllerTest.class,
                OperationControllerTest.class
        }
)
public class AllTests extends TestSuite {
    public static Test suite() {
        return new JUnit4TestAdapter(AllTests.class);
    }
}
