package globaldata;

import com.microsoft.schemas._2003._10.serialization.arrays.ArrayOfKeyValueOfstringstring;
import module.PropertyLoader;
import org.datacontract.schemas._2004._07.neuromancerlibrary.*;
import org.tempuri.IService;
import org.tempuri.Service;
import play.Logger;
import repository.BaseRepositoryTest;
import services.W2GlobaldataService;

import javax.xml.bind.JAXBElement;
import javax.xml.namespace.QName;
import java.util.Date;

import static org.junit.Assert.fail;

/**
 * @author ra created 10.02.2016.
 * @since 0.1.0
 */
public class GlobalDataTest extends BaseRepositoryTest {

    private W2GlobaldataService w2GlobaldataService;

    //@Before
    public void setup() {
        w2GlobaldataService = application.injector().instanceOf(W2GlobaldataService.class);
        PropertyLoader propertyLoader = application.injector().instanceOf(PropertyLoader.class);
        propertyLoader.load(("conf/properties.json"), dispatcher);
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

    //@Test
    public void standardInternationalSanctionsService() throws Exception {
        try {
            w2GlobaldataService.standardInternationalSanctionsService("Robert Mugabe", new Date()).get(10000000L);
        } catch (Exception e) {
            Logger.error("Error standardInternationalSanctionsService", e);
            fail();
        }
    }

    //@Test
    public void eKYC_UKService() throws Exception {
        try {
            Thread.currentThread().sleep(1000);
            w2GlobaldataService.eKYC_UKService("Moray", "Abdiou", new Date(), "68", null, null, null, "LN4 7AT").get(10000000L);
        } catch (Exception e) {
            Logger.error("Error eKYC_UKService", e);
            fail();
        }
    }

    //@Test
    public void seniorPoliticalFiguresService() throws Exception {
        try {
            w2GlobaldataService.seniorPoliticalFiguresService("David Cameron", new Date()).get(10000000L);
        } catch (Exception e) {
            Logger.error("Error seniorPoliticalFiguresService", e);
            fail();
        }
    }

    //@Test
    public void internationalAddressLookupService() throws Exception {
        try {
            w2GlobaldataService.internationalAddressLookupService("68", "RH13 3HE", null, null, null).get(10000000L);
        } catch (Exception e) {
            Logger.error("Error W2DataAddressLookup007Service", e);
            fail();
        }
    }

    //@Test
    public void manualValidationService() throws Exception {
        try {
            w2GlobaldataService.manualValidationService("Louie", "Ellis", "92", "PE12 0WS", new Date(), "GBR", null, null).get(10000000L);
        } catch (Exception e) {
            Logger.error("Error manualValidationService", e);
            fail();
        }
    }

   //@Test
    public void uploadDocument() throws Exception {
        try {
            w2GlobaldataService.uploadDocument("Document data", "reference", "JPEG", new Date()).get(10000000L);
        } catch (Exception e) {
            Logger.error("Error uploadDocument", e);
            fail();
        }
    }

}
