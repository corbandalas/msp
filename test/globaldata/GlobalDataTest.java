package globaldata;

import junit.framework.Assert;
import module.PropertyLoader;
import org.datacontract.schemas._2004._07.NeuromancerLibrary_DataContracts.ServiceResponse;
import org.junit.Before;
import org.junit.Test;
import play.Logger;
import repository.BaseRepositoryTest;
import services.W2GlobaldataService;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

/**
 * @author kv created 30.06.2016.
 * @since 0.1.0
 */
public class GlobalDataTest extends BaseRepositoryTest {

    private W2GlobaldataService w2GlobaldataService;

    @Before
    public void setup() {
        w2GlobaldataService = application.injector().instanceOf(W2GlobaldataService.class);
        PropertyLoader propertyLoader = application.injector().instanceOf(PropertyLoader.class);
        propertyLoader.load(("conf/properties.json"), dispatcher);
    }

    @Test
    public void testUKSuccessSDD() throws Exception {
        try {
            Thread.currentThread().sleep(1000);
            String dt = "1966-10-09";  // Start date
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Calendar c = Calendar.getInstance();
            c.setTime(sdf.parse(dt));
            ServiceResponse serviceResponse = w2GlobaldataService.kycCheckUK("David Cameron", "David", null, "Cameron", c.getTime(), "5", "BS8 1HN", null, null, null, null, null, "KYC_UK_SafePay_SDD").get(10000000L);
            Assert.assertEquals(serviceResponse.getProcessRequestResult().getTransactionInformation().getInterpretResult().getValue(), "Pass");
        } catch (Exception e) {
            Logger.error("Error testUKSuccess", e);
            fail();
        }
    }

    @Test
    public void testUKFailSDD() throws Exception {
        try {
            Thread.currentThread().sleep(1000);
            String dt = "1944-12-31";  // Start date
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Calendar c = Calendar.getInstance();
            c.setTime(sdf.parse(dt));
            ServiceResponse serviceResponse = w2GlobaldataService.kycCheckUK("Billy Jones", "Billy", null, "Jones", c.getTime(), "68", "RH13 3HE", null, null, null, null, null, "KYC_UK_SafePay_SDD").get(10000000L);
            Assert.assertEquals(serviceResponse.getProcessRequestResult().getTransactionInformation().getInterpretResult().getValue(), "Fail");

        } catch (Exception e) {
            Logger.error("Error testUKFail", e);
            fail();
        }
    }

}
