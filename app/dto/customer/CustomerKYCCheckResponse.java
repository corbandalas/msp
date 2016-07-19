package dto.customer;

import dto.BaseAPIResponse;
import org.datacontract.schemas._2004._07.NeuromancerLibrary_Resources.ServiceResult;
import org.datacontract.schemas._2004._07.NeuromancerLibrary_Resources.ServiceTransactionInformation;

import java.util.List;

/**
 * Customer KYC verification response
 *
 * @author kv created 30.06.2016.
 * @since 0.3.0
 */
public class CustomerKYCCheckResponse extends BaseAPIResponse {

    private String result;
    private List<KYCServiceResult> kycServiceResults;

    public CustomerKYCCheckResponse(String text, String code, String result, List<KYCServiceResult> kycServiceResults) {
        super(text, code);
        this.result = result;
        this.kycServiceResults = kycServiceResults;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public List<KYCServiceResult> getKycServiceResults() {
        return kycServiceResults;
    }

    public void setKycServiceResults(List<KYCServiceResult> kycServiceResults) {
        this.kycServiceResults = kycServiceResults;
    }
}
