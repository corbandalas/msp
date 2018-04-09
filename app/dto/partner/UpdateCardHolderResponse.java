package dto.partner;

import ae.globalprocessing.hyperionweb.CustomerUpdate;
import dto.BaseAPIResponse;
import provider.dto.CardUnloadResponse;

/**
 * Update Card holder response DTO object
 *
 * @author corbandalas created 09.04.2018.
 * @since 0.6.0
 */
public class UpdateCardHolderResponse extends BaseAPIResponse {

    private CustomerUpdate customerUpdate;

    public UpdateCardHolderResponse(String text, String code, CustomerUpdate customerUpdate) {
        super(text, code);
        this.customerUpdate = customerUpdate;
    }

    public CustomerUpdate getCustomerUpdate() {
        return customerUpdate;
    }

    public void setCustomerUpdate(CustomerUpdate customerUpdate) {
        this.customerUpdate = customerUpdate;
    }
}
