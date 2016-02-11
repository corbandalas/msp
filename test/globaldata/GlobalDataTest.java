package globaldata;

import com.microsoft.schemas._2003._10.serialization.arrays.ArrayOfKeyValueOfstringstring;
import org.datacontract.schemas._2004._07.neuromancerlibrary.*;
import org.junit.Test;
import org.tempuri.IService;
import org.tempuri.Service;

import javax.xml.bind.JAXBElement;
import javax.xml.namespace.QName;

/**
 * @author ra created 10.02.2016.
 * @since 0.1.0
 */
public class GlobalDataTest {

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

        queryData.setNameQuery(new JAXBElement<>(new QName("d4p1"),String.class,"Ra"));
        queryData.setNameQueryMatchThreshold(new JAXBElement<>(new QName("d4p1"),Integer.class,0));

        serviceRequest.setQueryData(new JAXBElement<>(new QName("d4p1"), QueryData.class, queryData));

        ServiceAuthorisation serviceAuthorisation = new ServiceAuthorisation();
        serviceAuthorisation.setAPIKey(new JAXBElement<>(new QName("d4p1"),String.class,"123456"));

        serviceRequest.setServiceAuthorisation(new JAXBElement<>(new QName("d4p1"), ServiceAuthorisation.class, serviceAuthorisation));

        final ServiceResponse serviceResponse = servicePort.kycCheck(serviceRequest);

        System.out.print(serviceResponse.getProcessRequestResult().getValue());

    }
}
