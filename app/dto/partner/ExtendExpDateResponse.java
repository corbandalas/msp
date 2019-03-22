package dto.partner;

import ae.globalprocessing.hyperionweb.BalanceEnquire2;
import ae.globalprocessing.hyperionweb.ExtendExpiry;
import dto.BaseAPIResponse;

/**
 * Extend exp date response DTO object
 *
 * @author corbandalas created 20.03.2019.
 * @since 0.6.0
 */

public class ExtendExpDateResponse extends BaseAPIResponse {

    private ExtendExpiry extendExpiry;

    public ExtendExpDateResponse(String text, String code, ExtendExpiry extendExpiry) {
        super(text, code);
        this.extendExpiry = extendExpiry;
    }

    public ExtendExpiry getExtendExpiry() {
        return extendExpiry;
    }

    public void setExtendExpiry(ExtendExpiry extendExpiry) {
        this.extendExpiry = extendExpiry;
    }
}
