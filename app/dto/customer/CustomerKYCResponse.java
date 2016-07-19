package dto.customer;

import dto.BaseAPIResponse;


/**
 * Customer KYC response
 *
 * @author corbandalas created 19.07.2016.
 * @since 0.3.0
 */
public class CustomerKYCResponse extends BaseAPIResponse {

    private String kyc;

    public CustomerKYCResponse() {
        super("", "");
    }

    public CustomerKYCResponse(String text, String code, String kyc) {
        super(text, code);
        this.kyc = kyc;
    }

    public String getKyc() {
        return kyc;
    }

    public void setKyc(String kyc) {
        this.kyc = kyc;
    }
}
