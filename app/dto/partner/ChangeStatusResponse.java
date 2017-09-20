package dto.partner;

import dto.BaseAPIResponse;
import provider.dto.CardStatusChangeResponseResponse;

/**
 * Card Balance response DTO object
 *
 * @author corbandalas created 20.09.2017.
 * @since 0.6.0
 */

public class ChangeStatusResponse extends BaseAPIResponse {

    private CardStatusChangeResponseResponse statusChangeResponseResponse;

    public ChangeStatusResponse(String text, String code, CardStatusChangeResponseResponse statusChangeResponseResponse) {
        super(text, code);
        this.statusChangeResponseResponse = statusChangeResponseResponse;
    }

    public CardStatusChangeResponseResponse getStatusChangeResponseResponse() {
        return statusChangeResponseResponse;
    }

    public void setStatusChangeResponseResponse(CardStatusChangeResponseResponse statusChangeResponseResponse) {
        this.statusChangeResponseResponse = statusChangeResponseResponse;
    }
}
