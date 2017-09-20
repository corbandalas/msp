package dto.partner;

import dto.BaseAPIResponse;
import provider.dto.CardStatusChangeResponseResponse;
import provider.dto.PlasticCardActivateResponse;

/**
 * Activate card response DTO object
 *
 * @author corbandalas created 20.09.2017.
 * @since 0.6.0
 */

public class ActivateCardResponse extends BaseAPIResponse {

    private PlasticCardActivateResponse plasticCardActivateResponse;

    public ActivateCardResponse(String text, String code, PlasticCardActivateResponse plasticCardActivateResponse) {
        super(text, code);
        this.plasticCardActivateResponse = plasticCardActivateResponse;
    }

    public PlasticCardActivateResponse getPlasticCardActivateResponse() {
        return plasticCardActivateResponse;
    }

    public void setPlasticCardActivateResponse(PlasticCardActivateResponse plasticCardActivateResponse) {
        this.plasticCardActivateResponse = plasticCardActivateResponse;
    }
}
