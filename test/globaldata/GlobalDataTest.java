package globaldata;

import com.microsoft.schemas._2003._10.serialization.arrays.ArrayOfKeyValueOfstringstring;
import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;
import module.PropertyLoader;
import org.datacontract.schemas._2004._07.neuromancerlibrary.*;
import org.junit.Before;
import org.junit.Test;
import org.tempuri.IService;
import org.tempuri.Service;
import play.Logger;
import play.libs.F;
import provider.GlobalProcessingCardProvider;
import repository.BaseRepositoryTest;
import repository.CurrencyRepository;
import repository.PropertyRepository;
import scala.concurrent.Await;
import scala.concurrent.duration.Duration;
import w2globaldata.W2GlobaldataClient;

import javax.xml.bind.JAXBElement;
import javax.xml.namespace.QName;

import java.util.Date;

import static org.junit.Assert.fail;

/**
 * @author ra created 10.02.2016.
 * @since 0.1.0
 */
public class GlobalDataTest extends BaseRepositoryTest {

    private W2GlobaldataClient w2GlobaldataClient;

   //@Before
    public void setup() {
        Config conf = ConfigFactory.load();
        w2GlobaldataClient = application.injector().instanceOf(W2GlobaldataClient.class);
        PropertyLoader propertyLoader = application.injector().instanceOf(PropertyLoader.class);
        propertyLoader.load(conf.getString("project.path") + "/conf/properties.json", dispatcher);
    }


    //    @Test
    public void kycCheck() throws Exception {
        final Service service = new Service();
        final IService servicePort = service.getPort(IService.class);

        ServiceRequest serviceRequest = new ServiceRequest();

        final BundleData bundleData = new BundleData();
        serviceRequest.setBundleData(new JAXBElement<>(new QName("d4p1"), BundleData.class, bundleData));

        final ArrayOfKeyValueOfstringstring queryOptions = new ArrayOfKeyValueOfstringstring();
        final ArrayOfKeyValueOfstringstring.KeyValueOfstringstring queryOption = new ArrayOfKeyValueOfstringstring.KeyValueOfstringstring();

        queryOption.setKey("Sandbox");
        queryOption.setValue("true");

        queryOptions.getKeyValueOfstringstring().add(queryOption);
        serviceRequest.setQueryOptions(new JAXBElement<>(new QName("d4p1"), ArrayOfKeyValueOfstringstring.class, queryOptions));

        QueryData queryData = new QueryData();

        queryData.setNameQuery(new JAXBElement<>(new QName("d4p1"), String.class, "Ra"));
        queryData.setNameQueryMatchThreshold(new JAXBElement<>(new QName("d4p1"), Integer.class, 0));

        serviceRequest.setQueryData(new JAXBElement<>(new QName("d4p1"), QueryData.class, queryData));

        ServiceAuthorisation serviceAuthorisation = new ServiceAuthorisation();
        serviceAuthorisation.setAPIKey(new JAXBElement<>(new QName("d4p1"), String.class, "123456"));

        serviceRequest.setServiceAuthorisation(new JAXBElement<>(new QName("d4p1"), ServiceAuthorisation.class, serviceAuthorisation));

        final ServiceResponse serviceResponse = servicePort.kycCheck(serviceRequest);

        System.out.print(serviceResponse.getProcessRequestResult().getValue());

    }

   // @Test
    public void SISPlusService() throws Exception {
        try {
            w2GlobaldataClient.SISPlusService("Robert Mugabe", null, null, null, null, null, true).get(10000000L);
        } catch (Exception e) {
            Logger.error("Error SISPlusService", e);
            fail();
        }
    }

    //@Test
    public void W2DataEkycUk007Service() throws Exception {
        try {
            w2GlobaldataClient.W2DataEkycUk007Service("Moray", null, "Abdiou", 11, 12, 1924, "68", null, null, null, null, null, "LN4 7AT", true).get(10000000L);
        } catch (Exception e) {
            Logger.error("Error W2DataEkycUk007Service", e);
            fail();
        }
    }

    //@Test
    public void SPFPlusService() throws Exception {
        try {
            w2GlobaldataClient.SPFPlusService("David Cameron", null, null, null, null, null, true).get(10000000L);
        } catch (Exception e) {
            Logger.error("Error SPFPlusService", e);
            fail();
        }
    }

    //@Test
    public void W2DataAddressLookup007Service() throws Exception {
        try {
            w2GlobaldataClient.W2DataAddressLookup007Service("68", "RH13 3HE", null, null, null, null, true).get(10000000L);
        } catch (Exception e) {
            Logger.error("Error W2DataAddressLookup007Service", e);
            fail();
        }
    }

    //@Test
    public void W2DATAIDVCHECKService() throws Exception {
        try {
            w2GlobaldataClient.W2DATAIDVCHECKService("Louie", "Ellis", "92", "PE12 0WS", 19, 2, 1944, "GBR", null, null, null, null, null, null, true).get(10000000L);
        } catch (Exception e) {
            Logger.error("Error W2DataAddressLookup007Service", e);
            fail();
        }
    }

   //@Test
    public void uploadDocument() throws Exception {
        try {
            w2GlobaldataClient.uploadDocument("Document data", "reference", "JPEG", new Date(), true).get(10000000L);
        } catch (Exception e) {
            Logger.error("Error uploadDocument", e);
            fail();
        }
    }

}
