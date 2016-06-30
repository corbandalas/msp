package dto.customer;

import dto.BaseAPIResponse;
import org.datacontract.schemas._2004._07.NeuromancerLibrary_Resources.ServiceTransactionInformation;

/**
 * Request object for change pin
 *
 * @author kv created 30.06.2016.
 * @since 0.2.0
 */
public class KYCServiceResult {
    String serviceName;
    String serviceResult;
    String serviceResultMessage;

    public KYCServiceResult(String serviceName, String serviceResult, String serviceResultMessage) {
        this.serviceName = serviceName;
        this.serviceResult = serviceResult;
        this.serviceResultMessage = serviceResultMessage;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getServiceResult() {
        return serviceResult;
    }

    public void setServiceResult(String serviceResult) {
        this.serviceResult = serviceResult;
    }

    public String getServiceResultMessage() {
        return serviceResultMessage;
    }

    public void setServiceResultMessage(String serviceResultMessage) {
        this.serviceResultMessage = serviceResultMessage;
    }
}
